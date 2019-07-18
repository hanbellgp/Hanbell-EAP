/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.FormInstance;
import cn.hanbell.oa.entity.HKCG007;
import cn.hanbell.oa.entity.HKCW002;
import cn.hanbell.oa.entity.HKCW002Detail;
import cn.hanbell.oa.entity.HKCW002P;
import cn.hanbell.oa.entity.HKCW002PpurDetail;
import cn.hanbell.oa.model.HKCG007DetailModel;
import cn.hanbell.oa.model.HKCG007Model;
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
 * @author C1491
 */
@Stateless
@LocalBean
public class HKCG007Bean extends SuperEJBForEFGP<HKCG007> {

    @EJB
    private FormInstanceBean formInstanceBean;
    @EJB
    private WorkFlowBean workFlowBean;
    @EJB
    private HKCW002PBean hkcw002pBean;
    @EJB
    private HKCW002PpurDetailBean hkcw002ppurdetalBean;
    @EJB
    private HKCW002Bean hkcw002Bean;

    public HKCG007Bean() {
        super(HKCG007.class);
    }

    public Boolean initByHKCW002P(String psn) {
        try {
            HKCG007Model m;
            HKCG007DetailModel d;
            List<HKCG007DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("purDetail", detailList);

            List<HKCW002PpurDetail> purDetailList;
            HKCW002P pm = hkcw002pBean.findByPSN(psn);

            //判断是否已抛转
            if (pm.getIfturn() != null && !"".equals(pm.getIfturn())) {
                return false;
            }
            purDetailList = hkcw002ppurdetalBean.findByFSN(pm.getFormSerialNumber());
            if (purDetailList != null && !purDetailList.isEmpty()) {
                detailList.clear();//清除前面的资料
                int i = 0;
                for (HKCW002PpurDetail pd : purDetailList) {
                    i++;
                    if (pd.getQgnum() != null && !pd.getQgnum().isEmpty()) {
                        d = new HKCG007DetailModel();
                        d.setSeq(String.valueOf(i));
                        d.setItnbr(pd.getPncode());
                        d.setItdsc(pd.getPnname());
                        d.setSpdsc(pd.getSpdse());
                        d.setRqtdateTxt(pd.getDatetime1Txt());
                        d.setEmgyn(pd.getSfjj());
                        d.setPrqy1(pd.getApplynum());
                        d.setAppunit(pd.getApplyunit());
                        d.setApamts(pd.getApamts());
                        d.setBudgetacc(pd.getBudgetacc());
                        d.setBudgetaccname(pd.getBudgetaccname());
                        d.setDmark1(pd.getDmark1());
                        d.setDmark1name(pd.getDmark1name());
                        d.setDmark2(pd.getDmark2());
                        d.setDmark2name(pd.getDmark2name());
                        d.setPurdaskdescs("");
                        d.setAccPeriod(pd.getSubperbal());
                        d.setAccYear(pd.getSubyearbal());
                        d.setVdrno("");
                        d.setBuyer("");
                        d.setUnpris("");
                        d.setAskdateTxt("");
                        d.setTax("4");
                        d.setTaxrate("0.17");
                        d.setPosrccode("");
                        d.setAddcode(pd.getAddcode());
                        d.setVdrna("");
                        d.setBuyername("");
                        d.setCtotamts("0.00");
                        d.setCtramts("0.00");
                        d.setCtaxamts("0.00");
                        d.setQtotamts("0.00");
                        detailList.add(d);
                    }

                }
                if (detailList.size() > 0) {
                    //先用需求人员初始化，获得部门主管cfmuserno
                    workFlowBean.initUserInfo(pm.getUserman());
                    m = new HKCG007Model();
                    m.setFacno(pm.getFacno());
                    m.setProno("1");
                    m.setCreator(pm.getApplyUser());
                    m.setAppuser(pm.getUserman());
                    m.setDepno(pm.getUsingDept());
                    m.setCenterid(pm.getBudgetdept());
                    m.setAppDate(BaseLib.getDate());
                    m.setPrkind(pm.getPrkind());
                    m.setHmark1(pm.getHmark1());
                    m.setCurrency(pm.getCurrency());
                    m.setRate(pm.getRate());
                    m.setQtotaly(pm.getQtotaly());
                    m.setQtotalyRMB(pm.getQtotalrmb());
                    m.setFormid(psn);

                    m.setMastbuyer("");
                    m.setMastbuyername("");
                    m.setCtotaly(0.00);
                    m.setCtotalyRMB(0.00);
                    m.setIstechnique("N");
                    m.setDeptPeriod(pm.getDeptperbal());
                    m.setDeptYear(pm.getDeptyearbal());

                    m.setIsNine(pm.getProtype());
                    m.setYfPrice("N");
                    m.setBudgetcode(workFlowBean.getOrganizationUnit().getId());
                    m.setCfmuserno(workFlowBean.getOrganizationUnit().getManager().getId());

                    //项目建设效益
                    m.setFormulateDept(pm.getZddw());
                    m.setFormulateUser(pm.getSqr());
                    m.setFormulateDate(pm.getDate65());
                    m.setEquipmentName(pm.getCproname());
                    m.setEquipmentName2(pm.getTextbox56());
                    m.setEquipmentSpec(pm.getGuige());
                    m.setAdviceBrand(pm.getTextbox64());
                    m.setPlanqty(pm.getTextbox63());
                    m.setUsed(pm.getTextbox55());
                    m.setProperty(pm.getProperty());
                    m.setAttribute(pm.getProattr());
                    m.setVendor(pm.getTextbox62());
                    m.setSource(pm.getSource());
                    m.setRemark(pm.getTextArea80());
                    m.setFactor01(pm.getTextbox81());
                    m.setFactor02(pm.getTextbox82());
                    m.setFactor03(pm.getTextbox84());
                    m.setFactor04(pm.getTextbox85());
                    m.setFactor05(pm.getTextbox91());
                    m.setFactor06(pm.getTextbox92());
                    m.setFactor07(pm.getTextbox93());
                    m.setFactor08(pm.getTextbox94());
                    m.setFactor09(pm.getTextbox95());
                    m.setFactor10(pm.getTextbox101());
                    m.setFactor11(pm.getTextbox102());
                    m.setFactor12(pm.getTextbox103());
                    m.setConclusion(pm.getTextbox104());
                    m.setOrigproject1(pm.getTextbox106());
                    m.setOrigqty1(pm.getTextbox111());
                    m.setOrigrate1(pm.getTextbox114());
                    m.setNewrate1(pm.getTextbox116());
                    m.setOrigproject2(pm.getTextbox108());
                    m.setOrigqty2(pm.getTextbox112());
                    m.setOrigrate2(pm.getTextbox3());
                    m.setNewrate2(pm.getTextbox0());
                    m.setNewproject1(pm.getTextbox7());
                    m.setNewqty1(pm.getTextbox10());
                    m.setNewproject2(pm.getTextbox4());
                    m.setNewqty2(pm.getTextbox15());

                    //重新初始化流程发起人员
                    workFlowBean.initUserInfo(pm.getApplyUser());
                    String formInstance = workFlowBean.buildXmlForEFGP("HK_CG007", m, details);
                    String subject = "资产申请单_" + pm.getProcessSerialNumber();
                    String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HK_CG007", formInstance, subject);
                    String[] rm = msg.split("\\$");
                    if (rm.length == 2 && rm[0].equals("200")) {
                        //更新资产申请单状态
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, rm[0]);
                        pm.setIfturn("已抛转请购单");
                        pm.setQgd(rm[1]);
                        hkcw002pBean.update(pm);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean initByHKCW002(String psn) {
        HKCG007Model m;
        HKCG007DetailModel d;
        List<HKCG007DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("purDetail", detailList);

        String attachment = null;
        try {
            List<HKCW002Detail> purDetailList;
            HKCW002 aa = hkcw002Bean.findByPSN(psn);
            if (aa == null) {
                return false;
            }
            //判断是否已抛转
            if ("0".equals(aa.getPurchase()) || !"".equals(aa.getHkcg007())) {
                return true;
            }
            //找到表单实例
            FormInstance fi = formInstanceBean.findByOID(aa.getOid());
            if (fi == null) {
                return false;
            }
            //获取附件信息
            int s = fi.getFieldValues().indexOf("<Attachment id=\"Attachment\">");
            int e = fi.getFieldValues().indexOf("</Attachment>");
            if (s > 0 && e > 0 && e > s) {
                attachment = fi.getFieldValues().substring(s, e + 13);
                attachment = attachment.replaceAll("\r|\n", "");
            }

            hkcw002Bean.setDetail(aa.getFormSerialNumber());
            purDetailList = hkcw002Bean.getDetailList();
            if (purDetailList != null && !purDetailList.isEmpty()) {
                int i = 0;
                for (HKCW002Detail aad : purDetailList) {
                    i++;
                    if (aad.getPurqty() != null && !"".equals(aad.getPurqty()) && !"0".equals(aad.getPurqty())) {
                        d = new HKCG007DetailModel();
                        d.setSeq(String.valueOf(i));
                        d.setItnbr(aad.getItemno());
                        d.setItdsc(aad.getItemdesc());
                        d.setSpdsc(aad.getItemspec());
                        d.setRqtdateTxt(aad.getRqtdateTxt());
                        d.setEmgyn(aad.getEmgyn());
                        d.setPrqy1(aad.getPurqty());
                        d.setAppunit(aad.getUnit());
                        d.setApamts(aad.getPrice());
                        d.setBudgetacc(aad.getBudgetacc());
                        d.setBudgetaccname(aad.getBudgetaccname());
                        d.setAccPeriod(aad.getAccperbal());
                        d.setAccYear(aad.getAccyearbal());
                        d.setDmark1(aad.getDmark1());
                        d.setDmark1name(aad.getDmark1desc());
                        d.setDmark2(aad.getDmark2());
                        d.setDmark2name(aad.getDmark2desc());
                        d.setQtotamts(aad.getAmts());

                        d.setPurdaskdescs("");
                        d.setVdrno("");
                        d.setBuyer("");
                        d.setUnpris("");
                        d.setAskdateTxt("");
                        d.setTax("4");
                        d.setTaxrate("0.17");
                        d.setPosrccode("3");
                        d.setAddcode(aa.getAddcode());
                        d.setVdrna("");
                        d.setBuyername("");
                        d.setCtotamts("0.00");
                        d.setCtramts("0.00");
                        d.setCtaxamts("0.00");
                        d.setQtotamts("0.00");
                        detailList.add(d);
                    }
                }
                if (detailList.size() > 0) {
                    //先用需求人员初始化，获得部门主管cfmuserno
                    workFlowBean.initUserInfo(aa.getRequireUserno());
                    m = new HKCG007Model();
                    m.setFacno(aa.getFacno());
                    m.setProno("1");
                    m.setAppDate(BaseLib.getDate());
                    m.setAppuser(aa.getRequireUserno());
                    m.setDepno(aa.getRequireDeptno());
                    m.setCenterid(aa.getCenterid());
                    m.setCreator(aa.getApplyUserno());
                    m.setPrkind(aa.getPrkind());
                    m.setHmark1(aa.getHmark1());
                    m.setCurrency(aa.getCurrency());
                    m.setRate(aa.getRate());
                    m.setQtotaly(aa.getTotalamts());
                    m.setQtotalyRMB(aa.getTotalamt());
                    m.setFormid(psn);
                    m.setDeptPeriod(aa.getDeptperbal());
                    m.setDeptYear(aa.getDeptyearbal());

                    m.setMastbuyer("");
                    m.setMastbuyername("");
                    m.setCtotaly(0.00);
                    m.setCtotalyRMB(0.00);
                    m.setIstechnique("N");

                    m.setIsNine("0");
                    m.setYfPrice("N");
                    m.setBudgetcode(workFlowBean.getOrganizationUnit().getId());
                    m.setCfmuserno(workFlowBean.getOrganizationUnit().getManager().getId());

                    //项目建设效益
                    m.setFormulateDept(aa.getFormulateDept());
                    m.setFormulateUser(aa.getFormulateUser());
                    m.setFormulateDate(aa.getFormulateDate());
                    m.setEquipmentName(aa.getEquipmentName());
                    m.setEquipmentName2(aa.getEquipmentName2());
                    m.setEquipmentSpec(aa.getEquipmentSpec());
                    m.setAdviceBrand(aa.getAdviceBrand());
                    m.setPlanqty(aa.getPlanqty());
                    m.setUsed(aa.getUsed());
                    m.setProperty(aa.getProperty());
                    m.setAttribute(aa.getAttribute());
                    m.setVendor(aa.getVendor());
                    m.setSource(aa.getSource());
                    m.setRemark(aa.getRemark());
                    m.setFactor01(aa.getFactor01());
                    m.setFactor02(aa.getFactor02());
                    m.setFactor03(aa.getFactor03());
                    m.setFactor04(aa.getFactor04());
                    m.setFactor05(aa.getFactor05());
                    m.setFactor06(aa.getFactor06());
                    m.setFactor07(aa.getFactor07());
                    m.setFactor08(aa.getFactor08());
                    m.setFactor09(aa.getFactor09());
                    m.setFactor10(aa.getFactor10());
                    m.setFactor11(aa.getFactor11());
                    m.setFactor12(aa.getFactor12());
                    m.setConclusion(aa.getConclusion());
                    m.setOrigproject1(aa.getOrigproject1());
                    m.setOrigqty1(aa.getOrigqty1());
                    m.setOrigrate1(aa.getOrigrate1());
                    m.setNewrate1(aa.getNewrate1());
                    m.setOrigproject2(aa.getOrigproject2());
                    m.setOrigqty2(aa.getOrigqty2());
                    m.setOrigrate2(aa.getOrigrate2());
                    m.setNewrate2(aa.getNewrate2());
                    m.setNewproject1(aa.getNewproject1());
                    m.setNewqty1(aa.getNewqty1());
                    m.setNewproject2(aa.getNewproject2());
                    m.setNewqty2(aa.getNewqty2());

                    //重新初始化流程发起人员
                    if (aa.getCreator() != null && !"".equals(aa.getCreator())) {
                        workFlowBean.initUserInfo(aa.getCreator());
                    } else {
                        workFlowBean.initUserInfo(aa.getApplyUserno());
                    }
                    String formInstance = workFlowBean.buildXmlForEFGP("HK_CG007", m, details);
                    //代入资产申请单的附件
                    if (attachment != null) {
                        formInstance = formInstance.replaceFirst("<HK_CG007>", "<HK_CG007>" + attachment);
                    }

                    String subject = "资产申请单_" + aa.getProcessSerialNumber();
                    String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HK_CG007", formInstance, subject);
                    String[] rm = msg.split("\\$");
                    if (rm.length == 2 && rm[0].equals("200")) {
                        //更新资产申请单状态
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, rm[0]);
                        aa.setHkcg007(rm[1]);
                        hkcw002Bean.update(aa);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
