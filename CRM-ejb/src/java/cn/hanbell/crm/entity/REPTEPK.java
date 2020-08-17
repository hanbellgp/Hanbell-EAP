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
public class REPTEPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TE001")
    private String te001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TE002")
    private String te002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TE004")
    private String te004;

    public REPTEPK() {
    }

    public REPTEPK(String te001, String te002, String te004) {
        this.te001 = te001;
        this.te002 = te002;
        this.te004 = te004;
    }

    public String getTe001() {
        return te001;
    }

    public void setTe001(String te001) {
        this.te001 = te001;
    }

    public String getTe002() {
        return te002;
    }

    public void setTe002(String te002) {
        this.te002 = te002;
    }

    public String getTe004() {
        return te004;
    }

    public void setTe004(String te004) {
        this.te004 = te004;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (te001 != null ? te001.hashCode() : 0);
        hash += (te002 != null ? te002.hashCode() : 0);
        hash += (te004 != null ? te004.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTEPK)) {
            return false;
        }
        REPTEPK other = (REPTEPK) object;
        if ((this.te001 == null && other.te001 != null) || (this.te001 != null && !this.te001.equals(other.te001))) {
            return false;
        }
        if ((this.te002 == null && other.te002 != null) || (this.te002 != null && !this.te002.equals(other.te002))) {
            return false;
        }
        if ((this.te004 == null && other.te004 != null) || (this.te004 != null && !this.te004.equals(other.te004))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPTEPK[ te001=" + te001 + ", te002=" + te002 + ", te004=" + te004 + " ]";
    }
    
}
