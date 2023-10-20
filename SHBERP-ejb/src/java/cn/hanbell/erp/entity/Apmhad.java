/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "apmhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmhad.findAll", query = "SELECT a FROM Apmhad a"),
    @NamedQuery(name = "Apmhad.findByFacno", query = "SELECT a FROM Apmhad a WHERE a.apmhadPK.facno = :facno"),
    @NamedQuery(name = "Apmhad.findByTrno", query = "SELECT a FROM Apmhad a WHERE a.apmhadPK.trno = :trno"),
    @NamedQuery(name = "Apmhad.findByVdrno", query = "SELECT a FROM Apmhad a WHERE a.apmhadPK.vdrno = :vdrno"),
    @NamedQuery(name = "Apmhad.findByAccno", query = "SELECT a FROM Apmhad a WHERE a.apmhadPK.accno = :accno"),
    @NamedQuery(name = "Apmhad.findByDetno", query = "SELECT a FROM Apmhad a WHERE a.apmhadPK.detno = :detno"),
    @NamedQuery(name = "Apmhad.findByDepno", query = "SELECT a FROM Apmhad a WHERE a.depno = :depno"),
    @NamedQuery(name = "Apmhad.findByVdrna", query = "SELECT a FROM Apmhad a WHERE a.vdrna = :vdrna"),
    @NamedQuery(name = "Apmhad.findByApmdat", query = "SELECT a FROM Apmhad a WHERE a.apmdat = :apmdat"),
    @NamedQuery(name = "Apmhad.findByUsrno", query = "SELECT a FROM Apmhad a WHERE a.usrno = :usrno"),
    @NamedQuery(name = "Apmhad.findByCode", query = "SELECT a FROM Apmhad a WHERE a.code = :code"),
    @NamedQuery(name = "Apmhad.findByPayda", query = "SELECT a FROM Apmhad a WHERE a.payda = :payda"),
    @NamedQuery(name = "Apmhad.findByVouno", query = "SELECT a FROM Apmhad a WHERE a.vouno = :vouno"),
    @NamedQuery(name = "Apmhad.findByVdrnoAndTrno", query = "SELECT a FROM Apmhad a WHERE a.apmhadPK.facno = :facno AND a.apmhadPK.vdrno = :vdrno AND a.apmhadPK.trno = :trno "
            + "AND ( a.config in (32,33) )")})
public class Apmhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmhadPK apmhadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "config")
    private short config;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Size(max = 30)
    @Column(name = "vdrna")
    private String vdrna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apmdat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "thamt")
    private BigDecimal thamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thtax")
    private BigDecimal thtax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamt")
    private BigDecimal preamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acpamt")
    private BigDecimal acpamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thamtfs")
    private BigDecimal thamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thtaxfs")
    private BigDecimal thtaxfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamtfs")
    private BigDecimal preamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acpamtfs")
    private BigDecimal acpamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmamt")
    private BigDecimal apmamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payamt")
    private BigDecimal payamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmamtfs")
    private BigDecimal apmamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payamtfs")
    private BigDecimal payamtfs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usrno")
    private String usrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yeamt")
    private BigDecimal yeamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alamt")
    private BigDecimal alamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yeamtfs")
    private BigDecimal yeamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alamtfs")
    private BigDecimal alamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aplpreamt")
    private BigDecimal aplpreamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "raplpreamt")
    private BigDecimal raplpreamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aplpreamtfs")
    private BigDecimal aplpreamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "raplpreamtfs")
    private BigDecimal raplpreamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private Character code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Column(name = "payda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payda;
    @Size(max = 12)
    @Column(name = "vouno")
    private String vouno;
    @Column(name = "vouseq")
    private Short vouseq;
    @Size(max = 50)
    @Column(name = "sumry")
    private String sumry;
    @Column(name = "terda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yorn")
    private Character yorn;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 1)
    @Column(name = "payptn")
    private String payptn;
    @Column(name = "oldratio")
    private BigDecimal oldratio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apmhad")
    private List<Apmchp> apmchpList;

    public Apmhad() {
    }

    public Apmhad(ApmhadPK apmhadPK) {
        this.apmhadPK = apmhadPK;
    }

    public Apmhad(ApmhadPK apmhadPK, short config, Date apmdat, BigDecimal thamt, BigDecimal thtax, BigDecimal preamt, BigDecimal acpamt, BigDecimal thamtfs, BigDecimal thtaxfs, BigDecimal preamtfs, BigDecimal acpamtfs, BigDecimal ratio, BigDecimal apmamt, BigDecimal payamt, BigDecimal apmamtfs, BigDecimal payamtfs, String usrno, BigDecimal yeamt, BigDecimal alamt, BigDecimal yeamtfs, BigDecimal alamtfs, BigDecimal aplpreamt, BigDecimal raplpreamt, BigDecimal aplpreamtfs, BigDecimal raplpreamtfs, Character code, String coin, Character yorn) {
        this.apmhadPK = apmhadPK;
        this.config = config;
        this.apmdat = apmdat;
        this.thamt = thamt;
        this.thtax = thtax;
        this.preamt = preamt;
        this.acpamt = acpamt;
        this.thamtfs = thamtfs;
        this.thtaxfs = thtaxfs;
        this.preamtfs = preamtfs;
        this.acpamtfs = acpamtfs;
        this.ratio = ratio;
        this.apmamt = apmamt;
        this.payamt = payamt;
        this.apmamtfs = apmamtfs;
        this.payamtfs = payamtfs;
        this.usrno = usrno;
        this.yeamt = yeamt;
        this.alamt = alamt;
        this.yeamtfs = yeamtfs;
        this.alamtfs = alamtfs;
        this.aplpreamt = aplpreamt;
        this.raplpreamt = raplpreamt;
        this.aplpreamtfs = aplpreamtfs;
        this.raplpreamtfs = raplpreamtfs;
        this.code = code;
        this.coin = coin;
        this.yorn = yorn;
    }

    public Apmhad(String facno, String trno, String vdrno, String accno, String detno) {
        this.apmhadPK = new ApmhadPK(facno, trno, vdrno, accno, detno);
    }

    public ApmhadPK getApmhadPK() {
        return apmhadPK;
    }

    public void setApmhadPK(ApmhadPK apmhadPK) {
        this.apmhadPK = apmhadPK;
    }

    public short getConfig() {
        return config;
    }

    public void setConfig(short config) {
        this.config = config;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public Date getApmdat() {
        return apmdat;
    }

    public void setApmdat(Date apmdat) {
        this.apmdat = apmdat;
    }

    public BigDecimal getThamt() {
        return thamt;
    }

    public void setThamt(BigDecimal thamt) {
        this.thamt = thamt;
    }

    public BigDecimal getThtax() {
        return thtax;
    }

    public void setThtax(BigDecimal thtax) {
        this.thtax = thtax;
    }

    public BigDecimal getPreamt() {
        return preamt;
    }

    public void setPreamt(BigDecimal preamt) {
        this.preamt = preamt;
    }

    public BigDecimal getAcpamt() {
        return acpamt;
    }

    public void setAcpamt(BigDecimal acpamt) {
        this.acpamt = acpamt;
    }

    public BigDecimal getThamtfs() {
        return thamtfs;
    }

    public void setThamtfs(BigDecimal thamtfs) {
        this.thamtfs = thamtfs;
    }

    public BigDecimal getThtaxfs() {
        return thtaxfs;
    }

    public void setThtaxfs(BigDecimal thtaxfs) {
        this.thtaxfs = thtaxfs;
    }

    public BigDecimal getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(BigDecimal preamtfs) {
        this.preamtfs = preamtfs;
    }

    public BigDecimal getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(BigDecimal acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public BigDecimal getApmamt() {
        return apmamt;
    }

    public void setApmamt(BigDecimal apmamt) {
        this.apmamt = apmamt;
    }

    public BigDecimal getPayamt() {
        return payamt;
    }

    public void setPayamt(BigDecimal payamt) {
        this.payamt = payamt;
    }

    public BigDecimal getApmamtfs() {
        return apmamtfs;
    }

    public void setApmamtfs(BigDecimal apmamtfs) {
        this.apmamtfs = apmamtfs;
    }

    public BigDecimal getPayamtfs() {
        return payamtfs;
    }

    public void setPayamtfs(BigDecimal payamtfs) {
        this.payamtfs = payamtfs;
    }

    public String getUsrno() {
        return usrno;
    }

    public void setUsrno(String usrno) {
        this.usrno = usrno;
    }

    public BigDecimal getYeamt() {
        return yeamt;
    }

    public void setYeamt(BigDecimal yeamt) {
        this.yeamt = yeamt;
    }

    public BigDecimal getAlamt() {
        return alamt;
    }

    public void setAlamt(BigDecimal alamt) {
        this.alamt = alamt;
    }

    public BigDecimal getYeamtfs() {
        return yeamtfs;
    }

    public void setYeamtfs(BigDecimal yeamtfs) {
        this.yeamtfs = yeamtfs;
    }

    public BigDecimal getAlamtfs() {
        return alamtfs;
    }

    public void setAlamtfs(BigDecimal alamtfs) {
        this.alamtfs = alamtfs;
    }

    public BigDecimal getAplpreamt() {
        return aplpreamt;
    }

    public void setAplpreamt(BigDecimal aplpreamt) {
        this.aplpreamt = aplpreamt;
    }

    public BigDecimal getRaplpreamt() {
        return raplpreamt;
    }

    public void setRaplpreamt(BigDecimal raplpreamt) {
        this.raplpreamt = raplpreamt;
    }

    public BigDecimal getAplpreamtfs() {
        return aplpreamtfs;
    }

    public void setAplpreamtfs(BigDecimal aplpreamtfs) {
        this.aplpreamtfs = aplpreamtfs;
    }

    public BigDecimal getRaplpreamtfs() {
        return raplpreamtfs;
    }

    public void setRaplpreamtfs(BigDecimal raplpreamtfs) {
        this.raplpreamtfs = raplpreamtfs;
    }

    public Character getCode() {
        return code;
    }

    public void setCode(Character code) {
        this.code = code;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Date getPayda() {
        return payda;
    }

    public void setPayda(Date payda) {
        this.payda = payda;
    }

    public String getVouno() {
        return vouno;
    }

    public void setVouno(String vouno) {
        this.vouno = vouno;
    }

    public Short getVouseq() {
        return vouseq;
    }

    public void setVouseq(Short vouseq) {
        this.vouseq = vouseq;
    }

    public String getSumry() {
        return sumry;
    }

    public void setSumry(String sumry) {
        this.sumry = sumry;
    }

    public Date getTerda() {
        return terda;
    }

    public void setTerda(Date terda) {
        this.terda = terda;
    }

    public Character getYorn() {
        return yorn;
    }

    public void setYorn(Character yorn) {
        this.yorn = yorn;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getPayptn() {
        return payptn;
    }

    public void setPayptn(String payptn) {
        this.payptn = payptn;
    }

    public BigDecimal getOldratio() {
        return oldratio;
    }

    public void setOldratio(BigDecimal oldratio) {
        this.oldratio = oldratio;
    }

    @XmlTransient
    public List<Apmchp> getApmchpList() {
        return apmchpList;
    }

    public void setApmchpList(List<Apmchp> apmchpList) {
        this.apmchpList = apmchpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmhadPK != null ? apmhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmhad)) {
            return false;
        }
        Apmhad other = (Apmhad) object;
        if ((this.apmhadPK == null && other.apmhadPK != null) || (this.apmhadPK != null && !this.apmhadPK.equals(other.apmhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmhad[ apmhadPK=" + apmhadPK + " ]";
    }

}
