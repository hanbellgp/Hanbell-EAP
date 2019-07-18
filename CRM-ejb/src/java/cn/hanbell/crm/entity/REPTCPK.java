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
public class REPTCPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TC001")
    private String tc001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TC002")
    private String tc002;

    public REPTCPK() {
    }

    public REPTCPK(String tc001, String tc002) {
        this.tc001 = tc001;
        this.tc002 = tc002;
    }

    public String getTc001() {
        return tc001;
    }

    public void setTc001(String tc001) {
        this.tc001 = tc001;
    }

    public String getTc002() {
        return tc002;
    }

    public void setTc002(String tc002) {
        this.tc002 = tc002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tc001 != null ? tc001.hashCode() : 0);
        hash += (tc002 != null ? tc002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTCPK)) {
            return false;
        }
        REPTCPK other = (REPTCPK) object;
        if ((this.tc001 == null && other.tc001 != null) || (this.tc001 != null && !this.tc001.equals(other.tc001))) {
            return false;
        }
        if ((this.tc002 == null && other.tc002 != null) || (this.tc002 != null && !this.tc002.equals(other.tc002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPTCPK[ tc001=" + tc001 + ", tc002=" + tc002 + " ]";
    }
    
}
