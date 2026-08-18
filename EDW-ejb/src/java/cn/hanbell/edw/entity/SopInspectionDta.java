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
@Table(name = "SopInspectionDta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SopInspectionDta.findAll", query = "SELECT s FROM SopInspectionDta s"),
    @NamedQuery(name = "SopInspectionDta.findById", query = "SELECT s FROM SopInspectionDta s WHERE s.id = :id"),
    @NamedQuery(name = "SopInspectionDta.findByCompany", query = "SELECT s FROM SopInspectionDta s WHERE s.company = :company"),
    @NamedQuery(name = "SopInspectionDta.findByDeptName", query = "SELECT s FROM SopInspectionDta s WHERE s.deptName = :deptName"),
    @NamedQuery(name = "SopInspectionDta.findByDeptNo", query = "SELECT s FROM SopInspectionDta s WHERE s.deptNo = :deptNo"),
    @NamedQuery(name = "SopInspectionDta.findByPost", query = "SELECT s FROM SopInspectionDta s WHERE s.post = :post"),
    @NamedQuery(name = "SopInspectionDta.findByCheckType", query = "SELECT s FROM SopInspectionDta s WHERE s.checkType = :checkType"),
    @NamedQuery(name = "SopInspectionDta.findByCheckClass", query = "SELECT s FROM SopInspectionDta s WHERE s.checkClass = :checkClass"),
    @NamedQuery(name = "SopInspectionDta.findByFactory", query = "SELECT s FROM SopInspectionDta s WHERE s.factory = :factory"),
    @NamedQuery(name = "SopInspectionDta.findByCreateTime", query = "SELECT s FROM SopInspectionDta s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SopInspectionDta.findByCreateId", query = "SELECT s FROM SopInspectionDta s WHERE s.createId = :createId"),
    @NamedQuery(name = "SopInspectionDta.findByUpdateId", query = "SELECT s FROM SopInspectionDta s WHERE s.updateId = :updateId"),
    @NamedQuery(name = "SopInspectionDta.findByUpdateTime", query = "SELECT s FROM SopInspectionDta s WHERE s.updateTime = :updateTime")})
public class SopInspectionDta implements Serializable {

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

    @Size(max = 20)
    @Column(name = "Result")
    private String result;

    @Size(max = 100)
    @Column(name = "Message")
    private String message;
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

    public SopInspectionDta() {
    }

    public SopInspectionDta(String id) {
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

    public String getReferencespeciFications() {
        return referencespeciFications;
    }

    public void setReferencespeciFications(String referencespeciFications) {
        this.referencespeciFications = referencespeciFications;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof SopInspectionDta)) {
            return false;
        }
        SopInspectionDta other = (SopInspectionDta) object;
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
