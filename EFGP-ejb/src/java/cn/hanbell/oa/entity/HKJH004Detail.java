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
@Table(name = "HK_JH004_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH004Detail.findAll", query = "SELECT h FROM HKJH004Detail h"),
    @NamedQuery(name = "HKJH004Detail.findByOID", query = "SELECT h FROM HKJH004Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH004Detail.findByVdrds", query = "SELECT h FROM HKJH004Detail h WHERE h.vdrds = :vdrds"),
    @NamedQuery(name = "HKJH004Detail.findByReason", query = "SELECT h FROM HKJH004Detail h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKJH004Detail.findBySeq", query = "SELECT h FROM HKJH004Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKJH004Detail.findByVdrna", query = "SELECT h FROM HKJH004Detail h WHERE h.vdrna = :vdrna"),
    @NamedQuery(name = "HKJH004Detail.findByVdrno", query = "SELECT h FROM HKJH004Detail h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HKJH004Detail.findByFSN", query = "SELECT h FROM HKJH004Detail h WHERE h.formSerialNumber = :fsn")})
public class HKJH004Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "vdrds")
    private String vdrds;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJH004Detail() {
    }

    public HKJH004Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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
        if (!(object instanceof HKJH004Detail)) {
            return false;
        }
        HKJH004Detail other = (HKJH004Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH004Detail[ oid=" + oid + " ]";
    }
    
}
