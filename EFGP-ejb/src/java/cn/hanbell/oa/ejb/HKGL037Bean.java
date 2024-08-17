/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL037;
import cn.hanbell.oa.entity.HKGL055;
import cn.hanbell.oa.entity.HZGL004;
import cn.hanbell.oa.entity.HZGL004carDetail;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.model.HKGL037DetailModel;
import cn.hanbell.oa.model.HKGL037Model;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    private HZGL004Bean hzgl004Bean;
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
            d.setMdcs(aa.getDestinationCity());
            d.setAddress2(aa.getDestinationCity());
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
    
    /**
     * 出差申请单结案自动申请派车申请
     *
     * @param psn
     * @return
     */
    public Boolean initByHZGL004(String psn) {
        HKGL037Model m;
        HKGL037DetailModel d;
        List<HKGL037DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);

        String attachment = null;
        try {
            HZGL004 aa = hzgl004Bean.findByPSN(psn);
            if (aa == null) {
                return false;
            }
            //判断是否已抛转
            if (aa.getHkgl037() != null && !"".equals(aa.getHkgl037())) {
                return true;
            }
            String formSerialNumber = aa.getFormSerialNumber();
            List<HZGL004carDetail> carDetail = hzgl004Bean.getCarDetail(formSerialNumber);
            if (null == carDetail || carDetail.size() == 0) {
                return false;
            }
            workFlowBean.initUserInfo(aa.getApplyUser());
            Users currentUser = workFlowBean.getCurrentUser();
            m = new HKGL037Model();
            m.setEmply(aa.getApplyUser());
            m.setSqrq(BaseLib.getDate());
            m.setEmployee(aa.getApplyUser());
            m.setDept(aa.getApplyDept());
            m.setLxfs(aa.getLxfs());
            m.setClxz(aa.getClxz());
            m.setCpno(aa.getCpno());
            m.setYcyy(aa.getYcyy()); 
            m.setBzsm(aa.getBzsm());
            m.setAccommodation(aa.getAccommodation());
            m.setAccommRegistration(aa.getAccommRegistration());
            m.setMKsystem("N");
            m.setYcrq(null);
            m.setJsyuser(aa.getEmployee());
            m.setJsylxfs(aa.getLxfs());
            m.setCph(aa.getCpno());
            m.setRemark("");
            m.setCctime(null);
            m.setHctime(null);
            m.setSgls(0);
            m.setZgls(0);
            m.setTotal(0);
            m.setDeparture(aa.getDeparture());
            m.setHzgl004(psn);
            //hdnDept C/K流程签核栏位，部门主管
            if ("1T100".equals(m.getDept())) {
                m.setHdnDept(m.getDept());
            } else {
                m.setHdnDept(m.getDept().substring(0, 2) + "000");
            }
            //明细插入数据
            int trseq = 0;
            for (HZGL004carDetail car : carDetail) {
                trseq++;
                d = new HKGL037DetailModel();
                d.setSeq(String.valueOf(trseq));
                d.setGhuser_txt(car.getGhuserTxt());
                d.setGhuser_lbl(car.getGhuserLbl());
                d.setBmdept_txt(car.getBmdeptTxt());
                d.setBmdept_lbl(car.getBmdeptLbl());
                d.setContact(aa.getLxfs());
                d.setKr(car.getKr());
                d.setKrlxfs(car.getKrlxfs());
                d.setYcrq_txt(car.getYcrqTxt());
                d.setCfsf(car.getCfsf());
                d.setCfcs(car.getCfcs());
                d.setAddress1(car.getAddress1());
                d.setMdsf(car.getMdsf());
                d.setMdcs(car.getMdcs());
                d.setAddress2(car.getAddress2());
                d.setSy(car.getSy());
                d.setGsmc(car.getGsmc());
                detailList.add(d);
            }
            String formInstance = workFlowBean.buildXmlForEFGP("HK_GL037", m, details);
            if (attachment != null) {
                formInstance = formInstance.replaceFirst("<HK_GL037>", "<HK_GL037>" + attachment);
            }
            String subject = "出差派车申请_" + aa.getProcessSerialNumber();
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL037", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm.length == 2 && rm[0].equals("200")) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, rm[0]);
                aa.setHkgl037(rm[1]);
                hzgl004Bean.update(aa);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
