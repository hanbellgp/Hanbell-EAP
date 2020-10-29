/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "cdrcusman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrcusman.findAll", query = "SELECT c FROM Cdrcusman c"),
    @NamedQuery(name = "Cdrcusman.findByPK", query = "SELECT c FROM Cdrcusman c WHERE c.cdrcusmanPK.facno = :facno AND  c.cdrcusmanPK.cusno = :cusno"),
    @NamedQuery(name = "Cdrcusman.findByMan", query = "SELECT c FROM Cdrcusman c WHERE c.man = :man"),
    @NamedQuery(name = "Cdrcusman.findByLatdate", query = "SELECT c FROM Cdrcusman c WHERE c.latdate = :latdate")})
public class Cdrcusman implements Serializable {

    @JsonbTransient
    @OneToOne()
    @JoinColumns({
        @JoinColumn(name = "cusno", referencedColumnName = "cusno", insertable = false, updatable = false)
    })
    private Cdrcus cdrcus;

    @OneToOne(optional = false)
    @JoinColumns({
        @JoinColumn(name = "man", referencedColumnName = "userno", insertable = false, updatable = false)
    })
    private Secuser secuser;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrcusmanPK cdrcusmanPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "man")
    private String man;
    @Column(name = "latdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latdate;

    public Cdrcusman() {
    }

    public Cdrcusman(CdrcusmanPK cdrcusmanPK) {
        this.cdrcusmanPK = cdrcusmanPK;
    }

    public Cdrcusman(String facno, String cusno) {
        this.cdrcusmanPK = new CdrcusmanPK(facno, cusno);
    }

    public CdrcusmanPK getCdrcusmanPK() {
        return cdrcusmanPK;
    }

    public void setCdrcusmanPK(CdrcusmanPK cdrcusmanPK) {
        this.cdrcusmanPK = cdrcusmanPK;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public Date getLatdate() {
        return latdate;
    }

    public void setLatdate(Date latdate) {
        this.latdate = latdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrcusmanPK != null ? cdrcusmanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrcusman)) {
            return false;
        }
        Cdrcusman other = (Cdrcusman) object;
        if (this.cdrcusmanPK != null && other.cdrcusmanPK != null) {
            return this.cdrcusmanPK.equals(other.cdrcusmanPK);
        }
        return this.man.equals(other.man);
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrcusman[ cdrcusmanPK=" + cdrcusmanPK + " ]";
    }

    /**
     * @return the cdrcus
     */
    public Cdrcus getCdrcus() {
        return cdrcus;
    }

    /**
     * @return the secuser
     */
    public Secuser getSecuser() {
        return secuser;
    }

}
