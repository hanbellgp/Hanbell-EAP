/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.HKGL037Application;
import cn.hanbell.oa.app.HKGL037DetailApplication;
import cn.hanbell.oa.app.KV;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.model.HKGL037DetailModel;
import cn.hanbell.oa.model.HKGL037Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Administrator
 */
@Path("efgp/hkgl037")
@javax.enterprise.context.RequestScoped
public class HKGL037FacadeREST extends SuperRESTForEFGP<KV> {

    public HKGL037FacadeREST() {
        super(KV.class);
    }

    @GET
    @Path("carType")
    @Produces({MediaType.APPLICATION_JSON})
    public List<KV> findClxz(@QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<KV> dataList = new ArrayList<>();
                dataList.add(new KV("1", "公务车"));
                dataList.add(new KV("2", "私车公用"));
                dataList.add(new KV("3", "外叫车"));
                return dataList;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("purpose")
    @Produces({MediaType.APPLICATION_JSON})
    public List<KV> findYcyy(@QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<KV> dataList = new ArrayList<>();
                dataList.add(new KV("1", "上下班"));
                dataList.add(new KV("2", "交际"));
                dataList.add(new KV("3", "加班"));
                dataList.add(new KV("4", "售后服务"));
                dataList.add(new KV("5", "宿舍事务"));
                dataList.add(new KV("6", "拜访厂商"));
                dataList.add(new KV("7", "拜访客户"));
                //dataList.add(new KV("8", "拜访客户"));
                dataList.add(new KV("9", "接送员工"));
                dataList.add(new KV("10", "接送客户"));
                dataList.add(new KV("11", "接送台干"));
                dataList.add(new KV("12", "税务、银行办事"));
                dataList.add(new KV("13", "其他"));
                dataList.add(new KV("14", "培训、会议、参观"));
                return dataList;
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
    public ResponseMessage create(HKGL037Application entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null || entity.getDetailList() == null || entity.getDetailList().isEmpty()) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            HKGL037Model m;
            HKGL037DetailModel d;
            List<HKGL037DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);
            try {
                workFlowBean.initUserInfo(entity.getEmployeeId());
                m = new HKGL037Model();
                m.setSqrq(BaseLib.getDate());
                m.setEmply(workFlowBean.getCurrentUser().getId());
                m.setDept(entity.getDeptId());
                m.setSqrq(BaseLib.getDate("yyyy-MM-dd", entity.getSqrqDate()));
                m.setLxfs(entity.getTelcontact());
                m.setClxz(entity.getClxz());
                if (null != entity.getPrivatedriver() && !"".equals(entity.getPrivatedriver())) {
                    m.setEmployee(entity.getPrivatedriver().split("-")[0]);
                } else {
                    m.setEmployee("");
                }
                m.setCpno(entity.getPrivatecarno());
                m.setYcyy(entity.getPurpose());
                m.setBzsm(entity.getHmark1());
                m.setAccommodation("2");
                m.setAccommRegistration("2");
                m.setDeparture("1");
                m.setYcrq(null);
                m.setJsyuser("");
                m.setJsylxfs("");
                m.setCph("0");
                m.setRemark("");
                m.setCctime(null);
                m.setHctime(null);
                m.setSgls(0);
                m.setZgls(0);
                m.setTotal(0);
                //hdnDept C/K流程签核栏位，部门主管
                if ("1T100".equals(m.getDept())) {
                    m.setHdnDept(m.getDept());
                } else {
                    m.setHdnDept(m.getDept().substring(0, 2) + "000");
                }
                //设置隐藏栏位
                m.setHdn_emply(entity.getEmployeeId() + "-" + entity.getEmployeeName());
                m.setHdn_dept(entity.getDeptName());
                m.setHdn_scgy(entity.getClxzDesc());
                m.setHdadress2(entity.getDetailList().get(0).getAddress2());
                m.setHdycyy(entity.getPurposeDesc());
                for (HKGL037DetailApplication oad : entity.getDetailList()) {
                    d = new HKGL037DetailModel();
                    d.setSeq(oad.getSeq());
                    d.setGhuser_txt(oad.getEmployeeId());
                    d.setGhuser_lbl(oad.getEmployeeName());
                    d.setBmdept_txt(oad.getDeptId());
                    d.setBmdept_lbl(oad.getDeptName().split("-")[1]);
                    d.setContact(oad.getContact());
                    d.setKr(oad.getKr());
                    d.setKrlxfs(oad.getContact());
                    d.setYcrq_txt(oad.getYcrq());
                    d.setCfsf(oad.getCfsf());
                    d.setCfcs(oad.getCfsf());
                    d.setAddress1(oad.getAddress1());
                    d.setMdsf(oad.getMdsf());
                    d.setMdcs(oad.getMdcs());
                    d.setAddress2(oad.getAddress2());
                    d.setSy(oad.getSy());
                    d.setGsmc("");
                    detailList.add(d);
                }
                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL037", m, details);
                String subject = entity.getEmployeeName() + "派车申请";
                String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HK_GL037", formInstance, subject);
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

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
