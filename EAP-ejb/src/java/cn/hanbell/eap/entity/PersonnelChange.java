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
@Table(name = "personnelchange")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelChange.findAll", query = "SELECT p FROM PersonnelChange p"),
    @NamedQuery(name = "PersonnelChange.findByTaskid", query = "SELECT p FROM PersonnelChange p WHERE p.taskid = :taskid"),
    @NamedQuery(name = "PersonnelChange.findByTaskname", query = "SELECT p FROM PersonnelChange p WHERE p.taskname = :taskname"),
    @NamedQuery(name = "PersonnelChange.findByTaskidAndEmployeeid", query = "SELECT p FROM PersonnelChange p WHERE p.taskid = :taskid AND p.employeeid = :employeeid"),
    @NamedQuery(name = "PersonnelChange.findByContent", query = "SELECT p FROM PersonnelChange p WHERE p.content = :content"),
    @NamedQuery(name = "PersonnelChange.findBySendtime", query = "SELECT p FROM PersonnelChange p WHERE p.sendtime = :sendtime"),
    @NamedQuery(name = "PersonnelChange.findByEmployeeid", query = "SELECT p FROM PersonnelChange p WHERE p.employeeid = :employeeid"),
    @NamedQuery(name = "PersonnelChange.findByEmployeename", query = "SELECT p FROM PersonnelChange p WHERE p.employeename = :employeename"),
    @NamedQuery(name = "PersonnelChange.findByDeptno", query = "SELECT p FROM PersonnelChange p WHERE p.deptno = :deptno"),
    @NamedQuery(name = "PersonnelChange.findByDept", query = "SELECT p FROM PersonnelChange p WHERE p.dept = :dept"),
    @NamedQuery(name = "PersonnelChange.findByConfirmtime", query = "SELECT p FROM PersonnelChange p WHERE p.confirmtime = :confirmtime")  })
public class PersonnelChange extends SuperEntity {

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
    @Size(min = 1, max = 200)
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
   

    public PersonnelChange() {
    }



    public PersonnelChange(Integer id, String taskid, String content, String employeeid) {
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
}
