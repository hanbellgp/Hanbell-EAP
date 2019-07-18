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
public class MCHKGL004 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String company;
    private String applyUser;
    private String applyDept;
    private String formType;
    private String formTypeDesc;
    private String formKind;
    private String formKindDesc;
    private String workType;
    private String workTypeDesc;

    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;

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
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the applyUser
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * @param applyUser the applyUser to set
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    /**
     * @return the applyDept
     */
    public String getApplyDept() {
        return applyDept;
    }

    /**
     * @param applyDept the applyDept to set
     */
    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        if (!(object instanceof MCHKGL004)) {
            return false;
        }
        MCHKGL004 other = (MCHKGL004) object;
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
