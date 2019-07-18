/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "BudgetAcc.findByFacno", query = "SELECT b FROM BudgetAcc b WHERE b.facno = :facno"),
    @NamedQuery(name = "BudgetAcc.findByAccno", query = "SELECT b FROM BudgetAcc b WHERE b.accno = :accno"),
    @NamedQuery(name = "BudgetAcc.findByAccname", query = "SELECT b FROM BudgetAcc b WHERE b.accname = :accname"),
    @NamedQuery(name = "BudgetAcc.findByAccclass", query = "SELECT b FROM BudgetAcc b WHERE b.accclass = :accclass"),
    @NamedQuery(name = "BudgetAcc.findByNeedcheck", query = "SELECT b FROM BudgetAcc b WHERE b.needcheck = :needcheck"),
    //@NamedQuery(name = "BudgetAcc.findByState", query = "SELECT b FROM BudgetAcc b WHERE b.state = :state"),
    @NamedQuery(name = "BudgetAcc.findByNeeddetail", query = "SELECT b FROM BudgetAcc b WHERE b.needdetail = :needdetail")})
public class BudgetAcc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "accno")
    private String accno;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "facno")
    private String facno;

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
        hash += (accno != null ? accno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetAcc)) {
            return false;
        }
        BudgetAcc other = (BudgetAcc) object;
        if ((this.accno == null && other.accno != null) || (this.accno != null && !this.accno.equals(other.accno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetAcc[ budgetaccPK=" + accno + " ]";
    }

}
