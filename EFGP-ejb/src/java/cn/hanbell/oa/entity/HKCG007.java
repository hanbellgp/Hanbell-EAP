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
 * @author Administrator
 */
@Entity
@Table(name = "HK_CG007")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG007.findAll", query = "SELECT h FROM HKCG007 h"),
    @NamedQuery(name = "HKCG007.findByOID", query = "SELECT h FROM HKCG007 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCG007.findByPSN", query = "SELECT h FROM HKCG007 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCG007.findByFSN", query = "SELECT h FROM HKCG007 h WHERE h.formSerialNumber = :fsn")})
public class HKCG007 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Textbox112")
    private String textbox112;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "TextArea80")
    private String textArea80;
    @Column(name = "Date65")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date65;
    @Size(max = 255)
    @Column(name = "Textbox114")
    private String textbox114;
    @Size(max = 255)
    @Column(name = "Textbox111")
    private String textbox111;
    @Size(max = 255)
    @Column(name = "budgetcode")
    private String budgetcode;
    @Size(max = 255)
    @Column(name = "Textbox116")
    private String textbox116;
    @Size(max = 255)
    @Column(name = "appunit")
    private String appunit;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Column(name = "askdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdate;
    @Size(max = 255)
    @Column(name = "purhaskdscs")
    private String purhaskdscs;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "emgyn")
    private String emgyn;
    @Size(max = 255)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 255)
    @Column(name = "isNine")
    private String isNine;
    @Size(max = 255)
    @Column(name = "Textbox104")
    private String textbox104;
    @Size(max = 255)
    @Column(name = "Textbox103")
    private String textbox103;
    @Size(max = 255)
    @Column(name = "Textbox102")
    private String textbox102;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ctramts")
    private Double ctramts;
    @Size(max = 255)
    @Column(name = "Textbox101")
    private String textbox101;
    @Column(name = "ctotaly")
    private Double ctotaly;
    @Size(max = 255)
    @Column(name = "prono")
    private String prono;
    @Column(name = "deptYear")
    private Double deptYear;
    @Column(name = "ctotamts")
    private Double ctotamts;
    @Size(max = 255)
    @Column(name = "Textbox15")
    private String textbox15;
    @Size(max = 255)
    @Column(name = "posrccode")
    private String posrccode;
    @Size(max = 255)
    @Column(name = "Textbox10")
    private String textbox10;
    @Size(max = 255)
    @Column(name = "property")
    private String property;
    @Size(max = 255)
    @Column(name = "Textbox108")
    private String textbox108;
    @Size(max = 255)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Size(max = 255)
    @Column(name = "Textbox106")
    private String textbox106;
    @Size(max = 255)
    @Column(name = "Textbox64")
    private String textbox64;
    @Size(max = 255)
    @Column(name = "tax")
    private String tax;
    @Column(name = "unpris")
    private Double unpris;
    @Column(name = "qtotaly")
    private Double qtotaly;
    @Size(max = 255)
    @Column(name = "Textbox62")
    private String textbox62;
    @Size(max = 255)
    @Column(name = "Textbox63")
    private String textbox63;
    @Size(max = 255)
    @Column(name = "prkind")
    private String prkind;
    @Size(max = 255)
    @Column(name = "purdaskdescs")
    private String purdaskdescs;
    @Size(max = 255)
    @Column(name = "guige")
    private String guige;
    @Column(name = "qtotamts")
    private Double qtotamts;
    @Size(max = 255)
    @Column(name = "mastbuyer")
    private String mastbuyer;
    @Size(max = 255)
    @Column(name = "Textbox0")
    private String textbox0;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "Textbox4")
    private String textbox4;
    @Size(max = 255)
    @Column(name = "Textbox3")
    private String textbox3;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "mastbuyername")
    private String mastbuyername;
    @Column(name = "ctaxamts")
    private Double ctaxamts;
    @Size(max = 255)
    @Column(name = "Textbox7")
    private String textbox7;
    @Size(max = 255)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Column(name = "taxrate")
    private Double taxrate;
    @Column(name = "qtotalyRMB")
    private Double qtotalyRMB;
    @Column(name = "ctotalyRMB")
    private Double ctotalyRMB;
    @Size(max = 255)
    @Column(name = "Textbox95")
    private String textbox95;
    @Column(name = "accPeriod")
    private Double accPeriod;
    @Size(max = 255)
    @Column(name = "Textbox93")
    private String textbox93;
    @Column(name = "rate")
    private Double rate;
    @Size(max = 255)
    @Column(name = "Textbox94")
    private String textbox94;
    @Size(max = 255)
    @Column(name = "hmark1")
    private String hmark1;
    @Column(name = "accYear")
    private Double accYear;
    @Size(max = 255)
    @Column(name = "dmark1name")
    private String dmark1name;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "appDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appDate;
    @Size(max = 255)
    @Column(name = "Textbox91")
    private String textbox91;
    @Size(max = 255)
    @Column(name = "Textbox56")
    private String textbox56;
    @Size(max = 255)
    @Column(name = "Textbox92")
    private String textbox92;
    @Size(max = 255)
    @Column(name = "Textbox55")
    private String textbox55;
    @Column(name = "deptPeriod")
    private Double deptPeriod;
    @Size(max = 255)
    @Column(name = "cproname")
    private String cproname;
    @Column(name = "apamts")
    private Double apamts;
    @Size(max = 255)
    @Column(name = "sqr")
    private String sqr;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "zddw")
    private String zddw;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "proattr")
    private String proattr;
    @Size(max = 255)
    @Column(name = "Textbox82")
    private String textbox82;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Column(name = "prqy1")
    private Double prqy1;
    @Size(max = 255)
    @Column(name = "Textbox84")
    private String textbox84;
    @Size(max = 255)
    @Column(name = "Textbox85")
    private String textbox85;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @Size(max = 255)
    @Column(name = "istechnique")
    private String istechnique;
    @Column(name = "rqtdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rqtdate;
    @Size(max = 255)
    @Column(name = "dmark2name")
    private String dmark2name;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "Textbox81")
    private String textbox81;
    @Size(max = 255)
    @Column(name = "yfPrice")
    private String yfPrice;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "buyername")
    private String buyername;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;

    public HKCG007() {
    }

    public HKCG007(String oid) {
        this.oid = oid;
    }

    public String getTextbox112() {
        return textbox112;
    }

    public void setTextbox112(String textbox112) {
        this.textbox112 = textbox112;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getTextArea80() {
        return textArea80;
    }

    public void setTextArea80(String textArea80) {
        this.textArea80 = textArea80;
    }

    public Date getDate65() {
        return date65;
    }

    public void setDate65(Date date65) {
        this.date65 = date65;
    }

    public String getTextbox114() {
        return textbox114;
    }

    public void setTextbox114(String textbox114) {
        this.textbox114 = textbox114;
    }

    public String getTextbox111() {
        return textbox111;
    }

    public void setTextbox111(String textbox111) {
        this.textbox111 = textbox111;
    }

    public String getBudgetcode() {
        return budgetcode;
    }

    public void setBudgetcode(String budgetcode) {
        this.budgetcode = budgetcode;
    }

    public String getTextbox116() {
        return textbox116;
    }

    public void setTextbox116(String textbox116) {
        this.textbox116 = textbox116;
    }

    public String getAppunit() {
        return appunit;
    }

    public void setAppunit(String appunit) {
        this.appunit = appunit;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public Date getAskdate() {
        return askdate;
    }

    public void setAskdate(Date askdate) {
        this.askdate = askdate;
    }

    public String getPurhaskdscs() {
        return purhaskdscs;
    }

    public void setPurhaskdscs(String purhaskdscs) {
        this.purhaskdscs = purhaskdscs;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getEmgyn() {
        return emgyn;
    }

    public void setEmgyn(String emgyn) {
        this.emgyn = emgyn;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getIsNine() {
        return isNine;
    }

    public void setIsNine(String isNine) {
        this.isNine = isNine;
    }

    public String getTextbox104() {
        return textbox104;
    }

    public void setTextbox104(String textbox104) {
        this.textbox104 = textbox104;
    }

    public String getTextbox103() {
        return textbox103;
    }

    public void setTextbox103(String textbox103) {
        this.textbox103 = textbox103;
    }

    public String getTextbox102() {
        return textbox102;
    }

    public void setTextbox102(String textbox102) {
        this.textbox102 = textbox102;
    }

    public Double getCtramts() {
        return ctramts;
    }

    public void setCtramts(Double ctramts) {
        this.ctramts = ctramts;
    }

    public String getTextbox101() {
        return textbox101;
    }

    public void setTextbox101(String textbox101) {
        this.textbox101 = textbox101;
    }

    public Double getCtotaly() {
        return ctotaly;
    }

    public void setCtotaly(Double ctotaly) {
        this.ctotaly = ctotaly;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public Double getDeptYear() {
        return deptYear;
    }

    public void setDeptYear(Double deptYear) {
        this.deptYear = deptYear;
    }

    public Double getCtotamts() {
        return ctotamts;
    }

    public void setCtotamts(Double ctotamts) {
        this.ctotamts = ctotamts;
    }

    public String getTextbox15() {
        return textbox15;
    }

    public void setTextbox15(String textbox15) {
        this.textbox15 = textbox15;
    }

    public String getPosrccode() {
        return posrccode;
    }

    public void setPosrccode(String posrccode) {
        this.posrccode = posrccode;
    }

    public String getTextbox10() {
        return textbox10;
    }

    public void setTextbox10(String textbox10) {
        this.textbox10 = textbox10;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTextbox108() {
        return textbox108;
    }

    public void setTextbox108(String textbox108) {
        this.textbox108 = textbox108;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public String getTextbox106() {
        return textbox106;
    }

    public void setTextbox106(String textbox106) {
        this.textbox106 = textbox106;
    }

    public String getTextbox64() {
        return textbox64;
    }

    public void setTextbox64(String textbox64) {
        this.textbox64 = textbox64;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public Double getUnpris() {
        return unpris;
    }

    public void setUnpris(Double unpris) {
        this.unpris = unpris;
    }

    public Double getQtotaly() {
        return qtotaly;
    }

    public void setQtotaly(Double qtotaly) {
        this.qtotaly = qtotaly;
    }

    public String getTextbox62() {
        return textbox62;
    }

    public void setTextbox62(String textbox62) {
        this.textbox62 = textbox62;
    }

    public String getTextbox63() {
        return textbox63;
    }

    public void setTextbox63(String textbox63) {
        this.textbox63 = textbox63;
    }

    public String getPrkind() {
        return prkind;
    }

    public void setPrkind(String prkind) {
        this.prkind = prkind;
    }

    public String getPurdaskdescs() {
        return purdaskdescs;
    }

    public void setPurdaskdescs(String purdaskdescs) {
        this.purdaskdescs = purdaskdescs;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public Double getQtotamts() {
        return qtotamts;
    }

    public void setQtotamts(Double qtotamts) {
        this.qtotamts = qtotamts;
    }

    public String getMastbuyer() {
        return mastbuyer;
    }

    public void setMastbuyer(String mastbuyer) {
        this.mastbuyer = mastbuyer;
    }

    public String getTextbox0() {
        return textbox0;
    }

    public void setTextbox0(String textbox0) {
        this.textbox0 = textbox0;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTextbox4() {
        return textbox4;
    }

    public void setTextbox4(String textbox4) {
        this.textbox4 = textbox4;
    }

    public String getTextbox3() {
        return textbox3;
    }

    public void setTextbox3(String textbox3) {
        this.textbox3 = textbox3;
    }

    public String getBudgetaccname() {
        return budgetaccname;
    }

    public void setBudgetaccname(String budgetaccname) {
        this.budgetaccname = budgetaccname;
    }

    public String getMastbuyername() {
        return mastbuyername;
    }

    public void setMastbuyername(String mastbuyername) {
        this.mastbuyername = mastbuyername;
    }

    public Double getCtaxamts() {
        return ctaxamts;
    }

    public void setCtaxamts(Double ctaxamts) {
        this.ctaxamts = ctaxamts;
    }

    public String getTextbox7() {
        return textbox7;
    }

    public void setTextbox7(String textbox7) {
        this.textbox7 = textbox7;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Double taxrate) {
        this.taxrate = taxrate;
    }

    public Double getQtotalyRMB() {
        return qtotalyRMB;
    }

    public void setQtotalyRMB(Double qtotalyRMB) {
        this.qtotalyRMB = qtotalyRMB;
    }

    public Double getCtotalyRMB() {
        return ctotalyRMB;
    }

    public void setCtotalyRMB(Double ctotalyRMB) {
        this.ctotalyRMB = ctotalyRMB;
    }

    public String getTextbox95() {
        return textbox95;
    }

    public void setTextbox95(String textbox95) {
        this.textbox95 = textbox95;
    }

    public Double getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(Double accPeriod) {
        this.accPeriod = accPeriod;
    }

    public String getTextbox93() {
        return textbox93;
    }

    public void setTextbox93(String textbox93) {
        this.textbox93 = textbox93;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTextbox94() {
        return textbox94;
    }

    public void setTextbox94(String textbox94) {
        this.textbox94 = textbox94;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public Double getAccYear() {
        return accYear;
    }

    public void setAccYear(Double accYear) {
        this.accYear = accYear;
    }

    public String getDmark1name() {
        return dmark1name;
    }

    public void setDmark1name(String dmark1name) {
        this.dmark1name = dmark1name;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getTextbox91() {
        return textbox91;
    }

    public void setTextbox91(String textbox91) {
        this.textbox91 = textbox91;
    }

    public String getTextbox56() {
        return textbox56;
    }

    public void setTextbox56(String textbox56) {
        this.textbox56 = textbox56;
    }

    public String getTextbox92() {
        return textbox92;
    }

    public void setTextbox92(String textbox92) {
        this.textbox92 = textbox92;
    }

    public String getTextbox55() {
        return textbox55;
    }

    public void setTextbox55(String textbox55) {
        this.textbox55 = textbox55;
    }

    public Double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(Double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public String getCproname() {
        return cproname;
    }

    public void setCproname(String cproname) {
        this.cproname = cproname;
    }

    public Double getApamts() {
        return apamts;
    }

    public void setApamts(Double apamts) {
        this.apamts = apamts;
    }

    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getZddw() {
        return zddw;
    }

    public void setZddw(String zddw) {
        this.zddw = zddw;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getProattr() {
        return proattr;
    }

    public void setProattr(String proattr) {
        this.proattr = proattr;
    }

    public String getTextbox82() {
        return textbox82;
    }

    public void setTextbox82(String textbox82) {
        this.textbox82 = textbox82;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Double getPrqy1() {
        return prqy1;
    }

    public void setPrqy1(Double prqy1) {
        this.prqy1 = prqy1;
    }

    public String getTextbox84() {
        return textbox84;
    }

    public void setTextbox84(String textbox84) {
        this.textbox84 = textbox84;
    }

    public String getTextbox85() {
        return textbox85;
    }

    public void setTextbox85(String textbox85) {
        this.textbox85 = textbox85;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIstechnique() {
        return istechnique;
    }

    public void setIstechnique(String istechnique) {
        this.istechnique = istechnique;
    }

    public Date getRqtdate() {
        return rqtdate;
    }

    public void setRqtdate(Date rqtdate) {
        this.rqtdate = rqtdate;
    }

    public String getDmark2name() {
        return dmark2name;
    }

    public void setDmark2name(String dmark2name) {
        this.dmark2name = dmark2name;
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

    public String getTextbox81() {
        return textbox81;
    }

    public void setTextbox81(String textbox81) {
        this.textbox81 = textbox81;
    }

    public String getYfPrice() {
        return yfPrice;
    }

    public void setYfPrice(String yfPrice) {
        this.yfPrice = yfPrice;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
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
        if (!(object instanceof HKCG007)) {
            return false;
        }
        HKCG007 other = (HKCG007) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG007[ oid=" + oid + " ]";
    }
    
}
