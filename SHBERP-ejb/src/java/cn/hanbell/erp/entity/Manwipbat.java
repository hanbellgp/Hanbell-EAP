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
 * @author C0160
 */
@Entity
@Table(name = "manwipbat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manwipbat.findAll", query = "SELECT m FROM Manwipbat m"),
    @NamedQuery(name = "Manwipbat.findByFacno", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.facno = :facno"),
    @NamedQuery(name = "Manwipbat.findByProno", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.prono = :prono"),
    @NamedQuery(name = "Manwipbat.findByManno", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.manno = :manno"),
    @NamedQuery(name = "Manwipbat.findByProsscode", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.prosscode = :prosscode"),
    @NamedQuery(name = "Manwipbat.findByWrcode", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.wrcode = :wrcode"),
    @NamedQuery(name = "Manwipbat.findByPctno", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.pctno = :pctno"),
    @NamedQuery(name = "Manwipbat.findByDepno", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.depno = :depno"),
    @NamedQuery(name = "Manwipbat.findByFixnr", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.fixnr = :fixnr"),
    @NamedQuery(name = "Manwipbat.findByVarnr", query = "SELECT m FROM Manwipbat m WHERE m.manwipbatPK.varnr = :varnr"),
    @NamedQuery(name = "Manwipbat.findByItnbr", query = "SELECT m FROM Manwipbat m WHERE m.itnbr = :itnbr"),
    @NamedQuery(name = "Manwipbat.findBySeqnr", query = "SELECT m FROM Manwipbat m WHERE m.seqnr = :seqnr"),
    @NamedQuery(name = "Manwipbat.findByKeyindate", query = "SELECT m FROM Manwipbat m WHERE m.keyindate = :keyindate"),
    @NamedQuery(name = "Manwipbat.findByTrnqy1", query = "SELECT m FROM Manwipbat m WHERE m.trnqy1 = :trnqy1"),
    @NamedQuery(name = "Manwipbat.findByHrcode", query = "SELECT m FROM Manwipbat m WHERE m.hrcode = :hrcode"),
    @NamedQuery(name = "Manwipbat.findByMbegqy1", query = "SELECT m FROM Manwipbat m WHERE m.mbegqy1 = :mbegqy1"),
    @NamedQuery(name = "Manwipbat.findByOnhand1", query = "SELECT m FROM Manwipbat m WHERE m.onhand1 = :onhand1"),
    @NamedQuery(name = "Manwipbat.findByFbegqy1", query = "SELECT m FROM Manwipbat m WHERE m.fbegqy1 = :fbegqy1"),
    @NamedQuery(name = "Manwipbat.findByFinqy1", query = "SELECT m FROM Manwipbat m WHERE m.finqy1 = :finqy1")})
public class Manwipbat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManwipbatPK manwipbatPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqnr")
    private short seqnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "keyindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyindate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "trnqy1")
    private BigDecimal trnqy1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hrcode")
    private Character hrcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mbegqy1")
    private BigDecimal mbegqy1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onhand1")
    private BigDecimal onhand1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fbegqy1")
    private BigDecimal fbegqy1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finqy1")
    private BigDecimal finqy1;

    public Manwipbat() {
    }

    public Manwipbat(ManwipbatPK manwipbatPK) {
        this.manwipbatPK = manwipbatPK;
    }

    public Manwipbat(ManwipbatPK manwipbatPK, String itnbr, short seqnr, Date keyindate, BigDecimal trnqy1, Character hrcode, BigDecimal mbegqy1, BigDecimal onhand1, BigDecimal fbegqy1, BigDecimal finqy1) {
        this.manwipbatPK = manwipbatPK;
        this.itnbr = itnbr;
        this.seqnr = seqnr;
        this.keyindate = keyindate;
        this.trnqy1 = trnqy1;
        this.hrcode = hrcode;
        this.mbegqy1 = mbegqy1;
        this.onhand1 = onhand1;
        this.fbegqy1 = fbegqy1;
        this.finqy1 = finqy1;
    }

    public Manwipbat(String facno, String prono, String manno, String prosscode, String wrcode, String pctno, String depno, String fixnr, String varnr) {
        this.manwipbatPK = new ManwipbatPK(facno, prono, manno, prosscode, wrcode, pctno, depno, fixnr, varnr);
    }

    public ManwipbatPK getManwipbatPK() {
        return manwipbatPK;
    }

    public void setManwipbatPK(ManwipbatPK manwipbatPK) {
        this.manwipbatPK = manwipbatPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public short getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(short seqnr) {
        this.seqnr = seqnr;
    }

    public Date getKeyindate() {
        return keyindate;
    }

    public void setKeyindate(Date keyindate) {
        this.keyindate = keyindate;
    }

    public BigDecimal getTrnqy1() {
        return trnqy1;
    }

    public void setTrnqy1(BigDecimal trnqy1) {
        this.trnqy1 = trnqy1;
    }

    public Character getHrcode() {
        return hrcode;
    }

    public void setHrcode(Character hrcode) {
        this.hrcode = hrcode;
    }

    public BigDecimal getMbegqy1() {
        return mbegqy1;
    }

    public void setMbegqy1(BigDecimal mbegqy1) {
        this.mbegqy1 = mbegqy1;
    }

    public BigDecimal getOnhand1() {
        return onhand1;
    }

    public void setOnhand1(BigDecimal onhand1) {
        this.onhand1 = onhand1;
    }

    public BigDecimal getFbegqy1() {
        return fbegqy1;
    }

    public void setFbegqy1(BigDecimal fbegqy1) {
        this.fbegqy1 = fbegqy1;
    }

    public BigDecimal getFinqy1() {
        return finqy1;
    }

    public void setFinqy1(BigDecimal finqy1) {
        this.finqy1 = finqy1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manwipbatPK != null ? manwipbatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manwipbat)) {
            return false;
        }
        Manwipbat other = (Manwipbat) object;
        if ((this.manwipbatPK == null && other.manwipbatPK != null) || (this.manwipbatPK != null && !this.manwipbatPK.equals(other.manwipbatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Manwipbat[ manwipbatPK=" + manwipbatPK + " ]";
    }
    
}
