/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.oa.app.LeaveApplication;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.HKGL004FilesApplication;
import cn.hanbell.oa.app.MCHKGL004;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKGL004Bean;
import cn.hanbell.oa.ejb.HKPB033WorkFlowBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.HKGL004;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HKGL004Model;
import cn.hanbell.util.BaseLib;
import cn.hanbell.wco.ejb.Agent1000002Bean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author C0160
 */
@Path("efgp/hkgl004")
@javax.enterprise.context.RequestScoped
public class HKGL004FacadeREST extends SuperRESTForEFGP<HKGL004> {

    @EJB
    private HKGL004Bean hkgl004Bean;

    @EJB
    private UsersBean userBean;

    @EJB
    private Agent1000002Bean agent1000002Bean;

    @EJB
    private HKPB033WorkFlowBean hkpb033WorkFlowBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hkgl004Bean;
    }

    public HKGL004FacadeREST() {
        super(HKGL004.class);
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(LeaveApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                List<JSONObject> files = new ArrayList<>();
                for (HKGL004FilesApplication e : entity.getHkgl004Files()) {
                    String fileName = String.valueOf(BaseLib.getDate().getTime()).concat(".").concat(e.getImageType());
                    String fileInfo = workFlowBean.reserveNoCmDocument(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, fileName);
                    JSONObject requestedJSON = XML.toJSONObject(fileInfo);
                    //路径
                    StringBuffer url = new StringBuffer("");
                    url.append(workFlowBean.FILE_URL);
                    url.append(requestedJSON.getJSONObject("com.dsc.nana.services.webservice.ReserveNoCmDocInfo").getString("filePathToSave")).append("/");
                    StringBuffer fileName1 = new StringBuffer("");
                    fileName1.append(requestedJSON.getJSONObject("com.dsc.nana.services.webservice.ReserveNoCmDocInfo").getString("physicalName"));
                    fileName1.append(".").append(e.getImageType());
                    workFlowBean.getShareFileContent(workFlowBean.OA_USERNO, workFlowBean.OA_PASSWORD, url.toString().replace("\\", "/") + fileName1, e.getData());
                    JSONObject attachment = new JSONObject();
                    attachment.append("OID", requestedJSON.getJSONObject("com.dsc.nana.services.webservice.ReserveNoCmDocInfo").get("OID"));
                    attachment.append("id", fileName1.toString());
                    attachment.append("fileSize", workFlowBean.getFileSize(workFlowBean.OA_USERNO, workFlowBean.OA_PASSWORD, url.toString().replace("\\", "/")));
                    attachment.append("fileType", e.getImageType());
                    attachment.append("name", fileName1.toString());
                    attachment.append("originalFileName", fileName1.toString());
                    attachment.append("uploadTime", new Date().getTime());
                    files.add(attachment);
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(BaseLib.getDate());
                if ("Y".equals(entity.getOverdue())) {
                    calendar.add(Calendar.DATE, -7);
                } else {
                    calendar.add(Calendar.DATE, -1);
                }
                Date zero = calendar.getTime();
                Date date1 = BaseLib.getDate("yyyy-MM-dd", entity.getDate1());
                Date date2 = BaseLib.getDate("yyyy-MM-dd", entity.getDate2());
                if (zero.getTime() >= date1.getTime()) {
                    return new ResponseMessage("500", "填单日期晚于实际请假日期不可以申请！");
                }
                if (date1.getTime() > date2.getTime()) {
                    return new ResponseMessage("500", "开始日期不能大于结束日期！");
                }
                workFlowBean.initUserInfo(entity.getEmployee());
                HKGL004Model la = new HKGL004Model();
                la.setApplyDate(BaseLib.getDate());
                la.setApplyUser(workFlowBean.getCurrentUser().getId());
                la.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
                la.setApplyDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
                la.setHdn_applyDept(workFlowBean.getUserFunction().getOrganizationUnit().getOrganizationUnitName());
                la.setIsWechat("Y");
                la.setOverdue(entity.getOverdue());
                //根据部门编号代出公司编号
                la.setFacno(workFlowBean.getCompanyByDeptId(la.getApplyDept()));
                la.setHdn_facno(la.getFacno());
                la.setLeana(entity.getFormType());
                la.setHdn_leana(entity.getFormTypeDesc());
                la.setLeano(entity.getFormKind());
                la.setHdn_leano(entity.getFormKindDesc());
                la.setLeatp(entity.getWorkType());
                la.setHdn_leatp(entity.getWorkTypeDesc());
                la.setEmployee(workFlowBean.getCurrentUser().getId());
                la.setHdn_employee(workFlowBean.getCurrentUser().getUserName());
                la.setDay("0");
                la.setDate1(BaseLib.getDate("yyyy-MM-dd", entity.getDate1()));
                la.setTime1(entity.getTime1());
                la.setDate2(BaseLib.getDate("yyyy-MM-dd", entity.getDate2()));
                la.setTime2(entity.getTime2());
                la.setLeaday1(entity.getLeaveDay());
                la.setLeaday2(entity.getLeaveHour());
                la.setLeaday3(entity.getLeaveMinute());
                la.setSamefirst(BaseLib.getDate("yyyy-MM-dd", entity.getSameDate()));
                la.setSamedays(entity.getSameDays());
                la.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(entity.getReason());
                String finishedReplaceStr = m.replaceAll("");
                la.setReason(finishedReplaceStr);
                Users user = userBean.findById(entity.getEmployee());
                String formInstance = hkpb033WorkFlowBean.buildXmlForEFGP("HK_GL004", la, files, null);
                String subject = la.getHdn_employee() + entity.getDate1() + "开始请假" + entity.getLeaveDay() + "天" + entity.getLeaveHour() + "时" + entity.getLeaveMinute() + "分";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL004", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    agent1000002Bean.initConfiguration();
                    agent1000002Bean.sendMsgToUser(entity.getEmployee(), "text", "[汉钟精机] 您申请的" + entity.getDate1() + "请假单已完成填单");
                    return new ResponseMessage(rm[0], rm[1]);
                } else {
                    return new ResponseMessage("200", "Code=200");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseMessage("500", "资料填写有误，核对后请联系管理员");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(MCHKGL004 entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (entity == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        try {
            //初始化发起人
            workFlowBean.initUserInfo(entity.getApplyUser());
            //实例化对象
            HKGL004Model la = new HKGL004Model();
            la.setFacno(entity.getCompany());
            la.setHdn_facno(entity.getCompany());
            la.setApplyDate(BaseLib.getDate());
            la.setApplyUser(workFlowBean.getCurrentUser().getId());
            la.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
            OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getApplyDept());
            if (ou == null) {
                throw new NullPointerException(entity.getApplyDept() + "不存在");
            }
            la.setApplyDept(ou.getId());
            la.setHdn_applyDept(ou.getOrganizationUnitName());
            //根据部门编号代出公司编号
            la.setLeana(entity.getFormType());
            la.setHdn_leana(entity.getFormTypeDesc());
            la.setLeano(entity.getFormKind());
            la.setHdn_leano(entity.getFormKindDesc());
            la.setLeatp(entity.getWorkType());
            la.setHdn_leatp(entity.getWorkTypeDesc());
            la.setEmployee(workFlowBean.getCurrentUser().getId());
            la.setHdn_employee(workFlowBean.getCurrentUser().getUserName());
            la.setDate1(BaseLib.getDate("yyyy-MM-dd", entity.getStartDate()));
            la.setTime1(entity.getStartTime());
            la.setDate2(BaseLib.getDate("yyyy-MM-dd", entity.getEndDate()));
            la.setTime2(entity.getEndTime());
            la.setLeaday1(entity.getLeaveDay());
            la.setLeaday2(entity.getLeaveHour());
            la.setLeaday3(entity.getLeaveMinute());
            la.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
            la.setReason(entity.getReason());
            //发起流程
            String formInstance = workFlowBean.buildXmlForEFGP("HK_GL004", la, null);
            String subject = la.getHdn_employee() + entity.getStartDate() + "开始请假" + entity.getLeaveDay() + "天" + entity.getLeaveHour() + "时" + entity.getLeaveMinute() + "分";
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL004", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2) {
                return new ResponseMessage(rm[0], rm[1]);
            } else {
                return new ResponseMessage("200", "Code=200");
            }
        } catch (Exception ex) {
            return new ResponseMessage("500", "系统错误更新失败");
        }
    }

}
