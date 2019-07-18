/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
@Table(name = "cdrcorman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrcorman.findAll", query = "SELECT c FROM Cdrcorman c")
    , @NamedQuery(name = "Cdrcorman.findByItcls", query = "SELECT c FROM Cdrcorman c WHERE c.itcls = :itcls")})
public class Cdrcorman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "itcls")
    private String itcls;

    public Cdrcorman() {
    }

    public Cdrcorman(String itcls) {
        this.itcls = itcls;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itcls != null ? itcls.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrcorman)) {
            return false;
        }
        Cdrcorman other = (Cdrcorman) object;
        if ((this.itcls == null && other.itcls != null) || (this.itcls != null && !this.itcls.equals(other.itcls))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrcorman[ itcls=" + itcls + " ]";
    }
    
}
