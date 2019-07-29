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
public class ApmpyhPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "acpno")
    private String acpno;

    public ApmpyhPK() {
    }

    public ApmpyhPK(String facno, String acpno) {
        this.facno = facno;
        this.acpno = acpno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getAcpno() {
        return acpno;
    }

    public void setAcpno(String acpno) {
        this.acpno = acpno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (acpno != null ? acpno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApmpyhPK)) {
            return false;
        }
        ApmpyhPK other = (ApmpyhPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.acpno == null && other.acpno != null) || (this.acpno != null && !this.acpno.equals(other.acpno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ApmpyhPK[ facno=" + facno + ", acpno=" + acpno + " ]";
    }

}
