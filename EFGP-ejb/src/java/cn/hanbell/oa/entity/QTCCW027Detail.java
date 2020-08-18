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
 * @author C2082
 */
@Entity
@Table(name = "QTC_CW027_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QTCCW027Detail.findAll", query = "SELECT q FROM QTCCW027Detail q"),
    @NamedQuery(name = "QTCCW027Detail.findByFphm", query = "SELECT q FROM QTCCW027Detail q WHERE q.fphm = :fphm"),
    @NamedQuery(name = "QTCCW027Detail.findByOid", query = "SELECT q FROM QTCCW027Detail q WHERE q.oid = :oid"),
    @NamedQuery(name = "QTCCW027Detail.findByZy", query = "SELECT q FROM QTCCW027Detail q WHERE q.zy = :zy"),
    @NamedQuery(name = "QTCCW027Detail.findByYsje", query = "SELECT q FROM QTCCW027Detail q WHERE q.ysje = :ysje"),
    @NamedQuery(name = "QTCCW027Detail.findBySsje", query = "SELECT q FROM QTCCW027Detail q WHERE q.ssje = :ssje"),
    @NamedQuery(name = "QTCCW027Detail.findBySeq", query = "SELECT q FROM QTCCW027Detail q WHERE q.seq = :seq"),
    @NamedQuery(name = "QTCCW027Detail.findByBibi", query = "SELECT q FROM QTCCW027Detail q WHERE q.bibi = :bibi"),
    @NamedQuery(name = "QTCCW027Detail.findByFSN", query = "SELECT q FROM QTCCW027Detail q WHERE q.formSerialNumber = :fsn")})
public class QTCCW027Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "fphm")
    private String fphm;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    @Size(max = 255)
    @Column(name = "ysje")
    private String ysje;
    @Size(max = 255)
    @Column(name = "ssje")
    private String ssje;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "bibi")
    private String bibi;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public QTCCW027Detail() {
    }

    public QTCCW027Detail(String oid) {
        this.oid = oid;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getSsje() {
        return ssje;
    }

    public void setSsje(String ssje) {
        this.ssje = ssje;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
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
        if (!(object instanceof QTCCW027Detail)) {
            return false;
        }
        QTCCW027Detail other = (QTCCW027Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.QTCCW027Detail[ oid=" + oid + " ]";
    }
    
}
