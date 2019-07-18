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
public class InvdtaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
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
    @Column(name = "trno")
    private String trno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private int trseq;

    public InvdtaPK() {
    }

    public InvdtaPK(String itnbr, String facno, String prono, String trno, int trseq) {
        this.itnbr = itnbr;
        this.facno = facno;
        this.prono = prono;
        this.trno = trno;
        this.trseq = trseq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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

    public String getTrno() {
        return trno;
    }

    public void setTrno(String trno) {
        this.trno = trno;
    }

    public int getTrseq() {
        return trseq;
    }

    public void setTrseq(int trseq) {
        this.trseq = trseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (trno != null ? trno.hashCode() : 0);
        hash += (int) trseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvdtaPK)) {
            return false;
        }
        InvdtaPK other = (InvdtaPK) object;
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.trno == null && other.trno != null) || (this.trno != null && !this.trno.equals(other.trno))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.InvdtaPK[ itnbr=" + itnbr + ", facno=" + facno + ", prono=" + prono + ", trno=" + trno + ", trseq=" + trseq + " ]";
    }
    
}
