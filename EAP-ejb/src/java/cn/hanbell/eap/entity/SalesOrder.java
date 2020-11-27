/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "salesorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrder.getRowCount", query = "SELECT COUNT(s) FROM SalesOrder s"),
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s"),
    @NamedQuery(name = "SalesOrder.findById", query = "SELECT s FROM SalesOrder s WHERE s.id = :id"),
    @NamedQuery(name = "SalesOrder.findByUID", query = "SELECT s FROM SalesOrder s WHERE s.uid = :uid"),
    @NamedQuery(name = "SalesOrder.findByFormdate", query = "SELECT s FROM SalesOrder s WHERE s.formdate = :formdate"),
    @NamedQuery(name = "SalesOrder.findByFormType", query = "SELECT s FROM SalesOrder s WHERE s.formType = :formType"),
    @NamedQuery(name = "SalesOrder.findByFormKind", query = "SELECT s FROM SalesOrder s WHERE s.formKind = :formKind"),
    @NamedQuery(name = "SalesOrder.findByDeptno", query = "SELECT s FROM SalesOrder s WHERE s.deptno = :deptno"),
    @NamedQuery(name = "SalesOrder.findByDept", query = "SELECT s FROM SalesOrder s WHERE s.dept = :dept"),
    @NamedQuery(name = "SalesOrder.findBySalesman", query = "SELECT s FROM SalesOrder s WHERE s.salesman = :salesman"),
    @NamedQuery(name = "SalesOrder.findBySalesmanName", query = "SELECT s FROM SalesOrder s WHERE s.salesmanName = :salesmanName"),
    @NamedQuery(name = "SalesOrder.findByCustomerno", query = "SELECT s FROM SalesOrder s WHERE s.customerno = :customerno"),
    @NamedQuery(name = "SalesOrder.findByCustomer", query = "SELECT s FROM SalesOrder s WHERE s.customer = :customer"),
    @NamedQuery(name = "SalesOrder.findByItemno", query = "SELECT s FROM SalesOrder s WHERE s.itemno = :itemno"),
    @NamedQuery(name = "SalesOrder.findByItemDesc", query = "SELECT s FROM SalesOrder s WHERE s.itemDesc = :itemDesc"),
    @NamedQuery(name = "SalesOrder.findByItemSpec", query = "SELECT s FROM SalesOrder s WHERE s.itemSpec = :itemSpec"),
    @NamedQuery(name = "SalesOrder.findByItemModel", query = "SELECT s FROM SalesOrder s WHERE s.itemModel = :itemModel"),
    @NamedQuery(name = "SalesOrder.findByDemandDate", query = "SELECT s FROM SalesOrder s WHERE s.demandDate = :demandDate"),
    @NamedQuery(name = "SalesOrder.findByStatus", query = "SELECT s FROM SalesOrder s WHERE s.status = :status")})
public class SalesOrder extends SuperEntity {

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "salesOrder")
    @JoinTable(name = "salesorderproduce")
    private List<SalesOrderSchedule> scheduleList = new ArrayList<SalesOrderSchedule>();

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
    @Size(max = 20)
    @Column(name = "salesman")
    private String salesman;
    @Size(max = 45)
    @Column(name = "salesmanName")
    private String salesmanName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customerno")
    private String customerno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer")
    private String customer;
    @Size(max = 45)
    @Column(name = "customerAlias")
    private String customerAlias;
    @Size(max = 45)
    @Column(name = "productSeries")
    private String productSeries;
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
    @Size(max = 45)
    @Column(name = "prop1")
    private String prop1;
    @Size(max = 45)
    @Column(name = "prop2")
    private String prop2;
    @Size(max = 45)
    @Column(name = "prop3")
    private String prop3;
    @Size(max = 45)
    @Column(name = "prop4")
    private String prop4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "demandDate")
    @Temporal(TemporalType.DATE)
    private Date demandDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigDecimal qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invqty")
    private BigDecimal invqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manqty")
    private BigDecimal manqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wipqty")
    private BigDecimal wipqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipqty")
    private BigDecimal shipqty;
    @Column(name = "bomDate")
    @Temporal(TemporalType.DATE)
    private Date bomDate;
    @Column(name = "manufactureDate")
    @Temporal(TemporalType.DATE)
    private Date manufactureDate;
    @Column(name = "prepareDate")
    @Temporal(TemporalType.DATE)
    private Date prepareDate;
    @Column(name = "deliveryDate")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Size(max = 200)
    @Column(name = "salesRemark")
    private String salesRemark;
    @Size(max = 200)
    @Column(name = "planRemark")
    private String planRemark;
    @Size(max = 200)
    @Column(name = "manufactureRemark")
    private String manufactureRemark;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "uid")
    private String uid;
    @Column(name = "autoUpdate")
    private Boolean autoUpdate;

    public SalesOrder() {
        this.autoUpdate = false;
    }

    /**
     * @return the scheduleList
     */
    public List<SalesOrderSchedule> getScheduleList() {
        return scheduleList;
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

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
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

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerAlias() {
        return customerAlias;
    }

    public void setCustomerAlias(String customerAlias) {
        this.customerAlias = customerAlias;
    }

    /**
     * @return the productSeries
     */
    public String getProductSeries() {
        return productSeries;
    }

    /**
     * @param productSeries the productSeries to set
     */
    public void setProductSeries(String productSeries) {
        this.productSeries = productSeries;
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

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getProp4() {
        return prop4;
    }

    public void setProp4(String prop4) {
        this.prop4 = prop4;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getInvqty() {
        return invqty;
    }

    public void setInvqty(BigDecimal invqty) {
        this.invqty = invqty;
    }

    public BigDecimal getManqty() {
        return manqty;
    }

    public void setManqty(BigDecimal manqty) {
        this.manqty = manqty;
    }

    public BigDecimal getWipqty() {
        return wipqty;
    }

    public void setWipqty(BigDecimal wipqty) {
        this.wipqty = wipqty;
    }

    public BigDecimal getShipqty() {
        return shipqty;
    }

    public void setShipqty(BigDecimal shipqty) {
        this.shipqty = shipqty;
    }

    public Date getBomDate() {
        return bomDate;
    }

    public void setBomDate(Date bomDate) {
        this.bomDate = bomDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getPrepareDate() {
        return prepareDate;
    }

    public void setPrepareDate(Date prepareDate) {
        this.prepareDate = prepareDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSalesRemark() {
        return salesRemark;
    }

    public void setSalesRemark(String salesRemark) {
        this.salesRemark = salesRemark;
    }

    public String getPlanRemark() {
        return planRemark;
    }

    public void setPlanRemark(String planRemark) {
        this.planRemark = planRemark;
    }

    public String getManufactureRemark() {
        return manufactureRemark;
    }

    public void setManufactureRemark(String manufactureRemark) {
        this.manufactureRemark = manufactureRemark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the uid
     */
    public String getUID() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUID(String uid) {
        this.uid = uid;
    }

    /**
     * @return the autoUpdate
     */
    public Boolean getAutoUpdate() {
        return autoUpdate;
    }

    /**
     * @param autoUpdate the autoUpdate to set
     */
    public void setAutoUpdate(Boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
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
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return Objects.equals(this.formid, other.formid);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SalesOrder[ id=" + id + " ]";
    }

    public void sumManufactureQuantity() {
        BigDecimal manqty = BigDecimal.ZERO;
        this.getScheduleList();
        for (SalesOrderSchedule p : this.scheduleList) {
            manqty = manqty.add(p.getManqty());
        }
        this.setManqty(manqty);
    }

}
