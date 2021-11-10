/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.HKPB033Application;
import cn.hanbell.oa.app.HKPB033FilesApplication;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKPB033Bean;
import cn.hanbell.oa.ejb.HKPB033WorkFlowBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.HKPB033;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HKPB033Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @author C2082
 */
@Path("efgp/hkpb033")
@javax.enterprise.context.RequestScoped
public class HKPB033FacadeREST extends SuperRESTForEFGP<HKPB033> {

    @EJB
    private UsersBean userBean;
    @EJB
    private HKPB033Bean hkpb033Bean;

    @EJB
    private HKPB033WorkFlowBean hkpb033WorkFlowBean;

    public HKPB033FacadeREST() {
        super(HKPB033.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hkpb033Bean;
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(HKPB033Application entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            List<JSONObject> files = new ArrayList<>();
            try {
                for (HKPB033FilesApplication e : entity.getHkpb033Files()) {
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
                workFlowBean.initUserInfo(entity.getApplyUserId());
                HKPB033Model hkpb033 = new HKPB033Model();
                hkpb033.setFormDate(BaseLib.formatDate("YYYY/MM/dd", new Date()));
                hkpb033.setAuditor(entity.getApplyUserId());
                hkpb033.setSecurityOfficer(entity.getSafetyOfficeId());
                hkpb033.setCorrectDept(entity.getSafetyDeptId());
                hkpb033.setDepartmentHead(entity.getDeptManager1Id());
                hkpb033.setSectionSupervisor(entity.getDeptManager2Id());
                hkpb033.setSite(entity.getAddress());
                hkpb033.setSafetySectionChief(entity.getMonthSafetyOfficeId());
                hkpb033.setHdnSafetySectionChief(entity.getMonthSafetyOfficeName());
                hkpb033.setSignatory(entity.getSafetyOfficeId());
                hkpb033.setRisksdesc(entity.getDescribe());
                hkpb033.setTargetDate("");
                hkpb033.setTrackingDate("");
                hkpb033.setReason("");
                hkpb033.setShortterm("");
                hkpb033.setLongterm("");
                hkpb033.setSschief_confirm("");
                hkpb033.setOrderDate("");
                String charge = entity.getChargeId();
                if ("1".equals(charge)) {
                    hkpb033.setOrder1(charge);
                } else if ("2".equals(charge)) {
                    hkpb033.setOrder2(charge);
                } else if ("3".equals(charge)) {
                    hkpb033.setOrder3(charge);
                } else if ("4".equals(charge)) {
                    hkpb033.setOrder4(charge);
                    hkpb033.setOrderDate(entity.getEndDate());
                }

                hkpb033.setConstruction(entity.getConstructionSide());
                hkpb033.setProject(entity.getConstructionProject());
                hkpb033.setAmount(entity.getDeduction() != null && !"".equals(entity.getDeduction()) ? Double.valueOf(entity.getDeduction()) : 0.0);
                Users user = userBean.findById(entity.getApplyUserId());
                String formInstance = hkpb033WorkFlowBean.buildXmlForEFGP("HK_PB033", hkpb033, files, user.getOid());
                String subject = entity.getApplyUserName() + "--安全隐患整改单";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_PB033", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    return new ResponseMessage(rm[0], rm[1]);
                } else {
                    return new ResponseMessage("200", "success");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return null;
    }

}
