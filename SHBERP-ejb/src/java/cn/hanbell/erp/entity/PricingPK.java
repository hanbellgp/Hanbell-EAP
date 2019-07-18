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
 * @author C0160
 */
@Embeddable
public class PricingPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pricingid")
    private String pricingid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "itemno")
    private String itemno;

    public PricingPK() {
    }

    public PricingPK(String pricingid, String itnbr, String itemno) {
        this.pricingid = pricingid;
        this.itnbr = itnbr;
        this.itemno = itemno;
    }

    public String getPricingid() {
        return pricingid;
    }

    public void setPricingid(String pricingid) {
        this.pricingid = pricingid;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingid != null ? pricingid.hashCode() : 0);
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (itemno != null ? itemno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingPK)) {
            return false;
        }
        PricingPK other = (PricingPK) object;
        if ((this.pricingid == null && other.pricingid != null) || (this.pricingid != null && !this.pricingid.equals(other.pricingid))) {
            return false;
        }
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.itemno == null && other.itemno != null) || (this.itemno != null && !this.itemno.equals(other.itemno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.shb.erp.PricingPK[ pricingid=" + pricingid + ", itnbr=" + itnbr + ", itemno=" + itemno + " ]";
    }
    
}
