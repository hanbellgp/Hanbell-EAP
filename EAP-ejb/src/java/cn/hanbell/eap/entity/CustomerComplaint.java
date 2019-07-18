/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C1879
 * 客诉成本单
 */
@Entity
@Table(name = "customercomplaint")
@NamedQueries({
    @NamedQuery(name = "CustomerComplaint.findAll", query = "SELECT c FROM CustomerComplaint c")
    ,
    @NamedQuery(name = "CustomerComplaint.findKfno", query = "SELECT c FROM CustomerComplaint c WHERE c.kfno = :kfno ")
    ,
    @NamedQuery(name = "CustomerComplaint.findOverdate", query = "SELECT c FROM CustomerComplaint c WHERE c.overdate >= :begin AND  c.overdate <= :end ORDER BY c.overdate ASC  ")
})
public class CustomerComplaint extends BaseEntity {
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 20)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 20)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 20)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 10)
    @Column(name = "n_code_DC")
    private String ncodeDC;
    @Size(max = 10)
    @Column(name = "n_code_CD")
    private String ncodeCD;
    @Size(max = 10)
    @Column(name = "n_code_DD")
    private String ncodeDD;
    @Size(max = 20)
    @Column(name = "dutydeptno")
    private String dutydeptno;
    @Size(max = 20)
    @Column(name = "dutydeptna")
    private String dutydeptna;
    @Size(max = 10)
    @Column(name = "dutyrate")
    private String dutyrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date overdate;
    @Size(max = 400)
    @Column(name = "badwhy")
    private String badwhy;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "clcost")
    private BigDecimal clcost;
    @Column(name = "rgcost")
    private BigDecimal rgcost;
    @Column(name = "yscost")
    private BigDecimal yscost;
    @Column(name = "clvcost")
    private BigDecimal clvcost;
    @Column(name = "reparations")
    private BigDecimal reparations;
    @Column(name = "other")
    private BigDecimal other;
    @Size(max = 45)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 45)
    @Column(name = "remark2")
    private String remark2;
    @Size(max = 45)
    @Column(name = "remark3")
    private String remark3;

    public CustomerComplaint() {
        this.clcost = BigDecimal.ZERO;
        this.rgcost = BigDecimal.ZERO;
        this.yscost = BigDecimal.ZERO;
        this.clvcost = BigDecimal.ZERO;
        this.reparations = BigDecimal.ZERO;
        this.other = BigDecimal.ZERO;
    }

    public CustomerComplaint(Integer id) {
        this.id = id;
    }

    public CustomerComplaint(Integer id, String kfno, Date credate, Date overdate) {
        this.id = id;
        this.kfno = kfno;
        this.credate = credate;
        this.overdate = overdate;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getNcodeDC() {
        return ncodeDC;
    }

    public void setNcodeDC(String ncodeDC) {
        this.ncodeDC = ncodeDC;
    }

    public String getNcodeCD() {
        return ncodeCD;
    }

    public void setNcodeCD(String ncodeCD) {
        this.ncodeCD = ncodeCD;
    }

    public String getNcodeDD() {
        return ncodeDD;
    }

    public void setNcodeDD(String ncodeDD) {
        this.ncodeDD = ncodeDD;
    }

    public String getDutydeptno() {
        return dutydeptno;
    }

    public void setDutydeptno(String dutydeptno) {
        this.dutydeptno = dutydeptno;
    }

    public String getDutydeptna() {
        return dutydeptna;
    }

    public void setDutydeptna(String dutydeptna) {
        this.dutydeptna = dutydeptna;
    }

    public String getDutyrate() {
        return dutyrate;
    }

    public void setDutyrate(String dutyrate) {
        this.dutyrate = dutyrate;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Date getOverdate() {
        return overdate;
    }

    public void setOverdate(Date overdate) {
        this.overdate = overdate;
    }

    public String getBadwhy() {
        return badwhy;
    }

    public void setBadwhy(String badwhy) {
        this.badwhy = badwhy;
    }

    public BigDecimal getClcost() {
        return clcost;
    }

    public void setClcost(BigDecimal clcost) {
        this.clcost = clcost;
    }

    public BigDecimal getRgcost() {
        return rgcost;
    }

    public void setRgcost(BigDecimal rgcost) {
        this.rgcost = rgcost;
    }

    public BigDecimal getYscost() {
        return yscost;
    }

    public void setYscost(BigDecimal yscost) {
        this.yscost = yscost;
    }

    public BigDecimal getClvcost() {
        return clvcost;
    }

    public void setClvcost(BigDecimal clvcost) {
        this.clvcost = clvcost;
    }

    public BigDecimal getReparations() {
        return reparations;
    }

    public void setReparations(BigDecimal reparations) {
        this.reparations = reparations;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
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
        if (!(object instanceof CustomerComplaint)) {
            return false;
        }
        CustomerComplaint other = (CustomerComplaint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.CuscomPlaint[ id=" + id + " ]";
    }

}
