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
@Table(name = "HK_CW002_purDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW002Detail.findAll", query = "SELECT h FROM HKCW002Detail h"),
    @NamedQuery(name = "HKCW002Detail.findByOID", query = "SELECT h FROM HKCW002Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW002Detail.findByFSN", query = "SELECT h FROM HKCW002Detail h WHERE h.formSerialNumber = :fsn")})
public class HKCW002Detail implements Serializable {

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
    @Column(name = "rqtdate_txt")
    private String rqtdateTxt;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "categoryDesc")
    private String categoryDesc;
    @Size(max = 255)
    @Column(name = "accyearbal")
    private String accyearbal;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "dmark2desc")
    private String dmark2desc;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Size(max = 255)
    @Column(name = "purqty")
    private String purqty;
    @Size(max = 255)
    @Column(name = "itemspec")
    private String itemspec;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "accperbal")
    private String accperbal;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "emgyn")
    private String emgyn;
    @Size(max = 255)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 255)
    @Column(name = "dmark1desc")
    private String dmark1desc;
    @Size(max = 255)
    @Column(name = "disqty")
    private String disqty;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "amts")
    private String amts;
    @Size(max = 255)
    @Column(name = "relno")
    private String relno;
    @Size(max = 255)
    @Column(name = "relseq")
    private String relseq;
    @Size(max = 255)
    @Column(name = "relqty")
    private String relqty;

    public HKCW002Detail() {
    }

    public HKCW002Detail(String oid) {
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

    public String getRqtdateTxt() {
        return rqtdateTxt;
    }

    public void setRqtdateTxt(String rqtdateTxt) {
        this.rqtdateTxt = rqtdateTxt;
    }

    public String getBudgetaccname() {
        return budgetaccname;
    }

    public void setBudgetaccname(String budgetaccname) {
        this.budgetaccname = budgetaccname;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getAccyearbal() {
        return accyearbal;
    }

    public void setAccyearbal(String accyearbal) {
        this.accyearbal = accyearbal;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getDmark2desc() {
        return dmark2desc;
    }

    public void setDmark2desc(String dmark2desc) {
        this.dmark2desc = dmark2desc;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurqty() {
        return purqty;
    }

    public void setPurqty(String purqty) {
        this.purqty = purqty;
    }

    public String getItemspec() {
        return itemspec;
    }

    public void setItemspec(String itemspec) {
        this.itemspec = itemspec;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getAccperbal() {
        return accperbal;
    }

    public void setAccperbal(String accperbal) {
        this.accperbal = accperbal;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getEmgyn() {
        return emgyn;
    }

    public void setEmgyn(String emgyn) {
        this.emgyn = emgyn;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getDmark1desc() {
        return dmark1desc;
    }

    public void setDmark1desc(String dmark1desc) {
        this.dmark1desc = dmark1desc;
    }

    public String getDisqty() {
        return disqty;
    }

    public void setDisqty(String disqty) {
        this.disqty = disqty;
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
        if (!(object instanceof HKCW002Detail)) {
            return false;
        }
        HKCW002Detail other = (HKCW002Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW002Detail[ oid=" + oid + " ]";
    }

    /**
     * @return the relno
     */
    public String getRelno() {
        return relno;
    }

    /**
     * @param relno the relno to set
     */
    public void setRelno(String relno) {
        this.relno = relno;
    }

    /**
     * @return the relseq
     */
    public String getRelseq() {
        return relseq;
    }

    /**
     * @param relseq the relseq to set
     */
    public void setRelseq(String relseq) {
        this.relseq = relseq;
    }

    /**
     * @return the relqty
     */
    public String getRelqty() {
        return relqty;
    }

    /**
     * @param relqty the relqty to set
     */
    public void setRelqty(String relqty) {
        this.relqty = relqty;
    }

}
