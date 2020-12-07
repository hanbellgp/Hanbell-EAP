/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.eap.jrs.model.YunUser;
import cn.hanbell.eap.jrs.model.YunLogin;
import cn.hanbell.jrs.ResponseData;
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
                    YunLogin login = new YunLogin();
                    login.setUserName(userid);
                    login.setStatus("success");
                    login.setType(type);
                    login.getCurrentAuthority().add("admin");
                    res = new ResponseObject<>("200", "验证成功", login);
                }
            } catch (Exception ex) {
                YunLogin login = new YunLogin();
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
    @Path("yun")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject fetchYun(@QueryParam("userid") String userid, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseObject res;
            SystemUser su = systemUserBean.findByUserId(userid);
            if (su != null) {
                YunUser yu = new YunUser();
                yu.setUserid(su.getUserid());
                yu.setName(su.getUsername());
                yu.setEmail(su.getEmail());
                yu.setGroup(su.getDept().getDept());
                yu.setTitle(su.getJob());
                yu.setPhone(su.getPhone());
                yu.setAddress("湖滨大道");
                List<Map<String, String>> tags = new ArrayList<>();
                Map<String, String> tag;
                tag = new HashMap<>();
                tag.put("key", "0");
                tag.put("label", "ERP问题专家");
                tags.add(tag);
                tag = new HashMap<>();
                tag.put("key", "1");
                tag.put("label", "Java架构师");
                tags.add(tag);
                tag = new HashMap<>();
                tag.put("key", "3");
                tag.put("label", "React先行者");
                tags.add(tag);

                yu.setTags(tags);

                // 菜单
                List<Map<String, Object>> menu = new ArrayList<>();
                ArrayList routes;
                Map<String, Object> route;

                route = new HashMap<>();
                route.put("path", "/workplace");
                route.put("name", "workplace");
                menu.add(route);

                routes = new ArrayList<>();

                route = new HashMap<>();
                route.put("path", "/custom/demands");
                route.put("name", "demands");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/custom/tasks");
                route.put("name", "tasks");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/custom/conference");
                route.put("name", "conference");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/custom");
                route.put("name", "custom");
                route.put("routes", routes);

                menu.add(route);

                routes = new ArrayList<>();

                route = new HashMap<>();
                route.put("path", "/production-marketing/product-series");
                route.put("name", "product-series");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/production-marketing/product");
                route.put("name", "product");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/production-marketing/sales-order");
                route.put("name", "sales-order");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/production-marketing/production-plan");
                route.put("name", "production-plan");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/production-marketing/production-demand");
                route.put("name", "production-demand");
                routes.add(route);

                route = new HashMap<>();
                route.put("path", "/production-marketing");
                route.put("name", "production-marketing");
                route.put("routes", routes);

                menu.add(route);

                // 首页雷达图数据
                List<Map<String, Object>> radarData = new ArrayList<>();
                Map<String, Object> chart;

                chart = new HashMap<>();
                chart.put("name", "个人");
                chart.put("label", "技术");
                chart.put("value", 10);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "个人");
                chart.put("label", "口碑");
                chart.put("value", 8);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "个人");
                chart.put("label", "产量");
                chart.put("value", 4);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "个人");
                chart.put("label", "贡献");
                chart.put("value", 5);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "个人");
                chart.put("label", "热度");
                chart.put("value", 7);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "部门");
                chart.put("label", "技术");
                chart.put("value", 5);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "部门");
                chart.put("label", "口碑");
                chart.put("value", 7);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "部门");
                chart.put("label", "产量");
                chart.put("value", 10);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "部门");
                chart.put("label", "贡献");
                chart.put("value", 5);
                radarData.add(chart);

                chart = new HashMap<>();
                chart.put("name", "部门");
                chart.put("label", "热度");
                chart.put("value", 2);
                radarData.add(chart);

                res = new ResponseObject<>("200", "success", yu);
                res.getExtData().put("menu", menu);
                res.getExtData().put("radarData", radarData);

            } else {
                res = new ResponseObject<>("404", "此用戶不存在", null);
            }
            return res;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseData findByQuery(String q, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<SystemUser> list = systemUserBean.findByUserIdOrName(q);
                ResponseData res = new ResponseData<SystemUser>("200", "success");
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

}
