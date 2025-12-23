/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

//import cn.hanbell.crm.ejb.CMSMEBean;
import cn.hanbell.oa.app.OvertimeApplication;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.MCHKGL034;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKGL034Bean;
import cn.hanbell.oa.entity.HKGL034;
import cn.hanbell.oa.model.HKGL034DetailModel;
import cn.hanbell.oa.model.HKGL034Model;
import cn.hanbell.oa.app.OvertimeApplicationDetail;
import cn.hanbell.oa.entity.OrganizationUnit;
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
@Path("efgp/hkgl034")
@javax.enterprise.context.RequestScoped
public class HKGL034FacadeREST extends SuperRESTForEFGP<HKGL034> {

    @EJB
    private HKGL034Bean hkgl034Bean;

    @EJB
    private Agent1000002Bean agent1000002Bean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hkgl034Bean;
    }

    public HKGL034FacadeREST() {
        super(HKGL034.class);
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(OvertimeApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null || entity.getDetailList() == null || entity.getDetailList().isEmpty()) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            HKGL034Model m;
            HKGL034DetailModel d;
            List<HKGL034DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);
            try {
                workFlowBean.initUserInfo(entity.getEmployee());
                m = new HKGL034Model();
                m.setApplyDate(BaseLib.getDate());
                m.setApplyUser(workFlowBean.getCurrentUser().getId());
                m.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
                m.setApplyDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
                m.setHdn_applyDept(workFlowBean.getUserFunction().getOrganizationUnit().getOrganizationUnitName());
                m.setType(entity.getFormType());
                m.setHdn_type(entity.getFormTypeDesc());
                m.setIsWechat("Y");
                //根据部门设置公司
                m.setFacno(workFlowBean.getCompanyByDeptId(m.getApplyDept()));
                m.setHdn_facno(m.getFacno());
                m.setOverdue(entity.getOverdue());
                for (OvertimeApplicationDetail oad : entity.getDetailList()) {
                    //前一天凌晨
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(BaseLib.getDate());
                    if ("Y".equals(entity.getOverdue())) {
                        calendar.add(Calendar.DATE, -7);
                    } else {
                        calendar.add(Calendar.DATE, -2);
                    }

                    Date zero = calendar.getTime();
                    Date date1 = BaseLib.getDate("yyyy-MM-dd", oad.getDate1());
                    if (zero.getTime() >= date1.getTime()) {
                        return new ResponseMessage("500", "填单日期晚于实际加班日期不可以申请！");
                    }

                    d = new HKGL034DetailModel();
                    d.setSeq(oad.getSeq());
//                    d.setDept_txt(workFlowBean.getUserFunction().getOrganizationUnit().getId());
//                    d.setDept_lbl(workFlowBean.getUserFunction().getOrganizationUnit().getOrganizationUnitName());
//                    d.setEmployee(workFlowBean.getCurrentUser().getId());
//                    d.setEmployeeName(workFlowBean.getCurrentUser().getUserName());
                    d.setDept_txt(oad.getDeptName().split("-")[1]);
                    d.setDept_lbl(oad.getDeptId());
                    d.setEmployee(oad.getEmployeeId());
                    d.setEmployeeName(oad.getEmployeeName().split("-")[1]);
                    Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                    Matcher matcher = p.matcher(oad.getContent());
                    String finishedReplaceStr = matcher.replaceAll("");
                    d.setContent(finishedReplaceStr);
                    d.setDate1_txt(oad.getDate1());
                    d.setTime1_txt(oad.getTime1());
                    d.setTime2_txt(oad.getTime2());
                    d.setHour(oad.getHour());
                    if (oad.getLunch()) {
                        d.setHdn_lunch("用餐");
                    } else {
                        d.setHdn_lunch("不用餐");
                    }
                    if (oad.getDinner()) {
                        d.setHdn_dinner("用餐");
                    } else {
                        d.setHdn_dinner("不用餐");
                    }
                    detailList.add(d);
                }
                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL034", m, details);
                String subject = entity.getEmployee() + "加班申请";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL034", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    boolean isSuccess = true;
                    StringBuffer users = new StringBuffer();
                    for (OvertimeApplicationDetail oad : entity.getDetailList()) {
                        agent1000002Bean.initConfiguration();
                        String errmsg = agent1000002Bean.sendMsgToUser(oad.getEmployeeId(), "text", "[汉钟精机] 您申请的" + oad.getDate1() + "加班单已完成填单");
                        if ("ok".equals(errmsg)) {
                            isSuccess = false;
                            users.append(oad.getEmployeeName()).append(",");
                        }
                    }
//                    if (isSuccess) {
//                        return new ResponseMessage("500", "表单发起成功，" + users + "消息发送失败");
//                    }

                    return new ResponseMessage(rm[0], rm[1]);

                } else {
                    return new ResponseMessage("500", "提交失败");
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
    public ResponseMessage create(MCHKGL034 entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null || entity.getBody() == null || entity.getBody().isEmpty()) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            HKGL034Model m;
            HKGL034DetailModel d;
            List<HKGL034DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);
            try {
                //初始化发起人
                workFlowBean.initUserInfo(entity.getHead().getId());
                //实例化对象
                m = new HKGL034Model();
                m.setApplyDate(BaseLib.getDate());
                m.setApplyUser(workFlowBean.getCurrentUser().getId());
                m.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
                OrganizationUnit ou = workFlowBean.findOrgUnitByDeptno(entity.getHead().getDeptno());
                if (ou == null) {
                    throw new NullPointerException(entity.getHead().getDeptno() + "不存在");
                }
                m.setApplyDept(ou.getId());
                m.setHdn_applyDept(ou.getOrganizationUnitName());
                m.setType(entity.getHead().getFormType());
                m.setHdn_type(entity.getHead().getFormTypeDesc());
                //根据部门设置公司
                m.setFacno(entity.getHead().getCompany());
                m.setHdn_facno(m.getFacno());
                int seq = 0;
                for (cn.hanbell.oa.app.MCHKGL034Detail oad : entity.getBody()) {
                    seq++;
                    d = new HKGL034DetailModel();
                    d.setSeq(String.valueOf(seq));
                    d.setDept_txt(oad.getDeptName().split("-")[1]);
                    d.setDept_lbl(oad.getDeptId());
                    d.setEmployee(oad.getEmployeeId());
                    d.setEmployeeName(oad.getEmployeeName().split("-")[1]);
                    d.setContent(oad.getNote());
                    d.setDate1_txt(oad.getDate());
                    d.setTime1_txt(oad.getStarttime());
                    d.setTime2_txt(oad.getEndtime());
                    d.setHour(oad.getWorktime());
                    if (oad.getLunch().equals("Y")) {
                        d.setHdn_lunch("用餐");
                    } else {
                        d.setHdn_lunch("不用餐");
                    }
                    if (oad.getDinner().equals("Y")) {
                        d.setHdn_dinner("用餐");
                    } else {
                        d.setHdn_dinner("不用餐");
                    }
                    detailList.add(d);
                }
                //发起流程
                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL034", m, details);
                String subject = workFlowBean.getCurrentUser().getUserName() + "加班申请";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL034", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    return new ResponseMessage(rm[0], rm[1]);
                } else {
                    return new ResponseMessage("200", "Code=200");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
