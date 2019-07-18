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
@Table(name = "secusys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secusys.findAll", query = "SELECT s FROM Secusys s"),
    @NamedQuery(name = "Secusys.findByPK", query = "SELECT s FROM Secusys s WHERE s.secusysPK.sysno = :sysno and s.secusysPK.userno = :userno"),
    @NamedQuery(name = "Secusys.findBySysno", query = "SELECT s FROM Secusys s WHERE s.secusysPK.sysno = :sysno"),
    @NamedQuery(name = "Secusys.findByUserno", query = "SELECT s FROM Secusys s WHERE s.secusysPK.userno = :userno")})
public class Secusys implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecusysPK secusysPK;

    public Secusys() {
    }

    public Secusys(SecusysPK secusysPK) {
        this.secusysPK = secusysPK;
    }

    public Secusys(String sysno, String userno) {
        this.secusysPK = new SecusysPK(sysno, userno);
    }

    public SecusysPK getSecusysPK() {
        return secusysPK;
    }

    public void setSecusysPK(SecusysPK secusysPK) {
        this.secusysPK = secusysPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secusysPK != null ? secusysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secusys)) {
            return false;
        }
        Secusys other = (Secusys) object;
        if ((this.secusysPK == null && other.secusysPK != null) || (this.secusysPK != null && !this.secusysPK.equals(other.secusysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secusys[ secusysPK=" + secusysPK + " ]";
    }
    
}
