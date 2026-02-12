/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.hrm.ejb.EmployeeBean;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.HKGL082FilesApplication;
import cn.hanbell.oa.app.IssueApplication;
import cn.hanbell.oa.app.KV;
import cn.hanbell.oa.app.ResignApplication;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKGL082Bean;
import cn.hanbell.oa.ejb.HKPB033WorkFlowBean;
import cn.hanbell.oa.entity.HKGL016;
import cn.hanbell.oa.entity.HKGL082;
import cn.hanbell.oa.model.HKGL016Model;
import cn.hanbell.oa.model.HKGL082Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author C2082
 */
@Path("efgp/hkgl082")
@javax.enterprise.context.RequestScoped
public class HKGL082FacadeREST extends SuperRESTForEFGP<HKGL082> {

    @EJB
    private HKGL082Bean HKGL082Bean;

    @EJB
    private EmployeeBean employeeBean;
    
    @EJB
    private HKPB033WorkFlowBean hkpb033WorkFlowBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return HKGL082Bean;
    }

    public HKGL082FacadeREST() {
        super(HKGL082.class);
    }
    
    
    @GET
    @Path("userInfo")
    @Produces({MediaType.APPLICATION_JSON})
    public WechatHKGL082InfoResultDto findUserInfo(@QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("userid") String userid) {
        if (isAuthorized(appid, token)) {
            try {
                List<KV> dataList = new ArrayList<>();
                cn.hanbell.hrm.entity.Employee employee = employeeBean.findByCode(userid);
                if (employee == null) {
                    throw new Exception("找不到该员工。");
                }
                if (employee.getJob() == null) {
                    throw new Exception("找不到该员工岗位别。");
                }
                WechatHKGL082InfoResultDto dto = new WechatHKGL082InfoResultDto();
                dto.grade = employee.getLevelId();
                dto.post = employee.getJob().getCode();
                dto.postDesc = employee.getJob().getName();
                dto.workDate = employee.getWorkingAgeBeginDate().getTime();
             //   dto.workDate = BaseLib.getDate();
                String facno = HKGL082Bean.getCompanyByDeptId(employee.getDepartment().getCode());
                String facnoname = HKGL082Bean.getCompanyName(facno);
                dto.facno = facno;
                dto.facnoname = facnoname;
                return dto;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(IssueApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                List<JSONObject> files = new ArrayList<>();
                for (HKGL082FilesApplication e : entity.getHkgl082Files()) {
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
                workFlowBean.initUserInfo(entity.getEmployeeNo());
                HKGL082Model item = new HKGL082Model();
                item.setFacno(entity.getFacno());
                item.setApplyUser(entity.getEmployeeNo());
                item.setApplyDept(entity.getDepeNo());
                item.setApplyDate(BaseLib.getDate());
                item.setWorkbeginDate(entity.getWorkStartDate());
                item.setPosition(entity.getPostDesc());
                item.setTitle(entity.getGrade());
                item.setProofType(entity.getProofType());
                item.setApplyReason(entity.getReasonCode());
                item.setLoanAmount(entity.getMoney());
                item.setExplain(entity.getSumrry());

//                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL082", item, null);
                String formInstance = hkpb033WorkFlowBean.buildXmlForEFGP("HK_GL082", item, files, null);
                String subject = entity.getEmployeeName() + entity.getProofDesc() + "申请";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL082", formInstance, subject);
                //String msg = "123\\PKG_HK_GL082202601200003";
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    return new ResponseMessage("200", rm[1]);
                } else {
                    return new ResponseMessage("500", "失败");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseMessage("500", "资料填写有误，核对后请联系管理员");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public class WechatHKGL082InfoResultDto {

        private String facno;
        private String facnoname;
        private String post;
        private String postDesc;
        private String grade;
        private long workDate;

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getPostDesc() {
            return postDesc;
        }

        public void setPostDesc(String postDesc) {
            this.postDesc = postDesc;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public long getWorkDate() {
            return workDate;
        }

        public void setWorkDate(long workDate) {
            this.workDate = workDate;
        }


        public String getFacno() {
            return facno;
        }

        public String getFacnoname() {
            return facnoname;
        }
        
    }
}
