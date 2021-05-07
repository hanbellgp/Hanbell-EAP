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
@Table(name = "rewardspunishment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsPunishment.findAll", query = "SELECT r FROM RewardsPunishment r"),
    @NamedQuery(name = "RewardsPunishment.findById", query = "SELECT r FROM RewardsPunishment r WHERE r.id = :id"),
    @NamedQuery(name = "RewardsPunishment.findByTaskid", query = "SELECT r FROM RewardsPunishment r WHERE r.taskid = :taskid"),
    @NamedQuery(name = "RewardsPunishment.findByTaskname", query = "SELECT r FROM RewardsPunishment r WHERE r.taskname = :taskname"),
    @NamedQuery(name = "RewardsPunishment.findByContent", query = "SELECT r FROM RewardsPunishment r WHERE r.content = :content"),
    @NamedQuery(name = "RewardsPunishment.findBySendtime", query = "SELECT r FROM RewardsPunishment r WHERE r.sendtime = :sendtime"),
    @NamedQuery(name = "RewardsPunishment.findByEmployeeid", query = "SELECT r FROM RewardsPunishment r WHERE r.employeeid = :employeeid"),
    @NamedQuery(name = "RewardsPunishment.findByEmployeename", query = "SELECT r FROM RewardsPunishment r WHERE r.employeename = :employeename"),
    @NamedQuery(name = "RewardsPunishment.findByDeptno", query = "SELECT r FROM RewardsPunishment r WHERE r.deptno = :deptno"),
    @NamedQuery(name = "RewardsPunishment.findByDept", query = "SELECT r FROM RewardsPunishment r WHERE r.dept = :dept"),
     @NamedQuery(name = "RewardsPunishment.findByStatus", query = "SELECT r FROM RewardsPunishment r WHERE r.status = :status"),
    @NamedQuery(name = "RewardsPunishment.findByConfirmtime", query = "SELECT r FROM RewardsPunishment r WHERE r.confirmtime = :confirmtime"),
    @NamedQuery(name = "RewardsPunishment.findByCfmdate", query = "SELECT r FROM RewardsPunishment r WHERE r.cfmdate = :cfmdate"),
    @NamedQuery(name = "RewardsPunishment.findByOptuser", query = "SELECT r FROM RewardsPunishment r WHERE r.optuser = :optuser"),
    @NamedQuery(name = "RewardsPunishment.findByOptdate", query = "SELECT r FROM RewardsPunishment r WHERE r.optdate = :optdate"),
    @NamedQuery(name = "RewardsPunishment.findByCfmuser", query = "SELECT r FROM RewardsPunishment r WHERE r.cfmuser = :cfmuser"),
    @NamedQuery(name = "RewardsPunishment.findByCredate", query = "SELECT r FROM RewardsPunishment r WHERE r.credate = :credate"),
    @NamedQuery(name = "RewardsPunishment.findByCreator", query = "SELECT r FROM RewardsPunishment r WHERE r.creator = :creator"),
@NamedQuery(name = "RewardsPunishment.findByTaskidAndEmployeeid", query = "SELECT r FROM RewardsPunishment r WHERE r.taskid = :taskid and r.employeeid = :employeeid")})
public class RewardsPunishment extends SuperEntity {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "taskid")
    private String taskid;
    @Size(max = 20)
    @Column(name = "taskname")
    private String taskname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "content")
    private String content;
    @Column(name = "sendtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "employeeid")
    private String employeeid;
    @Size(max = 8)
    @Column(name = "employeename")
    private String employeename;
    @Size(max = 10)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 20)
    @Column(name = "dept")
    private String dept;
    @Column(name = "confirmtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmtime;

    public RewardsPunishment() {
    }

    public RewardsPunishment(Integer id) {
        this.id = id;
    }

    public RewardsPunishment(Integer id, String taskid, String content, String employeeid) {
        this.id = id;
        this.taskid = taskid;
        this.content = content;
        this.employeeid = employeeid;
    }


    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

  
    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }


    public Date getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
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
        if (!(object instanceof RewardsPunishment)) {
            return false;
        }
        RewardsPunishment other = (RewardsPunishment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Rewardspunishment[ id=" + id + " ]";
    }

}
