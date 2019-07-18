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
public class AccacrPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sysno")
    private String sysno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "kind")
    private String kind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "rkd")
    private String rkd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accseq")
    private short accseq;

    public AccacrPK() {
    }

    public AccacrPK(String facno, String sysno, String kind, String rkd, short accseq) {
        this.facno = facno;
        this.sysno = sysno;
        this.kind = kind;
        this.rkd = rkd;
        this.accseq = accseq;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getRkd() {
        return rkd;
    }

    public void setRkd(String rkd) {
        this.rkd = rkd;
    }

    public short getAccseq() {
        return accseq;
    }

    public void setAccseq(short accseq) {
        this.accseq = accseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (sysno != null ? sysno.hashCode() : 0);
        hash += (kind != null ? kind.hashCode() : 0);
        hash += (rkd != null ? rkd.hashCode() : 0);
        hash += (int) accseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccacrPK)) {
            return false;
        }
        AccacrPK other = (AccacrPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.sysno == null && other.sysno != null) || (this.sysno != null && !this.sysno.equals(other.sysno))) {
            return false;
        }
        if ((this.kind == null && other.kind != null) || (this.kind != null && !this.kind.equals(other.kind))) {
            return false;
        }
        if ((this.rkd == null && other.rkd != null) || (this.rkd != null && !this.rkd.equals(other.rkd))) {
            return false;
        }
        if (this.accseq != other.accseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.AccacrPK[ facno=" + facno + ", sysno=" + sysno + ", kind=" + kind + ", rkd=" + rkd + ", accseq=" + accseq + " ]";
    }
    
}
