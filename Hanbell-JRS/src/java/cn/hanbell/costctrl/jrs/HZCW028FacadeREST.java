/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.CheckData;
import cn.hanbell.costctrl.app.MCHZCW028;
import cn.hanbell.costctrl.app.MCHZCW028reDetail;
import cn.hanbell.costctrl.app.MCHZCW028tDetail;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.crm.ejb.PORMYBean;
import cn.hanbell.crm.ejb.PORMZBean;
import cn.hanbell.crm.ejb.REPLCBean;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.SALFIBean;
import cn.hanbell.crm.ejb.SALFTBean;
import cn.hanbell.crm.entity.PORMY;
import cn.hanbell.crm.entity.PORMYPK;
import cn.hanbell.crm.entity.PORMZ;
import cn.hanbell.crm.entity.PORMZPK;
import cn.hanbell.crm.entity.REPLC;
import cn.hanbell.crm.entity.REPLCPK;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.crm.entity.SALFI;
import cn.hanbell.crm.entity.SALFT;
import cn.hanbell.crm.entity.SALFTPK;
import cn.hanbell.eap.comm.ErrorMailNotify;
import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.eap.ejb.CrmUserGroupBean;
import cn.hanbell.eap.ejb.ErrorMailNotificationBean;
import cn.hanbell.eap.ejb.McbudgetBean;
import cn.hanbell.eap.entity.Mcbudget;
import cn.hanbell.erp.ejb.BudgetCenterBean;
import cn.hanbell.erp.ejb.BudgetDetailBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.MisrateBean;
import cn.hanbell.erp.entity.BudgetCenter;
import cn.hanbell.erp.entity.Misrate;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.ejb.HZCW028Bean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.entity.HZCW028;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HZCW028Model;
import cn.hanbell.oa.model.HZCW028reDetailModel;
import cn.hanbell.oa.model.HZCW028tDetailModel;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("costctrl/hzcw028")
@javax.enterprise.context.RequestScoped
public class HZCW028FacadeREST extends SuperRESTForEFGP<HZCW028> {

    @EJB
    private HZCW028Bean hzcw028Bean;
    @EJB
    private HZCW017Bean hzcw017Bean;
    @EJB
    private CompanyBean comanyBean;
    @EJB
    private UsersBean usersBean;
    @EJB
    private WorkFlowBean workFlowBean;
    @EJB
    private McbudgetBean mcbudgetBean;
    @EJB
    private CrmUserGroupBean crmUserGroupBean;
    @EJB
    private ErrorMailNotificationBean mailBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private MisrateBean misrateBean;
    @EJB
    private BudgetCenterBean budgetCenterBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;
    @EJB
    private REPTCBean reptcBean;
    @EJB
    private REPLCBean replcBean;
    @EJB
    private SALFIBean salfiBean;
    @EJB
    private SALFTBean salftBean;
    @EJB
    private PORMYBean pormyBean;
    @EJB
    private PORMZBean pormzBean;
    @Resource
    private UserTransaction tran;

    public HZCW028FacadeREST() {
        super(HZCW028.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hzcw028Bean;
    }

    @POST
    @Path("check")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData CheckMCHZCW028(MCHZCW028 entity) {
        log4j.info(entity.getSrcno() + "每刻发起报销单检查：" + entity.toString());
        MCResponseData rs = new MCResponseData();
        rs = checkBeforeSend(0, entity);
        return rs;
    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData CreateOAHZCWO28(MCHZCW028 entity) {
        log4j.info(entity.getSrcno() + "每刻发起报销单检查：" + entity.toString());
        try {
            MCResponseData rs = new MCResponseData();
            rs = checkBeforeSend(1, entity);
            if (rs.getCode() != 200) {
                return rs;
            }
            //检查申请人是否重复借款(发起时检核)
//            if (!hzcw017Bean.checkArrears(entity.getAppUser())) {
//                return new MCResponseData(109, "您有借款未还不能再发起借支申请");
//            }
            tran.begin();
            //初始化CRM资料
            if (entity.getCrmno() != null && !entity.getCrmno().isEmpty()) {
                boolean isIniCRM = initialCRMWorkDetail(entity);
                if (isIniCRM == false) {
                    return new MCResponseData(MessageEnum.Failue_109.getCode(), "初始化CRM数据失败");
                }
            }
            //更新费控中间表状态为1 已完成
            List<Mcbudget> mcbudgets = mcbudgetBean.findBySrcno(entity.getSrcno());
            for (Mcbudget mcb : mcbudgets) {
                mcb.setStatus(1);
                mcbudgetBean.update(mcb);
            }
            //实例化对象
            HZCW028Model m = new HZCW028Model();
            List<MCHZCW028reDetail> reds = entity.getItems();
            List<HZCW028reDetailModel> rems = new ArrayList<>();
            Date date = BaseLib.getDate("yyyy/MM/dd", entity.getAppDate());
            String facno = entity.getFacno();
            budgetDetailBean.setCompany(facno);
            budgetCenterBean.setCompany(facno);
            if (!reds.isEmpty()) {
                int seq = 0;
                for (MCHZCW028reDetail re : reds) {
                    seq++;
                    HZCW028reDetailModel rem = new HZCW028reDetailModel();
                    rem.setNo(seq);
                    rem.setSummary(filterString(re.getSummary()));
                    rem.setBudgetDept_txt(re.getBudgetDept());
                    rem.setBudgetDept_lbl(re.getDeptName());
                    rem.setNotaxes(re.getNotaxes());
                    rem.setTaxes(re.getTaxes());
                    rem.setTaxInclusive(re.getTaxInclusive());
                    rem.setBudgetAcc(re.getBudgetAcc());
                    rem.setBudgetAccname(re.getBudgetAccname());
                    rem.setResearch(re.getResearch() != null ? re.getResearch() : "");
                    rem.setAccno(rem.getBudgetAcc());
                    rem.setAccName(rem.getBudgetAccname());
                    //获取科目期余额
                    rem.setAccPeriod(budgetDetailBean.getBudgetBalanceForAccPeriod(facno, date, re.getCenterid(), rem.getBudgetAcc()));
                    rem.setAccYear(budgetDetailBean.getBudgetBalanceForAccYear(facno, date, re.getCenterid(), rem.getBudgetAcc()));
                    rem.setProduct("R");
                    rem.setEntertainObj(re.getEntertainObj() != null ? re.getEntertainObj() : "");
                    String entertainDate = re.getEntertainDate();
                    if (entertainDate == null) {
                        rem.setEntertainDate_txt("");
                    } else {
                        rem.setEntertainDate_txt(entertainDate);
                    }
                    rem.setEntertainPeople(re.getEntertainPeople() != null ? re.getEntertainPeople() : "");
                    rem.setEntertainReason(re.getEntertainReason() != null ? re.getEntertainReason() : "");
                    rem.setCenterid(re.getCenterid());
                    rem.setRemark(re.getRemark());
                    rems.add(rem);
                }
            }
            List<MCHZCW028tDetail> tds = entity.getTravel_items();
            List<HZCW028tDetailModel> tms = new ArrayList<>();
            if (tds != null && !tds.isEmpty()) {
                int tseq = 0;
                for (MCHZCW028tDetail td : tds) {
                    tseq++;
                    HZCW028tDetailModel tm = new HZCW028tDetailModel();
                    tm.setNo(tseq);
                    tm.setTrafficDate_txt(td.getTrafficDate());
                    tm.setTrafficPlace(td.getTrafficPlace());
                    tm.setTrafficSummary(filterString(td.getTrafficSummary()));
                    //单据张数
                    int bill_num = td.getBill_num();
                    tm.setReceipt(String.valueOf(bill_num));
                    tm.setTaxi(td.getTaxi());
                    tm.setTrafficfee(td.getTrafficfee());
                    tm.setAccommodation(td.getAccommodation());
                    tm.setAllowance(td.getAllowance());
                    tm.setSubtotal(td.getSubtotal());
                    tm.setTravelReport("");
                    tm.setSort1("");
                    tm.setBh1("");
                    tm.setJc1("");
                    tm.setSort2("");
                    tm.setBh2("");
                    tm.setJc2("");
                    tm.setSort3("");
                    tm.setBh3("");
                    tm.setJc3("");
                    tm.setCarUse("");
                    tm.setStartMileage("");
                    tm.setEndMileage("");
                    tm.setTotalMileage("");
                    tm.setServiceno2("");
                    tm.setCustomerSno2("");
                    tm.setIsFree("");
                    tm.setOtherFee(td.getOtherFee());
                    tms.add(tm);
                }
            }
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("reDetail", rems);
            details.put("tDetail", tms);
            m.setFacno(facno);
            m.setCost(entity.getCost());
            m.setReimbursement(entity.getReimbursement());
            m.setAppDate(entity.getAppDate());
            m.setAppUser(entity.getAppUser());
            m.setAppDept(entity.getAppDept());
            m.setCRMNO(entity.getCrmno() != null ? entity.getCrmno() : "");
            m.setTotaltaxInclusive(entity.getTotaltaxInclusive());
            String coin = entity.getCoin();
            BigDecimal ratio = BigDecimal.ONE;
            if (null == coin || "".equals(coin) || "RMB".equals(coin)) {
                ratio = BigDecimal.ONE;
                m.setTotalnotaxesRMB(entity.getTotalnotaxesRMB());
                m.setTotaltaxesRMB(entity.getTotaltaxesRMB());
                m.setTotaltaxInclusiveRMB(entity.getTotaltaxInclusiveRMB());
            } else {
                misrateBean.setCompany("C");
                Misrate misrate = misrateBean.findByCoin(coin);
                if (misrate != null) {
                    ratio = misrate.getRate();
                    BigDecimal totalRMB = BigDecimal.valueOf(entity.getTotaltaxInclusive()).multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP);
                    m.setTotalnotaxesRMB(totalRMB.doubleValue());
                    m.setTotaltaxesRMB(0.00);
                    m.setTotaltaxInclusiveRMB(totalRMB.doubleValue());
                }
            }
            m.setCoin(coin);
            m.setRatio(ratio.doubleValue());
            //m.setRatio(entity.getRatio());
            BudgetCenter budgetCenter = budgetCenterBean.findByDeptid(m.getAppDept());
            m.setDeptPeriod(budgetDetailBean.getBudgetBalanceForDeptPeriod(facno, date, budgetCenter.getBudgetCenterPK().getCenterid()));
            m.setDeptYear(budgetDetailBean.getBudgetBalanceForDeptYear(facno, date, budgetCenter.getBudgetCenterPK().getCenterid()));
            m.setDays(0);
            BigDecimal b = new BigDecimal(m.getTotaltaxInclusiveRMB());
            m.setAmount(workFlowBean.number2CNMonetaryUnit(b.setScale(2, BigDecimal.ROUND_HALF_UP)));           //大写金额
            m.setCreator(entity.getCreator());
            m.setSrcno(entity.getSrcno());
            m.setDeptqx("");
            //初始化发起人
            workFlowBean.initUserInfo(entity.getAppUser());
            if (null == workFlowBean.getUserTitle()) {
                throw new RuntimeException("获取请款人职等失败");
            } else {
                m.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
            }
            //发起流程
            String formInstance = workFlowBean.buildXmlForEFGP("HZ_CW028", m, details);
            String subject = m.getAppUser() + "发起报销申请";
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HZ_CW028", formInstance, subject);
            String[] rm = msg.split("\\$");
            tran.commit();
            if (rm.length == 2) {
                return new MCResponseData(Integer.parseInt(rm[0]), rm[1]);
            } else {
                return new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            }

        } catch (Exception e) {
            try {
                e.printStackTrace();
                tran.rollback();
                //加入邮件通知
                mailBean.clearReceivers();
                if (!"".equals(entity.getAppUser())) {
                    mailBean.getTo().add(entity.getAppUser() + "@hanbell.com.cn");
                }
                mailBean.getTo().add("13120@hanbell.cn");
                mailBean.setMailSubject("每刻费用报销单抛转OA失败");
                mailBean.setMailContent(
                        "每刻费用申请单抛转异常，申请人: " + entity.getAppUser() + ",  每刻单号：" + entity.getSrcno() + " 出现异常：" + e.toString());
//                mailBean.notify(new ErrorMailNotify());
                return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
            } catch (Exception ex) {
                Logger.getLogger(HZCW028FacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
            }
        }
    }

    /**
     *
     * @param status 0发起费控前检核，1发起OA前检核
     * @param mc 检核报销单
     * @return
     */
    public MCResponseData checkBeforeSend(int status, MCHZCW028 mc) {
        int code = 200;
        String msg = "抛转检核OK";
        try {
            //判断token 是否有效
            if (mc == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!mc.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            //检查申请人是否重复借款
            if (!hzcw017Bean.checkArrears(mc.getAppUser())) {
                return new MCResponseData(109, "您有借款未还不能再发起借支申请");
            }
            //检查申请日期
            Date date;
            String period;
            try {
                String d = mc.getAppDate();
                if (d == null) {
                    code = 107;
                    msg = "申请日期不能为空";
                    return new MCResponseData(code, msg);
                }
                date = BaseLib.getDate("yyyy/MM/dd", d); //日期
                period = BaseLib.formatDate("yyyyMM", date);
            } catch (Exception e) {
                code = 107;
                msg = "申请日期格式错误";
                return new MCResponseData(code, msg);
            }
            String tdstatus = "N";
            double tdssum = 0.00;    //差旅费合计
            double resum = 0.00;    //费用明细合计     
            String cost = mc.getCost();
            String reimbursement = mc.getReimbursement();
            if (cost == null || cost.isEmpty() || reimbursement == null || reimbursement.isEmpty()) {
                code = 107;
                msg = "费用类别或销售性质不能为空";
                return new MCResponseData(code, msg);
            }
            String facno = mc.getFacno();
            budgetDetailBean.setCompany(facno);
            budgetCenterBean.setCompany(facno);
            if (null == comanyBean.findByCompany(facno)) {
                code = 107;
                msg = "传入公司别数据无效";
                return new MCResponseData(code, msg);
            }
            String appUser = mc.getAppUser();
            Users u = usersBean.findById(appUser);
            if (null == u || u.getLeaveDate() != null) {
                code = 107;
                msg = "传入申请人数据无效";
                return new MCResponseData(code, msg);
            }
            String coin = mc.getCoin();
            miscodeBean.setCompany(facno);
            if (null == miscodeBean.findByPK("GA", coin)) {
                code = 107;
                msg = "传入币别数据无效";
                return new MCResponseData(code, msg);
            }
            BigDecimal ratio = BigDecimal.ONE;
            if (null == coin || "".equals(coin) || "RMB".equals(coin)) {
                ratio = BigDecimal.ONE;
            } else {
                misrateBean.setCompany("C");
                Misrate misrate = misrateBean.findByCoin(coin);
                if (misrate != null) {
                    ratio = misrate.getRate();
                }
            }
            String srcno = mc.getSrcno();
            if (srcno == null || srcno.isEmpty()) {
                code = 107;
                msg = "来源单号不能为空";
                return new MCResponseData(code, msg);
            }
            List<MCHZCW028reDetail> items = mc.getItems();
            if (items.isEmpty()) {
                code = 107;
                msg = "费用明细不能为空";
                return new MCResponseData(code, msg);
            }
            String regex = "^(([1-9]\\d*)|\\d)(\\.\\d+)?$"; //正浮点数匹配
            String regex2 = "^\\d+(\\.\\d+)?$"; //非负浮点数
            for (MCHZCW028reDetail r : items) {
                double notaxes = r.getNotaxes();
                double taxes = r.getTaxes();
                double taxinclusive = r.getTaxInclusive();

                if (!String.valueOf(notaxes).matches(regex) || notaxes == 0.00) {
                    code = 107;
                    msg = "未税金额格式错误";
                    return new MCResponseData(code, msg);
                }
                if (!String.valueOf(taxes).matches(regex2)) {
                    code = 107;
                    msg = "税金额格式错误";
                    return new MCResponseData(code, msg);
                }
                if (!String.valueOf(taxinclusive).matches(regex) || taxinclusive == 0.00) {
                    code = 107;
                    msg = "含税金额格式错误";
                    return new MCResponseData(code, msg);
                }
                String budgetDept = r.getBudgetDept();
                if (null == workFlowBean.findOrgUnitByDeptno(budgetDept)) {
                    code = 107;
                    msg = "预算部门错误";
                    return new MCResponseData(code, msg);
                }
                String deptName = r.getDeptName();
                if (deptName == null || deptName.isEmpty()) {
                    code = 107;
                    msg = "部门名称不能为空";
                    return new MCResponseData(code, msg);
                }
                String centerid = r.getCenterid();
                BudgetCenter bc = budgetCenterBean.findByDeptid(budgetDept);
                if (null == bc) {
                    code = 107;
                    msg = "预算部门无责任中心";
                    return new MCResponseData(code, msg);
                } else {
                    if (!centerid.equals(bc.getBudgetCenterPK().getCenterid())) {
                        code = 107;
                        msg = "预算部门对应责任中心错误";
                        return new MCResponseData(code, msg);
                    }
                }
                String budgetAcc = r.getBudgetAcc();
                if (null == budgetDetailBean.findBudgetDetail(facno, period, centerid, budgetAcc)) {
                    code = 107;
                    msg = "ERP无对应预算方案";
                    return new MCResponseData(code, msg);
                }
                String summary = r.getSummary();
                if (summary == null || summary.isEmpty()) {
                    code = 107;
                    msg = "摘要不能为空";
                    return new MCResponseData(code, msg);
                }
                switch (budgetAcc) {
                    case "6731":
                    case "6631":
                        if (r.getEntertainDate() == null || r.getEntertainDate().isEmpty() || r.getEntertainObj() == null || r.getEntertainObj().isEmpty() || r.getEntertainPeople() == null || r.getEntertainPeople().isEmpty() || r.getEntertainReason() == null || r.getEntertainReason().isEmpty()) {
                            code = 107;
                            msg = "科目为交际费，招待明细必填";
                            return new MCResponseData(code, msg);
                        }
                        CheckData ch = new CheckData();
                        if (!ch.valiDateFormat(r.getEntertainDate())) {
                            code = 107;
                            msg = "招待日期格式错误";
                            return new MCResponseData(code, msg);
                        }
                        break;
                    case "5107":
                    case "5307":
                    case "6607":
                    case "6707":
                        if (r.getRemark() == null || r.getRemark().isEmpty()) {
                            code = 107;
                            msg = "科目为福利费，备注必填";
                            return new MCResponseData(code, msg);
                        }
                        break;
                    default:
                }
                if (budgetAcc.substring(0, 2).equals("53")) {
                    if (r.getResearch() == null || r.getResearch().isEmpty()) {
                        code = 107;
                        msg = "科目为研发，研发专案号必填";
                        return new MCResponseData(code, msg);
                    }
                }
                //检验科目期间余额,费控发起前检核
                if (status == 0) {
                    String accnoValue = "5117;5309;6617;6717;5137;6637;6737;6631;6731;5118;6618;6718;5136;6636;6736";
                    if (accnoValue.contains(budgetAcc) && !facno.equals("Q")) {
                        double accp = budgetDetailBean.getBudgetBalanceForAccPeriod(facno, date, centerid, budgetAcc);
                        if (accp - notaxes < 0.00) {
                            code = 110;
                            msg = "预算科目" + budgetAcc + "期间余额小于零不能申请";
                            return new MCResponseData(code, msg);
                        }
                    }
                }
                //检查报销单明细与费控中间表预扣是否一致(预算做的本币)
                if (status == 1) {
                    Boolean bool = mcbudgetBean.checkMcbudget("HZCW028", srcno, facno, period, centerid, budgetAcc, BigDecimal.valueOf(r.getTaxInclusive()).multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                    if (bool == false) {
                        code = 107;
                        msg = "费用明细与预算中间表预扣不一致";
                        return new MCResponseData(code, msg);
                    }
                }
                //明细含差旅费科目
                if (r.getBudgetAccname().contains("差旅费")) {
                    //tdstatus = "Y";
                    tdssum += r.getTaxInclusive();
                }
                resum += r.getTaxInclusive();
            }
            if ("Y".equals(tdstatus)) {
                List<MCHZCW028tDetail> travels = mc.getTravel_items();
                if (travels == null || travels.isEmpty()) {
                    code = 107;
                    msg = "差旅明细不能为空";
                    return new MCResponseData(code, msg);
                }
            }
            List<MCHZCW028tDetail> travels = mc.getTravel_items();
            if (("0".equals(cost) || "1".equals(cost))) {
                if (travels == null || travels.isEmpty()) {
                    code = 107;
                    msg = "差旅明细不能为空";
                    return new MCResponseData(code, msg);
                }
                //CRM相关人员CRM单号必填
                boolean checkStatus = crmUserGroupBean.checkStatus(appUser);
                if (checkStatus == true) {
                    if (mc.getCrmno() == null || mc.getCrmno().isEmpty()) {
                        code = 107;
                        msg = "CRM单号不能为空";
                        return new MCResponseData(code, msg);
                    }
                    if (mc.getCrmtype() == null || mc.getCrmtype().isEmpty()) {
                        code = 107;
                        msg = "CRM单据类型不能为空";
                        return new MCResponseData(code, msg);
                    }
                }
            }
            if (travels != null && travels.size() > 0) {
                double tdssum2 = 0.00;
                for (MCHZCW028tDetail t : travels) {
                    CheckData ch = new CheckData();
                    if (!ch.valiDateFormat(t.getTrafficDate())) {
                        code = 107;
                        msg = "差旅日期格式错误";
                        return new MCResponseData(code, msg);
                    }
                    if (!String.valueOf(t.getTaxi()).matches(regex2)) {
                        code = 107;
                        msg = "出租车费格式错误";
                        return new MCResponseData(code, msg);
                    }
                    if (!String.valueOf(t.getTrafficfee()).matches(regex2)) {
                        code = 107;
                        msg = "交通费费格式错误";
                        return new MCResponseData(code, msg);
                    }
                    if (!String.valueOf(t.getAccommodation()).matches(regex2)) {
                        code = 107;
                        msg = "住宿费格式错误";
                        return new MCResponseData(code, msg);
                    }
                    if (!String.valueOf(t.getAllowance()).matches(regex2)) {
                        code = 107;
                        msg = "出差补贴费格式错误";
                        return new MCResponseData(code, msg);
                    }
                    //if (!String.valueOf(t.getSubtotal()).matches(regex) || t.getSubtotal() == 0.00) {
                    //每刻报销行程摘要写入差旅明细允许金额0
                    if (!String.valueOf(t.getSubtotal()).matches(regex)) {
                        code = 107;
                        msg = "差旅金额小计格式错误";
                        return new MCResponseData(code, msg);
                    }
                    //tdssum2 += t.getSubtotal();
                    //差旅小计只算明细4个费用加起来
                    tdssum2 = tdssum2 + t.getTaxi() + t.getTrafficfee() + t.getAccommodation() + t.getAllowance();

                }
                BigDecimal bdsum = new BigDecimal(tdssum).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal bdsum2 = new BigDecimal(tdssum2).setScale(2, BigDecimal.ROUND_HALF_UP);
                if (bdsum.compareTo(bdsum2) != 0) {
                    code = 107;
                    msg = "差旅金额小计：" + bdsum2 + "与差旅费科目金额:" + bdsum + "不一致";
                    return new MCResponseData(code, msg);
                }
            }
            //检验部门期间余额
            if (status == 0) {
                BudgetCenter budgetCenter = budgetCenterBean.findByDeptid(mc.getAppDept());
                if (null == budgetCenter) {
                    code = 110;
                    msg = "未找到请款部门：" + mc.getAppDept() + "对应的责任中心";
                    return new MCResponseData(code, msg);
                }
                double depp = budgetDetailBean.getBudgetBalanceForDeptPeriod(facno, date, budgetCenter.getBudgetCenterPK().getCenterid());
                if (depp < mc.getTotaltaxInclusive()) {
                    code = 110;
                    msg = "部门期间余额小于零不能申请";
                    return new MCResponseData(code, msg);
                }
            }
            /**
             * 预算中间表检查是否发起过 status =0 预算新增前检查，status=1 预算新增后发起OA检查
             */
            List<Mcbudget> mcbudgets = mcbudgetBean.findBySrcno(srcno);
            if (status == 0) {
                if (null != mcbudgets && mcbudgets.size() > 0) {
                    code = 108;
                    msg = "此费控单号已发起过预算单据";
                    return new MCResponseData(code, msg);
                }
            } else if (status == 1) {
                if (null != mcbudgets && mcbudgets.size() < 1) {
                    code = 108;
                    msg = "此费控单号未关连预算";
                    return new MCResponseData(code, msg);
                }
                //检查费控中间表与报销总金额是否一致
                BigDecimal bd = BigDecimal.ZERO;
                for (Mcbudget mcbudget : mcbudgets) {
                    bd = bd.add(mcbudget.getPreamts());
                }
                if (bd.setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(BigDecimal.valueOf(mc.getTotaltaxInclusive()).multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP)) != 0) {
                    code = 107;
                    msg = "费用明细与预算中间表预扣不一致";
                    return new MCResponseData(code, msg);
                }
            }
            //费用明细与申请总额原币
            //if (resum != mc.getTotaltaxInclusive()) {
            if (new BigDecimal(resum).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal(mc.getTotaltaxInclusive()).setScale(2, BigDecimal.ROUND_HALF_UP)) != 0) {
                code = 107;
                msg = "费用明细与申请总额不一致";
                return new MCResponseData(code, msg);
            }
            //加入分摊部门检查    
            return new MCResponseData(code, msg);
        } catch (Exception e) {
            e.printStackTrace();
            log4j.error(e.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

    public boolean initialCRMWorkDetail(MCHZCW028 mc) {
        try {
            String crmno = mc.getCrmno();
            String crmtype = mc.getCrmtype();
            if (crmno == null) {
                return false;
            }
            List<MCHZCW028tDetail> travels = mc.getTravel_items();
            List<MCHZCW028reDetail> reDetails = mc.getItems();
            String coin = mc.getCoin();
            BigDecimal ratio = BigDecimal.ONE;
            if (null == coin || "".equals(coin) || "RMB".equals(coin)) {
                ratio = BigDecimal.ONE;
            } else {
                misrateBean.setCompany("C");
                Misrate misrate = misrateBean.findByCoin(coin);
                if (misrate != null) {
                    ratio = misrate.getRate();
                }
            }
            //销售人员用“YXJL”标识类别
            if ("YXJL".equals(crmtype)) {
                SALFI salfi = salfiBean.findByPK(crmno);
                List<SALFT> salftList = new ArrayList();
                //销售人员写入SALFT
                if (salfi != null) {
                    //差旅明细
                    for (MCHZCW028tDetail t : travels) {
                        if (t.getTaxi() > 0) {
                            SALFT sal = new SALFT();
                            sal.setCompany("SHAHANBELL");
                            sal.setCreator(salfi.getCreator());
                            sal.setCreateDate(salfi.getCreateDate());
                            sal.setUsrGroup(salfi.getUsrGroup());
                            sal.setFlag((short) 2);
                            int seq = salftList.size() + 1;
                            DecimalFormat decimalFormat = new DecimalFormat("0000000000");
                            String fi002 = decimalFormat.format(seq);
                            sal.setSALFTPK(new SALFTPK(crmno, fi002));
                            sal.setFt003(salfi.getFi004());
                            String ft004 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                            sal.setFt004(ft004);
                            sal.setFt005("");//目的
                            sal.setFt006(BigDecimal.valueOf(t.getTaxi()));
                            sal.setFt007("3B001");//出租车费
                            sal.setFt008(t.getTrafficSummary());
                            sal.setFt009(t.getTrafficPlace());
                            sal.setFt010(t.getTrafficPlace());
                            sal.setFt028(BigDecimal.valueOf(t.getTaxi()));
                            sal.setFt029(BigDecimal.ZERO);
                            sal.setFt030(BigDecimal.valueOf(t.getTaxi()));
                            salftList.add(sal);
                        }
                        if (t.getTrafficfee() > 0) {
                            SALFT sal = new SALFT();
                            sal.setCompany("SHAHANBELL");
                            sal.setCreator(salfi.getCreator());
                            sal.setCreateDate(salfi.getCreateDate());
                            sal.setUsrGroup(salfi.getUsrGroup());
                            sal.setFlag((short) 2);
                            int seq = salftList.size() + 1;
                            DecimalFormat decimalFormat = new DecimalFormat("0000000000");
                            String fi002 = decimalFormat.format(seq);
                            sal.setSALFTPK(new SALFTPK(crmno, fi002));
                            sal.setFt003(salfi.getFi004());
                            String ft004 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                            sal.setFt004(ft004);
                            sal.setFt005("");//目的
                            sal.setFt006(BigDecimal.valueOf(t.getTrafficfee()));
                            sal.setFt007("3B002");//其他交通费
                            sal.setFt008(t.getTrafficSummary());
                            sal.setFt009(t.getTrafficPlace());
                            sal.setFt010(t.getTrafficPlace());
                            sal.setFt028(BigDecimal.valueOf(t.getTrafficfee()));
                            sal.setFt029(BigDecimal.ZERO);
                            sal.setFt030(BigDecimal.valueOf(t.getTrafficfee()));
                            salftList.add(sal);
                        }
                        if (t.getAllowance() > 0) {
                            SALFT sal = new SALFT();
                            sal.setCompany("SHAHANBELL");
                            sal.setCreator(salfi.getCreator());
                            sal.setCreateDate(salfi.getCreateDate());
                            sal.setUsrGroup(salfi.getUsrGroup());
                            sal.setFlag((short) 2);
                            int seq = salftList.size() + 1;
                            DecimalFormat decimalFormat = new DecimalFormat("0000000000");
                            String fi002 = decimalFormat.format(seq);
                            sal.setSALFTPK(new SALFTPK(crmno, fi002));
                            sal.setFt003(salfi.getFi004());
                            String ft004 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                            sal.setFt004(ft004);
                            sal.setFt005("");//目的
                            sal.setFt006(BigDecimal.valueOf(t.getAllowance()));
                            sal.setFt007("3B003");//出差补贴
                            sal.setFt008(t.getTrafficSummary());
                            sal.setFt009(t.getTrafficPlace());
                            sal.setFt010(t.getTrafficPlace());
                            sal.setFt028(BigDecimal.valueOf(t.getAllowance()));
                            sal.setFt029(BigDecimal.ZERO);
                            sal.setFt030(BigDecimal.valueOf(t.getAllowance()));
                            salftList.add(sal);
                        }
                        if (t.getAccommodation() > 0) {
                            SALFT sal = new SALFT();
                            sal.setCompany("SHAHANBELL");
                            sal.setCreator(salfi.getCreator());
                            sal.setCreateDate(salfi.getCreateDate());
                            sal.setUsrGroup(salfi.getUsrGroup());
                            sal.setFlag((short) 2);
                            int seq = salftList.size() + 1;
                            DecimalFormat decimalFormat = new DecimalFormat("0000000000");
                            String fi002 = decimalFormat.format(seq);
                            sal.setSALFTPK(new SALFTPK(crmno, fi002));
                            sal.setFt003(salfi.getFi004());
                            String ft004 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                            sal.setFt004(ft004);
                            sal.setFt005("");//目的
                            sal.setFt006(BigDecimal.valueOf(t.getAccommodation()));
                            sal.setFt007("3B004");//住宿费
                            sal.setFt008(t.getTrafficSummary());
                            sal.setFt009(t.getTrafficPlace());
                            sal.setFt010(t.getTrafficPlace());
                            sal.setFt028(BigDecimal.valueOf(t.getAccommodation()));
                            sal.setFt029(BigDecimal.ZERO);
                            sal.setFt030(BigDecimal.valueOf(t.getAccommodation()));
                            salftList.add(sal);
                        }
                    }
                    //差旅费含其他
                    for (MCHZCW028reDetail re : reDetails) {
                        String accString = "6631;6618;6658;6614";
                        if (accString.contains(re.getBudgetAcc())) {
                            SALFT sal = new SALFT();
                            sal.setCompany("SHAHANBELL");
                            sal.setCreator(salfi.getCreator());
                            sal.setCreateDate(salfi.getCreateDate());
                            sal.setUsrGroup(salfi.getUsrGroup());
                            sal.setFlag((short) 2);
                            int seq = salftList.size() + 1;
                            DecimalFormat decimalFormat = new DecimalFormat("0000000000");
                            String fi002 = decimalFormat.format(seq);
                            sal.setSALFTPK(new SALFTPK(crmno, fi002));
                            sal.setFt003(salfi.getFi004());
                            if (re.getBudgetAcc().equals("6631")) {
                                String ft004 = re.getEntertainDate().substring(0, 4) + re.getEntertainDate().substring(5, 7) + re.getEntertainDate().substring(8, 10);
                                sal.setFt004(ft004);
                            }
                            sal.setFt005("");//目的
                            sal.setFt006(BigDecimal.valueOf(re.getTaxInclusive()));
                            sal.setFt007(re.getBudgetAcc());
                            sal.setFt008(re.getSummary());
                            sal.setFt028(BigDecimal.valueOf(re.getNotaxes()));
                            sal.setFt029(BigDecimal.valueOf(re.getTaxes()));
                            sal.setFt030(BigDecimal.valueOf(re.getTaxInclusive()));
                            salftList.add(sal);
                        }
                    }

                    //新增费用申请记录PORMY,PORMZ
                    List<PORMZ> pormzList = new ArrayList();
                    String my001 = "A1";
                    String my003 = BaseLib.formatDate("yyyyMMdd", BaseLib.getDate());
                    String my002 = pormyBean.getSerialNumber(my003);

                    PORMY py = new PORMY();
                    py.setCompany("SHAHANBELL");
                    py.setCreator(salfi.getCreator());
                    py.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                    py.setUsrGroup(salfi.getUsrGroup());
                    //py.setFlag((short) 2);

                    BigDecimal total = BigDecimal.ZERO;
                    for (SALFT f : salftList) {
                        PORMZ pz = new PORMZ();
                        pz.setCompany("SHAHANBELL");
                        pz.setCreator(salfi.getFi004());
                        pz.setCreateDate(salfi.getCreateDate());
                        pz.setUsrGroup(salfi.getFi003());
                        pz.setFlag((short) 1);
                        int seq = pormzList.size() + 1;
                        DecimalFormat decimalFormat = new DecimalFormat("0000");
                        String mz003 = decimalFormat.format(seq);
                        pz.setPormzPK(new PORMZPK(my001, my002, mz003));
                        pz.setMz004("1");
                        pz.setMz006(f.getSALFTPK().getFt001());
                        pz.setMz007(f.getSALFTPK().getFt002());
                        pz.setMz008(my003);
                        pz.setMz009(f.getFt007());
                        pz.setMz010(coin);  //币别
                        pz.setMz011(ratio);    //汇率
                        pz.setMz016(f.getFt006());
                        pz.setMz017(f.getFt006());
                        pz.setMz018(f.getFt006());
                        pz.setMz019(BigDecimal.ZERO);
                        pz.setMz020(f.getFt008());
                        pz.setMz021(salfi.getCustomer());
                        pz.setMz031(f.getFt009());
                        pz.setMz032(f.getFt010());
                        pz.setMz033(BigDecimal.ONE);
                        pz.setMz037("3B");
                        total = total.add(pz.getMz016());
                        pormzList.add(pz);
                        //更新费用申请单号
                        f.setFt021(my001);
                        f.setFt022(my002);
                        f.setFt023(mz003);
                        f.setFt014(salfi.getFi092());   //币别
                        f.setFt015(salfi.getFi093());   //汇率
                        f.setFt018("1");    //状态码
                        salftBean.persist(f);
                    };
                    //更新SALFI表头金额
                    salfi.setFi057(total);
                    salfi.setFi018("Y");
                    salfiBean.update(salfi);
                    py.setPormyPK(new PORMYPK(my001, my002));
                    py.setMy003(my003);
                    py.setMy004(py.getUsrGroup());
                    py.setMy005(py.getCreator());
                    py.setMy006(coin);
                    py.setMy007(String.valueOf(ratio));
                    py.setMy008(total);  //本币总金额
                    py.setMy009("Y");
                    py.setMy010(py.getCreator());
                    py.setMy011(my003);
                    py.setMy012("3");
                    py.setMy024(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                    py.setMy025(mc.getSrcno());//费控单号
                    py.setMy032(BigDecimal.valueOf(mc.getRatio()));
                    py.setMy033(total);//原币总金额
                    pormyBean.persist(py);
                    pormzList.forEach((PORMZ m) -> {
                        pormzBean.persist(m);
                    });
                    return true;
                }
            }
            List<REPLC> replcList = new ArrayList();
            //服务人员写入REPLC
            REPTC reptc = reptcBean.findByPK(crmtype, crmno);
            if (reptc != null) {
                //维修允许重复新增
                replcList = replcBean.findByLC001ANDLC002(crmtype, crmno);
                //差旅明细
                for (MCHZCW028tDetail t : travels) {
                    if (t.getTaxi() > 0) {
                        REPLC rep = new REPLC();
                        rep.setCompany("SHAHANBELL");
                        rep.setCreator(reptc.getCreator());
                        rep.setCreateDate(reptc.getCreateDate());
                        rep.setUsrGroup(reptc.getUsrGroup());
                        rep.setFlag((short) 2);
                        int seq = replcList.size() + 1;
                        DecimalFormat decimalFormat = new DecimalFormat("0000");
                        String lc003 = decimalFormat.format(seq);
                        rep.setREPLCPK(new REPLCPK(crmtype, crmno, lc003));
                        rep.setLc004("3C004");//出租车费
                        rep.setLc005(BigDecimal.valueOf(t.getTaxi()));
                        rep.setLc006(BigDecimal.ONE);
                        rep.setLc007(BigDecimal.valueOf(t.getTaxi()));
                        rep.setLc008(BigDecimal.valueOf(t.getTaxi()));
                        rep.setLc009(BigDecimal.ZERO);
                        rep.setLc010(BigDecimal.valueOf(t.getTaxi()));
                        rep.setLc011(BigDecimal.valueOf(t.getTaxi()));
                        rep.setLc018("1");
                        rep.setLc024(t.getTrafficSummary());
                        String lc025 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                        rep.setLc025(lc025);
                        rep.setLc030(reptc.getTc069());
                        rep.setLc031(reptc.getTc070());
                        rep.setLc032(reptc.getTc016());
                        replcList.add(rep);
                    }
                    if (t.getTrafficfee() > 0) {
                        REPLC rep = new REPLC();
                        rep.setCompany("SHAHANBELL");
                        rep.setCreator(reptc.getCreator());
                        rep.setCreateDate(reptc.getCreateDate());
                        rep.setUsrGroup(reptc.getUsrGroup());
                        rep.setFlag((short) 2);
                        int seq = replcList.size() + 1;
                        DecimalFormat decimalFormat = new DecimalFormat("0000");
                        String lc003 = decimalFormat.format(seq);
                        rep.setREPLCPK(new REPLCPK(crmtype, crmno, lc003));
                        rep.setLc004("3C002");//其他交通费
                        rep.setLc005(BigDecimal.valueOf(t.getTrafficfee()));
                        rep.setLc006(BigDecimal.ONE);
                        rep.setLc007(BigDecimal.valueOf(t.getTrafficfee()));
                        rep.setLc008(BigDecimal.valueOf(t.getTrafficfee()));
                        rep.setLc009(BigDecimal.ZERO);
                        rep.setLc010(BigDecimal.valueOf(t.getTrafficfee()));
                        rep.setLc011(BigDecimal.valueOf(t.getTrafficfee()));
                        rep.setLc018("1");
                        rep.setLc024(t.getTrafficSummary());
                        String lc025 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                        rep.setLc025(lc025);
                        rep.setLc030(reptc.getTc069());
                        rep.setLc031(reptc.getTc070());
                        rep.setLc032(reptc.getTc016());
                        replcList.add(rep);
                    }
                    if (t.getAllowance() > 0) {
                        REPLC rep = new REPLC();
                        rep.setCompany("SHAHANBELL");
                        rep.setCreator(reptc.getCreator());
                        rep.setCreateDate(reptc.getCreateDate());
                        rep.setUsrGroup(reptc.getUsrGroup());
                        rep.setFlag((short) 2);
                        int seq = replcList.size() + 1;
                        DecimalFormat decimalFormat = new DecimalFormat("0000");
                        String lc003 = decimalFormat.format(seq);
                        rep.setREPLCPK(new REPLCPK(crmtype, crmno, lc003));
                        rep.setLc004("3C003");//出差补贴
                        rep.setLc005(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc006(BigDecimal.ONE);
                        rep.setLc007(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc008(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc009(BigDecimal.ZERO);
                        rep.setLc010(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc011(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc018("1");
                        rep.setLc024(t.getTrafficSummary());
                        String lc025 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                        rep.setLc025(lc025);
                        rep.setLc030(reptc.getTc069());
                        rep.setLc031(reptc.getTc070());
                        rep.setLc032(reptc.getTc016());
                        replcList.add(rep);
                    }
                    if (t.getAccommodation() > 0) {
                        REPLC rep = new REPLC();
                        rep.setCompany("SHAHANBELL");
                        rep.setCreator(reptc.getCreator());
                        rep.setCreateDate(reptc.getCreateDate());
                        rep.setUsrGroup(reptc.getUsrGroup());
                        rep.setFlag((short) 2);
                        int seq = replcList.size() + 1;
                        DecimalFormat decimalFormat = new DecimalFormat("0000");
                        String lc003 = decimalFormat.format(seq);
                        rep.setREPLCPK(new REPLCPK(crmtype, crmno, lc003));
                        rep.setLc004("3C005");//住宿费
                        rep.setLc005(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc006(BigDecimal.ONE);
                        rep.setLc007(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc008(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc009(BigDecimal.ZERO);
                        rep.setLc010(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc011(BigDecimal.valueOf(t.getAllowance()));
                        rep.setLc018("1");
                        rep.setLc024(t.getTrafficSummary());
                        String lc025 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                        rep.setLc025(lc025);
                        rep.setLc030(reptc.getTc069());
                        rep.setLc031(reptc.getTc070());
                        rep.setLc032(reptc.getTc016());
                        replcList.add(rep);
                    }
                }
                //差旅费含其他
                for (MCHZCW028reDetail re : reDetails) {
                    String accString = "6618;6631;6658";
                    if (accString.contains(re.getBudgetAcc())) {
                        REPLC rep = new REPLC();
                        rep.setCompany("SHAHANBELL");
                        rep.setCreator(reptc.getCreator());
                        rep.setCreateDate(reptc.getCreateDate());
                        rep.setUsrGroup(reptc.getUsrGroup());
                        rep.setFlag((short) 2);
                        int seq = replcList.size() + 1;
                        DecimalFormat decimalFormat = new DecimalFormat("0000");
                        String lc003 = decimalFormat.format(seq);
                        rep.setREPLCPK(new REPLCPK(crmtype, crmno, lc003));
                        switch (re.getBudgetAcc()) {
                            case "6618":
                                rep.setLc004("3C001");
                                break;
                            case "6631":
                                rep.setLc004("3C007");
                                break;
                            case "6658":
                                rep.setLc004("3C008");
                                break;
                            default:
                                rep.setLc004("");
                                break;
                        }
                        rep.setLc005(BigDecimal.valueOf(re.getTaxInclusive()));
                        rep.setLc006(BigDecimal.ONE);
                        rep.setLc007(BigDecimal.valueOf(re.getTaxInclusive()));
                        rep.setLc008(BigDecimal.valueOf(re.getTaxInclusive()));
                        rep.setLc009(BigDecimal.ZERO);
                        rep.setLc010(BigDecimal.valueOf(re.getTaxInclusive()));
                        rep.setLc011(BigDecimal.valueOf(re.getTaxInclusive()));
                        rep.setLc018("1");
                        rep.setLc024(re.getSummary());
                        //String lc025 = t.getTrafficDate().substring(0, 4) + t.getTrafficDate().substring(5, 7) + t.getTrafficDate().substring(8, 10);
                        //rep.setLc025(lc025);
                        rep.setLc030(reptc.getTc069());
                        rep.setLc031(reptc.getTc070());
                        rep.setLc032(reptc.getTc016());
                        replcList.add(rep);
                    }
                }
                //新增费用申请记录PORMY,PORMZ
                List<PORMZ> pormzList = new ArrayList();
                String my001 = "A1";
                String my003 = BaseLib.formatDate("yyyyMMdd", BaseLib.getDate());
                String my002 = pormyBean.getSerialNumber(my003);

                PORMY py = new PORMY();
                py.setCompany("SHAHANBELL");
                py.setCreator(reptc.getCreator());
                py.setCreateDate(reptc.getCreateDate());
                py.setUsrGroup(reptc.getUsrGroup());
                //py.setFlag((short) 2);
                BigDecimal total = BigDecimal.ZERO;
                for (REPLC r : replcList) {
                    PORMZ pz = new PORMZ();
                    pz.setCompany("SHAHANBELL");
                    pz.setCreator(reptc.getTc016());
                    pz.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                    pz.setUsrGroup(reptc.getUsrGroup());
                    pz.setFlag((short) 1);
                    int seq = pormzList.size() + 1;
                    DecimalFormat decimalFormat = new DecimalFormat("0000");
                    String mz003 = decimalFormat.format(seq);
                    pz.setPormzPK(new PORMZPK(my001, my002, mz003));
                    pz.setMz004("2");
                    pz.setMz005(r.getREPLCPK().getLc001());
                    pz.setMz006(r.getREPLCPK().getLc002());
                    pz.setMz007(r.getREPLCPK().getLc003());
                    pz.setMz008(my003);
                    pz.setMz009(r.getLc004());
                    pz.setMz010(r.getLc030());    //币别
                    pz.setMz011(r.getLc031());    //汇率
                    pz.setMz016(r.getLc007());
                    pz.setMz017(r.getLc007());
                    pz.setMz018(r.getLc007());
                    pz.setMz019(BigDecimal.ZERO);
                    pz.setMz020(r.getLc024());
                    pz.setMz021(reptc.getTc007());
//                    pz.setMz031(f.getFt009());
//                    pz.setMz032(f.getFt010());
                    pz.setMz037("3C");
                    total = total.add(pz.getMz016());
                    pormzList.add(pz);
                    //更新费用申请单号
                    r.setLc021(my001);
                    r.setLc022(my002);
                    r.setLc023(mz003);
                    replcBean.persist(r);
                };
                py.setPormyPK(new PORMYPK(my001, my002));
                py.setMy003(my003);
                py.setMy004(py.getUsrGroup());
                py.setMy005(py.getCreator());
                py.setMy006(coin);
                py.setMy007(ratio.toString());
                py.setMy008(total);  //本币总金额
                py.setMy009("Y");
                py.setMy010(py.getCreator());
                py.setMy011(my003);
                py.setMy024(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                py.setMy025(mc.getSrcno());//费控单号
                py.setMy032(BigDecimal.valueOf(mc.getRatio()));
                py.setMy033(total);//原币总金额
                pormyBean.persist(py);
                pormzList.forEach((PORMZ m) -> {
                    pormzBean.persist(m);
                });
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log4j.error(e.toString());
            throw new RuntimeException(e.toString());
        }
        return false;
    }

}
