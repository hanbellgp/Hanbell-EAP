/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C1587
 */
@Embeddable
public class SecusysPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sysno")
    private String sysno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;

    public SecusysPK() {
    }

    public SecusysPK(String sysno, String userno) {
        this.sysno = sysno;
        this.userno = userno;
    }

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysno != null ? sysno.hashCode() : 0);
        hash += (userno != null ? userno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecusysPK)) {
            return false;
        }
        SecusysPK other = (SecusysPK) object;
        if ((this.sysno == null && other.sysno != null) || (this.sysno != null && !this.sysno.equals(other.sysno))) {
            return false;
        }
        if ((this.userno == null && other.userno != null) || (this.userno != null && !this.userno.equals(other.userno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.SecusysPK[ sysno=" + sysno + ", userno=" + userno + " ]";
    }
    
}
