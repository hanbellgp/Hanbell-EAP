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
 * @author C1749
 */
@Entity
@Table(name = "HK_JH004")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH004.findAll", query = "SELECT h FROM HKJH004 h"),
    @NamedQuery(name = "HKJH004.findByCreateTime", query = "SELECT h FROM HKJH004 h WHERE h.createTime = :createTime"),
    @NamedQuery(name = "HKJH004.findByOID", query = "SELECT h FROM HKJH004 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH004.findByFacno", query = "SELECT h FROM HKJH004 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKJH004.findByReason", query = "SELECT h FROM HKJH004 h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKJH004.findByFacno1", query = "SELECT h FROM HKJH004 h WHERE h.facno1 = :facno1"),
    @NamedQuery(name = "HKJH004.findByFacno2", query = "SELECT h FROM HKJH004 h WHERE h.facno2 = :facno2"),
    @NamedQuery(name = "HKJH004.findByVdrna", query = "SELECT h FROM HKJH004 h WHERE h.vdrna = :vdrna"),
    @NamedQuery(name = "HKJH004.findBySerialNumber", query = "SELECT h FROM HKJH004 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKJH004.findByVdrds", query = "SELECT h FROM HKJH004 h WHERE h.vdrds = :vdrds"),
    @NamedQuery(name = "HKJH004.findByApplyuser", query = "SELECT h FROM HKJH004 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKJH004.findByDept", query = "SELECT h FROM HKJH004 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKJH004.findByPSN", query = "SELECT h FROM HKJH004 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJH004.findByVdrno", query = "SELECT h FROM HKJH004 h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HKJH004.findByFSN", query = "SELECT h FROM HKJH004 h WHERE h.formSerialNumber = :fsn")})
public class HKJH004 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "createTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "facno1")
    private String facno1;
    @Size(max = 255)
    @Column(name = "facno2")
    private String facno2;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "vdrds")
    private String vdrds;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJH004() {
    }

    public HKJH004(String oid) {
        this.oid = oid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFacno1() {
        return facno1;
    }

    public void setFacno1(String facno1) {
        this.facno1 = facno1;
    }

    public String getFacno2() {
        return facno2;
    }

    public void setFacno2(String facno2) {
        this.facno2 = facno2;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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
        if (!(object instanceof HKJH004)) {
            return false;
        }
        HKJH004 other = (HKJH004) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH004[ oid=" + oid + " ]";
    }

}
