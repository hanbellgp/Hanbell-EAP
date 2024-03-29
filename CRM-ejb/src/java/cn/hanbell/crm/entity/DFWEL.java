/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "DFWEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DFWEL.findAll", query = "SELECT d FROM DFWEL d"),
    @NamedQuery(name = "DFWEL.findByCompany", query = "SELECT d FROM DFWEL d WHERE d.company = :company"),
    @NamedQuery(name = "DFWEL.findByCreator", query = "SELECT d FROM DFWEL d WHERE d.creator = :creator"),
    @NamedQuery(name = "DFWEL.findByUsrGroup", query = "SELECT d FROM DFWEL d WHERE d.usrGroup = :usrGroup"),
    @NamedQuery(name = "DFWEL.findByCreateDate", query = "SELECT d FROM DFWEL d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DFWEL.findByModifier", query = "SELECT d FROM DFWEL d WHERE d.modifier = :modifier"),
    @NamedQuery(name = "DFWEL.findByModiDate", query = "SELECT d FROM DFWEL d WHERE d.modiDate = :modiDate"),
    @NamedQuery(name = "DFWEL.findByFlag", query = "SELECT d FROM DFWEL d WHERE d.flag = :flag"),
    @NamedQuery(name = "DFWEL.findByEl001", query = "SELECT d FROM DFWEL d WHERE d.el001 = :el001"),
    @NamedQuery(name = "DFWEL.findByEl002", query = "SELECT d FROM DFWEL d WHERE d.el002 = :el002"),
    @NamedQuery(name = "DFWEL.findByEl003", query = "SELECT d FROM DFWEL d WHERE d.el003 = :el003"),
    @NamedQuery(name = "DFWEL.findByEl004", query = "SELECT d FROM DFWEL d WHERE d.el004 = :el004")
})

public class DFWEL implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 10)
    @Column(name = "CREATOR")
    private String creator;
    @Size(max = 10)
    @Column(name = "USR_GROUP")
    private String usrGroup;
    @Size(max = 8)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 10)
    @Column(name = "MODIFIER")
    private String modifier;
    @Size(max = 8)
    @Column(name = "MODI_DATE")
    private String modiDate;
    @Column(name = "FLAG")
    private Short flag;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EL001")
    private String el001;
    @Size(max = 50)
    @Column(name = "EL002")
    private String el002;
    @Size(max = 255)
    @Column(name = "EL003")
    private String el003;
    @Size(max = 1)
    @Column(name = "EL004")
    private String el004;

    public DFWEL() {
    }

    public DFWEL(String el001) {
        this.el001 = el001;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUsrGroup() {
        return usrGroup;
    }

    public void setUsrGroup(String usrGroup) {
        this.usrGroup = usrGroup;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getEl001() {
        return el001;
    }

    public void setEl001(String el001) {
        this.el001 = el001;
    }

    public String getEl002() {
        return el002;
    }

    public void setEl002(String el002) {
        this.el002 = el002;
    }

    public String getEl003() {
        return el003;
    }

    public void setEl003(String el003) {
        this.el003 = el003;
    }

    public String getEl004() {
        return el004;
    }

    public void setEl004(String el004) {
        this.el004 = el004;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (el001 != null ? el001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DFWEL)) {
            return false;
        }
        DFWEL other = (DFWEL) object;
        if ((this.el001 == null && other.el001 != null) || (this.el001 != null && !this.el001.equals(other.el001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DFWEL[ el001=" + el001 + " ]";
    }
    
}
