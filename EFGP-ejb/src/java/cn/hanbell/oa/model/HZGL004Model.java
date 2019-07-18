/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@XmlRootElement
public class HZGL004Model {

    private String facno;
    private String hdn_facno;
    private Date applyDate;
    private String applyUser;
    private String hdn_applyUser;
    private String applyDept;
    private String hdn_applyDept;
    private String formType;
    private String otherType;
    private String hdn_formType;
    private String vehicle;
    private String otherVehicle;
    private String hdn_vehicle;
    private String destination;
    private String hdn_destination;
    private Date day1;
    private Date day2;
    private Double days;
    private Double hdn_days;
    private String userTitle;
    private String hdn_employee;

    public HZGL004Model() {

    }

    /**
     * @return the facno
     */
    public String getFacno() {
        return facno;
    }

    /**
     * @return the hdn_facno
     */
    public String getHdn_facno() {
        return hdn_facno;
    }

    /**
     * @return the applyDate
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * @return the applyUser
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * @return the hdn_applyUser
     */
    public String getHdn_applyUser() {
        return hdn_applyUser;
    }

    /**
     * @return the applyDept
     */
    public String getApplyDept() {
        return applyDept;
    }

    /**
     * @return the hdn_applyDept
     */
    public String getHdn_applyDept() {
        return hdn_applyDept;
    }

    /**
     * @return the formType
     */
    public String getFormType() {
        return formType;
    }

    /**
     * @return the otherType
     */
    public String getOtherType() {
        return otherType;
    }

    /**
     * @return the hdn_formType
     */
    public String getHdn_formType() {
        return hdn_formType;
    }

    /**
     * @return the vehicle
     */
    public String getVehicle() {
        return vehicle;
    }

    /**
     * @return the otherVehicle
     */
    public String getOtherVehicle() {
        return otherVehicle;
    }

    /**
     * @return the hdn_vehicle
     */
    public String getHdn_vehicle() {
        return hdn_vehicle;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @return the hdn_destination
     */
    public String getHdn_destination() {
        return hdn_destination;
    }

    /**
     * @return the day1
     */
    public Date getDay1() {
        return day1;
    }

    /**
     * @return the day2
     */
    public Date getDay2() {
        return day2;
    }

    /**
     * @return the days
     */
    public Double getDays() {
        return days;
    }

    /**
     * @return the hdn_days
     */
    public Double getHdn_days() {
        return hdn_days;
    }

    /**
     * @return the userTitle
     */
    public String getUserTitle() {
        return userTitle;
    }

    /**
     * @return the hdn_employee
     */
    public String getHdn_employee() {
        return hdn_employee;
    }

    /**
     * @param facno the facno to set
     */
    public void setFacno(String facno) {
        this.facno = facno;
    }

    /**
     * @param hdn_facno the hdn_facno to set
     */
    public void setHdn_facno(String hdn_facno) {
        this.hdn_facno = hdn_facno;
    }

    /**
     * @param applyDate the applyDate to set
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * @param applyUser the applyUser to set
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    /**
     * @param hdn_applyUser the hdn_applyUser to set
     */
    public void setHdn_applyUser(String hdn_applyUser) {
        this.hdn_applyUser = hdn_applyUser;
    }

    /**
     * @param applyDept the applyDept to set
     */
    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    /**
     * @param hdn_applyDept the hdn_applyDept to set
     */
    public void setHdn_applyDept(String hdn_applyDept) {
        this.hdn_applyDept = hdn_applyDept;
    }

    /**
     * @param formType the formType to set
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * @param otherType the otherType to set
     */
    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    /**
     * @param hdn_formType the hdn_formType to set
     */
    public void setHdn_formType(String hdn_formType) {
        this.hdn_formType = hdn_formType;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @param otherVehicle the otherVehicle to set
     */
    public void setOtherVehicle(String otherVehicle) {
        this.otherVehicle = otherVehicle;
    }

    /**
     * @param hdn_vehicle the hdn_vehicle to set
     */
    public void setHdn_vehicle(String hdn_vehicle) {
        this.hdn_vehicle = hdn_vehicle;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @param hdn_destination the hdn_destination to set
     */
    public void setHdn_destination(String hdn_destination) {
        this.hdn_destination = hdn_destination;
    }

    /**
     * @param day1 the day1 to set
     */
    public void setDay1(Date day1) {
        this.day1 = day1;
    }

    /**
     * @param day2 the day2 to set
     */
    public void setDay2(Date day2) {
        this.day2 = day2;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Double days) {
        this.days = days;
    }

    /**
     * @param hdn_days the hdn_days to set
     */
    public void setHdn_days(Double hdn_days) {
        this.hdn_days = hdn_days;
    }

    /**
     * @param userTitle the userTitle to set
     */
    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    /**
     * @param hdn_employee the hdn_employee to set
     */
    public void setHdn_employee(String hdn_employee) {
        this.hdn_employee = hdn_employee;
    }

}
