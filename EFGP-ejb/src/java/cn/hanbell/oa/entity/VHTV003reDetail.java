/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "VH_TV003_reDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV003reDetail.findAll", query = "SELECT v FROM VHTV003reDetail v")
    , @NamedQuery(name = "VHTV003reDetail.findByOid", query = "SELECT v FROM VHTV003reDetail v WHERE v.oid = :oid")
    , @NamedQuery(name = "VHTV003reDetail.findByFSN", query = "SELECT v FROM VHTV003reDetail v WHERE v.formSerialNumber = :fsn")})
public class VHTV003reDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "summary")
    private String summary;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "notaxes")
    private String notaxes;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "taxInclusive")
    private String taxInclusive;
    @Size(max = 255)
    @Column(name = "budgetDept_txt")
    private String budgetDepttxt;
    @Size(max = 255)
    @Column(name = "accno")
    private String accno;
    @Size(max = 255)
    @Column(name = "entertainDate_txt")
    private String entertainDatetxt;
    @Size(max = 255)
    @Column(name = "entertainReason")
    private String entertainReason;
    @Size(max = 255)
    @Column(name = "budgetAcc")
    private String budgetAcc;
    @Size(max = 255)
    @Column(name = "research")
    private String research;
    @Size(max = 255)
    @Column(name = "entertainPeople")
    private String entertainPeople;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "entertainObj")
    private String entertainObj;
    @Size(max = 255)
    @Column(name = "accPeriod")
    private String accPeriod;
    @Size(max = 255)
    @Column(name = "budgetDept_lbl")
    private String budgetDeptlbl;
    @Size(max = 255)
    @Column(name = "accYear")
    private String accYear;
    @Size(max = 255)
    @Column(name = "accName")
    private String accName;
    @Size(max = 255)
    @Column(name = "budgetAccname")
    private String budgetAccname;
    @Size(max = 255)
    @Column(name = "taxes")
    private String taxes;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public VHTV003reDetail() {
    }

    public VHTV003reDetail(String oid) {
        this.oid = oid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getNotaxes() {
        return notaxes;
    }

    public void setNotaxes(String notaxes) {
        this.notaxes = notaxes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTaxInclusive() {
        return taxInclusive;
    }

    public void setTaxInclusive(String taxInclusive) {
        this.taxInclusive = taxInclusive;
    }

    public String getBudgetDepttxt() {
        return budgetDepttxt;
    }

    public void setBudgetDepttxt(String budgetDepttxt) {
        this.budgetDepttxt = budgetDepttxt;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getEntertainDatetxt() {
        return entertainDatetxt;
    }

    public void setEntertainDatetxt(String entertainDatetxt) {
        this.entertainDatetxt = entertainDatetxt;
    }

    public String getEntertainReason() {
        return entertainReason;
    }

    public void setEntertainReason(String entertainReason) {
        this.entertainReason = entertainReason;
    }

    public String getBudgetAcc() {
        return budgetAcc;
    }

    public void setBudgetAcc(String budgetAcc) {
        this.budgetAcc = budgetAcc;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getEntertainPeople() {
        return entertainPeople;
    }

    public void setEntertainPeople(String entertainPeople) {
        this.entertainPeople = entertainPeople;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getEntertainObj() {
        return entertainObj;
    }

    public void setEntertainObj(String entertainObj) {
        this.entertainObj = entertainObj;
    }

    public String getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(String accPeriod) {
        this.accPeriod = accPeriod;
    }

    public String getBudgetDeptlbl() {
        return budgetDeptlbl;
    }

    public void setBudgetDeptlbl(String budgetDeptlbl) {
        this.budgetDeptlbl = budgetDeptlbl;
    }

    public String getAccYear() {
        return accYear;
    }

    public void setAccYear(String accYear) {
        this.accYear = accYear;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getBudgetAccname() {
        return budgetAccname;
    }

    public void setBudgetAccname(String budgetAccname) {
        this.budgetAccname = budgetAccname;
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
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
        if (!(object instanceof VHTV003reDetail)) {
            return false;
        }
        VHTV003reDetail other = (VHTV003reDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV003reDetail[ oid=" + oid + " ]";
    }
    
}
