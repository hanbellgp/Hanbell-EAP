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
 * @author C0160
 */
@Entity
@Table(name = "HK_GC001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGC001.findAll", query = "SELECT h FROM HKGC001 h"),
    @NamedQuery(name = "HKGC001.findByOID", query = "SELECT h FROM HKGC001 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGC001.findByPSN", query = "SELECT h FROM HKGC001 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGC001.findByFSN", query = "SELECT h FROM HKGC001 h WHERE h.formSerialNumber = :fsn")})
public class HKGC001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "purchasehelp")
    private String purchasehelp;
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
    @Column(name = "machiningman")
    private String machiningman;
    @Size(max = 255)
    @Column(name = "finqty")
    private String finqty;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "relno")
    private String relno;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "wareh2")
    private String wareh2;
    @Size(max = 255)
    @Column(name = "applyneed")
    private String applyneed;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "itnbrname")
    private String itnbrname;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "whdsc2")
    private String whdsc2;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "needdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date needdate;
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
    @Column(name = "finishdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishdate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKGC001() {
    }

    public HKGC001(String oid) {
        this.oid = oid;
    }

    public String getPurchasehelp() {
        return purchasehelp;
    }

    public void setPurchasehelp(String purchasehelp) {
        this.purchasehelp = purchasehelp;
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

    public String getMachiningman() {
        return machiningman;
    }

    public void setMachiningman(String machiningman) {
        this.machiningman = machiningman;
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

    public String getRelno() {
        return relno;
    }

    public void setRelno(String relno) {
        this.relno = relno;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getWareh2() {
        return wareh2;
    }

    public void setWareh2(String wareh2) {
        this.wareh2 = wareh2;
    }

    public String getApplyneed() {
        return applyneed;
    }

    public void setApplyneed(String applyneed) {
        this.applyneed = applyneed;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getItnbrname() {
        return itnbrname;
    }

    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getWhdsc2() {
        return whdsc2;
    }

    public void setWhdsc2(String whdsc2) {
        this.whdsc2 = whdsc2;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getNeeddate() {
        return needdate;
    }

    public void setNeeddate(Date needdate) {
        this.needdate = needdate;
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

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
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
        if (!(object instanceof HKGC001)) {
            return false;
        }
        HKGC001 other = (HKGC001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGC001[ oid=" + oid + " ]";
    }
    
}
