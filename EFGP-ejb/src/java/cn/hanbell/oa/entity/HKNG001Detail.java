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
@Table(name = "HK_NG001_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKNG001Detail.findAll", query = "SELECT h FROM HKNG001Detail h")
    , @NamedQuery(name = "HKNG001Detail.findBySupNo", query = "SELECT h FROM HKNG001Detail h WHERE h.supNo = :supNo")
    , @NamedQuery(name = "HKNG001Detail.findByOid", query = "SELECT h FROM HKNG001Detail h WHERE h.oid = :oid")
    , @NamedQuery(name = "HKNG001Detail.findBySupName", query = "SELECT h FROM HKNG001Detail h WHERE h.supName = :supName")
    , @NamedQuery(name = "HKNG001Detail.findByTotamts", query = "SELECT h FROM HKNG001Detail h WHERE h.totamts = :totamts")
    , @NamedQuery(name = "HKNG001Detail.findByItnbr", query = "SELECT h FROM HKNG001Detail h WHERE h.itnbr = :itnbr")
    , @NamedQuery(name = "HKNG001Detail.findByTotprice", query = "SELECT h FROM HKNG001Detail h WHERE h.totprice = :totprice")
    , @NamedQuery(name = "HKNG001Detail.findByEsdid", query = "SELECT h FROM HKNG001Detail h WHERE h.esdid = :esdid")
    , @NamedQuery(name = "HKNG001Detail.findByTaxrate", query = "SELECT h FROM HKNG001Detail h WHERE h.taxrate = :taxrate")
    , @NamedQuery(name = "HKNG001Detail.findByUnprice", query = "SELECT h FROM HKNG001Detail h WHERE h.unprice = :unprice")
    , @NamedQuery(name = "HKNG001Detail.findByPrePrqy", query = "SELECT h FROM HKNG001Detail h WHERE h.prePrqy = :prePrqy")
    , @NamedQuery(name = "HKNG001Detail.findByUnmsr", query = "SELECT h FROM HKNG001Detail h WHERE h.unmsr = :unmsr")
    , @NamedQuery(name = "HKNG001Detail.findByItdsc", query = "SELECT h FROM HKNG001Detail h WHERE h.itdsc = :itdsc")
    , @NamedQuery(name = "HKNG001Detail.findByBgSeq", query = "SELECT h FROM HKNG001Detail h WHERE h.bgSeq = :bgSeq")
    , @NamedQuery(name = "HKNG001Detail.findByFSN", query = "SELECT h FROM HKNG001Detail h WHERE h.formSerialNumber = :fsn")})
public class HKNG001Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "SupNo")
    private String supNo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "SupName")
    private String supName;
    @Size(max = 255)
    @Column(name = "Totamts")
    private String totamts;
    @Size(max = 255)
    @Column(name = "Itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "Totprice")
    private String totprice;
    @Size(max = 255)
    @Column(name = "ESDID")
    private String esdid;
    @Size(max = 255)
    @Column(name = "Taxrate")
    private String taxrate;
    @Size(max = 255)
    @Column(name = "Unprice")
    private String unprice;
    @Size(max = 255)
    @Column(name = "PrePrqy")
    private String prePrqy;
    @Size(max = 255)
    @Column(name = "Unmsr")
    private String unmsr;
    @Size(max = 255)
    @Column(name = "Itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "BgSeq")
    private String bgSeq;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKNG001Detail() {
    }

    public HKNG001Detail(String oid) {
        this.oid = oid;
    }

    public String getSupNo() {
        return supNo;
    }

    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getTotamts() {
        return totamts;
    }

    public void setTotamts(String totamts) {
        this.totamts = totamts;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getTotprice() {
        return totprice;
    }

    public void setTotprice(String totprice) {
        this.totprice = totprice;
    }

    public String getEsdid() {
        return esdid;
    }

    public void setEsdid(String esdid) {
        this.esdid = esdid;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getUnprice() {
        return unprice;
    }

    public void setUnprice(String unprice) {
        this.unprice = unprice;
    }

    public String getPrePrqy() {
        return prePrqy;
    }

    public void setPrePrqy(String prePrqy) {
        this.prePrqy = prePrqy;
    }

    public String getUnmsr() {
        return unmsr;
    }

    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getBgSeq() {
        return bgSeq;
    }

    public void setBgSeq(String bgSeq) {
        this.bgSeq = bgSeq;
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
        if (!(object instanceof HKNG001Detail)) {
            return false;
        }
        HKNG001Detail other = (HKNG001Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKNG001Detail[ oid=" + oid + " ]";
    }
    
}
