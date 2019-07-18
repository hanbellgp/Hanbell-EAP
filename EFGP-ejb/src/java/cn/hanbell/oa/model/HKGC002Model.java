/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@XmlRootElement
public class HKGC002Model implements Serializable {

    private String facno;
    private String applyUser;
    private String applyDept;
    private Date applyDate;
    private String applyneed;
    private String srcno;
    private String itnbrf;
    private String itnbrfname;
    private String qty;
    private Date needdate;
    private String itnbr;
    private String itnbrname;
    private String supportUser;

    public HKGC002Model() {

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
     * @return the applyneed
     */
    public String getApplyneed() {
        return applyneed;
    }

    /**
     * @param applyneed the applyneed to set
     */
    public void setApplyneed(String applyneed) {
        this.applyneed = applyneed;
    }

    /**
     * @return the srcno
     */
    public String getSrcno() {
        return srcno;
    }

    /**
     * @param srcno the srcno to set
     */
    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    /**
     * @return the itnbrf
     */
    public String getItnbrf() {
        return itnbrf;
    }

    /**
     * @param itnbrf the itnbrf to set
     */
    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    /**
     * @return the itnbrfname
     */
    public String getItnbrfname() {
        return itnbrfname;
    }

    /**
     * @param itnbrfname the itnbrfname to set
     */
    public void setItnbrfname(String itnbrfname) {
        this.itnbrfname = itnbrfname;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the needdate
     */
    public Date getNeeddate() {
        return needdate;
    }

    /**
     * @param needdate the needdate to set
     */
    public void setNeeddate(Date needdate) {
        this.needdate = needdate;
    }

    /**
     * @return the itnbr
     */
    public String getItnbr() {
        return itnbr;
    }

    /**
     * @param itnbr the itnbr to set
     */
    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    /**
     * @return the itnbrname
     */
    public String getItnbrname() {
        return itnbrname;
    }

    /**
     * @param itnbrname the itnbrname to set
     */
    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    /**
     * @return the supportUser
     */
    public String getSupportUser() {
        return supportUser;
    }

    /**
     * @param supportUser the supportUser to set
     */
    public void setSupportUser(String supportUser) {
        this.supportUser = supportUser;
    }
}
