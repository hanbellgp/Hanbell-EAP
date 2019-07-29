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
public class PricingUserPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "userid")
    private String userid;

    public PricingUserPK() {
    }

    public PricingUserPK(String groupid, String pricingtype, String userid) {
        this.groupid = groupid;
        this.pricingtype = pricingtype;
        this.userid = userid;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        hash += (pricingtype != null ? pricingtype.hashCode() : 0);
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingUserPK)) {
            return false;
        }
        PricingUserPK other = (PricingUserPK) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        if ((this.pricingtype == null && other.pricingtype != null) || (this.pricingtype != null && !this.pricingtype.equals(other.pricingtype))) {
            return false;
        }
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.ejb.PricingUserPK[ groupid=" + groupid + ", pricingtype=" + pricingtype + ", userid=" + userid + " ]";
    }

}
