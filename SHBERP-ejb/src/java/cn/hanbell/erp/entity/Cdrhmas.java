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
@Table(name = "cdrhmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrhmas.findAll", query = "SELECT c FROM Cdrhmas c"),
    @NamedQuery(name = "Cdrhmas.findByFacno", query = "SELECT c FROM Cdrhmas c WHERE c.cdrhmasPK.facno = :facno"),
    @NamedQuery(name = "Cdrhmas.findByCdrno", query = "SELECT c FROM Cdrhmas c WHERE c.cdrhmasPK.cdrno = :cdrno"),
    @NamedQuery(name = "Cdrhmas.findByCusno", query = "SELECT c FROM Cdrhmas c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "Cdrhmas.findByCdrcode", query = "SELECT c FROM Cdrhmas c WHERE c.cdrcode = :cdrcode"),
    @NamedQuery(name = "Cdrhmas.findByDepno", query = "SELECT c FROM Cdrhmas c WHERE c.depno = :depno"),
    @NamedQuery(name = "Cdrhmas.findByRecdate", query = "SELECT c FROM Cdrhmas c WHERE c.recdate = :recdate"),
    @NamedQuery(name = "Cdrhmas.findByDecode", query = "SELECT c FROM Cdrhmas c WHERE c.decode = :decode"),
    @NamedQuery(name = "Cdrhmas.findByHrecsta", query = "SELECT c FROM Cdrhmas c WHERE c.hrecsta = :hrecsta"),
    @NamedQuery(name = "Cdrhmas.findByAreacode", query = "SELECT c FROM Cdrhmas c WHERE c.areacode = :areacode"),
    @NamedQuery(name = "Cdrhmas.findByMancode", query = "SELECT c FROM Cdrhmas c WHERE c.mancode = :mancode")
})
public class Cdrhmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrhmasPK cdrhmasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cdrcode")
    private Character cdrcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recdate;
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
    @Column(name = "hrecsta")
    private Character hrecsta;
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
    @Size(max = 18)
    @Column(name = "copyquono")
    private String copyquono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lcsamts")
    private BigDecimal lcsamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ppreamts")
    private BigDecimal ppreamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamts")
    private BigDecimal preamts;
    @Column(name = "ipreamts")
    private BigDecimal ipreamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mpreamts")
    private BigDecimal mpreamts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "tranprno")
    private String tranprno;
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
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Size(max = 18)
    @Column(name = "copycdrno")
    private String copycdrno;
    @Size(max = 20)
    @Column(name = "cuspono")
    private String cuspono;
    @Column(name = "ult_code")
    private Character ultCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoiceyn")
    private Character invoiceyn;
    @Size(max = 20)
    @Column(name = "pino")
    private String pino;
    @Column(name = "piprtcnt")
    private Short piprtcnt;
    @Column(name = "rollkey")
    private Character rollkey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mfgcode")
    private Character mfgcode;
    @Column(name = "spcode")
    private Character spcode;
    @Column(name = "psamts")
    private BigDecimal psamts;
    @Column(name = "msamts")
    private BigDecimal msamts;
    @Column(name = "isspin")
    private Character isspin;
    @Size(max = 18)
    @Column(name = "tocdrno")
    private String tocdrno;
    @Size(max = 18)
    @Column(name = "topono")
    private String topono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pricingtype")
    private String pricingtype;
    @Size(max = 1)
    @Column(name = "isspecial")
    private String isspecial;

    public Cdrhmas() {
        this.prtcnt = (short) 0;
        this.lcsamts = BigDecimal.ZERO;
        this.ppreamts = BigDecimal.ZERO;
        this.preamts = BigDecimal.ZERO;
        this.ipreamts = BigDecimal.ZERO;
        this.mpreamts = BigDecimal.ZERO;
        this.tranprno = "Z";
        this.ultCode = '0';
        this.invoiceyn = 'N';
        this.piprtcnt = (short) 0;
        this.mfgcode = 'N';
        this.spcode = 'N';
        this.psamts = BigDecimal.ZERO;
        this.msamts = BigDecimal.ZERO;
    }

    public Cdrhmas(String facno, String cdrno) {
        this.cdrhmasPK = new CdrhmasPK(facno, cdrno);
        this.prtcnt = (short) 0;
        this.lcsamts = BigDecimal.ZERO;
        this.ppreamts = BigDecimal.ZERO;
        this.preamts = BigDecimal.ZERO;
        this.ipreamts = BigDecimal.ZERO;
        this.mpreamts = BigDecimal.ZERO;
        this.tranprno = "Z";
        this.ultCode = '0';
        this.invoiceyn = 'N';
        this.piprtcnt = (short) 0;
        this.mfgcode = 'N';
        this.spcode = 'N';
        this.psamts = BigDecimal.ZERO;
        this.msamts = BigDecimal.ZERO;
    }

    public CdrhmasPK getCdrhmasPK() {
        return cdrhmasPK;
    }

    public void setCdrhmasPK(CdrhmasPK cdrhmasPK) {
        this.cdrhmasPK = cdrhmasPK;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public Character getCdrcode() {
        return cdrcode;
    }

    public void setCdrcode(Character cdrcode) {
        this.cdrcode = cdrcode;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Date getRecdate() {
        return recdate;
    }

    public void setRecdate(Date recdate) {
        this.recdate = recdate;
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

    public Character getHrecsta() {
        return hrecsta;
    }

    public void setHrecsta(Character hrecsta) {
        this.hrecsta = hrecsta;
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

    public String getCopyquono() {
        return copyquono;
    }

    public void setCopyquono(String copyquono) {
        this.copyquono = copyquono;
    }

    public BigDecimal getLcsamts() {
        return lcsamts;
    }

    public void setLcsamts(BigDecimal lcsamts) {
        this.lcsamts = lcsamts;
    }

    public BigDecimal getPpreamts() {
        return ppreamts;
    }

    public void setPpreamts(BigDecimal ppreamts) {
        this.ppreamts = ppreamts;
    }

    public BigDecimal getPreamts() {
        return preamts;
    }

    public void setPreamts(BigDecimal preamts) {
        this.preamts = preamts;
    }

    public BigDecimal getIpreamts() {
        return ipreamts;
    }

    public void setIpreamts(BigDecimal ipreamts) {
        this.ipreamts = ipreamts;
    }

    public BigDecimal getMpreamts() {
        return mpreamts;
    }

    public void setMpreamts(BigDecimal mpreamts) {
        this.mpreamts = mpreamts;
    }

    public String getTranprno() {
        return tranprno;
    }

    public void setTranprno(String tranprno) {
        this.tranprno = tranprno;
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

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getCopycdrno() {
        return copycdrno;
    }

    public void setCopycdrno(String copycdrno) {
        this.copycdrno = copycdrno;
    }

    public String getCuspono() {
        return cuspono;
    }

    public void setCuspono(String cuspono) {
        this.cuspono = cuspono;
    }

    public Character getUltCode() {
        return ultCode;
    }

    public void setUltCode(Character ultCode) {
        this.ultCode = ultCode;
    }

    public Character getInvoiceyn() {
        return invoiceyn;
    }

    public void setInvoiceyn(Character invoiceyn) {
        this.invoiceyn = invoiceyn;
    }

    public String getPino() {
        return pino;
    }

    public void setPino(String pino) {
        this.pino = pino;
    }

    public Short getPiprtcnt() {
        return piprtcnt;
    }

    public void setPiprtcnt(Short piprtcnt) {
        this.piprtcnt = piprtcnt;
    }

    public Character getRollkey() {
        return rollkey;
    }

    public void setRollkey(Character rollkey) {
        this.rollkey = rollkey;
    }

    public Character getMfgcode() {
        return mfgcode;
    }

    public void setMfgcode(Character mfgcode) {
        this.mfgcode = mfgcode;
    }

    public Character getSpcode() {
        return spcode;
    }

    public void setSpcode(Character spcode) {
        this.spcode = spcode;
    }

    public BigDecimal getPsamts() {
        return psamts;
    }

    public void setPsamts(BigDecimal psamts) {
        this.psamts = psamts;
    }

    public BigDecimal getMsamts() {
        return msamts;
    }

    public void setMsamts(BigDecimal msamts) {
        this.msamts = msamts;
    }

    public Character getIsspin() {
        return isspin;
    }

    public void setIsspin(Character isspin) {
        this.isspin = isspin;
    }

    public String getTocdrno() {
        return tocdrno;
    }

    public void setTocdrno(String tocdrno) {
        this.tocdrno = tocdrno;
    }

    public String getTopono() {
        return topono;
    }

    public void setTopono(String topono) {
        this.topono = topono;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrhmasPK != null ? cdrhmasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrhmas)) {
            return false;
        }
        Cdrhmas other = (Cdrhmas) object;
        if ((this.cdrhmasPK == null && other.cdrhmasPK != null) || (this.cdrhmasPK != null && !this.cdrhmasPK.equals(other.cdrhmasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.Cdrhmas[ cdrhmasPK=" + cdrhmasPK + " ]";
    }

}
