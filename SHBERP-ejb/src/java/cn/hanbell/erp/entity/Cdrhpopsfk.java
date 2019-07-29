/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "cdrhpopsfk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrhpopsfk.findAll", query = "SELECT c FROM Cdrhpopsfk c"),
    @NamedQuery(name = "Cdrhpopsfk.findByFacno", query = "SELECT c FROM Cdrhpopsfk c WHERE c.cdrhpopsfkPK.facno = :facno"),
    @NamedQuery(name = "Cdrhpopsfk.findBySfktrno", query = "SELECT c FROM Cdrhpopsfk c WHERE c.cdrhpopsfkPK.sfktrno = :sfktrno"),
    @NamedQuery(name = "Cdrhpopsfk.findByCusno", query = "SELECT c FROM Cdrhpopsfk c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "Cdrhpopsfk.findByItnbr", query = "SELECT c FROM Cdrhpopsfk c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrhpopsfk.findByItnbrcus", query = "SELECT c FROM Cdrhpopsfk c WHERE c.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "Cdrhpopsfk.findBySpcode", query = "SELECT c FROM Cdrhpopsfk c WHERE c.spcode = :spcode"),
    @NamedQuery(name = "Cdrhpopsfk.findByVersion", query = "SELECT c FROM Cdrhpopsfk c WHERE c.version = :version"),
    @NamedQuery(name = "Cdrhpopsfk.findByQuono", query = "SELECT c FROM Cdrhpopsfk c WHERE c.quono = :quono"),
    @NamedQuery(name = "Cdrhpopsfk.findByQtrseq", query = "SELECT c FROM Cdrhpopsfk c WHERE c.qtrseq = :qtrseq"),
    @NamedQuery(name = "Cdrhpopsfk.findByCdrno", query = "SELECT c FROM Cdrhpopsfk c WHERE c.cdrno = :cdrno"),
    @NamedQuery(name = "Cdrhpopsfk.findByCtrseq", query = "SELECT c FROM Cdrhpopsfk c WHERE c.ctrseq = :ctrseq"),
    @NamedQuery(name = "Cdrhpopsfk.findByManno", query = "SELECT c FROM Cdrhpopsfk c WHERE c.manno = :manno"),
    @NamedQuery(name = "Cdrhpopsfk.findBySpdesc", query = "SELECT c FROM Cdrhpopsfk c WHERE c.spdesc = :spdesc"),
    @NamedQuery(name = "Cdrhpopsfk.findByCrtprg", query = "SELECT c FROM Cdrhpopsfk c WHERE c.crtprg = :crtprg"),
    @NamedQuery(name = "Cdrhpopsfk.findByKeyindate", query = "SELECT c FROM Cdrhpopsfk c WHERE c.keyindate = :keyindate"),
    @NamedQuery(name = "Cdrhpopsfk.findByVarnr", query = "SELECT c FROM Cdrhpopsfk c WHERE c.varnr = :varnr"),
    @NamedQuery(name = "Cdrhpopsfk.findByMatcode", query = "SELECT c FROM Cdrhpopsfk c WHERE c.matcode = :matcode")})
public class Cdrhpopsfk implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrhpopsfkPK cdrhpopsfkPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "spcode")
    private Character spcode;
    @Size(max = 8)
    @Column(name = "version")
    private String version;
    @Size(max = 18)
    @Column(name = "quono")
    private String quono;
    @Column(name = "qtrseq")
    private Short qtrseq;
    @Size(max = 18)
    @Column(name = "cdrno")
    private String cdrno;
    @Column(name = "ctrseq")
    private Short ctrseq;
    @Size(max = 18)
    @Column(name = "manno")
    private String manno;
    @Size(max = 150)
    @Column(name = "spdesc")
    private String spdesc;
    @Size(max = 12)
    @Column(name = "crtprg")
    private String crtprg;
    @Column(name = "keyindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyindate;
    @Size(max = 24)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 20)
    @Column(name = "matcode")
    private String matcode;

    public Cdrhpopsfk() {
    }

    public Cdrhpopsfk(CdrhpopsfkPK cdrhpopsfkPK) {
        this.cdrhpopsfkPK = cdrhpopsfkPK;
    }

    public Cdrhpopsfk(CdrhpopsfkPK cdrhpopsfkPK, String cusno, String itnbr, String itnbrcus, Character spcode) {
        this.cdrhpopsfkPK = cdrhpopsfkPK;
        this.cusno = cusno;
        this.itnbr = itnbr;
        this.itnbrcus = itnbrcus;
        this.spcode = spcode;
    }

    public Cdrhpopsfk(String facno, String sfktrno) {
        this.cdrhpopsfkPK = new CdrhpopsfkPK(facno, sfktrno);
    }

    public CdrhpopsfkPK getCdrhpopsfkPK() {
        return cdrhpopsfkPK;
    }

    public void setCdrhpopsfkPK(CdrhpopsfkPK cdrhpopsfkPK) {
        this.cdrhpopsfkPK = cdrhpopsfkPK;
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

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public Character getSpcode() {
        return spcode;
    }

    public void setSpcode(Character spcode) {
        this.spcode = spcode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public Short getQtrseq() {
        return qtrseq;
    }

    public void setQtrseq(Short qtrseq) {
        this.qtrseq = qtrseq;
    }

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
    }

    public Short getCtrseq() {
        return ctrseq;
    }

    public void setCtrseq(Short ctrseq) {
        this.ctrseq = ctrseq;
    }

    public String getManno() {
        return manno;
    }

    public void setManno(String manno) {
        this.manno = manno;
    }

    public String getSpdesc() {
        return spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

    public String getCrtprg() {
        return crtprg;
    }

    public void setCrtprg(String crtprg) {
        this.crtprg = crtprg;
    }

    public Date getKeyindate() {
        return keyindate;
    }

    public void setKeyindate(Date keyindate) {
        this.keyindate = keyindate;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrhpopsfkPK != null ? cdrhpopsfkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrhpopsfk)) {
            return false;
        }
        Cdrhpopsfk other = (Cdrhpopsfk) object;
        if ((this.cdrhpopsfkPK == null && other.cdrhpopsfkPK != null) || (this.cdrhpopsfkPK != null && !this.cdrhpopsfkPK.equals(other.cdrhpopsfkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrhpopsfk[ cdrhpopsfkPK=" + cdrhpopsfkPK + " ]";
    }

}
