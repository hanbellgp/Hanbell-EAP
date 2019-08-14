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
@Table(name = "DDGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DDGA.findAll", query = "SELECT d FROM DDGA d"),
    @NamedQuery(name = "DDGA.findByCompany", query = "SELECT d FROM DDGA d WHERE d.company = :company"),
    @NamedQuery(name = "DDGA.findByCreator", query = "SELECT d FROM DDGA d WHERE d.creator = :creator"),
    @NamedQuery(name = "DDGA.findByUsrGroup", query = "SELECT d FROM DDGA d WHERE d.usrGroup = :usrGroup"),
    @NamedQuery(name = "DDGA.findByCreateDate", query = "SELECT d FROM DDGA d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DDGA.findByModifier", query = "SELECT d FROM DDGA d WHERE d.modifier = :modifier"),
    @NamedQuery(name = "DDGA.findByModiDate", query = "SELECT d FROM DDGA d WHERE d.modiDate = :modiDate"),
    @NamedQuery(name = "DDGA.findByFlag", query = "SELECT d FROM DDGA d WHERE d.flag = :flag"),
    @NamedQuery(name = "DDGA.findByGa001", query = "SELECT d FROM DDGA d WHERE d.dDGAPK.ga001 = :ga001"),
    @NamedQuery(name = "DDGA.findByGa002", query = "SELECT d FROM DDGA d WHERE d.dDGAPK.ga002 = :ga002"),
    @NamedQuery(name = "DDGA.findByGa003", query = "SELECT d FROM DDGA d WHERE d.dDGAPK.ga003 = :ga003"),
    @NamedQuery(name = "DDGA.findByGa004", query = "SELECT d FROM DDGA d WHERE d.dDGAPK.ga004 = :ga004"),
    @NamedQuery(name = "DDGA.findByREPPB", query = "SELECT d FROM DDGA d WHERE d.dDGAPK.ga001 = :ga001 AND d.dDGAPK.ga002 = :ga002 AND d.dDGAPK.ga003 = :ga003"),
    @NamedQuery(name = "DDGA.findByGa005", query = "SELECT d FROM DDGA d WHERE d.ga005 = :ga005"),
    @NamedQuery(name = "DDGA.findByGa006", query = "SELECT d FROM DDGA d WHERE d.ga006 = :ga006"),
    @NamedQuery(name = "DDGA.findByGa007", query = "SELECT d FROM DDGA d WHERE d.ga007 = :ga007"),
    @NamedQuery(name = "DDGA.findByGa008", query = "SELECT d FROM DDGA d WHERE d.ga008 = :ga008"),
    @NamedQuery(name = "DDGA.findByGa009", query = "SELECT d FROM DDGA d WHERE d.ga009 = :ga009"),
    @NamedQuery(name = "DDGA.findByGa010", query = "SELECT d FROM DDGA d WHERE d.ga010 = :ga010"),
    @NamedQuery(name = "DDGA.findByGa011", query = "SELECT d FROM DDGA d WHERE d.ga011 = :ga011"),
    @NamedQuery(name = "DDGA.findByGa012", query = "SELECT d FROM DDGA d WHERE d.ga012 = :ga012"),
    @NamedQuery(name = "DDGA.findByGa013", query = "SELECT d FROM DDGA d WHERE d.ga013 = :ga013")})
public class DDGA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DDGAPK dDGAPK;
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
    @Size(max = 120)
    @Column(name = "GA005")
    private String ga005;
    @Size(max = 120)
    @Column(name = "GA006")
    private String ga006;
    @Size(max = 2)
    @Column(name = "GA007")
    private String ga007;
    @Size(max = 11)
    @Column(name = "GA008")
    private String ga008;
    @Size(max = 10)
    @Column(name = "GA009")
    private String ga009;
    @Size(max = 500)
    @Column(name = "GA010")
    private String ga010;
    @Size(max = 11)
    @Column(name = "GA011")
    private String ga011;
    @Size(max = 4)
    @Column(name = "GA012")
    private String ga012;
    @Size(max = 500)
    @Column(name = "GA013")
    private String ga013;

    public DDGA() {
    }

    public DDGA(DDGAPK dDGAPK) {
        this.dDGAPK = dDGAPK;
    }

    public DDGA(String ga001, String ga002, String ga003, String ga004) {
        this.dDGAPK = new DDGAPK(ga001, ga002, ga003, ga004);
    }

    public DDGAPK getDDGAPK() {
        return dDGAPK;
    }

    public void setDDGAPK(DDGAPK dDGAPK) {
        this.dDGAPK = dDGAPK;
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

    public String getGa005() {
        return ga005;
    }

    public void setGa005(String ga005) {
        this.ga005 = ga005;
    }

    public String getGa006() {
        return ga006;
    }

    public void setGa006(String ga006) {
        this.ga006 = ga006;
    }

    public String getGa007() {
        return ga007;
    }

    public void setGa007(String ga007) {
        this.ga007 = ga007;
    }

    public String getGa008() {
        return ga008;
    }

    public void setGa008(String ga008) {
        this.ga008 = ga008;
    }

    public String getGa009() {
        return ga009;
    }

    public void setGa009(String ga009) {
        this.ga009 = ga009;
    }

    public String getGa010() {
        return ga010;
    }

    public void setGa010(String ga010) {
        this.ga010 = ga010;
    }

    public String getGa011() {
        return ga011;
    }

    public void setGa011(String ga011) {
        this.ga011 = ga011;
    }

    public String getGa012() {
        return ga012;
    }

    public void setGa012(String ga012) {
        this.ga012 = ga012;
    }

    public String getGa013() {
        return ga013;
    }

    public void setGa013(String ga013) {
        this.ga013 = ga013;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dDGAPK != null ? dDGAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGA)) {
            return false;
        }
        DDGA other = (DDGA) object;
        if ((this.dDGAPK == null && other.dDGAPK != null) || (this.dDGAPK != null && !this.dDGAPK.equals(other.dDGAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGA[ dDGAPK=" + dDGAPK + " ]";
    }

}
