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
import javax.persistence.EmbeddedId;
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
 * @author C2082
 */
@Entity
@Table(name = "invsafqy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invsafqy.findAll", query = "SELECT i FROM Invsafqy i"),
    @NamedQuery(name = "Invsafqy.findByItnbr", query = "SELECT i FROM Invsafqy i WHERE i.invsafqyPK.itnbr = :itnbr"),
    @NamedQuery(name = "Invsafqy.findByFacno", query = "SELECT i FROM Invsafqy i WHERE i.invsafqyPK.facno = :facno"),
    @NamedQuery(name = "Invsafqy.findByProno", query = "SELECT i FROM Invsafqy i WHERE i.invsafqyPK.prono = :prono"),
    @NamedQuery(name = "Invsafqy.findBySafqy", query = "SELECT i FROM Invsafqy i WHERE i.safqy = :safqy"),
    @NamedQuery(name = "Invsafqy.findByOrderqy", query = "SELECT i FROM Invsafqy i WHERE i.orderqy = :orderqy"),
    @NamedQuery(name = "Invsafqy.findByEnoughqy", query = "SELECT i FROM Invsafqy i WHERE i.enoughqy = :enoughqy"),
    @NamedQuery(name = "Invsafqy.findByBuyer", query = "SELECT i FROM Invsafqy i WHERE i.buyer = :buyer"),
    @NamedQuery(name = "Invsafqy.findByAddcode", query = "SELECT i FROM Invsafqy i WHERE i.addcode = :addcode"),
    @NamedQuery(name = "Invsafqy.findByDlvsafqy", query = "SELECT i FROM Invsafqy i WHERE i.dlvsafqy = :dlvsafqy"),
    @NamedQuery(name = "Invsafqy.findByMaxqy", query = "SELECT i FROM Invsafqy i WHERE i.maxqy = :maxqy"),
    @NamedQuery(name = "Invsafqy.findByModman", query = "SELECT i FROM Invsafqy i WHERE i.modman = :modman"),
    @NamedQuery(name = "Invsafqy.findByModdate", query = "SELECT i FROM Invsafqy i WHERE i.moddate = :moddate")})
public class Invsafqy implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvsafqyPK invsafqyPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "safqy")
    private BigDecimal safqy;
    @Column(name = "orderqy")
    private BigDecimal orderqy;
    @Column(name = "enoughqy")
    private BigDecimal enoughqy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Column(name = "dlvsafqy")
    private BigDecimal dlvsafqy;
    @Column(name = "maxqy")
    private BigDecimal maxqy;
    @Size(max = 8)
    @Column(name = "modman")
    private String modman;
    @Column(name = "moddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moddate;
    @JoinColumn(name = "itnbr", referencedColumnName = "itnbr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invmas invmas;

    public Invsafqy() {
    }

    public Invsafqy(InvsafqyPK invsafqyPK) {
        this.invsafqyPK = invsafqyPK;
    }

    public Invsafqy(InvsafqyPK invsafqyPK, BigDecimal safqy, String buyer) {
        this.invsafqyPK = invsafqyPK;
        this.safqy = safqy;
        this.buyer = buyer;
    }

    public Invsafqy(String itnbr, String facno, String prono) {
        this.invsafqyPK = new InvsafqyPK(itnbr, facno, prono);
    }

    public InvsafqyPK getInvsafqyPK() {
        return invsafqyPK;
    }

    public void setInvsafqyPK(InvsafqyPK invsafqyPK) {
        this.invsafqyPK = invsafqyPK;
    }

    public BigDecimal getSafqy() {
        return safqy;
    }

    public void setSafqy(BigDecimal safqy) {
        this.safqy = safqy;
    }

    public BigDecimal getOrderqy() {
        return orderqy;
    }

    public void setOrderqy(BigDecimal orderqy) {
        this.orderqy = orderqy;
    }

    public BigDecimal getEnoughqy() {
        return enoughqy;
    }

    public void setEnoughqy(BigDecimal enoughqy) {
        this.enoughqy = enoughqy;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public BigDecimal getDlvsafqy() {
        return dlvsafqy;
    }

    public void setDlvsafqy(BigDecimal dlvsafqy) {
        this.dlvsafqy = dlvsafqy;
    }

    public BigDecimal getMaxqy() {
        return maxqy;
    }

    public void setMaxqy(BigDecimal maxqy) {
        this.maxqy = maxqy;
    }

    public String getModman() {
        return modman;
    }

    public void setModman(String modman) {
        this.modman = modman;
    }

    public Date getModdate() {
        return moddate;
    }

    public void setModdate(Date moddate) {
        this.moddate = moddate;
    }

    public Invmas getInvmas() {
        return invmas;
    }

    public void setInvmas(Invmas invmas) {
        this.invmas = invmas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invsafqyPK != null ? invsafqyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invsafqy)) {
            return false;
        }
        Invsafqy other = (Invsafqy) object;
        if ((this.invsafqyPK == null && other.invsafqyPK != null) || (this.invsafqyPK != null && !this.invsafqyPK.equals(other.invsafqyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invsafqy[ invsafqyPK=" + invsafqyPK + " ]";
    }
    
}
