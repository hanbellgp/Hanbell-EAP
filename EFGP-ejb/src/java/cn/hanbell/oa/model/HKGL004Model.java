/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@XmlRootElement
public class HKGL004Model implements Serializable {

    private String facno;
    private String hdn_facno;
    private Date applyDate;
    private String applyUser;
    private String hdn_applyUser;
    private String applyDept;
    private String hdn_applyDept;

    private String leana;
    private String hdn_leana;
    private String leano;
    private String hdn_leano;
    private String leatp;
    private String hdn_leatp;

    private String employee;
    private String hdn_employee;
    private String day;
    private String userTitle;
    private Double leaday1;
    private Double leaday2;
    private Double leaday3;
    private Date date1;
    private Date date2;
    private String time1;
    private String time2;
    private String reason;

    public HKGL004Model() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKGL004Model)) {
            return false;
        }
        HKGL004Model other = (HKGL004Model) object;
        if ((this.getEmployee() != null) && (other.getEmployee() != null)) {
            return this.getEmployee().equals(other.getEmployee());
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL004";
    }

    /**
     * @return the facno
     */
    public String getFacno() {
        return facno;
    }

    /**
     * @param facno the facno to set
     */
    public void setFacno(String facno) {
        this.facno = facno;
    }

    /**
     * @return the applyDate
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate the applyDate to set
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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
     * @return the hdn_facno
     */
    public String getHdn_facno() {
        return hdn_facno;
    }

    /**
     * @param hdn_facno the hdn_facno to set
     */
    public void setHdn_facno(String hdn_facno) {
        this.hdn_facno = hdn_facno;
    }

    /**
     * @return the hdn_applyDept
     */
    public String getHdn_applyDept() {
        return hdn_applyDept;
    }

    /**
     * @param hdn_applyDept the hdn_applyDept to set
     */
    public void setHdn_applyDept(String hdn_applyDept) {
        this.hdn_applyDept = hdn_applyDept;
    }

    /**
     * @return the hdn_applyUser
     */
    public String getHdn_applyUser() {
        return hdn_applyUser;
    }

    /**
     * @param hdn_applyUser the hdn_applyUser to set
     */
    public void setHdn_applyUser(String hdn_applyUser) {
        this.hdn_applyUser = hdn_applyUser;
    }

    /**
     * @return the leana
     */
    public String getLeana() {
        return leana;
    }

    /**
     * @param leana the leana to set
     */
    public void setLeana(String leana) {
        this.leana = leana;
    }

    /**
     * @return the leano
     */
    public String getLeano() {
        return leano;
    }

    /**
     * @param leano the leano to set
     */
    public void setLeano(String leano) {
        this.leano = leano;
    }

    /**
     * @return the leatp
     */
    public String getLeatp() {
        return leatp;
    }

    /**
     * @param leatp the leatp to set
     */
    public void setLeatp(String leatp) {
        this.leatp = leatp;
    }

    /**
     * @return the hdn_leana
     */
    public String getHdn_leana() {
        return hdn_leana;
    }

    /**
     * @param hdn_leana the hdn_leana to set
     */
    public void setHdn_leana(String hdn_leana) {
        this.hdn_leana = hdn_leana;
    }

    /**
     * @return the hdn_leano
     */
    public String getHdn_leano() {
        return hdn_leano;
    }

    /**
     * @param hdn_leano the hdn_leano to set
     */
    public void setHdn_leano(String hdn_leano) {
        this.hdn_leano = hdn_leano;
    }

    /**
     * @return the hdn_leatp
     */
    public String getHdn_leatp() {
        return hdn_leatp;
    }

    /**
     * @param hdn_leatp the hdn_leatp to set
     */
    public void setHdn_leatp(String hdn_leatp) {
        this.hdn_leatp = hdn_leatp;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the userTitle
     */
    public String getUserTitle() {
        return userTitle;
    }

    /**
     * @param userTitle the userTitle to set
     */
    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    /**
     * @return the leaday1
     */
    public Double getLeaday1() {
        return leaday1;
    }

    /**
     * @param leaday1 the leaday1 to set
     */
    public void setLeaday1(Double leaday1) {
        this.leaday1 = leaday1;
    }

    /**
     * @return the leaday2
     */
    public Double getLeaday2() {
        return leaday2;
    }

    /**
     * @param leaday2 the leaday2 to set
     */
    public void setLeaday2(Double leaday2) {
        this.leaday2 = leaday2;
    }

    /**
     * @return the leaday3
     */
    public Double getLeaday3() {
        return leaday3;
    }

    /**
     * @param leaday3 the leaday3 to set
     */
    public void setLeaday3(Double leaday3) {
        this.leaday3 = leaday3;
    }

    /**
     * @return the date1
     */
    public Date getDate1() {
        return date1;
    }

    /**
     * @param date1 the date1 to set
     */
    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    /**
     * @return the date2
     */
    public Date getDate2() {
        return date2;
    }

    /**
     * @param date2 the date2 to set
     */
    public void setDate2(Date date2) {
        this.date2 = date2;
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

    /**
     * @return the hdn_employee
     */
    public String getHdn_employee() {
        return hdn_employee;
    }

    /**
     * @param hdn_employee the hdn_employee to set
     */
    public void setHdn_employee(String hdn_employee) {
        this.hdn_employee = hdn_employee;
    }

}
