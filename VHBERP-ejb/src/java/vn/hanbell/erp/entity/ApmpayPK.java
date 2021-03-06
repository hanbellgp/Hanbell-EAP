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
 * @author Administrator
 */
@Embeddable
public class ApmpayPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycode")
    private Character paycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "payno")
    private String payno;

    public ApmpayPK() {
    }

    public ApmpayPK(String facno, Character paycode, String payno) {
        this.facno = facno;
        this.paycode = paycode;
        this.payno = payno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Character getPaycode() {
        return paycode;
    }

    public void setPaycode(Character paycode) {
        this.paycode = paycode;
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (paycode != null ? paycode.hashCode() : 0);
        hash += (payno != null ? payno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmpayPK)) {
            return false;
        }
        ApmpayPK other = (ApmpayPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.paycode == null && other.paycode != null) || (this.paycode != null && !this.paycode.equals(other.paycode))) {
            return false;
        }
        if ((this.payno == null && other.payno != null) || (this.payno != null && !this.payno.equals(other.payno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.ApmpayPK[ facno=" + facno + ", paycode=" + paycode + ", payno=" + payno + " ]";
    }
    
}
