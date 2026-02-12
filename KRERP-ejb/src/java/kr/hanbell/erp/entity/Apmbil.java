/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "apmbil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmbil.findAll", query = "SELECT a FROM Apmbil a"),
    @NamedQuery(name = "Apmbil.findByBilno", query = "SELECT a FROM Apmbil a WHERE a.apmbilPK.bilno = :bilno"),
    @NamedQuery(name = "Apmbil.findByFacno", query = "SELECT a FROM Apmbil a WHERE a.apmbilPK.facno = :facno"),
    @NamedQuery(name = "Apmbil.findByBilstat", query = "SELECT a FROM Apmbil a WHERE a.bilstat = :bilstat"),
    @NamedQuery(name = "Apmbil.findByBilym", query = "SELECT a FROM Apmbil a WHERE a.bilym = :bilym"),
    @NamedQuery(name = "Apmbil.findByBilnum", query = "SELECT a FROM Apmbil a WHERE a.bilnum = :bilnum"),
    @NamedQuery(name = "Apmbil.findByTaxkd", query = "SELECT a FROM Apmbil a WHERE a.taxkd = :taxkd"),
    @NamedQuery(name = "Apmbil.findByApmdat", query = "SELECT a FROM Apmbil a WHERE a.apmdat = :apmdat"),
    @NamedQuery(name = "Apmbil.findByBildat", query = "SELECT a FROM Apmbil a WHERE a.bildat = :bildat"),
    @NamedQuery(name = "Apmbil.findByIvovdr", query = "SELECT a FROM Apmbil a WHERE a.ivovdr = :ivovdr"),
    @NamedQuery(name = "Apmbil.findByVdrno", query = "SELECT a FROM Apmbil a WHERE a.vdrno = :vdrno"),
    @NamedQuery(name = "Apmbil.findByVdrna", query = "SELECT a FROM Apmbil a WHERE a.vdrna = :vdrna"),
    @NamedQuery(name = "Apmbil.findByUniform", query = "SELECT a FROM Apmbil a WHERE a.uniform = :uniform"),
    @NamedQuery(name = "Apmbil.findByBiltyp", query = "SELECT a FROM Apmbil a WHERE a.biltyp = :biltyp"),
    @NamedQuery(name = "Apmbil.findByBilkid", query = "SELECT a FROM Apmbil a WHERE a.bilkid = :bilkid"),
    @NamedQuery(name = "Apmbil.findByUsrno", query = "SELECT a FROM Apmbil a WHERE a.usrno = :usrno"),
    @NamedQuery(name = "Apmbil.findByDepno", query = "SELECT a FROM Apmbil a WHERE a.depno = :depno"),
    @NamedQuery(name = "Apmbil.findByOgdkid", query = "SELECT a FROM Apmbil a WHERE a.ogdkid = :ogdkid"),
    @NamedQuery(name = "Apmbil.findByApmamt", query = "SELECT a FROM Apmbil a WHERE a.apmamt = :apmamt"),
    @NamedQuery(name = "Apmbil.findByBilamtfs", query = "SELECT a FROM Apmbil a WHERE a.bilamtfs = :bilamtfs"),
    @NamedQuery(name = "Apmbil.findByBiltaxfs", query = "SELECT a FROM Apmbil a WHERE a.biltaxfs = :biltaxfs"),
    @NamedQuery(name = "Apmbil.findByAcpamtfs", query = "SELECT a FROM Apmbil a WHERE a.acpamtfs = :acpamtfs"),
    @NamedQuery(name = "Apmbil.findByPreamtfs", query = "SELECT a FROM Apmbil a WHERE a.preamtfs = :preamtfs"),
    @NamedQuery(name = "Apmbil.findByApmamtfs", query = "SELECT a FROM Apmbil a WHERE a.apmamtfs = :apmamtfs"),
    @NamedQuery(name = "Apmbil.findByVouno", query = "SELECT a FROM Apmbil a WHERE a.vouno = :vouno"),
    @NamedQuery(name = "Apmbil.findBySumry", query = "SELECT a FROM Apmbil a WHERE a.sumry = :sumry"),
    @NamedQuery(name = "Apmbil.findByOpbankno", query = "SELECT a FROM Apmbil a WHERE a.opbankno = :opbankno"),
    @NamedQuery(name = "Apmbil.findByOpbankna", query = "SELECT a FROM Apmbil a WHERE a.opbankna = :opbankna"),
    @NamedQuery(name = "Apmbil.findByPK", query = "SELECT a FROM Apmbil a WHERE a.apmbilPK.facno = :facno AND a.apmbilPK.bilno = :bilno")})
public class Apmbil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmbilPK apmbilPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "bilstat")
    private String bilstat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "bilym")
    private String bilym;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "bilnum")
    private String bilnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxkd")
    private Character taxkd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apmdat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bildat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bildat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ivovdr")
    private String ivovdr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 60)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 18)
    @Column(name = "uniform")
    private String uniform;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biltyp")
    private Character biltyp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilkid")
    private Character bilkid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usrno")
    private String usrno;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Size(max = 8)
    @Column(name = "ogdkid")
    private String ogdkid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilorg")
    private Character bilorg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilamt")
    private BigDecimal bilamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biltax")
    private BigDecimal biltax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acpamt")
    private BigDecimal acpamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamt")
    private BigDecimal preamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmamt")
    private BigDecimal apmamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilamtfs")
    private BigDecimal bilamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biltaxfs")
    private BigDecimal biltaxfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acpamtfs")
    private BigDecimal acpamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamtfs")
    private BigDecimal preamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmamtfs")
    private BigDecimal apmamtfs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Column(name = "payda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payda;
    @Column(name = "terda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terda;
    @Column(name = "expamtfs")
    private BigDecimal expamtfs;
    @Column(name = "expamt")
    private BigDecimal expamt;
    @Column(name = "extamtfs")
    private BigDecimal extamtfs;
    @Column(name = "extamt")
    private BigDecimal extamt;
    @Column(name = "yeamtfs")
    private BigDecimal yeamtfs;
    @Column(name = "yeamt")
    private BigDecimal yeamt;
    @Size(max = 12)
    @Column(name = "vouno")
    private String vouno;
    @Size(max = 100)
    @Column(name = "sumry")
    private String sumry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "taxfacno")
    private String taxfacno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamtfs")
    private BigDecimal losamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamt")
    private BigDecimal losamt;
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
    @Size(min = 1, max = 1)
    @Column(name = "fixyn")
    private String fixyn;
    @Size(max = 1)
    @Column(name = "payptn")
    private String payptn;
    @Size(max = 1)
    @Column(name = "fixtyn")
    private String fixtyn;
    @Column(name = "taxbase")
    private BigDecimal taxbase;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 18)
    @Column(name = "bilcategory")
    private String bilcategory;
    @Size(max = 8)
    @Column(name = "opbankno")
    private String opbankno;
    @Size(max = 80)
    @Column(name = "opbankna")
    private String opbankna;
    @Size(max = 25)
    @Column(name = "opbanknum")
    private String opbanknum;

    public Apmbil() {
    }

    public Apmbil(ApmbilPK apmbilPK) {
        this.apmbilPK = apmbilPK;
    }

    public Apmbil(ApmbilPK apmbilPK, String bilstat, String bilym, String bilnum, Character taxkd, Date apmdat, Date bildat, String ivovdr, String vdrno, Character biltyp, Character bilkid, String usrno, Character bilorg, BigDecimal bilamt, BigDecimal biltax, BigDecimal acpamt, BigDecimal preamt, BigDecimal apmamt, BigDecimal bilamtfs, BigDecimal biltaxfs, BigDecimal acpamtfs, BigDecimal preamtfs, BigDecimal apmamtfs, String coin, BigDecimal ratio, String taxfacno, BigDecimal losamtfs, BigDecimal losamt, BigDecimal temamtfs, BigDecimal temamt, String fixyn) {
        this.apmbilPK = apmbilPK;
        this.bilstat = bilstat;
        this.bilym = bilym;
        this.bilnum = bilnum;
        this.taxkd = taxkd;
        this.apmdat = apmdat;
        this.bildat = bildat;
        this.ivovdr = ivovdr;
        this.vdrno = vdrno;
        this.biltyp = biltyp;
        this.bilkid = bilkid;
        this.usrno = usrno;
        this.bilorg = bilorg;
        this.bilamt = bilamt;
        this.biltax = biltax;
        this.acpamt = acpamt;
        this.preamt = preamt;
        this.apmamt = apmamt;
        this.bilamtfs = bilamtfs;
        this.biltaxfs = biltaxfs;
        this.acpamtfs = acpamtfs;
        this.preamtfs = preamtfs;
        this.apmamtfs = apmamtfs;
        this.coin = coin;
        this.ratio = ratio;
        this.taxfacno = taxfacno;
        this.losamtfs = losamtfs;
        this.losamt = losamt;
        this.temamtfs = temamtfs;
        this.temamt = temamt;
        this.fixyn = fixyn;
    }

    public Apmbil(String bilno, String facno) {
        this.apmbilPK = new ApmbilPK(bilno, facno);
    }

    public ApmbilPK getApmbilPK() {
        return apmbilPK;
    }

    public void setApmbilPK(ApmbilPK apmbilPK) {
        this.apmbilPK = apmbilPK;
    }

    public String getBilstat() {
        return bilstat;
    }

    public void setBilstat(String bilstat) {
        this.bilstat = bilstat;
    }

    public String getBilym() {
        return bilym;
    }

    public void setBilym(String bilym) {
        this.bilym = bilym;
    }

    public String getBilnum() {
        return bilnum;
    }

    public void setBilnum(String bilnum) {
        this.bilnum = bilnum;
    }

    public Character getTaxkd() {
        return taxkd;
    }

    public void setTaxkd(Character taxkd) {
        this.taxkd = taxkd;
    }

    public Date getApmdat() {
        return apmdat;
    }

    public void setApmdat(Date apmdat) {
        this.apmdat = apmdat;
    }

    public Date getBildat() {
        return bildat;
    }

    public void setBildat(Date bildat) {
        this.bildat = bildat;
    }

    public String getIvovdr() {
        return ivovdr;
    }

    public void setIvovdr(String ivovdr) {
        this.ivovdr = ivovdr;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public Character getBiltyp() {
        return biltyp;
    }

    public void setBiltyp(Character biltyp) {
        this.biltyp = biltyp;
    }

    public Character getBilkid() {
        return bilkid;
    }

    public void setBilkid(Character bilkid) {
        this.bilkid = bilkid;
    }

    public String getUsrno() {
        return usrno;
    }

    public void setUsrno(String usrno) {
        this.usrno = usrno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
    }

    public Character getBilorg() {
        return bilorg;
    }

    public void setBilorg(Character bilorg) {
        this.bilorg = bilorg;
    }

    public BigDecimal getBilamt() {
        return bilamt;
    }

    public void setBilamt(BigDecimal bilamt) {
        this.bilamt = bilamt;
    }

    public BigDecimal getBiltax() {
        return biltax;
    }

    public void setBiltax(BigDecimal biltax) {
        this.biltax = biltax;
    }

    public BigDecimal getAcpamt() {
        return acpamt;
    }

    public void setAcpamt(BigDecimal acpamt) {
        this.acpamt = acpamt;
    }

    public BigDecimal getPreamt() {
        return preamt;
    }

    public void setPreamt(BigDecimal preamt) {
        this.preamt = preamt;
    }

    public BigDecimal getApmamt() {
        return apmamt;
    }

    public void setApmamt(BigDecimal apmamt) {
        this.apmamt = apmamt;
    }

    public BigDecimal getBilamtfs() {
        return bilamtfs;
    }

    public void setBilamtfs(BigDecimal bilamtfs) {
        this.bilamtfs = bilamtfs;
    }

    public BigDecimal getBiltaxfs() {
        return biltaxfs;
    }

    public void setBiltaxfs(BigDecimal biltaxfs) {
        this.biltaxfs = biltaxfs;
    }

    public BigDecimal getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(BigDecimal acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public BigDecimal getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(BigDecimal preamtfs) {
        this.preamtfs = preamtfs;
    }

    public BigDecimal getApmamtfs() {
        return apmamtfs;
    }

    public void setApmamtfs(BigDecimal apmamtfs) {
        this.apmamtfs = apmamtfs;
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

    public BigDecimal getExtamtfs() {
        return extamtfs;
    }

    public void setExtamtfs(BigDecimal extamtfs) {
        this.extamtfs = extamtfs;
    }

    public BigDecimal getExtamt() {
        return extamt;
    }

    public void setExtamt(BigDecimal extamt) {
        this.extamt = extamt;
    }

    public BigDecimal getYeamtfs() {
        return yeamtfs;
    }

    public void setYeamtfs(BigDecimal yeamtfs) {
        this.yeamtfs = yeamtfs;
    }

    public BigDecimal getYeamt() {
        return yeamt;
    }

    public void setYeamt(BigDecimal yeamt) {
        this.yeamt = yeamt;
    }

    public String getVouno() {
        return vouno;
    }

    public void setVouno(String vouno) {
        this.vouno = vouno;
    }

    public String getSumry() {
        return sumry;
    }

    public void setSumry(String sumry) {
        this.sumry = sumry;
    }

    public String getTaxfacno() {
        return taxfacno;
    }

    public void setTaxfacno(String taxfacno) {
        this.taxfacno = taxfacno;
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

    public String getFixyn() {
        return fixyn;
    }

    public void setFixyn(String fixyn) {
        this.fixyn = fixyn;
    }

    public String getPayptn() {
        return payptn;
    }

    public void setPayptn(String payptn) {
        this.payptn = payptn;
    }

    public String getFixtyn() {
        return fixtyn;
    }

    public void setFixtyn(String fixtyn) {
        this.fixtyn = fixtyn;
    }

    public BigDecimal getTaxbase() {
        return taxbase;
    }

    public void setTaxbase(BigDecimal taxbase) {
        this.taxbase = taxbase;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getBilcategory() {
        return bilcategory;
    }

    public void setBilcategory(String bilcategory) {
        this.bilcategory = bilcategory;
    }

    public String getOpbankno() {
        return opbankno;
    }

    public void setOpbankno(String opbankno) {
        this.opbankno = opbankno;
    }

    public String getOpbankna() {
        return opbankna;
    }

    public void setOpbankna(String opbankna) {
        this.opbankna = opbankna;
    }

    public String getOpbanknum() {
        return opbanknum;
    }

    public void setOpbanknum(String opbanknum) {
        this.opbanknum = opbanknum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmbilPK != null ? apmbilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmbil)) {
            return false;
        }
        Apmbil other = (Apmbil) object;
        if ((this.apmbilPK == null && other.apmbilPK != null) || (this.apmbilPK != null && !this.apmbilPK.equals(other.apmbilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.ejb.Apmbil[ apmbilPK=" + apmbilPK + " ]";
    }

}
