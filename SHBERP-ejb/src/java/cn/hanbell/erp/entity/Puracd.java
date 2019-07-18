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
@Table(name = "puracd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puracd.findAll", query = "SELECT p FROM Puracd p"),
    @NamedQuery(name = "Puracd.findByFacno", query = "SELECT p FROM Puracd p WHERE p.puracdPK.facno = :facno"),
    @NamedQuery(name = "Puracd.findByProno", query = "SELECT p FROM Puracd p WHERE p.puracdPK.prono = :prono"),
    @NamedQuery(name = "Puracd.findByAcceptno", query = "SELECT p FROM Puracd p WHERE p.puracdPK.acceptno = :acceptno"),
    @NamedQuery(name = "Puracd.findByAcceptnoAndItnbr", query = "SELECT p FROM Puracd p WHERE p.puracdPK.acceptno = :acceptno AND p.itnbr = :itnbr"),
    @NamedQuery(name = "Puracd.findByPK", query = "SELECT p FROM Puracd p WHERE p.puracdPK.facno = :facno AND p.puracdPK.prono = :prono AND p.puracdPK.acceptno = :acceptno AND p.puracdPK.trseq = :trseq"),
    @NamedQuery(name = "Puracd.findByVdrno", query = "SELECT p FROM Puracd p WHERE p.vdrno = :vdrno")})
public class Puracd implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuracdPK puracdPK;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acceptdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptdate;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "pono")
    private String pono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ponotrseq")
    private short ponotrseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "batno")
    private short batno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "purtrtype")
    private String purtrtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deeadays")
    private short deeadays;
    @Column(name = "askdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdate;
    @Column(name = "dirrvyn")
    private Character dirrvyn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "accqy1")
    private BigDecimal accqy1;
    @Column(name = "accqy2")
    private BigDecimal accqy2;
    @Column(name = "recivedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recivedate;
    @Column(name = "okqy1")
    private BigDecimal okqy1;
    @Column(name = "okqy2")
    private BigDecimal okqy2;
    @Column(name = "badqy1")
    private BigDecimal badqy1;
    @Column(name = "badqy2")
    private BigDecimal badqy2;
    @Column(name = "defqy1")
    private BigDecimal defqy1;
    @Column(name = "defqy2")
    private BigDecimal defqy2;
    @Column(name = "stqy1")
    private BigDecimal stqy1;
    @Column(name = "stqy2")
    private BigDecimal stqy2;
    @Column(name = "adqy1")
    private BigDecimal adqy1;
    @Column(name = "adqy2")
    private BigDecimal adqy2;
    @Column(name = "payqy")
    private BigDecimal payqy;
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
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private Character tax;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxamts")
    private BigDecimal taxamts;
    @Column(name = "tramts")
    private BigDecimal tramts;
    @Column(name = "totamts")
    private BigDecimal totamts;
    @Column(name = "taxamt")
    private BigDecimal taxamt;
    @Column(name = "tramt")
    private BigDecimal tramt;
    @Column(name = "totamt")
    private BigDecimal totamt;
    @Size(max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 12)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 18)
    @Column(name = "varnr")
    private String varnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "plnrcode")
    private String plnrcode;
    @Column(name = "accsta")
    private Character accsta;
    @Column(name = "chkcode")
    private Character chkcode;
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
    @Column(name = "recuserno")
    private String recuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Size(max = 10)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 10)
    @Column(name = "dmark2")
    private String dmark2;
    @Column(name = "prtcnt")
    private Short prtcnt;
    @Column(name = "rvprtcnt")
    private Short rvprtcnt;
    @Size(max = 8)
    @Column(name = "trivdrno")
    private String trivdrno;
    @Column(name = "triunpris")
    private BigDecimal triunpris;
    @Column(name = "tritax")
    private Character tritax;
    @Column(name = "tritaxrate")
    private BigDecimal tritaxrate;
    @Column(name = "tritaxamts")
    private BigDecimal tritaxamts;
    @Column(name = "tritramts")
    private BigDecimal tritramts;
    @Column(name = "tritotamts")
    private BigDecimal tritotamts;
    @Column(name = "tritaxamt")
    private BigDecimal tritaxamt;
    @Column(name = "tritramt")
    private BigDecimal tritramt;
    @Column(name = "tritotamt")
    private BigDecimal tritotamt;
    @Column(name = "po_status")
    private Character poStatus;
    @Column(name = "asrs_qty")
    private BigDecimal asrsQty;
    @Size(max = 20)
    @Column(name = "asrs_user")
    private String asrsUser;
    @Size(max = 60)
    @Column(name = "asrs_dmark")
    private String asrsDmark;
    @Column(name = "asrs_sta")
    private Integer asrsSta;
    @Column(name = "badtype")
    private Character badtype;
    @Column(name = "schseq")
    private Short schseq;
    @Size(max = 18)
    @Column(name = "stno")
    private String stno;
    @Column(name = "sttrseq")
    private Integer sttrseq;

    public Puracd() {
    }

    public Puracd(PuracdPK puracdPK) {
        this.puracdPK = puracdPK;
    }

    public Puracd(PuracdPK puracdPK, Date acceptdate, String pono, short ponotrseq, String itnbr, short batno, String purtrtype, short deeadays, String coin, BigDecimal ratio, BigDecimal unpris, Character tax, BigDecimal taxamts, String plnrcode, Date indate, String userno) {
        this.puracdPK = puracdPK;
        this.acceptdate = acceptdate;
        this.pono = pono;
        this.ponotrseq = ponotrseq;
        this.itnbr = itnbr;
        this.batno = batno;
        this.purtrtype = purtrtype;
        this.deeadays = deeadays;
        this.coin = coin;
        this.ratio = ratio;
        this.unpris = unpris;
        this.tax = tax;
        this.taxamts = taxamts;
        this.plnrcode = plnrcode;
        this.indate = indate;
        this.userno = userno;
    }

    public Puracd(String facno, String prono, String acceptno, short trseq) {
        this.puracdPK = new PuracdPK(facno, prono, acceptno, trseq);
    }

    public PuracdPK getPuracdPK() {
        return puracdPK;
    }

    public void setPuracdPK(PuracdPK puracdPK) {
        this.puracdPK = puracdPK;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public short getPonotrseq() {
        return ponotrseq;
    }

    public void setPonotrseq(short ponotrseq) {
        this.ponotrseq = ponotrseq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public short getBatno() {
        return batno;
    }

    public void setBatno(short batno) {
        this.batno = batno;
    }

    public String getPurtrtype() {
        return purtrtype;
    }

    public void setPurtrtype(String purtrtype) {
        this.purtrtype = purtrtype;
    }

    public short getDeeadays() {
        return deeadays;
    }

    public void setDeeadays(short deeadays) {
        this.deeadays = deeadays;
    }

    public Date getAskdate() {
        return askdate;
    }

    public void setAskdate(Date askdate) {
        this.askdate = askdate;
    }

    public Character getDirrvyn() {
        return dirrvyn;
    }

    public void setDirrvyn(Character dirrvyn) {
        this.dirrvyn = dirrvyn;
    }

    public BigDecimal getAccqy1() {
        return accqy1;
    }

    public void setAccqy1(BigDecimal accqy1) {
        this.accqy1 = accqy1;
    }

    public BigDecimal getAccqy2() {
        return accqy2;
    }

    public void setAccqy2(BigDecimal accqy2) {
        this.accqy2 = accqy2;
    }

    public Date getRecivedate() {
        return recivedate;
    }

    public void setRecivedate(Date recivedate) {
        this.recivedate = recivedate;
    }

    public BigDecimal getOkqy1() {
        return okqy1;
    }

    public void setOkqy1(BigDecimal okqy1) {
        this.okqy1 = okqy1;
    }

    public BigDecimal getOkqy2() {
        return okqy2;
    }

    public void setOkqy2(BigDecimal okqy2) {
        this.okqy2 = okqy2;
    }

    public BigDecimal getBadqy1() {
        return badqy1;
    }

    public void setBadqy1(BigDecimal badqy1) {
        this.badqy1 = badqy1;
    }

    public BigDecimal getBadqy2() {
        return badqy2;
    }

    public void setBadqy2(BigDecimal badqy2) {
        this.badqy2 = badqy2;
    }

    public BigDecimal getDefqy1() {
        return defqy1;
    }

    public void setDefqy1(BigDecimal defqy1) {
        this.defqy1 = defqy1;
    }

    public BigDecimal getDefqy2() {
        return defqy2;
    }

    public void setDefqy2(BigDecimal defqy2) {
        this.defqy2 = defqy2;
    }

    public BigDecimal getStqy1() {
        return stqy1;
    }

    public void setStqy1(BigDecimal stqy1) {
        this.stqy1 = stqy1;
    }

    public BigDecimal getStqy2() {
        return stqy2;
    }

    public void setStqy2(BigDecimal stqy2) {
        this.stqy2 = stqy2;
    }

    public BigDecimal getAdqy1() {
        return adqy1;
    }

    public void setAdqy1(BigDecimal adqy1) {
        this.adqy1 = adqy1;
    }

    public BigDecimal getAdqy2() {
        return adqy2;
    }

    public void setAdqy2(BigDecimal adqy2) {
        this.adqy2 = adqy2;
    }

    public BigDecimal getPayqy() {
        return payqy;
    }

    public void setPayqy(BigDecimal payqy) {
        this.payqy = payqy;
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

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
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

    public BigDecimal getTaxamts() {
        return taxamts;
    }

    public void setTaxamts(BigDecimal taxamts) {
        this.taxamts = taxamts;
    }

    public BigDecimal getTramts() {
        return tramts;
    }

    public void setTramts(BigDecimal tramts) {
        this.tramts = tramts;
    }

    public BigDecimal getTotamts() {
        return totamts;
    }

    public void setTotamts(BigDecimal totamts) {
        this.totamts = totamts;
    }

    public BigDecimal getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigDecimal taxamt) {
        this.taxamt = taxamt;
    }

    public BigDecimal getTramt() {
        return tramt;
    }

    public void setTramt(BigDecimal tramt) {
        this.tramt = tramt;
    }

    public BigDecimal getTotamt() {
        return totamt;
    }

    public void setTotamt(BigDecimal totamt) {
        this.totamt = totamt;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getPlnrcode() {
        return plnrcode;
    }

    public void setPlnrcode(String plnrcode) {
        this.plnrcode = plnrcode;
    }

    public Character getAccsta() {
        return accsta;
    }

    public void setAccsta(Character accsta) {
        this.accsta = accsta;
    }

    public Character getChkcode() {
        return chkcode;
    }

    public void setChkcode(Character chkcode) {
        this.chkcode = chkcode;
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

    public String getRecuserno() {
        return recuserno;
    }

    public void setRecuserno(String recuserno) {
        this.recuserno = recuserno;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
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

    public Short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(Short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public Short getRvprtcnt() {
        return rvprtcnt;
    }

    public void setRvprtcnt(Short rvprtcnt) {
        this.rvprtcnt = rvprtcnt;
    }

    public String getTrivdrno() {
        return trivdrno;
    }

    public void setTrivdrno(String trivdrno) {
        this.trivdrno = trivdrno;
    }

    public BigDecimal getTriunpris() {
        return triunpris;
    }

    public void setTriunpris(BigDecimal triunpris) {
        this.triunpris = triunpris;
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

    public BigDecimal getTritaxamts() {
        return tritaxamts;
    }

    public void setTritaxamts(BigDecimal tritaxamts) {
        this.tritaxamts = tritaxamts;
    }

    public BigDecimal getTritramts() {
        return tritramts;
    }

    public void setTritramts(BigDecimal tritramts) {
        this.tritramts = tritramts;
    }

    public BigDecimal getTritotamts() {
        return tritotamts;
    }

    public void setTritotamts(BigDecimal tritotamts) {
        this.tritotamts = tritotamts;
    }

    public BigDecimal getTritaxamt() {
        return tritaxamt;
    }

    public void setTritaxamt(BigDecimal tritaxamt) {
        this.tritaxamt = tritaxamt;
    }

    public BigDecimal getTritramt() {
        return tritramt;
    }

    public void setTritramt(BigDecimal tritramt) {
        this.tritramt = tritramt;
    }

    public BigDecimal getTritotamt() {
        return tritotamt;
    }

    public void setTritotamt(BigDecimal tritotamt) {
        this.tritotamt = tritotamt;
    }

    public Character getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(Character poStatus) {
        this.poStatus = poStatus;
    }

    public BigDecimal getAsrsQty() {
        return asrsQty;
    }

    public void setAsrsQty(BigDecimal asrsQty) {
        this.asrsQty = asrsQty;
    }

    public String getAsrsUser() {
        return asrsUser;
    }

    public void setAsrsUser(String asrsUser) {
        this.asrsUser = asrsUser;
    }

    public String getAsrsDmark() {
        return asrsDmark;
    }

    public void setAsrsDmark(String asrsDmark) {
        this.asrsDmark = asrsDmark;
    }

    public Integer getAsrsSta() {
        return asrsSta;
    }

    public void setAsrsSta(Integer asrsSta) {
        this.asrsSta = asrsSta;
    }

    public Character getBadtype() {
        return badtype;
    }

    public void setBadtype(Character badtype) {
        this.badtype = badtype;
    }

    public Short getSchseq() {
        return schseq;
    }

    public void setSchseq(Short schseq) {
        this.schseq = schseq;
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }

    public Integer getSttrseq() {
        return sttrseq;
    }

    public void setSttrseq(Integer sttrseq) {
        this.sttrseq = sttrseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puracdPK != null ? puracdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puracd)) {
            return false;
        }
        Puracd other = (Puracd) object;
        if ((this.puracdPK == null && other.puracdPK != null) || (this.puracdPK != null && !this.puracdPK.equals(other.puracdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Puracd[ puracdPK=" + puracdPK + " ]";
    }

}
