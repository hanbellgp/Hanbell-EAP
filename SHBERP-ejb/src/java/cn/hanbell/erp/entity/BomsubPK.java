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
public class BomsubPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "optkind")
    private String optkind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "optvalue")
    private String optvalue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrs")
    private String itnbrs;

    public BomsubPK() {
    }

    public BomsubPK(String itnbrf, String optkind, String optvalue, String itnbr, String itnbrs) {
        this.itnbrf = itnbrf;
        this.optkind = optkind;
        this.optvalue = optvalue;
        this.itnbr = itnbr;
        this.itnbrs = itnbrs;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getOptkind() {
        return optkind;
    }

    public void setOptkind(String optkind) {
        this.optkind = optkind;
    }

    public String getOptvalue() {
        return optvalue;
    }

    public void setOptvalue(String optvalue) {
        this.optvalue = optvalue;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItnbrs() {
        return itnbrs;
    }

    public void setItnbrs(String itnbrs) {
        this.itnbrs = itnbrs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itnbrf != null ? itnbrf.hashCode() : 0);
        hash += (optkind != null ? optkind.hashCode() : 0);
        hash += (optvalue != null ? optvalue.hashCode() : 0);
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (itnbrs != null ? itnbrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BomsubPK)) {
            return false;
        }
        BomsubPK other = (BomsubPK) object;
        if ((this.itnbrf == null && other.itnbrf != null) || (this.itnbrf != null && !this.itnbrf.equals(other.itnbrf))) {
            return false;
        }
        if ((this.optkind == null && other.optkind != null) || (this.optkind != null && !this.optkind.equals(other.optkind))) {
            return false;
        }
        if ((this.optvalue == null && other.optvalue != null) || (this.optvalue != null && !this.optvalue.equals(other.optvalue))) {
            return false;
        }
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.itnbrs == null && other.itnbrs != null) || (this.itnbrs != null && !this.itnbrs.equals(other.itnbrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.BomsubPK[ itnbrf=" + itnbrf + ", optkind=" + optkind + ", optvalue=" + optvalue + ", itnbr=" + itnbr + ", itnbrs=" + itnbrs + " ]";
    }
    
}
