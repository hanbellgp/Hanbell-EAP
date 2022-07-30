/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
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
 * @author C0160
 */
@Entity
@Table(name = "SHB_ERP_APM828")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "SHBERPAPM828.findAll", query = "SELECT s FROM SHBERPAPM828 s"),
    @NamedQuery(name = "SHBERPAPM828.findByPSN",
        query = "SELECT s FROM SHBERPAPM828 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SHBERPAPM828.findByFSN",
        query = "SELECT s FROM SHBERPAPM828 s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPAPM828.findByOID", query = "SELECT s FROM SHBERPAPM828 s WHERE s.oid = :oid")})
public class SHBERPAPM828 implements Serializable {

    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "apamtfs")
    private Double apamtfs;
    @Size(max = 255)
    @Column(name = "apdsc")
    private String apdsc;
    @Size(max = 255)
    @Column(name = "apamt")
    private String apamt;
    @Size(max = 255)
    @Column(name = "hdnappuser")
    private String hdnappuser;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;
    @Size(max = 255)
    @Column(name = "agreedPayment")
    private String agreedPayment;
    @Size(max = 255)
    @Column(name = "check1")
    private String check1;
    @Size(max = 255)
    @Column(name = "purchaseOrder")
    private String purchaseOrder;
    @Size(max = 255)
    @Column(name = "hdnAmanager")
    private String hdnAmanager;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "amountInWords")
    private String amountInWords;
    @Size(max = 255)
    @Column(name = "vdrds")
    private String vdrds;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "inuser")
    private String inuser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "tickdays")
    private String tickdays;
    @Size(max = 255)
    @Column(name = "paydate")
    private String paydate;
    @Size(max = 255)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 255)
    @Column(name = "appdept")
    private String appdept;
    @Size(max = 255)
    @Column(name = "total")
    private String total;
    @Size(max = 255)
    @Column(name = "hmark")
    private String hmark;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "apsta")
    private String apsta;
    @Size(max = 255)
    @Column(name = "trapyh")
    private String trapyh;
    @Size(max = 255)
    @Column(name = "totalfs")
    private String totalfs;
    @Size(max = 255)
    @Column(name = "apno")
    private String apno;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "terdate")
    private String terdate;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "pyhyn")
    private String pyhyn;
    @Size(max = 255)
    @Column(name = "aptyp")
    private String aptyp;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 255)
    @Column(name = "paytn")
    private String paytn;
    @Column(name = "appdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appdate;
    @Size(max = 255)
    @Column(name = "ogdkid")
    private String ogdkid;
    @Size(max = 255)
    @Column(name = "accno")
    private String accno;
    @Size(max = 255)
    @Column(name = "rkd")
    private String rkd;
    @Size(max = 255)
    @Column(name = "config")
    private String config;
    @Column(name = "payda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payda;
    @Size(max = 255)
    @Column(name = "bankName")
    private String bankName;
    @Size(max = 255)
    @Column(name = "bankAccount")
    private String bankAccount;

    public SHBERPAPM828() {
    }

    public SHBERPAPM828(String oid) {
        this.oid = oid;
    }

    public String getInuser() {
        return inuser;
    }

    public void setInuser(String inuser) {
        this.inuser = inuser;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getTickdays() {
        return tickdays;
    }

    public void setTickdays(String tickdays) {
        this.tickdays = tickdays;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getAppdept() {
        return appdept;
    }

    public void setAppdept(String appdept) {
        this.appdept = appdept;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getHmark() {
        return hmark;
    }

    public void setHmark(String hmark) {
        this.hmark = hmark;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getApsta() {
        return apsta;
    }

    public void setApsta(String apsta) {
        this.apsta = apsta;
    }

    public String getTrapyh() {
        return trapyh;
    }

    public void setTrapyh(String trapyh) {
        this.trapyh = trapyh;
    }

    public String getTotalfs() {
        return totalfs;
    }

    public void setTotalfs(String totalfs) {
        this.totalfs = totalfs;
    }

    public String getApno() {
        return apno;
    }

    public void setApno(String apno) {
        this.apno = apno;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTerdate() {
        return terdate;
    }

    public void setTerdate(String terdate) {
        this.terdate = terdate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPyhyn() {
        return pyhyn;
    }

    public void setPyhyn(String pyhyn) {
        this.pyhyn = pyhyn;
    }

    public String getAptyp() {
        return aptyp;
    }

    public void setAptyp(String aptyp) {
        this.aptyp = aptyp;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getPaytn() {
        return paytn;
    }

    public void setPaytn(String paytn) {
        this.paytn = paytn;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getRkd() {
        return rkd;
    }

    public void setRkd(String rkd) {
        this.rkd = rkd;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Date getPayda() {
        return payda;
    }

    public void setPayda(Date payda) {
        this.payda = payda;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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
        if (!(object instanceof SHBERPAPM828)) {
            return false;
        }
        SHBERPAPM828 other = (SHBERPAPM828)object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM828[ oid=" + oid + " ]";
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public Double getApamtfs() {
        return apamtfs;
    }

    public void setApamtfs(Double apamtfs) {
        this.apamtfs = apamtfs;
    }

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

    public String getApamt() {
        return apamt;
    }

    public void setApamt(String apamt) {
        this.apamt = apamt;
    }

    public String getHdnappuser() {
        return hdnappuser;
    }

    public void setHdnappuser(String hdnappuser) {
        this.hdnappuser = hdnappuser;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getAgreedPayment() {
        return agreedPayment;
    }

    public void setAgreedPayment(String agreedPayment) {
        this.agreedPayment = agreedPayment;
    }

    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getHdnAmanager() {
        return hdnAmanager;
    }

    public void setHdnAmanager(String hdnAmanager) {
        this.hdnAmanager = hdnAmanager;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
    }

}
