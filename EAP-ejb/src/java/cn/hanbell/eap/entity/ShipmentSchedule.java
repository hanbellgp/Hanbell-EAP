/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
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
 * @author kevindong
 */
@Entity
@Table(name = "shipmentschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShipmentSchedule.findAll", query = "SELECT s FROM ShipmentSchedule s"),
    @NamedQuery(name = "ShipmentSchedule.findById", query = "SELECT s FROM ShipmentSchedule s WHERE s.id = :id"),
    @NamedQuery(name = "ShipmentSchedule.findByCompany", query = "SELECT s FROM ShipmentSchedule s WHERE s.company = :company"),
    @NamedQuery(name = "ShipmentSchedule.findByFormdate", query = "SELECT s FROM ShipmentSchedule s WHERE s.formdate = :formdate"),
    @NamedQuery(name = "ShipmentSchedule.findByCustomerno", query = "SELECT s FROM ShipmentSchedule s WHERE s.customerno = :customerno"),
    @NamedQuery(name = "ShipmentSchedule.findByCustomer", query = "SELECT s FROM ShipmentSchedule s WHERE s.customer = :customer"),
    @NamedQuery(name = "ShipmentSchedule.findByItemno", query = "SELECT s FROM ShipmentSchedule s WHERE s.itemno = :itemno"),
    @NamedQuery(name = "ShipmentSchedule.findByItemDesc", query = "SELECT s FROM ShipmentSchedule s WHERE s.itemDesc = :itemDesc"),
    @NamedQuery(name = "ShipmentSchedule.findByPriority", query = "SELECT s FROM ShipmentSchedule s WHERE s.priority = :priority"),
    @NamedQuery(name = "ShipmentSchedule.findByUID", query = "SELECT s FROM ShipmentSchedule s WHERE s.uid = :uid"),
    @NamedQuery(name = "ShipmentSchedule.findByStatus", query = "SELECT s FROM ShipmentSchedule s WHERE s.status = :status")})
public class ShipmentSchedule extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "company")
    private String company;
    @Column(name = "formdate")
    @Temporal(TemporalType.DATE)
    private Date formdate;
    @Size(max = 45)
    @Column(name = "customerno")
    private String customerno;
    @Size(max = 45)
    @Column(name = "customer")
    private String customer;
    @Size(max = 45)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 60)
    @Column(name = "itemDesc")
    private String itemDesc;
    @Size(max = 60)
    @Column(name = "itemSpec")
    private String itemSpec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "appqty")
    private BigDecimal appqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invqty")
    private BigDecimal invqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diffqty")
    private BigDecimal diffqty;
    @Size(max = 400)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "tag")
    private String tag;
    @Column(name = "priority")
    private Integer priority;
    @Size(max = 32)
    @Column(name = "uid")
    private String uid;

    public ShipmentSchedule() {
        this.appqty = BigDecimal.ZERO;
        this.invqty = BigDecimal.ZERO;
        this.diffqty = BigDecimal.ZERO;
        this.priority = 2;
        this.uid = UUID.randomUUID().toString().replace("-", "");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getFormdate() {
        return formdate;
    }

    public void setFormdate(Date formdate) {
        this.formdate = formdate;
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

    public BigDecimal getAppqty() {
        return appqty;
    }

    public void setAppqty(BigDecimal appqty) {
        this.appqty = appqty;
    }

    public BigDecimal getInvqty() {
        return invqty;
    }

    public void setInvqty(BigDecimal invqty) {
        this.invqty = invqty;
    }

    public BigDecimal getDiffqty() {
        return diffqty;
    }

    public void setDiffqty(BigDecimal diffqty) {
        this.diffqty = diffqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
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
        if (!(object instanceof ShipmentSchedule)) {
            return false;
        }
        ShipmentSchedule other = (ShipmentSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ShipmentSchedule[ id=" + id + " ]";
    }

}
