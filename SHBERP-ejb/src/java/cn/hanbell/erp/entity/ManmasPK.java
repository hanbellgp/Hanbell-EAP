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
 * @author kevindong
 */
@Embeddable
public class ManmasPK implements Serializable {

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
    @Column(name = "manno")
    private String manno;

    public ManmasPK() {
    }

    public ManmasPK(String facno, String prono, String manno) {
        this.facno = facno;
        this.prono = prono;
        this.manno = manno;
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

    public String getManno() {
        return manno;
    }

    public void setManno(String manno) {
        this.manno = manno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (manno != null ? manno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManmasPK)) {
            return false;
        }
        ManmasPK other = (ManmasPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.manno == null && other.manno != null) || (this.manno != null && !this.manno.equals(other.manno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ManmasPK[ facno=" + facno + ", prono=" + prono + ", manno=" + manno + " ]";
    }
    
}
