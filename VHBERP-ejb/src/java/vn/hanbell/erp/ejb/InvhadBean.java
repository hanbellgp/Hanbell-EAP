/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.HKFW006Inv310Bean;
import cn.hanbell.oa.ejb.HKFW006Inv310DetailBean;
import cn.hanbell.oa.ejb.SHBERPINV310Bean;
import cn.hanbell.oa.ejb.SHBERPINV325Bean;
import cn.hanbell.oa.ejb.VHFW004Bean;
import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.oa.entity.HKFW006Inv310;
import cn.hanbell.oa.entity.HKFW006Inv310Detail;
import cn.hanbell.oa.entity.VHFW004;
import cn.hanbell.oa.entity.VHFW004Detail;
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
import javax.ejb.TransactionRolledbackLocalException;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Invbal;
import vn.hanbell.erp.entity.Invbat;
import vn.hanbell.erp.entity.Invdou;
import vn.hanbell.erp.entity.Invdta;
import vn.hanbell.erp.entity.InvdtaPK;
import vn.hanbell.erp.entity.Invhad;
import vn.hanbell.erp.entity.InvhadPK;
import vn.hanbell.erp.entity.Invmas;
import vn.hanbell.erp.entity.Invsys;
import vn.hanbell.erp.entity.Invtrn;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class InvhadBean extends SuperEJBForERP<Invhad> {

    //EJBForEFGP
    @EJB
    private VHFW004Bean vhfw004Bean;

    @EJB
    private SHBERPINV310Bean shberpinv310Bean;

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

//    public Boolean initByOAHKFW006(String psn) {
//        Date date;
//        HKFW006Inv310 h = hkfw006inv310Bean.findByPSN(psn);
//        if (h == null) {
//            throw new NullPointerException();
//        }
//        if (h.getPzno() != null && h.getPzno().length() > 5) {
//            throw new NullPointerException("抛转单号已生成，请确认是否已抛转");
//        }
//        try {
//            String facno = h.getFacno();
//            String prono = "1";
//            String depno = h.getDepno();
//            String trtype = h.getTrtype();
//            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
//            String mon = BaseLib.formatDate("yyyyMM", date);
//            invsysBean.setCompany(facno);
//            Invsys invsys = invsysBean.findByFacno(facno);
//            //如果已月结就改成次月1号
//            if (mon.equals(invsys.getLmonth())) {
//                Calendar c = Calendar.getInstance();
//                c.setTime(date);
//                c.add(Calendar.MONTH, 1);
//                c.set(Calendar.DATE, 1);
//                date = c.getTime();
//            }
//            invsernoBean.setCompany(facno);
//            String trno = invsernoBean.getTrno(facno, depno, trtype, date, true);
//            Invhad invhad = new Invhad();
//            InvhadPK pk = new InvhadPK();
//            pk.setFacno(facno);
//            pk.setProno(prono);
//            pk.setTrno(trno);
//            invhad.setInvhadPK(pk);
//            invhad.setTrtype(trtype);
//            invhad.setTrdate(date);
//            invhad.setDepno(depno);
//            invhad.setIocode('1');
//            invhad.setHmark1(h.getHmark1());
//            invhad.setHmark2(h.getHmark2());
//            invhad.setResno(h.getResno());
//            invhad.setFwno(h.getFwno());
//            invhad.setKfno(h.getKfno());
//            String srcno = h.getProcessSerialNumber().substring(4);
//            invhad.setSourceno(srcno);
//
//            HKFW006 hkfw006 = hkfw006Bean.findByPSN(psn);
//            invhad.setUserno(h.getPzuser());
//            invhad.setIndate(date);
//            //invhad.setCfmuserno(h.getPzuser());
//            //invhad.setCfmdate(date);
//            invhad.setStatus("N".charAt(0));
//            invhad.setPrtcnt((short) 0);
//            invhad.setVdrno("");
//            this.setCompany(facno);
//            persist(invhad);
//
//            List<HKFW006Inv310Detail> details = hkfw006inv310DetailBean.findByFSN(h.getFormSerialNumber());
//            if (details.size() <= 0) {
//                throw new NullPointerException();
//            }
//            //表身循环
//            for (int i = 0; i < details.size(); i++) {
//                HKFW006Inv310Detail detail = details.get(i);
//                Invdta invdta = new Invdta();
//                InvdtaPK invdtaPK = new InvdtaPK();
//                invdtaPK.setFacno(facno);
//                invdtaPK.setItnbr(detail.getItnbr());
//                invdtaPK.setProno("1");
//                invdtaPK.setTrno(trno);
//                invdtaPK.setTrseq(i + 1);
//                invdta.setInvdtaPK(invdtaPK);
//                invdta.setTrtype(trtype);
//                invmasBean.setCompany(facno);
//                Invmas m = invmasBean.findByItnbr(detail.getItnbr());
//                if (m == null) {
//                    throw new RuntimeException(detail.getItnbr() + "ERP中不存在");
//                }
//                invdta.setItcls(m.getItcls());
//                invdta.setItclscode(m.getItclscode());
//                invdta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(detail.getNum())));
//                invdta.setTrnqy2(BigDecimal.ZERO);
//                invdta.setTrnqy3(BigDecimal.ZERO);
//                invdta.setUnmsr1(m.getUnmsr1());
//                invdta.setWareh(detail.getWareh());
//                invdta.setIocode('1');
//                invdta.setVarnr(detail.getVarnr());
//                invdta.setFixnr(detail.getFixnr());
//                //按ERP逻辑重新设置批号
//                switch (m.getInvcls().getNrcode()) {
//                    case '0':
//                        invdta.setFixnr("");
//                        invdta.setVarnr("");
//                        break;
//                    case '1':
//                        invdta.setVarnr("");
//                        break;
//                    case '2':
//                        invdta.setFixnr("");
//                        break;
//                    default:
//                        break;
//                }
//                invdtaBean.setCompany(facno);
//                invdtaBean.persist(invdta);
//                invdtaBean.getEntityManager().flush();
//
//            }
//            //加入表头备注栏位说明
////            Invhdsc invhdsc = new Invhdsc();
////            InvhdscPK invhdscPK = new InvhdscPK();
////            invhdscPK.setFacno(facno);
////            invhdscPK.setProno(prono);
////            invhdscPK.setTrno(trno);
////            invhdsc.setInvhdscPK(invhdscPK);
////            invhdsc.setMark1(h.getMark1());
////            invhdscBean.setCompany(facno);
////            invhdscBean.persist(invhdsc);
//            //回写ERP单号到OA
//            h.setPzno(trno);
//            hkfw006inv310Bean.update(h);
//            HKFW006 fw006 = hkfw006Bean.findByPSN(psn);
//            fw006.setPzno(trno);
//            hkfw006Bean.update(fw006);
//            return true;
//        } catch (ParseException | NullPointerException | NumberFormatException ex) {
//            log4j.error("initByOAHKFW006", ex);
//            ex.printStackTrace();
//            return false;
//        }
//    }

    public Boolean initByOAVHFW004(String psn) {

        VHFW004 e = vhfw004Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException();
        }
        List<VHFW004Detail> detailList;
        detailList = vhfw004Bean.getDetailList(e.getFormSerialNumber());
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
            for (VHFW004Detail d : detailList) {
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
                invdta.setWareh(d.getTB010txt());
                invdta.setFixnr(d.getTB011txt());
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
            vhfw004Bean.update(e);

            return true;
        } catch (ParseException | RuntimeException ex) {
            log4j.error("initByOAWARMI05", ex);
            return false;
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
        String facno = "KM".equals(kfno.substring(0, 2)) ? "K" : "C,C4,N,G,J,F";
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

    /**
     *
     * @param fwno
     * @param resno
     * @return 得出历史档材料明细
     */
    public synchronized BigDecimal getInvtrnhTramt(String fwno, String resno) {
        StringBuilder sb = new StringBuilder();
        String facno;
        BigDecimal amt = BigDecimal.ZERO;
        sb.append(" select isnull(sum(t.tramt),0) as tramt FROM (SELECT * FROM invhadh h ");
        sb.append(" LEFT JOIN invdtah d on h.trno=d.trno AND  h.facno=d.facno ");
        sb.append(" AND h.prono=d.prono  LEFT JOIN invmas v on d.itnbr = v.itnbr ");
        sb.append(" LEFT JOIN invdou e on e.trtype=d.trtype where  h.facno='${facno}' ");
        sb.append(" and h.prono='1' and (h.trtype in ('IAF' ,'IAG')) AND h.fwno='${fwno}' ");
        if (!"".equals(resno)) {//('1001','1013')
            sb.append(" and h.resno in ").append(resno);
        }
        sb.append(" ) a ");
        sb.append(" LEFT JOIN  invtrnh t on a.facno=t.facno and a.prono=t.prono and a.itnbr = t.itnbr  and  a.trno= t.trno ");
        sb.append(" and t.trseq=a.trseq and t.trno= a.trno and t.trtype = a.trtype where t.facno='${facno}' ");
        sb.append(" and (t.trtype ='IAF' or t.trtype= 'IAG') and t.prono= '1' ");
        switch (fwno.substring(0, 2)) {
            case "KM":
                facno = "K";
                break;
            case "ZS":
                facno = "E";
                break;
            default:
                facno = "C,C4,N,G,J";
                break;
        }
        try {
            String[] arr = facno.split(",");
            String sql;
            Query query;
            for (String fn : arr) {
                sql = sb.toString().replace("${facno}", fn).replace("${fwno}", fwno);
                setCompany(fn);
                query = getEntityManager().createNativeQuery(sql);
                Object o = query.getSingleResult();
                BigDecimal result = BigDecimal.valueOf(Double.valueOf(o.toString()));
                amt.add(result);
            }
            return amt;
        } catch (NumberFormatException | TransactionRolledbackLocalException ex) {
            return BigDecimal.ZERO;
        }
    }

    public List<Invhad> getInvtrnhByFacnoAndPronoAndTrnoAndTrtype(String facno, String prono, String trno, String trtype) {
        try {

            StringBuffer sql = new StringBuffer();
            sql.append("SELECT *");
            sql.append(" FROM invhadh where trno='").append(trno).append("' and facno='").append(facno).append("' and prono='").append(prono).append("' and trtype='").append(trtype).append("'");
            sql.append(" union");
            sql.append("  SELECT *");
            sql.append(" FROM invhad where trno='").append(trno).append("' and facno='").append(facno).append("' and prono='").append(prono).append("' and trtype='").append(trtype).append("'");

            Query q = getEntityManager().createNativeQuery(sql.toString(), Invhad.class);

            List<Invhad> s = q.getResultList();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //对包含中文的字符长度做处理
    public List<String> getStringArray(String s, int slength, List<String> arrList) {
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            String si = s.substring(i, i + 1);
            if (si.matches("[^\\x00-\\xff]")) { //匹配中文字符
                k += 2;
            } else {
                k += 1;
            }
            if (k >= slength) {
                arrList.add(s.substring(0, i + 1));
                if (!s.substring(i + 1).trim().equals("")) {
                    return getStringArray(s.substring(i + 1), slength, arrList);
                }
            }
        }
        if (k < slength) {
            arrList.add(s.substring(0));
        }
        return arrList;
    }
}
