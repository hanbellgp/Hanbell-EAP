/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ItemModelBean;
import cn.hanbell.erp.entity.ItemModel;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.SuperEJB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.Query;
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
@Path("shberp/itemmodel")
@javax.enterprise.context.RequestScoped
public class ItemModelFacadeREST extends SuperRESTForERP<ItemModel> {

    @Inject
    private ItemModelBean itemModelBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return itemModelBean;
    }

    public ItemModelFacadeREST() {
        super(ItemModel.class);
    }

    @GET
    @Path("{model}")
    @Produces({"application/xml", "application/json"})
    public ItemModel findById(@PathParam("model") PathSegment model) {
        Query query = itemModelBean.getEntityManager().createNativeQuery("SELECT cmcmodel,itnbr FROM cdrdmmodel WHERE cmcmodel = '" + model.getPath() + "' ORDER BY cmcmodel ");
        Object[] row = (Object[]) query.getSingleResult();
        ItemModel newEntity = new ItemModel(row[0].toString(), row[1].toString());
        return newEntity;
    }

    @GET
    @Path("kind/{query}")
    @Produces({"application/json"})
    public List<ItemModel> findByKind(@PathParam("query") PathSegment queryFilters) {
        MultivaluedMap<String, String> mv = queryFilters.getMatrixParameters();
        if (mv == null || mv.isEmpty()) {
            return itemModelBean.findByKind(queryFilters.getPath(), null);
        } else {
            Map<String, Object> filters = new HashMap<>();
            for (Map.Entry<String, List<String>> entrySet : mv.entrySet()) {
                filters.put(entrySet.getKey(), entrySet.getValue().get(0));
            }
            return itemModelBean.findByKind(queryFilters.getPath(), filters);
        }
    }

    @GET
    @Path("kind/{query}/{offset}/{pageSize}")
    @Produces({"application/json"})
    public List<ItemModel> findByKind(@PathParam("query") PathSegment queryFilters, @PathParam("offset") int offset, @PathParam("pageSize") int pageSize) {
        MultivaluedMap<String, String> mv = queryFilters.getMatrixParameters();
        if (mv == null || mv.isEmpty()) {
            return itemModelBean.findByKind(queryFilters.getPath(), null, offset, pageSize);
        } else {
            Map<String, Object> filters = new HashMap<>();
            for (Map.Entry<String, List<String>> entrySet : mv.entrySet()) {
                filters.put(entrySet.getKey(), entrySet.getValue().get(0));
            }
            return itemModelBean.findByKind(queryFilters.getPath(), filters, offset, pageSize);
        }
    }

}
