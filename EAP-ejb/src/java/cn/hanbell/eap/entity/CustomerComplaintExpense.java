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

/**
 *
 * @author C1879
 */
@Entity
@Table(name = "customercomplaintexpense")
@NamedQueries({
    @NamedQuery(name = "CustomerComplaintExpense.findAll", query = "SELECT c FROM CustomerComplaintExpense c")
    ,
    @NamedQuery(name = "CustomerComplaintExpense.findKfno", query = "SELECT c FROM CustomerComplaintExpense c WHERE c.kfno = :kfno ")
    ,
    @NamedQuery(name = "CustomerComplaintExpense.findKfnoAndType", query = "SELECT c FROM CustomerComplaintExpense c WHERE c.kfno = :kfno and c.type = :type ")
})
public class CustomerComplaintExpense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sources")
    private String sources;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 20)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 10)
    @Column(name = "userno")
    private String userno;
    @Size(max = 10)
    @Column(name = "userna")
    private String userna;
    @Size(max = 10)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 20)
    @Column(name = "deptna")
    private String deptna;
    @Size(max = 20)
    @Column(name = "serialno")
    private String serialno;
    @Size(max = 10)
    @Column(name = "occurdate")
    private String occurdate;
    @Size(max = 20)
    @Column(name = "expensetype")
    private String expensetype;
    @Size(max = 45)
    @Column(name = "custom1")
    private String custom1;
    @Size(max = 45)
    @Column(name = "custom2")
    private String custom2;
    @Size(max = 45)
    @Column(name = "custom3")
    private String custom3;
    @Size(max = 45)
    @Column(name = "custom4")
    private String custom4;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "expense")
    private BigDecimal expense;
    @Size(max = 400)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 45)
    @Column(name = "sourcesno")
    private String sourcesno;
    @Size(max = 10)
    @Column(name = "sourcesdate")
    private String sourcesdate;
    @Size(max = 40)
    @Column(name = "remark2")
    private String remark2;

    public CustomerComplaintExpense() {
        this.expense = BigDecimal.ZERO;
    }

    public CustomerComplaintExpense(Integer id) {
        this.id = id;
    }

    public CustomerComplaintExpense(Integer id, String type, String sources, String kfno) {
        this.id = id;
        this.type = type;
        this.sources = sources;
        this.kfno = kfno;
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

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUserna() {
        return userna;
    }

    public void setUserna(String userna) {
        this.userna = userna;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptna() {
        return deptna;
    }

    public void setDeptna(String deptna) {
        this.deptna = deptna;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getOccurdate() {
        return occurdate;
    }

    public void setOccurdate(String occurdate) {
        this.occurdate = occurdate;
    }

    public String getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getSourcesno() {
        return sourcesno;
    }

    public void setSourcesno(String sourcesno) {
        this.sourcesno = sourcesno;
    }

    public String getSourcesdate() {
        return sourcesdate;
    }

    public void setSourcesdate(String sourcesdate) {
        this.sourcesdate = sourcesdate;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
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
        if (!(object instanceof CustomerComplaintExpense)) {
            return false;
        }
        CustomerComplaintExpense other = (CustomerComplaintExpense) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.CustomerComplaintExpense[ id=" + id + " ]";
    }

}
