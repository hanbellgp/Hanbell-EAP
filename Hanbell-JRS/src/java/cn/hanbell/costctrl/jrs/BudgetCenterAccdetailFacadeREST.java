/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCBudgetCenterAccdetail;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.costctrl.app.RequestBody;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.BudgetCenterAccDetailBean;
import cn.hanbell.erp.entity.BudgetCenterAccDetail;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("costctrl/budgetcenteraccdetail")
@javax.enterprise.context.RequestScoped
public class BudgetCenterAccdetailFacadeREST extends SuperRESTForERP<BudgetCenterAccDetail> {

    @EJB
    private BudgetCenterAccDetailBean budgetCenterAccDetailBean;
    @EJB
    private CompanyBean companyBean;

    public BudgetCenterAccdetailFacadeREST() {
        super(BudgetCenterAccDetail.class);
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return budgetCenterAccDetailBean;
    }

    @POST
    @Path("get")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData findAll(RequestBody entity) {
        try {
            //判断token 是否有效
            if (entity == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            if (!entity.checkRequestParams()) {
                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
            }
            String facno = entity.getFacno();
            if (null == companyBean.findByCompany(facno)) {
                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
            }
            int page_index = entity.getPage_index();
            int page_size = entity.getPage_size();
            int first = (page_index - 1) * page_size;
            List<BudgetCenterAccDetail> budgetcenteraccList;
            String centerid = entity.getCenterId();
            budgetCenterAccDetailBean.setCompany(facno);
            HashMap<String, Object> filters = new HashMap<String, Object>();
            if (centerid != null && !centerid.isEmpty()) {
                filters.put("budgetcenteraccdetailPK.centerid", centerid);
            }else{
                //责任中心必填
                 return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
            }
//            if (!centerid.isEmpty()) {
//                budgetcenteraccList = budgetcenteraccList.stream().filter(b -> b.getBudgetCenterAccDetailPK().getCenterid() == centerid).collect(Collectors.toList());
//            }
            //加入科目和科目名称模糊查询
            String budgetacc = entity.getBudgetAcc();
            if (budgetacc != null && !budgetacc.isEmpty()) {
                filters.put("budgetcenteraccdetailPK.budgetacc", budgetacc);
            }
            String accName = entity.getAccName();
            if (accName != null && !accName.isEmpty()) {
                filters.put("budgetAccount.accname", accName);
            }
            int hasMore = 0;
            int totalCount = budgetCenterAccDetailBean.getRowCount(filters);
            budgetcenteraccList = budgetCenterAccDetailBean.findByFilters(filters, first, page_size);
            List<MCBudgetCenterAccdetail> bacclist = new ArrayList<>();
            if (!budgetcenteraccList.isEmpty()) {
                budgetcenteraccList.forEach((BudgetCenterAccDetail m) -> {
                    MCBudgetCenterAccdetail mbacc = new MCBudgetCenterAccdetail();
                    mbacc.setFacno(m.getBudgetCenterAccDetailPK().getFacno());
                    mbacc.setCenterId(m.getBudgetCenterAccDetailPK().getCenterid());
                    mbacc.setBudgetAcc(m.getBudgetCenterAccDetailPK().getBudgetacc());
                    mbacc.setAccName(m.getBudgetAccount().getAccname());
                    bacclist.add(mbacc);
                });
            }
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            if (page_index * page_size < totalCount) {
                hasMore = 1;
            }
            JSONObject js = new JSONObject();
            js.put("has_more", hasMore);
            js.put("total_count", totalCount);
            js.put("items", bacclist);
            res.setData(js);
            return res;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

}
