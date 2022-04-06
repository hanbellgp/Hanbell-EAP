/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "HZ_PB131_purDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZPB131purDetail.findAll", query = "SELECT h FROM HZPB131purDetail h"),
    @NamedQuery(name = "HZPB131purDetail.findByActDemandDatetxt", query = "SELECT h FROM HZPB131purDetail h WHERE h.actDemandDatetxt = :actDemandDatetxt"),
    @NamedQuery(name = "HZPB131purDetail.findByFirst3MonthsAverage", query = "SELECT h FROM HZPB131purDetail h WHERE h.first3MonthsAverage = :first3MonthsAverage"),
    @NamedQuery(name = "HZPB131purDetail.findBySysRequirementDatetxt", query = "SELECT h FROM HZPB131purDetail h WHERE h.sysRequirementDatetxt = :sysRequirementDatetxt"),
    @NamedQuery(name = "HZPB131purDetail.findBySafetyStock", query = "SELECT h FROM HZPB131purDetail h WHERE h.safetyStock = :safetyStock"),
    @NamedQuery(name = "HZPB131purDetail.findByActualRequisitions", query = "SELECT h FROM HZPB131purDetail h WHERE h.actualRequisitions = :actualRequisitions"),
    @NamedQuery(name = "HZPB131purDetail.findByBatch", query = "SELECT h FROM HZPB131purDetail h WHERE h.batch = :batch"),
    @NamedQuery(name = "HZPB131purDetail.findByMultiple", query = "SELECT h FROM HZPB131purDetail h WHERE h.multiple = :multiple"),
    @NamedQuery(name = "HZPB131purDetail.findByLeadTime", query = "SELECT h FROM HZPB131purDetail h WHERE h.leadTime = :leadTime"),
    @NamedQuery(name = "HZPB131purDetail.findByItemno", query = "SELECT h FROM HZPB131purDetail h WHERE h.itemno = :itemno"),
    @NamedQuery(name = "HZPB131purDetail.findByOID", query = "SELECT h FROM HZPB131purDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZPB131purDetail.findByAnnualAverage", query = "SELECT h FROM HZPB131purDetail h WHERE h.annualAverage = :annualAverage"),
    @NamedQuery(name = "HZPB131purDetail.findByInventory", query = "SELECT h FROM HZPB131purDetail h WHERE h.inventory = :inventory"),
    @NamedQuery(name = "HZPB131purDetail.findByHdnManStatus", query = "SELECT h FROM HZPB131purDetail h WHERE h.hdnManStatus = :hdnManStatus"),
    @NamedQuery(name = "HZPB131purDetail.findByPurDraftRequirements", query = "SELECT h FROM HZPB131purDetail h WHERE h.purDraftRequirements = :purDraftRequirements"),
    @NamedQuery(name = "HZPB131purDetail.findByItdsc", query = "SELECT h FROM HZPB131purDetail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HZPB131purDetail.findByPurNotEntered", query = "SELECT h FROM HZPB131purDetail h WHERE h.purNotEntered = :purNotEntered"),
    @NamedQuery(name = "HZPB131purDetail.findByManNo", query = "SELECT h FROM HZPB131purDetail h WHERE h.manNo = :manNo"),
    @NamedQuery(name = "HZPB131purDetail.findByFSN", query = "SELECT h FROM HZPB131purDetail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZPB131purDetail.findBySeq", query = "SELECT h FROM HZPB131purDetail h WHERE h.seq = :seq")})
public class HZPB131purDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "actDemandDate_txt")
    private String actDemandDatetxt;
    @Size(max = 255)
    @Column(name = "first3MonthsAverage")
    private String first3MonthsAverage;
    @Size(max = 255)
    @Column(name = "sysRequirementDate_txt")
    private String sysRequirementDatetxt;
    @Size(max = 255)
    @Column(name = "safetyStock")
    private String safetyStock;
    @Size(max = 255)
    @Column(name = "actualRequisitions")
    private String actualRequisitions;
    @Size(max = 255)
    @Column(name = "batch")
    private String batch;
    @Size(max = 255)
    @Column(name = "multiple")
    private String multiple;
    @Size(max = 255)
    @Column(name = "leadTime")
    private String leadTime;
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
    @Column(name = "inventory")
    private String inventory;
    @Size(max = 255)
    @Column(name = "hdnManStatus")
    private String hdnManStatus;
    @Size(max = 255)
    @Column(name = "purDraftRequirements")
    private String purDraftRequirements;
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
    @Column(name = "seq")
    private String seq;

    public HZPB131purDetail() {
    }

    public HZPB131purDetail(String oid) {
        this.oid = oid;
    }

    public String getActDemandDatetxt() {
        return actDemandDatetxt;
    }

    public void setActDemandDatetxt(String actDemandDatetxt) {
        this.actDemandDatetxt = actDemandDatetxt;
    }

    public String getFirst3MonthsAverage() {
        return first3MonthsAverage;
    }

    public void setFirst3MonthsAverage(String first3MonthsAverage) {
        this.first3MonthsAverage = first3MonthsAverage;
    }

    public String getSysRequirementDatetxt() {
        return sysRequirementDatetxt;
    }

    public void setSysRequirementDatetxt(String sysRequirementDatetxt) {
        this.sysRequirementDatetxt = sysRequirementDatetxt;
    }

    public String getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(String safetyStock) {
        this.safetyStock = safetyStock;
    }

    public String getActualRequisitions() {
        return actualRequisitions;
    }

    public void setActualRequisitions(String actualRequisitions) {
        this.actualRequisitions = actualRequisitions;
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

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
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

    public String getPurDraftRequirements() {
        return purDraftRequirements;
    }

    public void setPurDraftRequirements(String purDraftRequirements) {
        this.purDraftRequirements = purDraftRequirements;
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

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof HZPB131purDetail)) {
            return false;
        }
        HZPB131purDetail other = (HZPB131purDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZPB131purDetail[ oid=" + oid + " ]";
    }
    
}
