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
@Table(name = "SHB_ERP_INV310")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV310.findAll", query = "SELECT s FROM SHBERPINV310 s"),
    @NamedQuery(name = "SHBERPINV310.findByCode", query = "SELECT s FROM SHBERPINV310 s WHERE s.code = :code"),
    @NamedQuery(name = "SHBERPINV310.findByFacno", query = "SELECT s FROM SHBERPINV310 s WHERE s.facno = :facno"),
    @NamedQuery(name = "SHBERPINV310.findByPSN", query = "SELECT s FROM SHBERPINV310 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SHBERPINV310.findByUseDept", query = "SELECT s FROM SHBERPINV310 s WHERE s.useDept = :useDept"),
    @NamedQuery(name = "SHBERPINV310.findByInputUser", query = "SELECT s FROM SHBERPINV310 s WHERE s.inputUser = :inputUser"),
    @NamedQuery(name = "SHBERPINV310.findByItnbr", query = "SELECT s FROM SHBERPINV310 s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPINV310.findByApplyUser", query = "SELECT s FROM SHBERPINV310 s WHERE s.applyUser = :applyUser"),
    @NamedQuery(name = "SHBERPINV310.findByTotal", query = "SELECT s FROM SHBERPINV310 s WHERE s.total = :total"),
    @NamedQuery(name = "SHBERPINV310.findByApplyDept", query = "SELECT s FROM SHBERPINV310 s WHERE s.applyDept = :applyDept"),
    @NamedQuery(name = "SHBERPINV310.findByItdsc", query = "SELECT s FROM SHBERPINV310 s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "SHBERPINV310.findByCdesc", query = "SELECT s FROM SHBERPINV310 s WHERE s.cdesc = :cdesc"),
    @NamedQuery(name = "SHBERPINV310.findByUnmsr1", query = "SELECT s FROM SHBERPINV310 s WHERE s.unmsr1 = :unmsr1"),
    @NamedQuery(name = "SHBERPINV310.findByFixnr", query = "SELECT s FROM SHBERPINV310 s WHERE s.fixnr = :fixnr"),
    @NamedQuery(name = "SHBERPINV310.findByChangeCode", query = "SELECT s FROM SHBERPINV310 s WHERE s.changeCode = :changeCode"),
    @NamedQuery(name = "SHBERPINV310.findByFSN", query = "SELECT s FROM SHBERPINV310 s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPINV310.findByFactory1", query = "SELECT s FROM SHBERPINV310 s WHERE s.factory1 = :factory1"),
    @NamedQuery(name = "SHBERPINV310.findByOid", query = "SELECT s FROM SHBERPINV310 s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPINV310.findByWareh", query = "SELECT s FROM SHBERPINV310 s WHERE s.wareh = :wareh"),
    @NamedQuery(name = "SHBERPINV310.findBySerialNumber", query = "SELECT s FROM SHBERPINV310 s WHERE s.serialNumber = :serialNumber"),
    @NamedQuery(name = "SHBERPINV310.findByChangeCdesc", query = "SELECT s FROM SHBERPINV310 s WHERE s.changeCdesc = :changeCdesc"),
    @NamedQuery(name = "SHBERPINV310.findByQty", query = "SELECT s FROM SHBERPINV310 s WHERE s.qty = :qty"),
    @NamedQuery(name = "SHBERPINV310.findByProducer", query = "SELECT s FROM SHBERPINV310 s WHERE s.producer = :producer"),
    @NamedQuery(name = "SHBERPINV310.findByApplyDate", query = "SELECT s FROM SHBERPINV310 s WHERE s.applyDate = :applyDate"),
    @NamedQuery(name = "SHBERPINV310.findByManufacturingNo", query = "SELECT s FROM SHBERPINV310 s WHERE s.manufacturingNo = :manufacturingNo"),
    @NamedQuery(name = "SHBERPINV310.findByRemarks", query = "SELECT s FROM SHBERPINV310 s WHERE s.remarks = :remarks"),
    @NamedQuery(name = "SHBERPINV310.findBySpdsc", query = "SELECT s FROM SHBERPINV310 s WHERE s.spdsc = :spdsc")})
public class SHBERPINV310 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "useDept")
    private String useDept;
    @Size(max = 255)
    @Column(name = "inputUser")
    private String inputUser;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "erptrno")
    private String erptrno;
    @Size(max = 255)
    @Column(name = "total")
    private String total;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "cdesc")
    private String cdesc;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 255)
    @Column(name = "changeCode")
    private String changeCode;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "factory1")
    private String factory1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "changeCdesc")
    private String changeCdesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Size(max = 255)
    @Column(name = "producer")
    private String producer;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "manufacturingNo")
    private String manufacturingNo;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "erpDept")
    private String erpDept;
    @Size(max = 255)
    @Column(name = "trtype")
    private String trtype;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;

    public SHBERPINV310() {
    }

    public SHBERPINV310(String oid) {
        this.oid = oid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getUseDept() {
        return useDept;
    }

    public void setUseDept(String useDept) {
        this.useDept = useDept;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getChangeCode() {
        return changeCode;
    }

    public void setChangeCode(String changeCode) {
        this.changeCode = changeCode;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getFactory1() {
        return factory1;
    }

    public void setFactory1(String factory1) {
        this.factory1 = factory1;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getChangeCdesc() {
        return changeCdesc;
    }

    public void setChangeCdesc(String changeCdesc) {
        this.changeCdesc = changeCdesc;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getManufacturingNo() {
        return manufacturingNo;
    }

    public void setManufacturingNo(String manufacturingNo) {
        this.manufacturingNo = manufacturingNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
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
        if (!(object instanceof SHBERPINV310)) {
            return false;
        }
        SHBERPINV310 other = (SHBERPINV310) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV310[ oid=" + oid + " ]";
    }

    public String getErptrno() {
        return erptrno;
    }

    public void setErptrno(String erptrno) {
        this.erptrno = erptrno;
    }

    public String getErpDept() {
        return erpDept;
    }

    public void setErpDept(String erpDept) {
        this.erpDept = erpDept;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

}
