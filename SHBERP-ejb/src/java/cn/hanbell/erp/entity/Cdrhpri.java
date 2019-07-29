/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cdrhpri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrhpri.findAll", query = "SELECT c FROM Cdrhpri c"),
    @NamedQuery(name = "Cdrhpri.findByCusno", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.cusno = :cusno"),
    @NamedQuery(name = "Cdrhpri.findByFacno", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.facno = :facno"),
    @NamedQuery(name = "Cdrhpri.findByItnbr", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrhpri.findByCoin", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.coin = :coin"),
    @NamedQuery(name = "Cdrhpri.findByUnpris", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.unpris = :unpris"),
    @NamedQuery(name = "Cdrhpri.findByTrno", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.trno = :trno"),
    @NamedQuery(name = "Cdrhpri.findByTrseq", query = "SELECT c FROM Cdrhpri c WHERE c.cdrhpriPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrhpri.findByTrdate", query = "SELECT c FROM Cdrhpri c WHERE c.trdate = :trdate"),
    @NamedQuery(name = "Cdrhpri.findByRatio", query = "SELECT c FROM Cdrhpri c WHERE c.ratio = :ratio"),
    @NamedQuery(name = "Cdrhpri.findBySndcode", query = "SELECT c FROM Cdrhpri c WHERE c.sndcode = :sndcode"),
    @NamedQuery(name = "Cdrhpri.findByPaycode", query = "SELECT c FROM Cdrhpri c WHERE c.paycode = :paycode"),
    @NamedQuery(name = "Cdrhpri.findByArmqy", query = "SELECT c FROM Cdrhpri c WHERE c.armqy = :armqy"),
    @NamedQuery(name = "Cdrhpri.findByItnbrcus", query = "SELECT c FROM Cdrhpri c WHERE c.itnbrcus = :itnbrcus")})
public class Cdrhpri implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrhpriPK cdrhpriPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycode")
    private Character paycode;
    @Column(name = "armqy")
    private BigDecimal armqy;
    @Size(max = 20)
    @Column(name = "itnbrcus")
    private String itnbrcus;

    public Cdrhpri() {
    }

    public Cdrhpri(CdrhpriPK cdrhpriPK) {
        this.cdrhpriPK = cdrhpriPK;
    }

    public Cdrhpri(CdrhpriPK cdrhpriPK, Date trdate, BigDecimal ratio, String sndcode, Character paycode) {
        this.cdrhpriPK = cdrhpriPK;
        this.trdate = trdate;
        this.ratio = ratio;
        this.sndcode = sndcode;
        this.paycode = paycode;
    }

    public Cdrhpri(String cusno, String facno, String itnbr, String coin, BigDecimal unpris, String trno, short trseq) {
        this.cdrhpriPK = new CdrhpriPK(cusno, facno, itnbr, coin, unpris, trno, trseq);
    }

    public CdrhpriPK getCdrhpriPK() {
        return cdrhpriPK;
    }

    public void setCdrhpriPK(CdrhpriPK cdrhpriPK) {
        this.cdrhpriPK = cdrhpriPK;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public Character getPaycode() {
        return paycode;
    }

    public void setPaycode(Character paycode) {
        this.paycode = paycode;
    }

    public BigDecimal getArmqy() {
        return armqy;
    }

    public void setArmqy(BigDecimal armqy) {
        this.armqy = armqy;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrhpriPK != null ? cdrhpriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrhpri)) {
            return false;
        }
        Cdrhpri other = (Cdrhpri) object;
        if ((this.cdrhpriPK == null && other.cdrhpriPK != null) || (this.cdrhpriPK != null && !this.cdrhpriPK.equals(other.cdrhpriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrhpri[ cdrhpriPK=" + cdrhpriPK + " ]";
    }

}
