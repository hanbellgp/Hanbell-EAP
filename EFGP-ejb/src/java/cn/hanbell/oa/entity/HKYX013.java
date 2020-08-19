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
 * @author Administrator
 */
@Entity
@Table(name = "HK_YX013")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX013.findAll", query = "SELECT h FROM HKYX013 h"),
    @NamedQuery(name = "HKYX013.findByFacno", query = "SELECT h FROM HKYX013 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKYX013.findByPSN", query = "SELECT h FROM HKYX013 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKYX013.findByRemark", query = "SELECT h FROM HKYX013 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HKYX013.findByItnbr", query = "SELECT h FROM HKYX013 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKYX013.findByOldMancode", query = "SELECT h FROM HKYX013 h WHERE h.oldMancode = :oldMancode"),
    @NamedQuery(name = "HKYX013.findByOldMancodeName", query = "SELECT h FROM HKYX013 h WHERE h.oldMancodeName = :oldMancodeName"),
    @NamedQuery(name = "HKYX013.findByApplyUser", query = "SELECT h FROM HKYX013 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKYX013.findByNcodeCD", query = "SELECT h FROM HKYX013 h WHERE h.ncodeCD = :ncodeCD"),
    @NamedQuery(name = "HKYX013.findByHdnNcodeCD", query = "SELECT h FROM HKYX013 h WHERE h.hdnNcodeCD = :hdnNcodeCD"),
    @NamedQuery(name = "HKYX013.findByInvoiceType", query = "SELECT h FROM HKYX013 h WHERE h.invoiceType = :invoiceType"),
    @NamedQuery(name = "HKYX013.findByFSN", query = "SELECT h FROM HKYX013 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKYX013.findByOldDeptName", query = "SELECT h FROM HKYX013 h WHERE h.oldDeptName = :oldDeptName"),
    @NamedQuery(name = "HKYX013.findByIssevdta", query = "SELECT h FROM HKYX013 h WHERE h.issevdta = :issevdta"),
    @NamedQuery(name = "HKYX013.findByAppDept", query = "SELECT h FROM HKYX013 h WHERE h.appDept = :appDept"),
    @NamedQuery(name = "HKYX013.findByOldDeptno", query = "SELECT h FROM HKYX013 h WHERE h.oldDeptno = :oldDeptno"),
    @NamedQuery(name = "HKYX013.findByOid", query = "SELECT h FROM HKYX013 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKYX013.findByNcodeDA", query = "SELECT h FROM HKYX013 h WHERE h.ncodeDA = :ncodeDA"),
    @NamedQuery(name = "HKYX013.findByNewDept", query = "SELECT h FROM HKYX013 h WHERE h.newDept = :newDept"),
    @NamedQuery(name = "HKYX013.findByNcodeDC", query = "SELECT h FROM HKYX013 h WHERE h.ncodeDC = :ncodeDC"),
    @NamedQuery(name = "HKYX013.findBySingleNumber", query = "SELECT h FROM HKYX013 h WHERE h.singleNumber = :singleNumber"),
    @NamedQuery(name = "HKYX013.findByNcodeDD", query = "SELECT h FROM HKYX013 h WHERE h.ncodeDD = :ncodeDD"),
    @NamedQuery(name = "HKYX013.findBySerialNumber", query = "SELECT h FROM HKYX013 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKYX013.findByHdnNcodeDA", query = "SELECT h FROM HKYX013 h WHERE h.hdnNcodeDA = :hdnNcodeDA"),
    @NamedQuery(name = "HKYX013.findByHdnNcodeDC", query = "SELECT h FROM HKYX013 h WHERE h.hdnNcodeDC = :hdnNcodeDC"),
    @NamedQuery(name = "HKYX013.findByNewMancode", query = "SELECT h FROM HKYX013 h WHERE h.newMancode = :newMancode"),
    @NamedQuery(name = "HKYX013.findByApplyDate", query = "SELECT h FROM HKYX013 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HKYX013.findByProducttype", query = "SELECT h FROM HKYX013 h WHERE h.producttype = :producttype"),
    @NamedQuery(name = "HKYX013.findByDivision", query = "SELECT h FROM HKYX013 h WHERE h.division = :division"),
    @NamedQuery(name = "HKYX013.findByHdnregion", query = "SELECT h FROM HKYX013 h WHERE h.hdnregion = :hdnregion"),
    @NamedQuery(name = "HKYX013.findByOriginaldept", query = "SELECT h FROM HKYX013 h WHERE h.originaldept = :originaldept"),
    @NamedQuery(name = "HKYX013.findByHdndivision", query = "SELECT h FROM HKYX013 h WHERE h.hdndivision = :hdndivision"),
    @NamedQuery(name = "HKYX013.findByNewsalesman", query = "SELECT h FROM HKYX013 h WHERE h.newsalesman = :newsalesman"),
    @NamedQuery(name = "HKYX013.findByOriginalcode2", query = "SELECT h FROM HKYX013 h WHERE h.originalcode2 = :originalcode2"),
    @NamedQuery(name = "HKYX013.findByOriginalsalesman", query = "SELECT h FROM HKYX013 h WHERE h.originalsalesman = :originalsalesman"),
    @NamedQuery(name = "HKYX013.findByHdnproducttype", query = "SELECT h FROM HKYX013 h WHERE h.hdnproducttype = :hdnproducttype"),
    @NamedQuery(name = "HKYX013.findByOriginalcode1", query = "SELECT h FROM HKYX013 h WHERE h.originalcode1 = :originalcode1"),
    @NamedQuery(name = "HKYX013.findByService", query = "SELECT h FROM HKYX013 h WHERE h.service = :service"),
    @NamedQuery(name = "HKYX013.findByMachineParts", query = "SELECT h FROM HKYX013 h WHERE h.machineParts = :machineParts"),
    @NamedQuery(name = "HKYX013.findByApplydept", query = "SELECT h FROM HKYX013 h WHERE h.applydept = :applydept"),
    @NamedQuery(name = "HKYX013.findByRegion", query = "SELECT h FROM HKYX013 h WHERE h.region = :region"),
    @NamedQuery(name = "HKYX013.findByDifferenceAmount", query = "SELECT h FROM HKYX013 h WHERE h.differenceAmount = :differenceAmount")})
public class HKYX013 implements Serializable {

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
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "oldMancode")
    private String oldMancode;
    @Size(max = 255)
    @Column(name = "oldMancodeName")
    private String oldMancodeName;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "ncodeCD")
    private String ncodeCD;
    @Size(max = 255)
    @Column(name = "hdnNcodeCD")
    private String hdnNcodeCD;
    @Size(max = 255)
    @Column(name = "invoiceType")
    private String invoiceType;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "oldDeptName")
    private String oldDeptName;
    @Size(max = 255)
    @Column(name = "issevdta")
    private String issevdta;
    @Size(max = 255)
    @Column(name = "appDept")
    private String appDept;
    @Size(max = 255)
    @Column(name = "oldDeptno")
    private String oldDeptno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ncodeDA")
    private String ncodeDA;
    @Size(max = 255)
    @Column(name = "newDept")
    private String newDept;
    @Size(max = 255)
    @Column(name = "ncodeDC")
    private String ncodeDC;
    @Size(max = 255)
    @Column(name = "singleNumber")
    private String singleNumber;
    @Size(max = 255)
    @Column(name = "ncodeDD")
    private String ncodeDD;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdnNcodeDA")
    private String hdnNcodeDA;
    @Size(max = 255)
    @Column(name = "hdnNcodeDC")
    private String hdnNcodeDC;
    @Size(max = 255)
    @Column(name = "newMancode")
    private String newMancode;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "producttype")
    private String producttype;
    @Size(max = 255)
    @Column(name = "division")
    private String division;
    @Size(max = 255)
    @Column(name = "hdnregion")
    private String hdnregion;
    @Size(max = 255)
    @Column(name = "originaldept")
    private String originaldept;
    @Size(max = 255)
    @Column(name = "hdndivision")
    private String hdndivision;
    @Size(max = 255)
    @Column(name = "newsalesman")
    private String newsalesman;
    @Size(max = 255)
    @Column(name = "originalcode2")
    private String originalcode2;
    @Size(max = 255)
    @Column(name = "originalsalesman")
    private String originalsalesman;
    @Size(max = 255)
    @Column(name = "hdnproducttype")
    private String hdnproducttype;
    @Size(max = 255)
    @Column(name = "originalcode1")
    private String originalcode1;
    @Size(max = 255)
    @Column(name = "service")
    private String service;
    @Size(max = 255)
    @Column(name = "MachineParts")
    private String machineParts;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "region")
    private String region;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "differenceAmount")
    private Double differenceAmount;

    public HKYX013() {
    }

    public HKYX013(String oid) {
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

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getOldMancode() {
        return oldMancode;
    }

    public void setOldMancode(String oldMancode) {
        this.oldMancode = oldMancode;
    }

    public String getOldMancodeName() {
        return oldMancodeName;
    }

    public void setOldMancodeName(String oldMancodeName) {
        this.oldMancodeName = oldMancodeName;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getNcodeCD() {
        return ncodeCD;
    }

    public void setNcodeCD(String ncodeCD) {
        this.ncodeCD = ncodeCD;
    }

    public String getHdnNcodeCD() {
        return hdnNcodeCD;
    }

    public void setHdnNcodeCD(String hdnNcodeCD) {
        this.hdnNcodeCD = hdnNcodeCD;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOldDeptName() {
        return oldDeptName;
    }

    public void setOldDeptName(String oldDeptName) {
        this.oldDeptName = oldDeptName;
    }

    public String getIssevdta() {
        return issevdta;
    }

    public void setIssevdta(String issevdta) {
        this.issevdta = issevdta;
    }

    public String getAppDept() {
        return appDept;
    }

    public void setAppDept(String appDept) {
        this.appDept = appDept;
    }

    public String getOldDeptno() {
        return oldDeptno;
    }

    public void setOldDeptno(String oldDeptno) {
        this.oldDeptno = oldDeptno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNcodeDA() {
        return ncodeDA;
    }

    public void setNcodeDA(String ncodeDA) {
        this.ncodeDA = ncodeDA;
    }

    public String getNewDept() {
        return newDept;
    }

    public void setNewDept(String newDept) {
        this.newDept = newDept;
    }

    public String getNcodeDC() {
        return ncodeDC;
    }

    public void setNcodeDC(String ncodeDC) {
        this.ncodeDC = ncodeDC;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public String getNcodeDD() {
        return ncodeDD;
    }

    public void setNcodeDD(String ncodeDD) {
        this.ncodeDD = ncodeDD;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnNcodeDA() {
        return hdnNcodeDA;
    }

    public void setHdnNcodeDA(String hdnNcodeDA) {
        this.hdnNcodeDA = hdnNcodeDA;
    }

    public String getHdnNcodeDC() {
        return hdnNcodeDC;
    }

    public void setHdnNcodeDC(String hdnNcodeDC) {
        this.hdnNcodeDC = hdnNcodeDC;
    }

    public String getNewMancode() {
        return newMancode;
    }

    public void setNewMancode(String newMancode) {
        this.newMancode = newMancode;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getHdnregion() {
        return hdnregion;
    }

    public void setHdnregion(String hdnregion) {
        this.hdnregion = hdnregion;
    }

    public String getOriginaldept() {
        return originaldept;
    }

    public void setOriginaldept(String originaldept) {
        this.originaldept = originaldept;
    }

    public String getHdndivision() {
        return hdndivision;
    }

    public void setHdndivision(String hdndivision) {
        this.hdndivision = hdndivision;
    }

    public String getNewsalesman() {
        return newsalesman;
    }

    public void setNewsalesman(String newsalesman) {
        this.newsalesman = newsalesman;
    }

    public String getOriginalcode2() {
        return originalcode2;
    }

    public void setOriginalcode2(String originalcode2) {
        this.originalcode2 = originalcode2;
    }

    public String getOriginalsalesman() {
        return originalsalesman;
    }

    public void setOriginalsalesman(String originalsalesman) {
        this.originalsalesman = originalsalesman;
    }

    public String getHdnproducttype() {
        return hdnproducttype;
    }

    public void setHdnproducttype(String hdnproducttype) {
        this.hdnproducttype = hdnproducttype;
    }

    public String getOriginalcode1() {
        return originalcode1;
    }

    public void setOriginalcode1(String originalcode1) {
        this.originalcode1 = originalcode1;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMachineParts() {
        return machineParts;
    }

    public void setMachineParts(String machineParts) {
        this.machineParts = machineParts;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getDifferenceAmount() {
        return differenceAmount;
    }

    public void setDifferenceAmount(Double differenceAmount) {
        this.differenceAmount = differenceAmount;
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
        if (!(object instanceof HKYX013)) {
            return false;
        }
        HKYX013 other = (HKYX013) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX013[ oid=" + oid + " ]";
    }
    
}