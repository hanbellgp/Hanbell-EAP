/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "pricing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pricing.findAll", query = "SELECT p FROM Pricing p"),
    @NamedQuery(name = "Pricing.findByPricingid", query = "SELECT p FROM Pricing p WHERE p.pricingPK.pricingid = :pricingid"),
    @NamedQuery(name = "Pricing.findByItnbr", query = "SELECT p FROM Pricing p WHERE p.pricingPK.itnbr = :itnbr"),
    @NamedQuery(name = "Pricing.findByItemno", query = "SELECT p FROM Pricing p WHERE p.pricingPK.itemno = :itemno"),
    @NamedQuery(name = "Pricing.findByItnbrAndCategory", query = "SELECT p FROM Pricing p WHERE p.pricingPK.itnbr =:itnbr AND p.itemdesc = :category")})
public class Pricing implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PricingPK pricingPK;
    @Size(max = 100)
    @Column(name = "itemdesc")
    private String itemdesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price09")
    private BigDecimal price09;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price08")
    private BigDecimal price08;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price07")
    private BigDecimal price07;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price06")
    private BigDecimal price06;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price05")
    private BigDecimal price05;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price04")
    private BigDecimal price04;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price03")
    private BigDecimal price03;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price02")
    private BigDecimal price02;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price01")
    private BigDecimal price01;

    public Pricing() {
    }

    public Pricing(PricingPK pricingPK) {
        this.pricingPK = pricingPK;
    }

    public Pricing(PricingPK pricingPK, BigDecimal price09, BigDecimal price08, BigDecimal price07, BigDecimal price06, BigDecimal price05, BigDecimal price04, BigDecimal price03, BigDecimal price02, BigDecimal price01) {
        this.pricingPK = pricingPK;
        this.price09 = price09;
        this.price08 = price08;
        this.price07 = price07;
        this.price06 = price06;
        this.price05 = price05;
        this.price04 = price04;
        this.price03 = price03;
        this.price02 = price02;
        this.price01 = price01;
    }

    public Pricing(String pricingid, String itnbr, String itemno) {
        this.pricingPK = new PricingPK(pricingid, itnbr, itemno);
    }

    public PricingPK getPricingPK() {
        return pricingPK;
    }

    public void setPricingPK(PricingPK pricingPK) {
        this.pricingPK = pricingPK;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public BigDecimal getPrice09() {
        return price09;
    }

    public void setPrice09(BigDecimal price09) {
        this.price09 = price09;
    }

    public BigDecimal getPrice08() {
        return price08;
    }

    public void setPrice08(BigDecimal price08) {
        this.price08 = price08;
    }

    public BigDecimal getPrice07() {
        return price07;
    }

    public void setPrice07(BigDecimal price07) {
        this.price07 = price07;
    }

    public BigDecimal getPrice06() {
        return price06;
    }

    public void setPrice06(BigDecimal price06) {
        this.price06 = price06;
    }

    public BigDecimal getPrice05() {
        return price05;
    }

    public void setPrice05(BigDecimal price05) {
        this.price05 = price05;
    }

    public BigDecimal getPrice04() {
        return price04;
    }

    public void setPrice04(BigDecimal price04) {
        this.price04 = price04;
    }

    public BigDecimal getPrice03() {
        return price03;
    }

    public void setPrice03(BigDecimal price03) {
        this.price03 = price03;
    }

    public BigDecimal getPrice02() {
        return price02;
    }

    public void setPrice02(BigDecimal price02) {
        this.price02 = price02;
    }

    public BigDecimal getPrice01() {
        return price01;
    }

    public void setPrice01(BigDecimal price01) {
        this.price01 = price01;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingPK != null ? pricingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pricing)) {
            return false;
        }
        Pricing other = (Pricing) object;
        if ((this.pricingPK == null && other.pricingPK != null) || (this.pricingPK != null && !this.pricingPK.equals(other.pricingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.shb.erp.Pricing[ pricingPK=" + pricingPK + " ]";
    }
    
}
