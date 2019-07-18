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
@Table(name = "HK_CW002_P")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW002P.findAll", query = "SELECT h FROM HKCW002P h"),
    @NamedQuery(name = "HKCW002P.findBySubyearbal", query = "SELECT h FROM HKCW002P h WHERE h.subyearbal = :subyearbal"),
    @NamedQuery(name = "HKCW002P.findByTextbox112", query = "SELECT h FROM HKCW002P h WHERE h.textbox112 = :textbox112"),
    @NamedQuery(name = "HKCW002P.findByUserman", query = "SELECT h FROM HKCW002P h WHERE h.userman = :userman"),
    @NamedQuery(name = "HKCW002P.findByTextArea80", query = "SELECT h FROM HKCW002P h WHERE h.textArea80 = :textArea80"),
    @NamedQuery(name = "HKCW002P.findByDate65", query = "SELECT h FROM HKCW002P h WHERE h.date65 = :date65"),
    @NamedQuery(name = "HKCW002P.findByTextbox114", query = "SELECT h FROM HKCW002P h WHERE h.textbox114 = :textbox114"),
    @NamedQuery(name = "HKCW002P.findByMidclasscodeTxt", query = "SELECT h FROM HKCW002P h WHERE h.midclasscodeTxt = :midclasscodeTxt"),
    @NamedQuery(name = "HKCW002P.findByTextbox111", query = "SELECT h FROM HKCW002P h WHERE h.textbox111 = :textbox111"),
    @NamedQuery(name = "HKCW002P.findByTextbox116", query = "SELECT h FROM HKCW002P h WHERE h.textbox116 = :textbox116"),
    @NamedQuery(name = "HKCW002P.findByDeptyearbal", query = "SELECT h FROM HKCW002P h WHERE h.deptyearbal = :deptyearbal"),
    @NamedQuery(name = "HKCW002P.findBySubperbal", query = "SELECT h FROM HKCW002P h WHERE h.subperbal = :subperbal"),
    @NamedQuery(name = "HKCW002P.findByBudgetacc", query = "SELECT h FROM HKCW002P h WHERE h.budgetacc = :budgetacc"),
    @NamedQuery(name = "HKCW002P.findByIfturn", query = "SELECT h FROM HKCW002P h WHERE h.ifturn = :ifturn"),
    @NamedQuery(name = "HKCW002P.findBySerialNumber", query = "SELECT h FROM HKCW002P h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW002P.findByDmark1", query = "SELECT h FROM HKCW002P h WHERE h.dmark1 = :dmark1"),
    @NamedQuery(name = "HKCW002P.findByDmark2", query = "SELECT h FROM HKCW002P h WHERE h.dmark2 = :dmark2"),
    @NamedQuery(name = "HKCW002P.findByQgnum", query = "SELECT h FROM HKCW002P h WHERE h.qgnum = :qgnum"),
    @NamedQuery(name = "HKCW002P.findByAppdate", query = "SELECT h FROM HKCW002P h WHERE h.appdate = :appdate"),
    @NamedQuery(name = "HKCW002P.findBySpdse", query = "SELECT h FROM HKCW002P h WHERE h.spdse = :spdse"),
    @NamedQuery(name = "HKCW002P.findByTextbox104", query = "SELECT h FROM HKCW002P h WHERE h.textbox104 = :textbox104"),
    @NamedQuery(name = "HKCW002P.findByTextbox103", query = "SELECT h FROM HKCW002P h WHERE h.textbox103 = :textbox103"),
    @NamedQuery(name = "HKCW002P.findByApplytype", query = "SELECT h FROM HKCW002P h WHERE h.applytype = :applytype"),
    @NamedQuery(name = "HKCW002P.findByAdscodeTxt", query = "SELECT h FROM HKCW002P h WHERE h.adscodeTxt = :adscodeTxt"),
    @NamedQuery(name = "HKCW002P.findByTextbox102", query = "SELECT h FROM HKCW002P h WHERE h.textbox102 = :textbox102"),
    @NamedQuery(name = "HKCW002P.findByTextbox101", query = "SELECT h FROM HKCW002P h WHERE h.textbox101 = :textbox101"),
    @NamedQuery(name = "HKCW002P.findByApplyunit", query = "SELECT h FROM HKCW002P h WHERE h.applyunit = :applyunit"),
    @NamedQuery(name = "HKCW002P.findByTextbox15", query = "SELECT h FROM HKCW002P h WHERE h.textbox15 = :textbox15"),
    @NamedQuery(name = "HKCW002P.findByDatetime1", query = "SELECT h FROM HKCW002P h WHERE h.datetime1 = :datetime1"),
    @NamedQuery(name = "HKCW002P.findByAdscode", query = "SELECT h FROM HKCW002P h WHERE h.adscode = :adscode"),
    @NamedQuery(name = "HKCW002P.findByTextbox10", query = "SELECT h FROM HKCW002P h WHERE h.textbox10 = :textbox10"),
    @NamedQuery(name = "HKCW002P.findByProperty", query = "SELECT h FROM HKCW002P h WHERE h.property = :property"),
    @NamedQuery(name = "HKCW002P.findByTextbox108", query = "SELECT h FROM HKCW002P h WHERE h.textbox108 = :textbox108"),
    @NamedQuery(name = "HKCW002P.findByQgd", query = "SELECT h FROM HKCW002P h WHERE h.qgd = :qgd"),
    @NamedQuery(name = "HKCW002P.findByTextbox106", query = "SELECT h FROM HKCW002P h WHERE h.textbox106 = :textbox106"),
    @NamedQuery(name = "HKCW002P.findByTextbox64", query = "SELECT h FROM HKCW002P h WHERE h.textbox64 = :textbox64"),
    @NamedQuery(name = "HKCW002P.findByUsingDept", query = "SELECT h FROM HKCW002P h WHERE h.usingDept = :usingDept"),
    @NamedQuery(name = "HKCW002P.findBySfjj", query = "SELECT h FROM HKCW002P h WHERE h.sfjj = :sfjj"),
    @NamedQuery(name = "HKCW002P.findByQtotaly", query = "SELECT h FROM HKCW002P h WHERE h.qtotaly = :qtotaly"),
    @NamedQuery(name = "HKCW002P.findByTextbox62", query = "SELECT h FROM HKCW002P h WHERE h.textbox62 = :textbox62"),
    @NamedQuery(name = "HKCW002P.findByTextbox63", query = "SELECT h FROM HKCW002P h WHERE h.textbox63 = :textbox63"),
    @NamedQuery(name = "HKCW002P.findByPrkind", query = "SELECT h FROM HKCW002P h WHERE h.prkind = :prkind"),
    @NamedQuery(name = "HKCW002P.findByLynum", query = "SELECT h FROM HKCW002P h WHERE h.lynum = :lynum"),
    @NamedQuery(name = "HKCW002P.findByGuige", query = "SELECT h FROM HKCW002P h WHERE h.guige = :guige"),
    @NamedQuery(name = "HKCW002P.findByApplynum", query = "SELECT h FROM HKCW002P h WHERE h.applynum = :applynum"),
    @NamedQuery(name = "HKCW002P.findByTextbox0", query = "SELECT h FROM HKCW002P h WHERE h.textbox0 = :textbox0"),
    @NamedQuery(name = "HKCW002P.findByOid", query = "SELECT h FROM HKCW002P h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW002P.findByTextbox4", query = "SELECT h FROM HKCW002P h WHERE h.textbox4 = :textbox4"),
    @NamedQuery(name = "HKCW002P.findByDeptperbal", query = "SELECT h FROM HKCW002P h WHERE h.deptperbal = :deptperbal"),
    @NamedQuery(name = "HKCW002P.findByTextbox3", query = "SELECT h FROM HKCW002P h WHERE h.textbox3 = :textbox3"),
    @NamedQuery(name = "HKCW002P.findByBudgetaccname", query = "SELECT h FROM HKCW002P h WHERE h.budgetaccname = :budgetaccname"),
    @NamedQuery(name = "HKCW002P.findByProtype", query = "SELECT h FROM HKCW002P h WHERE h.protype = :protype"),
    @NamedQuery(name = "HKCW002P.findByAddcode", query = "SELECT h FROM HKCW002P h WHERE h.addcode = :addcode"),
    @NamedQuery(name = "HKCW002P.findByTextbox7", query = "SELECT h FROM HKCW002P h WHERE h.textbox7 = :textbox7"),
    @NamedQuery(name = "HKCW002P.findByBudgetdept", query = "SELECT h FROM HKCW002P h WHERE h.budgetdept = :budgetdept"),
    @NamedQuery(name = "HKCW002P.findByFacno", query = "SELECT h FROM HKCW002P h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW002P.findBySmallclasscodeTxt", query = "SELECT h FROM HKCW002P h WHERE h.smallclasscodeTxt = :smallclasscodeTxt"),
    @NamedQuery(name = "HKCW002P.findByBigclasscodeTxt", query = "SELECT h FROM HKCW002P h WHERE h.bigclasscodeTxt = :bigclasscodeTxt"),
    @NamedQuery(name = "HKCW002P.findByCurrency", query = "SELECT h FROM HKCW002P h WHERE h.currency = :currency"),
    @NamedQuery(name = "HKCW002P.findByTextbox95", query = "SELECT h FROM HKCW002P h WHERE h.textbox95 = :textbox95"),
    @NamedQuery(name = "HKCW002P.findByTextbox93", query = "SELECT h FROM HKCW002P h WHERE h.textbox93 = :textbox93"),
    @NamedQuery(name = "HKCW002P.findByRate", query = "SELECT h FROM HKCW002P h WHERE h.rate = :rate"),
    @NamedQuery(name = "HKCW002P.findByTextbox94", query = "SELECT h FROM HKCW002P h WHERE h.textbox94 = :textbox94"),
    @NamedQuery(name = "HKCW002P.findByHmark1", query = "SELECT h FROM HKCW002P h WHERE h.hmark1 = :hmark1"),
    @NamedQuery(name = "HKCW002P.findByMidclasscode", query = "SELECT h FROM HKCW002P h WHERE h.midclasscode = :midclasscode"),
    @NamedQuery(name = "HKCW002P.findByDmark1name", query = "SELECT h FROM HKCW002P h WHERE h.dmark1name = :dmark1name"),
    @NamedQuery(name = "HKCW002P.findByPSN", query = "SELECT h FROM HKCW002P h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW002P.findByTextbox91", query = "SELECT h FROM HKCW002P h WHERE h.textbox91 = :textbox91"),
    @NamedQuery(name = "HKCW002P.findByTextbox56", query = "SELECT h FROM HKCW002P h WHERE h.textbox56 = :textbox56"),
    @NamedQuery(name = "HKCW002P.findByTextbox92", query = "SELECT h FROM HKCW002P h WHERE h.textbox92 = :textbox92"),
    @NamedQuery(name = "HKCW002P.findByTextbox55", query = "SELECT h FROM HKCW002P h WHERE h.textbox55 = :textbox55"),
    @NamedQuery(name = "HKCW002P.findByCproname", query = "SELECT h FROM HKCW002P h WHERE h.cproname = :cproname"),
    @NamedQuery(name = "HKCW002P.findByPnname", query = "SELECT h FROM HKCW002P h WHERE h.pnname = :pnname"),
    @NamedQuery(name = "HKCW002P.findByApamts", query = "SELECT h FROM HKCW002P h WHERE h.apamts = :apamts"),
    @NamedQuery(name = "HKCW002P.findBySqr", query = "SELECT h FROM HKCW002P h WHERE h.sqr = :sqr"),
    @NamedQuery(name = "HKCW002P.findByZddw", query = "SELECT h FROM HKCW002P h WHERE h.zddw = :zddw"),
    @NamedQuery(name = "HKCW002P.findBySmallclasscode", query = "SELECT h FROM HKCW002P h WHERE h.smallclasscode = :smallclasscode"),
    @NamedQuery(name = "HKCW002P.findByProattr", query = "SELECT h FROM HKCW002P h WHERE h.proattr = :proattr"),
    @NamedQuery(name = "HKCW002P.findByTextbox82", query = "SELECT h FROM HKCW002P h WHERE h.textbox82 = :textbox82"),
    @NamedQuery(name = "HKCW002P.findByApplyUser", query = "SELECT h FROM HKCW002P h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKCW002P.findByTextbox84", query = "SELECT h FROM HKCW002P h WHERE h.textbox84 = :textbox84"),
    @NamedQuery(name = "HKCW002P.findByTextbox85", query = "SELECT h FROM HKCW002P h WHERE h.textbox85 = :textbox85"),
    @NamedQuery(name = "HKCW002P.findBySource", query = "SELECT h FROM HKCW002P h WHERE h.source = :source"),
    @NamedQuery(name = "HKCW002P.findByPremoney", query = "SELECT h FROM HKCW002P h WHERE h.premoney = :premoney"),
    @NamedQuery(name = "HKCW002P.findByDmark2name", query = "SELECT h FROM HKCW002P h WHERE h.dmark2name = :dmark2name"),
    @NamedQuery(name = "HKCW002P.findByQtotalrmb", query = "SELECT h FROM HKCW002P h WHERE h.qtotalrmb = :qtotalrmb"),
    @NamedQuery(name = "HKCW002P.findByPncode", query = "SELECT h FROM HKCW002P h WHERE h.pncode = :pncode"),
    @NamedQuery(name = "HKCW002P.findByBigclasscode", query = "SELECT h FROM HKCW002P h WHERE h.bigclasscode = :bigclasscode"),
    @NamedQuery(name = "HKCW002P.findByFSN", query = "SELECT h FROM HKCW002P h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW002P.findByTextbox81", query = "SELECT h FROM HKCW002P h WHERE h.textbox81 = :textbox81")})
public class HKCW002P implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subyearbal")
    private Double subyearbal;
    @Size(max = 255)
    @Column(name = "Textbox112")
    private String textbox112;
    @Size(max = 255)
    @Column(name = "userman")
    private String userman;
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
    @Column(name = "midclasscode_txt")
    private String midclasscodeTxt;
    @Size(max = 255)
    @Column(name = "Textbox111")
    private String textbox111;
    @Size(max = 255)
    @Column(name = "Textbox116")
    private String textbox116;
    @Column(name = "deptyearbal")
    private Double deptyearbal;
    @Column(name = "subperbal")
    private Double subperbal;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "ifturn")
    private String ifturn;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Column(name = "qgnum")
    private Integer qgnum;
    @Column(name = "appdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appdate;
    @Size(max = 255)
    @Column(name = "spdse")
    private String spdse;
    @Size(max = 255)
    @Column(name = "Textbox104")
    private String textbox104;
    @Size(max = 255)
    @Column(name = "Textbox103")
    private String textbox103;
    @Size(max = 255)
    @Column(name = "applytype")
    private String applytype;
    @Size(max = 255)
    @Column(name = "adscode_txt")
    private String adscodeTxt;
    @Size(max = 255)
    @Column(name = "Textbox102")
    private String textbox102;
    @Size(max = 255)
    @Column(name = "Textbox101")
    private String textbox101;
    @Size(max = 255)
    @Column(name = "applyunit")
    private String applyunit;
    @Size(max = 255)
    @Column(name = "Textbox15")
    private String textbox15;
    @Column(name = "datetime1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime1;
    @Size(max = 255)
    @Column(name = "adscode")
    private String adscode;
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
    @Column(name = "qgd")
    private String qgd;
    @Size(max = 255)
    @Column(name = "Textbox106")
    private String textbox106;
    @Size(max = 255)
    @Column(name = "Textbox64")
    private String textbox64;
    @Size(max = 255)
    @Column(name = "usingDept")
    private String usingDept;
    @Size(max = 255)
    @Column(name = "sfjj")
    private String sfjj;
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
    @Column(name = "lynum")
    private Integer lynum;
    @Size(max = 255)
    @Column(name = "guige")
    private String guige;
    @Column(name = "applynum")
    private Integer applynum;
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
    @Column(name = "deptperbal")
    private Double deptperbal;
    @Size(max = 255)
    @Column(name = "Textbox3")
    private String textbox3;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "protype")
    private String protype;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "Textbox7")
    private String textbox7;
    @Size(max = 255)
    @Column(name = "budgetdept")
    private String budgetdept;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "smallclasscode_txt")
    private String smallclasscodeTxt;
    @Size(max = 255)
    @Column(name = "bigclasscode_txt")
    private String bigclasscodeTxt;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Size(max = 255)
    @Column(name = "Textbox95")
    private String textbox95;
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
    @Size(max = 255)
    @Column(name = "midclasscode")
    private String midclasscode;
    @Size(max = 255)
    @Column(name = "dmark1name")
    private String dmark1name;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
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
    @Size(max = 255)
    @Column(name = "cproname")
    private String cproname;
    @Size(max = 255)
    @Column(name = "pnname")
    private String pnname;
    @Column(name = "apamts")
    private Double apamts;
    @Size(max = 255)
    @Column(name = "sqr")
    private String sqr;
    @Size(max = 255)
    @Column(name = "zddw")
    private String zddw;
    @Size(max = 255)
    @Column(name = "smallclasscode")
    private String smallclasscode;
    @Size(max = 255)
    @Column(name = "proattr")
    private String proattr;
    @Size(max = 255)
    @Column(name = "Textbox82")
    private String textbox82;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "Textbox84")
    private String textbox84;
    @Size(max = 255)
    @Column(name = "Textbox85")
    private String textbox85;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @Column(name = "premoney")
    private Double premoney;
    @Size(max = 255)
    @Column(name = "dmark2name")
    private String dmark2name;
    @Column(name = "qtotalrmb")
    private Double qtotalrmb;
    @Size(max = 255)
    @Column(name = "pncode")
    private String pncode;
    @Size(max = 255)
    @Column(name = "bigclasscode")
    private String bigclasscode;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "Textbox81")
    private String textbox81;

    public HKCW002P() {
    }

    public HKCW002P(String oid) {
        this.oid = oid;
    }

    public Double getSubyearbal() {
        return subyearbal;
    }

    public void setSubyearbal(Double subyearbal) {
        this.subyearbal = subyearbal;
    }

    public String getTextbox112() {
        return textbox112;
    }

    public void setTextbox112(String textbox112) {
        this.textbox112 = textbox112;
    }

    public String getUserman() {
        return userman;
    }

    public void setUserman(String userman) {
        this.userman = userman;
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

    public String getMidclasscodeTxt() {
        return midclasscodeTxt;
    }

    public void setMidclasscodeTxt(String midclasscodeTxt) {
        this.midclasscodeTxt = midclasscodeTxt;
    }

    public String getTextbox111() {
        return textbox111;
    }

    public void setTextbox111(String textbox111) {
        this.textbox111 = textbox111;
    }

    public String getTextbox116() {
        return textbox116;
    }

    public void setTextbox116(String textbox116) {
        this.textbox116 = textbox116;
    }

    public Double getDeptyearbal() {
        return deptyearbal;
    }

    public void setDeptyearbal(Double deptyearbal) {
        this.deptyearbal = deptyearbal;
    }

    public Double getSubperbal() {
        return subperbal;
    }

    public void setSubperbal(Double subperbal) {
        this.subperbal = subperbal;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getIfturn() {
        return ifturn;
    }

    public void setIfturn(String ifturn) {
        this.ifturn = ifturn;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public Integer getQgnum() {
        return qgnum;
    }

    public void setQgnum(Integer qgnum) {
        this.qgnum = qgnum;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public String getSpdse() {
        return spdse;
    }

    public void setSpdse(String spdse) {
        this.spdse = spdse;
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

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getAdscodeTxt() {
        return adscodeTxt;
    }

    public void setAdscodeTxt(String adscodeTxt) {
        this.adscodeTxt = adscodeTxt;
    }

    public String getTextbox102() {
        return textbox102;
    }

    public void setTextbox102(String textbox102) {
        this.textbox102 = textbox102;
    }

    public String getTextbox101() {
        return textbox101;
    }

    public void setTextbox101(String textbox101) {
        this.textbox101 = textbox101;
    }

    public String getApplyunit() {
        return applyunit;
    }

    public void setApplyunit(String applyunit) {
        this.applyunit = applyunit;
    }

    public String getTextbox15() {
        return textbox15;
    }

    public void setTextbox15(String textbox15) {
        this.textbox15 = textbox15;
    }

    public Date getDatetime1() {
        return datetime1;
    }

    public void setDatetime1(Date datetime1) {
        this.datetime1 = datetime1;
    }

    public String getAdscode() {
        return adscode;
    }

    public void setAdscode(String adscode) {
        this.adscode = adscode;
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

    public String getQgd() {
        return qgd;
    }

    public void setQgd(String qgd) {
        this.qgd = qgd;
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

    public String getUsingDept() {
        return usingDept;
    }

    public void setUsingDept(String usingDept) {
        this.usingDept = usingDept;
    }

    public String getSfjj() {
        return sfjj;
    }

    public void setSfjj(String sfjj) {
        this.sfjj = sfjj;
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

    public Integer getLynum() {
        return lynum;
    }

    public void setLynum(Integer lynum) {
        this.lynum = lynum;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public Integer getApplynum() {
        return applynum;
    }

    public void setApplynum(Integer applynum) {
        this.applynum = applynum;
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

    public Double getDeptperbal() {
        return deptperbal;
    }

    public void setDeptperbal(Double deptperbal) {
        this.deptperbal = deptperbal;
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

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public String getTextbox7() {
        return textbox7;
    }

    public void setTextbox7(String textbox7) {
        this.textbox7 = textbox7;
    }

    public String getBudgetdept() {
        return budgetdept;
    }

    public void setBudgetdept(String budgetdept) {
        this.budgetdept = budgetdept;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSmallclasscodeTxt() {
        return smallclasscodeTxt;
    }

    public void setSmallclasscodeTxt(String smallclasscodeTxt) {
        this.smallclasscodeTxt = smallclasscodeTxt;
    }

    public String getBigclasscodeTxt() {
        return bigclasscodeTxt;
    }

    public void setBigclasscodeTxt(String bigclasscodeTxt) {
        this.bigclasscodeTxt = bigclasscodeTxt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTextbox95() {
        return textbox95;
    }

    public void setTextbox95(String textbox95) {
        this.textbox95 = textbox95;
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

    public String getMidclasscode() {
        return midclasscode;
    }

    public void setMidclasscode(String midclasscode) {
        this.midclasscode = midclasscode;
    }

    public String getDmark1name() {
        return dmark1name;
    }

    public void setDmark1name(String dmark1name) {
        this.dmark1name = dmark1name;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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

    public String getCproname() {
        return cproname;
    }

    public void setCproname(String cproname) {
        this.cproname = cproname;
    }

    public String getPnname() {
        return pnname;
    }

    public void setPnname(String pnname) {
        this.pnname = pnname;
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

    public String getZddw() {
        return zddw;
    }

    public void setZddw(String zddw) {
        this.zddw = zddw;
    }

    public String getSmallclasscode() {
        return smallclasscode;
    }

    public void setSmallclasscode(String smallclasscode) {
        this.smallclasscode = smallclasscode;
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

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
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

    public Double getPremoney() {
        return premoney;
    }

    public void setPremoney(Double premoney) {
        this.premoney = premoney;
    }

    public String getDmark2name() {
        return dmark2name;
    }

    public void setDmark2name(String dmark2name) {
        this.dmark2name = dmark2name;
    }

    public Double getQtotalrmb() {
        return qtotalrmb;
    }

    public void setQtotalrmb(Double qtotalrmb) {
        this.qtotalrmb = qtotalrmb;
    }

    public String getPncode() {
        return pncode;
    }

    public void setPncode(String pncode) {
        this.pncode = pncode;
    }

    public String getBigclasscode() {
        return bigclasscode;
    }

    public void setBigclasscode(String bigclasscode) {
        this.bigclasscode = bigclasscode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW002P)) {
            return false;
        }
        HKCW002P other = (HKCW002P) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW002P[ oid=" + oid + " ]";
    }
    
}
