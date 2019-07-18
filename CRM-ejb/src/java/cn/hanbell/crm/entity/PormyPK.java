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
public class PormyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MY001")
    private String my001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "MY002")
    private String my002;

    public PormyPK() {
    }

    public PormyPK(String my001, String my002) {
        this.my001 = my001;
        this.my002 = my002;
    }

    public String getMy001() {
        return my001;
    }

    public void setMy001(String my001) {
        this.my001 = my001;
    }

    public String getMy002() {
        return my002;
    }

    public void setMy002(String my002) {
        this.my002 = my002;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (my001 != null ? my001.hashCode() : 0);
        hash += (my002 != null ? my002.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PormyPK)) {
            return false;
        }
        PormyPK other = (PormyPK) object;
        if ((this.my001 == null && other.my001 != null) || (this.my001 != null && !this.my001.equals(other.my001))) {
            return false;
        }
        if ((this.my002 == null && other.my002 != null) || (this.my002 != null && !this.my002.equals(other.my002))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.PormyPK[ my001=" + my001 + ", my002=" + my002 + " ]";
    }
    
}
