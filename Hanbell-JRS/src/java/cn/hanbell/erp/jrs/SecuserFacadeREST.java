/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.SecuserBean;
import cn.hanbell.erp.entity.Secuser;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("shberp/secuser")
@javax.enterprise.context.RequestScoped
public class SecuserFacadeREST extends SuperRESTForERP<Secuser> {

    @Inject
    private SecuserBean secuserBean;

    @Override
    protected SuperEJBForERP getERPEJB() {
        company = "C";
        return secuserBean;
    }

    public SecuserFacadeREST() {
        super(Secuser.class);
    }

    @PUT
    @Path("{id}/{opwd}/{npwd}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage edit(@PathParam("id") String id, @PathParam("opwd") String opwd, @PathParam("npwd") String npwd, Secuser entity) {
        try {
            Secuser u = secuserBean.findByUsernoAndPwd(id, opwd);
            if (u != null) {
                u.setSigntext(npwd);
                secuserBean.update(u);
            } else {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return new ResponseMessage("200", "更新成功");
        } catch (Exception e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path("single/{id}/{pwd}")
    @Produces({"application/json"})
    public Secuser findByUsernoAndPwd(@PathParam("id") String id, @PathParam("pwd") String pwd) {
        Secuser u = secuserBean.findByUsernoAndPwd(id, pwd);
        if (u != null) {
            return u;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("LDAP/single/{id}/{pwd}")
    @Produces({"application/json"})
    public Secuser findByLDAPAccount(@PathParam("id") String id, @PathParam("pwd") String pwd) {
        try {
            if (BaseLib.ADAuth("172.16.10.6:389", id + "@hanbell.com.cn", pwd)) {
                Secuser u = secuserBean.findByUserno(id);
                if (u != null) {
                    return u;
                } else {
                    throw new WebApplicationException(Response.Status.NOT_FOUND);
                }
            }
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

}
