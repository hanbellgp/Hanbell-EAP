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
 * @author C0160
 */
@Entity
@Table(name = "HK_CW002")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW002.findAll", query = "SELECT h FROM HKCW002 h"),
    @NamedQuery(name = "HKCW002.findByOID", query = "SELECT h FROM HKCW002 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW002.findByPSN", query = "SELECT h FROM HKCW002 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW002.findByFSN", query = "SELECT h FROM HKCW002 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW002.findBySrcformid", query = "SELECT h FROM HKCW002 h WHERE h.srcformid = :srcformid"),
    @NamedQuery(name = "HKCW002.findNotAcceptance", query = "SELECT h FROM HKCW002 h WHERE h.purchase = '1' AND (NOT h.hkcg007 IS NULL) AND h.hkcg007<>'' AND  ((h.relformid IS NULL) OR (h.relformid=''))"),
    @NamedQuery(name = "HKCW002.findNotAcceptanceByPSN", query = "SELECT h FROM HKCW002 h WHERE h.purchase in ('1','XJ') AND (NOT h.hkcg007 IS NULL) AND h.hkcg007<>'' AND  ((h.relformid IS NULL) OR (h.relformid='')) AND h.processSerialNumber = :psn ")})
public class HKCW002 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "applyDeptno")
    private String applyDeptno;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "used")
    private String used;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "deptyearbal")
    private Double deptyearbal;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "emgyn")
    private String emgyn;
    @Size(max = 255)
    @Column(name = "adviceBrand")
    private String adviceBrand;
    @Size(max = 255)
    @Column(name = "formulateDept")
    private String formulateDept;
    @Column(name = "formdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formdate;
    @Column(name = "formulateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formulateDate;
    @Size(max = 255)
    @Column(name = "origproject1")
    private String origproject1;
    @Size(max = 255)
    @Column(name = "origproject2")
    private String origproject2;
    @Size(max = 255)
    @Column(name = "planqty")
    private String planqty;
    @Column(name = "qty")
    private Integer qty;
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
    @Size(max = 255)
    @Column(name = "equipmentName")
    private String equipmentName;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private Double price;
    @Column(name = "totalamts")
    private Double totalamts;
    @Size(max = 255)
    @Column(name = "itemspec")
    private String itemspec;
    @Size(max = 255)
    @Column(name = "prkind")
    private String prkind;
    @Size(max = 255)
    @Column(name = "dmark1desc")
    private String dmark1desc;
    @Size(max = 255)
    @Column(name = "conclusion")
    private String conclusion;
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
    @Column(name = "factor05")
    private String factor05;
    @Size(max = 255)
    @Column(name = "factor04")
    private String factor04;
    @Size(max = 255)
    @Column(name = "factor03")
    private String factor03;
    @Size(max = 255)
    @Column(name = "origqty2")
    private String origqty2;
    @Size(max = 255)
    @Column(name = "factor02")
    private String factor02;
    @Size(max = 255)
    @Column(name = "equipmentName2")
    private String equipmentName2;
    @Size(max = 255)
    @Column(name = "origqty1")
    private String origqty1;
    @Size(max = 255)
    @Column(name = "factor01")
    private String factor01;
    @Column(name = "deptperbal")
    private Double deptperbal;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "attribute")
    private String attribute;
    @Size(max = 255)
    @Column(name = "purchase")
    private String purchase;
    @Size(max = 255)
    @Column(name = "protype")
    private String protype;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "HKCG007")
    private String hkcg007;
    @Column(name = "accyearbal")
    private Double accyearbal;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "factor09")
    private String factor09;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Size(max = 255)
    @Column(name = "newrate2")
    private String newrate2;
    @Size(max = 255)
    @Column(name = "dmark2desc")
    private String dmark2desc;
    @Column(name = "totalamt")
    private Double totalamt;
    @Column(name = "rate")
    private Double rate;
    @Size(max = 255)
    @Column(name = "newrate1")
    private String newrate1;
    @Size(max = 255)
    @Column(name = "hmark1")
    private String hmark1;
    @Column(name = "accperbal")
    private Double accperbal;
    @Size(max = 255)
    @Column(name = "requireUserno")
    private String requireUserno;
    @Column(name = "disqty")
    private Integer disqty;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "requireDeptno")
    private String requireDeptno;
    @Column(name = "amts")
    private Double amts;
    @Size(max = 255)
    @Column(name = "itemdesc")
    private String itemdesc;
    @Size(max = 255)
    @Column(name = "formulateUser")
    private String formulateUser;
    @Size(max = 255)
    @Column(name = "factor12")
    private String factor12;
    @Size(max = 255)
    @Column(name = "vendor")
    private String vendor;
    @Size(max = 255)
    @Column(name = "categoryDesc")
    private String categoryDesc;
    @Size(max = 255)
    @Column(name = "newqty1")
    private String newqty1;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @Column(name = "purqty")
    private Integer purqty;
    @Size(max = 255)
    @Column(name = "equipmentSpec")
    private String equipmentSpec;
    @Column(name = "rqtdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rqtdate;
    @Size(max = 255)
    @Column(name = "newqty2")
    private String newqty2;
    @Size(max = 255)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 255)
    @Column(name = "factor10")
    private String factor10;
    @Size(max = 255)
    @Column(name = "factor11")
    private String factor11;
    @Size(max = 255)
    @Column(name = "applyUserno")
    private String applyUserno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "srcformid")
    private String srcformid;
    @Size(max = 255)
    @Column(name = "relformid")
    private String relformid;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;

    public HKCW002() {
    }

    public HKCW002(String oid) {
        this.oid = oid;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getApplyDeptno() {
        return applyDeptno;
    }

    public void setApplyDeptno(String applyDeptno) {
        this.applyDeptno = applyDeptno;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public Double getDeptyearbal() {
        return deptyearbal;
    }

    public void setDeptyearbal(Double deptyearbal) {
        this.deptyearbal = deptyearbal;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
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

    public String getFormulateDept() {
        return formulateDept;
    }

    public void setFormulateDept(String formulateDept) {
        this.formulateDept = formulateDept;
    }

    public Date getFormdate() {
        return formdate;
    }

    public void setFormdate(Date formdate) {
        this.formdate = formdate;
    }

    public Date getFormulateDate() {
        return formulateDate;
    }

    public void setFormulateDate(Date formulateDate) {
        this.formulateDate = formulateDate;
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

    public String getPlanqty() {
        return planqty;
    }

    public void setPlanqty(String planqty) {
        this.planqty = planqty;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalamts() {
        return totalamts;
    }

    public void setTotalamts(Double totalamts) {
        this.totalamts = totalamts;
    }

    public String getItemspec() {
        return itemspec;
    }

    public void setItemspec(String itemspec) {
        this.itemspec = itemspec;
    }

    public String getPrkind() {
        return prkind;
    }

    public void setPrkind(String prkind) {
        this.prkind = prkind;
    }

    public String getDmark1desc() {
        return dmark1desc;
    }

    public void setDmark1desc(String dmark1desc) {
        this.dmark1desc = dmark1desc;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
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

    public String getOrigqty2() {
        return origqty2;
    }

    public void setOrigqty2(String origqty2) {
        this.origqty2 = origqty2;
    }

    public String getFactor02() {
        return factor02;
    }

    public void setFactor02(String factor02) {
        this.factor02 = factor02;
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

    public String getFactor01() {
        return factor01;
    }

    public void setFactor01(String factor01) {
        this.factor01 = factor01;
    }

    public Double getDeptperbal() {
        return deptperbal;
    }

    public void setDeptperbal(Double deptperbal) {
        this.deptperbal = deptperbal;
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

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
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

    public String getHkcg007() {
        return hkcg007;
    }

    public void setHkcg007(String hkcg007) {
        this.hkcg007 = hkcg007;
    }

    public Double getAccyearbal() {
        return accyearbal;
    }

    public void setAccyearbal(Double accyearbal) {
        this.accyearbal = accyearbal;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNewrate2() {
        return newrate2;
    }

    public void setNewrate2(String newrate2) {
        this.newrate2 = newrate2;
    }

    public String getDmark2desc() {
        return dmark2desc;
    }

    public void setDmark2desc(String dmark2desc) {
        this.dmark2desc = dmark2desc;
    }

    public Double getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Double totalamt) {
        this.totalamt = totalamt;
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

    public Double getAccperbal() {
        return accperbal;
    }

    public void setAccperbal(Double accperbal) {
        this.accperbal = accperbal;
    }

    public String getRequireUserno() {
        return requireUserno;
    }

    public void setRequireUserno(String requireUserno) {
        this.requireUserno = requireUserno;
    }

    public Integer getDisqty() {
        return disqty;
    }

    public void setDisqty(Integer disqty) {
        this.disqty = disqty;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getRequireDeptno() {
        return requireDeptno;
    }

    public void setRequireDeptno(String requireDeptno) {
        this.requireDeptno = requireDeptno;
    }

    public Double getAmts() {
        return amts;
    }

    public void setAmts(Double amts) {
        this.amts = amts;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public String getFormulateUser() {
        return formulateUser;
    }

    public void setFormulateUser(String formulateUser) {
        this.formulateUser = formulateUser;
    }

    public String getFactor12() {
        return factor12;
    }

    public void setFactor12(String factor12) {
        this.factor12 = factor12;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getNewqty1() {
        return newqty1;
    }

    public void setNewqty1(String newqty1) {
        this.newqty1 = newqty1;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPurqty() {
        return purqty;
    }

    public void setPurqty(Integer purqty) {
        this.purqty = purqty;
    }

    public String getEquipmentSpec() {
        return equipmentSpec;
    }

    public void setEquipmentSpec(String equipmentSpec) {
        this.equipmentSpec = equipmentSpec;
    }

    public Date getRqtdate() {
        return rqtdate;
    }

    public void setRqtdate(Date rqtdate) {
        this.rqtdate = rqtdate;
    }

    public String getNewqty2() {
        return newqty2;
    }

    public void setNewqty2(String newqty2) {
        this.newqty2 = newqty2;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
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

    public String getApplyUserno() {
        return applyUserno;
    }

    public void setApplyUserno(String applyUserno) {
        this.applyUserno = applyUserno;
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
        if (!(object instanceof HKCW002)) {
            return false;
        }
        HKCW002 other = (HKCW002) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW002[ oid=" + oid + " ]";
    }

    /**
     * @return the srcformid
     */
    public String getSrcformid() {
        return srcformid;
    }

    /**
     * @param srcformid the srcformid to set
     */
    public void setSrcformid(String srcformid) {
        this.srcformid = srcformid;
    }

    /**
     * @return the relformid
     */
    public String getRelformid() {
        return relformid;
    }

    /**
     * @param relformid the relformid to set
     */
    public void setRelformid(String relformid) {
        this.relformid = relformid;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

}
