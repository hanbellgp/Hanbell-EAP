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
@Table(name = "EhsHazardInspection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsHazardInspection.findAll", query = "SELECT e FROM EhsHazardInspection e"),
    @NamedQuery(name = "EhsHazardInspection.findById", query = "SELECT e FROM EhsHazardInspection e WHERE e.id = :id"),
    @NamedQuery(name = "EhsHazardInspection.findByCompany", query = "SELECT e FROM EhsHazardInspection e WHERE e.company = :company"),
    @NamedQuery(name = "EhsHazardInspection.findByPatrolId", query = "SELECT e FROM EhsHazardInspection e WHERE e.patrolId = :patrolId"),
    @NamedQuery(name = "EhsHazardInspection.findByPatrolName", query = "SELECT e FROM EhsHazardInspection e WHERE e.patrolName = :patrolName"),
    @NamedQuery(name = "EhsHazardInspection.findByPatrolType", query = "SELECT e FROM EhsHazardInspection e WHERE e.patrolType = :patrolType"),
    @NamedQuery(name = "EhsHazardInspection.findByPatrolPost", query = "SELECT e FROM EhsHazardInspection e WHERE e.patrolPost = :patrolPost"),
    @NamedQuery(name = "EhsHazardInspection.findByPatrolDept", query = "SELECT e FROM EhsHazardInspection e WHERE e.patrolDept = :patrolDept"),
    @NamedQuery(name = "EhsHazardInspection.findByPatrolDeptName", query = "SELECT e FROM EhsHazardInspection e WHERE e.patrolDeptName = :patrolDeptName"),
    @NamedQuery(name = "EhsHazardInspection.findByResult", query = "SELECT e FROM EhsHazardInspection e WHERE e.result = :result"),
    @NamedQuery(name = "EhsHazardInspection.findByStatus", query = "SELECT e FROM EhsHazardInspection e WHERE e.status = :status"),
    @NamedQuery(name = "EhsHazardInspection.findByCreateTime", query = "SELECT e FROM EhsHazardInspection e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsHazardInspection.findByCreateId", query = "SELECT e FROM EhsHazardInspection e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsHazardInspection.findByUpdateId", query = "SELECT e FROM EhsHazardInspection e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsHazardInspection.findByUpdateTime", query = "SELECT e FROM EhsHazardInspection e WHERE e.updateTime = :updateTime")})
public class EhsHazardInspection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Id")
    private String id;
    @Size(max = 4)
    @Column(name = "Company")
    private String company;
    @Size(max = 20)
    @Column(name = "PatrolId")
    private String patrolId;
    @Size(max = 20)
    @Column(name = "PatrolName")
    private String patrolName;
    @Size(max = 20)
    @Column(name = "PatrolType")
    private String patrolType;
    @Size(max = 20)
    @Column(name = "PatrolPost")
    private String patrolPost;
    @Size(max = 20)
    @Column(name = "PatrolDept")
    private String patrolDept;
    @Size(max = 20)
    @Column(name = "PatrolDeptName")
    private String patrolDeptName;
    @Size(max = 20)
    @Column(name = "Result")
    private String result;
    @Size(max = 4)
    @Column(name = "Status")
    private String status;
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

    public EhsHazardInspection() {
    }

    public EhsHazardInspection(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPatrolId() {
        return patrolId;
    }

    public void setPatrolId(String patrolId) {
        this.patrolId = patrolId;
    }

    public String getPatrolName() {
        return patrolName;
    }

    public void setPatrolName(String patrolName) {
        this.patrolName = patrolName;
    }

    public String getPatrolType() {
        return patrolType;
    }

    public void setPatrolType(String patrolType) {
        this.patrolType = patrolType;
    }

    public String getPatrolPost() {
        return patrolPost;
    }

    public void setPatrolPost(String patrolPost) {
        this.patrolPost = patrolPost;
    }

    public String getPatrolDept() {
        return patrolDept;
    }

    public void setPatrolDept(String patrolDept) {
        this.patrolDept = patrolDept;
    }

    public String getPatrolDeptName() {
        return patrolDeptName;
    }

    public void setPatrolDeptName(String patrolDeptName) {
        this.patrolDeptName = patrolDeptName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof EhsHazardInspection)) {
            return false;
        }
        EhsHazardInspection other = (EhsHazardInspection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsHazardInspection[ id=" + id + " ]";
    }
    
}
