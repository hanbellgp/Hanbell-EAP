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
@Table(name = "cdrbhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrbhad.findAll", query = "SELECT c FROM Cdrbhad c"),
    @NamedQuery(name = "Cdrbhad.findByFacno", query = "SELECT c FROM Cdrbhad c WHERE c.cdrbhadPK.facno = :facno"),
    @NamedQuery(name = "Cdrbhad.findByBakno", query = "SELECT c FROM Cdrbhad c WHERE c.cdrbhadPK.bakno = :bakno"),
    @NamedQuery(name = "Cdrbhad.findByBakdate", query = "SELECT c FROM Cdrbhad c WHERE c.bakdate = :bakdate"),
    @NamedQuery(name = "Cdrbhad.findByTrtype", query = "SELECT c FROM Cdrbhad c WHERE c.trtype = :trtype"),
    @NamedQuery(name = "Cdrbhad.findByDepno", query = "SELECT c FROM Cdrbhad c WHERE c.depno = :depno"),
    @NamedQuery(name = "Cdrbhad.findByDecode", query = "SELECT c FROM Cdrbhad c WHERE c.decode = :decode"),
    @NamedQuery(name = "Cdrbhad.findByCusno", query = "SELECT c FROM Cdrbhad c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "Cdrbhad.findByShptrseq", query = "SELECT c FROM Cdrbhad c WHERE c.shptrseq = :shptrseq"),
    @NamedQuery(name = "Cdrbhad.findByIvotrseq", query = "SELECT c FROM Cdrbhad c WHERE c.ivotrseq = :ivotrseq"),
    @NamedQuery(name = "Cdrbhad.findByBaksta", query = "SELECT c FROM Cdrbhad c WHERE c.baksta = :baksta"),
    @NamedQuery(name = "Cdrbhad.findByTax", query = "SELECT c FROM Cdrbhad c WHERE c.tax = :tax"),
    @NamedQuery(name = "Cdrbhad.findByTaxrate", query = "SELECT c FROM Cdrbhad c WHERE c.taxrate = :taxrate"),
    @NamedQuery(name = "Cdrbhad.findByCoin", query = "SELECT c FROM Cdrbhad c WHERE c.coin = :coin"),
    @NamedQuery(name = "Cdrbhad.findByRatio", query = "SELECT c FROM Cdrbhad c WHERE c.ratio = :ratio"),
    @NamedQuery(name = "Cdrbhad.findByBakamts", query = "SELECT c FROM Cdrbhad c WHERE c.bakamts = :bakamts"),
    @NamedQuery(name = "Cdrbhad.findByTaxamts", query = "SELECT c FROM Cdrbhad c WHERE c.taxamts = :taxamts"),
    @NamedQuery(name = "Cdrbhad.findByTotamts", query = "SELECT c FROM Cdrbhad c WHERE c.totamts = :totamts"),
    @NamedQuery(name = "Cdrbhad.findBySndcode", query = "SELECT c FROM Cdrbhad c WHERE c.sndcode = :sndcode"),
    @NamedQuery(name = "Cdrbhad.findByPaycode", query = "SELECT c FROM Cdrbhad c WHERE c.paycode = :paycode"),
    @NamedQuery(name = "Cdrbhad.findByTermcode", query = "SELECT c FROM Cdrbhad c WHERE c.termcode = :termcode"),
    @NamedQuery(name = "Cdrbhad.findBySacode", query = "SELECT c FROM Cdrbhad c WHERE c.sacode = :sacode"),
    @NamedQuery(name = "Cdrbhad.findByAreacode", query = "SELECT c FROM Cdrbhad c WHERE c.areacode = :areacode"),
    @NamedQuery(name = "Cdrbhad.findByCuycode", query = "SELECT c FROM Cdrbhad c WHERE c.cuycode = :cuycode"),
    @NamedQuery(name = "Cdrbhad.findByMancode", query = "SELECT c FROM Cdrbhad c WHERE c.mancode = :mancode"),
    @NamedQuery(name = "Cdrbhad.findByAddamts", query = "SELECT c FROM Cdrbhad c WHERE c.addamts = :addamts"),
    @NamedQuery(name = "Cdrbhad.findBySubamts", query = "SELECT c FROM Cdrbhad c WHERE c.subamts = :subamts"),
    @NamedQuery(name = "Cdrbhad.findByPrtcnt", query = "SELECT c FROM Cdrbhad c WHERE c.prtcnt = :prtcnt"),
    @NamedQuery(name = "Cdrbhad.findByCusaskno", query = "SELECT c FROM Cdrbhad c WHERE c.cusaskno = :cusaskno"),
    @NamedQuery(name = "Cdrbhad.findByHmark1", query = "SELECT c FROM Cdrbhad c WHERE c.hmark1 = :hmark1"),
    @NamedQuery(name = "Cdrbhad.findByHmark2", query = "SELECT c FROM Cdrbhad c WHERE c.hmark2 = :hmark2"),
    @NamedQuery(name = "Cdrbhad.findByIndate", query = "SELECT c FROM Cdrbhad c WHERE c.indate = :indate"),
    @NamedQuery(name = "Cdrbhad.findByUserno", query = "SELECT c FROM Cdrbhad c WHERE c.userno = :userno"),
    @NamedQuery(name = "Cdrbhad.findByCfmuserno", query = "SELECT c FROM Cdrbhad c WHERE c.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Cdrbhad.findByCfmdate", query = "SELECT c FROM Cdrbhad c WHERE c.cfmdate = :cfmdate"),
    @NamedQuery(name = "Cdrbhad.findByOwarehyn", query = "SELECT c FROM Cdrbhad c WHERE c.owarehyn = :owarehyn"),
    @NamedQuery(name = "Cdrbhad.findByProno", query = "SELECT c FROM Cdrbhad c WHERE c.prono = :prono"),
    @NamedQuery(name = "Cdrbhad.findByOwareh", query = "SELECT c FROM Cdrbhad c WHERE c.owareh = :owareh"),
    @NamedQuery(name = "Cdrbhad.findByReplenish", query = "SELECT c FROM Cdrbhad c WHERE c.replenish = :replenish"),
    @NamedQuery(name = "Cdrbhad.findByIssevhad", query = "SELECT c FROM Cdrbhad c WHERE c.issevhad = :issevhad")})
public class Cdrbhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrbhadPK cdrbhadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bakdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bakdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decode")
    private Character decode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shptrseq")
    private short shptrseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivotrseq")
    private short ivotrseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baksta")
    private Character baksta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private Character tax;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxrate")
    private BigDecimal taxrate;
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
    @Column(name = "bakamts")
    private BigDecimal bakamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxamts")
    private BigDecimal taxamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totamts")
    private BigDecimal totamts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycode")
    private Character paycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "termcode")
    private String termcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sacode")
    private String sacode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areacode")
    private String areacode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cuycode")
    private String cuycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mancode")
    private String mancode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addamts")
    private BigDecimal addamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subamts")
    private BigDecimal subamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prtcnt")
    private short prtcnt;
    @Size(max = 18)
    @Column(name = "cusaskno")
    private String cusaskno;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "owarehyn")
    private Character owarehyn;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 12)
    @Column(name = "owareh")
    private String owareh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "replenish")
    private Character replenish;
    @Column(name = "issevhad")
    private Character issevhad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdrbhad")
    private List<Cdrbdta> cdrbdtaList;

    public Cdrbhad() {
    }

    public Cdrbhad(CdrbhadPK cdrbhadPK) {
        this.cdrbhadPK = cdrbhadPK;
    }

    public Cdrbhad(CdrbhadPK cdrbhadPK, Date bakdate, String trtype, String depno, Character decode, String cusno, short shptrseq, short ivotrseq, Character baksta, Character tax, BigDecimal taxrate, String coin, BigDecimal ratio, BigDecimal bakamts, BigDecimal taxamts, BigDecimal totamts, String sndcode, Character paycode, String termcode, String sacode, String areacode, String cuycode, String mancode, BigDecimal addamts, BigDecimal subamts, short prtcnt, Date indate, String userno, Character owarehyn, Character replenish) {
        this.cdrbhadPK = cdrbhadPK;
        this.bakdate = bakdate;
        this.trtype = trtype;
        this.depno = depno;
        this.decode = decode;
        this.cusno = cusno;
        this.shptrseq = shptrseq;
        this.ivotrseq = ivotrseq;
        this.baksta = baksta;
        this.tax = tax;
        this.taxrate = taxrate;
        this.coin = coin;
        this.ratio = ratio;
        this.bakamts = bakamts;
        this.taxamts = taxamts;
        this.totamts = totamts;
        this.sndcode = sndcode;
        this.paycode = paycode;
        this.termcode = termcode;
        this.sacode = sacode;
        this.areacode = areacode;
        this.cuycode = cuycode;
        this.mancode = mancode;
        this.addamts = addamts;
        this.subamts = subamts;
        this.prtcnt = prtcnt;
        this.indate = indate;
        this.userno = userno;
        this.owarehyn = owarehyn;
        this.replenish = replenish;
    }

    public Cdrbhad(String facno, String bakno) {
        this.cdrbhadPK = new CdrbhadPK(facno, bakno);
    }

    public CdrbhadPK getCdrbhadPK() {
        return cdrbhadPK;
    }

    public void setCdrbhadPK(CdrbhadPK cdrbhadPK) {
        this.cdrbhadPK = cdrbhadPK;
    }

    public Date getBakdate() {
        return bakdate;
    }

    public void setBakdate(Date bakdate) {
        this.bakdate = bakdate;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public short getShptrseq() {
        return shptrseq;
    }

    public void setShptrseq(short shptrseq) {
        this.shptrseq = shptrseq;
    }

    public short getIvotrseq() {
        return ivotrseq;
    }

    public void setIvotrseq(short ivotrseq) {
        this.ivotrseq = ivotrseq;
    }

    public Character getBaksta() {
        return baksta;
    }

    public void setBaksta(Character baksta) {
        this.baksta = baksta;
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

    public BigDecimal getBakamts() {
        return bakamts;
    }

    public void setBakamts(BigDecimal bakamts) {
        this.bakamts = bakamts;
    }

    public BigDecimal getTaxamts() {
        return taxamts;
    }

    public void setTaxamts(BigDecimal taxamts) {
        this.taxamts = taxamts;
    }

    public BigDecimal getTotamts() {
        return totamts;
    }

    public void setTotamts(BigDecimal totamts) {
        this.totamts = totamts;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public Character getPaycode() {
        return paycode;
    }

    public void setPaycode(Character paycode) {
        this.paycode = paycode;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getSacode() {
        return sacode;
    }

    public void setSacode(String sacode) {
        this.sacode = sacode;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getCuycode() {
        return cuycode;
    }

    public void setCuycode(String cuycode) {
        this.cuycode = cuycode;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public BigDecimal getAddamts() {
        return addamts;
    }

    public void setAddamts(BigDecimal addamts) {
        this.addamts = addamts;
    }

    public BigDecimal getSubamts() {
        return subamts;
    }

    public void setSubamts(BigDecimal subamts) {
        this.subamts = subamts;
    }

    public short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public String getCusaskno() {
        return cusaskno;
    }

    public void setCusaskno(String cusaskno) {
        this.cusaskno = cusaskno;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public Character getOwarehyn() {
        return owarehyn;
    }

    public void setOwarehyn(Character owarehyn) {
        this.owarehyn = owarehyn;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getOwareh() {
        return owareh;
    }

    public void setOwareh(String owareh) {
        this.owareh = owareh;
    }

    public Character getReplenish() {
        return replenish;
    }

    public void setReplenish(Character replenish) {
        this.replenish = replenish;
    }

    public Character getIssevhad() {
        return issevhad;
    }

    public void setIssevhad(Character issevhad) {
        this.issevhad = issevhad;
    }

    @XmlTransient
    public List<Cdrbdta> getCdrbdtaList() {
        return cdrbdtaList;
    }

    public void setCdrbdtaList(List<Cdrbdta> cdrbdtaList) {
        this.cdrbdtaList = cdrbdtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrbhadPK != null ? cdrbhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrbhad)) {
            return false;
        }
        Cdrbhad other = (Cdrbhad) object;
        if ((this.cdrbhadPK == null && other.cdrbhadPK != null) || (this.cdrbhadPK != null && !this.cdrbhadPK.equals(other.cdrbhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrbhad[ cdrbhadPK=" + cdrbhadPK + " ]";
    }
    
}
