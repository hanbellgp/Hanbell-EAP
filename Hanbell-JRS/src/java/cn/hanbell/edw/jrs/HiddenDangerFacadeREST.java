/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.jrs;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import cn.hanbell.eam.entity.AssetCard;
import cn.hanbell.eam.ejb.SysCodeBean;
import cn.hanbell.edw.ejb.EhsHazardInspectionBean;
import cn.hanbell.edw.ejb.EhsHazardInspectionDtaBean;
import cn.hanbell.edw.ejb.EhsHiddenDangerBean;
import cn.hanbell.edw.ejb.EhsHiddenDangerFileBean;
import cn.hanbell.edw.ejb.EhsHiddenDangerParameterBean;
import cn.hanbell.edw.ejb.EhsSafemanagerStandardBean;
import cn.hanbell.edw.ejb.EhsSecureBean;
import cn.hanbell.edw.entity.EhsHazardInspection;
import cn.hanbell.edw.entity.EhsHazardInspectionDta;
import cn.hanbell.edw.entity.EhsHiddenDanger;
import cn.hanbell.edw.entity.EhsHiddenDangerFile;
import cn.hanbell.edw.entity.EhsHiddenDangerParameter;
import cn.hanbell.edw.entity.EhsSafemanagerStandard;
import cn.hanbell.edw.entity.EhsSecure;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEDW;
import com.lightshell.comm.SuperEJB;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author C2079
 */
@Stateless
@Path("shbedw/hiddendanger")
public class HiddenDangerFacadeREST extends SuperRESTForEDW<EhsHiddenDanger> {

    @EJB
    private EhsHiddenDangerBean ehsHiddenDangerBean;
    @EJB
    private EhsHiddenDangerFileBean ehsHiddenDangerFileBean;
    @EJB
    private EhsHazardInspectionDtaBean ehsHazardInspectionDtaBean;
    @EJB
    private EhsHazardInspectionBean ehsHazardInspectionBean;
    @EJB
    private EhsHiddenDangerParameterBean ehsHiddenDangerParameterBean;
    @EJB
    private EhsSafemanagerStandardBean ehsSafemanagerStandardBean;

    @EJB
    private EhsSecureBean ehsSecureBean;
    protected SuperEJB superEJB;
    //生产环境
    private final String filePathTemp = "D:\\glassfish5\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
    //private final String filePathTemp = "D:\\Java\\glassfish5\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
    //测试环境
//   private final String filePathTemp = "D:\\Java\\glassfish5.0.1\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
    //本地环境
    //private final String filePathTemp = "E:\\C2079\\EAM\\dist\\gfdeploy\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";

    @Override
    protected SuperEJB getSuperEJB() {
        return ehsHiddenDangerBean;
    }

    public HiddenDangerFacadeREST() {
        super(EhsHiddenDanger.class);

    }

    @GET
    @Path("getHiddenDangerModel/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EhsHiddenDanger> getHiddenDangerModel(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = ehsHiddenDangerBean;
            List<EhsHiddenDanger> ehsHiddenDangerListRes = new ArrayList<>();
            MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
            MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
            Map<String, Object> filterFields = new HashMap<>();
            Map<String, String> sortFields = new LinkedHashMap<>();
            String key, value = "";
            String userId = filtersMM.getFirst("userid");
            String company = filtersMM.getFirst("company");
            List<EhsSecure> checkList = new ArrayList<EhsSecure>();
            Map<String, Object> filterSecure = new HashMap<>();
            filterSecure.put("position", "月安全课长");
            filterSecure.put("remark =", new Date().getMonth() + 1 + "");
            checkList = ehsSecureBean.findByFilters(filterSecure);

            try {
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (!key.equals("company")) {

                            if (key.equals("formdateBegin") || key.equals("formdateEnd")) {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                Date dateFormatParse = sdf.parse(value);
                                filterFields.put(key, dateFormatParse);
                            } else {
                                filterFields.put(key, value);
                            }
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
                sortFields.put("createTime", "DESC");
                //assetCardRes = assetCardBean.findByAssetno(filterFields.get("formid").toString());
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                for (EhsSecure ehsSecure : checkList) {
                    if (ehsSecure.getSecureId().equals(userId)) {
                        filterFields.put("月安全课长", "安全专员巡查");
                        filterFields.put("area", ehsSecure.getArea());
                    }
                }
                ehsHiddenDangerListRes = ehsHiddenDangerBean.getEHSHiddenDangerList(filterFields, sortFields);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
//            return assetCardListRes;
            return ehsHiddenDangerListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

//    @GET
//    @Path("getHiddenBacklogInfo/{filters}/{sorts}/{offset}/{pageSize}")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public int getHiddenBacklogInfo(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
//        if (isAuthorized(appid, token)) {
//
//            List<EhsHiddenDanger> eqpHiddenListRes = new ArrayList<EhsHiddenDanger>();
//            int eqpHiddenCountRes;
//            try {
//                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
//                Map<String, Object> filterFields = new HashMap<>();
//                Map<String, String> sortFields = new HashMap<>();
//                String key, value = "";
//                if (filtersMM != null) {
//                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
//                        key = entrySet.getKey();
//                        value = entrySet.getValue().get(0);
//                        filterFields.put(key, value);
//                    }
//                }
////                eqpRepairListRes = equipmentrepairBean.getEquipmentRepairList(filterFields,sortFields);
//                eqpHiddenCountRes = ehsHiddenDangerBean.getRowCount(filterFields);
//
//            } catch (Exception ex) {
//                throw new WebApplicationException(Response.Status.NOT_FOUND);
//            }
//            //initDtaRes.add(repairUserListRes);
//            //initDtaRes.add(repairReasonListRes);
//            return eqpHiddenCountRes;
//
//        } else {
//            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//    }
    @POST
    @Path("submitHiddenDangerHad")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage submitHiddenDangerHad(EhsHiddenDanger entity, @QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("openId") String openId, @QueryParam("sessionKey") String sessionKey, @QueryParam("docPid") String docPid) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                EhsHiddenDanger hiddenTemp = new EhsHiddenDanger();
                //String formid = equipmentrepairBean.getFormId(new Date(), "AP", "YYYYMMdd", 4);
                String formid = ehsHiddenDangerBean.getFormId(new Date(), "HD", "YYMM", 4);
                Map<String, Object> filterFields = new HashMap<>();
                filterFields.put("id", docPid);
                List<EhsHazardInspectionDta> eDta = ehsHazardInspectionDtaBean.findByFilters(filterFields);
                Map<String, Object> hiddenFields = new HashMap<>();
                String id = "";
                id = entity.getId();
                if (id == null) {
                    id = "测试";
                }
                hiddenFields.put("id", id);
                List<EhsHiddenDanger> ehsList = ehsHiddenDangerBean.findByFilters(hiddenFields);
                if (ehsList.size() > 0) {
                    hiddenTemp = ehsList.get(0);
                }

                hiddenTemp.setCompany(entity.getCompany());
                hiddenTemp.setId(entity.getId());
                hiddenTemp.setHiddenType(entity.getHiddenType());
                hiddenTemp.setRstatus(entity.getRstatus());
                hiddenTemp.setStatus(entity.getStatus());
                hiddenTemp.setAcceptanceOpinions(entity.getAcceptanceOpinions());
                hiddenTemp.setHiddenLocation(entity.getHiddenLocation());
                hiddenTemp.setHiddenDescribe(entity.getHiddenDescribe());
                hiddenTemp.setHiddenSource(entity.getHiddenSource());
                hiddenTemp.setCreateTime(entity.getCreateTime());
                hiddenTemp.setRectificationDeadline(entity.getRectificationDeadline());
                hiddenTemp.setPresentingId(entity.getPresentingId());
                hiddenTemp.setPresentingName(entity.getPresentingName());
                hiddenTemp.setRectificationMeasures(entity.getRectificationMeasures());
                hiddenTemp.setRectificationType(entity.getRectificationType());
                hiddenTemp.setRectifierId(entity.getRectifierId());
                hiddenTemp.setRectifierName(entity.getRectifierName());
                hiddenTemp.setAcceptedId(entity.getAcceptedId());
                hiddenTemp.setArea(entity.getArea());
                hiddenTemp.setRectificationReasons(entity.getRectificationReasons());
                hiddenTemp.setAcceptedName(entity.getAcceptedName());
                hiddenTemp.setCheckOpinions(entity.getCheckOpinions());
                if ("30".equals(hiddenTemp.getRstatus()) && hiddenTemp.getRectificationMeasures() != null) {
                    hiddenTemp.setRectificationCompletionDate(new Date());
                }
                if (entity.getId() == null)//判断是否是新建单子
                {
                    hiddenTemp.setId(formid);
                    hiddenTemp.setRstatus("10");
                    hiddenTemp.setStatus("S");
                    hiddenTemp.setCreateId(hiddenTemp.getPresentingId());
                    hiddenTemp.setCreateTime(new Date());
                } else {
                    if (null != hiddenTemp.getRstatus()) {
                        switch (hiddenTemp.getRstatus()) {
                            case "10":
                                if (hiddenTemp.getRectificationType().equals("03")) {//无需整改时节点换成验收
                                    hiddenTemp.setRstatus("60");
                                    hiddenTemp.setStatus("V");
                                } else {
                                    hiddenTemp.setRstatus("30");
                                    hiddenTemp.setStatus("V");
                                }

                                break;
                            case "30":
                                if (hiddenTemp.getHiddenSource().equals("岗位自查") || hiddenTemp.getHiddenSource().equals("班组巡查") || hiddenTemp.getHiddenSource().equals("课长巡查")) {
                                    hiddenTemp.setRstatus("60");
                                    hiddenTemp.setStatus("V");
                                } else {
                                    hiddenTemp.setRstatus("45");
                                    hiddenTemp.setStatus("V");
                                }

                                break;
                            case "45":
                                hiddenTemp.setRstatus("60");
                                hiddenTemp.setStatus("V");
                                break;
                            case "60":
                                if (hiddenTemp.getHiddenSource().equals("安全专员巡查")) {
                                    hiddenTemp.setRstatus("75");
                                    hiddenTemp.setStatus("V");
                                } else {
                                    hiddenTemp.setRstatus("95");
                                    hiddenTemp.setStatus("T");
                                }

                                break;
                            case "75":
                                hiddenTemp.setRstatus("95");
                                hiddenTemp.setStatus("T");
                                break;
                            default:
                                break;
                        }
                    }
                    hiddenTemp.setUpdateTime(new Date());
                }

                if (eDta.size() > 0) {//更新隐患单号到明细
                    eDta.get(0).setHiddenDangerId(hiddenTemp.getId());
                    ehsHazardInspectionDtaBean.update(eDta);
                }
                ehsHiddenDangerBean.update(hiddenTemp);
                List<EhsSecure> checkList = new ArrayList<EhsSecure>();
                Map<String, Object> filterSecure = new HashMap<>();
                filterSecure.put("position", "月安全课长");
                filterSecure.put("remark", new Date().getMonth() + 1 + "");
                filterSecure.put("company", entity.getCompany());
                filterSecure.put("area", entity.getArea());//发送给对应厂区的月安全科长
                checkList = ehsSecureBean.findByFilters(filterSecure);
                if (hiddenTemp.getRstatus().equals("10")) {
                    StringBuffer msg = new StringBuffer("收到新的隐患单:");
                    StringBuffer userStrTemp = new StringBuffer(entity.getRectifierId().toUpperCase());
                    msg.append(formid).append("<br/>");
                    msg.append("隐患来源:").append(entity.getHiddenSource()).append("<br/>");
                    msg.append("隐患地点:").append(entity.getHiddenLocation()).append("<br/>");
                    msg.append("排查人:").append(entity.getPresentingId()).append("-").append(entity.getPresentingName()).append("<br/>");
                    msg.append("整改人:").append(entity.getRectifierName()).append("<br/>");
                    msg.append("详情请至微信小程序查看!");
                    String errmsg = sendMsgString(userStrTemp.toString(), msg.toString(), sessionKey, openId);
                    // 发送失败，抛异常，使事务回滚
                    if (!"200".equals(errmsg)) {
                        //throw new RuntimeException("发送失败,请联系管理员");
                        return new ResponseMessage("203", formid);
                    }
                } else if (hiddenTemp.getRstatus().equals("45")) {
                    StringBuffer msg = new StringBuffer("你有一张隐患单待处理:");
                    StringBuffer userStrTemp = new StringBuffer(entity.getAcceptedId().toUpperCase());
                    msg.append(hiddenTemp.getId()).append("<br/>");
                    msg.append("隐患来源:").append(entity.getHiddenSource()).append("<br/>");
                    msg.append("隐患地点:").append(entity.getHiddenLocation()).append("<br/>");
                    msg.append("排查人:").append(entity.getPresentingId()).append("-").append(entity.getPresentingName()).append("<br/>");
                    msg.append("整改人:").append(entity.getRectifierName()).append("<br/>");
                    msg.append("详情请至微信小程序查看!");
                    String errmsg = sendMsgString(userStrTemp.toString(), msg.toString(), sessionKey, openId);
                    // 发送失败，抛异常，使事务回滚
                    if (!"200".equals(errmsg)) {
                        //throw new RuntimeException("发送失败,请联系管理员");
                        return new ResponseMessage("203", formid);
                    }
                } else if (hiddenTemp.getRstatus().equals("60")) {
                    StringBuffer msg = new StringBuffer("你有一张隐患单待处理:");
                    String userStrTemp = entity.getPresentingId().toUpperCase();
                    msg.append(hiddenTemp.getId()).append("<br/>");
                    msg.append("隐患来源:").append(entity.getHiddenSource()).append("<br/>");
                    msg.append("隐患地点:").append(entity.getHiddenLocation()).append("<br/>");
                    msg.append("排查人:").append(entity.getPresentingId()).append("-").append(entity.getPresentingName()).append("<br/>");
                    msg.append("整改人:").append(entity.getRectifierName()).append("<br/>");
                    msg.append("详情请至微信小程序查看!");
                    String errmsg = sendMsgString(userStrTemp, msg.toString(), sessionKey, openId);
                    // 发送失败，抛异常，使事务回滚
                    if (!"200".equals(errmsg)) {
                        //throw new RuntimeException("发送失败,请联系管理员");
                        return new ResponseMessage("203", formid);
                    }
                } else if (hiddenTemp.getRstatus().equals("75")) {
                    StringBuffer msg = new StringBuffer("你有一张隐患单待处理:");
                    String userStrTemp = entity.getPresentingId().toUpperCase();
                    if (hiddenTemp.getHiddenSource().equals("安全专员巡查")) {//如果是安全专员巡查的单子验收完提醒当月安全课长审核否则提醒发起人结案
                        userStrTemp = checkList.get(0).getSecureId();
                    }
                    msg.append(hiddenTemp.getId()).append("<br/>");
                    msg.append("隐患来源:").append(entity.getHiddenSource()).append("<br/>");
                    msg.append("隐患地点:").append(entity.getHiddenLocation()).append("<br/>");
                    msg.append("排查人:").append(entity.getPresentingId()).append("-").append(entity.getPresentingName()).append("<br/>");
                    msg.append("整改人:").append(entity.getRectifierName()).append("<br/>");
                    msg.append("详情请至微信小程序查看!");
                    String errmsg = sendMsgString(userStrTemp, msg.toString(), sessionKey, openId);
                    // 发送失败，抛异常，使事务回滚
                    if (!"200".equals(errmsg)) {
                        //throw new RuntimeException("发送失败,请联系管理员");
                        return new ResponseMessage("203", formid);
                    }
                }

                return new ResponseMessage("200", hiddenTemp.getId());
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    // 发送企业微信信息
    public String sendMsgString(String userId, String msg, String sessionkey, String openid)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        String URL = "http://172.16.10.51/Hanbell-WCO/api/sendmsg/send";
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

    @GET
    @Path("getHiddenDocImageInfo/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getHiddenDocImageInfo(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            String companyCodeStr = "";
            String deptno = "";
            String docType = "";
            this.superEJB = ehsHiddenDangerFileBean;
            List<Object> list = new ArrayList<>();

            List<EhsHiddenDangerFile> hiddenImageListRes = new ArrayList<>();
            List<EhsHiddenDangerParameter> hiddenTypeList = new ArrayList<EhsHiddenDangerParameter>();
            List<EhsHiddenDangerParameter> areaTypeList = new ArrayList<EhsHiddenDangerParameter>();
            List<EhsHiddenDangerParameter> rectificationTypeList = new ArrayList<EhsHiddenDangerParameter>();
            List<EhsSecure> rectifierList = new ArrayList<EhsSecure>();
            List<EhsSecure> acceptList = new ArrayList<EhsSecure>();
            List<EhsSecure> checkList = new ArrayList<EhsSecure>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                companyCodeStr = filtersMM.getFirst("company");
                String key, value = "";
                if (filtersMM != null) {
                    deptno = filtersMM.getFirst("deptno");
                    docType = filtersMM.getFirst("docType");
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (!key.equals("company")) {
                            if (!"deptno".equals(key) && !"docType".equals(key)) {
                                filterFields.put(key, value);
                            }
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
                hiddenImageListRes = ehsHiddenDangerFileBean.findByFilters(filterFields);
                List<Object> hiddenImageListResObj = new ArrayList<>();
                for (EhsHiddenDangerFile eh : hiddenImageListRes) {
                    // 将字节数组转换为Base64编码
                    Object[] obj = new Object[2];
                    java.io.File imageFile = new java.io.File(filePathTemp + eh.getFileName());
                    byte[] imageBytes = null;
                    imageBytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(imageFile.getPath()));
                    String base64String = java.util.Base64.getEncoder().encodeToString(imageBytes);
                    obj[0] = "data:image/png;base64," + base64String;
                    obj[1] = eh.getFileType();
                    hiddenImageListResObj.add(obj);
                }
                hiddenTypeList = ehsHiddenDangerParameterBean.getTroubleNameList(companyCodeStr, "YH", "HiddenType");
                areaTypeList = ehsHiddenDangerParameterBean.getTroubleNameList(companyCodeStr, "YH", "AreaType");
                rectificationTypeList = ehsHiddenDangerParameterBean.getTroubleNameList(companyCodeStr, "YH", "RectificationType");
                Map<String, Object> filterSecure = new HashMap<>();
                //获取所有整改人，部分只搜索自己部门的整改人
                filterSecure.put("company", companyCodeStr);
                filterSecure.put("position", "整改人");
                if (docType.equals("岗位自查") || docType.equals("班组巡查") || docType.equals("课长巡查")) {
                    filterSecure.put("deptNo", deptno.substring(0, 2));
                }
                rectifierList = ehsSecureBean.findByFilters(filterSecure);
                //获取课长信息
                filterSecure.clear();
                filterSecure.put("position", "单位课长");
                acceptList = ehsSecureBean.findByFilters(filterSecure);
                //获取月安全课长
                filterSecure.clear();
                filterSecure.put("company", companyCodeStr);
                filterSecure.put("position", "月安全课长");
                filterSecure.put("remark", new Date().getMonth() + 1 + "");
                checkList = ehsSecureBean.findByFilters(filterSecure);
                list.add(hiddenImageListResObj);
                list.add(hiddenTypeList);
                list.add(rectificationTypeList);
                list.add(rectifierList);
                list.add(acceptList);
                list.add(checkList);
                list.add(areaTypeList);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
//            return assetCardListRes;
            return list;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("uploadHiddendImg")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage uploadHiddendImg(String jsonRequest) {

        //return new ResponseMessage("200", "Code=200");
//              company: 'C',
//              pid: _this.data.docFormidId,
//              fileIndex: imageListIndex,
//              fileDta: obj,
//              fileMark: _this.data.troubleDetailInfo,
        EhsHiddenDangerFile hiddenDangerFile = new EhsHiddenDangerFile();
        List<EhsHiddenDangerFile> ehsHiddenDangerImageList = new ArrayList<>();
        try {
            JSONObject requestedJSON = new JSONObject(jsonRequest);
            String companyTemp = requestedJSON.getString("company");
            String pidTemp = requestedJSON.getString("pid");
            int fileIndexTemp = requestedJSON.getInt("fileIndex");
//            String fileMarkTemp = requestedJSON.getString("fileMark");
            String fileDtaStr = requestedJSON.getString("fileDta");
            String fileType = requestedJSON.getString("fileType");
            String fileFrom = requestedJSON.getString("fileFrom");

            ehsHiddenDangerImageList = ehsHiddenDangerFileBean.getPid(pidTemp);
            int fileIndexMaxTemp = 0;

            if (ehsHiddenDangerImageList == null || ehsHiddenDangerImageList.size() < 1) {
                fileIndexTemp = 1;
            } else {
                for (int i = 0; i < ehsHiddenDangerImageList.size(); i++) {
                    if (ehsHiddenDangerImageList.get(i).getSeq() >= fileIndexMaxTemp) {
                        fileIndexMaxTemp = ehsHiddenDangerImageList.get(i).getSeq();
                    }
                }
                fileIndexTemp = fileIndexMaxTemp + 1;
            }

            String fileNameTemp = pidTemp + "_" + fileIndexTemp + "_" + System.currentTimeMillis() + "." + fileType;
            String relativePath = "../../resources/app/res/" + fileNameTemp;

            //保存至服务器本地
            GenerateImage(fileDtaStr, filePathTemp + fileNameTemp);
            hiddenDangerFile.setId(pidTemp + fileIndexTemp);
            hiddenDangerFile.setCompany(companyTemp);
            hiddenDangerFile.setPid(pidTemp);
            hiddenDangerFile.setSeq(fileIndexTemp);
            hiddenDangerFile.setFileName(fileNameTemp);
            hiddenDangerFile.setFileType(fileFrom);
            hiddenDangerFile.setFilePath(relativePath);
            hiddenDangerFile.setCreateTime(new Date());
            ehsHiddenDangerFileBean.update(hiddenDangerFile);

        } catch (Exception ex) {
            return new ResponseMessage("500", "上传失败");
        }

        return new ResponseMessage("200", "文件已经上传成功");

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

    //获取点检表
    @GET
    @Path("getPostSecureInspectModel/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EhsHazardInspection> getPostSecureInspectModel(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = ehsHazardInspectionBean;
            List<EhsHazardInspection> ehsHazardInspectionList = new ArrayList<>();
            MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
            MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
            Map<String, Object> filterFields = new HashMap<>();
            Map<String, String> sortFields = new LinkedHashMap<>();
            String key, value = "";

            try {
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
                sortFields.put("createTime", "DESC");
                //assetCardRes = assetCardBean.findByAssetno(filterFields.get("formid").toString());
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                ehsHazardInspectionList = ehsHazardInspectionBean.findByFilters(filterFields, sortFields);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);

            }
//            return assetCardListRes;
            return ehsHazardInspectionList;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    //获取点检表
    @GET
    @Path("getPostSecureInspectDtaModel/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getPostSecureInspectDtaModel(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object> initDtaRes = new ArrayList<Object>();
            this.superEJB = ehsHazardInspectionDtaBean;
            List<EhsHazardInspection> ehi = new ArrayList<>();
            List<EhsHazardInspectionDta> ehsHazardInspectionList = new ArrayList<>();
            MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
            MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
            Map<String, Object> filterFields = new HashMap<>();
            Map<String, String> sortFields = new LinkedHashMap<>();
            String key, value = "";
            String pid = "";

            try {
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.equals("pid")) {
                            pid = value;
                        }
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
                sortFields.put("createTime", "DESC");
                //assetCardRes = assetCardBean.findByAssetno(filterFields.get("formid").toString());
                //assetCardListRes = superEJB.findByFilters(filterFields, offset, pageSize, sortFields);
                ehi = ehsHazardInspectionBean.findById(pid);
                ehsHazardInspectionList = ehsHazardInspectionDtaBean.findByFilters(filterFields, sortFields);
                initDtaRes.add(ehi);
                initDtaRes.add(ehsHazardInspectionList);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);

            }
//            return assetCardListRes;
            return initDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("updateForm")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateForm(EhsHazardInspectionDta entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                Map<String, Object> filterFields = new HashMap<>();
                entity.setUpdateTime(new Date());
                ehsHazardInspectionDtaBean.update(entity);//先更新对应信息
                List<EhsHazardInspection> autoMaintainInfo = ehsHazardInspectionBean.findById(entity.getPid());
                filterFields.put("pid", entity.getPid());
                List<EhsHazardInspectionDta> eDtaList = ehsHazardInspectionDtaBean.findByFilters(filterFields);
                if (autoMaintainInfo == null) {
                    throw new WebApplicationException(Response.Status.BAD_REQUEST);
                }
                int item = 0;//完成项
                for (EhsHazardInspectionDta eDta : eDtaList) {
                    if (!eDta.getResult().equals("待检")) {//获取已完成项目数
                        item++;
                    }
                }
                if (item > 0) {//该项目进行中
                    autoMaintainInfo.get(0).setStatus("V");
                }
                if (item == eDtaList.size()) {//该项目已完成
                    autoMaintainInfo.get(0).setStatus("T");
                }
                //子项有一个为异常则主项为异常
                if (entity.getResult().equals("异常")) {
                    autoMaintainInfo.get(0).setResult("异常");
                }
                autoMaintainInfo.get(0).setUpdateId(entity.getUpdateId());
                autoMaintainInfo.get(0).setUpdateTime(entity.getUpdateTime());
                ehsHazardInspectionBean.update(autoMaintainInfo);
//                EhsHazardInspectionDta autoMaintainDetail;
//                JSONArray jsonArray = new JSONArray(entity.getStatus());
//                JSONArray eqpMaintainDetailList_jsonArray = jsonArray.getJSONArray(0);
//                String resultStrTemp = "";
//                for (Object obj : eqpMaintainDetailList_jsonArray) {
//                    JSONObject jsonObject = (JSONObject) obj;
////                    autoMaintainDetail = equipmentAnalyResultDtaBean.findById(jsonObject.getInt("Id"));
//                    resultStrTemp = jsonObject.getString("result");
//                    //已经完成的不能派工
//                    if (resultStrTemp.equals("正常") || resultStrTemp.equals("异常")) {
//                        continue;
//                    }
////                    autoMaintainDetail.setAnalysisuser(jsonObject.getString("analysisUser"));
////                    autoMaintainDetail.setLastanalysisuser(jsonObject.getString("analysisUserName"));
//                }

//                autoMaintainInfo.setOptdate(new Date());
//                autoMaintainInfo.setOptuser(entity.getOptuser());
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Update失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("createPost")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createPost(EhsSafemanagerStandard entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                Map<String, Object> filterFields = new HashMap<>();
                List<EhsSafemanagerStandard> eStandard = new ArrayList<>();
                EhsHazardInspection eInspection = new EhsHazardInspection();
                List<EhsHazardInspectionDta> eInspectionDta = new ArrayList<>();
                filterFields.put("post", entity.getPost());
                filterFields.put("deptNo", entity.getDeptNo().substring(0, 2));
                eStandard = ehsSafemanagerStandardBean.findByFilters(filterFields);
//                eStandard = ehsSafemanagerStandardBean.findAll();
                if (eStandard.isEmpty()) {
                    return new ResponseMessage("500", "系统错误Update失败");
                }
                String formid = ehsHazardInspectionBean.getFormId(new Date(), "XC", "YYMM", 4);
                eInspection.setId(formid);
                eInspection.setCompany(entity.getCompany());
                eInspection.setPatrolDept(entity.getDeptNo());
                eInspection.setPatrolDeptName(entity.getDeptName());
                eInspection.setPatrolId(entity.getCreateId());
                eInspection.setPatrolName(entity.getUpdateId());
                eInspection.setPatrolType("岗位自查");
                eInspection.setPatrolPost(eStandard.get(0).getPost());
                eInspection.setResult("待检");
                eInspection.setStatus("S");
                eInspection.setCreateId(entity.getCreateId());
                eInspection.setCreateTime(new Date());
                int i = 1;
                int id = ehsHazardInspectionDtaBean.getMaxCount() + 1;//获取当前多少条
                for (EhsSafemanagerStandard ehsStandard : eStandard) {
                    EhsHazardInspectionDta eDta = new EhsHazardInspectionDta();
                    eDta.setSeq(i + "");
                    eDta.setPid(eInspection.getId());
                    eDta.setCompany(entity.getCompany());
                    eDta.setCreateId(entity.getCreateId());
                    eDta.setProject(ehsStandard.getCheckClass());
                    eDta.setResult("待检");
                    eInspectionDta.add(eDta);
                    eDta.setId(id + "");
                    id++;
                    i++;
                }
                ehsHazardInspectionBean.persist(eInspection);
                ehsHazardInspectionDtaBean.update(eInspectionDta);
                return new ResponseMessage("200", formid);
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Update失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    /**
     * 获取整改人名单
     *
     * @param filters
     * @param sorts
     * @param offset
     * @param pageSize
     * @param appid
     * @param token
     * @return
     */
    @GET
    @Path("secureUser/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EhsSecure> findByOrganizationUnitId(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<EhsSecure> eList = new ArrayList<>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                String key, value;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                filterFields.put("position", "整改人");
                filterFields.put("company", "C");
                sortFields.put("secureId", "ASC");
                eList = ehsSecureBean.findByFilters(filterFields, offset, pageSize, sortFields);

            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return eList;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);

        }
    }

    class AssetcardResponseResult {

        private Integer size;
        private List<AssetCard> result;

        public AssetcardResponseResult() {

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
}
