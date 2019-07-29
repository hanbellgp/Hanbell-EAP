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
public class InvpriPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "yearmon")
    private String yearmon;
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

    public InvpriPK() {
    }

    public InvpriPK(String yearmon, String itnbr, String facno) {
        this.yearmon = yearmon;
        this.itnbr = itnbr;
        this.facno = facno;
    }

    public String getYearmon() {
        return yearmon;
    }

    public void setYearmon(String yearmon) {
        this.yearmon = yearmon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yearmon != null ? yearmon.hashCode() : 0);
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (facno != null ? facno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvpriPK)) {
            return false;
        }
        InvpriPK other = (InvpriPK) object;
        if ((this.yearmon == null && other.yearmon != null) || (this.yearmon != null && !this.yearmon.equals(other.yearmon))) {
            return false;
        }
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.InvpriPK[ yearmon=" + yearmon + ", itnbr=" + itnbr + ", facno=" + facno + " ]";
    }

}
