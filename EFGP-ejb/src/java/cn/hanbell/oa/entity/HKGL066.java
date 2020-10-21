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
@Table(name = "HK_GL066")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL066.findAll", query = "SELECT h FROM HKGL066 h"),
    @NamedQuery(name = "HKGL066.findByOID", query = "SELECT h FROM HKGL066 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL066.findByPSN", query = "SELECT h FROM HKGL066 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL066.findByFSN", query = "SELECT h FROM HKGL066 h WHERE h.formSerialNumber = :fsn")})
public class HKGL066 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "openEmail")
    private String openEmail;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "phonePassword")
    private String phonePassword;
    @Size(max = 255)
    @Column(name = "post")
    private String post;
    @Size(max = 255)
    @Column(name = "openExtension")
    private String openExtension;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "openAccount")
    private String openAccount;
    @Size(max = 255)
    @Column(name = "openLAN")
    private String openLAN;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;

    public HKGL066() {
    }

    public HKGL066(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpenEmail() {
        return openEmail;
    }

    public void setOpenEmail(String openEmail) {
        this.openEmail = openEmail;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getPhonePassword() {
        return phonePassword;
    }

    public void setPhonePassword(String phonePassword) {
        this.phonePassword = phonePassword;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getOpenExtension() {
        return openExtension;
    }

    public void setOpenExtension(String openExtension) {
        this.openExtension = openExtension;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOpenAccount() {
        return openAccount;
    }

    public void setOpenAccount(String openAccount) {
        this.openAccount = openAccount;
    }

    public String getOpenLAN() {
        return openLAN;
    }

    public void setOpenLAN(String openLAN) {
        this.openLAN = openLAN;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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
        if (!(object instanceof HKGL066)) {
            return false;
        }
        HKGL066 other = (HKGL066) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL066[ oid=" + oid + " ]";
    }

}
