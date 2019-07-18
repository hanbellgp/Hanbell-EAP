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
 * @author C0160
 */
@Entity
@Table(name = "HK_GL034_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL034Detail.findAll", query = "SELECT h FROM HKGL034Detail h"),
    @NamedQuery(name = "HKGL034Detail.findByOID", query = "SELECT h FROM HKGL034Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL034Detail.findByFSN", query = "SELECT h FROM HKGL034Detail h WHERE h.formSerialNumber = :fsn")})
public class HKGL034Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "dept_lbl")
    private String deptLbl;
    @Size(max = 255)
    @Column(name = "hour")
    private String hour;
    @Size(max = 255)
    @Column(name = "date1_txt")
    private String date1Txt;
    @Size(max = 255)
    @Column(name = "employeeName")
    private String employeeName;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "hdn_dinner")
    private String hdnDinner;
    @Size(max = 255)
    @Column(name = "hdn_lunch")
    private String hdnLunch;
    @Size(max = 255)
    @Column(name = "dept_txt")
    private String deptTxt;
    @Size(max = 255)
    @Column(name = "time2_txt")
    private String time2Txt;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "time1_txt")
    private String time1Txt;
    @Size(max = 255)
    @Column(name = "employee")
    private String employee;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKGL034Detail() {
    }

    public HKGL034Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDeptLbl() {
        return deptLbl;
    }

    public void setDeptLbl(String deptLbl) {
        this.deptLbl = deptLbl;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate1Txt() {
        return date1Txt;
    }

    public void setDate1Txt(String date1Txt) {
        this.date1Txt = date1Txt;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHdnDinner() {
        return hdnDinner;
    }

    public void setHdnDinner(String hdnDinner) {
        this.hdnDinner = hdnDinner;
    }

    public String getHdnLunch() {
        return hdnLunch;
    }

    public void setHdnLunch(String hdnLunch) {
        this.hdnLunch = hdnLunch;
    }

    public String getDeptTxt() {
        return deptTxt;
    }

    public void setDeptTxt(String deptTxt) {
        this.deptTxt = deptTxt;
    }

    public String getTime2Txt() {
        return time2Txt;
    }

    public void setTime2Txt(String time2Txt) {
        this.time2Txt = time2Txt;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTime1Txt() {
        return time1Txt;
    }

    public void setTime1Txt(String time1Txt) {
        this.time1Txt = time1Txt;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
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
        if (!(object instanceof HKGL034Detail)) {
            return false;
        }
        HKGL034Detail other = (HKGL034Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL034Detail[ oid=" + oid + " ]";
    }

}
