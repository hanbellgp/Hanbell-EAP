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
 * @author C1491
 */
@Entity
@Table(name = "purqnam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purqnam.findAll", query = "SELECT p FROM Purqnam p"),
    @NamedQuery(name = "Purqnam.findByFacno", query = "SELECT p FROM Purqnam p WHERE p.purqnamPK.facno = :facno"),
    @NamedQuery(name = "Purqnam.findByProno", query = "SELECT p FROM Purqnam p WHERE p.purqnamPK.prono = :prono"),
    @NamedQuery(name = "Purqnam.findByPrno", query = "SELECT p FROM Purqnam p WHERE p.purqnamPK.prno = :prno"),
    @NamedQuery(name = "Purqnam.findByTrseq", query = "SELECT p FROM Purqnam p WHERE p.purqnamPK.trseq = :trseq"),
    @NamedQuery(name = "Purqnam.findByItdsc", query = "SELECT p FROM Purqnam p WHERE p.itdsc = :itdsc"),
    @NamedQuery(name = "Purqnam.findBySpdsc", query = "SELECT p FROM Purqnam p WHERE p.spdsc = :spdsc"),
    @NamedQuery(name = "Purqnam.findByUnmsr1", query = "SELECT p FROM Purqnam p WHERE p.unmsr1 = :unmsr1"),
    @NamedQuery(name = "Purqnam.findByUnmsr1e", query = "SELECT p FROM Purqnam p WHERE p.unmsr1e = :unmsr1e")})
public class Purqnam implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurqnamPK purqnamPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 30)
    @Column(name = "spdsc")
    private String spdsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 12)
    @Column(name = "unmsr1e")
    private String unmsr1e;

    public Purqnam() {
    }

    public Purqnam(PurqnamPK purqnamPK) {
        this.purqnamPK = purqnamPK;
    }

    public Purqnam(PurqnamPK purqnamPK, String itdsc, String unmsr1) {
        this.purqnamPK = purqnamPK;
        this.itdsc = itdsc;
        this.unmsr1 = unmsr1;
    }

    public Purqnam(String facno, String prono, String prno, short trseq) {
        this.purqnamPK = new PurqnamPK(facno, prono, prno, trseq);
    }

    public PurqnamPK getPurqnamPK() {
        return purqnamPK;
    }

    public void setPurqnamPK(PurqnamPK purqnamPK) {
        this.purqnamPK = purqnamPK;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getUnmsr1e() {
        return unmsr1e;
    }

    public void setUnmsr1e(String unmsr1e) {
        this.unmsr1e = unmsr1e;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purqnamPK != null ? purqnamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purqnam)) {
            return false;
        }
        Purqnam other = (Purqnam) object;
        if ((this.purqnamPK == null && other.purqnamPK != null) || (this.purqnamPK != null && !this.purqnamPK.equals(other.purqnamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purqnam[ purqnamPK=" + purqnamPK + " ]";
    }
    
}
