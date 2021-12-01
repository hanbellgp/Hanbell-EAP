/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCBudget;
import cn.hanbell.costctrl.app.MCBudgetDetail;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.crm.ejb.SALFIBean;
import cn.hanbell.crm.entity.SALFI;
import cn.hanbell.eap.ejb.McbudgetBean;
import cn.hanbell.eap.entity.Mcbudget;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.BudgetDetailBean;
import cn.hanbell.erp.entity.BudgetDetail;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.entity.HZCW017;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrator
 */
@Path("costctrl/budgetdetail")
@javax.enterprise.context.RequestScoped
public class BudgetDetailFacadeREST extends SuperRESTForERP<BudgetDetail> {

    @EJB
    private BudgetDetailBean budgetDetailBean;
    @EJB
    private McbudgetBean mcbudgetBean;
    @EJB
    private HZCW017Bean hzcw017Bean;
    @EJB
    private SALFIBean salfiBean;

    public BudgetDetailFacadeREST() {
        super(BudgetDetail.class);
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return budgetDetailBean;
    }

    @POST
    @Path("addbudget")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData createByFeiKong(MCBudget entity) {
        try {
            //判断token 是否有效
            if (entity == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            String type = entity.getType();
            if (type == null || !("HZCW028".equals(type) || "HZCW033".equals(type))) {
                return new MCResponseData(107, "单据类型错误");
            }
            String srcno = entity.getSrcno();
            String crmno = entity.getCrmno() == null ? "" : entity.getCrmno();
            String crmtype = entity.getCrmtype() == null ? "" : entity.getCrmtype();
            String loanNo = entity.getLoanNo();
            if (srcno == null || "".equals(srcno)) {
                return new MCResponseData(107, "来源费控单号不能为空");
            }
            if ("HZCW033".equals(type)) {
                if (loanNo == null || "".equals(loanNo)) {
                    return new MCResponseData(107, "借款归还类别借支单单号不能为空");
                }
            }
            List<BudgetDetail> budgetDetails = new ArrayList<>();;
            List<MCBudgetDetail> resultList = entity.getBudgetList();
            if (!resultList.isEmpty()) {
                final String facno = resultList.get(0).getFacno();
                resultList.forEach((MCBudgetDetail e) -> {
                    int index = resultList.indexOf(e);
                    budgetDetails.add(new BudgetDetail(facno, "", e.getPeriod(), e.getCenterid(), e.getBudgetacc(), "R", index, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, e.getPreamts()));
                    Mcbudget mcbudget = new Mcbudget(type, srcno, facno, e.getPeriod(), e.getCenterid(), e.getBudgetacc(), e.getPreamts());
                    mcbudget.setCrmno(crmno);
                    mcbudget.setCrmtype(crmtype);
                    mcbudget.setLoanNo(loanNo);
                    mcbudgetBean.persist(mcbudget);
                    //更新CRM状态
                    if (crmtype.isEmpty()) {
                        //营业报销锁定//服务可以重发填写单身
                        SALFI salfi = salfiBean.findByPK(crmno);
                        if (salfi != null) {
                            salfi.setFi018("Y");
                            salfiBean.update(salfi);
                        }
                    }

                    if ("HZCW033".equals(type)) {
                        //改变借支单科目预扣
                        try {
                            BudgetDetail u1;
                            HZCW017 jz = hzcw017Bean.findByPSN(loanNo);
                            if (null != jz) {
                                Date date1 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", jz.getLoanDate())); //借支单日期
                                String period1 = BaseLib.formatDate("yyyyMM", date1);
                                if (e.getPreamts().doubleValue() <= jz.getTotalRMB()) {
                                    u1 = new BudgetDetail(jz.getFacno(), "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(e.getPreamts()));
                                } else {
                                    u1 = new BudgetDetail(jz.getFacno(), "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(BigDecimal.valueOf(jz.getTotalRMB())));
                                }
                                budgetDetails.add(u1);
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(BudgetDetailFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                            throw new NullPointerException("处理借支单预算失败");
                        }
                    }

                });
                budgetDetailBean.setCompany(facno);
                budgetDetailBean.add(budgetDetails);
                //budgetDetailBean.getEntityManager().flush();

            }

        } catch (RuntimeException ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
        return new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());

    }

    @POST
    @Path("rebudget")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData rollbackByFeiKong(MCBudget entity) {
        try {
            if (entity == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            String srcno = entity.getSrcno();
            if (srcno == null || "".equals(srcno)) {
                return new MCResponseData(107, "来源费控单号不能为空");
            }
            List<Mcbudget> mcbudgets = mcbudgetBean.findBySrcno(srcno);
            if (!mcbudgets.isEmpty()) {

//                String type = mcbudgets.get(0).getType();
//                String loanNo = mcbudgets.get(0).getLoanNo();
//                List<BudgetDetail> budgetDetails = new ArrayList<>();;
//                List<MCBudgetDetail> resultList = entity.getBudgetList();
//                if (!resultList.isEmpty()) {
//                    final String facno = resultList.get(0).getFacno();
//                    resultList.forEach((MCBudgetDetail e) -> {
//                        int index = resultList.indexOf(e);
//                        budgetDetails.add(new BudgetDetail(facno, "", e.getPeriod(), e.getCenterid(), e.getBudgetacc(), "R", index, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, e.getPreamts()));
//                        if ("HZCW033".equals(type)) {
//                            //改变借支单科目预扣
//                            try {
//                                BudgetDetail u1;
//                                HZCW017 jz = hzcw017Bean.findByPSN(loanNo);
//                                if (null != jz) {
//                                    Date date1 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", jz.getLoanDate())); //借支单日期
//                                    String period1 = BaseLib.formatDate("yyyyMM", date1);
//
//                                    if (e.getPreamts().doubleValue() <= jz.getTotalRMB()) {
//                                        u1 = new BudgetDetail(jz.getFacno(), "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(e.getPreamts()));
//                                    } else {
//                                        u1 = new BudgetDetail(jz.getFacno(), "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(BigDecimal.valueOf(jz.getTotalRMB())));
//                                    }
//                                    budgetDetails.add(u1);
//                                }
//                            } catch (ParseException ex) {
//                                Logger.getLogger(BudgetDetailFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
//                                throw new NullPointerException("处理借支单预算失败");
//                            }
//                        }
//
//                    });
//                    budgetDetailBean.setCompany(facno);
//                    budgetDetailBean.subtract(budgetDetails);
//                }
                mcbudgets.forEach((Mcbudget mcb) -> {
                    String type = mcb.getType();
                    String loanNo = mcb.getLoanNo();
                    List<BudgetDetail> budgetDetails = new ArrayList<>();;
                    String facno = mcb.getFacno();
                    int index = mcbudgets.indexOf(mcb);
                    budgetDetails.add(new BudgetDetail(facno, "", mcb.getPeriod(), mcb.getCenterid(), mcb.getBudgetacc(), "R", index, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, mcb.getPreamts()));
                    if ("HZCW033".equals(type)) {
                        //改变借支单科目预扣
                        try {
                            BudgetDetail u1;
                            HZCW017 jz = hzcw017Bean.findByPSN(loanNo);
                            if (null != jz) {
                                Date date1 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", jz.getLoanDate())); //借支单日期
                                String period1 = BaseLib.formatDate("yyyyMM", date1);

                                if (mcb.getPreamts().doubleValue() <= jz.getTotalRMB()) {
                                    u1 = new BudgetDetail(jz.getFacno(), "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(mcb.getPreamts()));
                                } else {
                                    u1 = new BudgetDetail(jz.getFacno(), "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(BigDecimal.valueOf(jz.getTotalRMB())));
                                }
                                budgetDetails.add(u1);
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(BudgetDetailFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                            throw new NullPointerException("处理借支单预算失败");
                        }
                    }

                    budgetDetailBean.setCompany(facno);
                    budgetDetailBean.subtract(budgetDetails);

                    //更新CRM状态
                    if (mcb.getCrmtype().isEmpty()) {
                        SALFI salfi = salfiBean.findByPK(mcb.getCrmno());
                        //营业报销释放
                        if (salfi != null) {
                            salfi.setFi018("N");
                            salfiBean.update(salfi);
                        }
                    }
                    mcbudgetBean.delete(mcb);
                });

            } else {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }

        } catch (RuntimeException ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
        return new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());

    }

}
