/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCBudgetCenter;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.costctrl.app.RequestBody;
import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.BudgetCenterBean;
import cn.hanbell.erp.entity.BudgetCenter;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrator
 */
@Path("costctrl/mcbudgetcenter")
@javax.enterprise.context.RequestScoped
public class BudgetcenterFacadeREST extends SuperRESTForERP<BudgetCenter> {

    @EJB
    private BudgetCenterBean budgetCenterBean;
    @EJB
    private CompanyBean companyBean;

    public BudgetcenterFacadeREST() {
        super(BudgetCenter.class);
    }

    @POST
    @Path("get")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData findAll(RequestBody entity) {
        try {
            //判断token 是否有效
            if (entity == null || entity.getFacno() == null || entity.getFacno().equals("") || entity.getPage_index() < 0 || entity.getPage_size() < 0) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
//            if (!entity.checkRequestParams()) {
//                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
//            }
            List<BudgetCenter> budgetcenterList;
            String facno = entity.getFacno();
            if (null == companyBean.findByCompany(facno)) {
                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
            }
            budgetCenterBean.setCompany(facno);
            budgetcenterList = budgetCenterBean.findAll();
            String deptid = entity.getDeptId();
            String deptName = entity.getDeptName();
            if (deptid != null && !deptid.isEmpty()) {
                //budgetcenterList = budgetcenterList.stream().filter(b -> b.getBudgetCenterPK().getDeptid().equals(deptid)).collect(Collectors.toList());
                budgetcenterList = budgetcenterList.stream().filter(b -> b.getBudgetCenterPK().getDeptid().contains(deptid)).collect(Collectors.toList());
            }
            //加入部门模糊查询
            if (deptName != null && !deptName.isEmpty()) {
                budgetcenterList = budgetcenterList.stream().filter(b -> b.getDeptname().contains(deptName)).collect(Collectors.toList());
            }
            List<MCBudgetCenter> bclist = new ArrayList<>();
            if (!budgetcenterList.isEmpty()) {
                //加入去重（不同产品别）
                String deptString = "";
                for (BudgetCenter m : budgetcenterList) {
                    if (!deptString.contains(m.getBudgetCenterPK().getDeptid())) {
                        MCBudgetCenter mbc = new MCBudgetCenter();
                        mbc.setFacno(m.getBudgetCenterPK().getFacno());
                        mbc.setCenterId(m.getBudgetCenterPK().getCenterid());
                        mbc.setDeptId(m.getBudgetCenterPK().getDeptid());
                        mbc.setDeptName(m.getDeptname());
                        bclist.add(mbc);
                        deptString += mbc.getDeptId() + ";";
                    }
                };
            }
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            res.setData(bclist);
            return res;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return budgetCenterBean;
    }

}
