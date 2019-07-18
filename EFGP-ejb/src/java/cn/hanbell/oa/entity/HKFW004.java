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
@Table(name = "HK_FW004")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW004.findAll", query = "SELECT h FROM HKFW004 h"),
    @NamedQuery(name = "HKFW004.findByTotal", query = "SELECT h FROM HKFW004 h WHERE h.total = :total"),
    @NamedQuery(name = "HKFW004.findByEndtype", query = "SELECT h FROM HKFW004 h WHERE h.endtype = :endtype"),
    @NamedQuery(name = "HKFW004.findByOid", query = "SELECT h FROM HKFW004 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW004.findByTrnno", query = "SELECT h FROM HKFW004 h WHERE h.trnno = :trnno"),
    @NamedQuery(name = "HKFW004.findByEndyear", query = "SELECT h FROM HKFW004 h WHERE h.endyear = :endyear"),
    @NamedQuery(name = "HKFW004.findByCusna", query = "SELECT h FROM HKFW004 h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKFW004.findByQty", query = "SELECT h FROM HKFW004 h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKFW004.findByMark", query = "SELECT h FROM HKFW004 h WHERE h.mark = :mark"),
    @NamedQuery(name = "HKFW004.findByRestxt", query = "SELECT h FROM HKFW004 h WHERE h.restxt = :restxt"),
    @NamedQuery(name = "HKFW004.findByItdsc", query = "SELECT h FROM HKFW004 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW004.findByFacno", query = "SELECT h FROM HKFW004 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKFW004.findByEmply", query = "SELECT h FROM HKFW004 h WHERE h.emply = :emply"),
    @NamedQuery(name = "HKFW004.findByZrgs", query = "SELECT h FROM HKFW004 h WHERE h.zrgs = :zrgs"),
    @NamedQuery(name = "HKFW004.findByTtotal", query = "SELECT h FROM HKFW004 h WHERE h.ttotal = :ttotal"),
    @NamedQuery(name = "HKFW004.findByNoreasno", query = "SELECT h FROM HKFW004 h WHERE h.noreasno = :noreasno"),
    @NamedQuery(name = "HKFW004.findByAprice", query = "SELECT h FROM HKFW004 h WHERE h.aprice = :aprice"),
    @NamedQuery(name = "HKFW004.findByCusno", query = "SELECT h FROM HKFW004 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKFW004.findByItnbr", query = "SELECT h FROM HKFW004 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW004.findByDept", query = "SELECT h FROM HKFW004 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKFW004.findByPSN", query = "SELECT h FROM HKFW004 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKFW004.findByEnddate", query = "SELECT h FROM HKFW004 h WHERE h.enddate = :enddate"),
    @NamedQuery(name = "HKFW004.findByFSN", query = "SELECT h FROM HKFW004 h WHERE h.formSerialNumber = :fsn")})
public class HKFW004 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Size(max = 255)
    @Column(name = "endtype")
    private String endtype;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "trnno")
    private String trnno;
    @Size(max = 255)
    @Column(name = "endyear")
    private String endyear;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Column(name = "qty")
    private Double qty;
    @Size(max = 255)
    @Column(name = "mark")
    private String mark;
    @Size(max = 255)
    @Column(name = "restxt")
    private String restxt;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "emply")
    private String emply;
    @Size(max = 255)
    @Column(name = "zrgs")
    private String zrgs;
    @Column(name = "ttotal")
    private Double ttotal;
    @Size(max = 255)
    @Column(name = "noreasno")
    private String noreasno;
    @Column(name = "Aprice")
    private Double aprice;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKFW004() {
    }

    public HKFW004(String oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEndtype() {
        return endtype;
    }

    public void setEndtype(String endtype) {
        this.endtype = endtype;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTrnno() {
        return trnno;
    }

    public void setTrnno(String trnno) {
        this.trnno = trnno;
    }

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getRestxt() {
        return restxt;
    }

    public void setRestxt(String restxt) {
        this.restxt = restxt;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getEmply() {
        return emply;
    }

    public void setEmply(String emply) {
        this.emply = emply;
    }

    public String getZrgs() {
        return zrgs;
    }

    public void setZrgs(String zrgs) {
        this.zrgs = zrgs;
    }

    public Double getTtotal() {
        return ttotal;
    }

    public void setTtotal(Double ttotal) {
        this.ttotal = ttotal;
    }

    public String getNoreasno() {
        return noreasno;
    }

    public void setNoreasno(String noreasno) {
        this.noreasno = noreasno;
    }

    public Double getAprice() {
        return aprice;
    }

    public void setAprice(Double aprice) {
        this.aprice = aprice;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
        if (!(object instanceof HKFW004)) {
            return false;
        }
        HKFW004 other = (HKFW004) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW004[ oid=" + oid + " ]";
    }
    
}
