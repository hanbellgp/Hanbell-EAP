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
@Table(name = "VH_TV006_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV006Detail.findAll", query = "SELECT h FROM VHTV006Detail h"),
    @NamedQuery(name = "VHTV006Detail.findByOid", query = "SELECT h FROM VHTV006Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "VHTV006Detail.findByItnbrcus", query = "SELECT h FROM VHTV006Detail h WHERE h.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "VHTV006Detail.findByRefmodel", query = "SELECT h FROM VHTV006Detail h WHERE h.refmodel = :refmodel"),
    @NamedQuery(name = "VHTV006Detail.findByItdsc", query = "SELECT h FROM VHTV006Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "VHTV006Detail.findByUnpris", query = "SELECT h FROM VHTV006Detail h WHERE h.unpris = :unpris"),
    @NamedQuery(name = "VHTV006Detail.findByDiffitting", query = "SELECT h FROM VHTV006Detail h WHERE h.diffitting = :diffitting"),
    @NamedQuery(name = "VHTV006Detail.findBySeq", query = "SELECT h FROM VHTV006Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "VHTV006Detail.findByTramts", query = "SELECT h FROM VHTV006Detail h WHERE h.tramts = :tramts"),
    @NamedQuery(name = "VHTV006Detail.findByPeratio", query = "SELECT h FROM VHTV006Detail h WHERE h.peratio = :peratio"),
    @NamedQuery(name = "VHTV006Detail.findByItnbr", query = "SELECT h FROM VHTV006Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "VHTV006Detail.findByRefratio", query = "SELECT h FROM VHTV006Detail h WHERE h.refratio = :refratio"),
    @NamedQuery(name = "VHTV006Detail.findByTrseq", query = "SELECT h FROM VHTV006Detail h WHERE h.trseq = :trseq"),
    @NamedQuery(name = "VHTV006Detail.findByQuaqy1", query = "SELECT h FROM VHTV006Detail h WHERE h.quaqy1 = :quaqy1"),
    @NamedQuery(name = "VHTV006Detail.findByFSN", query = "SELECT h FROM VHTV006Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "VHTV006Detail.findByLastunpri", query = "SELECT h FROM VHTV006Detail h WHERE h.lastunpri = :lastunpri")})
public class VHTV006Detail implements Serializable {

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

    public VHTV006Detail() {
    }

    public VHTV006Detail(String oid) {
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
        if (!(object instanceof VHTV006Detail)) {
            return false;
        }
        VHTV006Detail other = (VHTV006Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV006Detail[ oid=" + oid + " ]";
    }

}
