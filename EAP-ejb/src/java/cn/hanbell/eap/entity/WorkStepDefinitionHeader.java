/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
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
@Table(name = "workstepdefinitionheader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkStepDefinitionHeader.findAll", query = "SELECT w FROM WorkStepDefinitionHeader w"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findById", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.id = :id"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findByUID", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.uid = :uid"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findByName", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.name = :name"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findByDescription", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.description = :description"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findByContextObject", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.contextObject = :contextObject"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findByRemark", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.remark = :remark"),
    @NamedQuery(name = "WorkStepDefinitionHeader.findByStatus", query = "SELECT w FROM WorkStepDefinitionHeader w WHERE w.status = :status")})
public class WorkStepDefinitionHeader extends SuperEntity {

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
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Size(max = 45)
    @Column(name = "uid")
    private String uid;

    public WorkStepDefinitionHeader() {
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
        if (!(object instanceof WorkStepDefinitionHeader)) {
            return false;
        }
        WorkStepDefinitionHeader other = (WorkStepDefinitionHeader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.WorkStepDefinitionHeader[ id=" + id + " ]";
    }

}
