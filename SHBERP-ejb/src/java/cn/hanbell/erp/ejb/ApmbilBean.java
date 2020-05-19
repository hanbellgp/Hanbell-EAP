/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.entity.Apmbil;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmapd;
import cn.hanbell.erp.entity.Apmaph;
import cn.hanbell.erp.entity.ApmbilPK;
import cn.hanbell.erp.entity.Apmpur;
import cn.hanbell.erp.entity.ApmpurPK;
import cn.hanbell.erp.entity.Apmpyh;
import cn.hanbell.erp.entity.Apmtbil;
import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.ejb.SHBERPAPM811Bean;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.oa.entity.SHBERPAPM811;
import cn.hanbell.oa.entity.SHBERPAPM811Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ApmbilBean extends SuperEJBForERP<Apmbil> {

    @EJB
    private SHBERPAPM811Bean shberpapm811Bean;
    @EJB
    private ApmaphBean apmaphBean;
    @EJB
    private ApmapdBean apmapdBean;
    @EJB
    private ApmtbilBean apmtbilBean;
    @EJB
    private ApmpurBean apmpurBean;
    @EJB
    private MisBean misBean;
    @EJB
    private MisdecBean misdecBean;
    @EJB
    private InvtrnhBean invtrnhBean;
    @EJB
    private ApmsysBean apmsysBean;
    @EJB
    private ApmpyhBean apmpyhBean;
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

    public Boolean initByOAAPM811(String psn) {
        try {
            SHBERPAPM811 oah = shberpapm811Bean.findByPSN(psn);
            if (oah == null) {
                throw new NullPointerException();
            }
            Apmbil a;
            ApmbilPK apk;
            String apno;
            String facno;
            String aptyp;
            String locoin;
            String ls_acpno;
            String ls_bilno;
            String ls_preyrmth;
            String ls_itnbr;
            String ls_ogdkid_r;
            String ls_subtrtype;
            Character ls_trapyh;
            Date ldt_apmdat, ld_start, ld_end;
            int li_decl, li_decs;
            int li_mth;
            BigDecimal ldc_acpamtfs, ldc_acpamt;
            BigDecimal ldc_apmamtfs, ldc_apmamt;
            BigDecimal ldc_resttaxfs, ldc_resttax;
            BigDecimal ldc_biltaxfs, ldc_biltax;
            BigDecimal ldc_thamtfs, ldc_thamt;
            BigDecimal ldc_thtaxfs, ldc_thtax;
            BigDecimal ldc_ivops;
            BigDecimal ldc_ivoms;
            BigDecimal ldc_ivopsfs;
            BigDecimal ldc_ivomsfs;

            facno = oah.getFacno();
            apno = oah.getApno();
            aptyp = oah.getAptyp();

            Calendar cl = Calendar.getInstance();
            this.setCompany(facno);
            List<SHBERPAPM811Detail> oads = shberpapm811Bean.getDetailList(oah.getFormSerialNumber());
            if (oads != null && !oads.isEmpty()) {
                ldc_acpamt = BigDecimal.ZERO;
                ldc_acpamtfs = BigDecimal.ZERO;
                ldc_thtaxfs = BigDecimal.ZERO;
                ldc_thtax = BigDecimal.ZERO;
                Map<String, BigDecimal> macpamt = new HashMap<>();
                Map<String, BigDecimal> macpamtfs = new HashMap<>();
                apmaphBean.setCompany(facno);
                apmtbilBean.setCompany(facno);
                misBean.setCompany(facno);
                misdecBean.setCompany(facno);
                apmpyhBean.setCompany(facno);
                apmsysBean.setCompany(facno);
                invtrnhBean.setCompany(facno);
                apmpurBean.setCompany(facno);
                Apmaph erph = apmaphBean.findByPK(facno, apno, aptyp);
                List<Apmapd> apmapds = apmaphBean.findNeedThrowDetail(facno, apno, aptyp);
                ldt_apmdat = erph.getApdate();
                locoin = misBean.findAll().get(0).getCoinno();
                li_decl = misdecBean.findAll().get(0).getAmtdec();
                li_decs = misdecBean.findAll().get(0).getAmtfsdec();
                ld_start = ldt_apmdat;
                cl.setTime(ld_start);
                li_mth = cl.get(Calendar.MONTH) + 1;
                do {
                    cl.setTime(ld_start);;
                    cl.set(Calendar.DATE, cl.get(Calendar.DATE) - 1);
                    ld_start = cl.getTime();
                } while (cl.get(Calendar.MONTH) + 1 == li_mth);

                ls_preyrmth = BaseLib.formatDate("yyyyMM", ld_start);
                cl.setTime(ld_start);
                cl.set(Calendar.DATE, cl.get(Calendar.DATE) + 1);
                ld_end = cl.getTime();
                li_mth = cl.get(Calendar.MONTH) + 1;
                do {
                    cl.setTime(ld_end);;
                    cl.set(Calendar.DATE, cl.get(Calendar.DATE) + 1);
                    ld_end = cl.getTime();
                } while (cl.get(Calendar.MONTH) + 1 == li_mth);

                for (Apmapd erpd : apmapds) {
                    // erpd =apmapdBean.findByPK(facno, apno, aptyp, oad.getSeq());
                    ls_bilno = erpd.getBilno();
                    if (null == this.findByPK(facno, ls_bilno)) {
                        if (macpamtfs.containsKey(ls_bilno)) {
                            ldc_acpamt = macpamt.get(ls_bilno).add(erpd.getAcpamt());
                            ldc_acpamtfs = macpamtfs.get(ls_bilno).add(erpd.getAcpamtfs());
                            macpamt.replace(ls_bilno, ldc_acpamt);
                            macpamtfs.replace(ls_bilno, ldc_acpamtfs);
                        } else {
                            macpamt.put(ls_bilno, erpd.getAcpamt());
                            macpamtfs.put(ls_bilno, erpd.getAcpamtfs());
                        }
                    }
                }
                for (Map.Entry<String, BigDecimal> entry : macpamtfs.entrySet()) {
                    String key = entry.getKey();
                    BigDecimal value = entry.getValue();
                    Apmtbil atb = apmtbilBean.findByPK(facno, key);
                    ldc_biltaxfs = atb.getBiltaxfs();
                    ldc_biltax = atb.getBiltax();
                    if (atb.getCoin().equals(locoin)) {
                        ldc_acpamtfs = value.setScale(li_decl, BigDecimal.ROUND_HALF_UP);
                    } else {
                        ldc_acpamtfs = value.setScale(li_decs, BigDecimal.ROUND_HALF_UP);
                    }
                    ldc_acpamt = value.setScale(li_decl, BigDecimal.ROUND_HALF_UP);
                    ldc_apmamtfs = atb.getBilamtfs().subtract(atb.getTemamtfs()).add(ldc_biltaxfs);
                    ldc_apmamt = atb.getBilamt().subtract(atb.getTemamt()).add(ldc_biltax);
                    ldc_resttaxfs = ldc_biltaxfs;
                    ldc_resttax = ldc_biltax;
                    int li_seq = 0;
                    for (Apmapd erpd : apmapds) {
                        ldc_thamtfs = erpd.getAcpamtfs();
                        ls_itnbr = erpd.getItnbr();
                        ls_acpno = erpd.getAcpno();
                        ls_bilno = erpd.getBilno();
                        ldc_ivops = erpd.getIvops();
                        ldc_ivoms = erpd.getIvoms();
                        ls_ogdkid_r = erpd.getOgdkid();
                        ldc_ivopsfs = erpd.getIvopsfs();
                        ldc_ivomsfs = erpd.getIvomsfs();
                        ldc_thamt = erpd.getAcpamt();
                        ls_trapyh = erpd.getTrapyh().charAt(0);
                        if (key.equals(erpd.getBilno())) {
                            li_seq += 1;
                            if (ldc_biltaxfs.compareTo(BigDecimal.ZERO) > 0) {
                                double temtemthtaxfs = ldc_biltaxfs.doubleValue() * ldc_thamtfs.doubleValue() / ldc_acpamtfs.doubleValue();
                                BigDecimal temthtaxfs = BigDecimal.valueOf(temtemthtaxfs);
                                //BigDecimal temthtaxfs = ldc_biltaxfs.multiply(ldc_thamtfs).divide(ldc_acpamtfs); //Bigdecimal 除不尽会报错
                                double temtemthtax = ldc_biltax.doubleValue() * ldc_thamtfs.doubleValue() / ldc_acpamtfs.doubleValue();
                                BigDecimal temthtax = BigDecimal.valueOf(temtemthtax);
                                if (atb.getCoin().equals(locoin)) {
                                    ldc_thtaxfs = misBean.setdecbymis(temthtaxfs, li_decl, 3);
                                } else {
                                    ldc_thtaxfs = misBean.setdecbymis(temthtaxfs, li_decs, 3);
                                }
                                ldc_thtax = misBean.setdecbymis(temthtax, li_decl, 3);
                            }
                            if (ldc_resttaxfs.compareTo(ldc_thtaxfs) > -1) {
                                ldc_resttaxfs = ldc_resttaxfs.subtract(ldc_thtaxfs);
                            } else {
                                ldc_thtaxfs = ldc_resttaxfs;
                                ldc_resttaxfs = BigDecimal.ZERO;
                            }
                            if (ldc_resttax.compareTo(ldc_thtax) > -1) {
                                ldc_resttax = ldc_resttax.subtract(ldc_thtax);
                            } else {
                                ldc_thtax = ldc_resttax;
                                ldc_resttax = BigDecimal.ZERO;
                            }
                            //进货短估/溢估新增资料至库存交易历史主档 invtrnh
                            //借货规则做存货立帐短溢估才写到存货
                            if (ldc_ivopsfs.compareTo(BigDecimal.ZERO) > 0) {
                                boolean b1 = apmaphBean.checkValueyn(facno, ls_ogdkid_r);
                                if (b1 == true) {
                                    if (apmaphBean.checkExistqty(facno, ls_itnbr, ls_preyrmth, ld_start, ld_end)) {
                                        int i = invtrnhBean.invapminsert(facno, "ADD", ls_acpno, ls_bilno, "", "APM330", ldt_apmdat, ldc_ivops);
                                        if (0 != i) {
                                            return false;
                                        }
                                    } else {
                                        ls_subtrtype = apmsysBean.findByFacno(facno).getSubtrtype();
                                        if (null == ls_subtrtype || "".equals(ls_subtrtype)) {
                                        } else {
                                            ls_ogdkid_r = ls_subtrtype;
                                        }
                                    }
                                }
                            }
                            if (ldc_ivomsfs.compareTo(BigDecimal.ZERO) > 0) {
                                boolean b1 = apmaphBean.checkValueyn(facno, ls_ogdkid_r);
                                if (b1 == true) {
                                    if (apmaphBean.checkExistqty(facno, ls_itnbr, ls_preyrmth, ld_start, ld_end)) {
                                        int i = invtrnhBean.invapminsert(facno, "DIS", ls_acpno, ls_bilno, "", "APM330", ldt_apmdat, ldc_ivoms);
                                        if (0 != i) {
                                            return false;
                                        }
                                    } else {
                                        ls_subtrtype = apmsysBean.findByFacno(facno).getSubtrtype();
                                        if (null == ls_subtrtype || "".equals(ls_subtrtype)) {
                                        } else {
                                            ls_ogdkid_r = ls_subtrtype;
                                        }
                                    }
                                }
                            }

                            //请款冲验收暂估
                            Apmpyh apmpyh = apmpyhBean.findByPK(facno, ls_acpno);
                            if (apmpyh == null) {
                                throw new RuntimeException("错误,Update APMPYH error!");
                            } else {
                                if (ls_trapyh.equals('1')) {
                                    //请款冲验收
                                    apmpyh.setIvoamtfs(apmpyh.getIvoamtfs().add(ldc_thamtfs));
                                    apmpyh.setIvoamt(apmpyh.getIvoamt().add(ldc_thamt));
                                    apmpyh.setAivoamtfs(apmpyh.getAivoamtfs().subtract(ldc_thamtfs));
                                    apmpyh.setAivoamt(apmpyh.getAivoamt().subtract(ldc_thamt));
                                } else {
                                    //申请冲暂估
                                    apmpyh.setIvopsfs(apmpyh.getIvopsfs().add(ldc_ivopsfs));    //进货短估
                                    apmpyh.setIvops(apmpyh.getIvops().add(ldc_ivops));
                                    apmpyh.setIvomsfs(apmpyh.getIvomsfs().add(ldc_ivomsfs));    //进货溢估
                                    apmpyh.setIvoms(apmpyh.getIvoms().add(ldc_ivoms));
                                    apmpyh.setIvoamtfs(apmpyh.getIvoamtfs().add(ldc_thamtfs));
                                    apmpyh.setIvoamt(apmpyh.getIvoamt().add(ldc_thamt));
                                    apmpyh.setAivoamtfs(apmpyh.getAivoamtfs().subtract(ldc_thamtfs));
                                    apmpyh.setAivoamt(apmpyh.getAivoamt().subtract(ldc_thamt));
                                }
                                //防止重复执行，判断目前申请立账金额
                                if (apmpyh.getAivoamt().compareTo(BigDecimal.ZERO) < 0) {
                                    throw new RuntimeException("目前申请立账金额小于0！请查看！");
                                }
                                apmpyhBean.update(apmpyh);
                            }

                        }
                        //更新发票对应验收档
                        if (key.equals(erpd.getBilno())) {         //防止重复生成，影响产生初稿传票
                            Apmpur apmpur = new Apmpur();
                            ApmpurPK apmpurPK = new ApmpurPK();
                            apmpurPK.setFacno(facno);
                            apmpurPK.setBilno(key);
                            apmpurPK.setAcpno(ls_acpno);
                            apmpur.setApmpurPK(apmpurPK);
                            apmpur.setThamt(ldc_thamt);
                            apmpur.setThpre(erpd.getPreamt());
                            apmpur.setThtem(erpd.getTemamt());
                            apmpur.setThtax(ldc_thtax);
                            apmpur.setLosamt(erpd.getLosamt());
                            apmpur.setCstamt(BigDecimal.ZERO);
                            apmpur.setIvops(erpd.getIvops());
                            apmpur.setIvoms(erpd.getIvoms());
                            apmpur.setThamtfs(ldc_thamtfs);
                            apmpur.setThprefs(erpd.getPreamtfs());
                            apmpur.setThtemfs(erpd.getTemamtfs());
                            apmpur.setThtaxfs(ldc_thtaxfs);
                            apmpur.setLosamtfs(erpd.getLosamtfs());
                            apmpur.setCstamtfs(BigDecimal.ZERO);
                            apmpur.setIvopsfs(ldc_ivopsfs);
                            apmpur.setIvomsfs(ldc_ivomsfs);
                            apmpur.setCoin(atb.getCoin());
                            apmpur.setRatio(erpd.getRatio());
                            //由apusrno调整为userno,
                            apmpur.setUsrno(erph.getUserno());
                            apmpur.setSponr(erpd.getSponr());
                            apmpur.setSrckind(ls_trapyh);
                            apmpur.setSeqno((short) li_seq);
                            apmpur.setProno("");
                            apmpur.setTrtype(ls_ogdkid_r);
                            apmpur.setApmqty(erpd.getPayqty());
                            apmpurBean.persist(apmpur);
                        }

                    }
                    a = new Apmbil();
                    apk = new ApmbilPK();
                    apk.setFacno(facno);
                    apk.setBilno(key);
                    a.setApmbilPK(apk);
                    a.setBilstat("0");
                    a.setBilym(atb.getBilym());
                    a.setBilnum(atb.getBilnum().toString());
                    a.setTaxkd(atb.getTaxkd());
                    a.setApmdat(erph.getApdate());
                    a.setBildat(atb.getBildat());
                    a.setIvovdr(erph.getVdrno());
                    a.setVdrno(atb.getVdrno());
                    a.setVdrna(atb.getVdrna());
                    //发票形式
                    a.setBiltyp('3');
                    a.setBilkid(atb.getBilkid());
                    a.setUsrno(atb.getUsrno());
                    a.setDepno(atb.getDepno());
                    a.setOgdkid("ZZZZ");
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
                    a.setPayda(erph.getPayda());
                    a.setTerda(erph.getTerda());
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
                    a.setPayptn(erph.getPaytn());
                    a.setFixtyn("N");
                    a.setUniform(atb.getUniform());
                    a.setVdrna(erph.getVdrna());
                    a.setTaxrate(atb.getTaxrate());
                    a.setTaxbase(atb.getTaxbase());
                    a.setBilcategory(atb.getBilcategory());
                    a.setOpbankna(atb.getOpbankna());
                    a.setOpbankno(atb.getOpbankno());
                    a.setOpbanknum(atb.getOpbanknum());
                    persist(a);
                    atb.setBilstat('2');
                    apmtbilBean.update(atb);
                }
                //抛转单号为OA表单代号
                erph.setOano(oah.getFormSerialNumber());
                erph.setApsta("30");
                //加入apusrno,cfmusrno 为OA审核人20200411
                List<ProcessCheck> processList;
                processList = processCheckBean.findByPSN(psn);
                if (processList.size() > 1) {
                    ProcessCheck pc1 = processList.get(processList.size() - 1);
                    ProcessCheck pc2 = processList.get(processList.size() - 2);
                    erph.setCfmusrno(pc1.getUserID());
                    erph.setApusrno(pc2.getUserID());
                }
                apmaphBean.update(erph);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmbilBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
