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
@Table(name = "VH_TM001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTM001.findAll", query = "SELECT v FROM VHTM001 v"),
    @NamedQuery(name = "VHTM001.findByPSN", query = "SELECT v FROM VHTM001 v WHERE v.processSerialNumber = :psn"),
    @NamedQuery(name = "VHTM001.findByFSN", query = "SELECT v FROM VHTM001 v WHERE v.formSerialNumber = :fsn")})
public class VHTM001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "budgetcode")
    private String budgetcode;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 255)
    @Column(name = "formulateDept")
    private String formulateDept;
    @Column(name = "formulateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formulateDate;
    @Size(max = 255)
    @Column(name = "prono")
    private String prono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "deptYear")
    private Double deptYear;
    @Size(max = 255)
    @Column(name = "planqty")
    private String planqty;
    @Size(max = 255)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Size(max = 255)
    @Column(name = "equipmentName")
    private String equipmentName;
    @Size(max = 255)
    @Column(name = "tax")
    private String tax;
    @Column(name = "qtotaly")
    private Double qtotaly;
    @Size(max = 255)
    @Column(name = "prkind")
    private String prkind;
    @Size(max = 255)
    @Column(name = "hdnappDept")
    private String hdnappDept;
    @Size(max = 255)
    @Column(name = "conclusion")
    private String conclusion;
    @Size(max = 255)
    @Column(name = "purdaskdescs")
    private String purdaskdescs;
    @Column(name = "qtotamts")
    private Double qtotamts;
    @Size(max = 255)
    @Column(name = "mastbuyer")
    private String mastbuyer;
    @Size(max = 255)
    @Column(name = "origqty2")
    private String origqty2;
    @Size(max = 255)
    @Column(name = "equipmentName2")
    private String equipmentName2;
    @Size(max = 255)
    @Column(name = "origqty1")
    private String origqty1;
    @Size(max = 255)
    @Column(name = "purhaskdscs1")
    private String purhaskdscs1;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Column(name = "qtotalyRMB")
    private Double qtotalyRMB;
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
    @Column(name = "deptPeriod")
    private Double deptPeriod;
    @Size(max = 255)
    @Column(name = "formulateUser")
    private String formulateUser;
    @Size(max = 255)
    @Column(name = "hdnhmark1")
    private String hdnhmark1;
    @Size(max = 255)
    @Column(name = "hdncreator")
    private String hdncreator;
    @Size(max = 255)
    @Column(name = "vendor")
    private String vendor;
    @Size(max = 255)
    @Column(name = "yfPrice")
    private String yfPrice;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "newqty1")
    private String newqty1;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Column(name = "prqy1")
    private Double prqy1;
    @Size(max = 255)
    @Column(name = "equipmentSpec")
    private String equipmentSpec;
    @Size(max = 255)
    @Column(name = "istechnique")
    private String istechnique;
    @Size(max = 255)
    @Column(name = "newqty2")
    private String newqty2;
    @Size(max = 255)
    @Column(name = "factor26")
    private String factor26;
    @Size(max = 255)
    @Column(name = "factor25")
    private String factor25;
    @Size(max = 255)
    @Column(name = "factor24")
    private String factor24;
    @Size(max = 255)
    @Column(name = "factor23")
    private String factor23;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "factor29")
    private String factor29;
    @Size(max = 255)
    @Column(name = "factor28")
    private String factor28;
    @Size(max = 255)
    @Column(name = "factor27")
    private String factor27;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "used")
    private String used;
    @Size(max = 255)
    @Column(name = "appunit")
    private String appunit;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
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
    @Column(name = "reman")
    private String reman;
    @Size(max = 255)
    @Column(name = "emgyn")
    private String emgyn;
    @Size(max = 255)
    @Column(name = "adviceBrand")
    private String adviceBrand;
    @Size(max = 255)
    @Column(name = "isNine")
    private String isNine;
    @Size(max = 255)
    @Column(name = "factor21")
    private String factor21;
    @Size(max = 255)
    @Column(name = "hdnprkind")
    private String hdnprkind;
    @Size(max = 255)
    @Column(name = "factor22")
    private String factor22;
    @Column(name = "ctramts")
    private Double ctramts;
    @Column(name = "ctotaly")
    private Double ctotaly;
    @Size(max = 255)
    @Column(name = "origproject1")
    private String origproject1;
    @Size(max = 255)
    @Column(name = "origproject2")
    private String origproject2;
    @Column(name = "ctotamts")
    private Double ctotamts;
    @Size(max = 255)
    @Column(name = "posrccode")
    private String posrccode;
    @Size(max = 255)
    @Column(name = "property")
    private String property;
    @Size(max = 255)
    @Column(name = "origrate1")
    private String origrate1;
    @Size(max = 255)
    @Column(name = "newproject2")
    private String newproject2;
    @Size(max = 255)
    @Column(name = "origrate2")
    private String origrate2;
    @Size(max = 255)
    @Column(name = "newproject1")
    private String newproject1;
    @Column(name = "unpris")
    private Double unpris;
    @Size(max = 255)
    @Column(name = "factor30")
    private String factor30;
    @Size(max = 255)
    @Column(name = "factor31")
    private String factor31;
    @Size(max = 255)
    @Column(name = "factor32")
    private String factor32;
    @Size(max = 255)
    @Column(name = "factor33")
    private String factor33;
    @Size(max = 255)
    @Column(name = "factor08")
    private String factor08;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "factor07")
    private String factor07;
    @Size(max = 255)
    @Column(name = "factor06")
    private String factor06;
    @Size(max = 255)
    @Column(name = "hdnappUser")
    private String hdnappUser;
    @Size(max = 255)
    @Column(name = "factor05")
    private String factor05;
    @Size(max = 255)
    @Column(name = "factor04")
    private String factor04;
    @Size(max = 255)
    @Column(name = "factor03")
    private String factor03;
    @Size(max = 255)
    @Column(name = "factor02")
    private String factor02;
    @Size(max = 255)
    @Column(name = "factor01")
    private String factor01;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "attribute")
    private String attribute;
    @Size(max = 255)
    @Column(name = "mastbuyername")
    private String mastbuyername;
    @Column(name = "ctaxamts")
    private Double ctaxamts;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "factor09")
    private String factor09;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Column(name = "taxrate")
    private Double taxrate;
    @Size(max = 255)
    @Column(name = "newrate2")
    private String newrate2;
    @Column(name = "ctotalyRMB")
    private Double ctotalyRMB;
    @Column(name = "accPeriod")
    private Double accPeriod;
    @Column(name = "rate")
    private Double rate;
    @Size(max = 255)
    @Column(name = "newrate1")
    private String newrate1;
    @Size(max = 255)
    @Column(name = "hmark1")
    private String hmark1;
    @Column(name = "appDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appDate;
    @Size(max = 255)
    @Column(name = "TextArea4")
    private String textArea4;
    @Column(name = "apamts")
    private Double apamts;
    @Size(max = 255)
    @Column(name = "buyername")
    private String buyername;
    @Size(max = 255)
    @Column(name = "factor12")
    private String factor12;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @Column(name = "rqtdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rqtdate;
    @Size(max = 255)
    @Column(name = "dmark2name")
    private String dmark2name;
    @Size(max = 255)
    @Column(name = "factor10")
    private String factor10;
    @Size(max = 255)
    @Column(name = "factor11")
    private String factor11;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public VHTM001() {
    }

    public VHTM001(String oid) {
        this.oid = oid;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getBudgetcode() {
        return budgetcode;
    }

    public void setBudgetcode(String budgetcode) {
        this.budgetcode = budgetcode;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getFormulateDept() {
        return formulateDept;
    }

    public void setFormulateDept(String formulateDept) {
        this.formulateDept = formulateDept;
    }

    public Date getFormulateDate() {
        return formulateDate;
    }

    public void setFormulateDate(Date formulateDate) {
        this.formulateDate = formulateDate;
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

    public String getPlanqty() {
        return planqty;
    }

    public void setPlanqty(String planqty) {
        this.planqty = planqty;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public Double getQtotaly() {
        return qtotaly;
    }

    public void setQtotaly(Double qtotaly) {
        this.qtotaly = qtotaly;
    }

    public String getPrkind() {
        return prkind;
    }

    public void setPrkind(String prkind) {
        this.prkind = prkind;
    }

    public String getHdnappDept() {
        return hdnappDept;
    }

    public void setHdnappDept(String hdnappDept) {
        this.hdnappDept = hdnappDept;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getPurdaskdescs() {
        return purdaskdescs;
    }

    public void setPurdaskdescs(String purdaskdescs) {
        this.purdaskdescs = purdaskdescs;
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

    public String getOrigqty2() {
        return origqty2;
    }

    public void setOrigqty2(String origqty2) {
        this.origqty2 = origqty2;
    }

    public String getEquipmentName2() {
        return equipmentName2;
    }

    public void setEquipmentName2(String equipmentName2) {
        this.equipmentName2 = equipmentName2;
    }

    public String getOrigqty1() {
        return origqty1;
    }

    public void setOrigqty1(String origqty1) {
        this.origqty1 = origqty1;
    }

    public String getPurhaskdscs1() {
        return purhaskdscs1;
    }

    public void setPurhaskdscs1(String purhaskdscs1) {
        this.purhaskdscs1 = purhaskdscs1;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getQtotalyRMB() {
        return qtotalyRMB;
    }

    public void setQtotalyRMB(Double qtotalyRMB) {
        this.qtotalyRMB = qtotalyRMB;
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

    public Double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(Double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public String getFormulateUser() {
        return formulateUser;
    }

    public void setFormulateUser(String formulateUser) {
        this.formulateUser = formulateUser;
    }

    public String getHdnhmark1() {
        return hdnhmark1;
    }

    public void setHdnhmark1(String hdnhmark1) {
        this.hdnhmark1 = hdnhmark1;
    }

    public String getHdncreator() {
        return hdncreator;
    }

    public void setHdncreator(String hdncreator) {
        this.hdncreator = hdncreator;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getYfPrice() {
        return yfPrice;
    }

    public void setYfPrice(String yfPrice) {
        this.yfPrice = yfPrice;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getNewqty1() {
        return newqty1;
    }

    public void setNewqty1(String newqty1) {
        this.newqty1 = newqty1;
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

    public String getEquipmentSpec() {
        return equipmentSpec;
    }

    public void setEquipmentSpec(String equipmentSpec) {
        this.equipmentSpec = equipmentSpec;
    }

    public String getIstechnique() {
        return istechnique;
    }

    public void setIstechnique(String istechnique) {
        this.istechnique = istechnique;
    }

    public String getNewqty2() {
        return newqty2;
    }

    public void setNewqty2(String newqty2) {
        this.newqty2 = newqty2;
    }

    public String getFactor26() {
        return factor26;
    }

    public void setFactor26(String factor26) {
        this.factor26 = factor26;
    }

    public String getFactor25() {
        return factor25;
    }

    public void setFactor25(String factor25) {
        this.factor25 = factor25;
    }

    public String getFactor24() {
        return factor24;
    }

    public void setFactor24(String factor24) {
        this.factor24 = factor24;
    }

    public String getFactor23() {
        return factor23;
    }

    public void setFactor23(String factor23) {
        this.factor23 = factor23;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFactor29() {
        return factor29;
    }

    public void setFactor29(String factor29) {
        this.factor29 = factor29;
    }

    public String getFactor28() {
        return factor28;
    }

    public void setFactor28(String factor28) {
        this.factor28 = factor28;
    }

    public String getFactor27() {
        return factor27;
    }

    public void setFactor27(String factor27) {
        this.factor27 = factor27;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getAppunit() {
        return appunit;
    }

    public void setAppunit(String appunit) {
        this.appunit = appunit;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
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

    public String getReman() {
        return reman;
    }

    public void setReman(String reman) {
        this.reman = reman;
    }

    public String getEmgyn() {
        return emgyn;
    }

    public void setEmgyn(String emgyn) {
        this.emgyn = emgyn;
    }

    public String getAdviceBrand() {
        return adviceBrand;
    }

    public void setAdviceBrand(String adviceBrand) {
        this.adviceBrand = adviceBrand;
    }

    public String getIsNine() {
        return isNine;
    }

    public void setIsNine(String isNine) {
        this.isNine = isNine;
    }

    public String getFactor21() {
        return factor21;
    }

    public void setFactor21(String factor21) {
        this.factor21 = factor21;
    }

    public String getHdnprkind() {
        return hdnprkind;
    }

    public void setHdnprkind(String hdnprkind) {
        this.hdnprkind = hdnprkind;
    }

    public String getFactor22() {
        return factor22;
    }

    public void setFactor22(String factor22) {
        this.factor22 = factor22;
    }

    public Double getCtramts() {
        return ctramts;
    }

    public void setCtramts(Double ctramts) {
        this.ctramts = ctramts;
    }

    public Double getCtotaly() {
        return ctotaly;
    }

    public void setCtotaly(Double ctotaly) {
        this.ctotaly = ctotaly;
    }

    public String getOrigproject1() {
        return origproject1;
    }

    public void setOrigproject1(String origproject1) {
        this.origproject1 = origproject1;
    }

    public String getOrigproject2() {
        return origproject2;
    }

    public void setOrigproject2(String origproject2) {
        this.origproject2 = origproject2;
    }

    public Double getCtotamts() {
        return ctotamts;
    }

    public void setCtotamts(Double ctotamts) {
        this.ctotamts = ctotamts;
    }

    public String getPosrccode() {
        return posrccode;
    }

    public void setPosrccode(String posrccode) {
        this.posrccode = posrccode;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getOrigrate1() {
        return origrate1;
    }

    public void setOrigrate1(String origrate1) {
        this.origrate1 = origrate1;
    }

    public String getNewproject2() {
        return newproject2;
    }

    public void setNewproject2(String newproject2) {
        this.newproject2 = newproject2;
    }

    public String getOrigrate2() {
        return origrate2;
    }

    public void setOrigrate2(String origrate2) {
        this.origrate2 = origrate2;
    }

    public String getNewproject1() {
        return newproject1;
    }

    public void setNewproject1(String newproject1) {
        this.newproject1 = newproject1;
    }

    public Double getUnpris() {
        return unpris;
    }

    public void setUnpris(Double unpris) {
        this.unpris = unpris;
    }

    public String getFactor30() {
        return factor30;
    }

    public void setFactor30(String factor30) {
        this.factor30 = factor30;
    }

    public String getFactor31() {
        return factor31;
    }

    public void setFactor31(String factor31) {
        this.factor31 = factor31;
    }

    public String getFactor32() {
        return factor32;
    }

    public void setFactor32(String factor32) {
        this.factor32 = factor32;
    }

    public String getFactor33() {
        return factor33;
    }

    public void setFactor33(String factor33) {
        this.factor33 = factor33;
    }

    public String getFactor08() {
        return factor08;
    }

    public void setFactor08(String factor08) {
        this.factor08 = factor08;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFactor07() {
        return factor07;
    }

    public void setFactor07(String factor07) {
        this.factor07 = factor07;
    }

    public String getFactor06() {
        return factor06;
    }

    public void setFactor06(String factor06) {
        this.factor06 = factor06;
    }

    public String getHdnappUser() {
        return hdnappUser;
    }

    public void setHdnappUser(String hdnappUser) {
        this.hdnappUser = hdnappUser;
    }

    public String getFactor05() {
        return factor05;
    }

    public void setFactor05(String factor05) {
        this.factor05 = factor05;
    }

    public String getFactor04() {
        return factor04;
    }

    public void setFactor04(String factor04) {
        this.factor04 = factor04;
    }

    public String getFactor03() {
        return factor03;
    }

    public void setFactor03(String factor03) {
        this.factor03 = factor03;
    }

    public String getFactor02() {
        return factor02;
    }

    public void setFactor02(String factor02) {
        this.factor02 = factor02;
    }

    public String getFactor01() {
        return factor01;
    }

    public void setFactor01(String factor01) {
        this.factor01 = factor01;
    }

    public String getBudgetaccname() {
        return budgetaccname;
    }

    public void setBudgetaccname(String budgetaccname) {
        this.budgetaccname = budgetaccname;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
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

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
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

    public String getFactor09() {
        return factor09;
    }

    public void setFactor09(String factor09) {
        this.factor09 = factor09;
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

    public String getNewrate2() {
        return newrate2;
    }

    public void setNewrate2(String newrate2) {
        this.newrate2 = newrate2;
    }

    public Double getCtotalyRMB() {
        return ctotalyRMB;
    }

    public void setCtotalyRMB(Double ctotalyRMB) {
        this.ctotalyRMB = ctotalyRMB;
    }

    public Double getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(Double accPeriod) {
        this.accPeriod = accPeriod;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getNewrate1() {
        return newrate1;
    }

    public void setNewrate1(String newrate1) {
        this.newrate1 = newrate1;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getTextArea4() {
        return textArea4;
    }

    public void setTextArea4(String textArea4) {
        this.textArea4 = textArea4;
    }

    public Double getApamts() {
        return apamts;
    }

    public void setApamts(Double apamts) {
        this.apamts = apamts;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getFactor12() {
        return factor12;
    }

    public void setFactor12(String factor12) {
        this.factor12 = factor12;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getFactor10() {
        return factor10;
    }

    public void setFactor10(String factor10) {
        this.factor10 = factor10;
    }

    public String getFactor11() {
        return factor11;
    }

    public void setFactor11(String factor11) {
        this.factor11 = factor11;
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
        if (!(object instanceof VHTM001)) {
            return false;
        }
        VHTM001 other = (VHTM001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTM001[ oid=" + oid + " ]";
    }

}
