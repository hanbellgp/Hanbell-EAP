/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.BudgetCenterAccDetailBean;
import cn.hanbell.erp.entity.BudgetCenterAccDetail;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C1491
 */
@Path("erp/budgetcenteracc")
@javax.enterprise.context.RequestScoped
public class BudgetCenterAccFacadeREST extends SuperRESTForERP<BudgetCenterAccDetail> {

    @EJB
    private BudgetCenterAccDetailBean budgetCenterAccDetailBean;

    public BudgetCenterAccFacadeREST() {
        super(BudgetCenterAccDetail.class);
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return budgetCenterAccDetailBean;
    }

//    @GET
//    @Path("{filters}/{sorts}/{offset}/{pageSize}/size")
//    @Produces({MediaType.APPLICATION_JSON})
//   public BudgetAccnoResponseResult findByOrganizationUnitId(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public List<BudgetCenterAccDetail> findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                budgetCenterAccDetailBean.setCompany(filterFields.get("budgetcenteraccdetailPK.facno").toString());
                return budgetCenterAccDetailBean.findByFilters(filterFields, offset, pageSize, sortFields);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
