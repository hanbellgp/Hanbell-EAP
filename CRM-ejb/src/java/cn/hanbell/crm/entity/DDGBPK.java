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
public class DDGBPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "GB001")
    private String gb001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GB002")
    private String gb002;

    public DDGBPK() {
    }

    public DDGBPK(String gb001, String gb002) {
        this.gb001 = gb001;
        this.gb002 = gb002;
    }

    public String getGb001() {
        return gb001;
    }

    public void setGb001(String gb001) {
        this.gb001 = gb001;
    }

    public String getGb002() {
        return gb002;
    }

    public void setGb002(String gb002) {
        this.gb002 = gb002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gb001 != null ? gb001.hashCode() : 0);
        hash += (gb002 != null ? gb002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDGBPK)) {
            return false;
        }
        DDGBPK other = (DDGBPK) object;
        if ((this.gb001 == null && other.gb001 != null) || (this.gb001 != null && !this.gb001.equals(other.gb001))) {
            return false;
        }
        if ((this.gb002 == null && other.gb002 != null) || (this.gb002 != null && !this.gb002.equals(other.gb002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DDGBPK[ gb001=" + gb001 + ", gb002=" + gb002 + " ]";
    }

}
