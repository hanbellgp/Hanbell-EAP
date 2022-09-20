/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class SHBERPAPM811Model implements Serializable {

    private BigDecimal total;
    private String apsta;
    private String terdate;
    private BigDecimal expamt;
    private String vdrna;
    private Double sum_taxfs;
    private Double pric;
    private String ogdkid;
    private Double preamtfs;
    private Double ivopsfs;
    private String dmark;
    private String trapyh;
    private Date appdate;
    private Double sum_tax;
    private Double sum_bilnum8fs;
    private Double temamtfs;
    private Double com_apamtfs;
    private BigDecimal expamtfs;
    private String ratio;
    private String aptyp;
    private String appdept;
    private Double compute_1;
    private BigDecimal sum_apamt;
    private Double losamtfs;
    private String appuser;
    private String facno;
    private String inuser;
    private Date indate;
    private BigDecimal totalfs;
    private BigDecimal sum_apamtfs;
    private String tickdays;
    private String itnbr;
    private Double acpamtfs;
    private Double payqty;
    private String hmark;
    private String coin;
    private String pyhyn;
    private String isretmoney;
    private String acpno;
    private String paytn;
    private String paydate;
    private Double ivomsfs;
    private String itdsc;
    private String sponr;
    private String apno;
    private Double sum_bilnum8;
    private String bilno;
    private String vdrno;
    private Double sumivopsfs;
    private Double sumivomsfs;
    private String isAttachment;

    public SHBERPAPM811Model() {
        this.trapyh = "";
        this.acpno = "";
        this.sponr = "";
        this.itnbr = "";
        this.itdsc = "";
        this.pric = 0.00;
        this.payqty = 0.00;
        this.coin = "";
        this.ratio = "";
        this.ogdkid = "";
        this.bilno = "";
        this.acpamtfs = 0.00;
        this.ivopsfs = 0.00;
        this.ivomsfs = 0.00;
        this.preamtfs = 0.00;
        this.temamtfs = 0.00;
        this.losamtfs = 0.00;
        this.com_apamtfs = 0.00;
        this.dmark = "";
    }

    public String getApsta() {
        return apsta;
    }

    public void setApsta(String apsta) {
        this.apsta = apsta;
    }

    public String getTerdate() {
        return terdate;
    }

    public void setTerdate(String terdate) {
        this.terdate = terdate;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public Double getPric() {
        return pric;
    }

    public void setPric(Double pric) {
        this.pric = pric;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
    }

    public Double getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(Double preamtfs) {
        this.preamtfs = preamtfs;
    }

    public Double getIvopsfs() {
        return ivopsfs;
    }

    public void setIvopsfs(Double ivopsfs) {
        this.ivopsfs = ivopsfs;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getTrapyh() {
        return trapyh;
    }

    public void setTrapyh(String trapyh) {
        this.trapyh = trapyh;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public Double getSum_tax() {
        return sum_tax;
    }

    public void setSum_tax(Double sum_tax) {
        this.sum_tax = sum_tax;
    }

    public Double getSum_bilnum8fs() {
        return sum_bilnum8fs;
    }

    public void setSum_bilnum8fs(Double sum_bilnum8fs) {
        this.sum_bilnum8fs = sum_bilnum8fs;
    }

    public Double getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(Double temamtfs) {
        this.temamtfs = temamtfs;
    }

    public Double getCom_apamtfs() {
        return com_apamtfs;
    }

    public void setCom_apamtfs(Double com_apamtfs) {
        this.com_apamtfs = com_apamtfs;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getAptyp() {
        return aptyp;
    }

    public void setAptyp(String aptyp) {
        this.aptyp = aptyp;
    }

    public String getAppdept() {
        return appdept;
    }

    public void setAppdept(String appdept) {
        this.appdept = appdept;
    }

    public Double getCompute_1() {
        return compute_1;
    }

    public void setCompute_1(Double compute_1) {
        this.compute_1 = compute_1;
    }

    public Double getLosamtfs() {
        return losamtfs;
    }

    public void setLosamtfs(Double losamtfs) {
        this.losamtfs = losamtfs;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getInuser() {
        return inuser;
    }

    public void setInuser(String inuser) {
        this.inuser = inuser;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getTickdays() {
        return tickdays;
    }

    public void setTickdays(String tickdays) {
        this.tickdays = tickdays;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public Double getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(Double acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public Double getPayqty() {
        return payqty;
    }

    public void setPayqty(Double payqty) {
        this.payqty = payqty;
    }

    public String getHmark() {
        return hmark;
    }

    public void setHmark(String hmark) {
        this.hmark = hmark;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getPyhyn() {
        return pyhyn;
    }

    public void setPyhyn(String pyhyn) {
        this.pyhyn = pyhyn;
    }

    public String getIsretmoney() {
        return isretmoney;
    }

    public void setIsretmoney(String isretmoney) {
        this.isretmoney = isretmoney;
    }

    public String getAcpno() {
        return acpno;
    }

    public void setAcpno(String acpno) {
        this.acpno = acpno;
    }

    public String getPaytn() {
        return paytn;
    }

    public void setPaytn(String paytn) {
        this.paytn = paytn;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public Double getIvomsfs() {
        return ivomsfs;
    }

    public void setIvomsfs(Double ivomsfs) {
        this.ivomsfs = ivomsfs;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSponr() {
        return sponr;
    }

    public void setSponr(String sponr) {
        this.sponr = sponr;
    }

    public String getApno() {
        return apno;
    }

    public void setApno(String apno) {
        this.apno = apno;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM811Model";
    }

    public Double getSum_taxfs() {
        return sum_taxfs;
    }

    public void setSum_taxfs(Double sum_taxfs) {
        this.sum_taxfs = sum_taxfs;
    }

    public Double getSum_bilnum8() {
        return sum_bilnum8;
    }

    public void setSum_bilnum8(Double sum_bilnum8) {
        this.sum_bilnum8 = sum_bilnum8;
    }

    public Double getSumivopsfs() {
        return sumivopsfs;
    }

    public void setSumivopsfs(Double sumivopsfs) {
        this.sumivopsfs = sumivopsfs;
    }

    public Double getSumivomsfs() {
        return sumivomsfs;
    }

    public void setSumivomsfs(Double sumivomsfs) {
        this.sumivomsfs = sumivomsfs;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getExpamt() {
        return expamt;
    }

    public void setExpamt(BigDecimal expamt) {
        this.expamt = expamt;
    }

    public BigDecimal getExpamtfs() {
        return expamtfs;
    }

    public void setExpamtfs(BigDecimal expamtfs) {
        this.expamtfs = expamtfs;
    }

    public BigDecimal getSum_apamt() {
        return sum_apamt;
    }

    public void setSum_apamt(BigDecimal sum_apamt) {
        this.sum_apamt = sum_apamt;
    }

    public BigDecimal getTotalfs() {
        return totalfs;
    }

    public void setTotalfs(BigDecimal totalfs) {
        this.totalfs = totalfs;
    }

    public BigDecimal getSum_apamtfs() {
        return sum_apamtfs;
    }

    public void setSum_apamtfs(BigDecimal sum_apamtfs) {
        this.sum_apamtfs = sum_apamtfs;
    }

    public String getIsAttachment() {
        return isAttachment;
    }

    public void setIsAttachment(String isAttachment) {
        this.isAttachment = isAttachment;
    }

}
