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
public class DDGCPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GC001")
    private String gc001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "GC002")
    private String gc002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GC003")
    private String gc003;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "GC004")
    private String gc004;

    public DDGCPK() {
    }

    public DDGCPK(String gc001, String gc002, String gc003, String gc004) {
        this.gc001 = gc001;
        this.gc002 = gc002;
        this.gc003 = gc003;
        this.gc004 = gc004;
    }

    public String getGc001() {
        return gc001;
    }

    public void setGc001(String gc001) {
        this.gc001 = gc001;
    }

    public String getGc002() {
        return gc002;
    }

    public void setGc002(String gc002) {
        this.gc002 = gc002;
    }

    public String getGc003() {
        return gc003;
    }

    public void setGc003(String gc003) {
        this.gc003 = gc003;
    }

    public String getGc004() {
        return gc004;
    }

    public void setGc004(String gc004) {
        this.gc004 = gc004;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gc001 != null ? gc001.hashCode() : 0);
        hash += (gc002 != null ? gc002.hashCode() : 0);
        hash += (gc003 != null ? gc003.hashCode() : 0);
        hash += (gc004 != null ? gc004.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGCPK)) {
            return false;
        }
        DDGCPK other = (DDGCPK) object;
        if ((this.gc001 == null && other.gc001 != null) || (this.gc001 != null && !this.gc001.equals(other.gc001))) {
            return false;
        }
        if ((this.gc002 == null && other.gc002 != null) || (this.gc002 != null && !this.gc002.equals(other.gc002))) {
            return false;
        }
        if ((this.gc003 == null && other.gc003 != null) || (this.gc003 != null && !this.gc003.equals(other.gc003))) {
            return false;
        }
        if ((this.gc004 == null && other.gc004 != null) || (this.gc004 != null && !this.gc004.equals(other.gc004))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGCPK[ gc001=" + gc001 + ", gc002=" + gc002 + ", gc003=" + gc003 + ", gc004=" + gc004 + " ]";
    }
    
}
