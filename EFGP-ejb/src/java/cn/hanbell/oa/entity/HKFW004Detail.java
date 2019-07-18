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
@Table(name = "HK_FW004_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW004Detail.findAll", query = "SELECT h FROM HKFW004Detail h"),
    @NamedQuery(name = "HKFW004Detail.findByTotal", query = "SELECT h FROM HKFW004Detail h WHERE h.total = :total"),
    @NamedQuery(name = "HKFW004Detail.findByEndtype", query = "SELECT h FROM HKFW004Detail h WHERE h.endtype = :endtype"),
    @NamedQuery(name = "HKFW004Detail.findByOid", query = "SELECT h FROM HKFW004Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW004Detail.findByTrnno", query = "SELECT h FROM HKFW004Detail h WHERE h.trnno = :trnno"),
    @NamedQuery(name = "HKFW004Detail.findByNo", query = "SELECT h FROM HKFW004Detail h WHERE h.no = :no"),
    @NamedQuery(name = "HKFW004Detail.findByEndyear", query = "SELECT h FROM HKFW004Detail h WHERE h.endyear = :endyear"),
    @NamedQuery(name = "HKFW004Detail.findByCusna", query = "SELECT h FROM HKFW004Detail h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKFW004Detail.findByQty", query = "SELECT h FROM HKFW004Detail h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKFW004Detail.findByMark", query = "SELECT h FROM HKFW004Detail h WHERE h.mark = :mark"),
    @NamedQuery(name = "HKFW004Detail.findByRestxt", query = "SELECT h FROM HKFW004Detail h WHERE h.restxt = :restxt"),
    @NamedQuery(name = "HKFW004Detail.findByItdsc", query = "SELECT h FROM HKFW004Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW004Detail.findByZrgs", query = "SELECT h FROM HKFW004Detail h WHERE h.zrgs = :zrgs"),
    @NamedQuery(name = "HKFW004Detail.findByNoreasno", query = "SELECT h FROM HKFW004Detail h WHERE h.noreasno = :noreasno"),
    @NamedQuery(name = "HKFW004Detail.findByAprice", query = "SELECT h FROM HKFW004Detail h WHERE h.aprice = :aprice"),
    @NamedQuery(name = "HKFW004Detail.findByCusno", query = "SELECT h FROM HKFW004Detail h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKFW004Detail.findByItnbr", query = "SELECT h FROM HKFW004Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW004Detail.findByFSN", query = "SELECT h FROM HKFW004Detail h WHERE h.formSerialNumber = :fsn")})
public class HKFW004Detail implements Serializable {

    @Size(max = 255)
    @Column(name = "td003")
    private String td003;
    @Size(max = 255)
    @Column(name = "td002")
    private String td002;
    @Size(max = 255)
    @Column(name = "td001")
    private String td001;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "total")
    private String total;
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
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "endyear")
    private String endyear;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
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
    @Column(name = "zrgs")
    private String zrgs;
    @Size(max = 255)
    @Column(name = "noreasno")
    private String noreasno;
    @Size(max = 255)
    @Column(name = "Aprice")
    private String aprice;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKFW004Detail() {
    }

    public HKFW004Detail(String oid) {
        this.oid = oid;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
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

    public String getZrgs() {
        return zrgs;
    }

    public void setZrgs(String zrgs) {
        this.zrgs = zrgs;
    }

    public String getNoreasno() {
        return noreasno;
    }

    public void setNoreasno(String noreasno) {
        this.noreasno = noreasno;
    }

    public String getAprice() {
        return aprice;
    }

    public void setAprice(String aprice) {
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
        if (!(object instanceof HKFW004Detail)) {
            return false;
        }
        HKFW004Detail other = (HKFW004Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW004Detail[ oid=" + oid + " ]";
    }

    public String getTd003() {
        return td003;
    }

    public void setTd003(String td003) {
        this.td003 = td003;
    }

    public String getTd002() {
        return td002;
    }

    public void setTd002(String td002) {
        this.td002 = td002;
    }

    public String getTd001() {
        return td001;
    }

    public void setTd001(String td001) {
        this.td001 = td001;
    }
    
}
