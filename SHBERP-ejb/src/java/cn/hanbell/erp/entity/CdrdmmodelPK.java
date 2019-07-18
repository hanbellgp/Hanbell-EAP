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
public class CdrdmmodelPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cmccode")
    private String cmccode;

    public CdrdmmodelPK() {
    }

    public CdrdmmodelPK(String facno, String itnbr, String cmccode) {
        this.facno = facno;
        this.itnbr = itnbr;
        this.cmccode = cmccode;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getCmccode() {
        return cmccode;
    }

    public void setCmccode(String cmccode) {
        this.cmccode = cmccode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (cmccode != null ? cmccode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrdmmodelPK)) {
            return false;
        }
        CdrdmmodelPK other = (CdrdmmodelPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.cmccode == null && other.cmccode != null) || (this.cmccode != null && !this.cmccode.equals(other.cmccode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.shb.erp.CdrdmmodelPK[ facno=" + facno + ", itnbr=" + itnbr + ", cmccode=" + cmccode + " ]";
    }
    
}
