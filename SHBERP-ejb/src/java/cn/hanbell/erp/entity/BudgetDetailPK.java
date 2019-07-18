/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C0160
 */
@Embeddable
public class BudgetDetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "budgetid")
    private String budgetid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "period")
    private String period;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "centerid")
    private String centerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "protype")
    private String protype;

    public BudgetDetailPK() {
    }

    public BudgetDetailPK(String facno, String budgetid, String period, String centerid, String budgetacc, String protype) {
        this.facno = facno;
        this.budgetid = budgetid;
        this.period = period;
        this.centerid = centerid;
        this.budgetacc = budgetacc;
        this.protype = protype;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(String budgetid) {
        this.budgetid = budgetid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (budgetid != null ? budgetid.hashCode() : 0);
        hash += (period != null ? period.hashCode() : 0);
        hash += (centerid != null ? centerid.hashCode() : 0);
        hash += (budgetacc != null ? budgetacc.hashCode() : 0);
        hash += (protype != null ? protype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetDetailPK)) {
            return false;
        }
        BudgetDetailPK other = (BudgetDetailPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.budgetid == null && other.budgetid != null) || (this.budgetid != null && !this.budgetid.equals(other.budgetid))) {
            return false;
        }
        if ((this.period == null && other.period != null) || (this.period != null && !this.period.equals(other.period))) {
            return false;
        }
        if ((this.centerid == null && other.centerid != null) || (this.centerid != null && !this.centerid.equals(other.centerid))) {
            return false;
        }
        if ((this.budgetacc == null && other.budgetacc != null) || (this.budgetacc != null && !this.budgetacc.equals(other.budgetacc))) {
            return false;
        }
        if ((this.protype == null && other.protype != null) || (this.protype != null && !this.protype.equals(other.protype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetDetailPK[ facno=" + facno + ", budgetid=" + budgetid + ", period=" + period + ", centerid=" + centerid + ", budgetacc=" + budgetacc + ", protype=" + protype + " ]";
    }
    
}
