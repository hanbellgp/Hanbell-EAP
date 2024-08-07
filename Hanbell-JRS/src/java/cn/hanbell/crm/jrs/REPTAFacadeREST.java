///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.ejb.REPTABean;
//import cn.hanbell.crm.entity.REPTA;
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
// * @author Administrator
// */
//@Path("crm/repta")
//@javax.enterprise.context.RequestScoped
//public class REPTAFacadeREST extends SuperRESTForCRM<REPTA> {
//
//    @EJB
//    private REPTABean reptaBean;
//
//    public REPTAFacadeREST() {
//        super(REPTA.class);
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//        return reptaBean;
//    }
//
//    /**
//     * 获取未处理的叫修单
//     *
//     * @param ta001
//     * @param ta002
//     * @param appid
//     * @param token
//     * @return
//     * @throws Exception
//     */
//    @GET
//    @Path("repair/{ta001}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData<JSONObject> findRepair(@PathParam("ta001") String ta001, @QueryParam("searchWord") String ta002,
//            @QueryParam("appid") String appid, @QueryParam("token") String token) throws Exception {
//        if (isAuthorized(appid, token)) {
//            List<Object[]> list = reptaBean.getReptaByTA001AndTA031(ta001, ta002);
//            if (list == null) {
//                throw new WebApplicationException("没有未处理的叫修单");
//            }
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject js;
//            for (Object[] o : list) {
//                js = new JSONObject();
//                // -- 叫修单号，单据日期，客户编号,接单人员,产品品号，产品品名，产品规格，产品序号,机型,产品别，区域别,问题代号，问题描述，备注
//                // TA002,TA003,TA004,TA009,TA005,TA006,TA007,TA013, TA500
//                // ,TA197,TA198,TA071,TA010 ，TA009，TA017
//                js.put("key", o[0]);
//                js.put("value", o[1]);
//                js.put("ta004", o[2]);
//                js.put("ta009", o[3]);
//                js.put("ta005", o[4]);
//                js.put("ta006", o[5]);
//                js.put("ta007", o[6]);
//                js.put("ta013", o[7]);
//                js.put("ta500", o[8]);
//                js.put("ta197", o[9]);
//                js.put("ta198", o[10]);
//                js.put("ta071", o[11]);
//                js.put("ta010", o[12]);
//                js.put("ta017", o[13]);
//                REPTA r = reptaBean.findByPK(ta001, o[0].toString());
//                if (r != null) {
//                    if (r.getReceiver() != null) {
//                        js.put("receiver", r.getReceiver().getMv002());
//                    }
//                    if (r.getCrmgg() != null) {
//                        js.put("cusna", r.getCrmgg().getGg003());
//                    }
//                    if (r.getProductna() != null) {
//                        js.put("productna", r.getProductna().getEl002());
//                    }
//                    if (r.getAreana() != null) {
//                        js.put("areana", r.getAreana().getBg002());
//                    }
//                }
//                objs.add(js);
//            }
//            ResponseData<JSONObject> rsd = new ResponseData<>();
//            rsd.setCount(objs.size());
//            rsd.setData(objs);
//            return rsd;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//}
