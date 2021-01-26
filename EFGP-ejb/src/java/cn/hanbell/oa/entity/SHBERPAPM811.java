/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "SHB_ERP_APM811")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPAPM811.findAll", query = "SELECT s FROM SHBERPAPM811 s"),
    @NamedQuery(name = "SHBERPAPM811.findByItnbr", query = "SELECT s FROM SHBERPAPM811 s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPAPM811.findByAcpamtfs", query = "SELECT s FROM SHBERPAPM811 s WHERE s.acpamtfs = :acpamtfs"),
    @NamedQuery(name = "SHBERPAPM811.findByPSN", query = "SELECT s FROM SHBERPAPM811 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SHBERPAPM811.findByApno", query = "SELECT s FROM SHBERPAPM811 s WHERE s.apno = :apno"),
    @NamedQuery(name = "SHBERPAPM811.findByBilno", query = "SELECT s FROM SHBERPAPM811 s WHERE s.bilno = :bilno"),
    @NamedQuery(name = "SHBERPAPM811.findByVdrno", query = "SELECT s FROM SHBERPAPM811 s WHERE s.vdrno = :vdrno"),
    @NamedQuery(name = "SHBERPAPM811.findByFSN", query = "SELECT s FROM SHBERPAPM811 s WHERE s.formSerialNumber = :fsn")})
public class SHBERPAPM811 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Size(max = 255)
    @Column(name = "apsta")
    private String apsta;
    @Size(max = 255)
    @Column(name = "terdate")
    private String terdate;
    @Column(name = "expamt")
    private Double expamt;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Column(name = "sum_taxfs")
    private Double sumTaxfs;
    @Column(name = "pric")
    private Double pric;
    @Size(max = 255)
    @Column(name = "ogdkid")
    private String ogdkid;
    @Column(name = "preamtfs")
    private Double preamtfs;
    @Column(name = "ivopsfs")
    private Double ivopsfs;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "trapyh")
    private String trapyh;
    @Column(name = "appdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appdate;
    @Column(name = "sum_tax")
    private Double sumTax;
    @Column(name = "sum_bilnum8fs")
    private Double sumBilnum8fs;
    @Column(name = "temamtfs")
    private Double temamtfs;
    @Column(name = "com_apamtfs")
    private Double comApamtfs;
    @Column(name = "expamtfs")
    private Double expamtfs;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;
    @Size(max = 255)
    @Column(name = "aptyp")
    private String aptyp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "appdept")
    private String appdept;
    @Column(name = "sum_apamt")
    private Double sumApamt;
    @Column(name = "losamtfs")
    private Double losamtfs;
    @Size(max = 255)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "inuser")
    private String inuser;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Column(name = "totalfs")
    private Double totalfs;
    @Column(name = "sum_apamtfs")
    private Double sumApamtfs;
    @Size(max = 255)
    @Column(name = "tickdays")
    private String tickdays;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Column(name = "acpamtfs")
    private Double acpamtfs;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "payqty")
    private Double payqty;
    @Size(max = 255)
    @Column(name = "hmark")
    private String hmark;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "pyhyn")
    private String pyhyn;
    @Size(max = 255)
    @Column(name = "isretmoney")
    private String isretmoney;
    @Size(max = 255)
    @Column(name = "acpno")
    private String acpno;
    @Size(max = 255)
    @Column(name = "paytn")
    private String paytn;
    @Size(max = 255)
    @Column(name = "paydate")
    private String paydate;
    @Column(name = "ivomsfs")
    private Double ivomsfs;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "sponr")
    private String sponr;
    @Size(max = 255)
    @Column(name = "apno")
    private String apno;
    @Column(name = "sum_bilnum8")
    private Double sumBilnum8;
    @Size(max = 255)
    @Column(name = "bilno")
    private String bilno;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "sumivopsfs")
    private Double sumIvopsfs;
    @Column(name = "sumivomsfs")
    private Double sumIvomsfs;

    public SHBERPAPM811() {
    }

    public SHBERPAPM811(String oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public Double getExpamt() {
        return expamt;
    }

    public void setExpamt(Double expamt) {
        this.expamt = expamt;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public Double getSumTaxfs() {
        return sumTaxfs;
    }

    public void setSumTaxfs(Double sumTaxfs) {
        this.sumTaxfs = sumTaxfs;
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

    public Double getSumTax() {
        return sumTax;
    }

    public void setSumTax(Double sumTax) {
        this.sumTax = sumTax;
    }

    public Double getSumBilnum8fs() {
        return sumBilnum8fs;
    }

    public void setSumBilnum8fs(Double sumBilnum8fs) {
        this.sumBilnum8fs = sumBilnum8fs;
    }

    public Double getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(Double temamtfs) {
        this.temamtfs = temamtfs;
    }

    public Double getComApamtfs() {
        return comApamtfs;
    }

    public void setComApamtfs(Double comApamtfs) {
        this.comApamtfs = comApamtfs;
    }

    public Double getExpamtfs() {
        return expamtfs;
    }

    public void setExpamtfs(Double expamtfs) {
        this.expamtfs = expamtfs;
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

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAppdept() {
        return appdept;
    }

    public void setAppdept(String appdept) {
        this.appdept = appdept;
    }

    public Double getSumApamt() {
        return sumApamt;
    }

    public void setSumApamt(Double sumApamt) {
        this.sumApamt = sumApamt;
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

    public Double getTotalfs() {
        return totalfs;
    }

    public void setTotalfs(Double totalfs) {
        this.totalfs = totalfs;
    }

    public Double getSumApamtfs() {
        return sumApamtfs;
    }

    public void setSumApamtfs(Double sumApamtfs) {
        this.sumApamtfs = sumApamtfs;
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

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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

    public Double getSumBilnum8() {
        return sumBilnum8;
    }

    public void setSumBilnum8(Double sumBilnum8) {
        this.sumBilnum8 = sumBilnum8;
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

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SHBERPAPM811)) {
            return false;
        }
        SHBERPAPM811 other = (SHBERPAPM811) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.app.SHBERPAPM811[ oid=" + oid + " ]";
    }

    public Double getSumIvopsfs() {
        return sumIvopsfs;
    }

    public void setSumIvopsfs(Double sumIvopsfs) {
        this.sumIvopsfs = sumIvopsfs;
    }

    public Double getSumIvomsfs() {
        return sumIvomsfs;
    }

    public void setSumIvomsfs(Double sumIvomsfs) {
        this.sumIvomsfs = sumIvomsfs;
    }

}
