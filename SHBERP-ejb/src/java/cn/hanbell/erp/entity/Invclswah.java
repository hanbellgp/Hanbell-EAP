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
 * @author Administrator
 */
@Entity
@Table(name = "invclswah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invclswah.findAll", query = "SELECT i FROM Invclswah i"),
    @NamedQuery(name = "Invclswah.findByItcls", query = "SELECT i FROM Invclswah i WHERE i.invclswahPK.itcls = :itcls"),
    @NamedQuery(name = "Invclswah.findByFacno", query = "SELECT i FROM Invclswah i WHERE i.invclswahPK.facno = :facno"),
    @NamedQuery(name = "Invclswah.findByProno", query = "SELECT i FROM Invclswah i WHERE i.invclswahPK.prono = :prono"),
    @NamedQuery(name = "Invclswah.findByPK", query = "SELECT i FROM Invclswah i WHERE i.invclswahPK.facno = :facno AND i.invclswahPK.prono = :prono AND  i.invclswahPK.itcls = :itcls"),
    @NamedQuery(name = "Invclswah.findByDefwah", query = "SELECT i FROM Invclswah i WHERE i.defwah = :defwah"),
    @NamedQuery(name = "Invclswah.findByDefbadwah", query = "SELECT i FROM Invclswah i WHERE i.defbadwah = :defbadwah"),
    @NamedQuery(name = "Invclswah.findByDefprowah", query = "SELECT i FROM Invclswah i WHERE i.defprowah = :defprowah")})
public class Invclswah implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvclswahPK invclswahPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "defwah")
    private String defwah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "defbadwah")
    private String defbadwah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "defprowah")
    private String defprowah;

    public Invclswah() {
    }

    public Invclswah(InvclswahPK invclswahPK) {
        this.invclswahPK = invclswahPK;
    }

    public Invclswah(InvclswahPK invclswahPK, String defwah, String defbadwah, String defprowah) {
        this.invclswahPK = invclswahPK;
        this.defwah = defwah;
        this.defbadwah = defbadwah;
        this.defprowah = defprowah;
    }

    public Invclswah(String itcls, String facno, String prono) {
        this.invclswahPK = new InvclswahPK(itcls, facno, prono);
    }

    public InvclswahPK getInvclswahPK() {
        return invclswahPK;
    }

    public void setInvclswahPK(InvclswahPK invclswahPK) {
        this.invclswahPK = invclswahPK;
    }

    public String getDefwah() {
        return defwah;
    }

    public void setDefwah(String defwah) {
        this.defwah = defwah;
    }

    public String getDefbadwah() {
        return defbadwah;
    }

    public void setDefbadwah(String defbadwah) {
        this.defbadwah = defbadwah;
    }

    public String getDefprowah() {
        return defprowah;
    }

    public void setDefprowah(String defprowah) {
        this.defprowah = defprowah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invclswahPK != null ? invclswahPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invclswah)) {
            return false;
        }
        Invclswah other = (Invclswah) object;
        if ((this.invclswahPK == null && other.invclswahPK != null) || (this.invclswahPK != null && !this.invclswahPK.equals(other.invclswahPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invclswah[ invclswahPK=" + invclswahPK + " ]";
    }
    
}
