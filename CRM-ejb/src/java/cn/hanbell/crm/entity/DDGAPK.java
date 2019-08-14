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
public class DDGAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GA001")
    private String ga001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "GA002")
    private String ga002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GA003")
    private String ga003;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "GA004")
    private String ga004;

    public DDGAPK() {
    }

    public DDGAPK(String ga001, String ga002, String ga003, String ga004) {
        this.ga001 = ga001;
        this.ga002 = ga002;
        this.ga003 = ga003;
        this.ga004 = ga004;
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

    public String getGa003() {
        return ga003;
    }

    public void setGa003(String ga003) {
        this.ga003 = ga003;
    }

    public String getGa004() {
        return ga004;
    }

    public void setGa004(String ga004) {
        this.ga004 = ga004;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ga001 != null ? ga001.hashCode() : 0);
        hash += (ga002 != null ? ga002.hashCode() : 0);
        hash += (ga003 != null ? ga003.hashCode() : 0);
        hash += (ga004 != null ? ga004.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGAPK)) {
            return false;
        }
        DDGAPK other = (DDGAPK) object;
        if ((this.ga001 == null && other.ga001 != null) || (this.ga001 != null && !this.ga001.equals(other.ga001))) {
            return false;
        }
        if ((this.ga002 == null && other.ga002 != null) || (this.ga002 != null && !this.ga002.equals(other.ga002))) {
            return false;
        }
        if ((this.ga003 == null && other.ga003 != null) || (this.ga003 != null && !this.ga003.equals(other.ga003))) {
            return false;
        }
        if ((this.ga004 == null && other.ga004 != null) || (this.ga004 != null && !this.ga004.equals(other.ga004))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGAPK[ ga001=" + ga001 + ", ga002=" + ga002 + ", ga003=" + ga003 + ", ga004=" + ga004 + " ]";
    }

}
