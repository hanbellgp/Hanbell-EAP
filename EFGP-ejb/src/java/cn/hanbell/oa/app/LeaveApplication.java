/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@XmlRootElement
public class LeaveApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employee;
    private String formType;
    private String formTypeDesc;
    private String formKind;
    private String formKindDesc;
    private String workType;
    private String workTypeDesc;

    private String date1;
    private String time1;
    private String date2;
    private String time2;

    private double leaveDay;
    private double leaveHour;
    private double leaveMinute;

    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the employee
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    /**
     * @return the formType
     */
    public String getFormType() {
        return formType;
    }

    /**
     * @param formType the formType to set
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * @return the formTypeDesc
     */
    public String getFormTypeDesc() {
        return formTypeDesc;
    }

    /**
     * @param formTypeDesc the formTypeDesc to set
     */
    public void setFormTypeDesc(String formTypeDesc) {
        this.formTypeDesc = formTypeDesc;
    }

    /**
     * @return the formKind
     */
    public String getFormKind() {
        return formKind;
    }

    /**
     * @param formKind the formKind to set
     */
    public void setFormKind(String formKind) {
        this.formKind = formKind;
    }

    /**
     * @return the formKindDesc
     */
    public String getFormKindDesc() {
        return formKindDesc;
    }

    /**
     * @param formKindDesc the formKindDesc to set
     */
    public void setFormKindDesc(String formKindDesc) {
        this.formKindDesc = formKindDesc;
    }

    /**
     * @return the workType
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * @param workType the workType to set
     */
    public void setWorkType(String workType) {
        this.workType = workType;
    }

    /**
     * @return the workTypeDesc
     */
    public String getWorkTypeDesc() {
        return workTypeDesc;
    }

    /**
     * @param workTypeDesc the workTypeDesc to set
     */
    public void setWorkTypeDesc(String workTypeDesc) {
        this.workTypeDesc = workTypeDesc;
    }

    /**
     * @return the date1
     */
    public String getDate1() {
        return date1;
    }

    /**
     * @param date1 the date1 to set
     */
    public void setDate1(String date1) {
        this.date1 = date1;
    }

    /**
     * @return the time1
     */
    public String getTime1() {
        return time1;
    }

    /**
     * @param time1 the time1 to set
     */
    public void setTime1(String time1) {
        this.time1 = time1;
    }

    /**
     * @return the date2
     */
    public String getDate2() {
        return date2;
    }

    /**
     * @param date2 the date2 to set
     */
    public void setDate2(String date2) {
        this.date2 = date2;
    }

    /**
     * @return the time2
     */
    public String getTime2() {
        return time2;
    }

    /**
     * @param time2 the time2 to set
     */
    public void setTime2(String time2) {
        this.time2 = time2;
    }

    /**
     * @return the leaveDay
     */
    public double getLeaveDay() {
        return leaveDay;
    }

    /**
     * @param leaveDay the leaveDay to set
     */
    public void setLeaveDay(double leaveDay) {
        this.leaveDay = leaveDay;
    }

    /**
     * @return the leaveHour
     */
    public double getLeaveHour() {
        return leaveHour;
    }

    /**
     * @param leaveHour the leaveHour to set
     */
    public void setLeaveHour(double leaveHour) {
        this.leaveHour = leaveHour;
    }

    /**
     * @return the leaveMinute
     */
    public double getLeaveMinute() {
        return leaveMinute;
    }

    /**
     * @param leaveMinute the leaveMinute to set
     */
    public void setLeaveMinute(double leaveMinute) {
        this.leaveMinute = leaveMinute;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveApplication)) {
            return false;
        }
        LeaveApplication other = (LeaveApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.LeaveApplication[ id=" + id + " ]";
    }

}
