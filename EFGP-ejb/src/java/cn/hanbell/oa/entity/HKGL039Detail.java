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
 * @author C1587
 */
@Entity
@Table(name = "HK_GL039_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL039Detail.findAll", query = "SELECT h FROM HKGL039Detail h"),
    @NamedQuery(name = "HKGL039Detail.findByOID", query = "SELECT h FROM HKGL039Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL039Detail.findBySalekind", query = "SELECT h FROM HKGL039Detail h WHERE h.salekind = :salekind"),
    @NamedQuery(name = "HKGL039.findByPrice01h", query = "SELECT h FROM HKGL039 h WHERE h.price01h = :price01h"),
    @NamedQuery(name = "HKGL039Detail.findByBottle02", query = "SELECT h FROM HKGL039Detail h WHERE h.bottle02 = :bottle02"),
    @NamedQuery(name = "HKGL039Detail.findByBox01", query = "SELECT h FROM HKGL039Detail h WHERE h.box01 = :box01"),
    @NamedQuery(name = "HKGL039Detail.findByUnit01", query = "SELECT h FROM HKGL039Detail h WHERE h.unit01 = :unit01"),
    @NamedQuery(name = "HKGL039Detail.findByJ01", query = "SELECT h FROM HKGL039Detail h WHERE h.j01 = :j01"),
    @NamedQuery(name = "HKGL039Detail.findByBottle01", query = "SELECT h FROM HKGL039Detail h WHERE h.bottle01 = :bottle01"),
    @NamedQuery(name = "HKGL039Detail.findBySum01", query = "SELECT h FROM HKGL039Detail h WHERE h.sum01 = :sum01"),
    @NamedQuery(name = "HKGL039Detail.findByA01", query = "SELECT h FROM HKGL039Detail h WHERE h.a01 = :a01"),
    @NamedQuery(name = "HKGL039Detail.findBySeq", query = "SELECT h FROM HKGL039Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL039Detail.findByNo01", query = "SELECT h FROM HKGL039Detail h WHERE h.no01 = :no01"),
    @NamedQuery(name = "HKGL039Detail.findByPrice01", query = "SELECT h FROM HKGL039Detail h WHERE h.price01 = :price01"),
    @NamedQuery(name = "HKGL039Detail.findByS01", query = "SELECT h FROM HKGL039Detail h WHERE h.s01 = :s01"),
    @NamedQuery(name = "HKGL039Detail.findByFSN", query = "SELECT h FROM HKGL039Detail h WHERE h.formSerialNumber = :fsn")})
public class HKGL039Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "salekind")
    private String salekind;
    @Size(max = 255)
    @Column(name = "bottle02")
    private String bottle02;
    @Size(max = 255)
    @Column(name = "box01")
    private String box01;
    @Size(max = 255)
    @Column(name = "unit01")
    private String unit01;
    @Size(max = 255)
    @Column(name = "j01")
    private String j01;
    @Size(max = 255)
    @Column(name = "bottle01")
    private String bottle01;
    @Size(max = 255)
    @Column(name = "sum01")
    private String sum01;
    @Size(max = 255)
    @Column(name = "a01")
    private String a01;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "no01")
    private String no01;
    @Size(max = 255)
    @Column(name = "price01")
    private String price01;
    @Size(max = 255)
    @Column(name = "price01h")
    private String price01h;
    @Size(max = 255)
    @Column(name = "s01")
    private String s01;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKGL039Detail() {
    }

    public HKGL039Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSalekind() {
        return salekind;
    }

    public void setSalekind(String salekind) {
        this.salekind = salekind;
    }

    public String getBottle02() {
        return bottle02;
    }

    public void setBottle02(String bottle02) {
        this.bottle02 = bottle02;
    }

    public String getBox01() {
        return box01;
    }

    public void setBox01(String box01) {
        this.box01 = box01;
    }

    public String getUnit01() {
        return unit01;
    }

    public void setUnit01(String unit01) {
        this.unit01 = unit01;
    }

    public String getJ01() {
        return j01;
    }

    public void setJ01(String j01) {
        this.j01 = j01;
    }

    public String getBottle01() {
        return bottle01;
    }

    public void setBottle01(String bottle01) {
        this.bottle01 = bottle01;
    }

    public String getSum01() {
        return sum01;
    }

    public void setSum01(String sum01) {
        this.sum01 = sum01;
    }

    public String getA01() {
        return a01;
    }

    public void setA01(String a01) {
        this.a01 = a01;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getNo01() {
        return no01;
    }

    public void setNo01(String no01) {
        this.no01 = no01;
    }

    public String getPrice01() {
        return price01;
    }

    public void setPrice01(String price01) {
        this.price01 = price01;
    }

    public String getS01() {
        return s01;
    }

    public void setS01(String s01) {
        this.s01 = s01;
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
        if (!(object instanceof HKGL039Detail)) {
            return false;
        }
        HKGL039Detail other = (HKGL039Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL039Detail[ oid=" + oid + " ]";
    }

    /**
     * @return the price01h
     */
    public String getPrice01h() {
        return price01h;
    }

    /**
     * @param price01h the price01h to set
     */
    public void setPrice01h(String price01h) {
        this.price01h = price01h;
    }
    
}
