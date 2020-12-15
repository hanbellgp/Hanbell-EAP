/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
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

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperRESTForERP<T> {

    @EJB
    protected cn.hanbell.eap.ejb.SystemNameBean systemNameBean;

    protected Class<T> entityClass;
    protected String company;

    protected abstract SuperEJBForERP getSuperEJBForERP();

    protected SuperEJB getSuperEJB() {
        SuperEJBForERP superEJB = getSuperEJBForERP();
        superEJB.setCompany(getCompany());
        return superEJB;
    }

    public SuperRESTForERP(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(T entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage edit(@PathParam("id") PathSegment id, T entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @DELETE
    @Produces({"application/json"})
    public ResponseMessage remove(@PathParam("id") PathSegment id, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @GET
    @Path("all/{company}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findAll(@PathParam("company") PathSegment company, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                this.company = company.getPath();
                List<T> list = getSuperEJB().findAll();
                int count = list.size();
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
    @Path("pagination/{company}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByPagination(@PathParam("company") PathSegment company, @QueryParam("offset") Integer offset, @QueryParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                this.company = company.getPath();
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
    @Path("pagination/{company}/{filters}/{sorts}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByPaginationAndFilters(@PathParam("company") PathSegment company, @PathParam("filters") PathSegment filters,
            @PathParam("sorts") PathSegment sorts, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                this.company = company.getPath();
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
                                try {
                                    Field field = entityClass.getDeclaredField(key);
                                    obj = com.lightshell.comm.BaseLib.convertObject(field.getType(), value);
                                    filterFields.put(key, obj);
                                } catch (Exception ex) {
                                    filterFields.put(key, value);
                                }
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

    protected boolean isAuthorized(String appid, String token) {
        return systemNameBean.isAuthorized(appid, token);
    }

}
