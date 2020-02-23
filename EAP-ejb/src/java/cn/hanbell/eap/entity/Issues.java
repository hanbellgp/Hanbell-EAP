/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author C2082
 */
@Entity
@Table(name = "issues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Issues.findAll", query = "SELECT i FROM Issues i"),
    @NamedQuery(name = "Issues.findBySystemtype", query = "SELECT i FROM Issues i WHERE i.systemtype = :systemtype"),
    @NamedQuery(name = "Issues.findByModuletype", query = "SELECT i FROM Issues i WHERE i.moduletype = :moduletype"),
    @NamedQuery(name = "Issues.findByIssuesContent", query = "SELECT i FROM Issues i WHERE i.issuesContent = :issuesContent"),
    @NamedQuery(name = "Issues.findByIssuesname", query = "SELECT i FROM Issues i WHERE i.issuesname = :issuesname"),
    @NamedQuery(name = "Issues.findByDeptno", query = "SELECT i FROM Issues i WHERE i.deptno = :deptno"),
    @NamedQuery(name = "Issues.findByDeptname", query = "SELECT i FROM Issues i WHERE i.deptname = :deptname"),
    @NamedQuery(name = "Issues.findByNeederid", query = "SELECT i FROM Issues i WHERE i.neederid = :neederid"),
    @NamedQuery(name = "Issues.findByNeedername", query = "SELECT i FROM Issues i WHERE i.needername = :needername"),
    @NamedQuery(name = "Issues.findByStarttime", query = "SELECT i FROM Issues i WHERE i.starttime = :starttime"),
    @NamedQuery(name = "Issues.findByOvertime", query = "SELECT i FROM Issues i WHERE i.overtime = :overtime"),
    @NamedQuery(name = "Issues.findByPrincipalid", query = "SELECT i FROM Issues i WHERE i.principalid = :principalid"),
    @NamedQuery(name = "Issues.findByPrincipalname", query = "SELECT i FROM Issues i WHERE i.principalname = :principalname"),
    @NamedQuery(name = "Issues.findBySchedule", query = "SELECT i FROM Issues i WHERE i.schedule = :schedule"),
    @NamedQuery(name = "Issues.findByUsetime", query = "SELECT i FROM Issues i WHERE i.usetime = :usetime"),
    @NamedQuery(name = "Issues.findByPostpone", query = "SELECT i FROM Issues i WHERE i.postpone = :postpone"),
    @NamedQuery(name = "Issues.findByPostponecause", query = "SELECT i FROM Issues i WHERE i.postponecause = :postponecause"),
    @NamedQuery(name = "Issues.findByAnswer", query = "SELECT i FROM Issues i WHERE i.answer = :answer"),
    @NamedQuery(name = "Issues.findByAnswerstate", query = "SELECT i FROM Issues i WHERE i.answerstate = :answerstate"),
    @NamedQuery(name = "Issues.findByFile", query = "SELECT i FROM Issues i WHERE i.file = :file"),
    @NamedQuery(name = "Issues.findByIssuestype", query = "SELECT i FROM Issues i WHERE i.issuestype = :issuestype")})
public class Issues extends FormEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "systemtype")
    private String systemtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "moduletype")
    private String moduletype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "issuesContent")
    private String issuesContent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "issuesname")
    private String issuesname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "deptno")
    private String deptno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "deptname")
    private String deptname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "neederid")
    private String neederid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "needername")
    private String needername;
    @Column(name = "starttime")
    @Temporal(TemporalType.DATE)
    private Date starttime;
    @Column(name = "overtime")
    @Temporal(TemporalType.DATE)
    private Date overtime;
    @Size(max = 45)
    @Column(name = "principalid")
    private String principalid;
    @Size(max = 45)
    @Column(name = "principalname")
    private String principalname;
    @Size(max = 45)
    @Column(name = "schedule")
    private String schedule;
    @Size(max = 45)
    @Column(name = "usetime")
    private String usetime;
    @Column(name = "postpone")
    private Character postpone;
    @Size(max = 400)
    @Column(name = "postponecause")
    private String postponecause;
    @Size(max = 45)
    @Column(name = "answer")
    private String answer;
    @Size(max = 45)
    @Column(name = "answerstate")
    private String answerstate;
    @Size(max = 45)
    @Column(name = "file")
    private String file;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "issuestype")
    private String issuestype;

    public Issues(String systemtype, String moduletype, String issuesContent, String issuesname, String deptno, String deptname, String neederid, String needername, Date starttime, Date overtime, String principalid, String principalname, String schedule, String usetime, Character postpone, String postponecause, String answer, String answerstate, String file, String issuestype) {
        this.systemtype = systemtype;
        this.moduletype = moduletype;
        this.issuesContent = issuesContent;
        this.issuesname = issuesname;
        this.deptno = deptno;
        this.deptname = deptname;
        this.neederid = neederid;
        this.needername = needername;
        this.starttime = starttime;
        this.overtime = overtime;
        this.principalid = principalid;
        this.principalname = principalname;
        this.schedule = schedule;
        this.usetime = usetime;
        this.postpone = postpone;
        this.postponecause = postponecause;
        this.answer = answer;
        this.answerstate = answerstate;
        this.file = file;
        this.issuestype = issuestype;
    }

    public Issues() {
    }

    public String getSystemtype() {
        return systemtype;
    }

    public void setSystemtype(String systemtype) {
        this.systemtype = systemtype;
    }

    public String getModuletype() {
        return moduletype;
    }

    public void setModuletype(String moduletype) {
        this.moduletype = moduletype;
    }

    public String getIssuesContent() {
        return issuesContent;
    }

    public void setIssuesContent(String issuesContent) {
        this.issuesContent = issuesContent;
    }

    public String getIssuesname() {
        return issuesname;
    }

    public void setIssuesname(String issuesname) {
        this.issuesname = issuesname;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getNeederid() {
        return neederid;
    }

    public void setNeederid(String neederid) {
        this.neederid = neederid;
    }

    public String getNeedername() {
        return needername;
    }

    public void setNeedername(String needername) {
        this.needername = needername;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public String getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(String principalid) {
        this.principalid = principalid;
    }

    public String getPrincipalname() {
        return principalname;
    }

    public void setPrincipalname(String principalname) {
        this.principalname = principalname;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public Character getPostpone() {
        return postpone;
    }

    public void setPostpone(Character postpone) {
        this.postpone = postpone;
    }

    public String getPostponecause() {
        return postponecause;
    }

    public void setPostponecause(String postponecause) {
        this.postponecause = postponecause;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerstate() {
        return answerstate;
    }

    public void setAnswerstate(String answerstate) {
        this.answerstate = answerstate;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getIssuestype() {
        return issuestype;
    }

    public void setIssuestype(String issuestype) {
        this.issuestype = issuestype;
    }

}
