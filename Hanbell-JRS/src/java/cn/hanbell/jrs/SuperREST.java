/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperREST<T> {

    protected Class<T> entityClass;
    protected Map<Integer, List<T>> data;

    @EJB
    protected cn.hanbell.eap.ejb.SystemNameBean systemNameBean;

    protected abstract SuperEJB getSuperEJB();

    public SuperREST(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(T entity) {
        try {
            getSuperEJB().persist(entity);
            return new ResponseMessage("200", "更新成功");
        } catch (Exception ex) {
            return new ResponseMessage("500", "系统错误更新失败");
        }
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
    @Path("{id}")
    @Produces({"application/json"})
    public ResponseMessage remove(@PathParam("id") PathSegment id) {
        try {
            T t = (T) getSuperEJB().findById(id.getPath());
            if (t == null) {
                return new ResponseMessage("404", "内容为空");
            }
            getSuperEJB().delete(t);
            return new ResponseMessage("200", "更新成功");
        } catch (Exception ex) {
            return new ResponseMessage("500", "系统错误更新失败");
        }
    }

    public Map<Integer, List<T>> find(PathSegment filters, PathSegment sorts, Integer offset, Integer pageSize) {
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
    }

    @GET
    @Produces({"application/json"})
    public List<T> findAll() {
        return getSuperEJB().findAll();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public T findById(@PathParam("id") PathSegment id) {
        return (T) getSuperEJB().findById(id.getPath());
    }

    @GET
    @Path("{offset}/{pageSize}")
    @Produces({"application/json"})
    public List<T> findAll(@PathParam("offset") int offset, @PathParam("pageSize") int pageSize) {
        return getSuperEJB().findAll(offset, pageSize);
    }

    public int getRowCount() {
        return getSuperEJB().getRowCount();
    }

    protected boolean isAuthorized(String appid, String token) {
        return systemNameBean.isAuthorized(appid, token);
    }

}
