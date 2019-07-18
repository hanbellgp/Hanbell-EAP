/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.entity;

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
public class HZFWDD05PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "hzfwd_d05001")
    private String hzfwdD05001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "hzfwd_d05002")
    private String hzfwdD05002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "hzfwd_d05003")
    private String hzfwdD05003;

    public HZFWDD05PK() {
    }

    public HZFWDD05PK(String hzfwdD05001, String hzfwdD05002, String hzfwdD05003) {
        this.hzfwdD05001 = hzfwdD05001;
        this.hzfwdD05002 = hzfwdD05002;
        this.hzfwdD05003 = hzfwdD05003;
    }

    public String getHzfwdD05001() {
        return hzfwdD05001;
    }

    public void setHzfwdD05001(String hzfwdD05001) {
        this.hzfwdD05001 = hzfwdD05001;
    }

    public String getHzfwdD05002() {
        return hzfwdD05002;
    }

    public void setHzfwdD05002(String hzfwdD05002) {
        this.hzfwdD05002 = hzfwdD05002;
    }

    public String getHzfwdD05003() {
        return hzfwdD05003;
    }

    public void setHzfwdD05003(String hzfwdD05003) {
        this.hzfwdD05003 = hzfwdD05003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hzfwdD05001 != null ? hzfwdD05001.hashCode() : 0);
        hash += (hzfwdD05002 != null ? hzfwdD05002.hashCode() : 0);
        hash += (hzfwdD05003 != null ? hzfwdD05003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZFWDD05PK)) {
            return false;
        }
        HZFWDD05PK other = (HZFWDD05PK) object;
        if ((this.hzfwdD05001 == null && other.hzfwdD05001 != null) || (this.hzfwdD05001 != null && !this.hzfwdD05001.equals(other.hzfwdD05001))) {
            return false;
        }
        if ((this.hzfwdD05002 == null && other.hzfwdD05002 != null) || (this.hzfwdD05002 != null && !this.hzfwdD05002.equals(other.hzfwdD05002))) {
            return false;
        }
        if ((this.hzfwdD05003 == null && other.hzfwdD05003 != null) || (this.hzfwdD05003 != null && !this.hzfwdD05003.equals(other.hzfwdD05003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.efnet.entity.HZFWDD05PK[ hzfwdD05001=" + hzfwdD05001 + ", hzfwdD05002=" + hzfwdD05002 + ", hzfwdD05003=" + hzfwdD05003 + " ]";
    }
    
}
