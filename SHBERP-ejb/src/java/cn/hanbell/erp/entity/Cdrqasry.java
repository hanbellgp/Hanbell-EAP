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
 * @author Administrator
 */
@Entity
@Table(name = "cdrqasry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrqasry.findAll", query = "SELECT c FROM Cdrqasry c")
    , @NamedQuery(name = "Cdrqasry.findByFacno", query = "SELECT c FROM Cdrqasry c WHERE c.cdrqasryPK.facno = :facno")
    , @NamedQuery(name = "Cdrqasry.findByQuono", query = "SELECT c FROM Cdrqasry c WHERE c.cdrqasryPK.quono = :quono")
    , @NamedQuery(name = "Cdrqasry.findByTrseq", query = "SELECT c FROM Cdrqasry c WHERE c.cdrqasryPK.trseq = :trseq")
    , @NamedQuery(name = "Cdrqasry.findBySeq", query = "SELECT c FROM Cdrqasry c WHERE c.cdrqasryPK.seq = :seq")
    , @NamedQuery(name = "Cdrqasry.findByItnbr", query = "SELECT c FROM Cdrqasry c WHERE c.itnbr = :itnbr")
    , @NamedQuery(name = "Cdrqasry.findByItnbrf", query = "SELECT c FROM Cdrqasry c WHERE c.itnbrf = :itnbrf")
    , @NamedQuery(name = "Cdrqasry.findByProsscode", query = "SELECT c FROM Cdrqasry c WHERE c.prosscode = :prosscode")
    , @NamedQuery(name = "Cdrqasry.findByStdqty", query = "SELECT c FROM Cdrqasry c WHERE c.stdqty = :stdqty")
    , @NamedQuery(name = "Cdrqasry.findByStdpar", query = "SELECT c FROM Cdrqasry c WHERE c.stdpar = :stdpar")
    , @NamedQuery(name = "Cdrqasry.findByBadrat", query = "SELECT c FROM Cdrqasry c WHERE c.badrat = :badrat")
    , @NamedQuery(name = "Cdrqasry.findByCmccode", query = "SELECT c FROM Cdrqasry c WHERE c.cdrqasryPK.cmccode = :cmccode")})
public class Cdrqasry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrqasryPK cdrqasryPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
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

    public Cdrqasry() {
    }

    public Cdrqasry(CdrqasryPK cdrqasryPK) {
        this.cdrqasryPK = cdrqasryPK;
    }

    public Cdrqasry(CdrqasryPK cdrqasryPK, String itnbr, String itnbrf, BigDecimal stdqty, short stdpar, BigDecimal badrat) {
        this.cdrqasryPK = cdrqasryPK;
        this.itnbr = itnbr;
        this.itnbrf = itnbrf;
        this.stdqty = stdqty;
        this.stdpar = stdpar;
        this.badrat = badrat;
    }

    public Cdrqasry(String facno, String quono, short trseq, short seq, String cmccode) {
        this.cdrqasryPK = new CdrqasryPK(facno, quono, trseq, seq, cmccode);
    }

    public CdrqasryPK getCdrqasryPK() {
        return cdrqasryPK;
    }

    public void setCdrqasryPK(CdrqasryPK cdrqasryPK) {
        this.cdrqasryPK = cdrqasryPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrqasryPK != null ? cdrqasryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrqasry)) {
            return false;
        }
        Cdrqasry other = (Cdrqasry) object;
        if ((this.cdrqasryPK == null && other.cdrqasryPK != null) || (this.cdrqasryPK != null && !this.cdrqasryPK.equals(other.cdrqasryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrqasry[ cdrqasryPK=" + cdrqasryPK + " ]";
    }
    
}
