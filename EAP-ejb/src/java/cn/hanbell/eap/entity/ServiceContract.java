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
@Table(name = "servicecontract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceContract.findAll", query = "SELECT p FROM ServiceContract p"),
    @NamedQuery(name = "ServiceContract.findByFormid", query = "SELECT p FROM ServiceContract p WHERE p.formid = :formid"),
    @NamedQuery(name = "ServiceContract.findByFormname", query = "SELECT p FROM ServiceContract p WHERE p.formname = :formname"),
    @NamedQuery(name = "ServiceContract.findByFormidAndEmployeeid", query = "SELECT p FROM ServiceContract p WHERE p.formid = :formid AND p.employeeid = :employeeid"),
    @NamedQuery(name = "ServiceContract.findByContent", query = "SELECT p FROM ServiceContract p WHERE p.content = :content"),
    @NamedQuery(name = "ServiceContract.findBySendtime", query = "SELECT p FROM ServiceContract p WHERE p.sendtime = :sendtime"),
    @NamedQuery(name = "ServiceContract.findByEmployeeid", query = "SELECT p FROM ServiceContract p WHERE p.employeeid = :employeeid"),
    @NamedQuery(name = "ServiceContract.findByEmployeename", query = "SELECT p FROM ServiceContract p WHERE p.employeename = :employeename"),
    @NamedQuery(name = "ServiceContract.findByConfirmtime", query = "SELECT p FROM ServiceContract p WHERE p.confirmtime = :confirmtime")})
public class ServiceContract extends SuperEntity {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "formid")
    private String formid;
    @Size(max = 20)
    @Column(name = "formname")
    private String formname;
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
    @Column(name = "confirmtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmtime;
   

    public ServiceContract() {
    }



    public ServiceContract(Integer id, String formid, String content, String employeeid) {
        this.id = id;
        this.formid = formid;
        this.content = content;
        this.employeeid = employeeid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
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

    public Date getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }
}
