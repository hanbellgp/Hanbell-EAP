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
 * @author C1749
 */
@Entity
@Table(name = "HK_JH003_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH003Detail.findAll", query = "SELECT h FROM HKJH003Detail h"),
    @NamedQuery(name = "HKJH003Detail.findByOID", query = "SELECT h FROM HKJH003Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH003Detail.findByReason", query = "SELECT h FROM HKJH003Detail h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKJH003Detail.findByCusds", query = "SELECT h FROM HKJH003Detail h WHERE h.cusds = :cusds"),
    @NamedQuery(name = "HKJH003Detail.findBySeq", query = "SELECT h FROM HKJH003Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKJH003Detail.findByCusna", query = "SELECT h FROM HKJH003Detail h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKJH003Detail.findByCusno", query = "SELECT h FROM HKJH003Detail h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKJH003Detail.findByFSN", query = "SELECT h FROM HKJH003Detail h WHERE h.formSerialNumber = :fsn")})
public class HKJH003Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJH003Detail() {
    }

    public HKJH003Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
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
        if (!(object instanceof HKJH003Detail)) {
            return false;
        }
        HKJH003Detail other = (HKJH003Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH003Detail[ oid=" + oid + " ]";
    }

}
