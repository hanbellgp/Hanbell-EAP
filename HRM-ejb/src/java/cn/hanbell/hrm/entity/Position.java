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
@Table(name = "Position")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findByPositionId", query = "SELECT p FROM Position p WHERE p.positionId = :positionId"),
    @NamedQuery(name = "Position.findByRemark", query = "SELECT p FROM Position p WHERE p.remark = :remark"),
    @NamedQuery(name = "Position.findByPositionGroupId", query = "SELECT p FROM Position p WHERE p.positionGroupId = :positionGroupId"),
    @NamedQuery(name = "Position.findByCode", query = "SELECT p FROM Position p WHERE p.code = :code"),
    @NamedQuery(name = "Position.findByName", query = "SELECT p FROM Position p WHERE p.name = :name"),
    @NamedQuery(name = "Position.findByFlag", query = "SELECT p FROM Position p WHERE p.flag = :flag"),
    @NamedQuery(name = "Position.findByCreateDate", query = "SELECT p FROM Position p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Position.findByLastModifiedDate", query = "SELECT p FROM Position p WHERE p.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "Position.findByCreateBy", query = "SELECT p FROM Position p WHERE p.createBy = :createBy"),
    @NamedQuery(name = "Position.findByLastModifiedBy", query = "SELECT p FROM Position p WHERE p.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "Position.findByRepealRemark", query = "SELECT p FROM Position p WHERE p.repealRemark = :repealRemark"),
    @NamedQuery(name = "Position.findByAssignReason", query = "SELECT p FROM Position p WHERE p.assignReason = :assignReason"),
    @NamedQuery(name = "Position.findByOwnerId", query = "SELECT p FROM Position p WHERE p.ownerId = :ownerId"),
    @NamedQuery(name = "Position.findByCorporationId", query = "SELECT p FROM Position p WHERE p.corporationId = :corporationId"),
    @NamedQuery(name = "Position.findByBeginEndDateBeginDate", query = "SELECT p FROM Position p WHERE p.beginEndDateBeginDate = :beginEndDateBeginDate"),
    @NamedQuery(name = "Position.findByBeginEndDateEndDate", query = "SELECT p FROM Position p WHERE p.beginEndDateEndDate = :beginEndDateEndDate"),
    @NamedQuery(name = "Position.findByIsNullBeginEndDate", query = "SELECT p FROM Position p WHERE p.isNullBeginEndDate = :isNullBeginEndDate")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "PositionId")
    private String positionId;
    @Size(max = 1073741823)
    @Column(name = "Remark")
    private String remark;
    @Size(max = 200)
    @Column(name = "PositionGroupId")
    private String positionGroupId;
    @Size(max = 200)
    @Column(name = "Code")
    private String code;
    @Size(max = 200)
    @Column(name = "Name")
    private String name;
    @Column(name = "Flag")
    private Boolean flag;
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
    @Size(max = 1073741823)
    @Column(name = "RepealRemark")
    private String repealRemark;
    @Size(max = 200)
    @Column(name = "AssignReason")
    private String assignReason;
    @Size(max = 200)
    @Column(name = "OwnerId")
    private String ownerId;
    @Size(max = 36)
    @Column(name = "CorporationId")
    private String corporationId;
    @Column(name = "BeginEndDate_BeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginEndDateBeginDate;
    @Column(name = "BeginEndDate_EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginEndDateEndDate;
    @Column(name = "IsNull_BeginEndDate")
    private Boolean isNullBeginEndDate;

    public Position() {
    }

    public Position(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPositionGroupId() {
        return positionGroupId;
    }

    public void setPositionGroupId(String positionGroupId) {
        this.positionGroupId = positionGroupId;
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

    public String getRepealRemark() {
        return repealRemark;
    }

    public void setRepealRemark(String repealRemark) {
        this.repealRemark = repealRemark;
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

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
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
        hash += (positionId != null ? positionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.positionId == null && other.positionId != null) || (this.positionId != null && !this.positionId.equals(other.positionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.hrm.entity.Position[ positionId=" + positionId + " ]";
    }
    
}
