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
 * @author C2082
 */
@Entity
@Table(name = "HZ_CW033_tDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW033tDetail.findAll", query = "SELECT h FROM HZCW033tDetail h"),
    @NamedQuery(name = "HZCW033tDetail.findByOID", query = "SELECT h FROM HZCW033tDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW033tDetail.findByTaxi", query = "SELECT h FROM HZCW033tDetail h WHERE h.taxi = :taxi"),
    @NamedQuery(name = "HZCW033tDetail.findByAllowance", query = "SELECT h FROM HZCW033tDetail h WHERE h.allowance = :allowance"),
    @NamedQuery(name = "HZCW033tDetail.findByNo", query = "SELECT h FROM HZCW033tDetail h WHERE h.no = :no"),
    @NamedQuery(name = "HZCW033tDetail.findByTrafficSummary", query = "SELECT h FROM HZCW033tDetail h WHERE h.trafficSummary = :trafficSummary"),
    @NamedQuery(name = "HZCW033tDetail.findByBh3", query = "SELECT h FROM HZCW033tDetail h WHERE h.bh3 = :bh3"),
    @NamedQuery(name = "HZCW033tDetail.findByBh2", query = "SELECT h FROM HZCW033tDetail h WHERE h.bh2 = :bh2"),
    @NamedQuery(name = "HZCW033tDetail.findByReceipt", query = "SELECT h FROM HZCW033tDetail h WHERE h.receipt = :receipt"),
    @NamedQuery(name = "HZCW033tDetail.findBySubtotal", query = "SELECT h FROM HZCW033tDetail h WHERE h.subtotal = :subtotal"),
    @NamedQuery(name = "HZCW033tDetail.findByTrafficfee", query = "SELECT h FROM HZCW033tDetail h WHERE h.trafficfee = :trafficfee"),
    @NamedQuery(name = "HZCW033tDetail.findByBh1", query = "SELECT h FROM HZCW033tDetail h WHERE h.bh1 = :bh1"),
    @NamedQuery(name = "HZCW033tDetail.findByTrafficDatetxt", query = "SELECT h FROM HZCW033tDetail h WHERE h.trafficDatetxt = :trafficDatetxt"),
    @NamedQuery(name = "HZCW033tDetail.findBySort3", query = "SELECT h FROM HZCW033tDetail h WHERE h.sort3 = :sort3"),
    @NamedQuery(name = "HZCW033tDetail.findBySort2", query = "SELECT h FROM HZCW033tDetail h WHERE h.sort2 = :sort2"),
    @NamedQuery(name = "HZCW033tDetail.findByTravelReport", query = "SELECT h FROM HZCW033tDetail h WHERE h.travelReport = :travelReport"),
    @NamedQuery(name = "HZCW033tDetail.findByJc2", query = "SELECT h FROM HZCW033tDetail h WHERE h.jc2 = :jc2"),
    @NamedQuery(name = "HZCW033tDetail.findByJc1", query = "SELECT h FROM HZCW033tDetail h WHERE h.jc1 = :jc1"),
    @NamedQuery(name = "HZCW033tDetail.findByAccommodation", query = "SELECT h FROM HZCW033tDetail h WHERE h.accommodation = :accommodation"),
    @NamedQuery(name = "HZCW033tDetail.findBySort1", query = "SELECT h FROM HZCW033tDetail h WHERE h.sort1 = :sort1"),
    @NamedQuery(name = "HZCW033tDetail.findByJc3", query = "SELECT h FROM HZCW033tDetail h WHERE h.jc3 = :jc3"),
    @NamedQuery(name = "HZCW033tDetail.findByTrafficPlace", query = "SELECT h FROM HZCW033tDetail h WHERE h.trafficPlace = :trafficPlace"),
    @NamedQuery(name = "HZCW033tDetail.findByFSN", query = "SELECT h FROM HZCW033tDetail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW033tDetail.findByEndMileage", query = "SELECT h FROM HZCW033tDetail h WHERE h.endMileage = :endMileage"),
    @NamedQuery(name = "HZCW033tDetail.findByCarUse", query = "SELECT h FROM HZCW033tDetail h WHERE h.carUse = :carUse"),
    @NamedQuery(name = "HZCW033tDetail.findByStartMileage", query = "SELECT h FROM HZCW033tDetail h WHERE h.startMileage = :startMileage"),
    @NamedQuery(name = "HZCW033tDetail.findByTotalMileage", query = "SELECT h FROM HZCW033tDetail h WHERE h.totalMileage = :totalMileage")})
public class HZCW033tDetail implements Serializable {

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
    @Size(max = 255)
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

    public HZCW033tDetail() {
    }

    public HZCW033tDetail(String oid) {
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
        if (!(object instanceof HZCW033tDetail)) {
            return false;
        }
        HZCW033tDetail other = (HZCW033tDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW033tDetail[ oid=" + oid + " ]";
    }
    
}
