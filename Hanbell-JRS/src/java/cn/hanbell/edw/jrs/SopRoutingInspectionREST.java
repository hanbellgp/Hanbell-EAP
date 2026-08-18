/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.hanbell.edw.jrs;

import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.eam.ejb.SysCodeBean;
import cn.hanbell.eam.entity.SysCode;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.edw.ejb.RdpmSubjectUserReportsBean;
import cn.hanbell.edw.ejb.SopInspectionDtaBean;
import cn.hanbell.edw.ejb.SopSafemanagerStandardBean;
import cn.hanbell.edw.entity.RdpmSubjectUserReports;
import cn.hanbell.edw.entity.SopInspectionDta;
import cn.hanbell.edw.entity.SopSafemanagerStandard;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEDW;
import com.lightshell.comm.SuperEJB;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.json.JSONArray;

/**
 *
 * @author 研发项目管理专案
 */
/**
 *
 * @author C2079
 */
@Stateless
@Path("shbedw/sop")
public class SopRoutingInspectionREST extends SuperRESTForEDW<RdpmSubjectUserReports> {

    @EJB
    private RdpmSubjectUserReportsBean rdpmSubjectUserReportsBean;
    @EJB
    private SopSafemanagerStandardBean sopSafemanagerStandardBean;

    @EJB
    private SopInspectionDtaBean sopInspectionDtaBean;
    protected SuperEJB superEJB;
    @EJB
    private SystemUserBean systemUserBean;
    @EJB
    private SysCodeBean sysCodeBean;

    @Override
    protected SuperEJB getSuperEJB() {
        return rdpmSubjectUserReportsBean;
    }

    public SopRoutingInspectionREST() {
        super(RdpmSubjectUserReports.class);

    }

    @GET
    @Path("getSopRoutingInspectionModel/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getSopRoutingInspectionModel(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("deptId") String deptId) {
        if (isAuthorized(appid, token)) {
            this.superEJB = rdpmSubjectUserReportsBean;
            List<SopSafemanagerStandard> sopList = new ArrayList<>();
            List<SopInspectionDta> sopDtaList = new ArrayList<>();
            List<Object> initDtaRes = new ArrayList<Object>();
            MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
            String post = filtersMM.getFirst("post");
            String factory = filtersMM.getFirst("factory");
            String company = filtersMM.getFirst("company");
            List<SysCode> deptListRes = new ArrayList<SysCode>();
            Map<String, Object> filterFields_troubleFrom = new HashMap<>();
            filterFields_troubleFrom.put("code", deptId);
            deptListRes = sysCodeBean.findByFilters(filterFields_troubleFrom);
            if (factory.equals("null") && deptListRes.size() > 0) {
                factory = deptListRes.get(0).getCdesc();
            }
            List<Object[]> list = new ArrayList<Object[]>();
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                sopDtaList = sopInspectionDtaBean.getSopDtaList(company, post, factory);
                if (sopDtaList.size() > 0) {
                    initDtaRes.add(deptListRes);
                    initDtaRes.add(sopDtaList);
                    return initDtaRes;
                }
                sopList = sopSafemanagerStandardBean.getSopSafemanagerStandardList(company, post, factory);

                for (SopSafemanagerStandard sop : sopList) {

                    SopInspectionDta sDta = new SopInspectionDta();
                    sDta.setId("");
                    sDta.setCheckClass(sop.getCheckClass());
                    sDta.setCheckType(sop.getCheckType());
                    sDta.setCompany(sop.getCompany());
                    sDta.setDeptNo(sop.getDeptNo());
                    sDta.setDeptName(sop.getDeptName());
                    sDta.setPost(sop.getPost());
                    sDta.setResult("待检");
                    sDta.setMessage("");
                    sDta.setReferencespeciFications(sop.getReferencespeciFications());
                    sDta.setFactory(sop.getFactory());
                    sDta.setCreateTime(new Date());
                    sopDtaList.add(sDta);
                }
                if (sopDtaList.size() > 0) {
                    initDtaRes.add(deptListRes);
                    initDtaRes.add(sopDtaList);
                    return initDtaRes;
                }
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return initDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("autonomous-maintain-start")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpMaintenance_autoMaintain(SopInspectionDta entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                Date minOptDate = new Date();

                List<SopInspectionDta> sDtaList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(entity.getMessage());
                JSONArray eqpMaintainDetailList_jsonArray = jsonArray.getJSONArray(0);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                for (Object obj : eqpMaintainDetailList_jsonArray) {
                    org.json.JSONObject jsonObject = (org.json.JSONObject) obj;
                    SopInspectionDta sDta = new SopInspectionDta();
                    String id = jsonObject.optString("id");
                    if (id == null || "".equals(id)) {
                        UUID staUuid = UUID.randomUUID();
                        sDta.setId(staUuid.toString());
                        sDta.setCreateId(entity.getUpdateId());
                        sDta.setCreateTime(new Date());

                    } else {
                        sDta.setUpdateId(entity.getUpdateId());
                        sDta.setUpdateTime(new Date());
                        String createDate = jsonObject.optString("createTime");

                        if (createDate != null && !createDate.isEmpty()) {
                            String utcStr = createDate.replace("[UTC]", "");
                            Instant instant = Instant.parse(utcStr);
                            ZonedDateTime local = instant.atZone(ZoneId.of("Asia/Shanghai"));
                            createDate = local.format(FORMATTER);
                            Date startDateTemp = sdf.parse(createDate);
                            sDta.setCreateTime(startDateTemp);
                        }
                        sDta.setId(jsonObject.optString("id"));
                        sDta.setCreateId(jsonObject.optString("createId"));
                    }

                    sDta.setCompany(jsonObject.optString("company"));
                    sDta.setCheckClass(jsonObject.optString("checkClass"));
                    sDta.setCheckType(jsonObject.optString("checkType"));
                    sDta.setDeptNo(jsonObject.optString("deptNo"));
                    sDta.setDeptName(jsonObject.optString("deptName"));
                    sDta.setFactory(jsonObject.optString("factory"));
                    sDta.setMessage(jsonObject.optString("message"));
                    sDta.setPost(jsonObject.optString("post"));
                    sDta.setResult(jsonObject.optString("result"));
                    sDta.setReferencespeciFications(jsonObject.optString("referencespeciFications"));
                    sDtaList.add(sDta);
                }

                sopInspectionDtaBean.update(sDtaList);

                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Update失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("saveReport")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage saveReport(JSONObject jsonObj1, @QueryParam("reportingDate") String reportingDate, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(reportingDate);
                // 2. 提取 jsonObj1 的字符串值
                String jsonArrayStr = jsonObj1.getString("jsonObj1");
                // 3. 去除外层方括号（字符串实际是数组的字符串形式）
                jsonArrayStr = jsonArrayStr.substring(1, jsonArrayStr.length() - 1);
                // 4. 解析内层 JSON 数组
                JSONArray dataArray = new JSONArray(jsonArrayStr);
                List<RdpmSubjectUserReports> list = new ArrayList<>();
                String ITEM = "";
                for (int i = 0; i < dataArray.length(); i++) {
                    org.json.JSONObject jsonObj = (org.json.JSONObject) dataArray.get(i);
                    RdpmSubjectUserReports uR = new RdpmSubjectUserReports();

                    uR.setId(jsonObj.getString("id"));
                    uR.setSubjectWorkPercent(jsonObj.getDouble("subjectWorkPercent") / 100);//存的是百分比转换一下
                    uR.setSubjectName(jsonObj.getString("subjectName"));
                    uR.setSubjectNo(jsonObj.getString("subjectNo"));
                    uR.setuType(jsonObj.getString("uType"));
                    uR.setSubjectUserNo(jsonObj.getString("subjectUserNo"));
                    uR.setSubjectWorkDateTime(date);
                    uR.setSubjectUserName(jsonObj.getString("subjectUserName"));
                    uR.setSubjectSeq(jsonObj.getInt("subjectSeq"));
                    uR.setSubjectSeqName(jsonObj.getString("subjectSeqName"));
                    if (uR.getFacno() == null) {
                        String userno = jsonObj.getString("subjectUserNo");
                        SystemUser sUser = systemUserBean.findByUserId(jsonObj.getString("subjectUserNo"));
                        uR.setFacno(sUser.getDept().getCompany());
                        uR.setSubjectDept(sUser.getDeptno());
                        uR.setSubjectDeptName(sUser.getDept().getDept());
                    }

                    if (uR.getRelationUserNo() == null && !uR.getSubjectNo().equals("01")) {
                        String relationUserNo = "[";
                        List<Object[]> rdpmSubjectUserList = rdpmSubjectUserReportsBean.getRdpmSubjectUserList(jsonObj.getString("subjectUserNo"));
                        for (Object[] rE : rdpmSubjectUserList) {
                            relationUserNo += " {\"UserNo\":\"" + rE[0] + "\",\"UserName\":\"" + rE[1] + "\",\"UType\":\"" + rE[2] + "\"},";
                        }
                        if (relationUserNo != null && relationUserNo != "[") {
                            relationUserNo = relationUserNo.substring(0, relationUserNo.length() - 1);
                            relationUserNo += "]";
                            uR.setRelationUserNo(relationUserNo);
                        }
                    }
                    list.add(uR);
                }
                rdpmSubjectUserReportsBean.update(list);
                return new ResponseMessage("200", "保存成功");
            } catch (Exception e) {
                return new ResponseMessage("300", "保存失败,请重试!");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
