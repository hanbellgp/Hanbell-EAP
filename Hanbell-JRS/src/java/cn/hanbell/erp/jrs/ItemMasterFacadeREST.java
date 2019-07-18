/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ItemMasterBean;
import cn.hanbell.erp.entity.ItemMaster;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.SuperEJB;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author C0160
 */
@Path("shberp/servitemmaster")
@javax.enterprise.context.RequestScoped
public class ItemMasterFacadeREST extends SuperRESTForERP<ItemMaster> {

    @Inject
    private ItemMasterBean itemMasterBean;

    @Override
    protected SuperEJBForERP getERPEJB() {
        company = "C";
        return itemMasterBean;
    }

    public ItemMasterFacadeREST() {
        super(ItemMaster.class);
    }

    @GET
    @Path("list/{query}/{offset}/{pageSize}")
    @Produces({"application/json"})
    public List<ItemMaster> findByCategory(@PathParam("query") PathSegment queryFilters, @PathParam("offset") int offset, @PathParam("pageSize") int pageSize) {
        return itemMasterBean.findByCategory(queryFilters.getPath(), offset, pageSize);
    }

//    @GET
//    @Path("{model}/{category}/{offset}/{pageSize}")
//    @Produces({"application/json"})
//    public List<ItemMaster> findByModelAndCategory(@PathParam("model") String model, @PathParam("category") String category, @PathParam("offset") int offset, @PathParam("pageSize") int pageSize) {
//        return itemMasterBean.findByModelAndCategory(model, category, offset, pageSize);
//    }

}
