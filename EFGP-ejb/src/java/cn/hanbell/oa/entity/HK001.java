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
import javax.persistence.ManyToOne;
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
 * @author C2082
 */
@Entity
@Table(name = "HK_001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HK001.findAll", query = "SELECT h FROM HK001 h"),
    @NamedQuery(name = "HK001.findByContractDate", query = "SELECT h FROM HK001 h WHERE h.contractDate = :contractDate"),
    @NamedQuery(name = "HK001.findByFacno", query = "SELECT h FROM HK001 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HK001.findByYearDeposit", query = "SELECT h FROM HK001 h WHERE h.yearDeposit = :yearDeposit"),
    @NamedQuery(name = "HK001.findByProcessSerialNumber", query = "SELECT h FROM HK001 h WHERE h.processSerialNumber = :processSerialNumber"),
    @NamedQuery(name = "HK001.findByMonthDeposit", query = "SELECT h FROM HK001 h WHERE h.monthDeposit = :monthDeposit"),
    @NamedQuery(name = "HK001.findByPayWay", query = "SELECT h FROM HK001 h WHERE h.payWay = :payWay"),
    @NamedQuery(name = "HK001.findByApplyUser", query = "SELECT h FROM HK001 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HK001.findByUserTitle", query = "SELECT h FROM HK001 h WHERE h.userTitle = :userTitle"),
    @NamedQuery(name = "HK001.findByApplyDept", query = "SELECT h FROM HK001 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HK001.findByUserPost", query = "SELECT h FROM HK001 h WHERE h.userPost = :userPost"),
    @NamedQuery(name = "HK001.findByFormSerialNumber", query = "SELECT h FROM HK001 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HK001.findByYearPay", query = "SELECT h FROM HK001 h WHERE h.yearPay = :yearPay"),
    @NamedQuery(name = "HK001.findByCustomerAddress", query = "SELECT h FROM HK001 h WHERE h.customerAddress = :customerAddress"),
    @NamedQuery(name = "HK001.findByType3", query = "SELECT h FROM HK001 h WHERE h.type3 = :type3"),
    @NamedQuery(name = "HK001.findByType2", query = "SELECT h FROM HK001 h WHERE h.type2 = :type2"),
    @NamedQuery(name = "HK001.findByAddress1", query = "SELECT h FROM HK001 h WHERE h.address1 = :address1"),
    @NamedQuery(name = "HK001.findByOtherPerson", query = "SELECT h FROM HK001 h WHERE h.otherPerson = :otherPerson"),
    @NamedQuery(name = "HK001.findByApplyReason", query = "SELECT h FROM HK001 h WHERE h.applyReason = :applyReason"),
    @NamedQuery(name = "HK001.findByContracStigning", query = "SELECT h FROM HK001 h WHERE h.contracStigning = :contracStigning"),
    @NamedQuery(name = "HK001.findByOid", query = "SELECT h FROM HK001 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HK001.findByType1", query = "SELECT h FROM HK001 h WHERE h.type1 = :type1"),
    @NamedQuery(name = "HK001.findByCustomerName", query = "SELECT h FROM HK001 h WHERE h.customerName = :customerName"),
    @NamedQuery(name = "HK001.findBySerialNumber", query = "SELECT h FROM HK001 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HK001.findByMonthPay", query = "SELECT h FROM HK001 h WHERE h.monthPay = :monthPay"),
    @NamedQuery(name = "HK001.findByStartDate2", query = "SELECT h FROM HK001 h WHERE h.startDate2 = :startDate2"),
    @NamedQuery(name = "HK001.findByStartDate3", query = "SELECT h FROM HK001 h WHERE h.startDate3 = :startDate3"),
    @NamedQuery(name = "HK001.findByStartDate1", query = "SELECT h FROM HK001 h WHERE h.startDate1 = :startDate1"),
    @NamedQuery(name = "HK001.findByDomicile", query = "SELECT h FROM HK001 h WHERE h.domicile = :domicile"),
    @NamedQuery(name = "HK001.findByResidents", query = "SELECT h FROM HK001 h WHERE h.residents = :residents"),
    @NamedQuery(name = "HK001.findByApplyDate", query = "SELECT h FROM HK001 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HK001.findByEndDate1", query = "SELECT h FROM HK001 h WHERE h.endDate1 = :endDate1"),
    @NamedQuery(name = "HK001.findByEndDate2", query = "SELECT h FROM HK001 h WHERE h.endDate2 = :endDate2"),
    @NamedQuery(name = "HK001.findByEndDate3", query = "SELECT h FROM HK001 h WHERE h.endDate3 = :endDate3")})
public class HK001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "contractDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractDate;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "yearDeposit")
    private String yearDeposit;
    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private ProcessInstance processSerialNumber;
    @Size(max = 255)
    @Column(name = "monthDeposit")
    private String monthDeposit;
    @Size(max = 255)
    @Column(name = "payWay")
    private String payWay;
    @JoinColumn(name = "applyUser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyUser;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @JoinColumn(name = "applyDept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit applyDept;
    @Size(max = 255)
    @Column(name = "userPost")
    private String userPost;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "yearPay")
    private String yearPay;
    @Size(max = 255)
    @Column(name = "customerAddress")
    private String customerAddress;
    @Size(max = 255)
    @Column(name = "type3")
    private String type3;
    @Size(max = 255)
    @Column(name = "type2")
    private String type2;
    @Size(max = 255)
    @Column(name = "address1")
    private String address1;
    @Size(max = 255)
    @Column(name = "otherPerson")
    private String otherPerson;
    @Size(max = 255)
    @Column(name = "applyReason")
    private String applyReason;
    @Size(max = 255)
    @Column(name = "contracStigning")
    private String contracStigning;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "type1")
    private String type1;
    @Size(max = 255)
    @Column(name = "customerName")
    private String customerName;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "monthPay")
    private String monthPay;
    @Column(name = "startDate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate2;
    @Column(name = "startDate3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate3;
    @Column(name = "startDate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate1;
    @Size(max = 255)
    @Column(name = "domicile")
    private String domicile;
    @Size(max = 255)
    @Column(name = "residents")
    private String residents;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Column(name = "endDate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate1;
    @Column(name = "endDate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate2;
    @Column(name = "endDate3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate3;

    public HK001() {
    }

    public HK001(String oid) {
        this.oid = oid;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getYearDeposit() {
        return yearDeposit;
    }

    public void setYearDeposit(String yearDeposit) {
        this.yearDeposit = yearDeposit;
    }

    public ProcessInstance getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(ProcessInstance processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(String monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Users getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Users applyUser) {
        this.applyUser = applyUser;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public OrganizationUnit getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(OrganizationUnit applyDept) {
        this.applyDept = applyDept;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getYearPay() {
        return yearPay;
    }

    public void setYearPay(String yearPay) {
        this.yearPay = yearPay;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getOtherPerson() {
        return otherPerson;
    }

    public void setOtherPerson(String otherPerson) {
        this.otherPerson = otherPerson;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getContracStigning() {
        return contracStigning;
    }

    public void setContracStigning(String contracStigning) {
        this.contracStigning = contracStigning;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(String monthPay) {
        this.monthPay = monthPay;
    }

    public Date getStartDate2() {
        return startDate2;
    }

    public void setStartDate2(Date startDate2) {
        this.startDate2 = startDate2;
    }

    public Date getStartDate3() {
        return startDate3;
    }

    public void setStartDate3(Date startDate3) {
        this.startDate3 = startDate3;
    }

    public Date getStartDate1() {
        return startDate1;
    }

    public void setStartDate1(Date startDate1) {
        this.startDate1 = startDate1;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getResidents() {
        return residents;
    }

    public void setResidents(String residents) {
        this.residents = residents;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getEndDate1() {
        return endDate1;
    }

    public void setEndDate1(Date endDate1) {
        this.endDate1 = endDate1;
    }

    public Date getEndDate2() {
        return endDate2;
    }

    public void setEndDate2(Date endDate2) {
        this.endDate2 = endDate2;
    }

    public Date getEndDate3() {
        return endDate3;
    }

    public void setEndDate3(Date endDate3) {
        this.endDate3 = endDate3;
    }

    public String getType1Value() {
        switch (this.type1) {
            case "1":
                return "A/B职等 35元/日";
            case "2":
                return "C职等   45元/日";
            case "3":
                return "D职等   60元/日";
            default:
                return "";
        }
    }

    public String getType2Value() {
        switch (this.type2) {
            case "1":
                return "A/B职等 35元/日";
            case "2":
                return "C职等   45元/日";
            case "3":
                return "D职等   60元/日";
            default:
                return "";
        }
    }

    public String getType3Value() {
        switch (this.type3) {
            case "1":
                return "一室一厅";
            case "2":
                return "二室一厅";
            case "3":
                return "三室二厅";
            default:
                return "";
        }
    }

    public String getPayWayValue() {
        switch (this.payWay) {
            case "1":
                return "年付";
            case "2":
                return "季付";
            case "3":
                return "半年付";
            case "QT":
                return "其他";
            default:
                return "";
        }
    }

    public String getContracStigningValue() {
        switch (this.contracStigning) {
            case "1":
                return "公司";
            case "2":
                return "个人";
            default:
                return "";
        }
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
        if (!(object instanceof HK001)) {
            return false;
        }
        HK001 other = (HK001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HK001[ oid=" + oid + " ]";
    }

}
