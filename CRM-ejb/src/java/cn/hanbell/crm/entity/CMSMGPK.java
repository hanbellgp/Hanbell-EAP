/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C2082
 */
@Embeddable
public class CMSMGPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MG001")
    private String mg001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MG002")
    private String mg002;

    public CMSMGPK() {
    }

    public CMSMGPK(String mg001, String mg002) {
        this.mg001 = mg001;
        this.mg002 = mg002;
    }

    public String getMg001() {
        return mg001;
    }

    public void setMg001(String mg001) {
        this.mg001 = mg001;
    }

    public String getMg002() {
        return mg002;
    }

    public void setMg002(String mg002) {
        this.mg002 = mg002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mg001 != null ? mg001.hashCode() : 0);
        hash += (mg002 != null ? mg002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMSMGPK)) {
            return false;
        }
        CMSMGPK other = (CMSMGPK) object;
        if ((this.mg001 == null && other.mg001 != null) || (this.mg001 != null && !this.mg001.equals(other.mg001))) {
            return false;
        }
        if ((this.mg002 == null && other.mg002 != null) || (this.mg002 != null && !this.mg002.equals(other.mg002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CMSMGPK[ mg001=" + mg001 + ", mg002=" + mg002 + " ]";
    }
    
}
