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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "apmpur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmpur.findAll", query = "SELECT a FROM Apmpur a"),
    @NamedQuery(name = "Apmpur.findByBilno", query = "SELECT a FROM Apmpur a WHERE a.apmpurPK.bilno = :bilno"),
    @NamedQuery(name = "Apmpur.findByAcpno", query = "SELECT a FROM Apmpur a WHERE a.apmpurPK.acpno = :acpno"),
    @NamedQuery(name = "Apmpur.findByFacno", query = "SELECT a FROM Apmpur a WHERE a.apmpurPK.facno = :facno"),
    @NamedQuery(name = "Apmpur.findByThamt", query = "SELECT a FROM Apmpur a WHERE a.thamt = :thamt"),
    @NamedQuery(name = "Apmpur.findByThpre", query = "SELECT a FROM Apmpur a WHERE a.thpre = :thpre"),
    @NamedQuery(name = "Apmpur.findByThtem", query = "SELECT a FROM Apmpur a WHERE a.thtem = :thtem"),
    @NamedQuery(name = "Apmpur.findByThtax", query = "SELECT a FROM Apmpur a WHERE a.thtax = :thtax"),
    @NamedQuery(name = "Apmpur.findByLosamt", query = "SELECT a FROM Apmpur a WHERE a.losamt = :losamt"),
    @NamedQuery(name = "Apmpur.findByCstamt", query = "SELECT a FROM Apmpur a WHERE a.cstamt = :cstamt"),
    @NamedQuery(name = "Apmpur.findByIvops", query = "SELECT a FROM Apmpur a WHERE a.ivops = :ivops"),
    @NamedQuery(name = "Apmpur.findByIvoms", query = "SELECT a FROM Apmpur a WHERE a.ivoms = :ivoms"),
    @NamedQuery(name = "Apmpur.findByThamtfs", query = "SELECT a FROM Apmpur a WHERE a.thamtfs = :thamtfs"),
    @NamedQuery(name = "Apmpur.findByThprefs", query = "SELECT a FROM Apmpur a WHERE a.thprefs = :thprefs"),
    @NamedQuery(name = "Apmpur.findByThtemfs", query = "SELECT a FROM Apmpur a WHERE a.thtemfs = :thtemfs"),
    @NamedQuery(name = "Apmpur.findByThtaxfs", query = "SELECT a FROM Apmpur a WHERE a.thtaxfs = :thtaxfs"),
    @NamedQuery(name = "Apmpur.findByLosamtfs", query = "SELECT a FROM Apmpur a WHERE a.losamtfs = :losamtfs"),
    @NamedQuery(name = "Apmpur.findByCstamtfs", query = "SELECT a FROM Apmpur a WHERE a.cstamtfs = :cstamtfs"),
    @NamedQuery(name = "Apmpur.findByIvopsfs", query = "SELECT a FROM Apmpur a WHERE a.ivopsfs = :ivopsfs"),
    @NamedQuery(name = "Apmpur.findByIvomsfs", query = "SELECT a FROM Apmpur a WHERE a.ivomsfs = :ivomsfs"),
    @NamedQuery(name = "Apmpur.findByCoin", query = "SELECT a FROM Apmpur a WHERE a.coin = :coin"),
    @NamedQuery(name = "Apmpur.findByRatio", query = "SELECT a FROM Apmpur a WHERE a.ratio = :ratio"),
    @NamedQuery(name = "Apmpur.findByUsrno", query = "SELECT a FROM Apmpur a WHERE a.usrno = :usrno"),
    @NamedQuery(name = "Apmpur.findBySponr", query = "SELECT a FROM Apmpur a WHERE a.sponr = :sponr"),
    @NamedQuery(name = "Apmpur.findBySrckind", query = "SELECT a FROM Apmpur a WHERE a.srckind = :srckind"),
    @NamedQuery(name = "Apmpur.findBySeqno", query = "SELECT a FROM Apmpur a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "Apmpur.findByProno", query = "SELECT a FROM Apmpur a WHERE a.prono = :prono"),
    @NamedQuery(name = "Apmpur.findByChgno", query = "SELECT a FROM Apmpur a WHERE a.chgno = :chgno"),
    @NamedQuery(name = "Apmpur.findByTrtype", query = "SELECT a FROM Apmpur a WHERE a.trtype = :trtype"),
    @NamedQuery(name = "Apmpur.findByApmqty", query = "SELECT a FROM Apmpur a WHERE a.apmqty = :apmqty")})
public class Apmpur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmpurPK apmpurPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "thamt")
    private BigDecimal thamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thpre")
    private BigDecimal thpre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thtem")
    private BigDecimal thtem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thtax")
    private BigDecimal thtax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamt")
    private BigDecimal losamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cstamt")
    private BigDecimal cstamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivops")
    private BigDecimal ivops;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivoms")
    private BigDecimal ivoms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thamtfs")
    private BigDecimal thamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thprefs")
    private BigDecimal thprefs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thtemfs")
    private BigDecimal thtemfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thtaxfs")
    private BigDecimal thtaxfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamtfs")
    private BigDecimal losamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cstamtfs")
    private BigDecimal cstamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivopsfs")
    private BigDecimal ivopsfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivomsfs")
    private BigDecimal ivomsfs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usrno")
    private String usrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "sponr")
    private String sponr;
    @Column(name = "srckind")
    private Character srckind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private short seqno;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 8)
    @Column(name = "chgno")
    private String chgno;
    @Size(max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Column(name = "apmqty")
    private BigDecimal apmqty;

    public Apmpur() {
    }

    public Apmpur(ApmpurPK apmpurPK) {
        this.apmpurPK = apmpurPK;
    }

    public Apmpur(ApmpurPK apmpurPK, BigDecimal thamt, BigDecimal thpre, BigDecimal thtem, BigDecimal thtax, BigDecimal losamt, BigDecimal cstamt, BigDecimal ivops, BigDecimal ivoms, BigDecimal thamtfs, BigDecimal thprefs, BigDecimal thtemfs, BigDecimal thtaxfs, BigDecimal losamtfs, BigDecimal cstamtfs, BigDecimal ivopsfs, BigDecimal ivomsfs, String coin, BigDecimal ratio, String usrno, String sponr, short seqno) {
        this.apmpurPK = apmpurPK;
        this.thamt = thamt;
        this.thpre = thpre;
        this.thtem = thtem;
        this.thtax = thtax;
        this.losamt = losamt;
        this.cstamt = cstamt;
        this.ivops = ivops;
        this.ivoms = ivoms;
        this.thamtfs = thamtfs;
        this.thprefs = thprefs;
        this.thtemfs = thtemfs;
        this.thtaxfs = thtaxfs;
        this.losamtfs = losamtfs;
        this.cstamtfs = cstamtfs;
        this.ivopsfs = ivopsfs;
        this.ivomsfs = ivomsfs;
        this.coin = coin;
        this.ratio = ratio;
        this.usrno = usrno;
        this.sponr = sponr;
        this.seqno = seqno;
    }

    public Apmpur(String bilno, String acpno, String facno) {
        this.apmpurPK = new ApmpurPK(bilno, acpno, facno);
    }

    public ApmpurPK getApmpurPK() {
        return apmpurPK;
    }

    public void setApmpurPK(ApmpurPK apmpurPK) {
        this.apmpurPK = apmpurPK;
    }

    public BigDecimal getThamt() {
        return thamt;
    }

    public void setThamt(BigDecimal thamt) {
        this.thamt = thamt;
    }

    public BigDecimal getThpre() {
        return thpre;
    }

    public void setThpre(BigDecimal thpre) {
        this.thpre = thpre;
    }

    public BigDecimal getThtem() {
        return thtem;
    }

    public void setThtem(BigDecimal thtem) {
        this.thtem = thtem;
    }

    public BigDecimal getThtax() {
        return thtax;
    }

    public void setThtax(BigDecimal thtax) {
        this.thtax = thtax;
    }

    public BigDecimal getLosamt() {
        return losamt;
    }

    public void setLosamt(BigDecimal losamt) {
        this.losamt = losamt;
    }

    public BigDecimal getCstamt() {
        return cstamt;
    }

    public void setCstamt(BigDecimal cstamt) {
        this.cstamt = cstamt;
    }

    public BigDecimal getIvops() {
        return ivops;
    }

    public void setIvops(BigDecimal ivops) {
        this.ivops = ivops;
    }

    public BigDecimal getIvoms() {
        return ivoms;
    }

    public void setIvoms(BigDecimal ivoms) {
        this.ivoms = ivoms;
    }

    public BigDecimal getThamtfs() {
        return thamtfs;
    }

    public void setThamtfs(BigDecimal thamtfs) {
        this.thamtfs = thamtfs;
    }

    public BigDecimal getThprefs() {
        return thprefs;
    }

    public void setThprefs(BigDecimal thprefs) {
        this.thprefs = thprefs;
    }

    public BigDecimal getThtemfs() {
        return thtemfs;
    }

    public void setThtemfs(BigDecimal thtemfs) {
        this.thtemfs = thtemfs;
    }

    public BigDecimal getThtaxfs() {
        return thtaxfs;
    }

    public void setThtaxfs(BigDecimal thtaxfs) {
        this.thtaxfs = thtaxfs;
    }

    public BigDecimal getLosamtfs() {
        return losamtfs;
    }

    public void setLosamtfs(BigDecimal losamtfs) {
        this.losamtfs = losamtfs;
    }

    public BigDecimal getCstamtfs() {
        return cstamtfs;
    }

    public void setCstamtfs(BigDecimal cstamtfs) {
        this.cstamtfs = cstamtfs;
    }

    public BigDecimal getIvopsfs() {
        return ivopsfs;
    }

    public void setIvopsfs(BigDecimal ivopsfs) {
        this.ivopsfs = ivopsfs;
    }

    public BigDecimal getIvomsfs() {
        return ivomsfs;
    }

    public void setIvomsfs(BigDecimal ivomsfs) {
        this.ivomsfs = ivomsfs;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getUsrno() {
        return usrno;
    }

    public void setUsrno(String usrno) {
        this.usrno = usrno;
    }

    public String getSponr() {
        return sponr;
    }

    public void setSponr(String sponr) {
        this.sponr = sponr;
    }

    public Character getSrckind() {
        return srckind;
    }

    public void setSrckind(Character srckind) {
        this.srckind = srckind;
    }

    public short getSeqno() {
        return seqno;
    }

    public void setSeqno(short seqno) {
        this.seqno = seqno;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getChgno() {
        return chgno;
    }

    public void setChgno(String chgno) {
        this.chgno = chgno;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public BigDecimal getApmqty() {
        return apmqty;
    }

    public void setApmqty(BigDecimal apmqty) {
        this.apmqty = apmqty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmpurPK != null ? apmpurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmpur)) {
            return false;
        }
        Apmpur other = (Apmpur) object;
        if ((this.apmpurPK == null && other.apmpurPK != null) || (this.apmpurPK != null && !this.apmpurPK.equals(other.apmpurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmpur[ apmpurPK=" + apmpurPK + " ]";
    }

}
