/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class HKGL037DetailApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String seq;
    private String employeeId;
    private String employeeName;
    private String deptId;
    private String deptName;
    private String ycrq;
    private String kr;
    private String contact;
    private String cfsf;
    private String cfcs;
    private String address1;
    private String mdsf;
    private String mdcs;
    private String address2;
    private String sy;

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
        if (!(object instanceof HKGL037DetailApplication)) {
            return false;
        }
        HKGL037DetailApplication other = (HKGL037DetailApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.app.HKGL037DetailApplication[ id=" + id + " ]";
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

    public String getYcrq() {
        return ycrq;
    }

    public void setYcrq(String ycrq) {
        this.ycrq = ycrq;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCfsf() {
        return cfsf;
    }

    public void setCfsf(String cfsf) {
        this.cfsf = cfsf;
    }

    public String getCfcs() {
        return cfcs;
    }

    public void setCfcs(String cfcs) {
        this.cfcs = cfcs;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getMdsf() {
        return mdsf;
    }

    public void setMdsf(String mdsf) {
        this.mdsf = mdsf;
    }

    public String getMdcs() {
        return mdcs;
    }

    public void setMdcs(String mdcs) {
        this.mdcs = mdcs;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getSy() {
        return sy;
    }

    public void setSy(String sy) {
        this.sy = sy;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

}
