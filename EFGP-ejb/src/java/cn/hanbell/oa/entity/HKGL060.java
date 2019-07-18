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
@Table(name = "HK_GL060")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL060.findAll", query = "SELECT h FROM HKGL060 h")
    , @NamedQuery(name = "HKGL060.findByOID", query = "SELECT h FROM HKGL060 h WHERE h.oid = :oid")
    , @NamedQuery(name = "HKGL060.findByPSN", query = "SELECT h FROM HKGL060 h WHERE h.processSerialNumber = :psn")
    , @NamedQuery(name = "HKGL060.findByFSN", query = "SELECT h FROM HKGL060 h WHERE h.formSerialNumber = :fsn")})
public class HKGL060 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "useexplain")
    private String useexplain;
    @Column(name = "applyqty")
    private Integer applyqty;
    @Size(max = 255)
    @Column(name = "hdn_applyDept")
    private String hdnapplyDept;
    @Size(max = 255)
    @Column(name = "warehouse")
    private String warehouse;
    @Size(max = 255)
    @Column(name = "hdn_applyUser")
    private String hdnapplyUser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "categoryName")
    private String categoryName;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amts")
    private Double amts;
    @Size(max = 255)
    @Column(name = "itemdesc")
    private String itemdesc;
    @Size(max = 255)
    @Column(name = "requireDept")
    private String requireDept;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "requireUser")
    private String requireUser;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Column(name = "price")
    private Double price;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Column(name = "totalamts")
    private Double totalamts;
    @Size(max = 255)
    @Column(name = "itemspec")
    private String itemspec;
    @Column(name = "actualqty")
    private Integer actualqty;
    @Column(name = "totalqty")
    private Double totalqty;
    @Size(max = 255)
    @Column(name = "itemno")
    private String itemno;
    @Column(name = "stockqty")
    private Integer stockqty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;
    @Size(max = 20)
    @Column(name = "relformid")
    private String relformid;

    public HKGL060() {
    }

    public HKGL060(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUseexplain() {
        return useexplain;
    }

    public void setUseexplain(String useexplain) {
        this.useexplain = useexplain;
    }

    public Integer getApplyqty() {
        return applyqty;
    }

    public void setApplyqty(Integer applyqty) {
        this.applyqty = applyqty;
    }

    public String getHdnapplyDept() {
        return hdnapplyDept;
    }

    public void setHdnapplyDept(String hdnapplyDept) {
        this.hdnapplyDept = hdnapplyDept;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getHdnapplyUser() {
        return hdnapplyUser;
    }

    public void setHdnapplyUser(String hdnapplyUser) {
        this.hdnapplyUser = hdnapplyUser;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Double getAmts() {
        return amts;
    }

    public void setAmts(Double amts) {
        this.amts = amts;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public String getRequireDept() {
        return requireDept;
    }

    public void setRequireDept(String requireDept) {
        this.requireDept = requireDept;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getRequireUser() {
        return requireUser;
    }

    public void setRequireUser(String requireUser) {
        this.requireUser = requireUser;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Double getTotalamts() {
        return totalamts;
    }

    public void setTotalamts(Double totalamts) {
        this.totalamts = totalamts;
    }

    public String getItemspec() {
        return itemspec;
    }

    public void setItemspec(String itemspec) {
        this.itemspec = itemspec;
    }

    public Integer getActualqty() {
        return actualqty;
    }

    public void setActualqty(Integer actualqty) {
        this.actualqty = actualqty;
    }

    public Double getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Double totalqty) {
        this.totalqty = totalqty;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public Integer getStockqty() {
        return stockqty;
    }

    public void setStockqty(Integer stockqty) {
        this.stockqty = stockqty;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
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
        if (!(object instanceof HKGL060)) {
            return false;
        }
        HKGL060 other = (HKGL060) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL060[ oid=" + oid + " ]";
    }

    /**
     * @return the relformid
     */
    public String getRelformid() {
        return relformid;
    }

    /**
     * @param relformid the relformid to set
     */
    public void setRelformid(String relformid) {
        this.relformid = relformid;
    }

}
