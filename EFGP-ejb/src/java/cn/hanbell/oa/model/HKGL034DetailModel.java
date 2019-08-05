/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@XmlRootElement
public class HKGL034DetailModel implements Serializable {

    private String seq;
    private String dept_txt;
    private String dept_lbl;
    private String employee;
    private String employeeName;
    private String content;
    private String date1_txt;
    private String time1_txt;
    private String time2_txt;
    private String hour;
    private String hdn_lunch;
    private String hdn_dinner;

    public HKGL034DetailModel() {
    }

    /**
     * @return the seq
     */
    public String getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * @return the dept_txt
     */
    public String getDept_txt() {
        return dept_txt;
    }

    /**
     * @param dept_txt the dept_txt to set
     */
    public void setDept_txt(String dept_txt) {
        this.dept_txt = dept_txt;
    }

    /**
     * @return the dept_lbl
     */
    public String getDept_lbl() {
        return dept_lbl;
    }

    /**
     * @param dept_lbl the dept_lbl to set
     */
    public void setDept_lbl(String dept_lbl) {
        this.dept_lbl = dept_lbl;
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
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the date1_txt
     */
    public String getDate1_txt() {
        return date1_txt;
    }

    /**
     * @param date1_txt the date1_txt to set
     */
    public void setDate1_txt(String date1_txt) {
        this.date1_txt = date1_txt;
    }

    /**
     * @return the time1_txt
     */
    public String getTime1_txt() {
        return time1_txt;
    }

    /**
     * @param time1_txt the time1_txt to set
     */
    public void setTime1_txt(String time1_txt) {
        this.time1_txt = time1_txt;
    }

    /**
     * @return the time2_txt
     */
    public String getTime2_txt() {
        return time2_txt;
    }

    /**
     * @param time2_txt the time2_txt to set
     */
    public void setTime2_txt(String time2_txt) {
        this.time2_txt = time2_txt;
    }

    /**
     * @return the hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * @return the hdn_dinner
     */
    public String getHdn_dinner() {
        return hdn_dinner;
    }

    /**
     * @param hdn_dinner the hdn_dinner to set
     */
    public void setHdn_dinner(String hdn_dinner) {
        this.hdn_dinner = hdn_dinner;
    }

    /**
     * @return the hdn_lunch
     */
    public String getHdn_lunch() {
        return hdn_lunch;
    }

    /**
     * @param hdn_lunch the hdn_lunch to set
     */
    public void setHdn_lunch(String hdn_lunch) {
        this.hdn_lunch = hdn_lunch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKGL034DetailModel)) {
            return false;
        }
        HKGL034DetailModel other = (HKGL034DetailModel) object;
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL034Detail";
    }

}
