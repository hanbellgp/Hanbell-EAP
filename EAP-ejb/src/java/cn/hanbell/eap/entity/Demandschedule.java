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
 * @author Administrator
 */
@Entity
@Table(name = "demandschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandschedule.findAll", query = "SELECT d FROM Demandschedule d"),
    @NamedQuery(name = "Demandschedule.findById", query = "SELECT d FROM Demandschedule d WHERE d.id = :id"),
    @NamedQuery(name = "Demandschedule.findBySystemname", query = "SELECT d FROM Demandschedule d WHERE d.systemname = :systemname"),
    @NamedQuery(name = "Demandschedule.findByRequestdescript", query = "SELECT d FROM Demandschedule d WHERE d.requestdescript = :requestdescript"),
    @NamedQuery(name = "Demandschedule.findByBriefrequestscript", query = "SELECT d FROM Demandschedule d WHERE d.briefrequestscript = :briefrequestscript"),
    @NamedQuery(name = "Demandschedule.findByApplydept", query = "SELECT d FROM Demandschedule d WHERE d.applydept = :applydept"),
    @NamedQuery(name = "Demandschedule.findByApplyuser", query = "SELECT d FROM Demandschedule d WHERE d.applyuser = :applyuser"),
    @NamedQuery(name = "Demandschedule.findByApplytime", query = "SELECT d FROM Demandschedule d WHERE d.applytime = :applytime"),
    @NamedQuery(name = "Demandschedule.findByPlanfinishtime", query = "SELECT d FROM Demandschedule d WHERE d.planfinishtime = :planfinishtime"),
    @NamedQuery(name = "Demandschedule.findBySteptime", query = "SELECT d FROM Demandschedule d WHERE d.steptime = :steptime"),
    @NamedQuery(name = "Demandschedule.findByChargedept", query = "SELECT d FROM Demandschedule d WHERE d.chargedept = :chargedept"),
    @NamedQuery(name = "Demandschedule.findByFinishstatus", query = "SELECT d FROM Demandschedule d WHERE d.finishstatus = :finishstatus"),
    @NamedQuery(name = "Demandschedule.findByFinishtime", query = "SELECT d FROM Demandschedule d WHERE d.finishtime = :finishtime"),
    @NamedQuery(name = "Demandschedule.findByChargedeptremark", query = "SELECT d FROM Demandschedule d WHERE d.chargedeptremark = :chargedeptremark"),
    @NamedQuery(name = "Demandschedule.findByApplydeptremark", query = "SELECT d FROM Demandschedule d WHERE d.applydeptremark = :applydeptremark"),
    @NamedQuery(name = "Demandschedule.findByRequestremark", query = "SELECT d FROM Demandschedule d WHERE d.requestremark = :requestremark"),
    @NamedQuery(name = "Demandschedule.findByRequeststate", query = "SELECT d FROM Demandschedule d WHERE d.requeststate = :requeststate"),
    @NamedQuery(name = "Demandschedule.findByAttachment", query = "SELECT d FROM Demandschedule d WHERE d.attachment = :attachment")})
public class Demandschedule extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "systemname")
    private String systemname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "requestdescript")
    private String requestdescript;
    @Size(max = 100)
    @Column(name = "briefrequestscript")
    private String briefrequestscript;
    @Size(max = 45)
    @Column(name = "applydept")
    private String applydept;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "applyuser")
    private String applyuser;
    @Column(name = "applytime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applytime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planfinishtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planfinishtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "steptime")
    private String steptime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "chargedept")
    private String chargedept;
    @Size(max = 45)
    @Column(name = "finishstatus")
    private String finishstatus;
    @Column(name = "finishtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishtime;
    @Size(max = 400)
    @Column(name = "chargedeptremark")
    private String chargedeptremark;
    @Size(max = 400)
    @Column(name = "applydeptremark")
    private String applydeptremark;
    @Size(max = 400)
    @Column(name = "requestremark")
    private String requestremark;
    @Size(max = 45)
    @Column(name = "requeststate")
    private String requeststate;
    @Size(max = 45)
    @Column(name = "attachment")
    private String attachment;
  

    public Demandschedule() {
    }

    public Demandschedule(Integer id) {
        this.id = id;
    }

    public Demandschedule(Integer id, String systemname, String requestdescript, String applyuser, Date planfinishtime, String steptime, String chargedept, String status) {
        this.id = id;
        this.systemname = systemname;
        this.requestdescript = requestdescript;
        this.applyuser = applyuser;
        this.planfinishtime = planfinishtime;
        this.steptime = steptime;
        this.chargedept = chargedept;
        this.status = status;
    }


    public String getSystemname() {
        return systemname;
    }

    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }

    public String getRequestdescript() {
        return requestdescript;
    }

    public void setRequestdescript(String requestdescript) {
        this.requestdescript = requestdescript;
    }

    public String getBriefrequestscript() {
        return briefrequestscript;
    }

    public void setBriefrequestscript(String briefrequestscript) {
        this.briefrequestscript = briefrequestscript;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getPlanfinishtime() {
        return planfinishtime;
    }

    public void setPlanfinishtime(Date planfinishtime) {
        this.planfinishtime = planfinishtime;
    }

    public String getSteptime() {
        return steptime;
    }

    public void setSteptime(String steptime) {
        this.steptime = steptime;
    }

    public String getChargedept() {
        return chargedept;
    }

    public void setChargedept(String chargedept) {
        this.chargedept = chargedept;
    }

    public String getFinishstatus() {
        return finishstatus;
    }

    public void setFinishstatus(String finishstatus) {
        this.finishstatus = finishstatus;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public String getChargedeptremark() {
        return chargedeptremark;
    }

    public void setChargedeptremark(String chargedeptremark) {
        this.chargedeptremark = chargedeptremark;
    }

    public String getApplydeptremark() {
        return applydeptremark;
    }

    public void setApplydeptremark(String applydeptremark) {
        this.applydeptremark = applydeptremark;
    }

    public String getRequestremark() {
        return requestremark;
    }

    public void setRequestremark(String requestremark) {
        this.requestremark = requestremark;
    }

    public String getRequeststate() {
        return requeststate;
    }

    public void setRequeststate(String requeststate) {
        this.requeststate = requeststate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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
        if (!(object instanceof Demandschedule)) {
            return false;
        }
        Demandschedule other = (Demandschedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Demandschedule[ id=" + id + " ]";
    }
    
}
