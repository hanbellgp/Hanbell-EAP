/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

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
@Table(name = "apmtbil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmtbil.findAll", query = "SELECT a FROM Apmtbil a"),
    @NamedQuery(name = "Apmtbil.findByFacno", query = "SELECT a FROM Apmtbil a WHERE a.apmtbilPK.facno = :facno"),
    @NamedQuery(name = "Apmtbil.findByBilno", query = "SELECT a FROM Apmtbil a WHERE a.apmtbilPK.bilno = :bilno"),
    @NamedQuery(name = "Apmtbil.findByBilstat", query = "SELECT a FROM Apmtbil a WHERE a.bilstat = :bilstat"),
    @NamedQuery(name = "Apmtbil.findByAcpno", query = "SELECT a FROM Apmtbil a WHERE a.acpno = :acpno"),
    @NamedQuery(name = "Apmtbil.findByBilym", query = "SELECT a FROM Apmtbil a WHERE a.bilym = :bilym"),
    @NamedQuery(name = "Apmtbil.findByBilnum", query = "SELECT a FROM Apmtbil a WHERE a.bilnum = :bilnum"),
    @NamedQuery(name = "Apmtbil.findByTaxkd", query = "SELECT a FROM Apmtbil a WHERE a.taxkd = :taxkd"),
    @NamedQuery(name = "Apmtbil.findByBildat", query = "SELECT a FROM Apmtbil a WHERE a.bildat = :bildat"),
    @NamedQuery(name = "Apmtbil.findByVdrno", query = "SELECT a FROM Apmtbil a WHERE a.vdrno = :vdrno"),
    @NamedQuery(name = "Apmtbil.findByVdrna", query = "SELECT a FROM Apmtbil a WHERE a.vdrna = :vdrna"),
    @NamedQuery(name = "Apmtbil.findByOpbankno", query = "SELECT a FROM Apmtbil a WHERE a.opbankno = :opbankno"),
    @NamedQuery(name = "Apmtbil.findByOpbankna", query = "SELECT a FROM Apmtbil a WHERE a.opbankna = :opbankna"),
    @NamedQuery(name = "Apmtbil.findByPK", query = "SELECT a FROM Apmtbil a WHERE a.apmtbilPK.facno = :facno AND a.apmtbilPK.bilno = :bilno")})
public class Apmtbil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmtbilPK apmtbilPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilstat")
    private Character bilstat;
    @Size(max = 18)
    @Column(name = "acpno")
    private String acpno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "bilym")
    private String bilym;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilnum")
    private Character bilnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxkd")
    private Character taxkd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bildat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bildat;
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
    @Column(name = "bilkid")
    private Character bilkid;
    @Size(max = 8)
    @Column(name = "chgno")
    private String chgno;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
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
    @Column(name = "preamt")
    private BigDecimal preamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temamt")
    private BigDecimal temamt;
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
    @Column(name = "chgamt")
    private BigDecimal chgamt;
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
    @Column(name = "preamtfs")
    private BigDecimal preamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temamtfs")
    private BigDecimal temamtfs;
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
    @Column(name = "chgamtfs")
    private BigDecimal chgamtfs;
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
    @Column(name = "fixyn")
    private Character fixyn;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Column(name = "bilorg")
    private Character bilorg;
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
    @Column(name = "taxbase")
    private BigDecimal taxbase;
    @Column(name = "extamtfs")
    private BigDecimal extamtfs;
    @Column(name = "extamt")
    private BigDecimal extamt;
    @Column(name = "expamtfs")
    private BigDecimal expamtfs;
    @Column(name = "expamt")
    private BigDecimal expamt;

    public Apmtbil() {
    }

    public Apmtbil(ApmtbilPK apmtbilPK) {
        this.apmtbilPK = apmtbilPK;
    }

    public Apmtbil(ApmtbilPK apmtbilPK, Character bilstat, String bilym, Character bilnum, Character taxkd, Date bildat, String vdrno, Character bilkid, BigDecimal bilamt, BigDecimal biltax, BigDecimal preamt, BigDecimal temamt, BigDecimal losamt, BigDecimal cstamt, BigDecimal chgamt, BigDecimal bilamtfs, BigDecimal biltaxfs, BigDecimal preamtfs, BigDecimal temamtfs, BigDecimal losamtfs, BigDecimal cstamtfs, BigDecimal chgamtfs, String coin, BigDecimal ratio, String usrno, Character fixyn) {
        this.apmtbilPK = apmtbilPK;
        this.bilstat = bilstat;
        this.bilym = bilym;
        this.bilnum = bilnum;
        this.taxkd = taxkd;
        this.bildat = bildat;
        this.vdrno = vdrno;
        this.bilkid = bilkid;
        this.bilamt = bilamt;
        this.biltax = biltax;
        this.preamt = preamt;
        this.temamt = temamt;
        this.losamt = losamt;
        this.cstamt = cstamt;
        this.chgamt = chgamt;
        this.bilamtfs = bilamtfs;
        this.biltaxfs = biltaxfs;
        this.preamtfs = preamtfs;
        this.temamtfs = temamtfs;
        this.losamtfs = losamtfs;
        this.cstamtfs = cstamtfs;
        this.chgamtfs = chgamtfs;
        this.coin = coin;
        this.ratio = ratio;
        this.usrno = usrno;
        this.fixyn = fixyn;
    }

    public Apmtbil(String facno, String bilno) {
        this.apmtbilPK = new ApmtbilPK(facno, bilno);
    }

    public ApmtbilPK getApmtbilPK() {
        return apmtbilPK;
    }

    public void setApmtbilPK(ApmtbilPK apmtbilPK) {
        this.apmtbilPK = apmtbilPK;
    }

    public Character getBilstat() {
        return bilstat;
    }

    public void setBilstat(Character bilstat) {
        this.bilstat = bilstat;
    }

    public String getAcpno() {
        return acpno;
    }

    public void setAcpno(String acpno) {
        this.acpno = acpno;
    }

    public String getBilym() {
        return bilym;
    }

    public void setBilym(String bilym) {
        this.bilym = bilym;
    }

    public Character getBilnum() {
        return bilnum;
    }

    public void setBilnum(Character bilnum) {
        this.bilnum = bilnum;
    }

    public Character getTaxkd() {
        return taxkd;
    }

    public void setTaxkd(Character taxkd) {
        this.taxkd = taxkd;
    }

    public Date getBildat() {
        return bildat;
    }

    public void setBildat(Date bildat) {
        this.bildat = bildat;
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

    public Character getBilkid() {
        return bilkid;
    }

    public void setBilkid(Character bilkid) {
        this.bilkid = bilkid;
    }

    public String getChgno() {
        return chgno;
    }

    public void setChgno(String chgno) {
        this.chgno = chgno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
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

    public BigDecimal getPreamt() {
        return preamt;
    }

    public void setPreamt(BigDecimal preamt) {
        this.preamt = preamt;
    }

    public BigDecimal getTemamt() {
        return temamt;
    }

    public void setTemamt(BigDecimal temamt) {
        this.temamt = temamt;
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

    public BigDecimal getChgamt() {
        return chgamt;
    }

    public void setChgamt(BigDecimal chgamt) {
        this.chgamt = chgamt;
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

    public BigDecimal getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(BigDecimal preamtfs) {
        this.preamtfs = preamtfs;
    }

    public BigDecimal getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(BigDecimal temamtfs) {
        this.temamtfs = temamtfs;
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

    public BigDecimal getChgamtfs() {
        return chgamtfs;
    }

    public void setChgamtfs(BigDecimal chgamtfs) {
        this.chgamtfs = chgamtfs;
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

    public Character getFixyn() {
        return fixyn;
    }

    public void setFixyn(Character fixyn) {
        this.fixyn = fixyn;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public Character getBilorg() {
        return bilorg;
    }

    public void setBilorg(Character bilorg) {
        this.bilorg = bilorg;
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

    public BigDecimal getTaxbase() {
        return taxbase;
    }

    public void setTaxbase(BigDecimal taxbase) {
        this.taxbase = taxbase;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmtbilPK != null ? apmtbilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmtbil)) {
            return false;
        }
        Apmtbil other = (Apmtbil) object;
        if ((this.apmtbilPK == null && other.apmtbilPK != null) || (this.apmtbilPK != null && !this.apmtbilPK.equals(other.apmtbilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.Apmtbil[ apmtbilPK=" + apmtbilPK + " ]";
    }

}
