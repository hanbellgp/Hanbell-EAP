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
@Table(name = "cdrserno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrserno.findAll", query = "SELECT c FROM Cdrserno c")
    , @NamedQuery(name = "Cdrserno.findByFacno", query = "SELECT c FROM Cdrserno c WHERE c.cdrsernoPK.facno = :facno")
    , @NamedQuery(name = "Cdrserno.findByDifcode", query = "SELECT c FROM Cdrserno c WHERE c.cdrsernoPK.difcode = :difcode")
    , @NamedQuery(name = "Cdrserno.findByKeyformat", query = "SELECT c FROM Cdrserno c WHERE c.cdrsernoPK.keyformat = :keyformat")
    , @NamedQuery(name = "Cdrserno.findByPK", query = "SELECT c FROM Cdrserno c WHERE c.cdrsernoPK.facno = :facno AND c.cdrsernoPK.difcode = :difcode AND c.cdrsernoPK.keyformat = :keyformat")
    , @NamedQuery(name = "Cdrserno.findByMaxserno", query = "SELECT c FROM Cdrserno c WHERE c.maxserno = :maxserno")})
public class Cdrserno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrsernoPK cdrsernoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxserno")
    private short maxserno;

    public Cdrserno() {
    }

    public Cdrserno(CdrsernoPK cdrsernoPK) {
        this.cdrsernoPK = cdrsernoPK;
    }

    public Cdrserno(CdrsernoPK cdrsernoPK, short maxserno) {
        this.cdrsernoPK = cdrsernoPK;
        this.maxserno = maxserno;
    }

    public Cdrserno(String facno, Character difcode, String keyformat) {
        this.cdrsernoPK = new CdrsernoPK(facno, difcode, keyformat);
    }

    public CdrsernoPK getCdrsernoPK() {
        return cdrsernoPK;
    }

    public void setCdrsernoPK(CdrsernoPK cdrsernoPK) {
        this.cdrsernoPK = cdrsernoPK;
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
        hash += (cdrsernoPK != null ? cdrsernoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrserno)) {
            return false;
        }
        Cdrserno other = (Cdrserno) object;
        if ((this.cdrsernoPK == null && other.cdrsernoPK != null) || (this.cdrsernoPK != null && !this.cdrsernoPK.equals(other.cdrsernoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Cdrserno[ cdrsernoPK=" + cdrsernoPK + " ]";
    }

}
