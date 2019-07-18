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
 * @author Administrator
 */
@Embeddable
public class SERCAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CA001")
    private String ca001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CA002")
    private String ca002;

    public SERCAPK() {
    }

    public SERCAPK(String ca001, String ca002) {
        this.ca001 = ca001;
        this.ca002 = ca002;
    }

    public String getCa001() {
        return ca001;
    }

    public void setCa001(String ca001) {
        this.ca001 = ca001;
    }

    public String getCa002() {
        return ca002;
    }

    public void setCa002(String ca002) {
        this.ca002 = ca002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ca001 != null ? ca001.hashCode() : 0);
        hash += (ca002 != null ? ca002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERCAPK)) {
            return false;
        }
        SERCAPK other = (SERCAPK) object;
        if ((this.ca001 == null && other.ca001 != null) || (this.ca001 != null && !this.ca001.equals(other.ca001))) {
            return false;
        }
        if ((this.ca002 == null && other.ca002 != null) || (this.ca002 != null && !this.ca002.equals(other.ca002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.ejb.SERCAPK[ ca001=" + ca001 + ", ca002=" + ca002 + " ]";
    }
    
}
