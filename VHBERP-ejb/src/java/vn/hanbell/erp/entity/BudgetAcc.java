/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

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
@Table(name = "budgetacc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetAcc.findAll", query = "SELECT b FROM BudgetAcc b"),
    @NamedQuery(name = "BudgetAcc.findByFacno", query = "SELECT b FROM BudgetAcc b WHERE b.budgetAccPK.facno = :facno"),
    @NamedQuery(name = "BudgetAcc.findByAccno", query = "SELECT b FROM BudgetAcc b WHERE b.budgetAccPK.accno = :accno"),
    @NamedQuery(name = "BudgetAcc.findByAccname", query = "SELECT b FROM BudgetAcc b WHERE b.accname = :accname"),
    @NamedQuery(name = "BudgetAcc.findByAccclass", query = "SELECT b FROM BudgetAcc b WHERE b.accclass = :accclass"),
    @NamedQuery(name = "BudgetAcc.findByNeedcheck", query = "SELECT b FROM BudgetAcc b WHERE b.needcheck = :needcheck"),
    @NamedQuery(name = "BudgetAcc.findByState", query = "SELECT b FROM BudgetAcc b WHERE b.state = :state"),
    @NamedQuery(name = "BudgetAcc.findByNeeddetail", query = "SELECT b FROM BudgetAcc b WHERE b.needdetail = :needdetail")})
public class BudgetAcc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BudgetAccPK budgetAccPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "accname")
    private String accname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "accclass")
    private String accclass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "needcheck")
    private boolean needcheck;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private boolean state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "needdetail")
    private boolean needdetail;

    public BudgetAcc() {
    }

    public BudgetAcc(BudgetAccPK budgetAccPK) {
        this.budgetAccPK = budgetAccPK;
    }

    public BudgetAcc(BudgetAccPK budgetAccPK, String accname, String accclass, boolean needcheck, boolean state, boolean needdetail) {
        this.budgetAccPK = budgetAccPK;
        this.accname = accname;
        this.accclass = accclass;
        this.needcheck = needcheck;
        this.state = state;
        this.needdetail = needdetail;
    }

    public BudgetAcc(String facno, String accno) {
        this.budgetAccPK = new BudgetAccPK(facno, accno);
    }

    public BudgetAccPK getBudgetAccPK() {
        return budgetAccPK;
    }

    public void setBudgetAccPK(BudgetAccPK budgetAccPK) {
        this.budgetAccPK = budgetAccPK;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getAccclass() {
        return accclass;
    }

    public void setAccclass(String accclass) {
        this.accclass = accclass;
    }

    public boolean getNeedcheck() {
        return needcheck;
    }

    public void setNeedcheck(boolean needcheck) {
        this.needcheck = needcheck;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getNeeddetail() {
        return needdetail;
    }

    public void setNeeddetail(boolean needdetail) {
        this.needdetail = needdetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetAccPK != null ? budgetAccPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetAcc)) {
            return false;
        }
        BudgetAcc other = (BudgetAcc) object;
        if ((this.budgetAccPK == null && other.budgetAccPK != null) || (this.budgetAccPK != null && !this.budgetAccPK.equals(other.budgetAccPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.BudgetAcc[ budgetAccPK=" + budgetAccPK + " ]";
    }
    
}
