/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

import java.io.Serializable;
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
 * @author C0160
 */
@Entity
@Table(name = "miscode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miscode.findAll", query = "SELECT m FROM Miscode m"),
    @NamedQuery(name = "Miscode.findByPK", query = "SELECT m FROM Miscode m WHERE m.miscodePK.ckind = :ckind AND m.miscodePK.code = :code"),
    @NamedQuery(name = "Miscode.findByCkind", query = "SELECT m FROM Miscode m WHERE m.miscodePK.ckind = :ckind"),
    @NamedQuery(name = "Miscode.findByCkindAndCdesc", query = "SELECT m FROM Miscode m WHERE m.miscodePK.ckind = :ckind AND m.cdesc = :cdesc"),
    @NamedQuery(name = "Miscode.findByCode", query = "SELECT m FROM Miscode m WHERE m.miscodePK.code = :code"),
    @NamedQuery(name = "Miscode.findByCdesc", query = "SELECT m FROM Miscode m WHERE m.cdesc = :cdesc"),
    @NamedQuery(name = "Miscode.findByStatus", query = "SELECT m FROM Miscode m WHERE m.status = :status"),
    @NamedQuery(name = "Miscode.findByMascreyn", query = "SELECT m FROM Miscode m WHERE m.mascreyn = :mascreyn"),
    @NamedQuery(name = "Miscode.findByCusds", query = "SELECT m FROM Miscode m WHERE m.cusds = :cusds")})
public class Miscode implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MiscodePK miscodePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cdesc")
    private String cdesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mascreyn")
    private Character mascreyn;
    @Size(max = 80)
    @Column(name = "cusds")
    private String cusds;

    public Miscode() {
    }

    public Miscode(MiscodePK miscodePK) {
        this.miscodePK = miscodePK;
    }

    public Miscode(MiscodePK miscodePK, String cdesc, Character status, Character mascreyn) {
        this.miscodePK = miscodePK;
        this.cdesc = cdesc;
        this.status = status;
        this.mascreyn = mascreyn;
    }

    public Miscode(String ckind, String code) {
        this.miscodePK = new MiscodePK(ckind, code);
    }

    public MiscodePK getMiscodePK() {
        return miscodePK;
    }

    public void setMiscodePK(MiscodePK miscodePK) {
        this.miscodePK = miscodePK;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getMascreyn() {
        return mascreyn;
    }

    public void setMascreyn(Character mascreyn) {
        this.mascreyn = mascreyn;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (miscodePK != null ? miscodePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miscode)) {
            return false;
        }
        Miscode other = (Miscode) object;
        if ((this.miscodePK == null && other.miscodePK != null) || (this.miscodePK != null && !this.miscodePK.equals(other.miscodePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Miscode[ miscodePK=" + miscodePK + " ]";
    }

}
