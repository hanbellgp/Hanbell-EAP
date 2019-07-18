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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "HK_GC003_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGC003Detail.findAll", query = "SELECT h FROM HKGC003Detail h"),
    @NamedQuery(name = "HKGC003Detail.findByOID", query = "SELECT h FROM HKGC003Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGC003Detail.findByFSN", query = "SELECT h FROM HKGC003Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGC003Detail.findBySrcOID", query = "SELECT h FROM HKGC003Detail h WHERE h.srcOID = :srcOID")
})
public class HKGC003Detail implements Serializable {

    @JoinColumn(name = "formSerialNumber", referencedColumnName = "formSerialNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HKGC003 parent;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Size(max = 255)
    @Column(name = "srcOID")
    private String srcOID;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "finqty")
    private String finqty;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "itnbrname")
    private String itnbrname;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "itnbrfname")
    private String itnbrfname;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "stockqty")
    private String stockqty;
    @Size(max = 255)
    @Column(name = "stockDate")
    private String stockDate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKGC003Detail() {
    }

    public HKGC003Detail(String oid) {
        this.oid = oid;
    }

    /**
     * @return the parent
     */
    public HKGC003 getParent() {
        return parent;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getSrcOID() {
        return srcOID;
    }

    public void setSrcOID(String srcOID) {
        this.srcOID = srcOID;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFinqty() {
        return finqty;
    }

    public void setFinqty(String finqty) {
        this.finqty = finqty;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getItnbrname() {
        return itnbrname;
    }

    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getItnbrfname() {
        return itnbrfname;
    }

    public void setItnbrfname(String itnbrfname) {
        this.itnbrfname = itnbrfname;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getStockqty() {
        return stockqty;
    }

    public void setStockqty(String stockqty) {
        this.stockqty = stockqty;
    }

    public String getStockDate() {
        return stockDate;
    }

    public void setStockDate(String stockDate) {
        this.stockDate = stockDate;
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
        if (!(object instanceof HKGC003Detail)) {
            return false;
        }
        HKGC003Detail other = (HKGC003Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGC003Detail[ oid=" + oid + " ]";
    }

}
