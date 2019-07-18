/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "HZ_CW028_tDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW028tDetail.findAll", query = "SELECT h FROM HZCW028tDetail h"),
    @NamedQuery(name = "HZCW028tDetail.findByOid", query = "SELECT h FROM HZCW028tDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW028tDetail.findByFSN", query = "SELECT h FROM HZCW028tDetail h WHERE h.formSerialNumber = :fsn ORDER BY h.trafficDatetxt ASC")})
public class HZCW028tDetail implements Serializable {

    @Size(max = 255)
    @Column(name = "isFree")
    private String isFree;
    @Size(max = 255)
    @Column(name = "customerSno2")
    private String customerSno2;
    @Size(max = 255)
    @Column(name = "serviceno2")
    private String serviceno2;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "taxi")
    private String taxi;
    @Size(max = 255)
    @Column(name = "allowance")
    private String allowance;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "trafficSummary")
    private String trafficSummary;
    @Size(max = 255)
    @Column(name = "bh3")
    private String bh3;
    @Size(max = 255)
    @Column(name = "bh2")
    private String bh2;
    @Size(max = 255)
    @Column(name = "receipt")
    private String receipt;
    @Size(max = 255)
    @Column(name = "subtotal")
    private String subtotal;
    @Size(max = 255)
    @Column(name = "trafficfee")
    private String trafficfee;
    @Size(max = 255)
    @Column(name = "bh1")
    private String bh1;
    @Size(max = 255)
    @Column(name = "trafficDate_txt")
    private String trafficDatetxt;
    @Size(max = 255)
    @Column(name = "sort3")
    private String sort3;
    @Size(max = 255)
    @Column(name = "sort2")
    private String sort2;
    @Size(max = 4000)
    @Column(name = "travelReport")
    private String travelReport;
    @Size(max = 255)
    @Column(name = "jc2")
    private String jc2;
    @Size(max = 255)
    @Column(name = "jc1")
    private String jc1;
    @Size(max = 255)
    @Column(name = "accommodation")
    private String accommodation;
    @Size(max = 255)
    @Column(name = "sort1")
    private String sort1;
    @Size(max = 255)
    @Column(name = "jc3")
    private String jc3;
    @Size(max = 255)
    @Column(name = "trafficPlace")
    private String trafficPlace;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "endMileage")
    private String endMileage;
    @Size(max = 255)
    @Column(name = "carUse")
    private String carUse;
    @Size(max = 255)
    @Column(name = "startMileage")
    private String startMileage;
    @Size(max = 255)
    @Column(name = "totalMileage")
    private String totalMileage;

    public HZCW028tDetail() {
    }

    public HZCW028tDetail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTaxi() {
        return taxi;
    }

    public void setTaxi(String taxi) {
        this.taxi = taxi;
    }

    public String getAllowance() {
        return allowance;
    }

    public void setAllowance(String allowance) {
        this.allowance = allowance;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTrafficSummary() {
        return trafficSummary;
    }

    public void setTrafficSummary(String trafficSummary) {
        this.trafficSummary = trafficSummary;
    }

    public String getBh3() {
        return bh3;
    }

    public void setBh3(String bh3) {
        this.bh3 = bh3;
    }

    public String getBh2() {
        return bh2;
    }

    public void setBh2(String bh2) {
        this.bh2 = bh2;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTrafficfee() {
        return trafficfee;
    }

    public void setTrafficfee(String trafficfee) {
        this.trafficfee = trafficfee;
    }

    public String getBh1() {
        return bh1;
    }

    public void setBh1(String bh1) {
        this.bh1 = bh1;
    }

    public String getTrafficDatetxt() {
        return trafficDatetxt;
    }

    public void setTrafficDatetxt(String trafficDatetxt) {
        this.trafficDatetxt = trafficDatetxt;
    }

    public String getSort3() {
        return sort3;
    }

    public void setSort3(String sort3) {
        this.sort3 = sort3;
    }

    public String getSort2() {
        return sort2;
    }

    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    public String getTravelReport() {
        return travelReport;
    }

    public void setTravelReport(String travelReport) {
        this.travelReport = travelReport;
    }

    public String getJc2() {
        return jc2;
    }

    public void setJc2(String jc2) {
        this.jc2 = jc2;
    }

    public String getJc1() {
        return jc1;
    }

    public void setJc1(String jc1) {
        this.jc1 = jc1;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getJc3() {
        return jc3;
    }

    public void setJc3(String jc3) {
        this.jc3 = jc3;
    }

    public String getTrafficPlace() {
        return trafficPlace;
    }

    public void setTrafficPlace(String trafficPlace) {
        this.trafficPlace = trafficPlace;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(String endMileage) {
        this.endMileage = endMileage;
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

    public String getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(String totalMileage) {
        this.totalMileage = totalMileage;
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
        if (!(object instanceof HZCW028tDetail)) {
            return false;
        }
        HZCW028tDetail other = (HZCW028tDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW028tDetail[ oid=" + oid + " ]";
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public String getCustomerSno2() {
        return customerSno2;
    }

    public void setCustomerSno2(String customerSno2) {
        this.customerSno2 = customerSno2;
    }

    public String getServiceno2() {
        return serviceno2;
    }

    public void setServiceno2(String serviceno2) {
        this.serviceno2 = serviceno2;
    }
    
}
