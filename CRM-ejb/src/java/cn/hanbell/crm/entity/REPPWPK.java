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
public class REPPWPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PW001")
    private String pw001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PW002")
    private String pw002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PW003")
    private String pw003;

    public REPPWPK() {
    }

    public REPPWPK(String pw001, String pw002, String pw003) {
        this.pw001 = pw001;
        this.pw002 = pw002;
        this.pw003 = pw003;
    }

    public String getPw001() {
        return pw001;
    }

    public void setPw001(String pw001) {
        this.pw001 = pw001;
    }

    public String getPw002() {
        return pw002;
    }

    public void setPw002(String pw002) {
        this.pw002 = pw002;
    }

    public String getPw003() {
        return pw003;
    }

    public void setPw003(String pw003) {
        this.pw003 = pw003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pw001 != null ? pw001.hashCode() : 0);
        hash += (pw002 != null ? pw002.hashCode() : 0);
        hash += (pw003 != null ? pw003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPPWPK)) {
            return false;
        }
        REPPWPK other = (REPPWPK) object;
        if ((this.pw001 == null && other.pw001 != null) || (this.pw001 != null && !this.pw001.equals(other.pw001))) {
            return false;
        }
        if ((this.pw002 == null && other.pw002 != null) || (this.pw002 != null && !this.pw002.equals(other.pw002))) {
            return false;
        }
        if ((this.pw003 == null && other.pw003 != null) || (this.pw003 != null && !this.pw003.equals(other.pw003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPPWPK[ pw001=" + pw001 + ", pw002=" + pw002 + ", pw003=" + pw003 + " ]";
    }
    
}
