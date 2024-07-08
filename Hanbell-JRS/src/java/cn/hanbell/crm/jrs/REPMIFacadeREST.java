///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.ejb.REPMIBean;
//import cn.hanbell.crm.entity.REPMI;
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
//@Path("crm/repmi")
//@javax.enterprise.context.RequestScoped
//public class REPMIFacadeREST extends SuperRESTForCRM<REPMI> {
//
//    @EJB
//    private REPMIBean repmiBean;
//
//    public REPMIFacadeREST() {
//        super(REPMI.class);
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//      return repmiBean;
//    }
//
//   /**
//    * 产品序号开窗选择
//    * 
//    * @param MI002
//    * @param appid
//    * @param token
//    * @return 
//    */
//    @GET
//    @Path("productNumber")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData<JSONObject> findProductNumber(@QueryParam("searchWord") String MI002, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<Object[]> list = repmiBean.findProductNumber(MI002);
//            List<JSONObject> jsonobjects = new ArrayList<>();
//            JSONObject js = new JSONObject();
//            for (int i = 0; i < list.size(); i++) {
//                js = new JSONObject();
//                js.put("key", list.get(i)[0]);//序号
//                js.put("value1", list.get(i)[2]);//品名
//                js.put("value", list.get(i)[1]);//品号
//                js.put("value2", list.get(i)[3]);//规格
//                js.put("value3", list.get(i)[4]);//保固开始日期
//                js.put("value4", list.get(i)[5]);//保固结束日期
//                js.put("value5", list.get(i)[6]);//单位
//                jsonobjects.add(js);
//            }
//            ResponseData responseData = new ResponseData("200", "success");
//            responseData.setCount(list.size());
//            responseData.setData(jsonobjects);
//            return responseData;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    /**
//     * 产品品号开窗选择
//     * 
//     * @param MB001
//     * @param appid
//     * @param token
//     * @return 
//     */
//    @GET
//    @Path("productQuality")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData<JSONObject> findProductQuality(@QueryParam("searchWord") String MB001, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<Object[]> list = repmiBean.findProductQuality(MB001);
//            List<JSONObject> jsonobjects = new ArrayList<>();
//            JSONObject js = new JSONObject();
//            for (int i = 0; i < list.size(); i++) {
//                js = new JSONObject();
//                js.put("key", i + 1);             //自定义key（前端需要）
//                js.put("value", list.get(i)[0]);//品号
//                js.put("value1", list.get(i)[1]);//品名
//                js.put("value2", list.get(i)[2]);//规格
//                js.put("value3", list.get(i)[3]);//保固开始日期
//                js.put("value4 ", list.get(i)[4]);//保固结束日期
//                js.put("value5", list.get(i)[5]);//单位
//                jsonobjects.add(js);
//            }
//            ResponseData responseData = new ResponseData("200", "success");
//            responseData.setCount(list.size());
//            responseData.setData(jsonobjects);
//            return responseData;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//}
