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

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public ResponseData findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<DSH> dshList;
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
                dshList = dshBean.findByFilters(filterFields, offset, pageSize, sortFields);
                ResponseData responseData = new ResponseData("200", "seccess");
                responseData.setData(dshList);
                responseData.setCount(dshList.size());
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
        return dshBean;
    }

    /**
     * 事发省
     *
     * @param provincename
     * @param appid
     * @param token
     * @return
     */
    @GET
    @Path("incidentProvince")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findIncidentArea(@QueryParam("searchWord") String provincename, @QueryParam("appid") String appid, @QueryParam("token") String token) {
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
