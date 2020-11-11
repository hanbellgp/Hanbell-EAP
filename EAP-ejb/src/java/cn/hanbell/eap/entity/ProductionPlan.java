/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "productionplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionPlan.findAll", query = "SELECT p FROM ProductionPlan p"),
    @NamedQuery(name = "ProductionPlan.findById", query = "SELECT p FROM ProductionPlan p WHERE p.id = :id"),
    @NamedQuery(name = "ProductionPlan.findByCompany", query = "SELECT p FROM ProductionPlan p WHERE p.company = :company"),
    @NamedQuery(name = "ProductionPlan.findByFormid", query = "SELECT p FROM ProductionPlan p WHERE p.formid = :formid"),
    @NamedQuery(name = "ProductionPlan.findByFormdate", query = "SELECT p FROM ProductionPlan p WHERE p.formdate = :formdate"),
    @NamedQuery(name = "ProductionPlan.findByFormType", query = "SELECT p FROM ProductionPlan p WHERE p.formType = :formType"),
    @NamedQuery(name = "ProductionPlan.findByFormKind", query = "SELECT p FROM ProductionPlan p WHERE p.formKind = :formKind"),
    @NamedQuery(name = "ProductionPlan.findByContent", query = "SELECT p FROM ProductionPlan p WHERE p.content = :content"),
    @NamedQuery(name = "ProductionPlan.findByItemno", query = "SELECT p FROM ProductionPlan p WHERE p.itemno = :itemno"),
    @NamedQuery(name = "ProductionPlan.findByItemModel", query = "SELECT p FROM ProductionPlan p WHERE p.itemModel = :itemModel"),
    @NamedQuery(name = "ProductionPlan.findByUid", query = "SELECT p FROM ProductionPlan p WHERE p.uid = :uid"),
    @NamedQuery(name = "ProductionPlan.findByStatus", query = "SELECT p FROM ProductionPlan p WHERE p.status = :status"),})
public class ProductionPlan extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 6)
    @Column(name = "mon")
    private String mon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "formid")
    private String formid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "formdate")
    @Temporal(TemporalType.DATE)
    private Date formdate;
    @Size(max = 10)
    @Column(name = "formType")
    private String formType;
    @Size(max = 10)
    @Column(name = "formKind")
    private String formKind;
    @Size(max = 45)
    @Column(name = "content")
    private String content;
    @Size(max = 20)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 45)
    @Column(name = "dept")
    private String dept;
    @Size(max = 60)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 100)
    @Column(name = "itemDesc")
    private String itemDesc;
    @Size(max = 100)
    @Column(name = "itemSpec")
    private String itemSpec;
    @Size(max = 45)
    @Column(name = "itemModel")
    private String itemModel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigDecimal qty;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Size(max = 45)
    @Column(name = "uid")
    private String uid;

    public ProductionPlan() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the mon
     */
    public String getMon() {
        return mon;
    }

    /**
     * @param mon the mon to set
     */
    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public Date getFormdate() {
        return formdate;
    }

    public void setFormdate(Date formdate) {
        this.formdate = formdate;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormKind() {
        return formKind;
    }

    public void setFormKind(String formKind) {
        this.formKind = formKind;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUID() {
        return uid;
    }

    public void setUID(String uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionPlan)) {
            return false;
        }
        ProductionPlan other = (ProductionPlan) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return Objects.equals(this.formid, other.formid);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ProductionPlan[ id=" + id + " ]";
    }

}
