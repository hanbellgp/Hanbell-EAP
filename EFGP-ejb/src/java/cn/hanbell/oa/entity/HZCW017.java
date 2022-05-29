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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "HZ_CW017")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW017.findAll", query = "SELECT j FROM HZCW017 j"),
    @NamedQuery(name = "HZCW017.findByOID", query = "SELECT j FROM HZCW017 j WHERE j.oid = :oid"),
    @NamedQuery(name = "HZCW017.findByCenterid", query = "SELECT j FROM HZCW017 j WHERE j.centerid = :centerid"),
    @NamedQuery(name = "HZCW017.findByOther", query = "SELECT j FROM HZCW017 j WHERE j.other = :other"),
    @NamedQuery(name = "HZCW017.findByAllowance", query = "SELECT j FROM HZCW017 j WHERE j.allowance = :allowance"),
    @NamedQuery(name = "HZCW017.findByReason", query = "SELECT j FROM HZCW017 j WHERE j.reason = :reason"),
    @NamedQuery(name = "HZCW017.findByPrePayDate", query = "SELECT j FROM HZCW017 j WHERE j.prePayDate = :prePayDate"),
    @NamedQuery(name = "HZCW017.findByEntertain", query = "SELECT j FROM HZCW017 j WHERE j.entertain = :entertain"),
    @NamedQuery(name = "HZCW017.findByPreCustomer", query = "SELECT j FROM HZCW017 j WHERE j.preCustomer = :preCustomer"),
    @NamedQuery(name = "HZCW017.findByPreLocation", query = "SELECT j FROM HZCW017 j WHERE j.preLocation = :preLocation"),
    @NamedQuery(name = "HZCW017.findByPeople", query = "SELECT j FROM HZCW017 j WHERE j.people = :people"),
    @NamedQuery(name = "HZCW017.findByFacno", query = "SELECT j FROM HZCW017 j WHERE j.facno = :facno"),
    @NamedQuery(name = "HZCW017.findByTrafficfee", query = "SELECT j FROM HZCW017 j WHERE j.trafficfee = :trafficfee"),
    @NamedQuery(name = "HZCW017.findByPreAccno", query = "SELECT j FROM HZCW017 j WHERE j.preAccno = :preAccno"),
    @NamedQuery(name = "HZCW017.findByCreator", query = "SELECT j FROM HZCW017 j WHERE j.creator = :creator"),
    @NamedQuery(name = "HZCW017.findByAmount", query = "SELECT j FROM HZCW017 j WHERE j.amount = :amount"),
    @NamedQuery(name = "HZCW017.findByPSN", query = "SELECT j FROM HZCW017 j WHERE j.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW017.findByPreAccname", query = "SELECT j FROM HZCW017 j WHERE j.preAccname = :preAccname"),
    @NamedQuery(name = "HZCW017.findByDeptPeriod", query = "SELECT j FROM HZCW017 j WHERE j.deptPeriod = :deptPeriod"),
    @NamedQuery(name = "HZCW017.findByDeptYear", query = "SELECT j FROM HZCW017 j WHERE j.deptYear = :deptYear"),
    @NamedQuery(name = "HZCW017.findByLoanTotal", query = "SELECT j FROM HZCW017 j WHERE j.loanTotal = :loanTotal"),
    @NamedQuery(name = "HZCW017.findByCoin", query = "SELECT j FROM HZCW017 j WHERE j.coin = :coin"),
    @NamedQuery(name = "HZCW017.findByLoanUser", query = "SELECT j FROM HZCW017 j WHERE j.loanUser = :loanUser"),
    @NamedQuery(name = "HZCW017.findByLoanProperty", query = "SELECT j FROM HZCW017 j WHERE j.loanProperty = :loanProperty"),
    @NamedQuery(name = "HZCW017.findByProduct", query = "SELECT j FROM HZCW017 j WHERE j.product = :product"),
    @NamedQuery(name = "HZCW017.findByLoanDept", query = "SELECT j FROM HZCW017 j WHERE j.loanDept = :loanDept"),
    @NamedQuery(name = "HZCW017.findByArrears", query = "SELECT j FROM HZCW017 j WHERE j.arrears = :arrears"),
    @NamedQuery(name = "HZCW017.findByTraffic", query = "SELECT j FROM HZCW017 j WHERE j.traffic = :traffic"),
    @NamedQuery(name = "HZCW017.findByTotalRMB", query = "SELECT j FROM HZCW017 j WHERE j.totalRMB = :totalRMB"),
    @NamedQuery(name = "HZCW017.findByDays", query = "SELECT j FROM HZCW017 j WHERE j.days = :days"),
    @NamedQuery(name = "HZCW017.findByRatio", query = "SELECT j FROM HZCW017 j WHERE j.ratio = :ratio"),
    @NamedQuery(name = "HZCW017.findByAccommodation", query = "SELECT j FROM HZCW017 j WHERE j.accommodation = :accommodation"),
    @NamedQuery(name = "HZCW017.findByLoanDate", query = "SELECT j FROM HZCW017 j WHERE j.loanDate = :loanDate"),
    @NamedQuery(name = "HZCW017.findByFSN", query = "SELECT j FROM HZCW017 j WHERE j.formSerialNumber = :fsn"),})
public class HZCW017 implements Serializable {

    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdnloanUser")
    private String hdnloanUser;
    @Size(max = 255)
    @Column(name = "hdnloanDept")
    private String hdnloanDept;
    @Size(max = 255)
    @Column(name = "hdncreator")
    private String hdncreator;
    @Size(max = 255)
    @Column(name = "hdnfacno")
    private String hdnfacno;
    @Size(max = 255)
    @Column(name = "hdnloanProperty")
    private String hdnloanProperty;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "other")
    private Double other;
    @Column(name = "allowance")
    private Double allowance;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Column(name = "prePayDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prePayDate;
    @Column(name = "entertain")
    private Double entertain;
    @Size(max = 255)
    @Column(name = "preCustomer")
    private String preCustomer;
    @Size(max = 255)
    @Column(name = "preLocation")
    private String preLocation;
    @Column(name = "people")
    private Integer people;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Column(name = "trafficfee")
    private Double trafficfee;
    @Size(max = 255)
    @Column(name = "preAccno")
    private String preAccno;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "preAccname")
    private String preAccname;
    @Column(name = "deptPeriod")
    private Double deptPeriod;
    @Column(name = "deptYear")
    private Double deptYear;
    @Column(name = "loanTotal")
    private Double loanTotal;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "loanUser")
    private String loanUser;
    @Size(max = 255)
    @Column(name = "loanProperty")
    private String loanProperty;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "loanDept")
    private String loanDept;
    @Column(name = "arrears")
    private Double arrears;
    @Size(max = 255)
    @Column(name = "traffic")
    private String traffic;
    @Column(name = "totalRMB")
    private Double totalRMB;
    @Column(name = "days")
    private Integer days;
    @Column(name = "ratio")
    private Double ratio;
    @Column(name = "accommodation")
    private Double accommodation;
    @Column(name = "loanDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loanDate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private ProcessInstance processInstance;
    @Size(max = 255)
    @Column(name = "srcno")
    private String srcno;

    public HZCW017() {
    }

    public HZCW017(String oid) {
        this.oid = oid;
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

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public String getReason() {
        return reason.replaceAll("\r|\n", " ");
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getPrePayDate() {
        return prePayDate;
    }

    public void setPrePayDate(Date prePayDate) {
        this.prePayDate = prePayDate;
    }

    public Double getEntertain() {
        return entertain;
    }

    public void setEntertain(Double entertain) {
        this.entertain = entertain;
    }

    public String getPreCustomer() {
        return preCustomer;
    }

    public void setPreCustomer(String preCustomer) {
        this.preCustomer = preCustomer;
    }

    public String getPreLocation() {
        return preLocation;
    }

    public void setPreLocation(String preLocation) {
        this.preLocation = preLocation;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
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

    public String getPreAccno() {
        return preAccno;
    }

    public void setPreAccno(String preAccno) {
        this.preAccno = preAccno;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getPreAccname() {
        return preAccname;
    }

    public void setPreAccname(String preAccname) {
        this.preAccname = preAccname;
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

    public Double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(Double loanTotal) {
        this.loanTotal = loanTotal;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(String loanUser) {
        this.loanUser = loanUser;
    }

    public String getLoanProperty() {
        return loanProperty;
    }

    public void setLoanProperty(String loanProperty) {
        this.loanProperty = loanProperty;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLoanDept() {
        return loanDept;
    }

    public void setLoanDept(String loanDept) {
        this.loanDept = loanDept;
    }

    public Double getArrears() {
        return arrears;
    }

    public void setArrears(Double arrears) {
        this.arrears = arrears;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public Double getTotalRMB() {
        return totalRMB;
    }

    public void setTotalRMB(Double totalRMB) {
        this.totalRMB = totalRMB;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Double accommodation) {
        this.accommodation = accommodation;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
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
        if (!(object instanceof HZCW017)) {
            return false;
        }
        HZCW017 other = (HZCW017) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW017[ oid=" + oid + " ]";
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnloanUser() {
        return hdnloanUser;
    }

    public void setHdnloanUser(String hdnloanUser) {
        this.hdnloanUser = hdnloanUser;
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

    public String getHdnfacno() {
        return hdnfacno;
    }

    public void setHdnfacno(String hdnfacno) {
        this.hdnfacno = hdnfacno;
    }

    public String getHdnloanProperty() {
        return hdnloanProperty;
    }

    public void setHdnloanProperty(String hdnloanProperty) {
        this.hdnloanProperty = hdnloanProperty;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

}
