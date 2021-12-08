/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCHZCW017;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.erp.ejb.BudgetCenterBean;
import cn.hanbell.erp.ejb.BudgetDetailBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.MisrateBean;
import cn.hanbell.erp.entity.BudgetCenter;
import cn.hanbell.erp.entity.Misrate;
import cn.hanbell.jrs.SuperREST;
import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.entity.HZCW017;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HZCW017Model;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Administrator
 */
@Path("costctrl/hzcw017")
@javax.enterprise.context.RequestScoped
public class HZCW017FacadeREST extends SuperREST<HZCW017> {

    @EJB
    private WorkFlowBean workFlowBean;
    @EJB
    private HZCW017Bean hzcw017Bean;
    @EJB
    private CompanyBean comanyBean;
    @EJB
    private UsersBean usersBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private MisrateBean misrateBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;
    @EJB
    private BudgetCenterBean budgetCenterBean;

    @Override
    protected SuperEJB getSuperEJB() {
        return hzcw017Bean;
    }

    public HZCW017FacadeREST() {
        super(HZCW017.class);
    }

    @POST
    @Path("check")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData checkMCHZCW017(MCHZCW017 entity) {
        if (entity == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        try {
            MCResponseData rs = new MCResponseData();
            rs = checkBeforeSend(entity);
            return rs;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }

    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData createOAHZCW017(MCHZCW017 entity) {

        try {
            MCResponseData rs = new MCResponseData();
            rs = checkBeforeSend(entity);
            if (rs.getCode() != 200) {
                return rs;
            }
            //检查申请人是否重复借款
            if (!hzcw017Bean.checkArrears(entity.getLoanUser())) {
                return new MCResponseData(500, "您有借款未还不能再发起借支申请");
            }
            //初始化发起人
            workFlowBean.initUserInfo(entity.getLoanUser());
            //实例化对象
            HZCW017Model la = new HZCW017Model();
            la.setFacno(entity.getFacno());
            la.setLoanDate(BaseLib.getDate());
            la.setLoanUser(workFlowBean.getCurrentUser().getId());
            la.setHdnloanUser(workFlowBean.getCurrentUser().getUserName());
            OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getLoanDept());
            if (ou == null) {
                throw new NullPointerException(entity.getLoanDept() + "不存在");
            }
            la.setLoanDept(ou.getId());
            la.setHdnloanDept(ou.getOrganizationUnitName());
            la.setLoanProperty(entity.getLoanProperty());
            //la.setHdnloanProperty(entity.getLoanpropertyDesc());
            la.setCreator(entity.getLoanUser());
            la.setReason(entity.getReason());
            la.setCoin(entity.getCoin());
            if ("RMB".endsWith(entity.getCoin())) {
                la.setRatio(1.000);
            } else {
                misrateBean.setCompany(la.getFacno());
                Misrate misrate = misrateBean.findByCoin(entity.getCoin());
                if (misrate != null) {
                    la.setRatio(misrate.getRate().doubleValue());
                }
            }
            la.setLoanTotal(entity.getLoanTotal());
            BigDecimal b = new BigDecimal(entity.getLoanTotal() * la.getRatio());
            la.setTotalRMB(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            la.setAmount(workFlowBean.number2CNMonetaryUnit(b.setScale(2, BigDecimal.ROUND_HALF_UP)));              //大写金额
            la.setPreLocation("");
            la.setPeople("");
            la.setDays("");
            la.setTrafficfee(entity.getTrafficfee());
            la.setAccommodation(entity.getAccommodation());
            la.setAllowance(entity.getAllowance());
            la.setEntertain(entity.getEntertain());
            la.setOther(entity.getOther());
            la.setCenterid(entity.getCenterid());
            la.setPreCustomer("");
            budgetDetailBean.setCompany(la.getFacno());
            la.setDeptPeriod(budgetDetailBean.getBudgetBalanceForDeptPeriod(la.getFacno(), BaseLib.getDate(), entity.getCenterid()));
            la.setDeptYear(budgetDetailBean.getBudgetBalanceForDeptYear(la.getFacno(), BaseLib.getDate(), entity.getCenterid()));
            la.setPreAccno(entity.getPreAccno());
            la.setPreAccname(entity.getPreAccname());
            la.setArrears(entity.getLoanTotal());
            la.setProduct("R");
            la.setPrePayDate(BaseLib.getDate("yyyy/MM/dd", entity.getPrePayDate()));
            la.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
            la.setSrcno(entity.getSrcno());

            //发起流程
            String formInstance = workFlowBean.buildXmlForEFGP("HZ_CW017", la, null);
            String subject = la.getHdnloanUser() + "申请借支";
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HZ_CW017", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2) {
                return new MCResponseData(Integer.valueOf(rm[0]), rm[1]);
            } else {
                return new MCResponseData(200, "Code=200");
            }
        } catch (Exception ex) {
            return new MCResponseData(500, "系统错误更新失败");
        }
    }

    public MCResponseData checkBeforeSend(MCHZCW017 mc) {
        int code = MessageEnum.Failue_101.getCode();
        String msg = MessageEnum.Failue_101.getMsg();
        try {
            //判断token 是否有效
            if (mc == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!mc.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            Date date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); //日期
            String period = BaseLib.formatDate("yyyyMM", date);
            String srcno = mc.getSrcno();
            if (srcno == null || srcno.isEmpty()) {
                code = 107;
                msg = "来源单号不能为空";
                return new MCResponseData(code, msg);
            }
            String facno = mc.getFacno();
            if (null == comanyBean.findByCompany(facno)) {
                code = 107;
                msg = "传入公司别数据无效";
                return new MCResponseData(code, msg);
            }
            String loanUser = mc.getLoanUser();
            Users u = usersBean.findById(loanUser);
            if (null == u || u.getLeaveDate() != null) {
                code = 107;
                msg = "传入申请人数据无效";
                return new MCResponseData(code, msg);
            }
            String coin = mc.getCoin();
            if (null == miscodeBean.findByPK("GA", coin)) {
                code = 107;
                msg = "传入币别数据无效";
                return new MCResponseData(code, msg);
            }
            String regex = "^(([1-9]\\d*)|\\d)(\\.\\d+)?$"; //正浮点数匹配
            double loanTotal = mc.getLoanTotal();
            if (!String.valueOf(loanTotal).matches(regex) || loanTotal == 0.00) {
                code = 107;
                msg = "借款金额格式错误";
                return new MCResponseData(code, msg);
            }
            String budgetDept = mc.getLoanDept();
            if (null == workFlowBean.findOrgUnitByDeptno(budgetDept)) {
                code = 107;
                msg = "预算部门错误";
                return new MCResponseData(code, msg);
            }
            String centerid = mc.getCenterid();
            BudgetCenter bc = budgetCenterBean.findByDeptid(budgetDept);
            if (null == bc) {
                code = 107;
                msg = "预算部门无责任中心";
                return new MCResponseData(code, msg);
            } else {
                if (!centerid.endsWith(bc.getBudgetCenterPK().getCenterid())) {
                    code = 107;
                    msg = "预算部门对应责任中心错误";
                    return new MCResponseData(code, msg);
                }
            }
            String preAcc = mc.getPreAccno();
            if (null == budgetDetailBean.findBudgetDetail(facno, period, centerid, preAcc)) {
                code = 107;
                msg = "ERP无对应预算方案";
                return new MCResponseData(code, msg);
            }
            String reason = mc.getReason();
            if (reason == null || reason.isEmpty()) {
                code = 107;
                msg = "借支理由不能为空";
                return new MCResponseData(code, msg);
            }
            //检验部门期间余额
            BudgetCenter budgetCenter = budgetCenterBean.findByDeptid(mc.getLoanDept());
            double depp = budgetDetailBean.getBudgetBalanceForDeptPeriod(facno, date, budgetCenter.getBudgetCenterPK().getCenterid());
            if (depp <= 0.00) {
                code = 110;
                msg = "部门期间余额小于零不能申请";
                return new MCResponseData(code, msg);
            }

            return new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            log4j.error(e.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

}
