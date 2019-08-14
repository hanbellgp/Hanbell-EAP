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
@Table(name = "DDGB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DDGB.findAll", query = "SELECT d FROM DDGB d"),
    @NamedQuery(name = "DDGB.findByCompany", query = "SELECT d FROM DDGB d WHERE d.company = :company"),
    @NamedQuery(name = "DDGB.findByCreator", query = "SELECT d FROM DDGB d WHERE d.creator = :creator"),
    @NamedQuery(name = "DDGB.findByUsrGroup", query = "SELECT d FROM DDGB d WHERE d.usrGroup = :usrGroup"),
    @NamedQuery(name = "DDGB.findByCreateDate", query = "SELECT d FROM DDGB d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DDGB.findByModifier", query = "SELECT d FROM DDGB d WHERE d.modifier = :modifier"),
    @NamedQuery(name = "DDGB.findByModiDate", query = "SELECT d FROM DDGB d WHERE d.modiDate = :modiDate"),
    @NamedQuery(name = "DDGB.findByFlag", query = "SELECT d FROM DDGB d WHERE d.flag = :flag"),
    @NamedQuery(name = "DDGB.findByGb001", query = "SELECT d FROM DDGB d WHERE d.dDGBPK.gb001 = :gb001"),
    @NamedQuery(name = "DDGB.findByGb002", query = "SELECT d FROM DDGB d WHERE d.dDGBPK.gb002 = :gb002"),
    @NamedQuery(name = "DDGB.findByGb003", query = "SELECT d FROM DDGB d WHERE d.gb003 = :gb003"),
    @NamedQuery(name = "DDGB.findByGb004", query = "SELECT d FROM DDGB d WHERE d.gb004 = :gb004"),
    @NamedQuery(name = "DDGB.findByGb005", query = "SELECT d FROM DDGB d WHERE d.gb005 = :gb005"),
    @NamedQuery(name = "DDGB.findByGb006", query = "SELECT d FROM DDGB d WHERE d.gb006 = :gb006"),
    @NamedQuery(name = "DDGB.findByGb007", query = "SELECT d FROM DDGB d WHERE d.gb007 = :gb007"),
    @NamedQuery(name = "DDGB.findByGb008", query = "SELECT d FROM DDGB d WHERE d.gb008 = :gb008"),
    @NamedQuery(name = "DDGB.findByGb009", query = "SELECT d FROM DDGB d WHERE d.gb009 = :gb009")})
public class DDGB implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DDGBPK dDGBPK;
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
    @Column(name = "GB003")
    private String gb003;
    @Size(max = 500)
    @Column(name = "GB004")
    private String gb004;
    @Size(max = 500)
    @Column(name = "GB005")
    private String gb005;
    @Size(max = 500)
    @Column(name = "GB006")
    private String gb006;
    @Size(max = 500)
    @Column(name = "GB007")
    private String gb007;
    @Size(max = 500)
    @Column(name = "GB008")
    private String gb008;
    @Size(max = 500)
    @Column(name = "GB009")
    private String gb009;

    public DDGB() {
    }

    public DDGB(DDGBPK dDGBPK) {
        this.dDGBPK = dDGBPK;
    }

    public DDGB(String gb001, String gb002) {
        this.dDGBPK = new DDGBPK(gb001, gb002);
    }

    public DDGBPK getDDGBPK() {
        return dDGBPK;
    }

    public void setDDGBPK(DDGBPK dDGBPK) {
        this.dDGBPK = dDGBPK;
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

    public String getGb003() {
        return gb003;
    }

    public void setGb003(String gb003) {
        this.gb003 = gb003;
    }

    public String getGb004() {
        return gb004;
    }

    public void setGb004(String gb004) {
        this.gb004 = gb004;
    }

    public String getGb005() {
        return gb005;
    }

    public void setGb005(String gb005) {
        this.gb005 = gb005;
    }

    public String getGb006() {
        return gb006;
    }

    public void setGb006(String gb006) {
        this.gb006 = gb006;
    }

    public String getGb007() {
        return gb007;
    }

    public void setGb007(String gb007) {
        this.gb007 = gb007;
    }

    public String getGb008() {
        return gb008;
    }

    public void setGb008(String gb008) {
        this.gb008 = gb008;
    }

    public String getGb009() {
        return gb009;
    }

    public void setGb009(String gb009) {
        this.gb009 = gb009;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dDGBPK != null ? dDGBPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGB)) {
            return false;
        }
        DDGB other = (DDGB) object;
        if ((this.dDGBPK == null && other.dDGBPK != null) || (this.dDGBPK != null && !this.dDGBPK.equals(other.dDGBPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGB[ dDGBPK=" + dDGBPK + " ]";
    }

}
