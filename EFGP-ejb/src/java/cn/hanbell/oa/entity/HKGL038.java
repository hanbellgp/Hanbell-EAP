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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Administrator
 */
@Entity
@Table(name = "HK_GL038")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL038.findAll", query = "SELECT h FROM HKGL038 h"),
    @NamedQuery(name = "HKGL038.findByTotal", query = "SELECT h FROM HKGL038 h WHERE h.total = :total"),
    @NamedQuery(name = "HKGL038.findByMileagetotal", query = "SELECT h FROM HKGL038 h WHERE h.mileagetotal = :mileagetotal"),
    @NamedQuery(name = "HKGL038.findByOid", query = "SELECT h FROM HKGL038 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL038.findBySrcno", query = "SELECT h FROM HKGL038 h WHERE h.srcno = :srcno"),
    @NamedQuery(name = "HKGL038.findByApplydate", query = "SELECT h FROM HKGL038 h WHERE h.applydate = :applydate"),
    @NamedQuery(name = "HKGL038.findByZgls", query = "SELECT h FROM HKGL038 h WHERE h.zgls = :zgls"),
    @NamedQuery(name = "HKGL038.findByApplydept", query = "SELECT h FROM HKGL038 h WHERE h.applydept = :applydept"),
    @NamedQuery(name = "HKGL038.findByCctime", query = "SELECT h FROM HKGL038 h WHERE h.cctime = :cctime"),
    @NamedQuery(name = "HKGL038.findByFacno", query = "SELECT h FROM HKGL038 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKGL038.findByClxz", query = "SELECT h FROM HKGL038 h WHERE h.clxz = :clxz"),
    @NamedQuery(name = "HKGL038.findBySerialNumber", query = "SELECT h FROM HKGL038 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL038.findByHdDetail", query = "SELECT h FROM HKGL038 h WHERE h.hdDetail = :hdDetail"),
    @NamedQuery(name = "HKGL038.findByJsy", query = "SELECT h FROM HKGL038 h WHERE h.jsy = :jsy"),
    @NamedQuery(name = "HKGL038.findBySgls", query = "SELECT h FROM HKGL038 h WHERE h.sgls = :sgls"),
    @NamedQuery(name = "HKGL038.findByApplyuser", query = "SELECT h FROM HKGL038 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKGL038.findByCph", query = "SELECT h FROM HKGL038 h WHERE h.cph = :cph"),
    @NamedQuery(name = "HKGL038.findByTxry", query = "SELECT h FROM HKGL038 h WHERE h.txry = :txry"),
    @NamedQuery(name = "HKGL038.findByPSN", query = "SELECT h FROM HKGL038 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL038.findByFSN", query = "SELECT h FROM HKGL038 h WHERE h.formSerialNumber = :fsn")})
public class HKGL038 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @JoinColumn(name = "applyuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyUser;
    @JoinColumn(name = "applydept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit applyDept;
    @Column(name = "total")
    private Double total;
    @Column(name = "mileagetotal")
    private Double mileagetotal;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "srcno")
    private String srcno;
    @Column(name = "applydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydate;
    @Column(name = "zgls")
    private Double zgls;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "cctime")
    private String cctime;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "clxz")
    private String clxz;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdDetail")
    private String hdDetail;
    @Size(max = 255)
    @Column(name = "jsy")
    private String jsy;
    @Column(name = "sgls")
    private Double sgls;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "cph")
    private String cph;
    @Size(max = 255)
    @Column(name = "txry")
    private String txry;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "ycyy")
    private String ycyy;
    @Column(name = "unprice")
    private Double unprice;
    @Column(name = "cost ")
    private Double cost;
    @Column(name = "totalcost")
    private Double totalcost;
    public HKGL038() {
    }

    public HKGL038(String oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMileagetotal() {
        return mileagetotal;
    }

    public void setMileagetotal(Double mileagetotal) {
        this.mileagetotal = mileagetotal;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Double getZgls() {
        return zgls;
    }

    public void setZgls(Double zgls) {
        this.zgls = zgls;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getCctime() {
        return cctime;
    }

    public void setCctime(String cctime) {
        this.cctime = cctime;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getClxz() {
        return clxz;
    }

    public void setClxz(String clxz) {
        this.clxz = clxz;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdDetail() {
        return hdDetail;
    }

    public void setHdDetail(String hdDetail) {
        this.hdDetail = hdDetail;
    }

    public String getJsy() {
        return jsy;
    }

    public void setJsy(String jsy) {
        this.jsy = jsy;
    }

    public Double getSgls() {
        return sgls;
    }

    public void setSgls(Double sgls) {
        this.sgls = sgls;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getTxry() {
        return txry;
    }

    public void setTxry(String txry) {
        this.txry = txry;
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

    public Users getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Users applyUser) {
        this.applyUser = applyUser;
    }

    public OrganizationUnit getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(OrganizationUnit applyDept) {
        this.applyDept = applyDept;
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
        if (!(object instanceof HKGL038)) {
            return false;
        }
        HKGL038 other = (HKGL038) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.comm.HKGL038[ oid=" + oid + " ]";
    }

    public String getYcyy() {
        return ycyy;
    }

    public void setYcyy(String ycyy) {
        this.ycyy = ycyy;
    }

    public Double getUnprice() {
        return unprice;
    }

    public void setUnprice(Double unprice) {
        this.unprice = unprice;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }

}
