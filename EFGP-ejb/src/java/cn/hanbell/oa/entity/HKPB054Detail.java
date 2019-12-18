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
@Table(name = "HK_PB054_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKPB054Detail.findAll", query = "SELECT h FROM HKPB054Detail h"),
    @NamedQuery(name = "HKPB054Detail.findByOID", query = "SELECT h FROM HKPB054Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKPB054Detail.findByFSN", query = "SELECT h FROM HKPB054Detail h WHERE h.formSerialNumber = :fsn")})
public class HKPB054Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ZR002C")
    private String zr002c;
    @Size(max = 255)
    @Column(name = "ZR003C")
    private String zr003c;
    @Size(max = 255)
    @Column(name = "mftNo")
    private String mftNo;
    @Size(max = 255)
    @Column(name = "BL002C")
    private String bl002c;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "BL003C")
    private String bl003c;
    @Size(max = 255)
    @Column(name = "JE001C")
    private String je001c;
    @Size(max = 255)
    @Column(name = "JE002C")
    private String je002c;
    @Size(max = 255)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 255)
    @Column(name = "ZR001C")
    private String zr001c;
    @Size(max = 255)
    @Column(name = "JE003C")
    private String je003c;
    @Size(max = 255)
    @Column(name = "BL001C")
    private String bl001c;
    @Size(max = 255)
    @Column(name = "JEtotalC")
    private String jEtotalC;
    @Size(max = 255)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    public HKPB054Detail() {
    }

    public HKPB054Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getZr002c() {
        return zr002c;
    }

    public void setZr002c(String zr002c) {
        this.zr002c = zr002c;
    }

    public String getZr003c() {
        return zr003c;
    }

    public void setZr003c(String zr003c) {
        this.zr003c = zr003c;
    }

    public String getMftNo() {
        return mftNo;
    }

    public void setMftNo(String mftNo) {
        this.mftNo = mftNo;
    }

    public String getBl002c() {
        return bl002c;
    }

    public void setBl002c(String bl002c) {
        this.bl002c = bl002c;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBl003c() {
        return bl003c;
    }

    public void setBl003c(String bl003c) {
        this.bl003c = bl003c;
    }

    public String getJe001c() {
        return je001c;
    }

    public void setJe001c(String je001c) {
        this.je001c = je001c;
    }

    public String getJe002c() {
        return je002c;
    }

    public void setJe002c(String je002c) {
        this.je002c = je002c;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getZr001c() {
        return zr001c;
    }

    public void setZr001c(String zr001c) {
        this.zr001c = zr001c;
    }

    public String getJe003c() {
        return je003c;
    }

    public void setJe003c(String je003c) {
        this.je003c = je003c;
    }

    public String getBl001c() {
        return bl001c;
    }

    public void setBl001c(String bl001c) {
        this.bl001c = bl001c;
    }

    public String getJEtotalC() {
        return jEtotalC;
    }

    public void setJEtotalC(String jEtotalC) {
        this.jEtotalC = jEtotalC;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
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
        if (!(object instanceof HKPB054Detail)) {
            return false;
        }
        HKPB054Detail other = (HKPB054Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKPB054Detail[ oid=" + oid + " ]";
    }
    
}
