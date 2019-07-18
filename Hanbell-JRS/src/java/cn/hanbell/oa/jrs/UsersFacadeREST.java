/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.FunctionsBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.Functions;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
 * @author C0160
 */
@Path("efgp/users")
@javax.enterprise.context.RequestScoped
public class UsersFacadeREST extends SuperRESTForEFGP<Users> {

    @EJB
    private UsersBean usersBean;
    @EJB
    private FunctionsBean functionsBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return usersBean;
    }

    public UsersFacadeREST() {
        super(Users.class);
    }

    @Override
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Users findById(@PathParam("id") PathSegment id, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                workFlowBean.initUserInfo(id.getPath());
                Users u = workFlowBean.getCurrentUser();
                u.setCompany(workFlowBean.getCompanyByDeptId(u.getDeptno()));
                return u;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}/size")
    @Produces({MediaType.APPLICATION_JSON})
    public UsersResponseResult findByFiltersWithSize(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        data = super.findWithSize(filters, sorts, offset, pageSize, appid, token);
        UsersResponseResult r = new UsersResponseResult();
        for (Map.Entry<Integer, List<Users>> entrySet : data.entrySet()) {
            r.setSize(entrySet.getKey());
            r.setResult(entrySet.getValue());
        }
        return r;
    }

    @GET
    @Path("functions/organizationunit/{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Users> findByOrganizationUnitId(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Users> usersList = new ArrayList<>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
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
                List<Functions> functionsList = functionsBean.findByFilters(filterFields, offset, pageSize, sortFields);
                for (Functions f : functionsList) {
                    usersList.add(f.getUsers());
                }
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return usersList;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("LDAP/{id}/{pwd}")
    @Produces({MediaType.APPLICATION_JSON})
    public Users findByLDAPAccount(@PathParam("id") String id, @PathParam("pwd") String pwd) {
        try {
            if (BaseLib.ADAuth("172.16.10.6:389", id + "@hanbell.com.cn", pwd)) {
                Users u = usersBean.findById(id);
                if (u != null) {
                    return u;
                } else {
                    throw new WebApplicationException(Response.Status.NOT_FOUND);
                }
            }
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

}
