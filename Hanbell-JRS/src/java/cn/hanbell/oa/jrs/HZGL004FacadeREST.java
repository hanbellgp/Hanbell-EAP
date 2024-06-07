/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.MCHZGL004;
import cn.hanbell.oa.app.MCHZGL004BizDetail;
import cn.hanbell.oa.app.MCHZGL004CarDetail;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HZGL004Bean;
import cn.hanbell.oa.entity.HZGL004;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.model.HZGL004BizDetailModel;
import cn.hanbell.oa.model.HZGL004CarDetailModel;
import cn.hanbell.oa.model.HZGL004Model;
import cn.hanbell.util.BaseLib;
import cn.hanbell.wco.ejb.Agent1000002Bean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
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

/**
 *
 * @author C0160
 */
@Path("efgp/hzgl004")
@javax.enterprise.context.RequestScoped
public class HZGL004FacadeREST extends SuperRESTForEFGP<HZGL004> {

    @EJB
    private HZGL004Bean hzgl004Bean;

    @EJB
    private Agent1000002Bean agent1000002Bean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hzgl004Bean;
    }

    public HZGL004FacadeREST() {
        super(HZGL004.class);
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createByWeChat(MCHZGL004 entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (entity == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        HZGL004Model m;
        HZGL004BizDetailModel d;
        HZGL004CarDetailModel cd;
        List<HZGL004BizDetailModel> detailList = new ArrayList<>();
        List<HZGL004CarDetailModel> cardetailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("bizDetail", detailList);
        details.put("carDetail", cardetailList);
        try {
            //初始化发起人
            workFlowBean.initUserInfo(entity.getApplyUser());
            //实例化对象
            m = new HZGL004Model();
            m.setFacno(entity.getCompany().split("-")[0]);
            m.setApplyDate(BaseLib.getDate());
            m.setApplyUser(workFlowBean.getCurrentUser().getId());
            m.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
            m.setSrcno("WX");
            OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getApplyDept());
            if (ou == null) {
                throw new NullPointerException(entity.getApplyDept() + "不存在");
            }
            m.setApplyDept(ou.getId());
            m.setHdn_applyDept(ou.getOrganizationUnitName());
            m.setFormType(entity.getFormType());
            m.setCountry(entity.getCountry());
            if (entity.getSafeplace()) {
                m.setSafeplace("Y");
            } else {
                m.setSafeplace("N");
            }
            if ("5".equals(entity.getFormType())) {
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
            m.setIsWechat("Y");
            m.setDestination(entity.getDestination());
            m.setHdn_destination(entity.getDestinationDesc());
            m.setDay1(BaseLib.getDate("yyyy-MM-dd", entity.getStartDate()));
            m.setDay2(BaseLib.getDate("yyyy-MM-dd", entity.getEndDate()));
            m.setDays(entity.getDays());
            m.setUserTitle(workFlowBean.getUserTitle().getTitleDefinition().getTitleDefinitionName());
            m.setHdn_employee(workFlowBean.getCurrentUser().getId());
            m.setHdn_days(m.getDays());

            int seq = 0;
            //派车
            m.setUseCar(entity.getUseCar());
            if (m.getUseCar().equals("Y")) {
                m.setEmployee(entity.getPrivatedriverno());
                m.setClxz(entity.getClxz());
                m.setCpno(entity.getPrivatecarno());
                m.setYcyy(entity.getPurpose());
                m.setAccommodation(entity.getStaykey());
                m.setDeparture(entity.getDeparturekey());
                m.setAccommRegistration(entity.getRegistrationkey());
                m.setLxfs(entity.getTelcontact());
                m.setBzsm(entity.getHmark1());
                for (MCHZGL004CarDetail mcd : entity.getCardetailList()) {
                    seq++;
                    cd = new HZGL004CarDetailModel();
                    cd.setSeq(String.valueOf(seq));
                    cd.setGhuser_txt(mcd.getEmployeeId());
                    cd.setGhuser_lbl(mcd.getEmployeeName());
                    cd.setBmdept_txt(mcd.getDeptId());
                    cd.setBmdept_lbl(mcd.getDeptName());
                    cd.setKr(mcd.getKr());
                    cd.setKrlxfs(mcd.getContact());
                    cd.setYcrq_txt(mcd.getYcrq());
                    cd.setCfsf(mcd.getCfsf());
                    cd.setCfcs(mcd.getCfcs());
                    cd.setAddress1(mcd.getAddress1());
                    cd.setMdsf(mcd.getMdsf());
                    cd.setMdcs(mcd.getMdcs());
                    cd.setAddress2(mcd.getAddress2());
                    cd.setSy(mcd.getSy());
                    cd.setGsmc(mcd.getCompany());
                    cardetailList.add(cd);
                }
            }

            seq = 0;
            for (MCHZGL004BizDetail mcd : entity.getDetailList()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 59);
                calendar.add(calendar.MINUTE, -1);
                Date zero = calendar.getTime();
                Date date1 = BaseLib.getDate("yyyy-MM-dd", mcd.getBizDate());
                if (zero.getTime() >= date1.getTime()) {
                    return new ResponseMessage("500", "填单日期晚于实际出差日期不可以申请！");
                }
                if (date1.getTime() < m.getDay1().getTime() || date1.getTime() > m.getDay2().getTime()) {
                    return new ResponseMessage("500", "出差日期不在出差起止日期内！");
                }
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
                boolean isSuccess = true;
                StringBuffer users = new StringBuffer();
                for (MCHZGL004BizDetail mcd : entity.getDetailList()) {
                    agent1000002Bean.initConfiguration();
                    String errmsg = agent1000002Bean.sendMsgToUser(mcd.getBizEmployee(), "text", "[汉钟精机] 您申请的" + mcd.getBizDate() + "出差单已完成填单");
                    if ("ok".equals(errmsg)) {
                        isSuccess = false;
                        users.append(mcd.getBizEmployeeName()).append(",");
                    }
                }
                return new ResponseMessage(rm[0], rm[1]);
            } else {
                return new ResponseMessage("200", "Code=200");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseMessage("500", "资料填写有误，核对后请联系管理员");
        }
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
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HZ_GL004", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2) {
                boolean isSuccess = true;
                StringBuffer users = new StringBuffer();
                for (MCHZGL004BizDetail mcd : entity.getDetailList()) {
                    agent1000002Bean.initConfiguration();
                    String errmsg = agent1000002Bean.sendMsgToUser(mcd.getBizEmployee(), "text", "[汉钟精机] 您申请的" + mcd.getBizDate() + "出差单已完成填单");
                    if ("ok".equals(errmsg)) {
                        isSuccess = false;
                        users.append(mcd.getBizEmployeeName()).append(",");
                    }
                }
                if (isSuccess) {
                    return new ResponseMessage("500", "表单发起成功，" + users + "消息发送失败");
                }
                return new ResponseMessage(rm[0], rm[1]);
            } else {
                return new ResponseMessage("200", "Code=200");
            }
        } catch (Exception ex) {
            return new ResponseMessage("500", "系统错误更新失败");
        }
    }

}
