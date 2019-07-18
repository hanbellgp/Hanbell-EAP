/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
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
@Table(name = "HK_CG016")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG016.findAll", query = "SELECT h FROM HKCG016 h")
    ,
    @NamedQuery(name = "HKCG016.findByTtbankna", query = "SELECT h FROM HKCG016 h WHERE h.ttbankna = :ttbankna")
    ,
    @NamedQuery(name = "HKCG016.findByVdrdse", query = "SELECT h FROM HKCG016 h WHERE h.vdrdse = :vdrdse")
    ,
    @NamedQuery(name = "HKCG016.findByTtname", query = "SELECT h FROM HKCG016 h WHERE h.ttname = :ttname")
    ,
    @NamedQuery(name = "HKCG016.findByVdrna", query = "SELECT h FROM HKCG016 h WHERE h.vdrna = :vdrna")
    ,
    @NamedQuery(name = "HKCG016.findBySerialNumber", query = "SELECT h FROM HKCG016 h WHERE h.serialNumber = :serialNumber")
    ,
    @NamedQuery(name = "HKCG016.findByTel1", query = "SELECT h FROM HKCG016 h WHERE h.tel1 = :tel1")
    ,
    @NamedQuery(name = "HKCG016.findByTel2", query = "SELECT h FROM HKCG016 h WHERE h.tel2 = :tel2")
    ,
    @NamedQuery(name = "HKCG016.findByTtbankno", query = "SELECT h FROM HKCG016 h WHERE h.ttbankno = :ttbankno")
    ,
    @NamedQuery(name = "HKCG016.findByZonenum", query = "SELECT h FROM HKCG016 h WHERE h.zonenum = :zonenum")
    ,
    @NamedQuery(name = "HKCG016.findByLatdate", query = "SELECT h FROM HKCG016 h WHERE h.latdate = :latdate")
    ,
    @NamedQuery(name = "HKCG016.findBySndcode", query = "SELECT h FROM HKCG016 h WHERE h.sndcode = :sndcode")
    ,
    @NamedQuery(name = "HKCG016.findByTtbanknum", query = "SELECT h FROM HKCG016 h WHERE h.ttbanknum = :ttbanknum")
    ,
    @NamedQuery(name = "HKCG016.findByDecode", query = "SELECT h FROM HKCG016 h WHERE h.decode = :decode")
    ,
    @NamedQuery(name = "HKCG016.findByPaycom", query = "SELECT h FROM HKCG016 h WHERE h.paycom = :paycom")
    ,
    @NamedQuery(name = "HKCG016.findByTax", query = "SELECT h FROM HKCG016 h WHERE h.tax = :tax")
    ,
    @NamedQuery(name = "HKCG016.findByBegdate", query = "SELECT h FROM HKCG016 h WHERE h.begdate = :begdate")
    ,
    @NamedQuery(name = "HKCG016.findByFkfs", query = "SELECT h FROM HKCG016 h WHERE h.fkfs = :fkfs")
    ,
    @NamedQuery(name = "HKCG016.findByPaycode", query = "SELECT h FROM HKCG016 h WHERE h.paycode = :paycode")
    ,
    @NamedQuery(name = "HKCG016.findByPurkind", query = "SELECT h FROM HKCG016 h WHERE h.purkind = :purkind")
    ,
    @NamedQuery(name = "HKCG016.findByYeramt", query = "SELECT h FROM HKCG016 h WHERE h.yeramt = :yeramt")
    ,
    @NamedQuery(name = "HKCG016.findByOid", query = "SELECT h FROM HKCG016 h WHERE h.oid = :oid")
    ,
    @NamedQuery(name = "HKCG016.findByMark1", query = "SELECT h FROM HKCG016 h WHERE h.mark1 = :mark1")
    ,
    @NamedQuery(name = "HKCG016.findByCapamt", query = "SELECT h FROM HKCG016 h WHERE h.capamt = :capamt")
    ,
    @NamedQuery(name = "HKCG016.findByAreacode", query = "SELECT h FROM HKCG016 h WHERE h.areacode = :areacode")
    ,
    @NamedQuery(name = "HKCG016.findByContactman", query = "SELECT h FROM HKCG016 h WHERE h.contactman = :contactman")
    ,
    @NamedQuery(name = "HKCG016.findByFktype", query = "SELECT h FROM HKCG016 h WHERE h.fktype = :fktype")
    ,
    @NamedQuery(name = "HKCG016.findByFacno", query = "SELECT h FROM HKCG016 h WHERE h.facno = :facno")
    ,
    @NamedQuery(name = "HKCG016.findByTaxrate", query = "SELECT h FROM HKCG016 h WHERE h.taxrate = :taxrate")
    ,
    @NamedQuery(name = "HKCG016.findByTitle", query = "SELECT h FROM HKCG016 h WHERE h.title = :title")
    ,
    @NamedQuery(name = "HKCG016.findByVdrds", query = "SELECT h FROM HKCG016 h WHERE h.vdrds = :vdrds")
    ,
    @NamedQuery(name = "HKCG016.findByVdrsta", query = "SELECT h FROM HKCG016 h WHERE h.vdrsta = :vdrsta")
    ,
    @NamedQuery(name = "HKCG016.findByFax2", query = "SELECT h FROM HKCG016 h WHERE h.fax2 = :fax2")
    ,
    @NamedQuery(name = "HKCG016.findByFax1", query = "SELECT h FROM HKCG016 h WHERE h.fax1 = :fax1")
    ,
    @NamedQuery(name = "HKCG016.findByTickdays", query = "SELECT h FROM HKCG016 h WHERE h.tickdays = :tickdays")
    ,
    @NamedQuery(name = "HKCG016.findByPSN", query = "SELECT h FROM HKCG016 h WHERE h.processSerialNumber = :psn")
    ,
    @NamedQuery(name = "HKCG016.findByFj1", query = "SELECT h FROM HKCG016 h WHERE h.fj1 = :fj1")
    ,
    @NamedQuery(name = "HKCG016.findByFj2", query = "SELECT h FROM HKCG016 h WHERE h.fj2 = :fj2")
    ,
    @NamedQuery(name = "HKCG016.findByUniform", query = "SELECT h FROM HKCG016 h WHERE h.uniform = :uniform")
    ,
    @NamedQuery(name = "HKCG016.findByWebsite", query = "SELECT h FROM HKCG016 h WHERE h.website = :website")
    ,
    @NamedQuery(name = "HKCG016.findByCoin", query = "SELECT h FROM HKCG016 h WHERE h.coin = :coin")
    ,
    @NamedQuery(name = "HKCG016.findByBoss", query = "SELECT h FROM HKCG016 h WHERE h.boss = :boss")
    ,
    @NamedQuery(name = "HKCG016.findByCuycode", query = "SELECT h FROM HKCG016 h WHERE h.cuycode = :cuycode")
    ,
    @NamedQuery(name = "HKCG016.findByUserno", query = "SELECT h FROM HKCG016 h WHERE h.userno = :userno")
    ,
    @NamedQuery(name = "HKCG016.findByAddress", query = "SELECT h FROM HKCG016 h WHERE h.address = :address")
    ,
    @NamedQuery(name = "HKCG016.findByAbccode", query = "SELECT h FROM HKCG016 h WHERE h.abccode = :abccode")
    ,
    @NamedQuery(name = "HKCG016.findByTermcode", query = "SELECT h FROM HKCG016 h WHERE h.termcode = :termcode")
    ,
    @NamedQuery(name = "HKCG016.findByTextbox45", query = "SELECT h FROM HKCG016 h WHERE h.textbox45 = :textbox45")
    ,
    @NamedQuery(name = "HKCG016.findByVdrno", query = "SELECT h FROM HKCG016 h WHERE h.vdrno = :vdrno")
    ,
    @NamedQuery(name = "HKCG016.findByFSN", query = "SELECT h FROM HKCG016 h WHERE h.formSerialNumber = :fsn")})
public class HKCG016 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "ttbankna")
    private String ttbankna;
    @Size(max = 255)
    @Column(name = "vdrdse")
    private String vdrdse;
    @Size(max = 255)
    @Column(name = "ttname")
    private String ttname;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 255)
    @Column(name = "ttbankno")
    private String ttbankno;
    @Size(max = 255)
    @Column(name = "zonenum")
    private String zonenum;
    @Column(name = "latdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latdate;
    @Size(max = 255)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 255)
    @Column(name = "ttbanknum")
    private String ttbanknum;
    @Size(max = 255)
    @Column(name = "decode")
    private String decode;
    @Size(max = 255)
    @Column(name = "paycom")
    private String paycom;
    @Size(max = 255)
    @Column(name = "tax")
    private String tax;
    @Column(name = "begdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date begdate;
    @Size(max = 255)
    @Column(name = "fkfs")
    private String fkfs;
    @Size(max = 255)
    @Column(name = "paycode")
    private String paycode;
    @Size(max = 255)
    @Column(name = "purkind")
    private String purkind;
    @Size(max = 255)
    @Column(name = "yeramt")
    private String yeramt;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 255)
    @Column(name = "capamt")
    private String capamt;
    @Size(max = 255)
    @Column(name = "areacode")
    private String areacode;
    @Size(max = 255)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 255)
    @Column(name = "fktype")
    private String fktype;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "taxrate")
    private String taxrate;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "vdrds")
    private String vdrds;
    @Size(max = 255)
    @Column(name = "vdrsta")
    private String vdrsta;
    @Size(max = 255)
    @Column(name = "fax2")
    private String fax2;
    @Size(max = 255)
    @Column(name = "fax1")
    private String fax1;
    @Size(max = 255)
    @Column(name = "tickdays")
    private String tickdays;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "fj1")
    private String fj1;
    @Size(max = 255)
    @Column(name = "fj2")
    private String fj2;
    @Size(max = 255)
    @Column(name = "uniform")
    private String uniform;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "boss")
    private String boss;
    @Size(max = 255)
    @Column(name = "cuycode")
    private String cuycode;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "abccode")
    private String abccode;
    @Size(max = 255)
    @Column(name = "termcode")
    private String termcode;
    @Size(max = 255)
    @Column(name = "Textbox45")
    private String textbox45;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "isvdrwareh")
    private String isvdrwareh;
    @Size(max = 255)
    @Column(name = "jtwareher")
    private String jtwareher;
    @Size(max = 255)
    @Column(name = "Tag")
    private String Tag;
    @Size(max = 255)
    @Column(name = "BackUrl")
    private String BackUrl;

    

    public HKCG016() {
    }

    public HKCG016(String oid) {
        this.oid = oid;
    }

    public String getTtbankna() {
        return ttbankna;
    }

    public void setTtbankna(String ttbankna) {
        this.ttbankna = ttbankna;
    }

    public String getVdrdse() {
        return vdrdse;
    }

    public void setVdrdse(String vdrdse) {
        this.vdrdse = vdrdse;
    }

    public String getTtname() {
        return ttname;
    }

    public void setTtname(String ttname) {
        this.ttname = ttname;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getTtbankno() {
        return ttbankno;
    }

    public void setTtbankno(String ttbankno) {
        this.ttbankno = ttbankno;
    }

    public String getZonenum() {
        return zonenum;
    }

    public void setZonenum(String zonenum) {
        this.zonenum = zonenum;
    }

    public Date getLatdate() {
        return latdate;
    }

    public void setLatdate(Date latdate) {
        this.latdate = latdate;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public String getTtbanknum() {
        return ttbanknum;
    }

    public void setTtbanknum(String ttbanknum) {
        this.ttbanknum = ttbanknum;
    }

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
        this.decode = decode;
    }

    public String getPaycom() {
        return paycom;
    }

    public void setPaycom(String paycom) {
        this.paycom = paycom;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public Date getBegdate() {
        return begdate;
    }

    public void setBegdate(Date begdate) {
        this.begdate = begdate;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode;
    }

    public String getPurkind() {
        return purkind;
    }

    public void setPurkind(String purkind) {
        this.purkind = purkind;
    }

    public String getYeramt() {
        return yeramt;
    }

    public void setYeramt(String yeramt) {
        this.yeramt = yeramt;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getCapamt() {
        return capamt;
    }

    public void setCapamt(String capamt) {
        this.capamt = capamt;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getFktype() {
        return fktype;
    }

    public void setFktype(String fktype) {
        this.fktype = fktype;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
    }

    public String getVdrsta() {
        return vdrsta;
    }

    public void setVdrsta(String vdrsta) {
        this.vdrsta = vdrsta;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getTickdays() {
        return tickdays;
    }

    public void setTickdays(String tickdays) {
        this.tickdays = tickdays;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getFj1() {
        return fj1;
    }

    public void setFj1(String fj1) {
        this.fj1 = fj1;
    }

    public String getFj2() {
        return fj2;
    }

    public void setFj2(String fj2) {
        this.fj2 = fj2;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getCuycode() {
        return cuycode;
    }

    public void setCuycode(String cuycode) {
        this.cuycode = cuycode;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbccode() {
        return abccode;
    }

    public void setAbccode(String abccode) {
        this.abccode = abccode;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getTextbox45() {
        return textbox45;
    }

    public void setTextbox45(String textbox45) {
        this.textbox45 = textbox45;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCG016)) {
            return false;
        }
        HKCG016 other = (HKCG016) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG016[ oid=" + oid + " ]";
    }

    public String getIsvdrwareh() {
        return isvdrwareh;
    }

    public void setIsvdrwareh(String isvdrwareh) {
        this.isvdrwareh = isvdrwareh;
    }

    public String getJtwareher() {
        return jtwareher;
    }

    public void setJtwareher(String jtwareher) {
        this.jtwareher = jtwareher;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getBackUrl() {
        return BackUrl;
    }

    public void setBackUrl(String BackUrl) {
        this.BackUrl = BackUrl;
    }

}
