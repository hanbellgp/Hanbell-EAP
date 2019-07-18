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
public class DDGDPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "GD001")
    private String gd001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GD002")
    private String gd002;

    public DDGDPK() {
    }

    public DDGDPK(String gd001, String gd002) {
        this.gd001 = gd001;
        this.gd002 = gd002;
    }

    public String getGd001() {
        return gd001;
    }

    public void setGd001(String gd001) {
        this.gd001 = gd001;
    }

    public String getGd002() {
        return gd002;
    }

    public void setGd002(String gd002) {
        this.gd002 = gd002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gd001 != null ? gd001.hashCode() : 0);
        hash += (gd002 != null ? gd002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGDPK)) {
            return false;
        }
        DDGDPK other = (DDGDPK) object;
        if ((this.gd001 == null && other.gd001 != null) || (this.gd001 != null && !this.gd001.equals(other.gd001))) {
            return false;
        }
        if ((this.gd002 == null && other.gd002 != null) || (this.gd002 != null && !this.gd002.equals(other.gd002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGDPK[ gd001=" + gd001 + ", gd002=" + gd002 + " ]";
    }
    
}
