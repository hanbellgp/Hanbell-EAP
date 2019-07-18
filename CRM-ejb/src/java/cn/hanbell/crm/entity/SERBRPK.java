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
public class SERBRPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "BR001")
    private String br001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "BR002")
    private String br002;

    public SERBRPK() {
    }

    public SERBRPK(String br001, String br002) {
        this.br001 = br001;
        this.br002 = br002;
    }

    public String getBr001() {
        return br001;
    }

    public void setBr001(String br001) {
        this.br001 = br001;
    }

    public String getBr002() {
        return br002;
    }

    public void setBr002(String br002) {
        this.br002 = br002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (br001 != null ? br001.hashCode() : 0);
        hash += (br002 != null ? br002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERBRPK)) {
            return false;
        }
        SERBRPK other = (SERBRPK) object;
        if ((this.br001 == null && other.br001 != null) || (this.br001 != null && !this.br001.equals(other.br001))) {
            return false;
        }
        if ((this.br002 == null && other.br002 != null) || (this.br002 != null && !this.br002.equals(other.br002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SERBRPK[ br001=" + br001 + ", br002=" + br002 + " ]";
    }
    
}
