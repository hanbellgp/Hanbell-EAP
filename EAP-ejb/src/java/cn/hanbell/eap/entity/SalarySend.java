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
@Table(name = "salarysend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalarySend.findAll", query = "SELECT s FROM SalarySend s"),
    @NamedQuery(name = "SalarySend.findByTaskidAndDeptno", query = "SELECT s FROM SalarySend s WHERE s.taskid like :taskid AND s.deptno = :deptno"),
    @NamedQuery(name = "SalarySend.findByTaskidAndEmployeeid", query = "SELECT s FROM SalarySend s WHERE s.taskid =:taskid AND s.employeeid=:employeeid"),
    @NamedQuery(name = "SalarySend.findById", query = "SELECT s FROM SalarySend s WHERE s.id = :id"), 
    @NamedQuery(name = "SalarySend.findByTaskid", query = "SELECT s FROM SalarySend s WHERE s.taskid = :taskid"),
    @NamedQuery(name = "SalarySend.findByTaskname", query = "SELECT s FROM SalarySend s WHERE s.taskname = :taskname"),
    @NamedQuery(name = "SalarySend.findBySendtime", query = "SELECT s FROM SalarySend s WHERE s.sendtime = :sendtime"),
    @NamedQuery(name = "SalarySend.findByEmployeeid", query = "SELECT s FROM SalarySend s WHERE s.employeeid = :employeeid"),
    @NamedQuery(name = "SalarySend.findByEmployeename", query = "SELECT s FROM SalarySend s WHERE s.employeename = :employeename"),
    @NamedQuery(name = "SalarySend.findByDeptno", query = "SELECT s FROM SalarySend s WHERE s.deptno = :deptno"),
    @NamedQuery(name = "SalarySend.findByDept", query = "SELECT s FROM SalarySend s WHERE s.dept = :dept"),
    @NamedQuery(name = "SalarySend.findByStatus", query = "SELECT s FROM SalarySend s WHERE s.status = :status"),
    @NamedQuery(name = "SalarySend.findByConfirmtime", query = "SELECT s FROM SalarySend s WHERE s.confirmtime = :confirmtime"),
    @NamedQuery(name = "SalarySend.findByCfmdate", query = "SELECT s FROM SalarySend s WHERE s.cfmdate = :cfmdate"),
    @NamedQuery(name = "SalarySend.findByOptuser", query = "SELECT s FROM SalarySend s WHERE s.optuser = :optuser"),
    @NamedQuery(name = "SalarySend.findByOptdate", query = "SELECT s FROM SalarySend s WHERE s.optdate = :optdate"),
    @NamedQuery(name = "SalarySend.findByCfmuser", query = "SELECT s FROM SalarySend s WHERE s.cfmuser = :cfmuser"),
    @NamedQuery(name = "SalarySend.findByCredate", query = "SELECT s FROM SalarySend s WHERE s.credate = :credate"),
    @NamedQuery(name = "SalarySend.findByCreator", query = "SELECT s FROM SalarySend s WHERE s.creator = :creator")})
public class SalarySend extends SuperEntity {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "taskid")
    private String taskid;
    @Size(max = 20)
    @Column(name = "taskname")
    private String taskname;
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

    public SalarySend() {
    }

    public SalarySend(Integer id) {
        this.id = id;
    }

    public SalarySend(Integer id, String taskid, String employeeid) {
        this.id = id;
        this.taskid = taskid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof SalarySend)) {
            return false;
        }
        SalarySend other = (SalarySend) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Salarysend[ id=" + id + " ]";
    }
    
}
