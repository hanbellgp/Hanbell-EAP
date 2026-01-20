/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author C2082
 */
public class HKGL016Model implements Serializable {

    private String applyUser;
    private String applyDept;
    private Date applyDate;
    private String post1;
    private String userTitle;
    private String administrativeDuties;
    private Date contractDate;
    private Date retirementDate;
    private String retireReason;
    private String opinion1;
    private String reason1;
    private String opinion2;
    private String reason2;
    private String opinion3;
    private String reason3;
    private String opinion4;
    private String reason4;
    private String hdnpost1;
    private String hdnHeader;
    private String hdnManager;
    private String hdnBoss1;
    private String hdnBoss2;
    private String SerialNumber;

    public HKGL016Model() {
        this.opinion1 = "";
        this.opinion2 = "";
        this.opinion3 = "";
        this.opinion4 = "";

        this.reason1 = "";
        this.reason2 = "";
        this.reason3 = "";
        this.reason4 = "";

    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getPost1() {
        return post1;
    }

    public void setPost1(String post1) {
        this.post1 = post1;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getAdministrativeDuties() {
        return administrativeDuties;
    }

    public void setAdministrativeDuties(String administrativeDuties) {
        this.administrativeDuties = administrativeDuties;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(Date retirementDate) {
        this.retirementDate = retirementDate;
    }

    public String getRetireReason() {
        return retireReason;
    }

    public void setRetireReason(String retireReason) {
        this.retireReason = retireReason;
    }

    public String getOpinion1() {
        return opinion1;
    }

    public void setOpinion1(String opinion1) {
        this.opinion1 = opinion1;
    }

    public String getReason1() {
        return reason1;
    }

    public void setReason1(String reason1) {
        this.reason1 = reason1;
    }

    public String getOpinion2() {
        return opinion2;
    }

    public void setOpinion2(String opinion2) {
        this.opinion2 = opinion2;
    }

    public String getReason2() {
        return reason2;
    }

    public void setReason2(String reason2) {
        this.reason2 = reason2;
    }

    public String getOpinion3() {
        return opinion3;
    }

    public void setOpinion3(String opinion3) {
        this.opinion3 = opinion3;
    }

    public String getOpinion4() {
        return opinion4;
    }

    public void setOpinion4(String opinion4) {
        this.opinion4 = opinion4;
    }

    public String getReason4() {
        return reason4;
    }

    public void setReason4(String reason4) {
        this.reason4 = reason4;
    }

    public String getHdnpost1() {
        return hdnpost1;
    }

    public void setHdnpost1(String hdnpost1) {
        this.hdnpost1 = hdnpost1;
    }

    public String getHdnHeader() {
        return hdnHeader;
    }

    public void setHdnHeader(String hdnHeader) {
        this.hdnHeader = hdnHeader;
    }

    public String getHdnManager() {
        return hdnManager;
    }

    public void setHdnManager(String hdnManager) {
        this.hdnManager = hdnManager;
    }

    public String getHdnBoss1() {
        return hdnBoss1;
    }

    public void setHdnBoss1(String hdnBoss1) {
        this.hdnBoss1 = hdnBoss1;
    }

    public String getHdnBoss2() {
        return hdnBoss2;
    }

    public void setHdnBoss2(String hdnBoss2) {
        this.hdnBoss2 = hdnBoss2;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }
    
    

}
