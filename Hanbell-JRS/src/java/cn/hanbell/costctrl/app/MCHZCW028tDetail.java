/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCHZCW028tDetail {

    private int no;
    private String trafficDate;
    private String trafficPlace;
    private String trafficSummary;
    private int bill_num;
    private double taxi;
    private double trafficfee;
    private double accommodation;
    private double allowance;
    private double subtotal;
    private String travelReport;
    private double otherFee;
    private int esgaccommdays;  //住宿天数
    private double  esgmileages; //碳排查公里数
    private String esgvehicle; //交通方式

    public MCHZCW028tDetail() {

    }

    public String getTrafficPlace() {
        return trafficPlace;
    }

    public void setTrafficPlace(String trafficPlace) {
        this.trafficPlace = trafficPlace;
    }

    public String getTrafficSummary() {
        return trafficSummary;
    }

    public void setTrafficSummary(String trafficSummary) {
        this.trafficSummary = trafficSummary;
    }

    public double getTaxi() {
        return taxi;
    }

    public void setTaxi(double taxi) {
        this.taxi = taxi;
    }

    public double getTrafficfee() {
        return trafficfee;
    }

    public void setTrafficfee(double trafficfee) {
        this.trafficfee = trafficfee;
    }

    public double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(double accommodation) {
        this.accommodation = accommodation;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTrafficDate() {
        return trafficDate;
    }

    public void setTrafficDate(String trafficDate) {
        this.trafficDate = trafficDate;
    }

    public String getTravelReport() {
        return travelReport;
    }

    public void setTravelReport(String travelReport) {
        this.travelReport = travelReport;
    }

    public int getBill_num() {
        return bill_num;
    }

    public void setBill_num(int bill_num) {
        this.bill_num = bill_num;
    }

    public double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(double otherFee) {
        this.otherFee = otherFee;
    }

    @Override
    public String toString() {
        return "MCHZCW028tDetail{" + "no=" + no + ", trafficDate=" + trafficDate + ", trafficPlace=" + trafficPlace + ", trafficSummary=" + trafficSummary + ", bill_num=" + bill_num + ", taxi=" + taxi + ", trafficfee=" + trafficfee + ", accommodation=" + accommodation + ", allowance=" + allowance + ", subtotal=" + subtotal + ", travelReport=" + travelReport + ", otherFee=" + otherFee + '}';
    }

    public int getEsgaccommdays() {
        return esgaccommdays;
    }

    public void setEsgaccommdays(int esgaccommdays) {
        this.esgaccommdays = esgaccommdays;
    }

    public double getEsgmileages() {
        return esgmileages;
    }

    public void setEsgmileages(double esgmileages) {
        this.esgmileages = esgmileages;
    }

    public String getEsgvehicle() {
        return esgvehicle;
    }

    public void setEsgvehicle(String esgvehicle) {
        this.esgvehicle = esgvehicle;
    }

}
