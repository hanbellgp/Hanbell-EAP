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
public class ManwipbatPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "fixnr")
    private String fixnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "varnr")
    private String varnr;

    public ManwipbatPK() {
    }

    public ManwipbatPK(String facno, String prono, String manno, String prosscode, String wrcode, String pctno, String depno, String fixnr, String varnr) {
        this.facno = facno;
        this.prono = prono;
        this.manno = manno;
        this.prosscode = prosscode;
        this.wrcode = wrcode;
        this.pctno = pctno;
        this.depno = depno;
        this.fixnr = fixnr;
        this.varnr = varnr;
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

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
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
        hash += (depno != null ? depno.hashCode() : 0);
        hash += (fixnr != null ? fixnr.hashCode() : 0);
        hash += (varnr != null ? varnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManwipbatPK)) {
            return false;
        }
        ManwipbatPK other = (ManwipbatPK) object;
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
        if ((this.depno == null && other.depno != null) || (this.depno != null && !this.depno.equals(other.depno))) {
            return false;
        }
        if ((this.fixnr == null && other.fixnr != null) || (this.fixnr != null && !this.fixnr.equals(other.fixnr))) {
            return false;
        }
        if ((this.varnr == null && other.varnr != null) || (this.varnr != null && !this.varnr.equals(other.varnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.ManwipbatPK[ facno=" + facno + ", prono=" + prono + ", manno=" + manno + ", prosscode=" + prosscode + ", wrcode=" + wrcode + ", pctno=" + pctno + ", depno=" + depno + ", fixnr=" + fixnr + ", varnr=" + varnr + " ]";
    }
    
}
