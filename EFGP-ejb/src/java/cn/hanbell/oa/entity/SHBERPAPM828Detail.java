/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
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
 * @author C0160
 */
@Entity
@Table(name = "SHB_ERP_APM828_detail")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "SHBERPAPM828Detail.findAll", query = "SELECT s FROM SHBERPAPM828Detail s"),
    @NamedQuery(name = "SHBERPAPM828Detail.findByFSN",
        query = "SELECT s FROM SHBERPAPM828Detail s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPAPM828Detail.findByOID",
        query = "SELECT s FROM SHBERPAPM828Detail s WHERE s.oid = :oid")})
public class SHBERPAPM828Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "apamt")
    private String apamt;
    @Size(max = 255)
    @Column(name = "apamtfs")
    private String apamtfs;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
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
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;
    @Size(max = 255)
    @Column(name = "com_apamtfs")
    private String comApamtfs;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;

    public SHBERPAPM828Detail() {
    }

    public SHBERPAPM828Detail(String oid) {
        this.oid = oid;
    }

    public String getApamt() {
        return apamt;
    }

    public void setApamt(String apamt) {
        this.apamt = apamt;
    }

    public String getApamtfs() {
        return apamtfs;
    }

    public void setApamtfs(String apamtfs) {
        this.apamtfs = apamtfs;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
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

    public String getComApamtfs() {
        return comApamtfs;
    }

    public void setComApamtfs(String comApamtfs) {
        this.comApamtfs = comApamtfs;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
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
        if (!(object instanceof SHBERPAPM828Detail)) {
            return false;
        }
        SHBERPAPM828Detail other = (SHBERPAPM828Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM828Detail[ oid=" + oid + " ]";
    }

}
