/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1587
 */
@Entity
@Table(name = "secgsys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secgsys.findAll", query = "SELECT s FROM Secgsys s"),
    @NamedQuery(name = "Secgsys.findByPK", query = "SELECT s FROM Secgsys s WHERE s.secgsysPK.sysno = :sysno AND s.secgsysPK.groupno = :groupno AND s.secgsysPK.gtype = :gtype"),
    @NamedQuery(name = "Secgsys.findBySysno", query = "SELECT s FROM Secgsys s WHERE s.secgsysPK.sysno = :sysno"),
    @NamedQuery(name = "Secgsys.findByGroupno", query = "SELECT s FROM Secgsys s WHERE s.secgsysPK.groupno = :groupno"),
    @NamedQuery(name = "Secgsys.findByGtype", query = "SELECT s FROM Secgsys s WHERE s.secgsysPK.gtype = :gtype")})
public class Secgsys implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecgsysPK secgsysPK;

    public Secgsys() {
    }

    public Secgsys(SecgsysPK secgsysPK) {
        this.secgsysPK = secgsysPK;
    }

    public Secgsys(String sysno, String groupno, String gtype) {
        this.secgsysPK = new SecgsysPK(sysno, groupno, gtype);
    }

    public SecgsysPK getSecgsysPK() {
        return secgsysPK;
    }

    public void setSecgsysPK(SecgsysPK secgsysPK) {
        this.secgsysPK = secgsysPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secgsysPK != null ? secgsysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secgsys)) {
            return false;
        }
        Secgsys other = (Secgsys) object;
        if ((this.secgsysPK == null && other.secgsysPK != null) || (this.secgsysPK != null && !this.secgsysPK.equals(other.secgsysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secgsys[ secgsysPK=" + secgsysPK + " ]";
    }

}
