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
 * @author C0160
 */
@Entity
@Table(name = "ParticipantActivityInstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipantActivityInstance.findAll", query = "SELECT p FROM ParticipantActivityInstance p"),
    @NamedQuery(name = "ParticipantActivityInstance.findByOID", query = "SELECT p FROM ParticipantActivityInstance p WHERE p.oid = :oid"),
    @NamedQuery(name = "ParticipantActivityInstance.findByContainerOID", query = "SELECT p FROM ParticipantActivityInstance p WHERE p.containerOID = :containerOID"),
    @NamedQuery(name = "ParticipantActivityInstance.findByContextOID", query = "SELECT p FROM ParticipantActivityInstance p WHERE p.contextOID = :contextOID"),
    @NamedQuery(name = "ParticipantActivityInstance.findByCurrentState", query = "SELECT p FROM ParticipantActivityInstance p WHERE p.currentState = :currentState"),
    @NamedQuery(name = "ParticipantActivityInstance.findByComeBackActivityInstOID", query = "SELECT p FROM ParticipantActivityInstance p WHERE p.comeBackActivityInstOID = :comeBackActivityInstOID"),
    @NamedQuery(name = "ParticipantActivityInstance.findByContextOIDAndDefinitionId", query = "SELECT p FROM ParticipantActivityInstance p WHERE  p.contextOID = :contextOID AND p.definitionId = :definitionId"),
    @NamedQuery(name = "ParticipantActivityInstance.findByPerformType", query = "SELECT p FROM ParticipantActivityInstance p WHERE p.performType = :performType")})
public class ParticipantActivityInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addingActivityAuthority")
    private int addingActivityAuthority;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ableToInvokeRefProcess")
    private int ableToInvokeRefProcess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ableToAskActivityReexecute")
    private int ableToAskActivityReexecute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bypassed")
    private int bypassed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bypassable")
    private int bypassable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "batchPerformable")
    private int batchPerformable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "containerOID")
    private String containerOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "contextOID")
    private String contextOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentState")
    private int currentState;
    @Size(max = 32)
    @Column(name = "comeBackActivityInstOID")
    private String comeBackActivityInstOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "definitionId")
    private String definitionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numOfNotification")
    private int numOfNotification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noticeAuthority")
    private int noticeAuthority;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reassignable")
    private int reassignable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requiredToSpecifyOrgUnit")
    private int requiredToSpecifyOrgUnit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secured")
    private int secured;
    @Column(name = "terminateReason")
    private Integer terminateReason;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "performType")
    private String performType;
    @Column(name = "lastNoticeTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastNoticeTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAccessMcloud")
    private int isAccessMcloud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automaticBypassed")
    private int automaticBypassed;

    public ParticipantActivityInstance() {
    }

    public ParticipantActivityInstance(String oid) {
        this.oid = oid;
    }

    public ParticipantActivityInstance(String oid, int addingActivityAuthority, int ableToInvokeRefProcess, int ableToAskActivityReexecute, int bypassed, int bypassable, int batchPerformable, String containerOID, String contextOID, int currentState, Date createdTime, String definitionId, int numOfNotification, int noticeAuthority, int reassignable, int requiredToSpecifyOrgUnit, int secured, int objectVersion, String performType, int isAccessMcloud, int automaticBypassed) {
        this.oid = oid;
        this.addingActivityAuthority = addingActivityAuthority;
        this.ableToInvokeRefProcess = ableToInvokeRefProcess;
        this.ableToAskActivityReexecute = ableToAskActivityReexecute;
        this.bypassed = bypassed;
        this.bypassable = bypassable;
        this.batchPerformable = batchPerformable;
        this.containerOID = containerOID;
        this.contextOID = contextOID;
        this.currentState = currentState;
        this.createdTime = createdTime;
        this.definitionId = definitionId;
        this.numOfNotification = numOfNotification;
        this.noticeAuthority = noticeAuthority;
        this.reassignable = reassignable;
        this.requiredToSpecifyOrgUnit = requiredToSpecifyOrgUnit;
        this.secured = secured;
        this.objectVersion = objectVersion;
        this.performType = performType;
        this.isAccessMcloud = isAccessMcloud;
        this.automaticBypassed = automaticBypassed;
    }

    public String getOID() {
        return oid;
    }

    public void setOID(String oid) {
        this.oid = oid;
    }

    public int getAddingActivityAuthority() {
        return addingActivityAuthority;
    }

    public void setAddingActivityAuthority(int addingActivityAuthority) {
        this.addingActivityAuthority = addingActivityAuthority;
    }

    public int getAbleToInvokeRefProcess() {
        return ableToInvokeRefProcess;
    }

    public void setAbleToInvokeRefProcess(int ableToInvokeRefProcess) {
        this.ableToInvokeRefProcess = ableToInvokeRefProcess;
    }

    public int getAbleToAskActivityReexecute() {
        return ableToAskActivityReexecute;
    }

    public void setAbleToAskActivityReexecute(int ableToAskActivityReexecute) {
        this.ableToAskActivityReexecute = ableToAskActivityReexecute;
    }

    public int getBypassed() {
        return bypassed;
    }

    public void setBypassed(int bypassed) {
        this.bypassed = bypassed;
    }

    public int getBypassable() {
        return bypassable;
    }

    public void setBypassable(int bypassable) {
        this.bypassable = bypassable;
    }

    public int getBatchPerformable() {
        return batchPerformable;
    }

    public void setBatchPerformable(int batchPerformable) {
        this.batchPerformable = batchPerformable;
    }

    public String getContainerOID() {
        return containerOID;
    }

    public void setContainerOID(String containerOID) {
        this.containerOID = containerOID;
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

    public String getComeBackActivityInstOID() {
        return comeBackActivityInstOID;
    }

    public void setComeBackActivityInstOID(String comeBackActivityInstOID) {
        this.comeBackActivityInstOID = comeBackActivityInstOID;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public int getNumOfNotification() {
        return numOfNotification;
    }

    public void setNumOfNotification(int numOfNotification) {
        this.numOfNotification = numOfNotification;
    }

    public int getNoticeAuthority() {
        return noticeAuthority;
    }

    public void setNoticeAuthority(int noticeAuthority) {
        this.noticeAuthority = noticeAuthority;
    }

    public int getReassignable() {
        return reassignable;
    }

    public void setReassignable(int reassignable) {
        this.reassignable = reassignable;
    }

    public int getRequiredToSpecifyOrgUnit() {
        return requiredToSpecifyOrgUnit;
    }

    public void setRequiredToSpecifyOrgUnit(int requiredToSpecifyOrgUnit) {
        this.requiredToSpecifyOrgUnit = requiredToSpecifyOrgUnit;
    }

    public int getSecured() {
        return secured;
    }

    public void setSecured(int secured) {
        this.secured = secured;
    }

    public Integer getTerminateReason() {
        return terminateReason;
    }

    public void setTerminateReason(Integer terminateReason) {
        this.terminateReason = terminateReason;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getPerformType() {
        return performType;
    }

    public void setPerformType(String performType) {
        this.performType = performType;
    }

    public Date getLastNoticeTime() {
        return lastNoticeTime;
    }

    public void setLastNoticeTime(Date lastNoticeTime) {
        this.lastNoticeTime = lastNoticeTime;
    }

    public int getIsAccessMcloud() {
        return isAccessMcloud;
    }

    public void setIsAccessMcloud(int isAccessMcloud) {
        this.isAccessMcloud = isAccessMcloud;
    }

    public int getAutomaticBypassed() {
        return automaticBypassed;
    }

    public void setAutomaticBypassed(int automaticBypassed) {
        this.automaticBypassed = automaticBypassed;
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
        if (!(object instanceof ParticipantActivityInstance)) {
            return false;
        }
        ParticipantActivityInstance other = (ParticipantActivityInstance) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.ParticipantActivityInstance[ oid=" + oid + " ]";
    }

}
