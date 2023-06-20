/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "invmasmark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invmasmark.findAll", query = "SELECT i FROM Invmasmark i"),
    @NamedQuery(name = "Invmasmark.findByGrpcode", query = "SELECT i FROM Invmasmark i WHERE i.grpcode = :grpcode"),
    @NamedQuery(name = "Invmasmark.findByGenre2", query = "SELECT i FROM Invmasmark i WHERE i.genre2 = :genre2"),
    @NamedQuery(name = "Invmasmark.findByGenre3", query = "SELECT i FROM Invmasmark i WHERE i.genre3 = :genre3"),
    @NamedQuery(name = "Invmasmark.findByItcls", query = "SELECT i FROM Invmasmark i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "Invmasmark.findByFacno", query = "SELECT i FROM Invmasmark i WHERE i.facno = :facno")})
public class Invmasmark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "grpcode")
    private String grpcode;
    @Size(max = 40)
    @Column(name = "genre2")
    private String genre2;
    @Size(max = 40)
    @Column(name = "genre3")
    private String genre3;
    @Size(max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 3)
    @Column(name = "facno")
    private String facno;

    public Invmasmark() {
    }

    public Invmasmark(String grpcode) {
        this.grpcode = grpcode;
    }

    public String getGrpcode() {
        return grpcode;
    }

    public void setGrpcode(String grpcode) {
        this.grpcode = grpcode;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpcode != null ? grpcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invmasmark)) {
            return false;
        }
        Invmasmark other = (Invmasmark) object;
        if ((this.grpcode == null && other.grpcode != null) || (this.grpcode != null && !this.grpcode.equals(other.grpcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.Invmasmark[ grpcode=" + grpcode + " ]";
    }
    
}
