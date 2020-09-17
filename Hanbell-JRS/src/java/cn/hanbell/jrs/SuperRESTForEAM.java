/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import cn.hanbell.util.BaseLib;
import com.lightshell.comm.SuperEJB;
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
 * @author C2090
 * @param <T>
 */
public abstract class SuperRESTForEAM<T> {

    protected Class<T> entityClass;

    protected abstract SuperEJB getSuperEJB();

    @EJB
    protected cn.hanbell.eap.ejb.SystemNameBean systemNameBean;

    public SuperRESTForEAM(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage create(T entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
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


    protected boolean isAuthorized(String appid, String token) {
        return systemNameBean.isAuthorized(appid, token);
    }

}
