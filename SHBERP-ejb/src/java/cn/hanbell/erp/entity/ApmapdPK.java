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
public class ApmapdPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;

    public ApmapdPK() {
    }

    public ApmapdPK(String facno, String apno, String aptyp, short trseq) {
        this.facno = facno;
        this.apno = apno;
        this.aptyp = aptyp;
        this.trseq = trseq;
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

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (apno != null ? apno.hashCode() : 0);
        hash += (aptyp != null ? aptyp.hashCode() : 0);
        hash += (int) trseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmapdPK)) {
            return false;
        }
        ApmapdPK other = (ApmapdPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.apno == null && other.apno != null) || (this.apno != null && !this.apno.equals(other.apno))) {
            return false;
        }
        if ((this.aptyp == null && other.aptyp != null) || (this.aptyp != null && !this.aptyp.equals(other.aptyp))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ApmapdPK[ facno=" + facno + ", apno=" + apno + ", aptyp=" + aptyp + ", trseq=" + trseq + " ]";
    }
    
}
