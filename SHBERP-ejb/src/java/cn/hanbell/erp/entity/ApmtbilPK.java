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
public class ApmtbilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "bilno")
    private String bilno;

    public ApmtbilPK() {
    }

    public ApmtbilPK(String facno, String bilno) {
        this.facno = facno;
        this.bilno = bilno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
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
        hash += (bilno != null ? bilno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmtbilPK)) {
            return false;
        }
        ApmtbilPK other = (ApmtbilPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.bilno == null && other.bilno != null) || (this.bilno != null && !this.bilno.equals(other.bilno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ApmtbilPK[ facno=" + facno + ", bilno=" + bilno + " ]";
    }

}
