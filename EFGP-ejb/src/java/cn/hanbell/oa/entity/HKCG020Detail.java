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
@Table(name = "HK_CG020_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG020Detail.findAll", query = "SELECT h FROM HKCG020Detail h"),
    @NamedQuery(name = "HKCG020Detail.findByPriceChange", query = "SELECT h FROM HKCG020Detail h WHERE h.priceChange = :priceChange"),
    @NamedQuery(name = "HKCG020Detail.findByItdsc", query = "SELECT h FROM HKCG020Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKCG020Detail.findByApmunmsr", query = "SELECT h FROM HKCG020Detail h WHERE h.apmunmsr = :apmunmsr"),
    @NamedQuery(name = "HKCG020Detail.findByFormSerialNumber", query = "SELECT h FROM HKCG020Detail h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKCG020Detail.findByOldpri", query = "SELECT h FROM HKCG020Detail h WHERE h.oldpri = :oldpri"),
    @NamedQuery(name = "HKCG020Detail.findByOid", query = "SELECT h FROM HKCG020Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCG020Detail.findByUnpris", query = "SELECT h FROM HKCG020Detail h WHERE h.unpris = :unpris"),
    @NamedQuery(name = "HKCG020Detail.findByItnbr", query = "SELECT h FROM HKCG020Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKCG020Detail.findBySeq", query = "SELECT h FROM HKCG020Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCG020Detail.findByEcode", query = "SELECT h FROM HKCG020Detail h WHERE h.ecode = :ecode"),
    @NamedQuery(name = "HKCG020Detail.findBySpdsc", query = "SELECT h FROM HKCG020Detail h WHERE h.spdsc = :spdsc")})
public class HKCG020Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "priceChange")
    private String priceChange;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "apmunmsr")
    private String apmunmsr;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "oldpri")
    private String oldpri;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "unpris")
    private String unpris;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "ecode")
    private String ecode;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;

    public HKCG020Detail() {
    }

    public HKCG020Detail(String oid) {
        this.oid = oid;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getApmunmsr() {
        return apmunmsr;
    }

    public void setApmunmsr(String apmunmsr) {
        this.apmunmsr = apmunmsr;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOldpri() {
        return oldpri;
    }

    public void setOldpri(String oldpri) {
        this.oldpri = oldpri;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUnpris() {
        return unpris;
    }

    public void setUnpris(String unpris) {
        this.unpris = unpris;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
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
        if (!(object instanceof HKCG020Detail)) {
            return false;
        }
        HKCG020Detail other = (HKCG020Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG020Detail[ oid=" + oid + " ]";
    }
    
}
