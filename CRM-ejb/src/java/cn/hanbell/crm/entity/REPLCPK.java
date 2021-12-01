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
public class REPLCPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "LC001")
    private String lc001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "LC002")
    private String lc002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "LC003")
    private String lc003;

    public REPLCPK() {
    }

    public REPLCPK(String lc001, String lc002, String lc003) {
        this.lc001 = lc001;
        this.lc002 = lc002;
        this.lc003 = lc003;
    }

    public String getLc001() {
        return lc001;
    }

    public void setLc001(String lc001) {
        this.lc001 = lc001;
    }

    public String getLc002() {
        return lc002;
    }

    public void setLc002(String lc002) {
        this.lc002 = lc002;
    }

    public String getLc003() {
        return lc003;
    }

    public void setLc003(String lc003) {
        this.lc003 = lc003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lc001 != null ? lc001.hashCode() : 0);
        hash += (lc002 != null ? lc002.hashCode() : 0);
        hash += (lc003 != null ? lc003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPLCPK)) {
            return false;
        }
        REPLCPK other = (REPLCPK) object;
        if ((this.lc001 == null && other.lc001 != null) || (this.lc001 != null && !this.lc001.equals(other.lc001))) {
            return false;
        }
        if ((this.lc002 == null && other.lc002 != null) || (this.lc002 != null && !this.lc002.equals(other.lc002))) {
            return false;
        }
        if ((this.lc003 == null && other.lc003 != null) || (this.lc003 != null && !this.lc003.equals(other.lc003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPLCPK[ lc001=" + lc001 + ", lc002=" + lc002 + ", lc003=" + lc003 + " ]";
    }
    
}
