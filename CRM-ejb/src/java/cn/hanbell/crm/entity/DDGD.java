/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "DDGD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DDGD.findAll", query = "SELECT d FROM DDGD d")
    , @NamedQuery(name = "DDGD.findByCompany", query = "SELECT d FROM DDGD d WHERE d.company = :company")
    , @NamedQuery(name = "DDGD.findByCreator", query = "SELECT d FROM DDGD d WHERE d.creator = :creator")
    , @NamedQuery(name = "DDGD.findByUsrGroup", query = "SELECT d FROM DDGD d WHERE d.usrGroup = :usrGroup")
    , @NamedQuery(name = "DDGD.findByCreateDate", query = "SELECT d FROM DDGD d WHERE d.createDate = :createDate")
    , @NamedQuery(name = "DDGD.findByModifier", query = "SELECT d FROM DDGD d WHERE d.modifier = :modifier")
    , @NamedQuery(name = "DDGD.findByModiDate", query = "SELECT d FROM DDGD d WHERE d.modiDate = :modiDate")
    , @NamedQuery(name = "DDGD.findByFlag", query = "SELECT d FROM DDGD d WHERE d.flag = :flag")
    , @NamedQuery(name = "DDGD.findByGd001", query = "SELECT d FROM DDGD d WHERE d.dDGDPK.gd001 = :gd001")
    , @NamedQuery(name = "DDGD.findByGd002", query = "SELECT d FROM DDGD d WHERE d.dDGDPK.gd002 = :gd002")
    , @NamedQuery(name = "DDGD.findByGd003", query = "SELECT d FROM DDGD d WHERE d.gd003 = :gd003")
    , @NamedQuery(name = "DDGD.findByGd004", query = "SELECT d FROM DDGD d WHERE d.gd004 = :gd004")
    , @NamedQuery(name = "DDGD.findByGd005", query = "SELECT d FROM DDGD d WHERE d.gd005 = :gd005")
    , @NamedQuery(name = "DDGD.findByGd006", query = "SELECT d FROM DDGD d WHERE d.gd006 = :gd006")
    , @NamedQuery(name = "DDGD.findByGd007", query = "SELECT d FROM DDGD d WHERE d.gd007 = :gd007")
    , @NamedQuery(name = "DDGD.findByGd008", query = "SELECT d FROM DDGD d WHERE d.gd008 = :gd008")
    , @NamedQuery(name = "DDGD.findByGd009", query = "SELECT d FROM DDGD d WHERE d.gd009 = :gd009")})
public class DDGD implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DDGDPK dDGDPK;
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
    @Size(max = 500)
    @Column(name = "GD003")
    private String gd003;
    @Size(max = 500)
    @Column(name = "GD004")
    private String gd004;
    @Size(max = 120)
    @Column(name = "GD005")
    private String gd005;
    @Size(max = 500)
    @Column(name = "GD006")
    private String gd006;
    @Size(max = 500)
    @Column(name = "GD007")
    private String gd007;
    @Size(max = 500)
    @Column(name = "GD008")
    private String gd008;
    @Size(max = 500)
    @Column(name = "GD009")
    private String gd009;

    public DDGD() {
    }

    public DDGD(DDGDPK dDGDPK) {
        this.dDGDPK = dDGDPK;
    }

    public DDGD(String gd001, String gd002) {
        this.dDGDPK = new DDGDPK(gd001, gd002);
    }

    public DDGDPK getDDGDPK() {
        return dDGDPK;
    }

    public void setDDGDPK(DDGDPK dDGDPK) {
        this.dDGDPK = dDGDPK;
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

    public String getGd003() {
        return gd003;
    }

    public void setGd003(String gd003) {
        this.gd003 = gd003;
    }

    public String getGd004() {
        return gd004;
    }

    public void setGd004(String gd004) {
        this.gd004 = gd004;
    }

    public String getGd005() {
        return gd005;
    }

    public void setGd005(String gd005) {
        this.gd005 = gd005;
    }

    public String getGd006() {
        return gd006;
    }

    public void setGd006(String gd006) {
        this.gd006 = gd006;
    }

    public String getGd007() {
        return gd007;
    }

    public void setGd007(String gd007) {
        this.gd007 = gd007;
    }

    public String getGd008() {
        return gd008;
    }

    public void setGd008(String gd008) {
        this.gd008 = gd008;
    }

    public String getGd009() {
        return gd009;
    }

    public void setGd009(String gd009) {
        this.gd009 = gd009;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dDGDPK != null ? dDGDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGD)) {
            return false;
        }
        DDGD other = (DDGD) object;
        if ((this.dDGDPK == null && other.dDGDPK != null) || (this.dDGDPK != null && !this.dDGDPK.equals(other.dDGDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGD[ dDGDPK=" + dDGDPK + " ]";
    }
    
}
