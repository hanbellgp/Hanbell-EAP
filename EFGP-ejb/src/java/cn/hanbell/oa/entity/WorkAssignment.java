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
 * @author C0160
 */
@Entity
@Table(name = "WorkAssignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkAssignment.findAll", query = "SELECT w FROM WorkAssignment w"),
    @NamedQuery(name = "WorkAssignment.findByOID", query = "SELECT w FROM WorkAssignment w WHERE w.oid = :oid"),
    @NamedQuery(name = "WorkAssignment.findByObjectVersion", query = "SELECT w FROM WorkAssignment w WHERE w.objectVersion = :objectVersion"),
    @NamedQuery(name = "WorkAssignment.findByWorkItemOID", query = "SELECT w FROM WorkAssignment w WHERE w.workItemOID = :workItemOID"),
    @NamedQuery(name = "WorkAssignment.findByAssigneeOID", query = "SELECT w FROM WorkAssignment w WHERE w.assigneeOID = :assigneeOID"),
    @NamedQuery(name = "WorkAssignment.findByAssignmentType", query = "SELECT w FROM WorkAssignment w WHERE w.assignmentType = :assignmentType"),
    @NamedQuery(name = "WorkAssignment.findByIsNotice", query = "SELECT w FROM WorkAssignment w WHERE w.isNotice = :isNotice"),
    @NamedQuery(name = "WorkAssignment.findByNoticeType", query = "SELECT w FROM WorkAssignment w WHERE w.noticeType = :noticeType"),
    @NamedQuery(name = "WorkAssignment.findByViewTimes", query = "SELECT w FROM WorkAssignment w WHERE w.viewTimes = :viewTimes")})
public class WorkAssignment implements Serializable {

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
    @Column(name = "workItemOID")
    private String workItemOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "assigneeOID")
    private String assigneeOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignmentType")
    private int assignmentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isNotice")
    private int isNotice;
    @Column(name = "noticeType")
    private Integer noticeType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viewTimes")
    private int viewTimes;

    public WorkAssignment() {
    }

    public WorkAssignment(String oid) {
        this.oid = oid;
    }

    public WorkAssignment(String oid, int objectVersion, String workItemOID, String assigneeOID, int assignmentType, int isNotice, int viewTimes) {
        this.oid = oid;
        this.objectVersion = objectVersion;
        this.workItemOID = workItemOID;
        this.assigneeOID = assigneeOID;
        this.assignmentType = assignmentType;
        this.isNotice = isNotice;
        this.viewTimes = viewTimes;
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

    public String getWorkItemOID() {
        return workItemOID;
    }

    public void setWorkItemOID(String workItemOID) {
        this.workItemOID = workItemOID;
    }

    public String getAssigneeOID() {
        return assigneeOID;
    }

    public void setAssigneeOID(String assigneeOID) {
        this.assigneeOID = assigneeOID;
    }

    public int getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(int assignmentType) {
        this.assignmentType = assignmentType;
    }

    public int getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(int isNotice) {
        this.isNotice = isNotice;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public int getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(int viewTimes) {
        this.viewTimes = viewTimes;
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
        if (!(object instanceof WorkAssignment)) {
            return false;
        }
        WorkAssignment other = (WorkAssignment) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.WorkAssignment[ oid=" + oid + " ]";
    }
    
}
