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
 * @author C0160
 */
@Entity
@Table(name = "HZ_CW034_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW034Detail.findAll", query = "SELECT h FROM HZCW034Detail h"),
    @NamedQuery(name = "HZCW034Detail.findByOID", query = "SELECT h FROM HZCW034Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW034Detail.findByFSN", query = "SELECT h FROM HZCW034Detail h WHERE h.formSerialNumber = :fsn")})
public class HZCW034Detail implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "takeKind")
    private String takeKind;
    @Size(max = 255)
    @Column(name = "takeKind1")
    private String takeKind1;
    @Size(max = 255)
    @Column(name = "scrapReason")
    private String scrapReason;
    @Size(max = 255)
    @Column(name = "scrapReason1")
    private String scrapReason1;
    @Size(max = 255)
    @Column(name = "assetDesc")
    private String assetDesc;
    @Size(max = 255)
    @Column(name = "warehouseno")
    private String warehouseno;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "warehouseno2")
    private String warehouseno2;
    @Size(max = 255)
    @Column(name = "buyDate_txt")
    private String buyDatetxt;
    @Size(max = 255)
    @Column(name = "warehouse2")
    private String warehouse2;
    @Size(max = 255)
    @Column(name = "surplusValue")
    private String surplusValue;
    @Size(max = 255)
    @Column(name = "scrapKind")
    private String scrapKind;
    @Size(max = 255)
    @Column(name = "warehouse")
    private String warehouse;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "assetno")
    private String assetno;
    @Size(max = 255)
    @Column(name = "scrapqty")
    private String scrapqty;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Size(max = 255)
    @Column(name = "usetime")
    private String usetime;
    @Size(max = 255)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "deptname")
    private String deptname;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "amts")
    private String amts;

    public HZCW034Detail() {
    }

    public HZCW034Detail(String oid) {
        this.oid = oid;
    }

    public String getTakeKind() {
        return takeKind;
    }

    public void setTakeKind(String takeKind) {
        this.takeKind = takeKind;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the seq
     */
    public String getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getScrapReason() {
        return scrapReason;
    }

    public void setScrapReason(String scrapReason) {
        this.scrapReason = scrapReason;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
    }

    public String getWarehouseno() {
        return warehouseno;
    }

    public void setWarehouseno(String warehouseno) {
        this.warehouseno = warehouseno;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehouseno2() {
        return warehouseno2;
    }

    public void setWarehouseno2(String warehouseno2) {
        this.warehouseno2 = warehouseno2;
    }

    public String getBuyDatetxt() {
        return buyDatetxt;
    }

    public void setBuyDatetxt(String buyDatetxt) {
        this.buyDatetxt = buyDatetxt;
    }

    public String getWarehouse2() {
        return warehouse2;
    }

    public void setWarehouse2(String warehouse2) {
        this.warehouse2 = warehouse2;
    }

    public String getSurplusValue() {
        return surplusValue;
    }

    public void setSurplusValue(String surplusValue) {
        this.surplusValue = surplusValue;
    }

    public String getScrapKind() {
        return scrapKind;
    }

    public void setScrapKind(String scrapKind) {
        this.scrapKind = scrapKind;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getAssetno() {
        return assetno;
    }

    public void setAssetno(String assetno) {
        this.assetno = assetno;
    }

    public String getScrapqty() {
        return scrapqty;
    }

    public void setScrapqty(String scrapqty) {
        this.scrapqty = scrapqty;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getAmts() {
        return amts;
    }

    public void setAmts(String amts) {
        this.amts = amts;
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
        if (!(object instanceof HZCW034Detail)) {
            return false;
        }
        HZCW034Detail other = (HZCW034Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW034Detail[ oid=" + oid + " ]";
    }

    public String getTakeKind1() {
        return takeKind1;
    }

    public void setTakeKind1(String takeKind1) {
        this.takeKind1 = takeKind1;
    }

    public String getScrapReason1() {
        return scrapReason1;
    }

    public void setScrapReason1(String scrapReason1) {
        this.scrapReason1 = scrapReason1;
    }

}
