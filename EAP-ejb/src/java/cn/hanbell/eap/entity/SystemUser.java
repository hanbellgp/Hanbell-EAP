/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "systemuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemUser.getRowCount", query = "SELECT COUNT(s) FROM SystemUser s"),
    @NamedQuery(name = "SystemUser.findAll", query = "SELECT s FROM SystemUser s ORDER BY s.userid"),
    @NamedQuery(name = "SystemUser.findById", query = "SELECT s FROM SystemUser s WHERE s.id = :id"),
    @NamedQuery(name = "SystemUser.findByDeptno", query = "SELECT s FROM SystemUser s WHERE s.deptno = :deptno ORDER BY s.userid"),
    @NamedQuery(name = "SystemUser.findByDeptnoAndOnJob", query = "SELECT s FROM SystemUser s WHERE s.status<>'X' AND s.deptno = :deptno ORDER BY s.userid"),
    @NamedQuery(name = "SystemUser.findByDeptnoAndSyncWeChatStatus", query = "SELECT s FROM SystemUser s WHERE (s.syncWeChatStatus IS NULL OR s.syncWeChatStatus<>'X') AND s.deptno = :deptno ORDER BY s.userid"),
    @NamedQuery(name = "SystemUser.findByManagerIdAndOnJob", query = "SELECT s FROM SystemUser s WHERE s.status<>'X' AND s.managerId = :managerId ORDER BY s.userid"),
    @NamedQuery(name = "SystemUser.findByUserId", query = "SELECT s FROM SystemUser s WHERE s.userid = :userid"),
    @NamedQuery(name = "SystemUser.findByUsername", query = "SELECT s FROM SystemUser s WHERE s.username = :username"),
    @NamedQuery(name = "SystemUser.findByUserIdAndPwd", query = "SELECT s FROM SystemUser s WHERE (s.userid = :userid OR s.email =:email) AND s.password = :pwd"),
    @NamedQuery(name = "SystemUser.findByUserIdOrName", query = "SELECT s FROM SystemUser s WHERE (s.userid LIKE :userid OR s.username LIKE :username) ORDER BY s.userid"),
    @NamedQuery(name = "SystemUser.findByLocked", query = "SELECT s FROM SystemUser s WHERE s.locked = :locked"),
    @NamedQuery(name = "SystemUser.findByStatus", query = "SELECT s FROM SystemUser s WHERE s.status = :status"),
    @NamedQuery(name = "SystemUser.findByLikeDeptno", query = "SELECT s FROM SystemUser s WHERE s.deptno LIKE :deptno ORDER BY s.userid")})
public class SystemUser extends SuperEntity {

    @JoinColumn(name = "deptno", referencedColumnName = "deptno", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Department dept;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userid")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "jobCode")
    private String jobCode;
    @Size(max = 45)
    @Column(name = "job")
    private String job;
    @Size(max = 10)
    @Column(name = "positionCode")
    private String positionCode;
    @Size(max = 45)
    @Column(name = "position")
    private String position;
    @Size(max = 20)
    @Column(name = "levelId")
    private String levelId;
    @Size(max = 45)
    @Column(name = "decisionLevel")
    private String decisionLevel;
    @Size(max = 20)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 20)
    @Column(name = "managerId")
    private String managerId;
    @Size(max = 45)
    @Column(name = "domainuser")
    private String domainuser;
    @Size(max = 100)
    @Column(name = "domainname")
    private String domainname;
    @Column(name = "superuser")
    private Boolean superuser;
    @Column(name = "failure")
    private Integer failure;
    @Column(name = "locked")
    private Boolean locked;
    @Column(name = "lastlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    @Column(name = "newestlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newestlogin;
    @Size(max = 2)
    @Column(name = "syncWeChatStatus")
    private String syncWeChatStatus;
    @Column(name = "syncWeChatDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncWeChatDate;
    @Column(name = "workingAgeBeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workingAgeBeginDate;
    @Column(name = "birthdayDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdayDate;

    public SystemUser() {
        this.password = "e10adc3949ba59abbe56e057f20f883e";//123456
        this.superuser = false;
        this.failure = 0;
        this.locked = false;
        this.status = "N";
        this.syncWeChatStatus = "N";
    }

    /**
     * @return the dept
     */
    public Department getDept() {
        return dept;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the jobCode
     */
    public String getJobCode() {
        return jobCode;
    }

    /**
     * @param jobCode the jobCode to set
     */
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the positionCode
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * @param positionCode the positionCode to set
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getDecisionLevel() {
        return decisionLevel;
    }

    public void setDecisionLevel(String decisionLevel) {
        this.decisionLevel = decisionLevel;
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
     * @return the managerId
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDomainuser() {
        return domainuser;
    }

    public void setDomainuser(String domainuser) {
        this.domainuser = domainuser;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
    }

    public Integer getFailure() {
        return failure;
    }

    public void setFailure(Integer failure) {
        this.failure = failure;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getNewestlogin() {
        return newestlogin;
    }

    public void setNewestlogin(Date newestlogin) {
        this.newestlogin = newestlogin;
    }

    /**
     * @return the syncWeChatStatus
     */
    public String getSyncWeChatStatus() {
        return syncWeChatStatus;
    }

    /**
     * @param syncWeChatStatus the syncWeChatStatus to set
     */
    public void setSyncWeChatStatus(String syncWeChatStatus) {
        this.syncWeChatStatus = syncWeChatStatus;
    }

    /**
     * @return the syncWeChatDate
     */
    public Date getSyncWeChatDate() {
        return syncWeChatDate;
    }

    /**
     * @param syncWeChatDate the syncWeChatDate to set
     */
    public void setSyncWeChatDate(Date syncWeChatDate) {
        this.syncWeChatDate = syncWeChatDate;
    }

    public Date getWorkingAgeBeginDate() {
        return workingAgeBeginDate;
    }

    public void setWorkingAgeBeginDate(Date workingAgeBeginDate) {
        this.workingAgeBeginDate = workingAgeBeginDate;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
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
        if (!(object instanceof SystemUser)) {
            return false;
        }
        SystemUser other = (SystemUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SystemUser[ id=" + id + " ]";
    }

}
