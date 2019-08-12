/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "shipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipment.findAll", query = "SELECT s FROM Shipment s"),
    @NamedQuery(name = "Shipment.findById", query = "SELECT s FROM Shipment s WHERE s.id = :id"),
    @NamedQuery(name = "Shipment.findByCompany", query = "SELECT s FROM Shipment s WHERE s.company = :company"),
    @NamedQuery(name = "Shipment.findByFormid", query = "SELECT s FROM Shipment s WHERE s.formid = :formid"),
    @NamedQuery(name = "Shipment.findByFormdate", query = "SELECT s FROM Shipment s WHERE s.formdate = :formdate"),
    @NamedQuery(name = "Shipment.findByDeptno", query = "SELECT s FROM Shipment s WHERE s.deptno = :deptno"),
    @NamedQuery(name = "Shipment.findByDeptname", query = "SELECT s FROM Shipment s WHERE s.deptname = :deptname"),
    @NamedQuery(name = "Shipment.findByUserno", query = "SELECT s FROM Shipment s WHERE s.userno = :userno"),
    @NamedQuery(name = "Shipment.findByUsername", query = "SELECT s FROM Shipment s WHERE s.username = :username"),
    @NamedQuery(name = "Shipment.findByCustomerno", query = "SELECT s FROM Shipment s WHERE s.customerno = :customerno"),
    @NamedQuery(name = "Shipment.findByCustomer", query = "SELECT s FROM Shipment s WHERE s.customer = :customer"),
    @NamedQuery(name = "Shipment.findByStatus", query = "SELECT s FROM Shipment s WHERE s.status = :status")})
public class Shipment extends FormEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "company")
    private String company;

    @Size(max = 20)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 45)
    @Column(name = "deptname")
    private String deptname;
    @Size(max = 20)
    @Column(name = "userno")
    private String userno;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customerno")
    private String customerno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer")
    private String customer;
    @Size(max = 100)
    @Column(name = "customerFullname")
    private String customerFullName;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public Shipment() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    /**
     * @return the customerFullName
     */
    public String getCustomerFullName() {
        return customerFullName;
    }

    /**
     * @param customerFullName the customerFullName to set
     */
    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
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
        if (!(object instanceof Shipment)) {
            return false;
        }
        Shipment other = (Shipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Shipment[ id=" + id + " ]";
    }

}
