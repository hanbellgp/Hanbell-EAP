/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@XmlRootElement
public class HKPB033Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String formDate;
    private String applyUserId;
    private String applyUserName;
    private String applyDeptId;
    private String applyDeptName;
    private String company;
    private String safetyOfficeId;
    private String safetyOfficeName;
    private String safetyDeptId;
    private String safetyDeptName;
    private String deptManager1Id;
    private String deptManager1Name;
    private String deptManager2Id;
    private String deptManager2Name;
    private String monthSafetyOfficeId;
    private String monthSafetyOfficeName;
    private String describe;
    private String chargeId;
    private String chargeName;
    private String constructionProject;
    private String constructionSide;
    private String address;
    private double deduction;
    private String endDate;
    private List<HKPB033FilesApplication> hkpb033Files;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    
    public String getApplyUserId() {
        return applyUserId;
    }
    
    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyDeptId() {
        return applyDeptId;
    }

    public void setApplyDeptId(String applyDeptId) {
        this.applyDeptId = applyDeptId;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSafetyOfficeId() {
        return safetyOfficeId;
    }

    public void setSafetyOfficeId(String safetyOfficeId) {
        this.safetyOfficeId = safetyOfficeId;
    }

    public String getSafetyOfficeName() {
        return safetyOfficeName;
    }

    public void setSafetyOfficeName(String safetyOfficeName) {
        this.safetyOfficeName = safetyOfficeName;
    }

    public String getSafetyDeptId() {
        return safetyDeptId;
    }

    public void setSafetyDeptId(String safetyDeptId) {
        this.safetyDeptId = safetyDeptId;
    }

    public String getSafetyDeptName() {
        return safetyDeptName;
    }

    public void setSafetyDeptName(String safetyDeptName) {
        this.safetyDeptName = safetyDeptName;
    }

    public String getDeptManager1Id() {
        return deptManager1Id;
    }

    public void setDeptManager1Id(String deptManager1Id) {
        this.deptManager1Id = deptManager1Id;
    }

    public String getDeptManager1Name() {
        return deptManager1Name;
    }

    public void setDeptManager1Name(String deptManager1Name) {
        this.deptManager1Name = deptManager1Name;
    }

    public String getDeptManager2Id() {
        return deptManager2Id;
    }

    public void setDeptManager2Id(String deptManager2Id) {
        this.deptManager2Id = deptManager2Id;
    }

    public String getDeptManager2Name() {
        return deptManager2Name;
    }

    public void setDeptManager2Name(String deptManager2Name) {
        this.deptManager2Name = deptManager2Name;
    }

    public String getMonthSafetyOfficeId() {
        return monthSafetyOfficeId;
    }

    public void setMonthSafetyOfficeId(String monthSafetyOfficeId) {
        this.monthSafetyOfficeId = monthSafetyOfficeId;
    }

    public String getMonthSafetyOfficeName() {
        return monthSafetyOfficeName;
    }

    public void setMonthSafetyOfficeName(String monthSafetyOfficeName) {
        this.monthSafetyOfficeName = monthSafetyOfficeName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getConstructionProject() {
        return constructionProject;
    }

    public void setConstructionProject(String constructionProject) {
        this.constructionProject = constructionProject;
    }

    
    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getConstructionSide() {
        return constructionSide;
    }

    public void setConstructionSide(String constructionSide) {
        this.constructionSide = constructionSide;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public List<HKPB033FilesApplication> getHkpb033Files() {
        return hkpb033Files;
    }

    public void setHkpb033Files(List<HKPB033FilesApplication> hkpb033Files) {
        this.hkpb033Files = hkpb033Files;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.applyUserId);
        hash = 23 * hash + Objects.hashCode(this.applyUserName);
        hash = 23 * hash + Objects.hashCode(this.applyDeptId);
        hash = 23 * hash + Objects.hashCode(this.applyDeptName);
        hash = 23 * hash + Objects.hashCode(this.company);
        hash = 23 * hash + Objects.hashCode(this.safetyOfficeId);
        hash = 23 * hash + Objects.hashCode(this.safetyOfficeName);
        hash = 23 * hash + Objects.hashCode(this.safetyDeptId);
        hash = 23 * hash + Objects.hashCode(this.safetyDeptName);
        hash = 23 * hash + Objects.hashCode(this.deptManager1Id);
        hash = 23 * hash + Objects.hashCode(this.deptManager1Name);
        hash = 23 * hash + Objects.hashCode(this.deptManager2Id);
        hash = 23 * hash + Objects.hashCode(this.deptManager2Name);
        hash = 23 * hash + Objects.hashCode(this.monthSafetyOfficeId);
        hash = 23 * hash + Objects.hashCode(this.monthSafetyOfficeName);
        hash = 23 * hash + Objects.hashCode(this.chargeId);
        hash = 23 * hash + Objects.hashCode(this.chargeName);
        hash = 23 * hash + Objects.hashCode(this.constructionSide);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.deduction) ^ (Double.doubleToLongBits(this.deduction) >>> 32));
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
        final HKPB033Application other = (HKPB033Application) obj;
        if (Double.doubleToLongBits(this.deduction) != Double.doubleToLongBits(other.deduction)) {
            return false;
        }
        if (!Objects.equals(this.applyUserId, other.applyUserId)) {
            return false;
        }
        if (!Objects.equals(this.applyUserName, other.applyUserName)) {
            return false;
        }
        if (!Objects.equals(this.applyDeptId, other.applyDeptId)) {
            return false;
        }
        if (!Objects.equals(this.applyDeptName, other.applyDeptName)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.safetyOfficeId, other.safetyOfficeId)) {
            return false;
        }
        if (!Objects.equals(this.safetyOfficeName, other.safetyOfficeName)) {
            return false;
        }
        if (!Objects.equals(this.safetyDeptId, other.safetyDeptId)) {
            return false;
        }
        if (!Objects.equals(this.safetyDeptName, other.safetyDeptName)) {
            return false;
        }
        if (!Objects.equals(this.deptManager1Id, other.deptManager1Id)) {
            return false;
        }
        if (!Objects.equals(this.deptManager1Name, other.deptManager1Name)) {
            return false;
        }
        if (!Objects.equals(this.deptManager2Id, other.deptManager2Id)) {
            return false;
        }
        if (!Objects.equals(this.deptManager2Name, other.deptManager2Name)) {
            return false;
        }
        if (!Objects.equals(this.monthSafetyOfficeId, other.monthSafetyOfficeId)) {
            return false;
        }
        if (!Objects.equals(this.monthSafetyOfficeName, other.monthSafetyOfficeName)) {
            return false;
        }
        if (!Objects.equals(this.chargeId, other.chargeId)) {
            return false;
        }
        if (!Objects.equals(this.chargeName, other.chargeName)) {
            return false;
        }
        if (!Objects.equals(this.constructionSide, other.constructionSide)) {
            return false;
        }
        return true;
    }

}
