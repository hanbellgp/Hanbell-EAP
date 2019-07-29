/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "secmemb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secmemb.findAll", query = "SELECT s FROM Secmemb s"),
    @NamedQuery(name = "Secmemb.findByFacno", query = "SELECT s FROM Secmemb s WHERE s.secmembPK.facno = :facno"),
    @NamedQuery(name = "Secmemb.findByDepno", query = "SELECT s FROM Secmemb s WHERE s.secmembPK.depno = :depno"),
    @NamedQuery(name = "Secmemb.findByUserno", query = "SELECT s FROM Secmemb s WHERE s.secmembPK.userno = :userno"),
    @NamedQuery(name = "Secmemb.findByPK", query = "SELECT s FROM Secmemb s WHERE s.secmembPK.facno = :facno AND s.secmembPK.depno = :depno AND s.secmembPK.userno = :userno")})
public class Secmemb implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecmembPK secmembPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supvisor")
    private Character supvisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auth")
    private Character auth;
    @Size(max = 8)
    @Column(name = "director")
    private String director;

    public Secmemb() {
    }

    public Secmemb(SecmembPK secmembPK) {
        this.secmembPK = secmembPK;
    }

    public Secmemb(SecmembPK secmembPK, Character supvisor, Character auth) {
        this.secmembPK = secmembPK;
        this.supvisor = supvisor;
        this.auth = auth;
    }

    public Secmemb(String facno, String depno, String userno) {
        this.secmembPK = new SecmembPK(facno, depno, userno);
    }

    public SecmembPK getSecmembPK() {
        return secmembPK;
    }

    public void setSecmembPK(SecmembPK secmembPK) {
        this.secmembPK = secmembPK;
    }

    public Character getSupvisor() {
        return supvisor;
    }

    public void setSupvisor(Character supvisor) {
        this.supvisor = supvisor;
    }

    public Character getAuth() {
        return auth;
    }

    public void setAuth(Character auth) {
        this.auth = auth;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secmembPK != null ? secmembPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secmemb)) {
            return false;
        }
        Secmemb other = (Secmemb) object;
        if ((this.secmembPK == null && other.secmembPK != null) || (this.secmembPK != null && !this.secmembPK.equals(other.secmembPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secmemb[ secmembPK=" + secmembPK + " ]";
    }

}
