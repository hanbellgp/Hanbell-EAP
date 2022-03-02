/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author C0160
 */
public class MCHKGL034Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;

    private String lunch;
    private String dinner;
    private String deptno;
    private String id;
    private String date;

    private String starttime;
    private String endtime;
    private String worktime;
    private String note;

    public MCHKGL034Detail() {

    }

    /**
     * @return the lunch
     */
    public String getLunch() {
        return lunch;
    }

    /**
     * @param lunch the lunch to set
     */
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    /**
     * @return the dinner
     */
    public String getDinner() {
        return dinner;
    }

    /**
     * @param dinner the dinner to set
     */
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    /**
     * @return the deptno
     */
    public String getDeptno() {
        return deptno;
    }

    /**
     * @param deptno the deptno to set
     */
    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the starttime
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * @param starttime the starttime to set
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    /**
     * @return the endtime
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * @param endtime the endtime to set
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    /**
     * @return the worktime
     */
    public String getWorktime() {
        return worktime;
    }

    /**
     * @param worktime the worktime to set
     */
    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

}
