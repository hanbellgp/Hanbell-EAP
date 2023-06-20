/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
@Table(name = "VH_TV005_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV005Detail.findAll", query = "SELECT v FROM VHTV005Detail v"),
    @NamedQuery(name = "VHTV005Detail.findByPayqty", query = "SELECT v FROM VHTV005Detail v WHERE v.payqty = :payqty"),
    @NamedQuery(name = "VHTV005Detail.findByCenterid", query = "SELECT v FROM VHTV005Detail v WHERE v.centerid = :centerid"),
    @NamedQuery(name = "VHTV005Detail.findByCmpCenterid", query = "SELECT v FROM VHTV005Detail v WHERE v.cmpCenterid = :cmpCenterid"),
    @NamedQuery(name = "VHTV005Detail.findByAcpamtfs", query = "SELECT v FROM VHTV005Detail v WHERE v.acpamtfs = :acpamtfs"),
    @NamedQuery(name = "VHTV005Detail.findByDmark", query = "SELECT v FROM VHTV005Detail v WHERE v.dmark = :dmark"),
    @NamedQuery(name = "VHTV005Detail.findByComApamtfs", query = "SELECT v FROM VHTV005Detail v WHERE v.comApamtfs = :comApamtfs"),
    @NamedQuery(name = "VHTV005Detail.findByOid", query = "SELECT v FROM VHTV005Detail v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHTV005Detail.findByApdsc", query = "SELECT v FROM VHTV005Detail v WHERE v.apdsc = :apdsc"),
    @NamedQuery(name = "VHTV005Detail.findByBudgetacc", query = "SELECT v FROM VHTV005Detail v WHERE v.budgetacc = :budgetacc"),
    @NamedQuery(name = "VHTV005Detail.findByBilno", query = "SELECT v FROM VHTV005Detail v WHERE v.bilno = :bilno"),
    @NamedQuery(name = "VHTV005Detail.findByTemamtfs", query = "SELECT v FROM VHTV005Detail v WHERE v.temamtfs = :temamtfs"),
    @NamedQuery(name = "VHTV005Detail.findByCmpBudgetacc", query = "SELECT v FROM VHTV005Detail v WHERE v.cmpBudgetacc = :cmpBudgetacc"),
    @NamedQuery(name = "VHTV005Detail.findByComApamt", query = "SELECT v FROM VHTV005Detail v WHERE v.comApamt = :comApamt"),
    @NamedQuery(name = "VHTV005Detail.findByAcpamt", query = "SELECT v FROM VHTV005Detail v WHERE v.acpamt = :acpamt"),
    @NamedQuery(name = "VHTV005Detail.findByTemamt", query = "SELECT v FROM VHTV005Detail v WHERE v.temamt = :temamt"),
    @NamedQuery(name = "VHTV005Detail.findByFormSerialNumber", query = "SELECT v FROM VHTV005Detail v WHERE v.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "VHTV005Detail.findBySeq", query = "SELECT v FROM VHTV005Detail v WHERE v.seq = :seq"),
    @NamedQuery(name = "VHTV005Detail.findByCoin", query = "SELECT v FROM VHTV005Detail v WHERE v.coin = :coin"),
    @NamedQuery(name = "VHTV005Detail.findByRatio", query = "SELECT v FROM VHTV005Detail v WHERE v.ratio = :ratio")})
public class VHTV005Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "payqty")
    private String payqty;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "cmp_centerid")
    private String cmpCenterid;
    @Size(max = 255)
    @Column(name = "acpamtfs")
    private String acpamtfs;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "com_apamtfs")
    private String comApamtfs;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "apdsc")
    private String apdsc;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "bilno")
    private String bilno;
    @Size(max = 255)
    @Column(name = "temamtfs")
    private String temamtfs;
    @Size(max = 255)
    @Column(name = "cmp_budgetacc")
    private String cmpBudgetacc;
    @Size(max = 255)
    @Column(name = "com_apamt")
    private String comApamt;
    @Size(max = 255)
    @Column(name = "acpamt")
    private String acpamt;
    @Size(max = 255)
    @Column(name = "temamt")
    private String temamt;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;

    public VHTV005Detail() {
    }

    public VHTV005Detail(String oid) {
        this.oid = oid;
    }

    public String getPayqty() {
        return payqty;
    }

    public void setPayqty(String payqty) {
        this.payqty = payqty;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getCmpCenterid() {
        return cmpCenterid;
    }

    public void setCmpCenterid(String cmpCenterid) {
        this.cmpCenterid = cmpCenterid;
    }

    public String getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(String acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getComApamtfs() {
        return comApamtfs;
    }

    public void setComApamtfs(String comApamtfs) {
        this.comApamtfs = comApamtfs;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(String temamtfs) {
        this.temamtfs = temamtfs;
    }

    public String getCmpBudgetacc() {
        return cmpBudgetacc;
    }

    public void setCmpBudgetacc(String cmpBudgetacc) {
        this.cmpBudgetacc = cmpBudgetacc;
    }

    public String getComApamt() {
        return comApamt;
    }

    public void setComApamt(String comApamt) {
        this.comApamt = comApamt;
    }

    public String getAcpamt() {
        return acpamt;
    }

    public void setAcpamt(String acpamt) {
        this.acpamt = acpamt;
    }

    public String getTemamt() {
        return temamt;
    }

    public void setTemamt(String temamt) {
        this.temamt = temamt;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VHTV005Detail)) {
            return false;
        }
        VHTV005Detail other = (VHTV005Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV005Detail[ oid=" + oid + " ]";
    }
    
}
