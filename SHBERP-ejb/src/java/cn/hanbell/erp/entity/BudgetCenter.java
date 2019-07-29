/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
 * @author Administrator
 */
@Entity
@Table(name = "budgetcenter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetCenter.findAll", query = "SELECT b FROM BudgetCenter b"),
    @NamedQuery(name = "BudgetCenter.findByFacno", query = "SELECT b FROM BudgetCenter b WHERE b.budgetCenterPK.facno = :facno"),
    @NamedQuery(name = "BudgetCenter.findByDeptid", query = "SELECT b FROM BudgetCenter b WHERE b.budgetCenterPK.deptid = :deptid"),
    @NamedQuery(name = "BudgetCenter.findByDeptname", query = "SELECT b FROM BudgetCenter b WHERE b.deptname = :deptname"),
    @NamedQuery(name = "BudgetCenter.findByProtype", query = "SELECT b FROM BudgetCenter b WHERE b.budgetCenterPK.protype = :protype"),
    @NamedQuery(name = "BudgetCenter.findByCenterid", query = "SELECT b FROM BudgetCenter b WHERE b.budgetCenterPK.centerid = :centerid"),
    @NamedQuery(name = "BudgetCenter.findByNeedcheck", query = "SELECT b FROM BudgetCenter b WHERE b.needcheck = :needcheck")})
public class BudgetCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BudgetCenterPK budgetCenterPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "deptname")
    private String deptname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "needcheck")
    private boolean needcheck;

    public BudgetCenter() {
    }

    public BudgetCenter(BudgetCenterPK budgetCenterPK) {
        this.budgetCenterPK = budgetCenterPK;
    }

    public BudgetCenter(BudgetCenterPK budgetCenterPK, String deptname, boolean needcheck) {
        this.budgetCenterPK = budgetCenterPK;
        this.deptname = deptname;
        this.needcheck = needcheck;
    }

    public BudgetCenter(String facno, String deptid, String protype, String centerid) {
        this.budgetCenterPK = new BudgetCenterPK(facno, deptid, protype, centerid);
    }

    public BudgetCenterPK getBudgetCenterPK() {
        return budgetCenterPK;
    }

    public void setBudgetCenterPK(BudgetCenterPK budgetCenterPK) {
        this.budgetCenterPK = budgetCenterPK;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public boolean getNeedcheck() {
        return needcheck;
    }

    public void setNeedcheck(boolean needcheck) {
        this.needcheck = needcheck;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetCenterPK != null ? budgetCenterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetCenter)) {
            return false;
        }
        BudgetCenter other = (BudgetCenter) object;
        if ((this.budgetCenterPK == null && other.budgetCenterPK != null) || (this.budgetCenterPK != null && !this.budgetCenterPK.equals(other.budgetCenterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetCenter[ budgetCenterPK=" + budgetCenterPK + " ]";
    }

}
