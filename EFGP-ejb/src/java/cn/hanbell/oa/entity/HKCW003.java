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
@Table(name = "HK_CW003")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW003.findAll", query = "SELECT s FROM HKCW003 s"),
    @NamedQuery(name = "HKCW003.findByOid", query = "SELECT s FROM HKCW003 s WHERE s.oid = :oid"),
    @NamedQuery(name = "HKCW003.findByApplydate", query = "SELECT s FROM HKCW003 s WHERE s.applydate = :applydate"),
    @NamedQuery(name = "HKCW003.findByEspdsc", query = "SELECT s FROM HKCW003 s WHERE s.espdsc = :espdsc"),
    @NamedQuery(name = "HKCW003.findByApplydept", query = "SELECT s FROM HKCW003 s WHERE s.applydept = :applydept"),
    @NamedQuery(name = "HKCW003.findByItdsc", query = "SELECT s FROM HKCW003 s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "HKCW003.findByUnmsr1", query = "SELECT s FROM HKCW003 s WHERE s.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HKCW003.findByCost", query = "SELECT s FROM HKCW003 s WHERE s.cost = :cost"),
    @NamedQuery(name = "HKCW003.findByFacno", query = "SELECT s FROM HKCW003 s WHERE s.facno = :facno"),
    @NamedQuery(name = "HKCW003.findBySerialNumber", query = "SELECT s FROM HKCW003 s WHERE s.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW003.findBySpdsc", query = "SELECT s FROM HKCW003 s WHERE s.spdsc = :spdsc"),
    @NamedQuery(name = "HKCW003.findByAsscost", query = "SELECT s FROM HKCW003 s WHERE s.asscost = :asscost"),
    @NamedQuery(name = "HKCW003.findByApplyuser", query = "SELECT s FROM HKCW003 s WHERE s.applyuser = :applyuser"),
    @NamedQuery(name = "HKCW003.findByItnbr", query = "SELECT s FROM HKCW003 s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "HKCW003.findByPSN", query = "SELECT s FROM HKCW003 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW003.findByFSN", query = "SELECT s FROM HKCW003 s WHERE s.formSerialNumber = :fsn")})
public class HKCW003 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "applydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydate;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Column(name = "asscost")
    private Double asscost;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKCW003() {
    }

    public HKCW003(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public Double getAsscost() {
        return asscost;
    }

    public void setAsscost(Double asscost) {
        this.asscost = asscost;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW003)) {
            return false;
        }
        HKCW003 other = (HKCW003) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW003[ oid=" + oid + " ]";
    }
    
}
