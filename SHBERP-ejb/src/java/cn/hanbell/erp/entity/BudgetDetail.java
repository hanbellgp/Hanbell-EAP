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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "budgetdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetDetail.findAll", query = "SELECT b FROM BudgetDetail b"),
    @NamedQuery(name = "BudgetDetail.findByFacno", query = "SELECT b FROM BudgetDetail b WHERE b.budgetDetailPK.facno = :facno"),
    @NamedQuery(name = "BudgetDetail.findByBudgetid", query = "SELECT b FROM BudgetDetail b WHERE b.budgetDetailPK.budgetid = :budgetid"),
    @NamedQuery(name = "BudgetDetail.findByCenterid", query = "SELECT b FROM BudgetDetail b WHERE b.budgetDetailPK.centerid = :centerid"),
    @NamedQuery(name = "BudgetDetail.findBudgetDetail", query = "SELECT b FROM BudgetDetail b WHERE b.budgetDetailPK.facno = :facno AND b.budgetDetailPK.period = :period AND b.budgetDetailPK.centerid = :centerid AND b.budgetDetailPK.budgetacc = :budgetacc")})
public class BudgetDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BudgetDetailPK budgetDetailPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seq")
    private int seq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amts")
    private BigDecimal amts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addamts")
    private BigDecimal addamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decramts")
    private BigDecimal decramts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamts")
    private BigDecimal preamts;

    public BudgetDetail() {
    }

    public BudgetDetail(BudgetDetailPK budgetDetailPK) {
        this.budgetDetailPK = budgetDetailPK;
    }

    public BudgetDetail(BudgetDetailPK budgetDetailPK, int seq, BigDecimal amts, BigDecimal addamts, BigDecimal decramts, BigDecimal preamts) {
        this.budgetDetailPK = budgetDetailPK;
        this.seq = seq;
        this.amts = amts;
        this.addamts = addamts;
        this.decramts = decramts;
        this.preamts = preamts;
    }

    public BudgetDetail(String facno, String budgetid, String period, String centerid, String budgetacc, String protype) {
        this.budgetDetailPK = new BudgetDetailPK(facno, budgetid, period, centerid, budgetacc, protype);
    }

    public BudgetDetail(String facno, String budgetid, String period, String centerid, String budgetacc, String protype, int seq, BigDecimal amts, BigDecimal addamts, BigDecimal decramts, BigDecimal preamts) {
        this.budgetDetailPK = new BudgetDetailPK(facno, budgetid, period, centerid, budgetacc, protype);
        this.seq = seq;
        this.amts = amts;
        this.addamts = addamts;
        this.decramts = decramts;
        this.preamts = preamts;
    }

    public BudgetDetailPK getBudgetDetailPK() {
        return budgetDetailPK;
    }

    public void setBudgetDetailPK(BudgetDetailPK budgetDetailPK) {
        this.budgetDetailPK = budgetDetailPK;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public BigDecimal getAmts() {
        return amts;
    }

    public void setAmts(BigDecimal amts) {
        this.amts = amts;
    }

    public BigDecimal getAddamts() {
        return addamts;
    }

    public void setAddamts(BigDecimal addamts) {
        this.addamts = addamts;
    }

    public BigDecimal getDecramts() {
        return decramts;
    }

    public void setDecramts(BigDecimal decramts) {
        this.decramts = decramts;
    }

    public BigDecimal getPreamts() {
        return preamts;
    }

    public void setPreamts(BigDecimal preamts) {
        this.preamts = preamts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetDetailPK != null ? budgetDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetDetail)) {
            return false;
        }
        BudgetDetail other = (BudgetDetail) object;
        if ((this.budgetDetailPK == null && other.budgetDetailPK != null) || (this.budgetDetailPK != null && !this.budgetDetailPK.equals(other.budgetDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetDetail[ budgetDetailPK=" + budgetDetailPK + " ]";
    }

}
