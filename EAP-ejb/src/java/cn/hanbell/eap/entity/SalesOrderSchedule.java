/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "salesorderschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrderSchedule.findAll", query = "SELECT s FROM SalesOrderSchedule s"),
    @NamedQuery(name = "SalesOrderSchedule.findById", query = "SELECT s FROM SalesOrderSchedule s WHERE s.id = :id"),
    @NamedQuery(name = "SalesOrderSchedule.findByPId", query = "SELECT s FROM SalesOrderSchedule s WHERE s.pid = :pid"),
    @NamedQuery(name = "SalesOrderSchedule.findByManufactureDate", query = "SELECT s FROM SalesOrderSchedule s WHERE s.manufactureDate = :manufactureDate"),
    @NamedQuery(name = "SalesOrderSchedule.findByManqty", query = "SELECT s FROM SalesOrderSchedule s WHERE s.manqty = :manqty"),
    @NamedQuery(name = "SalesOrderSchedule.findByRemark", query = "SELECT s FROM SalesOrderSchedule s WHERE s.remark = :remark")})
public class SalesOrderSchedule extends SuperDetailEntity {

    @JsonbTransient
    @ManyToOne(optional = false)
    @JoinColumn(name = "pid", referencedColumnName = "id", insertable = false, updatable = false)
    private SalesOrder salesOrder;

    @Size(max = 20)
    @Column(name = "manufactureId")
    private String manufactureId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manufactureDate")
    @Temporal(TemporalType.DATE)
    private Date manufactureDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "manqty")
    private BigDecimal manqty;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public SalesOrderSchedule() {

    }

    /**
     * @return the salesOrder
     */
    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    /**
     * @param salesOrder the salesOrder to set
     */
    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    /**
     * @return the manufactureId
     */
    public String getManufactureId() {
        return manufactureId;
    }

    /**
     * @param manufactureId the manufactureId to set
     */
    public void setManufactureId(String manufactureId) {
        this.manufactureId = manufactureId;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public BigDecimal getManqty() {
        return manqty;
    }

    public void setManqty(BigDecimal manqty) {
        this.manqty = manqty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof SalesOrderSchedule)) {
            return false;
        }
        SalesOrderSchedule other = (SalesOrderSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SalesOrderProduce[ id=" + id + " ]";
    }

}
