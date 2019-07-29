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
@Table(name = "cdrqhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrqhad.findAll", query = "SELECT c FROM Cdrqhad c"),
    @NamedQuery(name = "Cdrqhad.findByFacno", query = "SELECT c FROM Cdrqhad c WHERE c.cdrqhadPK.facno = :facno"),
    @NamedQuery(name = "Cdrqhad.findByQuono", query = "SELECT c FROM Cdrqhad c WHERE c.cdrqhadPK.quono = :quono"),
    @NamedQuery(name = "Cdrqhad.findByCusno", query = "SELECT c FROM Cdrqhad c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "Cdrqhad.findByDepno", query = "SELECT c FROM Cdrqhad c WHERE c.depno = :depno"),
    @NamedQuery(name = "Cdrqhad.findByQuodate", query = "SELECT c FROM Cdrqhad c WHERE c.quodate = :quodate"),
    @NamedQuery(name = "Cdrqhad.findByEffdays", query = "SELECT c FROM Cdrqhad c WHERE c.effdays = :effdays"),
    @NamedQuery(name = "Cdrqhad.findByEeffdate", query = "SELECT c FROM Cdrqhad c WHERE c.eeffdate = :eeffdate"),
    @NamedQuery(name = "Cdrqhad.findByDecode", query = "SELECT c FROM Cdrqhad c WHERE c.decode = :decode"),
    @NamedQuery(name = "Cdrqhad.findByShptrseq", query = "SELECT c FROM Cdrqhad c WHERE c.shptrseq = :shptrseq"),
    @NamedQuery(name = "Cdrqhad.findByIvotrseq", query = "SELECT c FROM Cdrqhad c WHERE c.ivotrseq = :ivotrseq"),
    @NamedQuery(name = "Cdrqhad.findByHquosta", query = "SELECT c FROM Cdrqhad c WHERE c.hquosta = :hquosta"),
    @NamedQuery(name = "Cdrqhad.findByTax", query = "SELECT c FROM Cdrqhad c WHERE c.tax = :tax"),
    @NamedQuery(name = "Cdrqhad.findByTaxrate", query = "SELECT c FROM Cdrqhad c WHERE c.taxrate = :taxrate"),
    @NamedQuery(name = "Cdrqhad.findByCoin", query = "SELECT c FROM Cdrqhad c WHERE c.coin = :coin"),
    @NamedQuery(name = "Cdrqhad.findByPaysepcode", query = "SELECT c FROM Cdrqhad c WHERE c.paysepcode = :paysepcode"),
    @NamedQuery(name = "Cdrqhad.findBySacode", query = "SELECT c FROM Cdrqhad c WHERE c.sacode = :sacode"),
    @NamedQuery(name = "Cdrqhad.findByAreacode", query = "SELECT c FROM Cdrqhad c WHERE c.areacode = :areacode"),
    @NamedQuery(name = "Cdrqhad.findByCuycode", query = "SELECT c FROM Cdrqhad c WHERE c.cuycode = :cuycode"),
    @NamedQuery(name = "Cdrqhad.findByMancode", query = "SELECT c FROM Cdrqhad c WHERE c.mancode = :mancode"),
    @NamedQuery(name = "Cdrqhad.findByTramts", query = "SELECT c FROM Cdrqhad c WHERE c.tramts = :tramts"),
    @NamedQuery(name = "Cdrqhad.findByTaxamts", query = "SELECT c FROM Cdrqhad c WHERE c.taxamts = :taxamts"),
    @NamedQuery(name = "Cdrqhad.findByTotamts", query = "SELECT c FROM Cdrqhad c WHERE c.totamts = :totamts"),
    @NamedQuery(name = "Cdrqhad.findByHmark1", query = "SELECT c FROM Cdrqhad c WHERE c.hmark1 = :hmark1"),
    @NamedQuery(name = "Cdrqhad.findByPrtcnt", query = "SELECT c FROM Cdrqhad c WHERE c.prtcnt = :prtcnt"),
    @NamedQuery(name = "Cdrqhad.findByPiprtcnt", query = "SELECT c FROM Cdrqhad c WHERE c.piprtcnt = :piprtcnt"),
    @NamedQuery(name = "Cdrqhad.findByBcdrno", query = "SELECT c FROM Cdrqhad c WHERE c.bcdrno = :bcdrno"),
    @NamedQuery(name = "Cdrqhad.findByIndate", query = "SELECT c FROM Cdrqhad c WHERE c.indate = :indate"),
    @NamedQuery(name = "Cdrqhad.findByUserno", query = "SELECT c FROM Cdrqhad c WHERE c.userno = :userno"),
    @NamedQuery(name = "Cdrqhad.findByCfmuserno", query = "SELECT c FROM Cdrqhad c WHERE c.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Cdrqhad.findByCfmdate", query = "SELECT c FROM Cdrqhad c WHERE c.cfmdate = :cfmdate"),
    @NamedQuery(name = "Cdrqhad.findByTrnuserno", query = "SELECT c FROM Cdrqhad c WHERE c.trnuserno = :trnuserno"),
    @NamedQuery(name = "Cdrqhad.findByTrndate", query = "SELECT c FROM Cdrqhad c WHERE c.trndate = :trndate"),
    @NamedQuery(name = "Cdrqhad.findByPino", query = "SELECT c FROM Cdrqhad c WHERE c.pino = :pino"),
    @NamedQuery(name = "Cdrqhad.findByCopyquono", query = "SELECT c FROM Cdrqhad c WHERE c.copyquono = :copyquono"),
    @NamedQuery(name = "Cdrqhad.findByQuotype", query = "SELECT c FROM Cdrqhad c WHERE c.quotype = :quotype"),
    @NamedQuery(name = "Cdrqhad.findBySelpricode", query = "SELECT c FROM Cdrqhad c WHERE c.selpricode = :selpricode"),
    @NamedQuery(name = "Cdrqhad.findByFromdate", query = "SELECT c FROM Cdrqhad c WHERE c.fromdate = :fromdate"),
    @NamedQuery(name = "Cdrqhad.findByContactman", query = "SELECT c FROM Cdrqhad c WHERE c.contactman = :contactman"),
    @NamedQuery(name = "Cdrqhad.findByPricingtype", query = "SELECT c FROM Cdrqhad c WHERE c.pricingtype = :pricingtype"),
    @NamedQuery(name = "Cdrqhad.findByIsspecial", query = "SELECT c FROM Cdrqhad c WHERE c.isspecial = :isspecial"),
    @NamedQuery(name = "Cdrqhad.findBySpcode", query = "SELECT c FROM Cdrqhad c WHERE c.spcode = :spcode"),
    @NamedQuery(name = "Cdrqhad.findByLevelp", query = "SELECT c FROM Cdrqhad c WHERE c.levelp = :levelp"),
    @NamedQuery(name = "Cdrqhad.findByOacfuser", query = "SELECT c FROM Cdrqhad c WHERE c.oacfuser = :oacfuser"),
    @NamedQuery(name = "Cdrqhad.findByCuspono", query = "SELECT c FROM Cdrqhad c WHERE c.cuspono = :cuspono"),
    @NamedQuery(name = "Cdrqhad.findByApprresno", query = "SELECT c FROM Cdrqhad c WHERE c.apprresno = :apprresno"),
    @NamedQuery(name = "Cdrqhad.findByWarranty", query = "SELECT c FROM Cdrqhad c WHERE c.warranty = :warranty"),
    @NamedQuery(name = "Cdrqhad.findByNewcusna", query = "SELECT c FROM Cdrqhad c WHERE c.newcusna = :newcusna"),
    @NamedQuery(name = "Cdrqhad.findByFaultmc", query = "SELECT c FROM Cdrqhad c WHERE c.faultmc = :faultmc"),
    @NamedQuery(name = "Cdrqhad.findByIsuphis", query = "SELECT c FROM Cdrqhad c WHERE c.isuphis = :isuphis"),
    @NamedQuery(name = "Cdrqhad.findNeedThrow", query = "SELECT c FROM Cdrqhad c WHERE c.hquosta = 'R'  ORDER BY c.cdrqhadPK.facno  ,c.cdrqhadPK.quono"),
    @NamedQuery(name = "Cdrqhad.findByRechkprice", query = "SELECT c FROM Cdrqhad c WHERE c.rechkprice = :rechkprice")})
public class Cdrqhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrqhadPK cdrqhadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quodate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date quodate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "effdays")
    private short effdays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eeffdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eeffdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decode")
    private Character decode;
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
    @Column(name = "hquosta")
    private Character hquosta;
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
    @Size(max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 8)
    @Column(name = "paycode")
    private String paycode;
    @Size(max = 8)
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
    @Size(max = 8)
    @Column(name = "sacode")
    private String sacode;
    @Size(max = 8)
    @Column(name = "areacode")
    private String areacode;
    @Size(max = 8)
    @Column(name = "cuycode")
    private String cuycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mancode")
    private String mancode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tramts")
    private BigDecimal tramts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxamts")
    private BigDecimal taxamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totamts")
    private BigDecimal totamts;
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
    @Column(name = "piprtcnt")
    private short piprtcnt;
    @Size(max = 18)
    @Column(name = "bcdrno")
    private String bcdrno;
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
    @Size(max = 8)
    @Column(name = "trnuserno")
    private String trnuserno;
    @Column(name = "trndate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trndate;
    @Size(max = 20)
    @Column(name = "pino")
    private String pino;
    @Size(max = 18)
    @Column(name = "copyquono")
    private String copyquono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quotype")
    private Character quotype;
    @Column(name = "selpricode")
    private Character selpricode;
    @Column(name = "fromdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromdate;
    @Size(max = 30)
    @Column(name = "contactman")
    private String contactman;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pricingtype")
    private String pricingtype;
    @Size(max = 1)
    @Column(name = "isspecial")
    private String isspecial;
    @Column(name = "spcode")
    private Character spcode;
    @Size(max = 3)
    @Column(name = "levelp")
    private String levelp;
    @Size(max = 8)
    @Column(name = "oacfuser")
    private String oacfuser;
    @Size(max = 20)
    @Column(name = "cuspono")
    private String cuspono;
    @Size(max = 12)
    @Column(name = "apprresno")
    private String apprresno;
    @Column(name = "warranty")
    private Short warranty;
    @Size(max = 40)
    @Column(name = "newcusna")
    private String newcusna;
    @Size(max = 40)
    @Column(name = "faultmc")
    private String faultmc;
    @Column(name = "isuphis")
    private Character isuphis;
    @Size(max = 10)
    @Column(name = "wxgl")
    private String wxgl;
    @Size(max = 1)
    @Column(name = "rechkprice")
    private String rechkprice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdrqhad")
    private List<Cdrqdta> cdrqdtaList;

    public Cdrqhad() {
    }

    public Cdrqhad(CdrqhadPK cdrqhadPK) {
        this.cdrqhadPK = cdrqhadPK;
    }

    public Cdrqhad(CdrqhadPK cdrqhadPK, String cusno, Date quodate, short effdays, Date eeffdate, Character decode, short shptrseq, short ivotrseq, Character hquosta, Character tax, BigDecimal taxrate, String coin, BigDecimal ratio, String mancode, BigDecimal tramts, BigDecimal taxamts, BigDecimal totamts, short prtcnt, short piprtcnt, Date indate, String userno, Character quotype, String pricingtype) {
        this.cdrqhadPK = cdrqhadPK;
        this.cusno = cusno;
        this.quodate = quodate;
        this.effdays = effdays;
        this.eeffdate = eeffdate;
        this.decode = decode;
        this.shptrseq = shptrseq;
        this.ivotrseq = ivotrseq;
        this.hquosta = hquosta;
        this.tax = tax;
        this.taxrate = taxrate;
        this.coin = coin;
        this.ratio = ratio;
        this.mancode = mancode;
        this.tramts = tramts;
        this.taxamts = taxamts;
        this.totamts = totamts;
        this.prtcnt = prtcnt;
        this.piprtcnt = piprtcnt;
        this.indate = indate;
        this.userno = userno;
        this.quotype = quotype;
        this.pricingtype = pricingtype;
    }

    public Cdrqhad(String facno, String quono) {
        this.cdrqhadPK = new CdrqhadPK(facno, quono);
    }

    public CdrqhadPK getCdrqhadPK() {
        return cdrqhadPK;
    }

    public void setCdrqhadPK(CdrqhadPK cdrqhadPK) {
        this.cdrqhadPK = cdrqhadPK;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Date getQuodate() {
        return quodate;
    }

    public void setQuodate(Date quodate) {
        this.quodate = quodate;
    }

    public short getEffdays() {
        return effdays;
    }

    public void setEffdays(short effdays) {
        this.effdays = effdays;
    }

    public Date getEeffdate() {
        return eeffdate;
    }

    public void setEeffdate(Date eeffdate) {
        this.eeffdate = eeffdate;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
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

    public Character getHquosta() {
        return hquosta;
    }

    public void setHquosta(Character hquosta) {
        this.hquosta = hquosta;
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

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
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

    public short getPiprtcnt() {
        return piprtcnt;
    }

    public void setPiprtcnt(short piprtcnt) {
        this.piprtcnt = piprtcnt;
    }

    public String getBcdrno() {
        return bcdrno;
    }

    public void setBcdrno(String bcdrno) {
        this.bcdrno = bcdrno;
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

    public String getTrnuserno() {
        return trnuserno;
    }

    public void setTrnuserno(String trnuserno) {
        this.trnuserno = trnuserno;
    }

    public Date getTrndate() {
        return trndate;
    }

    public void setTrndate(Date trndate) {
        this.trndate = trndate;
    }

    public String getPino() {
        return pino;
    }

    public void setPino(String pino) {
        this.pino = pino;
    }

    public String getCopyquono() {
        return copyquono;
    }

    public void setCopyquono(String copyquono) {
        this.copyquono = copyquono;
    }

    public Character getQuotype() {
        return quotype;
    }

    public void setQuotype(Character quotype) {
        this.quotype = quotype;
    }

    public Character getSelpricode() {
        return selpricode;
    }

    public void setSelpricode(Character selpricode) {
        this.selpricode = selpricode;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getPricingtype() {
        return pricingtype;
    }

    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }

    public String getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(String isspecial) {
        this.isspecial = isspecial;
    }

    public Character getSpcode() {
        return spcode;
    }

    public void setSpcode(Character spcode) {
        this.spcode = spcode;
    }

    public String getLevelp() {
        return levelp;
    }

    public void setLevelp(String levelp) {
        this.levelp = levelp;
    }

    public String getOacfuser() {
        return oacfuser;
    }

    public void setOacfuser(String oacfuser) {
        this.oacfuser = oacfuser;
    }

    public String getCuspono() {
        return cuspono;
    }

    public void setCuspono(String cuspono) {
        this.cuspono = cuspono;
    }

    public String getApprresno() {
        return apprresno;
    }

    public void setApprresno(String apprresno) {
        this.apprresno = apprresno;
    }

    public Short getWarranty() {
        return warranty;
    }

    public void setWarranty(Short warranty) {
        this.warranty = warranty;
    }

    public String getNewcusna() {
        return newcusna;
    }

    public void setNewcusna(String newcusna) {
        this.newcusna = newcusna;
    }

    public String getFaultmc() {
        return faultmc;
    }

    public void setFaultmc(String faultmc) {
        this.faultmc = faultmc;
    }

    public Character getIsuphis() {
        return isuphis;
    }

    public void setIsuphis(Character isuphis) {
        this.isuphis = isuphis;
    }

    public String getWxgl() {
        return wxgl;
    }

    public void setWxgl(String wxgl) {
        this.wxgl = wxgl;
    }

    public String getRechkprice() {
        return rechkprice;
    }

    public void setRechkprice(String rechkprice) {
        this.rechkprice = rechkprice;
    }

    @XmlTransient
    public List<Cdrqdta> getCdrqdtaList() {
        return cdrqdtaList;
    }

    public void setCdrqdtaList(List<Cdrqdta> cdrqdtaList) {
        this.cdrqdtaList = cdrqdtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrqhadPK != null ? cdrqhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrqhad)) {
            return false;
        }
        Cdrqhad other = (Cdrqhad) object;
        if ((this.cdrqhadPK == null && other.cdrqhadPK != null) || (this.cdrqhadPK != null && !this.cdrqhadPK.equals(other.cdrqhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrqhad[ cdrqhadPK=" + cdrqhadPK + " ]";
    }

}
