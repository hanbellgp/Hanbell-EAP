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
 * @author C0160
 */
@Embeddable
public class SecguserPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;

    public SecguserPK() {
    }

    public SecguserPK(String groupno, String gtype, String userno) {
        this.groupno = groupno;
        this.gtype = gtype;
        this.userno = userno;
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

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupno != null ? groupno.hashCode() : 0);
        hash += (gtype != null ? gtype.hashCode() : 0);
        hash += (userno != null ? userno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecguserPK)) {
            return false;
        }
        SecguserPK other = (SecguserPK) object;
        if ((this.groupno == null && other.groupno != null) || (this.groupno != null && !this.groupno.equals(other.groupno))) {
            return false;
        }
        if ((this.gtype == null && other.gtype != null) || (this.gtype != null && !this.gtype.equals(other.gtype))) {
            return false;
        }
        if ((this.userno == null && other.userno != null) || (this.userno != null && !this.userno.equals(other.userno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.SecguserPK[ groupno=" + groupno + ", gtype=" + gtype + ", userno=" + userno + " ]";
    }

}
