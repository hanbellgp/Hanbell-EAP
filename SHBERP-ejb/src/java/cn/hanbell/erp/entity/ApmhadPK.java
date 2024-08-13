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
public class ApmhadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "trno")
    private String trno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
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

    public ApmhadPK() {
    }

    public ApmhadPK(String facno, String trno, String vdrno, String accno, String detno) {
        this.facno = facno;
        this.trno = trno;
        this.vdrno = vdrno;
        this.accno = accno;
        this.detno = detno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getTrno() {
        return trno;
    }

    public void setTrno(String trno) {
        this.trno = trno;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (trno != null ? trno.hashCode() : 0);
        hash += (vdrno != null ? vdrno.hashCode() : 0);
        hash += (accno != null ? accno.hashCode() : 0);
        hash += (detno != null ? detno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmhadPK)) {
            return false;
        }
        ApmhadPK other = (ApmhadPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.trno == null && other.trno != null) || (this.trno != null && !this.trno.equals(other.trno))) {
            return false;
        }
        if ((this.vdrno == null && other.vdrno != null) || (this.vdrno != null && !this.vdrno.equals(other.vdrno))) {
            return false;
        }
        if ((this.accno == null && other.accno != null) || (this.accno != null && !this.accno.equals(other.accno))) {
            return false;
        }
        if ((this.detno == null && other.detno != null) || (this.detno != null && !this.detno.equals(other.detno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ApmhadPK[ facno=" + facno + ", trno=" + trno + ", vdrno=" + vdrno + ", accno=" + accno + ", detno=" + detno + " ]";
    }
    
}
