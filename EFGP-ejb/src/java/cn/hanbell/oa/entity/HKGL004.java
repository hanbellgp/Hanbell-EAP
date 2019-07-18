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
 * @author C0160
 */
@Entity
@Table(name = "HK_GL004")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL004.findAll", query = "SELECT h FROM HKGL004 h"),
    @NamedQuery(name = "HKGL004.findByOID", query = "SELECT h FROM HKGL004 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL004.findByFacno", query = "SELECT h FROM HKGL004 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKGL004.findBySerialNumber", query = "SELECT h FROM HKGL004 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL004.findByPSN", query = "SELECT h FROM HKGL004 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL004.findByFSN", query = "SELECT h FROM HKGL004 h WHERE h.formSerialNumber = :fsn")})
public class HKGL004 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "hdn_applyDept")
    private String hdnapplyDept;
    @Size(max = 255)
    @Column(name = "hdn_applyUser")
    private String hdnapplyUser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "time2")
    private String time2;
    @Size(max = 255)
    @Column(name = "time1")
    private String time1;
    @Column(name = "date2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date2;
    @Size(max = 255)
    @Column(name = "leano")
    private String leano;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "employee")
    private String employee;
    @Column(name = "date1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;
    @Size(max = 255)
    @Column(name = "hdn_leatp")
    private String hdnLeatp;
    @Size(max = 255)
    @Column(name = "leatp")
    private String leatp;
    @Size(max = 255)
    @Column(name = "hdn_leano")
    private String hdnLeano;
    @Size(max = 255)
    @Column(name = "leana")
    private String leana;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Column(name = "leaday2")
    private Integer leaday2;
    @Column(name = "leaday3")
    private Integer leaday3;
    @Size(max = 255)
    @Column(name = "hdn_leana")
    private String hdnLeana;
    @Column(name = "leaday1")
    private Integer leaday1;
    @Size(max = 255)
    @Column(name = "day")
    private String day;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;
    @Size(max = 255)
    @Column(name = "hdn_employee")
    private String hdnEmployee;

    public HKGL004() {
    }

    public HKGL004(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getHdnapplyDept() {
        return hdnapplyDept;
    }

    public void setHdnapplyDept(String hdnapplyDept) {
        this.hdnapplyDept = hdnapplyDept;
    }

    public String getHdnapplyUser() {
        return hdnapplyUser;
    }

    public void setHdnapplyUser(String hdnapplyUser) {
        this.hdnapplyUser = hdnapplyUser;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String getLeano() {
        return leano;
    }

    public void setLeano(String leano) {
        this.leano = leano;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public String getHdnLeatp() {
        return hdnLeatp;
    }

    public void setHdnLeatp(String hdnLeatp) {
        this.hdnLeatp = hdnLeatp;
    }

    public String getLeatp() {
        return leatp;
    }

    public void setLeatp(String leatp) {
        this.leatp = leatp;
    }

    public String getHdnLeano() {
        return hdnLeano;
    }

    public void setHdnLeano(String hdnLeano) {
        this.hdnLeano = hdnLeano;
    }

    public String getLeana() {
        return leana;
    }

    public void setLeana(String leana) {
        this.leana = leana;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public Integer getLeaday2() {
        return leaday2;
    }

    public void setLeaday2(Integer leaday2) {
        this.leaday2 = leaday2;
    }

    public Integer getLeaday3() {
        return leaday3;
    }

    public void setLeaday3(Integer leaday3) {
        this.leaday3 = leaday3;
    }

    public String getHdnLeana() {
        return hdnLeana;
    }

    public void setHdnLeana(String hdnLeana) {
        this.hdnLeana = hdnLeana;
    }

    public Integer getLeaday1() {
        return leaday1;
    }

    public void setLeaday1(Integer leaday1) {
        this.leaday1 = leaday1;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
    }

    public String getHdnEmployee() {
        return hdnEmployee;
    }

    public void setHdnEmployee(String hdnEmployee) {
        this.hdnEmployee = hdnEmployee;
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
        if (!(object instanceof HKGL004)) {
            return false;
        }
        HKGL004 other = (HKGL004) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL004[ oid=" + oid + " ]";
    }

}
