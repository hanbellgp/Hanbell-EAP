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
@Table(name = "DCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DCS.findAll", query = "SELECT d FROM DCS d")
    , @NamedQuery(name = "DCS.findByCompany", query = "SELECT d FROM DCS d WHERE d.company = :company")
    , @NamedQuery(name = "DCS.findByCreator", query = "SELECT d FROM DCS d WHERE d.creator = :creator")
    , @NamedQuery(name = "DCS.findByUsrGroup", query = "SELECT d FROM DCS d WHERE d.usrGroup = :usrGroup")
    , @NamedQuery(name = "DCS.findByCreateDate", query = "SELECT d FROM DCS d WHERE d.createDate = :createDate")
    , @NamedQuery(name = "DCS.findByModifier", query = "SELECT d FROM DCS d WHERE d.modifier = :modifier")
    , @NamedQuery(name = "DCS.findByModiDate", query = "SELECT d FROM DCS d WHERE d.modiDate = :modiDate")
    , @NamedQuery(name = "DCS.findByFlag", query = "SELECT d FROM DCS d WHERE d.flag = :flag")
    , @NamedQuery(name = "DCS.findByCityid", query = "SELECT d FROM DCS d WHERE d.cityid = :cityid")
    , @NamedQuery(name = "DCS.findByCityname", query = "SELECT d FROM DCS d WHERE d.cityname = :cityname")
    , @NamedQuery(name = "DCS.findByProvinceid", query = "SELECT d FROM DCS d WHERE d.provinceid = :provinceid")})
public class DCS implements Serializable {

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
    @Column(name = "cityid")
    private String cityid;
    @Size(max = 50)
    @Column(name = "cityname")
    private String cityname;
    @Size(max = 50)
    @Column(name = "provinceid")
    private String provinceid;

    public DCS() {
    }

    public DCS(String cityid) {
        this.cityid = cityid;
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

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityid != null ? cityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DCS)) {
            return false;
        }
        DCS other = (DCS) object;
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DCS[ cityid=" + cityid + " ]";
    }
    
}
