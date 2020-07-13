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
public class SERBFPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "BF001")
    private String bf001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BF002")
    private String bf002;

    public SERBFPK() {
    }

    public SERBFPK(String bf001, String bf002) {
        this.bf001 = bf001;
        this.bf002 = bf002;
    }

    public String getBf001() {
        return bf001;
    }

    public void setBf001(String bf001) {
        this.bf001 = bf001;
    }

    public String getBf002() {
        return bf002;
    }

    public void setBf002(String bf002) {
        this.bf002 = bf002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bf001 != null ? bf001.hashCode() : 0);
        hash += (bf002 != null ? bf002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERBFPK)) {
            return false;
        }
        SERBFPK other = (SERBFPK) object;
        if ((this.bf001 == null && other.bf001 != null) || (this.bf001 != null && !this.bf001.equals(other.bf001))) {
            return false;
        }
        if ((this.bf002 == null && other.bf002 != null) || (this.bf002 != null && !this.bf002.equals(other.bf002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SERBFPK[ bf001=" + bf001 + ", bf002=" + bf002 + " ]";
    }
    
}
