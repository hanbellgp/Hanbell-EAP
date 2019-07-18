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
 * @author C1368
 */
@Entity
@Table(name = "purvdr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purvdr.findAll", query = "SELECT p FROM Purvdr p"),
    @NamedQuery(name = "Purvdr.findById", query = "SELECT p FROM Purvdr p WHERE p.vdrno = :id"),
    @NamedQuery(name = "Purvdr.findByVdrno", query = "SELECT p FROM Purvdr p WHERE p.vdrno = :vdrno"),
    @NamedQuery(name = "Purvdr.findByVdrna", query = "SELECT p FROM Purvdr p WHERE p.vdrna = :vdrna"),
    @NamedQuery(name = "Purvdr.findByVdrds", query = "SELECT p FROM Purvdr p WHERE p.vdrds = :vdrds"),
    @NamedQuery(name = "Purvdr.findByAbccode", query = "SELECT p FROM Purvdr p WHERE p.abccode = :abccode"),
    @NamedQuery(name = "Purvdr.findByDecode", query = "SELECT p FROM Purvdr p WHERE p.decode = :decode"),
    @NamedQuery(name = "Purvdr.findByBoss", query = "SELECT p FROM Purvdr p WHERE p.boss = :boss"),
    @NamedQuery(name = "Purvdr.findByContactman", query = "SELECT p FROM Purvdr p WHERE p.contactman = :contactman"),
    @NamedQuery(name = "Purvdr.findByAddress", query = "SELECT p FROM Purvdr p WHERE p.address = :address"),
    @NamedQuery(name = "Purvdr.findByUniform", query = "SELECT p FROM Purvdr p WHERE p.uniform = :uniform"),
    @NamedQuery(name = "Purvdr.findByCoin", query = "SELECT p FROM Purvdr p WHERE p.coin = :coin"),
    @NamedQuery(name = "Purvdr.findByTel1", query = "SELECT p FROM Purvdr p WHERE p.tel1 = :tel1"),
    @NamedQuery(name = "Purvdr.findByTel2", query = "SELECT p FROM Purvdr p WHERE p.tel2 = :tel2"),
    @NamedQuery(name = "Purvdr.findByFax1", query = "SELECT p FROM Purvdr p WHERE p.fax1 = :fax1"),
    @NamedQuery(name = "Purvdr.findByFax2", query = "SELECT p FROM Purvdr p WHERE p.fax2 = :fax2"),
    @NamedQuery(name = "Purvdr.findByZonenum", query = "SELECT p FROM Purvdr p WHERE p.zonenum = :zonenum"),
    @NamedQuery(name = "Purvdr.findByWebsite", query = "SELECT p FROM Purvdr p WHERE p.website = :website"),
    @NamedQuery(name = "Purvdr.findByTax", query = "SELECT p FROM Purvdr p WHERE p.tax = :tax"),
    @NamedQuery(name = "Purvdr.findByPaycom", query = "SELECT p FROM Purvdr p WHERE p.paycom = :paycom"),
    @NamedQuery(name = "Purvdr.findByPaycode", query = "SELECT p FROM Purvdr p WHERE p.paycode = :paycode"),
    @NamedQuery(name = "Purvdr.findByPaysepcode", query = "SELECT p FROM Purvdr p WHERE p.paysepcode = :paysepcode"),
    @NamedQuery(name = "Purvdr.findBySeldate1", query = "SELECT p FROM Purvdr p WHERE p.seldate1 = :seldate1"),
    @NamedQuery(name = "Purvdr.findBySeldate2", query = "SELECT p FROM Purvdr p WHERE p.seldate2 = :seldate2"),
    @NamedQuery(name = "Purvdr.findBySeldate3", query = "SELECT p FROM Purvdr p WHERE p.seldate3 = :seldate3"),
    @NamedQuery(name = "Purvdr.findBySeldate4", query = "SELECT p FROM Purvdr p WHERE p.seldate4 = :seldate4"),
    @NamedQuery(name = "Purvdr.findByHandays1", query = "SELECT p FROM Purvdr p WHERE p.handays1 = :handays1"),
    @NamedQuery(name = "Purvdr.findByHandays2", query = "SELECT p FROM Purvdr p WHERE p.handays2 = :handays2"),
    @NamedQuery(name = "Purvdr.findByHandays3", query = "SELECT p FROM Purvdr p WHERE p.handays3 = :handays3"),
    @NamedQuery(name = "Purvdr.findByHandays4", query = "SELECT p FROM Purvdr p WHERE p.handays4 = :handays4"),
    @NamedQuery(name = "Purvdr.findByTickdays", query = "SELECT p FROM Purvdr p WHERE p.tickdays = :tickdays"),
    @NamedQuery(name = "Purvdr.findByTtbankno", query = "SELECT p FROM Purvdr p WHERE p.ttbankno = :ttbankno"),
    @NamedQuery(name = "Purvdr.findByTtbankna", query = "SELECT p FROM Purvdr p WHERE p.ttbankna = :ttbankna"),
    @NamedQuery(name = "Purvdr.findByTtbanknum", query = "SELECT p FROM Purvdr p WHERE p.ttbanknum = :ttbanknum"),
    @NamedQuery(name = "Purvdr.findByTtname", query = "SELECT p FROM Purvdr p WHERE p.ttname = :ttname"),
    @NamedQuery(name = "Purvdr.findByPurkind", query = "SELECT p FROM Purvdr p WHERE p.purkind = :purkind"),
    @NamedQuery(name = "Purvdr.findByVdrsta", query = "SELECT p FROM Purvdr p WHERE p.vdrsta = :vdrsta"),
    @NamedQuery(name = "Purvdr.findByAreacode", query = "SELECT p FROM Purvdr p WHERE p.areacode = :areacode"),
    @NamedQuery(name = "Purvdr.findByTermcode", query = "SELECT p FROM Purvdr p WHERE p.termcode = :termcode"),
    @NamedQuery(name = "Purvdr.findBySndcode", query = "SELECT p FROM Purvdr p WHERE p.sndcode = :sndcode"),
    @NamedQuery(name = "Purvdr.findByCuycode", query = "SELECT p FROM Purvdr p WHERE p.cuycode = :cuycode"),
    @NamedQuery(name = "Purvdr.findByCapamt", query = "SELECT p FROM Purvdr p WHERE p.capamt = :capamt"),
    @NamedQuery(name = "Purvdr.findByYeramt", query = "SELECT p FROM Purvdr p WHERE p.yeramt = :yeramt"),
    @NamedQuery(name = "Purvdr.findByBegdate", query = "SELECT p FROM Purvdr p WHERE p.begdate = :begdate"),
    @NamedQuery(name = "Purvdr.findByLatdate", query = "SELECT p FROM Purvdr p WHERE p.latdate = :latdate"),
    @NamedQuery(name = "Purvdr.findByMark1", query = "SELECT p FROM Purvdr p WHERE p.mark1 = :mark1"),
    @NamedQuery(name = "Purvdr.findByTitle", query = "SELECT p FROM Purvdr p WHERE p.title = :title"),
    @NamedQuery(name = "Purvdr.findByTaxrate", query = "SELECT p FROM Purvdr p WHERE p.taxrate = :taxrate"),
    @NamedQuery(name = "Purvdr.findByBilcategory", query = "SELECT p FROM Purvdr p WHERE p.bilcategory = :bilcategory"),
    @NamedQuery(name = "Purvdr.findByVdrdse", query = "SELECT p FROM Purvdr p WHERE p.vdrdse = :vdrdse"),
    @NamedQuery(name = "Purvdr.findByShr", query = "SELECT p FROM Purvdr p WHERE p.shr = :shr"),
    @NamedQuery(name = "Purvdr.findByShzt", query = "SELECT p FROM Purvdr p WHERE p.shzt = :shzt"),
    @NamedQuery(name = "Purvdr.findByTtinfomode", query = "SELECT p FROM Purvdr p WHERE p.ttinfomode = :ttinfomode"),
    @NamedQuery(name = "Purvdr.findByTtinfocont", query = "SELECT p FROM Purvdr p WHERE p.ttinfocont = :ttinfocont"),
    @NamedQuery(name = "Purvdr.findByFkfs", query = "SELECT p FROM Purvdr p WHERE p.fkfs = :fkfs")})
public class Purvdr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vdrna")
    private String vdrna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vdrds")
    private String vdrds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abccode")
    private Character abccode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decode")
    private Character decode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "boss")
    private String boss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contactman")
    private String contactman;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "uniform")
    private String uniform;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 20)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 20)
    @Column(name = "fax1")
    private String fax1;
    @Size(max = 20)
    @Column(name = "fax2")
    private String fax2;
    @Size(max = 10)
    @Column(name = "zonenum")
    private String zonenum;
    @Size(max = 40)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tax")
    private String tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycom")
    private Character paycom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycode")
    private Character paycode;
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "ttbankno")
    private String ttbankno;
    @Size(max = 40)
    @Column(name = "ttbankna")
    private String ttbankna;
    @Size(max = 25)
    @Column(name = "ttbanknum")
    private String ttbanknum;
    @Size(max = 40)
    @Column(name = "ttname")
    private String ttname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "purkind")
    private String purkind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vdrsta")
    private Character vdrsta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areacode")
    private String areacode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "termcode")
    private String termcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cuycode")
    private String cuycode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capamt")
    private BigDecimal capamt;
    @Column(name = "yeramt")
    private BigDecimal yeramt;
    @Column(name = "begdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date begdate;
    @Column(name = "latdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latdate;
    @Size(max = 30)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 60)
    @Column(name = "title")
    private String title;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 18)
    @Column(name = "bilcategory")
    private String bilcategory;
    @Size(max = 60)
    @Column(name = "vdrdse")
    private String vdrdse;
    @Size(max = 8)
    @Column(name = "shr")
    private String shr;
    @Size(max = 8)
    @Column(name = "shzt")
    private String shzt;
    @Column(name = "ttinfomode")
    private Character ttinfomode;
    @Column(name = "ttinfocont")
    private Short ttinfocont;
    @Size(max = 800)
    @Column(name = "fkfs")
    private String fkfs;

    public Purvdr() {
        this.shr="mis";
        this.shzt = "Y";
    }

    public Purvdr(String vdrno) {
        this.vdrno = vdrno;
    }

    public Purvdr(String vdrno, String vdrna, String vdrds, Character abccode, Character decode, String boss, String contactman, String address, String uniform, String coin, String tel1, String tax, Character paycom, Character paycode, Character paysepcode, String purkind, Character vdrsta, String areacode, String termcode, String sndcode, String cuycode) {
        this.vdrno = vdrno;
        this.vdrna = vdrna;
        this.vdrds = vdrds;
        this.abccode = abccode;
        this.decode = decode;
        this.boss = boss;
        this.contactman = contactman;
        this.address = address;
        this.uniform = uniform;
        this.coin = coin;
        this.tel1 = tel1;
        this.tax = tax;
        this.paycom = paycom;
        this.paycode = paycode;
        this.paysepcode = paysepcode;
        this.purkind = purkind;
        this.vdrsta = vdrsta;
        this.areacode = areacode;
        this.termcode = termcode;
        this.sndcode = sndcode;
        this.cuycode = cuycode;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
    }

    public Character getAbccode() {
        return abccode;
    }

    public void setAbccode(Character abccode) {
        this.abccode = abccode;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getZonenum() {
        return zonenum;
    }

    public void setZonenum(String zonenum) {
        this.zonenum = zonenum;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
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

    public String getTtbankno() {
        return ttbankno;
    }

    public void setTtbankno(String ttbankno) {
        this.ttbankno = ttbankno;
    }

    public String getTtbankna() {
        return ttbankna;
    }

    public void setTtbankna(String ttbankna) {
        this.ttbankna = ttbankna;
    }

    public String getTtbanknum() {
        return ttbanknum;
    }

    public void setTtbanknum(String ttbanknum) {
        this.ttbanknum = ttbanknum;
    }

    public String getTtname() {
        return ttname;
    }

    public void setTtname(String ttname) {
        this.ttname = ttname;
    }

    public String getPurkind() {
        return purkind;
    }

    public void setPurkind(String purkind) {
        this.purkind = purkind;
    }

    public Character getVdrsta() {
        return vdrsta;
    }

    public void setVdrsta(Character vdrsta) {
        this.vdrsta = vdrsta;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public String getCuycode() {
        return cuycode;
    }

    public void setCuycode(String cuycode) {
        this.cuycode = cuycode;
    }

    public BigDecimal getCapamt() {
        return capamt;
    }

    public void setCapamt(BigDecimal capamt) {
        this.capamt = capamt;
    }

    public BigDecimal getYeramt() {
        return yeramt;
    }

    public void setYeramt(BigDecimal yeramt) {
        this.yeramt = yeramt;
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

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getVdrdse() {
        return vdrdse;
    }

    public void setVdrdse(String vdrdse) {
        this.vdrdse = vdrdse;
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

    public Character getTtinfomode() {
        return ttinfomode;
    }

    public void setTtinfomode(Character ttinfomode) {
        this.ttinfomode = ttinfomode;
    }

    public Short getTtinfocont() {
        return ttinfocont;
    }

    public void setTtinfocont(Short ttinfocont) {
        this.ttinfocont = ttinfocont;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vdrno != null ? vdrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purvdr)) {
            return false;
        }
        Purvdr other = (Purvdr) object;
        if ((this.vdrno == null && other.vdrno != null) || (this.vdrno != null && !this.vdrno.equals(other.vdrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purvdr[ vdrno=" + vdrno + " ]";
    }
    
}
