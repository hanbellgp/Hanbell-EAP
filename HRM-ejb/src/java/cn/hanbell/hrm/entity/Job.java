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
@Table(name = "Job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobId", query = "SELECT j FROM Job j WHERE j.jobId = :jobId"),
    @NamedQuery(name = "Job.findByPositionId", query = "SELECT j FROM Job j WHERE j.positionId = :positionId"),
    @NamedQuery(name = "Job.findByJobGradeId", query = "SELECT j FROM Job j WHERE j.jobGradeId = :jobGradeId"),
    @NamedQuery(name = "Job.findByDescribe", query = "SELECT j FROM Job j WHERE j.describe = :describe"),
    @NamedQuery(name = "Job.findByIsVice", query = "SELECT j FROM Job j WHERE j.isVice = :isVice"),
    @NamedQuery(name = "Job.findByCreateDate", query = "SELECT j FROM Job j WHERE j.createDate = :createDate"),
    @NamedQuery(name = "Job.findByEducationType", query = "SELECT j FROM Job j WHERE j.educationType = :educationType"),
    @NamedQuery(name = "Job.findByEducation", query = "SELECT j FROM Job j WHERE j.education = :education"),
    @NamedQuery(name = "Job.findByGenderType", query = "SELECT j FROM Job j WHERE j.genderType = :genderType"),
    @NamedQuery(name = "Job.findByGender", query = "SELECT j FROM Job j WHERE j.gender = :gender"),
    @NamedQuery(name = "Job.findByAgeType", query = "SELECT j FROM Job j WHERE j.ageType = :ageType"),
    @NamedQuery(name = "Job.findByAgeUp", query = "SELECT j FROM Job j WHERE j.ageUp = :ageUp"),
    @NamedQuery(name = "Job.findByAgeDown", query = "SELECT j FROM Job j WHERE j.ageDown = :ageDown"),
    @NamedQuery(name = "Job.findBySpecialtyId", query = "SELECT j FROM Job j WHERE j.specialtyId = :specialtyId"),
    @NamedQuery(name = "Job.findByExperience", query = "SELECT j FROM Job j WHERE j.experience = :experience"),
    @NamedQuery(name = "Job.findByTime", query = "SELECT j FROM Job j WHERE j.time = :time"),
    @NamedQuery(name = "Job.findByObject", query = "SELECT j FROM Job j WHERE j.object = :object"),
    @NamedQuery(name = "Job.findByDuty", query = "SELECT j FROM Job j WHERE j.duty = :duty"),
    @NamedQuery(name = "Job.findByRepealRemark", query = "SELECT j FROM Job j WHERE j.repealRemark = :repealRemark"),
    @NamedQuery(name = "Job.findByCreateBy", query = "SELECT j FROM Job j WHERE j.createBy = :createBy"),
    @NamedQuery(name = "Job.findByLastModifiedDate", query = "SELECT j FROM Job j WHERE j.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "Job.findByLastModifiedBy", query = "SELECT j FROM Job j WHERE j.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "Job.findByCode", query = "SELECT j FROM Job j WHERE j.code = :code"),
    @NamedQuery(name = "Job.findByFlag", query = "SELECT j FROM Job j WHERE j.flag = :flag"),
    @NamedQuery(name = "Job.findByName", query = "SELECT j FROM Job j WHERE j.name = :name"),
    @NamedQuery(name = "Job.findByAssignReason", query = "SELECT j FROM Job j WHERE j.assignReason = :assignReason"),
    @NamedQuery(name = "Job.findByOwnerId", query = "SELECT j FROM Job j WHERE j.ownerId = :ownerId"),
    @NamedQuery(name = "Job.findByCorporationId", query = "SELECT j FROM Job j WHERE j.corporationId = :corporationId"),
    @NamedQuery(name = "Job.findByBeginEndDateBeginDate", query = "SELECT j FROM Job j WHERE j.beginEndDateBeginDate = :beginEndDateBeginDate"),
    @NamedQuery(name = "Job.findByBeginEndDateEndDate", query = "SELECT j FROM Job j WHERE j.beginEndDateEndDate = :beginEndDateEndDate"),
    @NamedQuery(name = "Job.findByIsNullBeginEndDate", query = "SELECT j FROM Job j WHERE j.isNullBeginEndDate = :isNullBeginEndDate")})
public class Job implements Serializable {

    @JoinColumn(name = "PositionId", referencedColumnName = "PositionId", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Position position;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "JobId")
    private String jobId;
    @Size(max = 36)
    @Column(name = "PositionId")
    private String positionId;
    @Size(max = 200)
    @Column(name = "JobGradeId")
    private String jobGradeId;
    @Size(max = 1073741823)
    @Column(name = "Describe")
    private String describe;
    @Column(name = "IsVice")
    private Boolean isVice;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "EducationType")
    private Integer educationType;
    @Size(max = 200)
    @Column(name = "Education")
    private String education;
    @Column(name = "GenderType")
    private Integer genderType;
    @Size(max = 200)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "AgeType")
    private Integer ageType;
    @Column(name = "AgeUp")
    private Integer ageUp;
    @Column(name = "AgeDown")
    private Integer ageDown;
    @Size(max = 200)
    @Column(name = "SpecialtyId")
    private String specialtyId;
    @Size(max = 1073741823)
    @Column(name = "Experience")
    private String experience;
    @Size(max = 1073741823)
    @Column(name = "Time")
    private String time;
    @Size(max = 1073741823)
    @Column(name = "Object")
    private String object;
    @Size(max = 1073741823)
    @Column(name = "Duty")
    private String duty;
    @Size(max = 1073741823)
    @Column(name = "RepealRemark")
    private String repealRemark;
    @Size(max = 36)
    @Column(name = "CreateBy")
    private String createBy;
    @Column(name = "LastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 36)
    @Column(name = "LastModifiedBy")
    private String lastModifiedBy;
    @Size(max = 200)
    @Column(name = "Code")
    private String code;
    @Column(name = "Flag")
    private Boolean flag;
    @Size(max = 200)
    @Column(name = "Name")
    private String name;
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

    public Job() {
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getJobGradeId() {
        return jobGradeId;
    }

    public void setJobGradeId(String jobGradeId) {
        this.jobGradeId = jobGradeId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Boolean getIsVice() {
        return isVice;
    }

    public void setIsVice(Boolean isVice) {
        this.isVice = isVice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getEducationType() {
        return educationType;
    }

    public void setEducationType(Integer educationType) {
        this.educationType = educationType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getGenderType() {
        return genderType;
    }

    public void setGenderType(Integer genderType) {
        this.genderType = genderType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAgeType() {
        return ageType;
    }

    public void setAgeType(Integer ageType) {
        this.ageType = ageType;
    }

    public Integer getAgeUp() {
        return ageUp;
    }

    public void setAgeUp(Integer ageUp) {
        this.ageUp = ageUp;
    }

    public Integer getAgeDown() {
        return ageDown;
    }

    public void setAgeDown(Integer ageDown) {
        this.ageDown = ageDown;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getRepealRemark() {
        return repealRemark;
    }

    public void setRepealRemark(String repealRemark) {
        this.repealRemark = repealRemark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.hrm.entity.Job[ jobId=" + jobId + " ]";
    }

}
