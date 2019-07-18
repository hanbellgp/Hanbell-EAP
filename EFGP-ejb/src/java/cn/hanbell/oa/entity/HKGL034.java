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
@Table(name = "HK_GL034")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL034.findAll", query = "SELECT h FROM HKGL034 h"),
    @NamedQuery(name = "HKGL034.findByOID", query = "SELECT h FROM HKGL034 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL034.findBySerialNumber", query = "SELECT h FROM HKGL034 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL034.findByPSN", query = "SELECT h FROM HKGL034 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL034.findByFSN", query = "SELECT h FROM HKGL034 h WHERE h.formSerialNumber = :fsn")})
public class HKGL034 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "hdn_applyDept")
    private String hdnapplyDept;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "hdn_applyUser")
    private String hdnapplyUser;
    @Size(max = 255)
    @Column(name = "employeeName")
    private String employeeName;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdn_dinner")
    private String hdnDinner;
    @Size(max = 255)
    @Column(name = "time2")
    private String time2;
    @Size(max = 255)
    @Column(name = "time1")
    private String time1;
    @Size(max = 255)
    @Column(name = "hdn_type")
    private String hdnType;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "lunch")
    private String lunch;
    @Size(max = 255)
    @Column(name = "employee")
    private String employee;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "date1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hour")
    private Double hour;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "dinner")
    private String dinner;
    @Size(max = 255)
    @Column(name = "hdn_lunch")
    private String hdnLunch;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKGL034() {
    }

    public HKGL034(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getHdnapplyDept() {
        return hdnapplyDept;
    }

    public void setHdnapplyDept(String hdnapplyDept) {
        this.hdnapplyDept = hdnapplyDept;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHdnapplyUser() {
        return hdnapplyUser;
    }

    public void setHdnapplyUser(String hdnapplyUser) {
        this.hdnapplyUser = hdnapplyUser;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnDinner() {
        return hdnDinner;
    }

    public void setHdnDinner(String hdnDinner) {
        this.hdnDinner = hdnDinner;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getHdnType() {
        return hdnType;
    }

    public void setHdnType(String hdnType) {
        this.hdnType = hdnType;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getHdnLunch() {
        return hdnLunch;
    }

    public void setHdnLunch(String hdnLunch) {
        this.hdnLunch = hdnLunch;
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

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
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
        if (!(object instanceof HKGL034)) {
            return false;
        }
        HKGL034 other = (HKGL034) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL034[ oid=" + oid + " ]";
    }

}
