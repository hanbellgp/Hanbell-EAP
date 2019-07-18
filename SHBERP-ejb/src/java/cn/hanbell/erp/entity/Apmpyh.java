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
 * @author Administrator
 */
@Entity
@Table(name = "apmpyh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmpyh.findAll", query = "SELECT a FROM Apmpyh a"),
    @NamedQuery(name = "Apmpyh.findByFacno", query = "SELECT a FROM Apmpyh a WHERE a.apmpyhPK.facno = :facno"),
    @NamedQuery(name = "Apmpyh.findByAcpno", query = "SELECT a FROM Apmpyh a WHERE a.apmpyhPK.acpno = :acpno"),
    @NamedQuery(name = "Apmpyh.findByPyhkind", query = "SELECT a FROM Apmpyh a WHERE a.pyhkind = :pyhkind"),
    @NamedQuery(name = "Apmpyh.findByTrtype", query = "SELECT a FROM Apmpyh a WHERE a.trtype = :trtype"),
    @NamedQuery(name = "Apmpyh.findByItrtype", query = "SELECT a FROM Apmpyh a WHERE a.itrtype = :itrtype"),
    @NamedQuery(name = "Apmpyh.findByTrdat", query = "SELECT a FROM Apmpyh a WHERE a.trdat = :trdat"),
    @NamedQuery(name = "Apmpyh.findByDepno", query = "SELECT a FROM Apmpyh a WHERE a.depno = :depno"),
    @NamedQuery(name = "Apmpyh.findByVdrno", query = "SELECT a FROM Apmpyh a WHERE a.vdrno = :vdrno"),
    @NamedQuery(name = "Apmpyh.findBySponr", query = "SELECT a FROM Apmpyh a WHERE a.sponr = :sponr"),
    @NamedQuery(name = "Apmpyh.findByItnbr", query = "SELECT a FROM Apmpyh a WHERE a.itnbr = :itnbr"),
    @NamedQuery(name = "Apmpyh.findByItdsc", query = "SELECT a FROM Apmpyh a WHERE a.itdsc = :itdsc"),
    @NamedQuery(name = "Apmpyh.findBySpdsc", query = "SELECT a FROM Apmpyh a WHERE a.spdsc = :spdsc"),
    @NamedQuery(name = "Apmpyh.findByPric", query = "SELECT a FROM Apmpyh a WHERE a.pric = :pric"),
    @NamedQuery(name = "Apmpyh.findByPayqty", query = "SELECT a FROM Apmpyh a WHERE a.payqty = :payqty"),
    @NamedQuery(name = "Apmpyh.findByLosamt", query = "SELECT a FROM Apmpyh a WHERE a.losamt = :losamt"),
    @NamedQuery(name = "Apmpyh.findByLosamtfs", query = "SELECT a FROM Apmpyh a WHERE a.losamtfs = :losamtfs"),
    @NamedQuery(name = "Apmpyh.findByTramtfs", query = "SELECT a FROM Apmpyh a WHERE a.tramtfs = :tramtfs"),
    @NamedQuery(name = "Apmpyh.findByTramt", query = "SELECT a FROM Apmpyh a WHERE a.tramt = :tramt"),
    @NamedQuery(name = "Apmpyh.findByPsamtfs", query = "SELECT a FROM Apmpyh a WHERE a.psamtfs = :psamtfs"),
    @NamedQuery(name = "Apmpyh.findByPsamt", query = "SELECT a FROM Apmpyh a WHERE a.psamt = :psamt"),
    @NamedQuery(name = "Apmpyh.findByMsamtfs", query = "SELECT a FROM Apmpyh a WHERE a.msamtfs = :msamtfs"),
    @NamedQuery(name = "Apmpyh.findByMsamt", query = "SELECT a FROM Apmpyh a WHERE a.msamt = :msamt"),
    @NamedQuery(name = "Apmpyh.findByRetamtfs", query = "SELECT a FROM Apmpyh a WHERE a.retamtfs = :retamtfs"),
    @NamedQuery(name = "Apmpyh.findByRetamt", query = "SELECT a FROM Apmpyh a WHERE a.retamt = :retamt"),
    @NamedQuery(name = "Apmpyh.findByActramtfs", query = "SELECT a FROM Apmpyh a WHERE a.actramtfs = :actramtfs"),
    @NamedQuery(name = "Apmpyh.findByActramt", query = "SELECT a FROM Apmpyh a WHERE a.actramt = :actramt"),
    @NamedQuery(name = "Apmpyh.findByAcpamtfs", query = "SELECT a FROM Apmpyh a WHERE a.acpamtfs = :acpamtfs"),
    @NamedQuery(name = "Apmpyh.findByAcpamt", query = "SELECT a FROM Apmpyh a WHERE a.acpamt = :acpamt"),
    @NamedQuery(name = "Apmpyh.findByTaxamtfs", query = "SELECT a FROM Apmpyh a WHERE a.taxamtfs = :taxamtfs"),
    @NamedQuery(name = "Apmpyh.findByTaxamt", query = "SELECT a FROM Apmpyh a WHERE a.taxamt = :taxamt"),
    @NamedQuery(name = "Apmpyh.findByPreamtfs", query = "SELECT a FROM Apmpyh a WHERE a.preamtfs = :preamtfs"),
    @NamedQuery(name = "Apmpyh.findByPreamt", query = "SELECT a FROM Apmpyh a WHERE a.preamt = :preamt"),
    @NamedQuery(name = "Apmpyh.findByIvoamtfs", query = "SELECT a FROM Apmpyh a WHERE a.ivoamtfs = :ivoamtfs"),
    @NamedQuery(name = "Apmpyh.findByIvoamt", query = "SELECT a FROM Apmpyh a WHERE a.ivoamt = :ivoamt"),
    @NamedQuery(name = "Apmpyh.findByIvoprefs", query = "SELECT a FROM Apmpyh a WHERE a.ivoprefs = :ivoprefs"),
    @NamedQuery(name = "Apmpyh.findByIvopre", query = "SELECT a FROM Apmpyh a WHERE a.ivopre = :ivopre"),
    @NamedQuery(name = "Apmpyh.findByAivoamtfs", query = "SELECT a FROM Apmpyh a WHERE a.aivoamtfs = :aivoamtfs"),
    @NamedQuery(name = "Apmpyh.findByAivoamt", query = "SELECT a FROM Apmpyh a WHERE a.aivoamt = :aivoamt"),
    @NamedQuery(name = "Apmpyh.findByIvopsfs", query = "SELECT a FROM Apmpyh a WHERE a.ivopsfs = :ivopsfs"),
    @NamedQuery(name = "Apmpyh.findByIvops", query = "SELECT a FROM Apmpyh a WHERE a.ivops = :ivops"),
    @NamedQuery(name = "Apmpyh.findByIvomsfs", query = "SELECT a FROM Apmpyh a WHERE a.ivomsfs = :ivomsfs"),
    @NamedQuery(name = "Apmpyh.findByIvoms", query = "SELECT a FROM Apmpyh a WHERE a.ivoms = :ivoms"),
    @NamedQuery(name = "Apmpyh.findByCstamtfs", query = "SELECT a FROM Apmpyh a WHERE a.cstamtfs = :cstamtfs"),
    @NamedQuery(name = "Apmpyh.findByCstamt", query = "SELECT a FROM Apmpyh a WHERE a.cstamt = :cstamt"),
    @NamedQuery(name = "Apmpyh.findByUsrno", query = "SELECT a FROM Apmpyh a WHERE a.usrno = :usrno"),
    @NamedQuery(name = "Apmpyh.findByCoin", query = "SELECT a FROM Apmpyh a WHERE a.coin = :coin"),
    @NamedQuery(name = "Apmpyh.findByTax", query = "SELECT a FROM Apmpyh a WHERE a.tax = :tax"),
    @NamedQuery(name = "Apmpyh.findByRatio", query = "SELECT a FROM Apmpyh a WHERE a.ratio = :ratio"),
    @NamedQuery(name = "Apmpyh.findByAcdat", query = "SELECT a FROM Apmpyh a WHERE a.acdat = :acdat"),
    @NamedQuery(name = "Apmpyh.findByDaycnt", query = "SELECT a FROM Apmpyh a WHERE a.daycnt = :daycnt"),
    @NamedQuery(name = "Apmpyh.findByPayptn", query = "SELECT a FROM Apmpyh a WHERE a.payptn = :payptn"),
    @NamedQuery(name = "Apmpyh.findByVpaydate", query = "SELECT a FROM Apmpyh a WHERE a.vpaydate = :vpaydate"),
    @NamedQuery(name = "Apmpyh.findByVterdate", query = "SELECT a FROM Apmpyh a WHERE a.vterdate = :vterdate"),
    @NamedQuery(name = "Apmpyh.findByBilno", query = "SELECT a FROM Apmpyh a WHERE a.bilno = :bilno"),
    @NamedQuery(name = "Apmpyh.findByFixyn", query = "SELECT a FROM Apmpyh a WHERE a.fixyn = :fixyn"),
    @NamedQuery(name = "Apmpyh.findByPono", query = "SELECT a FROM Apmpyh a WHERE a.pono = :pono"),
    @NamedQuery(name = "Apmpyh.findByProno", query = "SELECT a FROM Apmpyh a WHERE a.prono = :prono"),
    @NamedQuery(name = "Apmpyh.findByTaxrate", query = "SELECT a FROM Apmpyh a WHERE a.taxrate = :taxrate"),
    @NamedQuery(name = "Apmpyh.findByExpamt", query = "SELECT a FROM Apmpyh a WHERE a.expamt = :expamt"),
    @NamedQuery(name = "Apmpyh.findByExpamtfs", query = "SELECT a FROM Apmpyh a WHERE a.expamtfs = :expamtfs"),
    @NamedQuery(name = "Apmpyh.findByPyhyn", query = "SELECT a FROM Apmpyh a WHERE a.pyhyn = :pyhyn"),
    @NamedQuery(name = "Apmpyh.findByDmark", query = "SELECT a FROM Apmpyh a WHERE a.dmark = :dmark"),
    @NamedQuery(name = "Apmpyh.findByPK", query = "SELECT a FROM Apmpyh a WHERE a.apmpyhPK.facno = :facno AND a.apmpyhPK.acpno = :acpno")})
public class Apmpyh implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmpyhPK apmpyhPK;
    @Column(name = "pyhkind")
    private Character pyhkind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Size(max = 3)
    @Column(name = "itrtype")
    private String itrtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdat;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 22)
    @Column(name = "sponr")
    private String sponr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 30)
    @Column(name = "spdsc")
    private String spdsc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pric")
    private BigDecimal pric;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payqty")
    private BigDecimal payqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamt")
    private BigDecimal losamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamtfs")
    private BigDecimal losamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tramtfs")
    private BigDecimal tramtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tramt")
    private BigDecimal tramt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psamtfs")
    private BigDecimal psamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psamt")
    private BigDecimal psamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "msamtfs")
    private BigDecimal msamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "msamt")
    private BigDecimal msamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "retamtfs")
    private BigDecimal retamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "retamt")
    private BigDecimal retamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actramtfs")
    private BigDecimal actramtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actramt")
    private BigDecimal actramt;
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
    @Column(name = "taxamtfs")
    private BigDecimal taxamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxamt")
    private BigDecimal taxamt;
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
    @Column(name = "ivoamtfs")
    private BigDecimal ivoamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivoamt")
    private BigDecimal ivoamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivoprefs")
    private BigDecimal ivoprefs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivopre")
    private BigDecimal ivopre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aivoamtfs")
    private BigDecimal aivoamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aivoamt")
    private BigDecimal aivoamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivopsfs")
    private BigDecimal ivopsfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivops")
    private BigDecimal ivops;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivomsfs")
    private BigDecimal ivomsfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivoms")
    private BigDecimal ivoms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cstamtfs")
    private BigDecimal cstamtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cstamt")
    private BigDecimal cstamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usrno")
    private String usrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private Character tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Column(name = "acdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acdat;
    @Column(name = "daycnt")
    private Short daycnt;
    @Column(name = "payptn")
    private Character payptn;
    @Column(name = "vpaydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vpaydate;
    @Column(name = "vterdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vterdate;
    @Size(max = 20)
    @Column(name = "bilno")
    private String bilno;
    @Size(max = 1)
    @Column(name = "fixyn")
    private String fixyn;
    @Size(max = 18)
    @Column(name = "pono")
    private String pono;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Column(name = "expamt")
    private BigDecimal expamt;
    @Column(name = "expamtfs")
    private BigDecimal expamtfs;
    @Size(max = 1)
    @Column(name = "pyhyn")
    private String pyhyn;
    @Size(max = 20)
    @Column(name = "dmark")
    private String dmark;
    @Column(name = "apmqty")
    private BigDecimal apmqty;

    public Apmpyh() {
    }

    public Apmpyh(ApmpyhPK apmpyhPK) {
        this.apmpyhPK = apmpyhPK;
    }

    public Apmpyh(ApmpyhPK apmpyhPK, String trtype, Date trdat, String vdrno, String itnbr, String itdsc, BigDecimal pric, BigDecimal payqty, BigDecimal losamt, BigDecimal losamtfs, BigDecimal tramtfs, BigDecimal tramt, BigDecimal psamtfs, BigDecimal psamt, BigDecimal msamtfs, BigDecimal msamt, BigDecimal retamtfs, BigDecimal retamt, BigDecimal actramtfs, BigDecimal actramt, BigDecimal acpamtfs, BigDecimal acpamt, BigDecimal taxamtfs, BigDecimal taxamt, BigDecimal preamtfs, BigDecimal preamt, BigDecimal ivoamtfs, BigDecimal ivoamt, BigDecimal ivoprefs, BigDecimal ivopre, BigDecimal aivoamtfs, BigDecimal aivoamt, BigDecimal ivopsfs, BigDecimal ivops, BigDecimal ivomsfs, BigDecimal ivoms, BigDecimal cstamtfs, BigDecimal cstamt, String usrno, String coin, Character tax, BigDecimal ratio) {
        this.apmpyhPK = apmpyhPK;
        this.trtype = trtype;
        this.trdat = trdat;
        this.vdrno = vdrno;
        this.itnbr = itnbr;
        this.itdsc = itdsc;
        this.pric = pric;
        this.payqty = payqty;
        this.losamt = losamt;
        this.losamtfs = losamtfs;
        this.tramtfs = tramtfs;
        this.tramt = tramt;
        this.psamtfs = psamtfs;
        this.psamt = psamt;
        this.msamtfs = msamtfs;
        this.msamt = msamt;
        this.retamtfs = retamtfs;
        this.retamt = retamt;
        this.actramtfs = actramtfs;
        this.actramt = actramt;
        this.acpamtfs = acpamtfs;
        this.acpamt = acpamt;
        this.taxamtfs = taxamtfs;
        this.taxamt = taxamt;
        this.preamtfs = preamtfs;
        this.preamt = preamt;
        this.ivoamtfs = ivoamtfs;
        this.ivoamt = ivoamt;
        this.ivoprefs = ivoprefs;
        this.ivopre = ivopre;
        this.aivoamtfs = aivoamtfs;
        this.aivoamt = aivoamt;
        this.ivopsfs = ivopsfs;
        this.ivops = ivops;
        this.ivomsfs = ivomsfs;
        this.ivoms = ivoms;
        this.cstamtfs = cstamtfs;
        this.cstamt = cstamt;
        this.usrno = usrno;
        this.coin = coin;
        this.tax = tax;
        this.ratio = ratio;
    }

    public Apmpyh(String facno, String acpno) {
        this.apmpyhPK = new ApmpyhPK(facno, acpno);
    }

    public ApmpyhPK getApmpyhPK() {
        return apmpyhPK;
    }

    public void setApmpyhPK(ApmpyhPK apmpyhPK) {
        this.apmpyhPK = apmpyhPK;
    }

    public Character getPyhkind() {
        return pyhkind;
    }

    public void setPyhkind(Character pyhkind) {
        this.pyhkind = pyhkind;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getItrtype() {
        return itrtype;
    }

    public void setItrtype(String itrtype) {
        this.itrtype = itrtype;
    }

    public Date getTrdat() {
        return trdat;
    }

    public void setTrdat(Date trdat) {
        this.trdat = trdat;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public BigDecimal getPric() {
        return pric;
    }

    public void setPric(BigDecimal pric) {
        this.pric = pric;
    }

    public BigDecimal getPayqty() {
        return payqty;
    }

    public void setPayqty(BigDecimal payqty) {
        this.payqty = payqty;
    }

    public BigDecimal getLosamt() {
        return losamt;
    }

    public void setLosamt(BigDecimal losamt) {
        this.losamt = losamt;
    }

    public BigDecimal getLosamtfs() {
        return losamtfs;
    }

    public void setLosamtfs(BigDecimal losamtfs) {
        this.losamtfs = losamtfs;
    }

    public BigDecimal getTramtfs() {
        return tramtfs;
    }

    public void setTramtfs(BigDecimal tramtfs) {
        this.tramtfs = tramtfs;
    }

    public BigDecimal getTramt() {
        return tramt;
    }

    public void setTramt(BigDecimal tramt) {
        this.tramt = tramt;
    }

    public BigDecimal getPsamtfs() {
        return psamtfs;
    }

    public void setPsamtfs(BigDecimal psamtfs) {
        this.psamtfs = psamtfs;
    }

    public BigDecimal getPsamt() {
        return psamt;
    }

    public void setPsamt(BigDecimal psamt) {
        this.psamt = psamt;
    }

    public BigDecimal getMsamtfs() {
        return msamtfs;
    }

    public void setMsamtfs(BigDecimal msamtfs) {
        this.msamtfs = msamtfs;
    }

    public BigDecimal getMsamt() {
        return msamt;
    }

    public void setMsamt(BigDecimal msamt) {
        this.msamt = msamt;
    }

    public BigDecimal getRetamtfs() {
        return retamtfs;
    }

    public void setRetamtfs(BigDecimal retamtfs) {
        this.retamtfs = retamtfs;
    }

    public BigDecimal getRetamt() {
        return retamt;
    }

    public void setRetamt(BigDecimal retamt) {
        this.retamt = retamt;
    }

    public BigDecimal getActramtfs() {
        return actramtfs;
    }

    public void setActramtfs(BigDecimal actramtfs) {
        this.actramtfs = actramtfs;
    }

    public BigDecimal getActramt() {
        return actramt;
    }

    public void setActramt(BigDecimal actramt) {
        this.actramt = actramt;
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

    public BigDecimal getTaxamtfs() {
        return taxamtfs;
    }

    public void setTaxamtfs(BigDecimal taxamtfs) {
        this.taxamtfs = taxamtfs;
    }

    public BigDecimal getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigDecimal taxamt) {
        this.taxamt = taxamt;
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

    public BigDecimal getIvoamtfs() {
        return ivoamtfs;
    }

    public void setIvoamtfs(BigDecimal ivoamtfs) {
        this.ivoamtfs = ivoamtfs;
    }

    public BigDecimal getIvoamt() {
        return ivoamt;
    }

    public void setIvoamt(BigDecimal ivoamt) {
        this.ivoamt = ivoamt;
    }

    public BigDecimal getIvoprefs() {
        return ivoprefs;
    }

    public void setIvoprefs(BigDecimal ivoprefs) {
        this.ivoprefs = ivoprefs;
    }

    public BigDecimal getIvopre() {
        return ivopre;
    }

    public void setIvopre(BigDecimal ivopre) {
        this.ivopre = ivopre;
    }

    public BigDecimal getAivoamtfs() {
        return aivoamtfs;
    }

    public void setAivoamtfs(BigDecimal aivoamtfs) {
        this.aivoamtfs = aivoamtfs;
    }

    public BigDecimal getAivoamt() {
        return aivoamt;
    }

    public void setAivoamt(BigDecimal aivoamt) {
        this.aivoamt = aivoamt;
    }

    public BigDecimal getIvopsfs() {
        return ivopsfs;
    }

    public void setIvopsfs(BigDecimal ivopsfs) {
        this.ivopsfs = ivopsfs;
    }

    public BigDecimal getIvops() {
        return ivops;
    }

    public void setIvops(BigDecimal ivops) {
        this.ivops = ivops;
    }

    public BigDecimal getIvomsfs() {
        return ivomsfs;
    }

    public void setIvomsfs(BigDecimal ivomsfs) {
        this.ivomsfs = ivomsfs;
    }

    public BigDecimal getIvoms() {
        return ivoms;
    }

    public void setIvoms(BigDecimal ivoms) {
        this.ivoms = ivoms;
    }

    public BigDecimal getCstamtfs() {
        return cstamtfs;
    }

    public void setCstamtfs(BigDecimal cstamtfs) {
        this.cstamtfs = cstamtfs;
    }

    public BigDecimal getCstamt() {
        return cstamt;
    }

    public void setCstamt(BigDecimal cstamt) {
        this.cstamt = cstamt;
    }

    public String getUsrno() {
        return usrno;
    }

    public void setUsrno(String usrno) {
        this.usrno = usrno;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Character getTax() {
        return tax;
    }

    public void setTax(Character tax) {
        this.tax = tax;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public Date getAcdat() {
        return acdat;
    }

    public void setAcdat(Date acdat) {
        this.acdat = acdat;
    }

    public Short getDaycnt() {
        return daycnt;
    }

    public void setDaycnt(Short daycnt) {
        this.daycnt = daycnt;
    }

    public Character getPayptn() {
        return payptn;
    }

    public void setPayptn(Character payptn) {
        this.payptn = payptn;
    }

    public Date getVpaydate() {
        return vpaydate;
    }

    public void setVpaydate(Date vpaydate) {
        this.vpaydate = vpaydate;
    }

    public Date getVterdate() {
        return vterdate;
    }

    public void setVterdate(Date vterdate) {
        this.vterdate = vterdate;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getFixyn() {
        return fixyn;
    }

    public void setFixyn(String fixyn) {
        this.fixyn = fixyn;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getExpamt() {
        return expamt;
    }

    public void setExpamt(BigDecimal expamt) {
        this.expamt = expamt;
    }

    public BigDecimal getExpamtfs() {
        return expamtfs;
    }

    public void setExpamtfs(BigDecimal expamtfs) {
        this.expamtfs = expamtfs;
    }

    public String getPyhyn() {
        return pyhyn;
    }

    public void setPyhyn(String pyhyn) {
        this.pyhyn = pyhyn;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
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
        hash += (apmpyhPK != null ? apmpyhPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmpyh)) {
            return false;
        }
        Apmpyh other = (Apmpyh) object;
        if ((this.apmpyhPK == null && other.apmpyhPK != null) || (this.apmpyhPK != null && !this.apmpyhPK.equals(other.apmpyhPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmpyh[ apmpyhPK=" + apmpyhPK + " ]";
    }
    
}
