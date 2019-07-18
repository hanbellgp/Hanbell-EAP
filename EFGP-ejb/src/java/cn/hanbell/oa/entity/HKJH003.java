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
@Table(name = "HK_JH003")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH003.findAll", query = "SELECT h FROM HKJH003 h"),
    @NamedQuery(name = "HKJH003.findByCreateTime", query = "SELECT h FROM HKJH003 h WHERE h.createTime = :createTime"),
    @NamedQuery(name = "HKJH003.findByOID", query = "SELECT h FROM HKJH003 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH003.findByFacno", query = "SELECT h FROM HKJH003 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKJH003.findByReason", query = "SELECT h FROM HKJH003 h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKJH003.findByFacno1", query = "SELECT h FROM HKJH003 h WHERE h.facno1 = :facno1"),
    @NamedQuery(name = "HKJH003.findByFacno2", query = "SELECT h FROM HKJH003 h WHERE h.facno2 = :facno2"),
    @NamedQuery(name = "HKJH003.findByCusna", query = "SELECT h FROM HKJH003 h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKJH003.findBySerialNumber", query = "SELECT h FROM HKJH003 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKJH003.findByCusds", query = "SELECT h FROM HKJH003 h WHERE h.cusds = :cusds"),
    @NamedQuery(name = "HKJH003.findByApplyuser", query = "SELECT h FROM HKJH003 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKJH003.findByCusno", query = "SELECT h FROM HKJH003 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKJH003.findByDept", query = "SELECT h FROM HKJH003 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKJH003.findByPSN", query = "SELECT h FROM HKJH003 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJH003.findByFSN", query = "SELECT h FROM HKJH003 h WHERE h.formSerialNumber = :fsn")})
public class HKJH003 implements Serializable {

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
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJH003() {
    }

    public HKJH003(String oid) {
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

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
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
        if (!(object instanceof HKJH003)) {
            return false;
        }
        HKJH003 other = (HKJH003) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH003[ oid=" + oid + " ]";
    }

}
