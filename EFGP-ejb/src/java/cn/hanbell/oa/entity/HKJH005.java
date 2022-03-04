/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "HK_JH005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH005.findAll", query = "SELECT h FROM HKJH005 h"),
    @NamedQuery(name = "HKJH005.findByOID", query = "SELECT h FROM HKJH005 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH005.findByRemark", query = "SELECT h FROM HKJH005 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HKJH005.findByItnbr", query = "SELECT h FROM HKJH005 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKJH005.findByPSN", query = "SELECT h FROM HKJH005 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJH005.findByBtrseq", query = "SELECT h FROM HKJH005 h WHERE h.btrseq = :btrseq"),
    @NamedQuery(name = "HKJH005.findByNprebkdate", query = "SELECT h FROM HKJH005 h WHERE h.nprebkdate = :nprebkdate"),
    @NamedQuery(name = "HKJH005.findByApplydate", query = "SELECT h FROM HKJH005 h WHERE h.applydate = :applydate"),
    @NamedQuery(name = "HKJH005.findByBvarnr", query = "SELECT h FROM HKJH005 h WHERE h.bvarnr = :bvarnr"),
    @NamedQuery(name = "HKJH005.findByCusna", query = "SELECT h FROM HKJH005 h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKJH005.findByItdsc", query = "SELECT h FROM HKJH005 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKJH005.findByUnmsr1", query = "SELECT h FROM HKJH005 h WHERE h.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HKJH005.findByBqty", query = "SELECT h FROM HKJH005 h WHERE h.bqty = :bqty"),
    @NamedQuery(name = "HKJH005.findByCategory", query = "SELECT h FROM HKJH005 h WHERE h.category = :category"),
    @NamedQuery(name = "HKJH005.findByCdrtractno", query = "SELECT h FROM HKJH005 h WHERE h.cdrtractno = :cdrtractno"),
    @NamedQuery(name = "HKJH005.findByFSN", query = "SELECT h FROM HKJH005 h WHERE h.formSerialNumber = :fsn")})
public class HKJH005 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Oprebkdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oprebkdate;
    @Size(max = 255)
    @Column(name = "hdcdrlnhad")
    private String hdcdrlnhad;
    @Size(max = 255)
    @Column(name = "fixnr")
    private String fixnr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "btrno")
    private String btrno;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "isspecial")
    private String isspecial;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "btrseq")
    private String btrseq;
    @Column(name = "Nprebkdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nprebkdate;
    @Column(name = "applydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydate;
    @Size(max = 255)
    @Column(name = "bvarnr")
    private String bvarnr;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "bqty")
    private String bqty;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Size(max = 255)
    @Column(name = "cdrtractno")
    private String cdrtractno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJH005() {
    }

    public HKJH005(String oid) {
        this.oid = oid;
    }

    public Date getOprebkdate() {
        return oprebkdate;
    }

    public void setOprebkdate(Date oprebkdate) {
        this.oprebkdate = oprebkdate;
    }

    public String getHdcdrlnhad() {
        return hdcdrlnhad;
    }

    public void setHdcdrlnhad(String hdcdrlnhad) {
        this.hdcdrlnhad = hdcdrlnhad;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBtrno() {
        return btrno;
    }

    public void setBtrno(String btrno) {
        this.btrno = btrno;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(String isspecial) {
        this.isspecial = isspecial;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getBtrseq() {
        return btrseq;
    }

    public void setBtrseq(String btrseq) {
        this.btrseq = btrseq;
    }

    public Date getNprebkdate() {
        return nprebkdate;
    }

    public void setNprebkdate(Date nprebkdate) {
        this.nprebkdate = nprebkdate;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getBvarnr() {
        return bvarnr;
    }

    public void setBvarnr(String bvarnr) {
        this.bvarnr = bvarnr;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
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

    public String getBqty() {
        return bqty;
    }

    public void setBqty(String bqty) {
        this.bqty = bqty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCdrtractno() {
        return cdrtractno;
    }

    public void setCdrtractno(String cdrtractno) {
        this.cdrtractno = cdrtractno;
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
        if (!(object instanceof HKJH005)) {
            return false;
        }
        HKJH005 other = (HKJH005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH005[ oid=" + oid + " ]";
    }

}
