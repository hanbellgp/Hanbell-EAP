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
@Table(name = "HZ_CW030_detail1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW030Detail1.findAll", query = "SELECT h FROM HZCW030Detail1 h"),
    @NamedQuery(name = "HZCW030Detail1.findByCenterid", query = "SELECT h FROM HZCW030Detail1 h WHERE h.centerid = :centerid"),
    @NamedQuery(name = "HZCW030Detail1.findByBudgetAcc1", query = "SELECT h FROM HZCW030Detail1 h WHERE h.budgetAcc1 = :budgetAcc1"),
    @NamedQuery(name = "HZCW030Detail1.findByBudgetAccname1", query = "SELECT h FROM HZCW030Detail1 h WHERE h.budgetAccname1 = :budgetAccname1"),
    @NamedQuery(name = "HZCW030Detail1.findByAmount1", query = "SELECT h FROM HZCW030Detail1 h WHERE h.amount1 = :amount1"),
    @NamedQuery(name = "HZCW030Detail1.findByProjectType", query = "SELECT h FROM HZCW030Detail1 h WHERE h.projectType = :projectType"),
    @NamedQuery(name = "HZCW030Detail1.findByFSN", query = "SELECT h FROM HZCW030Detail1 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW030Detail1.findByOID", query = "SELECT h FROM HZCW030Detail1 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW030Detail1.findByRemark1", query = "SELECT h FROM HZCW030Detail1 h WHERE h.remark1 = :remark1"),
    @NamedQuery(name = "HZCW030Detail1.findBySeq", query = "SELECT h FROM HZCW030Detail1 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HZCW030Detail1.findByBudgetDate1txt", query = "SELECT h FROM HZCW030Detail1 h WHERE h.budgetDate1txt = :budgetDate1txt"),
    @NamedQuery(name = "HZCW030Detail1.findByCenterName", query = "SELECT h FROM HZCW030Detail1 h WHERE h.centerName = :centerName")})
public class HZCW030Detail1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "budgetAcc1")
    private String budgetAcc1;
    @Size(max = 255)
    @Column(name = "budgetAccname1")
    private String budgetAccname1;
    @Size(max = 255)
    @Column(name = "amount1")
    private String amount1;
    @Size(max = 255)
    @Column(name = "projectType")
    private String projectType;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "budgetDate1_txt")
    private String budgetDate1txt;
    @Size(max = 255)
    @Column(name = "centerName")
    private String centerName;

    public HZCW030Detail1() {
    }

    public HZCW030Detail1(String oid) {
        this.oid = oid;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getBudgetAcc1() {
        return budgetAcc1;
    }

    public void setBudgetAcc1(String budgetAcc1) {
        this.budgetAcc1 = budgetAcc1;
    }

    public String getBudgetAccname1() {
        return budgetAccname1;
    }

    public void setBudgetAccname1(String budgetAccname1) {
        this.budgetAccname1 = budgetAccname1;
    }

    public String getAmount1() {
        return amount1;
    }

    public void setAmount1(String amount1) {
        this.amount1 = amount1;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBudgetDate1txt() {
        return budgetDate1txt;
    }

    public void setBudgetDate1txt(String budgetDate1txt) {
        this.budgetDate1txt = budgetDate1txt;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
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
        if (!(object instanceof HZCW030Detail1)) {
            return false;
        }
        HZCW030Detail1 other = (HZCW030Detail1) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW030Detail1[ oid=" + oid + " ]";
    }
    
}
