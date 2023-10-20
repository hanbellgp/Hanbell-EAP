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
@Table(name = "HK_CW018")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW018.findAll", query = "SELECT h FROM HKCW018 h"),
    @NamedQuery(name = "HKCW018.findByPSN", query = "SELECT h FROM HKCW018 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW018.findByFSN", query = "SELECT h FROM HKCW018 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW018.findBySerialNumber", query = "SELECT h FROM HKCW018 h WHERE h.serialNumber = :serialNumber")})
public class HKCW018 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "reason1")
    private String reason1;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "payWay")
    private String payWay;
    @Size(max = 255)
    @Column(name = "invoiceAmount")
    private String invoiceAmount;
    @Size(max = 255)
    @Column(name = "hdnManager")
    private String hdnManager;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payAmount4")
    private Double payAmount4;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Column(name = "payAmount2")
    private Double payAmount2;
    @Column(name = "payAmount3")
    private Double payAmount3;
    @Column(name = "payAmount1")
    private Double payAmount1;
    @Size(max = 255)
    @Column(name = "invoiceNumber")
    private String invoiceNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "payDate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate2;
    @Column(name = "payDate3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate3;
    @Column(name = "payDate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate1;
    @Column(name = "rate1")
    private Double rate1;
    @Column(name = "payInterest")
    private Double payInterest;
    @Size(max = 255)
    @Column(name = "appno")
    private String appno;
    @Size(max = 255)
    @Column(name = "hdnPurkind")
    private String hdnPurkind;
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
    @Column(name = "chargeInterest")
    private String chargeInterest;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "payWay1")
    private String payWay1;
    @Size(max = 255)
    @Column(name = "purkind")
    private String purkind;
    @Size(max = 255)
    @Column(name = "payWay2")
    private String payWay2;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "vdrds")
    private String vdrds;
    @Size(max = 255)
    @Column(name = "payprocess")
    private String payprocess;

    public HKCW018() {
    }

    public HKCW018(String oid) {
        this.oid = oid;
    }

    public String getReason1() {
        return reason1;
    }

    public void setReason1(String reason1) {
        this.reason1 = reason1;
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

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getHdnManager() {
        return hdnManager;
    }

    public void setHdnManager(String hdnManager) {
        this.hdnManager = hdnManager;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Double getPayAmount4() {
        return payAmount4;
    }

    public void setPayAmount4(Double payAmount4) {
        this.payAmount4 = payAmount4;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Double getPayAmount2() {
        return payAmount2;
    }

    public void setPayAmount2(Double payAmount2) {
        this.payAmount2 = payAmount2;
    }

    public Double getPayAmount3() {
        return payAmount3;
    }

    public void setPayAmount3(Double payAmount3) {
        this.payAmount3 = payAmount3;
    }

    public Double getPayAmount1() {
        return payAmount1;
    }

    public void setPayAmount1(Double payAmount1) {
        this.payAmount1 = payAmount1;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Date getPayDate2() {
        return payDate2;
    }

    public void setPayDate2(Date payDate2) {
        this.payDate2 = payDate2;
    }

    public Date getPayDate3() {
        return payDate3;
    }

    public void setPayDate3(Date payDate3) {
        this.payDate3 = payDate3;
    }

    public Date getPayDate1() {
        return payDate1;
    }

    public void setPayDate1(Date payDate1) {
        this.payDate1 = payDate1;
    }

    public Double getRate1() {
        return rate1;
    }

    public void setRate1(Double rate1) {
        this.rate1 = rate1;
    }

    public Double getPayInterest() {
        return payInterest;
    }

    public void setPayInterest(Double payInterest) {
        this.payInterest = payInterest;
    }

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getHdnPurkind() {
        return hdnPurkind;
    }

    public void setHdnPurkind(String hdnPurkind) {
        this.hdnPurkind = hdnPurkind;
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

    public String getChargeInterest() {
        return chargeInterest;
    }

    public void setChargeInterest(String chargeInterest) {
        this.chargeInterest = chargeInterest;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPayWay1() {
        return payWay1;
    }

    public void setPayWay1(String payWay1) {
        this.payWay1 = payWay1;
    }

    public String getPurkind() {
        return purkind;
    }

    public void setPurkind(String purkind) {
        this.purkind = purkind;
    }

    public String getPayWay2() {
        return payWay2;
    }

    public void setPayWay2(String payWay2) {
        this.payWay2 = payWay2;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
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
        if (!(object instanceof HKCW018)) {
            return false;
        }
        HKCW018 other = (HKCW018) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW018[ oid=" + oid + " ]";
    }
    
}
