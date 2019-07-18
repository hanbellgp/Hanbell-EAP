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
@Table(name = "invbat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invbat.findAll", query = "SELECT i FROM Invbat i"),
    @NamedQuery(name = "Invbat.findByItnbr", query = "SELECT i FROM Invbat i WHERE i.invbatPK.itnbr = :itnbr"),
    @NamedQuery(name = "Invbat.findByPK", query = "SELECT i FROM Invbat i WHERE i.invbatPK.facno = :facno AND i.invbatPK.prono = :prono AND  i.invbatPK.itnbr = :itnbr AND  i.invbatPK.wareh = :wareh AND i.invbatPK.fixnr = :fixnr AND i.invbatPK.varnr = :varnr"),
    @NamedQuery(name = "Invbat.findByWareh", query = "SELECT i FROM Invbat i WHERE i.invbatPK.wareh = :wareh"),
    @NamedQuery(name = "Invbat.findByFixnr", query = "SELECT i FROM Invbat i WHERE i.invbatPK.fixnr = :fixnr"),
    @NamedQuery(name = "Invbat.findByVarnr", query = "SELECT i FROM Invbat i WHERE i.invbatPK.varnr = :varnr"),
    @NamedQuery(name = "Invbat.findByItcls", query = "SELECT i FROM Invbat i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "Invbat.findByItclscode", query = "SELECT i FROM Invbat i WHERE i.itclscode = :itclscode")})
public class Invbat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvbatPK invbatPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itclscode")
    private Character itclscode;
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Column(name = "lindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lindate;
    @Column(name = "loudate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loudate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preqy1")
    private BigDecimal preqy1;
    @Column(name = "preqy2")
    private BigDecimal preqy2;
    @Column(name = "preqy3")
    private BigDecimal preqy3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onhand1")
    private BigDecimal onhand1;
    @Column(name = "onhand2")
    private BigDecimal onhand2;
    @Column(name = "onhand3")
    private BigDecimal onhand3;
    @Column(name = "mbegqy1")
    private BigDecimal mbegqy1;
    @Column(name = "mbegqy2")
    private BigDecimal mbegqy2;
    @Column(name = "mbegqy3")
    private BigDecimal mbegqy3;

    public Invbat() {
        this.preqy1 = BigDecimal.ZERO;
        this.preqy2 = BigDecimal.ZERO;
        this.preqy3 = BigDecimal.ZERO;
        this.onhand1 = BigDecimal.ZERO;
        this.onhand2 = BigDecimal.ZERO;
        this.onhand3 = BigDecimal.ZERO;
        this.mbegqy1 = BigDecimal.ZERO;
        this.mbegqy2 = BigDecimal.ZERO;
        this.mbegqy3 = BigDecimal.ZERO;
    }

    public Invbat(InvbatPK invbatPK) {
        this.invbatPK = invbatPK;
        this.preqy1 = BigDecimal.ZERO;
        this.preqy2 = BigDecimal.ZERO;
        this.preqy3 = BigDecimal.ZERO;
        this.onhand1 = BigDecimal.ZERO;
        this.onhand2 = BigDecimal.ZERO;
        this.onhand3 = BigDecimal.ZERO;
        this.mbegqy1 = BigDecimal.ZERO;
        this.mbegqy2 = BigDecimal.ZERO;
        this.mbegqy3 = BigDecimal.ZERO;
    }

    public Invbat(String facno, String prono, String itnbr, String wareh, String fixnr, String varnr) {
        this.invbatPK = new InvbatPK(facno, prono, itnbr, wareh, fixnr, varnr);
        this.preqy1 = BigDecimal.ZERO;
        this.preqy2 = BigDecimal.ZERO;
        this.preqy3 = BigDecimal.ZERO;
        this.onhand1 = BigDecimal.ZERO;
        this.onhand2 = BigDecimal.ZERO;
        this.onhand3 = BigDecimal.ZERO;
        this.mbegqy1 = BigDecimal.ZERO;
        this.mbegqy2 = BigDecimal.ZERO;
        this.mbegqy3 = BigDecimal.ZERO;
    }

    public InvbatPK getInvbatPK() {
        return invbatPK;
    }

    public void setInvbatPK(InvbatPK invbatPK) {
        this.invbatPK = invbatPK;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public Character getItclscode() {
        return itclscode;
    }

    public void setItclscode(Character itclscode) {
        this.itclscode = itclscode;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public Date getLindate() {
        return lindate;
    }

    public void setLindate(Date lindate) {
        this.lindate = lindate;
    }

    public Date getLoudate() {
        return loudate;
    }

    public void setLoudate(Date loudate) {
        this.loudate = loudate;
    }

    public BigDecimal getPreqy1() {
        return preqy1;
    }

    public void setPreqy1(BigDecimal preqy1) {
        this.preqy1 = preqy1;
    }

    public BigDecimal getPreqy2() {
        return preqy2;
    }

    public void setPreqy2(BigDecimal preqy2) {
        this.preqy2 = preqy2;
    }

    public BigDecimal getPreqy3() {
        return preqy3;
    }

    public void setPreqy3(BigDecimal preqy3) {
        this.preqy3 = preqy3;
    }

    public BigDecimal getOnhand1() {
        return onhand1;
    }

    public void setOnhand1(BigDecimal onhand1) {
        this.onhand1 = onhand1;
    }

    public BigDecimal getOnhand2() {
        return onhand2;
    }

    public void setOnhand2(BigDecimal onhand2) {
        this.onhand2 = onhand2;
    }

    public BigDecimal getOnhand3() {
        return onhand3;
    }

    public void setOnhand3(BigDecimal onhand3) {
        this.onhand3 = onhand3;
    }

    public BigDecimal getMbegqy1() {
        return mbegqy1;
    }

    public void setMbegqy1(BigDecimal mbegqy1) {
        this.mbegqy1 = mbegqy1;
    }

    public BigDecimal getMbegqy2() {
        return mbegqy2;
    }

    public void setMbegqy2(BigDecimal mbegqy2) {
        this.mbegqy2 = mbegqy2;
    }

    public BigDecimal getMbegqy3() {
        return mbegqy3;
    }

    public void setMbegqy3(BigDecimal mbegqy3) {
        this.mbegqy3 = mbegqy3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invbatPK != null ? invbatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invbat)) {
            return false;
        }
        Invbat other = (Invbat) object;
        if ((this.invbatPK == null && other.invbatPK != null) || (this.invbatPK != null && !this.invbatPK.equals(other.invbatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invbat[ invbatPK=" + invbatPK + " ]";
    }

}
