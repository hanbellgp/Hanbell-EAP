/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.eap.ejb.MailSettingBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdmas;
import cn.hanbell.erp.entity.Cdrdta;
import cn.hanbell.erp.entity.Cdrhad;
import cn.hanbell.erp.entity.Cdrhmas;
import cn.hanbell.erp.entity.Cdrlot;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Transwah;
import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.HKYX013Bean;
import cn.hanbell.oa.ejb.HKYX013DetailBean;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.oa.entity.HKFW005Detail;
import cn.hanbell.oa.entity.HKYX013;
import cn.hanbell.oa.entity.HKYX013Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
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
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrhadBean extends SuperEJBForERP<Cdrhad> {

    @EJB
    private CdrdtaBean cdrdtaBean;
    @EJB
    private CdrlotBean cdrlotBean;
    @EJB
    private CdrhmasBean cdrhmasBean;
    @EJB
    private CdrdmasBean cdrdmasBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private TranswahBean transwahBean;
    @EJB
    private CdrsysBean cdrsysBean;
    @EJB
    private HKYX013Bean hkyx013Bean;
    @EJB
    private HKYX013DetailBean hkyxDetail013Bean;
    @EJB
    private HKFW005Bean hkfw005Bean;
    @EJB
    private MailSettingBean mailSettingBean;
    @EJB
    private MailNotificationBean mailBean;

    private List<Cdrdta> detailList;

    public CdrhadBean() {
        super(Cdrhad.class);
    }

    @Override
    public Cdrhad findById(Object value) {
        Query query = getEntityManager().createNamedQuery("Cdrhad.findByShpno");
        query.setParameter("shpno", value);
        try {
            Object o = query.getSingleResult();
            return (Cdrhad) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<String[]> queryShpdateList(String facno, String[] itnbrs) {
        List<String[]> shpdateList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itnbrs.length; i++) {
            String itnbr = itnbrs[i].trim();
            String[] arr = new String[2];
            arr[0] = itnbr;
            if (!"".equals(itnbr)) {
                sb.setLength(0);
                sb.append(" SELECT top 1 convert(varchar(10),shpdate,111) FROM cdrhadh h,cdrdtah d where h.shpno=d.shpno and d.facno= '${facno}' and d.itnbr =  '${itnbr}' ORDER BY shpdate ASC ");
                String sql1 = sb.toString().replace("${itnbr}", itnbr).replace("${facno}", facno);
                sb.setLength(0);
                sb.append(" SELECT top 1 convert(varchar(10),shpdate,111)  FROM cdrhad h,cdrdta d   where h.shpno=d.shpno and d.facno= '${facno}' and d.itnbr =  '${itnbr}'  ORDER BY shpdate ASC ");
                String sql2 = sb.toString().replace("${itnbr}", itnbr).replace("${facno}", facno);
                try {
                    setCompany(facno);
                    Query query1 = getEntityManager().createNativeQuery(sql1);
                    List result;
                    //第一次查询销售历史表数据，如无记录则查询现销售表数据赋值
                    result = query1.getResultList();
                    if (result != null && !result.isEmpty()) {
                        arr[1] = result.get(0).toString();
                    } else {
                        Query query2 = getEntityManager().createNativeQuery(sql2);
                        result = query2.getResultList();
                        if (result != null && !result.isEmpty()) {
                            arr[1] = result.get(0).toString();
                        } else {
                            arr[1] = "null";
                        }
                    }
                } catch (Exception e) {
                    arr[1] = e.toString();
                }
                shpdateList.add(arr);
            }
        }
        return shpdateList;
    }

    /**
     * 修改订单出货单
     *
     * @param psn
     * @return
     */
    public boolean updateByOAHKYX013(String psn) {
        HKYX013 h = hkyx013Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        List<HKYX013Detail> details = hkyxDetail013Bean.findByFSN(h.getFormSerialNumber());
        try {
            if (!details.isEmpty()) {
                for (HKYX013Detail item : details) {
                    if ("2".equals(item.getInvoiceType())) {
                        this.setCompany(h.getFacno());
                        Cdrhad c = this.findById(item.getSingleNumber());
                        if (c != null) {
                            if (!"".equals(item.getNewDeptno())) {
                                c.setDepno(item.getNewDeptno());
                            }
                            if (!"".equals(item.getNewMancode())) {
                                c.setMancode(item.getNewMancode());
                            }
                            if (!"".equals(item.getNewDeptno()) || !"".equals(item.getNewMancode())) {
                                this.update(c);
                            }
                        }
                        //更新出货单表身明细
                        cdrdtaBean.setCompany(h.getFacno());
                        Cdrdta cdrdta = cdrdtaBean.findByFacnoAndShpnoAndItnbrAndTrseq(h.getFacno(), item.getSingleNumber(), item.getItnbr(), Integer.parseInt(item.getTrseq()));
                        if (cdrdta != null) {
                            if (!"".equals(item.getNcodeDA()) && !"请选择".equals(item.getNcodeDA()) && !"0".equals(item.getNcodeDA())) {
                                cdrdta.setNcodeDA(item.getNcodeDA());
                            }
                            if (!"".equals(item.getNcodeCD()) && !"请选择".equals(item.getNcodeCD()) && !"0".equals(item.getNcodeCD())) {
                                cdrdta.setNcodeCD(item.getNcodeCD());
                            }
                            if (!"".equals(item.getNcodeDC()) && !"请选择".equals(item.getNcodeDC()) && !"0".equals(item.getNcodeDC())) {
                                cdrdta.setNcodeDC(item.getNcodeDC());
                            }
                            if (!"".equals(item.getNcodeDD()) && !"请选择".equals(item.getNcodeDD()) && !"0".equals(item.getNcodeDD())) {
                                cdrdta.setNcodeDD(item.getNcodeDD());
                            }
                            if (!"".equals(item.getIssevdta()) && !"请选择".equals(item.getIssevdta()) && !"0".equals(item.getIssevdta())) {
                                cdrdta.setIssevdta(item.getIssevdta().charAt(0));
                            }
                            cdrdtaBean.update(cdrdta);
                        }
                    }
                }
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * OA服务工作支援单零件抛转出货单
     *
     * @param psn
     * @param OA流程序号
     * @return
     */
    public Boolean initByOAHKFW005(String psn) {
        String cdrno, facno;
        String ls_shpno;
        String ls_moveno;
        String retshpno = "";
        Date shpdate;
        Map<String, String> pzcdrnos;
        List<Cdrdta> cdtaList;
        List<Cdrdmas> cdmasList;
        try {
            HKFW005 f = hkfw005Bean.findByPSN(psn);
            if (null == f) {
                throw new NullPointerException("找不到对应的OA服务工作支援单流程");
            }
            if (f.getType().equals("1")) {
                cdrno = f.getOrderno();
                //公司别取单身数据
                //facno = f.getFacno();
                if (cdrno.isEmpty()) {
                    return true;
                }
                pzcdrnos = new HashMap<String, String>();
                List<HKFW005Detail> fd = hkfw005Bean.getDetailList(f.getFormSerialNumber());
                if (fd.size() > 0) {
                    for (HKFW005Detail d : fd) {
                        cdrno = d.getCdrno();
                        facno = d.getDfacno();
                        if (!pzcdrnos.containsKey(cdrno)) {
                            cdrhmasBean.setCompany(facno);
                            if (null == cdrhmasBean.findById(cdrno)) {
                                throw new NullPointerException("找不到对应的订单");
                            }
                            pzcdrnos.put(cdrno, facno);
                        }
                    }
                }
                for (Map.Entry<String, String> entry : pzcdrnos.entrySet()) {
                    Cdrhad chad;
                    String pzcdrno;
                    short li_shptrseq;
                    cdtaList = new ArrayList<>();
                    cdmasList = new ArrayList<>();
                    facno = entry.getValue();
                    pzcdrno = entry.getKey();
                    shpdate = BaseLib.getDate();
                    BigDecimal ldc_shpamts = BigDecimal.ZERO;
                    BigDecimal ldc_taxamts = BigDecimal.ZERO;
                    BigDecimal ldc_totamts = BigDecimal.ZERO;
                    Cdrhmas chmas = cdrhmasBean.findById(pzcdrno);
                    Character decode = chmas.getDecode();  //国内
                    li_shptrseq = chmas.getShptrseq();
                    cdrsysBean.setCompany(facno);
                    ls_shpno = cdrsysBean.getSerialNumber(facno, "", "", shpdate, decode, Boolean.TRUE, "CDR645");
                    short seq = 1;
                    for (HKFW005Detail d : fd) {
                        if (pzcdrno.equals(d.getCdrno())) {
                            cdrdmasBean.setCompany(facno);
                            Cdrdmas cdmas = cdrdmasBean.findByFacnoAndCdrnoAndItnbrAndTrseq(facno, pzcdrno, d.getItnbr(), Integer.parseInt(d.getTrseq()));
                            if (cdmas == null) {
                                throw new RuntimeException("抛转订单单身资料异常！");
                            }
                            Cdrdta cdta = new Cdrdta(facno, ls_shpno, seq);
                            cdta.setCdrno(pzcdrno);
                            cdta.setCtrseq(Short.valueOf(d.getTrseq()));
                            invmasBean.setCompany(facno);
                            Invmas m = invmasBean.findByItnbr(d.getItnbr());
                            if (m == null) {
                                throw new RuntimeException(d.getItnbr() + "件号未找到！");
                            }
                            cdta.setItnbr(d.getItnbr());
                            cdta.setItdsc(m.getItdsc());
                            cdta.setSpdsc(m.getSpdsc());
                            cdta.setItnbrcus(d.getModel());
                            cdta.setProno("1");
                            BigDecimal leftqy1 = cdmas.getCdrqy1().subtract(cdmas.getShpqy1()).subtract(cdmas.getPreqy1());
                            if (BigDecimal.valueOf(Double.parseDouble(d.getQty())).compareTo(leftqy1) > 0) {
                                throw new RuntimeException("订单" + pzcdrno + "库存" + d.getItnbr() + "可利用不足");
                            }
                            cdta.setShpqy1(BigDecimal.valueOf(Double.parseDouble(d.getQty())));
                            cdta.setShpqy2(BigDecimal.ZERO);
                            //cdta.setArmqy(cdmas.getArmqy());
                            cdta.setArmqy(cdta.getShpqy1());   //应收账款数量（单单位）
                            cdta.setUnpris(cdmas.getUnpris());
                            cdta.setUnprisrccode(cdmas.getUnprisrccode());
                            cdta.setShpamts(cdta.getUnpris().multiply(cdta.getShpqy1()));
                            cdta.setIvoamts(BigDecimal.ZERO);
                            cdta.setDmark1(cdmas.getDmark1());
                            cdta.setDmark2(cdmas.getDmark2());
                            cdta.setDmark3(cdmas.getDmark3());
                            cdta.setDmark4(cdmas.getDmark4());
                            cdta.setTrtype("L1A");
                            cdta.setCusmark(cdmas.getCusmark());
                            //cdta.setIssevdta('Y');  //是否服务出货
                            cdta.setNcodeDA(cdmas.getNcodeDA());
                            cdta.setNcodeCD(cdmas.getNcodeCD());
                            cdta.setNcodeDC(cdmas.getNcodeDC());
                            cdta.setNcodeDD(cdmas.getNcodeDD());
                            cdtaList.add(cdta);
                            cdmas.setPreqy1(cdmas.getPreqy1().add(cdta.getShpqy1()));
                            cdmas.setPreqy2(cdmas.getPreqy2().add(cdta.getShpqy2()));
                            cdmas.setDrecsta("84");
                            cdmasList.add(cdmas);
                            ldc_totamts = ldc_totamts.add(cdta.getShpamts());
                            //变更出货地址
                            if (d.getShptrseq() != null && d.getShptrseq() != "") {
                                if (Short.parseShort(d.getShptrseq()) != li_shptrseq) {
                                    li_shptrseq = Short.parseShort(d.getShptrseq());
                                }
                            }
                            seq++;
                        }
                    }
                    //表头数据
                    chad = new Cdrhad(facno, ls_shpno);
                    chad.setSalecode('1');
                    chad.setDecode(decode);
                    try {
                        chad.setShpdate(BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", shpdate)));
                    } catch (ParseException ex) {
                        Logger.getLogger(CdrhadBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    chad.setTrtype("L1A");  //国内出货
                    chad.setDepno(chmas.getDepno());
                    chad.setCusno(chmas.getCusno());
                    //变更出货单地址选择，从支援单单身获取
                    //chad.setShptrseq(chmas.getShptrseq());
                    chad.setShptrseq(li_shptrseq);
                    chad.setIvotrseq(chmas.getIvotrseq());
                    chad.setHoutsta('N');
                    chad.setTax(chmas.getTax());
                    chad.setTaxrate(chmas.getTaxrate());
                    chad.setCoin(chmas.getCoin());
                    chad.setRatio(chmas.getRatio());
                    chad.setTotamts(ldc_totamts);
                    ldc_shpamts = ldc_totamts.divide(chad.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
                    chad.setShpamts(ldc_shpamts);
                    ldc_taxamts = ldc_shpamts.multiply(chad.getTaxrate()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    chad.setTaxamts(ldc_taxamts);
                    chad.setSndcode(chmas.getSndcode());
                    chad.setPaycode(chmas.getPaycode());
                    chad.setTermcode(chmas.getTermcode());
                    chad.setSndcodedsc(chmas.getSndcodedsc());
                    chad.setPaycodedsc(chmas.getPaycodedsc());
                    chad.setTermcodedsc(chmas.getTermcodedsc());
                    chad.setPaysepcode(chmas.getPaysepcode());
                    chad.setSeldate1(chmas.getSeldate1());
                    chad.setSeldate2(chmas.getSeldate2());
                    chad.setSeldate3(chmas.getSeldate3());
                    chad.setSeldate4(chmas.getSeldate4());
                    chad.setHandays1(chmas.getHandays1());
                    chad.setHandays2(chmas.getHandays2());
                    chad.setHandays3(chmas.getHandays3());
                    //chad.setHandays4(chmas.getHandays4());
                    chad.setHandays4((short) 5);   //来源CDR645
                    chad.setTickdays(chmas.getTickdays());
                    chad.setSacode(chmas.getSacode());
                    chad.setAreacode(chmas.getAreacode());
                    chad.setCuycode(chmas.getCuycode());
                    chad.setMancode(chmas.getMancode());
                    chad.setInvoiceyn(chmas.getInvoiceyn());
                    chad.setHmark2(chmas.getHmark1());//订单产品别写入出货单
                    chad.setIndate(shpdate);
                    if (f.getCdruserno() == null || f.getCdruserno().isEmpty()) {
                        chad.setUserno(chmas.getUserno());
                    } else {
                        chad.setUserno(f.getCdruserno());
                    }
                    ls_moveno = cdrsysBean.getSerialNumber(facno, "", "", shpdate, decode, Boolean.TRUE, "O" + "CDR645");
                    chad.setMoveno(ls_moveno); //海关仓转移单号
                    transwahBean.setCompany(facno);
                    Transwah transwah = transwahBean.findByCusnoAndTrseq(chmas.getCusno(), chmas.getIvotrseq());
                    if (transwah == null) {
                        throw new NullPointerException("系统设定发票立帐发票客户必须有对应的周转仓库, 请到ERP-CDR181设定!");
                    }
                    chad.setOwareh(transwah.getWareh()); //海关仓
                    chad.setReplenish('N');
                    //chad.setIssevhad('Y');
                    if (chad.getCusno().equals("SCQ00146") || chad.getCusno().equals("SJS00254") || chad.getCusno().equals("SSD00107") || chad.getCusno().equals("SGD00088")) {
                        chad.setIssevhad('N');
                    } else {
                        chad.setIssevhad('Y');
                    }
                    persist(chad);
                    this.getEntityManager().flush();
                    for (Cdrdta dta : cdtaList) {
                        dta.setIssevdta(chad.getIssevhad());  //是否服务出货
                        cdrdtaBean.persist(dta);
                    }
                    retshpno += ls_shpno + ";";
                    //更新订单单身状态
                    for (Cdrdmas dmas : cdmasList) {
                        cdrdmasBean.update(dmas);
                    }
                }

                //出货单号回写OA
                f.setShpno(retshpno);
                hkfw005Bean.update(f);

                List<String> emailTo
                        = mailSettingBean.findRecipientTo("cn.hanbell.jws.EAPWebService.createERPCDR645ByOAHKFW005");
                List<String> emailCc
                        = mailSettingBean.findRecipientCc("cn.hanbell.jws.EAPWebService.createERPCDR645ByOAHKFW005");

                mailBean.clearReceivers();
                mailBean.getAttachments().clear();
                if (emailTo != null && !emailTo.isEmpty()) {
                    mailBean.getTo().addAll(emailTo);
                }
                if (emailCc != null && !emailCc.isEmpty()) {
                    mailBean.getCc().addAll(emailCc);
                }
                mailBean.setMailSubject("服务工作支援单抛转CDR45出货成功");
                mailBean.setMailContent(
                        "OA服务工作支援单号：" + psn + "抛转成功，生成ERP单号：" + retshpno);
                mailBean.notify(new MailNotify());
                log4j.info("Info", "报表邮件发送成功");
                return true;
            } else {
                //非零件支援返回true
                return true;
            }
        } catch (Exception ex) {
            List<String> emailTo
                    = mailSettingBean.findRecipientTo("cn.hanbell.jws.EAPWebService.createERPCDR645ByOAHKFW005");
            List<String> emailCc
                    = mailSettingBean.findRecipientCc("cn.hanbell.jws.EAPWebService.createERPCDR645ByOAHKFW005");
            mailBean.clearReceivers();
            if (emailTo != null && !emailTo.isEmpty()) {
                mailBean.getTo().addAll(emailTo);
            }
            if (emailCc != null && !emailCc.isEmpty()) {
                mailBean.getCc().addAll(emailCc);
            }
            mailBean.setMailSubject("服务工作支援单抛转CDR45出货失败");
            mailBean.setMailContent(
                    "OA服务工作支援单号：" + psn + "抛转失败，异常：" + ex);
            mailBean.notify(new MailNotify());
            log4j.error(ex);
            throw new RuntimeException(ex);
        }
    }

    public List<Cdrlot> findCdrlotList(String facno, String shpno) {
        cdrlotBean.setCompany(facno);
        return cdrlotBean.findByFacnoAndShpno(facno, shpno);
    }

    @Override
    public void setDetail(Object value) {
        detailList = cdrdtaBean.findByShpno(value.toString());
    }

    public List<Cdrdta> getDetail(String facno, Object o) {
        cdrdtaBean.setCompany(facno);
        return cdrdtaBean.findByShpno(o.toString());
    }

    /**
     * @return the detailList
     */
    public List<Cdrdta> getDetailList() {
        return detailList;
    }

}
