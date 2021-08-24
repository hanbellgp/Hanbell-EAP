/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.NianjiaBean;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForERP;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author C2082
 */
@Path("shberp/nianjia")
@javax.enterprise.context.RequestScoped
public class NianjiaFacadeREST extends SuperRESTForERP<Object> {

    @EJB
    private NianjiaBean nianjiaBean;

    public NianjiaFacadeREST() {
        super(Object.class);
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return nianjiaBean;
    }

    @GET
    @Path("{employeeid}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject findProductType(@PathParam("employeeid") String employeeid, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                BigDecimal count = nianjiaBean.getLeftYearDays(employeeid);
                ResponseObject responseObj = new ResponseObject("200", "seccess");
                responseObj.setObject(count);
                return responseObj;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }

        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
