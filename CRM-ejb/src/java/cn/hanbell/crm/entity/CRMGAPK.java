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
public class CRMGAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "GA001")
    private String ga001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GA002")
    private String ga002;

    public CRMGAPK() {
    }

    public CRMGAPK(String ga001, String ga002) {
        this.ga001 = ga001;
        this.ga002 = ga002;
    }

    public String getGa001() {
        return ga001;
    }

    public void setGa001(String ga001) {
        this.ga001 = ga001;
    }

    public String getGa002() {
        return ga002;
    }

    public void setGa002(String ga002) {
        this.ga002 = ga002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ga001 != null ? ga001.hashCode() : 0);
        hash += (ga002 != null ? ga002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRMGAPK)) {
            return false;
        }
        CRMGAPK other = (CRMGAPK) object;
        if ((this.ga001 == null && other.ga001 != null) || (this.ga001 != null && !this.ga001.equals(other.ga001))) {
            return false;
        }
        if ((this.ga002 == null && other.ga002 != null) || (this.ga002 != null && !this.ga002.equals(other.ga002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CRMGAPK[ ga001=" + ga001 + ", ga002=" + ga002 + " ]";
    }
    
}
