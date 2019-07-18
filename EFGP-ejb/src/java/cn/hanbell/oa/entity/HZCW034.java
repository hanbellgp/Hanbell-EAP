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
 * @author C0160
 */
@Entity
@Table(name = "HZ_CW034")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW034.findAll", query = "SELECT h FROM HZCW034 h"),
    @NamedQuery(name = "HZCW034.findByOID", query = "SELECT h FROM HZCW034 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW034.findByPSN", query = "SELECT h FROM HZCW034 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW034.findByFSN", query = "SELECT h FROM HZCW034 h WHERE h.formSerialNumber = :fsn")})
public class HZCW034 implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "applyuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyuser1;
    @JoinColumn(name = "applydept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit applydept1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "warehouse")
    private String warehouse;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdnFacno")
    private String hdnFacno;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Column(name = "rsum")
    private Double rsum;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "deptname")
    private String deptname;
    @Column(name = "applydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydate;
    @Size(max = 255)
    @Column(name = "warehouseno")
    private String warehouseno;
    @Size(max = 255)
    @Column(name = "mark")
    private String mark;
    @Size(max = 255)
    @Column(name = "hdnAssetKind")
    private String hdnAssetKind;
    @Column(name = "countsum")
    private Double countsum;
    @Size(max = 255)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "sourceno")
    private String sourceno;
    @Size(max = 255)
    @Column(name = "disposeno")
    private String disposeno;

    public HZCW034() {
    }

    public HZCW034(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getRsum() {
        return rsum;
    }

    public void setRsum(Double rsum) {
        this.rsum = rsum;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getWarehouseno() {
        return warehouseno;
    }

    public void setWarehouseno(String warehouseno) {
        this.warehouseno = warehouseno;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getHdnAssetKind() {
        return hdnAssetKind;
    }

    public void setHdnAssetKind(String hdnAssetKind) {
        this.hdnAssetKind = hdnAssetKind;
    }

    public Double getCountsum() {
        return countsum;
    }

    public void setCountsum(Double countsum) {
        this.countsum = countsum;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
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
        if (!(object instanceof HZCW034)) {
            return false;
        }
        HZCW034 other = (HZCW034) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW034[ oid=" + oid + " ]";
    }

    /**
     * @return the sourceno
     */
    public String getSourceno() {
        return sourceno;
    }

    /**
     * @param sourceno the sourceno to set
     */
    public void setSourceno(String sourceno) {
        this.sourceno = sourceno;
    }

    /**
     * @return the disposeno
     */
    public String getDisposeno() {
        return disposeno;
    }

    /**
     * @param disposeno the disposeno to set
     */
    public void setDisposeno(String disposeno) {
        this.disposeno = disposeno;
    }

    /**
     * @return the applyuser1
     */
    public Users getApplyuser1() {
        return applyuser1;
    }

    /**
     * @param applyuser1 the applyuser1 to set
     */
    public void setApplyuser1(Users applyuser1) {
        this.applyuser1 = applyuser1;
    }

    /**
     * @return the applydept1
     */
    public OrganizationUnit getApplydept1() {
        return applydept1;
    }

    /**
     * @param applydept1 the applydept1 to set
     */
    public void setApplydept1(OrganizationUnit applydept1) {
        this.applydept1 = applydept1;
    }

}
