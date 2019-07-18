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
 * @author C0160
 */
@Entity
@Table(name = "HZ_GL004")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZGL004.findAll", query = "SELECT h FROM HZGL004 h"),
    @NamedQuery(name = "HZGL004.findByOID", query = "SELECT h FROM HZGL004 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZGL004.findByPSN", query = "SELECT h FROM HZGL004 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZGL004.findByFSN", query = "SELECT h FROM HZGL004 h WHERE h.formSerialNumber = :fsn")})
public class HZGL004 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "hdn_applyUser")
    private String hdnapplyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "hdn_applyDept")
    private String hdnapplyDept;
    @Size(max = 255)
    @Column(name = "formType")
    private String formType;
    @Size(max = 255)
    @Column(name = "otherType")
    private String otherType;
    @Size(max = 255)
    @Column(name = "hdn_formType")
    private String hdnformType;
    @Size(max = 255)
    @Column(name = "vehicle")
    private String vehicle;
    @Size(max = 255)
    @Column(name = "otherVehicle")
    private String otherVehicle;
    @Size(max = 255)
    @Column(name = "hdn_vehicle")
    private String hdnVehicle;
    @Size(max = 255)
    @Column(name = "destination")
    private String destination;
    @Size(max = 255)
    @Column(name = "hdn_destination")
    private String hdnDestination;
    @Column(name = "day1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date day1;
    @Column(name = "day2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date day2;
    @Column(name = "days")
    private Double days;
    @Column(name = "hdn_days")
    private Double hdnDays;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "hdn_employee")
    private String hdnEmployee;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HZGL004() {
    }

    public HZGL004(String oid) {
        this.oid = oid;
    }

    public String getHdnapplyUser() {
        return hdnapplyUser;
    }

    public void setHdnapplyUser(String hdnapplyUser) {
        this.hdnapplyUser = hdnapplyUser;
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

    public String getHdnformType() {
        return hdnformType;
    }

    public void setHdnformType(String hdnformType) {
        this.hdnformType = hdnformType;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public String getOtherVehicle() {
        return otherVehicle;
    }

    public void setOtherVehicle(String otherVehicle) {
        this.otherVehicle = otherVehicle;
    }

    public String getHdnVehicle() {
        return hdnVehicle;
    }

    public void setHdnVehicle(String hdnVehicle) {
        this.hdnVehicle = hdnVehicle;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDay2() {
        return day2;
    }

    public void setDay2(Date day2) {
        this.day2 = day2;
    }

    public Date getDay1() {
        return day1;
    }

    public void setDay1(Date day1) {
        this.day1 = day1;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getHdnapplyDept() {
        return hdnapplyDept;
    }

    public void setHdnapplyDept(String hdnapplyDept) {
        this.hdnapplyDept = hdnapplyDept;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Double getHdnDays() {
        return hdnDays;
    }

    public void setHdnDays(Double hdnDays) {
        this.hdnDays = hdnDays;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days;
    }

    public String getHdnEmployee() {
        return hdnEmployee;
    }

    public void setHdnEmployee(String hdnEmployee) {
        this.hdnEmployee = hdnEmployee;
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
        if (!(object instanceof HZGL004)) {
            return false;
        }
        HZGL004 other = (HZGL004) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZGL004[ oid=" + oid + " ]";
    }

}
