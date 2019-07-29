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
@Table(name = "cdrsfkspec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrsfkspec.findAll", query = "SELECT c FROM Cdrsfkspec c"),
    @NamedQuery(name = "Cdrsfkspec.findByFacno", query = "SELECT c FROM Cdrsfkspec c WHERE c.cdrsfkspecPK.facno = :facno"),
    @NamedQuery(name = "Cdrsfkspec.findByParts", query = "SELECT c FROM Cdrsfkspec c WHERE c.cdrsfkspecPK.parts = :parts"),
    @NamedQuery(name = "Cdrsfkspec.findBySorts", query = "SELECT c FROM Cdrsfkspec c WHERE c.cdrsfkspecPK.sorts = :sorts"),
    @NamedQuery(name = "Cdrsfkspec.findBySpecifit", query = "SELECT c FROM Cdrsfkspec c WHERE c.cdrsfkspecPK.specifit = :specifit"),
    @NamedQuery(name = "Cdrsfkspec.findByPK", query = "SELECT c FROM Cdrsfkspec c WHERE c.cdrsfkspecPK.facno = :facno AND c.cdrsfkspecPK.parts = :parts AND c.cdrsfkspecPK.sorts = :sorts AND c.cdrsfkspecPK.specifit = :specifit"),
    @NamedQuery(name = "Cdrsfkspec.findBySpecifitesc", query = "SELECT c FROM Cdrsfkspec c WHERE c.specifitesc = :specifitesc")})
public class Cdrsfkspec implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrsfkspecPK cdrsfkspecPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "specifitesc")
    private String specifitesc;

    public Cdrsfkspec() {
    }

    public Cdrsfkspec(CdrsfkspecPK cdrsfkspecPK) {
        this.cdrsfkspecPK = cdrsfkspecPK;
    }

    public Cdrsfkspec(CdrsfkspecPK cdrsfkspecPK, String specifitesc) {
        this.cdrsfkspecPK = cdrsfkspecPK;
        this.specifitesc = specifitesc;
    }

    public Cdrsfkspec(String facno, String parts, String sorts, String specifit) {
        this.cdrsfkspecPK = new CdrsfkspecPK(facno, parts, sorts, specifit);
    }

    public CdrsfkspecPK getCdrsfkspecPK() {
        return cdrsfkspecPK;
    }

    public void setCdrsfkspecPK(CdrsfkspecPK cdrsfkspecPK) {
        this.cdrsfkspecPK = cdrsfkspecPK;
    }

    public String getSpecifitesc() {
        return specifitesc;
    }

    public void setSpecifitesc(String specifitesc) {
        this.specifitesc = specifitesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrsfkspecPK != null ? cdrsfkspecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrsfkspec)) {
            return false;
        }
        Cdrsfkspec other = (Cdrsfkspec) object;
        if ((this.cdrsfkspecPK == null && other.cdrsfkspecPK != null) || (this.cdrsfkspecPK != null && !this.cdrsfkspecPK.equals(other.cdrsfkspecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrsfkspec[ cdrsfkspecPK=" + cdrsfkspecPK + " ]";
    }

}
