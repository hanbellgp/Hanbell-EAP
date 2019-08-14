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
@Table(name = "HK_GL060_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL060Detail.findAll", query = "SELECT h FROM HKGL060Detail h"),
    @NamedQuery(name = "HKGL060Detail.findByOID", query = "SELECT h FROM HKGL060Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL060Detail.findByFSN", query = "SELECT h FROM HKGL060Detail h WHERE h.formSerialNumber = :fsn")})
public class HKGL060Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "itemdesc")
    private String itemdesc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "requireUserName")
    private String requireUserName;
    @Size(max = 255)
    @Column(name = "applyqty")
    private String applyqty;
    @Size(max = 255)
    @Column(name = "warehouse")
    private String warehouse;
    @Size(max = 255)
    @Column(name = "requireDeptName")
    private String requireDeptName;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Size(max = 255)
    @Column(name = "itemspec")
    private String itemspec;
    @Size(max = 255)
    @Column(name = "actualqty")
    private String actualqty;
    @Size(max = 255)
    @Column(name = "requireUserno")
    private String requireUserno;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 255)
    @Column(name = "requireDeptno")
    private String requireDeptno;
    @Size(max = 255)
    @Column(name = "stockqty")
    private String stockqty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "amts")
    private String amts;

    public HKGL060Detail() {
    }

    public HKGL060Detail(String oid) {
        this.oid = oid;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRequireUserName() {
        return requireUserName;
    }

    public void setRequireUserName(String requireUserName) {
        this.requireUserName = requireUserName;
    }

    public String getApplyqty() {
        return applyqty;
    }

    public void setApplyqty(String applyqty) {
        this.applyqty = applyqty;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getRequireDeptName() {
        return requireDeptName;
    }

    public void setRequireDeptName(String requireDeptName) {
        this.requireDeptName = requireDeptName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemspec() {
        return itemspec;
    }

    public void setItemspec(String itemspec) {
        this.itemspec = itemspec;
    }

    public String getActualqty() {
        return actualqty;
    }

    public void setActualqty(String actualqty) {
        this.actualqty = actualqty;
    }

    public String getRequireUserno() {
        return requireUserno;
    }

    public void setRequireUserno(String requireUserno) {
        this.requireUserno = requireUserno;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getRequireDeptno() {
        return requireDeptno;
    }

    public void setRequireDeptno(String requireDeptno) {
        this.requireDeptno = requireDeptno;
    }

    public String getStockqty() {
        return stockqty;
    }

    public void setStockqty(String stockqty) {
        this.stockqty = stockqty;
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
        if (!(object instanceof HKGL060Detail)) {
            return false;
        }
        HKGL060Detail other = (HKGL060Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL060Detail[ oid=" + oid + " ]";
    }

}
