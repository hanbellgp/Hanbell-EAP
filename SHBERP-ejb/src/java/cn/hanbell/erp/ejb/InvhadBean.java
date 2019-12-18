/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invbal;
import cn.hanbell.erp.entity.Invbat;
import cn.hanbell.erp.entity.Invcls;
import cn.hanbell.erp.entity.Invdou;
import cn.hanbell.erp.entity.Invdta;
import cn.hanbell.erp.entity.InvdtaPK;
import cn.hanbell.erp.entity.Invhad;
import cn.hanbell.erp.entity.InvhadPK;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Invsys;
import cn.hanbell.erp.entity.Invtrn;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.HKFW006Inv310Bean;
import cn.hanbell.oa.ejb.HKFW006Inv310DetailBean;
import cn.hanbell.oa.ejb.HKGC001Bean;
import cn.hanbell.oa.ejb.HKGC003Bean;
import cn.hanbell.oa.ejb.HKPB054Bean;
import cn.hanbell.oa.ejb.SHBERPINV325Bean;
import cn.hanbell.oa.ejb.WARMI05Bean;
import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.oa.entity.HKFW006Inv310;
import cn.hanbell.oa.entity.HKFW006Inv310Detail;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HKGC001Detail;
import cn.hanbell.oa.entity.HKGC003;
import cn.hanbell.oa.entity.HKGC003Detail;
import cn.hanbell.oa.entity.HKPB054;
import cn.hanbell.oa.entity.HKPB054WLDetail;
import cn.hanbell.oa.entity.SHBERPINV325;
import cn.hanbell.oa.entity.SHBERPINV325Detail;
import cn.hanbell.oa.entity.WARMI05;
import cn.hanbell.oa.entity.WARMI05Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class InvhadBean extends SuperEJBForERP<Invhad> {

    //EJBForEFGP
    @EJB
    private HKFW006Bean hkfw006Bean;
    @EJB
    private HKFW006Inv310Bean hkfw006inv310Bean;
    @EJB
    private HKFW006Inv310DetailBean hkfw006inv310DetailBean;
    @EJB
    private HKGC001Bean hkgc001Bean;
    @EJB
    private HKGC003Bean hkgc003Bean;
    @EJB
    private SHBERPINV325Bean shberpinv325Bean;
    @EJB
    private WARMI05Bean warmi05Bean;

    @EJB
    private HKPB054Bean hkpb054Bean;

    //EJBForERP
    @EJB
    private InvclsBean invclsBean;
    @EJB
    private InvdouBean invdouBean;
    @EJB
    private InvsernoBean invsernoBean;
    @EJB
    private InvsysBean invsysBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private InvbalBean invbalBean;
    @EJB
    private InvbatBean invbatBean;
    @EJB
    private InvtrnBean invtrnBean;
    @EJB
    private InvdtaBean invdtaBean;

    public InvhadBean() {
        super(Invhad.class);
    }

    public Boolean initByOAHKFW006(String psn) {
        Date date;
        HKFW006Inv310 h = hkfw006inv310Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        try {
            String facno = h.getFacno();
            String prono = "1";
            String depno = h.getDepno();
            String trtype = h.getTrtype();
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String mon = BaseLib.formatDate("yyyyMM", date);
            invsysBean.setCompany(facno);
            Invsys invsys = invsysBean.findByFacno(facno);
            //如果已月结就改成次月1号
            if (mon.equals(invsys.getLmonth())) {
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                date = c.getTime();
            }
            invsernoBean.setCompany(facno);
            String trno = invsernoBean.getTrno(facno, depno, trtype, date, true);
            Invhad invhad = new Invhad();
            InvhadPK pk = new InvhadPK();
            pk.setFacno(facno);
            pk.setProno(prono);
            pk.setTrno(trno);
            invhad.setInvhadPK(pk);
            invhad.setTrtype(trtype);
            invhad.setTrdate(date);
            invhad.setDepno(depno);
            invhad.setIocode('1');
            invhad.setHmark1(h.getHmark1());
            invhad.setHmark2(h.getHmark2());
            invhad.setResno(h.getResno());
            invhad.setFwno(h.getFwno());
            invhad.setKfno(h.getKfno());
            String srcno = h.getProcessSerialNumber().substring(4);
            invhad.setSourceno(srcno);

            HKFW006 hkfw006 = hkfw006Bean.findByPSN(psn);
            invhad.setUserno(h.getPzuser());
            invhad.setIndate(date);
            //invhad.setCfmuserno(h.getPzuser());
            //invhad.setCfmdate(date);
            invhad.setStatus("N".charAt(0));
            invhad.setPrtcnt((short) 0);
            invhad.setAsrsQty(BigDecimal.ZERO);
            invhad.setVdrno("");
            invhad.setKfspdsc("");
            this.setCompany(facno);
            persist(invhad);

            List<HKFW006Inv310Detail> details = hkfw006inv310DetailBean.findByFSN(h.getFormSerialNumber());
            if (details.size() <= 0) {
                throw new NullPointerException();
            }
            //表身循环
            for (int i = 0; i < details.size(); i++) {
                HKFW006Inv310Detail detail = details.get(i);
                Invdta invdta = new Invdta();
                InvdtaPK invdtaPK = new InvdtaPK();
                invdtaPK.setFacno(facno);
                invdtaPK.setItnbr(detail.getItnbr());
                invdtaPK.setProno("1");
                invdtaPK.setTrno(trno);
                invdtaPK.setTrseq(i + 1);
                invdta.setInvdtaPK(invdtaPK);
                invdta.setTrtype(trtype);
                invmasBean.setCompany(facno);
                Invmas m = invmasBean.findByItnbr(detail.getItnbr());
                invdta.setItcls(m.getItcls());
                invdta.setItclscode(m.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(detail.getNum())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(m.getUnmsr1());
                invdta.setWareh(detail.getWareh());
                invdta.setIocode('1');
                invdta.setVarnr(detail.getVarnr());
                //按ERP逻辑重新设置批号
                switch (m.getInvcls().getNrcode()) {
                    case '0':
                        invdta.setFixnr("");
                        invdta.setVarnr("");
                        break;
                    case '1':
                        invdta.setVarnr("");
                        break;
                    case '2':
                        invdta.setFixnr("");
                        break;
                    default:
                        break;
                }
                invdtaBean.setCompany(facno);
                invdtaBean.persist(invdta);
                invdtaBean.getEntityManager().flush();

            }
            h.setPzno(trno);
            hkfw006inv310Bean.update(h);
            HKFW006 fw006 = hkfw006Bean.findByPSN(psn);
            fw006.setPzno(trno);
            hkfw006Bean.update(fw006);
            return true;
        } catch (ParseException | NullPointerException | NumberFormatException ex) {
            log4j.error("initByOAHKFW006", ex);
            return false;
        }
    }

    public String initByOAHKGC001(String psn) throws Exception {
        HKGC001 e = hkgc001Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException(psn + "流程实例不存在");
        }
        if (e.getRelno() != null && !"".equals(e.getRelno())) {
            return "200";
        }
        hkgc001Bean.setDetail(e.getFormSerialNumber(), "N");
        if (hkgc001Bean.getDetailList() == null || hkgc001Bean.getDetailList().isEmpty()) {
            return "204";
        }
        String facno;
        String prono;
        String trno;
        Date trdate;
        Date indate = BaseLib.getDate();
        String trtype;

        facno = e.getFacno();
        prono = "1";
        trtype = "IAC";
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        Invdou invdou = invdouBean.findByTrtype(trtype);
        if (invdou == null) {
            throw new NullPointerException("库存交易单据类别错误，ERP不存在" + trtype);
        }
        int trseq = 0;
        Invhad invhad;
        Invdta invdta;
        Invmas invmas;
        List<Invdta> addedDetail = new ArrayList<>();
        HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
        detailAdded.put(invdtaBean, addedDetail);

        this.setCompany(facno);
        invmasBean.setCompany(facno);
        invsernoBean.setCompany(facno);
        invsysBean.setCompany(facno);
        try {
            trdate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String mon = BaseLib.formatDate("yyyyMM", trdate);
            Invsys invsys = invsysBean.findByFacno(facno);
            //如果已月结就改成次月1号
            if (mon.equals(invsys.getLmonth())) {
                Calendar c = Calendar.getInstance();
                c.setTime(trdate);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                trdate = c.getTime();
            }
            for (HKGC001Detail d : hkgc001Bean.getDetailList()) {
                //获取品号资料
                invmas = invmasBean.findByItnbr(d.getItnbr());
                if (invmas == null) {
                    throw new RuntimeException(d.getItnbr() + "ERP中不存在");
                }
                trseq++;
                invdta = new Invdta(d.getItnbr(), facno, prono, "", trseq);
                invdta.setTrtype(trtype);
                invdta.setItcls(invmas.getItcls());
                invdta.setItclscode(invmas.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getQty())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(invmas.getUnmsr1());
                invdta.setWareh(d.getWareh());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode('2');
                addedDetail.add(invdta);

                trseq++;
                invdta = new Invdta(d.getItnbr(), facno, prono, "", trseq);
                invdta.setTrtype(trtype);
                invdta.setItcls(invmas.getItcls());
                invdta.setItclscode(invmas.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getQty())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(invmas.getUnmsr1());
                invdta.setWareh(d.getWareh2());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode('1');
                addedDetail.add(invdta);
            }

            trno = invsernoBean.getTrno(facno, "", trtype, trdate, true);
            invhad = new Invhad(facno, prono, trno);
            invhad.setTrtype(trtype);
            invhad.setTrdate(trdate);
            invhad.setDepno(e.getApplyDept());
            invhad.setIocode(invdou.getIocode());
            invhad.setResno("T99");
            invhad.setSourceno(e.getProcessSerialNumber().substring(4));
            invhad.setStatus('N');
            invhad.setUserno(e.getApplyUser());
            invhad.setIndate(indate);
            invhad.setPrtcnt((short) 0);
            invhad.setAsrsQty(BigDecimal.ZERO);
            //明细列表交易单号赋值
            for (Invdta d : addedDetail) {
                d.getInvdtaPK().setTrno(trno);
            }
            //更新ERP INV325
            this.persist(invhad, detailAdded);
            getEntityManager().flush();
            e.setRelno(trno);
            hkgc001Bean.update(e);
            return trno;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String initByOAHKGC003(String psn) throws Exception {
        HKGC003 e = hkgc003Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException(psn + "流程实例不存在");
        }
        if ((e.getRelout() != null && !"".equals(e.getRelout())) || (e.getRelin() != null && !"".equals(e.getRelin()))) {
            return "200";
        }
        hkgc003Bean.setDetail(e.getFormSerialNumber());
        if (hkgc003Bean.getDetailList() == null || hkgc003Bean.getDetailList().isEmpty()) {
            return "204";
        }
        String facno;
        String prono;
        String trno;
        Date trdate;
        Date indate = BaseLib.getDate();

        facno = e.getFacno();
        prono = "1";
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        //入库
        Invdou IAA = invdouBean.findByTrtype("IAA");
        //出库
        Invdou IAB = invdouBean.findByTrtype("IAB");

        int trseq = 0;
        Invhad invhad;
        Invdta invdta;
        Invmas invmas;

        List<Invdta> addedIAA = new ArrayList<>();
        HashMap<SuperEJBForERP, List<?>> detailIAAAdded = new HashMap<>();
        detailIAAAdded.put(invdtaBean, addedIAA);

        List<Invdta> addedIAB = new ArrayList<>();
        HashMap<SuperEJBForERP, List<?>> detailIABAdded = new HashMap<>();
        detailIABAdded.put(invdtaBean, addedIAB);

        this.setCompany(facno);
        invmasBean.setCompany(facno);
        invsernoBean.setCompany(facno);
        invsysBean.setCompany(facno);
        try {
            trdate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String mon = BaseLib.formatDate("yyyyMM", trdate);
            Invsys invsys = invsysBean.findByFacno(facno);
            //如果已月结就改成次月1号
            if (mon.equals(invsys.getLmonth())) {
                Calendar c = Calendar.getInstance();
                c.setTime(trdate);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                trdate = c.getTime();
            }
            for (HKGC003Detail d : hkgc003Bean.getDetailList()) {
                //获取品号资料
                invmas = invmasBean.findByItnbr(d.getItnbr());
                if (invmas == null) {
                    throw new RuntimeException(d.getItnbr() + "ERP中不存在");
                }
                trseq++;
                //出库
                invdta = new Invdta(d.getItnbr(), facno, prono, "", trseq);
                invdta.setTrtype(IAB.getTrtype());
                invdta.setItcls(invmas.getItcls());
                invdta.setItclscode(invmas.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getStockqty())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(invmas.getUnmsr1());
                invdta.setWareh(d.getWareh());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode(IAB.getIocode());
                addedIAB.add(invdta);
                //入库
                invmas = invmasBean.findByItnbr(d.getItnbrf());
                if (invmas == null) {
                    throw new RuntimeException(d.getItnbrf() + "ERP中不存在");
                }
                invdta = new Invdta(d.getItnbrf(), facno, prono, "", trseq);
                invdta.setTrtype(IAA.getTrtype());
                invdta.setItcls(invmas.getItcls());
                invdta.setItclscode(invmas.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getStockqty())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(invmas.getUnmsr1());
                invdta.setWareh(d.getWareh());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode(IAA.getIocode());
                addedIAA.add(invdta);
            }
            //IAB
            trno = invsernoBean.getTrno(facno, "", IAB.getTrtype(), trdate, true);
            invhad = new Invhad(facno, prono, trno);
            invhad.setTrtype(IAB.getTrtype());
            invhad.setTrdate(trdate);
            invhad.setDepno(e.getApplyDept());
            invhad.setIocode(IAB.getIocode());
            invhad.setResno("T99");
            invhad.setSourceno(e.getProcessSerialNumber().substring(4));
            invhad.setStatus('N');
            invhad.setUserno(e.getApplyUser());
            invhad.setIndate(indate);
            invhad.setPrtcnt((short) 0);
            invhad.setAsrsQty(BigDecimal.ZERO);
            //明细列表交易单号赋值
            for (Invdta d : addedIAB) {
                d.getInvdtaPK().setTrno(trno);
            }
            this.persist(invhad, detailIABAdded);
            //记录ERP出库单号
            e.setRelout(trno);
            //IAA
            trno = invsernoBean.getTrno(facno, "", IAA.getTrtype(), trdate, true);
            invhad = new Invhad(facno, prono, trno);
            invhad.setTrtype(IAA.getTrtype());
            invhad.setTrdate(trdate);
            invhad.setDepno(e.getApplyDept());
            invhad.setIocode(IAA.getIocode());
            invhad.setResno("T99");
            invhad.setSourceno(e.getProcessSerialNumber().substring(4));
            invhad.setStatus('N');
            invhad.setUserno(e.getApplyUser());
            invhad.setIndate(indate);
            invhad.setPrtcnt((short) 0);
            invhad.setAsrsQty(BigDecimal.ZERO);
            //明细列表交易单号赋值
            for (Invdta d : addedIAA) {
                d.getInvdtaPK().setTrno(trno);
            }
            this.persist(invhad, detailIAAAdded);
            //记录ERP入库单号
            e.setRelin(trno);
            getEntityManager().flush();
            hkgc003Bean.update(e);
            return e.getRelout() + "$" + e.getRelin();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String initByOASHBERPINV325(String psn) {
        SHBERPINV325 e = shberpinv325Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.getRelformid() != null && !"".equals(e.getRelformid())) {
            return e.getRelformid();
        }
        shberpinv325Bean.setDetail(e.getFormSerialNumber());
        if (shberpinv325Bean.getDetailList() == null || shberpinv325Bean.getDetailList().isEmpty()) {
            throw new NullPointerException();
        }
        String facno;
        String prono;
        String trno;
        Date trdate;
        Date indate = BaseLib.getDate();
        String trtype;

        facno = e.getFacno();
        prono = e.getProno();
        trtype = e.getTrtype();
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        Invdou invdou = invdouBean.findByTrtype(trtype);
        if (invdou == null) {
            throw new NullPointerException("库存交易单据类别错误，ERP不存在" + trtype);
        }

        int trseq = 0;
        Invhad invhad;
        Invdta invdta;
        Invmas m;
        List<Invdta> addedDetail = new ArrayList<>();
        HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
        detailAdded.put(invdtaBean, addedDetail);

        this.setCompany(facno);
        invmasBean.setCompany(facno);
        invsernoBean.setCompany(facno);
        invsysBean.setCompany(facno);
        try {
            trdate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String mon = BaseLib.formatDate("yyyyMM", trdate);
            Invsys invsys = invsysBean.findByFacno(facno);
            //如果已月结就改成次月1号
            if (mon.equals(invsys.getLmonth())) {
                Calendar c = Calendar.getInstance();
                c.setTime(trdate);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                trdate = c.getTime();
            }
            for (SHBERPINV325Detail d : shberpinv325Bean.getDetailList()) {
                //获取品号资料
                m = invmasBean.findByItnbr(d.getItnbr());
                if (m == null) {
                    throw new RuntimeException(d.getItnbr() + "ERP中不存在");
                }
                trseq++;
                invdta = new Invdta(d.getItnbr(), facno, prono, "", trseq);
                invdta.setTrtype(trtype);
                invdta.setItcls(m.getItcls());
                invdta.setItclscode(m.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getSumnum())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(m.getUnmsr1());
                invdta.setWareh(d.getDfromwareh());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode('2');
                invdta.setDmark2("EFGP");
                addedDetail.add(invdta);

                trseq++;
                invdta = new Invdta(d.getItnbr(), facno, prono, "", trseq);
                invdta.setTrtype(trtype);
                invdta.setItcls(m.getItcls());
                invdta.setItclscode(m.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getSumnum())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(m.getUnmsr1());
                invdta.setWareh(d.getDtowareh());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode('1');
                invdta.setDmark2("EFGP");
                addedDetail.add(invdta);
            }

            trno = invsernoBean.getTrno(facno, "", trtype, trdate, true);
            invhad = new Invhad(facno, prono, trno);
            invhad.setTrtype(trtype);
            invhad.setTrdate(trdate);
            invhad.setDepno(e.getApplyDept());
            invhad.setIocode(invdou.getIocode());
            invhad.setResno(e.getResno());
            invhad.setSourceno(e.getProcessSerialNumber().substring(8));
            invhad.setStatus('N');
            invhad.setUserno(e.getApplyUser());
            invhad.setIndate(indate);
            invhad.setPrtcnt((short) 0);
            invhad.setAsrsQty(BigDecimal.ZERO);
            //明细列表交易单号赋值
            for (Invdta d : addedDetail) {
                d.getInvdtaPK().setTrno(trno);
            }
            //更新ERP INV325
            this.persist(invhad, detailAdded);
            getEntityManager().flush();
            e.setRelformid(trno);
            shberpinv325Bean.update(e);
            return trno;
        } catch (ParseException | RuntimeException ex) {
            log4j.error("initByOASHBERPINV325", ex);
        }
        return "";
    }

    public Boolean initByOAWARMI05(String psn) {

        WARMI05 e = warmi05Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException();
        }
        List<WARMI05Detail> detailList;
        warmi05Bean.setDetail(e.getFormSerialNumber());
        detailList = warmi05Bean.getDetailList();
        if (detailList.isEmpty()) {
            throw new NullPointerException();
        }
        String trtype = null;
        if (e.getTa001().equals("FWLL")) {
            //服务领料
            trtype = "IAF";
        } else if (e.getTa001().equals("FWTL")) {
            //服务退料
            trtype = "IAG";
        }
        if (trtype == null) {
            throw new NullPointerException("单据类别错误，OA需要FWLL或FWTL");
        }
        //判断是否已经抛转
        if ((trtype.equals("IAF") && e.getTa025() != null && !"".equals(e.getTa025())) || (trtype.equals("IAG")) && e.getTa026() != null && !"".equals(e.getTa026())) {
            return true;//返回false会导致流程死循环
        }

        boolean flag = false;
        String facno = e.getTa014();
        String prono = "1";
        String trno = "";
        Date trdate;
        Date indate = BaseLib.getDate();
        short trseq = 0;
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        Invdou invdou = invdouBean.findByTrtype(trtype);
        if (invdou == null) {
            throw new NullPointerException("单据类别错误，ERP需要IAF或IAG");
        }
        Invbal invbal;
        Invbat invbat;
        Invtrn invtrn;
        List<Invbal> invbalList = new ArrayList();
        List<Invbat> invbatList = new ArrayList();
        List<Invtrn> invtrnList = new ArrayList();

        List<Invdta> addedDetail = new ArrayList();
        HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
        detailAdded.put(invdtaBean, addedDetail);
        this.setCompany(facno);
        invmasBean.setCompany(facno);
        invbalBean.setCompany(facno);
        invbatBean.setCompany(facno);
        invtrnBean.setCompany(facno);
        invsysBean.setCompany(facno);
        try {
            trdate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String mon = BaseLib.formatDate("yyyyMM", trdate);
            Invsys invsys = invsysBean.findByFacno(facno);
            //如果已月结就改成次月1号
            if (mon.equals(invsys.getLmonth())) {
                Calendar c = Calendar.getInstance();
                c.setTime(trdate);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                trdate = c.getTime();
            }
            for (WARMI05Detail d : detailList) {
                trseq++;
                Invdta invdta = new Invdta();
                InvdtaPK invdtaPK = new InvdtaPK();
                invdtaPK.setFacno(facno);
                invdtaPK.setItnbr(d.getTb004());
                invdtaPK.setProno(prono);
                //invdtaPK.setTrno();
                invdtaPK.setTrseq(trseq);
                invdta.setInvdtaPK(invdtaPK);
                invdta.setTrtype(trtype);
                //获取品号资料
                Invmas m = invmasBean.findByItnbr(d.getTb004());
                if (m == null) {
                    throw new RuntimeException(d.getTb004() + "ERP中不存在");
                }
                invdta.setItcls(m.getItcls());
                invdta.setItclscode(m.getItclscode());
                if (d.getTb009() == null || "".equals(d.getTb009())) {
                    invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getTb007())));
                } else {
                    invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getTb009())));
                }
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(m.getUnmsr1());
                invdta.setWareh(d.getTb010());
                invdta.setFixnr(d.getTb011());
                invdta.setVarnr(d.getTb019());
                invdta.setIocode(invdou.getIocode());
                //按ERP逻辑重新设置批号
                switch (m.getInvcls().getNrcode()) {
                    case '0':
                        invdta.setFixnr("");
                        invdta.setVarnr("");
                        break;
                    case '1':
                        invdta.setVarnr("");
                        break;
                    case '2':
                        invdta.setFixnr("");
                        break;
                    default:
                        break;
                }
                if (invdou.getIocode() == '2') {
                    //库存可利用量检查
                    flag = invbalBean.isGreatThenInvbal(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh(), invdta.getTrnqy1());
                    if (flag) {
                        throw new RuntimeException(d.getTb004() + "库存可利用量不足(invbal)");
                    } else {
                        invbal = new Invbal(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh());
                        invbal.setItcls(invdta.getItcls());
                        invbal.setItclscode(invdta.getItclscode());
                        invbal.setOnhand1(invdta.getTrnqy1());
                        //加入库存更新列表
                        invbalList.add(invbal);
                    }
                    //批号可利用量检查
                    if (m.getInvcls().getNrcode() != '0') {
                        invdta.setDefaultValue();
                        flag = invbatBean.isGreatThenInvbat(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh(), invdta.getFixnr(), invdta.getVarnr(), invdta.getTrnqy1());
                        if (flag) {
                            throw new RuntimeException(d.getTb004() + "库存可利用量不足(invbat)");
                        } else {
                            invbat = new Invbat(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh(), invdta.getFixnr(), invdta.getVarnr());
                            invbat.setItcls(invdta.getItcls());
                            invbat.setItclscode(invdta.getItclscode());
                            invbat.setOnhand1(invdta.getTrnqy1());
                            //加入库存更新列表
                            invbatList.add(invbat);
                        }
                    }
                }
                //交易单号预设空白，后续重新赋值
                invtrn = new Invtrn(facno, prono, trtype, "", trseq);
                invtrn.setItnbr(invdta.getInvdtaPK().getItnbr());
                invtrn.setTrdate(trdate);
                invtrn.setDepno(e.getTa032());
                invtrn.setHmark1(e.getTa031());
                invtrn.setHmark2(e.getTa030());
                invtrn.setWareh(invdta.getWareh());
                invtrn.setFixnr(invdta.getFixnr());
                invtrn.setVarnr(invdta.getVarnr());
                invtrn.setTrnqy1(invdta.getTrnqy1());
                invtrn.setTrnqy2(invdta.getTrnqy2());
                invtrn.setTrnqy3(invdta.getTrnqy3());
                invtrn.setUnmsr1(m.getUnmsr1());
                invtrn.setIocode(invdou.getIocode());
                invtrn.setUserno(e.getTa012());
                invtrn.setCfmuserno(e.getTa012());
                invtrn.setRescode(e.getTa042());
                invtrn.setSyscode(invdou.getSyscode());
                invtrn.setSourceno(e.getTa001() + e.getTa002());
                invtrn.setItcls(invdta.getItcls());
                invtrn.setItclscode(invdta.getItclscode());
                invtrn.setIndate(indate);
                invtrn.setCfmdate(indate);
                //加入库存出入新增列表
                addedDetail.add(invdta);
                //加入交易历史新增列表
                invtrnList.add(invtrn);
            }
            invsernoBean.setCompany(facno);
            trno = invsernoBean.getTrno(facno, "", trtype, trdate, true);
            Invhad invhad = new Invhad(facno, prono, trno);
            invhad.setTrtype(trtype);
            invhad.setTrdate(trdate);
            invhad.setDepno(e.getTa032());//客户
            invhad.setIocode(invdou.getIocode());
            invhad.setHmark1(e.getTa031());//区域
            invhad.setHmark2(e.getTa030());//产品
            invhad.setResno(e.getTa042());
            invhad.setKfno(e.getTa039());
            invhad.setFwno(e.getTa040() + e.getTa041());
            invhad.setSourceno(e.getTa002());
            invhad.setStatus('Y');
            invhad.setUserno(e.getTa012());
            invhad.setIndate(indate);
            invhad.setCfmuserno(e.getTa012());
            invhad.setCfmdate(indate);
            //明细列表交易单号赋值
            for (Invdta d : addedDetail) {
                d.getInvdtaPK().setTrno(trno);
            }
            //更新ERP INV310
            this.persist(invhad, detailAdded);
            //更新ERP交易历史
            for (Invtrn t : invtrnList) {
                t.getInvtrnPK().setTrno(trno);
                invtrnBean.persist(t);
            }
            //更新ERP库存数量
            if (invdou.getIocode() == '1') {
                //入库增加库存
                invbalBean.add(invbalList);
                invbatBean.add(invbatList);
            } else if (invdou.getIocode() == '2') {
                //出库减少库存
                invbalBean.subtract(invbalList);
                invbatBean.subtract(invbatList);
            }
            //回写OA记录ERP单号
            if (trtype.equals("IAF")) {
                e.setTa025(trno);
            } else if (trtype.equals("IAG")) {
                e.setTa026(trno);
            }
            warmi05Bean.update(e);

            return true;
        } catch (ParseException | RuntimeException ex) {
            log4j.error("initByOAWARMI05", ex);
            return false;
        }

    }

    public String initINV310(Invhad invhad, List<Invdta> addedDetail, boolean confirm) {
        boolean flag;
        String facno;
        String prono;
        String trno;
        Date trdate;
        String trtype;
        facno = invhad.getInvhadPK().getFacno();
        prono = invhad.getInvhadPK().getProno();
        trdate = invhad.getTrdate();
        trtype = invhad.getTrtype();

        Invcls invcls;
        Invbal invbal;
        Invbat invbat;
        Invtrn invtrn;
        List<Invbal> invbalList = new ArrayList();
        List<Invbat> invbatList = new ArrayList();
        List<Invtrn> invtrnList = new ArrayList();

        HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
        detailAdded.put(invdtaBean, addedDetail);

        this.setCompany(facno);
        invclsBean.setCompany(facno);
        invdouBean.setCompany(facno);
        invmasBean.setCompany(facno);
        invbalBean.setCompany(facno);
        invbatBean.setCompany(facno);
        invtrnBean.setCompany(facno);

        try {
            //获取ERP库存交易类别
            Invdou invdou = invdouBean.findByTrtype(trtype);
            if (invdou == null) {
                throw new NullPointerException(trtype + "单据类别错误");
            }
            invsernoBean.setCompany(facno);
            trno = invsernoBean.getTrno(facno, "", trtype, trdate, true);
            invhad.getInvhadPK().setTrno(trno);
            invhad.setIocode(invdou.getIocode());

            flag = true;
            for (Invdta invdta : addedDetail) {

                invdta.getInvdtaPK().setTrno(trno);
                invdta.setIocode(invdou.getIocode());
                if (invdou.getIocode() == '2') {
                    //库存可利用量检查
                    flag = flag && !invbalBean.isGreatThenInvbal(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh(), invdta.getTrnqy1());
                    if (flag) {
                        invbal = new Invbal(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh());
                        invbal.setItcls(invdta.getItcls());
                        invbal.setItclscode(invdta.getItclscode());
                        invbal.setOnhand1(invdta.getTrnqy1());
                        //加入库存更新列表
                        invbalList.add(invbal);
                    }
                    invcls = invclsBean.findByItcls(invdta.getItcls());
                    //批号可利用量检查
                    if (invcls.getNrcode() != '0') {
                        invdta.setDefaultValue();
                        flag = flag && !invbatBean.isGreatThenInvbat(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh(), invdta.getFixnr(), invdta.getVarnr(), invdta.getTrnqy1());
                        if (flag) {
                            invbat = new Invbat(facno, prono, invdta.getInvdtaPK().getItnbr(), invdta.getWareh(), invdta.getFixnr(), invdta.getVarnr());
                            invbat.setItcls(invdta.getItcls());
                            invbat.setItclscode(invdta.getItclscode());
                            invbat.setOnhand1(invdta.getTrnqy1());
                            //加入库存更新列表
                            invbatList.add(invbat);
                        }
                    }
                }
                //库存交易历史
                invtrn = new Invtrn(facno, prono, trtype, trno, invdta.getInvdtaPK().getTrseq());
                invtrn.setItnbr(invdta.getInvdtaPK().getItnbr());
                invtrn.setTrdate(trdate);
                invtrn.setDepno(invhad.getDepno());
                invtrn.setWareh(invdta.getWareh());
                invtrn.setFixnr(invdta.getFixnr());
                invtrn.setVarnr(invdta.getVarnr());
                invtrn.setTrnqy1(invdta.getTrnqy1());
                invtrn.setTrnqy2(invdta.getTrnqy2());
                invtrn.setTrnqy3(invdta.getTrnqy3());
                invtrn.setUnmsr1(invdta.getUnmsr1());
                invtrn.setIocode(invdta.getIocode());
                invtrn.setUserno(invhad.getUserno());
                invtrn.setCfmuserno(invhad.getUserno());
                invtrn.setRescode(invhad.getResno());
                invtrn.setSyscode(invdou.getSyscode());
                invtrn.setSourceno(invhad.getSourceno());
                invtrn.setItcls(invdta.getItcls());
                invtrn.setItclscode(invdta.getItclscode());
                invtrn.setIndate(trdate);
                invtrn.setCfmdate(trdate);
                //加入交易历史新增列表
                invtrnList.add(invtrn);

            }
            //如果库存检查正确直接确认单据
            if (flag && confirm) {
                invhad.setStatus('Y');
                invhad.setCfmuserno(invhad.getUserno());
                invhad.setCfmdate(trdate);
            }
            //更新ERP INV310
            this.persist(invhad, detailAdded);

            //如果库存检查正确直接确认单据
            if (flag && confirm) {
                //更新ERP交易历史
                for (Invtrn t : invtrnList) {
                    invtrnBean.persist(t);
                }
                //更新ERP库存数量
                if (invdou.getIocode() == '1') {
                    //入库增加库存
                    invbalBean.add(invbalList);
                    invbatBean.add(invbatList);
                } else if (invdou.getIocode() == '2') {
                    //出库减少库存
                    invbalBean.subtract(invbalList);
                    invbatBean.subtract(invbatList);
                }
            }
            return trno + "$" + String.valueOf(flag);
        } catch (Exception ex) {
            log4j.error("initINV310", ex);
            return "";
        }
    }

    public Boolean initByOAHKPB054(String psn) throws Exception {
        HKPB054 e = hkpb054Bean.findByPSN(psn);
        //判断流程是否存在
        if (e == null) {
            throw new NullPointerException(psn + "流程实例不存在");
        }
        //判断物料赔款明细是否存在
        hkpb054Bean.setHkpb054WLDetailList(e.getFormSerialNumber());
        if (hkpb054Bean.getHkpb054WLDetailList() == null || hkpb054Bean.getHkpb054WLDetailList().isEmpty()) {
            throw new NullPointerException("OA表单中不存在物料赔款明细");
        }
        String facno;
        String prono;
        String trno;
        Date trdate;
        BigDecimal trnqy;
        Date indate = BaseLib.getDate();

        facno = e.getFacno();
        prono = "1";
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        Invdou IAB = invdouBean.findByTrtype("IAB");
        if (IAB == null) {
            throw new NullPointerException("库存交易单据类别错误，ERP不存在" + "IAB");
        }
        //手工领料单
        int trseq = 0;
        Invhad invhad;
        Invdta invdta;
        Invmas invmas;
        Invbal invbal;
        List<Invdta> addedIAB = new ArrayList<>();
        HashMap<SuperEJBForERP, List<?>> detailIABAdded = new HashMap<>();
        detailIABAdded.put(invdtaBean, addedIAB);

        this.setCompany(facno);
        invmasBean.setCompany(facno);
        invsernoBean.setCompany(facno);
        invsysBean.setCompany(facno);
        try {
            trdate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String mon = BaseLib.formatDate("yyyyMM", trdate);
            Invsys invsys = invsysBean.findByFacno(facno);
            //如果已月结就改成次月1号
            if (mon.equals(invsys.getLmonth())) {
                Calendar c = Calendar.getInstance();
                c.setTime(trdate);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                trdate = c.getTime();
            }
            for (HKPB054WLDetail d : hkpb054Bean.getHkpb054WLDetailList()) {
            //获取品号资料
                invmas = invmasBean.findByItnbr(d.getItnbr());
                if (invmas == null) {
                    throw new RuntimeException(d.getItnbr() + "ERP中不存在");
                }
                //判断是否有库存数量
                invbal = invbalBean.findByItnbrAndWareh(d.getItnbr(), d.getWareh());
                if (invbal == null) {
                    throw new RuntimeException(d.getItnbr() + "ERP中不存在库存信息");
                } else {
                    trnqy = new BigDecimal(d.getQuantity());
                    if (invbal.getOnhand1().compareTo(trnqy) == -1) {
                        throw new RuntimeException(d.getItnbr() + "ERP中库存不足");
                    }
                }
                trseq++;
                //调拨出去
                invdta = new Invdta(d.getItnbr(), facno, prono, "", trseq);
                invdta.setTrtype(IAB.getTrtype());
                invdta.setItcls(invmas.getItcls());
                invdta.setItclscode(invmas.getItclscode());
                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getQuantity())));
                invdta.setTrnqy2(BigDecimal.ZERO);
                invdta.setTrnqy3(BigDecimal.ZERO);
                invdta.setUnmsr1(invmas.getUnmsr1());
                invdta.setWareh(d.getWareh());
                invdta.setFixnr("");
                invdta.setVarnr("");
                invdta.setIocode(IAB.getIocode());
                addedIAB.add(invdta);
            }
            trno = invsernoBean.getTrno(facno, "", IAB.getTrtype(), trdate, true);
            invhad = new Invhad(facno, prono, trno);
            invhad.setTrtype(IAB.getTrtype());
            invhad.setTrdate(trdate);
            invhad.setDepno(e.getApplyDept());
            invhad.setIocode(IAB.getIocode());
            invhad.setResno("");
            invhad.setSourceno(e.getProcessSerialNumber().substring(8));
            invhad.setStatus('N');
            invhad.setUserno(e.getApplyUser());
            invhad.setIndate(indate);
            invhad.setPrtcnt((short) 0);
            invhad.setAsrsQty(BigDecimal.ZERO);
            //明细列表交易单号赋值
            for (Invdta d : addedIAB) {
                d.getInvdtaPK().setTrno(trno);
            }
            //更新ERP INV310
            this.persist(invhad, detailIABAdded);
            getEntityManager().flush();
            //单号回写OA
            e.setRelformid(trno);
            hkpb054Bean.update(e);
            return true;
        } catch (Exception ex) {
            log4j.error("initByOAHKPB054", ex.toString());
            throw ex;
        }
    }

    /**
     *
     * @param kfno
     * @return 得出历史档材料明细
     */
    public List getCustomerComplaintMaterial(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" select a.kfno,a.fwno,a.trtype,a.typedsc,t.trno,a.trdate,a.trseq,t.itnbr,a.itdsc,t.trnqy1,t.unmsr1,t.tramt FROM (SELECT * FROM invhadh h ");
        sb.append(" LEFT JOIN invdtah d on h.trno=d.trno AND  h.facno=d.facno AND h.prono=d.prono  LEFT JOIN invmas v on d.itnbr = v.itnbr ");
        sb.append(" LEFT JOIN invdou e on e.trtype=d.trtype where  h.facno='${facno}' and h.prono='1' and (h.trtype in ('IAF' ,'IAG')) AND h.kfno='${kfno}' ) a ");
        sb.append(" LEFT JOIN  invtrnh t on a.facno=t.facno and a.prono=t.prono and a.itnbr = t.itnbr  and  a.trno= t.trno ");
        sb.append(" and t.trseq=a.trseq and t.trno= a.trno and t.trtype = a.trtype where t.facno='${facno}' and (t.trtype ='IAF' or t.trtype= 'IAG') and t.prono= '1' ");
        sb.append(" union all ");
        sb.append(" select a.kfno,a.fwno,a.trtype,a.typedsc,t.trno,a.trdate,a.trseq,t.itnbr,a.itdsc,t.trnqy1,t.unmsr1,t.tramt FROM (SELECT * FROM invhad h ");
        sb.append(" LEFT JOIN invdta d on h.trno=d.trno AND  h.facno=d.facno AND h.prono=d.prono  LEFT JOIN invmas v on d.itnbr = v.itnbr ");
        sb.append(" LEFT JOIN invdou e on e.trtype=d.trtype where  h.facno='${facno}' and h.prono='1' and (h.trtype in ('IAF' ,'IAG')) AND h.kfno='${kfno}' ) a ");
        sb.append(" LEFT JOIN  invtrn t on a.facno=t.facno and a.prono=t.prono and a.itnbr = t.itnbr  and  a.trno= t.trno ");
        sb.append(" and t.trseq=a.trseq and t.trno= a.trno and t.trtype = a.trtype where t.facno='${facno}' and (t.trtype ='IAF' or t.trtype= 'IAG') and t.prono= '1' ");

        List alllist = null;
        String facno = "KM".equals(kfno.substring(0, 2)) ? "K" : "C,C4,N,G,J";
        try {
            if (facno != null) {
                alllist = new ArrayList<>();
                String[] arr = facno.split(",");
                String sql;
                Query query;
                List list;
                for (String fn : arr) {
                    sql = sb.toString().replace("${facno}", fn).replace("${kfno}", kfno);
                    setCompany(fn);
                    query = getEntityManager().createNativeQuery(sql);
                    list = query.getResultList();
                    if (list != null && !list.isEmpty()) {
                        alllist.addAll(list);
                    }
                }
            }
            return alllist;
        } catch (Exception e) {
            return null;
        }
    }

}
