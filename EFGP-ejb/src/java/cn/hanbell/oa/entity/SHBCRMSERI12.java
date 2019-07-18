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
 * @author Administrator
 */
@Entity
@Table(name = "SHB_CRM_SERI12")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBCRMSERI12.findAll", query = "SELECT s FROM SHBCRMSERI12 s")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq500", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq500 = :bq500")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq506", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq506 = :bq506")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq035h", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq035h = :bq035h")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq035", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq035 = :bq035")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq135", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq135 = :bq135")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq005c", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq005c = :bq005c")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq130", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq130 = :bq130")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq056", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq056 = :bq056")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq055", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq055 = :bq055")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq023c", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq023c = :bq023c")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq023", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq023 = :bq023")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq024", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq024 = :bq024")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq506c", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq506c = :bq506c")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq129", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq129 = :bq129")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq060", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq060 = :bq060")
    , @NamedQuery(name = "SHBCRMSERI12.findByCa500", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.ca500 = :ca500")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq061", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq061 = :bq061")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq003c", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq003c = :bq003c")
    , @NamedQuery(name = "SHBCRMSERI12.findByBq197", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.bq197 = :bq197")
    , @NamedQuery(name = "SHBCRMSERI12.findByPSN", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.processSerialNumber = :psn")
    , @NamedQuery(name = "SHBCRMSERI12.findByFSN", query = "SELECT s FROM SHBCRMSERI12 s WHERE s.formSerialNumber = :fsn")})
public class SHBCRMSERI12 implements Serializable {

    @Size(max = 255)
    @Column(name = "hdnappdept")
    private String hdnappdept;
    @Size(max = 255)
    @Column(name = "hdnapplyuser")
    private String hdnapplyuser;
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "BQ500")
    private String bq500;
    @Size(max = 255)
    @Column(name = "BQ506")
    private String bq506;
    @Size(max = 255)
    @Column(name = "BQ035H")
    private String bq035h;
    @Size(max = 255)
    @Column(name = "BQ035")
    private String bq035;
    @Size(max = 255)
    @Column(name = "BQ135")
    private String bq135;
    @Size(max = 255)
    @Column(name = "BQ005C")
    private String bq005c;
    @Size(max = 255)
    @Column(name = "BQ130")
    private String bq130;
    @Size(max = 255)
    @Column(name = "BQ056")
    private String bq056;
    @Size(max = 255)
    @Column(name = "BQ055")
    private String bq055;
    @Size(max = 255)
    @Column(name = "BQ023C")
    private String bq023c;
    @Size(max = 255)
    @Column(name = "BQ023")
    private String bq023;
    @Size(max = 255)
    @Column(name = "BQ024")
    private String bq024;
    @Size(max = 255)
    @Column(name = "BQ506C")
    private String bq506c;
    @Size(max = 255)
    @Column(name = "BQ129")
    private String bq129;
    @Size(max = 255)
    @Column(name = "BQ060")
    private String bq060;
    @Size(max = 255)
    @Column(name = "CA500")
    private String ca500;
    @Size(max = 255)
    @Column(name = "BQ061")
    private String bq061;
    @Size(max = 255)
    @Column(name = "CA500C")
    private String ca500c;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "BQ002C")
    private String bq002c;
    @Size(max = 255)
    @Column(name = "BQ017C")
    private String bq017c;
    @Size(max = 255)
    @Column(name = "BQ014C1")
    private String bq014c1;
    @Size(max = 255)
    @Column(name = "BQ014C2")
    private String bq014c2;
    @Size(max = 255)
    @Column(name = "BQ014")
    private String bq014;
    @Size(max = 255)
    @Column(name = "BQ110")
    private String bq110;
    @Size(max = 255)
    @Column(name = "BQ016")
    private String bq016;
    @Size(max = 255)
    @Column(name = "BQ017")
    private String bq017;
    @Size(max = 255)
    @Column(name = "CA011")
    private String ca011;
    @Size(max = 255)
    @Column(name = "CA010")
    private String ca010;
    @Size(max = 255)
    @Column(name = "BQ003C")
    private String bq003c;
    @Size(max = 255)
    @Column(name = "BQ197")
    private String bq197;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "BQ198")
    private String bq198;
    @Size(max = 255)
    @Column(name = "BQ199C")
    private String bq199c;
    @Size(max = 255)
    @Column(name = "BQ199")
    private String bq199;
    @Size(max = 255)
    @Column(name = "BQ016C")
    private String bq016c;
    @Size(max = 255)
    @Column(name = "BQ197C")
    private String bq197c;
    @Size(max = 255)
    @Column(name = "BQ005")
    private String bq005;
    @Size(max = 255)
    @Column(name = "CA003")
    private String ca003;
    @Size(max = 255)
    @Column(name = "BQ006")
    private String bq006;
    @Size(max = 255)
    @Column(name = "BQ003")
    private String bq003;
    @Size(max = 255)
    @Column(name = "CA005")
    private String ca005;
    @Size(max = 255)
    @Column(name = "CA004")
    private String ca004;
    @Size(max = 255)
    @Column(name = "BQ001")
    private String bq001;
    @Size(max = 255)
    @Column(name = "BQ002")
    private String bq002;
    @Size(max = 255)
    @Column(name = "BQ009")
    private String bq009;
    @Size(max = 255)
    @Column(name = "BQ198C")
    private String bq198c;
    @Size(max = 255)
    @Column(name = "BQ007")
    private String bq007;
    @Size(max = 255)
    @Column(name = "CA009")
    private String ca009;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public SHBCRMSERI12() {
    }

    public SHBCRMSERI12(String oid) {
        this.oid = oid;
    }

    public String getBq500() {
        return bq500;
    }

    public void setBq500(String bq500) {
        this.bq500 = bq500;
    }

    public String getBq506() {
        return bq506;
    }

    public void setBq506(String bq506) {
        this.bq506 = bq506;
    }

    public String getBq035h() {
        return bq035h;
    }

    public void setBq035h(String bq035h) {
        this.bq035h = bq035h;
    }

    public String getBq035() {
        return bq035;
    }

    public void setBq035(String bq035) {
        this.bq035 = bq035;
    }

    public String getBq135() {
        return bq135;
    }

    public void setBq135(String bq135) {
        this.bq135 = bq135;
    }

    public String getBq005c() {
        return bq005c;
    }

    public void setBq005c(String bq005c) {
        this.bq005c = bq005c;
    }

    public String getBq130() {
        return bq130;
    }

    public void setBq130(String bq130) {
        this.bq130 = bq130;
    }

    public String getBq056() {
        return bq056;
    }

    public void setBq056(String bq056) {
        this.bq056 = bq056;
    }

    public String getBq055() {
        return bq055;
    }

    public void setBq055(String bq055) {
        this.bq055 = bq055;
    }

    public String getBq023c() {
        return bq023c;
    }

    public void setBq023c(String bq023c) {
        this.bq023c = bq023c;
    }

    public String getBq023() {
        return bq023;
    }

    public void setBq023(String bq023) {
        this.bq023 = bq023;
    }

    public String getBq024() {
        return bq024;
    }

    public void setBq024(String bq024) {
        this.bq024 = bq024;
    }

    public String getBq506c() {
        return bq506c;
    }

    public void setBq506c(String bq506c) {
        this.bq506c = bq506c;
    }

    public String getBq129() {
        return bq129;
    }

    public void setBq129(String bq129) {
        this.bq129 = bq129;
    }

    public String getBq060() {
        return bq060;
    }

    public void setBq060(String bq060) {
        this.bq060 = bq060;
    }

    public String getCa500() {
        return ca500;
    }

    public void setCa500(String ca500) {
        this.ca500 = ca500;
    }

    public String getBq061() {
        return bq061;
    }

    public void setBq061(String bq061) {
        this.bq061 = bq061;
    }

    public String getCa500c() {
        return ca500c;
    }

    public void setCa500c(String ca500c) {
        this.ca500c = ca500c;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBq002c() {
        return bq002c;
    }

    public void setBq002c(String bq002c) {
        this.bq002c = bq002c;
    }

    public String getBq017c() {
        return bq017c;
    }

    public void setBq017c(String bq017c) {
        this.bq017c = bq017c;
    }

    public String getBq014c1() {
        return bq014c1;
    }

    public void setBq014c1(String bq014c1) {
        this.bq014c1 = bq014c1;
    }

    public String getBq014c2() {
        return bq014c2;
    }

    public void setBq014c2(String bq014c2) {
        this.bq014c2 = bq014c2;
    }

    public String getBq014() {
        return bq014;
    }

    public void setBq014(String bq014) {
        this.bq014 = bq014;
    }

    public String getBq110() {
        return bq110;
    }

    public void setBq110(String bq110) {
        this.bq110 = bq110;
    }

    public String getBq016() {
        return bq016;
    }

    public void setBq016(String bq016) {
        this.bq016 = bq016;
    }

    public String getBq017() {
        return bq017;
    }

    public void setBq017(String bq017) {
        this.bq017 = bq017;
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

    public String getBq003c() {
        return bq003c;
    }

    public void setBq003c(String bq003c) {
        this.bq003c = bq003c;
    }

    public String getBq197() {
        return bq197;
    }

    public void setBq197(String bq197) {
        this.bq197 = bq197;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getBq198() {
        return bq198;
    }

    public void setBq198(String bq198) {
        this.bq198 = bq198;
    }

    public String getBq199c() {
        return bq199c;
    }

    public void setBq199c(String bq199c) {
        this.bq199c = bq199c;
    }

    public String getBq199() {
        return bq199;
    }

    public void setBq199(String bq199) {
        this.bq199 = bq199;
    }

    public String getBq016c() {
        return bq016c;
    }

    public void setBq016c(String bq016c) {
        this.bq016c = bq016c;
    }

    public String getBq197c() {
        return bq197c;
    }

    public void setBq197c(String bq197c) {
        this.bq197c = bq197c;
    }

    public String getBq005() {
        return bq005;
    }

    public void setBq005(String bq005) {
        this.bq005 = bq005;
    }

    public String getCa003() {
        return ca003;
    }

    public void setCa003(String ca003) {
        this.ca003 = ca003;
    }

    public String getBq006() {
        return bq006;
    }

    public void setBq006(String bq006) {
        this.bq006 = bq006;
    }

    public String getBq003() {
        return bq003;
    }

    public void setBq003(String bq003) {
        this.bq003 = bq003;
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

    public String getBq001() {
        return bq001;
    }

    public void setBq001(String bq001) {
        this.bq001 = bq001;
    }

    public String getBq002() {
        return bq002;
    }

    public void setBq002(String bq002) {
        this.bq002 = bq002;
    }

    public String getBq009() {
        return bq009;
    }

    public void setBq009(String bq009) {
        this.bq009 = bq009;
    }

    public String getBq198c() {
        return bq198c;
    }

    public void setBq198c(String bq198c) {
        this.bq198c = bq198c;
    }

    public String getBq007() {
        return bq007;
    }

    public void setBq007(String bq007) {
        this.bq007 = bq007;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SHBCRMSERI12)) {
            return false;
        }
        SHBCRMSERI12 other = (SHBCRMSERI12) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBCRMSERI12[ oid=" + oid + " ]";
    }

    public String getHdnappdept() {
        return hdnappdept;
    }

    public void setHdnappdept(String hdnappdept) {
        this.hdnappdept = hdnappdept;
    }

    public String getHdnapplyuser() {
        return hdnapplyuser;
    }

    public void setHdnapplyuser(String hdnapplyuser) {
        this.hdnapplyuser = hdnapplyuser;
    }

}
