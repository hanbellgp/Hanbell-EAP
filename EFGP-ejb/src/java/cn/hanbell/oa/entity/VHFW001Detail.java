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
 * @author ZFF
 */
@Entity
@Table(name = "VH_FW001_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHFW001Detail.findAll", query = "SELECT v FROM VHFW001Detail v"),
    @NamedQuery(name = "VHFW001Detail.findByAprice", query = "SELECT v FROM VHFW001Detail v WHERE v.aprice = :aprice"),
    @NamedQuery(name = "VHFW001Detail.findByVarnr", query = "SELECT v FROM VHFW001Detail v WHERE v.varnr = :varnr"),
    @NamedQuery(name = "VHFW001Detail.findByCusno", query = "SELECT v FROM VHFW001Detail v WHERE v.cusno = :cusno"),
    @NamedQuery(name = "VHFW001Detail.findByTrnno", query = "SELECT v FROM VHFW001Detail v WHERE v.trnno = :trnno"),
    @NamedQuery(name = "VHFW001Detail.findByOid", query = "SELECT v FROM VHFW001Detail v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHFW001Detail.findByItnbr", query = "SELECT v FROM VHFW001Detail v WHERE v.itnbr = :itnbr"),
    @NamedQuery(name = "VHFW001Detail.findBySerialNo", query = "SELECT v FROM VHFW001Detail v WHERE v.serialNo = :serialNo"),
    @NamedQuery(name = "VHFW001Detail.findByTd001", query = "SELECT v FROM VHFW001Detail v WHERE v.td001 = :td001"),
    @NamedQuery(name = "VHFW001Detail.findByTd002", query = "SELECT v FROM VHFW001Detail v WHERE v.td002 = :td002"),
    @NamedQuery(name = "VHFW001Detail.findByTotal", query = "SELECT v FROM VHFW001Detail v WHERE v.total = :total"),
    @NamedQuery(name = "VHFW001Detail.findByTd003", query = "SELECT v FROM VHFW001Detail v WHERE v.td003 = :td003"),
    @NamedQuery(name = "VHFW001Detail.findByItdsc", query = "SELECT v FROM VHFW001Detail v WHERE v.itdsc = :itdsc"),
    @NamedQuery(name = "VHFW001Detail.findByEndtype", query = "SELECT v FROM VHFW001Detail v WHERE v.endtype = :endtype"),
    @NamedQuery(name = "VHFW001Detail.findByQty", query = "SELECT v FROM VHFW001Detail v WHERE v.qty = :qty"),
    @NamedQuery(name = "VHFW001Detail.findByFSN", query = "SELECT v FROM VHFW001Detail v WHERE v.formSerialNumber = :fsn"),
    @NamedQuery(name = "VHFW001Detail.findByCusna", query = "SELECT v FROM VHFW001Detail v WHERE v.cusna = :cusna"),
    @NamedQuery(name = "VHFW001Detail.findByMark", query = "SELECT v FROM VHFW001Detail v WHERE v.mark = :mark")})
public class VHFW001Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Aprice")
    private String aprice;
    @Size(max = 255)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "trnno")
    private String trnno;
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
    @Column(name = "serialNo")
    private String serialNo;
    @Size(max = 255)
    @Column(name = "td001")
    private String td001;
    @Size(max = 255)
    @Column(name = "td002")
    private String td002;
    @Size(max = 255)
    @Column(name = "total")
    private String total;
    @Size(max = 255)
    @Column(name = "td003")
    private String td003;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "endtype")
    private String endtype;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "endyear")
    private String endyear;
    @Size(max = 255)
    @Column(name = "noreasno")
    private String noreasno;
    @Size(max = 255)
    @Column(name = "restxt")
    private String restxt;
    @Size(max = 255)
    @Column(name = "zrgs")
    private String zrgs;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "mark")
    private String mark;

    public VHFW001Detail() {
    }

    public VHFW001Detail(String oid) {
        this.oid = oid;
    }

    public String getAprice() {
        return aprice;
    }

    public void setAprice(String aprice) {
        this.aprice = aprice;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTd003() {
        return td003;
    }

    public void setTd003(String td003) {
        this.td003 = td003;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getEndtype() {
        return endtype;
    }

    public void setEndtype(String endtype) {
        this.endtype = endtype;
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

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public String getNoreasno() {
        return noreasno;
    }

    public void setNoreasno(String noreasno) {
        this.noreasno = noreasno;
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
        if (!(object instanceof VHFW001Detail)) {
            return false;
        }
        VHFW001Detail other = (VHFW001Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHFW001Detail[ oid=" + oid + " ]";
    }
    
}
