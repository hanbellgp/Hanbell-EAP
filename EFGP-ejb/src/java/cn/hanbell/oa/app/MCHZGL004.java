/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

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
    private boolean safeplace;

    //派车单栏位
    private String useCar;
    private String clxz;
    private String privatedriverno;
    private String privatecarno;
    private String purpose;
    private String staykey;
    private String departurekey;
    private String registrationkey;
    private String telcontact;
    private String hmark1;

    private List<MCHZGL004BizDetail> detailList;
    private List<MCHZGL004CarDetail> cardetailList;
    private List<HZGL004FilesApplication> hzgl004Files;
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

    public boolean getSafeplace() {
        return safeplace;
    }

    public void setSafeplace(boolean safeplace) {
        this.safeplace = safeplace;
    }

    public String getUseCar() {
        return useCar;
    }

    public void setUseCar(String useCar) {
        this.useCar = useCar;
    }

    public String getClxz() {
        return clxz;
    }

    public void setClxz(String clxz) {
        this.clxz = clxz;
    }

    public String getPrivatedriverno() {
        return privatedriverno;
    }

    public void setPrivatedriverno(String privatedriverno) {
        this.privatedriverno = privatedriverno;
    }

    public String getPrivatecarno() {
        return privatecarno;
    }

    public void setPrivatecarno(String privatecarno) {
        this.privatecarno = privatecarno;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStaykey() {
        return staykey;
    }

    public void setStaykey(String staykey) {
        this.staykey = staykey;
    }

    public String getDeparturekey() {
        return departurekey;
    }

    public void setDeparturekey(String departurekey) {
        this.departurekey = departurekey;
    }

    public String getRegistrationkey() {
        return registrationkey;
    }

    public void setRegistrationkey(String registrationkey) {
        this.registrationkey = registrationkey;
    }

    public String getTelcontact() {
        return telcontact;
    }

    public void setTelcontact(String telcontact) {
        this.telcontact = telcontact;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public List<MCHZGL004CarDetail> getCardetailList() {
        return cardetailList;
    }

    public void setCardetailList(List<MCHZGL004CarDetail> cardetailList) {
        this.cardetailList = cardetailList;
    }

    public List<HZGL004FilesApplication> getHzgl004Files() {
        return hzgl004Files;
    }

    public void setHzgl004Files(List<HZGL004FilesApplication> hzgl004Files) {
        this.hzgl004Files = hzgl004Files;
    }

}
