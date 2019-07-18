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
 * @author Administrator
 */
@Embeddable
public class BudgetCenterAccDetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "facno")
    private String facno;
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

    public BudgetCenterAccDetailPK() {
    }

    public BudgetCenterAccDetailPK(String facno, String centerid, String budgetacc) {
        this.facno = facno;
        this.centerid = centerid;
        this.budgetacc = budgetacc;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (centerid != null ? centerid.hashCode() : 0);
        hash += (budgetacc != null ? budgetacc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetCenterAccDetailPK)) {
            return false;
        }
        BudgetCenterAccDetailPK other = (BudgetCenterAccDetailPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.centerid == null && other.centerid != null) || (this.centerid != null && !this.centerid.equals(other.centerid))) {
            return false;
        }
        if ((this.budgetacc == null && other.budgetacc != null) || (this.budgetacc != null && !this.budgetacc.equals(other.budgetacc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetcenteraccdetailPK[ facno=" + facno + ", centerid=" + centerid + ", budgetacc=" + budgetacc + " ]";
    }
    
}
