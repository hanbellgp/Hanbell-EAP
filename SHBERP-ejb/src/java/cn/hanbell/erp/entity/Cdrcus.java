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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cdrcus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrcus.findAll", query = "SELECT c FROM Cdrcus c"),
    @NamedQuery(name = "Cdrcus.findById", query = "SELECT c FROM Cdrcus c WHERE c.cusno = :id"),
    @NamedQuery(name = "Cdrcus.findByCusno", query = "SELECT c FROM Cdrcus c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "Cdrcus.findByCusna", query = "SELECT c FROM Cdrcus c WHERE c.cusna = :cusna"),
    @NamedQuery(name = "Cdrcus.findByCusds", query = "SELECT c FROM Cdrcus c WHERE c.cusds = :cusds"),
    @NamedQuery(name = "Cdrcus.findByCussta", query = "SELECT c FROM Cdrcus c WHERE c.cussta = :cussta"),
    @NamedQuery(name = "Cdrcus.findByDecode", query = "SELECT c FROM Cdrcus c WHERE c.decode = :decode"),
    @NamedQuery(name = "Cdrcus.findByCuskind", query = "SELECT c FROM Cdrcus c WHERE c.cuskind = :cuskind")})
public class Cdrcus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cusna")
    private String cusna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 60)
    @Column(name = "cusdse")
    private String cusdse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cussta")//默认2
    private Character cussta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decode")//国内外码
    private Character decode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cuskind")
    private String cuskind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dmcode")
    private Character dmcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "address1")
    private String address1;
    @Size(max = 40)
    @Column(name = "address2")
    private String address2;
    @Size(max = 40)
    @Column(name = "address3")
    private String address3;
    @Size(max = 40)
    @Column(name = "address4")
    private String address4;
    @Size(max = 40)
    @Column(name = "address5")
    private String address5;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "uniform")
    private String uniform;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "bilnum")
    private String bilnum;
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
    @Column(name = "shptrseq")//Default:1
    private short shptrseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivotrseq")//Default:1
    private short ivotrseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sndcode")//Default:"001"
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
    @Column(name = "paysepcode")//Default:'1'
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
    @Size(max = 30)
    @Column(name = "boss")
    private String boss;
    @Size(max = 30)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 20)
    @Column(name = "tel1")
    private String tel1;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Size(max = 10)
    @Column(name = "zonenum")
    private String zonenum;
    @Column(name = "mchdate")
    private Short mchdate;
    @Size(max = 8)
    @Column(name = "cusgroup")
    private String cusgroup;
    @Column(name = "begdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date begdate;
    @Column(name = "latdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latdate;
    @Column(name = "capamt")
    private Long capamt;
    @Column(name = "yearamt")
    private Long yearamt;
    @Size(max = 8)
    @Column(name = "destarea")
    private String destarea;
    @Size(max = 8)
    @Column(name = "agentfacno")
    private String agentfacno;
    @Size(max = 8)
    @Column(name = "portfacno")
    private String portfacno;
    @Size(max = 8)
    @Column(name = "loadport")
    private String loadport;
    @Size(max = 8)
    @Column(name = "discport")
    private String discport;
    @Size(max = 8)
    @Column(name = "checkfacno")
    private String checkfacno;
    @Size(max = 8)
    @Column(name = "shipfacno")
    private String shipfacno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "commrate")
    private BigDecimal commrate;
    @Size(max = 8)
    @Column(name = "markno")
    private String markno;
    @Size(max = 30)
    @Column(name = "mark1")
    private String mark1;
    @Column(name = "mapbilyn")
    private Character mapbilyn;
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
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 18)
    @Column(name = "bilcategory")
    private String bilcategory;
    @Size(max = 8)
    @Column(name = "opbankno")
    private String opbankno;
    @Size(max = 40)
    @Column(name = "opbankna")
    private String opbankna;
    @Size(max = 25)
    @Column(name = "opbanknum")
    private String opbanknum;
    @Column(name = "prnyn")
    private Character prnyn;
    @Size(max = 12)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 60)
    @Column(name = "cusbakna")
    private String cusbakna;
    @Size(max = 30)
    @Column(name = "cusacctno")
    private String cusacctno;
    @Size(max = 100)
    @Column(name = "mark2")
    private String mark2;
    @Size(max = 10)
    @Column(name = "shr")
    private String shr;
    @Size(max = 2)
    @Column(name = "shzt")
    private String shzt;
    @Column(name = "incprerec")
    private Character incprerec;
    @Size(max = 30)
    @Column(name = "cusnaprt")
    private String cusnaprt;
    @Column(name = "fenyn")
    private Character fenyn;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 400)
    @Column(name = "email")
    private String email;
    @Size(max = 400)
    @Column(name = "skfs")
    private String skfs;

    public Cdrcus() {
        this.decode = '1';
        this.cussta = '2';
        this.paysepcode = '1';
        this.tickdays = ((short) 0);
        this.shptrseq = 1;
        this.ivotrseq = 1;
    }

    public Cdrcus(String cusno) {
        this.cusno = cusno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getCusdse() {
        return cusdse;
    }

    public void setCusdse(String cusdse) {
        this.cusdse = cusdse;
    }

    public Character getCussta() {
        return cussta;
    }

    public void setCussta(Character cussta) {
        this.cussta = cussta;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public String getCuskind() {
        return cuskind;
    }

    public void setCuskind(String cuskind) {
        this.cuskind = cuskind;
    }

    public Character getDmcode() {
        return dmcode;
    }

    public void setDmcode(Character dmcode) {
        this.dmcode = dmcode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getBilnum() {
        return bilnum;
    }

    public void setBilnum(String bilnum) {
        this.bilnum = bilnum;
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

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZonenum() {
        return zonenum;
    }

    public void setZonenum(String zonenum) {
        this.zonenum = zonenum;
    }

    public Short getMchdate() {
        return mchdate;
    }

    public void setMchdate(Short mchdate) {
        this.mchdate = mchdate;
    }

    public String getCusgroup() {
        return cusgroup;
    }

    public void setCusgroup(String cusgroup) {
        this.cusgroup = cusgroup;
    }

    public Date getBegdate() {
        return begdate;
    }

    public void setBegdate(Date begdate) {
        this.begdate = begdate;
    }

    public Date getLatdate() {
        return latdate;
    }

    public void setLatdate(Date latdate) {
        this.latdate = latdate;
    }

    public Long getCapamt() {
        return capamt;
    }

    public void setCapamt(Long capamt) {
        this.capamt = capamt;
    }

    public Long getYearamt() {
        return yearamt;
    }

    public void setYearamt(Long yearamt) {
        this.yearamt = yearamt;
    }

    public String getDestarea() {
        return destarea;
    }

    public void setDestarea(String destarea) {
        this.destarea = destarea;
    }

    public String getAgentfacno() {
        return agentfacno;
    }

    public void setAgentfacno(String agentfacno) {
        this.agentfacno = agentfacno;
    }

    public String getPortfacno() {
        return portfacno;
    }

    public void setPortfacno(String portfacno) {
        this.portfacno = portfacno;
    }

    public String getLoadport() {
        return loadport;
    }

    public void setLoadport(String loadport) {
        this.loadport = loadport;
    }

    public String getDiscport() {
        return discport;
    }

    public void setDiscport(String discport) {
        this.discport = discport;
    }

    public String getCheckfacno() {
        return checkfacno;
    }

    public void setCheckfacno(String checkfacno) {
        this.checkfacno = checkfacno;
    }

    public String getShipfacno() {
        return shipfacno;
    }

    public void setShipfacno(String shipfacno) {
        this.shipfacno = shipfacno;
    }

    public BigDecimal getCommrate() {
        return commrate;
    }

    public void setCommrate(BigDecimal commrate) {
        this.commrate = commrate;
    }

    public String getMarkno() {
        return markno;
    }

    public void setMarkno(String markno) {
        this.markno = markno;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public Character getMapbilyn() {
        return mapbilyn;
    }

    public void setMapbilyn(Character mapbilyn) {
        this.mapbilyn = mapbilyn;
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

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getBilcategory() {
        return bilcategory;
    }

    public void setBilcategory(String bilcategory) {
        this.bilcategory = bilcategory;
    }

    public String getOpbankno() {
        return opbankno;
    }

    public void setOpbankno(String opbankno) {
        this.opbankno = opbankno;
    }

    public String getOpbankna() {
        return opbankna;
    }

    public void setOpbankna(String opbankna) {
        this.opbankna = opbankna;
    }

    public String getOpbanknum() {
        return opbanknum;
    }

    public void setOpbanknum(String opbanknum) {
        this.opbanknum = opbanknum;
    }

    public Character getPrnyn() {
        return prnyn;
    }

    public void setPrnyn(Character prnyn) {
        this.prnyn = prnyn;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getCusbakna() {
        return cusbakna;
    }

    public void setCusbakna(String cusbakna) {
        this.cusbakna = cusbakna;
    }

    public String getCusacctno() {
        return cusacctno;
    }

    public void setCusacctno(String cusacctno) {
        this.cusacctno = cusacctno;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    public Character getIncprerec() {
        return incprerec;
    }

    public void setIncprerec(Character incprerec) {
        this.incprerec = incprerec;
    }

    public String getCusnaprt() {
        return cusnaprt;
    }

    public void setCusnaprt(String cusnaprt) {
        this.cusnaprt = cusnaprt;
    }

    public Character getFenyn() {
        return fenyn;
    }

    public void setFenyn(Character fenyn) {
        this.fenyn = fenyn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkfs() {
        return skfs;
    }

    public void setSkfs(String skfs) {
        this.skfs = skfs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusno != null ? cusno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrcus)) {
            return false;
        }
        Cdrcus other = (Cdrcus) object;
        if ((this.cusno == null && other.cusno != null) || (this.cusno != null && !this.cusno.equals(other.cusno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cusno;
    }

}
