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
public class PurdaskdscPK implements Serializable {

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
    @Column(name = "prno")
    private String prno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;

    public PurdaskdscPK() {
    }

    public PurdaskdscPK(String facno, String prono, String prno, short trseq) {
        this.facno = facno;
        this.prono = prono;
        this.prno = prno;
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

    public String getPrno() {
        return prno;
    }

    public void setPrno(String prno) {
        this.prno = prno;
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
        hash += (prno != null ? prno.hashCode() : 0);
        hash += (int) trseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurdaskdscPK)) {
            return false;
        }
        PurdaskdscPK other = (PurdaskdscPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.prno == null && other.prno != null) || (this.prno != null && !this.prno.equals(other.prno))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.PurdaskdscPK[ facno=" + facno + ", prono=" + prono + ", prno=" + prno + ", trseq=" + trseq + " ]";
    }
    
}
