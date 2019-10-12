/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.io.Serializable;
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
 * @author C1749
 */
@Entity
@Table(name = "issues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Issues.findAll", query = "SELECT i FROM Issues i")
    , @NamedQuery(name = "Issues.findById", query = "SELECT i FROM Issues i WHERE i.id = :id")
    , @NamedQuery(name = "Issues.findByIssuenumber", query = "SELECT i FROM Issues i WHERE i.issuenumber = :issuenumber")
    , @NamedQuery(name = "Issues.findBySystemtype", query = "SELECT i FROM Issues i WHERE i.systemtype = :systemtype")
    , @NamedQuery(name = "Issues.findByModuletype", query = "SELECT i FROM Issues i WHERE i.moduletype = :moduletype")
    , @NamedQuery(name = "Issues.findByIssuesid", query = "SELECT i FROM Issues i WHERE i.issuesid = :issuesid")
    , @NamedQuery(name = "Issues.findByIssuesname", query = "SELECT i FROM Issues i WHERE i.issuesname = :issuesname")
    , @NamedQuery(name = "Issues.findByDeptno", query = "SELECT i FROM Issues i WHERE i.deptno = :deptno")
    , @NamedQuery(name = "Issues.findByDeptname", query = "SELECT i FROM Issues i WHERE i.deptname = :deptname")
    , @NamedQuery(name = "Issues.findByNeederid", query = "SELECT i FROM Issues i WHERE i.neederid = :neederid")
    , @NamedQuery(name = "Issues.findByNeedername", query = "SELECT i FROM Issues i WHERE i.needername = :needername")
    , @NamedQuery(name = "Issues.findByCreatetime", query = "SELECT i FROM Issues i WHERE i.createtime = :createtime")
    , @NamedQuery(name = "Issues.findByPlantime", query = "SELECT i FROM Issues i WHERE i.plantime = :plantime")
    , @NamedQuery(name = "Issues.findByEndtime", query = "SELECT i FROM Issues i WHERE i.endtime = :endtime")
    , @NamedQuery(name = "Issues.findByPrincipalid", query = "SELECT i FROM Issues i WHERE i.principalid = :principalid")
    , @NamedQuery(name = "Issues.findByPrincipalname", query = "SELECT i FROM Issues i WHERE i.principalname = :principalname")
    , @NamedQuery(name = "Issues.findBySchedule", query = "SELECT i FROM Issues i WHERE i.schedule = :schedule")
    , @NamedQuery(name = "Issues.findByUsetime", query = "SELECT i FROM Issues i WHERE i.usetime = :usetime")
    , @NamedQuery(name = "Issues.findByPostpone", query = "SELECT i FROM Issues i WHERE i.postpone = :postpone")
    , @NamedQuery(name = "Issues.findByPostponecause", query = "SELECT i FROM Issues i WHERE i.postponecause = :postponecause")
    , @NamedQuery(name = "Issues.findByAnswer", query = "SELECT i FROM Issues i WHERE i.answer = :answer")
    , @NamedQuery(name = "Issues.findByAnswerstate", query = "SELECT i FROM Issues i WHERE i.answerstate = :answerstate")
    , @NamedQuery(name = "Issues.findByFile", query = "SELECT i FROM Issues i WHERE i.file = :file")})
public class Issues extends SuperEntity {

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "issuenumber")
    private String issuenumber;
    @Size(max = 45)
    @Column(name = "systemtype")
    private String systemtype;
    @Size(max = 45)
    @Column(name = "moduletype")
    private String moduletype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "issuesid")
    private String issuesid;
    @Size(max = 400)
    @Column(name = "issuesname")
    private String issuesname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 45)
    @Column(name = "deptname")
    private String deptname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "neederid")
    private String neederid;
    @Size(max = 45)
    @Column(name = "needername")
    private String needername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createtime")
    @Temporal(TemporalType.DATE)
    private Date createtime;
    @Column(name = "plantime")
    @Temporal(TemporalType.DATE)
    private Date plantime;
    @Column(name = "endtime")
    @Temporal(TemporalType.DATE)
    private Date endtime;
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

    public Issues() {
    }

    public Issues(Integer id) {
        this.id = id;
    }

    public Issues(Integer id, String issuenumber, String issuesid, String deptno, String neederid, Date createtime) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.issuesid = issuesid;
        this.deptno = deptno;
        this.neederid = neederid;
        this.createtime = createtime;
    }

    public String getIssuenumber() {
        return issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber;
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

    public String getIssuesid() {
        return issuesid;
    }

    public void setIssuesid(String issuesid) {
        this.issuesid = issuesid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPlantime() {
        return plantime;
    }

    public void setPlantime(Date plantime) {
        this.plantime = plantime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Issues)) {
            return false;
        }
        Issues other = (Issues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Issues[ id=" + id + " ]";
    }
    
}
