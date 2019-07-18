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
 * @author C1587
 */
@Embeddable
public class InvwhsafePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "wareh")
    private String wareh;

    public InvwhsafePK() {
    }

    public InvwhsafePK(String itnbr, String wareh) {
        this.itnbr = itnbr;
        this.wareh = wareh;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (wareh != null ? wareh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvwhsafePK)) {
            return false;
        }
        InvwhsafePK other = (InvwhsafePK) object;
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.wareh == null && other.wareh != null) || (this.wareh != null && !this.wareh.equals(other.wareh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.InvwhsafePK[ itnbr=" + itnbr + ", wareh=" + wareh + " ]";
    }
    
}
