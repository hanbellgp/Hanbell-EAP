/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.hrm.ejb.CodeInfoBean;
import cn.hanbell.hrm.ejb.EmployeeBean;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.HKGL004FilesApplication;
import cn.hanbell.oa.app.KV;
import cn.hanbell.oa.app.LeaveApplication;
import cn.hanbell.oa.app.ResignApplication;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKGL016Bean;
import cn.hanbell.oa.ejb.HKGL034Bean;
import cn.hanbell.oa.entity.HKGL016;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HKGL004Model;
import cn.hanbell.oa.model.HKGL016Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@Path("efgp/hkgl016")
@javax.enterprise.context.RequestScoped
public class HKGL016FacadeREST extends SuperRESTForEFGP<HKGL016> {

    @EJB
    private HKGL016Bean hkgl016Bean;

    @EJB
    private EmployeeBean employeeBean;

    

    public HKGL016FacadeREST() {
        super(HKGL016.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hkgl016Bean;
    }

    @GET
    @Path("userInfo")
    @Produces({MediaType.APPLICATION_JSON})
    public WechatHKGL016InfoResultDto findUserInfo(@QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("userid") String userid) {
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
                WechatHKGL016InfoResultDto dto = new WechatHKGL016InfoResultDto();
                dto.grade = employee.getLevelId();
                dto.post = employee.getJob().getCode();
                dto.postDesc = employee.getJob().getName();
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
    public ResponseMessage create(ResignApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                workFlowBean.initUserInfo(entity.getEmployeeNo());
                HKGL016Model item = new HKGL016Model();
                item.setApplyUser(entity.getEmployeeNo());
                item.setApplyDept(entity.getDepeNo());
                item.setApplyDate(BaseLib.getDate());
                item.setPost1(entity.getPost());
                item.setHdnpost1(item.getPost1());
                item.setUserTitle(entity.getGrade());
                item.setAdministrativeDuties(entity.getIsAdmin());
                item.setContractDate(entity.getWorkdate());
                item.setRetirementDate(entity.getResigndate());
                item.setRetireReason(entity.getReason());
             
                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL016", item, null);
                String subject = entity.getEmployeeName()+"离职申请";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL016", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    return new ResponseMessage("200", rm[1]);
                } else {
                    return new ResponseMessage("200", "失败");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseMessage("500", "资料填写有误，核对后请联系管理员");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    
    
    

    public class WechatHKGL016InfoResultDto {
        private String post;
        private String postDesc;
        private String grade;
        
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

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.post);
            hash = 97 * hash + Objects.hashCode(this.postDesc);
            hash = 97 * hash + Objects.hashCode(this.grade);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final WechatHKGL016InfoResultDto other = (WechatHKGL016InfoResultDto) obj;
            if (!Objects.equals(this.post, other.post)) {
                return false;
            }
            if (!Objects.equals(this.postDesc, other.postDesc)) {
                return false;
            }
            if (!Objects.equals(this.grade, other.grade)) {
                return false;
            }
            return true;
        }
        
        

    }
}
