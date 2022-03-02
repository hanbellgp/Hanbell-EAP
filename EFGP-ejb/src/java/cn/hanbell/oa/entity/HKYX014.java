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
@Table(name = "HK_YX014")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX014.findAll", query = "SELECT h FROM HKYX014 h"),
    @NamedQuery(name = "HKYX014.findByReason", query = "SELECT h FROM HKYX014 h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKYX014.findByAmount", query = "SELECT h FROM HKYX014 h WHERE h.amount = :amount"),
    @NamedQuery(name = "HKYX014.findByHdndivision", query = "SELECT h FROM HKYX014 h WHERE h.hdndivision = :hdndivision"),
    @NamedQuery(name = "HKYX014.findByCode1", query = "SELECT h FROM HKYX014 h WHERE h.code1 = :code1"),
    @NamedQuery(name = "HKYX014.findByFacno", query = "SELECT h FROM HKYX014 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKYX014.findByCustomerPerson", query = "SELECT h FROM HKYX014 h WHERE h.customerPerson = :customerPerson"),
    @NamedQuery(name = "HKYX014.findByPSN", query = "SELECT h FROM HKYX014 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKYX014.findByOldQuotationNo", query = "SELECT h FROM HKYX014 h WHERE h.oldQuotationNo = :oldQuotationNo"),
    @NamedQuery(name = "HKYX014.findBySealfacno", query = "SELECT h FROM HKYX014 h WHERE h.sealfacno = :sealfacno"),
    @NamedQuery(name = "HKYX014.findByOID", query = "SELECT h FROM HKYX014 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKYX014.findByQuotationNo", query = "SELECT h FROM HKYX014 h WHERE h.quotationNo = :quotationNo"),
    @NamedQuery(name = "HKYX014.findByDivision", query = "SELECT h FROM HKYX014 h WHERE h.division = :division"),
    @NamedQuery(name = "HKYX014.findByApplyUser", query = "SELECT h FROM HKYX014 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKYX014.findByApplyDept", query = "SELECT h FROM HKYX014 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKYX014.findByProjectno", query = "SELECT h FROM HKYX014 h WHERE h.projectno = :projectno"),
    @NamedQuery(name = "HKYX014.findBySerialNumber", query = "SELECT h FROM HKYX014 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKYX014.findByFSN", query = "SELECT h FROM HKYX014 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKYX014.findByApplyDate", query = "SELECT h FROM HKYX014 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HKYX014.findByCoin", query = "SELECT h FROM HKYX014 h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKYX014.findByCustomer", query = "SELECT h FROM HKYX014 h WHERE h.customer = :customer")})
public class HKYX014 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "hdndivision")
    private String hdndivision;
    @Size(max = 255)
    @Column(name = "code1")
    private String code1;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "customerPerson")
    private String customerPerson;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "oldQuotationNo")
    private String oldQuotationNo;
    @Size(max = 255)
    @Column(name = "sealfacno")
    private String sealfacno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "quotationNo")
    private String quotationNo;
    @Size(max = 255)
    @Column(name = "division")
    private String division;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "projectno")
    private String projectno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "customer")
    private String customer;

    public HKYX014() {
    }

    public HKYX014(String oid) {
        this.oid = oid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getHdndivision() {
        return hdndivision;
    }

    public void setHdndivision(String hdndivision) {
        this.hdndivision = hdndivision;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCustomerPerson() {
        return customerPerson;
    }

    public void setCustomerPerson(String customerPerson) {
        this.customerPerson = customerPerson;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getOldQuotationNo() {
        return oldQuotationNo;
    }

    public void setOldQuotationNo(String oldQuotationNo) {
        this.oldQuotationNo = oldQuotationNo;
    }

    public String getSealfacno() {
        return sealfacno;
    }

    public void setSealfacno(String sealfacno) {
        this.sealfacno = sealfacno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getProjectno() {
        return projectno;
    }

    public void setProjectno(String projectno) {
        this.projectno = projectno;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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
        if (!(object instanceof HKYX014)) {
            return false;
        }
        HKYX014 other = (HKYX014) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX014[ oid=" + oid + " ]";
    }
    
}
