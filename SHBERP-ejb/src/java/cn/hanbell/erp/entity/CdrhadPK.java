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
public class CdrhadPK implements Serializable {
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

    public CdrhadPK() {
    }

    public CdrhadPK(String facno, String shpno) {
        this.facno = facno;
        this.shpno = shpno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (shpno != null ? shpno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrhadPK)) {
            return false;
        }
        CdrhadPK other = (CdrhadPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.shpno == null && other.shpno != null) || (this.shpno != null && !this.shpno.equals(other.shpno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.CdrhadPK[ facno=" + facno + ", shpno=" + shpno + " ]";
    }
    
}
