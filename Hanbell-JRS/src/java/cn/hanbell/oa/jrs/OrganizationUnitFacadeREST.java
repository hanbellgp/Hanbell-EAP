/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.OrganizationUnitBean;
import cn.hanbell.oa.entity.OrganizationUnit;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author C0160
 */
@Path("efgp/organizationunit")
@javax.enterprise.context.RequestScoped
public class OrganizationUnitFacadeREST extends SuperRESTForEFGP<OrganizationUnit> {

    @EJB
    private OrganizationUnitBean organizationUnitBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return organizationUnitBean;
    }

    public OrganizationUnitFacadeREST() {
        super(OrganizationUnit.class);
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}/size")
    @Produces({MediaType.APPLICATION_JSON})
    public OrganizationUnitResponseResult findByFiltersWithSize(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        data = super.findWithSize(filters, sorts, offset, pageSize, appid, token);
        OrganizationUnitResponseResult r = new OrganizationUnitResponseResult();
        for (Map.Entry<Integer, List<OrganizationUnit>> entrySet : data.entrySet()) {
            r.setSize(entrySet.getKey());
            r.setResult(entrySet.getValue());
        }
        return r;
    }

}
