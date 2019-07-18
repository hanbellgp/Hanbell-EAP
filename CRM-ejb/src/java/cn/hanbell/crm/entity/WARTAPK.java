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
public class WARTAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TA001")
    private String ta001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TA002")
    private String ta002;

    public WARTAPK() {
    }

    public WARTAPK(String ta001, String ta002) {
        this.ta001 = ta001;
        this.ta002 = ta002;
    }

    public String getTa001() {
        return ta001;
    }

    public void setTa001(String ta001) {
        this.ta001 = ta001;
    }

    public String getTa002() {
        return ta002;
    }

    public void setTa002(String ta002) {
        this.ta002 = ta002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ta001 != null ? ta001.hashCode() : 0);
        hash += (ta002 != null ? ta002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARTAPK)) {
            return false;
        }
        WARTAPK other = (WARTAPK) object;
        if ((this.ta001 == null && other.ta001 != null) || (this.ta001 != null && !this.ta001.equals(other.ta001))) {
            return false;
        }
        if ((this.ta002 == null && other.ta002 != null) || (this.ta002 != null && !this.ta002.equals(other.ta002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARTAPK[ ta001=" + ta001 + ", ta002=" + ta002 + " ]";
    }
    
}
