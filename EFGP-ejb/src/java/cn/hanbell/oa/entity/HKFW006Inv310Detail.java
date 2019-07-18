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
@Table(name = "HK_FW006_INV310_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW006Inv310Detail.findAll", query = "SELECT h FROM HKFW006Inv310Detail h"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByOid", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByUnit", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByNum", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.num = :num"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByWareh", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.wareh = :wareh"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByVarnr", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.varnr = :varnr"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByWhdsc", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.whdsc = :whdsc"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByItnbr", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByItdsc", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByFSN", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKFW006Inv310Detail.findByTrseq", query = "SELECT h FROM HKFW006Inv310Detail h WHERE h.trseq = :trseq")})
public class HKFW006Inv310Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "num")
    private String num;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;

    public HKFW006Inv310Detail() {
    }

    public HKFW006Inv310Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
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
        if (!(object instanceof HKFW006Inv310Detail)) {
            return false;
        }
        HKFW006Inv310Detail other = (HKFW006Inv310Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW006Inv310Detail[ oid=" + oid + " ]";
    }
    
}
