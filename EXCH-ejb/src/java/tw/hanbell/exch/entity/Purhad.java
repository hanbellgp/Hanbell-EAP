/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.hanbell.exch.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurhadPK purhadPK;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 1)
    @Column(name = "decode")
    private String decode;
    @Column(name = "podate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date podate;
    @Size(max = 8)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 4)
    @Column(name = "coin")
    private String coin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Size(max = 8)
    @Column(name = "termcode")
    private String termcode;
    @Size(max = 90)
    @Column(name = "termcodedsc")
    private String termcodedsc;
    @Size(max = 1)
    @Column(name = "paycom")
    private String paycom;
    @Size(max = 1)
    @Column(name = "paycode")
    private String paycode;
    @Size(max = 90)
    @Column(name = "paycodedsc")
    private String paycodedsc;
    @Size(max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 90)
    @Column(name = "sndcodedsc")
    private String sndcodedsc;
    @Size(max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 1)
    @Column(name = "paysepcode")
    private String paysepcode;
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
    @Size(max = 1)
    @Column(name = "tax")
    private String tax;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Column(name = "poamts")
    private BigDecimal poamts;
    @Column(name = "taxamts")
    private BigDecimal taxamts;
    @Column(name = "totamts")
    private BigDecimal totamts;
    @Size(max = 1)
    @Column(name = "posrc")
    private String posrc;
    @Size(max = 1)
    @Column(name = "hposta")
    private String hposta;
    @Column(name = "prepayamts")
    private BigDecimal prepayamts;
    @Column(name = "aprepayamts")
    private BigDecimal aprepayamts;
    @Column(name = "iprepayamts")
    private BigDecimal iprepayamts;
    @Size(max = 10)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 10)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Column(name = "prtcnt")
    private Short prtcnt;
    @Size(max = 30)
    @Column(name = "queryno")
    private String queryno;
    @Size(max = 1)
    @Column(name = "relyn")
    private String relyn;
    @Size(max = 1)
    @Column(name = "triyn")
    private String triyn;
    @Size(max = 8)
    @Column(name = "trivdrno")
    private String trivdrno;
    @Size(max = 1)
    @Column(name = "tritax")
    private String tritax;
    @Column(name = "tritaxrate")
    private BigDecimal tritaxrate;
    @Size(max = 1)
    @Column(name = "isspin")
    private String isspin;
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
    @Column(name = "n_pretype")
    private String nPretype;
    @Size(max = 1)
    @Column(name = "scmyn")
    private String scmyn;
    @Column(name = "scmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scmdate;
    @Size(max = 8)
    @Column(name = "n_contacter")
    private String nContacter;

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

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
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

    public String getPaycom() {
        return paycom;
    }

    public void setPaycom(String paycom) {
        this.paycom = paycom;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
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

    public String getPaysepcode() {
        return paysepcode;
    }

    public void setPaysepcode(String paysepcode) {
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

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
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

    public String getPosrc() {
        return posrc;
    }

    public void setPosrc(String posrc) {
        this.posrc = posrc;
    }

    public String getHposta() {
        return hposta;
    }

    public void setHposta(String hposta) {
        this.hposta = hposta;
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

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public Short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(Short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public String getQueryno() {
        return queryno;
    }

    public void setQueryno(String queryno) {
        this.queryno = queryno;
    }

    public String getRelyn() {
        return relyn;
    }

    public void setRelyn(String relyn) {
        this.relyn = relyn;
    }

    public String getTriyn() {
        return triyn;
    }

    public void setTriyn(String triyn) {
        this.triyn = triyn;
    }

    public String getTrivdrno() {
        return trivdrno;
    }

    public void setTrivdrno(String trivdrno) {
        this.trivdrno = trivdrno;
    }

    public String getTritax() {
        return tritax;
    }

    public void setTritax(String tritax) {
        this.tritax = tritax;
    }

    public BigDecimal getTritaxrate() {
        return tritaxrate;
    }

    public void setTritaxrate(BigDecimal tritaxrate) {
        this.tritaxrate = tritaxrate;
    }

    public String getIsspin() {
        return isspin;
    }

    public void setIsspin(String isspin) {
        this.isspin = isspin;
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

    public String getNPretype() {
        return nPretype;
    }

    public void setNPretype(String nPretype) {
        this.nPretype = nPretype;
    }

    public String getScmyn() {
        return scmyn;
    }

    public void setScmyn(String scmyn) {
        this.scmyn = scmyn;
    }

    public Date getScmdate() {
        return scmdate;
    }

    public void setScmdate(Date scmdate) {
        this.scmdate = scmdate;
    }

    public String getNContacter() {
        return nContacter;
    }

    public void setNContacter(String nContacter) {
        this.nContacter = nContacter;
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
        if ((this.purhadPK == null && other.purhadPK != null) || (this.purhadPK != null && !this.purhadPK.equals(other.purhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tw.hanbell.exch.entity.Purhad[ purhadPK=" + purhadPK + " ]";
    }

}
