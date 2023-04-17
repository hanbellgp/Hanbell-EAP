/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.FormInstance;
import cn.hanbell.oa.entity.HKGL037;
import cn.hanbell.oa.entity.HKGL055;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HKGL037DetailModel;
import cn.hanbell.oa.model.HKGL037Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKGL037Bean extends SuperEJBForEFGP<HKGL037> {

    @EJB
    private HKGL055Bean hkgl005Bean;
    @EJB
    private WorkFlowBean workFlowBean;

    public HKGL037Bean() {
        super(HKGL037.class);
    }

    /**
     * 返台申请单结案自动申请派公务车
     *
     * @param psn
     * @return
     */
    public Boolean initByHKGL055(String psn) {
        HKGL037Model m;
        HKGL037DetailModel d;
        List<HKGL037DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);

        String attachment = null;
        try {
            HKGL055 aa = hkgl005Bean.findByPSN(psn);
            if (aa == null) {
                return false;
            }
            //判断是否已抛转
            if (aa.getHkgl037() != null && !"".equals(aa.getHkgl037())) {
                return true;
            }
            workFlowBean.initUserInfo(aa.getRestEmployee());
            Users currentUser = workFlowBean.getCurrentUser();
            m = new HKGL037Model();
            m.setSqrq(BaseLib.getDate());
            m.setEmply(aa.getRestEmployee());
            m.setDept(aa.getRestDept());
            m.setLxfs(aa.getContact());
            m.setClxz("1");
            m.setCpno("");
            m.setYcyy("11");  //接送台干
            m.setBzsm(aa.getCause());
            m.setAccommodation("2");
            m.setAccommRegistration("2");
            m.setMKsystem("N");
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
            //明细插入一条数据
            d = new HKGL037DetailModel();
            d.setSeq("1");
            d.setGhuser_txt(aa.getRestEmployee());
            d.setGhuser_lbl(currentUser.getUserName());
            d.setBmdept_txt(currentUser.getDeptno());
            d.setBmdept_lbl(currentUser.getDeptname());
            d.setContact(aa.getContact());
            d.setKr("");
            d.setKrlxfs("");
            d.setYcrq_txt(BaseLib.formatDate("yyyy/MM/dd HH:mm", aa.getUsecarDate()));
            d.setCfsf("上海市");
            d.setCfcs(aa.getDepartureCity());
            d.setAddress1(aa.getDepartureCity());
            d.setMdsf("上海市");
            d.setMdcs(aa.getDestination());
            d.setAddress2(aa.getDestination());
            d.setSy(aa.getCause());
            d.setGsmc("");
            detailList.add(d);
            String formInstance = workFlowBean.buildXmlForEFGP("HK_GL037", m, details);
//            if (attachment != null) {
//                formInstance = formInstance.replaceFirst("<HK_GL037>", "<HK_GL037>" + attachment);
//            }
//
            String subject = "返台派车申请_" + aa.getProcessSerialNumber();
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL037", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2 && rm[0].equals("200")) {
                //更新资产申请单状态
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, rm[0]);
                aa.setHkgl037(rm[1]);
                hkgl005Bean.update(aa);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
