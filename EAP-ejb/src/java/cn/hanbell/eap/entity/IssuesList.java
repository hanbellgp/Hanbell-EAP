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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1749
 */
@Entity
@Table(name = "issueslist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IssuesList.findAll", query = "SELECT i FROM IssuesList i")
    , @NamedQuery(name = "IssuesList.findById", query = "SELECT i FROM IssuesList i WHERE i.id = :id")
    , @NamedQuery(name = "IssuesList.findByIssuesid", query = "SELECT i FROM IssuesList i WHERE i.issuesid = :issuesid")
    , @NamedQuery(name = "IssuesList.findByIssuesname", query = "SELECT i FROM IssuesList i WHERE i.issuesname = :issuesname")
    , @NamedQuery(name = "IssuesList.findByDeptno", query = "SELECT i FROM IssuesList i WHERE i.deptno = :deptno")
    , @NamedQuery(name = "IssuesList.findByDeptname", query = "SELECT i FROM IssuesList i WHERE i.deptname = :deptname")
    , @NamedQuery(name = "IssuesList.findByNeederid", query = "SELECT i FROM IssuesList i WHERE i.neederid = :neederid")
    , @NamedQuery(name = "IssuesList.findByNeedername", query = "SELECT i FROM IssuesList i WHERE i.needername = :needername")
    , @NamedQuery(name = "IssuesList.findByCreatetime", query = "SELECT i FROM IssuesList i WHERE i.createtime = :createtime")
    , @NamedQuery(name = "IssuesList.findByPlantime", query = "SELECT i FROM IssuesList i WHERE i.plantime = :plantime")
    , @NamedQuery(name = "IssuesList.findByEndtime", query = "SELECT i FROM IssuesList i WHERE i.endtime = :endtime")
    , @NamedQuery(name = "IssuesList.findByPhase", query = "SELECT i FROM IssuesList i WHERE i.phase = :phase")
    , @NamedQuery(name = "IssuesList.findByPrincipalid", query = "SELECT i FROM IssuesList i WHERE i.principalid = :principalid")
    , @NamedQuery(name = "IssuesList.findByPrincipalname", query = "SELECT i FROM IssuesList i WHERE i.principalname = :principalname")
    , @NamedQuery(name = "IssuesList.findBySchedule", query = "SELECT i FROM IssuesList i WHERE i.schedule = :schedule")
    , @NamedQuery(name = "IssuesList.findByRemark1", query = "SELECT i FROM IssuesList i WHERE i.remark1 = :remark1")
    , @NamedQuery(name = "IssuesList.findByRemark2", query = "SELECT i FROM IssuesList i WHERE i.remark2 = :remark2")
    , @NamedQuery(name = "IssuesList.findByAnswer", query = "SELECT i FROM IssuesList i WHERE i.answer = :answer")
    , @NamedQuery(name = "IssuesList.findByAnswerstate", query = "SELECT i FROM IssuesList i WHERE i.answerstate = :answerstate")
    , @NamedQuery(name = "IssuesList.findByFile", query = "SELECT i FROM IssuesList i WHERE i.file = :file")
    , @NamedQuery(name = "IssuesList.findByStatus", query = "SELECT i FROM IssuesList i WHERE i.status = :status")
    , @NamedQuery(name = "IssuesList.findByCreator", query = "SELECT i FROM IssuesList i WHERE i.creator = :creator")
    , @NamedQuery(name = "IssuesList.findByCredate", query = "SELECT i FROM IssuesList i WHERE i.credate = :credate")
    , @NamedQuery(name = "IssuesList.findByOptuser", query = "SELECT i FROM IssuesList i WHERE i.optuser = :optuser")
    , @NamedQuery(name = "IssuesList.findByOptdate", query = "SELECT i FROM IssuesList i WHERE i.optdate = :optdate")
    , @NamedQuery(name = "IssuesList.findByCfmuser", query = "SELECT i FROM IssuesList i WHERE i.cfmuser = :cfmuser")
    , @NamedQuery(name = "IssuesList.findByCfmdate", query = "SELECT i FROM IssuesList i WHERE i.cfmdate = :cfmdate")})
public class IssuesList extends SuperEntity {

    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "issuesid")
    private String issuesid;
    @Size(max = 400)
    @Column(name = "issuesname")
    private String issuesname;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 45)
    @Column(name = "deptname")
    private String deptname;
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "neederid")
    private String neederid;
    @Size(max = 45)
    @Column(name = "needername")
    private String needername;
    @Basic(optional = false)
    @Column(name = "createtime")
    @Temporal(TemporalType.DATE)
    private Date createtime;
    @Column(name = "plantime")
    @Temporal(TemporalType.DATE)
    private Date plantime;
    @Column(name = "endtime")
    @Temporal(TemporalType.DATE)
    private Date endtime;
    @Size(max = 400)
    @Column(name = "phase")
    private String phase;
    @Size(max = 45)
    @Column(name = "principalid")
    private String principalid;
    @Size(max = 45)
    @Column(name = "principalname")
    private String principalname;
    @Size(max = 200)
    @Column(name = "schedule")
    private String schedule;
    @Size(max = 45)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 45)
    @Column(name = "remark2")
    private String remark2;
    @Size(max = 45)
    @Column(name = "answer")
    private String answer;
    @Size(max = 45)
    @Column(name = "answerstate")
    private String answerstate;
    @Size(max = 45)
    @Column(name = "file")
    private String file;
    
    public IssuesList() {
    }


    public IssuesList(String issuesid, String deptno, String neederid, Date createtime) {
        this.issuesid = issuesid;
        this.deptno = deptno;
        this.neederid = neederid;
        this.createtime = createtime;
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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
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

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
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
        if (!(object instanceof IssuesList)) {
            return false;
        }
        IssuesList other = (IssuesList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.IssuesList[ id=" + id + " ]";
    }

}
