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
 * @author C1368
 */
@Entity
@Table(name = "purvdrbuyer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurvdrBuyer.findAll", query = "SELECT p FROM PurvdrBuyer p"),
    @NamedQuery(name = "PurvdrBuyer.findByFacno", query = "SELECT p FROM PurvdrBuyer p WHERE p.purvdrBuyerPK.facno = :facno"),
    @NamedQuery(name = "PurvdrBuyer.findByProno", query = "SELECT p FROM PurvdrBuyer p WHERE p.purvdrBuyerPK.prono = :prono"),
    @NamedQuery(name = "PurvdrBuyer.findByVdrno", query = "SELECT p FROM PurvdrBuyer p WHERE p.purvdrBuyerPK.vdrno = :vdrno"),
    @NamedQuery(name = "PurvdrBuyer.findByBuyer", query = "SELECT p FROM PurvdrBuyer p WHERE p.buyer = :buyer")})
public class PurvdrBuyer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurvdrBuyerPK purvdrBuyerPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "buyer")
    private String buyer;

    public PurvdrBuyer() {
    }

    public PurvdrBuyer(PurvdrBuyerPK purvdrBuyerPK) {
        this.purvdrBuyerPK = purvdrBuyerPK;
    }

    public PurvdrBuyer(PurvdrBuyerPK purvdrBuyerPK, String buyer) {
        this.purvdrBuyerPK = purvdrBuyerPK;
        this.buyer = buyer;
    }

    public PurvdrBuyer(String facno, String prono, String vdrno) {
        this.purvdrBuyerPK = new PurvdrBuyerPK(facno, prono, vdrno);
    }

    public PurvdrBuyerPK getPurvdrBuyerPK() {
        return purvdrBuyerPK;
    }

    public void setPurvdrBuyerPK(PurvdrBuyerPK purvdrBuyerPK) {
        this.purvdrBuyerPK = purvdrBuyerPK;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purvdrBuyerPK != null ? purvdrBuyerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurvdrBuyer)) {
            return false;
        }
        PurvdrBuyer other = (PurvdrBuyer) object;
        if ((this.purvdrBuyerPK == null && other.purvdrBuyerPK != null) || (this.purvdrBuyerPK != null && !this.purvdrBuyerPK.equals(other.purvdrBuyerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.PurvdrBuyer[ purvdrBuyerPK=" + purvdrBuyerPK + " ]";
    }
    
}
