/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCHZGL004;
import cn.hanbell.costctrl.app.MCHZGL004BizDetail;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HZGL004Bean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.HZGL004;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HZGL004BizDetailModel;
import cn.hanbell.oa.model.HZGL004Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Administrator
 */
@Path("costctrl/hzgl004")
@javax.enterprise.context.RequestScoped
public class HZGL004FacadeREST extends SuperRESTForEFGP<HZGL004> {

    @EJB
    private HZGL004Bean hzgl004Bean;
    @EJB
    private UsersBean usersBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hzgl004Bean;
    }

    public HZGL004FacadeREST() {
        super(HZGL004.class);
    }

    @POST
    @Path("check")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData checkMCHZCW017(MCHZGL004 entity) {
        try {
            MCResponseData rs = new MCResponseData();
            rs = checkBeforeSend(entity);
            return rs;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData createOAHZGL004(MCHZGL004 entity) {
        if (entity == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        //先检核再新增
        MCResponseData rs = new MCResponseData();
        rs = checkBeforeSend(entity);
        if (rs.getCode() != 200) {
            return rs;
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
            m.setFacno(entity.getFacno());
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
            m.setOtherType("");
            m.setVehicle(entity.getVehicle());
            m.setOtherVehicle("");
            m.setDestination(entity.getDestination());
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
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher matcher = p.matcher(mcd.getBizContent());
                String finishedReplaceStr = matcher.replaceAll("");
                d.setBizContent(finishedReplaceStr);
                d.setUserTitle(m.getUserTitle());
                detailList.add(d);
            }
            //发起流程
            String formInstance = workFlowBean.buildXmlForEFGP("HZ_GL004", m, details);
            String subject = m.getHdn_applyUser() + entity.getStartDate() + "开始出差" + entity.getDays() + "天";
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HZ_GL004", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2) {
                return new MCResponseData(Integer.valueOf(rm[0]), rm[1]);
            } else {
                return new MCResponseData(200, "Code=200");
            }
        } catch (Exception ex) {
            return new MCResponseData(500, "系统错误更新失败");
        }
    }

    public MCResponseData checkBeforeSend(MCHZGL004 mc) {
        int code = MessageEnum.Failue_101.getCode();
        String msg = MessageEnum.Failue_101.getMsg();
        try {
            //判断token 是否有效
            if (mc == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!mc.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }

            String srcno = mc.getSrcno();
            if (srcno.isEmpty()) {
                code = 107;
                msg = "来源单号不能为空";
                return new MCResponseData(code, msg);
            }

            String applyUser = mc.getApplyUser();
            Users u = usersBean.findById(applyUser);
            if (null == u || u.getLeaveDate() != null) {
                code = 107;
                msg = "传入申请人数据无效";
                return new MCResponseData(code, msg);
            }
            List<MCHZGL004BizDetail> detList = mc.getDetailList();
            if (null == detList || detList.isEmpty()) {
                return new MCResponseData(MessageEnum.Failue_105.getCode(), MessageEnum.Failue_105.getMsg());
            }
            for (MCHZGL004BizDetail d : detList) {
                if (d.getBizEmployee() == null || "".equals(d.getBizEmployee())) {
                    return new MCResponseData(MessageEnum.Failue_105.getCode(), MessageEnum.Failue_105.getMsg());
                }
                if (d.getBizDate() == null || "".equals(d.getBizDate())) {
                    return new MCResponseData(MessageEnum.Failue_105.getCode(), MessageEnum.Failue_105.getMsg());
                }
            }
            return new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            log4j.error(e.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

}
