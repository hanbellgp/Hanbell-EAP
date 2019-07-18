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
public class CdrivoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ivocusno")
    private String ivocusno;

    public CdrivoPK() {
    }

    public CdrivoPK(String cusno, short trseq, String ivocusno) {
        this.cusno = cusno;
        this.trseq = trseq;
        this.ivocusno = ivocusno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    public String getIvocusno() {
        return ivocusno;
    }

    public void setIvocusno(String ivocusno) {
        this.ivocusno = ivocusno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusno != null ? cusno.hashCode() : 0);
        hash += (int) trseq;
        hash += (ivocusno != null ? ivocusno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrivoPK)) {
            return false;
        }
        CdrivoPK other = (CdrivoPK) object;
        if ((this.cusno == null && other.cusno != null) || (this.cusno != null && !this.cusno.equals(other.cusno))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        if ((this.ivocusno == null && other.ivocusno != null) || (this.ivocusno != null && !this.ivocusno.equals(other.ivocusno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrivoPK[ cusno=" + cusno + ", trseq=" + trseq + ", ivocusno=" + ivocusno + " ]";
    }
    
}
