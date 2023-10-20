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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
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
    //private final String filePathTemp = "D:\\Java\\glassfish5\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
    //测试环境
//    private final String filePathTemp = "D:\\Java\\glassfish5.0.1\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
    //测试环境
    private final String filePathTemp = "E:\\C2079\\EAM\\dist\\gfdeploy\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";

//    private final String filePathTemp = "E:\\Java\\glassfish5.0.1b05\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
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
            List<EhsSecure> checkList = new ArrayList<EhsSecure>();
            Map<String, Object> filterSecure = new HashMap<>();
            filterSecure.put("position", "月安全课长");
            filterSecure.put("remark", new Date().getMonth() + 1 + "");
            checkList = ehsSecureBean.findByFilters(filterSecure);

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
                if (checkList.get(0).getSecureId().equals(userId)) {
                    filterFields.put("月安全课长", "安全专员巡查");
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
                hiddenTemp.setCompany(entity.getCompany());
                hiddenTemp.setId(entity.getId());
                hiddenTemp.setHiddenType(entity.getHiddenType());
                hiddenTemp.setRstatus(entity.getRstatus());
                hiddenTemp.setStatus(entity.getStatus());
                hiddenTemp.setAcceptanceOpinions(entity.getAcceptanceOpinions());
                hiddenTemp.setHiddenLocation(entity.getHiddenLocation());
                hiddenTemp.setHiddenDescribe(entity.getHiddenDescribe());
                hiddenTemp.setHiddenSource(entity.getHiddenSource());
                hiddenTemp.setRectificationCompletionDate(entity.getRectificationCompletionDate());
                hiddenTemp.setCreateTime(entity.getCreateTime());
                hiddenTemp.setRectificationDeadline(entity.getRectificationDeadline());
                hiddenTemp.setPresentingId(entity.getPresentingId());
                hiddenTemp.setPresentingName(entity.getPresentingName());
                hiddenTemp.setRectificationMeasures(entity.getRectificationMeasures());
                hiddenTemp.setRectificationType(entity.getRectificationType());
                hiddenTemp.setRectifierId(entity.getRectifierId());
                hiddenTemp.setRectifierName(entity.getRectifierName());
                hiddenTemp.setAcceptedId(entity.getAcceptedId());
                hiddenTemp.setAcceptedName(entity.getAcceptedName());
                hiddenTemp.setCheckOpinions(entity.getCheckOpinions());
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
                                if (hiddenTemp.getRectificationType().equals("02")) {//无需整改时节点换成验收
                                    hiddenTemp.setRstatus("45");
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
                if (hiddenTemp.getRstatus() == "45" && hiddenTemp.getRectificationMeasures() != null) {
                    hiddenTemp.setRectificationCompletionDate(new Date());
                }
                if (eDta.size() > 0) {//更新隐患单号到明细
                    eDta.get(0).setHiddenDangerId(hiddenTemp.getId());
                    ehsHazardInspectionDtaBean.update(eDta);
                }
                ehsHiddenDangerBean.update(hiddenTemp);
//                if ((!"2".equals(entity.getId())) && assetCardTemp != null) {
//                    StringBuffer msg = new StringBuffer("收到新的报修单:");
////                    StringBuffer userStrTemp = new StringBuffer(entity.getServiceuser().toUpperCase());
//                    msg.append(formid).append("<br/>");
//                    msg.append("资产编号:").append(assetCardTemp.getFormid()).append("<br/>");
//                    msg.append("设备名称:").append(assetCardTemp.getAssetDesc()).append("<br/>");
//                    msg.append("设备位置:").append(assetCardTemp.getPosition1().getName()).append(assetCardTemp.getPosition2().getName());
//                    if (assetCardTemp.getPosition3() != null) {
//                        msg.append(assetCardTemp.getPosition3().getName()).append("<br/>");
//                    } else {
//                        msg.append("<br/>");
//                    }
//                    msg.append("提报人:").append(entity.getPresentingId()).append("-").append(entity.getPresentingName()).append("<br/>");
//                    msg.append("整改人:").append(entity.getRectifierId()).append("-").append(entity.getRectifierName()).append("<br/>");
//                    msg.append("详情请至微信小程序查看!");
//
//                    //sysUserList = systemUserBean.findByDeptno("1W300");
////                    String repairDeptMangerId = sysCodeBean.findBySyskindAndCode(companyCodeStr, "RD", "repairleaders").getCvalue();
////
////                    if (repairDeptMangerId != null && !repairDeptMangerId.equals("")) {
////                        userStrTemp.append("|").append(repairDeptMangerId.toUpperCase());
////                    }
////
////                    if ("C0-1".equalsIgnoreCase(assetCardTemp.getPosition2().getPosition())) {
////                        userStrTemp.append("|").append("C0299");
////                    } else if ("C0-2".equalsIgnoreCase(assetCardTemp.getPosition2().getPosition())) {
////                        userStrTemp.append("|").append("C0141");
////                    }
//
//                    String errmsg = sendMsgString(null, msg.toString(), sessionKey, openId);
//
//                    // 发送失败，抛异常，使事务回滚
//                    if (!"200".equals(errmsg)) {
//                        //throw new RuntimeException("发送失败,请联系管理员");
//                        return new ResponseMessage("203", formid);
//                    }
//                } else if (assetCardTemp == null) {
//                    StringBuffer msg = new StringBuffer("收到新的报修单:");
//                    StringBuffer userStrTemp = new StringBuffer(entity.getServiceuser().toUpperCase());
//                    msg.append(formid).append("<br/>");
//                    msg.append("资产编号:").append("无<br/>");
//                    msg.append("设备名称:").append("其他设备<br/>");
//                    msg.append("设备位置:").append(entity.getRepairarea()).append("<br/>");
//                    msg.append("报修人:").append(entity.getRepairuser()).append("-").append(entity.getRepairusername()).append("<br/>");
//                    msg.append("维修人:").append(entity.getServiceuser()).append("-").append(entity.getServiceusername()).append("<br/>");
//                    msg.append("详情请至微信小程序查看!");
//
////                    sysUserList = systemUserBean.findByDeptno("1W300");
////                    if(sysUserList.size() > 0)
////                    {
////                        userStrTemp.append("|").append(sysUserList.get(0).getUserid().toUpperCase());
////                    }
//                    String repairDeptMangerId = sysCodeBean.findBySyskindAndCode(companyCodeStr, "RD", "repairleaders").getCvalue();
//
//                    if (repairDeptMangerId != null && !repairDeptMangerId.equals("")) {
//                        userStrTemp.append("|").append(repairDeptMangerId.toUpperCase());
//                    }
//
//                    if ("枫泾厂".equalsIgnoreCase(entity.getRepairarea()) || "枫泾总部".equalsIgnoreCase(entity.getRepairarea())) {
//                        userStrTemp.append("|").append("C0299");
//                    } else if ("兴塔厂".equalsIgnoreCase(entity.getRepairarea()) || "枫泾一厂".equalsIgnoreCase(entity.getRepairarea())) {
//                        userStrTemp.append("|").append("C0141");
//                    }
//
//                    String errmsg = sendMsgString(userStrTemp.toString(), msg.toString(), sessionKey, openId);
//
//                    // 发送失败，抛异常，使事务回滚
//                    if (!"200".equals(errmsg)) {
//                        //throw new RuntimeException("发送失败,请联系管理员");
//                        return new ResponseMessage("203", formid);
//                    }
//                }
                return new ResponseMessage("200", hiddenTemp.getId());
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("getHiddenDocImageInfo/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getHiddenDocImageInfo(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            String companyCodeStr = "";
            this.superEJB = ehsHiddenDangerFileBean;
            List<Object> list = new ArrayList<>();
            List<EhsHiddenDangerFile> hiddenImageListRes = new ArrayList<>();
            List<EhsHiddenDangerParameter> hiddenTypeList = new ArrayList<EhsHiddenDangerParameter>();
            List<EhsHiddenDangerParameter> rectificationTypeList = new ArrayList<EhsHiddenDangerParameter>();
            List<EhsSecure> rectifierList = new ArrayList<EhsSecure>();
            List<EhsSecure> acceptList = new ArrayList<EhsSecure>();
            List<EhsSecure> checkList = new ArrayList<EhsSecure>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                String key, value = "";
                if (filtersMM != null) {
                    companyCodeStr = filtersMM.getFirst("company");
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
                hiddenImageListRes = ehsHiddenDangerFileBean.findByFilters(filterFields);
                hiddenTypeList = ehsHiddenDangerParameterBean.getTroubleNameList(companyCodeStr, "YH", "HiddenType");
                rectificationTypeList = ehsHiddenDangerParameterBean.getTroubleNameList(companyCodeStr, "YH", "RectificationType");
                Map<String, Object> filterSecure = new HashMap<>();
                filterSecure.put("company", companyCodeStr);
                filterSecure.put("position", "整改人");
                rectifierList = ehsSecureBean.findByFilters(filterSecure);
                filterSecure.clear();
                filterSecure.put("company", companyCodeStr);
                filterSecure.put("position", "单位课长");
                acceptList = ehsSecureBean.findByFilters(filterSecure);

                filterSecure.put("company", companyCodeStr);
                filterSecure.put("position", "月安全课长");
                filterSecure.put("remark", new Date().getMonth() + 1 + "");
                checkList = ehsSecureBean.findByFilters(filterSecure);
                list.add(hiddenImageListRes);
                list.add(hiddenTypeList);
                list.add(rectificationTypeList);
                list.add(rectifierList);
                list.add(acceptList);
                list.add(checkList);

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
                filterFields.put("deptNo", entity.getDeptNo().substring(0, 3));
                eStandard = ehsSafemanagerStandardBean.findByFilters(filterFields);
                eStandard = ehsSafemanagerStandardBean.findAll();
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
                eInspection.setPatrolPost("岗位自查");
                eInspection.setResult("待检");
                eInspection.setStatus("S");
                eInspection.setCreateId(entity.getCreateId());
                eInspection.setCreateTime(new Date());
                int i = 1;
                int id = ehsHazardInspectionDtaBean.findAll().size() + 1;//获取当前多少条
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
                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Update失败");
            }
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
