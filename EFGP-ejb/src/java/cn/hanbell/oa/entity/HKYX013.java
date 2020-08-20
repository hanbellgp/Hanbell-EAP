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
    @NamedQuery(name = "HKYX013.findByOldDept", query = "SELECT h FROM HKYX013 h WHERE h.oldDept = :oldDept"),
    @NamedQuery(name = "HKYX013.findByItnbr", query = "SELECT h FROM HKYX013 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKYX013.findByOldMancode", query = "SELECT h FROM HKYX013 h WHERE h.oldMancode = :oldMancode"),
    @NamedQuery(name = "HKYX013.findByApplyUser", query = "SELECT h FROM HKYX013 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKYX013.findByDifferenceAmount", query = "SELECT h FROM HKYX013 h WHERE h.differenceAmount = :differenceAmount"),
    @NamedQuery(name = "HKYX013.findByNcodeCD", query = "SELECT h FROM HKYX013 h WHERE h.ncodeCD = :ncodeCD"),
    @NamedQuery(name = "HKYX013.findByHdnNcodeCD", query = "SELECT h FROM HKYX013 h WHERE h.hdnNcodeCD = :hdnNcodeCD"),
    @NamedQuery(name = "HKYX013.findByInvoiceType", query = "SELECT h FROM HKYX013 h WHERE h.invoiceType = :invoiceType"),
    @NamedQuery(name = "HKYX013.findByFSN", query = "SELECT h FROM HKYX013 h WHERE h.formSerialNumber = :fsn"),
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
    @NamedQuery(name = "HKYX013.findByTrseq", query = "SELECT h FROM HKYX013 h WHERE h.trseq = :trseq"),
    @NamedQuery(name = "HKYX013.findByHdnNcodeDC", query = "SELECT h FROM HKYX013 h WHERE h.hdnNcodeDC = :hdnNcodeDC"),
    @NamedQuery(name = "HKYX013.findByNewMancode", query = "SELECT h FROM HKYX013 h WHERE h.newMancode = :newMancode"),
    @NamedQuery(name = "HKYX013.findByOldManName", query = "SELECT h FROM HKYX013 h WHERE h.oldManName = :oldManName"),
    @NamedQuery(name = "HKYX013.findByApplyDate", query = "SELECT h FROM HKYX013 h WHERE h.applyDate = :applyDate")})
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
    @Column(name = "oldDept")
    private String oldDept;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "oldMancode")
    private String oldMancode;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "differenceAmount")
    private Double differenceAmount;
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
    @Column(name = "trseq")
    private Integer trseq;
    @Size(max = 255)
    @Column(name = "hdnNcodeDC")
    private String hdnNcodeDC;
    @Size(max = 255)
    @Column(name = "newMancode")
    private String newMancode;
    @Size(max = 255)
    @Column(name = "oldManName")
    private String oldManName;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;

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

    public String getOldDept() {
        return oldDept;
    }

    public void setOldDept(String oldDept) {
        this.oldDept = oldDept;
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

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Double getDifferenceAmount() {
        return differenceAmount;
    }

    public void setDifferenceAmount(Double differenceAmount) {
        this.differenceAmount = differenceAmount;
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

    public Integer getTrseq() {
        return trseq;
    }

    public void setTrseq(Integer trseq) {
        this.trseq = trseq;
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

    public String getOldManName() {
        return oldManName;
    }

    public void setOldManName(String oldManName) {
        this.oldManName = oldManName;
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
