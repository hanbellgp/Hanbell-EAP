/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
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
 * @author Administrator
 */
@Entity
@Table(name = "conferencebooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConferenceBooking.findAll", query = "SELECT c FROM ConferenceBooking c"),
    @NamedQuery(name = "ConferenceBooking.findById", query = "SELECT c FROM ConferenceBooking c WHERE c.id = :id"),
    @NamedQuery(name = "ConferenceBooking.findByStatus", query = "SELECT c FROM ConferenceBooking c WHERE c.status = :status"),
    @NamedQuery(name = "ConferenceBooking.findByCreator", query = "SELECT c FROM ConferenceBooking c WHERE c.creator = :creator")})
public class ConferenceBooking extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "confCode")
    private String confCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "confName")
    private String confName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confDate")
    @Temporal(TemporalType.DATE)
    private Date confDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sender")
    private String sender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "chairman")
    private String chairman;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "recipient")
    private String recipient;
    @Size(max = 4000)
    @Column(name = "CC")
    private String cc;
    @Size(max = 4000)
    @Column(name = "BCC")
    private String bcc;
    @Size(max = 30)
    @Column(name = "hasDrink")
    private String hasDrink;
    @Size(max = 2000)
    @Column(name = "hasWelcome")
    private String hasWelcome;
    @Size(max = 30)
    @Column(name = "hasVOIP")
    private String hasVOIP;
    @Size(max = 30)
    @Column(name = "hasZOOM")
    private String hasZOOM;
    @Size(max = 30)
    @Column(name = "hasWeChat")
    private String hasWeChat;
  
    public ConferenceBooking() {
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
        if (!(object instanceof ConferenceBooking)) {
            return false;
        }
        ConferenceBooking other = (ConferenceBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ConferenceBooking[ id=" + id + " ]";
    }

    public ConferenceBooking(Integer id) {
        this.id = id;
    }

    public ConferenceBooking(Integer id, String confCode, String confName, Date confDate, Date startTime, Date endTime, String sender, String chairman, String subject, String description, String recipient, String status) {
        this.id = id;
        this.confCode = confCode;
        this.confName = confName;
        this.confDate = confDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sender = sender;
        this.chairman = chairman;
        this.subject = subject;
        this.description = description;
        this.recipient = recipient;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfCode() {
        return confCode;
    }

    public void setConfCode(String confCode) {
        this.confCode = confCode;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public Date getConfDate() {
        return confDate;
    }

    public void setConfDate(Date confDate) {
        this.confDate = confDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getHasDrink() {
        return hasDrink;
    }

    public void setHasDrink(String hasDrink) {
        this.hasDrink = hasDrink;
    }

    public String getHasWelcome() {
        return hasWelcome;
    }

    public void setHasWelcome(String hasWelcome) {
        this.hasWelcome = hasWelcome;
    }

    public String getHasVOIP() {
        return hasVOIP;
    }

    public void setHasVOIP(String hasVOIP) {
        this.hasVOIP = hasVOIP;
    }

    public String getHasZOOM() {
        return hasZOOM;
    }

    public void setHasZOOM(String hasZOOM) {
        this.hasZOOM = hasZOOM;
    }

    public String getHasWeChat() {
        return hasWeChat;
    }

    public void setHasWeChat(String hasWeChat) {
        this.hasWeChat = hasWeChat;
    }

}
