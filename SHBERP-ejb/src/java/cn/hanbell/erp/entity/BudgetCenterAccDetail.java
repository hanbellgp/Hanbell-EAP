/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "budgetcenteraccdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetCenterAccDetail.findAll", query = "SELECT b FROM BudgetCenterAccDetail b"),
    @NamedQuery(name = "BudgetCenterAccDetail.findByFacno", query = "SELECT b FROM BudgetCenterAccDetail b WHERE b.budgetcenteraccdetailPK.facno = :facno"),
    @NamedQuery(name = "BudgetCenterAccDetail.findByCenterid", query = "SELECT b FROM BudgetCenterAccDetail b WHERE b.budgetcenteraccdetailPK.centerid = :centerid"),
    @NamedQuery(name = "BudgetCenterAccDetail.findByBudgetacc", query = "SELECT b FROM BudgetCenterAccDetail b WHERE b.budgetcenteraccdetailPK.budgetacc = :budgetacc")})
public class BudgetCenterAccDetail implements Serializable {

    @ManyToOne(optional = true)
    @JoinColumns({
        @JoinColumn(name = "budgetacc", referencedColumnName = "accno", insertable = false, updatable = false)
    })
    private BudgetAcc budgetAccount;
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BudgetCenterAccDetailPK budgetcenteraccdetailPK;

    public BudgetCenterAccDetail() {
    }

    public BudgetCenterAccDetail(BudgetCenterAccDetailPK budgetcenteraccdetailPK) {
        this.budgetcenteraccdetailPK = budgetcenteraccdetailPK;
    }

    public BudgetCenterAccDetail(String facno, String centerid, String budgetacc) {
        this.budgetcenteraccdetailPK = new BudgetCenterAccDetailPK(facno, centerid, budgetacc);
    }

    public BudgetCenterAccDetailPK getBudgetCenterAccDetailPK() {
        return budgetcenteraccdetailPK;
    }

    public void setBudgetCenterAccDetailPK(BudgetCenterAccDetailPK budgetcenteraccdetailPK) {
        this.budgetcenteraccdetailPK = budgetcenteraccdetailPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetcenteraccdetailPK != null ? budgetcenteraccdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetCenterAccDetail)) {
            return false;
        }
        BudgetCenterAccDetail other = (BudgetCenterAccDetail) object;
        if ((this.budgetcenteraccdetailPK == null && other.budgetcenteraccdetailPK != null) || (this.budgetcenteraccdetailPK != null && !this.budgetcenteraccdetailPK.equals(other.budgetcenteraccdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetCenterAccDetail[ budgetcenteraccdetailPK=" + budgetcenteraccdetailPK + " ]";
    }

    public BudgetAcc getBudgetAccount() {
        return budgetAccount;
    }

    public void setBudgetAccount(BudgetAcc budgetAccount) {
        this.budgetAccount = budgetAccount;
    }

}
