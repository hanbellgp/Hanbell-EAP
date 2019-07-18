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
import javax.persistence.Lob;
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
 * @author C0160
 */
@Entity
@Table(name = "WorkItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkItem.findAll", query = "SELECT w FROM WorkItem w"),
    @NamedQuery(name = "WorkItem.findByOID", query = "SELECT w FROM WorkItem w WHERE w.oid = :oid"),
    @NamedQuery(name = "WorkItem.findByWorkItemName", query = "SELECT w FROM WorkItem w WHERE w.workItemName = :workItemName"),
    @NamedQuery(name = "WorkItem.findByCurrentState", query = "SELECT w FROM WorkItem w WHERE w.currentState = :currentState"),
    @NamedQuery(name = "WorkItem.findByContextOID", query = "SELECT w FROM WorkItem w WHERE w.contextOID = :contextOID"),
    @NamedQuery(name = "WorkItem.findByProcessIdWorkItemNameAndTime", query = "SELECT w FROM WorkItem w WHERE w.processInstance.processDefinitionId = :processId AND w.workItemName = :workItemName AND w.completedTime >= :startTime AND w.completedTime <= :endTime")})
public class WorkItem implements Serializable {

    @JoinColumn(name = "contextOID", referencedColumnName = "contextOID", insertable = false, updatable = false)
    @ManyToOne
    private ProcessInstance processInstance;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Size(max = 100)
    @Column(name = "workItemName")
    private String workItemName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentState")
    private int currentState;
    @Column(name = "dispatchType")
    private Integer dispatchType;
    @Lob
    @Column(name = "executiveComment")
    private String executiveComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Column(name = "completedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Lob
    @Column(name = "description")
    private String description;
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
    @Size(max = 32)
    @Column(name = "performerOID")
    private String performerOID;
    @Size(max = 32)
    @Column(name = "reexecActivityInstOID")
    private String reexecActivityInstOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limits")
    private int limits;
    @Lob
    @Column(name = "signedComment")
    private String signedComment;
    @Size(max = 32)
    @Column(name = "ownerOID")
    private String ownerOID;
    @Size(max = 32)
    @Column(name = "bypassPerformerOID")
    private String bypassPerformerOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "signoffState")
    private int signoffState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAccessMcloud")
    private int isAccessMcloud;
    @Size(max = 32)
    @Column(name = "skipUserName")
    private String skipUserName;
    @Size(max = 255)
    @Column(name = "attachmentHits")
    private String attachmentHits;
    @Column(name = "reminder")
    private Integer reminder;

    public WorkItem() {
    }

    /**
     * @return the processInstance
     */
    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    /**
     * @param processInstance the processInstance to set
     */
    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getWorkItemName() {
        return workItemName;
    }

    public void setWorkItemName(String workItemName) {
        this.workItemName = workItemName;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public Integer getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(Integer dispatchType) {
        this.dispatchType = dispatchType;
    }

    public String getExecutiveComment() {
        return executiveComment;
    }

    public void setExecutiveComment(String executiveComment) {
        this.executiveComment = executiveComment;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Date completedTime) {
        this.completedTime = completedTime;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPerformerOID() {
        return performerOID;
    }

    public void setPerformerOID(String performerOID) {
        this.performerOID = performerOID;
    }

    public String getReexecActivityInstOID() {
        return reexecActivityInstOID;
    }

    public void setReexecActivityInstOID(String reexecActivityInstOID) {
        this.reexecActivityInstOID = reexecActivityInstOID;
    }

    public int getLimits() {
        return limits;
    }

    public void setLimits(int limits) {
        this.limits = limits;
    }

    public String getSignedComment() {
        return signedComment;
    }

    public void setSignedComment(String signedComment) {
        this.signedComment = signedComment;
    }

    public String getOwnerOID() {
        return ownerOID;
    }

    public void setOwnerOID(String ownerOID) {
        this.ownerOID = ownerOID;
    }

    public String getBypassPerformerOID() {
        return bypassPerformerOID;
    }

    public void setBypassPerformerOID(String bypassPerformerOID) {
        this.bypassPerformerOID = bypassPerformerOID;
    }

    public int getSignoffState() {
        return signoffState;
    }

    public void setSignoffState(int signoffState) {
        this.signoffState = signoffState;
    }

    public int getIsAccessMcloud() {
        return isAccessMcloud;
    }

    public void setIsAccessMcloud(int isAccessMcloud) {
        this.isAccessMcloud = isAccessMcloud;
    }

    public String getSkipUserName() {
        return skipUserName;
    }

    public void setSkipUserName(String skipUserName) {
        this.skipUserName = skipUserName;
    }

    public String getAttachmentHits() {
        return attachmentHits;
    }

    public void setAttachmentHits(String attachmentHits) {
        this.attachmentHits = attachmentHits;
    }

    public Integer getReminder() {
        return reminder;
    }

    public void setReminder(Integer reminder) {
        this.reminder = reminder;
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
        if (!(object instanceof WorkItem)) {
            return false;
        }
        WorkItem other = (WorkItem) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.WorkItem[ oid=" + oid + " ]";
    }

}
