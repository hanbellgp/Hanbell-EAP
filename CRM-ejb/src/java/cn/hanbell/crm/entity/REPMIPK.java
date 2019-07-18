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
public class REPMIPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "MI001")
    private String mi001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MI002")
    private String mi002;

    public REPMIPK() {
    }

    public REPMIPK(String mi001, String mi002) {
        this.mi001 = mi001;
        this.mi002 = mi002;
    }

    public String getMi001() {
        return mi001;
    }

    public void setMi001(String mi001) {
        this.mi001 = mi001;
    }

    public String getMi002() {
        return mi002;
    }

    public void setMi002(String mi002) {
        this.mi002 = mi002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mi001 != null ? mi001.hashCode() : 0);
        hash += (mi002 != null ? mi002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMIPK)) {
            return false;
        }
        REPMIPK other = (REPMIPK) object;
        if ((this.mi001 == null && other.mi001 != null) || (this.mi001 != null && !this.mi001.equals(other.mi001))) {
            return false;
        }
        if ((this.mi002 == null && other.mi002 != null) || (this.mi002 != null && !this.mi002.equals(other.mi002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMIPK[ mi001=" + mi001 + ", mi002=" + mi002 + " ]";
    }
    
}
