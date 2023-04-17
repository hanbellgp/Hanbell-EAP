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
@Table(name = "HK_GL055")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL055.findAll", query = "SELECT h FROM HKGL055 h"),
    @NamedQuery(name = "HKGL055.findByOid", query = "SELECT h FROM HKGL055 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL055.findByPSN", query = "SELECT h FROM HKGL055 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL055.findByFSN", query = "SELECT h FROM HKGL055 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL055.findByHkgl037", query = "SELECT h FROM HKGL055 h WHERE h.hkgl037 = :hkgl037")})
public class HKGL055 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "returnTime")
    private String returnTime;
    @Size(max = 255)
    @Column(name = "rentAddress")
    private String rentAddress;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "returnAddress")
    private String returnAddress;
    @Size(max = 255)
    @Column(name = "rentCar")
    private String rentCar;
    @Size(max = 255)
    @Column(name = "hdn_applyDept")
    private String hdnapplyDept;
    @Column(name = "returnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Size(max = 255)
    @Column(name = "hdn_applyUser")
    private String hdnapplyUser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "hdn_destination")
    private String hdnDestination;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "rentTime")
    private String rentTime;
    @Size(max = 255)
    @Column(name = "restDays")
    private String restDays;
    @Column(name = "restDay1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date restDay1;
    @Column(name = "restDay2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date restDay2;
    @Size(max = 255)
    @Column(name = "report")
    private String report;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "restTime1")
    private String restTime1;
    @Size(max = 255)
    @Column(name = "restTime2")
    private String restTime2;
    @Column(name = "rentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentDate;
    @Size(max = 255)
    @Column(name = "reportAddress")
    private String reportAddress;
    @Size(max = 255)
    @Column(name = "hdn_holiday")
    private String hdnHoliday;
    @Size(max = 255)
    @Column(name = "reportContent")
    private String reportContent;
    @Size(max = 255)
    @Column(name = "otherholiday")
    private String otherholiday;
    @Size(max = 255)
    @Column(name = "destination")
    private String destination;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "holiday")
    private String holiday;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;
    @Size(max = 255)
    @Column(name = "restEmployee")
    private String restEmployee;
    @Size(max = 255)
    @Column(name = "restDept")
    private String restDept;
    @Size(max = 255)
    @Column(name = "cause")
    private String cause;
    @Size(max = 255)
    @Column(name = "vehicle")
    private String vehicle;
    @Size(max = 255)
    @Column(name = "contact")
    private String contact;
    @Size(max = 255)
    @Column(name = "departureCity")
    private String departureCity;
    @Size(max = 255)
    @Column(name = "destinationCity")
    private String destinationCity;
    @Column(name = "usecarDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usecarDate;
    @Size(max = 255)
    @Column(name = "hkgl037")
    private String hkgl037;

    public HKGL055() {
    }

    public HKGL055(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getRentAddress() {
        return rentAddress;
    }

    public void setRentAddress(String rentAddress) {
        this.rentAddress = rentAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public String getRentCar() {
        return rentCar;
    }

    public void setRentCar(String rentCar) {
        this.rentCar = rentCar;
    }

    public String getHdnapplyDept() {
        return hdnapplyDept;
    }

    public void setHdnapplyDept(String hdnapplyDept) {
        this.hdnapplyDept = hdnapplyDept;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getHdnapplyUser() {
        return hdnapplyUser;
    }

    public void setHdnapplyUser(String hdnapplyUser) {
        this.hdnapplyUser = hdnapplyUser;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHdnDestination() {
        return hdnDestination;
    }

    public void setHdnDestination(String hdnDestination) {
        this.hdnDestination = hdnDestination;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getRestDays() {
        return restDays;
    }

    public void setRestDays(String restDays) {
        this.restDays = restDays;
    }

    public Date getRestDay1() {
        return restDay1;
    }

    public void setRestDay1(Date restDay1) {
        this.restDay1 = restDay1;
    }

    public Date getRestDay2() {
        return restDay2;
    }

    public void setRestDay2(Date restDay2) {
        this.restDay2 = restDay2;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getRestTime1() {
        return restTime1;
    }

    public void setRestTime1(String restTime1) {
        this.restTime1 = restTime1;
    }

    public String getRestTime2() {
        return restTime2;
    }

    public void setRestTime2(String restTime2) {
        this.restTime2 = restTime2;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public String getReportAddress() {
        return reportAddress;
    }

    public void setReportAddress(String reportAddress) {
        this.reportAddress = reportAddress;
    }

    public String getHdnHoliday() {
        return hdnHoliday;
    }

    public void setHdnHoliday(String hdnHoliday) {
        this.hdnHoliday = hdnHoliday;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getOtherholiday() {
        return otherholiday;
    }

    public void setOtherholiday(String otherholiday) {
        this.otherholiday = otherholiday;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
    }

    public String getRestEmployee() {
        return restEmployee;
    }

    public void setRestEmployee(String restEmployee) {
        this.restEmployee = restEmployee;
    }

    public String getRestDept() {
        return restDept;
    }

    public void setRestDept(String restDept) {
        this.restDept = restDept;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getUsecarDate() {
        return usecarDate;
    }

    public void setUsecarDate(Date usecarDate) {
        this.usecarDate = usecarDate;
    }

    public String getHkgl037() {
        return hkgl037;
    }

    public void setHkgl037(String hkgl037) {
        this.hkgl037 = hkgl037;
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
        if (!(object instanceof HKGL055)) {
            return false;
        }
        HKGL055 other = (HKGL055) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL055[ oid=" + oid + " ]";
    }
    
}
