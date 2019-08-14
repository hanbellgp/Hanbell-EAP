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
public class REPPBPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PB001")
    private String pb001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PB002")
    private String pb002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PB003")
    private String pb003;

    public REPPBPK() {
    }

    public REPPBPK(String pb001, String pb002, String pb003) {
        this.pb001 = pb001;
        this.pb002 = pb002;
        this.pb003 = pb003;
    }

    public String getPb001() {
        return pb001;
    }

    public void setPb001(String pb001) {
        this.pb001 = pb001;
    }

    public String getPb002() {
        return pb002;
    }

    public void setPb002(String pb002) {
        this.pb002 = pb002;
    }

    public String getPb003() {
        return pb003;
    }

    public void setPb003(String pb003) {
        this.pb003 = pb003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pb001 != null ? pb001.hashCode() : 0);
        hash += (pb002 != null ? pb002.hashCode() : 0);
        hash += (pb003 != null ? pb003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPPBPK)) {
            return false;
        }
        REPPBPK other = (REPPBPK) object;
        if ((this.pb001 == null && other.pb001 != null) || (this.pb001 != null && !this.pb001.equals(other.pb001))) {
            return false;
        }
        if ((this.pb002 == null && other.pb002 != null) || (this.pb002 != null && !this.pb002.equals(other.pb002))) {
            return false;
        }
        if ((this.pb003 == null && other.pb003 != null) || (this.pb003 != null && !this.pb003.equals(other.pb003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPPBPK[ pb001=" + pb001 + ", pb002=" + pb002 + ", pb003=" + pb003 + " ]";
    }

}
