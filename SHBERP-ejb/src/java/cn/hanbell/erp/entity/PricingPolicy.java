/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pricingpolicy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PricingPolicy.findAll", query = "SELECT p FROM PricingPolicy p"),
    @NamedQuery(name = "PricingPolicy.findByPricingId", query = "SELECT p FROM PricingPolicy p WHERE p.pricingid = :pricingid AND p.status='V' "),
    @NamedQuery(name = "PricingPolicy.findByPricingtype", query = "SELECT p FROM PricingPolicy p WHERE p.pricingtype = :pricingtype"),
    @NamedQuery(name = "PricingPolicy.findByDeptid", query = "SELECT p FROM PricingPolicy p WHERE p.deptid = :deptid"),
    @NamedQuery(name = "PricingPolicy.findByStatus", query = "SELECT p FROM PricingPolicy p WHERE p.status = :status")})
public class PricingPolicy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pricingid")
    private String pricingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricingdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pricingdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pricingtype")
    private String pricingtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "daybegin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daybegin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dayend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dayend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "deptid")
    private String deptid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "currency")
    private String currency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "exchange")
    private BigDecimal exchange;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Size(max = 10)
    @Column(name = "creator")
    private String creator;
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Size(max = 10)
    @Column(name = "optuser")
    private String optuser;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;
    @Size(max = 10)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;

    public PricingPolicy() {
    }

    public PricingPolicy(String pricingid) {
        this.pricingid = pricingid;
    }

    public PricingPolicy(String pricingid, Date pricingdate, String pricingtype, Date daybegin, Date dayend, String deptid, String currency, BigDecimal exchange, Character status, String facno) {
        this.pricingid = pricingid;
        this.pricingdate = pricingdate;
        this.pricingtype = pricingtype;
        this.daybegin = daybegin;
        this.dayend = dayend;
        this.deptid = deptid;
        this.currency = currency;
        this.exchange = exchange;
        this.status = status;
        this.facno = facno;
    }

    public String getPricingid() {
        return pricingid;
    }

    public void setPricingid(String pricingid) {
        this.pricingid = pricingid;
    }

    public Date getPricingdate() {
        return pricingdate;
    }

    public void setPricingdate(Date pricingdate) {
        this.pricingdate = pricingdate;
    }

    public String getPricingtype() {
        return pricingtype;
    }

    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }

    public Date getDaybegin() {
        return daybegin;
    }

    public void setDaybegin(Date daybegin) {
        this.daybegin = daybegin;
    }

    public Date getDayend() {
        return dayend;
    }

    public void setDayend(Date dayend) {
        this.dayend = dayend;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getExchange() {
        return exchange;
    }

    public void setExchange(BigDecimal exchange) {
        this.exchange = exchange;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingid != null ? pricingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingPolicy)) {
            return false;
        }
        PricingPolicy other = (PricingPolicy) object;
        if ((this.pricingid == null && other.pricingid != null) || (this.pricingid != null && !this.pricingid.equals(other.pricingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.shb.erp.PricingPolicy[ pricingid=" + pricingid + " ]";
    }
    
}
