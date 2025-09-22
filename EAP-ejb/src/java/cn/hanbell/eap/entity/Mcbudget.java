/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "mcbudget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mcbudget.findAll", query = "SELECT m FROM Mcbudget m"),
    @NamedQuery(name = "Mcbudget.findById", query = "SELECT m FROM Mcbudget m WHERE m.id = :id"),
    @NamedQuery(name = "Mcbudget.findByProperties", query = "SELECT m FROM Mcbudget m WHERE m.type = :type AND m.srcno = :srcno AND m.facno = :facno "
            + " AND m.period = :period AND m.centerid = :centerid AND  m.budgetacc = :budgetacc"),
    @NamedQuery(name = "Mcbudget.findByProperties2", query = "SELECT m FROM Mcbudget m WHERE m.type = :type AND m.srcno = :srcno AND m.facno = :facno "
            + " AND m.centerid = :centerid AND  m.budgetacc = :budgetacc"),
    @NamedQuery(name = "Mcbudget.findBySrcno", query = "SELECT m FROM Mcbudget m WHERE m.srcno = :srcno"),
    @NamedQuery(name = "Mcbudget.findByCrmno", query = "SELECT m FROM Mcbudget m WHERE m.crmno = :crmno"),
    @NamedQuery(name = "Mcbudget.findByFacno", query = "SELECT m FROM Mcbudget m WHERE m.facno = :facno"),
    @NamedQuery(name = "Mcbudget.findByPeriod", query = "SELECT m FROM Mcbudget m WHERE m.period = :period"),
    @NamedQuery(name = "Mcbudget.findByCenterid", query = "SELECT m FROM Mcbudget m WHERE m.centerid = :centerid"),
    @NamedQuery(name = "Mcbudget.findByBudgetacc", query = "SELECT m FROM Mcbudget m WHERE m.budgetacc = :budgetacc"),
    @NamedQuery(name = "Mcbudget.findByPreamts", query = "SELECT m FROM Mcbudget m WHERE m.preamts = :preamts"),
    @NamedQuery(name = "Mcbudget.findByLoanNo", query = "SELECT m FROM Mcbudget m WHERE m.loanNo = :loanNo"),
    @NamedQuery(name = "Mcbudget.findByStatus", query = "SELECT m FROM Mcbudget m WHERE m.status = :status")})
public class Mcbudget implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 30)
    @Column(name = "crmno")
    private String crmno;
    @Size(max = 30)
    @Column(name = "crmtype")
    private String crmtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "facno")
    private String facno;
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
    @Size(min = 1, max = 30)
    @Column(name = "budgetacc")
    private String budgetacc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamts")
    private BigDecimal preamts;
    @Size(max = 30)
    @Column(name = "loanNo")
    private String loanNo;
    @Column(name = "status")
    private Integer status;

    public Mcbudget() {
    }

    public Mcbudget(Integer id) {
        this.id = id;
    }

    public Mcbudget(Integer id, String type, String srcno, String facno, String period, String centerid, String budgetacc, BigDecimal preamts) {
        this.id = id;
        this.type = type;
        this.srcno = srcno;
        this.facno = facno;
        this.period = period;
        this.centerid = centerid;
        this.budgetacc = budgetacc;
        this.preamts = preamts;
    }

    public Mcbudget(String type, String srcno, String facno, String period, String centerid, String budgetacc) {
        this.type = type;
        this.srcno = srcno;
        this.facno = facno;
        this.period = period;
        this.centerid = centerid;
        this.budgetacc = budgetacc;
    }

    public Mcbudget(String type, String srcno, String facno, String period, String centerid, String budgetacc, BigDecimal preamts) {
        this.type = type;
        this.srcno = srcno;
        this.facno = facno;
        this.period = period;
        this.centerid = centerid;
        this.budgetacc = budgetacc;
        this.preamts = preamts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getCrmno() {
        return crmno;
    }

    public void setCrmno(String crmno) {
        this.crmno = crmno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
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

    public BigDecimal getPreamts() {
        return preamts;
    }

    public void setPreamts(BigDecimal preamts) {
        this.preamts = preamts;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mcbudget)) {
            return false;
        }
        Mcbudget other = (Mcbudget) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Mcbudget[ id=" + id + " ]";
    }

    public String getCrmtype() {
        return crmtype;
    }

    public void setCrmtype(String crmtype) {
        this.crmtype = crmtype;
    }

}
