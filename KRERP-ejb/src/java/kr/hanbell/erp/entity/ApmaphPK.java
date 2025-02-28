/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.entity;

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
public class ApmaphPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "apno")
    private String apno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "aptyp")
    private String aptyp;

    public ApmaphPK() {
    }

    public ApmaphPK(String facno, String apno, String aptyp) {
        this.facno = facno;
        this.apno = apno;
        this.aptyp = aptyp;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getApno() {
        return apno;
    }

    public void setApno(String apno) {
        this.apno = apno;
    }

    public String getAptyp() {
        return aptyp;
    }

    public void setAptyp(String aptyp) {
        this.aptyp = aptyp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (apno != null ? apno.hashCode() : 0);
        hash += (aptyp != null ? aptyp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmaphPK)) {
            return false;
        }
        ApmaphPK other = (ApmaphPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.apno == null && other.apno != null) || (this.apno != null && !this.apno.equals(other.apno))) {
            return false;
        }
        if ((this.aptyp == null && other.aptyp != null) || (this.aptyp != null && !this.aptyp.equals(other.aptyp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.ApmaphPK[ facno=" + facno + ", apno=" + apno + ", aptyp=" + aptyp + " ]";
    }
    
}
