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
public class MCHZGL004BizDetail {

    private String bizEmployee;
    private String bizEmployeeName;
    private String bizDate;
    private String bizTime1;
    private String bizTime2;
    private String bizObject;
    private String bizAddress;
    private String bizContent;

    public MCHZGL004BizDetail() {

    }

    /**
     * @return the bizEmployee
     */
    public String getBizEmployee() {
        return bizEmployee;
    }

    /**
     * @return the bizEmployeeName
     */
    public String getBizEmployeeName() {
        return bizEmployeeName;
    }

    /**
     * @return the bizDate
     */
    public String getBizDate() {
        return bizDate;
    }

    /**
     * @return the bizTime1
     */
    public String getBizTime1() {
        return bizTime1;
    }

    /**
     * @return the bizTime2
     */
    public String getBizTime2() {
        return bizTime2;
    }

    /**
     * @return the bizObject
     */
    public String getBizObject() {
        return bizObject;
    }

    /**
     * @return the bizAddress
     */
    public String getBizAddress() {
        return bizAddress;
    }

    /**
     * @return the bizContent
     */
    public String getBizContent() {
        return bizContent;
    }

    /**
     * @param bizEmployee the bizEmployee to set
     */
    public void setBizEmployee(String bizEmployee) {
        this.bizEmployee = bizEmployee;
    }

    /**
     * @param bizEmployeeName the bizEmployeeName to set
     */
    public void setBizEmployeeName(String bizEmployeeName) {
        this.bizEmployeeName = bizEmployeeName;
    }

    /**
     * @param bizDate the bizDate to set
     */
    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    /**
     * @param bizTime1 the bizTime1 to set
     */
    public void setBizTime1(String bizTime1) {
        this.bizTime1 = bizTime1;
    }

    /**
     * @param bizTime2 the bizTime2 to set
     */
    public void setBizTime2(String bizTime2) {
        this.bizTime2 = bizTime2;
    }

    /**
     * @param bizObject the bizObject to set
     */
    public void setBizObject(String bizObject) {
        this.bizObject = bizObject;
    }

    /**
     * @param bizAddress the bizAddress to set
     */
    public void setBizAddress(String bizAddress) {
        this.bizAddress = bizAddress;
    }

    /**
     * @param bizContent the bizContent to set
     */
    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

}
