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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HK_FW013")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW013.findAll", query = "SELECT h FROM HKFW013 h"),
    @NamedQuery(name = "HKFW013.findByFacno", query = "SELECT h FROM HKFW013 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKFW013.findByOrderNumber", query = "SELECT h FROM HKFW013 h WHERE h.orderNumber = :orderNumber"),
    @NamedQuery(name = "HKFW013.findByThcontactPerson", query = "SELECT h FROM HKFW013 h WHERE h.thcontactPerson = :thcontactPerson"),
    @NamedQuery(name = "HKFW013.findByShcompanyName", query = "SELECT h FROM HKFW013 h WHERE h.shcompanyName = :shcompanyName"),
    @NamedQuery(name = "HKFW013.findByPSN", query = "SELECT h FROM HKFW013 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKFW013.findByShphone", query = "SELECT h FROM HKFW013 h WHERE h.shphone = :shphone"),
    @NamedQuery(name = "HKFW013.findByContactPerson", query = "SELECT h FROM HKFW013 h WHERE h.contactPerson = :contactPerson"),
    @NamedQuery(name = "HKFW013.findByItnbr", query = "SELECT h FROM HKFW013 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW013.findByThcompanyName", query = "SELECT h FROM HKFW013 h WHERE h.thcompanyName = :thcompanyName"),
    @NamedQuery(name = "HKFW013.findByThDate", query = "SELECT h FROM HKFW013 h WHERE h.thDate = :thDate"),
    @NamedQuery(name = "HKFW013.findByThManPhone", query = "SELECT h FROM HKFW013 h WHERE h.thManPhone = :thManPhone"),
    @NamedQuery(name = "HKFW013.findByApplyUser", query = "SELECT h FROM HKFW013 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKFW013.findByApplyDept", query = "SELECT h FROM HKFW013 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKFW013.findByItdsc", query = "SELECT h FROM HKFW013 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW013.findByThMan", query = "SELECT h FROM HKFW013 h WHERE h.thMan = :thMan"),
    @NamedQuery(name = "HKFW013.findByThcompanyAddress", query = "SELECT h FROM HKFW013 h WHERE h.thcompanyAddress = :thcompanyAddress"),
    @NamedQuery(name = "HKFW013.findByFSN", query = "SELECT h FROM HKFW013 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKFW013.findByApplyPhone", query = "SELECT h FROM HKFW013 h WHERE h.applyPhone = :applyPhone"),
    @NamedQuery(name = "HKFW013.findBySingleWeight", query = "SELECT h FROM HKFW013 h WHERE h.singleWeight = :singleWeight"),
    @NamedQuery(name = "HKFW013.findByThphone", query = "SELECT h FROM HKFW013 h WHERE h.thphone = :thphone"),
    @NamedQuery(name = "HKFW013.findBySingleSize", query = "SELECT h FROM HKFW013 h WHERE h.singleSize = :singleSize"),
    @NamedQuery(name = "HKFW013.findByShcompanyAddress", query = "SELECT h FROM HKFW013 h WHERE h.shcompanyAddress = :shcompanyAddress"),
    @NamedQuery(name = "HKFW013.findByShcontactPerson", query = "SELECT h FROM HKFW013 h WHERE h.shcontactPerson = :shcontactPerson"),
    @NamedQuery(name = "HKFW013.findByCusno", query = "SELECT h FROM HKFW013 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKFW013.findByThcompany", query = "SELECT h FROM HKFW013 h WHERE h.thcompany = :thcompany"),
    @NamedQuery(name = "HKFW013.findByOid", query = "SELECT h FROM HKFW013 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW013.findByKfno", query = "SELECT h FROM HKFW013 h WHERE h.kfno = :kfno"),
    @NamedQuery(name = "HKFW013.findBySerialNumber", query = "SELECT h FROM HKFW013 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKFW013.findByIsSure", query = "SELECT h FROM HKFW013 h WHERE h.isSure = :isSure"),
    @NamedQuery(name = "HKFW013.findByQty", query = "SELECT h FROM HKFW013 h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKFW013.findByCusds", query = "SELECT h FROM HKFW013 h WHERE h.cusds = :cusds"),
    @NamedQuery(name = "HKFW013.findByFreightCost", query = "SELECT h FROM HKFW013 h WHERE h.freightCost = :freightCost"),
    @NamedQuery(name = "HKFW013.findByApplyDate", query = "SELECT h FROM HKFW013 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HKFW013.findByContactPhone", query = "SELECT h FROM HKFW013 h WHERE h.contactPhone = :contactPhone"),
    @NamedQuery(name = "HKFW013.findByManufacturingNo", query = "SELECT h FROM HKFW013 h WHERE h.manufacturingNo = :manufacturingNo"),
    @NamedQuery(name = "HKFW013.findByWaybillNumber", query = "SELECT h FROM HKFW013 h WHERE h.waybillNumber = :waybillNumber")})
public class HKFW013 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "orderNumber")
    private String orderNumber;
    @Size(max = 255)
    @Column(name = "thcontactPerson")
    private String thcontactPerson;
    @Size(max = 255)
    @Column(name = "shcompanyName")
    private String shcompanyName;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "shphone")
    private String shphone;
    @Size(max = 255)
    @Column(name = "contactPerson")
    private String contactPerson;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "thcompanyName")
    private String thcompanyName;
    @Size(max = 255)
    @Column(name = "thDate")
    private String thDate;
    @Size(max = 255)
    @Column(name = "thManPhone")
    private String thManPhone;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "thMan")
    private String thMan;
    @Size(max = 255)
    @Column(name = "thcompanyAddress")
    private String thcompanyAddress;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "applyPhone")
    private String applyPhone;
    @Size(max = 255)
    @Column(name = "singleWeight")
    private String singleWeight;
    @Size(max = 255)
    @Column(name = "thphone")
    private String thphone;
    @Size(max = 255)
    @Column(name = "singleSize")
    private String singleSize;
    @Size(max = 255)
    @Column(name = "shcompanyAddress")
    private String shcompanyAddress;
    @Size(max = 255)
    @Column(name = "shcontactPerson")
    private String shcontactPerson;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "thcompany")
    private String thcompany;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "isSure")
    private String isSure;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 255)
    @Column(name = "freightCost")
    private String freightCost;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "contactPhone")
    private String contactPhone;
    @Size(max = 255)
    @Column(name = "manufacturingNo")
    private String manufacturingNo;
    @Size(max = 255)
    @Column(name = "waybillNumber")
    private String waybillNumber;
    @JoinColumn(name = "applyUser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;
    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private ProcessInstance processInstance;
    public HKFW013() {
    }

    public HKFW013(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getThcontactPerson() {
        return thcontactPerson;
    }

    public void setThcontactPerson(String thcontactPerson) {
        this.thcontactPerson = thcontactPerson;
    }

    public String getShcompanyName() {
        return shcompanyName;
    }

    public void setShcompanyName(String shcompanyName) {
        this.shcompanyName = shcompanyName;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getShphone() {
        return shphone;
    }

    public void setShphone(String shphone) {
        this.shphone = shphone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getThcompanyName() {
        return thcompanyName;
    }

    public void setThcompanyName(String thcompanyName) {
        this.thcompanyName = thcompanyName;
    }

    public String getThDate() {
        return thDate;
    }

    public void setThDate(String thDate) {
        this.thDate = thDate;
    }

    public String getThManPhone() {
        return thManPhone;
    }

    public void setThManPhone(String thManPhone) {
        this.thManPhone = thManPhone;
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

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getThMan() {
        return thMan;
    }

    public void setThMan(String thMan) {
        this.thMan = thMan;
    }

    public String getThcompanyAddress() {
        return thcompanyAddress;
    }

    public void setThcompanyAddress(String thcompanyAddress) {
        this.thcompanyAddress = thcompanyAddress;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public String getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(String singleWeight) {
        this.singleWeight = singleWeight;
    }

    public String getThphone() {
        return thphone;
    }

    public void setThphone(String thphone) {
        this.thphone = thphone;
    }

    public String getSingleSize() {
        return singleSize;
    }

    public void setSingleSize(String singleSize) {
        this.singleSize = singleSize;
    }

    public String getShcompanyAddress() {
        return shcompanyAddress;
    }

    public void setShcompanyAddress(String shcompanyAddress) {
        this.shcompanyAddress = shcompanyAddress;
    }

    public String getShcontactPerson() {
        return shcontactPerson;
    }

    public void setShcontactPerson(String shcontactPerson) {
        this.shcontactPerson = shcontactPerson;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getThcompany() {
        return thcompany;
    }

    public void setThcompany(String thcompany) {
        this.thcompany = thcompany;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIsSure() {
        return isSure;
    }

    public void setIsSure(String isSure) {
        this.isSure = isSure;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(String freightCost) {
        this.freightCost = freightCost;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getManufacturingNo() {
        return manufacturingNo;
    }

    public void setManufacturingNo(String manufacturingNo) {
        this.manufacturingNo = manufacturingNo;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }
     public String getThCompany(){
        switch (this.thcompany) {
            case "JX":
                return "久祥物流";
            case "KY":
               return "跨越物流";
            case "LS":
               return "雷速物流";
            case "HJ":
                 return "合捷物流";
            case "DB":
                return "德邦物流";
        }
        return "";
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
        if (!(object instanceof HKFW013)) {
            return false;
        }
        HKFW013 other = (HKFW013) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW013[ oid=" + oid + " ]";
    }
    
}
