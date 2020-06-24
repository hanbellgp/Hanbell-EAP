/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.REPMQBean;
import cn.hanbell.crm.ejb.REPMUBean;
import cn.hanbell.crm.entity.REPMQ;
import cn.hanbell.crm.entity.REPMU;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
import java.util.HashMap;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author Administrator
 */
@Path("crm/repmq")
@javax.enterprise.context.RequestScoped
public class REPMQFacadeREST extends SuperRESTForCRM<REPMQ> {

    @EJB
    private REPMQBean repmqBean;
    @EJB
    private REPMUBean repmuBean;

    public REPMQFacadeREST() {
        super(REPMQ.class);
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public ResponseData findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<REPMQ> repmqList;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                repmqList = repmqBean.findByFilters(filterFields, offset, pageSize, sortFields);
                ResponseData responseData = new ResponseData("200", "seccess");
                responseData.setData(repmqList);
                responseData.setCount(repmqList.size());
                return responseData;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    protected SuperEJB getSuperEJB() {
       return repmqBean;
    }

    /**
     * 客诉单别
     *
     * @param appid
     * @param token
     * @return
     */
    @GET
    @Path("form")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findForm(@QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object[]> list = repmqBean.findForm();
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
     * 维修单别
     *
     * @param employeeId
     * @param appid
     * @param token
     * @return
     */
    @GET
    @Path("maintainform/{employeeId}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findMaintainForm(@PathParam("employeeId") String employeeId, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<REPMU> list = repmuBean.findByMu001(employeeId);
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            List<JSONObject> objs = new ArrayList<>();
            JSONObject js = null;
            for (REPMU r : list) {
                js = new JSONObject();
                js.put("key", r.getRepmq().getMq001());
                js.put("value", r.getRepmq().getMq002());
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
