/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invwh;
import cn.hanbell.erp.entity.Invwhclk;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.erp.entity.PurvdrBuyer;
import cn.hanbell.erp.entity.PurvdrBuyerPK;
import cn.hanbell.oa.ejb.HKCG016Bean;
import cn.hanbell.oa.ejb.HKCG017Bean;
import cn.hanbell.oa.ejb.HKCG006Bean;
import cn.hanbell.oa.ejb.HKJH004Bean;
import cn.hanbell.oa.entity.HKCG016;
import cn.hanbell.oa.entity.HKCG017;
import cn.hanbell.oa.entity.HKCG006;
import cn.hanbell.oa.entity.HKJH004;
import cn.hanbell.oa.entity.HKJH004Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author C1368
 */
@Stateless
@LocalBean
public class PurvdrBean extends SuperEJBForERP<Purvdr> {

    @EJB
    private PurvdrBuyerBean purvdrBuyerBean;

    private final HashMap<SuperEJBForERP, List<?>> details = new HashMap<>();

    private final List<PurvdrBuyer> purvdrBuyerList = new ArrayList<>();
    private final List<Miscode> miscodeAdded = new ArrayList<>();
    private final List<Invwh> invwhAdded = new ArrayList<>();
    private final List<Invwhclk> invwhclkAdded = new ArrayList<>();

    @EJB
    private HKCG006Bean beanHKCG006;
    @EJB
    private HKCG016Bean beanHKCG016;
    @EJB
    private HKCG017Bean beanHKCG017;
    @EJB
    private HKJH004Bean beanHKJH004;
    @EJB
    private InvwhBean invwhBean;
    @EJB
    private InvwhclkBean invwhclkBean;
    @EJB
    private SyncGZBean syncGZBean;
    @EJB
    private SyncJNBean syncJNBean;
    @EJB
    private SyncNJBean syncNJBean;
    @EJB
    private SyncCQBean syncCQBean;
    @EJB
    private SyncZKBean syncZKBean;
    @EJB
    private SyncYCBean syncYCBean;

    private Purvdr purvdr;

    public PurvdrBean() {
        super(Purvdr.class);
    }

    public Boolean cloneByOAHKJH004(String psn) {
        // 定义表头
        HKJH004 h = beanHKJH004.findByPSN(psn);
        // 判断当前表是否存在
        if (h == null) {
            throw new NullPointerException(psn + "不存在");
        }
        List<HKJH004Detail> detailList = beanHKJH004.findDetail(h.getFormSerialNumber());
        try {
            // 判断当前detail里是否为空
            String facno1, facno2, vdrno;
            facno1 = h.getFacno1();
            facno2 = h.getFacno2();
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException("厂商明细表不存在!");
            }
            // 当前对象的处理
            details.put(purvdrBuyerBean, purvdrBuyerList);
            details.put(miscodeBean, miscodeAdded);
            // 循环detail里的数据
            for (HKJH004Detail v : detailList) {
                vdrno = v.getVdrno();
                setCompany(facno2);
                purvdr = findByVdrno(vdrno);// 确认厂商是否已存在
                if (purvdr != null) {// 不为空就不做处理继续执行
                    continue;
                }
                // 设置为来源公司
                setCompany(facno1);
                purvdrBuyerBean.setCompany(facno1);
                miscodeBean.setCompany(facno1);
                // 取出数据
                purvdr = findByVdrno(vdrno);
                List<PurvdrBuyer> purvdrby = purvdrBuyerBean.findByVdrno(vdrno);
                if (purvdrby != null && !purvdrby.isEmpty()) {
                    for (PurvdrBuyer pb : purvdrby) {
                        PurvdrBuyerPK pbpk = new PurvdrBuyerPK();
                        pbpk.setFacno(facno2);
                        pbpk.setProno(pb.getPurvdrBuyerPK().getProno());
                        pbpk.setVdrno(pb.getPurvdrBuyerPK().getVdrno());
                        PurvdrBuyer pby = (PurvdrBuyer) BeanUtils.cloneBean(pb);
                        pby.setPurvdrBuyerPK(pbpk);
                        purvdrBuyerList.add(pby);
                    }
                }
                Miscode code = miscodeBean.findByPK("PJ", vdrno);
                if (code != null) {
                    miscodeAdded.add(code);
                }
                // 设置为目的公司
                setCompany(facno2);
                purvdrBuyerBean.setCompany(facno2);
                miscodeBean.setCompany(facno2);

                persist(purvdr, details);// 新增到这个目的公司去
                getEntityManager().flush();
                resetObjects();// 如果循环之后，存在前一个对象的数据，就用这个方法清除
            }
        } catch (Exception ex) {
            resetObjects();
            log4j.error(ex);
            throw new RuntimeException(ex);
        } finally {
            details.clear();
        }
        return true;
    }

    public Purvdr findByVdrno(String vdrno) {
        Query query = getEntityManager().createNamedQuery("Purvdr.findByVdrno");
        query.setParameter("vdrno", vdrno);
        try {
            return (Purvdr) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public Purvdr findByVdrds(String vdrds) {
        Query query = getEntityManager().createNamedQuery("Purvdr.findByVdrds");
        query.setParameter("vdrds", vdrds);
        try {
            return (Purvdr) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Boolean initByOAPSN(String psn) {
        details.put(purvdrBuyerBean, purvdrBuyerList);
        details.put(miscodeBean, miscodeAdded);
        details.put(invwhBean, invwhAdded);
        details.put(invwhclkBean, invwhclkAdded);
        HKCG016 oa = beanHKCG016.findByPSN(psn);
        if (oa == null) {
            throw new NullPointerException();
        }

        Purvdr erp = new Purvdr();

        String facno, code, newvdrno;
        switch (oa.getFacno()) {
            // SHB和分公司统一到SHB下
            case "C":
            case "G":
            case "J":
            case "N":
            case "C4":
            case "C5":
            case "L":
                facno = "C";
                code = "S";
                break;
            default:
                facno = oa.getFacno();
                code = facno;
        }
        // 增加检查避免重复抛转
        setCompany(facno);
        Purvdr e = this.findByVdrds(oa.getVdrds());
        if (e != null) {
            oa.setVdrno(e.getVdrno());
            beanHKCG016.update(oa);
            return true;
        }

        Miscode m;
        miscodeBean.setCompany(facno);
        m = miscodeBean.findByCkindAndCdesc("NB", oa.getTtbankna());
        if (m == null) {
            m = new Miscode("NB", miscodeBean.getFormId("NB", "B", 5));
            m.setCdesc(oa.getTtbankna());
            m.setStatus('Y');
            m.setMascreyn('N');
            m.setCusds(oa.getTtbankna());
            miscodeBean.persist(m);
        }

        erp.setVdrna(oa.getVdrna());
        if (oa.getVdrsta() != null && !oa.getVdrsta().equals("")) {
            erp.setVdrsta(oa.getVdrsta().charAt(0));
        }
        erp.setVdrds(oa.getVdrds());
        erp.setVdrdse(oa.getVdrdse());
        erp.setAddress(oa.getAddress());
        if (oa.getDecode() != null && !oa.getDecode().equals("")) {
            erp.setDecode(oa.getDecode().charAt(0));
        }
        erp.setZonenum(oa.getZonenum());
        erp.setCoin(oa.getCoin());
        erp.setTax(oa.getTax());
        if (oa.getTaxrate() != null && !oa.getTaxrate().equals("")) {
            erp.setTaxrate(BigDecimal.valueOf(Double.parseDouble(oa.getTaxrate())));
        }
        erp.setUniform(oa.getUniform());
        erp.setPurkind(oa.getPurkind());
        erp.setTermcode(oa.getTermcode());
        erp.setAreacode(oa.getAreacode());
        if (oa.getPaycom() != null && !oa.getPaycom().equals("")) {
            erp.setPaycom(oa.getPaycom().charAt(0));
        }
        erp.setCuycode(oa.getCuycode());
        if (oa.getPaycode() != null && !oa.getPaycode().equals("")) {
            erp.setPaycode(oa.getPaycode().charAt(0));
        }
        if (oa.getTickdays() != null && !oa.getTickdays().equals("")) {
            erp.setTickdays(Short.valueOf(oa.getTickdays()));
        }
        erp.setBoss(oa.getBoss());
        erp.setMark1(oa.getMark1());
        erp.setSndcode(oa.getSndcode());
        erp.setContactman(oa.getContactman());
        erp.setTtbankno(m.getMiscodePK().getCode());
        erp.setTtbankna(oa.getTtbankna());
        erp.setTtbanknum(oa.getTtbanknum());
        erp.setTtname(oa.getTtname());
        if (oa.getYeramt() != null && !oa.getYeramt().equals("")) {
            erp.setYeramt(BigDecimal.valueOf(Double.parseDouble(oa.getYeramt())));
        }
        if (oa.getCapamt() != null && !oa.getCapamt().equals("")) {
            erp.setCapamt(BigDecimal.valueOf(Double.parseDouble(oa.getCapamt())));
        }
        erp.setTel1(oa.getTel1());
        erp.setTel2(oa.getTel2());
        erp.setWebsite(oa.getWebsite());
        if (oa.getAbccode() != null && !oa.getAbccode().equals("")) {
            erp.setAbccode(oa.getAbccode().charAt(0));
        }
        erp.setFax1(oa.getFax1());
        erp.setFax2(oa.getFax2());
        erp.setBegdate(oa.getBegdate());
        erp.setLatdate(oa.getLatdate());
        erp.setTitle(oa.getTitle());
        erp.setFkfs(oa.getFktype());
        erp.setPaysepcode('1');
        erp.setHandays1((short) 30);

        // 生成厂商编号
        newvdrno = getFormId(BaseLib.getDate(), code + erp.getCuycode(), null, 5, "purvdr", "vdrno");
        erp.setVdrno(newvdrno);

        // 生成采购员
        PurvdrBuyer b = new PurvdrBuyer(facno, "1", newvdrno);
        b.setBuyer(oa.getUserno());

        // 生成借客户仓
        if ("Y".equals(oa.getIsvdrwareh())) {
            Invwh w = new Invwh();
            w.setFacno(facno);
            w.setProno("1");
            w.setWareh("JT" + newvdrno);
            if (erp.getVdrna().length() < 3) {
                w.setWhdsc("借厂商-" + erp.getVdrna());
            } else {
                // 规则是只取两位名称
                if (erp.getVdrna().length() <= 4) {
                    w.setWhdsc("借厂商-" + erp.getVdrna().substring(2));
                } else if (erp.getVdrna().length() > 4) {
                    w.setWhdsc("借厂商-" + erp.getVdrna().substring(2, 4));
                }

            }
            w.setMrpco('N');
            w.setCostyn('Y');
            w.setWclerk(oa.getJtwareher());
            w.setIndate(BaseLib.getDate());
            w.setUserno("mis");
            invwhAdded.add(w);

            // 生成仓管员
            Invwhclk u = new Invwhclk(w.getFacno(), w.getProno(), w.getWareh(), w.getWclerk());
            u.setMainyn('Y');
            u.setIndate(BaseLib.getDate());
            u.setUserno("mis");
            invwhclkAdded.add(u);
        }

        // 生成MISCODE资料
        Miscode c = new Miscode("PJ", newvdrno);
        c.setCdesc(erp.getVdrna());
        c.setStatus('Y');
        c.setMascreyn('Y');
        c.setCusds(erp.getVdrds());

        purvdrBuyerList.add(b);
        miscodeAdded.add(c);

        try {
            persist(erp, details);
            getEntityManager().flush();

            oa.setVdrno(newvdrno);
            beanHKCG016.update(oa);

            switch (oa.getFacno()) {
                case "G":
                    // 同步广州ERP
                    resetFacno("G");
                    syncGZBean.persist(erp, details);
                    syncGZBean.getEntityManager().flush();
                    break;
                case "J":
                    // 同步济南ERP
                    resetFacno("J");
                    syncJNBean.persist(erp, details);
                    syncJNBean.getEntityManager().flush();
                    break;
                case "N":
                    // 同步南京ERP
                    resetFacno("N");
                    syncNJBean.persist(erp, details);
                    syncNJBean.getEntityManager().flush();
                    break;
                case "C4":
                    // 同步重庆ERP
                    resetFacno("C4");
                    syncCQBean.persist(erp, details);
                    syncCQBean.getEntityManager().flush();
                    break;
                case "C5":
                    // 同步银川汉钟ERP
                    resetFacno("C5");
                    syncYCBean.persist(erp, details);
                    syncYCBean.getEntityManager().flush();
                    break;
                case "L":
                    // 同步真空ERP
                    resetFacno("L");
                    syncZKBean.persist(erp, details);
                    syncZKBean.getEntityManager().flush();
                    break;
                default:
            }
            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            return false;
        } finally {
            resetObjects();
            details.clear();
        }

    }

    // 撤销供应商 by C1749 2018/3/28
    public boolean refuseByOAHKCG006(String psn) {
        // 定义表头
        HKCG006 oa = beanHKCG006.findByPSN(psn);
        // 判断当前表是否存在
        if (oa == null) {
            throw new NullPointerException(psn + "不存在");
        }
        String facno, code;
        facno = oa.getFacno();
        switch (facno) {
            // SHB和分公司统一到SHB下
            case "C":
            case "G":
            case "J":
            case "N":
            case "C4":
            case "C5":
            case "L":
                facno = "C";
                code = "S";
                break;
            default:
                facno = oa.getFacno();
                code = facno;
        }
        if (oa.getRbtn1().equals("2") && oa.getRbtn2().equals("2")) {
            try {
                setCompany(facno);
                Purvdr erp;
                erp = this.findByVdrno(oa.getSupno());
                if (erp != null) {
                    erp.setVdrsta('3');
                    update(erp);
                }
                miscodeBean.setCompany(facno);
                Miscode miscode = miscodeBean.findByPK("PJ", oa.getSupno());
                if (miscode != null) {
                    miscode.setStatus('N');
                    miscodeBean.update(miscode);
                }
                getEntityManager().flush();
                switch (oa.getFacno()) {
                    case "G":
                        // 同步广州ERP
                        syncGZBean.update(erp, null);
                        syncGZBean.getEntityManager().flush();
                        break;
                    case "J":
                        // 同步济南ERP
                        syncJNBean.update(erp, null);
                        syncJNBean.getEntityManager().flush();
                        break;
                    case "N":
                        // 同步南京ERP
                        syncNJBean.update(erp, null);
                        syncNJBean.getEntityManager().flush();
                        break;
                    case "C4":
                        // 同步重庆ERP
                        syncCQBean.update(erp, null);
                        syncCQBean.getEntityManager().flush();
                        break;
                    case "C5":
                        // 同步银川ERP
                        syncYCBean.update(erp, null);
                        syncYCBean.getEntityManager().flush();
                        break;
                    case "L":
                        // 同步真空ERP
                        syncZKBean.update(erp, null);
                        syncZKBean.getEntityManager().flush();
                        break;
                    default:
                }
                return true;
            } catch (Exception ex) {
                log4j.error(ex);
                return false;
            } finally {
                resetObjects();
                details.clear();
            }
        }
        return true;
    }

    protected void resetFacno(String facno) {
        for (PurvdrBuyer b : purvdrBuyerList) {
            b.getPurvdrBuyerPK().setFacno(facno);
        }
    }

    protected void resetObjects() {
        if (purvdrBuyerList != null && !purvdrBuyerList.isEmpty()) {
            purvdrBuyerList.clear();
        }
        if (miscodeAdded != null && !miscodeAdded.isEmpty()) {
            miscodeAdded.clear();
        }
        if (invwhAdded != null && !invwhAdded.isEmpty()) {
            invwhAdded.clear();
        }
        if (invwhclkAdded != null && !invwhclkAdded.isEmpty()) {
            invwhclkAdded.clear();
        }
    }

    @Override
    public Boolean updateByOAPSN(String psn) {
        details.put(purvdrBuyerBean, purvdrBuyerList);
        HKCG017 oa = beanHKCG017.findByPSN(psn);
        if (oa == null) {
            throw new NullPointerException();
        }

        String facno, code, newvdrno;
        switch (oa.getFacno()) {
            // SHB和分公司统一到SHB下
            case "C":
            case "G":
            case "J":
            case "N":
            case "C4":
            case "C5":
            case "L":
                facno = "C";
                code = "S";
                break;
            default:
                facno = oa.getFacno();
                code = facno;
        }
        setCompany(facno);
        Purvdr erp;
        erp = this.findById(oa.getVdrno());
        if (erp == null) {
            throw new NullPointerException();
        }
        if ("1".equals(oa.getCheckbox11())) {
            Miscode m;
            miscodeBean.setCompany(facno);
            m = miscodeBean.findByCkindAndCdesc("NB", oa.getTtbankna());
            if (m == null) {
                m = new Miscode("NB", miscodeBean.getFormId("NB", "B", 5));
                m.setCdesc(oa.getTtbankna());
                m.setStatus('Y');
                m.setMascreyn('N');
                m.setCusds(oa.getTtbankna());
                miscodeBean.persist(m);
                erp.setTtbankna(oa.getTtbankna());
                erp.setTtbankno(m.getMiscodePK().getCode());
            }
        }
        if (oa.getBvdrds().equals("1")) {
            erp.setVdrds(oa.getVdrds());
        }
        if (oa.getBfkfs().equals("1")) {
            erp.setFkfs(oa.getFktype());
        }
        if (oa.getCheckbox10().equals("1")) {
            erp.setAddress(oa.getAddress());
        }
        if (oa.getCheckbox12().equals("1")) {
            erp.setTtbanknum(oa.getTtbanknum());
        }
        if (oa.getCheckbox13().equals("1")) {
            erp.setUniform(oa.getUniform());
        }
        if (oa.getCheckbox14().equals("1")) {
            erp.setContactman(oa.getContactman());
        }
        if (oa.getCheckbox15().equals("1")) {
            erp.setTel1(oa.getTel1());
        }
        if (oa.getCheckbox16().equals("1")) {
            erp.setTel2(oa.getTel2());
        }
        if (oa.getCheckbox17().equals("1")) {
            erp.setFax1(oa.getFax1());
        }
        if (oa.getCheckbox19().equals("1")&& oa.getVdrsta() != null && !oa.getVdrsta().equals("")) {
            erp.setVdrsta(oa.getVdrsta().charAt(0));
        }
        if (oa.getCbtickdays().equals("1")) {
            erp.setTickdays(oa.getTickdays());
        }
        if (oa.getChkpaycode().equals("1") && oa.getPaycode() != null && !"0".equals(oa.getPaycode())) {
            erp.setPaycode(oa.getPaycode().charAt(0));
        }

        try {
            update(erp);
            getEntityManager().flush();

            switch (oa.getFacno()) {
                case "G":
                    // 同步广州ERP
                    // resetFacno("G");
                    syncGZBean.update(erp, null);
                    syncGZBean.getEntityManager().flush();
                    break;
                case "J":
                    // 同步济南ERP
                    // resetFacno("J");
                    syncJNBean.update(erp, null);
                    syncJNBean.getEntityManager().flush();
                    break;
                case "N":
                    // 同步南京ERP
                    // resetFacno("N");
                    syncNJBean.update(erp, null);
                    syncNJBean.getEntityManager().flush();
                    break;
                case "C4":
                    // 同步重庆ERP
                    // resetFacno("C4");
                    syncCQBean.update(erp, null);
                    syncCQBean.getEntityManager().flush();
                    break;
                case "C5":
                    // 同步银川ERP
                    // resetFacno("C5");
                    syncYCBean.update(erp, null);
                    syncYCBean.getEntityManager().flush();
                    break;
                case "L":
                    // 同步真空ERP
                    // resetFacno("L");
                    syncZKBean.update(erp, null);
                    syncZKBean.getEntityManager().flush();
                    break;
                default:
            }
            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            return false;
        } finally {
            resetObjects();
            details.clear();
        }
    }

}
