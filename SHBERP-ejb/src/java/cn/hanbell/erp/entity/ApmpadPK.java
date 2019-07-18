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
public class ApmpadPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "trse")
    private short trse;

    public ApmpadPK() {
    }

    public ApmpadPK(String facno, Character paycode, String payno, short trse) {
        this.facno = facno;
        this.paycode = paycode;
        this.payno = payno;
        this.trse = trse;
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

    public short getTrse() {
        return trse;
    }

    public void setTrse(short trse) {
        this.trse = trse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (paycode != null ? paycode.hashCode() : 0);
        hash += (payno != null ? payno.hashCode() : 0);
        hash += (int) trse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmpadPK)) {
            return false;
        }
        ApmpadPK other = (ApmpadPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.paycode == null && other.paycode != null) || (this.paycode != null && !this.paycode.equals(other.paycode))) {
            return false;
        }
        if ((this.payno == null && other.payno != null) || (this.payno != null && !this.payno.equals(other.payno))) {
            return false;
        }
        if (this.trse != other.trse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ApmpadPK[ facno=" + facno + ", paycode=" + paycode + ", payno=" + payno + ", trse=" + trse + " ]";
    }
    
}
