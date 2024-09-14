/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import cn.hanbell.eap.comm.ErrorMailNotify;
import cn.hanbell.eap.ejb.ErrorMailNotificationBean;
import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.ejb.VHTV005Bean;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.oa.entity.VHTV005;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Apmapd;
import vn.hanbell.erp.entity.Apmaph;
import vn.hanbell.erp.entity.Apmbil;
import vn.hanbell.erp.entity.ApmbilPK;
import vn.hanbell.erp.entity.Apmtbil;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ApmbilBean extends SuperEJBForERP<Apmbil> {

    @EJB
    private VHTV005Bean vhtv005Bean;
    @EJB
    private ApmaphBean vhbapmaphBean;
    @EJB
    private ApmapdBean vhbapmapdBean;
    @EJB
    private ApmtbilBean vhbapmtbilBean;
    @EJB
    private ProcessCheckBean processCheckBean;

    public ApmbilBean() {
        super(Apmbil.class);
    }

    public Apmbil findByPK(String facno, String bilno) {
        Query query = this.getEntityManager().createNamedQuery("Apmbil.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("bilno", bilno);
        try {
            return (Apmbil) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    //OA--VHBERP/APM820抛转
    public Boolean initByOAAPM820(String psn) {
        try {
            VHTV005 oah = vhtv005Bean.findByPSN(psn);
            if (oah == null) {
                throw new NullPointerException();
            }
            Apmbil a;
            ApmbilPK apk;
            String apno;
            String facno;
            String aptyp;
            Character ls_biltyp;
            Character ls_bilnum;
            String ls_bilno;
            BigDecimal ldc_acpamtfs, ldc_acpamt;
            BigDecimal ldc_apmamtfs, ldc_apmamt;
            BigDecimal ldc_biltaxfs, ldc_biltax;
            BigDecimal ldc_preamtfs, ldc_preamt;
            BigDecimal ldc_temamtfs, ldc_temamt;
            BigDecimal ldc_losamtfs, ldc_losamt;
            BigDecimal ldc_bilamtfs, ldc_bilamt;

            facno = oah.getFacno();
            apno = oah.getApno();
            aptyp = "0";
            this.setCompany(facno);
            vhbapmaphBean.setCompany(facno);
            vhbapmtbilBean.setCompany(facno);
            vhbapmapdBean.setCompany(facno);
            Apmaph aph = vhbapmaphBean.findByPK(facno, apno, aptyp);
            if (aph == null || !aph.getApsta().equals("25")) {
                throw new NullPointerException(apno);
            }
            List<Apmapd> apdList = vhbapmaphBean.findApmapd(facno, apno);
            if (apdList == null || apdList.isEmpty()) {
                throw new NullPointerException(apno);
            }
            List<String> bilList = new ArrayList<>();
            for (Apmapd apd : apdList) {
                ls_bilno = apd.getBilno();
                if (!bilList.contains(ls_bilno)) {
                    if (null != this.findByPK(facno, ls_bilno)) {
                        throw new RuntimeException("发票主档中已有相同的资料,无法更新资料库!");
                    }
                    Apmtbil atb = vhbapmtbilBean.findByPK(facno, ls_bilno);
                    if (null == atb) {
                        throw new RuntimeException("找不到可对应的发票暂存档: " + ls_bilno);
                    }
                    String ls_trtype = vhbapmapdBean.getTrtypeByBilno(facno, apno, aptyp, ls_bilno);
                    ls_bilnum = atb.getBilnum();
                    ldc_biltaxfs = atb.getBiltaxfs();
                    ldc_biltax = atb.getBiltax();
                    ldc_preamtfs = atb.getPreamtfs();
                    ldc_preamt = atb.getPreamt();
                    ldc_temamtfs = atb.getTemamtfs();
                    ldc_temamt = atb.getTemamt();
                    ldc_losamtfs = atb.getLosamtfs();
                    ldc_losamt = atb.getLosamt();
                    ldc_bilamtfs = atb.getBilamtfs();
                    ldc_bilamt = atb.getBilamt();
                    if ('8' == ls_bilnum) {   //海关代徵
                        ldc_apmamtfs = ldc_biltaxfs.subtract(ldc_preamtfs).subtract(ldc_temamtfs);
                        ldc_apmamt = ldc_biltax.subtract(ldc_preamt).subtract(ldc_temamt);
                        ldc_acpamtfs = ldc_biltaxfs.add(ldc_preamtfs).add(ldc_losamtfs);
                        ldc_acpamt = ldc_biltax.add(ldc_preamt).add(ldc_losamt);
                    } else {
                        ldc_apmamtfs = ldc_bilamtfs.subtract(ldc_temamtfs).add(ldc_biltaxfs);
                        ldc_apmamt = ldc_bilamt.subtract(ldc_temamt).add(ldc_biltax);
                        ldc_acpamtfs = ldc_bilamtfs.add(ldc_preamtfs).add(ldc_losamtfs);
                        ldc_acpamt = ldc_bilamt.add(ldc_preamt).add(ldc_losamt);
                    }
                    if ('1' == ls_bilnum) {
                        ls_biltyp = '5';//收据
                    } else {
                        ls_biltyp = '2'; //费用预付类
                    }
                    a = new Apmbil();
                    apk = new ApmbilPK();
                    apk.setFacno(facno);
                    apk.setBilno(ls_bilno);
                    a.setApmbilPK(apk);
                    a.setBilstat("0");
                    a.setBilym(atb.getBilym());
                    a.setBilnum(atb.getBilnum().toString());
                    a.setTaxkd(atb.getTaxkd());
                    a.setApmdat(aph.getApdate());
                    a.setBildat(atb.getBildat());
                    a.setIvovdr(atb.getVdrno());
                    a.setVdrno(aph.getVdrno());
                    a.setVdrna(atb.getVdrna());
                    //发票形式
                    a.setBiltyp(ls_biltyp);
                    a.setBilkid(atb.getBilkid());
                    a.setUsrno(atb.getUsrno());
                    a.setDepno(atb.getDepno());
                    a.setOgdkid(ls_trtype);
                    a.setBilorg(atb.getBilorg());
                    a.setBilamt(atb.getBilamt());
                    a.setBiltax(atb.getBiltax());
                    a.setAcpamt(ldc_acpamt);
                    a.setPreamt(atb.getPreamt());
                    a.setApmamt(ldc_apmamt);
                    a.setBilamtfs(atb.getBilamtfs());
                    a.setBiltaxfs(ldc_biltaxfs);
                    a.setAcpamtfs(ldc_acpamtfs);
                    a.setPreamtfs(atb.getPreamtfs());
                    a.setApmamtfs(ldc_apmamtfs);
                    a.setCoin(atb.getCoin());
                    a.setRatio(atb.getRatio());
                    a.setPayda(aph.getPayda());
                    a.setTerda(aph.getTerda());
                    a.setExpamtfs(atb.getExpamtfs());
                    a.setExpamt(atb.getExpamt());
                    //原（进）料益估金额（L）
                    a.setExtamtfs(atb.getExtamtfs());
                    a.setExtamt(atb.getExtamt());
                    //暂估应付款立账金额（S）
                    a.setYeamtfs(BigDecimal.ZERO);
                    a.setYeamt(BigDecimal.ZERO);
                    //初稿传票编号
                    a.setVouno("");
                    //发票摘要
                    a.setSumry("");
                    a.setTaxfacno(facno);
                    a.setLosamtfs(atb.getLosamtfs());
                    a.setLosamt(atb.getLosamt());
                    a.setTemamtfs(atb.getTemamtfs());
                    a.setTemamt(atb.getTemamt());
                    a.setFixyn(atb.getFixyn().toString());
                    a.setPayptn(aph.getPaytn());
                    a.setFixtyn("N");
                    a.setUniform(atb.getUniform());
                    a.setVdrna(atb.getVdrna());
                    a.setTaxrate(atb.getTaxrate());
                    a.setTaxbase(atb.getTaxbase());
                    a.setBilcategory(atb.getBilcategory());
                    a.setOpbankna(atb.getOpbankna());
                    a.setOpbankno(atb.getOpbankno());
                    a.setOpbanknum(atb.getOpbanknum());
                    persist(a);
                    atb.setBilstat('2');
                    vhbapmtbilBean.setCompany(facno);
                    vhbapmtbilBean.update(atb);
                }
                bilList.add(ls_bilno);
            }

            //抛转单号为OA表单代号
            aph.setOano(oah.getFormSerialNumber());
            aph.setApsta("30");
            // 更新apusrno,cfmusrno为OA审核人
            aph.setOano(oah.getProcessSerialNumber().substring(4));
            List<ProcessCheck> processList;
            processList = processCheckBean.findByPSN(psn);
            for (ProcessCheck pc : processList) {
                if (pc.getWorkItemName().contains("直属主管") || pc.getWorkItemName().contains("课长")) {
                    aph.setApusrno(pc.getUserID());
                }
                if (pc.getWorkItemName().contains("经理级") && !pc.getWorkItemName().contains("总经理级")) {
                    aph.setCfmusrno(pc.getUserID());
                }
            }
            vhbapmaphBean.update(aph);
            return true;
        } catch (Exception ex) {
            //加入邮件通知
            ErrorMailNotificationBean mailBean = new ErrorMailNotificationBean();
            mailBean.getTo().clear();
            mailBean.getTo().add("13120@hanbell.com.cn");
            mailBean.setMailSubject("OA--越南费用请款单抛转ERP失败");
            mailBean.setMailContent(
                    "OA--越南费用请款单单号：" + psn + "抛转失败，异常：" + ex);
            mailBean.notify(new ErrorMailNotify());
            ex.printStackTrace();
            log4j.error(ex);
            throw new RuntimeException(ex);
        }
    }

}
