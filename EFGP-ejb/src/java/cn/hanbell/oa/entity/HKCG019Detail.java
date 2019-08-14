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
@Table(name = "HK_CG019_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG019Detail.findAll", query = "SELECT h FROM HKCG019Detail h"),
    @NamedQuery(name = "HKCG019Detail.findByTotamts", query = "SELECT h FROM HKCG019Detail h WHERE h.totamts = :totamts"),
    @NamedQuery(name = "HKCG019Detail.findByEsdid", query = "SELECT h FROM HKCG019Detail h WHERE h.esdid = :esdid"),
    @NamedQuery(name = "HKCG019Detail.findBySupName", query = "SELECT h FROM HKCG019Detail h WHERE h.supName = :supName"),
    @NamedQuery(name = "HKCG019Detail.findBySupNo", query = "SELECT h FROM HKCG019Detail h WHERE h.supNo = :supNo"),
    @NamedQuery(name = "HKCG019Detail.findByBgSeq", query = "SELECT h FROM HKCG019Detail h WHERE h.bgSeq = :bgSeq"),
    @NamedQuery(name = "HKCG019Detail.findByItnbr", query = "SELECT h FROM HKCG019Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKCG019Detail.findByTaxrate", query = "SELECT h FROM HKCG019Detail h WHERE h.taxrate = :taxrate"),
    @NamedQuery(name = "HKCG019Detail.findByOid", query = "SELECT h FROM HKCG019Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCG019Detail.findByUnmsr", query = "SELECT h FROM HKCG019Detail h WHERE h.unmsr = :unmsr"),
    @NamedQuery(name = "HKCG019Detail.findByItdsc", query = "SELECT h FROM HKCG019Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKCG019Detail.findByUnprice", query = "SELECT h FROM HKCG019Detail h WHERE h.unprice = :unprice"),
    @NamedQuery(name = "HKCG019Detail.findByTotprice", query = "SELECT h FROM HKCG019Detail h WHERE h.totprice = :totprice"),
    @NamedQuery(name = "HKCG019Detail.findByFormSerialNumber", query = "SELECT h FROM HKCG019Detail h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKCG019Detail.findByPrePrqy", query = "SELECT h FROM HKCG019Detail h WHERE h.prePrqy = :prePrqy"),
    @NamedQuery(name = "HKCG019Detail.findByTax", query = "SELECT h FROM HKCG019Detail h WHERE h.tax = :tax"),
    @NamedQuery(name = "HKCG019Detail.findByTaxamts", query = "SELECT h FROM HKCG019Detail h WHERE h.taxamts = :taxamts"),
    @NamedQuery(name = "HKCG019Detail.findByCoin", query = "SELECT h FROM HKCG019Detail h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKCG019Detail.findByPreMark", query = "SELECT h FROM HKCG019Detail h WHERE h.preMark = :preMark"),
    @NamedQuery(name = "HKCG019Detail.findByTramts", query = "SELECT h FROM HKCG019Detail h WHERE h.tramts = :tramts")})
public class HKCG019Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Totamts")
    private String totamts;
    @Size(max = 255)
    @Column(name = "ESDID")
    private String esdid;
    @Size(max = 255)
    @Column(name = "SupName")
    private String supName;
    @Size(max = 255)
    @Column(name = "SupNo")
    private String supNo;
    @Size(max = 255)
    @Column(name = "BgSeq")
    private String bgSeq;
    @Size(max = 255)
    @Column(name = "Itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "Taxrate")
    private String taxrate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "Unmsr")
    private String unmsr;
    @Size(max = 255)
    @Column(name = "Itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "Unprice")
    private String unprice;
    @Size(max = 255)
    @Column(name = "Totprice")
    private String totprice;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "PrePrqy")
    private String prePrqy;
    @Size(max = 255)
    @Column(name = "Tax")
    private String tax;
    @Size(max = 255)
    @Column(name = "Taxamts")
    private String taxamts;
    @Size(max = 255)
    @Column(name = "Coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "PreMark")
    private String preMark;
    @Size(max = 255)
    @Column(name = "Tramts")
    private String tramts;

    public HKCG019Detail() {
    }

    public HKCG019Detail(String oid) {
        this.oid = oid;
    }

    public String getTotamts() {
        return totamts;
    }

    public void setTotamts(String totamts) {
        this.totamts = totamts;
    }

    public String getEsdid() {
        return esdid;
    }

    public void setEsdid(String esdid) {
        this.esdid = esdid;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupNo() {
        return supNo;
    }

    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    public String getBgSeq() {
        return bgSeq;
    }

    public void setBgSeq(String bgSeq) {
        this.bgSeq = bgSeq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getUnprice() {
        return unprice;
    }

    public void setUnprice(String unprice) {
        this.unprice = unprice;
    }

    public String getTotprice() {
        return totprice;
    }

    public void setTotprice(String totprice) {
        this.totprice = totprice;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPrePrqy() {
        return prePrqy;
    }

    public void setPrePrqy(String prePrqy) {
        this.prePrqy = prePrqy;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxamts() {
        return taxamts;
    }

    public void setTaxamts(String taxamts) {
        this.taxamts = taxamts;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getPreMark() {
        return preMark;
    }

    public void setPreMark(String preMark) {
        this.preMark = preMark;
    }

    public String getTramts() {
        return tramts;
    }

    public void setTramts(String tramts) {
        this.tramts = tramts;
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
        if (!(object instanceof HKCG019Detail)) {
            return false;
        }
        HKCG019Detail other = (HKCG019Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG019Detail[ oid=" + oid + " ]";
    }

}
