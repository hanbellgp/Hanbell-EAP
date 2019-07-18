/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrcusman;
import cn.hanbell.erp.entity.CdrcusmanPK;
import cn.hanbell.erp.entity.Cdrivo;
import cn.hanbell.erp.entity.Cdrscus;
import cn.hanbell.erp.entity.Invwh;
import cn.hanbell.erp.entity.Invwhclk;
import cn.hanbell.erp.entity.InvwhclkPK;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Transwah;
import cn.hanbell.erp.entity.TranswahPK;
import cn.hanbell.oa.ejb.HKJH003Bean;
import cn.hanbell.oa.ejb.HKYX006Bean;
import cn.hanbell.oa.ejb.HKYX007Bean;
import cn.hanbell.oa.entity.HKJH003;
import cn.hanbell.oa.entity.HKJH003Detail;
import cn.hanbell.oa.entity.HKYX006;
import cn.hanbell.oa.entity.HKYX007;
import cn.hanbell.util.BaseLib;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.persistence.Query;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class CdrcusBean extends SuperEJBForERP<Cdrcus> {

    @EJB
    private HKYX006Bean beanHKYX006;
    @EJB
    private HKYX007Bean beanHKYX007;
    @EJB
    private HKJH003Bean beanHKJH003;
    @EJB
    private CRMGGBean beanCRMGG;

    @EJB
    private SyncGZBean syncGZBean;
    @EJB
    private SyncJNBean syncJNBean;
    @EJB
    private SyncNJBean syncNJBean;
    @EJB
    private SyncCQBean syncCQBean;
    @EJB
    private SyncSHBBean syncSHBBean;

    @EJB
    private CdrivoBean cdrivoBean;
    @EJB
    private CdrscusBean cdrscusBean;
    @EJB
    private CdrcusmanBean cdrcusmanBean;
    @EJB
    private InvwhBean invwhBean;
    @EJB
    private InvwhclkBean invwhclkBean;
    @EJB
    private TranswahBean transwahBean;

    private Cdrcus cdrcus;
    private final HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
    //private final HashMap<SuperEJBForERP, List<?>> detailEdited = new HashMap<>();
    //private final HashMap<SuperEJBForERP, List<?>> detailDeleted = new HashMap<>();

    private final List<Cdrivo> cdrivoAdded = new ArrayList<>();
    private final List<Cdrscus> cdrscusAdded = new ArrayList<>();
    private final List<Cdrcusman> cdrcusmanAdded = new ArrayList<>();
    private final List<Transwah> transwahAdded = new ArrayList<>();
    private final List<Invwh> invwhAdded = new ArrayList<>();
    private final List<Invwhclk> invwhclkAdded = new ArrayList<>();
    private final List<Miscode> miscodeAdded = new ArrayList<>();

    public CdrcusBean() {
        super(Cdrcus.class);
    }

    public Cdrcus findByCusno(String cusno) {
        Query query = getEntityManager().createNamedQuery("Cdrcus.findByCusno");
        query.setParameter("cusno", cusno);
        try {
            Object o = query.getSingleResult();
            return (Cdrcus) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cdrcus findByCusds(String cusds) {
        Query query = getEntityManager().createNamedQuery("Cdrcus.findByCusds");
        query.setParameter("cusds", cusds);
        try {
            Object o = query.getSingleResult();
            return (Cdrcus) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Cdrcus> findByMan(String userno) {
        List<Cdrcus> cdrcusList = new ArrayList<>();
        List<Cdrcusman> results = cdrcusmanBean.findByMan(userno);
        if (results != null && !results.isEmpty()) {
            for (Cdrcusman m : results) {
                cdrcusList.add(m.getCdrcus());
            }
        }
        return cdrcusList;
    }

    public List<Cdrcus> findByMan(Map<String, Object> filters, int first, int pageSize) {
        List<Cdrcus> cdrcusList = new ArrayList<>();
        List<Cdrcusman> results = cdrcusmanBean.findByFilters(filters, first, pageSize);
        if (results != null && !results.isEmpty()) {
            for (Cdrcusman m : results) {
                cdrcusList.add(m.getCdrcus());
            }
        }
        return cdrcusList;
    }

    public boolean cloneByOAHKJH003(String psn) {
        //表头
        HKJH003 e = beanHKJH003.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException(psn + "不存在");
        }
        List<HKJH003Detail> detailList = beanHKJH003.findDetail(e.getFormSerialNumber());
        String facno1, facno2, cusno;
        facno1 = e.getFacno1();
        facno2 = e.getFacno2();
        try {
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException("客户明细资料不存在");
            }
            detailAdded.put(transwahBean, transwahAdded);
            detailAdded.put(invwhclkBean, invwhclkAdded);
            detailAdded.put(invwhBean, invwhAdded);
            detailAdded.put(cdrcusmanBean, cdrcusmanAdded);
            detailAdded.put(cdrscusBean, cdrscusAdded);
            detailAdded.put(cdrivoBean, cdrivoAdded);
            detailAdded.put(miscodeBean, miscodeAdded);

            for (HKJH003Detail c : detailList) {
                cusno = c.getCusno();
                setCompany(facno2);
                cdrcus = findByCusno(cusno);
                if (cdrcus != null) {
                    continue;
                }
                setCompany(facno1);
                cdrscusBean.setCompany(facno1);
                cdrivoBean.setCompany(facno1);
                miscodeBean.setCompany(facno1);
                invwhclkBean.setCompany(facno1);
                invwhBean.setCompany(facno1);
                transwahBean.setCompany(facno1);
                cdrcusmanBean.setCompany(facno1);
                cdrcus = findByCusno(cusno);
                cdrscusAdded.addAll(cdrscusBean.findByCusno(cusno));
                cdrivoAdded.addAll(cdrivoBean.findByCusno(cusno));

                Invwh invwh = invwhBean.findByWareh("JC" + cusno);//改
                if (invwh != null) {
                    Invwh v = new Invwh();
                    v.setFacno(facno2);
                    v.setProno(invwh.getProno());
                    v.setWareh(invwh.getWareh());
                    v.setWhdsc(invwh.getWhdsc());
                    v.setMrpco(invwh.getMrpco());
                    v.setCostyn(invwh.getCostyn());
                    v.setWclerk(invwh.getWclerk());
                    v.setUserno(invwh.getUserno());
                    v.setIndate(invwh.getIndate());
                    invwhAdded.add(v);
                    //仓管员
                    List<Invwhclk> invwhclks = invwhclkBean.findByWareh("JC" + cusno);
                    if (invwhclks != null && !invwhclks.isEmpty()) {
                        for (Invwhclk io : invwhclks) {
                            InvwhclkPK inpk = new InvwhclkPK();
                            inpk.setFacno(facno2);
                            inpk.setProno(io.getInvwhclkPK().getProno());
                            inpk.setWareh(io.getInvwhclkPK().getWareh());
                            inpk.setWclerk(io.getInvwhclkPK().getWclerk());

                            Invwhclk in = (Invwhclk) BeanUtils.cloneBean(io);
                            in.setInvwhclkPK(inpk);
                            invwhclkAdded.add(in);
                        }
                    }
                }

                List<Transwah> transwahs = transwahBean.findByCusno(cusno);
                if (transwahs != null && !transwahs.isEmpty()) {
                    for (Transwah ta : transwahs) {
                        TranswahPK tnpk = new TranswahPK();
                        tnpk.setFacno(facno2);
                        tnpk.setProno(ta.getTranswahPK().getProno());
                        tnpk.setTrseq(ta.getTranswahPK().getTrseq());
                        tnpk.setCusno(ta.getTranswahPK().getCusno());
                        tnpk.setCustype(ta.getTranswahPK().getCustype());

                        Transwah th = (Transwah) BeanUtils.cloneBean(ta);
                        th.setTranswahPK(tnpk);
                        transwahAdded.add(th);
                    }
                }
                //客户代号
                Miscode code = miscodeBean.findByPK("CA", cusno);
                if (code != null) {
                    miscodeAdded.add(code);
                }
                //集团代号
                Miscode group = miscodeBean.findByPK("CB", cdrcus.getCusgroup());
                if (group != null) {
                    miscodeAdded.add(group);
                }
                Cdrcusman man = cdrcusmanBean.findByPK(facno1, cusno);
                if (man != null) {
                    CdrcusmanPK mpk = new CdrcusmanPK();
                    mpk.setFacno(facno2);
                    mpk.setCusno(man.getCdrcusmanPK().getCusno());
                    Cdrcusman m = (Cdrcusman) BeanUtils.cloneBean(man);
                    m.setCdrcusmanPK(mpk);
                    cdrcusmanAdded.add(m);
                }
                setCompany(facno2);
                cdrcusmanBean.setCompany(facno2);
                cdrivoBean.setCompany(facno2);
                cdrscusBean.setCompany(facno2);
                miscodeBean.setCompany(facno2);
                invwhBean.setCompany(facno2);
                invwhclkBean.setCompany(facno2);
                transwahBean.setCompany(facno2);
                if (cdrcus != null) {
                    persist(cdrcus, detailAdded);
                    resetObjects();
                } else {
                    throw new NullPointerException("客户资料不存在");
                }
            }
            return true;
        } catch (Exception ex) {
            resetObjects();
            log4j.error(ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Boolean initByOAPSN(String psn) {

        String facno, code, newcusno;

        HKYX006 oa = beanHKYX006.findByPSN(psn);
        if (oa == null) {
            throw new NullPointerException();
        }
        CRMGG crmgg = beanCRMGG.findById(oa.getGg001());
        //放开限制,允许无CRM资料就可以新增客户 C0160 2016/9/2
        //if (crmgg == null) {
        //    throw new NullPointerException();
        //}
        switch (oa.getFacno()) {
            //SHB和分公司统一到SHB下
            case "C":
            case "G":
            case "J":
            case "N":
            case "C4":
                facno = "C";
                code = "S";
                break;
            default:
                facno = oa.getFacno();
                code = facno;
        }
        //增加检查避免重复抛转
        setCompany(facno);
        Cdrcus e = this.findByCusds(oa.getGg004());
        if (e != null) {
            oa.setPz(e.getCusno());
            beanHKYX006.update(oa);
            return true;
        }

        detailAdded.put(transwahBean, transwahAdded);
        detailAdded.put(invwhclkBean, invwhclkAdded);
        detailAdded.put(invwhBean, invwhAdded);
        detailAdded.put(cdrcusmanBean, cdrcusmanAdded);
        detailAdded.put(cdrscusBean, cdrscusAdded);
        detailAdded.put(cdrivoBean, cdrivoAdded);
        detailAdded.put(miscodeBean, miscodeAdded);

        cdrcus = new Cdrcus();
        cdrcus.setPrnyn('N');
        cdrcus.setDecode(oa.getDecode().charAt(0));
        cdrcus.setCusna(oa.getGg003());
        cdrcus.setCusds(oa.getGg004());
        cdrcus.setCusdse(oa.getGg105());
        cdrcus.setCussta(oa.getCussta().charAt(0));
        cdrcus.setDecode(oa.getDecode().charAt(0));
        cdrcus.setCuskind(oa.getGg011());
        cdrcus.setDmcode(oa.getDmcode().charAt(0));
        if (oa.getGg036().length() <= 40) {
            cdrcus.setAddress1(oa.getGg036());
        } else if (oa.getGg036().length() > 40) {
            String str = oa.getGg036();
            str = str.replace('(', '（');
            str = str.replace(')', '）');
            String str1 = str.substring(0, 40);
            String[] split = str.split(str1);
            cdrcus.setAddress1(str1);
            cdrcus.setAddress2(split[1]);
        }
        cdrcus.setUniform(oa.getGg030());
        cdrcus.setBilnum(oa.getGg109());
        cdrcus.setCoin(oa.getGg084());
        cdrcus.setTax(oa.getGg098().charAt(0));
        cdrcus.setSndcode(oa.getSndcode());
        cdrcus.setPaycode(oa.getGg113().charAt(0));
        cdrcus.setTermcode(oa.getGg112());
        cdrcus.setHandays1(oa.getHandays1().shortValue());
        cdrcus.setSacode(oa.getGg009());
        cdrcus.setAreacode(oa.getGg008());
        cdrcus.setCuycode(oa.getGg010());
        cdrcus.setBoss(oa.getGg018());
        cdrcus.setContactman(oa.getContactman());
        cdrcus.setTel1(oa.getGg024());
        cdrcus.setFax(oa.getGg027());
        cdrcus.setBegdate(oa.getGg017());
        if (oa.getGg031() != null) {
            cdrcus.setCapamt(oa.getGg031().longValue());
        }
        cdrcus.setCusbakna(oa.getCusbakna());
        cdrcus.setCusacctno(oa.getCusacctno());
        cdrcus.setSkfs(oa.getSkfs2());
        cdrcus.setIndate(BaseLib.getDate());
        cdrcus.setUserno(oa.getGg078());
        cdrcus.setShr("mis");
        cdrcus.setShzt("Y");

        newcusno = getFormId(cdrcus.getIndate(), code + cdrcus.getCuycode(), null, 5, "cdrcus", "cusno");
        cdrcus.setCusno(newcusno);
        if (oa.getCusgroup() == null || "".equals(oa.getCusgroup())) {
            cdrcus.setCusgroup(newcusno);//集团代号
        } else {
            cdrcus.setCusgroup(oa.getCusgroup());
        }

        //生成发票客户资料
        Cdrivo i = new Cdrivo(newcusno, (short) 1, newcusno);
        i.setCusna(cdrcus.getCusna());
        i.setAddress1(cdrcus.getAddress1());
        i.setAddress2(cdrcus.getAddress2());
        i.setAddress3(cdrcus.getAddress3());
        i.setAddress4(cdrcus.getAddress4());
        i.setAddress5(cdrcus.getAddress5());
        i.setUniform(cdrcus.getUniform());
        i.setDifcode('1');
        i.setIvoyn('Y');
        i.setIndate(cdrcus.getIndate());
        i.setUserno(cdrcus.getUserno());

        //生成指配客户资料
        Cdrscus s = new Cdrscus(newcusno, (short) 1);
        s.setShpcusno(newcusno);
        s.setCusna(cdrcus.getCusna());
        s.setAddress1(cdrcus.getAddress1());
        s.setAddress2(cdrcus.getAddress2());
        s.setAddress3(cdrcus.getAddress3());
        s.setAddress4(cdrcus.getAddress4());
        s.setAddress5(cdrcus.getAddress5());
        s.setAreacode(cdrcus.getAreacode());
        s.setCuycode(cdrcus.getCuycode());
        s.setZonecode(cdrcus.getZonenum());
        s.setTel(cdrcus.getTel1());
        s.setFax(cdrcus.getFax());
        s.setShpyn('Y');
        s.setContactman(cdrcus.getContactman());
        s.setIndate(cdrcus.getIndate());
        s.setUserno(cdrcus.getUserno());

        //生成负责业务
        Cdrcusman m = new Cdrcusman(facno, newcusno);
        m.setMan(oa.getSalesman());
        m.setLatdate(cdrcus.getIndate());

        //生成借客户仓
        Invwh w = new Invwh();
        w.setFacno(facno);
        w.setProno("1");
        w.setWareh("JC" + newcusno);
        if (cdrcus.getCusna().length() < 6) {
            w.setWhdsc("借-" + cdrcus.getCusna());
        } else {
            w.setWhdsc("借-" + cdrcus.getCusna().substring(0, 5));
        }
        w.setMrpco('N');
        w.setCostyn('Y');
        w.setWclerk(m.getMan());
        w.setIndate(cdrcus.getIndate());
        w.setUserno("mis");

        //生成仓管员
        Invwhclk u = new Invwhclk(w.getFacno(), w.getProno(), w.getWareh(), w.getWclerk());
        u.setMainyn('Y');
        u.setIndate(cdrcus.getIndate());
        u.setUserno("mis");

        //生成客户周转仓资料
        Transwah t = new Transwah(w.getFacno(), w.getProno(), '2', newcusno, (short) 1);
        t.setWareh(w.getWareh());

        //生成miscode资料
        Miscode c = new Miscode("CA", newcusno);
        c.setCdesc(cdrcus.getCusna());
        c.setStatus('Y');
        c.setMascreyn('Y');
        c.setCusds(cdrcus.getCusds());

        //客户集团别如果不存在再新增
        Miscode g = miscodeBean.findByPK("CB", cdrcus.getCusgroup());

        cdrivoAdded.add(i);
        cdrscusAdded.add(s);
        cdrcusmanAdded.add(m);
        invwhAdded.add(w);
        invwhclkAdded.add(u);
        transwahAdded.add(t);
        miscodeAdded.add(c);
        if (g == null) {
            g = new Miscode("CB", newcusno);
            g.setCdesc(cdrcus.getCusna());
            g.setStatus('Y');
            g.setMascreyn('Y');
            g.setCusds(cdrcus.getCusds());
            miscodeAdded.add(g);
        }

        //放开限制,允许无CRM资料就可以新增客户 C0160 2016/9/2
        if (crmgg != null) {
            crmgg.setGg004(cdrcus.getCusds());
            crmgg.setGg008(cdrcus.getAreacode());
            crmgg.setGg009(cdrcus.getSacode());
            //crmgg.setGg010(cdrcus.getCuycode());//不需要抛转2017/2/20
            //crmgg.setGg011(cdrcus.getCuskind());
            crmgg.setGg011(cdrcus.getSndcode());
            crmgg.setGg013(cdrcus.getCuskind());
            crmgg.setGg017(BaseLib.formatDate("yyyyMMdd", cdrcus.getBegdate()));
            crmgg.setGg018(cdrcus.getBoss());
            crmgg.setGg024(cdrcus.getTel1());
            crmgg.setGg027(cdrcus.getFax());
            crmgg.setGg030(cdrcus.getUniform());
            if (cdrcus.getCapamt() != null) {
                crmgg.setGg031(BigDecimal.valueOf(cdrcus.getCapamt()));
            }
            crmgg.setGg036(oa.getGg036());
            crmgg.setGg043(newcusno);
            crmgg.setGg084(cdrcus.getCoin());
            //ERP与CRM定义不同
            switch (cdrcus.getTax()) {
                //外加税
                case '1':
                    crmgg.setGg089("A");
                    crmgg.setGg098("2");
                    crmgg.setGg109("S01");
                //零税
                case '2':
                    crmgg.setGg089("A");
                    crmgg.setGg098("3");
                    crmgg.setGg109("S01");
                    break;
                //免税
                //case '3':
                //内含
                case '4':
                    crmgg.setGg089("A");
                    crmgg.setGg098("1");
                    crmgg.setGg109("S02");
                default:
            }
            crmgg.setGg105(cdrcus.getCusdse());
            //交易类别字段形态不符
            //ERP与CRM定义不同
            switch (cdrcus.getPaycode()) {
                case '1':
                    //crmgg.setGg113('1');
                    crmgg.setGg091("1");
                    break;
                case '2':
                    //crmgg.setGg113('3');
                    crmgg.setGg091("3");
                    break;
                case '3':
                    //crmgg.setGg113('2');
                    crmgg.setGg091("2");
                    break;
                case '4':
                case '5':
                    //crmgg.setGg113('4');
                    crmgg.setGg091("4");
                    break;
                default:
                    //crmgg.setGg113('1');
                    crmgg.setGg091("1");
            }
            //交易条件
            switch (cdrcus.getTermcode()) {
                case "C&F":
                    crmgg.setGg112("3");
                    break;
                case "CIF":
                    crmgg.setGg112("1");
                    break;
                case "FOB":
                    crmgg.setGg112("2");
                    break;
                default:
                    crmgg.setGg112("3");
            }
            //回写更多内容
        }
        try {
            persist(cdrcus, detailAdded);
            getEntityManager().flush();

            if (crmgg != null) {
                beanCRMGG.update(crmgg);
                beanCRMGG.getEntityManager().flush();
            }

            oa.setPz(newcusno);
            beanHKYX006.update(oa);

            switch (oa.getFacno()) {
                case "G":
                    //同步广州ERP
                    resetFacno("G");
                    syncGZBean.persist(cdrcus, detailAdded);
                    syncGZBean.getEntityManager().flush();
                    break;
                case "J":
                    //同步济南ERP
                    resetFacno("J");
                    syncJNBean.persist(cdrcus, detailAdded);
                    syncJNBean.getEntityManager().flush();
                    break;
                case "N":
                    //同步南京ERP
                    resetFacno("N");
                    syncNJBean.persist(cdrcus, detailAdded);
                    syncNJBean.getEntityManager().flush();
                    break;
                case "C4":
                    //同步重庆ERP
                    resetFacno("C4");
                    syncCQBean.persist(cdrcus, detailAdded);
                    syncCQBean.getEntityManager().flush();
                    break;
                default:
            }
            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            return false;
        } finally {
            resetObjects();
        }
    }

    @Override
    public Boolean updateByOAPSN(String psn) {
        String facno;
        String origman = "";
        String newman = "";

        //获取OA客户修改资料
        HKYX007 oa = beanHKYX007.findByPSN(psn);
        if (oa == null) {
            throw new NullPointerException();
        }

        facno = oa.getFacno();

        //获取ERP客户资料
        this.setCompany(facno);
        cdrcus = this.findById(oa.getCusno());
        if (cdrcus == null) {
            throw new NullPointerException();
        }

        //获取CRM客户资料
        CRMGG crmgg = beanCRMGG.findByERPCusno(oa.getCusno());

        detailAdded.clear();
        detailAdded.put(cdrcusmanBean, cdrcusmanAdded);

        if (Objects.equals(oa.getChkcusds(), "1") && (oa.getCusds() != null) && !"".equals(oa.getCusds())) {
            cdrcus.setCusds(oa.getCusds());
            if (crmgg != null) {
                crmgg.setGg004(cdrcus.getCusds());
            }
        }
        if (Objects.equals(oa.getChkskfs(), "1") && (oa.getQtskfs() != null) && !"".equals(oa.getQtskfs())) {
            cdrcus.setSkfs(oa.getQtskfs());
            if (crmgg != null) {

            }
        }
        if (Objects.equals(oa.getChkaddress(), "1") && (oa.getAddress() != null) && !"".equals(oa.getAddress())) {
            if (oa.getAddress().length() <= 40) {
                cdrcus.setAddress1(oa.getAddress());
            } else if (oa.getAddress().length() > 40) {
                cdrcus.setAddress1(oa.getAddress().substring(0, 40));
                cdrcus.setAddress2(oa.getAddress().substring(40));
            }
            if (crmgg != null) {
                crmgg.setGg036(oa.getAddress());
            }
        }
        if (Objects.equals(oa.getChkcusbakna(), "1") && (oa.getCusbakna() != null) && !"".equals(oa.getCusbakna())) {
            cdrcus.setCusbakna(oa.getCusbakna());
        }
        if (Objects.equals(oa.getChkcusacctno(), "1") && (oa.getCusacctno() != null) && !"".equals(oa.getCusacctno())) {
            cdrcus.setCusacctno(oa.getCusacctno());
        }
        if (Objects.equals(oa.getChkuniform(), "1") && (oa.getUniform() != null) && !"".equals(oa.getUniform())) {
            cdrcus.setUniform(oa.getUniform());
            if (crmgg != null) {
                crmgg.setGg030(cdrcus.getUniform());
            }
        }
        if (Objects.equals(oa.getChkcontactman(), "1") && (oa.getContactman() != null) && !"".equals(oa.getContactman())) {
            cdrcus.setContactman(oa.getContactman());
            if (crmgg != null) {
                crmgg.setGg018(cdrcus.getContactman());
            }
        }
        if (Objects.equals(oa.getChktel1(), "1") && (oa.getTel1() != null) && !"".equals(oa.getTel1())) {
            cdrcus.setTel1(oa.getTel1());
            if (crmgg != null) {
                crmgg.setGg024(cdrcus.getTel1());
            }
        }
        if (Objects.equals(oa.getChkfax(), "1") && (oa.getFax() != null) && !"".equals(oa.getFax())) {
            cdrcus.setFax(oa.getFax());
            if (crmgg != null) {
                crmgg.setGg027(cdrcus.getFax());
            }
        }
        if (oa.getCbtickdays().equals("1")) {
            cdrcus.setTickdays(oa.getTickdays());
        }
        if (Objects.equals(oa.getChkman(), "1") && (oa.getMan() != null) && !"".equals(oa.getMan())) {
            cdrcusmanBean.setCompany(facno);
            //删除原来负责业务
            Cdrcusman m;
            m = cdrcusmanBean.findByPK(facno, oa.getCusno());
            if (m != null) {
                origman = m.getMan();
                cdrcusmanBean.delete(m);
                cdrcusmanBean.getEntityManager().flush();
                switch (facno) {
                    case "G":
                    case "J":
                    case "N":
                    case "C4":
                        //分公司发起,同步删除SHB_ERP中的负责业务信息
                        cdrcusmanBean.setCompany("C");
                        m = cdrcusmanBean.findByPK("C", oa.getCusno());
                        if (m != null) {
                            syncSHBBean.delete(m, null);
                            syncSHBBean.getEntityManager().flush();
                        }
                        break;
                    default:
                }
            }
            cdrcusmanBean.setCompany(facno);
            //创建新的负责业务
            m = new Cdrcusman(facno, oa.getCusno());
            m.setMan(oa.getMan());
            m.setLatdate(BaseLib.getDate());
            cdrcusmanAdded.add(m);

            newman = m.getMan();

            if (crmgg != null) {
                crmgg.setGg078(oa.getMan());
            }
        }

        try {
            //更新ERP客户资料
            updateForERP(cdrcus, detailAdded, null, null);
            if (!"".equals(origman) && !"".equals(newman)) {
                //更新ERP-armhad对应的负责业务
                updateSalesManInArmhad(cdrcus.getCusno(), origman, newman);
            }
            getEntityManager().flush();
            switch (facno) {
                case "G":
                case "J":
                case "N":
                case "C4":
                    //分公司发起,同步SHB_ERP
                    resetFacno("C");
                    syncSHBBean.update(cdrcus, detailAdded, null, null);
                    syncSHBBean.getEntityManager().flush();
                    break;
                default:
            }
            //更新CRM客户资料
            if (crmgg != null) {
                beanCRMGG.update(crmgg);
            }

            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            return false;
        } finally {
            resetObjects();
        }

    }

    protected void resetFacno(String facno) {
        for (Cdrcusman m : cdrcusmanAdded) {
            m.getCdrcusmanPK().setFacno(facno);
        }
        for (Invwh w : invwhAdded) {
            w.setFacno(facno);
        }
        for (Invwhclk u : invwhclkAdded) {
            u.getInvwhclkPK().setFacno(facno);
        }
        for (Transwah t : transwahAdded) {
            t.getTranswahPK().setFacno(facno);
        }
    }

    protected void resetObjects() {
        if (cdrivoAdded != null && !cdrivoAdded.isEmpty()) {
            cdrivoAdded.clear();
        }
        if (cdrscusAdded != null && !cdrscusAdded.isEmpty()) {
            cdrscusAdded.clear();
        }
        if (cdrcusmanAdded != null && !cdrcusmanAdded.isEmpty()) {
            cdrcusmanAdded.clear();
        }
        if (invwhAdded != null && !invwhAdded.isEmpty()) {
            invwhAdded.clear();
        }
        if (invwhclkAdded != null && !invwhclkAdded.isEmpty()) {
            invwhclkAdded.clear();
        }
        if (transwahAdded != null && !transwahAdded.isEmpty()) {
            transwahAdded.clear();
        }
        if (miscodeAdded != null && !miscodeAdded.isEmpty()) {
            miscodeAdded.clear();
        }
        if (detailAdded != null) {
            detailAdded.clear();
        }
    }

    //更新应收账款立账表中的负责业务
    public int updateSalesManInArmhad(String cusno, String origValue, String newValue) {
        Query query = getEntityManager().createNativeQuery("update armhad set mancode = ?1 where mancode = ?2 and cusno = ?3 and (booamt - recamt > 0)");
        query.setParameter(1, newValue);
        query.setParameter(2, origValue);
        query.setParameter(3, cusno);
        return query.executeUpdate();
    }

}
