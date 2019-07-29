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
public class CdrpaydscPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "difcode")
    private Character difcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "allcode")
    private String allcode;

    public CdrpaydscPK() {
    }

    public CdrpaydscPK(Character difcode, String allcode) {
        this.difcode = difcode;
        this.allcode = allcode;
    }

    public Character getDifcode() {
        return difcode;
    }

    public void setDifcode(Character difcode) {
        this.difcode = difcode;
    }

    public String getAllcode() {
        return allcode;
    }

    public void setAllcode(String allcode) {
        this.allcode = allcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (difcode != null ? difcode.hashCode() : 0);
        hash += (allcode != null ? allcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrpaydscPK)) {
            return false;
        }
        CdrpaydscPK other = (CdrpaydscPK) object;
        if ((this.difcode == null && other.difcode != null) || (this.difcode != null && !this.difcode.equals(other.difcode))) {
            return false;
        }
        if ((this.allcode == null && other.allcode != null) || (this.allcode != null && !this.allcode.equals(other.allcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrpaydscPK[ difcode=" + difcode + ", allcode=" + allcode + " ]";
    }

}
