/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
public class AccspedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "config")
    private short config;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "accno")
    private String accno;

    public AccspedPK() {
    }

    public AccspedPK(short config, String accno) {
        this.config = config;
        this.accno = accno;
    }

    public short getConfig() {
        return config;
    }

    public void setConfig(short config) {
        this.config = config;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) config;
        hash += (accno != null ? accno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccspedPK)) {
            return false;
        }
        AccspedPK other = (AccspedPK) object;
        if (this.config != other.config) {
            return false;
        }
        if ((this.accno == null && other.accno != null) || (this.accno != null && !this.accno.equals(other.accno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.AccspedPK[ config=" + config + ", accno=" + accno + " ]";
    }

}
