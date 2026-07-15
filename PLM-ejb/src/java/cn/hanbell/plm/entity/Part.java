/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author ZFF
 */
@Entity
@Table(name = "PART" , schema = "innovator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Part.findAll", query = "SELECT p FROM Part p"),
    @NamedQuery(name = "Part.findByKeyedName", query = "SELECT p FROM Part p WHERE p.keyedName = :keyedName and p.isCurrent = '1' "),
    @NamedQuery(name = "Part.findById", query = "SELECT p FROM Part p WHERE p.id = :id"),   
    @NamedQuery(name = "Part.findByCreatedById", query = "SELECT p FROM Part p WHERE p.createdById = :createdById"),
    @NamedQuery(name = "Part.findByItemNumber", query = "SELECT p FROM Part p WHERE p.itemNumber = :itemNumber"),
    @NamedQuery(name = "Part.findByCnNameEn", query = "SELECT p FROM Part p WHERE p.cnNameEn = :cnNameEn"),
    @NamedQuery(name = "Part.findByCnSpecEn", query = "SELECT p FROM Part p WHERE p.cnSpecEn = :cnSpecEn"),
    @NamedQuery(name = "Part.findByCnNameCn", query = "SELECT p FROM Part p WHERE p.cnNameCn = :cnNameCn"),
    @NamedQuery(name = "Part.findByCnSpecCn", query = "SELECT p FROM Part p WHERE p.cnSpecCn = :cnSpecCn")
})
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 128)
    @Column(name = "KEYED_NAME")
    private String keyedName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CREATED_BY_ID")
    private String createdById;
    @Size(max = 32)
    @Column(name = "OWNED_BY_ID")
    private String ownedById;
    @Size(max = 32)
    @Column(name = "MANAGED_BY_ID")
    private String managedById;
    @Column(name = "MODIFIED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Size(max = 32)
    @Column(name = "MODIFIED_BY_ID")
    private String modifiedById;
    @Size(max = 32)
    @Column(name = "CURRENT_STATE")
    private String currentState;
    @Size(max = 32)
    @Column(name = "LOCKED_BY_ID")
    private String lockedById;
    @Column(name = "IS_CURRENT")
    private Character isCurrent;
    @Size(max = 8)
    @Column(name = "MINOR_REV")
    private String minorRev;
    @Column(name = "IS_RELEASED")
    private Character isReleased;
    @Column(name = "NOT_LOCKABLE")
    private Character notLockable;
    @Size(max = 2147483647)
    @Column(name = "CSS")
    private String css;
    @Column(name = "GENERATION")
    private Integer generation;
    @Column(name = "NEW_VERSION")
    private Character newVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CONFIG_ID")
    private String configId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PERMISSION_ID")
    private String permissionId;
    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;
    @Column(name = "EFFECTIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;
    @Size(max = 32)
    @Column(name = "TEAM_ID")
    private String teamId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST")
    private BigDecimal cost;
    @Size(max = 64)
    @Column(name = "COST_BASIS")
    private String costBasis;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 256)
    @Column(name = "EXTERNAL_ID")
    private String externalId;
    @Size(max = 128)
    @Column(name = "EXTERNAL_OWNER")
    private String externalOwner;
    @Size(max = 128)
    @Column(name = "EXTERNAL_TYPE")
    private String externalType;
    @Column(name = "HAS_CHANGE_PENDING")
    private Character hasChangePending;
    @Size(max = 64)
    @Column(name = "MAKE_BUY")
    private String makeBuy;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 128)
    @Column(name = "THUMBNAIL")
    private String thumbnail;
    @Size(max = 64)
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "WEIGHT")
    private BigDecimal weight;
    @Size(max = 64)
    @Column(name = "WEIGHT_BASIS")
    private String weightBasis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 27)
    @Column(name = "ITEM_NUMBER")
    private String itemNumber;
    @Size(max = 512)
    @Column(name = "CLASSIFICATION")
    private String classification;
    @Size(max = 8)
    @Column(name = "MAJOR_REV")
    private String majorRev;
    @Size(max = 32)
    @Column(name = "STATE")
    private String state;
    @Column(name = "SUPERSEDED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date supersededDate;
    @Size(max = 128)
    @Column(name = "BCS_AUTONUMBER")
    private String bcsAutonumber;
    @Column(name = "BCS_IS_SAD")
    private Character bcsIsSad;
    @Column(name = "BCS_ISRESTRICTED")
    private Character bcsIsrestricted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CN_UNIT")
    private String cnUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CN_UNIT_EN")
    private String cnUnitEn;
    @Size(max = 60)
    @Column(name = "CN_NAME_EN")
    private String cnNameEn;
    @Size(max = 30)
    @Column(name = "CN_SPEC_ZT")
    private String cnSpecZt;
    @Size(max = 60)
    @Column(name = "CN_SPEC_EN")
    private String cnSpecEn;
    @Size(max = 30)
    @Column(name = "CN_NAME_CN")
    private String cnNameCn;
    @Size(max = 30)
    @Column(name = "CN_SPEC_CN")
    private String cnSpecCn;
    @Column(name = "CN_IS_ALL_BOM")
    private Character cnIsAllBom;
    @Column(name = "CN_TO_ERP")
    private Character cnToErp;
    @Column(name = "CN_ERP_COMFIRM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cnErpComfirmDate;
    @Size(max = 256)
    @Column(name = "CN_GROUP_ID")
    private String cnGroupId;
    @Size(max = 256)
    @Column(name = "CN_PRODUCT_CLASS")
    private String cnProductClass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CN_PRODUCT_SERIES")
    private String cnProductSeries;
    @Size(max = 256)
    @Column(name = "CN_CLASSIFICATION")
    private String cnClassification;
    @Size(max = 256)
    @Column(name = "CN_PRODUCT_TYPE")
    private String cnProductType;
    @Size(max = 256)
    @Column(name = "CN_PART_TYPE")
    private String cnPartType;
    @Size(max = 40)
    @Column(name = "CN_CADCAMNO")
    private String cnCadcamno;
    @Size(max = 20)
    @Column(name = "ITEM_NUMBER2")
    private String itemNumber2;
    @Size(max = 20)
    @Column(name = "ITEM_OLDNUMBER")
    private String itemOldnumber;
    @Size(max = 32)
    @Column(name = "VIEWABLE_FILE")
    private String viewableFile;
    @Size(max = 32)
    @Column(name = "VIEW_FILE")
    private String viewFile;

    public Part() {
    }

    public Part(String id) {
        this.id = id;
    }

    public Part(String id, Date createdOn, String createdById, String configId, String permissionId, String itemNumber, String cnUnit, String cnUnitEn, String cnProductSeries) {
        this.id = id;
        this.createdOn = createdOn;
        this.createdById = createdById;
        this.configId = configId;
        this.permissionId = permissionId;
        this.itemNumber = itemNumber;
        this.cnUnit = cnUnit;
        this.cnUnitEn = cnUnitEn;
        this.cnProductSeries = cnProductSeries;
    }

    public String getKeyedName() {
        return keyedName;
    }

    public void setKeyedName(String keyedName) {
        this.keyedName = keyedName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getOwnedById() {
        return ownedById;
    }

    public void setOwnedById(String ownedById) {
        this.ownedById = ownedById;
    }

    public String getManagedById() {
        return managedById;
    }

    public void setManagedById(String managedById) {
        this.managedById = managedById;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(String modifiedById) {
        this.modifiedById = modifiedById;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getLockedById() {
        return lockedById;
    }

    public void setLockedById(String lockedById) {
        this.lockedById = lockedById;
    }

    public Character getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Character isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getMinorRev() {
        return minorRev;
    }

    public void setMinorRev(String minorRev) {
        this.minorRev = minorRev;
    }

    public Character getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Character isReleased) {
        this.isReleased = isReleased;
    }

    public Character getNotLockable() {
        return notLockable;
    }

    public void setNotLockable(Character notLockable) {
        this.notLockable = notLockable;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public Character getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(Character newVersion) {
        this.newVersion = newVersion;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(String costBasis) {
        this.costBasis = costBasis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalOwner() {
        return externalOwner;
    }

    public void setExternalOwner(String externalOwner) {
        this.externalOwner = externalOwner;
    }

    public String getExternalType() {
        return externalType;
    }

    public void setExternalType(String externalType) {
        this.externalType = externalType;
    }

    public Character getHasChangePending() {
        return hasChangePending;
    }

    public void setHasChangePending(Character hasChangePending) {
        this.hasChangePending = hasChangePending;
    }

    public String getMakeBuy() {
        return makeBuy;
    }

    public void setMakeBuy(String makeBuy) {
        this.makeBuy = makeBuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightBasis() {
        return weightBasis;
    }

    public void setWeightBasis(String weightBasis) {
        this.weightBasis = weightBasis;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getMajorRev() {
        return majorRev;
    }

    public void setMajorRev(String majorRev) {
        this.majorRev = majorRev;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSupersededDate() {
        return supersededDate;
    }

    public void setSupersededDate(Date supersededDate) {
        this.supersededDate = supersededDate;
    }

    public String getBcsAutonumber() {
        return bcsAutonumber;
    }

    public void setBcsAutonumber(String bcsAutonumber) {
        this.bcsAutonumber = bcsAutonumber;
    }

    public Character getBcsIsSad() {
        return bcsIsSad;
    }

    public void setBcsIsSad(Character bcsIsSad) {
        this.bcsIsSad = bcsIsSad;
    }

    public Character getBcsIsrestricted() {
        return bcsIsrestricted;
    }

    public void setBcsIsrestricted(Character bcsIsrestricted) {
        this.bcsIsrestricted = bcsIsrestricted;
    }

    public String getCnUnit() {
        return cnUnit;
    }

    public void setCnUnit(String cnUnit) {
        this.cnUnit = cnUnit;
    }

    public String getCnUnitEn() {
        return cnUnitEn;
    }

    public void setCnUnitEn(String cnUnitEn) {
        this.cnUnitEn = cnUnitEn;
    }

    public String getCnNameEn() {
        return cnNameEn;
    }

    public void setCnNameEn(String cnNameEn) {
        this.cnNameEn = cnNameEn;
    }

    public String getCnSpecZt() {
        return cnSpecZt;
    }

    public void setCnSpecZt(String cnSpecZt) {
        this.cnSpecZt = cnSpecZt;
    }

    public String getCnSpecEn() {
        return cnSpecEn;
    }

    public void setCnSpecEn(String cnSpecEn) {
        this.cnSpecEn = cnSpecEn;
    }

    public String getCnNameCn() {
        return cnNameCn;
    }

    public void setCnNameCn(String cnNameCn) {
        this.cnNameCn = cnNameCn;
    }

    public String getCnSpecCn() {
        return cnSpecCn;
    }

    public void setCnSpecCn(String cnSpecCn) {
        this.cnSpecCn = cnSpecCn;
    }

    public Character getCnIsAllBom() {
        return cnIsAllBom;
    }

    public void setCnIsAllBom(Character cnIsAllBom) {
        this.cnIsAllBom = cnIsAllBom;
    }

    public Character getCnToErp() {
        return cnToErp;
    }

    public void setCnToErp(Character cnToErp) {
        this.cnToErp = cnToErp;
    }

    public Date getCnErpComfirmDate() {
        return cnErpComfirmDate;
    }

    public void setCnErpComfirmDate(Date cnErpComfirmDate) {
        this.cnErpComfirmDate = cnErpComfirmDate;
    }

    public String getCnGroupId() {
        return cnGroupId;
    }

    public void setCnGroupId(String cnGroupId) {
        this.cnGroupId = cnGroupId;
    }

    public String getCnProductClass() {
        return cnProductClass;
    }

    public void setCnProductClass(String cnProductClass) {
        this.cnProductClass = cnProductClass;
    }

    public String getCnProductSeries() {
        return cnProductSeries;
    }

    public void setCnProductSeries(String cnProductSeries) {
        this.cnProductSeries = cnProductSeries;
    }

    public String getCnClassification() {
        return cnClassification;
    }

    public void setCnClassification(String cnClassification) {
        this.cnClassification = cnClassification;
    }

    public String getCnProductType() {
        return cnProductType;
    }

    public void setCnProductType(String cnProductType) {
        this.cnProductType = cnProductType;
    }

    public String getCnPartType() {
        return cnPartType;
    }

    public void setCnPartType(String cnPartType) {
        this.cnPartType = cnPartType;
    }

    public String getCnCadcamno() {
        return cnCadcamno;
    }

    public void setCnCadcamno(String cnCadcamno) {
        this.cnCadcamno = cnCadcamno;
    }

    public String getItemNumber2() {
        return itemNumber2;
    }

    public void setItemNumber2(String itemNumber2) {
        this.itemNumber2 = itemNumber2;
    }

    public String getItemOldnumber() {
        return itemOldnumber;
    }

    public void setItemOldnumber(String itemOldnumber) {
        this.itemOldnumber = itemOldnumber;
    }

    public String getViewableFile() {
        return viewableFile;
    }

    public void setViewableFile(String viewableFile) {
        this.viewableFile = viewableFile;
    }

    public String getViewFile() {
        return viewFile;
    }

    public void setViewFile(String viewFile) {
        this.viewFile = viewFile;
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
        if (!(object instanceof Part)) {
            return false;
        }
        Part other = (Part) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.Part[ id=" + id + " ]";
    }
    
}
