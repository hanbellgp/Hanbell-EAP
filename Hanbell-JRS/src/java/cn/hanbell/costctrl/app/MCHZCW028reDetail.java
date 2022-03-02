/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCHZCW028reDetail {

    private int no;
    private String summary;
    private String budgetDept;
    private String DeptName;
    private double notaxes;
    private double taxes;
    private double taxInclusive;
    private String budgetAcc;
    private String budgetAccname;
    private String research;
    private String accno;
    private String accName;
    private double accPeriod;
    private double accYear;
    private String product;
    private String entertainObj;
    private String entertainDate;
    private String entertainPeople;
    private String entertainReason;
    private String centerid;
    private String remark;

    public MCHZCW028reDetail() {

    }

    public String getBudgetDept() {
        return budgetDept;
    }

    public void setBudgetDept(String budgetDept) {
        this.budgetDept = budgetDept;
    }

    public String getBudgetAcc() {
        return budgetAcc;
    }

    public void setBudgetAcc(String budgetAcc) {
        this.budgetAcc = budgetAcc;
    }

    public String getBudgetAccname() {
        return budgetAccname;
    }

    public void setBudgetAccname(String budgetAccname) {
        this.budgetAccname = budgetAccname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getNotaxes() {
        return notaxes;
    }

    public void setNotaxes(double notaxes) {
        this.notaxes = notaxes;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTaxInclusive() {
        return taxInclusive;
    }

    public void setTaxInclusive(double taxInclusive) {
        this.taxInclusive = taxInclusive;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getEntertainObj() {
        return entertainObj;
    }

    public void setEntertainObj(String entertainObj) {
        this.entertainObj = entertainObj;
    }

    public String getEntertainPeople() {
        return entertainPeople;
    }

    public void setEntertainPeople(String entertainPeople) {
        this.entertainPeople = entertainPeople;
    }

    public String getEntertainReason() {
        return entertainReason;
    }

    public void setEntertainReason(String entertainReason) {
        this.entertainReason = entertainReason;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public double getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(double accPeriod) {
        this.accPeriod = accPeriod;
    }

    public double getAccYear() {
        return accYear;
    }

    public void setAccYear(double accYear) {
        this.accYear = accYear;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getEntertainDate() {
        return entertainDate;
    }

    public void setEntertainDate(String entertainDate) {
        this.entertainDate = entertainDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
