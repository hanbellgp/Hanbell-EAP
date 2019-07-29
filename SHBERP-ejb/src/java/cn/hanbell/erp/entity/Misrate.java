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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "misrate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misrate.findAll", query = "SELECT m FROM Misrate m"),
    @NamedQuery(name = "Misrate.findByCoin", query = "SELECT m FROM Misrate m WHERE m.misratePK.coin = :coin"),
    @NamedQuery(name = "Misrate.findByRateday", query = "SELECT m FROM Misrate m WHERE m.misratePK.rateday = :rateday"),
    @NamedQuery(name = "Misrate.findByRate", query = "SELECT m FROM Misrate m WHERE m.rate = :rate"),
    @NamedQuery(name = "Misrate.findByIrate", query = "SELECT m FROM Misrate m WHERE m.irate = :irate"),
    @NamedQuery(name = "Misrate.findByOrate", query = "SELECT m FROM Misrate m WHERE m.orate = :orate"),
    @NamedQuery(name = "Misrate.findByCirate", query = "SELECT m FROM Misrate m WHERE m.cirate = :cirate"),
    @NamedQuery(name = "Misrate.findByCorate", query = "SELECT m FROM Misrate m WHERE m.corate = :corate")})
public class Misrate implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MisratePK misratePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private BigDecimal rate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "irate")
    private BigDecimal irate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orate")
    private BigDecimal orate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cirate")
    private BigDecimal cirate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corate")
    private BigDecimal corate;

    public Misrate() {
    }

    public Misrate(MisratePK misratePK) {
        this.misratePK = misratePK;
    }

    public Misrate(MisratePK misratePK, BigDecimal rate, BigDecimal irate, BigDecimal orate, BigDecimal cirate, BigDecimal corate) {
        this.misratePK = misratePK;
        this.rate = rate;
        this.irate = irate;
        this.orate = orate;
        this.cirate = cirate;
        this.corate = corate;
    }

    public Misrate(String coin, Date rateday) {
        this.misratePK = new MisratePK(coin, rateday);
    }

    public MisratePK getMisratePK() {
        return misratePK;
    }

    public void setMisratePK(MisratePK misratePK) {
        this.misratePK = misratePK;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getIrate() {
        return irate;
    }

    public void setIrate(BigDecimal irate) {
        this.irate = irate;
    }

    public BigDecimal getOrate() {
        return orate;
    }

    public void setOrate(BigDecimal orate) {
        this.orate = orate;
    }

    public BigDecimal getCirate() {
        return cirate;
    }

    public void setCirate(BigDecimal cirate) {
        this.cirate = cirate;
    }

    public BigDecimal getCorate() {
        return corate;
    }

    public void setCorate(BigDecimal corate) {
        this.corate = corate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (misratePK != null ? misratePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Misrate)) {
            return false;
        }
        Misrate other = (Misrate) object;
        if ((this.misratePK == null && other.misratePK != null) || (this.misratePK != null && !this.misratePK.equals(other.misratePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Misrate[ misratePK=" + misratePK + " ]";
    }

}
