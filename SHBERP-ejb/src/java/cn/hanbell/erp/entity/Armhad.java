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
@Table(name = "armhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armhad.findAll", query = "SELECT a FROM Armhad a"),
    @NamedQuery(name = "Armhad.findByCusnoDefault", query = "SELECT a FROM Armhad a WHERE a.armhadPK.cusno = :cusno AND (a.booamts - a.recamts <> 0) "),
    @NamedQuery(name = "Armhad.findByCusnoClosed", query = "SELECT a FROM Armhad a WHERE a.armhadPK.cusno = :cusno AND (a.booamts - a.recamts = 0) "),
    @NamedQuery(name = "Armhad.findByCusnoAll", query = "SELECT a FROM Armhad a WHERE a.armhadPK.cusno = :cusno"),
    @NamedQuery(name = "Armhad.findByAccno", query = "SELECT a FROM Armhad a WHERE a.armhadPK.accno = :accno"),
    @NamedQuery(name = "Armhad.findByDetno", query = "SELECT a FROM Armhad a WHERE a.armhadPK.detno = :detno"),
    @NamedQuery(name = "Armhad.findByBildat", query = "SELECT a FROM Armhad a WHERE a.bildat = :bildat"),
    @NamedQuery(name = "Armhad.findByDepno", query = "SELECT a FROM Armhad a WHERE a.depno = :depno"),
    @NamedQuery(name = "Armhad.findByMancode", query = "SELECT a FROM Armhad a WHERE a.mancode = :mancode")})
public class Armhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArmhadPK armhadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "config")
    private short config;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bildat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bildat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "booamts")
    private BigDecimal booamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btaxamts")
    private BigDecimal btaxamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recamts")
    private BigDecimal recamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "booamt")
    private BigDecimal booamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btaxamt")
    private BigDecimal btaxamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recamt")
    private BigDecimal recamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratin")
    private BigDecimal ratin;
    @Column(name = "warngdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date warngdate;
    @Column(name = "shlddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shlddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "difcod")
    private Character difcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "vouno")
    private String vouno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vouseq")
    private short vouseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ltrndate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ltrndate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ltrnusrid")
    private String ltrnusrid;
    @Size(max = 8)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 50)
    @Column(name = "delaydsc")
    private String delaydsc;
    @Size(max = 50)
    @Column(name = "errordsc")
    private String errordsc;
    @Size(max = 6)
    @Column(name = "yymm")
    private String yymm;
    @Size(max = 18)
    @Column(name = "relno")
    private String relno;
    @Column(name = "relseq")
    private Short relseq;
    @Column(name = "oldratio")
    private BigDecimal oldratio;
    @Column(name = "obooamt")
    private BigDecimal obooamt;
    @Column(name = "oratin")
    private BigDecimal oratin;
    @Column(name = "holamts")
    private BigDecimal holamts;
    @Column(name = "holamt")
    private BigDecimal holamt;

    public Armhad() {
    }

    public Armhad(ArmhadPK armhadPK) {
        this.armhadPK = armhadPK;
    }

    public Armhad(ArmhadPK armhadPK, short config, Date bildat, String depno, BigDecimal booamts, BigDecimal btaxamts, BigDecimal recamts, BigDecimal booamt, BigDecimal btaxamt, BigDecimal recamt, String coin, BigDecimal ratin, Character difcod, String vouno, short vouseq, Date ltrndate, String ltrnusrid) {
        this.armhadPK = armhadPK;
        this.config = config;
        this.bildat = bildat;
        this.depno = depno;
        this.booamts = booamts;
        this.btaxamts = btaxamts;
        this.recamts = recamts;
        this.booamt = booamt;
        this.btaxamt = btaxamt;
        this.recamt = recamt;
        this.coin = coin;
        this.ratin = ratin;
        this.difcod = difcod;
        this.vouno = vouno;
        this.vouseq = vouseq;
        this.ltrndate = ltrndate;
        this.ltrnusrid = ltrnusrid;
    }

    public Armhad(String facno, String cusno, String hadno, short hadseq, String accno, String detno, short hseq) {
        this.armhadPK = new ArmhadPK(facno, cusno, hadno, hadseq, accno, detno, hseq);
    }

    public ArmhadPK getArmhadPK() {
        return armhadPK;
    }

    public void setArmhadPK(ArmhadPK armhadPK) {
        this.armhadPK = armhadPK;
    }

    public short getConfig() {
        return config;
    }

    public void setConfig(short config) {
        this.config = config;
    }

    public Date getBildat() {
        return bildat;
    }

    public void setBildat(Date bildat) {
        this.bildat = bildat;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public BigDecimal getBooamts() {
        return booamts;
    }

    public void setBooamts(BigDecimal booamts) {
        this.booamts = booamts;
    }

    public BigDecimal getBtaxamts() {
        return btaxamts;
    }

    public void setBtaxamts(BigDecimal btaxamts) {
        this.btaxamts = btaxamts;
    }

    public BigDecimal getRecamts() {
        return recamts;
    }

    public void setRecamts(BigDecimal recamts) {
        this.recamts = recamts;
    }

    public BigDecimal getBooamt() {
        return booamt;
    }

    public void setBooamt(BigDecimal booamt) {
        this.booamt = booamt;
    }

    public BigDecimal getBtaxamt() {
        return btaxamt;
    }

    public void setBtaxamt(BigDecimal btaxamt) {
        this.btaxamt = btaxamt;
    }

    public BigDecimal getRecamt() {
        return recamt;
    }

    public void setRecamt(BigDecimal recamt) {
        this.recamt = recamt;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getRatin() {
        return ratin;
    }

    public void setRatin(BigDecimal ratin) {
        this.ratin = ratin;
    }

    public Date getWarngdate() {
        return warngdate;
    }

    public void setWarngdate(Date warngdate) {
        this.warngdate = warngdate;
    }

    public Date getShlddate() {
        return shlddate;
    }

    public void setShlddate(Date shlddate) {
        this.shlddate = shlddate;
    }

    public Character getDifcod() {
        return difcod;
    }

    public void setDifcod(Character difcod) {
        this.difcod = difcod;
    }

    public String getVouno() {
        return vouno;
    }

    public void setVouno(String vouno) {
        this.vouno = vouno;
    }

    public short getVouseq() {
        return vouseq;
    }

    public void setVouseq(short vouseq) {
        this.vouseq = vouseq;
    }

    public Date getLtrndate() {
        return ltrndate;
    }

    public void setLtrndate(Date ltrndate) {
        this.ltrndate = ltrndate;
    }

    public String getLtrnusrid() {
        return ltrnusrid;
    }

    public void setLtrnusrid(String ltrnusrid) {
        this.ltrnusrid = ltrnusrid;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getDelaydsc() {
        return delaydsc;
    }

    public void setDelaydsc(String delaydsc) {
        this.delaydsc = delaydsc;
    }

    public String getErrordsc() {
        return errordsc;
    }

    public void setErrordsc(String errordsc) {
        this.errordsc = errordsc;
    }

    public String getYymm() {
        return yymm;
    }

    public void setYymm(String yymm) {
        this.yymm = yymm;
    }

    public String getRelno() {
        return relno;
    }

    public void setRelno(String relno) {
        this.relno = relno;
    }

    public Short getRelseq() {
        return relseq;
    }

    public void setRelseq(Short relseq) {
        this.relseq = relseq;
    }

    public BigDecimal getOldratio() {
        return oldratio;
    }

    public void setOldratio(BigDecimal oldratio) {
        this.oldratio = oldratio;
    }

    public BigDecimal getObooamt() {
        return obooamt;
    }

    public void setObooamt(BigDecimal obooamt) {
        this.obooamt = obooamt;
    }

    public BigDecimal getOratin() {
        return oratin;
    }

    public void setOratin(BigDecimal oratin) {
        this.oratin = oratin;
    }

    public BigDecimal getHolamts() {
        return holamts;
    }

    public void setHolamts(BigDecimal holamts) {
        this.holamts = holamts;
    }

    public BigDecimal getHolamt() {
        return holamt;
    }

    public void setHolamt(BigDecimal holamt) {
        this.holamt = holamt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (armhadPK != null ? armhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armhad)) {
            return false;
        }
        Armhad other = (Armhad) object;
        if ((this.armhadPK == null && other.armhadPK != null) || (this.armhadPK != null && !this.armhadPK.equals(other.armhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.Armhad[ armhadPK=" + armhadPK + " ]";
    }

}
