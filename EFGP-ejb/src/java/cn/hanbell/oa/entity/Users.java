/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.getRowCount", query = "SELECT COUNT(u) FROM Users u"),
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByOID", query = "SELECT u FROM Users u WHERE u.oid = :oid"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByObjectVersion", query = "SELECT u FROM Users u WHERE u.objectVersion = :objectVersion"),
    @NamedQuery(name = "Users.findByReferCalendarOID", query = "SELECT u FROM Users u WHERE u.referCalendarOID = :referCalendarOID"),
    @NamedQuery(name = "Users.findByIdentificationType", query = "SELECT u FROM Users u WHERE u.identificationType = :identificationType"),
    @NamedQuery(name = "Users.findByMailAddress", query = "SELECT u FROM Users u WHERE u.mailAddress = :mailAddress"),
    @NamedQuery(name = "Users.findByLocaleString", query = "SELECT u FROM Users u WHERE u.localeString = :localeString"),
    @NamedQuery(name = "Users.findByPhoneNumber", query = "SELECT u FROM Users u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Users.findByWorkflowServerOID", query = "SELECT u FROM Users u WHERE u.workflowServerOID = :workflowServerOID")})
public class Users implements Serializable {

    @Transient
    private String company;
    @Transient
    private String companyname;
    @Transient
    private String deptno;
    @Transient
    private String deptname;
    @Transient
    private Title title;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Column(name = "leaveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveDate;
    @Size(max = 32)
    @Column(name = "referCalendarOID")
    private String referCalendarOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificationType")
    private String identificationType;
    @Size(max = 50)
    @Column(name = "mailAddress")
    private String mailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "localeString")
    private String localeString;
    @Size(max = 100)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Size(max = 32)
    @Column(name = "workflowServerOID")
    private String workflowServerOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enableSubstitute")
    private int enableSubstitute;
    @Column(name = "endSubstituteTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endSubstituteTime;
    @Column(name = "startSubstituteTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startSubstituteTime;
    @Column(name = "cost")
    private Integer cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mailingFrequencyType")
    private int mailingFrequencyType;
    @Size(max = 100)
    @Column(name = "ldapid")
    private String ldapid;
    @Column(name = "intermissionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intermissionDate;
    @Column(name = "lastUptPwdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUptPwdDate;

    public Users() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getReferCalendarOID() {
        return referCalendarOID;
    }

    public void setReferCalendarOID(String referCalendarOID) {
        this.referCalendarOID = referCalendarOID;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getLocaleString() {
        return localeString;
    }

    public void setLocaleString(String localeString) {
        this.localeString = localeString;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkflowServerOID() {
        return workflowServerOID;
    }

    public void setWorkflowServerOID(String workflowServerOID) {
        this.workflowServerOID = workflowServerOID;
    }

    public int getEnableSubstitute() {
        return enableSubstitute;
    }

    public void setEnableSubstitute(int enableSubstitute) {
        this.enableSubstitute = enableSubstitute;
    }

    public Date getEndSubstituteTime() {
        return endSubstituteTime;
    }

    public void setEndSubstituteTime(Date endSubstituteTime) {
        this.endSubstituteTime = endSubstituteTime;
    }

    public Date getStartSubstituteTime() {
        return startSubstituteTime;
    }

    public void setStartSubstituteTime(Date startSubstituteTime) {
        this.startSubstituteTime = startSubstituteTime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public int getMailingFrequencyType() {
        return mailingFrequencyType;
    }

    public void setMailingFrequencyType(int mailingFrequencyType) {
        this.mailingFrequencyType = mailingFrequencyType;
    }

    public String getLdapid() {
        return ldapid;
    }

    public void setLdapid(String ldapid) {
        this.ldapid = ldapid;
    }

    public Date getIntermissionDate() {
        return intermissionDate;
    }

    public void setIntermissionDate(Date intermissionDate) {
        this.intermissionDate = intermissionDate;
    }

    public Date getLastUptPwdDate() {
        return lastUptPwdDate;
    }

    public void setLastUptPwdDate(Date lastUptPwdDate) {
        this.lastUptPwdDate = lastUptPwdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.Users[ oid=" + oid + " ]";
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the deptno
     */
    public String getDeptno() {
        return deptno;
    }

    /**
     * @param deptno the deptno to set
     */
    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    /**
     * @return the deptname
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * @param deptname the deptname to set
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    /**
     * @return the title
     */
    public Title getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

}
