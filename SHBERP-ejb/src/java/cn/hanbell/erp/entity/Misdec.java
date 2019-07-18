/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "misdec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misdec.findAll", query = "SELECT m FROM Misdec m"),
    @NamedQuery(name = "Misdec.findByRatedec", query = "SELECT m FROM Misdec m WHERE m.ratedec = :ratedec"),
    @NamedQuery(name = "Misdec.findByUnprisdec", query = "SELECT m FROM Misdec m WHERE m.unprisdec = :unprisdec"),
    @NamedQuery(name = "Misdec.findByQtydec", query = "SELECT m FROM Misdec m WHERE m.qtydec = :qtydec"),
    @NamedQuery(name = "Misdec.findByQtymdec", query = "SELECT m FROM Misdec m WHERE m.qtymdec = :qtymdec"),
    @NamedQuery(name = "Misdec.findByAmtdec", query = "SELECT m FROM Misdec m WHERE m.amtdec = :amtdec"),
    @NamedQuery(name = "Misdec.findByAmtfsdec", query = "SELECT m FROM Misdec m WHERE m.amtfsdec = :amtfsdec")})
public class Misdec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratedec")
    private Short ratedec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unprisdec")
    private short unprisdec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtydec")
    private short qtydec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtymdec")
    private short qtymdec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtdec")
    private short amtdec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtfsdec")
    private short amtfsdec;

    public Misdec() {
    }

    public Misdec(Short ratedec) {
        this.ratedec = ratedec;
    }

    public Misdec(Short ratedec, short unprisdec, short qtydec, short qtymdec, short amtdec, short amtfsdec) {
        this.ratedec = ratedec;
        this.unprisdec = unprisdec;
        this.qtydec = qtydec;
        this.qtymdec = qtymdec;
        this.amtdec = amtdec;
        this.amtfsdec = amtfsdec;
    }

    public Short getRatedec() {
        return ratedec;
    }

    public void setRatedec(Short ratedec) {
        this.ratedec = ratedec;
    }

    public short getUnprisdec() {
        return unprisdec;
    }

    public void setUnprisdec(short unprisdec) {
        this.unprisdec = unprisdec;
    }

    public short getQtydec() {
        return qtydec;
    }

    public void setQtydec(short qtydec) {
        this.qtydec = qtydec;
    }

    public short getQtymdec() {
        return qtymdec;
    }

    public void setQtymdec(short qtymdec) {
        this.qtymdec = qtymdec;
    }

    public short getAmtdec() {
        return amtdec;
    }

    public void setAmtdec(short amtdec) {
        this.amtdec = amtdec;
    }

    public short getAmtfsdec() {
        return amtfsdec;
    }

    public void setAmtfsdec(short amtfsdec) {
        this.amtfsdec = amtfsdec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratedec != null ? ratedec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Misdec)) {
            return false;
        }
        Misdec other = (Misdec) object;
        if ((this.ratedec == null && other.ratedec != null) || (this.ratedec != null && !this.ratedec.equals(other.ratedec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Misdec[ ratedec=" + ratedec + " ]";
    }
    
}
