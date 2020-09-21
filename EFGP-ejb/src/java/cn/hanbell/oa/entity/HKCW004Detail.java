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
@Table(name = "HK_CW004_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW004Detail.findAll", query = "SELECT h FROM HKCW004Detail h"),
    @NamedQuery(name = "HKCW004Detail.findByBibi", query = "SELECT h FROM HKCW004Detail h WHERE h.bibi = :bibi"),
    @NamedQuery(name = "HKCW004Detail.findByFSN", query = "SELECT h FROM HKCW004Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW004Detail.findByOID", query = "SELECT h FROM HKCW004Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW004Detail.findBySsje", query = "SELECT h FROM HKCW004Detail h WHERE h.ssje = :ssje"),
    @NamedQuery(name = "HKCW004Detail.findByYsje", query = "SELECT h FROM HKCW004Detail h WHERE h.ysje = :ysje"),
    @NamedQuery(name = "HKCW004Detail.findBySeq", query = "SELECT h FROM HKCW004Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCW004Detail.findByFphm", query = "SELECT h FROM HKCW004Detail h WHERE h.fphm = :fphm"),
    @NamedQuery(name = "HKCW004Detail.findByZy", query = "SELECT h FROM HKCW004Detail h WHERE h.zy = :zy")})
public class HKCW004Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "bibi")
    private String bibi;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ssje")
    private String ssje;
    @Size(max = 255)
    @Column(name = "ysje")
    private String ysje;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "fphm")
    private String fphm;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;

    public HKCW004Detail() {
    }

    public HKCW004Detail(String oid) {
        this.oid = oid;
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

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSsje() {
        return ssje;
    }

    public void setSsje(String ssje) {
        this.ssje = ssje;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
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
        if (!(object instanceof HKCW004Detail)) {
            return false;
        }
        HKCW004Detail other = (HKCW004Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW004Detail[ oid=" + oid + " ]";
    }
    
}
