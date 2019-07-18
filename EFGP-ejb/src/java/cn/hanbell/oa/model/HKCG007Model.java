/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1368
 */
@XmlRootElement
public class HKCG007Model implements Serializable {

    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "budgetcode")
    private String budgetcode;
    @Size(max = 255)
    @Column(name = "purhaskdscs")
    private String purhaskdscs;
    @Size(max = 255)
    @Column(name = "isNine")
    private String isNine;
    @Column(name = "ctotaly")
    private Double ctotaly;
    @Size(max = 255)
    @Column(name = "prono")
    private String prono;
    @Column(name = "deptYear")
    private Double deptYear;
    @Size(max = 255)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "qtotaly")
    private Double qtotaly;
    @Size(max = 255)
    @Column(name = "prkind")
    private String prkind;
    @Size(max = 255)
    @Column(name = "mastbuyer")
    private String mastbuyer;
    @Column(name = "rate")
    private Double rate;
    @Size(max = 255)
    @Column(name = "mastbuyername")
    private String mastbuyername;
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
    @Column(name = "qtotalyRMB")
    private Double qtotalyRMB;
    @Column(name = "ctotalyRMB")
    private Double ctotalyRMB;
    @Size(max = 255)
    @Column(name = "hmark1")
    private String hmark1;
    @Column(name = "appDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appDate;
    @Column(name = "deptPeriod")
    private Double deptPeriod;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Size(max = 255)
    @Column(name = "istechnique")
    private String istechnique;
    @Size(max = 255)
    @Column(name = "yfPrice")
    private String yfPrice;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;

    @Size(max = 255)
    @Column(name = "formulateDept")
    private String formulateDept;
    @Size(max = 255)
    @Column(name = "formulateUser")
    private String formulateUser;
    @Column(name = "formulateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formulateDate;
    @Size(max = 255)
    @Column(name = "equipmentName")
    private String equipmentName;
    @Size(max = 255)
    @Column(name = "equipmentName2")
    private String equipmentName2;
    @Size(max = 255)
    @Column(name = "equipmentSpec")
    private String equipmentSpec;
    @Size(max = 255)
    @Column(name = "adviceBrand")
    private String adviceBrand;
    @Size(max = 255)
    @Column(name = "planqty")
    private String planqty;
    @Size(max = 255)
    @Column(name = "used")
    private String used;
    @Size(max = 255)
    @Column(name = "property")
    private String property;
    @Size(max = 255)
    @Column(name = "vendor")
    private String vendor;
    @Size(max = 255)
    @Column(name = "attribute")
    private String attribute;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "factor01")
    private String factor01;
    @Size(max = 255)
    @Column(name = "factor02")
    private String factor02;
    @Size(max = 255)
    @Column(name = "factor03")
    private String factor03;
    @Size(max = 255)
    @Column(name = "factor04")
    private String factor04;
    @Size(max = 255)
    @Column(name = "factor05")
    private String factor05;
    @Size(max = 255)
    @Column(name = "factor06")
    private String factor06;
    @Size(max = 255)
    @Column(name = "factor07")
    private String factor07;
    @Size(max = 255)
    @Column(name = "factor08")
    private String factor08;
    @Size(max = 255)
    @Column(name = "factor09")
    private String factor09;
    @Size(max = 255)
    @Column(name = "factor10")
    private String factor10;
    @Size(max = 255)
    @Column(name = "factor11")
    private String factor11;
    @Size(max = 255)
    @Column(name = "factor12")
    private String factor12;
    @Size(max = 255)
    @Column(name = "conclusion")
    private String conclusion;
    @Size(max = 255)
    @Column(name = "origproject1")
    private String origproject1;
    @Size(max = 255)
    @Column(name = "origqty1")
    private String origqty1;
    @Size(max = 255)
    @Column(name = "origrate1")
    private String origrate1;
    @Size(max = 255)
    @Column(name = "newrate1")
    private String newrate1;

    @Size(max = 255)
    @Column(name = "origproject2")
    private String origproject2;
    @Size(max = 255)
    @Column(name = "origqty2")
    private String origqty2;
    @Size(max = 255)
    @Column(name = "origrate2")
    private String origrate2;
    @Size(max = 255)
    @Column(name = "newrate2")
    private String newrate2;

    @Size(max = 255)
    @Column(name = "newproject1")
    private String newproject1;
    @Size(max = 255)
    @Column(name = "newqty1")
    private String newqty1;
    @Size(max = 255)
    @Column(name = "newproject2")
    private String newproject2;
    @Size(max = 255)
    @Column(name = "newqty2")
    private String newqty2;

    public HKCG007Model() {
    }

    public String getOrigqty2() {
        return origqty2;
    }

    public void setOrigqty2(String origqty2) {
        this.origqty2 = origqty2;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getFormulateDate() {
        return formulateDate;
    }

    public void setFormulateDate(Date formulateDate) {
        this.formulateDate = formulateDate;
    }

    public String getOrigrate1() {
        return origrate1;
    }

    public void setOrigrate1(String origrate1) {
        this.origrate1 = origrate1;
    }

    public String getOrigqty1() {
        return origqty1;
    }

    public void setOrigqty1(String origqty1) {
        this.origqty1 = origqty1;
    }

    public String getBudgetcode() {
        return budgetcode;
    }

    public void setBudgetcode(String budgetcode) {
        this.budgetcode = budgetcode;
    }

    public String getNewrate1() {
        return newrate1;
    }

    public void setNewrate1(String newrate1) {
        this.newrate1 = newrate1;
    }

    public String getPurhaskdscs() {
        return purhaskdscs;
    }

    public void setPurhaskdscs(String purhaskdscs) {
        this.purhaskdscs = purhaskdscs;
    }

    public String getIsNine() {
        return isNine;
    }

    public void setIsNine(String isNine) {
        this.isNine = isNine;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getFactor12() {
        return factor12;
    }

    public void setFactor12(String factor12) {
        this.factor12 = factor12;
    }

    public String getFactor11() {
        return factor11;
    }

    public void setFactor11(String factor11) {
        this.factor11 = factor11;
    }

    public String getFactor10() {
        return factor10;
    }

    public void setFactor10(String factor10) {
        this.factor10 = factor10;
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

    public String getNewqty2() {
        return newqty2;
    }

    public void setNewqty2(String newqty2) {
        this.newqty2 = newqty2;
    }

    public String getNewqty1() {
        return newqty1;
    }

    public void setNewqty1(String newqty1) {
        this.newqty1 = newqty1;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getOrigproject2() {
        return origproject2;
    }

    public void setOrigproject2(String origproject2) {
        this.origproject2 = origproject2;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public String getOrigproject1() {
        return origproject1;
    }

    public void setOrigproject1(String origproject1) {
        this.origproject1 = origproject1;
    }

    public String getAdviceBrand() {
        return adviceBrand;
    }

    public void setAdviceBrand(String adviceBrand) {
        this.adviceBrand = adviceBrand;
    }

    public Double getQtotaly() {
        return qtotaly;
    }

    public void setQtotaly(Double qtotaly) {
        this.qtotaly = qtotaly;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPlanqty() {
        return planqty;
    }

    public void setPlanqty(String planqty) {
        this.planqty = planqty;
    }

    public String getPrkind() {
        return prkind;
    }

    public void setPrkind(String prkind) {
        this.prkind = prkind;
    }

    public String getEquipmentSpec() {
        return equipmentSpec;
    }

    public void setEquipmentSpec(String equipmentSpec) {
        this.equipmentSpec = equipmentSpec;
    }

    public String getMastbuyer() {
        return mastbuyer;
    }

    public void setMastbuyer(String mastbuyer) {
        this.mastbuyer = mastbuyer;
    }

    public String getNewrate2() {
        return newrate2;
    }

    public void setNewrate2(String newrate2) {
        this.newrate2 = newrate2;
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

    public String getMastbuyername() {
        return mastbuyername;
    }

    public void setMastbuyername(String mastbuyername) {
        this.mastbuyername = mastbuyername;
    }

    public String getNewproject1() {
        return newproject1;
    }

    public void setNewproject1(String newproject1) {
        this.newproject1 = newproject1;
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

    public String getFactor09() {
        return factor09;
    }

    public void setFactor09(String factor09) {
        this.factor09 = factor09;
    }

    public String getFactor07() {
        return factor07;
    }

    public void setFactor07(String factor07) {
        this.factor07 = factor07;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getFactor08() {
        return factor08;
    }

    public void setFactor08(String factor08) {
        this.factor08 = factor08;
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

    public String getFactor05() {
        return factor05;
    }

    public void setFactor05(String factor05) {
        this.factor05 = factor05;
    }

    public String getEquipmentName2() {
        return equipmentName2;
    }

    public void setEquipmentName2(String equipmentName2) {
        this.equipmentName2 = equipmentName2;
    }

    public String getFactor06() {
        return factor06;
    }

    public void setFactor06(String factor06) {
        this.factor06 = factor06;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public Double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(Double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getFormulateUser() {
        return formulateUser;
    }

    public void setFormulateUser(String formulateUser) {
        this.formulateUser = formulateUser;
    }

    public String getFormulateDept() {
        return formulateDept;
    }

    public void setFormulateDept(String formulateDept) {
        this.formulateDept = formulateDept;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getFactor02() {
        return factor02;
    }

    public void setFactor02(String factor02) {
        this.factor02 = factor02;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getFactor03() {
        return factor03;
    }

    public void setFactor03(String factor03) {
        this.factor03 = factor03;
    }

    public String getFactor04() {
        return factor04;
    }

    public void setFactor04(String factor04) {
        this.factor04 = factor04;
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

    public String getFactor01() {
        return factor01;
    }

    public void setFactor01(String factor01) {
        this.factor01 = factor01;
    }

    public String getYfPrice() {
        return yfPrice;
    }

    public void setYfPrice(String yfPrice) {
        this.yfPrice = yfPrice;
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
        hash += (formid != null ? formid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCG007Model)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG007";
    }

}
