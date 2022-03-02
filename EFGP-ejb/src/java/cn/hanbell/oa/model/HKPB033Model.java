/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author C2082
 */
public class HKPB033Model implements Serializable {

    private String SerialNumber;
    private String correctDept;
    private String site;
    private String safetySectionChief;
    private String securityOfficer;
    private String departmentHead;
    private String sectionSupervisor;
    private String risksdesc;
    private String auditor;
    private String order1;
    private String order3;
    private String order2;
    private String order4;
    private String formDate;
    private String construction;
    private String project;
    private Double amount;
    private String shortterm;
    private String longterm;
    private String targetDate;
    private String trackingDate;
    private String sschief_confirm;
    private String signatory;
    private String orderDate;
    private String hdnSafetySectionChief;
    private String reason;

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public String getCorrectDept() {
        return correctDept;
    }

    public void setCorrectDept(String correctDept) {
        this.correctDept = correctDept;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSafetySectionChief() {
        return safetySectionChief;
    }

    public void setSafetySectionChief(String safetySectionChief) {
        this.safetySectionChief = safetySectionChief;
    }

    public String getSecurityOfficer() {
        return securityOfficer;
    }

    public void setSecurityOfficer(String securityOfficer) {
        this.securityOfficer = securityOfficer;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getSectionSupervisor() {
        return sectionSupervisor;
    }

    public void setSectionSupervisor(String sectionSupervisor) {
        this.sectionSupervisor = sectionSupervisor;
    }

    public String getRisksdesc() {
        return risksdesc;
    }

    public void setRisksdesc(String risksdesc) {
        this.risksdesc = risksdesc;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getOrder1() {
        return order1;
    }

    public void setOrder1(String order1) {
        this.order1 = order1;
    }

    public String getOrder3() {
        return order3;
    }

    public void setOrder3(String order3) {
        this.order3 = order3;
    }

    public String getOrder2() {
        return order2;
    }

    public void setOrder2(String order2) {
        this.order2 = order2;
    }

    public String getOrder4() {
        return order4;
    }

    public void setOrder4(String order4) {
        this.order4 = order4;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getShortterm() {
        return shortterm;
    }

    public void setShortterm(String shortterm) {
        this.shortterm = shortterm;
    }

    public String getLongterm() {
        return longterm;
    }

    public void setLongterm(String longterm) {
        this.longterm = longterm;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(String trackingDate) {
        this.trackingDate = trackingDate;
    }

    public String getSschief_confirm() {
        return sschief_confirm;
    }

    public void setSschief_confirm(String sschief_confirm) {
        this.sschief_confirm = sschief_confirm;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getHdnSafetySectionChief() {
        return hdnSafetySectionChief;
    }

    public void setHdnSafetySectionChief(String hdnSafetySectionChief) {
        this.hdnSafetySectionChief = hdnSafetySectionChief;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.SerialNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HKPB033Model other = (HKPB033Model) obj;
        if (!Objects.equals(this.SerialNumber, other.SerialNumber)) {
            return false;
        }
        return true;
    }

    
}
