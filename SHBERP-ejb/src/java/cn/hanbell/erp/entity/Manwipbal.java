/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "manwipbal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manwipbal.findAll", query = "SELECT m FROM Manwipbal m"),
    @NamedQuery(name = "Manwipbal.findByFacno", query = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.facno = :facno"),
    @NamedQuery(name = "Manwipbal.findByProno", query = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.prono = :prono"),
    @NamedQuery(name = "Manwipbal.findByManno", query = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.manno = :manno"),
    @NamedQuery(name = "Manwipbal.findByProsscode", query = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.prosscode = :prosscode"),
    @NamedQuery(name = "Manwipbal.findByWrcode", query = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.wrcode = :wrcode"),
    @NamedQuery(name = "Manwipbal.findByPctno", query = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.pctno = :pctno"),
    @NamedQuery(name = "Manwipbal.findByDepno", query = "SELECT m FROM Manwipbal m WHERE m.depno = :depno"),
    @NamedQuery(name = "Manwipbal.findByItnbr", query = "SELECT m FROM Manwipbal m WHERE m.itnbr = :itnbr")})
public class Manwipbal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManwipbalPK manwipbalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqnr")
    private short seqnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "keyindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyindate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "trnqy1")
    private BigDecimal trnqy1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hrcode")
    private Character hrcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mbegqy1")
    private BigDecimal mbegqy1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onhand1")
    private BigDecimal onhand1;
    @Column(name = "fbegqy1")
    private BigDecimal fbegqy1;
    @Column(name = "finqy1")
    private BigDecimal finqy1;

    public Manwipbal() {
    }

    public Manwipbal(String facno, String prono, String manno, String prosscode, String wrcode, String pctno) {
        this.manwipbalPK = new ManwipbalPK(facno, prono, manno, prosscode, wrcode, pctno);
    }

    public ManwipbalPK getManwipbalPK() {
        return manwipbalPK;
    }

    public void setManwipbalPK(ManwipbalPK manwipbalPK) {
        this.manwipbalPK = manwipbalPK;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public short getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(short seqnr) {
        this.seqnr = seqnr;
    }

    public Date getKeyindate() {
        return keyindate;
    }

    public void setKeyindate(Date keyindate) {
        this.keyindate = keyindate;
    }

    public BigDecimal getTrnqy1() {
        return trnqy1;
    }

    public void setTrnqy1(BigDecimal trnqy1) {
        this.trnqy1 = trnqy1;
    }

    public Character getHrcode() {
        return hrcode;
    }

    public void setHrcode(Character hrcode) {
        this.hrcode = hrcode;
    }

    public BigDecimal getMbegqy1() {
        return mbegqy1;
    }

    public void setMbegqy1(BigDecimal mbegqy1) {
        this.mbegqy1 = mbegqy1;
    }

    public BigDecimal getOnhand1() {
        return onhand1;
    }

    public void setOnhand1(BigDecimal onhand1) {
        this.onhand1 = onhand1;
    }

    public BigDecimal getFbegqy1() {
        return fbegqy1;
    }

    public void setFbegqy1(BigDecimal fbegqy1) {
        this.fbegqy1 = fbegqy1;
    }

    public BigDecimal getFinqy1() {
        return finqy1;
    }

    public void setFinqy1(BigDecimal finqy1) {
        this.finqy1 = finqy1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manwipbalPK != null ? manwipbalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manwipbal)) {
            return false;
        }
        Manwipbal other = (Manwipbal) object;
        if ((this.manwipbalPK == null && other.manwipbalPK != null) || (this.manwipbalPK != null && !this.manwipbalPK.equals(other.manwipbalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Manwipbal[ manwipbalPK=" + manwipbalPK + " ]";
    }

}
