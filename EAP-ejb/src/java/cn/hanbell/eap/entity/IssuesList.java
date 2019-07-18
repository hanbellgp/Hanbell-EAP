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
@Table(name = "issueslist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IssuesList.findAll", query = "SELECT i FROM IssuesList i"),
    @NamedQuery(name = "IssuesList.findById", query = "SELECT i FROM IssuesList i WHERE i.id = :id"),
    @NamedQuery(name = "IssuesList.findByAnnual", query = "SELECT i FROM IssuesList i WHERE i.annual = :annual"),
    @NamedQuery(name = "IssuesList.findByName", query = "SELECT i FROM IssuesList i WHERE i.name = :name"),
    @NamedQuery(name = "IssuesList.findByDescription", query = "SELECT i FROM IssuesList i WHERE i.description = :description"),
    @NamedQuery(name = "IssuesList.findByDept", query = "SELECT i FROM IssuesList i WHERE i.dept = :dept"),
    @NamedQuery(name = "IssuesList.findByPerson", query = "SELECT i FROM IssuesList i WHERE i.person = :person"),
    @NamedQuery(name = "IssuesList.findByPlantime", query = "SELECT i FROM IssuesList i WHERE i.plantime = :plantime"),
    @NamedQuery(name = "IssuesList.findByPhase", query = "SELECT i FROM IssuesList i WHERE i.phase = :phase"),
    @NamedQuery(name = "IssuesList.findByHead", query = "SELECT i FROM IssuesList i WHERE i.head = :head"),
    @NamedQuery(name = "IssuesList.findByJindu", query = "SELECT i FROM IssuesList i WHERE i.jindu = :jindu"),
    @NamedQuery(name = "IssuesList.findByEndtime", query = "SELECT i FROM IssuesList i WHERE i.endtime = :endtime"),
    @NamedQuery(name = "IssuesList.findByRemark1", query = "SELECT i FROM IssuesList i WHERE i.remark1 = :remark1"),
    @NamedQuery(name = "IssuesList.findByRemark2", query = "SELECT i FROM IssuesList i WHERE i.remark2 = :remark2"),
    @NamedQuery(name = "IssuesList.findByAnswer", query = "SELECT i FROM IssuesList i WHERE i.answer = :answer"),
    @NamedQuery(name = "IssuesList.findByAnswerstate", query = "SELECT i FROM IssuesList i WHERE i.answerstate = :answerstate"),
    @NamedQuery(name = "IssuesList.findByFile", query = "SELECT i FROM IssuesList i WHERE i.file = :file"),
    @NamedQuery(name = "IssuesList.findByStatus", query = "SELECT i FROM IssuesList i WHERE i.status = :status"),
    @NamedQuery(name = "IssuesList.findByCreator", query = "SELECT i FROM IssuesList i WHERE i.creator = :creator"),
    @NamedQuery(name = "IssuesList.findByCredate", query = "SELECT i FROM IssuesList i WHERE i.credate = :credate"),
    @NamedQuery(name = "IssuesList.findByOptuser", query = "SELECT i FROM IssuesList i WHERE i.optuser = :optuser"),
    @NamedQuery(name = "IssuesList.findByOptdate", query = "SELECT i FROM IssuesList i WHERE i.optdate = :optdate"),
    @NamedQuery(name = "IssuesList.findByCfmuser", query = "SELECT i FROM IssuesList i WHERE i.cfmuser = :cfmuser"),
    @NamedQuery(name = "IssuesList.findByCfmdate", query = "SELECT i FROM IssuesList i WHERE i.cfmdate = :cfmdate")})
public class IssuesList extends SuperEntity {

    @Size(max = 45)
    @Column(name = "annual")
    private String annual;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "dept")
    private String dept;
    @Size(max = 45)
    @Column(name = "person")
    private String person;
    @Column(name = "plantime")
    @Temporal(TemporalType.DATE)
    private Date plantime;
    @Size(max = 45)
    @Column(name = "phase")
    private String phase;
    @Size(max = 45)
    @Column(name = "head")
    private String head;
    @Size(max = 45)
    @Column(name = "jindu")
    private String jindu;
    @Column(name = "endtime")
    @Temporal(TemporalType.DATE)
    private Date endtime;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    @Size(max = 20)
    @Column(name = "creator")
    private String creator;
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Size(max = 20)
    @Column(name = "optuser")
    private String optuser;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;
    @Size(max = 20)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;

    public IssuesList() {
    }

    public IssuesList(Integer id) {
        this.id = id;
    }

    public IssuesList(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getPlantime() {
        return plantime;
    }

    public void setPlantime(Date plantime) {
        this.plantime = plantime;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getJindu() {
        return jindu;
    }

    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
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
