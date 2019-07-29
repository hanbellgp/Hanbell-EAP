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
public class BudgetCenterPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "deptid")
    private String deptid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "protype")
    private String protype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "centerid")
    private String centerid;

    public BudgetCenterPK() {
    }

    public BudgetCenterPK(String facno, String deptid, String protype, String centerid) {
        this.facno = facno;
        this.deptid = deptid;
        this.protype = protype;
        this.centerid = centerid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (deptid != null ? deptid.hashCode() : 0);
        hash += (protype != null ? protype.hashCode() : 0);
        hash += (centerid != null ? centerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetCenterPK)) {
            return false;
        }
        BudgetCenterPK other = (BudgetCenterPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.deptid == null && other.deptid != null) || (this.deptid != null && !this.deptid.equals(other.deptid))) {
            return false;
        }
        if ((this.protype == null && other.protype != null) || (this.protype != null && !this.protype.equals(other.protype))) {
            return false;
        }
        if ((this.centerid == null && other.centerid != null) || (this.centerid != null && !this.centerid.equals(other.centerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.BudgetCenterPK[ facno=" + facno + ", deptid=" + deptid + ", protype=" + protype + ", centerid=" + centerid + " ]";
    }

}
