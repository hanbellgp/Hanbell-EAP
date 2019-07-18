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
public class InvsernoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "keyformat")
    private String keyformat;

    public InvsernoPK() {
    }

    public InvsernoPK(String facno, String trtype, String keyformat) {
        this.facno = facno;
        this.trtype = trtype;
        this.keyformat = keyformat;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getKeyformat() {
        return keyformat;
    }

    public void setKeyformat(String keyformat) {
        this.keyformat = keyformat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (trtype != null ? trtype.hashCode() : 0);
        hash += (keyformat != null ? keyformat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvsernoPK)) {
            return false;
        }
        InvsernoPK other = (InvsernoPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.trtype == null && other.trtype != null) || (this.trtype != null && !this.trtype.equals(other.trtype))) {
            return false;
        }
        if ((this.keyformat == null && other.keyformat != null) || (this.keyformat != null && !this.keyformat.equals(other.keyformat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.InvsernoPK[ facno=" + facno + ", trtype=" + trtype + ", keyformat=" + keyformat + " ]";
    }
    
}
