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
public class ApmrnoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scode")
    private String scode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "maxnumber")
    private String maxnumber;

    public ApmrnoPK() {
    }

    public ApmrnoPK(String facno, String scode, String maxnumber) {
        this.facno = facno;
        this.scode = scode;
        this.maxnumber = maxnumber;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(String maxnumber) {
        this.maxnumber = maxnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (scode != null ? scode.hashCode() : 0);
        hash += (maxnumber != null ? maxnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmrnoPK)) {
            return false;
        }
        ApmrnoPK other = (ApmrnoPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        if ((this.maxnumber == null && other.maxnumber != null) || (this.maxnumber != null && !this.maxnumber.equals(other.maxnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ApmrnoPK[ facno=" + facno + ", scode=" + scode + ", maxnumber=" + maxnumber + " ]";
    }

}
