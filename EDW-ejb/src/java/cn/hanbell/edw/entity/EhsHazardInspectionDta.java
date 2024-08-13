/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "EhsHazardInspectionDta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsHazardInspectionDta.findAll", query = "SELECT e FROM EhsHazardInspectionDta e"),
    @NamedQuery(name = "EhsHazardInspectionDta.findById", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.id = :id"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByPid", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.pid = :pid"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByCompany", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.company = :company"),
    @NamedQuery(name = "EhsHazardInspectionDta.findBySeq", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.seq = :seq"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByProject", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.project = :project"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByResult", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.result = :result"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByHiddenDangerId", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.hiddenDangerId = :hiddenDangerId"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByCreateTime", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByCreateId", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByUpdateId", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsHazardInspectionDta.findByUpdateTime", query = "SELECT e FROM EhsHazardInspectionDta e WHERE e.updateTime = :updateTime")})
public class EhsHazardInspectionDta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Id")
    private String id;
    @Size(max = 30)
    @Column(name = "Pid")
    private String pid;
    @Size(max = 4)
    @Column(name = "Company")
    private String company;
    @Size(max = 2)
    @Column(name = "Seq")
    private String seq;
    @Size(max = 200)
    @Column(name = "Project")
    private String project;
    @Size(max = 10)
    @Column(name = "Result")
    private String result;
    @Size(max = 30)
    @Column(name = "HiddenDangerId")
    private String hiddenDangerId;
    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 30)
    @Column(name = "CreateId")
    private String createId;
    @Size(max = 30)
    @Column(name = "UpdateId")
    private String updateId;
    @Column(name = "UpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public EhsHazardInspectionDta() {
    }

    public EhsHazardInspectionDta(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getHiddenDangerId() {
        return hiddenDangerId;
    }

    public void setHiddenDangerId(String hiddenDangerId) {
        this.hiddenDangerId = hiddenDangerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        if (!(object instanceof EhsHazardInspectionDta)) {
            return false;
        }
        EhsHazardInspectionDta other = (EhsHazardInspectionDta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsHazardInspectionDta[ id=" + id + " ]";
    }
    
}
