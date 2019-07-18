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
@Table(name = "purhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purhad.findAll", query = "SELECT p FROM Purhad p"),
    @NamedQuery(name = "Purhad.findByPK", query = "SELECT p FROM Purhad p WHERE p.purhadPK.facno = :facno AND p.purhadPK.pono = :pono"),
    @NamedQuery(name = "Purhad.findByProno", query = "SELECT p FROM Purhad p WHERE p.purhadPK.prono = :prono"),
    @NamedQuery(name = "Purhad.findByPono", query = "SELECT p FROM Purhad p WHERE p.purhadPK.pono = :pono"),
    @NamedQuery(name = "Purhad.findByDecode", query = "SELECT p FROM Purhad p WHERE p.decode = :decode"),
    @NamedQuery(name = "Purhad.findNeedThrowByVdrno", query = "SELECT p FROM Purhad p WHERE p.vdrno = :vdrno AND p.podate>= :podate  AND p.hposta='Y' AND (p.fromcdrno IS NULL OR p.fromcdrno='') ORDER BY p.purhadPK.pono")})
public class Purhad implements Serializable {

    @JoinColumn(name = "vdrno", referencedColumnName = "vdrno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Purvdr purvdr;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurhadPK purhadPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;

    @Basic(optional = false)
    @NotNull
    @Column(name = "decode")
    private Character decode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "podate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date podate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "buyer")
    private String buyer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "termcode")
    private String termcode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Size(max = 90)
    @Column(name = "termcodedsc")
    private String termcodedsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycom")
    private Character paycom;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "paycode")
    private Character paycode;
    @Size(max = 90)
    @Column(name = "paycodedsc")
    private String paycodedsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 90)
    @Column(name = "sndcodedsc")
    private String sndcodedsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "tax")
    private Character tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poamts")
    private BigDecimal poamts;
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
    @Column(name = "hposta")
    private Character hposta;
    @Size(max = 10)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 10)
    @Column(name = "hmark2")
    private String hmark2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prtcnt")
    private short prtcnt;
    @Size(max = 30)
    @Column(name = "queryno")
    private String queryno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "relyn")
    private Character relyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "triyn")
    private Character triyn;
    @Size(max = 8)
    @Column(name = "trivdrno")
    private String trivdrno;
    @Size(max = 18)
    @Column(name = "tocdrno")
    private String tocdrno;
    @Size(max = 18)
    @Column(name = "fromcdrno")
    private String fromcdrno;
    @Size(max = 8)
    @Column(name = "fromcusno")
    private String fromcusno;
    @Size(max = 1)
    @Column(name = "vdrsta")
    private String vdrsta;
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
    @Column(name = "posrc")
    private Character posrc;
    @Column(name = "prepayamts")
    private BigDecimal prepayamts;
    @Column(name = "aprepayamts")
    private BigDecimal aprepayamts;
    @Column(name = "iprepayamts")
    private BigDecimal iprepayamts;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Column(name = "tritax")
    private Character tritax;
    @Column(name = "tritaxrate")
    private BigDecimal tritaxrate;
    @Column(name = "isspin")
    private Character isspin;

    public Purhad() {
    }

    public Purhad(PurhadPK purhadPK) {
        this.purhadPK = purhadPK;
    }

    public Purhad(String facno, String prono, String pono) {
        this.purhadPK = new PurhadPK(facno, prono, pono);
    }

    public PurhadPK getPurhadPK() {
        return purhadPK;
    }

    public void setPurhadPK(PurhadPK purhadPK) {
        this.purhadPK = purhadPK;
    }

    /**
     * @return the vdrno
     */
    public String getVdrno() {
        return vdrno;
    }

    /**
     * @param vdrno the vdrno to set
     */
    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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

    public Character getPosrc() {
        return posrc;
    }

    public void setPosrc(Character posrc) {
        this.posrc = posrc;
    }

    public BigDecimal getPrepayamts() {
        return prepayamts;
    }

    public void setPrepayamts(BigDecimal prepayamts) {
        this.prepayamts = prepayamts;
    }

    public BigDecimal getAprepayamts() {
        return aprepayamts;
    }

    public void setAprepayamts(BigDecimal aprepayamts) {
        this.aprepayamts = aprepayamts;
    }

    public BigDecimal getIprepayamts() {
        return iprepayamts;
    }

    public void setIprepayamts(BigDecimal iprepayamts) {
        this.iprepayamts = iprepayamts;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public Character getTritax() {
        return tritax;
    }

    public void setTritax(Character tritax) {
        this.tritax = tritax;
    }

    public BigDecimal getTritaxrate() {
        return tritaxrate;
    }

    public void setTritaxrate(BigDecimal tritaxrate) {
        this.tritaxrate = tritaxrate;
    }

    public Character getIsspin() {
        return isspin;
    }

    public void setIsspin(Character isspin) {
        this.isspin = isspin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purhadPK != null ? purhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purhad)) {
            return false;
        }
        Purhad other = (Purhad) object;
        if ((this.purhadPK != null && other.purhadPK != null)) {
            return this.purhadPK.equals(other.purhadPK);
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purhad[ purhadPK=" + purhadPK + " ]";
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public Date getPodate() {
        return podate;
    }

    public void setPodate(Date podate) {
        this.podate = podate;
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

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
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

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
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

    public BigDecimal getPoamts() {
        return poamts;
    }

    public void setPoamts(BigDecimal poamts) {
        this.poamts = poamts;
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

    public Character getHposta() {
        return hposta;
    }

    public void setHposta(Character hposta) {
        this.hposta = hposta;
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

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public String getQueryno() {
        return queryno;
    }

    public void setQueryno(String queryno) {
        this.queryno = queryno;
    }

    public Character getRelyn() {
        return relyn;
    }

    public void setRelyn(Character relyn) {
        this.relyn = relyn;
    }

    public Character getTriyn() {
        return triyn;
    }

    public void setTriyn(Character triyn) {
        this.triyn = triyn;
    }

    public String getTrivdrno() {
        return trivdrno;
    }

    public void setTrivdrno(String trivdrno) {
        this.trivdrno = trivdrno;
    }

    public String getTocdrno() {
        return tocdrno;
    }

    public void setTocdrno(String tocdrno) {
        this.tocdrno = tocdrno;
    }

    public String getFromcdrno() {
        return fromcdrno;
    }

    public void setFromcdrno(String fromcdrno) {
        this.fromcdrno = fromcdrno;
    }

    public String getFromcusno() {
        return fromcusno;
    }

    public void setFromcusno(String fromcusno) {
        this.fromcusno = fromcusno;
    }

    public String getVdrsta() {
        return vdrsta;
    }

    public void setVdrsta(String vdrsta) {
        this.vdrsta = vdrsta;
    }

    public Purvdr getPurvdr() {
        return purvdr;
    }

    public void setPurvdr(Purvdr purvdr) {
        this.purvdr = purvdr;
    }

}
