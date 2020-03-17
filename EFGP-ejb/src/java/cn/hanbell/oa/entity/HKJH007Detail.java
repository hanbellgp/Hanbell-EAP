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
@Table(name = "HK_JH007_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH007Detail.findAll", query = "SELECT h FROM HKJH007Detail h"),
    @NamedQuery(name = "HKJH007Detail.findByOID", query = "SELECT h FROM HKJH007Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH007Detail.findByFSN", query = "SELECT h FROM HKJH007Detail h WHERE h.formSerialNumber = :fsn")})
public class HKJH007Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "infixnr")
    private String infixnr;
    @Size(max = 255)
    @Column(name = "outvarnr")
    private String outvarnr;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "borrowDate")
    private String borrowDate;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "returnDate")
    private String returnDate;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "invarnr")
    private String invarnr;
    @Size(max = 255)
    @Column(name = "outfixnr")
    private String outfixnr;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    public HKJH007Detail() {
    }

    public HKJH007Detail(String oid) {
        this.oid = oid;
    }

    public String getInfixnr() {
        return infixnr;
    }

    public void setInfixnr(String infixnr) {
        this.infixnr = infixnr;
    }

    public String getOutvarnr() {
        return outvarnr;
    }

    public void setOutvarnr(String outvarnr) {
        this.outvarnr = outvarnr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getInvarnr() {
        return invarnr;
    }

    public void setInvarnr(String invarnr) {
        this.invarnr = invarnr;
    }

    public String getOutfixnr() {
        return outfixnr;
    }

    public void setOutfixnr(String outfixnr) {
        this.outfixnr = outfixnr;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof HKJH007Detail)) {
            return false;
        }
        HKJH007Detail other = (HKJH007Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH007Detail[ oid=" + oid + " ]";
    }

}
