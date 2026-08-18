/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author S31106868hb
 */
@Entity
@Table(name = "SopSafemanagerStandard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SopSafemanagerStandard.findAll", query = "SELECT s FROM SopSafemanagerStandard s"),
    @NamedQuery(name = "SopSafemanagerStandard.findById", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.id = :id"),
    @NamedQuery(name = "SopSafemanagerStandard.findByCompany", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.company = :company"),
    @NamedQuery(name = "SopSafemanagerStandard.findByDeptName", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.deptName = :deptName"),
    @NamedQuery(name = "SopSafemanagerStandard.findByDeptNo", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.deptNo = :deptNo"),
    @NamedQuery(name = "SopSafemanagerStandard.findByPost", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.post = :post"),
    @NamedQuery(name = "SopSafemanagerStandard.findByCheckType", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.checkType = :checkType"),
    @NamedQuery(name = "SopSafemanagerStandard.findByCheckClass", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.checkClass = :checkClass"),
    @NamedQuery(name = "SopSafemanagerStandard.findByFactory", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.factory = :factory"),
    @NamedQuery(name = "SopSafemanagerStandard.findByCreateTime", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SopSafemanagerStandard.findByCreateId", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.createId = :createId"),
    @NamedQuery(name = "SopSafemanagerStandard.findByUpdateId", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.updateId = :updateId"),
    @NamedQuery(name = "SopSafemanagerStandard.findByUpdateTime", query = "SELECT s FROM SopSafemanagerStandard s WHERE s.updateTime = :updateTime")})
public class SopSafemanagerStandard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Id")
    private String id;
    @Size(max = 2)
    @Column(name = "Company")
    private String company;
    @Size(max = 20)
    @Column(name = "DeptName")
    private String deptName;
    @Size(max = 20)
    @Column(name = "DeptNo")
    private String deptNo;
    @Size(max = 20)
    @Column(name = "Post")
    private String post;
    @Size(max = 20)
    @Column(name = "CheckType")
    private String checkType;
    @Size(max = 400)
    @Column(name = "CheckClass")
    private String checkClass;
    @Size(max = 100)
    @Column(name = "Factory")
    private String factory;
    @Size(max = 400)
    @Column(name = "ReferencespeciFications")
    private String referencespeciFications;

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

    public SopSafemanagerStandard() {
    }

    public SopSafemanagerStandard(String id) {
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckClass() {
        return checkClass;
    }

    public void setCheckClass(String checkClass) {
        this.checkClass = checkClass;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getReferencespeciFications() {
        return referencespeciFications;
    }

    public void setReferencespeciFications(String referencespeciFications) {
        this.referencespeciFications = referencespeciFications;
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
        if (!(object instanceof SopSafemanagerStandard)) {
            return false;
        }
        SopSafemanagerStandard other = (SopSafemanagerStandard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.SopSafemanagerStandard[ id=" + id + " ]";
    }

}
