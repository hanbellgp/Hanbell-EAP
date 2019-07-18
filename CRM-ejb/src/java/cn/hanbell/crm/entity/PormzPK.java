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
public class PormzPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MZ001")
    private String mz001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "MZ002")
    private String mz002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MZ003")
    private String mz003;

    public PormzPK() {
    }

    public PormzPK(String mz001, String mz002, String mz003) {
        this.mz001 = mz001;
        this.mz002 = mz002;
        this.mz003 = mz003;
    }

    public String getMz001() {
        return mz001;
    }

    public void setMz001(String mz001) {
        this.mz001 = mz001;
    }

    public String getMz002() {
        return mz002;
    }

    public void setMz002(String mz002) {
        this.mz002 = mz002;
    }

    public String getMz003() {
        return mz003;
    }

    public void setMz003(String mz003) {
        this.mz003 = mz003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mz001 != null ? mz001.hashCode() : 0);
        hash += (mz002 != null ? mz002.hashCode() : 0);
        hash += (mz003 != null ? mz003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PormzPK)) {
            return false;
        }
        PormzPK other = (PormzPK) object;
        if ((this.mz001 == null && other.mz001 != null) || (this.mz001 != null && !this.mz001.equals(other.mz001))) {
            return false;
        }
        if ((this.mz002 == null && other.mz002 != null) || (this.mz002 != null && !this.mz002.equals(other.mz002))) {
            return false;
        }
        if ((this.mz003 == null && other.mz003 != null) || (this.mz003 != null && !this.mz003.equals(other.mz003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.PormzPK[ mz001=" + mz001 + ", mz002=" + mz002 + ", mz003=" + mz003 + " ]";
    }
    
}
