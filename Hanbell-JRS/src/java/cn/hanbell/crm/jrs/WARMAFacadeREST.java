/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.WARMABean;
import cn.hanbell.crm.entity.WARMA;
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
 *
 * @author C2082
 */
@Path("crm/warma")
@javax.enterprise.context.RequestScoped
public class WARMAFacadeREST extends SuperRESTForCRM<WARMA> {

    @EJB
    private WARMABean warmaBean;

    public WARMAFacadeREST() {
        super(WARMA.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
      return warmaBean;
    }

    /**
     * 产品类型开窗
     *
     * @param MA003
     * @param appid
     * @param token
     * @return
     */
    @GET
    @Path("producttype/")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findProductType(@QueryParam("searchWord") String MA003, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object[]> list = warmaBean.findProductType(MA003);
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

    /**
     * 品号开窗
     * 
     * @param MB002
     * @param appid
     * @param token
     * @return 
     */
    @GET
    @Path("productquality")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findProductQuality(@QueryParam("searchWord") String MB002, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object[]> list = warmaBean.findProductQuality(MB002);
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            List<JSONObject> objs = new ArrayList<>();
            JSONObject js = null;
            for (int i = 0; i < list.size(); i++) {
                js = new JSONObject();
                js.put("MB001", list.get(i)[0]);//品号
                js.put("MB002", list.get(i)[1]);//品名
                js.put("MA003", list.get(i)[2]);//规格
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
