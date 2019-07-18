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
 * @author C0160
 */
@Entity
@Table(name = "purdtamap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purdtamap.findAll", query = "SELECT p FROM Purdtamap p"),
    @NamedQuery(name = "Purdtamap.findByFacno", query = "SELECT p FROM Purdtamap p WHERE p.purdtamapPK.facno = :facno"),
    @NamedQuery(name = "Purdtamap.findByProno", query = "SELECT p FROM Purdtamap p WHERE p.purdtamapPK.prono = :prono"),
    @NamedQuery(name = "Purdtamap.findByPono", query = "SELECT p FROM Purdtamap p WHERE p.purdtamapPK.pono = :pono"),
    @NamedQuery(name = "Purdtamap.findByTrseq", query = "SELECT p FROM Purdtamap p WHERE p.purdtamapPK.trseq = :trseq"),
    @NamedQuery(name = "Purdtamap.findByPosrc", query = "SELECT p FROM Purdtamap p WHERE p.posrc = :posrc"),
    @NamedQuery(name = "Purdtamap.findBySrcno", query = "SELECT p FROM Purdtamap p WHERE p.srcno = :srcno"),
    @NamedQuery(name = "Purdtamap.findBySrcseq", query = "SELECT p FROM Purdtamap p WHERE p.srcseq = :srcseq")})
public class Purdtamap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurdtamapPK purdtamapPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posrc")
    private Character posrc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "srcno")
    private String srcno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "srcseq")
    private short srcseq;

    public Purdtamap() {
    }

    public Purdtamap(PurdtamapPK purdtamapPK) {
        this.purdtamapPK = purdtamapPK;
    }

    public Purdtamap(PurdtamapPK purdtamapPK, Character posrc, String srcno, short srcseq) {
        this.purdtamapPK = purdtamapPK;
        this.posrc = posrc;
        this.srcno = srcno;
        this.srcseq = srcseq;
    }

    public Purdtamap(String facno, String prono, String pono, short trseq) {
        this.purdtamapPK = new PurdtamapPK(facno, prono, pono, trseq);
    }

    public PurdtamapPK getPurdtamapPK() {
        return purdtamapPK;
    }

    public void setPurdtamapPK(PurdtamapPK purdtamapPK) {
        this.purdtamapPK = purdtamapPK;
    }

    public Character getPosrc() {
        return posrc;
    }

    public void setPosrc(Character posrc) {
        this.posrc = posrc;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public short getSrcseq() {
        return srcseq;
    }

    public void setSrcseq(short srcseq) {
        this.srcseq = srcseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purdtamapPK != null ? purdtamapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purdtamap)) {
            return false;
        }
        Purdtamap other = (Purdtamap) object;
        if ((this.purdtamapPK == null && other.purdtamapPK != null) || (this.purdtamapPK != null && !this.purdtamapPK.equals(other.purdtamapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purdtamap[ purdtamapPK=" + purdtamapPK + " ]";
    }
    
}
