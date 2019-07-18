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
public class ArmhadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "hadno")
    private String hadno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hadseq")
    private short hadseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "accno")
    private String accno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "detno")
    private String detno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hseq")
    private short hseq;

    public ArmhadPK() {
    }

    public ArmhadPK(String facno, String cusno, String hadno, short hadseq, String accno, String detno, short hseq) {
        this.facno = facno;
        this.cusno = cusno;
        this.hadno = hadno;
        this.hadseq = hadseq;
        this.accno = accno;
        this.detno = detno;
        this.hseq = hseq;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getHadno() {
        return hadno;
    }

    public void setHadno(String hadno) {
        this.hadno = hadno;
    }

    public short getHadseq() {
        return hadseq;
    }

    public void setHadseq(short hadseq) {
        this.hadseq = hadseq;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getDetno() {
        return detno;
    }

    public void setDetno(String detno) {
        this.detno = detno;
    }

    public short getHseq() {
        return hseq;
    }

    public void setHseq(short hseq) {
        this.hseq = hseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (cusno != null ? cusno.hashCode() : 0);
        hash += (hadno != null ? hadno.hashCode() : 0);
        hash += (int) hadseq;
        hash += (accno != null ? accno.hashCode() : 0);
        hash += (detno != null ? detno.hashCode() : 0);
        hash += (int) hseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArmhadPK)) {
            return false;
        }
        ArmhadPK other = (ArmhadPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.cusno == null && other.cusno != null) || (this.cusno != null && !this.cusno.equals(other.cusno))) {
            return false;
        }
        if ((this.hadno == null && other.hadno != null) || (this.hadno != null && !this.hadno.equals(other.hadno))) {
            return false;
        }
        if (this.hadseq != other.hadseq) {
            return false;
        }
        if ((this.accno == null && other.accno != null) || (this.accno != null && !this.accno.equals(other.accno))) {
            return false;
        }
        if ((this.detno == null && other.detno != null) || (this.detno != null && !this.detno.equals(other.detno))) {
            return false;
        }
        if (this.hseq != other.hseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.ArmhadPK[ facno=" + facno + ", cusno=" + cusno + ", hadno=" + hadno + ", hadseq=" + hadseq + ", accno=" + accno + ", detno=" + detno + ", hseq=" + hseq + " ]";
    }
    
}
