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
@Table(name = "HK_PB033")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKPB033.findAll", query = "SELECT h FROM HKPB033 h"),
    @NamedQuery(name = "HKPB033.findByLongterm", query = "SELECT h FROM HKPB033 h WHERE h.longterm = :longterm"),
    @NamedQuery(name = "HKPB033.findByShortterm", query = "SELECT h FROM HKPB033 h WHERE h.shortterm = :shortterm"),
    @NamedQuery(name = "HKPB033.findByPSN", query = "SELECT h FROM HKPB033 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKPB033.findByHdnSschief", query = "SELECT h FROM HKPB033 h WHERE h.hdnSschief = :hdnSschief"),
    @NamedQuery(name = "HKPB033.findByDepartmentHead", query = "SELECT h FROM HKPB033 h WHERE h.departmentHead = :departmentHead"),
    @NamedQuery(name = "HKPB033.findByProject", query = "SELECT h FROM HKPB033 h WHERE h.project = :project"),
    @NamedQuery(name = "HKPB033.findBySectionSupervisor", query = "SELECT h FROM HKPB033 h WHERE h.sectionSupervisor = :sectionSupervisor"),
    @NamedQuery(name = "HKPB033.findByRisksdesc", query = "SELECT h FROM HKPB033 h WHERE h.risksdesc = :risksdesc"),
    @NamedQuery(name = "HKPB033.findBySafetySectionChief", query = "SELECT h FROM HKPB033 h WHERE h.safetySectionChief = :safetySectionChief"),
    @NamedQuery(name = "HKPB033.findByConstruction", query = "SELECT h FROM HKPB033 h WHERE h.construction = :construction"),
    @NamedQuery(name = "HKPB033.findByFormSerialNumber", query = "SELECT h FROM HKPB033 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKPB033.findByHdnSignatory", query = "SELECT h FROM HKPB033 h WHERE h.hdnSignatory = :hdnSignatory"),
    @NamedQuery(name = "HKPB033.findByCorrectDept", query = "SELECT h FROM HKPB033 h WHERE h.correctDept = :correctDept"),
    @NamedQuery(name = "HKPB033.findByAmount", query = "SELECT h FROM HKPB033 h WHERE h.amount = :amount"),
    @NamedQuery(name = "HKPB033.findByFormDate", query = "SELECT h FROM HKPB033 h WHERE h.formDate = :formDate"),
    @NamedQuery(name = "HKPB033.findByTargetDate", query = "SELECT h FROM HKPB033 h WHERE h.targetDate = :targetDate"),
    @NamedQuery(name = "HKPB033.findByAuditor", query = "SELECT h FROM HKPB033 h WHERE h.auditor = :auditor"),
    @NamedQuery(name = "HKPB033.findBySecurityOfficer", query = "SELECT h FROM HKPB033 h WHERE h.securityOfficer = :securityOfficer"),
    @NamedQuery(name = "HKPB033.findByTrackingDate", query = "SELECT h FROM HKPB033 h WHERE h.trackingDate = :trackingDate"),
    @NamedQuery(name = "HKPB033.findByOid", query = "SELECT h FROM HKPB033 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKPB033.findByPlanDate", query = "SELECT h FROM HKPB033 h WHERE h.planDate = :planDate"),
    @NamedQuery(name = "HKPB033.findByIfSign", query = "SELECT h FROM HKPB033 h WHERE h.ifSign = :ifSign"),
    @NamedQuery(name = "HKPB033.findBySite", query = "SELECT h FROM HKPB033 h WHERE h.site = :site"),
    @NamedQuery(name = "HKPB033.findBySschiefConfirm", query = "SELECT h FROM HKPB033 h WHERE h.sschiefConfirm = :sschiefConfirm"),
    @NamedQuery(name = "HKPB033.findBySerialNumber", query = "SELECT h FROM HKPB033 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKPB033.findByHdnManager", query = "SELECT h FROM HKPB033 h WHERE h.hdnManager = :hdnManager"),
    @NamedQuery(name = "HKPB033.findByOrder4", query = "SELECT h FROM HKPB033 h WHERE h.order4 = :order4"),
    @NamedQuery(name = "HKPB033.findByOrder3", query = "SELECT h FROM HKPB033 h WHERE h.order3 = :order3"),
    @NamedQuery(name = "HKPB033.findByOrder2", query = "SELECT h FROM HKPB033 h WHERE h.order2 = :order2"),
    @NamedQuery(name = "HKPB033.findByOrder1", query = "SELECT h FROM HKPB033 h WHERE h.order1 = :order1"),
    @NamedQuery(name = "HKPB033.findByOrderDate", query = "SELECT h FROM HKPB033 h WHERE h.orderDate = :orderDate"),
    @NamedQuery(name = "HKPB033.findBySignatory", query = "SELECT h FROM HKPB033 h WHERE h.signatory = :signatory"),
    @NamedQuery(name = "HKPB033.findByHdnSafetySectionChief", query = "SELECT h FROM HKPB033 h WHERE h.hdnSafetySectionChief = :hdnSafetySectionChief"),
    @NamedQuery(name = "HKPB033.findByReason", query = "SELECT h FROM HKPB033 h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKPB033.findBySschiefConfirm1", query = "SELECT h FROM HKPB033 h WHERE h.sschiefConfirm1 = :sschiefConfirm1"),
    @NamedQuery(name = "HKPB033.findByPersistenceSession", query = "SELECT h FROM HKPB033 h WHERE h.persistenceSession = :persistenceSession"),
    @NamedQuery(name = "HKPB033.findByHdnSschief1", query = "SELECT h FROM HKPB033 h WHERE h.hdnSschief1 = :hdnSschief1"),
    @NamedQuery(name = "HKPB033.findByHdnSignatory1", query = "SELECT h FROM HKPB033 h WHERE h.hdnSignatory1 = :hdnSignatory1"),
    @NamedQuery(name = "HKPB033.findByIfSign1", query = "SELECT h FROM HKPB033 h WHERE h.ifSign1 = :ifSign1"),
    @NamedQuery(name = "HKPB033.findByPersistencecacheKey", query = "SELECT h FROM HKPB033 h WHERE h.persistencecacheKey = :persistencecacheKey"),
    @NamedQuery(name = "HKPB033.findByHdnManager1", query = "SELECT h FROM HKPB033 h WHERE h.hdnManager1 = :hdnManager1"),
    @NamedQuery(name = "HKPB033.findByPersistenceHref", query = "SELECT h FROM HKPB033 h WHERE h.persistenceHref = :persistenceHref"),
    @NamedQuery(name = "HKPB033.findByPersistenceLinks", query = "SELECT h FROM HKPB033 h WHERE h.persistenceLinks = :persistenceLinks"),
    @NamedQuery(name = "HKPB033.findByPersistenceshouldRefreshFetchGroup", query = "SELECT h FROM HKPB033 h WHERE h.persistenceshouldRefreshFetchGroup = :persistenceshouldRefreshFetchGroup"),
    @NamedQuery(name = "HKPB033.findByPersistencefetchGroup", query = "SELECT h FROM HKPB033 h WHERE h.persistencefetchGroup = :persistencefetchGroup"),
    @NamedQuery(name = "HKPB033.findByPersistenceprimaryKey", query = "SELECT h FROM HKPB033 h WHERE h.persistenceprimaryKey = :persistenceprimaryKey"),
    @NamedQuery(name = "HKPB033.findByPersistencerelationshipInfo", query = "SELECT h FROM HKPB033 h WHERE h.persistencerelationshipInfo = :persistencerelationshipInfo"),
    @NamedQuery(name = "HKPB033.findByPersistenceListener", query = "SELECT h FROM HKPB033 h WHERE h.persistenceListener = :persistenceListener")})
public class HKPB033 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "longterm")
    private String longterm;
    @Size(max = 255)
    @Column(name = "shortterm")
    private String shortterm;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_sschief")
    private String hdnSschief;
    @Size(max = 255)
    @Column(name = "departmentHead")
    private String departmentHead;
    @Size(max = 255)
    @Column(name = "project")
    private String project;
    @Size(max = 255)
    @Column(name = "sectionSupervisor")
    private String sectionSupervisor;
    @Size(max = 255)
    @Column(name = "risksdesc")
    private String risksdesc;
    @Size(max = 255)
    @Column(name = "safetySectionChief")
    private String safetySectionChief;
    @Size(max = 255)
    @Column(name = "construction")
    private String construction;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_signatory")
    private String hdnSignatory;
    @Size(max = 255)
    @Column(name = "correctDept")
    private String correctDept;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "formDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formDate;
    @Column(name = "targetDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date targetDate;
    @Size(max = 255)
    @Column(name = "auditor")
    private String auditor;
    @Size(max = 255)
    @Column(name = "securityOfficer")
    private String securityOfficer;
    @Column(name = "trackingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackingDate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "planDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planDate;
    @Size(max = 255)
    @Column(name = "if_sign")
    private String ifSign;
    @Size(max = 255)
    @Column(name = "site")
    private String site;
    @Size(max = 255)
    @Column(name = "sschief_confirm")
    private String sschiefConfirm;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdn_manager")
    private String hdnManager;
    @Size(max = 255)
    @Column(name = "order4")
    private String order4;
    @Size(max = 255)
    @Column(name = "order3")
    private String order3;
    @Size(max = 255)
    @Column(name = "order2")
    private String order2;
    @Size(max = 255)
    @Column(name = "order1")
    private String order1;
    @Size(max = 255)
    @Column(name = "orderDate")
    private String orderDate;
    @Size(max = 255)
    @Column(name = "signatory")
    private String signatory;
    @Size(max = 255)
    @Column(name = "hdnSafetySectionChief")
    private String hdnSafetySectionChief;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "sschiefConfirm")
    private String sschiefConfirm1;
    @Size(max = 255)
    @Column(name = "_persistence_session")
    private String persistenceSession;
    @Size(max = 255)
    @Column(name = "hdnSschief")
    private String hdnSschief1;
    @Size(max = 255)
    @Column(name = "hdnSignatory")
    private String hdnSignatory1;
    @Size(max = 255)
    @Column(name = "ifSign")
    private String ifSign1;
    @Size(max = 255)
    @Column(name = "_persistence_cacheKey")
    private String persistencecacheKey;
    @Size(max = 255)
    @Column(name = "hdnManager")
    private String hdnManager1;
    @Size(max = 255)
    @Column(name = "_persistence_href")
    private String persistenceHref;
    @Size(max = 255)
    @Column(name = "_persistence_links")
    private String persistenceLinks;
    @Size(max = 255)
    @Column(name = "_persistence_shouldRefreshFetchGroup")
    private String persistenceshouldRefreshFetchGroup;
    @Size(max = 255)
    @Column(name = "_persistence_fetchGroup")
    private String persistencefetchGroup;
    @Size(max = 255)
    @Column(name = "_persistence_primaryKey")
    private String persistenceprimaryKey;
    @Size(max = 255)
    @Column(name = "_persistence_relationshipInfo")
    private String persistencerelationshipInfo;
    @Size(max = 255)
    @Column(name = "_persistence_listener")
    private String persistenceListener;
    @JoinColumn(name = "formSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @ManyToOne
    private FormInstance formInstance;

    public HKPB033() {
    }

    public HKPB033(String oid) {
        this.oid = oid;
    }

    public String getLongterm() {
        return longterm;
    }

    public void setLongterm(String longterm) {
        this.longterm = longterm;
    }

    public String getShortterm() {
        return shortterm;
    }

    public void setShortterm(String shortterm) {
        this.shortterm = shortterm;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getHdnSschief() {
        return hdnSschief;
    }

    public void setHdnSschief(String hdnSschief) {
        this.hdnSschief = hdnSschief;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSectionSupervisor() {
        return sectionSupervisor;
    }

    public void setSectionSupervisor(String sectionSupervisor) {
        this.sectionSupervisor = sectionSupervisor;
    }

    public String getRisksdesc() {
        return risksdesc;
    }

    public void setRisksdesc(String risksdesc) {
        this.risksdesc = risksdesc;
    }

    public String getSafetySectionChief() {
        return safetySectionChief;
    }

    public void setSafetySectionChief(String safetySectionChief) {
        this.safetySectionChief = safetySectionChief;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnSignatory() {
        return hdnSignatory;
    }

    public void setHdnSignatory(String hdnSignatory) {
        this.hdnSignatory = hdnSignatory;
    }

    public String getCorrectDept() {
        return correctDept;
    }

    public void setCorrectDept(String correctDept) {
        this.correctDept = correctDept;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getSecurityOfficer() {
        return securityOfficer;
    }

    public void setSecurityOfficer(String securityOfficer) {
        this.securityOfficer = securityOfficer;
    }

    public Date getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(Date trackingDate) {
        this.trackingDate = trackingDate;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getIfSign() {
        return ifSign;
    }

    public void setIfSign(String ifSign) {
        this.ifSign = ifSign;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSschiefConfirm() {
        return sschiefConfirm;
    }

    public void setSschiefConfirm(String sschiefConfirm) {
        this.sschiefConfirm = sschiefConfirm;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnManager() {
        return hdnManager;
    }

    public void setHdnManager(String hdnManager) {
        this.hdnManager = hdnManager;
    }

    public String getOrder4() {
        return order4;
    }

    public void setOrder4(String order4) {
        this.order4 = order4;
    }

    public String getOrder3() {
        return order3;
    }

    public void setOrder3(String order3) {
        this.order3 = order3;
    }

    public String getOrder2() {
        return order2;
    }

    public void setOrder2(String order2) {
        this.order2 = order2;
    }

    public String getOrder1() {
        return order1;
    }

    public void setOrder1(String order1) {
        this.order1 = order1;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public String getHdnSafetySectionChief() {
        return hdnSafetySectionChief;
    }

    public void setHdnSafetySectionChief(String hdnSafetySectionChief) {
        this.hdnSafetySectionChief = hdnSafetySectionChief;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSschiefConfirm1() {
        return sschiefConfirm1;
    }

    public void setSschiefConfirm1(String sschiefConfirm1) {
        this.sschiefConfirm1 = sschiefConfirm1;
    }

    public String getPersistenceSession() {
        return persistenceSession;
    }

    public void setPersistenceSession(String persistenceSession) {
        this.persistenceSession = persistenceSession;
    }

    public String getHdnSschief1() {
        return hdnSschief1;
    }

    public void setHdnSschief1(String hdnSschief1) {
        this.hdnSschief1 = hdnSschief1;
    }

    public String getHdnSignatory1() {
        return hdnSignatory1;
    }

    public void setHdnSignatory1(String hdnSignatory1) {
        this.hdnSignatory1 = hdnSignatory1;
    }

    public String getIfSign1() {
        return ifSign1;
    }

    public void setIfSign1(String ifSign1) {
        this.ifSign1 = ifSign1;
    }

    public String getPersistencecacheKey() {
        return persistencecacheKey;
    }

    public void setPersistencecacheKey(String persistencecacheKey) {
        this.persistencecacheKey = persistencecacheKey;
    }

    public String getHdnManager1() {
        return hdnManager1;
    }

    public void setHdnManager1(String hdnManager1) {
        this.hdnManager1 = hdnManager1;
    }

    public String getPersistenceHref() {
        return persistenceHref;
    }

    public void setPersistenceHref(String persistenceHref) {
        this.persistenceHref = persistenceHref;
    }

    public String getPersistenceLinks() {
        return persistenceLinks;
    }

    public void setPersistenceLinks(String persistenceLinks) {
        this.persistenceLinks = persistenceLinks;
    }

    public String getPersistenceshouldRefreshFetchGroup() {
        return persistenceshouldRefreshFetchGroup;
    }

    public void setPersistenceshouldRefreshFetchGroup(String persistenceshouldRefreshFetchGroup) {
        this.persistenceshouldRefreshFetchGroup = persistenceshouldRefreshFetchGroup;
    }

    public String getPersistencefetchGroup() {
        return persistencefetchGroup;
    }

    public void setPersistencefetchGroup(String persistencefetchGroup) {
        this.persistencefetchGroup = persistencefetchGroup;
    }

    public String getPersistenceprimaryKey() {
        return persistenceprimaryKey;
    }

    public void setPersistenceprimaryKey(String persistenceprimaryKey) {
        this.persistenceprimaryKey = persistenceprimaryKey;
    }

    public String getPersistencerelationshipInfo() {
        return persistencerelationshipInfo;
    }

    public void setPersistencerelationshipInfo(String persistencerelationshipInfo) {
        this.persistencerelationshipInfo = persistencerelationshipInfo;
    }

    public String getPersistenceListener() {
        return persistenceListener;
    }

    public void setPersistenceListener(String persistenceListener) {
        this.persistenceListener = persistenceListener;
    }

    public FormInstance getFormInstance() {
        return formInstance;
    }

    public void setFormInstance(FormInstance formInstance) {
        this.formInstance = formInstance;
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
        if (!(object instanceof HKPB033)) {
            return false;
        }
        HKPB033 other = (HKPB033) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKPB033[ oid=" + oid + " ]";
    }

}
