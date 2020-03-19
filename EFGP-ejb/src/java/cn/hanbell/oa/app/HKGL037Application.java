/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
public class HKGL037Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String employeeName;
    private String deptId;
    private String deptName;
    private String sqrqDate;
    private String telcontact;
    private String clxz;
    private String clxzDesc;
    private String privatedriver;
    private String privatecarno;
    private String purpose;
    private String purposeDesc;
    private String hmark1;
    private List<HKGL037DetailApplication> detailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKGL037Application)) {
            return false;
        }
        HKGL037Application other = (HKGL037Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.app.HKGL037Application[ id=" + id + " ]";
    }

    public List<HKGL037DetailApplication> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<HKGL037DetailApplication> detaiList) {
        this.detailList = detaiList;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSqrqDate() {
        return sqrqDate;
    }

    public void setSqrqDate(String sqrqDate) {
        this.sqrqDate = sqrqDate;
    }

    public String getTelcontact() {
        return telcontact;
    }

    public void setTelcontact(String telcontact) {
        this.telcontact = telcontact;
    }

    public String getClxz() {
        return clxz;
    }

    public void setClxz(String clxz) {
        this.clxz = clxz;
    }

    public String getClxzDesc() {
        return clxzDesc;
    }

    public void setClxzDesc(String clxzDesc) {
        this.clxzDesc = clxzDesc;
    }

    public String getPrivatedriver() {
        return privatedriver;
    }

    public void setPrivatedriver(String privatedriver) {
        this.privatedriver = privatedriver;
    }

    public String getPrivatecarno() {
        return privatecarno;
    }

    public void setPrivatecarno(String privatecarno) {
        this.privatecarno = privatecarno;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurposeDesc() {
        return purposeDesc;
    }

    public void setPurposeDesc(String purposeDesc) {
        this.purposeDesc = purposeDesc;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

}
