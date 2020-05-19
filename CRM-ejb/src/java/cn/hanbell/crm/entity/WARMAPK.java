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
 * @author C2082
 */
@Embeddable
public class WARMAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MA001")
    private String ma001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MA002")
    private String ma002;

    public WARMAPK() {
    }

    public WARMAPK(String ma001, String ma002) {
        this.ma001 = ma001;
        this.ma002 = ma002;
    }

    public String getMa001() {
        return ma001;
    }

    public void setMa001(String ma001) {
        this.ma001 = ma001;
    }

    public String getMa002() {
        return ma002;
    }

    public void setMa002(String ma002) {
        this.ma002 = ma002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ma001 != null ? ma001.hashCode() : 0);
        hash += (ma002 != null ? ma002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARMAPK)) {
            return false;
        }
        WARMAPK other = (WARMAPK) object;
        if ((this.ma001 == null && other.ma001 != null) || (this.ma001 != null && !this.ma001.equals(other.ma001))) {
            return false;
        }
        if ((this.ma002 == null && other.ma002 != null) || (this.ma002 != null && !this.ma002.equals(other.ma002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WarmaPK[ ma001=" + ma001 + ", ma002=" + ma002 + " ]";
    }
    
}
