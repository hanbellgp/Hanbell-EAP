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
public class PursernoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "prono")
    private String prono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "difcode")
    private Character difcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "keyformat")
    private String keyformat;

    public PursernoPK() {
    }

    public PursernoPK(String facno, String prono, Character difcode, String keyformat) {
        this.facno = facno;
        this.prono = prono;
        this.difcode = difcode;
        this.keyformat = keyformat;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public Character getDifcode() {
        return difcode;
    }

    public void setDifcode(Character difcode) {
        this.difcode = difcode;
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
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (difcode != null ? difcode.hashCode() : 0);
        hash += (keyformat != null ? keyformat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PursernoPK)) {
            return false;
        }
        PursernoPK other = (PursernoPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.difcode == null && other.difcode != null) || (this.difcode != null && !this.difcode.equals(other.difcode))) {
            return false;
        }
        if ((this.keyformat == null && other.keyformat != null) || (this.keyformat != null && !this.keyformat.equals(other.keyformat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.PursernoPK[ facno=" + facno + ", prono=" + prono + ", difcode=" + difcode + ", keyformat=" + keyformat + " ]";
    }
    
}
