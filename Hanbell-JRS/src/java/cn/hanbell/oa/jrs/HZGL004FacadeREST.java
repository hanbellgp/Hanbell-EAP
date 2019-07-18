/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperREST;
import cn.hanbell.oa.app.MCHZGL004;
import cn.hanbell.oa.app.MCHZGL004BizDetail;
import cn.hanbell.oa.ejb.HZGL004Bean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.entity.HZGL004;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.model.HZGL004BizDetailModel;
import cn.hanbell.oa.model.HZGL004Model;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
@Path("efgp/hzgl004")
@javax.enterprise.context.RequestScoped
public class HZGL004FacadeREST extends SuperREST<HZGL004> {

    @EJB
    private WorkFlowBean workFlowBean;
    @EJB
    private HZGL004Bean hzgl004Bean;

    @Override
    protected SuperEJB getSuperEJB() {
        return hzgl004Bean;
    }

    public HZGL004FacadeREST() {
        super(HZGL004.class);
    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(MCHZGL004 entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (entity == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        HZGL004Model m;
        HZGL004BizDetailModel d;
        List<HZGL004BizDetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("bizDetail", detailList);
        try {
            //初始化发起人
            workFlowBean.initUserInfo(entity.getApplyUser());
            //实例化对象
            m = new HZGL004Model();
            m.setFacno(entity.getCompany());
            m.setApplyDate(BaseLib.getDate());
            m.setApplyUser(workFlowBean.getCurrentUser().getId());
            m.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
            OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getApplyDept());
            if (ou == null) {
                throw new NullPointerException(entity.getApplyDept() + "不存在");
            }
            m.setApplyDept(ou.getId());
            m.setHdn_applyDept(ou.getOrganizationUnitName());
            m.setFormType(entity.getFormType());
            if ("7".equals(entity.getFormType())) {
                m.setOtherType(entity.getOtherType());
            } else {
                m.setOtherType("");
            }
            m.setHdn_formType(entity.getFormTypeDesc());
            m.setVehicle(entity.getVehicle());
            if ("6".equals(entity.getVehicle())) {
                m.setOtherVehicle(entity.getOtherVehicle());
            } else {
                m.setOtherVehicle("");
            }
            m.setHdn_vehicle(entity.getVehicleDesc());
            m.setDestination(entity.getDestination());
            m.setHdn_destination(entity.getDestinationDesc());
            m.setDay1(BaseLib.getDate("yyyy/MM/dd", entity.getStartDate()));
            m.setDay2(BaseLib.getDate("yyyy/MM/dd", entity.getEndDate()));
            m.setDays(entity.getDays());
            m.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
            m.setHdn_employee(workFlowBean.getCurrentUser().getId());
            m.setHdn_days(m.getDays());
            int seq = 0;
            for (MCHZGL004BizDetail mcd : entity.getDetailList()) {
                seq++;
                d = new HZGL004BizDetailModel();
                d.setSeq(String.valueOf(seq));
                d.setBizEmployee_txt(mcd.getBizEmployee());
                d.setBizEmployee_lbl(mcd.getBizEmployeeName());
                d.setBizDate_txt(mcd.getBizDate());
                d.setBizTime1_txt(mcd.getBizTime1());
                d.setBizTime2_txt(mcd.getBizTime2());
                d.setBizObject(mcd.getBizObject());
                d.setBizAddress(mcd.getBizAddress());
                d.setBizContent(mcd.getBizContent());
                d.setUserTitle(m.getUserTitle());
                detailList.add(d);
            }
            //发起流程
            String formInstance = workFlowBean.buildXmlForEFGP("HZ_GL004", m, details);
            String subject = m.getHdn_applyUser() + entity.getStartDate() + "开始出差" + entity.getDays() + "天";
            String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HZ_GL004", formInstance, subject);
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
