/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.oa.app.LeaveApplication;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.MCHKGL004;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKGL004Bean;
import cn.hanbell.oa.entity.HKGL004;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.model.HKGL004Model;
import cn.hanbell.util.BaseLib;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("efgp/hkgl004")
@javax.enterprise.context.RequestScoped
public class HKGL004FacadeREST extends SuperRESTForEFGP<HKGL004> {

    @EJB
    private HKGL004Bean hkgl004Bean;

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
                workFlowBean.initUserInfo(entity.getEmployee());
                HKGL004Model la = new HKGL004Model();
                la.setApplyDate(BaseLib.getDate());
                la.setApplyUser(workFlowBean.getCurrentUser().getId());
                la.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
                la.setApplyDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
                la.setHdn_applyDept(workFlowBean.getUserFunction().getOrganizationUnit().getOrganizationUnitName());
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
                la.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
                la.setReason(entity.getReason());

                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL004", la, null);
                String subject = la.getHdn_employee() + entity.getDate1() + "开始请假" + entity.getLeaveDay() + "天" + entity.getLeaveHour() + "时" + entity.getLeaveMinute() + "分";
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
