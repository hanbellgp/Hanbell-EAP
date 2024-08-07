///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.ejb.PORBGBean;
//import cn.hanbell.crm.entity.PORBG;
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
//@Path("crm/porbg")
//@javax.enterprise.context.RequestScoped
//public class PORBGFacadeREST extends SuperRESTForCRM<PORBG> {
//
//    @EJB
//    private PORBGBean porbgBean;
//
//    public PORBGFacadeREST() {
//        super(PORBG.class);
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//      return porbgBean;
//    }
//
//    /**
//     * 区域别开窗
//     * 
//     * @param appid
//     * @param token
//     * @return 
//     */
//    @GET
//    @Path("area")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData<PORBG> findArea(@QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            ResponseData response = new ResponseData("200", "success");
//            List<PORBG> list = porbgBean.findAll();
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject js = null;
//            for (PORBG p : list) {
//                js = new JSONObject();
//                js.put("key", p.getBg001());
//                js.put("value", p.getBg002());
//                objs.add(js);
//            }
//            response.setCount(objs.size());
//            response.setData(objs);
//            return response;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//}
