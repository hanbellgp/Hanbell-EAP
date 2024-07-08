///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.crm.jrs;
//
//import cn.hanbell.crm.app.REPTEApplication;
//import cn.hanbell.crm.ejb.REPTABean;
//import cn.hanbell.crm.ejb.REPTCBean;
//import cn.hanbell.crm.ejb.REPTEBean;
//import cn.hanbell.crm.entity.REPTC;
//import cn.hanbell.crm.entity.REPTE;
//import cn.hanbell.crm.entity.REPTEPK;
//import cn.hanbell.crm.jrs.model.JSONObject;
//import cn.hanbell.jrs.ResponseData;
//import cn.hanbell.jrs.ResponseMessage;
//import cn.hanbell.jrs.SuperRESTForCRM;
//import cn.hanbell.util.BaseLib;
//import cn.hanbell.util.SuperEJB;
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
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
// * @author C2082
// */
//@Path("crm/repte")
//@javax.enterprise.context.RequestScoped
//public class REPTEFacadeREST extends SuperRESTForCRM<REPTE> {
//
//    @EJB
//    private REPTEBean repteBean;
//    @EJB
//    private REPTCBean reptcBean;
//    @EJB
//    private REPTABean reptaBean;
//
//    public REPTEFacadeREST() {
//        super(REPTE.class);
//    }
//
//    @Override
//    protected SuperEJB getSuperEJB() {
//        return repteBean;
//    }
//
//    /**
//     * 验证今天当天是否第一天填维修描述，检查之前的维系描述时间是否有问题
//     *
//     * @param employeeid
//     * @param appid
//     * @param token
//     * @return "0" 当天没有维修描述，
//     */
//    @GET
//    @Path("validateDate/{employeeid}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public ResponseData validateDate(@PathParam("employeeid") String employeeid, @QueryParam("appid") String appid, @QueryParam("token") String token,
//            @QueryParam("maintainType") String maintainType, @QueryParam("maintainNumber") String maintainNumber, @QueryParam("maintainSerial") String maintainSerial
//    ) throws ParseException {
//        if (isAuthorized(appid, token)) {
//            List<REPTE> reptes = repteBean.findByCreatorAndCreatedateOrModifierAndModiDate(employeeid, BaseLib.formatDate("yyyyMMdd", new Date()));
//            Long a = new Date().getTime() - 1000 * 60 * 60 * 24;
//            List<REPTE> yesterday = repteBean.findByCreatorAndCreatedateOrModifierAndModiDate(employeeid, BaseLib.formatDate("yyyyMMdd", new Date(a)));
//            reptes.addAll(yesterday);
//            Set<REPTE> list = repteBean.validateIntegrity(reptes);
//            //当天非第一张数据
//            if (list != null && !list.isEmpty()) {
//                ResponseData resp = new ResponseData("201", "success");
//                List<JSONObject> jos = new ArrayList<>();
//                for (REPTE repte : list) {
//                    JSONObject js = new JSONObject();
//                    js.put("te001", repte.getREPTEPK().getTe001());
//                    js.put("te002", repte.getREPTEPK().getTe002());
//                    js.put("te004", repte.getREPTEPK().getTe004());
//                    REPTC reptc = reptcBean.findByPK(repte.getREPTEPK().getTe001(), repte.getREPTEPK().getTe002());
//                    js.put("roadStartDate", repteBean.proccessDate("HHmm", repte.getTe504(), "HH:mm"));
//                    js.put("roadEndDate", repteBean.proccessDate("HHmm", repte.getTe505(), "HH:mm"));
//                    js.put("arrivalDate", repteBean.proccessDate("HHmm", repte.getTe017(), "HH:mm"));
//                    js.put("leaveDate", repteBean.proccessDate("HHmm", repte.getTe019(), "HH:mm"));
//                    js.put("customerName", reptc.getTc036());
//                    js.put("productName", reptc.getTc009());
//                    js.put("problemId", reptc.getTc077());
//                    js.put("problemName", reptc.getTc013());
//                    jos.add(js);
//                }
//                resp.setCount(jos.size());
//                resp.setData(jos);
//                return resp;
//            } else {
//                //第一天是第一张数据
//                List<REPTC> reptcs = reptcBean.getReptcByTC001OrTc002(maintainType, "");
//                ResponseData resp = new ResponseData("200", "success");
//                resp.setCount(reptcs.size());
//                resp.setData(reptcs);
//                return resp;
//            }
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    /**
//     * 更新维修描述,更新时间及诶单
//     *
//     * @param entity
//     * @param appid
//     * @param token
//     * @param type 打卡关卡
//     * @return
//     * @throws ParseException
//     */
//    @POST
//    @Path("update")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public ResponseMessage updateMaintainDescribe(REPTEApplication entity, @QueryParam("appid") String appid,
//            @QueryParam("token") String token, @QueryParam("type") String type) throws ParseException {
//        if (isAuthorized(appid, token)) {
//            StringBuffer msg = new StringBuffer("【上海汉钟】");
//            msg.append("维修单号：").append(entity.getMaintainNumberId()).append("-").append(entity.getMainSerial()).append(";");
//            msg.append(" 打卡时间:").append(entity.getPunchDate()).append(";");
//            msg.append("打卡关卡:");
//            REPTE repte = repteBean.findByPK(entity.getMaintainTypeId(), entity.getMaintainNumberId(), entity.getMainSerial());
//            switch (type) {
//                case "1":
//                    repte.setTe502(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe504(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe506(entity.getAddressView());
//                    msg.append("路程开始时间");
//                    break;
//                case "2":
//                    repte.setTe007(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe017(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe507(entity.getAddressView());
//                    msg.append("到达时间");
//                    if (repte.getTe018() != null && repte.getTe019() != null && !"".equals(repte.getTe018()) && !"".equals(repte.getTe019())) {
//                        Date arriveDate = BaseLib.getDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate());
//                        Date leaveDate = BaseLib.getDate("yyyyMMdd HHmm", repte.getTe018() + " " + repte.getTe019());
//                        if (arriveDate.getTime() < leaveDate.getTime()) {
//                            long maintaintime = leaveDate.getTime() - arriveDate.getTime();
//                            BigDecimal decimal = new BigDecimal((double) maintaintime / 1000 / 60 / 60);
//                            BigDecimal bdmt = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//                            repte.setTe010(bdmt);
//                        }
//                    }
//                    repte.setTe010(BigDecimal.TEN);
//                    break;
//                case "3":
//                    repte.setTe018(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe019(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe009(entity.getHandlingInfo());
//                    repte.setTe508(entity.getAddressView());
//                    msg.append("离开时间");
//                    if (repte.getTe007() != null && repte.getTe017() != null && !"".equals(repte.getTe007()) && !"".equals(repte.getTe017())) {
//                        Date arriveDate = BaseLib.getDate("yyyyMMdd HHmm", repte.getTe007() + " " + repte.getTe017());
//                        Date leaveDate = BaseLib.getDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate());
//                        if (arriveDate.getTime() < leaveDate.getTime()) {
//                            long maintaintime = leaveDate.getTime() - arriveDate.getTime();
//                            BigDecimal decimal = new BigDecimal((double) maintaintime / 1000 / 60 / 60);
//                            BigDecimal bdmt = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//                            repte.setTe010(bdmt);
//                        }
//                    }
//                    break;
//
//                case "4":
//                    repte.setTe503(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe505(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe509(entity.getAddressView());
//                    msg.append("路程结束时间");
//                    break;
//            }
//
//            repteBean.update(repte);
//            msg.append("; 地点:");
//            msg.append(entity.getAddressView());
//            try {
//                String errmsg = repteBean.sendMsgString(entity.getMaintainerId(), msg.toString(), entity.getSessionkey(), entity.getOpenId());
//                if (!"200".equals(errmsg)) {
//                    throw new Exception();
//                }
//            } catch (Exception e) {
//                ResponseData respdate = new ResponseData("500", "发送消息失败");
//                return respdate;
//            }
//            ResponseMessage rspm = new ResponseMessage("200", "success");
//            return rspm;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//
//    /**
//     * 创建维修描述
//     *
//     * @param entity
//     * @param appid
//     * @param token
//     * @param type 打卡关卡
//     * @return
//     */
//    @POST
//    @Path("create")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public ResponseData createMaintainDescribe(REPTEApplication entity, @QueryParam("appid") String appid,
//            @QueryParam("token") String token, @QueryParam("type") String type) {
//        if (isAuthorized(appid, token)) {
//            StringBuffer msg = new StringBuffer("【上海汉钟】");
//            msg.append("维修单号：").append(entity.getMaintainNumberId()).append("-").append(entity.getMainSerial()).append(";");
//            msg.append(" 打卡时间:").append(entity.getPunchDate()).append(";");
//            msg.append("打卡关卡:");
//            System.out.println("entity=" + entity);
//            String serl;
//            serl = repteBean.getTE004ByTE001AndTE002(entity.getMaintainTypeId(), entity.getMaintainNumberId());
//            REPTE repte = new REPTE();
//            REPTEPK reptepk = new REPTEPK();
//            repte.setCompany("CRMDB");
//            repte.setCreator(entity.getMaintainerId());
//            repte.setUsrGroup(entity.getDeptno());
//            repte.setCreateDate(BaseLib.formatDate("yyyyMMdd", new Date()));
//            repte.setFlag(new Short("1"));
//            reptepk.setTe001(entity.getMaintainTypeId());
//            reptepk.setTe002(entity.getMaintainNumberId());
//            reptepk.setTe004(serl);
//            repte.setREPTEPK(reptepk);
//            repte.setTe003(entity.getProblemId());
//            repte.setTe005(entity.getProblemName());
//            repte.setTe008(entity.getMaintainerId());
//            repte.setTe012(BigDecimal.ZERO);
//            repte.setTe013(BigDecimal.ZERO);
//            repte.setTe015(entity.getDeptno());
//            REPTC reptc = reptcBean.findByPK(entity.getMaintainTypeId(), entity.getMaintainNumberId());
//            repte.setTe024(reptc.getTc095());
//            repte.setTe500(BigDecimal.ZERO);
//            repte.setTe501(BigDecimal.ZERO);
//            switch (type) {
//                case "1":
//                    repte.setTe502(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe504(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe506(entity.getAddressView());
//                    msg.append("路程开始时间");
//                    break;
//                case "2":
//                    repte.setTe007(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe017(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe507(entity.getAddressView());
//                    msg.append("到达时间");
//                    break;
//                case "3":
//                    repte.setTe018(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe019(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe508(entity.getAddressView());
//                    repte.setTe009(entity.getHandlingInfo());
//                    msg.append("离开时间");
//                    break;
//                case "4":
//                    repte.setTe503(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "yyyyMMdd"));
//                    repte.setTe505(repteBean.proccessDate("yyyy/MM/dd HH:mm:ss", entity.getPunchDate(), "HHmm"));
//                    repte.setTe509(entity.getAddressView());
//                    msg.append("路程结束时间");
//                    break;
//            }
//            repteBean.persist(repte);
//            msg.append("; 地点:");
//            msg.append(entity.getAddressView());
//            try {
//                String errmsg = repteBean.sendMsgString(entity.getMaintainerId(), msg.toString(), entity.getSessionkey(), entity.getOpenId());
//                if (!"200".equals(errmsg)) {
//                    throw new Exception();
//                }
//            } catch (Exception e) {
//                ResponseData respdate = new ResponseData("500", "发送消息失败");
//                return respdate;
//            }
//            ResponseData respdate = new ResponseData("200", serl.toString());
//            return respdate;
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
//}
