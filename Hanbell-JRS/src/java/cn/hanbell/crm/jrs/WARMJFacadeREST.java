///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.ejb.WARMJBean;
//import cn.hanbell.crm.entity.WARMJ;
//import cn.hanbell.crm.jrs.model.JSONObject;
//import cn.hanbell.jrs.ResponseData;
//import cn.hanbell.jrs.SuperRESTForCRM;
//import cn.hanbell.util.SuperEJB;
//import java.util.ArrayList;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
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
//@Path("crm/warmj")
//@javax.enterprise.context.RequestScoped
//public class WARMJFacadeREST extends SuperRESTForCRM<WARMJ> {
//
//    @EJB
//    private WARMJBean warmjBean;
//
//    public WARMJFacadeREST() {
//        super(WARMJ.class);
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//        return warmjBean;
//    }
//
//    /**
//     * 所有的仓库开窗
//     *
//     * @param searchWord
//     * @param appid
//     * @param token
//     * @return
//     */
//    @GET
//    @Path("warehouse")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData findWarehouse(@QueryParam("searchWord") String searchWord, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<Object[]> list = warmjBean.findLikeMJ002(searchWord);
//            if (list == null) {
//                throw new WebApplicationException(Response.Status.NOT_FOUND);
//            }
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject js = null;
//            for (Object[] o : list) {
//                js = new JSONObject();
//                js.put("key", o[0]);
//                js.put("value", o[1]);
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
//}
