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
public class SALFTPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FT001")
    private String ft001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FT002")
    private String ft002;

    public SALFTPK() {
    }

    public SALFTPK(String ft001, String ft002) {
        this.ft001 = ft001;
        this.ft002 = ft002;
    }

    public String getFt001() {
        return ft001;
    }

    public void setFt001(String ft001) {
        this.ft001 = ft001;
    }

    public String getFt002() {
        return ft002;
    }

    public void setFt002(String ft002) {
        this.ft002 = ft002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ft001 != null ? ft001.hashCode() : 0);
        hash += (ft002 != null ? ft002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SALFTPK)) {
            return false;
        }
        SALFTPK other = (SALFTPK) object;
        if ((this.ft001 == null && other.ft001 != null) || (this.ft001 != null && !this.ft001.equals(other.ft001))) {
            return false;
        }
        if ((this.ft002 == null && other.ft002 != null) || (this.ft002 != null && !this.ft002.equals(other.ft002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SALFTPK[ ft001=" + ft001 + ", ft002=" + ft002 + " ]";
    }
    
}
