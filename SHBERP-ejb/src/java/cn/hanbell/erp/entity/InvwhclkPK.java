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
public class InvwhclkPK implements Serializable {

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
    @Size(min = 1, max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "wclerk")
    private String wclerk;

    public InvwhclkPK() {
    }

    public InvwhclkPK(String facno, String prono, String wareh, String wclerk) {
        this.facno = facno;
        this.prono = prono;
        this.wareh = wareh;
        this.wclerk = wclerk;
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

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getWclerk() {
        return wclerk;
    }

    public void setWclerk(String wclerk) {
        this.wclerk = wclerk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (prono != null ? prono.hashCode() : 0);
        hash += (wareh != null ? wareh.hashCode() : 0);
        hash += (wclerk != null ? wclerk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvwhclkPK)) {
            return false;
        }
        InvwhclkPK other = (InvwhclkPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.prono == null && other.prono != null) || (this.prono != null && !this.prono.equals(other.prono))) {
            return false;
        }
        if ((this.wareh == null && other.wareh != null) || (this.wareh != null && !this.wareh.equals(other.wareh))) {
            return false;
        }
        if ((this.wclerk == null && other.wclerk != null) || (this.wclerk != null && !this.wclerk.equals(other.wclerk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.InvwhclkPK[ facno=" + facno + ", prono=" + prono + ", wareh=" + wareh + ", wclerk=" + wclerk + " ]";
    }
    
}
