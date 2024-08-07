///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.ejb.CRMGGBean;
//import cn.hanbell.crm.entity.CRMGG;
//import cn.hanbell.crm.jrs.model.JSONObject;
//import cn.hanbell.jrs.ResponseData;
//import cn.hanbell.jrs.SuperRESTForCRM;
//import cn.hanbell.oa.app.KV;
//import cn.hanbell.util.SuperEJB;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.ejb.EJB;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.PathSegment;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author Administrator
// */
//@Path("crm/crmgg")
//@javax.enterprise.context.RequestScoped
//public class CRMGGFacadeREST extends SuperRESTForCRM<CRMGG> {
//
//    @EJB
//    private CRMGGBean crmggBean;
//
//    public CRMGGFacadeREST() {
//        super(CRMGG.class);
//    }
//
//    @GET
//    @Path("{filters}/{sorts}/{offset}/{pageSize}")
//    @Produces({MediaType.APPLICATION_JSON})
//    @Override
//    public ResponseData findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<CRMGG> crmggList;
//            try {
//                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
//                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
//                Map<String, Object> filterFields = new HashMap<>();
//                Map<String, String> sortFields = new HashMap<>();
//                String key, value;
//                if (filtersMM != null) {
//                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
//                        key = entrySet.getKey();
//                        value = entrySet.getValue().get(0);
//                        filterFields.put(key, value);
//                    }
//                }
//                if (sortsMM != null) {
//                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
//                        key = entrySet.getKey();
//                        value = entrySet.getValue().get(0);
//                        sortFields.put(key, value);
//                    }
//                }
//                List<KV> dataList = new ArrayList<>();
//                crmggList = crmggBean.findByFilters(filterFields, offset, pageSize, sortFields);
//                if (!crmggList.isEmpty()) {
//                    crmggList.forEach((gg) -> {
//                        dataList.add(new KV(gg.getGg001(), gg.getGg003()));
//                    });
//                }
//                ResponseData responseData = new ResponseData("200", "seccess");
//                responseData.setCount(dataList.size());
//                responseData.setData(dataList);
//                return responseData;
//            } catch (Exception ex) {
//                throw new WebApplicationException(Response.Status.NOT_FOUND);
//            }
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//       return crmggBean;
//    }
//
//    /**
//     * 客户信息
//     *
//     * @param GG003
//     * @param appid
//     * @param token
//     * @return
//     */
//    @GET
//    @Path("customercode/")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData<JSONObject> findCustomerCode(@QueryParam("searchWord") String GG003, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            List<Object[]> list = crmggBean.findCustomerCode(GG003);
//            if (list == null) {
//                throw new WebApplicationException(Response.Status.NOT_FOUND);
//            }
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject js = null;
//            for (int i = 0; i < list.size(); i++) {
//                js = new JSONObject();
//                js.put("value", list.get(i)[1]);//公司简称           
//                js.put("key", list.get(i)[2]);//公司编号
//                js.put("value1", list.get(i)[3]);//公司简称
//                js.put("value2", list.get(i)[4]);//来电者
//                js.put("value3", list.get(i)[5]);//公司电话国码
//                js.put("value4", list.get(i)[6]);//公司电话区码
//                js.put("value5", list.get(i)[7]);//行动电话国码
//                js.put("value6", list.get(i)[8]);//行动电话区码
//                js.put("value7", list.get(i)[9]);//
//                js.put("value8", list.get(i)[10]);//交易币别
//                js.put("value9", list.get(i)[11]);//公司全名
//                js.put("value10", list.get(i)[12]);//发票地址一
//                js.put("value11", list.get(i)[13]);//发票地址二
//                js.put("value12", list.get(i)[14]);//发票邮政区号
//                js.put("value13", list.get(i)[15]);//统一编号
//                js.put("value14", list.get(i)[16]);//经销商
//                objs.add(js);
//            }
//            ResponseData responseData = new ResponseData("200", "seccess");
//            responseData.setData(objs);
//            responseData.setCount(objs.size());
//            return responseData;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//}
