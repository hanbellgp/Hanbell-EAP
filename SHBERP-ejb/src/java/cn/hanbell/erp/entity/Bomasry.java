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
@Table(name = "bomasry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bomasry.findAll", query = "SELECT b FROM Bomasry b"),
    @NamedQuery(name = "Bomasry.findByItnbrf", query = "SELECT b FROM Bomasry b WHERE b.bomasryPK.itnbrf = :itnbrf"),
    @NamedQuery(name = "Bomasry.findByItnbr", query = "SELECT b FROM Bomasry b WHERE b.bomasryPK.itnbr = :itnbr"),
    @NamedQuery(name = "Bomasry.findByItnbrfAndCmccode", query = "SELECT b FROM Bomasry b WHERE b.bomasryPK.itnbrf = :itnbrf AND b.bomasryPK.cmccode = :cmccode"),
    @NamedQuery(name = "Bomasry.findBySeqnr", query = "SELECT b FROM Bomasry b WHERE b.seqnr = :seqnr"),
    @NamedQuery(name = "Bomasry.findByProsscode", query = "SELECT b FROM Bomasry b WHERE b.prosscode = :prosscode"),
    @NamedQuery(name = "Bomasry.findByStdqty", query = "SELECT b FROM Bomasry b WHERE b.stdqty = :stdqty"),
    @NamedQuery(name = "Bomasry.findByStdpar", query = "SELECT b FROM Bomasry b WHERE b.stdpar = :stdpar"),
    @NamedQuery(name = "Bomasry.findByBadrat", query = "SELECT b FROM Bomasry b WHERE b.badrat = :badrat"),
    @NamedQuery(name = "Bomasry.findByUserno", query = "SELECT b FROM Bomasry b WHERE b.userno = :userno"),
    @NamedQuery(name = "Bomasry.findByIndate", query = "SELECT b FROM Bomasry b WHERE b.indate = :indate"),
    @NamedQuery(name = "Bomasry.findByCmccode", query = "SELECT b FROM Bomasry b WHERE b.bomasryPK.cmccode = :cmccode")})
public class Bomasry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BomasryPK bomasryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqnr")
    private short seqnr;
    @Size(max = 8)
    @Column(name = "prosscode")
    private String prosscode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "stdqty")
    private BigDecimal stdqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stdpar")
    private short stdpar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "badrat")
    private BigDecimal badrat;
    @Size(max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;

    public Bomasry() {
    }

    public Bomasry(BomasryPK bomasryPK) {
        this.bomasryPK = bomasryPK;
    }

    public Bomasry(BomasryPK bomasryPK, short seqnr, BigDecimal stdqty, short stdpar, BigDecimal badrat, Date indate) {
        this.bomasryPK = bomasryPK;
        this.seqnr = seqnr;
        this.stdqty = stdqty;
        this.stdpar = stdpar;
        this.badrat = badrat;
        this.indate = indate;
    }

    public Bomasry(String itnbrf, String itnbr, String cmccode) {
        this.bomasryPK = new BomasryPK(itnbrf, itnbr, cmccode);
    }

    public BomasryPK getBomasryPK() {
        return bomasryPK;
    }

    public void setBomasryPK(BomasryPK bomasryPK) {
        this.bomasryPK = bomasryPK;
    }

    public short getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(short seqnr) {
        this.seqnr = seqnr;
    }

    public String getProsscode() {
        return prosscode;
    }

    public void setProsscode(String prosscode) {
        this.prosscode = prosscode;
    }

    public BigDecimal getStdqty() {
        return stdqty;
    }

    public void setStdqty(BigDecimal stdqty) {
        this.stdqty = stdqty;
    }

    public short getStdpar() {
        return stdpar;
    }

    public void setStdpar(short stdpar) {
        this.stdpar = stdpar;
    }

    public BigDecimal getBadrat() {
        return badrat;
    }

    public void setBadrat(BigDecimal badrat) {
        this.badrat = badrat;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bomasryPK != null ? bomasryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bomasry)) {
            return false;
        }
        Bomasry other = (Bomasry) object;
        if ((this.bomasryPK == null && other.bomasryPK != null) || (this.bomasryPK != null && !this.bomasryPK.equals(other.bomasryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Bomasry[ bomasryPK=" + bomasryPK + " ]";
    }

}
