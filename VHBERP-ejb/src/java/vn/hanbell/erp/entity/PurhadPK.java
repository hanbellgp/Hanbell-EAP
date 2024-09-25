/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ZFF
 */
@Embeddable
public class PurhadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "prono")
    private String prono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "pono")
    private String pono;

    public PurhadPK() {
    }

    public PurhadPK(String facno, String prono, String pono) {
        this.facno = facno;
        this.prono = prono;
        this.pono = pono;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (pono != null ? pono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurhadPK)) {
            return false;
        }
        PurhadPK other = (PurhadPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.pono == null && other.pono != null) || (this.pono != null && !this.pono.equals(other.pono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.PurhadPK[ facno=" + facno + ", prono=" + prono + ", pono=" + pono + " ]";
    }
    
}
