/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class HZCW033tDetailModel {

    private int no;
    private String trafficDate_txt;
    private String trafficPlace;
    private String trafficSummary;
    private String receipt;
    private double taxi;
    private double trafficfee;
    private double accommodation;
    private double allowance;
    private double subtotal;
    private String travelReport;
    private String sort1;
    private String bh1;
    private String jc1;
    private String sort2;
    private String bh2;
    private String jc2;
    private String sort3;
    private String bh3;
    private String jc3;
    private String carUse;
    private String startMileage;
    private String endMileage;
    private String totalMileage;

    public HZCW033tDetailModel() {
        
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

    public String getTrafficDate_txt() {
        return trafficDate_txt;
    }

    public void setTrafficDate_txt(String trafficDate_txt) {
        this.trafficDate_txt = trafficDate_txt;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getTravelReport() {
        return travelReport;
    }

    public void setTravelReport(String travelReport) {
        this.travelReport = travelReport;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getBh1() {
        return bh1;
    }

    public void setBh1(String bh1) {
        this.bh1 = bh1;
    }

    public String getJc1() {
        return jc1;
    }

    public void setJc1(String jc1) {
        this.jc1 = jc1;
    }

    public String getSort2() {
        return sort2;
    }

    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    public String getBh2() {
        return bh2;
    }

    public void setBh2(String bh2) {
        this.bh2 = bh2;
    }

    public String getJc2() {
        return jc2;
    }

    public void setJc2(String jc2) {
        this.jc2 = jc2;
    }

    public String getSort3() {
        return sort3;
    }

    public void setSort3(String sort3) {
        this.sort3 = sort3;
    }

    public String getBh3() {
        return bh3;
    }

    public void setBh3(String bh3) {
        this.bh3 = bh3;
    }

    public String getJc3() {
        return jc3;
    }

    public void setJc3(String jc3) {
        this.jc3 = jc3;
    }

    public String getCarUse() {
        return carUse;
    }

    public void setCarUse(String carUse) {
        this.carUse = carUse;
    }

    public String getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(String startMileage) {
        this.startMileage = startMileage;
    }

    public String getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(String endMileage) {
        this.endMileage = endMileage;
    }

    public String getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(String totalMileage) {
        this.totalMileage = totalMileage;
    }

}
