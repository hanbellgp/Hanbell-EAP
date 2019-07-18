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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "HK_GC003")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGC003.findAll", query = "SELECT h FROM HKGC003 h"),
    @NamedQuery(name = "HKGC003.findByOID", query = "SELECT h FROM HKGC003 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGC003.findBySerialNumber", query = "SELECT h FROM HKGC003 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGC003.findByPSN", query = "SELECT h FROM HKGC003 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGC003.findByFSN", query = "SELECT h FROM HKGC003 h WHERE h.formSerialNumber = :fsn")})
public class HKGC003 implements Serializable {

    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private ProcessInstance processInstance;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "srcOID")
    private String srcOID;
    @Size(max = 255)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "finqty")
    private String finqty;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "prono")
    private String prono;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Column(name = "formDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formDate;
    @Size(max = 255)
    @Column(name = "itnbrname")
    private String itnbrname;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "itnbrfname")
    private String itnbrfname;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "stockqty")
    private String stockqty;
    @Column(name = "stockDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stockDate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 50)
    @Column(name = "relout")
    private String relout;
    @Size(max = 50)
    @Column(name = "relin")
    private String relin;

    public HKGC003() {
    }

    public HKGC003(String oid) {
        this.oid = oid;
    }

    /**
     * @return the processInstance
     */
    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public String getSrcOID() {
        return srcOID;
    }

    public void setSrcOID(String srcOID) {
        this.srcOID = srcOID;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFinqty() {
        return finqty;
    }

    public void setFinqty(String finqty) {
        this.finqty = finqty;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public String getItnbrname() {
        return itnbrname;
    }

    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getItnbrfname() {
        return itnbrfname;
    }

    public void setItnbrfname(String itnbrfname) {
        this.itnbrfname = itnbrfname;
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

    public String getStockqty() {
        return stockqty;
    }

    public void setStockqty(String stockqty) {
        this.stockqty = stockqty;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
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
        if (!(object instanceof HKGC003)) {
            return false;
        }
        HKGC003 other = (HKGC003) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGC003[ oid=" + oid + " ]";
    }

    /**
     * @return the relout
     */
    public String getRelout() {
        return relout;
    }

    /**
     * @param relout the relout to set
     */
    public void setRelout(String relout) {
        this.relout = relout;
    }

    /**
     * @return the relin
     */
    public String getRelin() {
        return relin;
    }

    /**
     * @param relin the relin to set
     */
    public void setRelin(String relin) {
        this.relin = relin;
    }

}
