/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.erp.ejb.BudgetDetailBean;
import cn.hanbell.erp.ejb.MisrateBean;
import cn.hanbell.erp.entity.Misrate;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperREST;
import cn.hanbell.oa.app.LoanApplication;
import cn.hanbell.oa.app.MCHZCW017;
import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.entity.HZCW017;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.model.HZCW017Model;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("efgp/hzcw017")
@javax.enterprise.context.RequestScoped
public class HZCW017FacadeREST extends SuperREST<HZCW017> {

    @EJB
    private WorkFlowBean workFlowBean;
    @EJB
    private HZCW017Bean hzcw017Bean;
    @EJB
    private MisrateBean misrateBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;

    @Override
    protected SuperEJB getSuperEJB() {
        return hzcw017Bean;
    }

    public HZCW017FacadeREST() {
        super(HZCW017.class);
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(LoanApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            //检查申请人是否重复借款
            if (hzcw017Bean.checkArrears(entity.getLoanUser())) {
                return new ResponseMessage("500", "有借款未还不能再发起借支申请，系统错误更新失败");
            }
            try {
                //初始化发起人
                workFlowBean.initUserInfo(entity.getLoanUser());
                //实例化对象
                HZCW017Model la = new HZCW017Model();
                la.setFacno(entity.getCompany().split("-")[0]);
                //la.setHdnfacno(entity.getCompany().split("-")[1]);
                la.setLoanDate(BaseLib.getDate("yyyy-MM-dd", entity.getLoanDate()));
                la.setLoanUser(workFlowBean.getCurrentUser().getId());
                la.setHdnloanUser(workFlowBean.getCurrentUser().getUserName());
                OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getLoanDept());
                if (ou == null) {
                    throw new NullPointerException(entity.getLoanDept() + "不存在");
                }
                la.setLoanDept(ou.getId());
                la.setHdnloanDept(ou.getOrganizationUnitName());
                la.setLoanProperty(entity.getLoanproperty());
                la.setHdnloanProperty(entity.getLoanpropertyDesc());
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
                la.setPreAccno(entity.getPreAccno().split("-")[0]);
                la.setPreAccname(entity.getPreAccno().split("-")[1]);
                la.setArrears(entity.getLoanTotal());
                la.setProduct("R");
                la.setPrePayDate(BaseLib.getDate("yyyy-MM-dd", entity.getPrePayDate()));
                la.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());

                //发起流程
                String formInstance = workFlowBean.buildXmlForEFGP("HZ_CW017", la, null);
                String subject = la.getHdnloanUser() + "申请借支";
                String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HZ_CW017", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    return new ResponseMessage(rm[0], rm[1]);
                } else {
                    return new ResponseMessage("200", "Code=200");
                }
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(MCHZCW017 entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (entity == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        //检查申请人是否重复借款
        if (hzcw017Bean.checkArrears(entity.getLoanUser())) {
            return new ResponseMessage("500", "有借款未还不能再发起借支申请，系统错误更新失败");
        }
        try {
            //初始化发起人
            workFlowBean.initUserInfo(entity.getLoanUser());
            //实例化对象
            HZCW017Model la = new HZCW017Model();
            la.setFacno(entity.getCompany().split("-")[0]);
            la.setHdnfacno(entity.getCompany().split("-")[1]);
            la.setLoanDate(BaseLib.getDate());
            la.setLoanUser(workFlowBean.getCurrentUser().getId());
            la.setHdnloanUser(workFlowBean.getCurrentUser().getUserName());
            OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getLoanDept());
            if (ou == null) {
                throw new NullPointerException(entity.getLoanDept() + "不存在");
            }
            la.setLoanDept(ou.getId());
            la.setHdnloanDept(ou.getOrganizationUnitName());
            //根据部门编号代出公司编号
            la.setLoanProperty(entity.getLoanproperty());
            la.setHdnloanProperty(entity.getLoanpropertyDesc());
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
            la.setPreAccno(entity.getPreAccno().split("-")[0]);
            la.setPreAccname(entity.getPreAccno().split("-")[1]);
            la.setArrears(entity.getLoanTotal());
            la.setProduct("R");
            la.setPrePayDate(BaseLib.getDate("yyyy/MM/dd", entity.getPrePayDate()));
            la.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());

            //发起流程
            String formInstance = workFlowBean.buildXmlForEFGP("HZ_CW017", la, null);
            String subject = la.getHdnloanUser() + "申请借支";
            String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HZ_CW017", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2) {
                return new ResponseMessage(rm[0], rm[1]);
            } else {
                return new ResponseMessage("200", "Code=200");
            }
        } catch (Exception ex) {
            return new ResponseMessage("500", "系统错误更新失败");
        }
    }

}
