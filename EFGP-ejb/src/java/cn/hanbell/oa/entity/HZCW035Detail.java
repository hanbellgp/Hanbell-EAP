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
@Table(name = "HZ_CW035_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW035Detail.findAll", query = "SELECT h FROM HZCW035Detail h"),
    @NamedQuery(name = "HZCW035Detail.findBySubprojectno", query = "SELECT h FROM HZCW035Detail h WHERE h.subprojectno = :subprojectno"),
    @NamedQuery(name = "HZCW035Detail.findByEstimateamount", query = "SELECT h FROM HZCW035Detail h WHERE h.estimateamount = :estimateamount"),
    @NamedQuery(name = "HZCW035Detail.findByEndDatetxt", query = "SELECT h FROM HZCW035Detail h WHERE h.endDatetxt = :endDatetxt"),
    @NamedQuery(name = "HZCW035Detail.findByStartDatetxt", query = "SELECT h FROM HZCW035Detail h WHERE h.startDatetxt = :startDatetxt"),
    @NamedQuery(name = "HZCW035Detail.findByPrice", query = "SELECT h FROM HZCW035Detail h WHERE h.price = :price"),
    @NamedQuery(name = "HZCW035Detail.findByQty", query = "SELECT h FROM HZCW035Detail h WHERE h.qty = :qty"),
    @NamedQuery(name = "HZCW035Detail.findByFSN", query = "SELECT h FROM HZCW035Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW035Detail.findByRemark", query = "SELECT h FROM HZCW035Detail h WHERE h.remark = :remark"),
    @NamedQuery(name = "HZCW035Detail.findByOID", query = "SELECT h FROM HZCW035Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW035Detail.findBySeq", query = "SELECT h FROM HZCW035Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HZCW035Detail.findBySubprojectname", query = "SELECT h FROM HZCW035Detail h WHERE h.subprojectname = :subprojectname")})
public class HZCW035Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "subprojectno")
    private String subprojectno;
    @Size(max = 255)
    @Column(name = "estimateamount")
    private String estimateamount;
    @Size(max = 255)
    @Column(name = "endDate_txt")
    private String endDatetxt;
    @Size(max = 255)
    @Column(name = "startDate_txt")
    private String startDatetxt;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
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
    @Column(name = "subprojectname")
    private String subprojectname;

    public HZCW035Detail() {
    }

    public HZCW035Detail(String oid) {
        this.oid = oid;
    }

    public String getSubprojectno() {
        return subprojectno;
    }

    public void setSubprojectno(String subprojectno) {
        this.subprojectno = subprojectno;
    }

    public String getEstimateamount() {
        return estimateamount;
    }

    public void setEstimateamount(String estimateamount) {
        this.estimateamount = estimateamount;
    }

    public String getEndDatetxt() {
        return endDatetxt;
    }

    public void setEndDatetxt(String endDatetxt) {
        this.endDatetxt = endDatetxt;
    }

    public String getStartDatetxt() {
        return startDatetxt;
    }

    public void setStartDatetxt(String startDatetxt) {
        this.startDatetxt = startDatetxt;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getSubprojectname() {
        return subprojectname;
    }

    public void setSubprojectname(String subprojectname) {
        this.subprojectname = subprojectname;
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
        if (!(object instanceof HZCW035Detail)) {
            return false;
        }
        HZCW035Detail other = (HZCW035Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW035Detail[ oid=" + oid + " ]";
    }
    
}
