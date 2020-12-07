/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "workstep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkStep.findAll", query = "SELECT w FROM WorkStep w"),
    @NamedQuery(name = "WorkStep.findById", query = "SELECT w FROM WorkStep w WHERE w.id = :id"),
    @NamedQuery(name = "WorkStep.findByUID", query = "SELECT w FROM WorkStep w WHERE w.uid = :uid"),
    @NamedQuery(name = "WorkStep.findByName", query = "SELECT w FROM WorkStep w WHERE w.name = :name"),
    @NamedQuery(name = "WorkStep.findByDescription", query = "SELECT w FROM WorkStep w WHERE w.description = :description"),
    @NamedQuery(name = "WorkStep.findByContextObject", query = "SELECT w FROM WorkStep w WHERE w.contextObject = :contextObject"),
    @NamedQuery(name = "WorkStep.findByContextUID", query = "SELECT w FROM WorkStep w WHERE w.contextUID = :contextUID ORDER BY w.seq"),
    @NamedQuery(name = "WorkStep.findByContextUIDAndSeq", query = "SELECT w FROM WorkStep w WHERE w.contextUID = :contextUID AND w.seq = :seq"),
    @NamedQuery(name = "WorkStep.findByStatus", query = "SELECT w FROM WorkStep w WHERE w.status = :status")})
public class WorkStep extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 200)
    @Column(name = "contextObject")
    private String contextObject;
    @Size(max = 45)
    @Column(name = "contextUID")
    private String contextUID;
    @Size(max = 45)
    @Column(name = "prevStep")
    private String prevStep;
    @Size(max = 45)
    @Column(name = "nextStep")
    private String nextStep;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Size(max = 45)
    @Column(name = "uid")
    private String uid;

    public WorkStep() {
        this.status = "N";
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContextObject() {
        return contextObject;
    }

    public void setContextObject(String contextObject) {
        this.contextObject = contextObject;
    }

    public String getContextUID() {
        return contextUID;
    }

    public void setContextUID(String contextUID) {
        this.contextUID = contextUID;
    }

    public String getPrevStep() {
        return prevStep;
    }

    public void setPrevStep(String prevStep) {
        this.prevStep = prevStep;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUID() {
        return uid;
    }

    public void setUID(String uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkStep)) {
            return false;
        }
        WorkStep other = (WorkStep) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return Objects.equals(this.uid, other.uid);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.WorkStep[ id=" + id + " ]";
    }

}
