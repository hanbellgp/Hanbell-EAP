/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@XmlRootElement
public class MCHZGL004 {

    private String company;
    private String applyDate;
    private String applyUser;
    private String applyDept;
    private String formType;
    private String otherType;
    private String formTypeDesc;
    private String vehicle;
    private String otherVehicle;
    private String vehicleDesc;
    private String country;
    private String destination;
    private String destinationDesc;
    private String startDate;
    private String endDate;
    private Double days;
    private String userTitle;
    private List<MCHZGL004BizDetail> detailList;

    public MCHZGL004() {

    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @return the applyDate
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * @return the applyUser
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * @return the applyDept
     */
    public String getApplyDept() {
        return applyDept;
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
     * @return the formTypeDesc
     */
    public String getFormTypeDesc() {
        return formTypeDesc;
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
     * @return the vehicleDesc
     */
    public String getVehicleDesc() {
        return vehicleDesc;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @return the destinationDesc
     */
    public String getDestinationDesc() {
        return destinationDesc;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @return the days
     */
    public Double getDays() {
        return days;
    }

    /**
     * @return the userTitle
     */
    public String getUserTitle() {
        return userTitle;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @param applyDate the applyDate to set
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * @param applyUser the applyUser to set
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    /**
     * @param applyDept the applyDept to set
     */
    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
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
     * @param formTypeDesc the formTypeDesc to set
     */
    public void setFormTypeDesc(String formTypeDesc) {
        this.formTypeDesc = formTypeDesc;
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
     * @param vehicleDesc the vehicleDesc to set
     */
    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @param destinationDesc the destinationDesc to set
     */
    public void setDestinationDesc(String destinationDesc) {
        this.destinationDesc = destinationDesc;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Double days) {
        this.days = days;
    }

    /**
     * @param userTitle the userTitle to set
     */
    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    /**
     * @return the detailList
     */
    public List<MCHZGL004BizDetail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<MCHZGL004BizDetail> detailList) {
        this.detailList = detailList;
    }

}
