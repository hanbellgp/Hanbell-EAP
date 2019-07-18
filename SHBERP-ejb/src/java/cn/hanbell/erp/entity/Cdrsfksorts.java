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
@Table(name = "cdrsfksorts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrsfksorts.findAll", query = "SELECT c FROM Cdrsfksorts c")
    , @NamedQuery(name = "Cdrsfksorts.findByFacno", query = "SELECT c FROM Cdrsfksorts c WHERE c.cdrsfksortsPK.facno = :facno")
    , @NamedQuery(name = "Cdrsfksorts.findByParts", query = "SELECT c FROM Cdrsfksorts c WHERE c.cdrsfksortsPK.parts = :parts")
    , @NamedQuery(name = "Cdrsfksorts.findBySorts", query = "SELECT c FROM Cdrsfksorts c WHERE c.cdrsfksortsPK.sorts = :sorts")
    , @NamedQuery(name = "Cdrsfksorts.findByPK", query = "SELECT c FROM Cdrsfksorts c WHERE c.cdrsfksortsPK.facno = :facno AND c.cdrsfksortsPK.parts = :parts AND c.cdrsfksortsPK.sorts = :sorts")
    , @NamedQuery(name = "Cdrsfksorts.findBySortsdesc", query = "SELECT c FROM Cdrsfksorts c WHERE c.sortsdesc = :sortsdesc")})
public class Cdrsfksorts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrsfksortsPK cdrsfksortsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sortsdesc")
    private String sortsdesc;

    public Cdrsfksorts() {
    }

    public Cdrsfksorts(CdrsfksortsPK cdrsfksortsPK) {
        this.cdrsfksortsPK = cdrsfksortsPK;
    }

    public Cdrsfksorts(CdrsfksortsPK cdrsfksortsPK, String sortsdesc) {
        this.cdrsfksortsPK = cdrsfksortsPK;
        this.sortsdesc = sortsdesc;
    }

    public Cdrsfksorts(String facno, String parts, String sorts) {
        this.cdrsfksortsPK = new CdrsfksortsPK(facno, parts, sorts);
    }

    public CdrsfksortsPK getCdrsfksortsPK() {
        return cdrsfksortsPK;
    }

    public void setCdrsfksortsPK(CdrsfksortsPK cdrsfksortsPK) {
        this.cdrsfksortsPK = cdrsfksortsPK;
    }

    public String getSortsdesc() {
        return sortsdesc;
    }

    public void setSortsdesc(String sortsdesc) {
        this.sortsdesc = sortsdesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrsfksortsPK != null ? cdrsfksortsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrsfksorts)) {
            return false;
        }
        Cdrsfksorts other = (Cdrsfksorts) object;
        if ((this.cdrsfksortsPK == null && other.cdrsfksortsPK != null) || (this.cdrsfksortsPK != null && !this.cdrsfksortsPK.equals(other.cdrsfksortsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrsfksorts[ cdrsfksortsPK=" + cdrsfksortsPK + " ]";
    }

}
