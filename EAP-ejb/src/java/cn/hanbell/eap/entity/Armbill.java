/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
import java.util.Date;
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
@Table(name = "armbill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armbill.findAll", query = "SELECT a FROM Armbill a"),
    @NamedQuery(name = "Armbill.findById", query = "SELECT a FROM Armbill a WHERE a.id = :id"),
    @NamedQuery(name = "Armbill.findByCompany", query = "SELECT a FROM Armbill a WHERE a.company = :company"),
    @NamedQuery(name = "Armbill.findByFormid", query = "SELECT a FROM Armbill a WHERE a.formid = :formid"),
    @NamedQuery(name = "Armbill.findByFormdate", query = "SELECT a FROM Armbill a WHERE a.formdate = :formdate"),
    @NamedQuery(name = "Armbill.findByDeptno", query = "SELECT a FROM Armbill a WHERE a.deptno = :deptno"),
    @NamedQuery(name = "Armbill.findByDeptname", query = "SELECT a FROM Armbill a WHERE a.deptname = :deptname"),
    @NamedQuery(name = "Armbill.findByUserno", query = "SELECT a FROM Armbill a WHERE a.userno = :userno"),
    @NamedQuery(name = "Armbill.findByUsername", query = "SELECT a FROM Armbill a WHERE a.username = :username"),
    @NamedQuery(name = "Armbill.findByCustomerno", query = "SELECT a FROM Armbill a WHERE a.customerno = :customerno"),
    @NamedQuery(name = "Armbill.findByCustomer", query = "SELECT a FROM Armbill a WHERE a.customer = :customer"),
    @NamedQuery(name = "Armbill.findByRemark", query = "SELECT a FROM Armbill a WHERE a.remark = :remark"),
    @NamedQuery(name = "Armbill.findByStatus", query = "SELECT a FROM Armbill a WHERE a.status = :status")})
public class Armbill extends FormEntity {

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
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Size(max = 45)
    @Column(name = "contacter")
    private String contacter;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public Armbill() {
    }

    public Armbill(Integer id, String company, String formid, Date formdate, String customerno, String customer, String status) {
        this.id = id;
        this.company = company;
        this.formid = formid;
        this.formdate = formdate;
        this.customerno = customerno;
        this.customer = customer;
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the contacter
     */
    public String getContacter() {
        return contacter;
    }

    /**
     * @param contacter the contacter to set
     */
    public void setContacter(String contacter) {
        this.contacter = contacter;
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
        if (!(object instanceof Armbill)) {
            return false;
        }
        Armbill other = (Armbill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Armbill[ id=" + id + " ]";
    }

}
