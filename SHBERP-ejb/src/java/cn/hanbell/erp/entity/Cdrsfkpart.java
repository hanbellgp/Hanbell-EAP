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
@Table(name = "cdrsfkpart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrsfkpart.findAll", query = "SELECT c FROM Cdrsfkpart c"),
    @NamedQuery(name = "Cdrsfkpart.findByFacno", query = "SELECT c FROM Cdrsfkpart c WHERE c.cdrsfkpartPK.facno = :facno"),
    @NamedQuery(name = "Cdrsfkpart.findByParts", query = "SELECT c FROM Cdrsfkpart c WHERE c.cdrsfkpartPK.parts = :parts"),
    @NamedQuery(name = "Cdrsfkpart.findByPK", query = "SELECT c FROM Cdrsfkpart c WHERE c.cdrsfkpartPK.facno = :facno AND c.cdrsfkpartPK.parts = :parts"),
    @NamedQuery(name = "Cdrsfkpart.findByPartsdesc", query = "SELECT c FROM Cdrsfkpart c WHERE c.partsdesc = :partsdesc"),
    @NamedQuery(name = "Cdrsfkpart.findByPx", query = "SELECT c FROM Cdrsfkpart c WHERE c.px = :px")})
public class Cdrsfkpart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrsfkpartPK cdrsfkpartPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "partsdesc")
    private String partsdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "px")
    private String px;

    public Cdrsfkpart() {
    }

    public Cdrsfkpart(CdrsfkpartPK cdrsfkpartPK) {
        this.cdrsfkpartPK = cdrsfkpartPK;
    }

    public Cdrsfkpart(CdrsfkpartPK cdrsfkpartPK, String partsdesc, String px) {
        this.cdrsfkpartPK = cdrsfkpartPK;
        this.partsdesc = partsdesc;
        this.px = px;
    }

    public Cdrsfkpart(String facno, String parts) {
        this.cdrsfkpartPK = new CdrsfkpartPK(facno, parts);
    }

    public CdrsfkpartPK getCdrsfkpartPK() {
        return cdrsfkpartPK;
    }

    public void setCdrsfkpartPK(CdrsfkpartPK cdrsfkpartPK) {
        this.cdrsfkpartPK = cdrsfkpartPK;
    }

    public String getPartsdesc() {
        return partsdesc;
    }

    public void setPartsdesc(String partsdesc) {
        this.partsdesc = partsdesc;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrsfkpartPK != null ? cdrsfkpartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrsfkpart)) {
            return false;
        }
        Cdrsfkpart other = (Cdrsfkpart) object;
        if ((this.cdrsfkpartPK == null && other.cdrsfkpartPK != null) || (this.cdrsfkpartPK != null && !this.cdrsfkpartPK.equals(other.cdrsfkpartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Cdrsfkpart[ cdrsfkpartPK=" + cdrsfkpartPK + " ]";
    }

}
