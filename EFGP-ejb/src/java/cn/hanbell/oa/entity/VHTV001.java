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
@Table(name = "VH_TV001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV001.findAll", query = "SELECT v FROM VHTV001 v"),
    @NamedQuery(name = "VHTV001.findByOID", query = "SELECT v FROM VHTV001 v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHTV001.findByPSN", query = "SELECT v FROM VHTV001 v WHERE v.processSerialNumber = :psn"),
    @NamedQuery(name = "VHTV001.findByFSN", query = "SELECT v FROM VHTV001 v WHERE v.formSerialNumber = :fsn")})
public class VHTV001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "other")
    private Double other;
    @Column(name = "allowance")
    private Double allowance;
    @Column(name = "totalRMB")
    private Double totalRMB;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Column(name = "prePayDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prePayDate;
    @Size(max = 255)
    @Column(name = "exception")
    private String exception;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Column(name = "entertain")
    private Double entertain;
    @Size(max = 255)
    @Column(name = "Textbox6")
    private String textbox6;
    @Size(max = 255)
    @Column(name = "preCustomer")
    private String preCustomer;
    @Size(max = 255)
    @Column(name = "Textbox7")
    private String textbox7;
    @Size(max = 255)
    @Column(name = "preLocation")
    private String preLocation;
    @Column(name = "people")
    private Integer people;
    @Column(name = "trafficfee")
    private Double trafficfee;
    @Size(max = 255)
    @Column(name = "preAccno")
    private String preAccno;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "loanTotal")
    private Double loanTotal;
    @Size(max = 255)
    @Column(name = "hdnloanUser")
    private String hdnloanUser;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "hdnloanDept")
    private String hdnloanDept;
    @Size(max = 255)
    @Column(name = "preAccname")
    private String preAccname;
    @Column(name = "deptPeriod")
    private Double deptPeriod;
    @Size(max = 255)
    @Column(name = "hdncreator")
    private String hdncreator;
    @Column(name = "deptYear")
    private Double deptYear;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "loanUser")
    private String loanUser;
    @Size(max = 255)
    @Column(name = "loanProperty")
    private String loanProperty;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "loanDept")
    private String loanDept;
    @Size(max = 255)
    @Column(name = "hdnfacno")
    private String hdnfacno;
    @Column(name = "arrears")
    private Double arrears;
    @Column(name = "days")
    private Double days;
    @Column(name = "ratio")
    private Double ratio;
    @Column(name = "accommodation")
    private Double accommodation;
    @Column(name = "loanDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loanDate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdnloanProperty")
    private String hdnloanProperty;

    public VHTV001() {
    }

    public VHTV001(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public Double getTotalRMB() {
        return totalRMB;
    }

    public void setTotalRMB(Double totalRMB) {
        this.totalRMB = totalRMB;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getPrePayDate() {
        return prePayDate;
    }

    public void setPrePayDate(Date prePayDate) {
        this.prePayDate = prePayDate;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public Double getEntertain() {
        return entertain;
    }

    public void setEntertain(Double entertain) {
        this.entertain = entertain;
    }

    public String getTextbox6() {
        return textbox6;
    }

    public void setTextbox6(String textbox6) {
        this.textbox6 = textbox6;
    }

    public String getPreCustomer() {
        return preCustomer;
    }

    public void setPreCustomer(String preCustomer) {
        this.preCustomer = preCustomer;
    }

    public String getTextbox7() {
        return textbox7;
    }

    public void setTextbox7(String textbox7) {
        this.textbox7 = textbox7;
    }

    public String getPreLocation() {
        return preLocation;
    }

    public void setPreLocation(String preLocation) {
        this.preLocation = preLocation;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Double getTrafficfee() {
        return trafficfee;
    }

    public void setTrafficfee(Double trafficfee) {
        this.trafficfee = trafficfee;
    }

    public String getPreAccno() {
        return preAccno;
    }

    public void setPreAccno(String preAccno) {
        this.preAccno = preAccno;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(Double loanTotal) {
        this.loanTotal = loanTotal;
    }

    public String getHdnloanUser() {
        return hdnloanUser;
    }

    public void setHdnloanUser(String hdnloanUser) {
        this.hdnloanUser = hdnloanUser;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getHdnloanDept() {
        return hdnloanDept;
    }

    public void setHdnloanDept(String hdnloanDept) {
        this.hdnloanDept = hdnloanDept;
    }

    public String getPreAccname() {
        return preAccname;
    }

    public void setPreAccname(String preAccname) {
        this.preAccname = preAccname;
    }

    public Double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(Double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public String getHdncreator() {
        return hdncreator;
    }

    public void setHdncreator(String hdncreator) {
        this.hdncreator = hdncreator;
    }

    public Double getDeptYear() {
        return deptYear;
    }

    public void setDeptYear(Double deptYear) {
        this.deptYear = deptYear;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(String loanUser) {
        this.loanUser = loanUser;
    }

    public String getLoanProperty() {
        return loanProperty;
    }

    public void setLoanProperty(String loanProperty) {
        this.loanProperty = loanProperty;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLoanDept() {
        return loanDept;
    }

    public void setLoanDept(String loanDept) {
        this.loanDept = loanDept;
    }

    public String getHdnfacno() {
        return hdnfacno;
    }

    public void setHdnfacno(String hdnfacno) {
        this.hdnfacno = hdnfacno;
    }

    public Double getArrears() {
        return arrears;
    }

    public void setArrears(Double arrears) {
        this.arrears = arrears;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Double accommodation) {
        this.accommodation = accommodation;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnloanProperty() {
        return hdnloanProperty;
    }

    public void setHdnloanProperty(String hdnloanProperty) {
        this.hdnloanProperty = hdnloanProperty;
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
        if (!(object instanceof VHTV001)) {
            return false;
        }
        VHTV001 other = (VHTV001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV001[ oid=" + oid + " ]";
    }

}
