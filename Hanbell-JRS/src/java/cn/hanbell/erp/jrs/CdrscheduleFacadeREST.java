/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.CdrscheduleBean;
import cn.hanbell.erp.entity.Cdrschedule;
import cn.hanbell.erp.entity.CdrschedulePK;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Stateless
@Path("shberp/cdrschedule")
public class CdrscheduleFacadeREST extends SuperRESTForERP<Cdrschedule> {

    @Inject
    private CdrscheduleBean cdrscheduleBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return cdrscheduleBean;
    }

    public CdrscheduleFacadeREST() {
        super(Cdrschedule.class);
    }

    private CdrschedulePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;facno=facnoValue;cdrno=cdrnoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        CdrschedulePK key = new CdrschedulePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> facno = map.get("facno");
        if (facno != null && !facno.isEmpty()) {
            key.setFacno(facno.get(0));
        }
        java.util.List<String> cdrno = map.get("cdrno");
        if (cdrno != null && !cdrno.isEmpty()) {
            key.setCdrno(cdrno.get(0));
        }
        return key;
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Cdrschedule findById(@PathParam("id") PathSegment id) {
        HashMap<String, Object> filters = new HashMap<>();
        javax.ws.rs.core.MultivaluedMap<String, String> map = id.getMatrixParameters();
        java.util.List<String> facno = map.get("facno");
        java.util.List<String> cdrno = map.get("cdrno");
        if (facno != null && !facno.isEmpty() && cdrno != null && !cdrno.isEmpty()) {
            return cdrscheduleBean.findByPK(facno.get(0), cdrno.get(0));
        }
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    //QueryParam
    @GET
    @Path("list/{cusno}/{filter}")
    @Produces({"application/json"})
    public List<Cdrschedule> findByCustomer(@PathParam("cusno") String cusno, @PathParam("filter") PathSegment filter) {
        String key, value, state;
        state = filter.getPath();
        MultivaluedMap<String, String> mm = filter.getMatrixParameters();
        Map<String, Object> filters = new HashMap<>();
        for (Map.Entry<String, List<String>> entrySet : mm.entrySet()) {
            key = entrySet.getKey();
            if (entrySet.getValue() != null) {
                value = entrySet.getValue().get(0);
            } else {
                value = "";
            }
            filters.put(key, value);
        }
        return cdrscheduleBean.findByCustomerAndStatusAndFilters(cusno, state, filters);
    }

}
