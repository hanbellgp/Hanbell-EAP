/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.DSHBean;
import cn.hanbell.crm.entity.DSH;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 获得省、市
 *
 * @author Administrator
 */
@Path("crm/dsh")
@javax.enterprise.context.RequestScoped
public class DSHFacadeREST extends SuperRESTForCRM<DSH> {

    @EJB
    private DSHBean dshBean;

    public DSHFacadeREST() {
        super(DSH.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return dshBean;
    }

    @GET
    @Path("wechat/incidentProvince")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findIncidentArea(@QueryParam("searchWord") String provincename,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object[]> list = dshBean.findIncidentArea(provincename);
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            List<JSONObject> objs = new ArrayList<>();
            JSONObject js = null;
            for (int i = 0; i < list.size(); i++) {
                js = new JSONObject();
                js.put("key", list.get(i)[0]);
                js.put("value", list.get(i)[1]);
                objs.add(js);
            }
            ResponseData responseData = new ResponseData("200", "seccess");
            responseData.setData(objs);
            responseData.setCount(objs.size());
            return responseData;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
