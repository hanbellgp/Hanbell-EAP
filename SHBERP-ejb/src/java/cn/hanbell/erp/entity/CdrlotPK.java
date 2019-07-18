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
public class CdrlotPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "shpno")
    private String shpno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seq")
    private short seq;

    public CdrlotPK() {
    }

    public CdrlotPK(String facno, String shpno, short trseq, short seq) {
        this.facno = facno;
        this.shpno = shpno;
        this.trseq = trseq;
        this.seq = seq;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (shpno != null ? shpno.hashCode() : 0);
        hash += (int) trseq;
        hash += (int) seq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrlotPK)) {
            return false;
        }
        CdrlotPK other = (CdrlotPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.shpno == null && other.shpno != null) || (this.shpno != null && !this.shpno.equals(other.shpno))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        if (this.seq != other.seq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrlotPK[ facno=" + facno + ", shpno=" + shpno + ", trseq=" + trseq + ", seq=" + seq + " ]";
    }
    
}
