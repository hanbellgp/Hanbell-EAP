/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.SystemGrantModuleBean;
import cn.hanbell.eap.ejb.SystemGrantPrgBean;
import cn.hanbell.eap.ejb.SystemRoleDetailBean;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemGrantModule;
import cn.hanbell.eap.entity.SystemGrantPrg;
import cn.hanbell.eap.entity.SystemRoleDetail;
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
    @EJB
    private SystemRoleDetailBean systemRoleDetailBean;
    @EJB
    private SystemGrantModuleBean systemGrantModuleBean;
    @EJB
    private SystemGrantPrgBean systemGrantPrgBean;

    private List<SystemGrantModule> userModuleGrantList;
    private List<SystemGrantModule> roleModuleGrantList;
    private List<SystemGrantModule> moduleGrantList;
    private List<SystemGrantPrg> userPrgGrantList;
    private List<SystemGrantPrg> rolePrgGrantList;
    private List<SystemGrantPrg> prgGrantList;
    private List<SystemRoleDetail> roleList;

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
    public ResponseObject loginYun(YunLogin entity, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
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
    public ResponseObject fetchYun(@QueryParam("userid") String userid, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseObject res;
            SystemUser su = systemUserBean.findByUserId(userid);
            if (su != null) {
                YunUser yu = new YunUser();
                yu.setUserid(su.getUserid());
                yu.setName(su.getUsername());
                yu.setEmail(su.getEmail());
                yu.setDeptno(su.getDeptno());
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

                try {
                    // 获取权限
                    setAuthorization("YUN", su.getId());
                    // 菜单
                    List<Map<String, Object>> menu = new ArrayList<>();
                    ArrayList routes;
                    Map<String, Object> route;
                    // 通用菜单
                    route = new HashMap<>();
                    route.put("path", "/workplace");
                    route.put("name", "workplace");
                    menu.add(route);
                    // 授权菜单
                    if (moduleGrantList != null && prgGrantList != null) {
                        for (SystemGrantModule m : moduleGrantList) {
                            routes = new ArrayList<>();
                            // 功能菜单
                            for (SystemGrantPrg p : prgGrantList) {
                                if (p.getPid() == m.getSystemModule().getId()) {
                                    route = new HashMap<>();
                                    route.put("path", p.getSysprg().getApi());
                                    route.put("name", p.getSysprg().getName());
                                    routes.add(route);
                                }
                            }
                            // 模块菜单
                            route = new HashMap<>();
                            route.put("path", m.getSystemModule().getApi());
                            route.put("name", m.getSystemModule().getName());
                            route.put("routes", routes);
                            // 加入菜单
                            menu.add(route);
                        }
                    }
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
                    res.getExtData().put("authorization", prgGrantList);

                    return res;
                } catch (Exception ex) {
                    return new ResponseObject<>("500", "系统错误", ex.getMessage());
                } finally {
                    if (moduleGrantList != null) {
                        moduleGrantList.clear();
                        moduleGrantList = null;
                    }
                }
            } else {
                return new ResponseObject<>("404", "此用戶不存在", null);
            }
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

    private void setAuthorization(String systemName, Integer userId) {
        boolean flag;
        moduleGrantList = new ArrayList<>();
        prgGrantList = new ArrayList<>();

        // 将用户权限和角色权限合并后产生菜单,用户权限优先角色权限
        userModuleGrantList = systemGrantModuleBean.findBySystemNameAndUserId(systemName, userId);
        userModuleGrantList.forEach((m) -> {
            moduleGrantList.add(m);
        });
        userPrgGrantList = systemGrantPrgBean.findBySystemNameAndUserId(systemName, userId);
        userPrgGrantList.forEach((p) -> {
            prgGrantList.add(p);
        });
        roleList = systemRoleDetailBean.findByUserId(userId);
        for (SystemRoleDetail r : roleList) {
            roleModuleGrantList = systemGrantModuleBean.findBySystemNameAndRoleId(systemName, r.getPid());
            if (moduleGrantList.isEmpty()) {
                moduleGrantList.addAll(roleModuleGrantList);
            } else {
                for (SystemGrantModule m : roleModuleGrantList) {
                    flag = true;
                    for (SystemGrantModule e : moduleGrantList) {
                        if (e.getSystemModule().getId().compareTo(m.getSystemModule().getId()) == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        moduleGrantList.add(m);
                    }
                }
            }
            rolePrgGrantList = systemGrantPrgBean.findBySystemNameAndRoleId(systemName, r.getPid());
            if (prgGrantList.isEmpty()) {
                prgGrantList.addAll(rolePrgGrantList);
            } else {
                for (SystemGrantPrg p : rolePrgGrantList) {
                    flag = true;
                    for (SystemGrantPrg e : prgGrantList) {
                        if (e.getSysprg().getId().compareTo(p.getSysprg().getId()) == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        prgGrantList.add(p);
                    }
                }
            }
        }
        moduleGrantList.sort((SystemGrantModule o1, SystemGrantModule o2) -> {
            if (o1.getSystemModule().getSortid() < o2.getSystemModule().getSortid()) {
                return -1;
            } else {
                return 1;
            }
        });
        prgGrantList.sort((SystemGrantPrg o1, SystemGrantPrg o2) -> {
            if (o1.getSysprg().getSortid() < o2.getSysprg().getSortid()) {
                return -1;
            } else {
                return 1;
            }
        });
    }

}
