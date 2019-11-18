/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.app.REPPWApplication;
import cn.hanbell.crm.app.REPTAApplication;
import cn.hanbell.crm.ejb.REPPWBean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.entity.REPPW;
import cn.hanbell.crm.entity.REPPWPK;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
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
 * @author Administrator
 */
@Path("crm/reppw")
@javax.enterprise.context.RequestScoped
public class REPPWFacadeREST extends SuperRESTForCRM<REPPW> {

    @EJB
    private REPPWBean reppwBean;
    @EJB
    private REPTABean reptaBean;

    public REPPWFacadeREST() {
        super(REPPW.class);
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(REPTAApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null || entity.getDetailList() == null || entity.getDetailList().isEmpty()) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            List<REPPW> reppwList = new ArrayList<>();
            String pw026 = "";
            try {
                for (REPPWApplication ad : entity.getDetailList()) {
                    if (null != ad.getRepairmanname2() && !"".equals(ad.getRepairmanname2())) {
                        String[] repmen = ad.getRepairmanname2().split(";");
                        for (int i = 1; i <= repmen.length; i++) {
                            REPPW m = new REPPW();
                            REPPWPK mk = new REPPWPK();
                            m.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                            m.setCreator(ad.getEmployeeId());
                            m.setUsrGroup(ad.getDeptId());
                            mk.setPw001(entity.getRepairKindname().split("-")[0]);
                            mk.setPw002(entity.getRepairno());
                            String pw004 = repmen[i - 1];
                            if ("".equals(pw004)) {
                                continue;
                            }
                            m.setPw004(pw004.split("-")[0]);
                            mk.setPw003(("0000" + i).substring(String.valueOf(i).length()));
                            m.setREPPWPK(mk);
                            if (pw004.equals(ad.getRepairmanname())) {
                                m.setPw019("Y");
                                pw026 = mk.getPw003();
                            } else {
                                m.setPw019("N");
                            }
                            if (!"".equals(ad.getStationname())) {
                                m.setPw005(ad.getStationname().split("-")[0]);
                            }
                            if (ad.getDate3() != null && !"".equals(ad.getDate3())) {
                                String date3 = ad.getDate3().substring(0, 4) + ad.getDate3().substring(5, 7) + ad.getDate3().substring(8, 10);
                                m.setPw006(BaseLib.formatString("yyyyMMdd", date3));
                            }
                            if (ad.getDate4() != null && !"".equals(ad.getDate4())) {
                                String date4 = ad.getDate4().substring(0, 4) + ad.getDate4().substring(5, 7) + ad.getDate4().substring(8, 10);
                                m.setPw007(BaseLib.formatString("yyyyMMdd", date4));
                            }
                            m.setPw010("0");    //派工状态码
                            m.setPw011(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                            m.setPw012(m.getCreator());
                            m.setPw021("0000");
                            m.setPw022("0000");
                            reppwList.add(m);
                        }
                    } else {
                        return new ResponseMessage("400", "请维护维修人员");
                    }
                }

                REPTA ra = reptaBean.findByPK(entity.getRepairKindname().split("-")[0], entity.getRepairno());
                for (REPPW reppw : reppwList) {
                    reppw.setPw026(pw026);
                    reppwBean.persist(reppw);
                }
                //更新叫修单状态为确认
                if (ra != null) {
                    ra.setTa035("1");  //派工码显示转维修站
                    ra.setTa014("Y");
                    ra.setTa015(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                    ra.setTa016(entity.getDetailList().get(0).getEmployeeId());
                    ra.setTa030("Y");
                    reptaBean.update(ra);
                }
                return new ResponseMessage("200", "更新派工资料成功！");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
