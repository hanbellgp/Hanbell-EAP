/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C1879
 * 客诉成本各费用明细
 */
@Entity
@Table(name = "customercomplaintcost")
@NamedQueries({
    @NamedQuery(name = "CustomerComplaintCost.findAll", query = "SELECT c FROM CustomerComplaintCost c")
    ,
    @NamedQuery(name = "CustomerComplaintCost.findKfno", query = "SELECT c FROM CustomerComplaintCost c WHERE c.kfno = :kfno ")
})
public class CustomerComplaintCost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 30)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 40)
    @Column(name = "costno")
    private String costno;
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;
    @Size(max = 40)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 40)
    @Column(name = "remark2")
    private String remark2;

    public CustomerComplaintCost() {
        this.cost = BigDecimal.ZERO;
    }

    public CustomerComplaintCost(Integer id) {
        this.id = id;
    }

    public CustomerComplaintCost(Integer id, String kfno) {
        this.id = id;
        this.kfno = kfno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getCostno() {
        return costno;
    }

    public void setCostno(String costno) {
        this.costno = costno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
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
        if (!(object instanceof CustomerComplaintCost)) {
            return false;
        }
        CustomerComplaintCost other = (CustomerComplaintCost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.CuscomPlaintCost[ id=" + id + " ]";
    }

}
