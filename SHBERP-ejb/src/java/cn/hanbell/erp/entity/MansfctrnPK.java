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
public class MansfctrnPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "trno")
    private String trno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;

    public MansfctrnPK() {
    }

    public MansfctrnPK(String facno, String prono, String manno, String trtype, String trno, short trseq) {
        this.facno = facno;
        this.prono = prono;
        this.manno = manno;
        this.trtype = trtype;
        this.trno = trno;
        this.trseq = trseq;
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

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getTrno() {
        return trno;
    }

    public void setTrno(String trno) {
        this.trno = trno;
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
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (manno != null ? manno.hashCode() : 0);
        hash += (trtype != null ? trtype.hashCode() : 0);
        hash += (trno != null ? trno.hashCode() : 0);
        hash += (int) trseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MansfctrnPK)) {
            return false;
        }
        MansfctrnPK other = (MansfctrnPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.manno == null && other.manno != null) || (this.manno != null && !this.manno.equals(other.manno))) {
            return false;
        }
        if ((this.trtype == null && other.trtype != null) || (this.trtype != null && !this.trtype.equals(other.trtype))) {
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
        return "cn.hanbell.erp.entity.MansfctrnPK[ facno=" + facno + ", prono=" + prono + ", manno=" + manno + ", trtype=" + trtype + ", trno=" + trno + ", trseq=" + trseq + " ]";
    }
    
}
