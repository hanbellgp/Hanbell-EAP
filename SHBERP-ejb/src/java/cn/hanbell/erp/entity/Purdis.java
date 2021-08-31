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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "purdis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purdis.findAll", query = "SELECT p FROM Purdis p"),
    @NamedQuery(name = "Purdis.findByFacno", query = "SELECT p FROM Purdis p WHERE p.purdisPK.facno = :facno"),
    @NamedQuery(name = "Purdis.findByProno", query = "SELECT p FROM Purdis p WHERE p.purdisPK.prono = :prono"),
    @NamedQuery(name = "Purdis.findByVdrno", query = "SELECT p FROM Purdis p WHERE p.purdisPK.vdrno = :vdrno"),
    @NamedQuery(name = "Purdis.findByItnbrAndMainyn", query = "SELECT p FROM Purdis p WHERE p.purdisPK.itnbr = :itnbr and p.mainyn=:mainyn"),
    @NamedQuery(name = "Purdis.findByDisrate", query = "SELECT p FROM Purdis p WHERE p.disrate = :disrate"),
    @NamedQuery(name = "Purdis.findByMainyn", query = "SELECT p FROM Purdis p WHERE p.mainyn = :mainyn")})
public class Purdis implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurdisPK purdisPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "disrate")
    private BigDecimal disrate;
    @Column(name = "mainyn")
    private Character mainyn;

    @JoinColumns({
        @JoinColumn(name = "vdrno", referencedColumnName = "vdrno", insertable = false, updatable = false),
        @JoinColumn(name = "itnbr", referencedColumnName = "itnbr", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Purvdrit purvdrit;

    public Purdis() {
    }

    public Purdis(PurdisPK purdisPK) {
        this.purdisPK = purdisPK;
    }

    public Purdis(PurdisPK purdisPK, BigDecimal disrate) {
        this.purdisPK = purdisPK;
        this.disrate = disrate;
    }

    public Purdis(String facno, String prono, String vdrno, String itnbr) {
        this.purdisPK = new PurdisPK(facno, prono, vdrno, itnbr);
    }

    public PurdisPK getPurdisPK() {
        return purdisPK;
    }

    public void setPurdisPK(PurdisPK purdisPK) {
        this.purdisPK = purdisPK;
    }

    public BigDecimal getDisrate() {
        return disrate;
    }

    public void setDisrate(BigDecimal disrate) {
        this.disrate = disrate;
    }

    public Character getMainyn() {
        return mainyn;
    }

    public void setMainyn(Character mainyn) {
        this.mainyn = mainyn;
    }

    public Purvdrit getPurvdrit() {
        return purvdrit;
    }

    public void setPurvdrit(Purvdrit purvdrit) {
        this.purvdrit = purvdrit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purdisPK != null ? purdisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purdis)) {
            return false;
        }
        Purdis other = (Purdis) object;
        if ((this.purdisPK == null && other.purdisPK != null) || (this.purdisPK != null && !this.purdisPK.equals(other.purdisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Purdis[ purdisPK=" + purdisPK + " ]";
    }

}
