/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.hanbell.exch.entity;

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
 * @author C2082
 */
@Entity
@Table(name = "BPM_Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BPMEmployee.findAll", query = "SELECT b FROM BPMEmployee b"),
    @NamedQuery(name = "BPMEmployee.findByUserid", query = "SELECT b FROM BPMEmployee b WHERE b.userid = :userid"),
    @NamedQuery(name = "BPMEmployee.findByWecomid", query = "SELECT b FROM BPMEmployee b WHERE b.wecomid = :wecomid"),
    @NamedQuery(name = "BPMEmployee.findByCnName", query = "SELECT b FROM BPMEmployee b WHERE b.cnName = :cnName"),
    @NamedQuery(name = "BPMEmployee.findByJobName", query = "SELECT b FROM BPMEmployee b WHERE b.jobName = :jobName"),
    @NamedQuery(name = "BPMEmployee.findByDepartmentId", query = "SELECT b FROM BPMEmployee b WHERE b.departmentId = :departmentId"),
    @NamedQuery(name = "BPMEmployee.findByDepartmentName", query = "SELECT b FROM BPMEmployee b WHERE b.departmentName = :departmentName"),
    @NamedQuery(name = "BPMEmployee.findByLastModifiedDate", query = "SELECT b FROM BPMEmployee b WHERE b.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "BPMEmployee.findByLastWorkDate", query = "SELECT b FROM BPMEmployee b WHERE b.lastWorkDate = :lastWorkDate"),
    @NamedQuery(name = "BPMEmployee.findByEmployeeStateId", query = "SELECT b FROM BPMEmployee b WHERE b.employeeStateId = :employeeStateId"),
    @NamedQuery(name = "BPMEmployee.findByEmployeeStateName", query = "SELECT b FROM BPMEmployee b WHERE b.employeeStateName = :employeeStateName"),
    @NamedQuery(name = "BPMEmployee.findByCreateDate", query = "SELECT b FROM BPMEmployee b WHERE b.createDate = :createDate"),
    @NamedQuery(name = "BPMEmployee.findByFactoryId", query = "SELECT b FROM BPMEmployee b WHERE b.factoryId = :factoryId"),
    @NamedQuery(name = "BPMEmployee.findByFactoryName", query = "SELECT b FROM BPMEmployee b WHERE b.factoryName = :factoryName"),
    @NamedQuery(name = "BPMEmployee.findBySyscOrg", query = "SELECT b FROM BPMEmployee b WHERE b.syscOrg = :syscOrg"),
    @NamedQuery(name = "BPMEmployee.findByProno", query = "SELECT b FROM BPMEmployee b WHERE b.prono = :prono")})
public class BPMEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Userid")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Wecomid")
    private String wecomid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CnName")
    private String cnName;
    @Size(max = 200)
    @Column(name = "JobName")
    private String jobName;
    @Size(max = 200)
    @Column(name = "DepartmentId")
    private String departmentId;
    @Size(max = 200)
    @Column(name = "DepartmentName")
    private String departmentName;
    @Column(name = "LastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "LastWorkDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastWorkDate;
    @Size(max = 200)
    @Column(name = "EmployeeStateId")
    private String employeeStateId;
    @Size(max = 200)
    @Column(name = "EmployeeStateName")
    private String employeeStateName;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 200)
    @Column(name = "FactoryId")
    private String factoryId;
    @Size(max = 200)
    @Column(name = "FactoryName")
    private String factoryName;
    @Size(max = 200)
    @Column(name = "SyscOrg")
    private String syscOrg;
    @Size(max = 10)
    @Column(name = "Prono")
    private String prono;

    public BPMEmployee() {
    }

    public BPMEmployee(String userid) {
        this.userid = userid;
    }

    public BPMEmployee(String userid, String wecomid, String cnName) {
        this.userid = userid;
        this.wecomid = wecomid;
        this.cnName = cnName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWecomid() {
        return wecomid;
    }

    public void setWecomid(String wecomid) {
        this.wecomid = wecomid;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getLastWorkDate() {
        return lastWorkDate;
    }

    public void setLastWorkDate(Date lastWorkDate) {
        this.lastWorkDate = lastWorkDate;
    }

    public String getEmployeeStateId() {
        return employeeStateId;
    }

    public void setEmployeeStateId(String employeeStateId) {
        this.employeeStateId = employeeStateId;
    }

    public String getEmployeeStateName() {
        return employeeStateName;
    }

    public void setEmployeeStateName(String employeeStateName) {
        this.employeeStateName = employeeStateName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getSyscOrg() {
        return syscOrg;
    }

    public void setSyscOrg(String syscOrg) {
        this.syscOrg = syscOrg;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BPMEmployee)) {
            return false;
        }
        BPMEmployee other = (BPMEmployee) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tw.hanbell.exch.entity.BPMEmployee[ userid=" + userid + " ]";
    }
    
}
