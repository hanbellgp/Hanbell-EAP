/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1879
 */
@Entity
@Table(name = "emailrecipient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailRecipient.findAll", query = "SELECT e FROM EmailRecipient e"),
    @NamedQuery(name = "EmailRecipient.findById", query = "SELECT e FROM EmailRecipient e WHERE e.id = :id"),
    @NamedQuery(name = "EmailRecipient.findByCode", query = "SELECT e FROM EmailRecipient e WHERE e.code = :code"),
    @NamedQuery(name = "EmailRecipient.findByEmailtype", query = "SELECT e FROM EmailRecipient e WHERE e.emailtype = :emailtype"),
    @NamedQuery(name = "EmailRecipient.findEmailnameByCodeAndEmailtype", query = "SELECT e FROM EmailRecipient e WHERE e.code = :code AND e.emailtype = :emailtype ")
})
public class EmailRecipient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emailtype")
    private String emailtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emailname")
    private String emailname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailaddress")
    private String emailaddress;
    @Size(max = 45)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 45)
    @Column(name = "remark2")
    private String remark2;
    @Size(max = 45)
    @Column(name = "remark3")
    private String remark3;

    public EmailRecipient() {
    }

    public EmailRecipient(Integer id) {
        this.id = id;
    }

    public EmailRecipient(Integer id, String code, String emailtype, String emailname, String emailaddress) {
        this.id = id;
        this.code = code;
        this.emailtype = emailtype;
        this.emailname = emailname;
        this.emailaddress = emailaddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmailtype() {
        return emailtype;
    }

    public void setEmailtype(String emailtype) {
        this.emailtype = emailtype;
    }

    public String getEmailname() {
        return emailname;
    }

    public void setEmailname(String emailname) {
        this.emailname = emailname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
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

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
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
        if (!(object instanceof EmailRecipient)) {
            return false;
        }
        EmailRecipient other = (EmailRecipient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.EmailRecipient[ id=" + id + " ]";
    }

}
