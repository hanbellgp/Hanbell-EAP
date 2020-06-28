/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author C0160
 */
@Path("shberp/cdrcus")
@javax.enterprise.context.RequestScoped
public class CdrcusFacadeREST extends SuperRESTForERP<Cdrcus> {

    @Inject
    private CdrcusBean cdrcusBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return cdrcusBean;
    }

    public CdrcusFacadeREST() {
        super(Cdrcus.class);
    }

    @GET
    @Path("list/{man}")
    @Produces({"application/json"})
    public List<Cdrcus> findByMan(@PathParam("man") String man) {
        return cdrcusBean.findByMan(man);
    }

    @GET
    @Path("list/{query}/{offset}/{pageSize}")
    @Produces({"application/json"})
    public List<Cdrcus> findByManAndFilters(@PathParam("query") PathSegment queryFilters, @PathParam("offset") int offset, @PathParam("pageSize") int pageSize) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("man", queryFilters.getPath());
        MultivaluedMap<String, String> mv = queryFilters.getMatrixParameters();
        if (mv != null && !mv.isEmpty()) {
            for (Map.Entry<String, List<String>> entrySet : mv.entrySet()) {
                filters.put(entrySet.getKey(), entrySet.getValue().get(0));
            }
        }
        return cdrcusBean.findByMan(filters, offset, pageSize);
    }

}
