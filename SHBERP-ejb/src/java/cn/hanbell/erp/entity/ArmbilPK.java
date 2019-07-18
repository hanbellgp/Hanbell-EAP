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
public class ArmbilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "bilym")
    private String bilym;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "bilno")
    private String bilno;

    public ArmbilPK() {
    }

    public ArmbilPK(String facno, String bilym, String bilno) {
        this.facno = facno;
        this.bilym = bilym;
        this.bilno = bilno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBilym() {
        return bilym;
    }

    public void setBilym(String bilym) {
        this.bilym = bilym;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (bilym != null ? bilym.hashCode() : 0);
        hash += (bilno != null ? bilno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArmbilPK)) {
            return false;
        }
        ArmbilPK other = (ArmbilPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.bilym == null && other.bilym != null) || (this.bilym != null && !this.bilym.equals(other.bilym))) {
            return false;
        }
        if ((this.bilno == null && other.bilno != null) || (this.bilno != null && !this.bilno.equals(other.bilno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ArmbilPK[ facno=" + facno + ", bilym=" + bilym + ", bilno=" + bilno + " ]";
    }
    
}
