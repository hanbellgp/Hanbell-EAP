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
@Table(name = "HZ_PB131")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZPB131.findAll", query = "SELECT h FROM HZPB131 h"),
    @NamedQuery(name = "HZPB131.findByFacno", query = "SELECT h FROM HZPB131 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HZPB131.findByPSN", query = "SELECT h FROM HZPB131 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZPB131.findByActualRequisitions", query = "SELECT h FROM HZPB131 h WHERE h.actualRequisitions = :actualRequisitions"),
    @NamedQuery(name = "HZPB131.findByLeadTime", query = "SELECT h FROM HZPB131 h WHERE h.leadTime = :leadTime"),
    @NamedQuery(name = "HZPB131.findByInventory", query = "SELECT h FROM HZPB131 h WHERE h.inventory = :inventory"),
    @NamedQuery(name = "HZPB131.findByHdnManStatus", query = "SELECT h FROM HZPB131 h WHERE h.hdnManStatus = :hdnManStatus"),
    @NamedQuery(name = "HZPB131.findByApplyUser", query = "SELECT h FROM HZPB131 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HZPB131.findByPurDraftRequirements", query = "SELECT h FROM HZPB131 h WHERE h.purDraftRequirements = :purDraftRequirements"),
    @NamedQuery(name = "HZPB131.findByApplyDept", query = "SELECT h FROM HZPB131 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HZPB131.findBySysRequirementDate", query = "SELECT h FROM HZPB131 h WHERE h.sysRequirementDate = :sysRequirementDate"),
    @NamedQuery(name = "HZPB131.findByItdsc", query = "SELECT h FROM HZPB131 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HZPB131.findByPurNotEntered", query = "SELECT h FROM HZPB131 h WHERE h.purNotEntered = :purNotEntered"),
    @NamedQuery(name = "HZPB131.findByManNo", query = "SELECT h FROM HZPB131 h WHERE h.manNo = :manNo"),
    @NamedQuery(name = "HZPB131.findByFSN", query = "SELECT h FROM HZPB131 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZPB131.findByFirst3MonthsAverage", query = "SELECT h FROM HZPB131 h WHERE h.first3MonthsAverage = :first3MonthsAverage"),
    @NamedQuery(name = "HZPB131.findBySafetyStock", query = "SELECT h FROM HZPB131 h WHERE h.safetyStock = :safetyStock"),
    @NamedQuery(name = "HZPB131.findByActDemandDate", query = "SELECT h FROM HZPB131 h WHERE h.actDemandDate = :actDemandDate"),
    @NamedQuery(name = "HZPB131.findByBatch", query = "SELECT h FROM HZPB131 h WHERE h.batch = :batch"),
    @NamedQuery(name = "HZPB131.findByMultiple", query = "SELECT h FROM HZPB131 h WHERE h.multiple = :multiple"),
    @NamedQuery(name = "HZPB131.findByItemno", query = "SELECT h FROM HZPB131 h WHERE h.itemno = :itemno"),
    @NamedQuery(name = "HZPB131.findByOID", query = "SELECT h FROM HZPB131 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZPB131.findByAnnualAverage", query = "SELECT h FROM HZPB131 h WHERE h.annualAverage = :annualAverage"),
    @NamedQuery(name = "HZPB131.findBySourceNumber", query = "SELECT h FROM HZPB131 h WHERE h.sourceNumber = :sourceNumber"),
    @NamedQuery(name = "HZPB131.findByProductionPlace", query = "SELECT h FROM HZPB131 h WHERE h.productionPlace = :productionPlace"),
    @NamedQuery(name = "HZPB131.findBySerialNumber", query = "SELECT h FROM HZPB131 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HZPB131.findByManStatus", query = "SELECT h FROM HZPB131 h WHERE h.manStatus = :manStatus"),
    @NamedQuery(name = "HZPB131.findByApplyDate", query = "SELECT h FROM HZPB131 h WHERE h.applyDate = :applyDate")})
public class HZPB131 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "actualRequisitions")
    private String actualRequisitions;
    @Size(max = 255)
    @Column(name = "leadTime")
    private String leadTime;
    @Size(max = 255)
    @Column(name = "inventory")
    private String inventory;
    @Size(max = 255)
    @Column(name = "hdnManStatus")
    private String hdnManStatus;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "purDraftRequirements")
    private String purDraftRequirements;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Column(name = "sysRequirementDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysRequirementDate;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "purNotEntered")
    private String purNotEntered;
    @Size(max = 255)
    @Column(name = "manNo")
    private String manNo;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "first3MonthsAverage")
    private String first3MonthsAverage;
    @Size(max = 255)
    @Column(name = "safetyStock")
    private String safetyStock;
    @Column(name = "actDemandDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actDemandDate;
    @Size(max = 255)
    @Column(name = "batch")
    private String batch;
    @Size(max = 255)
    @Column(name = "multiple")
    private String multiple;
    @Size(max = 255)
    @Column(name = "itemno")
    private String itemno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "annualAverage")
    private String annualAverage;
    @Size(max = 255)
    @Column(name = "sourceNumber")
    private String sourceNumber;
    @Size(max = 255)
    @Column(name = "productionPlace")
    private String productionPlace;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "manStatus")
    private String manStatus;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;

    public HZPB131() {
    }

    public HZPB131(String oid) {
        this.oid = oid;
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

    public String getActualRequisitions() {
        return actualRequisitions;
    }

    public void setActualRequisitions(String actualRequisitions) {
        this.actualRequisitions = actualRequisitions;
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getHdnManStatus() {
        return hdnManStatus;
    }

    public void setHdnManStatus(String hdnManStatus) {
        this.hdnManStatus = hdnManStatus;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getPurDraftRequirements() {
        return purDraftRequirements;
    }

    public void setPurDraftRequirements(String purDraftRequirements) {
        this.purDraftRequirements = purDraftRequirements;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Date getSysRequirementDate() {
        return sysRequirementDate;
    }

    public void setSysRequirementDate(Date sysRequirementDate) {
        this.sysRequirementDate = sysRequirementDate;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getPurNotEntered() {
        return purNotEntered;
    }

    public void setPurNotEntered(String purNotEntered) {
        this.purNotEntered = purNotEntered;
    }

    public String getManNo() {
        return manNo;
    }

    public void setManNo(String manNo) {
        this.manNo = manNo;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getFirst3MonthsAverage() {
        return first3MonthsAverage;
    }

    public void setFirst3MonthsAverage(String first3MonthsAverage) {
        this.first3MonthsAverage = first3MonthsAverage;
    }

    public String getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(String safetyStock) {
        this.safetyStock = safetyStock;
    }

    public Date getActDemandDate() {
        return actDemandDate;
    }

    public void setActDemandDate(Date actDemandDate) {
        this.actDemandDate = actDemandDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAnnualAverage() {
        return annualAverage;
    }

    public void setAnnualAverage(String annualAverage) {
        this.annualAverage = annualAverage;
    }

    public String getSourceNumber() {
        return sourceNumber;
    }

    public void setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        this.productionPlace = productionPlace;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManStatus() {
        return manStatus;
    }

    public void setManStatus(String manStatus) {
        this.manStatus = manStatus;
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
        if (!(object instanceof HZPB131)) {
            return false;
        }
        HZPB131 other = (HZPB131) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZPB131[ oid=" + oid + " ]";
    }
    
}
