/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
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
@Table(name = "intercompanytransactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntercompanyTransactions.findAll", query = "SELECT i FROM IntercompanyTransactions i"),
    @NamedQuery(name = "IntercompanyTransactions.findById", query = "SELECT i FROM IntercompanyTransactions i WHERE i.id = :id"),
    @NamedQuery(name = "IntercompanyTransactions.findByCompany", query = "SELECT i FROM IntercompanyTransactions i WHERE i.company = :company"),
    @NamedQuery(name = "IntercompanyTransactions.findByCustomerno", query = "SELECT i FROM IntercompanyTransactions i WHERE i.customerno = :customerno"),
    @NamedQuery(name = "IntercompanyTransactions.findByCustomer", query = "SELECT i FROM IntercompanyTransactions i WHERE i.customer = :customer"),
    @NamedQuery(name = "IntercompanyTransactions.findByPricingType", query = "SELECT i FROM IntercompanyTransactions i WHERE i.pricingType = :pricingType"),
    @NamedQuery(name = "IntercompanyTransactions.findBySalesman", query = "SELECT i FROM IntercompanyTransactions i WHERE i.salesman = :salesman"),
    @NamedQuery(name = "IntercompanyTransactions.findBySalesmanName", query = "SELECT i FROM IntercompanyTransactions i WHERE i.salesmanName = :salesmanName"),
    @NamedQuery(name = "IntercompanyTransactions.findByContacter", query = "SELECT i FROM IntercompanyTransactions i WHERE i.contacter = :contacter"),
    @NamedQuery(name = "IntercompanyTransactions.findByContacterName", query = "SELECT i FROM IntercompanyTransactions i WHERE i.contacterName = :contacterName"),
    @NamedQuery(name = "IntercompanyTransactions.findByPurchasingCompany", query = "SELECT i FROM IntercompanyTransactions i WHERE i.purchasingCompany = :purchasingCompany"),
    @NamedQuery(name = "IntercompanyTransactions.findByVendorno", query = "SELECT i FROM IntercompanyTransactions i WHERE i.vendorno = :vendorno"),
    @NamedQuery(name = "IntercompanyTransactions.findByVendor", query = "SELECT i FROM IntercompanyTransactions i WHERE i.vendor = :vendor"),
    @NamedQuery(name = "IntercompanyTransactions.findByStatus", query = "SELECT i FROM IntercompanyTransactions i WHERE i.status = :status ORDER BY i.sortid")})
public class IntercompanyTransactions extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customerno")
    private String customerno;
    @Size(max = 45)
    @Column(name = "customer")
    private String customer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pricingType")
    private String pricingType;
    @Size(max = 10)
    @Column(name = "salesman")
    private String salesman;
    @Size(max = 45)
    @Column(name = "salesmanName")
    private String salesmanName;
    @Size(max = 10)
    @Column(name = "contacter")
    private String contacter;
    @Size(max = 45)
    @Column(name = "contacterName")
    private String contacterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "purchasingCompany")
    private String purchasingCompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vendorno")
    private String vendorno;
    @Size(max = 45)
    @Column(name = "vendor")
    private String vendor;
    @Size(max = 8)
    @Column(name = "beginDate")
    private String beginDate;
    @Size(max = 10)
    @Column(name = "kind")
    private String kind;
    @Size(max = 45)
    @Column(name = "remark")
    private String remark;
    @Column(name = "sortid")
    private Integer sortid;

    public IntercompanyTransactions() {
    }

    public IntercompanyTransactions(String company, String customerno, String pricingType, String purchasingCompany, String vendorno) {
        this.company = company;
        this.customerno = customerno;
        this.pricingType = pricingType;
        this.purchasingCompany = purchasingCompany;
        this.vendorno = vendorno;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
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

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getContacterName() {
        return contacterName;
    }

    public void setContacterName(String contacterName) {
        this.contacterName = contacterName;
    }

    public String getPurchasingCompany() {
        return purchasingCompany;
    }

    public void setPurchasingCompany(String purchasingCompany) {
        this.purchasingCompany = purchasingCompany;
    }

    public String getVendorno() {
        return vendorno;
    }

    public void setVendorno(String vendorno) {
        this.vendorno = vendorno;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the sortid
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * @param sortid the sortid to set
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
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
        if (!(object instanceof IntercompanyTransactions)) {
            return false;
        }
        IntercompanyTransactions other = (IntercompanyTransactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.IntercompanyTransactions[ id=" + id + " ]";
    }

}
