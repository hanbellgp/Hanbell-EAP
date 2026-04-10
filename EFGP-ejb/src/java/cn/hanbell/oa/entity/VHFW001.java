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
 * @author ZFF
 */
@Entity
@Table(name = "VH_FW001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHFW001.findAll", query = "SELECT v FROM VHFW001 v"),
    @NamedQuery(name = "VHFW001.findByFacno", query = "SELECT v FROM VHFW001 v WHERE v.facno = :facno"),
    @NamedQuery(name = "VHFW001.findByPSN", query = "SELECT v FROM VHFW001 v WHERE v.processSerialNumber = :psn"),
    @NamedQuery(name = "VHFW001.findByItnbr", query = "SELECT v FROM VHFW001 v WHERE v.itnbr = :itnbr"),
    @NamedQuery(name = "VHFW001.findByTd001", query = "SELECT v FROM VHFW001 v WHERE v.td001 = :td001"),
    @NamedQuery(name = "VHFW001.findByTd002", query = "SELECT v FROM VHFW001 v WHERE v.td002 = :td002"),
    @NamedQuery(name = "VHFW001.findByTotal", query = "SELECT v FROM VHFW001 v WHERE v.total = :total"),
    @NamedQuery(name = "VHFW001.findByTd003", query = "SELECT v FROM VHFW001 v WHERE v.td003 = :td003"),
    @NamedQuery(name = "VHFW001.findByHdTrnno", query = "SELECT v FROM VHFW001 v WHERE v.hdTrnno = :hdTrnno"),
    @NamedQuery(name = "VHFW001.findByFSN", query = "SELECT v FROM VHFW001 v WHERE v.formSerialNumber = :fsn"),
    @NamedQuery(name = "VHFW001.findByMark", query = "SELECT v FROM VHFW001 v WHERE v.mark = :mark")})
public class VHFW001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "td001")
    private String td001;
    @Size(max = 255)
    @Column(name = "td002")
    private String td002;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Size(max = 255)
    @Column(name = "td003")
    private String td003;
    @Size(max = 255)
    @Column(name = "hdTrnno")
    private String hdTrnno;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "emply")
    private String emply;
    @Size(max = 255)
    @Column(name = "endtype")
    private String endtype;
    @Column(name = "ttotal")
    private Double ttotal;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "cooperateDept")
    private String cooperateDept;
    @Size(max = 255)
    @Column(name = "endyear")
    private String endyear;
    @Size(max = 255)
    @Column(name = "restxt")
    private String restxt;
    @Size(max = 255)
    @Column(name = "zrgs")
    private String zrgs;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Column(name = "Aprice")
    private Double aprice;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "trnno")
    private String trnno;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "qty")
    private Double qty;
    @Size(max = 255)
    @Column(name = "noreasno")
    private String noreasno;
    @Size(max = 255)
    @Column(name = "mark")
    private String mark;

    public VHFW001() {
    }

    public VHFW001(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getTd001() {
        return td001;
    }

    public void setTd001(String td001) {
        this.td001 = td001;
    }

    public String getTd002() {
        return td002;
    }

    public void setTd002(String td002) {
        this.td002 = td002;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTd003() {
        return td003;
    }

    public void setTd003(String td003) {
        this.td003 = td003;
    }

    public String getHdTrnno() {
        return hdTrnno;
    }

    public void setHdTrnno(String hdTrnno) {
        this.hdTrnno = hdTrnno;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getEmply() {
        return emply;
    }

    public void setEmply(String emply) {
        this.emply = emply;
    }

    public String getEndtype() {
        return endtype;
    }

    public void setEndtype(String endtype) {
        this.endtype = endtype;
    }

    public Double getTtotal() {
        return ttotal;
    }

    public void setTtotal(Double ttotal) {
        this.ttotal = ttotal;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCooperateDept() {
        return cooperateDept;
    }

    public void setCooperateDept(String cooperateDept) {
        this.cooperateDept = cooperateDept;
    }

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public String getRestxt() {
        return restxt;
    }

    public void setRestxt(String restxt) {
        this.restxt = restxt;
    }

    public String getZrgs() {
        return zrgs;
    }

    public void setZrgs(String zrgs) {
        this.zrgs = zrgs;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
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

    public String getTrnno() {
        return trnno;
    }

    public void setTrnno(String trnno) {
        this.trnno = trnno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getNoreasno() {
        return noreasno;
    }

    public void setNoreasno(String noreasno) {
        this.noreasno = noreasno;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
        if (!(object instanceof VHFW001)) {
            return false;
        }
        VHFW001 other = (VHFW001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHFW001[ oid=" + oid + " ]";
    }
    
}
