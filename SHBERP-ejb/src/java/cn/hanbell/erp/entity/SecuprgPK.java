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
public class SecuprgPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "prgno")
    private String prgno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;

    public SecuprgPK() {
    }

    public SecuprgPK(String prgno, String userno) {
        this.prgno = prgno;
        this.userno = userno;
    }

    public String getPrgno() {
        return prgno;
    }

    public void setPrgno(String prgno) {
        this.prgno = prgno;
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
        hash += (prgno != null ? prgno.hashCode() : 0);
        hash += (userno != null ? userno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecuprgPK)) {
            return false;
        }
        SecuprgPK other = (SecuprgPK) object;
        if ((this.prgno == null && other.prgno != null) || (this.prgno != null && !this.prgno.equals(other.prgno))) {
            return false;
        }
        if ((this.userno == null && other.userno != null) || (this.userno != null && !this.userno.equals(other.userno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.SecuprgPK[ prgno=" + prgno + ", userno=" + userno + " ]";
    }
    
}
