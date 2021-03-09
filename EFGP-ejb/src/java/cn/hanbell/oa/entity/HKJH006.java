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
 * @author C2082
 */
@Entity
@Table(name = "HK_JH006")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH006.findAll", query = "SELECT h FROM HKJH006 h"),
    @NamedQuery(name = "HKJH006.findByFirstdiscount", query = "SELECT h FROM HKJH006 h WHERE h.firstdiscount = :firstdiscount"),
    @NamedQuery(name = "HKJH006.findByNumberaddrate", query = "SELECT h FROM HKJH006 h WHERE h.numberaddrate = :numberaddrate"),
    @NamedQuery(name = "HKJH006.findByHdncustomertype", query = "SELECT h FROM HKJH006 h WHERE h.hdncustomertype = :hdncustomertype"),
    @NamedQuery(name = "HKJH006.findByProcessSerialNumber", query = "SELECT h FROM HKJH006 h WHERE h.processSerialNumber = :processSerialNumber"),
    @NamedQuery(name = "HKJH006.findByExplanation", query = "SELECT h FROM HKJH006 h WHERE h.explanation = :explanation"),
    @NamedQuery(name = "HKJH006.findByBnumber", query = "SELECT h FROM HKJH006 h WHERE h.bnumber = :bnumber"),
    @NamedQuery(name = "HKJH006.findByPrincipal", query = "SELECT h FROM HKJH006 h WHERE h.principal = :principal"),
    @NamedQuery(name = "HKJH006.findByApplyUser", query = "SELECT h FROM HKJH006 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKJH006.findByNumber", query = "SELECT h FROM HKJH006 h WHERE h.number = :number"),
    @NamedQuery(name = "HKJH006.findByApplyDept", query = "SELECT h FROM HKJH006 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKJH006.findByFormSerialNumber", query = "SELECT h FROM HKJH006 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKJH006.findByCustomername", query = "SELECT h FROM HKJH006 h WHERE h.customername = :customername"),
    @NamedQuery(name = "HKJH006.findByCustomerno", query = "SELECT h FROM HKJH006 h WHERE h.customerno = :customerno"),
    @NamedQuery(name = "HKJH006.findByGetdiscount", query = "SELECT h FROM HKJH006 h WHERE h.getdiscount = :getdiscount"),
    @NamedQuery(name = "HKJH006.findByCustomertype", query = "SELECT h FROM HKJH006 h WHERE h.customertype = :customertype"),
    @NamedQuery(name = "HKJH006.findByAmount", query = "SELECT h FROM HKJH006 h WHERE h.amount = :amount"),
    @NamedQuery(name = "HKJH006.findByApplyreason", query = "SELECT h FROM HKJH006 h WHERE h.applyreason = :applyreason"),
    @NamedQuery(name = "HKJH006.findByPeriod", query = "SELECT h FROM HKJH006 h WHERE h.period = :period"),
    @NamedQuery(name = "HKJH006.findByAmountaddrate", query = "SELECT h FROM HKJH006 h WHERE h.amountaddrate = :amountaddrate"),
    @NamedQuery(name = "HKJH006.findByBegdate", query = "SELECT h FROM HKJH006 h WHERE h.begdate = :begdate"),
    @NamedQuery(name = "HKJH006.findByBamount", query = "SELECT h FROM HKJH006 h WHERE h.bamount = :bamount"),
    @NamedQuery(name = "HKJH006.findByHdnapmanager", query = "SELECT h FROM HKJH006 h WHERE h.hdnapmanager = :hdnapmanager"),
    @NamedQuery(name = "HKJH006.findByOid", query = "SELECT h FROM HKJH006 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH006.findByDiscountrate", query = "SELECT h FROM HKJH006 h WHERE h.discountrate = :discountrate"),
    @NamedQuery(name = "HKJH006.findByBdiscountamount", query = "SELECT h FROM HKJH006 h WHERE h.bdiscountamount = :bdiscountamount"),
    @NamedQuery(name = "HKJH006.findByBdiscountrate", query = "SELECT h FROM HKJH006 h WHERE h.bdiscountrate = :bdiscountrate"),
    @NamedQuery(name = "HKJH006.findByAdiscountrate", query = "SELECT h FROM HKJH006 h WHERE h.adiscountrate = :adiscountrate"),
    @NamedQuery(name = "HKJH006.findByApplyDate", query = "SELECT h FROM HKJH006 h WHERE h.applyDate = :applyDate")})
public class HKJH006 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "firstdiscount")
    private String firstdiscount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "numberaddrate")
    private Double numberaddrate;
    @Size(max = 255)
    @Column(name = "hdncustomertype")
    private String hdncustomertype;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "explanation")
    private String explanation;
    @Column(name = "bnumber")
    private Double bnumber;
    @Size(max = 255)
    @Column(name = "principal")
    private String principal;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "number")
    private String number;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "customername")
    private String customername;
    @Size(max = 255)
    @Column(name = "customerno")
    private String customerno;
    @Size(max = 255)
    @Column(name = "getdiscount")
    private String getdiscount;
    @Size(max = 255)
    @Column(name = "customertype")
    private String customertype;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "applyreason")
    private String applyreason;
    @Size(max = 255)
    @Column(name = "period")
    private String period;
    @Column(name = "amountaddrate")
    private Double amountaddrate;
    @Size(max = 255)
    @Column(name = "begdate")
    private String begdate;
    @Column(name = "bamount")
    private Double bamount;
    @Size(max = 255)
    @Column(name = "hdnapmanager")
    private String hdnapmanager;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "discountrate")
    private String discountrate;
    @Size(max = 255)
    @Column(name = "bdiscountamount")
    private String bdiscountamount;
    @Size(max = 255)
    @Column(name = "bdiscountrate")
    private String bdiscountrate;
    @Size(max = 255)
    @Column(name = "adiscountrate")
    private String adiscountrate;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;

    public HKJH006() {
    }

    public HKJH006(String oid) {
        this.oid = oid;
    }

    public String getFirstdiscount() {
        return firstdiscount;
    }

    public void setFirstdiscount(String firstdiscount) {
        this.firstdiscount = firstdiscount;
    }

    public Double getNumberaddrate() {
        return numberaddrate;
    }

    public void setNumberaddrate(Double numberaddrate) {
        this.numberaddrate = numberaddrate;
    }

    public String getHdncustomertype() {
        return hdncustomertype;
    }

    public void setHdncustomertype(String hdncustomertype) {
        this.hdncustomertype = hdncustomertype;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Double getBnumber() {
        return bnumber;
    }

    public void setBnumber(Double bnumber) {
        this.bnumber = bnumber;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getGetdiscount() {
        return getdiscount;
    }

    public void setGetdiscount(String getdiscount) {
        this.getdiscount = getdiscount;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getAmountaddrate() {
        return amountaddrate;
    }

    public void setAmountaddrate(Double amountaddrate) {
        this.amountaddrate = amountaddrate;
    }

    public String getBegdate() {
        return begdate;
    }

    public void setBegdate(String begdate) {
        this.begdate = begdate;
    }

    public Double getBamount() {
        return bamount;
    }

    public void setBamount(Double bamount) {
        this.bamount = bamount;
    }

    public String getHdnapmanager() {
        return hdnapmanager;
    }

    public void setHdnapmanager(String hdnapmanager) {
        this.hdnapmanager = hdnapmanager;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(String discountrate) {
        this.discountrate = discountrate;
    }

    public String getBdiscountamount() {
        return bdiscountamount;
    }

    public void setBdiscountamount(String bdiscountamount) {
        this.bdiscountamount = bdiscountamount;
    }

    public String getBdiscountrate() {
        return bdiscountrate;
    }

    public void setBdiscountrate(String bdiscountrate) {
        this.bdiscountrate = bdiscountrate;
    }

    public String getAdiscountrate() {
        return adiscountrate;
    }

    public void setAdiscountrate(String adiscountrate) {
        this.adiscountrate = adiscountrate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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
        if (!(object instanceof HKJH006)) {
            return false;
        }
        HKJH006 other = (HKJH006) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH006[ oid=" + oid + " ]";
    }
    
}
