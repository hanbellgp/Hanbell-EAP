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
 * @author C2082
 */
@Entity
@Table(name = "HK_GL031")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL031.findAll", query = "SELECT h FROM HKGL031 h"),
    @NamedQuery(name = "HKGL031.findByOid", query = "SELECT h FROM HKGL031 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL031.findByFwView", query = "SELECT h FROM HKGL031 h WHERE h.fwView = :fwView"),
    @NamedQuery(name = "HKGL031.findByQtView", query = "SELECT h FROM HKGL031 h WHERE h.qtView = :qtView"),
    @NamedQuery(name = "HKGL031.findByJlView", query = "SELECT h FROM HKGL031 h WHERE h.jlView = :jlView"),
    @NamedQuery(name = "HKGL031.findByType", query = "SELECT h FROM HKGL031 h WHERE h.type = :type"),
    @NamedQuery(name = "HKGL031.findBySerialNumber", query = "SELECT h FROM HKGL031 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL031.findByCreatetime", query = "SELECT h FROM HKGL031 h WHERE h.createtime = :createtime"),
    @NamedQuery(name = "HKGL031.findByDept", query = "SELECT h FROM HKGL031 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKGL031.findByExplain", query = "SELECT h FROM HKGL031 h WHERE h.explain = :explain"),
    @NamedQuery(name = "HKGL031.findByZgView", query = "SELECT h FROM HKGL031 h WHERE h.zgView = :zgView"),
    @NamedQuery(name = "HKGL031.findByPSN", query = "SELECT h FROM HKGL031 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL031.findByEmpl", query = "SELECT h FROM HKGL031 h WHERE h.empl = :empl"),
    @NamedQuery(name = "HKGL031.findByFSN", query = "SELECT h FROM HKGL031 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL031.findByHdnEmpl", query = "SELECT h FROM HKGL031 h WHERE h.hdnEmpl = :hdnEmpl"),
    @NamedQuery(name = "HKGL031.findByHdnDept", query = "SELECT h FROM HKGL031 h WHERE h.hdnDept = :hdnDept"),
    @NamedQuery(name = "HKGL031.findByHdnType", query = "SELECT h FROM HKGL031 h WHERE h.hdnType = :hdnType"),
    @NamedQuery(name = "HKGL031.findByHdFileDetail", query = "SELECT h FROM HKGL031 h WHERE h.hdFileDetail = :hdFileDetail"),
    @NamedQuery(name = "HKGL031.findByTest2", query = "SELECT h FROM HKGL031 h WHERE h.test2 = :test2"),
    @NamedQuery(name = "HKGL031.findByBook1", query = "SELECT h FROM HKGL031 h WHERE h.book1 = :book1"),
    @NamedQuery(name = "HKGL031.findByTest1", query = "SELECT h FROM HKGL031 h WHERE h.test1 = :test1"),
    @NamedQuery(name = "HKGL031.findByHdFileType", query = "SELECT h FROM HKGL031 h WHERE h.hdFileType = :hdFileType"),
    @NamedQuery(name = "HKGL031.findByHdnDept1", query = "SELECT h FROM HKGL031 h WHERE h.hdnDept1 = :hdnDept1"),
    @NamedQuery(name = "HKGL031.findByHdnManager", query = "SELECT h FROM HKGL031 h WHERE h.hdnManager = :hdnManager"),
    @NamedQuery(name = "HKGL031.findByHdnmanage", query = "SELECT h FROM HKGL031 h WHERE h.hdnmanage = :hdnmanage"),
    @NamedQuery(name = "HKGL031.findByStampCategory", query = "SELECT h FROM HKGL031 h WHERE h.stampCategory = :stampCategory"),
    @NamedQuery(name = "HKGL031.findByFacno", query = "SELECT h FROM HKGL031 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKGL031.findBySealfacno", query = "SELECT h FROM HKGL031 h WHERE h.sealfacno = :sealfacno"),
    @NamedQuery(name = "HKGL031.findByDivision", query = "SELECT h FROM HKGL031 h WHERE h.division = :division"),
    @NamedQuery(name = "HKGL031.findByContractno", query = "SELECT h FROM HKGL031 h WHERE h.contractno = :contractno"),
    @NamedQuery(name = "HKGL031.findByOldcontractno", query = "SELECT h FROM HKGL031 h WHERE h.oldcontractno = :oldcontractno")})
public class HKGL031 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "fw_view")
    private String fwView;
    @Size(max = 255)
    @Column(name = "qt_view")
    private String qtView;
    @Size(max = 255)
    @Column(name = "jl_view")
    private String jlView;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "explain")
    private String explain;
    @Size(max = 255)
    @Column(name = "zg_view")
    private String zgView;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "empl")
    private String empl;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_empl")
    private String hdnEmpl;
    @Size(max = 255)
    @Column(name = "hdn_dept")
    private String hdnDept;
    @Size(max = 255)
    @Column(name = "hdn_type")
    private String hdnType;
    @Size(max = 255)
    @Column(name = "hdFileDetail")
    private String hdFileDetail;
    @Size(max = 255)
    @Column(name = "test2")
    private String test2;
    @Size(max = 255)
    @Column(name = "book1")
    private String book1;
    @Size(max = 255)
    @Column(name = "test1")
    private String test1;
    @Size(max = 255)
    @Column(name = "hdFileType")
    private String hdFileType;
    @Size(max = 255)
    @Column(name = "hdnDept")
    private String hdnDept1;
    @Size(max = 255)
    @Column(name = "hdnManager")
    private String hdnManager;
    @Size(max = 255)
    @Column(name = "hdnmanage")
    private String hdnmanage;
    @Size(max = 255)
    @Column(name = "stampCategory")
    private String stampCategory;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "sealfacno")
    private String sealfacno;
    @Size(max = 255)
    @Column(name = "division")
    private String division;
    @Size(max = 255)
    @Column(name = "contractno")
    private String contractno;
    @Size(max = 255)
    @Column(name = "oldcontractno")
    private String oldcontractno;

    public HKGL031() {
    }

    public HKGL031(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFwView() {
        return fwView;
    }

    public void setFwView(String fwView) {
        this.fwView = fwView;
    }

    public String getQtView() {
        return qtView;
    }

    public void setQtView(String qtView) {
        this.qtView = qtView;
    }

    public String getJlView() {
        return jlView;
    }

    public void setJlView(String jlView) {
        this.jlView = jlView;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getZgView() {
        return zgView;
    }

    public void setZgView(String zgView) {
        this.zgView = zgView;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getEmpl() {
        return empl;
    }

    public void setEmpl(String empl) {
        this.empl = empl;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnEmpl() {
        return hdnEmpl;
    }

    public void setHdnEmpl(String hdnEmpl) {
        this.hdnEmpl = hdnEmpl;
    }

    public String getHdnDept() {
        return hdnDept;
    }

    public void setHdnDept(String hdnDept) {
        this.hdnDept = hdnDept;
    }

    public String getHdnType() {
        return hdnType;
    }

    public void setHdnType(String hdnType) {
        this.hdnType = hdnType;
    }

    public String getHdFileDetail() {
        return hdFileDetail;
    }

    public void setHdFileDetail(String hdFileDetail) {
        this.hdFileDetail = hdFileDetail;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String getBook1() {
        return book1;
    }

    public void setBook1(String book1) {
        this.book1 = book1;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getHdFileType() {
        return hdFileType;
    }

    public void setHdFileType(String hdFileType) {
        this.hdFileType = hdFileType;
    }

    public String getHdnDept1() {
        return hdnDept1;
    }

    public void setHdnDept1(String hdnDept1) {
        this.hdnDept1 = hdnDept1;
    }

    public String getHdnManager() {
        return hdnManager;
    }

    public void setHdnManager(String hdnManager) {
        this.hdnManager = hdnManager;
    }

    public String getHdnmanage() {
        return hdnmanage;
    }

    public void setHdnmanage(String hdnmanage) {
        this.hdnmanage = hdnmanage;
    }

    public String getStampCategory() {
        return stampCategory;
    }

    public void setStampCategory(String stampCategory) {
        this.stampCategory = stampCategory;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSealfacno() {
        return sealfacno;
    }

    public void setSealfacno(String sealfacno) {
        this.sealfacno = sealfacno;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getOldcontractno() {
        return oldcontractno;
    }

    public void setOldcontractno(String oldcontractno) {
        this.oldcontractno = oldcontractno;
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
        if (!(object instanceof HKGL031)) {
            return false;
        }
        HKGL031 other = (HKGL031) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL031[ oid=" + oid + " ]";
    }
    
}
