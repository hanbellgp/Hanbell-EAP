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
public class CdrbrhadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "brtrno")
    private String brtrno;

    public CdrbrhadPK() {
    }

    public CdrbrhadPK(String facno, String brtrno) {
        this.facno = facno;
        this.brtrno = brtrno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBrtrno() {
        return brtrno;
    }

    public void setBrtrno(String brtrno) {
        this.brtrno = brtrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (brtrno != null ? brtrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrbrhadPK)) {
            return false;
        }
        CdrbrhadPK other = (CdrbrhadPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.brtrno == null && other.brtrno != null) || (this.brtrno != null && !this.brtrno.equals(other.brtrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrbrhadPK[ facno=" + facno + ", brtrno=" + brtrno + " ]";
    }
    
}
