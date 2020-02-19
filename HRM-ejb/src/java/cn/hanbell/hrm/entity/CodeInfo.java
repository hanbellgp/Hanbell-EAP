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
 * @author C1879
 */
@Entity
@Table(name = "CodeInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeInfo.findAll", query = "SELECT c FROM CodeInfo c")
    , @NamedQuery(name = "CodeInfo.findByCodeInfoId", query = "SELECT c FROM CodeInfo c WHERE c.codeInfoId = :codeInfoId")
    , @NamedQuery(name = "CodeInfo.findByKindCode", query = "SELECT c FROM CodeInfo c WHERE c.kindCode = :kindCode")
    , @NamedQuery(name = "CodeInfo.findByKindName", query = "SELECT c FROM CodeInfo c WHERE c.kindName = :kindName")
    , @NamedQuery(name = "CodeInfo.findByInfoCode", query = "SELECT c FROM CodeInfo c WHERE c.infoCode = :infoCode")
    , @NamedQuery(name = "CodeInfo.findByScName", query = "SELECT c FROM CodeInfo c WHERE c.scName = :scName")
    , @NamedQuery(name = "CodeInfo.findByIsSystem", query = "SELECT c FROM CodeInfo c WHERE c.isSystem = :isSystem")
    , @NamedQuery(name = "CodeInfo.findByRemark", query = "SELECT c FROM CodeInfo c WHERE c.remark = :remark")
    , @NamedQuery(name = "CodeInfo.findByCorporationId", query = "SELECT c FROM CodeInfo c WHERE c.corporationId = :corporationId")
    , @NamedQuery(name = "CodeInfo.findByFlag", query = "SELECT c FROM CodeInfo c WHERE c.flag = :flag")
    , @NamedQuery(name = "CodeInfo.findByCreateDate", query = "SELECT c FROM CodeInfo c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CodeInfo.findByLastModifiedDate", query = "SELECT c FROM CodeInfo c WHERE c.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "CodeInfo.findByCreateBy", query = "SELECT c FROM CodeInfo c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CodeInfo.findByLastModifiedBy", query = "SELECT c FROM CodeInfo c WHERE c.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "CodeInfo.findByOrderNumber", query = "SELECT c FROM CodeInfo c WHERE c.orderNumber = :orderNumber")
    , @NamedQuery(name = "CodeInfo.findByEnabled", query = "SELECT c FROM CodeInfo c WHERE c.enabled = :enabled")
    , @NamedQuery(name = "CodeInfo.findByAssignReason", query = "SELECT c FROM CodeInfo c WHERE c.assignReason = :assignReason")
    , @NamedQuery(name = "CodeInfo.findByOwnerId", query = "SELECT c FROM CodeInfo c WHERE c.ownerId = :ownerId")
    , @NamedQuery(name = "CodeInfo.findByIsESSSelect", query = "SELECT c FROM CodeInfo c WHERE c.isESSSelect = :isESSSelect")
    , @NamedQuery(name = "CodeInfo.findByIsEmployeeContract", query = "SELECT c FROM CodeInfo c WHERE c.isEmployeeContract = :isEmployeeContract")})
public class CodeInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CodeInfoId")
    private String codeInfoId;
    @Size(max = 200)
    @Column(name = "KindCode")
    private String kindCode;
    @Size(max = 200)
    @Column(name = "KindName")
    private String kindName;
    @Size(max = 200)
    @Column(name = "InfoCode")
    private String infoCode;
    @Size(max = 200)
    @Column(name = "ScName")
    private String scName;
    @Column(name = "IsSystem")
    private Boolean isSystem;
    @Size(max = 1073741823)
    @Column(name = "Remark")
    private String remark;
    @Size(max = 36)
    @Column(name = "CorporationId")
    private String corporationId;
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
    @Column(name = "OrderNumber")
    private Integer orderNumber;
    @Column(name = "Enabled")
    private Boolean enabled;
    @Size(max = 200)
    @Column(name = "AssignReason")
    private String assignReason;
    @Size(max = 200)
    @Column(name = "OwnerId")
    private String ownerId;
    @Column(name = "IsESSSelect")
    private Boolean isESSSelect;
    @Column(name = "IsEmployeeContract")
    private Boolean isEmployeeContract;

    public CodeInfo() {
    }

    public CodeInfo(String codeInfoId) {
        this.codeInfoId = codeInfoId;
    }

    public String getCodeInfoId() {
        return codeInfoId;
    }

    public void setCodeInfoId(String codeInfoId) {
        this.codeInfoId = codeInfoId;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public Boolean getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Boolean isSystem) {
        this.isSystem = isSystem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Boolean getIsESSSelect() {
        return isESSSelect;
    }

    public void setIsESSSelect(Boolean isESSSelect) {
        this.isESSSelect = isESSSelect;
    }

    public Boolean getIsEmployeeContract() {
        return isEmployeeContract;
    }

    public void setIsEmployeeContract(Boolean isEmployeeContract) {
        this.isEmployeeContract = isEmployeeContract;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeInfoId != null ? codeInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeInfo)) {
            return false;
        }
        CodeInfo other = (CodeInfo) object;
        if ((this.codeInfoId == null && other.codeInfoId != null) || (this.codeInfoId != null && !this.codeInfoId.equals(other.codeInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.hrm.entity.CodeInfo[ codeInfoId=" + codeInfoId + " ]";
    }
    
}
