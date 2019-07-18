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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "purserno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purserno.findAll", query = "SELECT p FROM Purserno p"),
    @NamedQuery(name = "Purserno.findByFacno", query = "SELECT p FROM Purserno p WHERE p.pursernoPK.facno = :facno"),
    @NamedQuery(name = "Purserno.findByProno", query = "SELECT p FROM Purserno p WHERE p.pursernoPK.prono = :prono"),
    @NamedQuery(name = "Purserno.findByDifcode", query = "SELECT p FROM Purserno p WHERE p.pursernoPK.difcode = :difcode"),
    @NamedQuery(name = "Purserno.findByKeyformat", query = "SELECT p FROM Purserno p WHERE p.pursernoPK.keyformat = :keyformat"),
    @NamedQuery(name = "Purserno.findByMaxserno", query = "SELECT p FROM Purserno p WHERE p.maxserno = :maxserno"),
    @NamedQuery(name = "Purserno.findByPK", query = "SELECT p FROM Purserno p WHERE p.pursernoPK.facno = :facno AND p.pursernoPK.prono = :prono AND p.pursernoPK.difcode = :difcode AND p.pursernoPK.keyformat = :keyformat")

})
public class Purserno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PursernoPK pursernoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxserno")
    private short maxserno;

    public Purserno() {
    }

    public Purserno(PursernoPK pursernoPK) {
        this.pursernoPK = pursernoPK;
    }

    public Purserno(PursernoPK pursernoPK, short maxserno) {
        this.pursernoPK = pursernoPK;
        this.maxserno = maxserno;
    }

    public Purserno(String facno, String prono, Character difcode, String keyformat) {
        this.pursernoPK = new PursernoPK(facno, prono, difcode, keyformat);
    }

    public PursernoPK getPursernoPK() {
        return pursernoPK;
    }

    public void setPursernoPK(PursernoPK pursernoPK) {
        this.pursernoPK = pursernoPK;
    }

    public short getMaxserno() {
        return maxserno;
    }

    public void setMaxserno(short maxserno) {
        this.maxserno = maxserno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pursernoPK != null ? pursernoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purserno)) {
            return false;
        }
        Purserno other = (Purserno) object;
        if ((this.pursernoPK == null && other.pursernoPK != null) || (this.pursernoPK != null && !this.pursernoPK.equals(other.pursernoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purserno[ pursernoPK=" + pursernoPK + " ]";
    }
    
}
