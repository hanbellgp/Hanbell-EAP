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
@Table(name = "VH_TV005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV005.findAll", query = "SELECT v FROM VHTV005 v"),
    @NamedQuery(name = "VHTV005.findByTel1", query = "SELECT v FROM VHTV005 v WHERE v.tel1 = :tel1"),
    @NamedQuery(name = "VHTV005.findByAmountInWords", query = "SELECT v FROM VHTV005 v WHERE v.amountInWords = :amountInWords"),
    @NamedQuery(name = "VHTV005.findByCenterid", query = "SELECT v FROM VHTV005 v WHERE v.centerid = :centerid"),
    @NamedQuery(name = "VHTV005.findByInuser", query = "SELECT v FROM VHTV005 v WHERE v.inuser = :inuser"),
    @NamedQuery(name = "VHTV005.findByCmpCenterid", query = "SELECT v FROM VHTV005 v WHERE v.cmpCenterid = :cmpCenterid"),
    @NamedQuery(name = "VHTV005.findByFacno", query = "SELECT v FROM VHTV005 v WHERE v.facno = :facno"),
    @NamedQuery(name = "VHTV005.findByAcpamtfs", query = "SELECT v FROM VHTV005 v WHERE v.acpamtfs = :acpamtfs"),
    @NamedQuery(name = "VHTV005.findByDmark", query = "SELECT v FROM VHTV005 v WHERE v.dmark = :dmark"),
    @NamedQuery(name = "VHTV005.findByProcessSerialNumber", query = "SELECT v FROM VHTV005 v WHERE v.processSerialNumber = :processSerialNumber"),
    @NamedQuery(name = "VHTV005.findByCmpSumTax", query = "SELECT v FROM VHTV005 v WHERE v.cmpSumTax = :cmpSumTax"),
    @NamedQuery(name = "VHTV005.findByBankName", query = "SELECT v FROM VHTV005 v WHERE v.bankName = :bankName"),
    @NamedQuery(name = "VHTV005.findByHdnAmanager", query = "SELECT v FROM VHTV005 v WHERE v.hdnAmanager = :hdnAmanager"),
    @NamedQuery(name = "VHTV005.findByTickdays", query = "SELECT v FROM VHTV005 v WHERE v.tickdays = :tickdays"),
    @NamedQuery(name = "VHTV005.findByPaydate", query = "SELECT v FROM VHTV005 v WHERE v.paydate = :paydate"),
    @NamedQuery(name = "VHTV005.findByBudgetacc", query = "SELECT v FROM VHTV005 v WHERE v.budgetacc = :budgetacc"),
    @NamedQuery(name = "VHTV005.findByAppuser", query = "SELECT v FROM VHTV005 v WHERE v.appuser = :appuser"),
    @NamedQuery(name = "VHTV005.findByBilno", query = "SELECT v FROM VHTV005 v WHERE v.bilno = :bilno"),
    @NamedQuery(name = "VHTV005.findByTemamtfs", query = "SELECT v FROM VHTV005 v WHERE v.temamtfs = :temamtfs"),
    @NamedQuery(name = "VHTV005.findByAppdept", query = "SELECT v FROM VHTV005 v WHERE v.appdept = :appdept"),
    @NamedQuery(name = "VHTV005.findByCmpBudgetacc", query = "SELECT v FROM VHTV005 v WHERE v.cmpBudgetacc = :cmpBudgetacc"),
    @NamedQuery(name = "VHTV005.findByTotal", query = "SELECT v FROM VHTV005 v WHERE v.total = :total"),
    @NamedQuery(name = "VHTV005.findByAgreedPayment", query = "SELECT v FROM VHTV005 v WHERE v.agreedPayment = :agreedPayment"),
    @NamedQuery(name = "VHTV005.findByAcpamt", query = "SELECT v FROM VHTV005 v WHERE v.acpamt = :acpamt"),
    @NamedQuery(name = "VHTV005.findByTemamt", query = "SELECT v FROM VHTV005 v WHERE v.temamt = :temamt"),
    @NamedQuery(name = "VHTV005.findByHmark", query = "SELECT v FROM VHTV005 v WHERE v.hmark = :hmark"),
    @NamedQuery(name = "VHTV005.findByVdrna", query = "SELECT v FROM VHTV005 v WHERE v.vdrna = :vdrna"),
    @NamedQuery(name = "VHTV005.findByFormSerialNumber", query = "SELECT v FROM VHTV005 v WHERE v.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "VHTV005.findByApsta", query = "SELECT v FROM VHTV005 v WHERE v.apsta = :apsta"),
    @NamedQuery(name = "VHTV005.findByTotalfs", query = "SELECT v FROM VHTV005 v WHERE v.totalfs = :totalfs"),
    @NamedQuery(name = "VHTV005.findByApno", query = "SELECT v FROM VHTV005 v WHERE v.apno = :apno"),
    @NamedQuery(name = "VHTV005.findByBankAccount", query = "SELECT v FROM VHTV005 v WHERE v.bankAccount = :bankAccount"),
    @NamedQuery(name = "VHTV005.findByPayqty", query = "SELECT v FROM VHTV005 v WHERE v.payqty = :payqty"),
    @NamedQuery(name = "VHTV005.findByComApamtfs", query = "SELECT v FROM VHTV005 v WHERE v.comApamtfs = :comApamtfs"),
    @NamedQuery(name = "VHTV005.findByVdrno", query = "SELECT v FROM VHTV005 v WHERE v.vdrno = :vdrno"),
    @NamedQuery(name = "VHTV005.findByOid", query = "SELECT v FROM VHTV005 v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHTV005.findByApdsc", query = "SELECT v FROM VHTV005 v WHERE v.apdsc = :apdsc"),
    @NamedQuery(name = "VHTV005.findByTerdate", query = "SELECT v FROM VHTV005 v WHERE v.terdate = :terdate"),
    @NamedQuery(name = "VHTV005.findByCheck1", query = "SELECT v FROM VHTV005 v WHERE v.check1 = :check1"),
    @NamedQuery(name = "VHTV005.findByComApamt", query = "SELECT v FROM VHTV005 v WHERE v.comApamt = :comApamt"),
    @NamedQuery(name = "VHTV005.findBySerialNumber", query = "SELECT v FROM VHTV005 v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "VHTV005.findByPurchaseOrder", query = "SELECT v FROM VHTV005 v WHERE v.purchaseOrder = :purchaseOrder"),
    @NamedQuery(name = "VHTV005.findByIndate", query = "SELECT v FROM VHTV005 v WHERE v.indate = :indate"),
    @NamedQuery(name = "VHTV005.findByPaytn", query = "SELECT v FROM VHTV005 v WHERE v.paytn = :paytn"),
    @NamedQuery(name = "VHTV005.findByAppdate", query = "SELECT v FROM VHTV005 v WHERE v.appdate = :appdate"),
    @NamedQuery(name = "VHTV005.findByVdrds", query = "SELECT v FROM VHTV005 v WHERE v.vdrds = :vdrds"),
    @NamedQuery(name = "VHTV005.findByCoin", query = "SELECT v FROM VHTV005 v WHERE v.coin = :coin"),
    @NamedQuery(name = "VHTV005.findByRatio", query = "SELECT v FROM VHTV005 v WHERE v.ratio = :ratio")})
public class VHTV005 implements Serializable {

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
    @Column(name = "acpamtfs")
    private String acpamtfs;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "cmp_sum_tax")
    private String cmpSumTax;
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
    @Size(max = 255)
    @Column(name = "acpamt")
    private String acpamt;
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
    @Column(name = "payqty")
    private String payqty;
    @Size(max = 255)
    @Column(name = "com_apamtfs")
    private String comApamtfs;
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
    @Column(name = "com_apamt")
    private String comApamt;
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
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;

    public VHTV005() {
    }

    public VHTV005(String oid) {
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

    public String getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(String acpamtfs) {
        this.acpamtfs = acpamtfs;
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

    public String getCmpSumTax() {
        return cmpSumTax;
    }

    public void setCmpSumTax(String cmpSumTax) {
        this.cmpSumTax = cmpSumTax;
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

    public String getAcpamt() {
        return acpamt;
    }

    public void setAcpamt(String acpamt) {
        this.acpamt = acpamt;
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

    public String getPayqty() {
        return payqty;
    }

    public void setPayqty(String payqty) {
        this.payqty = payqty;
    }

    public String getComApamtfs() {
        return comApamtfs;
    }

    public void setComApamtfs(String comApamtfs) {
        this.comApamtfs = comApamtfs;
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

    public String getComApamt() {
        return comApamt;
    }

    public void setComApamt(String comApamt) {
        this.comApamt = comApamt;
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
        if (!(object instanceof VHTV005)) {
            return false;
        }
        VHTV005 other = (VHTV005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV005[ oid=" + oid + " ]";
    }
    
}
