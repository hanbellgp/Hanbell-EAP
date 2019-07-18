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
@Table(name = "HK_FW006_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW006Detail.findAll", query = "SELECT h FROM HKFW006Detail h"),
    @NamedQuery(name = "HKFW006Detail.findByRecqty", query = "SELECT h FROM HKFW006Detail h WHERE h.recqty = :recqty"),
    @NamedQuery(name = "HKFW006Detail.findByOid", query = "SELECT h FROM HKFW006Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW006Detail.findByUnit", query = "SELECT h FROM HKFW006Detail h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKFW006Detail.findByRecitdsc", query = "SELECT h FROM HKFW006Detail h WHERE h.recitdsc = :recitdsc"),
    @NamedQuery(name = "HKFW006Detail.findByNo", query = "SELECT h FROM HKFW006Detail h WHERE h.no = :no"),
    @NamedQuery(name = "HKFW006Detail.findByRecitnbr", query = "SELECT h FROM HKFW006Detail h WHERE h.recitnbr = :recitnbr"),
    @NamedQuery(name = "HKFW006Detail.findByShpno", query = "SELECT h FROM HKFW006Detail h WHERE h.shpno = :shpno"),
    @NamedQuery(name = "HKFW006Detail.findByRetitnbr", query = "SELECT h FROM HKFW006Detail h WHERE h.retitnbr = :retitnbr"),
    @NamedQuery(name = "HKFW006Detail.findByRetqty", query = "SELECT h FROM HKFW006Detail h WHERE h.retqty = :retqty"),
    @NamedQuery(name = "HKFW006Detail.findByFSN", query = "SELECT h FROM HKFW006Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKFW006Detail.findByRetitdsc", query = "SELECT h FROM HKFW006Detail h WHERE h.retitdsc = :retitdsc"),
    @NamedQuery(name = "HKFW006Detail.findByYyjb", query = "SELECT h FROM HKFW006Detail h WHERE h.yyjb = :yyjb"),
    @NamedQuery(name = "HKFW006Detail.findByTklx", query = "SELECT h FROM HKFW006Detail h WHERE h.tklx = :tklx"),
    @NamedQuery(name = "HKFW006Detail.findByYymark", query = "SELECT h FROM HKFW006Detail h WHERE h.yymark = :yymark"),
    @NamedQuery(name = "HKFW006Detail.findByDhno", query = "SELECT h FROM HKFW006Detail h WHERE h.dhno = :dhno")})
public class HKFW006Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "recqty")
    private String recqty;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "recitdsc")
    private String recitdsc;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "recitnbr")
    private String recitnbr;
    @Size(max = 255)
    @Column(name = "shpno")
    private String shpno;
    @Size(max = 255)
    @Column(name = "retitnbr")
    private String retitnbr;
    @Size(max = 255)
    @Column(name = "retqty")
    private String retqty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "retitdsc")
    private String retitdsc;
    @Size(max = 255)
    @Column(name = "yyjb")
    private String yyjb;
    @Size(max = 255)
    @Column(name = "tklx")
    private String tklx;
    @Size(max = 255)
    @Column(name = "yymark")
    private String yymark;
    @Size(max = 255)
    @Column(name = "dhno")
    private String dhno;
    @Size(max = 255)
    @Column(name = "hdTD003")
    private String hdTD003;

    public HKFW006Detail() {
    }

    public HKFW006Detail(String oid) {
        this.oid = oid;
    }

    public String getRecqty() {
        return recqty;
    }

    public void setRecqty(String recqty) {
        this.recqty = recqty;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRecitdsc() {
        return recitdsc;
    }

    public void setRecitdsc(String recitdsc) {
        this.recitdsc = recitdsc;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRecitnbr() {
        return recitnbr;
    }

    public void setRecitnbr(String recitnbr) {
        this.recitnbr = recitnbr;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public String getRetitnbr() {
        return retitnbr;
    }

    public void setRetitnbr(String retitnbr) {
        this.retitnbr = retitnbr;
    }

    public String getRetqty() {
        return retqty;
    }

    public void setRetqty(String retqty) {
        this.retqty = retqty;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getRetitdsc() {
        return retitdsc;
    }

    public void setRetitdsc(String retitdsc) {
        this.retitdsc = retitdsc;
    }

    public String getYyjb() {
        return yyjb;
    }

    public void setYyjb(String yyjb) {
        this.yyjb = yyjb;
    }

    public String getTklx() {
        return tklx;
    }

    public void setTklx(String tklx) {
        this.tklx = tklx;
    }

    public String getYymark() {
        return yymark;
    }

    public void setYymark(String yymark) {
        this.yymark = yymark;
    }

    public String getDhno() {
        return dhno;
    }

    public void setDhno(String dhno) {
        this.dhno = dhno;
    }

    public String getHdTD003() {
        return hdTD003;
    }

    public void setHdTD003(String hdTD003) {
        this.hdTD003 = hdTD003;
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
        if (!(object instanceof HKFW006Detail)) {
            return false;
        }
        HKFW006Detail other = (HKFW006Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW006Detail[ oid=" + oid + " ]";
    }

}
