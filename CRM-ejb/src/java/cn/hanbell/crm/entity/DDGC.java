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
@Table(name = "DDGC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DDGC.findAll", query = "SELECT d FROM DDGC d"),
    @NamedQuery(name = "DDGC.findByCompany", query = "SELECT d FROM DDGC d WHERE d.company = :company"),
    @NamedQuery(name = "DDGC.findByCreator", query = "SELECT d FROM DDGC d WHERE d.creator = :creator"),
    @NamedQuery(name = "DDGC.findByUsrGroup", query = "SELECT d FROM DDGC d WHERE d.usrGroup = :usrGroup"),
    @NamedQuery(name = "DDGC.findByCreateDate", query = "SELECT d FROM DDGC d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DDGC.findByModifier", query = "SELECT d FROM DDGC d WHERE d.modifier = :modifier"),
    @NamedQuery(name = "DDGC.findByModiDate", query = "SELECT d FROM DDGC d WHERE d.modiDate = :modiDate"),
    @NamedQuery(name = "DDGC.findByFlag", query = "SELECT d FROM DDGC d WHERE d.flag = :flag"),
    @NamedQuery(name = "DDGC.findByGc001", query = "SELECT d FROM DDGC d WHERE d.dDGCPK.gc001 = :gc001"),
    @NamedQuery(name = "DDGC.findByGc002", query = "SELECT d FROM DDGC d WHERE d.dDGCPK.gc002 = :gc002"),
    @NamedQuery(name = "DDGC.findByGc003", query = "SELECT d FROM DDGC d WHERE d.dDGCPK.gc003 = :gc003"),
    @NamedQuery(name = "DDGC.findByGc004", query = "SELECT d FROM DDGC d WHERE d.dDGCPK.gc004 = :gc004"),
    @NamedQuery(name = "DDGC.findByREPPB", query = "SELECT d FROM DDGC d WHERE d.dDGCPK.gc001 = :gc001 AND d.dDGCPK.gc002 = :gc002 AND d.dDGCPK.gc003 = :gc003"),
    @NamedQuery(name = "DDGC.findByGc005", query = "SELECT d FROM DDGC d WHERE d.gc005 = :gc005"),
    @NamedQuery(name = "DDGC.findByGc006", query = "SELECT d FROM DDGC d WHERE d.gc006 = :gc006"),
    @NamedQuery(name = "DDGC.findByGc007", query = "SELECT d FROM DDGC d WHERE d.gc007 = :gc007"),
    @NamedQuery(name = "DDGC.findByGc008", query = "SELECT d FROM DDGC d WHERE d.gc008 = :gc008"),
    @NamedQuery(name = "DDGC.findByGc009", query = "SELECT d FROM DDGC d WHERE d.gc009 = :gc009"),
    @NamedQuery(name = "DDGC.findByGc010", query = "SELECT d FROM DDGC d WHERE d.gc010 = :gc010"),
    @NamedQuery(name = "DDGC.findByGc011", query = "SELECT d FROM DDGC d WHERE d.gc011 = :gc011"),
    @NamedQuery(name = "DDGC.findByGc012", query = "SELECT d FROM DDGC d WHERE d.gc012 = :gc012"),
    @NamedQuery(name = "DDGC.findByGc013", query = "SELECT d FROM DDGC d WHERE d.gc013 = :gc013")})
public class DDGC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DDGCPK dDGCPK;
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
    @Column(name = "GC005")
    private String gc005;
    @Size(max = 120)
    @Column(name = "GC006")
    private String gc006;
    @Size(max = 2)
    @Column(name = "GC007")
    private String gc007;
    @Size(max = 1)
    @Column(name = "GC008")
    private String gc008;
    @Size(max = 500)
    @Column(name = "GC009")
    private String gc009;
    @Size(max = 500)
    @Column(name = "GC010")
    private String gc010;
    @Size(max = 11)
    @Column(name = "GC011")
    private String gc011;
    @Size(max = 4)
    @Column(name = "GC012")
    private String gc012;
    @Size(max = 500)
    @Column(name = "GC013")
    private String gc013;

    public DDGC() {
    }

    public DDGC(DDGCPK dDGCPK) {
        this.dDGCPK = dDGCPK;
    }

    public DDGC(String gc001, String gc002, String gc003, String gc004) {
        this.dDGCPK = new DDGCPK(gc001, gc002, gc003, gc004);
    }

    public DDGCPK getDDGCPK() {
        return dDGCPK;
    }

    public void setDDGCPK(DDGCPK dDGCPK) {
        this.dDGCPK = dDGCPK;
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

    public String getGc005() {
        return gc005;
    }

    public void setGc005(String gc005) {
        this.gc005 = gc005;
    }

    public String getGc006() {
        return gc006;
    }

    public void setGc006(String gc006) {
        this.gc006 = gc006;
    }

    public String getGc007() {
        return gc007;
    }

    public void setGc007(String gc007) {
        this.gc007 = gc007;
    }

    public String getGc008() {
        return gc008;
    }

    public void setGc008(String gc008) {
        this.gc008 = gc008;
    }

    public String getGc009() {
        return gc009;
    }

    public void setGc009(String gc009) {
        this.gc009 = gc009;
    }

    public String getGc010() {
        return gc010;
    }

    public void setGc010(String gc010) {
        this.gc010 = gc010;
    }

    public String getGc011() {
        return gc011;
    }

    public void setGc011(String gc011) {
        this.gc011 = gc011;
    }

    public String getGc012() {
        return gc012;
    }

    public void setGc012(String gc012) {
        this.gc012 = gc012;
    }

    public String getGc013() {
        return gc013;
    }

    public void setGc013(String gc013) {
        this.gc013 = gc013;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dDGCPK != null ? dDGCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGC)) {
            return false;
        }
        DDGC other = (DDGC) object;
        if ((this.dDGCPK == null && other.dDGCPK != null) || (this.dDGCPK != null && !this.dDGCPK.equals(other.dDGCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGC[ dDGCPK=" + dDGCPK + " ]";
    }

}
