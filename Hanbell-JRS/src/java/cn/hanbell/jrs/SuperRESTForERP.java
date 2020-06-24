/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.util.SuperEJB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
 * @author C0160
 * @param <T>
 */
public abstract class SuperRESTForERP<T> {

    @EJB
    protected cn.hanbell.eap.ejb.SystemNameBean systemNameBean;

    protected Class<T> entityClass;
    protected Map<Integer, List<T>> data;
    protected String company;

    protected abstract SuperEJBForERP getSuperEJBForERP();

    protected SuperEJB getSuperEJB() {
        return getSuperEJBForERP();
    }

    public SuperRESTForERP(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(T entity) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage edit(@PathParam("id") PathSegment id, T entity) {
        try {
            getSuperEJB().update(entity);
            return new ResponseMessage("200", "更新成功");
        } catch (Exception ex) {
            return new ResponseMessage("500", "系统错误更新失败");
        }
    }

    @DELETE
    @Produces({"application/json"})
    public ResponseMessage remove(@PathParam("id") PathSegment id) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<T> findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
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
                return getSuperEJB().findByFilters(filterFields, offset, pageSize, sortFields);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    protected Map<Integer, List<T>> findWithSize(PathSegment filters, PathSegment sorts, Integer offset, Integer pageSize, String appid, String token) {
        if (isAuthorized(appid, token)) {
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
                int size = getSuperEJB().getRowCount(filterFields);
                List<T> list = getSuperEJB().findByFilters(filterFields, offset, pageSize, sortFields);
                Map<Integer, List<T>> map = new HashMap<>();
                map.put(size, list);
                return map;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    protected int getRowCount() {
        return getSuperEJB().getRowCount();
    }

    protected boolean isAuthorized(String appid, String token) {
        return systemNameBean.isAuthorized(appid, token);
    }

}
