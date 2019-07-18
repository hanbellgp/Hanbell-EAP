/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.entity;

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
public class HZFWDPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "hzfwd001")
    private String hzfwd001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "hzfwd002")
    private String hzfwd002;

    public HZFWDPK() {
    }

    public HZFWDPK(String hzfwd001, String hzfwd002) {
        this.hzfwd001 = hzfwd001;
        this.hzfwd002 = hzfwd002;
    }

    public String getHzfwd001() {
        return hzfwd001;
    }

    public void setHzfwd001(String hzfwd001) {
        this.hzfwd001 = hzfwd001;
    }

    public String getHzfwd002() {
        return hzfwd002;
    }

    public void setHzfwd002(String hzfwd002) {
        this.hzfwd002 = hzfwd002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hzfwd001 != null ? hzfwd001.hashCode() : 0);
        hash += (hzfwd002 != null ? hzfwd002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZFWDPK)) {
            return false;
        }
        HZFWDPK other = (HZFWDPK) object;
        if ((this.hzfwd001 == null && other.hzfwd001 != null) || (this.hzfwd001 != null && !this.hzfwd001.equals(other.hzfwd001))) {
            return false;
        }
        if ((this.hzfwd002 == null && other.hzfwd002 != null) || (this.hzfwd002 != null && !this.hzfwd002.equals(other.hzfwd002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.efnet.entity.HZFWDPK[ hzfwd001=" + hzfwd001 + ", hzfwd002=" + hzfwd002 + " ]";
    }
    
}
