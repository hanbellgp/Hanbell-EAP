/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1491
 */
@XmlRootElement
public class HZCW017Model implements Serializable {

    private String loanProperty;
    private String hdnloanProperty;
    private String facno;
    private String hdnfacno;
    private Date loanDate;
    private String loanUser;
    private String hdnloanUser;
    private String loanDept;
    private String hdnloanDept;
    private String hdncreator;
    private String amount;
    private String reason;
    private String coin;
    private Double ratio;
    private Double loanTotal;
    private Double totalRMB;

    private String preLocation;
    private String people;
    private String days;
    private Double trafficfee;
    private Double accommodation;
    private Double allowance;
    private Double entertain;
    private Double other;
    private String centerid;
    private String preCustomer;
    private String creator;
    private Double deptPeriod;
    private Double deptYear;
    private String preAccno;
    private String preAccname;
    private Double arrears;
    private String product;
    private Date prePayDate;
    private String userTitle;
    private String srcno;

    public HZCW017Model() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZCW017Model)) {
            return false;
        }
        HZCW017Model hzcw017m = (HZCW017Model) object;
        if ((this.getLoanUser() != null) && (hzcw017m.getLoanUser() != null)) {
            return this.getLoanUser().equals(hzcw017m.getLoanUser());
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW017";
    }

    public String getLoanProperty() {
        return loanProperty;
    }

    public void setLoanProperty(String loanProperty) {
        this.loanProperty = loanProperty;
    }

    public String getHdnloanProperty() {
        return hdnloanProperty;
    }

    public void setHdnloanProperty(String hdnloanProperty) {
        this.hdnloanProperty = hdnloanProperty;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHdnfacno() {
        return hdnfacno;
    }

    public void setHdnfacno(String hdnfacno) {
        this.hdnfacno = hdnfacno;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(String loanUser) {
        this.loanUser = loanUser;
    }

    public String getHdnloanUser() {
        return hdnloanUser;
    }

    public void setHdnloanUser(String hdnloanUser) {
        this.hdnloanUser = hdnloanUser;
    }

    public String getLoanDept() {
        return loanDept;
    }

    public void setLoanDept(String loanDept) {
        this.loanDept = loanDept;
    }

    public String getHdnloanDept() {
        return hdnloanDept;
    }

    public void setHdnloanDept(String hdnloanDept) {
        this.hdnloanDept = hdnloanDept;
    }

    public String getHdncreator() {
        return hdncreator;
    }

    public void setHdncreator(String hdncreator) {
        this.hdncreator = hdncreator;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(Double loanTotal) {
        this.loanTotal = loanTotal;
    }

    public Double getTotalRMB() {
        return totalRMB;
    }

    public void setTotalRMB(Double totalRMB) {
        this.totalRMB = totalRMB;
    }

    public String getPreLocation() {
        return preLocation;
    }

    public void setPreLocation(String preLocation) {
        this.preLocation = preLocation;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Double getTrafficfee() {
        return trafficfee;
    }

    public void setTrafficfee(Double trafficfee) {
        this.trafficfee = trafficfee;
    }

    public Double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Double accommodation) {
        this.accommodation = accommodation;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public Double getEntertain() {
        return entertain;
    }

    public void setEntertain(Double entertain) {
        this.entertain = entertain;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getPreCustomer() {
        return preCustomer;
    }

    public void setPreCustomer(String preCustomer) {
        this.preCustomer = preCustomer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(Double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public Double getDeptYear() {
        return deptYear;
    }

    public void setDeptYear(Double deptYear) {
        this.deptYear = deptYear;
    }

    public String getPreAccno() {
        return preAccno;
    }

    public void setPreAccno(String preAccno) {
        this.preAccno = preAccno;
    }

    public String getPreAccname() {
        return preAccname;
    }

    public void setPreAccname(String preAccname) {
        this.preAccname = preAccname;
    }

    public Double getArrears() {
        return arrears;
    }

    public void setArrears(Double arrears) {
        this.arrears = arrears;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getPrePayDate() {
        return prePayDate;
    }

    public void setPrePayDate(Date prePayDate) {
        this.prePayDate = prePayDate;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

}
