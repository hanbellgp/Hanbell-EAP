/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.eap.model.LoginYun;
import cn.hanbell.eap.model.YunLogin;
import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/systemuser")
public class SystemUserFacadeREST extends SuperRESTForEAP<SystemUser> {

    @EJB
    private SystemUserBean systemUserBean;

    public SystemUserFacadeREST() {
        super(SystemUser.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return systemUserBean;
    }

    @POST
    @Path("login/yun")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject loginYun(YunLogin entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseObject res = null;
            String userid, pwd, type;
            userid = entity.getUserName();
            pwd = entity.getPassword();
            type = entity.getType();
            try {
                if (cn.hanbell.util.BaseLib.ADAuth("172.16.10.6:389", userid + "@hanbell.com.cn", pwd)) {
                    LoginYun login = new LoginYun();
                    login.setStatus("success");
                    login.setType(type);
                    login.getCurrentAuthority().add("admin");
                    res = new ResponseObject<>("200", "验证成功", login);
                }
            } catch (Exception ex) {
                LoginYun login = new LoginYun();
                login.setStatus("error");
                login.setType(type);
                res = new ResponseObject<>("401", ex.getMessage(), login);
            }
            return res;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("grant/yun")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Map<String, Object>> grantYun(@QueryParam("userid") String userid, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Map<String, Object>> data = new ArrayList<>();
            ArrayList routes;
            Map<String, Object> route;

            routes = new ArrayList<>();
            route = new HashMap<>();
            route.put("path", "/dashboard/analysis");
            route.put("name", "analysis");
            route.put("icon", "folder");
            routes.add(route);
            route = new HashMap<>();
            route.put("path", "/dashboard/workplace");
            route.put("name", "workplace");
            route.put("icon", "folder");
            routes.add(route);
            route = new HashMap<>();
            route.put("path", "/dashboard");
            route.put("name", "dashboard");
            route.put("icon", "dashboard");
            route.put("routes", routes);
            data.add(route);

            routes = new ArrayList<>();
            route = new HashMap<>();
            route.put("path", "/custom/company");
            route.put("name", "公司列表");
            route.put("icon", "folder");
            routes.add(route);
            route = new HashMap<>();
            route.put("path", "/custom");
            route.put("name", "学习进度");
            route.put("icon", "folder");
            route.put("routes", routes);
            data.add(route);

            return data;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
