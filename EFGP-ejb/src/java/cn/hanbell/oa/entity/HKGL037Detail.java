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
 * @author Administrator
 */
@Entity
@Table(name = "HK_GL037_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL037Detail.findAll", query = "SELECT h FROM HKGL037Detail h"),
    @NamedQuery(name = "HKGL037Detail.findByGhTxt", query = "SELECT h FROM HKGL037Detail h WHERE h.ghTxt = :ghTxt"),
    @NamedQuery(name = "HKGL037Detail.findByBmTxt", query = "SELECT h FROM HKGL037Detail h WHERE h.bmTxt = :bmTxt"),
    @NamedQuery(name = "HKGL037Detail.findByOid", query = "SELECT h FROM HKGL037Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL037Detail.findByMdcs", query = "SELECT h FROM HKGL037Detail h WHERE h.mdcs = :mdcs"),
    @NamedQuery(name = "HKGL037Detail.findByYcrqTxt", query = "SELECT h FROM HKGL037Detail h WHERE h.ycrqTxt = :ycrqTxt"),
    @NamedQuery(name = "HKGL037Detail.findByAddress1", query = "SELECT h FROM HKGL037Detail h WHERE h.address1 = :address1"),
    @NamedQuery(name = "HKGL037Detail.findByAddress2", query = "SELECT h FROM HKGL037Detail h WHERE h.address2 = :address2"),
    @NamedQuery(name = "HKGL037Detail.findByMdsf", query = "SELECT h FROM HKGL037Detail h WHERE h.mdsf = :mdsf"),
    @NamedQuery(name = "HKGL037Detail.findByKr", query = "SELECT h FROM HKGL037Detail h WHERE h.kr = :kr"),
    @NamedQuery(name = "HKGL037Detail.findByCfcs", query = "SELECT h FROM HKGL037Detail h WHERE h.cfcs = :cfcs"),
    @NamedQuery(name = "HKGL037Detail.findByKrlxfs", query = "SELECT h FROM HKGL037Detail h WHERE h.krlxfs = :krlxfs"),
    @NamedQuery(name = "HKGL037Detail.findByContact", query = "SELECT h FROM HKGL037Detail h WHERE h.contact = :contact"),
    @NamedQuery(name = "HKGL037Detail.findByCfsf", query = "SELECT h FROM HKGL037Detail h WHERE h.cfsf = :cfsf"),
    @NamedQuery(name = "HKGL037Detail.findBySeq", query = "SELECT h FROM HKGL037Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL037Detail.findByGsmc", query = "SELECT h FROM HKGL037Detail h WHERE h.gsmc = :gsmc"),
    @NamedQuery(name = "HKGL037Detail.findByGhLbl", query = "SELECT h FROM HKGL037Detail h WHERE h.ghLbl = :ghLbl"),
    @NamedQuery(name = "HKGL037Detail.findBySy", query = "SELECT h FROM HKGL037Detail h WHERE h.sy = :sy"),
    @NamedQuery(name = "HKGL037Detail.findByFSN", query = "SELECT h FROM HKGL037Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL037Detail.findByBmLbl", query = "SELECT h FROM HKGL037Detail h WHERE h.bmLbl = :bmLbl")})
public class HKGL037Detail implements Serializable {

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
    @Column(name = "mdcs")
    private String mdcs;
    @Size(max = 255)
    @Column(name = "ycrq_txt")
    private String ycrqTxt;
    @Size(max = 255)
    @Column(name = "address1")
    private String address1;
    @Size(max = 255)
    @Column(name = "address2")
    private String address2;
    @Size(max = 255)
    @Column(name = "mdsf")
    private String mdsf;
    @Size(max = 255)
    @Column(name = "kr")
    private String kr;
    @Size(max = 255)
    @Column(name = "cfcs")
    private String cfcs;
    @Size(max = 255)
    @Column(name = "krlxfs")
    private String krlxfs;
    @Size(max = 255)
    @Column(name = "contact")
    private String contact;
    @Size(max = 255)
    @Column(name = "cfsf")
    private String cfsf;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "gsmc")
    private String gsmc;
    @Size(max = 255)
    @Column(name = "gh_lbl")
    private String ghLbl;
    @Size(max = 255)
    @Column(name = "sy")
    private String sy;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "bm_lbl")
    private String bmLbl;

    public HKGL037Detail() {
    }

    public HKGL037Detail(String oid) {
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

    public String getMdcs() {
        return mdcs;
    }

    public void setMdcs(String mdcs) {
        this.mdcs = mdcs;
    }

    public String getYcrqTxt() {
        return ycrqTxt;
    }

    public void setYcrqTxt(String ycrqTxt) {
        this.ycrqTxt = ycrqTxt;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getMdsf() {
        return mdsf;
    }

    public void setMdsf(String mdsf) {
        this.mdsf = mdsf;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getCfcs() {
        return cfcs;
    }

    public void setCfcs(String cfcs) {
        this.cfcs = cfcs;
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

    public String getCfsf() {
        return cfsf;
    }

    public void setCfsf(String cfsf) {
        this.cfsf = cfsf;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getGhLbl() {
        return ghLbl;
    }

    public void setGhLbl(String ghLbl) {
        this.ghLbl = ghLbl;
    }

    public String getSy() {
        return sy;
    }

    public void setSy(String sy) {
        this.sy = sy;
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
        if (!(object instanceof HKGL037Detail)) {
            return false;
        }
        HKGL037Detail other = (HKGL037Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.ejb.HKGL037Detail[ oid=" + oid + " ]";
    }
    
}
