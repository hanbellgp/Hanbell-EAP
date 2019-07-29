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
public class PurvdrrelPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;

    public PurvdrrelPK() {
    }

    public PurvdrrelPK(String vdrno, short trseq) {
        this.vdrno = vdrno;
        this.trseq = trseq;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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
        hash += (vdrno != null ? vdrno.hashCode() : 0);
        hash += (int) trseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurvdrrelPK)) {
            return false;
        }
        PurvdrrelPK other = (PurvdrrelPK) object;
        if ((this.vdrno == null && other.vdrno != null) || (this.vdrno != null && !this.vdrno.equals(other.vdrno))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.PurvdrrelPK[ vdrno=" + vdrno + ", trseq=" + trseq + " ]";
    }

}
