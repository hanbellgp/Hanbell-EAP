/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
 * @author ZFF
 */
@Entity
@Table(name = "VH_FW002_grid2_SERI12")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHFW002Grid2SERI12.findAll", query = "SELECT v FROM VHFW002Grid2SERI12 v"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByMi008", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.mi008 = :mi008"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByMi009", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.mi009 = :mi009"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByMi503", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.mi503 = :mi503"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByOid", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa010c", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca010c = :ca010c"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa008", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca008 = :ca008"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa019", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca019 = :ca019"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa009", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca009 = :ca009"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa006", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca006 = :ca006"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa019c", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca019c = :ca019c"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa007", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca007 = :ca007"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa018", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca018 = :ca018"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa004", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca004 = :ca004"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa015", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca015 = :ca015"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa005", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca005 = :ca005"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa016", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca016 = :ca016"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByFSN", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.formSerialNumber = :fsn"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa002", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca002 = :ca002"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa003", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca003 = :ca003"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa011", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca011 = :ca011"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByTa031", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ta031 = :ta031"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa020", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca020 = :ca020"),
    @NamedQuery(name = "VHFW002Grid2SERI12.findByCa010", query = "SELECT v FROM VHFW002Grid2SERI12 v WHERE v.ca010 = :ca010")})
public class VHFW002Grid2SERI12 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "MI008")
    private String mi008;
    @Size(max = 255)
    @Column(name = "MI009")
    private String mi009;
    @Size(max = 255)
    @Column(name = "MI503")
    private String mi503;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "CA010C")
    private String ca010c;
    @Size(max = 255)
    @Column(name = "CA008")
    private String ca008;
    @Size(max = 255)
    @Column(name = "CA019")
    private String ca019;
    @Size(max = 255)
    @Column(name = "CA009")
    private String ca009;
    @Size(max = 255)
    @Column(name = "CA006")
    private String ca006;
    @Size(max = 255)
    @Column(name = "CA019C")
    private String ca019c;
    @Size(max = 255)
    @Column(name = "CA007")
    private String ca007;
    @Size(max = 255)
    @Column(name = "CA018")
    private String ca018;
    @Size(max = 255)
    @Column(name = "CA004")
    private String ca004;
    @Size(max = 255)
    @Column(name = "CA015")
    private String ca015;
    @Size(max = 255)
    @Column(name = "CA005")
    private String ca005;
    @Size(max = 255)
    @Column(name = "CA016")
    private String ca016;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "CA002")
    private String ca002;
    @Size(max = 255)
    @Column(name = "CA003")
    private String ca003;
    @Size(max = 255)
    @Column(name = "CA011")
    private String ca011;
    @Size(max = 255)
    @Column(name = "TA031")
    private String ta031;
    @Size(max = 255)
    @Column(name = "CA020")
    private String ca020;
    @Size(max = 255)
    @Column(name = "CA010")
    private String ca010;

    public VHFW002Grid2SERI12() {
    }

    public VHFW002Grid2SERI12(String oid) {
        this.oid = oid;
    }

    public String getMi008() {
        return mi008;
    }

    public void setMi008(String mi008) {
        this.mi008 = mi008;
    }

    public String getMi009() {
        return mi009;
    }

    public void setMi009(String mi009) {
        this.mi009 = mi009;
    }

    public String getMi503() {
        return mi503;
    }

    public void setMi503(String mi503) {
        this.mi503 = mi503;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCa010c() {
        return ca010c;
    }

    public void setCa010c(String ca010c) {
        this.ca010c = ca010c;
    }

    public String getCa008() {
        return ca008;
    }

    public void setCa008(String ca008) {
        this.ca008 = ca008;
    }

    public String getCa019() {
        return ca019;
    }

    public void setCa019(String ca019) {
        this.ca019 = ca019;
    }

    public String getCa009() {
        return ca009;
    }

    public void setCa009(String ca009) {
        this.ca009 = ca009;
    }

    public String getCa006() {
        return ca006;
    }

    public void setCa006(String ca006) {
        this.ca006 = ca006;
    }

    public String getCa019c() {
        return ca019c;
    }

    public void setCa019c(String ca019c) {
        this.ca019c = ca019c;
    }

    public String getCa007() {
        return ca007;
    }

    public void setCa007(String ca007) {
        this.ca007 = ca007;
    }

    public String getCa018() {
        return ca018;
    }

    public void setCa018(String ca018) {
        this.ca018 = ca018;
    }

    public String getCa004() {
        return ca004;
    }

    public void setCa004(String ca004) {
        this.ca004 = ca004;
    }

    public String getCa015() {
        return ca015;
    }

    public void setCa015(String ca015) {
        this.ca015 = ca015;
    }

    public String getCa005() {
        return ca005;
    }

    public void setCa005(String ca005) {
        this.ca005 = ca005;
    }

    public String getCa016() {
        return ca016;
    }

    public void setCa016(String ca016) {
        this.ca016 = ca016;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCa002() {
        return ca002;
    }

    public void setCa002(String ca002) {
        this.ca002 = ca002;
    }

    public String getCa003() {
        return ca003;
    }

    public void setCa003(String ca003) {
        this.ca003 = ca003;
    }

    public String getCa011() {
        return ca011;
    }

    public void setCa011(String ca011) {
        this.ca011 = ca011;
    }

    public String getTa031() {
        return ta031;
    }

    public void setTa031(String ta031) {
        this.ta031 = ta031;
    }

    public String getCa020() {
        return ca020;
    }

    public void setCa020(String ca020) {
        this.ca020 = ca020;
    }

    public String getCa010() {
        return ca010;
    }

    public void setCa010(String ca010) {
        this.ca010 = ca010;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VHFW002Grid2SERI12)) {
            return false;
        }
        VHFW002Grid2SERI12 other = (VHFW002Grid2SERI12) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHFW002Grid2SERI12[ oid=" + oid + " ]";
    }
    
}
