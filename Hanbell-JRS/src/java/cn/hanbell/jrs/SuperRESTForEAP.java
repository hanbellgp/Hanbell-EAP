/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import cn.hanbell.util.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.lang.reflect.Field;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperRESTForEAP<T> {

    protected Class<T> entityClass;
    protected final Logger log4j = LogManager.getLogger("cn.hanbell.wco");

    protected abstract SuperEJB getSuperEJB();

    @EJB
    protected cn.hanbell.eap.ejb.SystemNameBean systemNameBean;

    public SuperRESTForEAP(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage create(T entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                //entity.setCredateToNow();
                //entity.setOptdate(entity.getCredate());
                getSuperEJB().persist(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage edit(@PathParam("id") PathSegment id, T entity, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                T t = (T) getSuperEJB().findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                //if (!Objects.equals(t.getOptdate(), entity.getOptdate())) {
                //    return new ResponseMessage("409", "修改冲突");
                //}
                //entity.setOptdateToNow();
                getSuperEJB().update(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage remove(@PathParam("id") PathSegment id, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                T t = (T) getSuperEJB().findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                getSuperEJB().delete(t);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findAll(@QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<T> list = getSuperEJB().findAll();
                ResponseData res = new ResponseData<T>("200", "success");
                res.setData(list);
                res.setCount(list.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("pagination")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByPagination(@QueryParam("offset") Integer offset, @QueryParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<T> list = getSuperEJB().findAll(offset, pageSize);
                int count = getSuperEJB().getRowCount();
                ResponseData res = new ResponseData<T>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("pagination/query")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByPaginationQuery(@QueryParam("q") String q, @QueryParam("offset") Integer offset, @QueryParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("query")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByQuery(@QueryParam("q") String q,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject findById(@PathParam("id") PathSegment id, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                T t = (T) getSuperEJB().findById(Integer.parseInt(id.getPath()));
                ResponseObject res = new ResponseObject<>("200", "success", t);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    @Deprecated
    public ResponseData findAll(@PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<T> list = getSuperEJB().findAll(offset, pageSize);
                int count = getSuperEJB().getRowCount();
                ResponseData res = new ResponseData<T>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("pagination/{filters}/{sorts}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByFiltering(@PathParam("filters") PathSegment filters,
            @PathParam("sorts") PathSegment sorts, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                Object obj;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.endsWith("dateBegin") || key.endsWith("DateBegin") || key.endsWith("dateEnd")
                                || key.endsWith("DateEnd")) {
                            obj = BaseLib.getDate("yyyy-MM-dd", value);
                            filterFields.put(key, obj);
                        } else {
                            if (!key.contains(".")) {
                                Field field = entityClass.getDeclaredField(key);
                                obj = com.lightshell.comm.BaseLib.convertObject(field.getType(), value);
                                filterFields.put(key, obj);
                            } else {
                                filterFields.put(key, value);
                            }
                        }
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                List<T> list = getSuperEJB().findByFilters(filterFields, offset, pageSize, sortFields);
                int count = getSuperEJB().getRowCount(filterFields);
                ResponseData res = new ResponseData<T>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    @Deprecated
    public ResponseData findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts,
            @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                Object obj;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.endsWith("dateBegin") || key.endsWith("DateBegin") || key.endsWith("dateEnd")
                                || key.endsWith("DateEnd")) {
                            obj = BaseLib.getDate("yyyy-MM-dd", value);
                            filterFields.put(key, obj);
                        } else {
                            if (!key.contains(".")) {
                                Field field = entityClass.getDeclaredField(key);
                                obj = com.lightshell.comm.BaseLib.convertObject(field.getType(), value);
                                filterFields.put(key, obj);
                            } else {
                                filterFields.put(key, value);
                            }
                        }
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                List<T> list = getSuperEJB().findByFilters(filterFields, offset, pageSize, sortFields);
                int count = getSuperEJB().getRowCount(filterFields);
                ResponseData res = new ResponseData<T>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    protected boolean isAuthorized(String appid, String token) {
        return systemNameBean.isAuthorized(appid, token);
    }

}
