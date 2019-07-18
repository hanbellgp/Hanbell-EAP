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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "misckind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misckind.findAll", query = "SELECT m FROM Misckind m"),
    @NamedQuery(name = "Misckind.findByCkind", query = "SELECT m FROM Misckind m WHERE m.ckind = :ckind"),
    @NamedQuery(name = "Misckind.findByCkdesc", query = "SELECT m FROM Misckind m WHERE m.ckdesc = :ckdesc"),
    @NamedQuery(name = "Misckind.findByClen", query = "SELECT m FROM Misckind m WHERE m.clen = :clen"),
    @NamedQuery(name = "Misckind.findByMasyn", query = "SELECT m FROM Misckind m WHERE m.masyn = :masyn")})
public class Misckind implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ckind")
    private String ckind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ckdesc")
    private String ckdesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clen")
    private short clen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "masyn")
    private Character masyn;

    public Misckind() {
    }

    public Misckind(String ckind) {
        this.ckind = ckind;
    }

    public Misckind(String ckind, String ckdesc, short clen, Character masyn) {
        this.ckind = ckind;
        this.ckdesc = ckdesc;
        this.clen = clen;
        this.masyn = masyn;
    }

    public String getCkind() {
        return ckind;
    }

    public void setCkind(String ckind) {
        this.ckind = ckind;
    }

    public String getCkdesc() {
        return ckdesc;
    }

    public void setCkdesc(String ckdesc) {
        this.ckdesc = ckdesc;
    }

    public short getClen() {
        return clen;
    }

    public void setClen(short clen) {
        this.clen = clen;
    }

    public Character getMasyn() {
        return masyn;
    }

    public void setMasyn(Character masyn) {
        this.masyn = masyn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ckind != null ? ckind.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Misckind)) {
            return false;
        }
        Misckind other = (Misckind) object;
        if ((this.ckind == null && other.ckind != null) || (this.ckind != null && !this.ckind.equals(other.ckind))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Misckind[ ckind=" + ckind + " ]";
    }
    
}
