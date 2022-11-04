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
@Table(name = "SHB_ERP_INV310_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV310Detail.findAll", query = "SELECT s FROM SHBERPINV310Detail s"),
    @NamedQuery(name = "SHBERPINV310Detail.findByWareh", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.wareh = :wareh"),
    @NamedQuery(name = "SHBERPINV310Detail.findByItdsc", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "SHBERPINV310Detail.findByUnmsr1", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.unmsr1 = :unmsr1"),
    @NamedQuery(name = "SHBERPINV310Detail.findByFixnr", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.fixnr = :fixnr"),
    @NamedQuery(name = "SHBERPINV310Detail.findByQty", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.qty = :qty"),
    @NamedQuery(name = "SHBERPINV310Detail.findByFSN", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPINV310Detail.findByOid", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPINV310Detail.findByItnbr", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPINV310Detail.findByManufacturingNo", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.manufacturingNo = :manufacturingNo"),
    @NamedQuery(name = "SHBERPINV310Detail.findBySeq", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.seq = :seq"),
    @NamedQuery(name = "SHBERPINV310Detail.findBySpdsc", query = "SELECT s FROM SHBERPINV310Detail s WHERE s.spdsc = :spdsc")})
public class SHBERPINV310Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
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
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "manufacturingNo")
    private String manufacturingNo;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;

    public SHBERPINV310Detail() {
    }

    public SHBERPINV310Detail(String oid) {
        this.oid = oid;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
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

    public String getManufacturingNo() {
        return manufacturingNo;
    }

    public void setManufacturingNo(String manufacturingNo) {
        this.manufacturingNo = manufacturingNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof SHBERPINV310Detail)) {
            return false;
        }
        SHBERPINV310Detail other = (SHBERPINV310Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV310Detail[ oid=" + oid + " ]";
    }
    
}
