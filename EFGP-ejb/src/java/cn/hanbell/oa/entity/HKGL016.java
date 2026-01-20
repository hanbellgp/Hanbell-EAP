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
@Table(name = "HK_GL016")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL016.findAll", query = "SELECT h FROM HKGL016 h"),
    @NamedQuery(name = "HKGL016.findByAdministrativeDuties", query = "SELECT h FROM HKGL016 h WHERE h.administrativeDuties = :administrativeDuties"),
    @NamedQuery(name = "HKGL016.findByReason1", query = "SELECT h FROM HKGL016 h WHERE h.reason1 = :reason1"),
    @NamedQuery(name = "HKGL016.findByContractDate", query = "SELECT h FROM HKGL016 h WHERE h.contractDate = :contractDate"),
    @NamedQuery(name = "HKGL016.findByReason2", query = "SELECT h FROM HKGL016 h WHERE h.reason2 = :reason2"),
    @NamedQuery(name = "HKGL016.findByReason3", query = "SELECT h FROM HKGL016 h WHERE h.reason3 = :reason3"),
    @NamedQuery(name = "HKGL016.findByProcessSerialNumber", query = "SELECT h FROM HKGL016 h WHERE h.processSerialNumber = :processSerialNumber"),
    @NamedQuery(name = "HKGL016.findByRetireReason", query = "SELECT h FROM HKGL016 h WHERE h.retireReason = :retireReason"),
    @NamedQuery(name = "HKGL016.findByHdnManager", query = "SELECT h FROM HKGL016 h WHERE h.hdnManager = :hdnManager"),
    @NamedQuery(name = "HKGL016.findByPost1", query = "SELECT h FROM HKGL016 h WHERE h.post1 = :post1"),
    @NamedQuery(name = "HKGL016.findByApplyUser", query = "SELECT h FROM HKGL016 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKGL016.findByUserTitle", query = "SELECT h FROM HKGL016 h WHERE h.userTitle = :userTitle"),
    @NamedQuery(name = "HKGL016.findByApplyDept", query = "SELECT h FROM HKGL016 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKGL016.findByHdnHeader", query = "SELECT h FROM HKGL016 h WHERE h.hdnHeader = :hdnHeader"),
    @NamedQuery(name = "HKGL016.findByFormSerialNumber", query = "SELECT h FROM HKGL016 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKGL016.findByReason4", query = "SELECT h FROM HKGL016 h WHERE h.reason4 = :reason4"),
    @NamedQuery(name = "HKGL016.findByHdnpost1", query = "SELECT h FROM HKGL016 h WHERE h.hdnpost1 = :hdnpost1"),
    @NamedQuery(name = "HKGL016.findByRetirementDate", query = "SELECT h FROM HKGL016 h WHERE h.retirementDate = :retirementDate"),
    @NamedQuery(name = "HKGL016.findByHdnBoss1", query = "SELECT h FROM HKGL016 h WHERE h.hdnBoss1 = :hdnBoss1"),
    @NamedQuery(name = "HKGL016.findByHdnBoss2", query = "SELECT h FROM HKGL016 h WHERE h.hdnBoss2 = :hdnBoss2"),
    @NamedQuery(name = "HKGL016.findByOpinion1", query = "SELECT h FROM HKGL016 h WHERE h.opinion1 = :opinion1"),
    @NamedQuery(name = "HKGL016.findByOid", query = "SELECT h FROM HKGL016 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL016.findBySerialNumber", query = "SELECT h FROM HKGL016 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL016.findByOpinion2", query = "SELECT h FROM HKGL016 h WHERE h.opinion2 = :opinion2"),
    @NamedQuery(name = "HKGL016.findByOpinion3", query = "SELECT h FROM HKGL016 h WHERE h.opinion3 = :opinion3"),
    @NamedQuery(name = "HKGL016.findByOpinion4", query = "SELECT h FROM HKGL016 h WHERE h.opinion4 = :opinion4"),
    @NamedQuery(name = "HKGL016.findByApplyDate", query = "SELECT h FROM HKGL016 h WHERE h.applyDate = :applyDate")})
public class HKGL016 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "administrativeDuties")
    private String administrativeDuties;
    @Size(max = 255)
    @Column(name = "reason1")
    private String reason1;
    @Column(name = "contractDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractDate;
    @Size(max = 255)
    @Column(name = "reason2")
    private String reason2;
    @Size(max = 255)
    @Column(name = "reason3")
    private String reason3;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "retireReason")
    private String retireReason;
    @Size(max = 255)
    @Column(name = "hdnManager")
    private String hdnManager;
    @Size(max = 255)
    @Column(name = "post1")
    private String post1;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "hdnHeader")
    private String hdnHeader;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "reason4")
    private String reason4;
    @Size(max = 255)
    @Column(name = "hdnpost1")
    private String hdnpost1;
    @Column(name = "retirementDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retirementDate;
    @Size(max = 255)
    @Column(name = "hdnBoss1")
    private String hdnBoss1;
    @Size(max = 255)
    @Column(name = "hdnBoss2")
    private String hdnBoss2;
    @Size(max = 255)
    @Column(name = "opinion1")
    private String opinion1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "opinion2")
    private String opinion2;
    @Size(max = 255)
    @Column(name = "opinion3")
    private String opinion3;
    @Size(max = 255)
    @Column(name = "opinion4")
    private String opinion4;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;

    public HKGL016() {
    }

    public HKGL016(String oid) {
        this.oid = oid;
    }

    public String getAdministrativeDuties() {
        return administrativeDuties;
    }

    public void setAdministrativeDuties(String administrativeDuties) {
        this.administrativeDuties = administrativeDuties;
    }

    public String getReason1() {
        return reason1;
    }

    public void setReason1(String reason1) {
        this.reason1 = reason1;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getReason2() {
        return reason2;
    }

    public void setReason2(String reason2) {
        this.reason2 = reason2;
    }

    public String getReason3() {
        return reason3;
    }

    public void setReason3(String reason3) {
        this.reason3 = reason3;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getRetireReason() {
        return retireReason;
    }

    public void setRetireReason(String retireReason) {
        this.retireReason = retireReason;
    }

    public String getHdnManager() {
        return hdnManager;
    }

    public void setHdnManager(String hdnManager) {
        this.hdnManager = hdnManager;
    }

    public String getPost1() {
        return post1;
    }

    public void setPost1(String post1) {
        this.post1 = post1;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getHdnHeader() {
        return hdnHeader;
    }

    public void setHdnHeader(String hdnHeader) {
        this.hdnHeader = hdnHeader;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getReason4() {
        return reason4;
    }

    public void setReason4(String reason4) {
        this.reason4 = reason4;
    }

    public String getHdnpost1() {
        return hdnpost1;
    }

    public void setHdnpost1(String hdnpost1) {
        this.hdnpost1 = hdnpost1;
    }

    public Date getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(Date retirementDate) {
        this.retirementDate = retirementDate;
    }

    public String getHdnBoss1() {
        return hdnBoss1;
    }

    public void setHdnBoss1(String hdnBoss1) {
        this.hdnBoss1 = hdnBoss1;
    }

    public String getHdnBoss2() {
        return hdnBoss2;
    }

    public void setHdnBoss2(String hdnBoss2) {
        this.hdnBoss2 = hdnBoss2;
    }

    public String getOpinion1() {
        return opinion1;
    }

    public void setOpinion1(String opinion1) {
        this.opinion1 = opinion1;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOpinion2() {
        return opinion2;
    }

    public void setOpinion2(String opinion2) {
        this.opinion2 = opinion2;
    }

    public String getOpinion3() {
        return opinion3;
    }

    public void setOpinion3(String opinion3) {
        this.opinion3 = opinion3;
    }

    public String getOpinion4() {
        return opinion4;
    }

    public void setOpinion4(String opinion4) {
        this.opinion4 = opinion4;
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
        if (!(object instanceof HKGL016)) {
            return false;
        }
        HKGL016 other = (HKGL016) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL016[ oid=" + oid + " ]";
    }
    
}
