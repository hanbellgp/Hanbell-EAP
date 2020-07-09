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
@Table(name = "HZ_CW030_detail2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW030Detail2.findAll", query = "SELECT h FROM HZCW030Detail2 h"),
    @NamedQuery(name = "HZCW030Detail2.findByBudgetAcc2", query = "SELECT h FROM HZCW030Detail2 h WHERE h.budgetAcc2 = :budgetAcc2"),
    @NamedQuery(name = "HZCW030Detail2.findByNeedUsertxt", query = "SELECT h FROM HZCW030Detail2 h WHERE h.needUsertxt = :needUsertxt"),
    @NamedQuery(name = "HZCW030Detail2.findByAmount2", query = "SELECT h FROM HZCW030Detail2 h WHERE h.amount2 = :amount2"),
    @NamedQuery(name = "HZCW030Detail2.findByBudgetAccname2", query = "SELECT h FROM HZCW030Detail2 h WHERE h.budgetAccname2 = :budgetAccname2"),
    @NamedQuery(name = "HZCW030Detail2.findByNeedUserlbl", query = "SELECT h FROM HZCW030Detail2 h WHERE h.needUserlbl = :needUserlbl"),
    @NamedQuery(name = "HZCW030Detail2.findByFSN", query = "SELECT h FROM HZCW030Detail2 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW030Detail2.findByOID", query = "SELECT h FROM HZCW030Detail2 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW030Detail2.findBySeq", query = "SELECT h FROM HZCW030Detail2 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HZCW030Detail2.findByBudgetDate2txt", query = "SELECT h FROM HZCW030Detail2 h WHERE h.budgetDate2txt = :budgetDate2txt"),
    @NamedQuery(name = "HZCW030Detail2.findByRemark2", query = "SELECT h FROM HZCW030Detail2 h WHERE h.remark2 = :remark2")})
public class HZCW030Detail2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "budgetAcc2")
    private String budgetAcc2;
    @Size(max = 255)
    @Column(name = "needUser_txt")
    private String needUsertxt;
    @Size(max = 255)
    @Column(name = "amount2")
    private String amount2;
    @Size(max = 255)
    @Column(name = "budgetAccname2")
    private String budgetAccname2;
    @Size(max = 255)
    @Column(name = "needUser_lbl")
    private String needUserlbl;
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
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "budgetDate2_txt")
    private String budgetDate2txt;
    @Size(max = 255)
    @Column(name = "remark2")
    private String remark2;

    public HZCW030Detail2() {
    }

    public HZCW030Detail2(String oid) {
        this.oid = oid;
    }

    public String getBudgetAcc2() {
        return budgetAcc2;
    }

    public void setBudgetAcc2(String budgetAcc2) {
        this.budgetAcc2 = budgetAcc2;
    }

    public String getNeedUsertxt() {
        return needUsertxt;
    }

    public void setNeedUsertxt(String needUsertxt) {
        this.needUsertxt = needUsertxt;
    }

    public String getAmount2() {
        return amount2;
    }

    public void setAmount2(String amount2) {
        this.amount2 = amount2;
    }

    public String getBudgetAccname2() {
        return budgetAccname2;
    }

    public void setBudgetAccname2(String budgetAccname2) {
        this.budgetAccname2 = budgetAccname2;
    }

    public String getNeedUserlbl() {
        return needUserlbl;
    }

    public void setNeedUserlbl(String needUserlbl) {
        this.needUserlbl = needUserlbl;
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

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBudgetDate2txt() {
        return budgetDate2txt;
    }

    public void setBudgetDate2txt(String budgetDate2txt) {
        this.budgetDate2txt = budgetDate2txt;
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
        if (!(object instanceof HZCW030Detail2)) {
            return false;
        }
        HZCW030Detail2 other = (HZCW030Detail2) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW030Detail2[ oid=" + oid + " ]";
    }
    
}
