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
@Table(name = "EhsSafemanagerStandard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsSafemanagerStandard.findAll", query = "SELECT e FROM EhsSafemanagerStandard e"),
    @NamedQuery(name = "EhsSafemanagerStandard.findById", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.id = :id"),
    @NamedQuery(name = "EhsSafemanagerStandard.findBySeq", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.seq = :seq"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByCompany", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.company = :company"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByDeptName", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.deptName = :deptName"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByDeptNo", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.deptNo = :deptNo"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByPost", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.post = :post"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByCheckType", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.checkType = :checkType"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByCheckClass", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.checkClass = :checkClass"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByReferencespeciFications", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.referencespeciFications = :referencespeciFications"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByFrequentness", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.frequentness = :frequentness"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByCreateTime", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByCreateId", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByUpdateId", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsSafemanagerStandard.findByUpdateTime", query = "SELECT e FROM EhsSafemanagerStandard e WHERE e.updateTime = :updateTime")})
public class EhsSafemanagerStandard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Id")
    private String id;
    @Size(max = 2)
    @Column(name = "Seq")
    private String seq;
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
    @Size(max = 200)
    @Column(name = "CheckClass")
    private String checkClass;
    @Size(max = 200)
    @Column(name = "ReferencespeciFications")
    private String referencespeciFications;
    @Size(max = 20)
    @Column(name = "Frequentness")
    private String frequentness;
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

    public EhsSafemanagerStandard() {
    }

    public EhsSafemanagerStandard(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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

    public String getReferencespeciFications() {
        return referencespeciFications;
    }

    public void setReferencespeciFications(String referencespeciFications) {
        this.referencespeciFications = referencespeciFications;
    }

    public String getFrequentness() {
        return frequentness;
    }

    public void setFrequentness(String frequentness) {
        this.frequentness = frequentness;
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
        if (!(object instanceof EhsSafemanagerStandard)) {
            return false;
        }
        EhsSafemanagerStandard other = (EhsSafemanagerStandard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsSafemanagerStandard[ id=" + id + " ]";
    }
    
}
