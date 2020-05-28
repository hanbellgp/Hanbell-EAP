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
 * @author C2082
 */
@Entity
@Table(name = "DJX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DJX.findAll", query = "SELECT d FROM DJX d"),
    @NamedQuery(name = "DJX.findByCompany", query = "SELECT d FROM DJX d WHERE d.company = :company"),
    @NamedQuery(name = "DJX.findByCreator", query = "SELECT d FROM DJX d WHERE d.creator = :creator"),
    @NamedQuery(name = "DJX.findByUsrGroup", query = "SELECT d FROM DJX d WHERE d.usrGroup = :usrGroup"),
    @NamedQuery(name = "DJX.findByCreateDate", query = "SELECT d FROM DJX d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DJX.findByModifier", query = "SELECT d FROM DJX d WHERE d.modifier = :modifier"),
    @NamedQuery(name = "DJX.findByModiDate", query = "SELECT d FROM DJX d WHERE d.modiDate = :modiDate"),
    @NamedQuery(name = "DJX.findByFlag", query = "SELECT d FROM DJX d WHERE d.flag = :flag"),
    @NamedQuery(name = "DJX.findByJx001", query = "SELECT d FROM DJX d WHERE d.jx001 = :jx001"),
    @NamedQuery(name = "DJX.findByJx002", query = "SELECT d FROM DJX d WHERE d.jx002 = :jx002"),
    @NamedQuery(name = "DJX.findByJx003", query = "SELECT d FROM DJX d WHERE d.jx003 = :jx003"),
    @NamedQuery(name = "DJX.findByJx004", query = "SELECT d FROM DJX d WHERE d.jx004 = :jx004")})
public class DJX implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "JX001")
    private String jx001;
    @Size(max = 100)
    @Column(name = "JX002")
    private String jx002;
    @Size(max = 50)
    @Column(name = "JX003")
    private String jx003;
    @Size(max = 50)
    @Column(name = "JX004")
    private String jx004;

    public DJX() {
    }

    public DJX(String jx001) {
        this.jx001 = jx001;
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

    public String getJx001() {
        return jx001;
    }

    public void setJx001(String jx001) {
        this.jx001 = jx001;
    }

    public String getJx002() {
        return jx002;
    }

    public void setJx002(String jx002) {
        this.jx002 = jx002;
    }

    public String getJx003() {
        return jx003;
    }

    public void setJx003(String jx003) {
        this.jx003 = jx003;
    }

    public String getJx004() {
        return jx004;
    }

    public void setJx004(String jx004) {
        this.jx004 = jx004;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jx001 != null ? jx001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DJX)) {
            return false;
        }
        DJX other = (DJX) object;
        if ((this.jx001 == null && other.jx001 != null) || (this.jx001 != null && !this.jx001.equals(other.jx001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DJX[ jx001=" + jx001 + " ]";
    }
    
}
