/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "invpri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invpri.findAll", query = "SELECT i FROM Invpri i"),
    @NamedQuery(name = "Invpri.findByYearmon", query = "SELECT i FROM Invpri i WHERE i.invpriPK.yearmon = :yearmon"),
    @NamedQuery(name = "Invpri.findByItnbr", query = "SELECT i FROM Invpri i WHERE i.invpriPK.itnbr = :itnbr"),
    @NamedQuery(name = "Invpri.findByFacno", query = "SELECT i FROM Invpri i WHERE i.invpriPK.facno = :facno"),
    @NamedQuery(name = "Invpri.findByPuravgcst", query = "SELECT i FROM Invpri i WHERE i.puravgcst = :puravgcst"),
    @NamedQuery(name = "Invpri.findByPurtotqy", query = "SELECT i FROM Invpri i WHERE i.purtotqy = :purtotqy"),
    @NamedQuery(name = "Invpri.findByPurtotcst", query = "SELECT i FROM Invpri i WHERE i.purtotcst = :purtotcst"),
    @NamedQuery(name = "Invpri.findBySfcavgcst", query = "SELECT i FROM Invpri i WHERE i.sfcavgcst = :sfcavgcst"),
    @NamedQuery(name = "Invpri.findBySfctotqy", query = "SELECT i FROM Invpri i WHERE i.sfctotqy = :sfctotqy"),
    @NamedQuery(name = "Invpri.findBySfctotcst", query = "SELECT i FROM Invpri i WHERE i.sfctotcst = :sfctotcst"),
    @NamedQuery(name = "Invpri.findByOthavgcst", query = "SELECT i FROM Invpri i WHERE i.othavgcst = :othavgcst"),
    @NamedQuery(name = "Invpri.findByOthtotqy", query = "SELECT i FROM Invpri i WHERE i.othtotqy = :othtotqy"),
    @NamedQuery(name = "Invpri.findByOthtotcst", query = "SELECT i FROM Invpri i WHERE i.othtotcst = :othtotcst"),
    @NamedQuery(name = "Invpri.findByInavgcst", query = "SELECT i FROM Invpri i WHERE i.inavgcst = :inavgcst"),
    @NamedQuery(name = "Invpri.findByIntotqy", query = "SELECT i FROM Invpri i WHERE i.intotqy = :intotqy"),
    @NamedQuery(name = "Invpri.findByIntotcst", query = "SELECT i FROM Invpri i WHERE i.intotcst = :intotcst"),
    @NamedQuery(name = "Invpri.findByUnitavgcst", query = "SELECT i FROM Invpri i WHERE i.unitavgcst = :unitavgcst"),
    @NamedQuery(name = "Invpri.findByUnittotqy", query = "SELECT i FROM Invpri i WHERE i.unittotqy = :unittotqy"),
    @NamedQuery(name = "Invpri.findByUnittotcst", query = "SELECT i FROM Invpri i WHERE i.unittotcst = :unittotcst"),
    @NamedQuery(name = "Invpri.findByUnitstdcst", query = "SELECT i FROM Invpri i WHERE i.unitstdcst = :unitstdcst"),
    @NamedQuery(name = "Invpri.findByPK", query = "SELECT i FROM Invpri i WHERE i.invpriPK.facno = :facno AND i.invpriPK.yearmon = :yearmon AND i.invpriPK.itnbr = :itnbr"),
    @NamedQuery(name = "Invpri.findByMorpcode", query = "SELECT i FROM Invpri i WHERE i.morpcode = :morpcode")})
public class Invpri implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvpriPK invpriPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "puravgcst")
    private BigDecimal puravgcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purtotqy")
    private BigDecimal purtotqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purtotcst")
    private BigDecimal purtotcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sfcavgcst")
    private BigDecimal sfcavgcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sfctotqy")
    private BigDecimal sfctotqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sfctotcst")
    private BigDecimal sfctotcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "othavgcst")
    private BigDecimal othavgcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "othtotqy")
    private BigDecimal othtotqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "othtotcst")
    private BigDecimal othtotcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inavgcst")
    private BigDecimal inavgcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intotqy")
    private BigDecimal intotqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intotcst")
    private BigDecimal intotcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitavgcst")
    private BigDecimal unitavgcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unittotqy")
    private BigDecimal unittotqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unittotcst")
    private BigDecimal unittotcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitstdcst")
    private BigDecimal unitstdcst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btmatm")
    private BigDecimal btmatm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btmanm")
    private BigDecimal btmanm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btexpm")
    private BigDecimal btexpm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btassm")
    private BigDecimal btassm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otexpm")
    private BigDecimal otexpm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otmatm")
    private BigDecimal otmatm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otmanm")
    private BigDecimal otmanm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otassm")
    private BigDecimal otassm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otmatp")
    private BigDecimal otmatp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otmanp")
    private BigDecimal otmanp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otexpp")
    private BigDecimal otexpp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otassp")
    private BigDecimal otassp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etmatm")
    private BigDecimal etmatm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etmanm")
    private BigDecimal etmanm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etexpm")
    private BigDecimal etexpm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etassm")
    private BigDecimal etassm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stmatp")
    private BigDecimal stmatp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stmanp")
    private BigDecimal stmanp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stexpp")
    private BigDecimal stexpp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stassp")
    private BigDecimal stassp;
    @Column(name = "morpcode")
    private Character morpcode;

    public Invpri() {
    }

    public Invpri(InvpriPK invpriPK) {
        this.invpriPK = invpriPK;
    }

    public Invpri(InvpriPK invpriPK, BigDecimal puravgcst, BigDecimal purtotqy, BigDecimal purtotcst, BigDecimal sfcavgcst, BigDecimal sfctotqy, BigDecimal sfctotcst, BigDecimal othavgcst, BigDecimal othtotqy, BigDecimal othtotcst, BigDecimal inavgcst, BigDecimal intotqy, BigDecimal intotcst, BigDecimal unitavgcst, BigDecimal unittotqy, BigDecimal unittotcst, BigDecimal unitstdcst, BigDecimal btmatm, BigDecimal btmanm, BigDecimal btexpm, BigDecimal btassm, BigDecimal otexpm, BigDecimal otmatm, BigDecimal otmanm, BigDecimal otassm, BigDecimal otmatp, BigDecimal otmanp, BigDecimal otexpp, BigDecimal otassp, BigDecimal etmatm, BigDecimal etmanm, BigDecimal etexpm, BigDecimal etassm, BigDecimal stmatp, BigDecimal stmanp, BigDecimal stexpp, BigDecimal stassp) {
        this.invpriPK = invpriPK;
        this.puravgcst = puravgcst;
        this.purtotqy = purtotqy;
        this.purtotcst = purtotcst;
        this.sfcavgcst = sfcavgcst;
        this.sfctotqy = sfctotqy;
        this.sfctotcst = sfctotcst;
        this.othavgcst = othavgcst;
        this.othtotqy = othtotqy;
        this.othtotcst = othtotcst;
        this.inavgcst = inavgcst;
        this.intotqy = intotqy;
        this.intotcst = intotcst;
        this.unitavgcst = unitavgcst;
        this.unittotqy = unittotqy;
        this.unittotcst = unittotcst;
        this.unitstdcst = unitstdcst;
        this.btmatm = btmatm;
        this.btmanm = btmanm;
        this.btexpm = btexpm;
        this.btassm = btassm;
        this.otexpm = otexpm;
        this.otmatm = otmatm;
        this.otmanm = otmanm;
        this.otassm = otassm;
        this.otmatp = otmatp;
        this.otmanp = otmanp;
        this.otexpp = otexpp;
        this.otassp = otassp;
        this.etmatm = etmatm;
        this.etmanm = etmanm;
        this.etexpm = etexpm;
        this.etassm = etassm;
        this.stmatp = stmatp;
        this.stmanp = stmanp;
        this.stexpp = stexpp;
        this.stassp = stassp;
    }

    public Invpri(String yearmon, String itnbr, String facno) {
        this.invpriPK = new InvpriPK(yearmon, itnbr, facno);
    }

    public InvpriPK getInvpriPK() {
        return invpriPK;
    }

    public void setInvpriPK(InvpriPK invpriPK) {
        this.invpriPK = invpriPK;
    }

    public BigDecimal getPuravgcst() {
        return puravgcst;
    }

    public void setPuravgcst(BigDecimal puravgcst) {
        this.puravgcst = puravgcst;
    }

    public BigDecimal getPurtotqy() {
        return purtotqy;
    }

    public void setPurtotqy(BigDecimal purtotqy) {
        this.purtotqy = purtotqy;
    }

    public BigDecimal getPurtotcst() {
        return purtotcst;
    }

    public void setPurtotcst(BigDecimal purtotcst) {
        this.purtotcst = purtotcst;
    }

    public BigDecimal getSfcavgcst() {
        return sfcavgcst;
    }

    public void setSfcavgcst(BigDecimal sfcavgcst) {
        this.sfcavgcst = sfcavgcst;
    }

    public BigDecimal getSfctotqy() {
        return sfctotqy;
    }

    public void setSfctotqy(BigDecimal sfctotqy) {
        this.sfctotqy = sfctotqy;
    }

    public BigDecimal getSfctotcst() {
        return sfctotcst;
    }

    public void setSfctotcst(BigDecimal sfctotcst) {
        this.sfctotcst = sfctotcst;
    }

    public BigDecimal getOthavgcst() {
        return othavgcst;
    }

    public void setOthavgcst(BigDecimal othavgcst) {
        this.othavgcst = othavgcst;
    }

    public BigDecimal getOthtotqy() {
        return othtotqy;
    }

    public void setOthtotqy(BigDecimal othtotqy) {
        this.othtotqy = othtotqy;
    }

    public BigDecimal getOthtotcst() {
        return othtotcst;
    }

    public void setOthtotcst(BigDecimal othtotcst) {
        this.othtotcst = othtotcst;
    }

    public BigDecimal getInavgcst() {
        return inavgcst;
    }

    public void setInavgcst(BigDecimal inavgcst) {
        this.inavgcst = inavgcst;
    }

    public BigDecimal getIntotqy() {
        return intotqy;
    }

    public void setIntotqy(BigDecimal intotqy) {
        this.intotqy = intotqy;
    }

    public BigDecimal getIntotcst() {
        return intotcst;
    }

    public void setIntotcst(BigDecimal intotcst) {
        this.intotcst = intotcst;
    }

    public BigDecimal getUnitavgcst() {
        return unitavgcst;
    }

    public void setUnitavgcst(BigDecimal unitavgcst) {
        this.unitavgcst = unitavgcst;
    }

    public BigDecimal getUnittotqy() {
        return unittotqy;
    }

    public void setUnittotqy(BigDecimal unittotqy) {
        this.unittotqy = unittotqy;
    }

    public BigDecimal getUnittotcst() {
        return unittotcst;
    }

    public void setUnittotcst(BigDecimal unittotcst) {
        this.unittotcst = unittotcst;
    }

    public BigDecimal getUnitstdcst() {
        return unitstdcst;
    }

    public void setUnitstdcst(BigDecimal unitstdcst) {
        this.unitstdcst = unitstdcst;
    }

    public BigDecimal getBtmatm() {
        return btmatm;
    }

    public void setBtmatm(BigDecimal btmatm) {
        this.btmatm = btmatm;
    }

    public BigDecimal getBtmanm() {
        return btmanm;
    }

    public void setBtmanm(BigDecimal btmanm) {
        this.btmanm = btmanm;
    }

    public BigDecimal getBtexpm() {
        return btexpm;
    }

    public void setBtexpm(BigDecimal btexpm) {
        this.btexpm = btexpm;
    }

    public BigDecimal getBtassm() {
        return btassm;
    }

    public void setBtassm(BigDecimal btassm) {
        this.btassm = btassm;
    }

    public BigDecimal getOtexpm() {
        return otexpm;
    }

    public void setOtexpm(BigDecimal otexpm) {
        this.otexpm = otexpm;
    }

    public BigDecimal getOtmatm() {
        return otmatm;
    }

    public void setOtmatm(BigDecimal otmatm) {
        this.otmatm = otmatm;
    }

    public BigDecimal getOtmanm() {
        return otmanm;
    }

    public void setOtmanm(BigDecimal otmanm) {
        this.otmanm = otmanm;
    }

    public BigDecimal getOtassm() {
        return otassm;
    }

    public void setOtassm(BigDecimal otassm) {
        this.otassm = otassm;
    }

    public BigDecimal getOtmatp() {
        return otmatp;
    }

    public void setOtmatp(BigDecimal otmatp) {
        this.otmatp = otmatp;
    }

    public BigDecimal getOtmanp() {
        return otmanp;
    }

    public void setOtmanp(BigDecimal otmanp) {
        this.otmanp = otmanp;
    }

    public BigDecimal getOtexpp() {
        return otexpp;
    }

    public void setOtexpp(BigDecimal otexpp) {
        this.otexpp = otexpp;
    }

    public BigDecimal getOtassp() {
        return otassp;
    }

    public void setOtassp(BigDecimal otassp) {
        this.otassp = otassp;
    }

    public BigDecimal getEtmatm() {
        return etmatm;
    }

    public void setEtmatm(BigDecimal etmatm) {
        this.etmatm = etmatm;
    }

    public BigDecimal getEtmanm() {
        return etmanm;
    }

    public void setEtmanm(BigDecimal etmanm) {
        this.etmanm = etmanm;
    }

    public BigDecimal getEtexpm() {
        return etexpm;
    }

    public void setEtexpm(BigDecimal etexpm) {
        this.etexpm = etexpm;
    }

    public BigDecimal getEtassm() {
        return etassm;
    }

    public void setEtassm(BigDecimal etassm) {
        this.etassm = etassm;
    }

    public BigDecimal getStmatp() {
        return stmatp;
    }

    public void setStmatp(BigDecimal stmatp) {
        this.stmatp = stmatp;
    }

    public BigDecimal getStmanp() {
        return stmanp;
    }

    public void setStmanp(BigDecimal stmanp) {
        this.stmanp = stmanp;
    }

    public BigDecimal getStexpp() {
        return stexpp;
    }

    public void setStexpp(BigDecimal stexpp) {
        this.stexpp = stexpp;
    }

    public BigDecimal getStassp() {
        return stassp;
    }

    public void setStassp(BigDecimal stassp) {
        this.stassp = stassp;
    }

    public Character getMorpcode() {
        return morpcode;
    }

    public void setMorpcode(Character morpcode) {
        this.morpcode = morpcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invpriPK != null ? invpriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invpri)) {
            return false;
        }
        Invpri other = (Invpri) object;
        if ((this.invpriPK == null && other.invpriPK != null) || (this.invpriPK != null && !this.invpriPK.equals(other.invpriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invpri[ invpriPK=" + invpriPK + " ]";
    }

}
