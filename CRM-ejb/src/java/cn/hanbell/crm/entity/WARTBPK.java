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
 * @author C1587
 */
@Embeddable
public class WARTBPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TB001")
    private String tb001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TB002")
    private String tb002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TB003")
    private String tb003;

    public WARTBPK() {
    }

    public WARTBPK(String tb001, String tb002, String tb003) {
        this.tb001 = tb001;
        this.tb002 = tb002;
        this.tb003 = tb003;
    }

    public String getTb001() {
        return tb001;
    }

    public void setTb001(String tb001) {
        this.tb001 = tb001;
    }

    public String getTb002() {
        return tb002;
    }

    public void setTb002(String tb002) {
        this.tb002 = tb002;
    }

    public String getTb003() {
        return tb003;
    }

    public void setTb003(String tb003) {
        this.tb003 = tb003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tb001 != null ? tb001.hashCode() : 0);
        hash += (tb002 != null ? tb002.hashCode() : 0);
        hash += (tb003 != null ? tb003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARTBPK)) {
            return false;
        }
        WARTBPK other = (WARTBPK) object;
        if ((this.tb001 == null && other.tb001 != null) || (this.tb001 != null && !this.tb001.equals(other.tb001))) {
            return false;
        }
        if ((this.tb002 == null && other.tb002 != null) || (this.tb002 != null && !this.tb002.equals(other.tb002))) {
            return false;
        }
        if ((this.tb003 == null && other.tb003 != null) || (this.tb003 != null && !this.tb003.equals(other.tb003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARTBPK[ tb001=" + tb001 + ", tb002=" + tb002 + ", tb003=" + tb003 + " ]";
    }
    
}
