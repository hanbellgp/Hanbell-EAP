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
public class REPTDPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TD001")
    private String td001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TD002")
    private String td002;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TD003")
    private String td003;

    public REPTDPK() {
    }

    public REPTDPK(String td001, String td002, String td003) {
        this.td001 = td001;
        this.td002 = td002;
        this.td003 = td003;
    }

    public String getTd001() {
        return td001;
    }

    public void setTd001(String td001) {
        this.td001 = td001;
    }

    public String getTd002() {
        return td002;
    }

    public void setTd002(String td002) {
        this.td002 = td002;
    }

    public String getTd003() {
        return td003;
    }

    public void setTd003(String td003) {
        this.td003 = td003;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (td001 != null ? td001.hashCode() : 0);
        hash += (td002 != null ? td002.hashCode() : 0);
        hash += (td003 != null ? td003.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTDPK)) {
            return false;
        }
        REPTDPK other = (REPTDPK) object;
        if ((this.td001 == null && other.td001 != null) || (this.td001 != null && !this.td001.equals(other.td001))) {
            return false;
        }
        if ((this.td002 == null && other.td002 != null) || (this.td002 != null && !this.td002.equals(other.td002))) {
            return false;
        }
        if ((this.td003 == null && other.td003 != null) || (this.td003 != null && !this.td003.equals(other.td003))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.comm.REPTDPK[ td001=" + td001 + ", td002=" + td002 + ", td003=" + td003 + " ]";
    }
    
}
