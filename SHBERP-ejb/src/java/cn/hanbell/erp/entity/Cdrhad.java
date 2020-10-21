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
 * @author C0160
 */
@Entity
@Table(name = "cdrhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrhad.findAll", query = "SELECT c FROM Cdrhad c"),
    @NamedQuery(name = "Cdrhad.findByFacno", query = "SELECT c FROM Cdrhad c WHERE c.cdrhadPK.facno = :facno"),
    @NamedQuery(name = "Cdrhad.findByShpno", query = "SELECT c FROM Cdrhad c WHERE c.cdrhadPK.shpno = :shpno"),
    @NamedQuery(name = "Cdrhad.findBySalecode", query = "SELECT c FROM Cdrhad c WHERE c.salecode = :salecode"),
    @NamedQuery(name = "Cdrhad.findByDecode", query = "SELECT c FROM Cdrhad c WHERE c.decode = :decode"),
    @NamedQuery(name = "Cdrhad.findByShpdate", query = "SELECT c FROM Cdrhad c WHERE c.shpdate = :shpdate"),
    @NamedQuery(name = "Cdrhad.findByTrtype", query = "SELECT c FROM Cdrhad c WHERE c.trtype = :trtype"),
    @NamedQuery(name = "Cdrhad.findByDepno", query = "SELECT c FROM Cdrhad c WHERE c.depno = :depno"),
    @NamedQuery(name = "Cdrhad.findByCusno", query = "SELECT c FROM Cdrhad c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "Cdrhad.findByHoutsta", query = "SELECT c FROM Cdrhad c WHERE c.houtsta = :houtsta"),
    @NamedQuery(name = "Cdrhad.findByMancode", query = "SELECT c FROM Cdrhad c WHERE c.mancode = :mancode"),
    @NamedQuery(name = "Cdrhad.findByHmark1", query = "SELECT c FROM Cdrhad c WHERE c.hmark1 = :hmark1"),
    @NamedQuery(name = "Cdrhad.findByHmark2", query = "SELECT c FROM Cdrhad c WHERE c.hmark2 = :hmark2"),
    @NamedQuery(name = "Cdrhad.findByHmark3", query = "SELECT c FROM Cdrhad c WHERE c.hmark3 = :hmark3"),
    @NamedQuery(name = "Cdrhad.findByHmark4", query = "SELECT c FROM Cdrhad c WHERE c.hmark4 = :hmark4")})
public class Cdrhad implements Serializable {

    @JoinColumn(name = "cusno", referencedColumnName = "cusno", insertable = false, updatable = false)
    @ManyToOne
    private Cdrcus cdrcus;
    @JoinColumn(name = "mancode", referencedColumnName = "userno", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Secuser secuser;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrhadPK cdrhadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salecode")
    private Character salecode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decode")
    private Character decode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shpdate;
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
    @Column(name = "houtsta")
    private Character houtsta;
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
    @Column(name = "shpamts")
    private BigDecimal shpamts;
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
    @Size(max = 90)
    @Column(name = "sndcodedsc")
    private String sndcodedsc;
    @Size(max = 90)
    @Column(name = "paycodedsc")
    private String paycodedsc;
    @Size(max = 90)
    @Column(name = "termcodedsc")
    private String termcodedsc;
    @Column(name = "paysepcode")
    private Character paysepcode;
    @Column(name = "seldate1")
    private Short seldate1;
    @Column(name = "seldate2")
    private Short seldate2;
    @Column(name = "seldate3")
    private Short seldate3;
    @Column(name = "seldate4")
    private Short seldate4;
    @Column(name = "handays1")
    private Short handays1;
    @Column(name = "handays2")
    private Short handays2;
    @Column(name = "handays3")
    private Short handays3;
    @Column(name = "handays4")
    private Short handays4;
    @Column(name = "tickdays")
    private Short tickdays;
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
    @Column(name = "invoiceyn")
    private Character invoiceyn;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 8)
    @Column(name = "hmark3")
    private String hmark3;
    @Size(max = 8)
    @Column(name = "hmark4")
    private String hmark4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prtcnt")
    private short prtcnt;
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
    @Size(max = 20)
    @Column(name = "bilno")
    private String bilno;
    @Size(max = 18)
    @Column(name = "moveno")
    private String moveno;
    @Size(max = 12)
    @Column(name = "owareh")
    private String owareh;
    @Size(max = 18)
    @Column(name = "shpono")
    private String shpono;
    @Column(name = "maplcsamt")
    private BigDecimal maplcsamt;
    @Size(max = 18)
    @Column(name = "ncdrno")
    private String ncdrno;
    @Size(max = 18)
    @Column(name = "preno")
    private String preno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "replenish")
    private Character replenish;
    @Column(name = "issevhad")
    private Character issevhad;

    public Cdrhad() {
    }

    public Cdrhad(CdrhadPK cdrhadPK) {
        this.cdrhadPK = cdrhadPK;
    }

    public Cdrhad(CdrhadPK cdrhadPK, Character salecode, Character decode, Date shpdate, String trtype, String depno, String cusno, short shptrseq, short ivotrseq, Character houtsta, Character tax, BigDecimal taxrate, String coin, BigDecimal ratio, BigDecimal shpamts, BigDecimal taxamts, BigDecimal totamts, String sndcode, Character paycode, String termcode, String sacode, String areacode, String cuycode, String mancode, Character invoiceyn, short prtcnt, Date indate, String userno, Character replenish) {
        this.cdrhadPK = cdrhadPK;
        this.salecode = salecode;
        this.decode = decode;
        this.shpdate = shpdate;
        this.trtype = trtype;
        this.depno = depno;
        this.cusno = cusno;
        this.shptrseq = shptrseq;
        this.ivotrseq = ivotrseq;
        this.houtsta = houtsta;
        this.tax = tax;
        this.taxrate = taxrate;
        this.coin = coin;
        this.ratio = ratio;
        this.shpamts = shpamts;
        this.taxamts = taxamts;
        this.totamts = totamts;
        this.sndcode = sndcode;
        this.paycode = paycode;
        this.termcode = termcode;
        this.sacode = sacode;
        this.areacode = areacode;
        this.cuycode = cuycode;
        this.mancode = mancode;
        this.invoiceyn = invoiceyn;
        this.prtcnt = prtcnt;
        this.indate = indate;
        this.userno = userno;
        this.replenish = replenish;
    }

    public Cdrhad(String facno, String shpno) {
        this.cdrhadPK = new CdrhadPK(facno, shpno);
    }

    public CdrhadPK getCdrhadPK() {
        return cdrhadPK;
    }

    public void setCdrhadPK(CdrhadPK cdrhadPK) {
        this.cdrhadPK = cdrhadPK;
    }

    public Character getSalecode() {
        return salecode;
    }

    public void setSalecode(Character salecode) {
        this.salecode = salecode;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public Date getShpdate() {
        return shpdate;
    }

    public void setShpdate(Date shpdate) {
        this.shpdate = shpdate;
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

    public Character getHoutsta() {
        return houtsta;
    }

    public void setHoutsta(Character houtsta) {
        this.houtsta = houtsta;
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

    public BigDecimal getShpamts() {
        return shpamts;
    }

    public void setShpamts(BigDecimal shpamts) {
        this.shpamts = shpamts;
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

    public String getSndcodedsc() {
        return sndcodedsc;
    }

    public void setSndcodedsc(String sndcodedsc) {
        this.sndcodedsc = sndcodedsc;
    }

    public String getPaycodedsc() {
        return paycodedsc;
    }

    public void setPaycodedsc(String paycodedsc) {
        this.paycodedsc = paycodedsc;
    }

    public String getTermcodedsc() {
        return termcodedsc;
    }

    public void setTermcodedsc(String termcodedsc) {
        this.termcodedsc = termcodedsc;
    }

    public Character getPaysepcode() {
        return paysepcode;
    }

    public void setPaysepcode(Character paysepcode) {
        this.paysepcode = paysepcode;
    }

    public Short getSeldate1() {
        return seldate1;
    }

    public void setSeldate1(Short seldate1) {
        this.seldate1 = seldate1;
    }

    public Short getSeldate2() {
        return seldate2;
    }

    public void setSeldate2(Short seldate2) {
        this.seldate2 = seldate2;
    }

    public Short getSeldate3() {
        return seldate3;
    }

    public void setSeldate3(Short seldate3) {
        this.seldate3 = seldate3;
    }

    public Short getSeldate4() {
        return seldate4;
    }

    public void setSeldate4(Short seldate4) {
        this.seldate4 = seldate4;
    }

    public Short getHandays1() {
        return handays1;
    }

    public void setHandays1(Short handays1) {
        this.handays1 = handays1;
    }

    public Short getHandays2() {
        return handays2;
    }

    public void setHandays2(Short handays2) {
        this.handays2 = handays2;
    }

    public Short getHandays3() {
        return handays3;
    }

    public void setHandays3(Short handays3) {
        this.handays3 = handays3;
    }

    public Short getHandays4() {
        return handays4;
    }

    public void setHandays4(Short handays4) {
        this.handays4 = handays4;
    }

    public Short getTickdays() {
        return tickdays;
    }

    public void setTickdays(Short tickdays) {
        this.tickdays = tickdays;
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

    public Character getInvoiceyn() {
        return invoiceyn;
    }

    public void setInvoiceyn(Character invoiceyn) {
        this.invoiceyn = invoiceyn;
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

    public String getHmark3() {
        return hmark3;
    }

    public void setHmark3(String hmark3) {
        this.hmark3 = hmark3;
    }

    public String getHmark4() {
        return hmark4;
    }

    public void setHmark4(String hmark4) {
        this.hmark4 = hmark4;
    }

    public short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(short prtcnt) {
        this.prtcnt = prtcnt;
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

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getMoveno() {
        return moveno;
    }

    public void setMoveno(String moveno) {
        this.moveno = moveno;
    }

    public String getOwareh() {
        return owareh;
    }

    public void setOwareh(String owareh) {
        this.owareh = owareh;
    }

    public String getShpono() {
        return shpono;
    }

    public void setShpono(String shpono) {
        this.shpono = shpono;
    }

    public BigDecimal getMaplcsamt() {
        return maplcsamt;
    }

    public void setMaplcsamt(BigDecimal maplcsamt) {
        this.maplcsamt = maplcsamt;
    }

    public String getNcdrno() {
        return ncdrno;
    }

    public void setNcdrno(String ncdrno) {
        this.ncdrno = ncdrno;
    }

    public String getPreno() {
        return preno;
    }

    public void setPreno(String preno) {
        this.preno = preno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrhadPK != null ? cdrhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrhad)) {
            return false;
        }
        Cdrhad other = (Cdrhad) object;
        if ((this.cdrhadPK == null && other.cdrhadPK != null) || (this.cdrhadPK != null && !this.cdrhadPK.equals(other.cdrhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.Cdrhad[ cdrhadPK=" + cdrhadPK + " ]";
    }

    /**
     * @return the cdrcus
     */
    public Cdrcus getCdrcus() {
        return cdrcus;
    }

    /**
     * @return the secuser
     */
    public Secuser getSecuser() {
        return secuser;
    }

}
