/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "HK_CG011")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG011.findAll", query = "SELECT h FROM HKCG011 h"),
    @NamedQuery(name = "HKCG011.findByFactel", query = "SELECT h FROM HKCG011 h WHERE h.factel = :factel"),
    @NamedQuery(name = "HKCG011.findByComtel", query = "SELECT h FROM HKCG011 h WHERE h.comtel = :comtel"),
    @NamedQuery(name = "HKCG011.findByPSN", query = "SELECT h FROM HKCG011 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCG011.findByFSN", query = "SELECT h FROM HKCG011 h WHERE h.formSerialNumber = :fsn")})
public class HKCG011 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "factel")
    private String factel;
    @Size(max = 255)
    @Column(name = "supplyParts")
    private String supplyParts;
    @Size(max = 255)
    @Column(name = "cgevaluation")
    private String cgevaluation;
    @Size(max = 255)
    @Column(name = "comfax")
    private String comfax;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "supno")
    private String supno;
    @Size(max = 255)
    @Column(name = "comtel")
    private String comtel;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "facfax")
    private String facfax;
    @Size(max = 255)
    @Column(name = "rating")
    private String rating;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "evaluationWay")
    private String evaluationWay;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "assessment")
    private String assessment;
    @Size(max = 255)
    @Column(name = "approved")
    private String approved;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "facAddress")
    private String facAddress;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "manpower")
    private String manpower;
    @Size(max = 255)
    @Column(name = "partstype")
    private String partstype;
    @Size(max = 255)
    @Column(name = "pbevaluation")
    private String pbevaluation;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 255)
    @Column(name = "suggestion")
    private String suggestion;
    @Size(max = 255)
    @Column(name = "supname")
    private String supname;
    @Size(max = 255)
    @Column(name = "equipment")
    private String equipment;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "supman")
    private String supman;
    @Size(max = 255)
    @Column(name = "comAddress")
    private String comAddress;
    @Size(max = 255)
    @Column(name = "jsevaluation")
    private String jsevaluation;
    @Size(max = 255)
    @Column(name = "plant")
    private String plant;
    @Size(max = 255)
    @Column(name = "remark2")
    private String remark2;

    public HKCG011() {
    }

    public HKCG011(String oid) {
        this.oid = oid;
    }

    public String getFactel() {
        return factel;
    }

    public void setFactel(String factel) {
        this.factel = factel;
    }

    public String getSupplyParts() {
        return supplyParts;
    }

    public void setSupplyParts(String supplyParts) {
        this.supplyParts = supplyParts;
    }

    public String getCgevaluation() {
        return cgevaluation;
    }

    public void setCgevaluation(String cgevaluation) {
        this.cgevaluation = cgevaluation;
    }

    public String getComfax() {
        return comfax;
    }

    public void setComfax(String comfax) {
        this.comfax = comfax;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSupno() {
        return supno;
    }

    public void setSupno(String supno) {
        this.supno = supno;
    }

    public String getComtel() {
        return comtel;
    }

    public void setComtel(String comtel) {
        this.comtel = comtel;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getFacfax() {
        return facfax;
    }

    public void setFacfax(String facfax) {
        this.facfax = facfax;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEvaluationWay() {
        return evaluationWay;
    }

    public void setEvaluationWay(String evaluationWay) {
        this.evaluationWay = evaluationWay;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getFacAddress() {
        return facAddress;
    }

    public void setFacAddress(String facAddress) {
        this.facAddress = facAddress;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getManpower() {
        return manpower;
    }

    public void setManpower(String manpower) {
        this.manpower = manpower;
    }

    public String getPartstype() {
        return partstype;
    }

    public void setPartstype(String partstype) {
        this.partstype = partstype;
    }

    public String getPbevaluation() {
        return pbevaluation;
    }

    public void setPbevaluation(String pbevaluation) {
        this.pbevaluation = pbevaluation;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSupman() {
        return supman;
    }

    public void setSupman(String supman) {
        this.supman = supman;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getJsevaluation() {
        return jsevaluation;
    }

    public void setJsevaluation(String jsevaluation) {
        this.jsevaluation = jsevaluation;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
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
        if (!(object instanceof HKCG011)) {
            return false;
        }
        HKCG011 other = (HKCG011) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG011[ oid=" + oid + " ]";
    }
    
}
