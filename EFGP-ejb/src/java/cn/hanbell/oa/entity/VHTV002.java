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
@Table(name = "VH_TV002")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV002.findAll", query = "SELECT v FROM VHTV002 v"),
    @NamedQuery(name = "VHTV002.findBySummary", query = "SELECT v FROM VHTV002 v WHERE v.summary = :summary"),
    @NamedQuery(name = "VHTV002.findByAppDept", query = "SELECT v FROM VHTV002 v WHERE v.appDept = :appDept"),
    @NamedQuery(name = "VHTV002.findByCenterid", query = "SELECT v FROM VHTV002 v WHERE v.centerid = :centerid"),
    @NamedQuery(name = "VHTV002.findByAllowance", query = "SELECT v FROM VHTV002 v WHERE v.allowance = :allowance"),
    @NamedQuery(name = "VHTV002.findByRemark", query = "SELECT v FROM VHTV002 v WHERE v.remark = :remark"),
    @NamedQuery(name = "VHTV002.findByTrafficSummary", query = "SELECT v FROM VHTV002 v WHERE v.trafficSummary = :trafficSummary"),
    @NamedQuery(name = "VHTV002.findByException", query = "SELECT v FROM VHTV002 v WHERE v.exception = :exception"),
    @NamedQuery(name = "VHTV002.findByBh3", query = "SELECT v FROM VHTV002 v WHERE v.bh3 = :bh3"),
    @NamedQuery(name = "VHTV002.findByBh2", query = "SELECT v FROM VHTV002 v WHERE v.bh2 = :bh2"),
    @NamedQuery(name = "VHTV002.findByReceipt", query = "SELECT v FROM VHTV002 v WHERE v.receipt = :receipt"),
    @NamedQuery(name = "VHTV002.findByLoanNo", query = "SELECT v FROM VHTV002 v WHERE v.loanNo = :loanNo"),
    @NamedQuery(name = "VHTV002.findByCarUse", query = "SELECT v FROM VHTV002 v WHERE v.carUse = :carUse"),
    @NamedQuery(name = "VHTV002.findByStartMileage", query = "SELECT v FROM VHTV002 v WHERE v.startMileage = :startMileage"),
    @NamedQuery(name = "VHTV002.findByDeptqx", query = "SELECT v FROM VHTV002 v WHERE v.deptqx = :deptqx"),
    @NamedQuery(name = "VHTV002.findByBh1", query = "SELECT v FROM VHTV002 v WHERE v.bh1 = :bh1"),
    @NamedQuery(name = "VHTV002.findByAmount", query = "SELECT v FROM VHTV002 v WHERE v.amount = :amount"),
    @NamedQuery(name = "VHTV002.findBySerialNumber", query = "SELECT v FROM VHTV002 v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "VHTV002.findByTravelReport", query = "SELECT v FROM VHTV002 v WHERE v.travelReport = :travelReport"),
    @NamedQuery(name = "VHTV002.findByJc2", query = "SELECT v FROM VHTV002 v WHERE v.jc2 = :jc2"),
    @NamedQuery(name = "VHTV002.findByJc1", query = "SELECT v FROM VHTV002 v WHERE v.jc1 = :jc1"),
    @NamedQuery(name = "VHTV002.findByJc3", query = "SELECT v FROM VHTV002 v WHERE v.jc3 = :jc3"),
    @NamedQuery(name = "VHTV002.findByTotalMileage", query = "SELECT v FROM VHTV002 v WHERE v.totalMileage = :totalMileage"),
    @NamedQuery(name = "VHTV002.findByHdreGrid", query = "SELECT v FROM VHTV002 v WHERE v.hdreGrid = :hdreGrid"),
    @NamedQuery(name = "VHTV002.findByHdtGrid", query = "SELECT v FROM VHTV002 v WHERE v.hdtGrid = :hdtGrid"),
    @NamedQuery(name = "VHTV002.findByDeptYear", query = "SELECT v FROM VHTV002 v WHERE v.deptYear = :deptYear"),
    @NamedQuery(name = "VHTV002.findBySubtotal", query = "SELECT v FROM VHTV002 v WHERE v.subtotal = :subtotal"),
    @NamedQuery(name = "VHTV002.findByCost", query = "SELECT v FROM VHTV002 v WHERE v.cost = :cost"),
    @NamedQuery(name = "VHTV002.findByHdnfacno", query = "SELECT v FROM VHTV002 v WHERE v.hdnfacno = :hdnfacno"),
    @NamedQuery(name = "VHTV002.findByEntertainObj", query = "SELECT v FROM VHTV002 v WHERE v.entertainObj = :entertainObj"),
    @NamedQuery(name = "VHTV002.findByRatio", query = "SELECT v FROM VHTV002 v WHERE v.ratio = :ratio"),
    @NamedQuery(name = "VHTV002.findByAccName", query = "SELECT v FROM VHTV002 v WHERE v.accName = :accName"),
    @NamedQuery(name = "VHTV002.findByHdnappDept", query = "SELECT v FROM VHTV002 v WHERE v.hdnappDept = :hdnappDept"),
    @NamedQuery(name = "VHTV002.findByApplyAmount", query = "SELECT v FROM VHTV002 v WHERE v.applyAmount = :applyAmount"),
    @NamedQuery(name = "VHTV002.findByHdnreimbursement", query = "SELECT v FROM VHTV002 v WHERE v.hdnreimbursement = :hdnreimbursement"),
    @NamedQuery(name = "VHTV002.findByOID", query = "SELECT v FROM VHTV002 v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHTV002.findByEndMileage", query = "SELECT v FROM VHTV002 v WHERE v.endMileage = :endMileage"),
    @NamedQuery(name = "VHTV002.findByTaxi", query = "SELECT v FROM VHTV002 v WHERE v.taxi = :taxi"),
    @NamedQuery(name = "VHTV002.findByLoanAmount", query = "SELECT v FROM VHTV002 v WHERE v.loanAmount = :loanAmount"),
    @NamedQuery(name = "VHTV002.findByHdnappUser", query = "SELECT v FROM VHTV002 v WHERE v.hdnappUser = :hdnappUser"),
    @NamedQuery(name = "VHTV002.findByNotaxes", query = "SELECT v FROM VHTV002 v WHERE v.notaxes = :notaxes"),
    @NamedQuery(name = "VHTV002.findByHdCRMNO", query = "SELECT v FROM VHTV002 v WHERE v.hdCRMNO = :hdCRMNO"),
    @NamedQuery(name = "VHTV002.findByTotaltaxInclusiveRMB", query = "SELECT v FROM VHTV002 v WHERE v.totaltaxInclusiveRMB = :totaltaxInclusiveRMB"),
    @NamedQuery(name = "VHTV002.findByTaxInclusive", query = "SELECT v FROM VHTV002 v WHERE v.taxInclusive = :taxInclusive"),
    @NamedQuery(name = "VHTV002.findByAccno", query = "SELECT v FROM VHTV002 v WHERE v.accno = :accno"),
    @NamedQuery(name = "VHTV002.findByUserTitle", query = "SELECT v FROM VHTV002 v WHERE v.userTitle = :userTitle"),
    @NamedQuery(name = "VHTV002.findByEntertainReason", query = "SELECT v FROM VHTV002 v WHERE v.entertainReason = :entertainReason"),
    @NamedQuery(name = "VHTV002.findByTextbox6", query = "SELECT v FROM VHTV002 v WHERE v.textbox6 = :textbox6"),
    @NamedQuery(name = "VHTV002.findByTotaltaxesRMB", query = "SELECT v FROM VHTV002 v WHERE v.totaltaxesRMB = :totaltaxesRMB"),
    @NamedQuery(name = "VHTV002.findByTextbox7", query = "SELECT v FROM VHTV002 v WHERE v.textbox7 = :textbox7"),
    @NamedQuery(name = "VHTV002.findByFacno", query = "SELECT v FROM VHTV002 v WHERE v.facno = :facno"),
    @NamedQuery(name = "VHTV002.findByTrafficfee", query = "SELECT v FROM VHTV002 v WHERE v.trafficfee = :trafficfee"),
    @NamedQuery(name = "VHTV002.findByIsBack", query = "SELECT v FROM VHTV002 v WHERE v.isBack = :isBack"),
    @NamedQuery(name = "VHTV002.findByCreator", query = "SELECT v FROM VHTV002 v WHERE v.creator = :creator"),
    @NamedQuery(name = "VHTV002.findByAccPeriod", query = "SELECT v FROM VHTV002 v WHERE v.accPeriod = :accPeriod"),
    @NamedQuery(name = "VHTV002.findByCrmno", query = "SELECT v FROM VHTV002 v WHERE v.crmno = :crmno"),
    @NamedQuery(name = "VHTV002.findByAccYear", query = "SELECT v FROM VHTV002 v WHERE v.accYear = :accYear"),
    @NamedQuery(name = "VHTV002.findByRefund", query = "SELECT v FROM VHTV002 v WHERE v.refund = :refund"),
    @NamedQuery(name = "VHTV002.findByCustomerSno", query = "SELECT v FROM VHTV002 v WHERE v.customerSno = :customerSno"),
    @NamedQuery(name = "VHTV002.findByEntertainDate", query = "SELECT v FROM VHTV002 v WHERE v.entertainDate = :entertainDate"),
    @NamedQuery(name = "VHTV002.findByTotaltaxInclusive", query = "SELECT v FROM VHTV002 v WHERE v.totaltaxInclusive = :totaltaxInclusive"),
    @NamedQuery(name = "VHTV002.findByPSN", query = "SELECT v FROM VHTV002 v WHERE v.processSerialNumber = :psn"),
    @NamedQuery(name = "VHTV002.findByTrafficPlace", query = "SELECT v FROM VHTV002 v WHERE v.trafficPlace = :trafficPlace"),
    @NamedQuery(name = "VHTV002.findByAppDate", query = "SELECT v FROM VHTV002 v WHERE v.appDate = :appDate"),
    @NamedQuery(name = "VHTV002.findByDeptPeriod", query = "SELECT v FROM VHTV002 v WHERE v.deptPeriod = :deptPeriod"),
    @NamedQuery(name = "VHTV002.findByTrafficDate", query = "SELECT v FROM VHTV002 v WHERE v.trafficDate = :trafficDate"),
    @NamedQuery(name = "VHTV002.findByHdncreator", query = "SELECT v FROM VHTV002 v WHERE v.hdncreator = :hdncreator"),
    @NamedQuery(name = "VHTV002.findByLoanProp", query = "SELECT v FROM VHTV002 v WHERE v.loanProp = :loanProp"),
    @NamedQuery(name = "VHTV002.findByBudgetDept", query = "SELECT v FROM VHTV002 v WHERE v.budgetDept = :budgetDept"),
    @NamedQuery(name = "VHTV002.findByCoin", query = "SELECT v FROM VHTV002 v WHERE v.coin = :coin"),
    @NamedQuery(name = "VHTV002.findByTotalnotaxesRMB", query = "SELECT v FROM VHTV002 v WHERE v.totalnotaxesRMB = :totalnotaxesRMB"),
    @NamedQuery(name = "VHTV002.findByReimbursement", query = "SELECT v FROM VHTV002 v WHERE v.reimbursement = :reimbursement"),
    @NamedQuery(name = "VHTV002.findByBudgetAcc", query = "SELECT v FROM VHTV002 v WHERE v.budgetAcc = :budgetAcc"),
    @NamedQuery(name = "VHTV002.findByResearch", query = "SELECT v FROM VHTV002 v WHERE v.research = :research"),
    @NamedQuery(name = "VHTV002.findByEntertainPeople", query = "SELECT v FROM VHTV002 v WHERE v.entertainPeople = :entertainPeople"),
    @NamedQuery(name = "VHTV002.findByTotalRefund", query = "SELECT v FROM VHTV002 v WHERE v.totalRefund = :totalRefund"),
    @NamedQuery(name = "VHTV002.findBySort3", query = "SELECT v FROM VHTV002 v WHERE v.sort3 = :sort3"),
    @NamedQuery(name = "VHTV002.findByProduct", query = "SELECT v FROM VHTV002 v WHERE v.product = :product"),
    @NamedQuery(name = "VHTV002.findBySort2", query = "SELECT v FROM VHTV002 v WHERE v.sort2 = :sort2"),
    @NamedQuery(name = "VHTV002.findByServiceno", query = "SELECT v FROM VHTV002 v WHERE v.serviceno = :serviceno"),
    @NamedQuery(name = "VHTV002.findByAppUser", query = "SELECT v FROM VHTV002 v WHERE v.appUser = :appUser"),
    @NamedQuery(name = "VHTV002.findByDays", query = "SELECT v FROM VHTV002 v WHERE v.days = :days"),
    @NamedQuery(name = "VHTV002.findByAccommodation", query = "SELECT v FROM VHTV002 v WHERE v.accommodation = :accommodation"),
    @NamedQuery(name = "VHTV002.findBySort1", query = "SELECT v FROM VHTV002 v WHERE v.sort1 = :sort1"),
    @NamedQuery(name = "VHTV002.findByBudgetAccname", query = "SELECT v FROM VHTV002 v WHERE v.budgetAccname = :budgetAccname"),
    @NamedQuery(name = "VHTV002.findByTaxes", query = "SELECT v FROM VHTV002 v WHERE v.taxes = :taxes"),
    @NamedQuery(name = "VHTV002.findByFSN", query = "SELECT v FROM VHTV002 v WHERE v.formSerialNumber = :fsn")})
public class VHTV002 implements Serializable {

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
    @Column(name = "exception")
    private String exception;
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
    @Column(name = "deptqx")
    private String deptqx;
    @Size(max = 255)
    @Column(name = "bh1")
    private String bh1;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
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
    @Size(max = 255)
    @Column(name = "hdreGrid")
    private String hdreGrid;
    @Size(max = 255)
    @Column(name = "hdtGrid")
    private String hdtGrid;
    @Column(name = "deptYear")
    private Double deptYear;
    @Column(name = "subtotal")
    private Double subtotal;
    @Size(max = 255)
    @Column(name = "cost")
    private String cost;
    @Size(max = 255)
    @Column(name = "hdnfacno")
    private String hdnfacno;
    @Size(max = 255)
    @Column(name = "entertainObj")
    private String entertainObj;
    @Column(name = "ratio")
    private Double ratio;
    @Size(max = 255)
    @Column(name = "accName")
    private String accName;
    @Size(max = 255)
    @Column(name = "hdnappDept")
    private String hdnappDept;
    @Column(name = "applyAmount")
    private Double applyAmount;
    @Size(max = 255)
    @Column(name = "hdnreimbursement")
    private String hdnreimbursement;
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
    @Size(max = 255)
    @Column(name = "hdnappUser")
    private String hdnappUser;
    @Column(name = "notaxes")
    private Double notaxes;
    @Size(max = 255)
    @Column(name = "hdCRMNO")
    private String hdCRMNO;
    @Column(name = "totaltaxInclusiveRMB")
    private Double totaltaxInclusiveRMB;
    @Column(name = "taxInclusive")
    private Double taxInclusive;
    @Size(max = 255)
    @Column(name = "accno")
    private String accno;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "entertainReason")
    private String entertainReason;
    @Size(max = 255)
    @Column(name = "Textbox6")
    private String textbox6;
    @Column(name = "totaltaxesRMB")
    private Double totaltaxesRMB;
    @Size(max = 255)
    @Column(name = "Textbox7")
    private String textbox7;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Column(name = "trafficfee")
    private Double trafficfee;
    @Size(max = 255)
    @Column(name = "isBack")
    private String isBack;
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
    @Column(name = "hdncreator")
    private String hdncreator;
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
    @Column(name = "totalRefund")
    private Double totalRefund;
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
    private Double days;
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
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public VHTV002() {
    }

    public VHTV002(String oid) {
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

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
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

    public String getDeptqx() {
        return deptqx;
    }

    public void setDeptqx(String deptqx) {
        this.deptqx = deptqx;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getHdreGrid() {
        return hdreGrid;
    }

    public void setHdreGrid(String hdreGrid) {
        this.hdreGrid = hdreGrid;
    }

    public String getHdtGrid() {
        return hdtGrid;
    }

    public void setHdtGrid(String hdtGrid) {
        this.hdtGrid = hdtGrid;
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

    public String getHdnfacno() {
        return hdnfacno;
    }

    public void setHdnfacno(String hdnfacno) {
        this.hdnfacno = hdnfacno;
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

    public String getHdnappDept() {
        return hdnappDept;
    }

    public void setHdnappDept(String hdnappDept) {
        this.hdnappDept = hdnappDept;
    }

    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getHdnreimbursement() {
        return hdnreimbursement;
    }

    public void setHdnreimbursement(String hdnreimbursement) {
        this.hdnreimbursement = hdnreimbursement;
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

    public String getHdnappUser() {
        return hdnappUser;
    }

    public void setHdnappUser(String hdnappUser) {
        this.hdnappUser = hdnappUser;
    }

    public Double getNotaxes() {
        return notaxes;
    }

    public void setNotaxes(Double notaxes) {
        this.notaxes = notaxes;
    }

    public String getHdCRMNO() {
        return hdCRMNO;
    }

    public void setHdCRMNO(String hdCRMNO) {
        this.hdCRMNO = hdCRMNO;
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

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getEntertainReason() {
        return entertainReason;
    }

    public void setEntertainReason(String entertainReason) {
        this.entertainReason = entertainReason;
    }

    public String getTextbox6() {
        return textbox6;
    }

    public void setTextbox6(String textbox6) {
        this.textbox6 = textbox6;
    }

    public Double getTotaltaxesRMB() {
        return totaltaxesRMB;
    }

    public void setTotaltaxesRMB(Double totaltaxesRMB) {
        this.totaltaxesRMB = totaltaxesRMB;
    }

    public String getTextbox7() {
        return textbox7;
    }

    public void setTextbox7(String textbox7) {
        this.textbox7 = textbox7;
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

    public String getIsBack() {
        return isBack;
    }

    public void setIsBack(String isBack) {
        this.isBack = isBack;
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

    public String getHdncreator() {
        return hdncreator;
    }

    public void setHdncreator(String hdncreator) {
        this.hdncreator = hdncreator;
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

    public Double getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Double totalRefund) {
        this.totalRefund = totalRefund;
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

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
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
        if (!(object instanceof VHTV002)) {
            return false;
        }
        VHTV002 other = (VHTV002) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV002[ oid=" + oid + " ]";
    }
    
}
