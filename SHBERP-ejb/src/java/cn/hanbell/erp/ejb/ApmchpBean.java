/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.eap.comm.ErrorMailNotify;
import cn.hanbell.eap.ejb.ErrorMailNotificationBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmchp;
import cn.hanbell.erp.entity.ApmchpPK;
import cn.hanbell.erp.entity.Apmhad;
import cn.hanbell.oa.ejb.HKCW018Bean;
import cn.hanbell.oa.entity.HKCW018;
import cn.hanbell.oa.entity.HKCW018Detail;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ApmchpBean extends SuperEJBForERP<Apmchp> {

    @EJB
    private HKCW018Bean hkcw018Bean;
    @EJB
    private ApmhadBean apmhadBean;
    @EJB
    private ErrorMailNotificationBean mailBean;

    public ApmchpBean() {
        super(Apmchp.class);
    }

    /**
     * 厂商变更付款信息
     *
     */
    public Boolean updateByOAHKCW018(String psn) {
        HKCW018 oah = hkcw018Bean.findByPSN(psn);
        if (oah == null) {
            throw new NullPointerException(psn);
        }
        List<HKCW018Detail> oadetails = hkcw018Bean.getDetailList(oah.getFormSerialNumber());
        String facno = oah.getFacno();
        String vdrno = oah.getVdrno();
        this.setCompany(facno);
        apmhadBean.setCompany(facno);
        try {
            for (HKCW018Detail oad : oadetails) {
                String trno = oad.getInvoiceNumber();
                //检查账款立账申请
                Apmhad apmhad = apmhadBean.findByTrno(facno, vdrno, trno);
                if (null == apmhad) {
                    throw new RuntimeException("找不到可对应的应付立账资料: " + trno);
                }
                if (apmhad.getApmamt().compareTo(apmhad.getPayamt()) < 1) {
                    throw new RuntimeException("此笔立账申请累计付款金额已大于等于申请金额: " + trno);
                }
                String accno = apmhad.getApmhadPK().getAccno();
                String detno = apmhad.getApmhadPK().getDetno();
                short config = apmhad.getConfig();
                Date terda = apmhad.getTerda();
                String coin = apmhad.getCoin();
                BigDecimal ratio = apmhad.getRatio();
                String payptn = apmhad.getPayptn();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                //更新批次付款明细档apmchp
                List<Apmchp> chpList = findByTrno(facno, vdrno, trno);
                List<Apmchp> addList = new ArrayList<>();
                if (null == chpList || chpList.size() == 0) {
                    BigDecimal sum = BigDecimal.ZERO;
                    if (!"".equals(oad.getPayDate1txt())) {
                        Apmchp apmchp = new Apmchp();
                        ApmchpPK apmhadPK = new ApmchpPK(facno, trno, vdrno, accno, detno, (short) 1);
                        apmchp.setApmchpPK(apmhadPK);
                        apmchp.setConfig(config);
                        apmchp.setPayda(sdf.parse(oad.getPayDate1txt()));
                        apmchp.setTerda(terda);
                        apmchp.setPayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayAmount1())));
                        apmchp.setPayamt(apmchp.getPayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        apmchp.setCoin(coin);
                        apmchp.setRatio(ratio);
                        apmchp.setPayyn("Y");
                        apmchp.setPayptn(payptn);
                        apmchp.setVouno("");
                        //有提前付款利息
                        if (!"".equals(oad.getPayInterest())) {
                            apmchp.setHpayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayInterest())));
                            apmchp.setHpayamt(apmchp.getHpayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        } else {
                            apmchp.setHpayamt(BigDecimal.ZERO);
                            apmchp.setHpayamtfs(BigDecimal.ZERO);
                        }
                        sum = sum.add(apmchp.getPayamtfs());
                        addList.add(apmchp);

                    }
                    if (!"".equals(oad.getPayDate2txt()) && !oad.getPayDate2txt().equals(oad.getPayDate1txt())) {
                        Apmchp apmchp2 = new Apmchp();
                        ApmchpPK apmhadPK2 = new ApmchpPK(facno, trno, vdrno, accno, detno, (short) 2);
                        apmchp2.setApmchpPK(apmhadPK2);
                        apmchp2.setConfig(config);
                        apmchp2.setPayda(sdf.parse(oad.getPayDate2txt()));
                        apmchp2.setTerda(terda);
                        apmchp2.setPayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayAmount2())));
                        apmchp2.setPayamt(apmchp2.getPayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        apmchp2.setCoin(coin);
                        apmchp2.setRatio(ratio);
                        apmchp2.setPayyn("Y");
                        apmchp2.setPayptn(payptn);
                        apmchp2.setVouno("");
                        apmchp2.setHpayamt(BigDecimal.ZERO);
                        apmchp2.setHpayamtfs(BigDecimal.ZERO);
                        sum = sum.add(apmchp2.getPayamtfs());
                        addList.add(apmchp2);
                    }
                    if (!"".equals(oad.getPayDate3txt()) && !oad.getPayDate3txt().equals(oad.getPayDate1txt()) && !oad.getPayDate3txt().equals(oad.getPayDate2txt())) {
                        Apmchp apmchp3 = new Apmchp();
                        ApmchpPK apmhadPK3 = new ApmchpPK(facno, trno, vdrno, accno, detno, (short) 3);
                        apmchp3.setApmchpPK(apmhadPK3);
                        apmchp3.setConfig(config);
                        apmchp3.setPayda(sdf.parse(oad.getPayDate3txt()));
                        apmchp3.setTerda(terda);
                        apmchp3.setPayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayAmount3())));
                        apmchp3.setPayamt(apmchp3.getPayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        apmchp3.setCoin(coin);
                        apmchp3.setRatio(ratio);
                        apmchp3.setPayyn("Y");
                        apmchp3.setPayptn(payptn);
                        apmchp3.setVouno("");
                        apmchp3.setHpayamt(BigDecimal.ZERO);
                        apmchp3.setHpayamtfs(BigDecimal.ZERO);
                        sum = sum.add(apmchp3.getPayamtfs());
                        addList.add(apmchp3);
                    }
                    //判断拆分后总金额是否等于余额
                    if (apmhad.getApmamt().subtract(apmhad.getPayamt()).compareTo(sum) != 0) {
                        throw new RuntimeException("此笔立账申请累计未付款金额" + apmhad.getApmamt().subtract(apmhad.getPayamt())
                                + "不等于拆分后金额合计: " + sum + "立账申请单号 ：" + trno);
                    }
                    for (Apmchp a : addList) {
                        this.persist(a);
                    }
                } else {
                    //检查OA选取资料
                    int size = chpList.size();
                    String payda = oad.getPayda();
                    String payamtfs = oad.getPayamtfs();
                    String seq = oad.getTrseq();
                    if ("".equals(seq) || "".equals(payda) || "".equals(payamtfs)) {
                        throw new RuntimeException("OA厂商付款明细找不到可对应的应付立账资料: " + trno);
                    }
                    addList.clear();
                    short trseq = Short.valueOf(seq);
                    Apmchp srcApmchp = this.findByPK(facno, trno, vdrno, accno, detno, trseq);
                    if (null == srcApmchp) {
                        continue;
                    }
                    BigDecimal srcpayamtfs = srcApmchp.getPayamtfs();   //变更前付款金额
                    BigDecimal srchpayamtfs = srcApmchp.getHpayamtfs(); //变更前已付款金额
                    BigDecimal srchpayamt = srcApmchp.getHpayamt();
                    BigDecimal sum = BigDecimal.ZERO;
                    //更新付款日期/金额
                    srcApmchp.setPayda(sdf.parse(oad.getPayDate1txt()));
                    srcApmchp.setPayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayAmount1())));
                    srcApmchp.setPayamt(srcApmchp.getPayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                    //有提前付款利息
                    if (!"".equals(oad.getPayInterest())) {
                        srcApmchp.setHpayamtfs(srchpayamtfs.add(BigDecimal.valueOf(Double.valueOf(oad.getPayInterest()))));
                        srcApmchp.setHpayamt(srcApmchp.getHpayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                    }
                    sum = sum.add(srcApmchp.getPayamtfs());

                    if (!"".equals(oad.getPayDate2txt()) && !oad.getPayDate2txt().equals(oad.getPayDate1txt())) {

                        Apmchp apmchp2 = new Apmchp();
                        ApmchpPK apmhadPK2 = new ApmchpPK(facno, trno, vdrno, accno, detno, (short) (size + 1));
                        apmchp2.setApmchpPK(apmhadPK2);
                        apmchp2.setConfig(config);
                        apmchp2.setPayda(sdf.parse(oad.getPayDate2txt()));
                        apmchp2.setTerda(terda);
                        apmchp2.setPayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayAmount2())));
                        apmchp2.setPayamt(apmchp2.getPayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        apmchp2.setCoin(coin);
                        apmchp2.setRatio(ratio);
                        apmchp2.setPayyn("Y");
                        apmchp2.setPayptn(payptn);
                        apmchp2.setVouno("");
                        apmchp2.setHpayamt(BigDecimal.ZERO);
                        apmchp2.setHpayamtfs(BigDecimal.ZERO);
                        sum = sum.add(apmchp2.getPayamtfs());
                        addList.add(apmchp2);
                    }
                    if (!"".equals(oad.getPayDate3txt()) && !oad.getPayDate3txt().equals(oad.getPayDate1txt()) && !oad.getPayDate3txt().equals(oad.getPayDate2txt())) {
                        Apmchp apmchp3 = new Apmchp();
                        ApmchpPK apmhadPK3 = new ApmchpPK(facno, trno, vdrno, accno, detno, (short) (size + 2));
                        apmchp3.setApmchpPK(apmhadPK3);
                        apmchp3.setConfig(config);
                        apmchp3.setPayda(sdf.parse(oad.getPayDate3txt()));
                        apmchp3.setTerda(terda);
                        apmchp3.setPayamtfs(BigDecimal.valueOf(Double.valueOf(oad.getPayAmount3())));
                        apmchp3.setPayamt(apmchp3.getPayamtfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        apmchp3.setCoin(coin);
                        apmchp3.setRatio(ratio);
                        apmchp3.setPayyn("Y");
                        apmchp3.setPayptn(payptn);
                        apmchp3.setVouno("");
                        apmchp3.setHpayamt(BigDecimal.ZERO);
                        apmchp3.setHpayamtfs(BigDecimal.ZERO);
                        sum = sum.add(apmchp3.getPayamtfs());
                        addList.add(apmchp3);
                    }
                    if ((srcpayamtfs.subtract(srchpayamtfs)).compareTo(sum) != 0) {
                        throw new RuntimeException("此笔立账申请原付款金额 :" + srcpayamtfs + " 减去已付款金额" + srchpayamtfs
                                + " 不等于拆分后金额合计: " + sum + "立账申请单号 ：" + trno + ",序号： " + trseq);
                    }
                    for (Apmchp a : addList) {
                        this.persist(a);
                    }
                    update(srcApmchp);
                }
            }
            return true;
        } catch (Exception ex) {
            mailBean.getTo().add("13120@hanbell.cn");
            mailBean.setMailSubject("OA厂商变更付款信息失败");
            mailBean.setMailContent("OA厂商变更付款信息抛转异常，OA单号: " + psn + ",  出现异常：" + ex.toString());
            mailBean.notify(new ErrorMailNotify());
            ex.printStackTrace();
            log4j.error(ex);
            throw new RuntimeException(ex);
        }
    }

    public List<Apmchp> findByTrno(String facno, String vdrno, String trno) {
        Query query = this.getEntityManager().createNamedQuery("Apmchp.findByVdrnoAndTrno");
        query.setParameter("facno", facno);
        query.setParameter("vdrno", vdrno);
        query.setParameter("trno", trno);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Apmchp findByPK(String facno, String trno, String vdrno, String accno, String detno, short trseq) {
        Query query = this.getEntityManager().createNamedQuery("Apmchp.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("trno", trno);
        query.setParameter("vdrno", vdrno);
        query.setParameter("accno", accno);
        query.setParameter("detno", detno);
        query.setParameter("trseq", trseq);
        try {
            return (Apmchp) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
