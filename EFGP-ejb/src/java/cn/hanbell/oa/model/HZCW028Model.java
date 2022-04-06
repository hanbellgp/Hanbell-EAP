/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class HZCW028Model {

    private String facno;
    private String cost;
    private String reimbursement;
    private String appDate;
    private String appUser;
    private String appDept;
    private String CRMNO;
    private double totaltaxInclusive;
    private double totalnotaxesRMB;
    private double totaltaxesRMB;
    private double totaltaxInclusiveRMB;
    private String coin;
    private double ratio;
    private String creator;
    private String srcno;
    private double deptPeriod;
    private double deptYear;
    private String amount;
    private int days;
    private String deptqx; //流程部门
    private String userTitle;

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(String reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public String getAppDept() {
        return appDept;
    }

    public void setAppDept(String appDept) {
        this.appDept = appDept;
    }

    public double getTotaltaxInclusive() {
        return totaltaxInclusive;
    }

    public void setTotaltaxInclusive(double totaltaxInclusive) {
        this.totaltaxInclusive = totaltaxInclusive;
    }

    public double getTotalnotaxesRMB() {
        return totalnotaxesRMB;
    }

    public void setTotalnotaxesRMB(double totalnotaxesRMB) {
        this.totalnotaxesRMB = totalnotaxesRMB;
    }

    public double getTotaltaxesRMB() {
        return totaltaxesRMB;
    }

    public void setTotaltaxesRMB(double totaltaxesRMB) {
        this.totaltaxesRMB = totaltaxesRMB;
    }

    public double getTotaltaxInclusiveRMB() {
        return totaltaxInclusiveRMB;
    }

    public void setTotaltaxInclusiveRMB(double totaltaxInclusiveRMB) {
        this.totaltaxInclusiveRMB = totaltaxInclusiveRMB;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public double getDeptYear() {
        return deptYear;
    }

    public void setDeptYear(double deptYear) {
        this.deptYear = deptYear;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCRMNO() {
        return CRMNO;
    }

    public void setCRMNO(String CRMNO) {
        this.CRMNO = CRMNO;
    }

    public String getDeptqx() {
        return deptqx;
    }

    public void setDeptqx(String deptqx) {
        this.deptqx = deptqx;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

}
