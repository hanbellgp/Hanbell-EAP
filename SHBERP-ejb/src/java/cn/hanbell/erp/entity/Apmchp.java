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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
 * @author Administrator
 */
@Entity
@Table(name = "apmchp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmchp.findAll", query = "SELECT a FROM Apmchp a"),
    @NamedQuery(name = "Apmchp.findByFacno", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.facno = :facno"),
    @NamedQuery(name = "Apmchp.findByTrno", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.trno = :trno"),
    @NamedQuery(name = "Apmchp.findByVdrno", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.vdrno = :vdrno"),
    @NamedQuery(name = "Apmchp.findByAccno", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.accno = :accno"),
    @NamedQuery(name = "Apmchp.findByDetno", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.detno = :detno"),
    @NamedQuery(name = "Apmchp.findByTrseq", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.trseq = :trseq"),
    @NamedQuery(name = "Apmchp.findByConfig", query = "SELECT a FROM Apmchp a WHERE a.config = :config"),
    @NamedQuery(name = "Apmchp.findByPayda", query = "SELECT a FROM Apmchp a WHERE a.payda = :payda"),
    @NamedQuery(name = "Apmchp.findByTerda", query = "SELECT a FROM Apmchp a WHERE a.terda = :terda"),
    @NamedQuery(name = "Apmchp.findByPayamtfs", query = "SELECT a FROM Apmchp a WHERE a.payamtfs = :payamtfs"),
    @NamedQuery(name = "Apmchp.findByPayamt", query = "SELECT a FROM Apmchp a WHERE a.payamt = :payamt"),
    @NamedQuery(name = "Apmchp.findByCoin", query = "SELECT a FROM Apmchp a WHERE a.coin = :coin"),
    @NamedQuery(name = "Apmchp.findByRatio", query = "SELECT a FROM Apmchp a WHERE a.ratio = :ratio"),
    @NamedQuery(name = "Apmchp.findByPayyn", query = "SELECT a FROM Apmchp a WHERE a.payyn = :payyn"),
    @NamedQuery(name = "Apmchp.findByPayptn", query = "SELECT a FROM Apmchp a WHERE a.payptn = :payptn"),
    @NamedQuery(name = "Apmchp.findByVouno", query = "SELECT a FROM Apmchp a WHERE a.vouno = :vouno"),
    @NamedQuery(name = "Apmchp.findByHpayamt", query = "SELECT a FROM Apmchp a WHERE a.hpayamt = :hpayamt"),
    @NamedQuery(name = "Apmchp.findByVdrnoAndTrno", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.facno = :facno AND a.apmchpPK.vdrno = :vdrno AND a.apmchpPK.trno = :trno "),
    @NamedQuery(name = "Apmchp.findByPK", query = "SELECT a FROM Apmchp a WHERE a.apmchpPK.facno = :facno AND a.apmchpPK.trno = :trno AND a.apmchpPK.vdrno = :vdrno "
            + "AND a.apmchpPK.accno = :accno AND a.apmchpPK.detno = :detno AND a.apmchpPK.trseq = :trseq ")})
public class Apmchp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmchpPK apmchpPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "config")
    private short config;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payda;
    @Column(name = "terda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "payamtfs")
    private BigDecimal payamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payamt")
    private BigDecimal payamt;
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
    @Size(min = 1, max = 1)
    @Column(name = "payyn")
    private String payyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "payptn")
    private String payptn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "vouno")
    private String vouno;
    @Column(name = "hpayamtfs")
    private BigDecimal hpayamtfs;
    @Column(name = "hpayamt")
    private BigDecimal hpayamt;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "trno", referencedColumnName = "trno", insertable = false, updatable = false),
        @JoinColumn(name = "vdrno", referencedColumnName = "vdrno", insertable = false, updatable = false),
        @JoinColumn(name = "accno", referencedColumnName = "accno", insertable = false, updatable = false),
        @JoinColumn(name = "detno", referencedColumnName = "detno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Apmhad apmhad;

    public Apmchp() {
    }

    public Apmchp(ApmchpPK apmchpPK) {
        this.apmchpPK = apmchpPK;
    }

    public Apmchp(ApmchpPK apmchpPK, short config, Date payda, BigDecimal payamtfs, BigDecimal payamt, String coin, BigDecimal ratio, String payyn, String payptn, String vouno) {
        this.apmchpPK = apmchpPK;
        this.config = config;
        this.payda = payda;
        this.payamtfs = payamtfs;
        this.payamt = payamt;
        this.coin = coin;
        this.ratio = ratio;
        this.payyn = payyn;
        this.payptn = payptn;
        this.vouno = vouno;
    }

    public Apmchp(String facno, String trno, String vdrno, String accno, String detno, short trseq) {
        this.apmchpPK = new ApmchpPK(facno, trno, vdrno, accno, detno, trseq);
    }

    public ApmchpPK getApmchpPK() {
        return apmchpPK;
    }

    public void setApmchpPK(ApmchpPK apmchpPK) {
        this.apmchpPK = apmchpPK;
    }

    public short getConfig() {
        return config;
    }

    public void setConfig(short config) {
        this.config = config;
    }

    public Date getPayda() {
        return payda;
    }

    public void setPayda(Date payda) {
        this.payda = payda;
    }

    public Date getTerda() {
        return terda;
    }

    public void setTerda(Date terda) {
        this.terda = terda;
    }

    public BigDecimal getPayamtfs() {
        return payamtfs;
    }

    public void setPayamtfs(BigDecimal payamtfs) {
        this.payamtfs = payamtfs;
    }

    public BigDecimal getPayamt() {
        return payamt;
    }

    public void setPayamt(BigDecimal payamt) {
        this.payamt = payamt;
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

    public String getPayyn() {
        return payyn;
    }

    public void setPayyn(String payyn) {
        this.payyn = payyn;
    }

    public String getPayptn() {
        return payptn;
    }

    public void setPayptn(String payptn) {
        this.payptn = payptn;
    }

    public String getVouno() {
        return vouno;
    }

    public void setVouno(String vouno) {
        this.vouno = vouno;
    }

    public BigDecimal getHpayamtfs() {
        return hpayamtfs;
    }

    public void setHpayamtfs(BigDecimal hpayamtfs) {
        this.hpayamtfs = hpayamtfs;
    }

    public BigDecimal getHpayamt() {
        return hpayamt;
    }

    public void setHpayamt(BigDecimal hpayamt) {
        this.hpayamt = hpayamt;
    }

    public Apmhad getApmhad() {
        return apmhad;
    }

    public void setApmhad(Apmhad apmhad) {
        this.apmhad = apmhad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmchpPK != null ? apmchpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmchp)) {
            return false;
        }
        Apmchp other = (Apmchp) object;
        if ((this.apmchpPK == null && other.apmchpPK != null) || (this.apmchpPK != null && !this.apmchpPK.equals(other.apmchpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmchp[ apmchpPK=" + apmchpPK + " ]";
    }

}
