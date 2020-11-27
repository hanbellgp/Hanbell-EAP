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
public class ManwipbalPK implements Serializable {

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
    @Size(min = 1, max = 18)
    @Column(name = "manno")
    private String manno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "prosscode")
    private String prosscode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "wrcode")
    private String wrcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "pctno")
    private String pctno;

    public ManwipbalPK() {
    }

    public ManwipbalPK(String facno, String prono, String manno, String prosscode, String wrcode, String pctno) {
        this.facno = facno;
        this.prono = prono;
        this.manno = manno;
        this.prosscode = prosscode;
        this.wrcode = wrcode;
        this.pctno = pctno;
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

    public String getManno() {
        return manno;
    }

    public void setManno(String manno) {
        this.manno = manno;
    }

    public String getProsscode() {
        return prosscode;
    }

    public void setProsscode(String prosscode) {
        this.prosscode = prosscode;
    }

    public String getWrcode() {
        return wrcode;
    }

    public void setWrcode(String wrcode) {
        this.wrcode = wrcode;
    }

    public String getPctno() {
        return pctno;
    }

    public void setPctno(String pctno) {
        this.pctno = pctno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (manno != null ? manno.hashCode() : 0);
        hash += (prosscode != null ? prosscode.hashCode() : 0);
        hash += (wrcode != null ? wrcode.hashCode() : 0);
        hash += (pctno != null ? pctno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManwipbalPK)) {
            return false;
        }
        ManwipbalPK other = (ManwipbalPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.manno == null && other.manno != null) || (this.manno != null && !this.manno.equals(other.manno))) {
            return false;
        }
        if ((this.prosscode == null && other.prosscode != null) || (this.prosscode != null && !this.prosscode.equals(other.prosscode))) {
            return false;
        }
        if ((this.wrcode == null && other.wrcode != null) || (this.wrcode != null && !this.wrcode.equals(other.wrcode))) {
            return false;
        }
        if ((this.pctno == null && other.pctno != null) || (this.pctno != null && !this.pctno.equals(other.pctno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ManwipbalPK[ facno=" + facno + ", prono=" + prono + ", manno=" + manno + ", prosscode=" + prosscode + ", wrcode=" + wrcode + ", pctno=" + pctno + " ]";
    }
    
}
