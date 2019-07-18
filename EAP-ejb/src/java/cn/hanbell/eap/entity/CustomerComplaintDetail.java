/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * 客诉成本领退料明细
 */
@Entity
@Table(name = "customercomplaintdetail")
@NamedQueries({
    @NamedQuery(name = "CustomerComplaintDetail.findAll", query = "SELECT c FROM CustomerComplaintDetail c")
    ,
    @NamedQuery(name = "CustomerComplaintDetail.findKfno", query = "SELECT c FROM CustomerComplaintDetail c WHERE c.kfno = :kfno")
})
public class CustomerComplaintDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 30)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 10)
    @Column(name = "trtype")
    private String trtype;
    @Size(max = 10)
    @Column(name = "typedsc")
    private String typedsc;
    @Size(max = 30)
    @Column(name = "trno")
    private String trno;
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Column(name = "trseq")
    private Integer trseq;
    @Size(max = 40)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 50)
    @Column(name = "itdsc")
    private String itdsc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "trnqy1")
    private BigDecimal trnqy1;
    @Size(max = 10)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Column(name = "tramt")
    private BigDecimal tramt;
    @Size(max = 50)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 50)
    @Column(name = "remark2")
    private String remark2;

    public CustomerComplaintDetail() {
        this.tramt = BigDecimal.ZERO;
    }

    public CustomerComplaintDetail(Integer id) {
        this.id = id;
    }

    public CustomerComplaintDetail(Integer id, String kfno) {
        this.id = id;
        this.kfno = kfno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getTypedsc() {
        return typedsc;
    }

    public void setTypedsc(String typedsc) {
        this.typedsc = typedsc;
    }

    public String getTrno() {
        return trno;
    }

    public void setTrno(String trno) {
        this.trno = trno;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public Integer getTrseq() {
        return trseq;
    }

    public void setTrseq(Integer trseq) {
        this.trseq = trseq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public BigDecimal getTrnqy1() {
        return trnqy1;
    }

    public void setTrnqy1(BigDecimal trnqy1) {
        this.trnqy1 = trnqy1;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public BigDecimal getTramt() {
        return tramt;
    }

    public void setTramt(BigDecimal tramt) {
        this.tramt = tramt;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerComplaintDetail)) {
            return false;
        }
        CustomerComplaintDetail other = (CustomerComplaintDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.CuscomPlaintDetail[ id=" + id + " ]";
    }

}
