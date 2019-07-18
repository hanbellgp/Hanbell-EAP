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
import javax.persistence.Lob;
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
 * @author C0160
 */
@Entity
@Table(name = "ProcessInstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessInstance.findAll", query = "SELECT p FROM ProcessInstance p"),
    @NamedQuery(name = "ProcessInstance.findByOID", query = "SELECT p FROM ProcessInstance p WHERE p.oid = :oid"),
    @NamedQuery(name = "ProcessInstance.findByObjectVersion", query = "SELECT p FROM ProcessInstance p WHERE p.objectVersion = :objectVersion"),
    @NamedQuery(name = "ProcessInstance.findByContextOID", query = "SELECT p FROM ProcessInstance p WHERE p.contextOID = :contextOID"),
    @NamedQuery(name = "ProcessInstance.findByCurrentState", query = "SELECT p FROM ProcessInstance p WHERE p.currentState = :currentState"),
    @NamedQuery(name = "ProcessInstance.findByInvokeOrganizationUnitOID", query = "SELECT p FROM ProcessInstance p WHERE p.invokeOrganizationUnitOID = :invokeOrganizationUnitOID"),
    @NamedQuery(name = "ProcessInstance.findByRequesterOID", query = "SELECT p FROM ProcessInstance p WHERE p.requesterOID = :requesterOID"),
    @NamedQuery(name = "ProcessInstance.findBySerialNumber", query = "SELECT p FROM ProcessInstance p WHERE p.serialNumber = :serialNumber"),
    @NamedQuery(name = "ProcessInstance.findByIsMain", query = "SELECT p FROM ProcessInstance p WHERE p.isMain = :isMain"),
    @NamedQuery(name = "ProcessInstance.findByCreatedTime", query = "SELECT p FROM ProcessInstance p WHERE p.createdTime = :createdTime"),
    @NamedQuery(name = "ProcessInstance.findByProcessInstanceName", query = "SELECT p FROM ProcessInstance p WHERE p.processInstanceName = :processInstanceName"),
    @NamedQuery(name = "ProcessInstance.findByProcessDefinitionId", query = "SELECT p FROM ProcessInstance p WHERE p.processDefinitionId = :processDefinitionId"),
    @NamedQuery(name = "ProcessInstance.findByRelationalManOID", query = "SELECT p FROM ProcessInstance p WHERE p.relationalManOID = :relationalManOID"),
    @NamedQuery(name = "ProcessInstance.findByDefaultAssignmentType", query = "SELECT p FROM ProcessInstance p WHERE p.defaultAssignmentType = :defaultAssignmentType"),
    @NamedQuery(name = "ProcessInstance.findByReferContainerOID", query = "SELECT p FROM ProcessInstance p WHERE p.referContainerOID = :referContainerOID"),
    @NamedQuery(name = "ProcessInstance.findByNumOfNotification", query = "SELECT p FROM ProcessInstance p WHERE p.numOfNotification = :numOfNotification"),
    @NamedQuery(name = "ProcessInstance.findByReferOrganizationUnitOID", query = "SELECT p FROM ProcessInstance p WHERE p.referOrganizationUnitOID = :referOrganizationUnitOID"),
    @NamedQuery(name = "ProcessInstance.findByAbortable", query = "SELECT p FROM ProcessInstance p WHERE p.abortable = :abortable"),
    @NamedQuery(name = "ProcessInstance.findByAbortedManOID", query = "SELECT p FROM ProcessInstance p WHERE p.abortedManOID = :abortedManOID"),
    @NamedQuery(name = "ProcessInstance.findByAbortedManType", query = "SELECT p FROM ProcessInstance p WHERE p.abortedManType = :abortedManType"),
    @NamedQuery(name = "ProcessInstance.findByInsLevelOID", query = "SELECT p FROM ProcessInstance p WHERE p.insLevelOID = :insLevelOID"),
    @NamedQuery(name = "ProcessInstance.findBySysIntegratedWith", query = "SELECT p FROM ProcessInstance p WHERE p.sysIntegratedWith = :sysIntegratedWith"),
    @NamedQuery(name = "ProcessInstance.findByDueDate", query = "SELECT p FROM ProcessInstance p WHERE p.dueDate = :dueDate"),
    @NamedQuery(name = "ProcessInstance.findByAdditionalRules", query = "SELECT p FROM ProcessInstance p WHERE p.additionalRules = :additionalRules"),
    @NamedQuery(name = "ProcessInstance.findByLastNoticeTime", query = "SELECT p FROM ProcessInstance p WHERE p.lastNoticeTime = :lastNoticeTime"),
    @NamedQuery(name = "ProcessInstance.findByRedefinableHeaderOID", query = "SELECT p FROM ProcessInstance p WHERE p.redefinableHeaderOID = :redefinableHeaderOID"),
    @NamedQuery(name = "ProcessInstance.findByMobilityProcess", query = "SELECT p FROM ProcessInstance p WHERE p.mobilityProcess = :mobilityProcess")})
public class ProcessInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "contextOID")
    private String contextOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentState")
    private int currentState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "invokeOrganizationUnitOID")
    private String invokeOrganizationUnitOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "requesterOID")
    private String requesterOID;
    @Size(max = 50)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isMain")
    private int isMain;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Size(max = 100)
    @Column(name = "processInstanceName")
    private String processInstanceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "processDefinitionId")
    private String processDefinitionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "relationalManOID")
    private String relationalManOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defaultAssignmentType")
    private int defaultAssignmentType;
    @Size(max = 32)
    @Column(name = "referContainerOID")
    private String referContainerOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numOfNotification")
    private int numOfNotification;
    @Lob
    @Column(name = "subject")
    private String subject;
    @Size(max = 32)
    @Column(name = "referOrganizationUnitOID")
    private String referOrganizationUnitOID;
    @Lob
    @Column(name = "abortComment")
    private String abortComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abortable")
    private int abortable;
    @Lob
    @Column(name = "bundleContainer")
    private String bundleContainer;
    @Size(max = 32)
    @Column(name = "abortedManOID")
    private String abortedManOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abortedManType")
    private int abortedManType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "insLevelOID")
    private String insLevelOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sysIntegratedWith")
    private int sysIntegratedWith;
    @Column(name = "dueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "additionalRules")
    private int additionalRules;
    @Column(name = "lastNoticeTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastNoticeTime;
    @Size(max = 32)
    @Column(name = "redefinableHeaderOID")
    private String redefinableHeaderOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobilityProcess")
    private int mobilityProcess;

    public ProcessInstance() {
    }

    public ProcessInstance(String oid) {
        this.oid = oid;
    }

    public ProcessInstance(String oid, int objectVersion, String contextOID, int currentState, String invokeOrganizationUnitOID, String requesterOID, int isMain, Date createdTime, String processDefinitionId, String relationalManOID, int defaultAssignmentType, int numOfNotification, int abortable, int abortedManType, String insLevelOID, int sysIntegratedWith, int additionalRules, int mobilityProcess) {
        this.oid = oid;
        this.objectVersion = objectVersion;
        this.contextOID = contextOID;
        this.currentState = currentState;
        this.invokeOrganizationUnitOID = invokeOrganizationUnitOID;
        this.requesterOID = requesterOID;
        this.isMain = isMain;
        this.createdTime = createdTime;
        this.processDefinitionId = processDefinitionId;
        this.relationalManOID = relationalManOID;
        this.defaultAssignmentType = defaultAssignmentType;
        this.numOfNotification = numOfNotification;
        this.abortable = abortable;
        this.abortedManType = abortedManType;
        this.insLevelOID = insLevelOID;
        this.sysIntegratedWith = sysIntegratedWith;
        this.additionalRules = additionalRules;
        this.mobilityProcess = mobilityProcess;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getContextOID() {
        return contextOID;
    }

    public void setContextOID(String contextOID) {
        this.contextOID = contextOID;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public String getInvokeOrganizationUnitOID() {
        return invokeOrganizationUnitOID;
    }

    public void setInvokeOrganizationUnitOID(String invokeOrganizationUnitOID) {
        this.invokeOrganizationUnitOID = invokeOrganizationUnitOID;
    }

    public String getRequesterOID() {
        return requesterOID;
    }

    public void setRequesterOID(String requesterOID) {
        this.requesterOID = requesterOID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getIsMain() {
        return isMain;
    }

    public void setIsMain(int isMain) {
        this.isMain = isMain;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getRelationalManOID() {
        return relationalManOID;
    }

    public void setRelationalManOID(String relationalManOID) {
        this.relationalManOID = relationalManOID;
    }

    public int getDefaultAssignmentType() {
        return defaultAssignmentType;
    }

    public void setDefaultAssignmentType(int defaultAssignmentType) {
        this.defaultAssignmentType = defaultAssignmentType;
    }

    public String getReferContainerOID() {
        return referContainerOID;
    }

    public void setReferContainerOID(String referContainerOID) {
        this.referContainerOID = referContainerOID;
    }

    public int getNumOfNotification() {
        return numOfNotification;
    }

    public void setNumOfNotification(int numOfNotification) {
        this.numOfNotification = numOfNotification;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReferOrganizationUnitOID() {
        return referOrganizationUnitOID;
    }

    public void setReferOrganizationUnitOID(String referOrganizationUnitOID) {
        this.referOrganizationUnitOID = referOrganizationUnitOID;
    }

    public String getAbortComment() {
        return abortComment;
    }

    public void setAbortComment(String abortComment) {
        this.abortComment = abortComment;
    }

    public int getAbortable() {
        return abortable;
    }

    public void setAbortable(int abortable) {
        this.abortable = abortable;
    }

    public String getBundleContainer() {
        return bundleContainer;
    }

    public void setBundleContainer(String bundleContainer) {
        this.bundleContainer = bundleContainer;
    }

    public String getAbortedManOID() {
        return abortedManOID;
    }

    public void setAbortedManOID(String abortedManOID) {
        this.abortedManOID = abortedManOID;
    }

    public int getAbortedManType() {
        return abortedManType;
    }

    public void setAbortedManType(int abortedManType) {
        this.abortedManType = abortedManType;
    }

    public String getInsLevelOID() {
        return insLevelOID;
    }

    public void setInsLevelOID(String insLevelOID) {
        this.insLevelOID = insLevelOID;
    }

    public int getSysIntegratedWith() {
        return sysIntegratedWith;
    }

    public void setSysIntegratedWith(int sysIntegratedWith) {
        this.sysIntegratedWith = sysIntegratedWith;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getAdditionalRules() {
        return additionalRules;
    }

    public void setAdditionalRules(int additionalRules) {
        this.additionalRules = additionalRules;
    }

    public Date getLastNoticeTime() {
        return lastNoticeTime;
    }

    public void setLastNoticeTime(Date lastNoticeTime) {
        this.lastNoticeTime = lastNoticeTime;
    }

    public String getRedefinableHeaderOID() {
        return redefinableHeaderOID;
    }

    public void setRedefinableHeaderOID(String redefinableHeaderOID) {
        this.redefinableHeaderOID = redefinableHeaderOID;
    }

    public int getMobilityProcess() {
        return mobilityProcess;
    }

    public void setMobilityProcess(int mobilityProcess) {
        this.mobilityProcess = mobilityProcess;
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
        if (!(object instanceof ProcessInstance)) {
            return false;
        }
        ProcessInstance other = (ProcessInstance) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.ProcessInstance[ oid=" + oid + " ]";
    }
    
}
