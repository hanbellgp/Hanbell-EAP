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
public class REPTMPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TM001")
    private String tm001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TM002")
    private String tm002;

    public REPTMPK() {
    }

    public REPTMPK(String tm001, String tm002) {
        this.tm001 = tm001;
        this.tm002 = tm002;
    }

    public String getTm001() {
        return tm001;
    }

    public void setTm001(String tm001) {
        this.tm001 = tm001;
    }

    public String getTm002() {
        return tm002;
    }

    public void setTm002(String tm002) {
        this.tm002 = tm002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tm001 != null ? tm001.hashCode() : 0);
        hash += (tm002 != null ? tm002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTMPK)) {
            return false;
        }
        REPTMPK other = (REPTMPK) object;
        if ((this.tm001 == null && other.tm001 != null) || (this.tm001 != null && !this.tm001.equals(other.tm001))) {
            return false;
        }
        if ((this.tm002 == null && other.tm002 != null) || (this.tm002 != null && !this.tm002.equals(other.tm002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPTMPK[ tm001=" + tm001 + ", tm002=" + tm002 + " ]";
    }
    
}
