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
public class CdrbomsubDefaultPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itemtyp")
    private String itemtyp;

    public CdrbomsubDefaultPK() {
    }

    public CdrbomsubDefaultPK(String facno, String itnbrf, String itemtyp) {
        this.facno = facno;
        this.itnbrf = itnbrf;
        this.itemtyp = itemtyp;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getItemtyp() {
        return itemtyp;
    }

    public void setItemtyp(String itemtyp) {
        this.itemtyp = itemtyp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (itnbrf != null ? itnbrf.hashCode() : 0);
        hash += (itemtyp != null ? itemtyp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrbomsubDefaultPK)) {
            return false;
        }
        CdrbomsubDefaultPK other = (CdrbomsubDefaultPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.itnbrf == null && other.itnbrf != null) || (this.itnbrf != null && !this.itnbrf.equals(other.itnbrf))) {
            return false;
        }
        if ((this.itemtyp == null && other.itemtyp != null) || (this.itemtyp != null && !this.itemtyp.equals(other.itemtyp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrbomsubDefaultPK[ facno=" + facno + ", itnbrf=" + itnbrf + ", itemtyp=" + itemtyp + " ]";
    }
    
}
