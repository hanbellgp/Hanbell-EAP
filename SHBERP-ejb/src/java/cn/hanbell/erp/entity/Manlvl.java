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
 * @author kevindong
 */
@Entity
@Table(name = "manlvl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manlvl.findAll", query = "SELECT m FROM Manlvl m"),
    @NamedQuery(name = "Manlvl.findByTypecode", query = "SELECT m FROM Manlvl m WHERE m.typecode = :typecode"),
    @NamedQuery(name = "Manlvl.findByBomcode", query = "SELECT m FROM Manlvl m WHERE m.bomcode = :bomcode"),
    @NamedQuery(name = "Manlvl.findByBorcode", query = "SELECT m FROM Manlvl m WHERE m.borcode = :borcode"),
    @NamedQuery(name = "Manlvl.findByModefcode", query = "SELECT m FROM Manlvl m WHERE m.modefcode = :modefcode"),
    @NamedQuery(name = "Manlvl.findBySelfcode", query = "SELECT m FROM Manlvl m WHERE m.selfcode = :selfcode"),
    @NamedQuery(name = "Manlvl.findByEbomcode", query = "SELECT m FROM Manlvl m WHERE m.ebomcode = :ebomcode")})
public class Manlvl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "typecode")
    private String typecode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bomcode")
    private Character bomcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borcode")
    private Character borcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modefcode")
    private Character modefcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "selfcode")
    private Character selfcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ebomcode")
    private Character ebomcode;

    public Manlvl() {
    }

    public Manlvl(String typecode) {
        this.typecode = typecode;
    }

    public Manlvl(String typecode, Character bomcode, Character borcode, Character modefcode, Character selfcode, Character ebomcode) {
        this.typecode = typecode;
        this.bomcode = bomcode;
        this.borcode = borcode;
        this.modefcode = modefcode;
        this.selfcode = selfcode;
        this.ebomcode = ebomcode;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public Character getBomcode() {
        return bomcode;
    }

    public void setBomcode(Character bomcode) {
        this.bomcode = bomcode;
    }

    public Character getBorcode() {
        return borcode;
    }

    public void setBorcode(Character borcode) {
        this.borcode = borcode;
    }

    public Character getModefcode() {
        return modefcode;
    }

    public void setModefcode(Character modefcode) {
        this.modefcode = modefcode;
    }

    public Character getSelfcode() {
        return selfcode;
    }

    public void setSelfcode(Character selfcode) {
        this.selfcode = selfcode;
    }

    public Character getEbomcode() {
        return ebomcode;
    }

    public void setEbomcode(Character ebomcode) {
        this.ebomcode = ebomcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typecode != null ? typecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manlvl)) {
            return false;
        }
        Manlvl other = (Manlvl) object;
        if ((this.typecode == null && other.typecode != null) || (this.typecode != null && !this.typecode.equals(other.typecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Manlvl[ typecode=" + typecode + " ]";
    }
    
}
