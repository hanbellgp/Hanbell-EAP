/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eam.jrs;

import cn.hanbell.crm.app.REPTCApplication;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import cn.hanbell.eam.entity.AssetCard;
import cn.hanbell.eam.ejb.AssetCardBean;
import cn.hanbell.eam.ejb.AssetCardSpecialBean;
import cn.hanbell.eam.ejb.EquipmentRepairBean;
import cn.hanbell.eam.ejb.EquipmentRepairFileBean;
import cn.hanbell.eam.ejb.EquipmentRepairHelpersBean;
import cn.hanbell.eam.ejb.EquipmentRepairHisBean;
import cn.hanbell.eam.ejb.EquipmentRepairSpareBean;
import cn.hanbell.eam.ejb.EquipmentSpareBean;
import cn.hanbell.eam.ejb.EquipmentSpareRecodeBean;
import cn.hanbell.eam.ejb.EquipmentSpareRecodeDtaBean;
import cn.hanbell.eam.ejb.EquipmentTroubleBean;
import cn.hanbell.eam.ejb.SysCodeBean;
import cn.hanbell.eam.ejb.UnitBean;
import cn.hanbell.eam.entity.EquipmentRepair;
import cn.hanbell.eam.entity.EquipmentRepairFile;
import cn.hanbell.eam.entity.EquipmentRepairHelpers;
import cn.hanbell.eam.entity.EquipmentRepairHis;
import cn.hanbell.eam.entity.EquipmentRepairSpare;
import cn.hanbell.eam.entity.EquipmentSpare;
import cn.hanbell.eam.entity.EquipmentSpareRecode;
import cn.hanbell.eam.entity.EquipmentSpareRecodeDta;
import cn.hanbell.eam.entity.EquipmentSpareRecodeDtaResponse;
import cn.hanbell.eam.entity.EquipmentTrouble;
import cn.hanbell.eam.entity.SysCode;
import cn.hanbell.eam.entity.Unit;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAM;
import com.lightshell.comm.SuperEJB;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author C2090
 */
@Stateless
@Path("shbeam/equipmentrepair")
public class EquipmentRepairFacadeREST extends SuperRESTForEAM<EquipmentRepair> {

    @EJB
    private EquipmentRepairBean equipmentrepairBean;

    @EJB
    private EquipmentRepairFileBean equipmentrepairfileBean;

    @EJB
    private SystemUserBean systemUserBean;

    @EJB
    private SysCodeBean sysCodeBean;

    @EJB
    private EquipmentSpareBean equipmentSpareBean;

    @EJB
    private EquipmentTroubleBean equipmentTroubleBean;

    @EJB
    private EquipmentRepairSpareBean equipmentRepairSpareBean;

    @EJB
    private UnitBean unitBean;

    @EJB
    private EquipmentRepairHisBean equipmentRepairHisBean;

    @EJB
    private EquipmentRepairHelpersBean equipmentRepairHelpersBean;

    @EJB
    private EquipmentSpareRecodeBean equipmentSpareRecodeBean;

    @EJB
    private EquipmentSpareRecodeDtaBean equipmentSpareRecodeDtaBean;

    @EJB
    private AssetCardBean assetCardBeam;

    @EJB
    private AssetCardSpecialBean assetCardSpecialBean;

    protected SuperEJB superEJB;

    //生产环境
    private final String filePathTemp = "D:\\glassfish5\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
    //测试环境
    //  private final String filePathTemp = "D:\\Java\\glassfish5.0.1\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";

    @Override
    protected SuperEJB getSuperEJB() {
        return equipmentrepairBean;
    }

    public EquipmentRepairFacadeREST() {
        super(EquipmentRepair.class);
    }

    @POST
    @Path("createEqpRepairHad")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createEqpRepairHad(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("assetCardId") String assetCardId, @QueryParam("openId") String openId, @QueryParam("sessionKey") String sessionKey) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                List<SystemUser> sysUserList = new ArrayList<SystemUser>();
                EquipmentRepair equipInvenTemp = new EquipmentRepair();
                AssetCard assetCardTemp = new AssetCard();
                assetCardTemp = assetCardBeam.findById(Integer.parseInt(assetCardId));
                if (entity.getItemno().equals("AS000")) {//非盘点资产查询
                    assetCardTemp = assetCardSpecialBean.transitionAssetCardSpecial(assetCardSpecialBean.findById(Integer.parseInt(assetCardId)));
                }
                //String formid = equipmentrepairBean.getFormId(new Date(), "AP", "YYYYMMdd", 4);
                String formid = equipmentrepairBean.getFormId(new Date(), "PR", "YYMM", 4);
                String companyCodeStr = entity.getCompany();
                if (companyCodeStr == null || companyCodeStr.equals("")) {
                    return new ResponseMessage("303", "公司代号信息异常,请重新登录");
                }

                equipInvenTemp.setCompany(entity.getCompany());
                equipInvenTemp.setAssetno(assetCardTemp);
                equipInvenTemp.setRepairuser(entity.getRepairuser());
                equipInvenTemp.setRepairusername(entity.getRepairusername());
                equipInvenTemp.setFormdate(new Date());
                equipInvenTemp.setHitchtime(entity.getHitchtime());
                if (entity.getDowninitiatetime() != null && entity.getHitchurgency().equals("03")) {//补单的情况停机按补单输入的时间并且是选的停机才记录
                    equipInvenTemp.setDowninitiatetime(entity.getDowninitiatetime());
                }
                if (equipInvenTemp.getDowninitiatetime() == null && equipInvenTemp.getHitchurgency() == null && entity.getHitchurgency().equals("03")) {//第一次创单时，停机记录停机时间点
                    equipInvenTemp.setDowninitiatetime(entity.getHitchtime());
                }
                equipInvenTemp.setHitchurgency(entity.getHitchurgency());
                equipInvenTemp.setItemno(entity.getItemno());
                equipInvenTemp.setFormid(formid);
                equipInvenTemp.setTroublefrom(entity.getTroublefrom());
                equipInvenTemp.setRepairarea(entity.getRepairarea());
                equipInvenTemp.setRepairmethodtype(entity.getRepairmethodtype());
                equipInvenTemp.setHitchdesc(entity.getHitchdesc());
                equipInvenTemp.setStatus("N");
                equipInvenTemp.setRepairdeptno(entity.getRepairdeptno());
                equipInvenTemp.setRepairdeptname(entity.getRepairdeptname());
                equipInvenTemp.setExcepttime(0);
                equipInvenTemp.setStopworktime(0);
                equipInvenTemp.setIsneedspare(entity.getIsneedspare());
                equipInvenTemp.setRemark(entity.getRemark());
                equipInvenTemp.setCreator(entity.getCreator());
                equipInvenTemp.setCredate(new Date());
                //init value
//                equipInvenTemp.setFormid(entity.getFormid());
//                equipInvenTemp.setItnbr(entity.getItnbr());
//                equipInvenTemp.setItdsc(entity.getItdsc());
//                equipInvenTemp.setQty(entity.getQty());
//                equipInvenTemp.setUsername(entity.getUsername());
//                equipInvenTemp.setUserno(entity.getUserno());
//                equipInvenTemp.setAssetno(entity.getAssetno());
//                equipInvenTemp.setDeptno(entity.getDeptno());
//                equipInvenTemp.setDeptname(entity.getDeptname());
//                equipInvenTemp.setType(entity.getType());
//                equipInvenTemp.setAddress(entity.getAddress());
//                equipInvenTemp.setIaddress(entity.getIaddress());
//                equipInvenTemp.setFormuser(entity.getFormuser());
//                LocalDateTime localDateTime = LocalDateTime.now();
//                Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
//                equipInvenTemp.setFormdate(date);
//                equipInvenTemp.setDmark(entity.getDmark());

                if ("2".equals(entity.getRepairmethodtype()) && (entity.getServiceuser() == null || entity.getServiceuser().equals(""))) {
                    equipInvenTemp.setServiceuser(entity.getRepairuser());
                    equipInvenTemp.setServiceusername(entity.getRepairusername());
                } else {
                    equipInvenTemp.setServiceuser(entity.getServiceuser());
                    equipInvenTemp.setServiceusername(entity.getServiceusername());
                }

                if (entity.getServicearrivetime() != null) {
                    equipInvenTemp.setServicearrivetime(entity.getServicearrivetime());
                    if (entity.getCompletetime() != null) {
                        equipInvenTemp.setCompletetime(entity.getCompletetime());
                        if ("2".equals(entity.getRepairmethodtype())) {
                            equipInvenTemp.setRstatus("95");
                        } else {
                            equipInvenTemp.setRstatus("30");
                            Long time2 = equipInvenTemp.getHitchtime().getTime();
                            Long time = equipInvenTemp.getCompletetime().getTime();
                            int min = (int) ((time - time2) / (60 * 1000));//获取开始到完成的时间分钟数
                            //当状态为停线时停机时间为维修开始时间到维修完成时间
                            if (equipInvenTemp.getHitchurgency().equals("03")) {
                                equipInvenTemp.setStopworktime(min);
                            }
                        }
                    } else {
                        equipInvenTemp.setRstatus("20");
                    }
                } else {
                    equipInvenTemp.setRstatus("10");
                }

                equipmentrepairBean.persist(equipInvenTemp);

                if ((!"2".equals(entity.getRepairmethodtype())) && assetCardTemp != null) {
                    StringBuffer msg = new StringBuffer("收到新的报修单:");
                    StringBuffer userStrTemp = new StringBuffer(entity.getServiceuser().toUpperCase());
                    msg.append(formid).append("<br/>");
                    msg.append("资产编号:").append(assetCardTemp.getFormid()).append("<br/>");
                    msg.append("设备名称:").append(assetCardTemp.getAssetDesc()).append("<br/>");
                    msg.append("设备位置:").append(assetCardTemp.getPosition1().getName()).append(assetCardTemp.getPosition2().getName());
                    if (assetCardTemp.getPosition3() != null) {
                        msg.append(assetCardTemp.getPosition3().getName()).append("<br/>");
                    } else {
                        msg.append("<br/>");
                    }
                    msg.append("报修人:").append(entity.getRepairuser()).append("-").append(entity.getRepairusername()).append("<br/>");
                    msg.append("维修人:").append(entity.getServiceuser()).append("-").append(entity.getServiceusername()).append("<br/>");
                    msg.append("详情请至微信小程序查看!");

                    //sysUserList = systemUserBean.findByDeptno("1W300");
                    String repairDeptMangerId = sysCodeBean.findBySyskindAndCode(companyCodeStr, "RD", "repairleaders").getCvalue();

                    if (repairDeptMangerId != null && !repairDeptMangerId.equals("")) {
                        userStrTemp.append("|").append(repairDeptMangerId.toUpperCase());
                    }

                    if ("C0-1".equalsIgnoreCase(assetCardTemp.getPosition2().getPosition())) {
                        userStrTemp.append("|").append("C0299");
                    } else if ("C0-2".equalsIgnoreCase(assetCardTemp.getPosition2().getPosition())) {
                        userStrTemp.append("|").append("C0141");
                    }

                    String errmsg = sendMsgString(userStrTemp.toString(), msg.toString(), sessionKey, openId);

                    // 发送失败，抛异常，使事务回滚
                    if (!"200".equals(errmsg)) {
                        //throw new RuntimeException("发送失败,请联系管理员");
                        return new ResponseMessage("203", formid);
                    }
                } else if (assetCardTemp == null) {
                    StringBuffer msg = new StringBuffer("收到新的报修单:");
                    StringBuffer userStrTemp = new StringBuffer(entity.getServiceuser().toUpperCase());
                    msg.append(formid).append("<br/>");
                    msg.append("资产编号:").append("无<br/>");
                    msg.append("设备名称:").append("其他设备<br/>");
                    msg.append("设备位置:").append(entity.getRepairarea()).append("<br/>");
                    msg.append("报修人:").append(entity.getRepairuser()).append("-").append(entity.getRepairusername()).append("<br/>");
                    msg.append("维修人:").append(entity.getServiceuser()).append("-").append(entity.getServiceusername()).append("<br/>");
                    msg.append("详情请至微信小程序查看!");

//                    sysUserList = systemUserBean.findByDeptno("1W300");
//                    if(sysUserList.size() > 0)
//                    {
//                        userStrTemp.append("|").append(sysUserList.get(0).getUserid().toUpperCase());
//                    }
                    String repairDeptMangerId = sysCodeBean.findBySyskindAndCode(companyCodeStr, "RD", "repairleaders").getCvalue();

                    if (repairDeptMangerId != null && !repairDeptMangerId.equals("")) {
                        userStrTemp.append("|").append(repairDeptMangerId.toUpperCase());
                    }

                    if ("枫泾厂".equalsIgnoreCase(entity.getRepairarea()) || "枫泾总部".equalsIgnoreCase(entity.getRepairarea())) {
                        userStrTemp.append("|").append("C0299");
                    } else if ("兴塔厂".equalsIgnoreCase(entity.getRepairarea()) || "枫泾一厂".equalsIgnoreCase(entity.getRepairarea())) {
                        userStrTemp.append("|").append("C0141");
                    }

                    String errmsg = sendMsgString(userStrTemp.toString(), msg.toString(), sessionKey, openId);

                    // 发送失败，抛异常，使事务回滚
                    if (!"200".equals(errmsg)) {
                        //throw new RuntimeException("发送失败,请联系管理员");
                        return new ResponseMessage("203", formid);
                    }
                }

                return new ResponseMessage("200", formid);
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("sendRepairMessage")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage sendRepairMessage(REPTCApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                StringBuffer msg = new StringBuffer("收到一条消息(test)");
                String errmsg = sendMsgString(entity.getEmployeeId().toString(), msg.toString(),
                        entity.getSessionkey(), entity.getOpenId());
                // 发送失败，抛异常，使事务回滚
                if (!"200".equals(errmsg)) {
                    throw new RuntimeException("发送失败,请联系管理员");
                }

                return new ResponseMessage("200", "发送成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("deleteRepairDoc")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_deleteRepairDoc(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                EquipmentRepair equipInvenTemp = new EquipmentRepair();

                if (entity.getId() != null) {
                    equipInvenTemp = equipmentrepairBean.findById(entity.getId());
                    if (equipInvenTemp != null) {
                        equipInvenTemp.setRstatus("98");
                        equipmentrepairBean.persist(equipInvenTemp);
                    }
                }
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("serviceStart")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_serviceStart(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("itemno") String itemno, @QueryParam("assetCardId") String assetCardId) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                EquipmentRepair equipInvenTemp = new EquipmentRepair();

                if (entity.getId() != null) {
                    equipInvenTemp = equipmentrepairBean.findById(entity.getId());
                    if (equipInvenTemp != null) {
                        equipInvenTemp.setRstatus("20");
                        equipInvenTemp.setServicearrivetime(new Date());
                        equipmentrepairBean.persist(equipInvenTemp);
                    }
                }
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("repairFinish")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_repairFinish(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                EquipmentRepair equipInvenTemp = new EquipmentRepair();

                if (entity.getId() != null) {
                    equipInvenTemp = equipmentrepairBean.findById(entity.getId());

                    if (equipInvenTemp != null) {
                        //检查是否需要领取备件
                        if (equipInvenTemp.getIsneedspare() != null && equipInvenTemp.getIsneedspare().equals("Y")) {
                            List<EquipmentSpareRecode> spareRecodeCheckList = new ArrayList<>();
                            Map<String, Object> filterFields = new HashMap<>();
                            Map<String, String> sortFields = new LinkedHashMap<>();
                            filterFields.put("relano", equipInvenTemp.getFormid());
                            filterFields.put("ExistForm", "ExistForm");
                            spareRecodeCheckList = equipmentSpareRecodeBean.getEquipmentRepairListByNativeQuery(filterFields, sortFields);
                            if (spareRecodeCheckList.size() < 1) {
                                return new ResponseMessage("503", "请先领取备件后再确认维修完成!");
                            }
                        }

                        if ("2".equals(equipInvenTemp.getRepairmethodtype())) {
                            equipInvenTemp.setRstatus("95");
                        } else {
                            equipInvenTemp.setRstatus("30");
                        }
//                        equipInvenTemp.setHitchtype(entity.getHitchtype());
//                        equipInvenTemp.setRepairmethod(entity.getRepairmethod());

                        equipInvenTemp.setCompletetime(new Date());
                        Long time2 = equipInvenTemp.getHitchtime().getTime();
                        Long time = equipInvenTemp.getCompletetime().getTime();
                        int min = (int) ((time - time2) / (60 * 1000));//获取开始到完成的时间分钟数
                        //当状态为停线时停机时间为维修开始时间到维修完成时间
                        if (equipInvenTemp.getHitchurgency().equals("03")) {
                            equipInvenTemp.setStopworktime(min);
                        }
                        equipmentrepairBean.persist(equipInvenTemp);
                    }
                }
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("repairAudit")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_repairAudit(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                String companyCodeStr = entity.getCompany();
                if (companyCodeStr == null || companyCodeStr.equals("")) {
                    return new ResponseMessage("303", "公司代号信息异常,请重新登录");
                }
                Map<String, Object> filterFields_spareUsed = new HashMap<>();
                EquipmentRepair equipInvenTemp = new EquipmentRepair();
                EquipmentRepairSpare eqpRepairSpareTemp = new EquipmentRepairSpare();
                EquipmentRepairHelpers eqpRepairHelperTemp = new EquipmentRepairHelpers();
                List<EquipmentSpare> eqpSpareListTemp = new ArrayList<EquipmentSpare>();
                List<EquipmentRepairSpare> eqpRepairSpareListTemp = new ArrayList<EquipmentRepairSpare>();
                EquipmentSpare eqpSpareTemp = new EquipmentSpare();
                Unit unitTemp = new Unit();

                JSONArray jsonArray = new JSONArray(entity.getRemark());

                //JSONArray spareUsedList_jsonArray = jsonArray.getJSONArray(0);
                JSONArray repairHelperList_jsonArray = jsonArray.getJSONArray(0);

                JSONObject jsonObj = new JSONObject();

                for (Object jobj : repairHelperList_jsonArray) {
                    jsonObj = (JSONObject) jobj;
                    eqpRepairHelperTemp = new EquipmentRepairHelpers();

                    if (jsonObj.has("docId")) {
                        eqpRepairHelperTemp = equipmentRepairHelpersBean.findById(jsonObj.getInt("docId"));
                        if (eqpRepairHelperTemp != null) {
                            eqpRepairHelperTemp.setUserno(jsonObj.getString("UserNo"));
                            equipmentRepairHelpersBean.persist(eqpRepairHelperTemp);
                        }
                    } else {
                        List<EquipmentRepairHelpers> eqpRepairHelperList = equipmentRepairHelpersBean.findByPId(entity.getFormid());

                        int helperIndexMaxTemp = 0;

                        if (eqpRepairHelperList == null || eqpRepairHelperList.size() < 1) {
                            helperIndexMaxTemp = 1;
                        } else {
                            for (int i = 0; i < eqpRepairHelperList.size(); i++) {
                                if (eqpRepairHelperList.get(i).getSeq() >= helperIndexMaxTemp) {
                                    helperIndexMaxTemp = eqpRepairHelperList.get(i).getSeq();
                                }
                            }
                            helperIndexMaxTemp = helperIndexMaxTemp + 1;
                        }

                        eqpRepairHelperTemp.setCompany(entity.getCompany());
                        eqpRepairHelperTemp.setPid(entity.getFormid());
                        eqpRepairHelperTemp.setSeq(helperIndexMaxTemp);
                        eqpRepairHelperTemp.setRtype("1");
                        eqpRepairHelperTemp.setCurnode(jsonObj.getString("CurNode"));
                        eqpRepairHelperTemp.setCurnode2(jsonObj.getString("CurNode2"));
                        eqpRepairHelperTemp.setUserno(jsonObj.getString("UserNo"));
                        eqpRepairHelperTemp.setStatus("N");
                        eqpRepairHelperTemp.setCredate(new Date());

                        equipmentRepairHelpersBean.persist(eqpRepairHelperTemp);
                    }
                }

                if (entity.getId() != null) {
                    equipInvenTemp = equipmentrepairBean.findById(entity.getId());
                    List<SysCode> sysLaborCostList = new ArrayList<SysCode>();
                    String currentStatus = "";
                    if (equipInvenTemp != null) {
                        currentStatus = equipInvenTemp.getRstatus();
                        if (currentStatus != null && currentStatus.equals("30")) {
                            currentStatus = "维修完成";
                        } else {
                            currentStatus = "维修验收";
                        }

                        if (entity.getHitchdutyuser() != null) {
                            equipInvenTemp.setRstatus("50");
                            equipInvenTemp.setHitchdutydeptno(entity.getHitchdutydeptno());
                            equipInvenTemp.setHitchdutydeptname(entity.getHitchdutydeptname());
                            equipInvenTemp.setHitchdutyuser(entity.getHitchdutyuser());
                            equipInvenTemp.setHitchdutyusername(entity.getHitchdutyusername());

                            StringBuffer msg = new StringBuffer("请填写故障改善措施!<br/>");
                            msg.append("报修单号:").append(equipInvenTemp.getFormid()).append("<br/>");
                            msg.append("资产编号:").append(equipInvenTemp.getAssetno().getFormid()).append("<br/>");
                            msg.append("设备名称:").append(equipInvenTemp.getAssetno().getAssetDesc()).append("<br/>");
                            msg.append("设备位置:").append(equipInvenTemp.getAssetno().getPosition1().getName()).append(equipInvenTemp.getAssetno().getPosition2().getName());
                            if (equipInvenTemp.getAssetno().getPosition3() != null) {
                                msg.append(equipInvenTemp.getAssetno().getPosition3().getName()).append("<br/>");
                            } else {
                                msg.append("<br/>");
                            }
                            msg.append("报修人:").append(equipInvenTemp.getRepairuser()).append("-").append(equipInvenTemp.getRepairusername()).append("<br/>");
                            msg.append("维修人:").append(equipInvenTemp.getServiceuser()).append("-").append(equipInvenTemp.getServiceusername()).append("<br/>");
                            msg.append("详情请至微信小程序查看!");

                            String errmsg = sendMsgString(entity.getHitchdutyuser(), msg.toString(), "ca80bf276a4948909ff4197095f1103a", "oJJhp5GvX45x3nZgoX9Ae9DyWak4");
                        } else {
                            if (companyCodeStr.equals("C")) {
                                equipInvenTemp.setRstatus("55");
                            } else {
                                equipInvenTemp.setRstatus("60");
                            }
                            equipInvenTemp.setHitchdutydeptno(null);
                            equipInvenTemp.setHitchdutydeptname(null);
                            equipInvenTemp.setHitchdutyuser(null);
                            equipInvenTemp.setHitchdutyusername(null);
                        }

                        String laborCost = "";
                        sysLaborCostList = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "laborcost");
                        if (sysLaborCostList.size() > 0) {
                            laborCost = sysLaborCostList.get(0).getCvalue();
                        }

                        equipInvenTemp.setExcepttime(entity.getExcepttime());
                        equipInvenTemp.setStopworktime(entity.getStopworktime());
                        equipInvenTemp.setAbrasehitch(entity.getAbrasehitch());
                        equipInvenTemp.setHitchtype(entity.getHitchtype());
                        equipInvenTemp.setHitchsort1(entity.getHitchsort1());
                        equipInvenTemp.setHitchdesc(entity.getHitchdesc());
                        equipInvenTemp.setHitchalarm(entity.getHitchalarm());
                        equipInvenTemp.setHitchreason(entity.getHitchreason());
                        equipInvenTemp.setRepairmethod(entity.getRepairmethod());
                        equipInvenTemp.setRepairprocess(entity.getRepairprocess());
                        equipInvenTemp.setMeasure(entity.getMeasure());
                        equipInvenTemp.setSparecost(entity.getSparecost());
                        equipInvenTemp.setRepaircost(entity.getRepaircost());
                        equipInvenTemp.setLaborcosts(entity.getLaborcosts());
                        equipInvenTemp.setLaborcost(laborCost);
                        equipInvenTemp.setRemark(entity.getOptuser());
                        equipInvenTemp.setStatus("N");
                        equipmentrepairBean.persist(equipInvenTemp);

                        //在辅助人员表中插入维修人自己的信息方便报表开发
                        List<EquipmentRepairHelpers> eqpRepairHelperList = equipmentRepairHelpersBean.findByPId(equipInvenTemp.getFormid());
                        boolean findMainRepairFlag = false;
                        int helperIndexMaxTemp = 0;

                        if (eqpRepairHelperList == null || eqpRepairHelperList.size() < 1) {
                            helperIndexMaxTemp = 0;
                        } else {
                            for (int i = 0; i < eqpRepairHelperList.size(); i++) {
                                if (equipInvenTemp.getServiceuser().equalsIgnoreCase(eqpRepairHelperList.get(i).getCurnode())) {
                                    findMainRepairFlag = true;
                                    eqpRepairHelperTemp = eqpRepairHelperList.get(i);
                                    helperIndexMaxTemp = eqpRepairHelperList.get(i).getSeq();
                                    break;
                                }
                                if (eqpRepairHelperList.get(i).getSeq() >= helperIndexMaxTemp) {
                                    helperIndexMaxTemp = eqpRepairHelperList.get(i).getSeq();
                                }
                            }
                        }

                        if (!findMainRepairFlag) {
                            eqpRepairHelperTemp = new EquipmentRepairHelpers();
                            helperIndexMaxTemp = helperIndexMaxTemp + 1;
                        }

                        Date arriveDate = equipInvenTemp.getServicearrivetime();
                        Date finishDate = equipInvenTemp.getCompletetime();

                        long dateDiff = 0;
                        if (finishDate != null) {
                            dateDiff = finishDate.getTime() - arriveDate.getTime();
                        }

                        double minuteDiff = (dateDiff / (1000 * 60)) - equipInvenTemp.getExcepttime();
                        eqpRepairHelperTemp.setCompany(equipInvenTemp.getCompany());
                        eqpRepairHelperTemp.setPid(equipInvenTemp.getFormid());
                        eqpRepairHelperTemp.setSeq(helperIndexMaxTemp);
                        eqpRepairHelperTemp.setRtype("0");
                        eqpRepairHelperTemp.setCurnode(equipInvenTemp.getServiceuser());
                        eqpRepairHelperTemp.setCurnode2(equipInvenTemp.getServiceusername());
                        eqpRepairHelperTemp.setUserno(String.format("%.2f", minuteDiff));
                        eqpRepairHelperTemp.setStatus("N");
                        eqpRepairHelperTemp.setCredate(new Date());

                        equipmentRepairHelpersBean.persist(eqpRepairHelperTemp);
                    } else {
                        return new ResponseMessage("301", "数据库异常");
                    }

                    List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                    EquipmentRepairHis eqpRepairTemp = new EquipmentRepairHis();
                    eqpRepairList = equipmentRepairHisBean.findByPId(entity.getFormid());

                    int maxIndex = 0;
                    for (int i = 0; i < eqpRepairList.size(); i++) {
                        if (eqpRepairList.get(i).getSeq() > i) {
                            maxIndex = eqpRepairList.get(i).getSeq();
                        }
                    }
                    maxIndex++;

                    eqpRepairTemp.setCompany(entity.getCompany());
                    eqpRepairTemp.setPid(entity.getFormid());
                    eqpRepairTemp.setSeq(maxIndex);
                    eqpRepairTemp.setUserno(equipInvenTemp.getServiceuser());
                    eqpRepairTemp.setCurnode(currentStatus);
                    eqpRepairTemp.setContenct("发起验收");
                    eqpRepairTemp.setNote(entity.getCfmuser());
                    eqpRepairTemp.setStatus("N");
                    eqpRepairTemp.setCredate(new Date());

                    equipmentRepairHisBean.persist(eqpRepairTemp);
                } else {
                    return new ResponseMessage("300", "数据异常更新失败");
                }
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("saveAuditDta")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_saveAuditDta(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                String companyCodeStr = entity.getCompany();
                if (companyCodeStr == null || companyCodeStr.equals("")) {
                    return new ResponseMessage("303", "公司代号信息异常,请重新登录");
                }
                Map<String, Object> filterFields_spareUsed = new HashMap<>();
                EquipmentRepair equipInvenTemp = new EquipmentRepair();
                EquipmentRepairSpare eqpRepairSpareTemp = new EquipmentRepairSpare();
                EquipmentRepairHelpers eqpRepairHelperTemp = new EquipmentRepairHelpers();
                List<EquipmentSpare> eqpSpareListTemp = new ArrayList<EquipmentSpare>();
                List<EquipmentRepairSpare> eqpRepairSpareListTemp = new ArrayList<EquipmentRepairSpare>();
                EquipmentSpare eqpSpareTemp = new EquipmentSpare();
                Unit unitTemp = new Unit();

                JSONArray jsonArray = new JSONArray(entity.getRemark());

                //JSONArray spareUsedList_jsonArray = jsonArray.getJSONArray(0);
                JSONArray repairHelperList_jsonArray = jsonArray.getJSONArray(0);

                JSONObject jsonObj = new JSONObject();

                for (Object jobj : repairHelperList_jsonArray) {
                    jsonObj = (JSONObject) jobj;
                    eqpRepairHelperTemp = new EquipmentRepairHelpers();

                    if (jsonObj.has("docId")) {
                        eqpRepairHelperTemp = equipmentRepairHelpersBean.findById(jsonObj.getInt("docId"));
                        if (eqpRepairHelperTemp != null) {
                            eqpRepairHelperTemp.setUserno(jsonObj.getString("UserNo"));
                            equipmentRepairHelpersBean.persist(eqpRepairHelperTemp);
                        }
                    } else {
                        List<EquipmentRepairHelpers> eqpRepairHelperList = equipmentRepairHelpersBean.findByPId(entity.getFormid());

                        int helperIndexMaxTemp = 0;

                        if (eqpRepairHelperList == null || eqpRepairHelperList.size() < 1) {
                            helperIndexMaxTemp = 1;
                        } else {
                            for (int i = 0; i < eqpRepairHelperList.size(); i++) {
                                if (eqpRepairHelperList.get(i).getSeq() >= helperIndexMaxTemp) {
                                    helperIndexMaxTemp = eqpRepairHelperList.get(i).getSeq();
                                }
                            }
                            helperIndexMaxTemp = helperIndexMaxTemp + 1;
                        }

                        eqpRepairHelperTemp.setCompany(entity.getCompany());
                        eqpRepairHelperTemp.setPid(entity.getFormid());
                        eqpRepairHelperTemp.setSeq(helperIndexMaxTemp);
                        eqpRepairHelperTemp.setRtype("1");
                        eqpRepairHelperTemp.setCurnode(jsonObj.getString("CurNode"));
                        eqpRepairHelperTemp.setCurnode2(jsonObj.getString("CurNode2"));
                        eqpRepairHelperTemp.setUserno(jsonObj.getString("UserNo"));
                        eqpRepairHelperTemp.setStatus("N");
                        eqpRepairHelperTemp.setCredate(new Date());

                        equipmentRepairHelpersBean.persist(eqpRepairHelperTemp);
                    }
                }

                if (entity.getId() != null) {
                    equipInvenTemp = equipmentrepairBean.findById(entity.getId());
                    List<SysCode> sysLaborCostList = new ArrayList<SysCode>();
                    if (equipInvenTemp != null) {
                        if (entity.getHitchdutyuser() != null) {
                            equipInvenTemp.setHitchdutydeptno(entity.getHitchdutydeptno());
                            equipInvenTemp.setHitchdutydeptname(entity.getHitchdutydeptname());
                            equipInvenTemp.setHitchdutyuser(entity.getHitchdutyuser());
                            equipInvenTemp.setHitchdutyusername(entity.getHitchdutyusername());
                        }

                        String laborCost = "";
                        sysLaborCostList = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "laborcost");
                        if (sysLaborCostList.size() > 0) {
                            laborCost = sysLaborCostList.get(0).getCvalue();
                        }

                        String rStatus = equipInvenTemp.getRstatus();
                        if (rStatus.compareTo("30") < 0) {
                            equipInvenTemp.setRstatus("25");
                        } else {
                            equipInvenTemp.setRstatus("40");
                        }

                        equipInvenTemp.setExcepttime(entity.getExcepttime());
                        equipInvenTemp.setStopworktime(entity.getStopworktime());
                        equipInvenTemp.setAbrasehitch(entity.getAbrasehitch());
                        if (!equipInvenTemp.getHitchurgency().equals("03") && equipInvenTemp.getHitchtype() == null && entity.getHitchtype().equals("03")) {
                            equipInvenTemp.setDowninitiatetime(new Date());
                        }
                        equipInvenTemp.setHitchtype(entity.getHitchtype());
                        equipInvenTemp.setHitchsort1(entity.getHitchsort1());
                        equipInvenTemp.setHitchdesc(entity.getHitchdesc());
                        equipInvenTemp.setHitchalarm(entity.getHitchalarm());
                        equipInvenTemp.setHitchreason(entity.getHitchreason());
                        equipInvenTemp.setRepairmethod(entity.getRepairmethod());
                        equipInvenTemp.setRepairprocess(entity.getRepairprocess());
                        equipInvenTemp.setMeasure(entity.getMeasure());
                        equipInvenTemp.setSparecost(entity.getSparecost());
                        equipInvenTemp.setRepaircost(entity.getRepaircost());
                        equipInvenTemp.setLaborcosts(entity.getLaborcosts());
                        equipInvenTemp.setLaborcost(laborCost);
                        equipInvenTemp.setRemark(entity.getOptuser());
                        equipInvenTemp.setStatus("N");
                        equipmentrepairBean.persist(equipInvenTemp);
                    } else {
                        return new ResponseMessage("301", "数据库异常");
                    }

                } else {
                    return new ResponseMessage("300", "数据异常更新失败");
                }
                return new ResponseMessage("200", "数据保存成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("repairAuditApprove")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_repairAuditApprove(EquipmentRepairHis entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                EquipmentRepairHis eqpRepairTemp = new EquipmentRepairHis();
                List<EquipmentRepair> equipInvenList = new ArrayList<EquipmentRepair>();
                equipInvenList = equipmentrepairBean.findByFormid(entity.getPid());
                if (equipInvenList.size() > 0) {
                    if (!entity.getContenct().equals("合格")) {
                        equipInvenList.get(0).setRstatus("40");
                    } else {
                        String needArchiveFlag = entity.getStatus();
                        BigDecimal totalCost = BigDecimal.ZERO;
                        BigDecimal laborCosts = equipInvenList.get(0).getLaborcosts() == null ? BigDecimal.ZERO : equipInvenList.get(0).getLaborcosts();
                        //BigDecimal repairCost = equipInvenList.get(0).getRepaircost() == null ? BigDecimal.ZERO:equipInvenList.get(0).getRepaircost();
                        BigDecimal repairCost = new BigDecimal(entity.getCreator());
                        BigDecimal spareCost = equipInvenList.get(0).getSparecost() == null ? BigDecimal.ZERO : equipInvenList.get(0).getSparecost();
                        totalCost = totalCost.add(laborCosts).add(repairCost).add(spareCost);
                        equipInvenList.get(0).setRepaircost(repairCost);
                        equipInvenList.get(0).setRepairarchive(needArchiveFlag);
                        if (totalCost.compareTo(new BigDecimal("5000")) >= 0 || needArchiveFlag.equals("Y")) {
                            equipInvenList.get(0).setRstatus("70");
                        } else {
                            equipInvenList.get(0).setRstatus("95");
                        }
                    }
                    equipInvenList.get(0).setRemark(entity.getRemark());
                    equipInvenList.get(0).setStatus("N");
                    equipmentrepairBean.persist(equipInvenList.get(0));
                } else {
                    return new ResponseMessage("301", "数据库异常");
                }

                eqpRepairList = equipmentRepairHisBean.findByPId(entity.getPid());
                int maxIndex = 0;
                for (int i = 0; i < eqpRepairList.size(); i++) {
                    if (eqpRepairList.get(i).getSeq() > i) {
                        maxIndex = eqpRepairList.get(i).getSeq();
                    }
                }
                maxIndex++;

                eqpRepairTemp.setPid(entity.getPid());
                eqpRepairTemp.setCompany(entity.getCompany());
                eqpRepairTemp.setSeq(maxIndex);
                eqpRepairTemp.setCurnode("课长审核");
                eqpRepairTemp.setUserno(entity.getUserno());
                eqpRepairTemp.setContenct(entity.getContenct());
                eqpRepairTemp.setNote(entity.getNote());
                eqpRepairTemp.setStatus("N");
                eqpRepairTemp.setCredate(new Date());

                equipmentRepairHisBean.persist(eqpRepairTemp);
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("repairAuditExam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_repairAuditExam(EquipmentRepairHis entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                EquipmentRepairHis eqpRepairTemp = new EquipmentRepairHis();
                List<EquipmentRepair> equipInvenList = new ArrayList<EquipmentRepair>();
                equipInvenList = equipmentrepairBean.findByFormid(entity.getPid());
                if (equipInvenList.size() > 0) {
                    if (!entity.getContenct().equals("合格")) {
                        equipInvenList.get(0).setRstatus("60");
                    } else {
                        equipInvenList.get(0).setRstatus("95");
                    }
                    equipInvenList.get(0).setRemark(entity.getRemark());
                    equipInvenList.get(0).setStatus("N");
                    equipmentrepairBean.persist(equipInvenList.get(0));
                } else {
                    return new ResponseMessage("301", "数据库异常");
                }

                eqpRepairList = equipmentRepairHisBean.findByPId(entity.getPid());
                int maxIndex = 0;
                for (int i = 0; i < eqpRepairList.size(); i++) {
                    if (eqpRepairList.get(i).getSeq() > i) {
                        maxIndex = eqpRepairList.get(i).getSeq();
                    }
                }
                maxIndex++;

                eqpRepairTemp.setCompany(entity.getCompany());
                eqpRepairTemp.setPid(entity.getPid());
                eqpRepairTemp.setSeq(maxIndex);
                eqpRepairTemp.setCurnode("经理审核");
                eqpRepairTemp.setUserno(entity.getUserno());
                eqpRepairTemp.setContenct(entity.getContenct());
                eqpRepairTemp.setNote(entity.getNote());
                eqpRepairTemp.setStatus("N");
                eqpRepairTemp.setCredate(new Date());

                equipmentRepairHisBean.persist(eqpRepairTemp);
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("dutyResponse")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_dutyResponse(EquipmentRepairHis entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                EquipmentRepairHis eqpRepairTemp = new EquipmentRepairHis();
                List<EquipmentRepair> equipInvenList = new ArrayList<EquipmentRepair>();
                equipInvenList = equipmentrepairBean.findByFormid(entity.getPid());
                if (equipInvenList.size() > 0) {
                    if (!entity.getContenct().equals("接受")) {
                        equipInvenList.get(0).setRstatus("40");
                    } else {
                        equipInvenList.get(0).setRstatus("60");
                    }
                    equipInvenList.get(0).setStatus("N");
                    equipmentrepairBean.persist(equipInvenList.get(0));
                } else {
                    return new ResponseMessage("301", "数据库异常");
                }

                eqpRepairList = equipmentRepairHisBean.findByPId(entity.getPid());
                int maxIndex = 0;
                for (int i = 0; i < eqpRepairList.size(); i++) {
                    if (eqpRepairList.get(i).getSeq() > i) {
                        maxIndex = eqpRepairList.get(i).getSeq();
                    }
                }
                maxIndex++;

                eqpRepairTemp.setCompany(entity.getCompany());
                eqpRepairTemp.setPid(entity.getPid());
                eqpRepairTemp.setSeq(maxIndex);
                eqpRepairTemp.setUserno(entity.getUserno());
                eqpRepairTemp.setCurnode("责任回复");
                eqpRepairTemp.setContenct(entity.getContenct());
                eqpRepairTemp.setNote(entity.getNote());
                eqpRepairTemp.setStatus("N");
                eqpRepairTemp.setCredate(new Date());

                equipmentRepairHisBean.persist(eqpRepairTemp);
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("repairStop")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_repairStop(EquipmentRepairHis entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                EquipmentRepairHis eqpRepairTemp = new EquipmentRepairHis();
                List<EquipmentRepair> equipInvenList = new ArrayList<EquipmentRepair>();
                equipInvenList = equipmentrepairBean.findByFormid(entity.getPid());
                String rStatus = equipInvenList.get(0).getRstatus();
                String currentStatus = "";
                if (rStatus.compareTo("20") >= 0 && rStatus.compareTo("30") < 0 && (!rStatus.equals("28"))) {
                    if (rStatus.equals("20")) {
                        currentStatus = "维修到达";
                    } else {
                        currentStatus = "维修中";
                    }
                    equipInvenList.get(0).setRstatus("28");
                    equipInvenList.get(0).setStatus("N");
                    equipmentrepairBean.persist(equipInvenList.get(0));
                } else {
                    return new ResponseMessage("301", "数据库异常");
                }

                eqpRepairList = equipmentRepairHisBean.findByPId(entity.getPid());
                int maxIndex = 0;
                for (int i = 0; i < eqpRepairList.size(); i++) {
                    if (eqpRepairList.get(i).getSeq() > i) {
                        maxIndex = eqpRepairList.get(i).getSeq();
                    }
                }
                maxIndex++;

                eqpRepairTemp.setCompany(entity.getCompany());
                eqpRepairTemp.setPid(entity.getPid());
                eqpRepairTemp.setSeq(maxIndex);
                eqpRepairTemp.setUserno(entity.getUserno());
                eqpRepairTemp.setCurnode(currentStatus);
                eqpRepairTemp.setContenct(entity.getContenct());
                eqpRepairTemp.setNote(entity.getNote());
                eqpRepairTemp.setStatus("N");
                eqpRepairTemp.setCredate(new Date());

                equipmentRepairHisBean.persist(eqpRepairTemp);
                StringBuffer msg = new StringBuffer(" 维修暂停通知:<br/>");
                msg.append("报修单号:").append(equipInvenList.get(0).getFormid()).append("<br/>");
                msg.append("资产编号:").append(equipInvenList.get(0).getAssetno().getFormid()).append("<br/>");
                msg.append("设备名称:").append(equipInvenList.get(0).getAssetno().getAssetDesc()).append("<br/>");
                msg.append("设备位置:").append(equipInvenList.get(0).getAssetno().getPosition1().getName()).append(equipInvenList.get(0).getAssetno().getPosition2().getName());
                if (equipInvenList.get(0).getAssetno().getPosition3() != null) {
                    msg.append(equipInvenList.get(0).getAssetno().getPosition3().getName()).append("<br/>");
                } else {
                    msg.append("<br/>");
                }
                msg.append("暂停原因:").append(entity.getNote()).append("<br/>");
                msg.append("报修人:").append(equipInvenList.get(0).getRepairuser()).append("-").append(equipInvenList.get(0).getRepairusername()).append("<br/>");
                msg.append("维修人:").append(equipInvenList.get(0).getServiceuser()).append("-").append(equipInvenList.get(0).getServiceusername()).append("<br/>");
                msg.append("详情请至微信小程序查看!");

                List<String> userList = new ArrayList<String>();
                userList.add(equipInvenList.get(0).getRepairuser());
                List<SysCode> code = sysCodeBean.getTroubleNameList(equipInvenList.get(0).getCompany(), "RD", "repairleaders");//获取维修的课长
                for (SysCode sysCode : code) {
                    userList.add(sysCode.getCvalue());//添加维修课长
                }
                code = sysCodeBean.getTroubleNameList(equipInvenList.get(0).getCompany(), "RD", "repairHeadmanId");//获取维修的组长
                for (SysCode sysCode : code) {
                    userList.add(sysCode.getCvalue());//获取维修的组长
                }
                 SystemUser user = systemUserBean.findByUserId(equipInvenList.get(0).getRepairuser());
                 if (user!=null&&user.getManagerId()!=null) {
                     userList.add(user.getManagerId());//添加发送报修人上一级
                }
                userList = userList.stream().distinct().collect(Collectors.toList());//去除重复项
                for (String string : userList) {
                    sendMsgString(string, msg.toString(), "ca80bf276a4948909ff4197095f1103a", "oJJhp5GvX45x3nZgoX9Ae9DyWak4");
                }
//                String errmsg = sendMsgString("C2079", msg.toString(), "ca80bf276a4948909ff4197095f1103a", "oJJhp5GvX45x3nZgoX9Ae9DyWak4");
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("repairStart")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_repairStart(EquipmentRepairHis entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                EquipmentRepairHis eqpStopRepairHis = new EquipmentRepairHis();
                EquipmentRepairHis eqpRepairTemp = new EquipmentRepairHis();
                List<EquipmentRepair> equipInvenList = new ArrayList<EquipmentRepair>();
                equipInvenList = equipmentrepairBean.findByFormid(entity.getPid());
                String rStatus = equipInvenList.get(0).getRstatus();
                int exceptTime = equipInvenList.get(0).getExcepttime() == null ? 0 : equipInvenList.get(0).getExcepttime();
                Date stopDate = new Date();
                Date startDate = new Date();
                if (rStatus.equals("28")) {
                    equipInvenList.get(0).setRstatus("25");
                    equipInvenList.get(0).setStatus("N");
                } else {
                    return new ResponseMessage("301", "数据库异常");
                }

                eqpRepairList = equipmentRepairHisBean.findByPId(entity.getPid());
                int maxIndex = 0;

                if (eqpRepairList.size() > 0) {
                    eqpStopRepairHis = eqpRepairList.get(eqpRepairList.size() - 1);
                    stopDate = eqpStopRepairHis.getCredate();
                    long dateDiff = 0;
                    if (stopDate != null) {
                        dateDiff = startDate.getTime() - stopDate.getTime();
                    } else {
                        return new ResponseMessage("301", "历史数据异常");
                    }

                    double minuteDiff = (dateDiff / (1000 * 60));
                    exceptTime = exceptTime + (int) minuteDiff;
                    equipInvenList.get(0).setExcepttime(exceptTime);
                    equipmentrepairBean.persist(equipInvenList.get(0));
                } else {
                    return new ResponseMessage("301", "历史数据异常");
                }

                for (int i = 0; i < eqpRepairList.size(); i++) {
                    if (eqpRepairList.get(i).getSeq() > i) {
                        maxIndex = eqpRepairList.get(i).getSeq();
                    }
                }
                maxIndex++;

                eqpRepairTemp.setCompany(entity.getCompany());
                eqpRepairTemp.setPid(entity.getPid());
                eqpRepairTemp.setSeq(maxIndex);
                eqpRepairTemp.setUserno(entity.getUserno());
                eqpRepairTemp.setCurnode("维修暂停");
                eqpRepairTemp.setContenct(entity.getContenct());
                eqpRepairTemp.setNote(entity.getNote());
                eqpRepairTemp.setStatus("N");
                eqpRepairTemp.setCredate(new Date());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                equipmentRepairHisBean.persist(eqpRepairTemp);
                StringBuffer msg = new StringBuffer(" 维修开始通知:<br/>");
                msg.append("报修单号:").append(equipInvenList.get(0).getFormid()).append("<br/>");
                msg.append("资产编号:").append(equipInvenList.get(0).getAssetno().getFormid()).append("<br/>");
                msg.append("设备名称:").append(equipInvenList.get(0).getAssetno().getAssetDesc()).append("<br/>");
                msg.append("维修人:").append(equipInvenList.get(0).getServiceuser()).append("-").append(equipInvenList.get(0).getServiceusername()).append("<br/>");
                msg.append("已于:").append(sdf.format(new Date())).append("开始维修，请知悉!!!").append("<br/>");;
                msg.append("详情请至微信小程序查看!");
                sendMsgString(equipInvenList.get(0).getRepairuser(), msg.toString(), "ca80bf276a4948909ff4197095f1103a", "oJJhp5GvX45x3nZgoX9Ae9DyWak4");

                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("changeServiceUser")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpRepairHad_changeServiceUser(EquipmentRepair entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                EquipmentRepair eqpRepairTemp = new EquipmentRepair();
                EquipmentRepairHis eqpRepairHisTemp = new EquipmentRepairHis();
                List<EquipmentRepairHis> eqpRepairList = new ArrayList<EquipmentRepairHis>();
                List<SysCode> repairManagerList = new ArrayList<SysCode>();
                eqpRepairTemp = equipmentrepairBean.findById(entity.getId());
                String rStatus = eqpRepairTemp.getRstatus();

                eqpRepairTemp.setStatus("N");
                if (entity.getRepairmethodtype().equals("2")) {//自主维修转单时将维修方式转换为维修课维修并记录时间
                    eqpRepairTemp.setRepairmethodtype("1");
                    eqpRepairTemp.setAutotransfertime(new Date());
                    if (eqpRepairTemp != null) {
                        StringBuffer msg = new StringBuffer("收到转移单<br/>");
                        msg.append("转移人:").append(eqpRepairTemp.getServiceuser()).append("-").append(eqpRepairTemp.getServiceusername()).append("<br/>");
                        msg.append("报修单号:").append(eqpRepairTemp.getFormid()).append("<br/>");
                        msg.append("资产编号:").append(eqpRepairTemp.getAssetno().getFormid()).append("<br/>");
                        msg.append("设备名称:").append(eqpRepairTemp.getAssetno().getAssetDesc()).append("<br/>");
                        msg.append("设备位置:").append(eqpRepairTemp.getAssetno().getPosition1().getName()).append(eqpRepairTemp.getAssetno().getPosition2().getName());
                        if (eqpRepairTemp.getAssetno().getPosition3() != null) {
                            msg.append(eqpRepairTemp.getAssetno().getPosition3().getName()).append("<br/>");
                        } else {
                            msg.append("<br/>");
                        }
                        msg.append("报修人:").append(eqpRepairTemp.getRepairuser()).append("-").append(eqpRepairTemp.getRepairusername()).append("<br/>");
                        msg.append("维修人:").append(entity.getServiceuser()).append("-").append(entity.getServiceusername()).append("<br/>");
                        msg.append("详情请至微信小程序查看!");

                        String errmsg = sendMsgString(entity.getServiceuser(), msg.toString(), "ca80bf276a4948909ff4197095f1103a", "oJJhp5GvX45x3nZgoX9Ae9DyWak4");
                    }
                }
                if (entity.getRepairmethodtype().equals("1")) {//维修课维修转单时将维修方式转换为委外维修并记录时间
                    repairManagerList = sysCodeBean.getTroubleNameList(eqpRepairTemp.getCompany(), "RD", "repairleaders");
                    if (entity.getServiceuser().equals(repairManagerList.get(0).getCvalue())) {//只有维修转单转给维修课长时才转到委外
                        eqpRepairTemp.setRepairmethodtype("3");
                        eqpRepairTemp.setRepairtransfertime(new Date());
                    }
                }
                eqpRepairTemp.setServiceuser(entity.getServiceuser());
                eqpRepairTemp.setServiceusername(entity.getServiceusername());
                equipmentrepairBean.persist(eqpRepairTemp);

                eqpRepairList = equipmentRepairHisBean.findByPId(eqpRepairTemp.getFormid());
                int maxIndex = 0;
                for (int i = 0; i < eqpRepairList.size(); i++) {
                    if (eqpRepairList.get(i).getSeq() > i) {
                        maxIndex = eqpRepairList.get(i).getSeq();
                    }
                }
                maxIndex++;

                eqpRepairHisTemp.setCompany(eqpRepairTemp.getCompany());
                eqpRepairHisTemp.setPid(eqpRepairTemp.getFormid());
                eqpRepairHisTemp.setSeq(maxIndex);
                eqpRepairHisTemp.setUserno(entity.getRepairuser());
                eqpRepairHisTemp.setCurnode("已报修");
                eqpRepairHisTemp.setContenct("转派维修人");
                eqpRepairHisTemp.setNote(entity.getRemark());
                eqpRepairHisTemp.setStatus("N");
                eqpRepairHisTemp.setCredate(new Date());

                equipmentRepairHisBean.persist(eqpRepairHisTemp);

                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误转派失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("uploadEqpRepairPic")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    //public void uploadEqpRepairPic(@FormParam("filename") String filename,@FormParam("file") InputStream fileInputStream) {
    public ResponseMessage uploadEqpRepairPic(String jsonRequest) {
        //return new ResponseMessage("200", "Code=200");

//              company: 'C',
//              pid: _this.data.docFormidId,
//              fileIndex: imageListIndex,
//              fileDta: obj,
//              fileMark: _this.data.troubleDetailInfo,
        EquipmentRepairFile equipmentrepairfile = new EquipmentRepairFile();
        List<EquipmentRepairFile> eqpRepairImageListRes = new ArrayList<>();
        try {
            JSONObject requestedJSON = new JSONObject(jsonRequest);
            String companyTemp = requestedJSON.getString("company");
            String pidTemp = requestedJSON.getString("pid");
            int fileIndexTemp = requestedJSON.getInt("fileIndex");
//            String fileMarkTemp = requestedJSON.getString("fileMark");
            String fileDtaStr = requestedJSON.getString("fileDta");
            String fileType = requestedJSON.getString("fileType");
            String fileFrom = requestedJSON.getString("fileFrom");

            eqpRepairImageListRes = equipmentrepairfileBean.findByPId(pidTemp);
            int fileIndexMaxTemp = 0;

            if (eqpRepairImageListRes == null || eqpRepairImageListRes.size() < 1) {
                fileIndexTemp = 1;
            } else {
                for (int i = 0; i < eqpRepairImageListRes.size(); i++) {
                    if (eqpRepairImageListRes.get(i).getSeq() >= fileIndexMaxTemp) {
                        fileIndexMaxTemp = eqpRepairImageListRes.get(i).getSeq();
                    }
                }
                fileIndexTemp = fileIndexMaxTemp + 1;
            }

            String fileNameTemp = pidTemp + "_" + fileIndexTemp + "_" + System.currentTimeMillis() + "." + fileType;
            String relativePath = "../../resources/app/res/" + fileNameTemp;
//            byte[] bytes1 = decoder.decodeBuffer(fileStr);
//            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
//            BufferedImage bi1 = ImageIO.read(bais);
//            File f1 = new File("d://out.jpg");
//            ImageIO.write(bi1, "jpg", f1);
            //So now you can use requestedJSON object created to do your stuff

            //保存至服务器本地
            GenerateImage(fileDtaStr, filePathTemp + fileNameTemp);

            equipmentrepairfile.setCompany(companyTemp);
            equipmentrepairfile.setPid(pidTemp);
            equipmentrepairfile.setSeq(fileIndexTemp);
            equipmentrepairfile.setFilefrom(fileFrom);
            equipmentrepairfile.setFilename(fileNameTemp);
            equipmentrepairfile.setFilepath(relativePath);
            equipmentrepairfile.setStatus("Y");

            equipmentrepairfileBean.persist(equipmentrepairfile);

        } catch (Exception ex) {
            return new ResponseMessage("500", "上传失败");
        }

        return new ResponseMessage("200", "文件已经上传成功");

    }

    @POST
    @Path("deleteAuditSpareDta")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage deleteAuditSpareDta(EquipmentRepairSpare entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            EquipmentRepairSpare eqpRepairSpareTemp = new EquipmentRepairSpare();
            try {
                eqpRepairSpareTemp = equipmentRepairSpareBean.findById(entity.getId());
                equipmentRepairSpareBean.delete(eqpRepairSpareTemp);
            } catch (Exception ex) {
                return new ResponseMessage("500", "删除失败");
            }

            return new ResponseMessage("200", "备件信息已删除");
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("deleteRepairHelperDta")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage deleteRepairHelperDta(EquipmentRepairHelpers entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            EquipmentRepairHelpers eqpRepairHelperTemp = new EquipmentRepairHelpers();
            try {
                eqpRepairHelperTemp = equipmentRepairHelpersBean.findById(entity.getId());
                equipmentRepairHelpersBean.delete(eqpRepairHelperTemp);
            } catch (Exception ex) {
                return new ResponseMessage("500", "删除失败");
            }

            return new ResponseMessage("200", "备件信息已删除");
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("deleteAuditImageDta")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage deleteAuditImageDta(EquipmentRepairFile entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            EquipmentRepairFile eqpRepairImageTemp = new EquipmentRepairFile();
            try {
                eqpRepairImageTemp = equipmentrepairfileBean.findById(entity.getId());
                equipmentrepairfileBean.delete(eqpRepairImageTemp);
            } catch (Exception ex) {
                return new ResponseMessage("500", "删除失败");
            }

            return new ResponseMessage("200", "维修图片信息已删除");
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairDocList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EquipmentRepair> getRepairDocList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = equipmentrepairBean;
            List<EquipmentRepair> eqpRepairListRes = new ArrayList<>();
            List<SysCode> sysCodeList = new ArrayList<SysCode>();
            AssetCard assetCardRes = new AssetCard();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, Object> filterFields_troubleFrom = new HashMap<>();
                Map<String, Object> filterFields_hitchUrgency = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.equals("formdateBegin") || key.equals("formdateEnd")) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date dateFormatParse = sdf.parse(value);
                            filterFields.put(key, dateFormatParse);
                        } else {
                            filterFields.put(key, value);
                        }
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                sortFields.put("hitchtime", "DESC");
//                List<AssetCard> assetCardList = assetCardBean.findByFilters(filterFields, offset, pageSize, sortFields);
//                for (AssetCard a : assetCardList) {
//                    assetCardListRes.add(a);
//                }
                //assetCardRes = assetCardBean.findByAssetno(filterFields.get("formid").toString());

                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                eqpRepairListRes = equipmentrepairBean.getEquipmentRepairList(filterFields, sortFields);
                for (EquipmentRepair eRepair : eqpRepairListRes) {
                    if (eRepair.getItemno().equals("AS000")) {
                        String formid = equipmentrepairBean.getAssetno(eRepair.getFormid());
                        eRepair.setAssetno(assetCardSpecialBean.transitionAssetCardSpecial(assetCardSpecialBean.findByAssetno(formid)));
                    }
                }
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
//            return assetCardListRes;
            return eqpRepairListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairDocInfo/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getRepairDocInfo(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = equipmentrepairBean;
            List<EquipmentRepair> eqpRepairListRes = new ArrayList<EquipmentRepair>();
            List<Object> infoListRes = new ArrayList<Object>();
            List<EquipmentRepair> eqpRepairListResTemp = new ArrayList<EquipmentRepair>();
            List<SystemUser> sysUserListRes = new ArrayList<SystemUser>();
            List<SysCode> sysCodeList = new ArrayList<SysCode>();
            List<SysCode> repairManagerList = new ArrayList<SysCode>();
            List<SysCode> leaderManagerList = new ArrayList<SysCode>();
            SystemUser repairUserObj = new SystemUser();
            SystemUser serviceUserObj = new SystemUser();
            AssetCard assetCardRes = new AssetCard();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, Object> filterFields_troubleFrom = new HashMap<>();
                Map<String, Object> filterFields_hitchUrgency = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                String key, value = "";
                String userCheckTemp = "";
                String companyCodeStr = "";
                String formidText = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.equals("formid")) {
                            formidText = value;
                        }
                        if (key.equals("userId")) {
                            userCheckTemp = value;
                        } else if (key.equals("company")) {
                            companyCodeStr = value;
                        } else {
                            filterFields.put(key, value);
                        }
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
                    }
                }

                if (companyCodeStr == null || companyCodeStr.equals("")) {
                    throw new WebApplicationException(Response.Status.NOT_FOUND);
                }

                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
//                List<AssetCard> assetCardList = assetCardBean.findByFilters(filterFields, offset, pageSize, sortFields);
//                for (AssetCard a : assetCardList) {
//                    assetCardListRes.add(a);
//                }
                //assetCardRes = assetCardBean.findByAssetno(filterFields.get("formid").toString());

                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                eqpRepairListRes = equipmentrepairBean.getEquipmentRepairList(filterFields, sortFields);
                for (EquipmentRepair eRepair : eqpRepairListRes) {
                    if (eRepair.getItemno().equals("AS000")) {
                        String formid = equipmentrepairBean.getAssetno(formidText);
                        eRepair.setAssetno(assetCardSpecialBean.transitionAssetCardSpecial(assetCardSpecialBean.findByAssetno(formid)));
                    }
                }

                EquipmentRepair repairResTemp = new EquipmentRepair();

                if (eqpRepairListRes.size() > 0) {
                    repairManagerList = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "repairmanager");
                    leaderManagerList = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "repairHeadmanId");
//                    repairResTemp.setId(eqpRepairListRes.get(0).getId());
//                    repairResTemp.setFormid(eqpRepairListRes.get(0).getFormid());
//                    repairResTemp.setFormdate(eqpRepairListRes.get(0).getFormdate());
//                    repairResTemp.setCompany(eqpRepairListRes.get(0).getCompany());
//                    repairResTemp.setItemno(eqpRepairListRes.get(0).getItemno());
//                    repairResTemp.setAssetno(eqpRepairListRes.get(0).getAssetno());
//                    repairResTemp.setHitchtime(eqpRepairListRes.get(0).getHitchtime());
//                    repairResTemp.setRepairdeptno(eqpRepairListRes.get(0).getRepairdeptno());
//                    repairResTemp.setRepairdeptname(eqpRepairListRes.get(0).getRepairdeptname());
//                    repairResTemp.setRepairuser(eqpRepairListRes.get(0).getRepairuser());
//                    repairResTemp.setRepairusername(eqpRepairListRes.get(0).getRepairusername());
//                    repairResTemp.setHitchurgency(eqpRepairListRes.get(0).getHitchurgency());
//                    repairResTemp.setTroublefrom(eqpRepairListRes.get(0).getTroublefrom());
//                    repairResTemp.setServiceuser(eqpRepairListRes.get(0).getServiceuser());
//                    repairResTemp.setServiceusername(eqpRepairListRes.get(0).getServiceusername());
//                    repairResTemp.setServicearrivetime(eqpRepairListRes.get(0).getServicearrivetime());
//                    repairResTemp.setRstatus(eqpRepairListRes.get(0).getRstatus());
//                    repairResTemp.setHitchdesc(eqpRepairListRes.get(0).getHitchdesc());
//                    repairResTemp.setHitchtype(eqpRepairListRes.get(0).getHitchtype());
//                    repairResTemp.setCompletetime(eqpRepairListRes.get(0).getCompletetime());
//                    repairResTemp.setCredate(eqpRepairListRes.get(0).getCredate());

                    String checkUser = userCheckTemp;
                    if (checkUser != "") {
                        if (eqpRepairListRes.get(0).getRstatus().compareTo("40") <= 0) {
                            if (!eqpRepairListRes.get(0).getRepairuser().equalsIgnoreCase(checkUser)) {
                                eqpRepairListRes.get(0).setStatus("Y");
                            }
                        } else if (eqpRepairListRes.get(0).getRstatus().equals("50")) {
                            if (eqpRepairListRes.get(0).getHitchdutyuser().equalsIgnoreCase(checkUser)) {
                                eqpRepairListRes.get(0).setStatus("Y");
                            }
                        } else if (eqpRepairListRes.get(0).getRstatus().equals("60")) {
//                            sysUserListRes = systemUserBean.findByUserIdOrName(checkUser);
//                            if(sysUserListRes.size() > 0)
//                            {
//                                if(sysUserListRes.get(0).getDeptno().equalsIgnoreCase("1W300"))
//                                {
//                                    eqpRepairListRes.get(0).setStatus("Y");
//                                }
//                            }
                            sysCodeList = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "repairleaders");

                            for (int i = 0; i < sysCodeList.size(); i++) {
                                if (sysCodeList.get(i).getCvalue().equalsIgnoreCase(checkUser)) {
                                    eqpRepairListRes.get(0).setStatus("Y");
                                    break;
                                }
                            }
                        } else if (eqpRepairListRes.get(0).getRstatus().equals("70")) {
                            if (repairManagerList.size() > 0) {
                                if (checkUser.equalsIgnoreCase(repairManagerList.get(0).getCvalue())) {
                                    eqpRepairListRes.get(0).setStatus("Y");
                                }
                            }
                        }
                    }

                    if (eqpRepairListRes.get(0).getTroublefrom() != null) {
                        filterFields_troubleFrom.put("code", "faultType");
                        filterFields_troubleFrom.put("cvalue", eqpRepairListRes.get(0).getTroublefrom());
                        sysCodeList = sysCodeBean.findByFilters(filterFields_troubleFrom);
                        if (sysCodeList.size() > 0) {
                            eqpRepairListRes.get(0).setTroublefrom(sysCodeList.get(0).getCdesc());
                        } else {
                            eqpRepairListRes.get(0).setTroublefrom("");
                        }
                        equipmentrepairBean.getEntityManager().clear();
                    }

                    if (eqpRepairListRes.get(0).getHitchurgency() != null) {
                        filterFields_hitchUrgency.put("code", "hitchurgency");
                        filterFields_hitchUrgency.put("cvalue", eqpRepairListRes.get(0).getHitchurgency());
                        sysCodeList = sysCodeBean.findByFilters(filterFields_hitchUrgency);
                        if (sysCodeList.size() > 0) {
                            eqpRepairListRes.get(0).setHitchurgency(sysCodeList.get(0).getCdesc());
                        } else {
                            eqpRepairListRes.get(0).setHitchurgency("");
                        }
                        equipmentrepairBean.getEntityManager().clear();
                    }

                    if (eqpRepairListRes.get(0).getRepairuser() != null) {
                        repairUserObj = systemUserBean.findByUserId(eqpRepairListRes.get(0).getRepairuser());
                    }

                    if (eqpRepairListRes.get(0).getServiceuser() != null) {
                        serviceUserObj = systemUserBean.findByUserId(eqpRepairListRes.get(0).getServiceuser());
                    }

                    //eqpRepairListResTemp.add(repairResTemp);
                }

                infoListRes.add(eqpRepairListRes.get(0));
                infoListRes.add(repairManagerList.get(0));
                infoListRes.add(repairUserObj);
                infoListRes.add(serviceUserObj);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            return infoListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairDocImageList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getRepairDocImageList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = equipmentrepairfileBean;
            List<EquipmentRepairFile> eqpRepairImageListRes = new ArrayList<>();
            AssetCard assetCardRes = new AssetCard();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
//                List<AssetCard> assetCardList = assetCardBean.findByFilters(filterFields, offset, pageSize, sortFields);
//                for (AssetCard a : assetCardList) {
//                    assetCardListRes.add(a);
//                }
                //assetCardRes = assetCardBean.findByAssetno(filterFields.get("formid").toString());

                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                //eqpRepairImageListRes = equipmentrepairfileBean.findByPId(value);
                eqpRepairImageListRes = equipmentrepairfileBean.findByFilters(filterFields);
                List<Object> list = new ArrayList<>();
                for (EquipmentRepairFile eq : eqpRepairImageListRes) {
                    // 将字节数组转换为Base64编码
                    java.io.File imageFile = new java.io.File(filePathTemp + eq.getFilename());
                    byte[] imageBytes = null;
                    imageBytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(imageFile.getPath()));
                    String base64String = java.util.Base64.getEncoder().encodeToString(imageBytes);
                    list.add("data:image/png;base64," + base64String);
                }

                return list;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

//            return assetCardListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairUserList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getRepairUserList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            String companyCodeStr = "";
            List<Object> initDtaRes = new ArrayList<Object>();
            List<SystemUser> repairUserListRes = new ArrayList<SystemUser>();
            List<SysCode> repairReasonListRes = new ArrayList<SysCode>();
            List<SysCode> hitchUrgencyListRes = new ArrayList<SysCode>();
            List<SysCode> repairAreaListRes = new ArrayList<SysCode>();
            List<SysCode> autonoRepairUserListRes = new ArrayList<>();
            this.superEJB = systemUserBean;
            try {
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                //获取自主维修的班组长信息
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                if (filtersMM != null) {
                    companyCodeStr = filtersMM.getFirst("company");
                    String userDeptNo = filtersMM.getFirst("deptno");
                    //2021-11-09 用公司别区分各个分公司的参数
                    if (companyCodeStr == null || companyCodeStr.equals("")) {
                        throw new WebApplicationException(Response.Status.NOT_FOUND);
                    }
                    if (userDeptNo != null && userDeptNo != "") {
                        if (!companyCodeStr.contains("C")) {
                            autonoRepairUserListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "RepairUser");
                        } else if (userDeptNo.contains("1P1")) {
                            autonoRepairUserListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "FX_RepairUser");
                        } else if (userDeptNo.contains("1P5")) {
                            autonoRepairUserListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "YX_RepairUser");
                        }
                    }
                } else {
                    throw new WebApplicationException(Response.Status.NOT_FOUND);
                }

//                String deptno = sysCodeBean.findBySyskindAndCode(companyCodeStr, "RD", "repairDeptno").getCvalue();
                repairReasonListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "faultType");
                hitchUrgencyListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "hitchurgency");
                repairAreaListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "repairarea");
                String key, value = "";
//                filterFields.put("deptno", deptno);
//                filterFields.put("status", "N");
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                List<SysCode> sysCodes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "repairDeptno");
//                repairUserListRes = systemUserBean.findByFilters(filterFields);
                for (SysCode sc : sysCodes) {
                    filterFields.clear();
                    filterFields.put("deptno", sc.getCvalue());
                    filterFields.put("status", "N");
                    List<SystemUser> repairUserList = systemUserBean.findByFilters(filterFields);
                    repairUserListRes.addAll(repairUserList);
                }

                System.out.print(repairUserListRes);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            initDtaRes.add(repairUserListRes);
            initDtaRes.add(repairReasonListRes);
            initDtaRes.add(hitchUrgencyListRes);
            initDtaRes.add(repairAreaListRes);
            initDtaRes.add(new Date());
            initDtaRes.add(autonoRepairUserListRes);

            return initDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairAuditInitDta/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getRepairAuditInitDta(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object> initDtaRes = new ArrayList<Object>();
            List<EquipmentTrouble> equipmentTroubleListRes = new ArrayList<EquipmentTrouble>();
            List<EquipmentRepairFile> eqpRepairFileListRes = new ArrayList<EquipmentRepairFile>();
            //List<EquipmentRepairSpare> eqpRepairSpareListRes = new ArrayList<EquipmentRepairSpare>();
            List<EquipmentSpareRecodeDtaResponse> eqpRepairSpareListRes = new ArrayList<EquipmentSpareRecodeDtaResponse>();
            List<EquipmentRepairHelpers> eqpRepairHelpersListRes = new ArrayList<EquipmentRepairHelpers>();
            List<SysCode> hitchUrgencyListRes = new ArrayList<SysCode>();
            EquipmentRepair equipmentRepairRes = new EquipmentRepair();
            this.superEJB = equipmentTroubleBean;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, Object> filterFields_eqpFile = new HashMap<>();
                String key, value = "";
                String companyCodeStr = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.equals("company")) {
                            companyCodeStr = value;
                        } else {
                            filterFields.put(key, value);
                            //filterFields.put("formid LIKE", "%" + value + "%");
                        }
                    }
                }

                if (companyCodeStr == null || companyCodeStr.equals("")) {
                    throw new WebApplicationException(Response.Status.NOT_FOUND);
                }
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                equipmentRepairRes = equipmentrepairBean.findById(Integer.parseInt(filterFields.get("docId").toString()));
                equipmentTroubleListRes = equipmentTroubleBean.findAll();
                hitchUrgencyListRes = sysCodeBean.getTroubleNameList(companyCodeStr, "RD", "hitchurgency");

                filterFields_eqpFile.put("pid", equipmentRepairRes.getFormid());
                filterFields_eqpFile.put("filefrom", "维修图片");
                eqpRepairFileListRes = equipmentrepairfileBean.findByFilters(filterFields_eqpFile);
                //eqpRepairSpareListRes = equipmentRepairSpareBean.findByPId(equipmentRepairRes.getFormid());
                eqpRepairSpareListRes = getEqpRepairSpareList(equipmentRepairRes.getFormid());
                eqpRepairHelpersListRes = equipmentRepairHelpersBean.findByPId(equipmentRepairRes.getFormid());

                System.out.print(equipmentTroubleListRes);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            initDtaRes.add(equipmentRepairRes);
            initDtaRes.add(equipmentTroubleListRes);
            initDtaRes.add(hitchUrgencyListRes);
            initDtaRes.add(eqpRepairFileListRes);
            initDtaRes.add(eqpRepairSpareListRes);
            initDtaRes.add(eqpRepairHelpersListRes);

            return initDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairApproveInitDta/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getRepairApproveInitDta(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object> initDtaRes = new ArrayList<Object>();
            List<EquipmentTrouble> equipmentTroubleListRes = new ArrayList<EquipmentTrouble>();
            List<SysCode> eqpSysCodeListRes = new ArrayList<SysCode>();
            List<EquipmentRepairFile> eqpRepairFileListRes = new ArrayList<EquipmentRepairFile>();
            //List<EquipmentRepairSpare> eqpRepairSpareListRes = new ArrayList<EquipmentRepairSpare>();
            List<EquipmentSpareRecodeDtaResponse> eqpRepairSpareListRes = new ArrayList<EquipmentSpareRecodeDtaResponse>();
            EquipmentRepair equipmentRepairRes = new EquipmentRepair();
            EquipmentRepair eqpRepairTemp = new EquipmentRepair();
            this.superEJB = equipmentTroubleBean;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, Object> filterFields_eqpTrouble = new HashMap<>();
                Map<String, Object> filterFields_eqpFile = new HashMap<>();
                Map<String, Object> filterFields_eqpSpare = new HashMap<>();
                Map<String, Object> filterFields_eqpHitchType = new HashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
//                        filterFields.put("formid LIKE", "%" + value + "%");
                    }
                }
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                equipmentRepairRes = equipmentrepairBean.findById(Integer.parseInt(filterFields.get("docId").toString()));
                eqpRepairTemp = equipmentRepairRes;
                filterFields_eqpTrouble.put("troubleid", equipmentRepairRes.getHitchsort1());
                equipmentTroubleListRes = equipmentTroubleBean.findByFilters(filterFields_eqpTrouble);
                if (equipmentTroubleListRes.size() > 0) {
                    eqpRepairTemp.setHitchsort1(equipmentTroubleListRes.get(0).getTroublename());
                    equipmentrepairBean.getEntityManager().clear();
                }

                filterFields_eqpHitchType.put("code", "hitchurgency");
                filterFields_eqpHitchType.put("cvalue", eqpRepairTemp.getHitchtype());
                eqpSysCodeListRes = sysCodeBean.findByFilters(filterFields_eqpHitchType);

                if (eqpSysCodeListRes.size() > 0) {
                    eqpRepairTemp.setHitchtype(eqpSysCodeListRes.get(0).getCdesc());
                    sysCodeBean.getEntityManager().clear();
                }

                filterFields_eqpFile.put("pid", equipmentRepairRes.getFormid());
                filterFields_eqpFile.put("filefrom", "维修图片");
                eqpRepairFileListRes = equipmentrepairfileBean.findByFilters(filterFields_eqpFile);

                //eqpRepairSpareListRes = equipmentRepairSpareBean.findByPId(equipmentRepairRes.getFormid());
                eqpRepairSpareListRes = getEqpRepairSpareList(equipmentRepairRes.getFormid());

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            initDtaRes.add(eqpRepairTemp);
            initDtaRes.add(eqpRepairSpareListRes);
            initDtaRes.add(eqpRepairFileListRes);

            return initDtaRes;

        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairHistoryDta/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getRepairHistoryDta(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object> initDtaRes = new ArrayList<Object>();
            List<EquipmentRepairHis> eqpHisListRes = new ArrayList<EquipmentRepairHis>();
            EquipmentRepair equipmentRepairRes = new EquipmentRepair();
            this.superEJB = equipmentTroubleBean;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }

                eqpHisListRes = equipmentRepairHisBean.findByPId(filterFields.get("docFormid").toString());

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            initDtaRes.add(eqpHisListRes);

            return initDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairSpareList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EquipmentSpare> getRepairSpareList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object> initDtaRes = new ArrayList<Object>();
            List<EquipmentSpare> repairUserListRes = new ArrayList<EquipmentSpare>();
            List<SysCode> repairReasonListRes = new ArrayList<SysCode>();
            this.superEJB = equipmentSpareBean;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                repairUserListRes = equipmentSpareBean.findByAllBasicInfo("C", filterFields.get("basicInfo").toString());

                System.out.print(repairUserListRes);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            //initDtaRes.add(repairUserListRes);
            //initDtaRes.add(repairReasonListRes);
            return repairUserListRes;

        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getHitchDutyList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<SystemUser> getHitchDutyList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<SystemUser> allDtaRes = new ArrayList<SystemUser>();
            List<SystemUser> sysUserListRes_ByUser = new ArrayList<SystemUser>();
            List<SystemUser> sysUserListRes_ByDept = new ArrayList<SystemUser>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                String basicInfo = filterFields.get("basicInfo").toString();
                sysUserListRes_ByUser = systemUserBean.findByUserIdOrName(basicInfo);
                sysUserListRes_ByDept = systemUserBean.findByDeptnoAndOnJob(basicInfo);

                allDtaRes.addAll(sysUserListRes_ByUser);
                if (sysUserListRes_ByDept.size() > 1) {
                    allDtaRes.removeAll(sysUserListRes_ByDept);
                    allDtaRes.addAll(sysUserListRes_ByDept);
                }

                System.out.print(allDtaRes);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            //initDtaRes.add(repairUserListRes);
            //initDtaRes.add(repairReasonListRes);
            return allDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairBacklogInfo/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public int getRepairBacklogInfo(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<SystemUser> allDtaRes = new ArrayList<SystemUser>();
            List<EquipmentRepair> eqpRepairListRes = new ArrayList<EquipmentRepair>();
            int eqpRepairCountRes;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                sortFields.put("hitchtime", "DESC");

//                eqpRepairListRes = equipmentrepairBean.getEquipmentRepairList(filterFields,sortFields);
                eqpRepairCountRes = equipmentrepairBean.getRowCount(filterFields);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            //initDtaRes.add(repairUserListRes);
            //initDtaRes.add(repairReasonListRes);
            return eqpRepairCountRes;

        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getRepairBacklogList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EquipmentRepair> getRepairBacklogList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<SystemUser> allDtaRes = new ArrayList<SystemUser>();
            List<EquipmentRepair> eqpRepairListRes = new ArrayList<EquipmentRepair>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                sortFields.put("hitchtime", "DESC");
                eqpRepairListRes = equipmentrepairBean.getEquipmentRepairList(filterFields, sortFields);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }

            //initDtaRes.add(repairUserListRes);
            //initDtaRes.add(repairReasonListRes);
            return eqpRepairListRes;

        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    private List<EquipmentSpareRecodeDtaResponse> getEqpRepairSpareList(String formid) {
        List<EquipmentSpareRecodeDta> eqpSpareRecodeDtas = equipmentSpareRecodeDtaBean.getEquipmentSpareRecodeDtaListByRepairFormId(formid);
        //List按照sparenum分组
        Map<EquipmentSpare, List<EquipmentSpareRecodeDta>> groupBySparenumMap = eqpSpareRecodeDtas.stream().collect(Collectors.groupingBy(EquipmentSpareRecodeDta::getSparenum));

        List<EquipmentSpareRecodeDtaResponse> resList = new ArrayList<>();
        groupBySparenumMap.forEach((key, value) -> {
            BigDecimal qtySum = BigDecimal.ZERO;
            BigDecimal priceSum = BigDecimal.ZERO;
            for (int i = 0; i < value.size(); i++) {
                EquipmentSpareRecodeDta dtaTemp = value.get(i);
                qtySum = qtySum.add(dtaTemp.getCqty());
                priceSum = priceSum.add(value.get(i).getCqty().multiply(value.get(i).getUprice()));
            }
            EquipmentSpareRecodeDtaResponse resTemp = new EquipmentSpareRecodeDtaResponse(key, value, qtySum, priceSum);
            resList.add(resTemp);
        });

        return resList;
    }

    public boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        if (imgData == null) // 图像数据为空
        {
            return false;
        }
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = Base64.decodeBase64(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }

    // 发送企业微信信息
    public String sendMsgString(String userId, String msg, String sessionkey, String openid)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        String URL = "http://jrs.hanbell.com.cn/Hanbell-WCO/api/sendmsg/send";
        StringBuilder jsonString = new StringBuilder("{'userId':'");
        jsonString.append(userId).append("','msg':'").append(msg).append("','sessionkey':'").append(sessionkey)
                .append("','openid':'").append(openid).append("'}");
        JSONObject jo = new JSONObject(jsonString.toString());
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("content-type", "application/json");
        httpPost.setEntity(new StringEntity(jo.toString(), "UTF-8"));
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                return "200";
            } else {
                return "500";
            }
        } catch (Exception var5) {
            return null;
        }
    }

}

class EquipmentRepairResponseResult {

    private Integer size;
    private List<AssetCard> result;

    public EquipmentRepairResponseResult() {

    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the result
     */
    public List<AssetCard> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<AssetCard> result) {
        this.result = result;
    }

}
