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
@Table(name = "Department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentId", query = "SELECT d FROM Department d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "Department.findByCode", query = "SELECT d FROM Department d WHERE d.code = :code"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByOwnerId", query = "SELECT d FROM Department d WHERE d.ownerId = :ownerId")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "DepartmentId")
    private String departmentId;
    @Size(max = 200)
    @Column(name = "ShortName")
    private String shortName;
    @Size(max = 1073741823)
    @Column(name = "Describe")
    private String describe;
    @Size(max = 200)
    @Column(name = "RepealRemark")
    private String repealRemark;
    @Column(name = "Type")
    private Integer type;
    @Size(max = 36)
    @Column(name = "CorporationId")
    private String corporationId;
    @Size(max = 200)
    @Column(name = "ParentId")
    private String parentId;
    @Size(max = 36)
    @Column(name = "CostCenterId")
    private String costCenterId;
    @Column(name = "OrderNumber")
    private Integer orderNumber;
    @Size(max = 200)
    @Column(name = "Code")
    private String code;
    @Size(max = 200)
    @Column(name = "Name")
    private String name;
    @Column(name = "Flag")
    private Boolean flag;
    @Column(name = "IsERP")
    private Boolean isERP;
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
    @Size(max = 200)
    @Column(name = "AssignReason")
    private String assignReason;
    @Size(max = 200)
    @Column(name = "OwnerId")
    private String ownerId;
    @Size(max = 200)
    @Column(name = "Alias")
    private String alias;
    @Size(max = 200)
    @Column(name = "OrgType")
    private String orgType;
    @Column(name = "IsShowInOrg")
    private Boolean isShowInOrg;
    @Column(name = "IsAccounting")
    private Boolean isAccounting;
    @Size(max = 200)
    @Column(name = "CostTypeId")
    private String costTypeId;
    @Column(name = "DeptLevel")
    private Integer deptLevel;
    @Size(max = 36)
    @Column(name = "DirectDeptId")
    private String directDeptId;
    @Size(max = 36)
    @Column(name = "WorkingCenterId")
    private String workingCenterId;
    @Size(max = 36)
    @Column(name = "Principal")
    private String principal;
    @Column(name = "LevelCode")
    private Integer levelCode;
    @Size(max = 200)
    @Column(name = "FloorCode")
    private String floorCode;
    @Size(max = 36)
    @Column(name = "PrincipalJobId")
    private String principalJobId;
    @Size(max = 200)
    @Column(name = "DisplayLever")
    private String displayLever;
    @Column(name = "SN")
    private Integer sn;
    @Column(name = "BeginEndDate_BeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginEndDateBeginDate;
    @Column(name = "BeginEndDate_EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginEndDateEndDate;
    @Column(name = "IsNull_BeginEndDate")
    private Boolean isNullBeginEndDate;

    public Department() {
    }

    public Department(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRepealRemark() {
        return repealRemark;
    }

    public void setRepealRemark(String repealRemark) {
        this.repealRemark = repealRemark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(String costCenterId) {
        this.costCenterId = costCenterId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getIsERP() {
        return isERP;
    }

    public void setIsERP(Boolean isERP) {
        this.isERP = isERP;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public Boolean getIsShowInOrg() {
        return isShowInOrg;
    }

    public void setIsShowInOrg(Boolean isShowInOrg) {
        this.isShowInOrg = isShowInOrg;
    }

    public Boolean getIsAccounting() {
        return isAccounting;
    }

    public void setIsAccounting(Boolean isAccounting) {
        this.isAccounting = isAccounting;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId;
    }

    public Integer getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Integer deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDirectDeptId() {
        return directDeptId;
    }

    public void setDirectDeptId(String directDeptId) {
        this.directDeptId = directDeptId;
    }

    public String getWorkingCenterId() {
        return workingCenterId;
    }

    public void setWorkingCenterId(String workingCenterId) {
        this.workingCenterId = workingCenterId;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getPrincipalJobId() {
        return principalJobId;
    }

    public void setPrincipalJobId(String principalJobId) {
        this.principalJobId = principalJobId;
    }

    public String getDisplayLever() {
        return displayLever;
    }

    public void setDisplayLever(String displayLever) {
        this.displayLever = displayLever;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Date getBeginEndDateBeginDate() {
        return beginEndDateBeginDate;
    }

    public void setBeginEndDateBeginDate(Date beginEndDateBeginDate) {
        this.beginEndDateBeginDate = beginEndDateBeginDate;
    }

    public Date getBeginEndDateEndDate() {
        return beginEndDateEndDate;
    }

    public void setBeginEndDateEndDate(Date beginEndDateEndDate) {
        this.beginEndDateEndDate = beginEndDateEndDate;
    }

    public Boolean getIsNullBeginEndDate() {
        return isNullBeginEndDate;
    }

    public void setIsNullBeginEndDate(Boolean isNullBeginEndDate) {
        this.isNullBeginEndDate = isNullBeginEndDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.hr.entity.Department[ departmentId=" + departmentId + " ]";
    }

}
