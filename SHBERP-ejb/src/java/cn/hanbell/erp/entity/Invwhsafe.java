/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1587
 */
@Entity
@Table(name = "invwhsafe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invwhsafe.findAll", query = "SELECT i FROM Invwhsafe i"),
    @NamedQuery(name = "Invwhsafe.findByItnbr", query = "SELECT i FROM Invwhsafe i WHERE i.invwhsafePK.itnbr = :itnbr"),
    @NamedQuery(name = "Invwhsafe.findByItdsc", query = "SELECT i FROM Invwhsafe i WHERE i.itdsc = :itdsc"),
    @NamedQuery(name = "Invwhsafe.findByWareh", query = "SELECT i FROM Invwhsafe i WHERE i.invwhsafePK.wareh = :wareh"),
    @NamedQuery(name = "Invwhsafe.findByLowest", query = "SELECT i FROM Invwhsafe i WHERE i.lowest = :lowest"),
    @NamedQuery(name = "Invwhsafe.findByHighest", query = "SELECT i FROM Invwhsafe i WHERE i.highest = :highest"),
    @NamedQuery(name = "Invwhsafe.findByMintake", query = "SELECT i FROM Invwhsafe i WHERE i.mintake = :mintake")})
public class Invwhsafe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvwhsafePK invwhsafePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "lowest")
    private BigDecimal lowest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "highest")
    private BigDecimal highest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mintake")
    private BigDecimal mintake;

    public Invwhsafe() {
    }

    public Invwhsafe(InvwhsafePK invwhsafePK) {
        this.invwhsafePK = invwhsafePK;
    }

    public Invwhsafe(InvwhsafePK invwhsafePK, String itdsc, BigDecimal lowest, BigDecimal highest, BigDecimal mintake) {
        this.invwhsafePK = invwhsafePK;
        this.itdsc = itdsc;
        this.lowest = lowest;
        this.highest = highest;
        this.mintake = mintake;
    }

    public Invwhsafe(String itnbr, String wareh) {
        this.invwhsafePK = new InvwhsafePK(itnbr, wareh);
    }

    public InvwhsafePK getInvwhsafePK() {
        return invwhsafePK;
    }

    public void setInvwhsafePK(InvwhsafePK invwhsafePK) {
        this.invwhsafePK = invwhsafePK;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public BigDecimal getLowest() {
        return lowest;
    }

    public void setLowest(BigDecimal lowest) {
        this.lowest = lowest;
    }

    public BigDecimal getHighest() {
        return highest;
    }

    public void setHighest(BigDecimal highest) {
        this.highest = highest;
    }

    public BigDecimal getMintake() {
        return mintake;
    }

    public void setMintake(BigDecimal mintake) {
        this.mintake = mintake;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invwhsafePK != null ? invwhsafePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invwhsafe)) {
            return false;
        }
        Invwhsafe other = (Invwhsafe) object;
        if ((this.invwhsafePK == null && other.invwhsafePK != null) || (this.invwhsafePK != null && !this.invwhsafePK.equals(other.invwhsafePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invwhsafe[ invwhsafePK=" + invwhsafePK + " ]";
    }
    
}
