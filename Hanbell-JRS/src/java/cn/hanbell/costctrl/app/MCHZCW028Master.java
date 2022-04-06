/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCHZCW028Master {

    private String facno;
    private String cost;
    private String reimbursement;
    private Date appDate;
    private String appUser;
    private String appDept;
    private String crmno;
    private double totaltaxInclusive;
    private double totalnotaxesRMB;
    private double totaltaxesRMB;
    private double totaltaxInclusiveRMB;
    private String coin;
    private double ratio;
    private String creator;
    private String srcno;

    public MCHZCW028Master() {

    }

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

    public String getCrmno() {
        return crmno;
    }

    public void setCrmno(String crmno) {
        this.crmno = crmno;
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

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }
}
