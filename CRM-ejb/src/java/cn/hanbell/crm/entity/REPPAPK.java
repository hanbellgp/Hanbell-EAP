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
public class REPPAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PA001")
    private String pa001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PA002")
    private String pa002;

    public REPPAPK() {
    }

    public REPPAPK(String pa001, String pa002) {
        this.pa001 = pa001;
        this.pa002 = pa002;
    }

    public String getPa001() {
        return pa001;
    }

    public void setPa001(String pa001) {
        this.pa001 = pa001;
    }

    public String getPa002() {
        return pa002;
    }

    public void setPa002(String pa002) {
        this.pa002 = pa002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pa001 != null ? pa001.hashCode() : 0);
        hash += (pa002 != null ? pa002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPPAPK)) {
            return false;
        }
        REPPAPK other = (REPPAPK) object;
        if ((this.pa001 == null && other.pa001 != null) || (this.pa001 != null && !this.pa001.equals(other.pa001))) {
            return false;
        }
        if ((this.pa002 == null && other.pa002 != null) || (this.pa002 != null && !this.pa002.equals(other.pa002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPPAPK[ pa001=" + pa001 + ", pa002=" + pa002 + " ]";
    }

}
