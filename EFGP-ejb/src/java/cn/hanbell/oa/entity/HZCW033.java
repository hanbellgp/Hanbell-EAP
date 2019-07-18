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
@Table(name = "HZ_CW033")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW033.findAll", query = "SELECT j FROM HZCW033 j"),
    @NamedQuery(name = "HZCW033.findBySummary", query = "SELECT j FROM HZCW033 j WHERE j.summary = :summary"),
    @NamedQuery(name = "HZCW033.findByAppDept", query = "SELECT j FROM HZCW033 j WHERE j.appDept = :appDept"),
    @NamedQuery(name = "HZCW033.findByCenterid", query = "SELECT j FROM HZCW033 j WHERE j.centerid = :centerid"),
    @NamedQuery(name = "HZCW033.findByAllowance", query = "SELECT j FROM HZCW033 j WHERE j.allowance = :allowance"),
    @NamedQuery(name = "HZCW033.findByRemark", query = "SELECT j FROM HZCW033 j WHERE j.remark = :remark"),
    @NamedQuery(name = "HZCW033.findByTrafficSummary", query = "SELECT j FROM HZCW033 j WHERE j.trafficSummary = :trafficSummary"),
    @NamedQuery(name = "HZCW033.findByBh3", query = "SELECT j FROM HZCW033 j WHERE j.bh3 = :bh3"),
    @NamedQuery(name = "HZCW033.findByBh2", query = "SELECT j FROM HZCW033 j WHERE j.bh2 = :bh2"),
    @NamedQuery(name = "HZCW033.findByReceipt", query = "SELECT j FROM HZCW033 j WHERE j.receipt = :receipt"),
    @NamedQuery(name = "HZCW033.findByLoanNo", query = "SELECT j FROM HZCW033 j WHERE j.loanNo = :loanNo"),
    @NamedQuery(name = "HZCW033.findByCarUse", query = "SELECT j FROM HZCW033 j WHERE j.carUse = :carUse"),
    @NamedQuery(name = "HZCW033.findByStartMileage", query = "SELECT j FROM HZCW033 j WHERE j.startMileage = :startMileage"),
    @NamedQuery(name = "HZCW033.findByBh1", query = "SELECT j FROM HZCW033 j WHERE j.bh1 = :bh1"),
    @NamedQuery(name = "HZCW033.findByAmount", query = "SELECT j FROM HZCW033 j WHERE j.amount = :amount"),
    @NamedQuery(name = "HZCW033.findByTravelReport", query = "SELECT j FROM HZCW033 j WHERE j.travelReport = :travelReport"),
    @NamedQuery(name = "HZCW033.findByJc2", query = "SELECT j FROM HZCW033 j WHERE j.jc2 = :jc2"),
    @NamedQuery(name = "HZCW033.findByJc1", query = "SELECT j FROM HZCW033 j WHERE j.jc1 = :jc1"),
    @NamedQuery(name = "HZCW033.findByJc3", query = "SELECT j FROM HZCW033 j WHERE j.jc3 = :jc3"),
    @NamedQuery(name = "HZCW033.findByTotalMileage", query = "SELECT j FROM HZCW033 j WHERE j.totalMileage = :totalMileage"),
    @NamedQuery(name = "HZCW033.findByDeptYear", query = "SELECT j FROM HZCW033 j WHERE j.deptYear = :deptYear"),
    @NamedQuery(name = "HZCW033.findBySubtotal", query = "SELECT j FROM HZCW033 j WHERE j.subtotal = :subtotal"),
    @NamedQuery(name = "HZCW033.findByCost", query = "SELECT j FROM HZCW033 j WHERE j.cost = :cost"),
    @NamedQuery(name = "HZCW033.findByEntertainObj", query = "SELECT j FROM HZCW033 j WHERE j.entertainObj = :entertainObj"),
    @NamedQuery(name = "HZCW033.findByRatio", query = "SELECT j FROM HZCW033 j WHERE j.ratio = :ratio"),
    @NamedQuery(name = "HZCW033.findByAccName", query = "SELECT j FROM HZCW033 j WHERE j.accName = :accName"),
    @NamedQuery(name = "HZCW033.findByApplyAmount", query = "SELECT j FROM HZCW033 j WHERE j.applyAmount = :applyAmount"),
    @NamedQuery(name = "HZCW033.findByOid", query = "SELECT j FROM HZCW033 j WHERE j.oid = :oid"),
    @NamedQuery(name = "HZCW033.findByEndMileage", query = "SELECT j FROM HZCW033 j WHERE j.endMileage = :endMileage"),
    @NamedQuery(name = "HZCW033.findByTaxi", query = "SELECT j FROM HZCW033 j WHERE j.taxi = :taxi"),
    @NamedQuery(name = "HZCW033.findByLoanAmount", query = "SELECT j FROM HZCW033 j WHERE j.loanAmount = :loanAmount"),
    @NamedQuery(name = "HZCW033.findByNotaxes", query = "SELECT j FROM HZCW033 j WHERE j.notaxes = :notaxes"),
    @NamedQuery(name = "HZCW033.findByTotaltaxInclusiveRMB", query = "SELECT j FROM HZCW033 j WHERE j.totaltaxInclusiveRMB = :totaltaxInclusiveRMB"),
    @NamedQuery(name = "HZCW033.findByTaxInclusive", query = "SELECT j FROM HZCW033 j WHERE j.taxInclusive = :taxInclusive"),
    @NamedQuery(name = "HZCW033.findByAccno", query = "SELECT j FROM HZCW033 j WHERE j.accno = :accno"),
    @NamedQuery(name = "HZCW033.findByEntertainReason", query = "SELECT j FROM HZCW033 j WHERE j.entertainReason = :entertainReason"),
    @NamedQuery(name = "HZCW033.findByTotaltaxesRMB", query = "SELECT j FROM HZCW033 j WHERE j.totaltaxesRMB = :totaltaxesRMB"),
    @NamedQuery(name = "HZCW033.findByFacno", query = "SELECT j FROM HZCW033 j WHERE j.facno = :facno"),
    @NamedQuery(name = "HZCW033.findByTrafficfee", query = "SELECT j FROM HZCW033 j WHERE j.trafficfee = :trafficfee"),
    @NamedQuery(name = "HZCW033.findByCreator", query = "SELECT j FROM HZCW033 j WHERE j.creator = :creator"),
    @NamedQuery(name = "HZCW033.findByAccPeriod", query = "SELECT j FROM HZCW033 j WHERE j.accPeriod = :accPeriod"),
    @NamedQuery(name = "HZCW033.findByCrmno", query = "SELECT j FROM HZCW033 j WHERE j.crmno = :crmno"),
    @NamedQuery(name = "HZCW033.findByAccYear", query = "SELECT j FROM HZCW033 j WHERE j.accYear = :accYear"),
    @NamedQuery(name = "HZCW033.findByRefund", query = "SELECT j FROM HZCW033 j WHERE j.refund = :refund"),
    @NamedQuery(name = "HZCW033.findByCustomerSno", query = "SELECT j FROM HZCW033 j WHERE j.customerSno = :customerSno"),
    @NamedQuery(name = "HZCW033.findByEntertainDate", query = "SELECT j FROM HZCW033 j WHERE j.entertainDate = :entertainDate"),
    @NamedQuery(name = "HZCW033.findByTotaltaxInclusive", query = "SELECT j FROM HZCW033 j WHERE j.totaltaxInclusive = :totaltaxInclusive"),
    @NamedQuery(name = "HZCW033.findByPSN", query = "SELECT j FROM HZCW033 j WHERE j.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW033.findByTrafficPlace", query = "SELECT j FROM HZCW033 j WHERE j.trafficPlace = :trafficPlace"),
    @NamedQuery(name = "HZCW033.findByAppDate", query = "SELECT j FROM HZCW033 j WHERE j.appDate = :appDate"),
    @NamedQuery(name = "HZCW033.findByDeptPeriod", query = "SELECT j FROM HZCW033 j WHERE j.deptPeriod = :deptPeriod"),
    @NamedQuery(name = "HZCW033.findByTrafficDate", query = "SELECT j FROM HZCW033 j WHERE j.trafficDate = :trafficDate"),
    @NamedQuery(name = "HZCW033.findByLoanProp", query = "SELECT j FROM HZCW033 j WHERE j.loanProp = :loanProp"),
    @NamedQuery(name = "HZCW033.findByBudgetDept", query = "SELECT j FROM HZCW033 j WHERE j.budgetDept = :budgetDept"),
    @NamedQuery(name = "HZCW033.findByCoin", query = "SELECT j FROM HZCW033 j WHERE j.coin = :coin"),
    @NamedQuery(name = "HZCW033.findByTotalnotaxesRMB", query = "SELECT j FROM HZCW033 j WHERE j.totalnotaxesRMB = :totalnotaxesRMB"),
    @NamedQuery(name = "HZCW033.findByReimbursement", query = "SELECT j FROM HZCW033 j WHERE j.reimbursement = :reimbursement"),
    @NamedQuery(name = "HZCW033.findByBudgetAcc", query = "SELECT j FROM HZCW033 j WHERE j.budgetAcc = :budgetAcc"),
    @NamedQuery(name = "HZCW033.findByResearch", query = "SELECT j FROM HZCW033 j WHERE j.research = :research"),
    @NamedQuery(name = "HZCW033.findByEntertainPeople", query = "SELECT j FROM HZCW033 j WHERE j.entertainPeople = :entertainPeople"),
    @NamedQuery(name = "HZCW033.findBySort3", query = "SELECT j FROM HZCW033 j WHERE j.sort3 = :sort3"),
    @NamedQuery(name = "HZCW033.findByProduct", query = "SELECT j FROM HZCW033 j WHERE j.product = :product"),
    @NamedQuery(name = "HZCW033.findBySort2", query = "SELECT j FROM HZCW033 j WHERE j.sort2 = :sort2"),
    @NamedQuery(name = "HZCW033.findByServiceno", query = "SELECT j FROM HZCW033 j WHERE j.serviceno = :serviceno"),
    @NamedQuery(name = "HZCW033.findByAppUser", query = "SELECT j FROM HZCW033 j WHERE j.appUser = :appUser"),
    @NamedQuery(name = "HZCW033.findByDays", query = "SELECT j FROM HZCW033 j WHERE j.days = :days"),
    @NamedQuery(name = "HZCW033.findByAccommodation", query = "SELECT j FROM HZCW033 j WHERE j.accommodation = :accommodation"),
    @NamedQuery(name = "HZCW033.findBySort1", query = "SELECT j FROM HZCW033 j WHERE j.sort1 = :sort1"),
    @NamedQuery(name = "HZCW033.findByBudgetAccname", query = "SELECT j FROM HZCW033 j WHERE j.budgetAccname = :budgetAccname"),
    @NamedQuery(name = "HZCW033.findByTaxes", query = "SELECT j FROM HZCW033 j WHERE j.taxes = :taxes"),
    @NamedQuery(name = "HZCW033.findByFormSerialNumber", query = "SELECT j FROM HZCW033 j WHERE j.formSerialNumber = :formSerialNumber")})
public class HZCW033 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "summary")
    private String summary;
    @Size(max = 255)
    @Column(name = "appDept")
    private String appDept;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "allowance")
    private Double allowance;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "trafficSummary")
    private String trafficSummary;
    @Size(max = 255)
    @Column(name = "bh3")
    private String bh3;
    @Size(max = 255)
    @Column(name = "bh2")
    private String bh2;
    @Column(name = "receipt")
    private Integer receipt;
    @Size(max = 255)
    @Column(name = "loanNo")
    private String loanNo;
    @Size(max = 255)
    @Column(name = "carUse")
    private String carUse;
    @Column(name = "startMileage")
    private Double startMileage;
    @Size(max = 255)
    @Column(name = "bh1")
    private String bh1;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "travelReport")
    private String travelReport;
    @Size(max = 255)
    @Column(name = "jc2")
    private String jc2;
    @Size(max = 255)
    @Column(name = "jc1")
    private String jc1;
    @Size(max = 255)
    @Column(name = "jc3")
    private String jc3;
    @Column(name = "totalMileage")
    private Double totalMileage;
    @Column(name = "deptYear")
    private Double deptYear;
    @Column(name = "subtotal")
    private Double subtotal;
    @Size(max = 255)
    @Column(name = "cost")
    private String cost;
    @Size(max = 255)
    @Column(name = "entertainObj")
    private String entertainObj;
    @Column(name = "ratio")
    private Double ratio;
    @Size(max = 255)
    @Column(name = "accName")
    private String accName;
    @Column(name = "applyAmount")
    private Double applyAmount;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "endMileage")
    private Double endMileage;
    @Column(name = "taxi")
    private Double taxi;
    @Column(name = "loanAmount")
    private Double loanAmount;
    @Column(name = "notaxes")
    private Double notaxes;
    @Column(name = "totaltaxInclusiveRMB")
    private Double totaltaxInclusiveRMB;
    @Column(name = "taxInclusive")
    private Double taxInclusive;
    @Size(max = 255)
    @Column(name = "accno")
    private String accno;
    @Size(max = 255)
    @Column(name = "entertainReason")
    private String entertainReason;
    @Column(name = "totaltaxesRMB")
    private Double totaltaxesRMB;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Column(name = "trafficfee")
    private Double trafficfee;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Column(name = "accPeriod")
    private Double accPeriod;
    @Size(max = 255)
    @Column(name = "CRMNO")
    private String crmno;
    @Column(name = "accYear")
    private Double accYear;
    @Column(name = "refund")
    private Double refund;
    @Size(max = 255)
    @Column(name = "customerSno")
    private String customerSno;
    @Column(name = "entertainDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entertainDate;
    @Column(name = "totaltaxInclusive")
    private Double totaltaxInclusive;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "trafficPlace")
    private String trafficPlace;
    @Column(name = "appDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appDate;
    @Column(name = "deptPeriod")
    private Double deptPeriod;
    @Column(name = "trafficDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trafficDate;
    @Size(max = 255)
    @Column(name = "loanProp")
    private String loanProp;
    @Size(max = 255)
    @Column(name = "budgetDept")
    private String budgetDept;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Column(name = "totalnotaxesRMB")
    private Double totalnotaxesRMB;
    @Size(max = 255)
    @Column(name = "reimbursement")
    private String reimbursement;
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
    @Column(name = "sort3")
    private String sort3;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "sort2")
    private String sort2;
    @Size(max = 255)
    @Column(name = "serviceno")
    private String serviceno;
    @Size(max = 255)
    @Column(name = "appUser")
    private String appUser;
    @Column(name = "days")
    private Integer days;
    @Column(name = "accommodation")
    private Double accommodation;
    @Size(max = 255)
    @Column(name = "sort1")
    private String sort1;
    @Size(max = 255)
    @Column(name = "budgetAccname")
    private String budgetAccname;
    @Column(name = "taxes")
    private Double taxes;

    @Column(name = "totalRefund")
    private Double totalRefund;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HZCW033() {
    }

    public HZCW033(String oid) {
        this.oid = oid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAppDept() {
        return appDept;
    }

    public void setAppDept(String appDept) {
        this.appDept = appDept;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTrafficSummary() {
        return trafficSummary;
    }

    public void setTrafficSummary(String trafficSummary) {
        this.trafficSummary = trafficSummary;
    }

    public String getBh3() {
        return bh3;
    }

    public void setBh3(String bh3) {
        this.bh3 = bh3;
    }

    public String getBh2() {
        return bh2;
    }

    public void setBh2(String bh2) {
        this.bh2 = bh2;
    }

    public Integer getReceipt() {
        return receipt;
    }

    public void setReceipt(Integer receipt) {
        this.receipt = receipt;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getCarUse() {
        return carUse;
    }

    public void setCarUse(String carUse) {
        this.carUse = carUse;
    }

    public Double getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(Double startMileage) {
        this.startMileage = startMileage;
    }

    public String getBh1() {
        return bh1;
    }

    public void setBh1(String bh1) {
        this.bh1 = bh1;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTravelReport() {
        return travelReport;
    }

    public void setTravelReport(String travelReport) {
        this.travelReport = travelReport;
    }

    public String getJc2() {
        return jc2;
    }

    public void setJc2(String jc2) {
        this.jc2 = jc2;
    }

    public String getJc1() {
        return jc1;
    }

    public void setJc1(String jc1) {
        this.jc1 = jc1;
    }

    public String getJc3() {
        return jc3;
    }

    public void setJc3(String jc3) {
        this.jc3 = jc3;
    }

    public Double getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Double totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Double getDeptYear() {
        return deptYear;
    }

    public void setDeptYear(Double deptYear) {
        this.deptYear = deptYear;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getEntertainObj() {
        return entertainObj;
    }

    public void setEntertainObj(String entertainObj) {
        this.entertainObj = entertainObj;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(Double endMileage) {
        this.endMileage = endMileage;
    }

    public Double getTaxi() {
        return taxi;
    }

    public void setTaxi(Double taxi) {
        this.taxi = taxi;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getNotaxes() {
        return notaxes;
    }

    public void setNotaxes(Double notaxes) {
        this.notaxes = notaxes;
    }

    public Double getTotaltaxInclusiveRMB() {
        return totaltaxInclusiveRMB;
    }

    public void setTotaltaxInclusiveRMB(Double totaltaxInclusiveRMB) {
        this.totaltaxInclusiveRMB = totaltaxInclusiveRMB;
    }

    public Double getTaxInclusive() {
        return taxInclusive;
    }

    public void setTaxInclusive(Double taxInclusive) {
        this.taxInclusive = taxInclusive;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getEntertainReason() {
        return entertainReason;
    }

    public void setEntertainReason(String entertainReason) {
        this.entertainReason = entertainReason;
    }

    public Double getTotaltaxesRMB() {
        return totaltaxesRMB;
    }

    public void setTotaltaxesRMB(Double totaltaxesRMB) {
        this.totaltaxesRMB = totaltaxesRMB;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Double getTrafficfee() {
        return trafficfee;
    }

    public void setTrafficfee(Double trafficfee) {
        this.trafficfee = trafficfee;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(Double accPeriod) {
        this.accPeriod = accPeriod;
    }

    public String getCrmno() {
        return crmno;
    }

    public void setCrmno(String crmno) {
        this.crmno = crmno;
    }

    public Double getAccYear() {
        return accYear;
    }

    public void setAccYear(Double accYear) {
        this.accYear = accYear;
    }

    public Double getRefund() {
        return refund;
    }

    public void setRefund(Double refund) {
        this.refund = refund;
    }

    public String getCustomerSno() {
        return customerSno;
    }

    public void setCustomerSno(String customerSno) {
        this.customerSno = customerSno;
    }

    public Date getEntertainDate() {
        return entertainDate;
    }

    public void setEntertainDate(Date entertainDate) {
        this.entertainDate = entertainDate;
    }

    public Double getTotaltaxInclusive() {
        return totaltaxInclusive;
    }

    public void setTotaltaxInclusive(Double totaltaxInclusive) {
        this.totaltaxInclusive = totaltaxInclusive;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getTrafficPlace() {
        return trafficPlace;
    }

    public void setTrafficPlace(String trafficPlace) {
        this.trafficPlace = trafficPlace;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Double getDeptPeriod() {
        return deptPeriod;
    }

    public void setDeptPeriod(Double deptPeriod) {
        this.deptPeriod = deptPeriod;
    }

    public Date getTrafficDate() {
        return trafficDate;
    }

    public void setTrafficDate(Date trafficDate) {
        this.trafficDate = trafficDate;
    }

    public String getLoanProp() {
        return loanProp;
    }

    public void setLoanProp(String loanProp) {
        this.loanProp = loanProp;
    }

    public String getBudgetDept() {
        return budgetDept;
    }

    public void setBudgetDept(String budgetDept) {
        this.budgetDept = budgetDept;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Double getTotalnotaxesRMB() {
        return totalnotaxesRMB;
    }

    public void setTotalnotaxesRMB(Double totalnotaxesRMB) {
        this.totalnotaxesRMB = totalnotaxesRMB;
    }

    public String getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(String reimbursement) {
        this.reimbursement = reimbursement;
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

    public String getSort3() {
        return sort3;
    }

    public void setSort3(String sort3) {
        this.sort3 = sort3;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSort2() {
        return sort2;
    }

    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Double accommodation) {
        this.accommodation = accommodation;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getBudgetAccname() {
        return budgetAccname;
    }

    public void setBudgetAccname(String budgetAccname) {
        this.budgetAccname = budgetAccname;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }
    
    public Double getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Double totalRefund) {
        this.totalRefund = totalRefund;
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
        if (!(object instanceof HZCW033)) {
            return false;
        }
        HZCW033 other = (HZCW033) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW033[ oid=" + oid + " ]";
    }

    public Object setApplyAmount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
