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
 * @author ZFF
 */
@Entity
@Table(name = "HZ_GL004_carDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZGL004carDetail.findAll", query = "SELECT h FROM HZGL004carDetail h"),
    @NamedQuery(name = "HZGL004carDetail.findByFSN", query = "SELECT h FROM HZGL004carDetail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZGL004carDetail.findByGhuserLbl", query = "SELECT h FROM HZGL004carDetail h WHERE h.ghuserLbl = :ghuserLbl")})
public class HZGL004carDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "ghuser_txt")
    private String ghuserTxt;
    @Size(max = 255)
    @Column(name = "address2")
    private String address2;
    @Size(max = 255)
    @Column(name = "address1")
    private String address1;
    @Size(max = 255)
    @Column(name = "sy")
    private String sy;
    @Size(max = 255)
    @Column(name = "kr")
    private String kr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "krlxfs")
    private String krlxfs;
    @Size(max = 255)
    @Column(name = "gsmc")
    private String gsmc;
    @Size(max = 255)
    @Column(name = "mdcs")
    private String mdcs;
    @Size(max = 255)
    @Column(name = "contact")
    private String contact;
    @Size(max = 255)
    @Column(name = "bmdept_txt")
    private String bmdeptTxt;
    @Size(max = 255)
    @Column(name = "cfsf")
    private String cfsf;
    @Size(max = 255)
    @Column(name = "mdsf")
    private String mdsf;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "cfcs")
    private String cfcs;
    @Size(max = 255)
    @Column(name = "bmdept_lbl")
    private String bmdeptLbl;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "ycrq_txt")
    private String ycrqTxt;
    @Size(max = 255)
    @Column(name = "ghuser_lbl")
    private String ghuserLbl;

    public HZGL004carDetail() {
    }

    public HZGL004carDetail(String oid) {
        this.oid = oid;
    }

    public String getGhuserTxt() {
        return ghuserTxt;
    }

    public void setGhuserTxt(String ghuserTxt) {
        this.ghuserTxt = ghuserTxt;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getSy() {
        return sy;
    }

    public void setSy(String sy) {
        this.sy = sy;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getKrlxfs() {
        return krlxfs;
    }

    public void setKrlxfs(String krlxfs) {
        this.krlxfs = krlxfs;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getMdcs() {
        return mdcs;
    }

    public void setMdcs(String mdcs) {
        this.mdcs = mdcs;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBmdeptTxt() {
        return bmdeptTxt;
    }

    public void setBmdeptTxt(String bmdeptTxt) {
        this.bmdeptTxt = bmdeptTxt;
    }

    public String getCfsf() {
        return cfsf;
    }

    public void setCfsf(String cfsf) {
        this.cfsf = cfsf;
    }

    public String getMdsf() {
        return mdsf;
    }

    public void setMdsf(String mdsf) {
        this.mdsf = mdsf;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCfcs() {
        return cfcs;
    }

    public void setCfcs(String cfcs) {
        this.cfcs = cfcs;
    }

    public String getBmdeptLbl() {
        return bmdeptLbl;
    }

    public void setBmdeptLbl(String bmdeptLbl) {
        this.bmdeptLbl = bmdeptLbl;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getYcrqTxt() {
        return ycrqTxt;
    }

    public void setYcrqTxt(String ycrqTxt) {
        this.ycrqTxt = ycrqTxt;
    }

    public String getGhuserLbl() {
        return ghuserLbl;
    }

    public void setGhuserLbl(String ghuserLbl) {
        this.ghuserLbl = ghuserLbl;
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
        if (!(object instanceof HZGL004carDetail)) {
            return false;
        }
        HZGL004carDetail other = (HZGL004carDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZGL004carDetail[ oid=" + oid + " ]";
    }
    
}
