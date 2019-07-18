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
@Table(name = "HZ_GL004_bizDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZGL004BizDetail.findAll", query = "SELECT h FROM HZGL004BizDetail h"),
    @NamedQuery(name = "HZGL004BizDetail.findByOID", query = "SELECT h FROM HZGL004BizDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZGL004BizDetail.findByFSN", query = "SELECT h FROM HZGL004BizDetail h WHERE h.formSerialNumber = :fsn")})
public class HZGL004BizDetail implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "bizEmployee_lbl")
    private String bizEmployeelbl;
    @Size(max = 255)
    @Column(name = "bizEmployee_txt")
    private String bizEmployeetxt;
    @Size(max = 255)
    @Column(name = "bizDate_txt")
    private String bizDatetxt;
    @Size(max = 255)
    @Column(name = "bizTime1_txt")
    private String bizTime1txt;
    @Size(max = 255)
    @Column(name = "bizTime2_txt")
    private String bizTime2txt;
    @Size(max = 255)
    @Column(name = "bizObject")
    private String bizObject;
    @Size(max = 255)
    @Column(name = "bizAddress")
    private String bizAddress;
    @Size(max = 255)
    @Column(name = "bizContent")
    private String bizContent;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HZGL004BizDetail() {
    }

    public HZGL004BizDetail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getBizTime2txt() {
        return bizTime2txt;
    }

    public void setBizTime2txt(String bizTime2txt) {
        this.bizTime2txt = bizTime2txt;
    }

    public String getBizObject() {
        return bizObject;
    }

    public void setBizObject(String bizObject) {
        this.bizObject = bizObject;
    }

    public String getBizTime1txt() {
        return bizTime1txt;
    }

    public void setBizTime1txt(String bizTime1txt) {
        this.bizTime1txt = bizTime1txt;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getBizEmployeelbl() {
        return bizEmployeelbl;
    }

    public void setBizEmployeelbl(String bizEmployeelbl) {
        this.bizEmployeelbl = bizEmployeelbl;
    }

    public String getBizEmployeetxt() {
        return bizEmployeetxt;
    }

    public void setBizEmployeetxt(String bizEmployeetxt) {
        this.bizEmployeetxt = bizEmployeetxt;
    }

    public String getBizDatetxt() {
        return bizDatetxt;
    }

    public void setBizDatetxt(String bizDatetxt) {
        this.bizDatetxt = bizDatetxt;
    }

    public String getBizAddress() {
        return bizAddress;
    }

    public void setBizAddress(String bizAddress) {
        this.bizAddress = bizAddress;
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
        if (!(object instanceof HZGL004BizDetail)) {
            return false;
        }
        HZGL004BizDetail other = (HZGL004BizDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZGL004BizDetail[ oid=" + oid + " ]";
    }

}
