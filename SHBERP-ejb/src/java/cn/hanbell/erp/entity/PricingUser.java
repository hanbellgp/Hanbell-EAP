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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pricinguser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PricingUser.findAll", query = "SELECT p FROM PricingUser p")
    , @NamedQuery(name = "PricingUser.findByGroupid", query = "SELECT p FROM PricingUser p WHERE p.pricingUserPK.groupid = :groupid")
    , @NamedQuery(name = "PricingUser.findByPricingtype", query = "SELECT p FROM PricingUser p WHERE p.pricingUserPK.pricingtype = :pricingtype")
    , @NamedQuery(name = "PricingUser.findByUserid", query = "SELECT p FROM PricingUser p WHERE p.pricingUserPK.userid = :userid")
    , @NamedQuery(name = "PricingUser.findByFacno", query = "SELECT p FROM PricingUser p WHERE p.facno = :facno")})
public class PricingUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PricingUserPK pricingUserPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @JoinColumn(name = "groupid", referencedColumnName = "groupid", insertable = false, updatable = false)
    @JoinColumn(name = "pricingtype", referencedColumnName = "pricingtype", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private PricingGroup pricingGroup;
    
    public PricingUser() {
    }

    public PricingUser(PricingUserPK pricingUserPK) {
        this.pricingUserPK = pricingUserPK;
    }

    public PricingUser(PricingUserPK pricingUserPK, String facno) {
        this.pricingUserPK = pricingUserPK;
        this.facno = facno;
    }

    public PricingUser(String groupid, String pricingtype, String userid) {
        this.pricingUserPK = new PricingUserPK(groupid, pricingtype, userid);
    }

    public PricingUserPK getPricingUserPK() {
        return pricingUserPK;
    }

    public void setPricingUserPK(PricingUserPK pricingUserPK) {
        this.pricingUserPK = pricingUserPK;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingUserPK != null ? pricingUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingUser)) {
            return false;
        }
        PricingUser other = (PricingUser) object;
        if ((this.pricingUserPK == null && other.pricingUserPK != null) || (this.pricingUserPK != null && !this.pricingUserPK.equals(other.pricingUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.ejb.PricingUser[ pricingUserPK=" + pricingUserPK + " ]";
    }

    public PricingGroup getPricingGroup() {
        return pricingGroup;
    }

    public void setPricingGroup(PricingGroup pricingGroup) {
        this.pricingGroup = pricingGroup;
    }
    
}
