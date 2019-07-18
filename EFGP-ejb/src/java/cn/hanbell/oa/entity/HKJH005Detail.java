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
@Table(name = "HK_JH005_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH005Detail.findAll", query = "SELECT h FROM HKJH005Detail h")
    , @NamedQuery(name = "HKJH005Detail.findByOid", query = "SELECT h FROM HKJH005Detail h WHERE h.oid = :oid")
    , @NamedQuery(name = "HKJH005Detail.findByFixnr", query = "SELECT h FROM HKJH005Detail h WHERE h.fixnr = :fixnr")
    , @NamedQuery(name = "HKJH005Detail.findByNprebkdatetxt", query = "SELECT h FROM HKJH005Detail h WHERE h.nprebkdatetxt = :nprebkdatetxt")
    , @NamedQuery(name = "HKJH005Detail.findByOprebkdatetxt", query = "SELECT h FROM HKJH005Detail h WHERE h.oprebkdatetxt = :oprebkdatetxt")
    , @NamedQuery(name = "HKJH005Detail.findByBvarnr", query = "SELECT h FROM HKJH005Detail h WHERE h.bvarnr = :bvarnr")
    , @NamedQuery(name = "HKJH005Detail.findBySeq", query = "SELECT h FROM HKJH005Detail h WHERE h.seq = :seq")
    , @NamedQuery(name = "HKJH005Detail.findByItnbr", query = "SELECT h FROM HKJH005Detail h WHERE h.itnbr = :itnbr")
    , @NamedQuery(name = "HKJH005Detail.findByUnmsr1", query = "SELECT h FROM HKJH005Detail h WHERE h.unmsr1 = :unmsr1")
    , @NamedQuery(name = "HKJH005Detail.findByItdsc", query = "SELECT h FROM HKJH005Detail h WHERE h.itdsc = :itdsc")
    , @NamedQuery(name = "HKJH005Detail.findByBtrseq", query = "SELECT h FROM HKJH005Detail h WHERE h.btrseq = :btrseq")
    , @NamedQuery(name = "HKJH005Detail.findByBqty", query = "SELECT h FROM HKJH005Detail h WHERE h.bqty = :bqty")
    , @NamedQuery(name = "HKJH005Detail.findByFSN", query = "SELECT h FROM HKJH005Detail h WHERE h.formSerialNumber = :fsn")})
public class HKJH005Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 255)
    @Column(name = "Nprebkdate_txt")
    private String nprebkdatetxt;
    @Size(max = 255)
    @Column(name = "Oprebkdate_txt")
    private String oprebkdatetxt;
    @Size(max = 255)
    @Column(name = "bvarnr")
    private String bvarnr;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "btrseq")
    private String btrseq;
    @Size(max = 255)
    @Column(name = "bqty")
    private String bqty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJH005Detail() {
    }

    public HKJH005Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getNprebkdatetxt() {
        return nprebkdatetxt;
    }

    public void setNprebkdatetxt(String nprebkdatetxt) {
        this.nprebkdatetxt = nprebkdatetxt;
    }

    public String getOprebkdatetxt() {
        return oprebkdatetxt;
    }

    public void setOprebkdatetxt(String oprebkdatetxt) {
        this.oprebkdatetxt = oprebkdatetxt;
    }

    public String getBvarnr() {
        return bvarnr;
    }

    public void setBvarnr(String bvarnr) {
        this.bvarnr = bvarnr;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getBtrseq() {
        return btrseq;
    }

    public void setBtrseq(String btrseq) {
        this.btrseq = btrseq;
    }

    public String getBqty() {
        return bqty;
    }

    public void setBqty(String bqty) {
        this.bqty = bqty;
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
        if (!(object instanceof HKJH005Detail)) {
            return false;
        }
        HKJH005Detail other = (HKJH005Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH005Detail[ oid=" + oid + " ]";
    }
    
}
