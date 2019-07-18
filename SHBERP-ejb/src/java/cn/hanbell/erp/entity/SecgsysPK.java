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
public class SecgsysPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sysno")
    private String sysno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "groupno")
    private String groupno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "gtype")
    private String gtype;

    public SecgsysPK() {
    }

    public SecgsysPK(String sysno, String groupno, String gtype) {
        this.sysno = sysno;
        this.groupno = groupno;
        this.gtype = gtype;
    }

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getGroupno() {
        return groupno;
    }

    public void setGroupno(String groupno) {
        this.groupno = groupno;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysno != null ? sysno.hashCode() : 0);
        hash += (groupno != null ? groupno.hashCode() : 0);
        hash += (gtype != null ? gtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecgsysPK)) {
            return false;
        }
        SecgsysPK other = (SecgsysPK) object;
        if ((this.sysno == null && other.sysno != null) || (this.sysno != null && !this.sysno.equals(other.sysno))) {
            return false;
        }
        if ((this.groupno == null && other.groupno != null) || (this.groupno != null && !this.groupno.equals(other.groupno))) {
            return false;
        }
        if ((this.gtype == null && other.gtype != null) || (this.gtype != null && !this.gtype.equals(other.gtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.SecgsysPK[ sysno=" + sysno + ", groupno=" + groupno + ", gtype=" + gtype + " ]";
    }
    
}
