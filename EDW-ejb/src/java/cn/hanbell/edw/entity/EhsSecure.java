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
@Table(name = "EhsSecure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsSecure.findAll", query = "SELECT e FROM EhsSecure e"),
    @NamedQuery(name = "EhsSecure.findById", query = "SELECT e FROM EhsSecure e WHERE e.id = :id"),
    @NamedQuery(name = "EhsSecure.findByCompany", query = "SELECT e FROM EhsSecure e WHERE e.company = :company"),
    @NamedQuery(name = "EhsSecure.findByDeptNo", query = "SELECT e FROM EhsSecure e WHERE e.deptNo = :deptNo"),
    @NamedQuery(name = "EhsSecure.findByDeptName", query = "SELECT e FROM EhsSecure e WHERE e.deptName = :deptName"),
    @NamedQuery(name = "EhsSecure.findBySecureName", query = "SELECT e FROM EhsSecure e WHERE e.secureName = :secureName"),
    @NamedQuery(name = "EhsSecure.findBySecureId", query = "SELECT e FROM EhsSecure e WHERE e.secureId = :secureId"),
    @NamedQuery(name = "EhsSecure.findByPosition", query = "SELECT e FROM EhsSecure e WHERE e.position = :position"),
    @NamedQuery(name = "EhsSecure.findByRemark", query = "SELECT e FROM EhsSecure e WHERE e.remark = :remark"),
    @NamedQuery(name = "EhsSecure.findByCreateTime", query = "SELECT e FROM EhsSecure e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsSecure.findByCreateId", query = "SELECT e FROM EhsSecure e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsSecure.findByUpdateId", query = "SELECT e FROM EhsSecure e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsSecure.findByUpdateTime", query = "SELECT e FROM EhsSecure e WHERE e.updateTime = :updateTime")})
public class EhsSecure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Id")
    private String id;
    @Size(max = 30)
    @Column(name = "Company")
    private String company;
    @Size(max = 30)
    @Column(name = "DeptNo")
    private String deptNo;
    @Size(max = 30)
    @Column(name = "DeptName")
    private String deptName;
    @Size(max = 30)
    @Column(name = "SecureName")
    private String secureName;
    @Size(max = 30)
    @Column(name = "SecureId")
    private String secureId;
    @Size(max = 30)
    @Column(name = "Position")
    private String position;
    @Size(max = 30)
    @Column(name = "Remark")
    private String remark;
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

    public EhsSecure() {
    }

    public EhsSecure(String id) {
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

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSecureName() {
        return secureName;
    }

    public void setSecureName(String secureName) {
        this.secureName = secureName;
    }

    public String getSecureId() {
        return secureId;
    }

    public void setSecureId(String secureId) {
        this.secureId = secureId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof EhsSecure)) {
            return false;
        }
        EhsSecure other = (EhsSecure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsSecure[ id=" + id + " ]";
    }
    
}
