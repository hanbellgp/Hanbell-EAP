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
@Table(name = "HZ_GLPCD_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZGLPCDDetail.findAll", query = "SELECT h FROM HZGLPCDDetail h"),
    @NamedQuery(name = "HZGLPCDDetail.findByOId", query = "SELECT h FROM HZGLPCDDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZGLPCDDetail.findByFSN", query = "SELECT h FROM HZGLPCDDetail h WHERE h.formSerialNumber = :fsn")})
public class HZGLPCDDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "gh_txt")
    private String ghTxt;
    @Size(max = 255)
    @Column(name = "bm_txt")
    private String bmTxt;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "gh_lbl")
    private String ghLbl;
    @Size(max = 255)
    @Column(name = "kr")
    private String kr;
    @Size(max = 255)
    @Column(name = "krlxfs")
    private String krlxfs;
    @Size(max = 255)
    @Column(name = "contact")
    private String contact;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "bm_lbl")
    private String bmLbl;

    public HZGLPCDDetail() {
    }

    public HZGLPCDDetail(String oid) {
        this.oid = oid;
    }

    public String getGhTxt() {
        return ghTxt;
    }

    public void setGhTxt(String ghTxt) {
        this.ghTxt = ghTxt;
    }

    public String getBmTxt() {
        return bmTxt;
    }

    public void setBmTxt(String bmTxt) {
        this.bmTxt = bmTxt;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getGhLbl() {
        return ghLbl;
    }

    public void setGhLbl(String ghLbl) {
        this.ghLbl = ghLbl;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getKrlxfs() {
        return krlxfs;
    }

    public void setKrlxfs(String krlxfs) {
        this.krlxfs = krlxfs;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getBmLbl() {
        return bmLbl;
    }

    public void setBmLbl(String bmLbl) {
        this.bmLbl = bmLbl;
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
        if (!(object instanceof HZGLPCDDetail)) {
            return false;
        }
        HZGLPCDDetail other = (HZGLPCDDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZGLPCDDetail[ oid=" + oid + " ]";
    }
    
}
