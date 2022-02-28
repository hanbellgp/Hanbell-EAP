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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "apmapd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmapd.findAll", query = "SELECT a FROM Apmapd a"),
    @NamedQuery(name = "Apmapd.findByFacno", query = "SELECT a FROM Apmapd a WHERE a.apmapdPK.facno = :facno"),
    @NamedQuery(name = "Apmapd.findByApno", query = "SELECT a FROM Apmapd a WHERE a.apmapdPK.apno = :apno"),
    @NamedQuery(name = "Apmapd.findByAptyp", query = "SELECT a FROM Apmapd a WHERE a.apmapdPK.aptyp = :aptyp"),
    @NamedQuery(name = "Apmapd.findByAcpno", query = "SELECT a FROM Apmapd a WHERE a.acpno = :acpno"),
    @NamedQuery(name = "Apmapd.findBySponr", query = "SELECT a FROM Apmapd a WHERE a.sponr = :sponr"),
    @NamedQuery(name = "Apmapd.findByOgdkid", query = "SELECT a FROM Apmapd a WHERE a.ogdkid = :ogdkid"),
    @NamedQuery(name = "Apmapd.findByBilno", query = "SELECT a FROM Apmapd a WHERE a.bilno = :bilno"),
    @NamedQuery(name = "Apmapd.findByFacnoAndApno", query = "SELECT a FROM Apmapd a WHERE a.apmapdPK.facno = :facno AND a.apmapdPK.apno = :apno ORDER BY a.apmapdPK.trseq "),
    @NamedQuery(name = "Apmapd.findByPK", query = "SELECT a FROM Apmapd a WHERE a.apmapdPK.facno = :facno AND a.apmapdPK.apno = :apno AND a.apmapdPK.aptyp = :aptyp AND a.apmapdPK.trseq = :trseq"),
    @NamedQuery(name = "Apmapd.findByNeedThrowDetail", query = "SELECT a FROM Apmapd a WHERE a.apmapdPK.facno = :facno  AND a.apmapdPK.apno = :apno AND a.apmapdPK.aptyp = :aptyp ORDER BY a.apmapdPK.trseq")})
public class Apmapd implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmapdPK apmapdPK;
    @Size(max = 22)
    @Column(name = "acpno")
    private String acpno;
    @Size(max = 22)
    @Column(name = "sponr")
    private String sponr;
    @Size(max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 60)
    @Column(name = "apdsc")
    private String apdsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ogdkid")
    private String ogdkid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payqty")
    private BigDecimal payqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pric")
    private BigDecimal pric;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acpamtfs")
    private BigDecimal acpamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acpamt")
    private BigDecimal acpamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamtfs")
    private BigDecimal preamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamt")
    private BigDecimal preamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temamtfs")
    private BigDecimal temamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temamt")
    private BigDecimal temamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apamtfs")
    private BigDecimal apamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apamt")
    private BigDecimal apamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "bilno")
    private String bilno;
    @Size(max = 20)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 1)
    @Column(name = "trapyh")
    private String trapyh;
    @Column(name = "expamtfs")
    private BigDecimal expamtfs;
    @Column(name = "expamt")
    private BigDecimal expamt;
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
    @Column(name = "ivopsfs")
    private BigDecimal ivopsfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivomsfs")
    private BigDecimal ivomsfs;
    @Column(name = "losamtfs")
    private BigDecimal losamtfs;
    @Column(name = "losamt")
    private BigDecimal losamt;
    @Column(name = "tax")
    private Character tax;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 10)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 10)
    @Column(name = "budgetacc")
    private String budgetacc;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "apno", referencedColumnName = "apno", insertable = false, updatable = false),
        @JoinColumn(name = "aptyp", referencedColumnName = "aptyp", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Apmaph apmaph;

    public Apmapd() {
        this.ogdkid = "";
        this.coin = "";
        this.bilno = "";

    }

    public Apmapd(ApmapdPK apmapdPK) {
        this.apmapdPK = apmapdPK;
    }

    public Apmapd(ApmapdPK apmapdPK, String ogdkid, String coin, BigDecimal ratio, BigDecimal payqty, BigDecimal pric, BigDecimal acpamtfs, BigDecimal acpamt, BigDecimal preamtfs, BigDecimal preamt, BigDecimal temamtfs, BigDecimal temamt, BigDecimal apamtfs, BigDecimal apamt, String bilno, BigDecimal ivops, BigDecimal ivoms, BigDecimal ivopsfs, BigDecimal ivomsfs) {
        this.apmapdPK = apmapdPK;
        this.ogdkid = ogdkid;
        this.coin = coin;
        this.ratio = ratio;
        this.payqty = payqty;
        this.pric = pric;
        this.acpamtfs = acpamtfs;
        this.acpamt = acpamt;
        this.preamtfs = preamtfs;
        this.preamt = preamt;
        this.temamtfs = temamtfs;
        this.temamt = temamt;
        this.apamtfs = apamtfs;
        this.apamt = apamt;
        this.bilno = bilno;
        this.ivops = ivops;
        this.ivoms = ivoms;
        this.ivopsfs = ivopsfs;
        this.ivomsfs = ivomsfs;
    }

    public Apmapd(String facno, String apno, String aptyp, short trseq) {
        this.apmapdPK = new ApmapdPK(facno, apno, aptyp, trseq);
    }

    public ApmapdPK getApmapdPK() {
        return apmapdPK;
    }

    public void setApmapdPK(ApmapdPK apmapdPK) {
        this.apmapdPK = apmapdPK;
    }

    public String getAcpno() {
        return acpno;
    }

    public void setAcpno(String acpno) {
        this.acpno = acpno;
    }

    public String getSponr() {
        return sponr;
    }

    public void setSponr(String sponr) {
        this.sponr = sponr;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
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

    public BigDecimal getPayqty() {
        return payqty;
    }

    public void setPayqty(BigDecimal payqty) {
        this.payqty = payqty;
    }

    public BigDecimal getPric() {
        return pric;
    }

    public void setPric(BigDecimal pric) {
        this.pric = pric;
    }

    public BigDecimal getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(BigDecimal acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public BigDecimal getAcpamt() {
        return acpamt;
    }

    public void setAcpamt(BigDecimal acpamt) {
        this.acpamt = acpamt;
    }

    public BigDecimal getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(BigDecimal preamtfs) {
        this.preamtfs = preamtfs;
    }

    public BigDecimal getPreamt() {
        return preamt;
    }

    public void setPreamt(BigDecimal preamt) {
        this.preamt = preamt;
    }

    public BigDecimal getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(BigDecimal temamtfs) {
        this.temamtfs = temamtfs;
    }

    public BigDecimal getTemamt() {
        return temamt;
    }

    public void setTemamt(BigDecimal temamt) {
        this.temamt = temamt;
    }

    public BigDecimal getApamtfs() {
        return apamtfs;
    }

    public void setApamtfs(BigDecimal apamtfs) {
        this.apamtfs = apamtfs;
    }

    public BigDecimal getApamt() {
        return apamt;
    }

    public void setApamt(BigDecimal apamt) {
        this.apamt = apamt;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getTrapyh() {
        return trapyh;
    }

    public void setTrapyh(String trapyh) {
        this.trapyh = trapyh;
    }

    public BigDecimal getExpamtfs() {
        return expamtfs;
    }

    public void setExpamtfs(BigDecimal expamtfs) {
        this.expamtfs = expamtfs;
    }

    public BigDecimal getExpamt() {
        return expamt;
    }

    public void setExpamt(BigDecimal expamt) {
        this.expamt = expamt;
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

    public BigDecimal getLosamtfs() {
        return losamtfs;
    }

    public void setLosamtfs(BigDecimal losamtfs) {
        this.losamtfs = losamtfs;
    }

    public BigDecimal getLosamt() {
        return losamt;
    }

    public void setLosamt(BigDecimal losamt) {
        this.losamt = losamt;
    }

    public Character getTax() {
        return tax;
    }

    public void setTax(Character tax) {
        this.tax = tax;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public Apmaph getApmaph() {
        return apmaph;
    }

    public void setApmaph(Apmaph apmaph) {
        this.apmaph = apmaph;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmapdPK != null ? apmapdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmapd)) {
            return false;
        }
        Apmapd other = (Apmapd) object;
        if ((this.apmapdPK == null && other.apmapdPK != null) || (this.apmapdPK != null && !this.apmapdPK.equals(other.apmapdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmapd[ apmapdPK=" + apmapdPK + " ]";
    }

}
