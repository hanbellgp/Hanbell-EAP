///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.ejb.REPMBBean;
//import cn.hanbell.crm.ejb.REPPWBean;
//import cn.hanbell.crm.entity.REPMB;
//import cn.hanbell.crm.jrs.model.JSONObject;
//import cn.hanbell.jrs.ResponseData;
//import cn.hanbell.jrs.SuperRESTForCRM;
//import cn.hanbell.util.SuperEJB;
//import java.util.ArrayList;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author C2082
// */
//@Path("crm/repmb")
//@javax.enterprise.context.RequestScoped
//public class REPMBFacadeREST extends SuperRESTForCRM<REPMB> {
//
//    @EJB
//    private REPMBBean repmbBean;
//
//    @EJB
//    private REPPWBean reppwBean;
//
//    public REPMBFacadeREST() {
//        super(REPMB.class);
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//       return repmbBean;
//    }
//
//    /**
//     * 根据这个服务部门找到部门下的人员
//     * 
//     * @param deptno
//     * @param appid
//     * @param token
//     * @return 
//     */
//    @GET
//    @Path("maintainperson/{deptno}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData findMaintainerson(@PathParam("deptno") String deptno, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<REPMB> list = repmbBean.findByMB003(deptno);
//            if (list == null) {
//                throw new WebApplicationException(Response.Status.NOT_FOUND);
//            }
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject js = null;
//            for (REPMB r : list) {
//                js = new JSONObject();
//                js.put("key", r.getCmsmv().getMv001());
//                js.put("value", r.getCmsmv().getMv002());
//                objs.add(js);
//            }
//            ResponseData responseData = new ResponseData("200", "success");
//            responseData.setCount(objs.size());
//            responseData.setData(objs);
//            return responseData;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    
//    /**
//     * 获取维修类型
//     * 
//     * @param appid
//     * @param token
//     * @return 
//     */
//    @GET
//    @Path("maintainType")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData findMaintainType(@QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject j1 = new JSONObject();
//            JSONObject j2 = new JSONObject();
//            JSONObject j3 = new JSONObject();
//            JSONObject j4 = new JSONObject();
//            JSONObject j5 = new JSONObject();
//            j1.put("key", "1");
//            j1.put("value", "料件");
//            j2.put("key", "2");
//            j2.put("value", "出货");
//            j3.put("key", "3");
//            j3.put("value", "运费");
//            j4.put("key", "4");
//            j4.put("value", "杂项");
//            j5.put("key", "5");
//            j5.put("value", "换货");
//            objs.add(j1);
//            objs.add(j2);
//            objs.add(j3);
//            objs.add(j4);
//            objs.add(j5);
//            ResponseData responseData = new ResponseData("200", "success");
//            responseData.setCount(objs.size());
//            responseData.setData(objs);
//            return responseData;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//}
