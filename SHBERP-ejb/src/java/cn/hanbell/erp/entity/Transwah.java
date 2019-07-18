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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "transwah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transwah.findAll", query = "SELECT t FROM Transwah t"),
    @NamedQuery(name = "Transwah.findByFacno", query = "SELECT t FROM Transwah t WHERE t.transwahPK.facno = :facno"),
    @NamedQuery(name = "Transwah.findByProno", query = "SELECT t FROM Transwah t WHERE t.transwahPK.prono = :prono"),
    @NamedQuery(name = "Transwah.findByCustype", query = "SELECT t FROM Transwah t WHERE t.transwahPK.custype = :custype"),
    @NamedQuery(name = "Transwah.findByCusno", query = "SELECT t FROM Transwah t WHERE t.transwahPK.cusno = :cusno"),
    @NamedQuery(name = "Transwah.findByTrseq", query = "SELECT t FROM Transwah t WHERE t.transwahPK.trseq = :trseq"),
    @NamedQuery(name = "Transwah.findByWareh", query = "SELECT t FROM Transwah t WHERE t.wareh = :wareh")})
public class Transwah implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TranswahPK transwahPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "wareh")
    private String wareh;

    public Transwah() {
    }

    public Transwah(TranswahPK transwahPK) {
        this.transwahPK = transwahPK;
    }

    public Transwah(TranswahPK transwahPK, String wareh) {
        this.transwahPK = transwahPK;
        this.wareh = wareh;
    }

    public Transwah(String facno, String prono, Character custype, String cusno, short trseq) {
        this.transwahPK = new TranswahPK(facno, prono, custype, cusno, trseq);
    }

    public TranswahPK getTranswahPK() {
        return transwahPK;
    }

    public void setTranswahPK(TranswahPK transwahPK) {
        this.transwahPK = transwahPK;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transwahPK != null ? transwahPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transwah)) {
            return false;
        }
        Transwah other = (Transwah) object;
        if ((this.transwahPK == null && other.transwahPK != null) || (this.transwahPK != null && !this.transwahPK.equals(other.transwahPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Transwah[ transwahPK=" + transwahPK + " ]";
    }
    
}
