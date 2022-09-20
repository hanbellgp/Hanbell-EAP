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
@Table(name = "HK_CW013")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW013.findAll", query = "SELECT h FROM HKCW013 h"),
    @NamedQuery(name = "HKCW013.findByTel1", query = "SELECT h FROM HKCW013 h WHERE h.tel1 = :tel1"),
    @NamedQuery(name = "HKCW013.findByAmountInWords", query = "SELECT h FROM HKCW013 h WHERE h.amountInWords = :amountInWords"),
    @NamedQuery(name = "HKCW013.findByCenterid", query = "SELECT h FROM HKCW013 h WHERE h.centerid = :centerid"),
    @NamedQuery(name = "HKCW013.findByInuser", query = "SELECT h FROM HKCW013 h WHERE h.inuser = :inuser"),
    @NamedQuery(name = "HKCW013.findByCmpCenterid", query = "SELECT h FROM HKCW013 h WHERE h.cmpCenterid = :cmpCenterid"),
    @NamedQuery(name = "HKCW013.findByFacno", query = "SELECT h FROM HKCW013 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW013.findByDmark", query = "SELECT h FROM HKCW013 h WHERE h.dmark = :dmark"),
    @NamedQuery(name = "HKCW013.findByPSN", query = "SELECT h FROM HKCW013 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW013.findByBankName", query = "SELECT h FROM HKCW013 h WHERE h.bankName = :bankName"),
    @NamedQuery(name = "HKCW013.findByHdnAmanager", query = "SELECT h FROM HKCW013 h WHERE h.hdnAmanager = :hdnAmanager"),
    @NamedQuery(name = "HKCW013.findByTickdays", query = "SELECT h FROM HKCW013 h WHERE h.tickdays = :tickdays"),
    @NamedQuery(name = "HKCW013.findByPaydate", query = "SELECT h FROM HKCW013 h WHERE h.paydate = :paydate"),
    @NamedQuery(name = "HKCW013.findByBudgetacc", query = "SELECT h FROM HKCW013 h WHERE h.budgetacc = :budgetacc"),
    @NamedQuery(name = "HKCW013.findByAppuser", query = "SELECT h FROM HKCW013 h WHERE h.appuser = :appuser"),
    @NamedQuery(name = "HKCW013.findByBilno", query = "SELECT h FROM HKCW013 h WHERE h.bilno = :bilno"),
    @NamedQuery(name = "HKCW013.findByTemamtfs", query = "SELECT h FROM HKCW013 h WHERE h.temamtfs = :temamtfs"),
    @NamedQuery(name = "HKCW013.findByAppdept", query = "SELECT h FROM HKCW013 h WHERE h.appdept = :appdept"),
    @NamedQuery(name = "HKCW013.findByCmpBudgetacc", query = "SELECT h FROM HKCW013 h WHERE h.cmpBudgetacc = :cmpBudgetacc"),
    @NamedQuery(name = "HKCW013.findByTotal", query = "SELECT h FROM HKCW013 h WHERE h.total = :total"),
    @NamedQuery(name = "HKCW013.findByAgreedPayment", query = "SELECT h FROM HKCW013 h WHERE h.agreedPayment = :agreedPayment"),
    @NamedQuery(name = "HKCW013.findByTemamt", query = "SELECT h FROM HKCW013 h WHERE h.temamt = :temamt"),
    @NamedQuery(name = "HKCW013.findByHmark", query = "SELECT h FROM HKCW013 h WHERE h.hmark = :hmark"),
    @NamedQuery(name = "HKCW013.findByVdrna", query = "SELECT h FROM HKCW013 h WHERE h.vdrna = :vdrna"),
    @NamedQuery(name = "HKCW013.findByFSN", query = "SELECT h FROM HKCW013 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW013.findByApsta", query = "SELECT h FROM HKCW013 h WHERE h.apsta = :apsta"),
    @NamedQuery(name = "HKCW013.findByTotalfs", query = "SELECT h FROM HKCW013 h WHERE h.totalfs = :totalfs"),
    @NamedQuery(name = "HKCW013.findByApno", query = "SELECT h FROM HKCW013 h WHERE h.apno = :apno"),
    @NamedQuery(name = "HKCW013.findByBankAccount", query = "SELECT h FROM HKCW013 h WHERE h.bankAccount = :bankAccount"),
    @NamedQuery(name = "HKCW013.findByExpamt", query = "SELECT h FROM HKCW013 h WHERE h.expamt = :expamt"),
    @NamedQuery(name = "HKCW013.findByVdrno", query = "SELECT h FROM HKCW013 h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HKCW013.findByOid", query = "SELECT h FROM HKCW013 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW013.findByApdsc", query = "SELECT h FROM HKCW013 h WHERE h.apdsc = :apdsc"),
    @NamedQuery(name = "HKCW013.findByTerdate", query = "SELECT h FROM HKCW013 h WHERE h.terdate = :terdate"),
    @NamedQuery(name = "HKCW013.findByCheck1", query = "SELECT h FROM HKCW013 h WHERE h.check1 = :check1"),
    @NamedQuery(name = "HKCW013.findByExpamtfs", query = "SELECT h FROM HKCW013 h WHERE h.expamtfs = :expamtfs"),
    @NamedQuery(name = "HKCW013.findBySerialNumber", query = "SELECT h FROM HKCW013 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW013.findByPurchaseOrder", query = "SELECT h FROM HKCW013 h WHERE h.purchaseOrder = :purchaseOrder"),
    @NamedQuery(name = "HKCW013.findByIndate", query = "SELECT h FROM HKCW013 h WHERE h.indate = :indate"),
    @NamedQuery(name = "HKCW013.findByPaytn", query = "SELECT h FROM HKCW013 h WHERE h.paytn = :paytn"),
    @NamedQuery(name = "HKCW013.findByAppdate", query = "SELECT h FROM HKCW013 h WHERE h.appdate = :appdate"),
    @NamedQuery(name = "HKCW013.findByVdrds", query = "SELECT h FROM HKCW013 h WHERE h.vdrds = :vdrds"),
    @NamedQuery(name = "HKCW013.findByOgdkid", query = "SELECT h FROM HKCW013 h WHERE h.ogdkid = :ogdkid"),
    @NamedQuery(name = "HKCW013.findByCoin", query = "SELECT h FROM HKCW013 h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKCW013.findByRatio", query = "SELECT h FROM HKCW013 h WHERE h.ratio = :ratio")})
public class HKCW013 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "amountInWords")
    private String amountInWords;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "inuser")
    private String inuser;
    @Size(max = 255)
    @Column(name = "cmp_centerid")
    private String cmpCenterid;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "bankName")
    private String bankName;
    @Size(max = 255)
    @Column(name = "hdnAmanager")
    private String hdnAmanager;
    @Size(max = 255)
    @Column(name = "tickdays")
    private String tickdays;
    @Size(max = 255)
    @Column(name = "paydate")
    private String paydate;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 255)
    @Column(name = "bilno")
    private String bilno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temamtfs")
    private Double temamtfs;
    @Size(max = 255)
    @Column(name = "appdept")
    private String appdept;
    @Size(max = 255)
    @Column(name = "cmp_budgetacc")
    private String cmpBudgetacc;
    @Column(name = "total")
    private Double total;
    @Size(max = 255)
    @Column(name = "agreedPayment")
    private String agreedPayment;
    @Column(name = "temamt")
    private Double temamt;
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
    @Column(name = "totalfs")
    private Double totalfs;
    @Size(max = 255)
    @Column(name = "apno")
    private String apno;
    @Size(max = 255)
    @Column(name = "bankAccount")
    private String bankAccount;
    @Size(max = 255)
    @Column(name = "expamt")
    private String expamt;
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
    @Column(name = "apdsc")
    private String apdsc;
    @Size(max = 255)
    @Column(name = "terdate")
    private String terdate;
    @Size(max = 255)
    @Column(name = "check1")
    private String check1;
    @Size(max = 255)
    @Column(name = "expamtfs")
    private String expamtfs;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "purchaseOrder")
    private String purchaseOrder;
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
    @Column(name = "vdrds")
    private String vdrds;
    @Size(max = 255)
    @Column(name = "ogdkid")
    private String ogdkid;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;

    public HKCW013() {
    }

    public HKCW013(String oid) {
        this.oid = oid;
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

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getInuser() {
        return inuser;
    }

    public void setInuser(String inuser) {
        this.inuser = inuser;
    }

    public String getCmpCenterid() {
        return cmpCenterid;
    }

    public void setCmpCenterid(String cmpCenterid) {
        this.cmpCenterid = cmpCenterid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getHdnAmanager() {
        return hdnAmanager;
    }

    public void setHdnAmanager(String hdnAmanager) {
        this.hdnAmanager = hdnAmanager;
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

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public Double getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(Double temamtfs) {
        this.temamtfs = temamtfs;
    }

    public String getAppdept() {
        return appdept;
    }

    public void setAppdept(String appdept) {
        this.appdept = appdept;
    }

    public String getCmpBudgetacc() {
        return cmpBudgetacc;
    }

    public void setCmpBudgetacc(String cmpBudgetacc) {
        this.cmpBudgetacc = cmpBudgetacc;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getAgreedPayment() {
        return agreedPayment;
    }

    public void setAgreedPayment(String agreedPayment) {
        this.agreedPayment = agreedPayment;
    }

    public Double getTemamt() {
        return temamt;
    }

    public void setTemamt(Double temamt) {
        this.temamt = temamt;
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

    public Double getTotalfs() {
        return totalfs;
    }

    public void setTotalfs(Double totalfs) {
        this.totalfs = totalfs;
    }

    public String getApno() {
        return apno;
    }

    public void setApno(String apno) {
        this.apno = apno;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getExpamt() {
        return expamt;
    }

    public void setExpamt(String expamt) {
        this.expamt = expamt;
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

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

    public String getTerdate() {
        return terdate;
    }

    public void setTerdate(String terdate) {
        this.terdate = terdate;
    }

    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getExpamtfs() {
        return expamtfs;
    }

    public void setExpamtfs(String expamtfs) {
        this.expamtfs = expamtfs;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
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

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW013)) {
            return false;
        }
        HKCW013 other = (HKCW013) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW013[ oid=" + oid + " ]";
    }
    
}
