/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.FunctionsBean;
import cn.hanbell.oa.entity.Functions;
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
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("efgp/functions")
@javax.enterprise.context.RequestScoped
public class FunctionsFacadeREST extends SuperRESTForEFGP<Functions> {

    @EJB
    private FunctionsBean funtionsBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return funtionsBean;
    }

    public FunctionsFacadeREST() {
        super(Functions.class);
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}/size")
    @Produces({MediaType.APPLICATION_JSON})
    public FunctionsResponseResult findByFiltersWithSize(@PathParam("filters") PathSegment filters,
            @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset,
            @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            data = super.find(filters, sorts, offset, pageSize);
            FunctionsResponseResult r = new FunctionsResponseResult();
            for (Map.Entry<Integer, List<Functions>> entrySet : data.entrySet()) {
                r.setSize(entrySet.getKey());
                r.setResult(entrySet.getValue());
            }
            return r;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}

class FunctionsResponseResult {

    private Integer size;
    private List<Functions> result;

    public FunctionsResponseResult() {

    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the result
     */
    public List<Functions> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<Functions> result) {
        this.result = result;
    }

}
