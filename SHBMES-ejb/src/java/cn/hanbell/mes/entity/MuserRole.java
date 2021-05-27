/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "MUSER_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MuserRole.findAll", query = "SELECT m FROM MuserRole m"),
    @NamedQuery(name = "MuserRole.findByUserid", query = "SELECT m FROM MuserRole m WHERE m.muserRolePK.userid = :userid"),
    @NamedQuery(name = "MuserRole.findByRoletype", query = "SELECT m FROM MuserRole m WHERE m.muserRolePK.roletype = :roletype"),
    @NamedQuery(name = "MuserRole.findByRoleid", query = "SELECT m FROM MuserRole m WHERE m.muserRolePK.roleid = :roleid")})
public class MuserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MuserRolePK muserRolePK;

    public MuserRole() {
    }

    public MuserRole(MuserRolePK muserRolePK) {
        this.muserRolePK = muserRolePK;
    }

    public MuserRole(String userid, String roletype, String roleid) {
        this.muserRolePK = new MuserRolePK(userid, roletype, roleid);
    }

    public MuserRolePK getMuserRolePK() {
        return muserRolePK;
    }

    public void setMuserRolePK(MuserRolePK muserRolePK) {
        this.muserRolePK = muserRolePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (muserRolePK != null ? muserRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MuserRole)) {
            return false;
        }
        MuserRole other = (MuserRole) object;
        if ((this.muserRolePK == null && other.muserRolePK != null) || (this.muserRolePK != null && !this.muserRolePK.equals(other.muserRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.mes.comm.MuserRole[ muserRolePK=" + muserRolePK + " ]";
    }
    
}
