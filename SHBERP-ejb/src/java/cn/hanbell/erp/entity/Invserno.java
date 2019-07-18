/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
@Table(name = "invserno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invserno.findAll", query = "SELECT i FROM Invserno i"),
    @NamedQuery(name = "Invserno.findByFacno", query = "SELECT i FROM Invserno i WHERE i.invsernoPK.facno = :facno"),
    @NamedQuery(name = "Invserno.findByTrtype", query = "SELECT i FROM Invserno i WHERE i.invsernoPK.trtype = :trtype"),
    @NamedQuery(name = "Invserno.findByKeyformat", query = "SELECT i FROM Invserno i WHERE i.invsernoPK.keyformat = :keyformat"),
     @NamedQuery(name = "Invserno.findByPK", query = "SELECT i FROM Invserno i WHERE i.invsernoPK.facno = :facno AND i.invsernoPK.trtype = :trtype AND i.invsernoPK.keyformat = :keyformat"),
    @NamedQuery(name = "Invserno.findByMaxserno", query = "SELECT i FROM Invserno i WHERE i.maxserno = :maxserno")})
public class Invserno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvsernoPK invsernoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxserno")
    private short maxserno;

    public Invserno() {
    }

    public Invserno(InvsernoPK invsernoPK) {
        this.invsernoPK = invsernoPK;
    }

    public Invserno(InvsernoPK invsernoPK, short maxserno) {
        this.invsernoPK = invsernoPK;
        this.maxserno = maxserno;
    }

    public Invserno(String facno, String trtype, String keyformat) {
        this.invsernoPK = new InvsernoPK(facno, trtype, keyformat);
    }

    public InvsernoPK getInvsernoPK() {
        return invsernoPK;
    }

    public void setInvsernoPK(InvsernoPK invsernoPK) {
        this.invsernoPK = invsernoPK;
    }

    public short getMaxserno() {
        return maxserno;
    }

    public void setMaxserno(short maxserno) {
        this.maxserno = maxserno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invsernoPK != null ? invsernoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invserno)) {
            return false;
        }
        Invserno other = (Invserno) object;
        if ((this.invsernoPK == null && other.invsernoPK != null) || (this.invsernoPK != null && !this.invsernoPK.equals(other.invsernoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invserno[ invsernoPK=" + invsernoPK + " ]";
    }
    
}
