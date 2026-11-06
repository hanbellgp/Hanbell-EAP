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
 * @author C2082
 */
@Entity
@Table(name = "HK_FW013_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW013Detail.findAll", query = "SELECT h FROM HKFW013Detail h"),
    @NamedQuery(name = "HKFW013Detail.findByItnbrTxt", query = "SELECT h FROM HKFW013Detail h WHERE h.itnbrTxt = :itnbrTxt"),
    @NamedQuery(name = "HKFW013Detail.findByItdsc", query = "SELECT h FROM HKFW013Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW013Detail.findByQty", query = "SELECT h FROM HKFW013Detail h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKFW013Detail.findByFSN", query = "SELECT h FROM HKFW013Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKFW013Detail.findByOid", query = "SELECT h FROM HKFW013Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW013Detail.findBySingleWeight", query = "SELECT h FROM HKFW013Detail h WHERE h.singleWeight = :singleWeight"),
    @NamedQuery(name = "HKFW013Detail.findByManufacturingNo", query = "SELECT h FROM HKFW013Detail h WHERE h.manufacturingNo = :manufacturingNo"),
    @NamedQuery(name = "HKFW013Detail.findBySingleSize", query = "SELECT h FROM HKFW013Detail h WHERE h.singleSize = :singleSize"),
    @NamedQuery(name = "HKFW013Detail.findBySerialNo", query = "SELECT h FROM HKFW013Detail h WHERE h.serialNo = :serialNo")})
public class HKFW013Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "itnbr_txt")
    private String itnbrTxt;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "singleWeight")
    private String singleWeight;
    @Size(max = 255)
    @Column(name = "manufacturingNo")
    private String manufacturingNo;
    @Size(max = 255)
    @Column(name = "singleSize")
    private String singleSize;
    @Size(max = 255)
    @Column(name = "serialNo")
    private String serialNo;

    public HKFW013Detail() {
    }

    public HKFW013Detail(String oid) {
        this.oid = oid;
    }

    public String getItnbrTxt() {
        return itnbrTxt;
    }

    public void setItnbrTxt(String itnbrTxt) {
        this.itnbrTxt = itnbrTxt;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(String singleWeight) {
        this.singleWeight = singleWeight;
    }

    public String getManufacturingNo() {
        return manufacturingNo;
    }

    public void setManufacturingNo(String manufacturingNo) {
        this.manufacturingNo = manufacturingNo;
    }

    public String getSingleSize() {
        return singleSize;
    }

    public void setSingleSize(String singleSize) {
        this.singleSize = singleSize;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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
        if (!(object instanceof HKFW013Detail)) {
            return false;
        }
        HKFW013Detail other = (HKFW013Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW013Detail[ oid=" + oid + " ]";
    }
    
}
