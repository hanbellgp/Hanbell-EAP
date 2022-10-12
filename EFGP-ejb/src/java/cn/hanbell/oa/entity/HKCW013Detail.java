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
@Table(name = "HK_CW013_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW013Detail.findAll", query = "SELECT h FROM HKCW013Detail h"),
    @NamedQuery(name = "HKCW013Detail.findByCenterid", query = "SELECT h FROM HKCW013Detail h WHERE h.centerid = :centerid"),
    @NamedQuery(name = "HKCW013Detail.findByCmpCenterid", query = "SELECT h FROM HKCW013Detail h WHERE h.cmpCenterid = :cmpCenterid"),
    @NamedQuery(name = "HKCW013Detail.findByDmark", query = "SELECT h FROM HKCW013Detail h WHERE h.dmark = :dmark"),
    @NamedQuery(name = "HKCW013Detail.findByOid", query = "SELECT h FROM HKCW013Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW013Detail.findByApdsc", query = "SELECT h FROM HKCW013Detail h WHERE h.apdsc = :apdsc"),
    @NamedQuery(name = "HKCW013Detail.findByBudgetacc", query = "SELECT h FROM HKCW013Detail h WHERE h.budgetacc = :budgetacc"),
    @NamedQuery(name = "HKCW013Detail.findByBilno", query = "SELECT h FROM HKCW013Detail h WHERE h.bilno = :bilno"),
    @NamedQuery(name = "HKCW013Detail.findByTemamtfs", query = "SELECT h FROM HKCW013Detail h WHERE h.temamtfs = :temamtfs"),
    @NamedQuery(name = "HKCW013Detail.findByCmpBudgetacc", query = "SELECT h FROM HKCW013Detail h WHERE h.cmpBudgetacc = :cmpBudgetacc"),
    @NamedQuery(name = "HKCW013Detail.findByTemamt", query = "SELECT h FROM HKCW013Detail h WHERE h.temamt = :temamt"),
    @NamedQuery(name = "HKCW013Detail.findByFSN", query = "SELECT h FROM HKCW013Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW013Detail.findBySeq", query = "SELECT h FROM HKCW013Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCW013Detail.findByCoin", query = "SELECT h FROM HKCW013Detail h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKCW013Detail.findByRatio", query = "SELECT h FROM HKCW013Detail h WHERE h.ratio = :ratio")})
public class HKCW013Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "cmp_centerid")
    private String cmpCenterid;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
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

    public HKCW013Detail() {
    }

    public HKCW013Detail(String oid) {
        this.oid = oid;
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
    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
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
        if (!(object instanceof HKCW013Detail)) {
            return false;
        }
        HKCW013Detail other = (HKCW013Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW013Detail[ oid=" + oid + " ]";
    }
    
}
