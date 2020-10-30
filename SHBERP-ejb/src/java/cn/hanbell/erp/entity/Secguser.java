/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "secguser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secguser.findAll", query = "SELECT s FROM Secguser s"),
    @NamedQuery(name = "Secguser.findByGroupno", query = "SELECT s FROM Secguser s WHERE s.secguserPK.groupno = :groupno"),
    @NamedQuery(name = "Secguser.findByPK", query = "SELECT s FROM Secguser s WHERE s.secguserPK.groupno = :groupno AND s.secguserPK.gtype = :gtype AND s.secguserPK.userno = :userno"),
    @NamedQuery(name = "Secguser.findByUserno", query = "SELECT s FROM Secguser s WHERE s.secguserPK.userno = :userno")})
public class Secguser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecguserPK secguserPK;
    @JoinColumns({
        @JoinColumn(name = "groupno", referencedColumnName = "groupno", insertable = false, updatable = false),
        @JoinColumn(name = "gtype", referencedColumnName = "gtype", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Secgroup secgroup;
    @JoinColumns({
        @JoinColumn(name = "userno", referencedColumnName = "userno", insertable = false, updatable = false)
    })
    @ManyToOne(optional = true)
    private Secuser secuser;

    public Secguser() {
    }

    public Secguser(SecguserPK secguserPK) {
        this.secguserPK = secguserPK;
    }

    public Secguser(String groupno, String gtype, String userno) {
        this.secguserPK = new SecguserPK(groupno, gtype, userno);
    }

    public SecguserPK getSecguserPK() {
        return secguserPK;
    }

    public void setSecguserPK(SecguserPK secguserPK) {
        this.secguserPK = secguserPK;
    }

    public Secgroup getSecgroup() {
        return secgroup;
    }

    public void setSecgroup(Secgroup secgroup) {
        this.secgroup = secgroup;
    }

    /**
     * @return the secuser
     */
    public Secuser getSecuser() {
        return secuser;
    }

    /**
     * @param secuser the secuser to set
     */
    public void setSecuser(Secuser secuser) {
        this.secuser = secuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secguserPK != null ? secguserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secguser)) {
            return false;
        }
        Secguser other = (Secguser) object;
        if ((this.secguserPK == null && other.secguserPK != null) || (this.secguserPK != null && !this.secguserPK.equals(other.secguserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secguser[ secguserPK=" + secguserPK + " ]";
    }

}
