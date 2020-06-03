/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.DFWELBean;
import cn.hanbell.crm.entity.DFWEL;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author C2082
 */
@Path("crm/dfwel")
@javax.enterprise.context.RequestScoped
public class DFWELFacadeREST extends SuperRESTForCRM<DFWEL> {

    @EJB
    private DFWELBean dfwelbaean;

    public DFWELFacadeREST() {
        super(DFWEL.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("wechat/product")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<DFWEL> findProduct(@QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<DFWEL> list = dfwelbaean.findAll();
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            ResponseData responseData = new ResponseData("200", "seccess");
            List<JSONObject> objs = new ArrayList<>();
            JSONObject js = null;
            for (DFWEL d : list) {
                js = new JSONObject();
                js.put("key", d.getEl001());
                js.put("value", d.getEl002());
                objs.add(js);
            }
            responseData.setData(objs);
            responseData.setCount(objs.size());
            return responseData;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
