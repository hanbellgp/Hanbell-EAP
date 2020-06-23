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
 * @author C2082
 */
@Embeddable
public class REPMUPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MU001")
    private String mu001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MU003")
    private String mu003;

    public REPMUPK() {
    }

    public REPMUPK(String mu001, String mu003) {
        this.mu001 = mu001;
        this.mu003 = mu003;
    }

    public String getMu001() {
        return mu001;
    }

    public void setMu001(String mu001) {
        this.mu001 = mu001;
    }

    public String getMu003() {
        return mu003;
    }

    public void setMu003(String mu003) {
        this.mu003 = mu003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mu001 != null ? mu001.hashCode() : 0);
        hash += (mu003 != null ? mu003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMUPK)) {
            return false;
        }
        REPMUPK other = (REPMUPK) object;
        if ((this.mu001 == null && other.mu001 != null) || (this.mu001 != null && !this.mu001.equals(other.mu001))) {
            return false;
        }
        if ((this.mu003 == null && other.mu003 != null) || (this.mu003 != null && !this.mu003.equals(other.mu003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMUPK[ mu001=" + mu001 + ", mu003=" + mu003 + " ]";
    }
    
}
