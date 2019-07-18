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
@Table(name = "WorkStep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkStep.findAll", query = "SELECT w FROM WorkStep w"),
    @NamedQuery(name = "WorkStep.findByOID", query = "SELECT w FROM WorkStep w WHERE w.oid = :oid"),
    @NamedQuery(name = "WorkStep.findByCurrentState", query = "SELECT w FROM WorkStep w WHERE w.currentState = :currentState"),
    @NamedQuery(name = "WorkStep.findByDefinitionId", query = "SELECT w FROM WorkStep w WHERE w.definitionId = :definitionId"),
    @NamedQuery(name = "WorkStep.findByContainerOID", query = "SELECT w FROM WorkStep w WHERE w.containerOID = :containerOID"),
    @NamedQuery(name = "WorkStep.findByObjectVersion", query = "SELECT w FROM WorkStep w WHERE w.objectVersion = :objectVersion"),
    @NamedQuery(name = "WorkStep.findByContextOID", query = "SELECT w FROM WorkStep w WHERE w.contextOID = :contextOID"),
    @NamedQuery(name = "WorkStep.findByExceptionHandleDefIndex", query = "SELECT w FROM WorkStep w WHERE w.exceptionHandleDefIndex = :exceptionHandleDefIndex"),
    @NamedQuery(name = "WorkStep.findByNextExceptionHandleTime", query = "SELECT w FROM WorkStep w WHERE w.nextExceptionHandleTime = :nextExceptionHandleTime"),
    @NamedQuery(name = "WorkStep.findByNumOfExceptionHandle", query = "SELECT w FROM WorkStep w WHERE w.numOfExceptionHandle = :numOfExceptionHandle"),
    @NamedQuery(name = "WorkStep.findByWorkStepIndex", query = "SELECT w FROM WorkStep w WHERE w.workStepIndex = :workStepIndex")})
public class WorkStep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentState")
    private int currentState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "definitionId")
    private String definitionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "containerOID")
    private String containerOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "contextOID")
    private String contextOID;
    @Column(name = "exceptionHandleDefIndex")
    private Integer exceptionHandleDefIndex;
    @Column(name = "nextExceptionHandleTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextExceptionHandleTime;
    @Column(name = "numOfExceptionHandle")
    private Integer numOfExceptionHandle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "workStepIndex")
    private int workStepIndex;

    public WorkStep() {
    }

    public WorkStep(String oid) {
        this.oid = oid;
    }

    public WorkStep(String oid, int currentState, String definitionId, String containerOID, int objectVersion, String contextOID, int workStepIndex) {
        this.oid = oid;
        this.currentState = currentState;
        this.definitionId = definitionId;
        this.containerOID = containerOID;
        this.objectVersion = objectVersion;
        this.contextOID = contextOID;
        this.workStepIndex = workStepIndex;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getContainerOID() {
        return containerOID;
    }

    public void setContainerOID(String containerOID) {
        this.containerOID = containerOID;
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

    public Integer getExceptionHandleDefIndex() {
        return exceptionHandleDefIndex;
    }

    public void setExceptionHandleDefIndex(Integer exceptionHandleDefIndex) {
        this.exceptionHandleDefIndex = exceptionHandleDefIndex;
    }

    public Date getNextExceptionHandleTime() {
        return nextExceptionHandleTime;
    }

    public void setNextExceptionHandleTime(Date nextExceptionHandleTime) {
        this.nextExceptionHandleTime = nextExceptionHandleTime;
    }

    public Integer getNumOfExceptionHandle() {
        return numOfExceptionHandle;
    }

    public void setNumOfExceptionHandle(Integer numOfExceptionHandle) {
        this.numOfExceptionHandle = numOfExceptionHandle;
    }

    public int getWorkStepIndex() {
        return workStepIndex;
    }

    public void setWorkStepIndex(int workStepIndex) {
        this.workStepIndex = workStepIndex;
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
        if (!(object instanceof WorkStep)) {
            return false;
        }
        WorkStep other = (WorkStep) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.WorkStep[ oid=" + oid + " ]";
    }
    
}
