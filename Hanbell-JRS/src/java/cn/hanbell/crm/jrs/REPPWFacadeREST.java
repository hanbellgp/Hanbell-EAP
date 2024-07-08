///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.app.REPPWApplication;
//import cn.hanbell.crm.app.REPTAApplication;
//import cn.hanbell.crm.ejb.REPMBBean;
//import cn.hanbell.crm.ejb.REPPWBean;
//import cn.hanbell.crm.ejb.REPTABean;
//import cn.hanbell.crm.entity.REPMB;
//import cn.hanbell.crm.entity.REPPW;
//import cn.hanbell.crm.entity.REPPWPK;
//import cn.hanbell.crm.entity.REPTA;
//import cn.hanbell.crm.jrs.model.JSONObject;
//import cn.hanbell.jrs.ResponseData;
//import cn.hanbell.jrs.ResponseMessage;
//import cn.hanbell.jrs.SuperRESTForCRM;
//import cn.hanbell.util.BaseLib;
//import cn.hanbell.util.SuperEJB;
//import java.util.ArrayList;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
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
//@Path("crm/reppw")
//@javax.enterprise.context.RequestScoped
//public class REPPWFacadeREST extends SuperRESTForCRM<REPPW> {
//
//    @EJB
//    private REPMBBean repmbBean;
//    @EJB
//    private REPPWBean reppwBean;
//    @EJB
//    private REPTABean reptaBean;
//
//    public REPPWFacadeREST() {
//        super(REPPW.class);
//    }
//
//    /**
//     * 派工单分配多人派工
//     *
//     * @param entity
//     * @param appid
//     * @param token
//     * @return
//     */
//    @POST
//    @Path("wechat")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public ResponseMessage create(REPTAApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        StringBuffer msg = new StringBuffer("【汉钟精机】 叫修单:").append(entity.getRepairKindname().split("-")[0]);
//        msg.append("-").append(entity.getRepairno()).append("已派工。 ");
//        msg.append("维修人员：");
//        if (isAuthorized(appid, token)) {
//            if (entity == null || entity.getDetailList() == null || entity.getDetailList().isEmpty()) {
//                throw new WebApplicationException(Response.Status.BAD_REQUEST);
//            }
//            List<REPPW> reppwList = new ArrayList<>();
//            String pw026 = "";
//            StringBuffer sendUser = new StringBuffer();
//            try {
//                int a = 1;
//                for (REPPWApplication ad : entity.getDetailList()) {
//                    if (null != ad.getRepairmanname2() && !"".equals(ad.getRepairmanname2())) {
//                        String[] repmen = ad.getRepairmanname2().split(";");
//                        for (int i = 1; i <= repmen.length; i++) {
//                            REPPW m = new REPPW();
//                            REPPWPK mk = new REPPWPK();
//                            m.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
//                            m.setCreator(ad.getEmployeeId());
//                            m.setUsrGroup(ad.getDeptId());
//                            mk.setPw001(entity.getRepairKindname().split("-")[0]);
//                            mk.setPw002(entity.getRepairno());
//                            String pw004 = repmen[i - 1];
//                            if ("".equals(pw004)) {
//                                continue;
//                            }
//                            m.setPw004(pw004.split("-")[0]);
//                            //拼装消息和发送人
//                            if (a != 1) {
//                                msg.append(",");
//                                sendUser.append("|");
//                            }
//                            a++;
//                            msg.append(pw004.split("-")[1]);
//                            sendUser.append(pw004.split("-")[0]);
//
//                            m.setREPPWPK(mk);
//                            m.setPw019("N");
//                            if (pw004.equals(ad.getRepairmanname())) {
//                                List<REPPW> reppws = reppwBean.findByPw001AndPw002AndPW019(mk.getPw001(), mk.getPw002(), "Y");
//                                if (reppws == null || reppws.isEmpty()) {
//                                    m.setPw019("Y");
//                                }
//
//                            }
//                            if (!"".equals(ad.getStationname())) {
//                                m.setPw005(ad.getStationname().split("-")[0]);
//                            }
//                            if (ad.getDate3() != null && !"".equals(ad.getDate3())) {
//                                String date3 = ad.getDate3().substring(0, 4) + ad.getDate3().substring(5, 7) + ad.getDate3().substring(8, 10);
//                                m.setPw006(BaseLib.formatString("yyyyMMdd", date3));
//                            }
//                            if (ad.getDate4() != null && !"".equals(ad.getDate4())) {
//                                String date4 = ad.getDate4().substring(0, 4) + ad.getDate4().substring(5, 7) + ad.getDate4().substring(8, 10);
//                                m.setPw007(BaseLib.formatString("yyyyMMdd", date4));
//                            }
//                            m.setPw010("0");    //派工状态码
//                            m.setPw011(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
//                            m.setPw012(m.getCreator());
//                            m.setPw013(new Short("1"));
//                            m.setPw020("1");
//                            m.setPw021("0000");
//                            m.setPw022("0000");
//                            m.setPw026("0001");
//                            reppwList.add(m);
//                        }
//                    } else {
//                        return new ResponseMessage("400", "请维护维修人员");
//                    }
//                }
//
//                REPTA ra = reptaBean.findByPK(entity.getRepairKindname().split("-")[0], entity.getRepairno());
//                List<REPPW> reppws = reppwBean.findByPw001AndPw002(entity.getRepairKindname().split("-")[0], entity.getRepairno());
//                int max = 0;
//                for (REPPW reppw : reppwList) {
//                    if (reppw.getPw013() > max) {
//                        max = reppw.getPw013();
//                    }
//                }
//                int size = reppws.size();
//                String isY=null;
//                for (REPPW reppw : reppwList) {
//                    size++;
//                    reppw.setPw013((short) max);
//                    String x = String.valueOf(size);
//                    StringBuffer serial = new StringBuffer("000").append(x);
//                    reppw.getREPPWPK().setPw003(serial.substring(x.length() - 1));
//                    if("Y".equals(reppw.getPw019())&&isY==null){
//                        isY=reppw.getPw019();
//                    }else{
//                        reppw.setPw019("N");
//                    }
//                    reppwBean.persist(reppw);
//
//                }
//                //更新叫修单状态为确认
//                if (ra != null) {
//                    ra.setTa035("1"); //派工码显示转维修站
//                    ra.setTa014("Y");
//                    ra.setTa015(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
//                    ra.setTa016(entity.getDetailList().get(0).getEmployeeId());
//                    ra.setTa030("Y");
//                    ra.setTa031("0");
//                    ra.setTa079("来至微信小程序");
//                    reptaBean.update(ra);
//                }
//                String errmsg = reptaBean.sendMsgString(sendUser.toString(), msg.toString(),
//                        entity.getSessionkey(), entity.getOpenId());
//                if (!"200".equals(errmsg)) {
//                    throw new RuntimeException("发送失败,请联系管理员");
//                }
//                return new ResponseMessage("200", "更新派工资料成功！");
//            } catch (Exception ex) {
//                return new ResponseMessage("500", "更新失败");
//            }
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    /**
//     * 获取维修人员，优先分配主维修人员，其次为其他的维修人员。
//     *
//     * 【需求修改】2020/9/29 ，直接获取主维修人员
//     *
//     * @param SerialNumber
//     * @param appid
//     * @param token
//     * @return
//     */
//    @GET
//    @Path("maintainNumber/{SerialNumber}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData<JSONObject> getMaintainPersonSerialNumber(@PathParam("SerialNumber") String SerialNumber, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//            String[] sers = SerialNumber.split("\\|");
//            List<REPPW> reppws = reppwBean.findByPw001AndPw002AndPW010AndPW019(sers[0], sers[1], "0", "Y");
//            List<JSONObject> objs = new ArrayList<>();
//            JSONObject js = null;
//            if (reppws != null && !reppws.isEmpty()) {
//                for (REPPW r : reppws) {
//                    js = new JSONObject();
//                    js.put("key", reppws.get(0).getPw004());
//                    js.put("value", reppws.get(0).getCmsmv().getMv002());
//                    REPMB repmb = repmbBean.findByMB001(r.getPw004());
//                    js.put("value1", repmb.getWarmj().getMj001());
//                    js.put("value2", repmb.getWarmj().getMj002());
//                    js.put("value3", r.getREPPWPK().getPw003());
//                    objs.add(js);
//                }
//            }
//            ResponseData<JSONObject> respone = new ResponseData("200", "success");
//            respone.setCount(objs.size());
//            respone.setData(objs);
//            return respone;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//        return reppwBean;
//    }
//}
