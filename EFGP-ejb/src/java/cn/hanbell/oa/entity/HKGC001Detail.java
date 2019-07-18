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
 * @author C0160
 */
@Entity
@Table(name = "HK_GC001_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGC001Detail.findAll", query = "SELECT h FROM HKGC001Detail h"),
    @NamedQuery(name = "HKGC001Detail.findByOID", query = "SELECT h FROM HKGC001Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGC001Detail.findByFSN", query = "SELECT h FROM HKGC001Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGC001Detail.findByFSNAndPurchase", query = "SELECT h FROM HKGC001Detail h WHERE h.formSerialNumber = :fsn AND h.purchasehelp =:purchase")})
public class HKGC001Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "purchasehelp")
    private String purchasehelp;
    @Size(max = 255)
    @Column(name = "itnbrf")
    private String itnbrf;
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
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "wareh2")
    private String wareh2;
    @Size(max = 255)
    @Column(name = "itnbrname")
    private String itnbrname;
    @Size(max = 255)
    @Column(name = "whdsc2")
    private String whdsc2;
    @Size(max = 255)
    @Column(name = "needdate")
    private String needdate;
    @Size(max = 255)
    @Column(name = "mancode")
    private String mancode;
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
    @Column(name = "manname")
    private String manname;
    @Size(max = 255)
    @Column(name = "finishdate")
    private String finishdate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "transno")
    private String transno;

    public HKGC001Detail() {
    }

    public HKGC001Detail(String oid) {
        this.oid = oid;
    }

    public String getPurchasehelp() {
        return purchasehelp;
    }

    public void setPurchasehelp(String purchasehelp) {
        this.purchasehelp = purchasehelp;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
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

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getWareh2() {
        return wareh2;
    }

    public void setWareh2(String wareh2) {
        this.wareh2 = wareh2;
    }

    public String getItnbrname() {
        return itnbrname;
    }

    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    public String getWhdsc2() {
        return whdsc2;
    }

    public void setWhdsc2(String whdsc2) {
        this.whdsc2 = whdsc2;
    }

    public String getNeeddate() {
        return needdate;
    }

    public void setNeeddate(String needdate) {
        this.needdate = needdate;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
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

    public String getManname() {
        return manname;
    }

    public void setManname(String manname) {
        this.manname = manname;
    }

    public String getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
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
        if (!(object instanceof HKGC001Detail)) {
            return false;
        }
        HKGC001Detail other = (HKGC001Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGC001Detail[ oid=" + oid + " ]";
    }

    /**
     * @return the transno
     */
    public String getTransno() {
        return transno;
    }

    /**
     * @param transno the transno to set
     */
    public void setTransno(String transno) {
        this.transno = transno;
    }

}
