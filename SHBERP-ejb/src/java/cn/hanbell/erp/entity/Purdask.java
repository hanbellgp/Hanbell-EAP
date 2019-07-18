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
@Table(name = "purdask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purdask.findAll", query = "SELECT p FROM Purdask p"),
    @NamedQuery(name = "Purdask.findByFacno", query = "SELECT p FROM Purdask p WHERE p.purdaskPK.facno = :facno"),
    @NamedQuery(name = "Purdask.findByProno", query = "SELECT p FROM Purdask p WHERE p.purdaskPK.prono = :prono"),
    @NamedQuery(name = "Purdask.findByPrno", query = "SELECT p FROM Purdask p WHERE p.purdaskPK.prno = :prno"),
    @NamedQuery(name = "Purdask.findByTrseq", query = "SELECT p FROM Purdask p WHERE p.purdaskPK.trseq = :trseq"),
    @NamedQuery(name = "Purdask.findByItnbr", query = "SELECT p FROM Purdask p WHERE p.itnbr = :itnbr"),
    @NamedQuery(name = "Purdask.findByPrqy1", query = "SELECT p FROM Purdask p WHERE p.prqy1 = :prqy1"),
    @NamedQuery(name = "Purdask.findByPrqy2", query = "SELECT p FROM Purdask p WHERE p.prqy2 = :prqy2"),
    @NamedQuery(name = "Purdask.findByApmqy", query = "SELECT p FROM Purdask p WHERE p.apmqy = :apmqy"),
    @NamedQuery(name = "Purdask.findByRqtdate", query = "SELECT p FROM Purdask p WHERE p.rqtdate = :rqtdate"),
    @NamedQuery(name = "Purdask.findByEmgyn", query = "SELECT p FROM Purdask p WHERE p.emgyn = :emgyn"),
    @NamedQuery(name = "Purdask.findByJudco", query = "SELECT p FROM Purdask p WHERE p.judco = :judco"),
    @NamedQuery(name = "Purdask.findByDmark1", query = "SELECT p FROM Purdask p WHERE p.dmark1 = :dmark1"),
    @NamedQuery(name = "Purdask.findByDmark2", query = "SELECT p FROM Purdask p WHERE p.dmark2 = :dmark2"),
    @NamedQuery(name = "Purdask.findByDasksta", query = "SELECT p FROM Purdask p WHERE p.dasksta = :dasksta"),
    @NamedQuery(name = "Purdask.findByPurtrtype", query = "SELECT p FROM Purdask p WHERE p.purtrtype = :purtrtype"),
    @NamedQuery(name = "Purdask.findByVdrno", query = "SELECT p FROM Purdask p WHERE p.vdrno = :vdrno"),
    @NamedQuery(name = "Purdask.findByBuyer", query = "SELECT p FROM Purdask p WHERE p.buyer = :buyer"),
    @NamedQuery(name = "Purdask.findByCoin", query = "SELECT p FROM Purdask p WHERE p.coin = :coin"),
    @NamedQuery(name = "Purdask.findByUnpris", query = "SELECT p FROM Purdask p WHERE p.unpris = :unpris"),
    @NamedQuery(name = "Purdask.findByRatio", query = "SELECT p FROM Purdask p WHERE p.ratio = :ratio"),
    @NamedQuery(name = "Purdask.findByTax", query = "SELECT p FROM Purdask p WHERE p.tax = :tax"),
    @NamedQuery(name = "Purdask.findByTaxrate", query = "SELECT p FROM Purdask p WHERE p.taxrate = :taxrate"),
    @NamedQuery(name = "Purdask.findByTramts", query = "SELECT p FROM Purdask p WHERE p.tramts = :tramts"),
    @NamedQuery(name = "Purdask.findByTaxamts", query = "SELECT p FROM Purdask p WHERE p.taxamts = :taxamts"),
    @NamedQuery(name = "Purdask.findByTotamts", query = "SELECT p FROM Purdask p WHERE p.totamts = :totamts"),
    @NamedQuery(name = "Purdask.findByAskdate", query = "SELECT p FROM Purdask p WHERE p.askdate = :askdate"),
    @NamedQuery(name = "Purdask.findByTermcode", query = "SELECT p FROM Purdask p WHERE p.termcode = :termcode"),
    @NamedQuery(name = "Purdask.findByTermcodedsc", query = "SELECT p FROM Purdask p WHERE p.termcodedsc = :termcodedsc"),
    @NamedQuery(name = "Purdask.findBySndcode", query = "SELECT p FROM Purdask p WHERE p.sndcode = :sndcode"),
    @NamedQuery(name = "Purdask.findBySndcodedsc", query = "SELECT p FROM Purdask p WHERE p.sndcodedsc = :sndcodedsc"),
    @NamedQuery(name = "Purdask.findByPaycom", query = "SELECT p FROM Purdask p WHERE p.paycom = :paycom"),
    @NamedQuery(name = "Purdask.findByPaycode", query = "SELECT p FROM Purdask p WHERE p.paycode = :paycode"),
    @NamedQuery(name = "Purdask.findByPaycodedsc", query = "SELECT p FROM Purdask p WHERE p.paycodedsc = :paycodedsc"),
    @NamedQuery(name = "Purdask.findByPaysepcode", query = "SELECT p FROM Purdask p WHERE p.paysepcode = :paysepcode"),
    @NamedQuery(name = "Purdask.findBySeldate1", query = "SELECT p FROM Purdask p WHERE p.seldate1 = :seldate1"),
    @NamedQuery(name = "Purdask.findBySeldate2", query = "SELECT p FROM Purdask p WHERE p.seldate2 = :seldate2"),
    @NamedQuery(name = "Purdask.findBySeldate3", query = "SELECT p FROM Purdask p WHERE p.seldate3 = :seldate3"),
    @NamedQuery(name = "Purdask.findBySeldate4", query = "SELECT p FROM Purdask p WHERE p.seldate4 = :seldate4"),
    @NamedQuery(name = "Purdask.findByHandays1", query = "SELECT p FROM Purdask p WHERE p.handays1 = :handays1"),
    @NamedQuery(name = "Purdask.findByHandays2", query = "SELECT p FROM Purdask p WHERE p.handays2 = :handays2"),
    @NamedQuery(name = "Purdask.findByHandays3", query = "SELECT p FROM Purdask p WHERE p.handays3 = :handays3"),
    @NamedQuery(name = "Purdask.findByHandays4", query = "SELECT p FROM Purdask p WHERE p.handays4 = :handays4"),
    @NamedQuery(name = "Purdask.findByTickdays", query = "SELECT p FROM Purdask p WHERE p.tickdays = :tickdays"),
    @NamedQuery(name = "Purdask.findByPrepayamts", query = "SELECT p FROM Purdask p WHERE p.prepayamts = :prepayamts"),
    @NamedQuery(name = "Purdask.findByAddcode", query = "SELECT p FROM Purdask p WHERE p.addcode = :addcode"),
    @NamedQuery(name = "Purdask.findByDecode", query = "SELECT p FROM Purdask p WHERE p.decode = :decode"),
    @NamedQuery(name = "Purdask.findByPoprtcnt", query = "SELECT p FROM Purdask p WHERE p.poprtcnt = :poprtcnt"),
    @NamedQuery(name = "Purdask.findByPosrccode", query = "SELECT p FROM Purdask p WHERE p.posrccode = :posrccode"),
    @NamedQuery(name = "Purdask.findByRefno", query = "SELECT p FROM Purdask p WHERE p.refno = :refno"),
    @NamedQuery(name = "Purdask.findByModnum", query = "SELECT p FROM Purdask p WHERE p.modnum = :modnum"),
    @NamedQuery(name = "Purdask.findByTransno", query = "SELECT p FROM Purdask p WHERE p.transno = :transno"),
    @NamedQuery(name = "Purdask.findByHunpri", query = "SELECT p FROM Purdask p WHERE p.hunpri = :hunpri"),
    @NamedQuery(name = "Purdask.findByPodate", query = "SELECT p FROM Purdask p WHERE p.podate = :podate"),
    @NamedQuery(name = "Purdask.findByPrnoamt", query = "SELECT p FROM Purdask p WHERE p.prnoamt = :prnoamt"),
    @NamedQuery(name = "Purdask.findByOrderdate", query = "SELECT p FROM Purdask p WHERE p.orderdate = :orderdate"),
    @NamedQuery(name = "Purdask.findByBudgetacc", query = "SELECT p FROM Purdask p WHERE p.budgetacc = :budgetacc"),
    @NamedQuery(name = "Purdask.findByPreprice", query = "SELECT p FROM Purdask p WHERE p.preprice = :preprice"),
    @NamedQuery(name = "Purdask.findByPredict", query = "SELECT p FROM Purdask p WHERE p.predict = :predict")})
public class Purdask implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurdaskPK purdaskPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prqy1")
    private BigDecimal prqy1;
    @Column(name = "prqy2")
    private BigDecimal prqy2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmqy")
    private BigDecimal apmqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rqtdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rqtdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emgyn")
    private Character emgyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "judco")
    private String judco;
    @Size(max = 10)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 10)
    @Column(name = "dmark2")
    private String dmark2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "dasksta")
    private String dasksta;
    @Size(max = 3)
    @Column(name = "purtrtype")
    private String purtrtype;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 4)
    @Column(name = "coin")
    private String coin;
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Column(name = "tax")
    private Character tax;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Column(name = "tramts")
    private BigDecimal tramts;
    @Column(name = "taxamts")
    private BigDecimal taxamts;
    @Column(name = "totamts")
    private BigDecimal totamts;
    @Column(name = "askdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdate;
    @Size(max = 8)
    @Column(name = "termcode")
    private String termcode;
    @Size(max = 90)
    @Column(name = "termcodedsc")
    private String termcodedsc;
    @Size(max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 90)
    @Column(name = "sndcodedsc")
    private String sndcodedsc;
    @Column(name = "paycom")
    private Character paycom;
    @Column(name = "paycode")
    private Character paycode;
    @Size(max = 90)
    @Column(name = "paycodedsc")
    private String paycodedsc;
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
    @Column(name = "prepayamts")
    private BigDecimal prepayamts;
    @Size(max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Column(name = "decode")
    private Character decode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poprtcnt")
    private short poprtcnt;
    @Column(name = "posrccode")
    private Character posrccode;
    @Size(max = 18)
    @Column(name = "refno")
    private String refno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modnum")
    private short modnum;
    @Size(max = 18)
    @Column(name = "transno")
    private String transno;
    @Column(name = "hunpri")
    private BigDecimal hunpri;
    @Column(name = "podate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date podate;
    @Column(name = "prnoamt")
    private BigDecimal prnoamt;
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Size(max = 10)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preprice")
    private BigDecimal preprice;
    @Size(max = 1)
    @Column(name = "predict")
    private String predict;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "prono", referencedColumnName = "prono", insertable = false, updatable = false),
        @JoinColumn(name = "prno", referencedColumnName = "prno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Purhask purhask;

    public Purdask() {
    }

    public Purdask(PurdaskPK purdaskPK) {
        this.purdaskPK = purdaskPK;
    }

    public Purdask(PurdaskPK purdaskPK, String itnbr, BigDecimal prqy1, BigDecimal apmqy, Date rqtdate, Character emgyn, String judco, String dasksta, String buyer, short poprtcnt, short modnum, BigDecimal preprice) {
        this.purdaskPK = purdaskPK;
        this.itnbr = itnbr;
        this.prqy1 = prqy1;
        this.apmqy = apmqy;
        this.rqtdate = rqtdate;
        this.emgyn = emgyn;
        this.judco = judco;
        this.dasksta = dasksta;
        this.buyer = buyer;
        this.poprtcnt = poprtcnt;
        this.modnum = modnum;
        this.preprice = preprice;
    }

    public Purdask(String facno, String prono, String prno, short trseq) {
        this.purdaskPK = new PurdaskPK(facno, prono, prno, trseq);
    }

    public PurdaskPK getPurdaskPK() {
        return purdaskPK;
    }

    public void setPurdaskPK(PurdaskPK purdaskPK) {
        this.purdaskPK = purdaskPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public BigDecimal getPrqy1() {
        return prqy1;
    }

    public void setPrqy1(BigDecimal prqy1) {
        this.prqy1 = prqy1;
    }

    public BigDecimal getPrqy2() {
        return prqy2;
    }

    public void setPrqy2(BigDecimal prqy2) {
        this.prqy2 = prqy2;
    }

    public BigDecimal getApmqy() {
        return apmqy;
    }

    public void setApmqy(BigDecimal apmqy) {
        this.apmqy = apmqy;
    }

    public Date getRqtdate() {
        return rqtdate;
    }

    public void setRqtdate(Date rqtdate) {
        this.rqtdate = rqtdate;
    }

    public Character getEmgyn() {
        return emgyn;
    }

    public void setEmgyn(Character emgyn) {
        this.emgyn = emgyn;
    }

    public String getJudco() {
        return judco;
    }

    public void setJudco(String judco) {
        this.judco = judco;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getDasksta() {
        return dasksta;
    }

    public void setDasksta(String dasksta) {
        this.dasksta = dasksta;
    }

    public String getPurtrtype() {
        return purtrtype;
    }

    public void setPurtrtype(String purtrtype) {
        this.purtrtype = purtrtype;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
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

    public BigDecimal getTramts() {
        return tramts;
    }

    public void setTramts(BigDecimal tramts) {
        this.tramts = tramts;
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

    public Date getAskdate() {
        return askdate;
    }

    public void setAskdate(Date askdate) {
        this.askdate = askdate;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getTermcodedsc() {
        return termcodedsc;
    }

    public void setTermcodedsc(String termcodedsc) {
        this.termcodedsc = termcodedsc;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public String getSndcodedsc() {
        return sndcodedsc;
    }

    public void setSndcodedsc(String sndcodedsc) {
        this.sndcodedsc = sndcodedsc;
    }

    public Character getPaycom() {
        return paycom;
    }

    public void setPaycom(Character paycom) {
        this.paycom = paycom;
    }

    public Character getPaycode() {
        return paycode;
    }

    public void setPaycode(Character paycode) {
        this.paycode = paycode;
    }

    public String getPaycodedsc() {
        return paycodedsc;
    }

    public void setPaycodedsc(String paycodedsc) {
        this.paycodedsc = paycodedsc;
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

    public BigDecimal getPrepayamts() {
        return prepayamts;
    }

    public void setPrepayamts(BigDecimal prepayamts) {
        this.prepayamts = prepayamts;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public short getPoprtcnt() {
        return poprtcnt;
    }

    public void setPoprtcnt(short poprtcnt) {
        this.poprtcnt = poprtcnt;
    }

    public Character getPosrccode() {
        return posrccode;
    }

    public void setPosrccode(Character posrccode) {
        this.posrccode = posrccode;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public short getModnum() {
        return modnum;
    }

    public void setModnum(short modnum) {
        this.modnum = modnum;
    }

    public String getTransno() {
        return transno;
    }

    public void setTransno(String transno) {
        this.transno = transno;
    }

    public BigDecimal getHunpri() {
        return hunpri;
    }

    public void setHunpri(BigDecimal hunpri) {
        this.hunpri = hunpri;
    }

    public Date getPodate() {
        return podate;
    }

    public void setPodate(Date podate) {
        this.podate = podate;
    }

    public BigDecimal getPrnoamt() {
        return prnoamt;
    }

    public void setPrnoamt(BigDecimal prnoamt) {
        this.prnoamt = prnoamt;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public BigDecimal getPreprice() {
        return preprice;
    }

    public void setPreprice(BigDecimal preprice) {
        this.preprice = preprice;
    }

    public String getPredict() {
        return predict;
    }

    public void setPredict(String predict) {
        this.predict = predict;
    }

    public Purhask getPurhask() {
        return purhask;
    }

    public void setPurhask(Purhask purhask) {
        this.purhask = purhask;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purdaskPK != null ? purdaskPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purdask)) {
            return false;
        }
        Purdask other = (Purdask) object;
        if ((this.purdaskPK == null && other.purdaskPK != null) || (this.purdaskPK != null && !this.purdaskPK.equals(other.purdaskPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purdask[ purdaskPK=" + purdaskPK + " ]";
    }
    
}
