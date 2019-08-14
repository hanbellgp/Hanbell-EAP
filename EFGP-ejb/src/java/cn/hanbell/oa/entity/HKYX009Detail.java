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
@Table(name = "HK_YX009_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX009Detail.findAll", query = "SELECT h FROM HKYX009Detail h"),
    @NamedQuery(name = "HKYX009Detail.findByOid", query = "SELECT h FROM HKYX009Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKYX009Detail.findByItnbrcus", query = "SELECT h FROM HKYX009Detail h WHERE h.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "HKYX009Detail.findByRefmodel", query = "SELECT h FROM HKYX009Detail h WHERE h.refmodel = :refmodel"),
    @NamedQuery(name = "HKYX009Detail.findByItdsc", query = "SELECT h FROM HKYX009Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKYX009Detail.findByUnpris", query = "SELECT h FROM HKYX009Detail h WHERE h.unpris = :unpris"),
    @NamedQuery(name = "HKYX009Detail.findByDiffitting", query = "SELECT h FROM HKYX009Detail h WHERE h.diffitting = :diffitting"),
    @NamedQuery(name = "HKYX009Detail.findByOrderqty", query = "SELECT h FROM HKYX009Detail h WHERE h.orderqty = :orderqty"),
    @NamedQuery(name = "HKYX009Detail.findBySeq", query = "SELECT h FROM HKYX009Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKYX009Detail.findByTramts", query = "SELECT h FROM HKYX009Detail h WHERE h.tramts = :tramts"),
    @NamedQuery(name = "HKYX009Detail.findByPeratio", query = "SELECT h FROM HKYX009Detail h WHERE h.peratio = :peratio"),
    @NamedQuery(name = "HKYX009Detail.findByItnbr", query = "SELECT h FROM HKYX009Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKYX009Detail.findByRefratio", query = "SELECT h FROM HKYX009Detail h WHERE h.refratio = :refratio"),
    @NamedQuery(name = "HKYX009Detail.findByTrseq", query = "SELECT h FROM HKYX009Detail h WHERE h.trseq = :trseq"),
    @NamedQuery(name = "HKYX009Detail.findByQuaqy1", query = "SELECT h FROM HKYX009Detail h WHERE h.quaqy1 = :quaqy1"),
    @NamedQuery(name = "HKYX009Detail.findByFSN", query = "SELECT h FROM HKYX009Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKYX009Detail.findByLastunpri", query = "SELECT h FROM HKYX009Detail h WHERE h.lastunpri = :lastunpri")})
public class HKYX009Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Size(max = 255)
    @Column(name = "refmodel")
    private String refmodel;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unpris")
    private String unpris;
    @Size(max = 255)
    @Column(name = "diffitting")
    private String diffitting;
    @Size(max = 255)
    @Column(name = "orderqty")
    private String orderqty;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "tramts")
    private String tramts;
    @Size(max = 255)
    @Column(name = "peratio")
    private String peratio;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "refratio")
    private String refratio;
    @Column(name = "cdrdate_txt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdrdate;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;
    @Size(max = 255)
    @Column(name = "quaqy1")
    private String quaqy1;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "lastunpri")
    private String lastunpri;

    public HKYX009Detail() {
    }

    public HKYX009Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public String getRefmodel() {
        return refmodel;
    }

    public void setRefmodel(String refmodel) {
        this.refmodel = refmodel;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getUnpris() {
        return unpris;
    }

    public void setUnpris(String unpris) {
        this.unpris = unpris;
    }

    public String getDiffitting() {
        return diffitting;
    }

    public void setDiffitting(String diffitting) {
        this.diffitting = diffitting;
    }

    public String getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(String orderqty) {
        this.orderqty = orderqty;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTramts() {
        return tramts;
    }

    public void setTramts(String tramts) {
        this.tramts = tramts;
    }

    public String getPeratio() {
        return peratio;
    }

    public void setPeratio(String peratio) {
        this.peratio = peratio;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getRefratio() {
        return refratio;
    }

    public void setRefratio(String refratio) {
        this.refratio = refratio;
    }

    public Date getCdrdate() {
        return cdrdate;
    }

    public void setCdrdate(Date cdrdate) {
        this.cdrdate = cdrdate;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public String getQuaqy1() {
        return quaqy1;
    }

    public void setQuaqy1(String quaqy1) {
        this.quaqy1 = quaqy1;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getLastunpri() {
        return lastunpri;
    }

    public void setLastunpri(String lastunpri) {
        this.lastunpri = lastunpri;
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
        if (!(object instanceof HKYX009Detail)) {
            return false;
        }
        HKYX009Detail other = (HKYX009Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX009Detail[ oid=" + oid + " ]";
    }

}
