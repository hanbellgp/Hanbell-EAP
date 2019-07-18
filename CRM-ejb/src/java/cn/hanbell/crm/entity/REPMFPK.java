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
public class REPMFPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "MF001")
    private String mf001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MF002")
    private String mf002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MF005")
    private String mf005;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MF009")
    private String mf009;

    public REPMFPK() {
    }

    public REPMFPK(String mf001, String mf002, String mf005, String mf009) {
        this.mf001 = mf001;
        this.mf002 = mf002;
        this.mf005 = mf005;
        this.mf009 = mf009;
    }

    public String getMf001() {
        return mf001;
    }

    public void setMf001(String mf001) {
        this.mf001 = mf001;
    }

    public String getMf002() {
        return mf002;
    }

    public void setMf002(String mf002) {
        this.mf002 = mf002;
    }

    public String getMf005() {
        return mf005;
    }

    public void setMf005(String mf005) {
        this.mf005 = mf005;
    }

    public String getMf009() {
        return mf009;
    }

    public void setMf009(String mf009) {
        this.mf009 = mf009;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mf001 != null ? mf001.hashCode() : 0);
        hash += (mf002 != null ? mf002.hashCode() : 0);
        hash += (mf005 != null ? mf005.hashCode() : 0);
        hash += (mf009 != null ? mf009.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMFPK)) {
            return false;
        }
        REPMFPK other = (REPMFPK) object;
        if ((this.mf001 == null && other.mf001 != null) || (this.mf001 != null && !this.mf001.equals(other.mf001))) {
            return false;
        }
        if ((this.mf002 == null && other.mf002 != null) || (this.mf002 != null && !this.mf002.equals(other.mf002))) {
            return false;
        }
        if ((this.mf005 == null && other.mf005 != null) || (this.mf005 != null && !this.mf005.equals(other.mf005))) {
            return false;
        }
        if ((this.mf009 == null && other.mf009 != null) || (this.mf009 != null && !this.mf009.equals(other.mf009))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMFPK[ mf001=" + mf001 + ", mf002=" + mf002 + ", mf005=" + mf005 + ", mf009=" + mf009 + " ]";
    }
    
}
