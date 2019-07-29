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
public class CdrqasryPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "quono")
    private String quono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seq")
    private short seq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cmccode")
    private String cmccode;

    public CdrqasryPK() {
    }

    public CdrqasryPK(String facno, String quono, short trseq, short seq, String cmccode) {
        this.facno = facno;
        this.quono = quono;
        this.trseq = trseq;
        this.seq = seq;
        this.cmccode = cmccode;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    public short getSeq() {
        return seq;
    }

    public void setSeq(short seq) {
        this.seq = seq;
    }

    public String getCmccode() {
        return cmccode;
    }

    public void setCmccode(String cmccode) {
        this.cmccode = cmccode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (quono != null ? quono.hashCode() : 0);
        hash += (int) trseq;
        hash += (int) seq;
        hash += (cmccode != null ? cmccode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrqasryPK)) {
            return false;
        }
        CdrqasryPK other = (CdrqasryPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.quono == null && other.quono != null) || (this.quono != null && !this.quono.equals(other.quono))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        if (this.seq != other.seq) {
            return false;
        }
        if ((this.cmccode == null && other.cmccode != null) || (this.cmccode != null && !this.cmccode.equals(other.cmccode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrqasryPK[ facno=" + facno + ", quono=" + quono + ", trseq=" + trseq + ", seq=" + seq + ", cmccode=" + cmccode + " ]";
    }

}
