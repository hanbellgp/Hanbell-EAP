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
@Table(name = "HZ_CW028")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW028.findAll", query = "SELECT h FROM HZCW028 h"),
    @NamedQuery(name = "HZCW028.findBySummary", query = "SELECT h FROM HZCW028 h WHERE h.summary = :summary"),
    @NamedQuery(name = "HZCW028.findByAppDept", query = "SELECT h FROM HZCW028 h WHERE h.appDept = :appDept"),
    @NamedQuery(name = "HZCW028.findByCenterid", query = "SELECT h FROM HZCW028 h WHERE h.centerid = :centerid"),
    @NamedQuery(name = "HZCW028.findByAllowance", query = "SELECT h FROM HZCW028 h WHERE h.allowance = :allowance"),
    @NamedQuery(name = "HZCW028.findByRemark", query = "SELECT h FROM HZCW028 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HZCW028.findByTrafficSummary", query = "SELECT h FROM HZCW028 h WHERE h.trafficSummary = :trafficSummary"),
    @NamedQuery(name = "HZCW028.findByBh3", query = "SELECT h FROM HZCW028 h WHERE h.bh3 = :bh3"),
    @NamedQuery(name = "HZCW028.findByBh2", query = "SELECT h FROM HZCW028 h WHERE h.bh2 = :bh2"),
    @NamedQuery(name = "HZCW028.findByReceipt", query = "SELECT h FROM HZCW028 h WHERE h.receipt = :receipt"),
    @NamedQuery(name = "HZCW028.findByCarUse", query = "SELECT h FROM HZCW028 h WHERE h.carUse = :carUse"),
    @NamedQuery(name = "HZCW028.findByStartMileage", query = "SELECT h FROM HZCW028 h WHERE h.startMileage = :startMileage"),
    @NamedQuery(name = "HZCW028.findByDeptqx", query = "SELECT h FROM HZCW028 h WHERE h.deptqx = :deptqx"),
    @NamedQuery(name = "HZCW028.findByBh1", query = "SELECT h FROM HZCW028 h WHERE h.bh1 = :bh1"),
    @NamedQuery(name = "HZCW028.findByAmount", query = "SELECT h FROM HZCW028 h WHERE h.amount = :amount"),
    @NamedQuery(name = "HZCW028.findByTravelReport", query = "SELECT h FROM HZCW028 h WHERE h.travelReport = :travelReport"),
    @NamedQuery(name = "HZCW028.findByJc2", query = "SELECT h FROM HZCW028 h WHERE h.jc2 = :jc2"),
    @NamedQuery(name = "HZCW028.findByJc1", query = "SELECT h FROM HZCW028 h WHERE h.jc1 = :jc1"),
    @NamedQuery(name = "HZCW028.findByJc3", query = "SELECT h FROM HZCW028 h WHERE h.jc3 = :jc3"),
    @NamedQuery(name = "HZCW028.findByTotalMileage", query = "SELECT h FROM HZCW028 h WHERE h.totalMileage = :totalMileage"),
    @NamedQuery(name = "HZCW028.findByDeptYear", query = "SELECT h FROM HZCW028 h WHERE h.deptYear = :deptYear"),
    @NamedQuery(name = "HZCW028.findBySubtotal", query = "SELECT h FROM HZCW028 h WHERE h.subtotal = :subtotal"),
    @NamedQuery(name = "HZCW028.findByCost", query = "SELECT h FROM HZCW028 h WHERE h.cost = :cost"),
    @NamedQuery(name = "HZCW028.findByEntertainObj", query = "SELECT h FROM HZCW028 h WHERE h.entertainObj = :entertainObj"),
    @NamedQuery(name = "HZCW028.findByRatio", query = "SELECT h FROM HZCW028 h WHERE h.ratio = :ratio"),
    @NamedQuery(name = "HZCW028.findByAccName", query = "SELECT h FROM HZCW028 h WHERE h.accName = :accName"),
    @NamedQuery(name = "HZCW028.findByOid", query = "SELECT h FROM HZCW028 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW028.findByEndMileage", query = "SELECT h FROM HZCW028 h WHERE h.endMileage = :endMileage"),
    @NamedQuery(name = "HZCW028.findByTaxi", query = "SELECT h FROM HZCW028 h WHERE h.taxi = :taxi"),
    @NamedQuery(name = "HZCW028.findByNotaxes", query = "SELECT h FROM HZCW028 h WHERE h.notaxes = :notaxes"),
    @NamedQuery(name = "HZCW028.findByTotaltaxInclusiveRMB", query = "SELECT h FROM HZCW028 h WHERE h.totaltaxInclusiveRMB = :totaltaxInclusiveRMB"),
    @NamedQuery(name = "HZCW028.findByTaxInclusive", query = "SELECT h FROM HZCW028 h WHERE h.taxInclusive = :taxInclusive"),
    @NamedQuery(name = "HZCW028.findByAccno", query = "SELECT h FROM HZCW028 h WHERE h.accno = :accno"),
    @NamedQuery(name = "HZCW028.findByEntertainReason", query = "SELECT h FROM HZCW028 h WHERE h.entertainReason = :entertainReason"),
    @NamedQuery(name = "HZCW028.findByTotaltaxesRMB", query = "SELECT h FROM HZCW028 h WHERE h.totaltaxesRMB = :totaltaxesRMB"),
    @NamedQuery(name = "HZCW028.findByFacno", query = "SELECT h FROM HZCW028 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HZCW028.findByTrafficfee", query = "SELECT h FROM HZCW028 h WHERE h.trafficfee = :trafficfee"),
    @NamedQuery(name = "HZCW028.findByCreator", query = "SELECT h FROM HZCW028 h WHERE h.creator = :creator"),
    @NamedQuery(name = "HZCW028.findByAccPeriod", query = "SELECT h FROM HZCW028 h WHERE h.accPeriod = :accPeriod"),
    @NamedQuery(name = "HZCW028.findByCrmno", query = "SELECT h FROM HZCW028 h WHERE h.crmno = :crmno"),
    @NamedQuery(name = "HZCW028.findByAccYear", query = "SELECT h FROM HZCW028 h WHERE h.accYear = :accYear"),
    @NamedQuery(name = "HZCW028.findByCustomerSno", query = "SELECT h FROM HZCW028 h WHERE h.customerSno = :customerSno"),
    @NamedQuery(name = "HZCW028.findByEntertainDate", query = "SELECT h FROM HZCW028 h WHERE h.entertainDate = :entertainDate"),
    @NamedQuery(name = "HZCW028.findByTotaltaxInclusive", query = "SELECT h FROM HZCW028 h WHERE h.totaltaxInclusive = :totaltaxInclusive"),
    @NamedQuery(name = "HZCW028.findByPSN", query = "SELECT h FROM HZCW028 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW028.findByTrafficPlace", query = "SELECT h FROM HZCW028 h WHERE h.trafficPlace = :trafficPlace"),
    @NamedQuery(name = "HZCW028.findByAppDate", query = "SELECT h FROM HZCW028 h WHERE h.appDate = :appDate"),
    @NamedQuery(name = "HZCW028.findByDeptPeriod", query = "SELECT h FROM HZCW028 h WHERE h.deptPeriod = :deptPeriod"),
    @NamedQuery(name = "HZCW028.findByTrafficDate", query = "SELECT h FROM HZCW028 h WHERE h.trafficDate = :trafficDate"),
    @NamedQuery(name = "HZCW028.findByBudgetDept", query = "SELECT h FROM HZCW028 h WHERE h.budgetDept = :budgetDept"),
    @NamedQuery(name = "HZCW028.findByCoin", query = "SELECT h FROM HZCW028 h WHERE h.coin = :coin"),
    @NamedQuery(name = "HZCW028.findByTotalnotaxesRMB", query = "SELECT h FROM HZCW028 h WHERE h.totalnotaxesRMB = :totalnotaxesRMB"),
    @NamedQuery(name = "HZCW028.findByReimbursement", query = "SELECT h FROM HZCW028 h WHERE h.reimbursement = :reimbursement"),
    @NamedQuery(name = "HZCW028.findByBudgetAcc", query = "SELECT h FROM HZCW028 h WHERE h.budgetAcc = :budgetAcc"),
    @NamedQuery(name = "HZCW028.findByResearch", query = "SELECT h FROM HZCW028 h WHERE h.research = :research"),
    @NamedQuery(name = "HZCW028.findByEntertainPeople", query = "SELECT h FROM HZCW028 h WHERE h.entertainPeople = :entertainPeople"),
    @NamedQuery(name = "HZCW028.findBySort3", query = "SELECT h FROM HZCW028 h WHERE h.sort3 = :sort3"),
    @NamedQuery(name = "HZCW028.findByProduct", query = "SELECT h FROM HZCW028 h WHERE h.product = :product"),
    @NamedQuery(name = "HZCW028.findBySort2", query = "SELECT h FROM HZCW028 h WHERE h.sort2 = :sort2"),
    @NamedQuery(name = "HZCW028.findByServiceno", query = "SELECT h FROM HZCW028 h WHERE h.serviceno = :serviceno"),
    @NamedQuery(name = "HZCW028.findByAppUser", query = "SELECT h FROM HZCW028 h WHERE h.appUser = :appUser"),
    @NamedQuery(name = "HZCW028.findByDays", query = "SELECT h FROM HZCW028 h WHERE h.days = :days"),
    @NamedQuery(name = "HZCW028.findByAccommodation", query = "SELECT h FROM HZCW028 h WHERE h.accommodation = :accommodation"),
    @NamedQuery(name = "HZCW028.findBySort1", query = "SELECT h FROM HZCW028 h WHERE h.sort1 = :sort1"),
    @NamedQuery(name = "HZCW028.findByBudgetAccname", query = "SELECT h FROM HZCW028 h WHERE h.budgetAccname = :budgetAccname"),
    @NamedQuery(name = "HZCW028.findByTaxes", query = "SELECT h FROM HZCW028 h WHERE h.taxes = :taxes"),
    @NamedQuery(name = "HZCW028.findByFSN", query = "SELECT h FROM HZCW028 h WHERE h.formSerialNumber = :fsn")})
public class HZCW028 implements Serializable {

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
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "Textbox6")
    private Double Textbox6;
    @Size(max = 255)
    @Column(name = "hdnappUser")
    private String hdnappUser;
    @Size(max = 255)
    @Column(name = "hdtrafficAmount")
    private String hdtrafficAmount;

    public HZCW028() {
    }

    public HZCW028(String oid) {
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

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Double getTextbox6() {
        return Textbox6;
    }

    public void setTextbox6(Double Textbox6) {
        this.Textbox6 = Textbox6;
    }

    public String getHdnappUser() {
        return hdnappUser;
    }

    public void setHdnappUser(String hdnappUser) {
        this.hdnappUser = hdnappUser;
    }

    public String getHdtrafficAmount() {
        return hdtrafficAmount;
    }

    public void setHdtrafficAmount(String hdtrafficAmount) {
        this.hdtrafficAmount = hdtrafficAmount;
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
        if (!(object instanceof HZCW028)) {
            return false;
        }
        HZCW028 other = (HZCW028) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW028[ oid=" + oid + " ]";
    }

}
