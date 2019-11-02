/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class PricingGroupPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "groupid")
    private String groupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pricingtype")
    private String pricingtype;

    public PricingGroupPK() {
    }

    public PricingGroupPK(String groupid, String pricingtype) {
        this.groupid = groupid;
        this.pricingtype = pricingtype;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getPricingtype() {
        return pricingtype;
    }

    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        hash += (pricingtype != null ? pricingtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingGroupPK)) {
            return false;
        }
        PricingGroupPK other = (PricingGroupPK) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        if ((this.pricingtype == null && other.pricingtype != null) || (this.pricingtype != null && !this.pricingtype.equals(other.pricingtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.PricingGroupPK[ groupid=" + groupid + ", pricingtype=" + pricingtype + " ]";
    }
    
}
