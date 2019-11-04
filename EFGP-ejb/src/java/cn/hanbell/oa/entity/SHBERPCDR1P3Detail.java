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
@Table(name = "SHB_ERP_CDR1P3_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPCDR1P3Detail.findAll", query = "SELECT s FROM SHBERPCDR1P3Detail s")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByArea", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.area = :area")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByArea1", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.area1 = :area1")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByCusno", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.cusno = :cusno")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByMancodesc", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.mancodesc = :mancodesc")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByOid", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.oid = :oid")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByChangetype", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.changetype = :changetype")
    , @NamedQuery(name = "SHBERPCDR1P3Detail.findByFSN", query = "SELECT s FROM SHBERPCDR1P3Detail s WHERE s.formSerialNumber = :fsn")})
public class SHBERPCDR1P3Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "area")
    private String area;
    @Size(max = 255)
    @Column(name = "area1")
    private String area1;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "mancodesc")
    private String mancodesc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 255)
    @Column(name = "cuslevel1")
    private String cuslevel1;
    @Size(max = 255)
    @Column(name = "cuslevel2")
    private String cuslevel2;
    @Size(max = 255)
    @Column(name = "changetype")
    private String changetype;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "appres")
    private String appres;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    public SHBERPCDR1P3Detail() {
    }

    public SHBERPCDR1P3Detail(String oid) {
        this.oid = oid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getMancodesc() {
        return mancodesc;
    }

    public void setMancodesc(String mancodesc) {
        this.mancodesc = mancodesc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getCuslevel1() {
        return cuslevel1;
    }

    public void setCuslevel1(String cuslevel1) {
        this.cuslevel1 = cuslevel1;
    }

    public String getCuslevel2() {
        return cuslevel2;
    }

    public void setCuslevel2(String cuslevel2) {
        this.cuslevel2 = cuslevel2;
    }

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getAppres() {
        return appres;
    }

    public void setAppres(String appres) {
        this.appres = appres;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof SHBERPCDR1P3Detail)) {
            return false;
        }
        SHBERPCDR1P3Detail other = (SHBERPCDR1P3Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPCDR1P3Detail[ oid=" + oid + " ]";
    }
    
}
