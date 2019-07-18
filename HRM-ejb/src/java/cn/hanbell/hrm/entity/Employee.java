/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByCreateDate", query = "SELECT e FROM Employee e WHERE CAST(e.createDate AS DATE)= :createDate"),
    @NamedQuery(name = "Employee.findByLastModifiedDate", query = "SELECT e FROM Employee e WHERE CAST(e.lastModifiedDate AS DATE) = :lastModifiedDate"),
    @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Employee.findByNumber", query = "SELECT e FROM Employee e WHERE e.number = :number"),
    @NamedQuery(name = "Employee.findByCnName", query = "SELECT e FROM Employee e WHERE e.cnName = :cnName"),
    @NamedQuery(name = "Employee.findByEnName", query = "SELECT e FROM Employee e WHERE e.enName = :enName"),
    @NamedQuery(name = "Employee.findByIDCardNo", query = "SELECT e FROM Employee e WHERE e.iDCardNo = :iDCardNo"),
    @NamedQuery(name = "Employee.findByCorporationId", query = "SELECT e FROM Employee e WHERE e.corporationId = :corporationId"),
    @NamedQuery(name = "Employee.findByAreaId", query = "SELECT e FROM Employee e WHERE e.areaId = :areaId"),
    @NamedQuery(name = "Employee.findByFactoryId", query = "SELECT e FROM Employee e WHERE e.factoryId = :factoryId"),
    @NamedQuery(name = "Employee.findByDepartmentId", query = "SELECT e FROM Employee e WHERE e.departmentId = :departmentId"),
    @NamedQuery(name = "Employee.findByJobId", query = "SELECT e FROM Employee e WHERE e.jobId = :jobId"),
    @NamedQuery(name = "Employee.findByPartTimeJob", query = "SELECT e FROM Employee e WHERE e.partTimeJob = :partTimeJob"),
    @NamedQuery(name = "Employee.findByDirectorId", query = "SELECT e FROM Employee e WHERE e.directorId = :directorId"),
    @NamedQuery(name = "Employee.findByMobilePhone", query = "SELECT e FROM Employee e WHERE e.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByEducationId", query = "SELECT e FROM Employee e WHERE e.educationId = :educationId"),
    @NamedQuery(name = "Employee.findByMajor", query = "SELECT e FROM Employee e WHERE e.major = :major"),
    @NamedQuery(name = "Employee.findByNativePlace", query = "SELECT e FROM Employee e WHERE e.nativePlace = :nativePlace"),
    @NamedQuery(name = "Employee.findByPoliticalIdentityId", query = "SELECT e FROM Employee e WHERE e.politicalIdentityId = :politicalIdentityId"),
    @NamedQuery(name = "Employee.findByLocation", query = "SELECT e FROM Employee e WHERE e.location = :location"),
    @NamedQuery(name = "Employee.findByPostalcode", query = "SELECT e FROM Employee e WHERE e.postalcode = :postalcode"),
    @NamedQuery(name = "Employee.findByNationId", query = "SELECT e FROM Employee e WHERE e.nationId = :nationId"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByCostCenterId", query = "SELECT e FROM Employee e WHERE e.costCenterId = :costCenterId"),
    @NamedQuery(name = "Employee.findByInterest", query = "SELECT e FROM Employee e WHERE e.interest = :interest"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByCode", query = "SELECT e FROM Employee e WHERE e.code = :code"),
    @NamedQuery(name = "Employee.findByITCode", query = "SELECT e FROM Employee e WHERE e.iTCode = :iTCode"),
    @NamedQuery(name = "Employee.findByAssignReason", query = "SELECT e FROM Employee e WHERE e.assignReason = :assignReason"),
    @NamedQuery(name = "Employee.findByOwnerId", query = "SELECT e FROM Employee e WHERE e.ownerId = :ownerId")})
public class Employee implements Serializable {

    @JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    private static final long serialVersionUID = 1L;
    @Size(max = 200)
    @Column(name = "IsTowner")
    private String isTowner;
    @Size(max = 200)
    @Column(name = "Source")
    private String source;
    @Column(name = "FundBeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fundBeginDate;
    @Column(name = "FundEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fundEndDate;
    @Size(max = 200)
    @Column(name = "IsFundId")
    private String isFundId;
    @Size(max = 200)
    @Column(name = "IsAuthorized")
    private String isAuthorized;
    @Size(max = 200)
    @Column(name = "IsReserveId")
    private String isReserveId;
    @Size(max = 200)
    @Column(name = "InnerEmployee")
    private String innerEmployee;
    @Column(name = "CertificateLimit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date certificateLimit;
    @Size(max = 200)
    @Column(name = "IsThisYearId")
    private String isThisYearId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BonusRate")
    private BigDecimal bonusRate;
    @Size(max = 200)
    @Column(name = "CCBCode")
    private String cCBCode;
    @Column(name = "JobDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jobDate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "EmployeeId")
    private String employeeId;
    @Column(name = "Number")
    private Integer number;
    @Size(max = 200)
    @Column(name = "CnName")
    private String cnName;
    @Size(max = 200)
    @Column(name = "EnName")
    private String enName;
    @Size(max = 200)
    @Column(name = "IDCardNo")
    private String iDCardNo;
    @Size(max = 200)
    @Column(name = "IDCardKindId")
    private String iDCardKindId;
    @Size(max = 200)
    @Column(name = "SocialWelfareNo")
    private String socialWelfareNo;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Size(max = 200)
    @Column(name = "GenderId")
    private String genderId;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 200)
    @Column(name = "EmployeeStateId")
    private String employeeStateId;
    @Size(max = 200)
    @Column(name = "WorkTypeId")
    private String workTypeId;
    @Size(max = 200)
    @Column(name = "MarriageId")
    private String marriageId;
    @Size(max = 200)
    @Column(name = "ServiceYears")
    private String serviceYears;
    @Size(max = 36)
    @Column(name = "CorporationId")
    private String corporationId;
    @Size(max = 200)
    @Column(name = "Telephone")
    private String telephone;
    @Size(max = 36)
    @Column(name = "AreaId")
    private String areaId;
    @Size(max = 200)
    @Column(name = "FactoryId")
    private String factoryId;
    @Size(max = 36)
    @Column(name = "DepartmentId")
    private String departmentId;
    @Size(max = 36)
    @Column(name = "JobId")
    private String jobId;
    @Size(max = 200)
    @Column(name = "PartTimeJob")
    private String partTimeJob;
    @Size(max = 36)
    @Column(name = "DirectorId")
    private String directorId;
    @Size(max = 200)
    @Column(name = "MobilePhone")
    private String mobilePhone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "Email")
    private String email;
    @Size(max = 200)
    @Column(name = "EducationId")
    private String educationId;
    @Size(max = 200)
    @Column(name = "Major")
    private String major;
    @Size(max = 200)
    @Column(name = "NativePlace")
    private String nativePlace;
    @Size(max = 200)
    @Column(name = "PoliticalIdentityId")
    private String politicalIdentityId;
    @Size(max = 200)
    @Column(name = "Location")
    private String location;
    @Size(max = 200)
    @Column(name = "Postalcode")
    private String postalcode;
    @Size(max = 200)
    @Column(name = "NationId")
    private String nationId;
    @Size(max = 200)
    @Column(name = "Address")
    private String address;
    @Size(max = 36)
    @Column(name = "CostCenterId")
    private String costCenterId;
    @Size(max = 1073741823)
    @Column(name = "Interest")
    private String interest;
    @Lob
    @Column(name = "Picture")
    private byte[] picture;
    @Size(max = 200)
    @Column(name = "Password")
    private String password;
    @Size(max = 200)
    @Column(name = "Code")
    private String code;
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
    @Column(name = "Flag")
    private Boolean flag;
    @Column(name = "IsPrincipal")
    private Boolean isPrincipal;
    @Column(name = "IsSend")
    private Boolean isSend;
    @Size(max = 200)
    @Column(name = "ITCode")
    private String iTCode;
    @Size(max = 200)
    @Column(name = "AssignReason")
    private String assignReason;
    @Size(max = 200)
    @Column(name = "OwnerId")
    private String ownerId;
    @Column(name = "OtherBirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otherBirthDate;
    @Size(max = 1073741823)
    @Column(name = "Remark")
    private String remark;
    @Column(name = "IntendTransformDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intendTransformDate;
    @Size(max = 200)
    @Column(name = "ATMealFeeType")
    private String aTMealFeeType;
    @Column(name = "LastWorkDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastWorkDate;
    @Size(max = 36)
    @Column(name = "DirectDeptId")
    private String directDeptId;
    @Size(max = 200)
    @Column(name = "TimeType")
    private String timeType;
    @Size(max = 200)
    @Column(name = "HomePhone")
    private String homePhone;
    @Column(name = "TransformDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transformDate;
    @Column(name = "WorkBeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workBeginDate;
    @Size(max = 200)
    @Column(name = "HealthStatus")
    private String healthStatus;
    @Size(max = 200)
    @Column(name = "Stature")
    private String stature;
    @Size(max = 200)
    @Column(name = "Weight")
    private String weight;
    @Size(max = 200)
    @Column(name = "EyeSight")
    private String eyeSight;
    @Size(max = 200)
    @Column(name = "BloodType")
    private String bloodType;
    @Size(max = 1073741823)
    @Column(name = "Personality")
    private String personality;
    @Size(max = 1073741823)
    @Column(name = "DiseaseHistory")
    private String diseaseHistory;
    @Size(max = 200)
    @Column(name = "CountryId")
    private String countryId;
    @Size(max = 200)
    @Column(name = "ProvinceId")
    private String provinceId;
    @Column(name = "WorkingAgeBeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workingAgeBeginDate;
    @Size(max = 200)
    @Column(name = "TWTaxTypeId")
    private String tWTaxTypeId;
    @Column(name = "TWFixedValue")
    private BigDecimal tWFixedValue;
    @Column(name = "TWFixedTaxRate")
    private BigDecimal tWFixedTaxRate;
    @Column(name = "FamilyNumber")
    private Integer familyNumber;
    @Column(name = "AdmitWorkAge")
    private BigDecimal admitWorkAge;
    @Size(max = 200)
    @Column(name = "CharacterTest")
    private String characterTest;
    @Size(max = 36)
    @Column(name = "Deputy")
    private String deputy;
    @Size(max = 200)
    @Column(name = "EmployTypeId")
    private String employTypeId;
    @Size(max = 36)
    @Column(name = "PositionId")
    private String positionId;
    @Size(max = 200)
    @Column(name = "PositionGroupId")
    private String positionGroupId;
    @Column(name = "EnterDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enterDate;
    @Column(name = "ResidenceExpireDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date residenceExpireDate;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "WorkingAge")
    private Integer workingAge;
    @Column(name = "OtherCorpWorkingAge")
    private Integer otherCorpWorkingAge;
    @Size(max = 200)
    @Column(name = "HomeMail")
    private String homeMail;
    @Size(max = 1073741823)
    @Column(name = "Hobbies")
    private String hobbies;
    @Size(max = 200)
    @Column(name = "MultiSysCode")
    private String multiSysCode;
    @Size(max = 200)
    @Column(name = "ZhiJian")
    private String zhiJian;
    @Size(max = 200)
    @Column(name = "ExtraField1")
    private String extraField1;
    @Size(max = 200)
    @Column(name = "ExtraField2")
    private String extraField2;
    @Size(max = 200)
    @Column(name = "ExtraField3")
    private String extraField3;
    @Size(max = 200)
    @Column(name = "ExtraField4")
    private String extraField4;
    @Size(max = 200)
    @Column(name = "ExtraField5")
    private String extraField5;
    @Size(max = 200)
    @Column(name = "ExtraField6")
    private String extraField6;
    @Size(max = 200)
    @Column(name = "ExtraField7")
    private String extraField7;
    @Size(max = 200)
    @Column(name = "ExtraField8")
    private String extraField8;
    @Size(max = 200)
    @Column(name = "ExtraField9")
    private String extraField9;
    @Size(max = 200)
    @Column(name = "ExtraField10")
    private String extraField10;
    @Size(max = 200)
    @Column(name = "ExtraField11")
    private String extraField11;
    @Size(max = 200)
    @Column(name = "ESSUserAccount")
    private String eSSUserAccount;
    @Size(max = 200)
    @Column(name = "DomainServer")
    private String domainServer;
    @Size(max = 200)
    @Column(name = "LevelId")
    private String levelId;
    @Size(max = 200)
    @Column(name = "SecretId")
    private String secretId;
    @Size(max = 200)
    @Column(name = "CalendarId")
    private String calendarId;
    @Size(max = 200)
    @Column(name = "AttendanceWorkRankId")
    private String attendanceWorkRankId;
    @Size(max = 200)
    @Column(name = "AttendanceRestRankId")
    private String attendanceRestRankId;
    @Size(max = 200)
    @Column(name = "LocationPostalCode")
    private String locationPostalCode;
    @Size(max = 200)
    @Column(name = "Grade")
    private String grade;
    @Size(max = 200)
    @Column(name = "Rank")
    private String rank;
    @Size(max = 200)
    @Column(name = "HoroscopeID")
    private String horoscopeID;
    @Size(max = 36)
    @Column(name = "PositionRankID")
    private String positionRankID;
    @Size(max = 200)
    @Column(name = "PositionRankName")
    private String positionRankName;
    @Column(name = "NewReportDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newReportDate;
    @Size(max = 36)
    @Column(name = "SalaryBankCardId")
    private String salaryBankCardId;
    @Column(name = "StatusCode")
    private Boolean statusCode;
    @Size(max = 200)
    @Column(name = "UniqueID")
    private String uniqueID;
    @Size(max = 200)
    @Column(name = "OtherCountTypeId")
    private String otherCountTypeId;
    @Size(max = 200)
    @Column(name = "DecisionLevel")
    private String decisionLevel;
    @Size(max = 200)
    @Column(name = "SalaryOverId")
    private String salaryOverId;
    @Column(name = "IsUploadPhoto")
    private Boolean isUploadPhoto;
    @Column(name = "IsUploadData")
    private Boolean isUploadData;
    @Column(name = "OutboundDay")
    private Integer outboundDay;
    @Size(max = 200)
    @Column(name = "WeixinId")
    private String weixinId;
    @Column(name = "IsEmpQRCode")
    private Boolean isEmpQRCode;
    @Column(name = "IsEmpSign")
    private Boolean isEmpSign;
    @Column(name = "IsEmpField")
    private Boolean isEmpField;
    @Size(max = 200)
    @Column(name = "AdminPost")
    private String adminPost;
    @Size(max = 200)
    @Column(name = "ProPost")
    private String proPost;
    @Size(max = 1073741823)
    @Column(name = "History")
    private String history;

    public Employee() {
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getIsTowner() {
        return isTowner;
    }

    public void setIsTowner(String isTowner) {
        this.isTowner = isTowner;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getFundBeginDate() {
        return fundBeginDate;
    }

    public void setFundBeginDate(Date fundBeginDate) {
        this.fundBeginDate = fundBeginDate;
    }

    public Date getFundEndDate() {
        return fundEndDate;
    }

    public void setFundEndDate(Date fundEndDate) {
        this.fundEndDate = fundEndDate;
    }

    public String getIsFundId() {
        return isFundId;
    }

    public void setIsFundId(String isFundId) {
        this.isFundId = isFundId;
    }

    public String getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(String isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public String getIsReserveId() {
        return isReserveId;
    }

    public void setIsReserveId(String isReserveId) {
        this.isReserveId = isReserveId;
    }

    public String getInnerEmployee() {
        return innerEmployee;
    }

    public void setInnerEmployee(String innerEmployee) {
        this.innerEmployee = innerEmployee;
    }

    public Date getCertificateLimit() {
        return certificateLimit;
    }

    public void setCertificateLimit(Date certificateLimit) {
        this.certificateLimit = certificateLimit;
    }

    public String getIsThisYearId() {
        return isThisYearId;
    }

    public void setIsThisYearId(String isThisYearId) {
        this.isThisYearId = isThisYearId;
    }

    public BigDecimal getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(BigDecimal bonusRate) {
        this.bonusRate = bonusRate;
    }

    public String getCCBCode() {
        return cCBCode;
    }

    public void setCCBCode(String cCBCode) {
        this.cCBCode = cCBCode;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getIDCardNo() {
        return iDCardNo;
    }

    public void setIDCardNo(String iDCardNo) {
        this.iDCardNo = iDCardNo;
    }

    public String getIDCardKindId() {
        return iDCardKindId;
    }

    public void setIDCardKindId(String iDCardKindId) {
        this.iDCardKindId = iDCardKindId;
    }

    public String getSocialWelfareNo() {
        return socialWelfareNo;
    }

    public void setSocialWelfareNo(String socialWelfareNo) {
        this.socialWelfareNo = socialWelfareNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmployeeStateId() {
        return employeeStateId;
    }

    public void setEmployeeStateId(String employeeStateId) {
        this.employeeStateId = employeeStateId;
    }

    public String getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(String workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(String marriageId) {
        this.marriageId = marriageId;
    }

    public String getServiceYears() {
        return serviceYears;
    }

    public void setServiceYears(String serviceYears) {
        this.serviceYears = serviceYears;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
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

    public String getPartTimeJob() {
        return partTimeJob;
    }

    public void setPartTimeJob(String partTimeJob) {
        this.partTimeJob = partTimeJob;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPoliticalIdentityId() {
        return politicalIdentityId;
    }

    public void setPoliticalIdentityId(String politicalIdentityId) {
        this.politicalIdentityId = politicalIdentityId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(String costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    public Boolean getIsSend() {
        return isSend;
    }

    public void setIsSend(Boolean isSend) {
        this.isSend = isSend;
    }

    public String getITCode() {
        return iTCode;
    }

    public void setITCode(String iTCode) {
        this.iTCode = iTCode;
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

    public Date getOtherBirthDate() {
        return otherBirthDate;
    }

    public void setOtherBirthDate(Date otherBirthDate) {
        this.otherBirthDate = otherBirthDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getIntendTransformDate() {
        return intendTransformDate;
    }

    public void setIntendTransformDate(Date intendTransformDate) {
        this.intendTransformDate = intendTransformDate;
    }

    public String getATMealFeeType() {
        return aTMealFeeType;
    }

    public void setATMealFeeType(String aTMealFeeType) {
        this.aTMealFeeType = aTMealFeeType;
    }

    public Date getLastWorkDate() {
        return lastWorkDate;
    }

    public void setLastWorkDate(Date lastWorkDate) {
        this.lastWorkDate = lastWorkDate;
    }

    public String getDirectDeptId() {
        return directDeptId;
    }

    public void setDirectDeptId(String directDeptId) {
        this.directDeptId = directDeptId;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Date getTransformDate() {
        return transformDate;
    }

    public void setTransformDate(Date transformDate) {
        this.transformDate = transformDate;
    }

    public Date getWorkBeginDate() {
        return workBeginDate;
    }

    public void setWorkBeginDate(Date workBeginDate) {
        this.workBeginDate = workBeginDate;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEyeSight() {
        return eyeSight;
    }

    public void setEyeSight(String eyeSight) {
        this.eyeSight = eyeSight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public Date getWorkingAgeBeginDate() {
        return workingAgeBeginDate;
    }

    public void setWorkingAgeBeginDate(Date workingAgeBeginDate) {
        this.workingAgeBeginDate = workingAgeBeginDate;
    }

    public String getTWTaxTypeId() {
        return tWTaxTypeId;
    }

    public void setTWTaxTypeId(String tWTaxTypeId) {
        this.tWTaxTypeId = tWTaxTypeId;
    }

    public BigDecimal getTWFixedValue() {
        return tWFixedValue;
    }

    public void setTWFixedValue(BigDecimal tWFixedValue) {
        this.tWFixedValue = tWFixedValue;
    }

    public BigDecimal getTWFixedTaxRate() {
        return tWFixedTaxRate;
    }

    public void setTWFixedTaxRate(BigDecimal tWFixedTaxRate) {
        this.tWFixedTaxRate = tWFixedTaxRate;
    }

    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber) {
        this.familyNumber = familyNumber;
    }

    public BigDecimal getAdmitWorkAge() {
        return admitWorkAge;
    }

    public void setAdmitWorkAge(BigDecimal admitWorkAge) {
        this.admitWorkAge = admitWorkAge;
    }

    public String getCharacterTest() {
        return characterTest;
    }

    public void setCharacterTest(String characterTest) {
        this.characterTest = characterTest;
    }

    public String getDeputy() {
        return deputy;
    }

    public void setDeputy(String deputy) {
        this.deputy = deputy;
    }

    public String getEmployTypeId() {
        return employTypeId;
    }

    public void setEmployTypeId(String employTypeId) {
        this.employTypeId = employTypeId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionGroupId() {
        return positionGroupId;
    }

    public void setPositionGroupId(String positionGroupId) {
        this.positionGroupId = positionGroupId;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getResidenceExpireDate() {
        return residenceExpireDate;
    }

    public void setResidenceExpireDate(Date residenceExpireDate) {
        this.residenceExpireDate = residenceExpireDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkingAge() {
        return workingAge;
    }

    public void setWorkingAge(Integer workingAge) {
        this.workingAge = workingAge;
    }

    public Integer getOtherCorpWorkingAge() {
        return otherCorpWorkingAge;
    }

    public void setOtherCorpWorkingAge(Integer otherCorpWorkingAge) {
        this.otherCorpWorkingAge = otherCorpWorkingAge;
    }

    public String getHomeMail() {
        return homeMail;
    }

    public void setHomeMail(String homeMail) {
        this.homeMail = homeMail;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getMultiSysCode() {
        return multiSysCode;
    }

    public void setMultiSysCode(String multiSysCode) {
        this.multiSysCode = multiSysCode;
    }

    public String getZhiJian() {
        return zhiJian;
    }

    public void setZhiJian(String zhiJian) {
        this.zhiJian = zhiJian;
    }

    public String getExtraField1() {
        return extraField1;
    }

    public void setExtraField1(String extraField1) {
        this.extraField1 = extraField1;
    }

    public String getExtraField2() {
        return extraField2;
    }

    public void setExtraField2(String extraField2) {
        this.extraField2 = extraField2;
    }

    public String getExtraField3() {
        return extraField3;
    }

    public void setExtraField3(String extraField3) {
        this.extraField3 = extraField3;
    }

    public String getExtraField4() {
        return extraField4;
    }

    public void setExtraField4(String extraField4) {
        this.extraField4 = extraField4;
    }

    public String getExtraField5() {
        return extraField5;
    }

    public void setExtraField5(String extraField5) {
        this.extraField5 = extraField5;
    }

    public String getExtraField6() {
        return extraField6;
    }

    public void setExtraField6(String extraField6) {
        this.extraField6 = extraField6;
    }

    public String getExtraField7() {
        return extraField7;
    }

    public void setExtraField7(String extraField7) {
        this.extraField7 = extraField7;
    }

    public String getExtraField8() {
        return extraField8;
    }

    public void setExtraField8(String extraField8) {
        this.extraField8 = extraField8;
    }

    public String getExtraField9() {
        return extraField9;
    }

    public void setExtraField9(String extraField9) {
        this.extraField9 = extraField9;
    }

    public String getExtraField10() {
        return extraField10;
    }

    public void setExtraField10(String extraField10) {
        this.extraField10 = extraField10;
    }

    public String getExtraField11() {
        return extraField11;
    }

    public void setExtraField11(String extraField11) {
        this.extraField11 = extraField11;
    }

    public String getESSUserAccount() {
        return eSSUserAccount;
    }

    public void setESSUserAccount(String eSSUserAccount) {
        this.eSSUserAccount = eSSUserAccount;
    }

    public String getDomainServer() {
        return domainServer;
    }

    public void setDomainServer(String domainServer) {
        this.domainServer = domainServer;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getAttendanceWorkRankId() {
        return attendanceWorkRankId;
    }

    public void setAttendanceWorkRankId(String attendanceWorkRankId) {
        this.attendanceWorkRankId = attendanceWorkRankId;
    }

    public String getAttendanceRestRankId() {
        return attendanceRestRankId;
    }

    public void setAttendanceRestRankId(String attendanceRestRankId) {
        this.attendanceRestRankId = attendanceRestRankId;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }

    public void setLocationPostalCode(String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getHoroscopeID() {
        return horoscopeID;
    }

    public void setHoroscopeID(String horoscopeID) {
        this.horoscopeID = horoscopeID;
    }

    public String getPositionRankID() {
        return positionRankID;
    }

    public void setPositionRankID(String positionRankID) {
        this.positionRankID = positionRankID;
    }

    public String getPositionRankName() {
        return positionRankName;
    }

    public void setPositionRankName(String positionRankName) {
        this.positionRankName = positionRankName;
    }

    public Date getNewReportDate() {
        return newReportDate;
    }

    public void setNewReportDate(Date newReportDate) {
        this.newReportDate = newReportDate;
    }

    public String getSalaryBankCardId() {
        return salaryBankCardId;
    }

    public void setSalaryBankCardId(String salaryBankCardId) {
        this.salaryBankCardId = salaryBankCardId;
    }

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getOtherCountTypeId() {
        return otherCountTypeId;
    }

    public void setOtherCountTypeId(String otherCountTypeId) {
        this.otherCountTypeId = otherCountTypeId;
    }

    public String getDecisionLevel() {
        return decisionLevel;
    }

    public void setDecisionLevel(String decisionLevel) {
        this.decisionLevel = decisionLevel;
    }

    public String getSalaryOverId() {
        return salaryOverId;
    }

    public void setSalaryOverId(String salaryOverId) {
        this.salaryOverId = salaryOverId;
    }

    public Boolean getIsUploadPhoto() {
        return isUploadPhoto;
    }

    public void setIsUploadPhoto(Boolean isUploadPhoto) {
        this.isUploadPhoto = isUploadPhoto;
    }

    public Boolean getIsUploadData() {
        return isUploadData;
    }

    public void setIsUploadData(Boolean isUploadData) {
        this.isUploadData = isUploadData;
    }

    public Integer getOutboundDay() {
        return outboundDay;
    }

    public void setOutboundDay(Integer outboundDay) {
        this.outboundDay = outboundDay;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public Boolean getIsEmpQRCode() {
        return isEmpQRCode;
    }

    public void setIsEmpQRCode(Boolean isEmpQRCode) {
        this.isEmpQRCode = isEmpQRCode;
    }

    public Boolean getIsEmpSign() {
        return isEmpSign;
    }

    public void setIsEmpSign(Boolean isEmpSign) {
        this.isEmpSign = isEmpSign;
    }

    public Boolean getIsEmpField() {
        return isEmpField;
    }

    public void setIsEmpField(Boolean isEmpField) {
        this.isEmpField = isEmpField;
    }

    public String getAdminPost() {
        return adminPost;
    }

    public void setAdminPost(String adminPost) {
        this.adminPost = adminPost;
    }

    public String getProPost() {
        return proPost;
    }

    public void setProPost(String proPost) {
        this.proPost = proPost;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.hr.entity.Employee[ employeeId=" + employeeId + " ]";
    }

}
