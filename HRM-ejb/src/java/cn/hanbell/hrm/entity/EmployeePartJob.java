/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author C0160
 */
@Entity
@Table(name = "EmployeePartJob")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeePartJob.findAll", query = "SELECT e FROM EmployeePartJob e"),
    @NamedQuery(name = "EmployeePartJob.findByEmployeePartJobId", query = "SELECT e FROM EmployeePartJob e WHERE e.employeePartJobId = :employeePartJobId"),
    @NamedQuery(name = "EmployeePartJob.findByEmployeeId", query = "SELECT e FROM EmployeePartJob e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "EmployeePartJob.findByCorporationId", query = "SELECT e FROM EmployeePartJob e WHERE e.corporationId = :corporationId"),
    @NamedQuery(name = "EmployeePartJob.findByDepartmentId", query = "SELECT e FROM EmployeePartJob e WHERE e.departmentId = :departmentId"),
    @NamedQuery(name = "EmployeePartJob.findByJobId", query = "SELECT e FROM EmployeePartJob e WHERE e.jobId = :jobId"),
    @NamedQuery(name = "EmployeePartJob.findByFlag", query = "SELECT e FROM EmployeePartJob e WHERE e.flag = :flag"),
    @NamedQuery(name = "EmployeePartJob.findByLastModifiedDate", query = "SELECT e FROM EmployeePartJob e WHERE e.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "EmployeePartJob.findByPartJobManagerId", query = "SELECT e FROM EmployeePartJob e WHERE e.partJobManagerId = :partJobManagerId"),
    @NamedQuery(name = "EmployeePartJob.findByPartJobManagerDeptId", query = "SELECT e FROM EmployeePartJob e WHERE e.partJobManagerDeptId = :partJobManagerDeptId"),
    @NamedQuery(name = "EmployeePartJob.findByDecisionLevel", query = "SELECT e FROM EmployeePartJob e WHERE e.decisionLevel = :decisionLevel")})
public class EmployeePartJob implements Serializable {

    @JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    @JoinColumn(name = "JobId", referencedColumnName = "JobId", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Job job;

    @JoinColumn(name = "DecisionLevel", referencedColumnName = "CodeInfoId", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private CodeInfo decisionlevelInfo;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "EmployeePartJobId")
    private String employeePartJobId;
    @Size(max = 36)
    @Column(name = "EmployeeId")
    private String employeeId;
    @Size(max = 36)
    @Column(name = "CorporationId")
    private String corporationId;
    @Size(max = 36)
    @Column(name = "DepartmentId")
    private String departmentId;
    @Size(max = 36)
    @Column(name = "JobId")
    private String jobId;
    @Column(name = "BeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
    @Column(name = "IsEffective")
    private Boolean isEffective;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 1073741823)
    @Column(name = "Remark")
    private String remark;
    @Column(name = "Flag")
    private Boolean flag;
    @Size(max = 200)
    @Column(name = "AssignReason")
    private String assignReason;
    @Size(max = 200)
    @Column(name = "OwnerId")
    private String ownerId;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "LastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 36)
    @Column(name = "CreateBy")
    private String createBy;
    @Size(max = 36)
    @Column(name = "LastModifiedBy")
    private String lastModifiedBy;
    @Size(max = 36)
    @Column(name = "PartJobManagerId")
    private String partJobManagerId;
    @Size(max = 36)
    @Column(name = "PartJobManagerDeptId")
    private String partJobManagerDeptId;
    @Size(max = 200)
    @Column(name = "DecisionLevel")
    private String decisionLevel;

    public EmployeePartJob() {
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @return the job
     */
    public Job getJob() {
        return job;
    }

    /**
     * @return the decisionlevelInfo
     */
    public CodeInfo getDecisionlevelInfo() {
        return decisionlevelInfo;
    }

    public String getEmployeePartJobId() {
        return employeePartJobId;
    }

    public void setEmployeePartJobId(String employeePartJobId) {
        this.employeePartJobId = employeePartJobId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getAssignReason() {
        return assignReason;
    }

    public void setAssignReason(String assignReason) {
        this.assignReason = assignReason;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getPartJobManagerId() {
        return partJobManagerId;
    }

    public void setPartJobManagerId(String partJobManagerId) {
        this.partJobManagerId = partJobManagerId;
    }

    public String getPartJobManagerDeptId() {
        return partJobManagerDeptId;
    }

    public void setPartJobManagerDeptId(String partJobManagerDeptId) {
        this.partJobManagerDeptId = partJobManagerDeptId;
    }

    public String getDecisionLevel() {
        return decisionLevel;
    }

    public void setDecisionLevel(String decisionLevel) {
        this.decisionLevel = decisionLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeePartJobId != null ? employeePartJobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeePartJob)) {
            return false;
        }
        EmployeePartJob other = (EmployeePartJob) object;
        if ((this.employeePartJobId == null && other.employeePartJobId != null) || (this.employeePartJobId != null && !this.employeePartJobId.equals(other.employeePartJobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.hrm.entity.EmployeePartJob[ employeePartJobId=" + employeePartJobId + " ]";
    }

}
