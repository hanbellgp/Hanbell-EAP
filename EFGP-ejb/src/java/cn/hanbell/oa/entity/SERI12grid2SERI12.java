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
 * @author C0160
 */
@Entity
@Table(name = "SERI12_grid2_SERI12")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERI12grid2SERI12.findAll", query = "SELECT s FROM SERI12grid2SERI12 s")
    , @NamedQuery(name = "SERI12grid2SERI12.findByOID", query = "SELECT s FROM SERI12grid2SERI12 s WHERE s.oid = :oid")
    , @NamedQuery(name = "SERI12grid2SERI12.findByFSN", query = "SELECT s FROM SERI12grid2SERI12 s WHERE s.formSerialNumber = :fsn")})
public class SERI12grid2SERI12 implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "CA019C")
    private String ca019c;
    @Size(max = 255)
    @Column(name = "CA016")
    private String ca016;
    @Size(max = 255)
    @Column(name = "CA003")
    private String ca003;
    @Size(max = 255)
    @Column(name = "TA031")
    private String ta031;
    @Size(max = 255)
    @Column(name = "CA020")
    private String ca020;
    @Size(max = 255)
    @Column(name = "CA015")
    private String ca015;
    @Size(max = 255)
    @Column(name = "CA002")
    private String ca002;
    @Size(max = 255)
    @Column(name = "CA005")
    private String ca005;
    @Size(max = 255)
    @Column(name = "CA004")
    private String ca004;
    @Size(max = 255)
    @Column(name = "CA011")
    private String ca011;
    @Size(max = 255)
    @Column(name = "CA010")
    private String ca010;
    @Size(max = 255)
    @Column(name = "CA007")
    private String ca007;
    @Size(max = 255)
    @Column(name = "CA019")
    private String ca019;
    @Size(max = 255)
    @Column(name = "CA006")
    private String ca006;
    @Size(max = 255)
    @Column(name = "CA018")
    private String ca018;
    @Size(max = 255)
    @Column(name = "CA009")
    private String ca009;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "CA008")
    private String ca008;
    @Size(max = 255)
    @Column(name = "MI008")
    private String mi008;
    @Size(max = 255)
    @Column(name = "MI009")
    private String mi009;
    @Size(max = 255)
    @Column(name = "MI007")
    private String mi007;
    @Size(max = 255)
    @Column(name = "MI017")
    private String mi017;
    @Size(max = 255)
    @Column(name = "MI503")
    private String mi503;

    public SERI12grid2SERI12() {
    }

    public SERI12grid2SERI12(String oid) {
        this.oid = oid;
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

    public String getCa019c() {
        return ca019c;
    }

    public void setCa019c(String ca019c) {
        this.ca019c = ca019c;
    }

    public String getCa016() {
        return ca016;
    }

    public void setCa016(String ca016) {
        this.ca016 = ca016;
    }

    public String getCa003() {
        return ca003;
    }

    public void setCa003(String ca003) {
        this.ca003 = ca003;
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

    public String getCa015() {
        return ca015;
    }

    public void setCa015(String ca015) {
        this.ca015 = ca015;
    }

    public String getCa002() {
        return ca002;
    }

    public void setCa002(String ca002) {
        this.ca002 = ca002;
    }

    public String getCa005() {
        return ca005;
    }

    public void setCa005(String ca005) {
        this.ca005 = ca005;
    }

    public String getCa004() {
        return ca004;
    }

    public void setCa004(String ca004) {
        this.ca004 = ca004;
    }

    public String getCa011() {
        return ca011;
    }

    public void setCa011(String ca011) {
        this.ca011 = ca011;
    }

    public String getCa010() {
        return ca010;
    }

    public void setCa010(String ca010) {
        this.ca010 = ca010;
    }

    public String getCa007() {
        return ca007;
    }

    public void setCa007(String ca007) {
        this.ca007 = ca007;
    }

    public String getCa019() {
        return ca019;
    }

    public void setCa019(String ca019) {
        this.ca019 = ca019;
    }

    public String getCa006() {
        return ca006;
    }

    public void setCa006(String ca006) {
        this.ca006 = ca006;
    }

    public String getCa018() {
        return ca018;
    }

    public void setCa018(String ca018) {
        this.ca018 = ca018;
    }

    public String getCa009() {
        return ca009;
    }

    public void setCa009(String ca009) {
        this.ca009 = ca009;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCa008() {
        return ca008;
    }

    public void setCa008(String ca008) {
        this.ca008 = ca008;
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

    public String getMi007() {
        return mi007;
    }

    public void setMi007(String mi007) {
        this.mi007 = mi007;
    }

    public String getMi017() {
        return mi017;
    }

    public void setMi017(String mi017) {
        this.mi017 = mi017;
    }

    public String getMi503() {
        return mi503;
    }

    public void setMi503(String mi503) {
        this.mi503 = mi503;
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
        if (!(object instanceof SERI12grid2SERI12)) {
            return false;
        }
        SERI12grid2SERI12 other = (SERI12grid2SERI12) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SERI12grid2SERI12[ oid=" + oid + " ]";
    }

}
