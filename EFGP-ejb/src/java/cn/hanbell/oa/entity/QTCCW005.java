/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.crm.entity.CRMGG;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "QTC_CW005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QTCCW005.findAll", query = "SELECT q FROM QTCCW005 q"),
    @NamedQuery(name = "QTCCW005.findByLkr", query = "SELECT q FROM QTCCW005 q WHERE q.lkr = :lkr"),
    @NamedQuery(name = "QTCCW005.findByOid", query = "SELECT q FROM QTCCW005 q WHERE q.oid = :oid"),
    @NamedQuery(name = "QTCCW005.findByFkje", query = "SELECT q FROM QTCCW005 q WHERE q.fkje = :fkje"),
    @NamedQuery(name = "QTCCW005.findByJine", query = "SELECT q FROM QTCCW005 q WHERE q.jine = :jine"),
    @NamedQuery(name = "QTCCW005.findByVdrd", query = "SELECT q FROM QTCCW005 q WHERE q.vdrd = :vdrd"),
    @NamedQuery(name = "QTCCW005.findByDx", query = "SELECT q FROM QTCCW005 q WHERE q.dx = :dx"),
    @NamedQuery(name = "QTCCW005.findByFkxz", query = "SELECT q FROM QTCCW005 q WHERE q.fkxz = :fkxz"),
    @NamedQuery(name = "QTCCW005.findByKemu", query = "SELECT q FROM QTCCW005 q WHERE q.kemu = :kemu"),
    @NamedQuery(name = "QTCCW005.findByCreatedate", query = "SELECT q FROM QTCCW005 q WHERE q.createdate = :createdate"),
    @NamedQuery(name = "QTCCW005.findByBttbankno", query = "SELECT q FROM QTCCW005 q WHERE q.bttbankno = :bttbankno"),
    @NamedQuery(name = "QTCCW005.findByBeizhu", query = "SELECT q FROM QTCCW005 q WHERE q.beizhu = :beizhu"),
    @NamedQuery(name = "QTCCW005.findByPzzh", query = "SELECT q FROM QTCCW005 q WHERE q.pzzh = :pzzh"),
    @NamedQuery(name = "QTCCW005.findByEls", query = "SELECT q FROM QTCCW005 q WHERE q.els = :els"),
    @NamedQuery(name = "QTCCW005.findByCreatetime", query = "SELECT q FROM QTCCW005 q WHERE q.createtime = :createtime"),
    @NamedQuery(name = "QTCCW005.findBySerialNumber", query = "SELECT q FROM QTCCW005 q WHERE q.serialNumber = :serialNumber"),
    @NamedQuery(name = "QTCCW005.findByZy", query = "SELECT q FROM QTCCW005 q WHERE q.zy = :zy"),
    @NamedQuery(name = "QTCCW005.findByApplyuser", query = "SELECT q FROM QTCCW005 q WHERE q.applyuser = :applyuser"),
    @NamedQuery(name = "QTCCW005.findByFkfs", query = "SELECT q FROM QTCCW005 q WHERE q.fkfs = :fkfs"),
    @NamedQuery(name = "QTCCW005.findByDeptno", query = "SELECT q FROM QTCCW005 q WHERE q.deptno = :deptno"),
    @NamedQuery(name = "QTCCW005.findByDept", query = "SELECT q FROM QTCCW005 q WHERE q.dept = :dept"),
    @NamedQuery(name = "QTCCW005.findByBib", query = "SELECT q FROM QTCCW005 q WHERE q.bib = :bib"),
    @NamedQuery(name = "QTCCW005.findByPSN", query = "SELECT q FROM QTCCW005 q WHERE q.processSerialNumber = :psn"),
    @NamedQuery(name = "QTCCW005.findByVdrno", query = "SELECT q FROM QTCCW005 q WHERE q.vdrno = :vdrno"),
    @NamedQuery(name = "QTCCW005.findByFSN", query = "SELECT q FROM QTCCW005 q WHERE q.formSerialNumber = :fsn")})
public class QTCCW005 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "lkr")
    private String lkr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fkje")
    private Double fkje;
    @Column(name = "jine")
    private Double jine;
    @Size(max = 255)
    @Column(name = "vdrd")
    private String vdrd;
    @Size(max = 255)
    @Column(name = "dx")
    private String dx;
    @Size(max = 255)
    @Column(name = "fkxz")
    private String fkxz;
    @Size(max = 255)
    @Column(name = "kemu")
    private String kemu;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "bttbankno")
    private String bttbankno;
    @Size(max = 255)
    @Column(name = "beizhu")
    private String beizhu;
    @Size(max = 255)
    @Column(name = "pzzh")
    private String pzzh;
    @Size(max = 255)
    @Column(name = "els")
    private String els;
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "fkfs")
    private String fkfs;
    @Size(max = 255)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "bib")
    private String bib;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    @JoinColumn(name = "lkr", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;
    
    public QTCCW005() {
    }

    public QTCCW005(String oid) {
        this.oid = oid;
    }

    public String getLkr() {
        return lkr;
    }

    public void setLkr(String lkr) {
        this.lkr = lkr;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getFkje() {
        return fkje;
    }

    public void setFkje(Double fkje) {
        this.fkje = fkje;
    }

    public Double getJine() {
        return jine;
    }

    public void setJine(Double jine) {
        this.jine = jine;
    }

    public String getVdrd() {
        return vdrd;
    }

    public void setVdrd(String vdrd) {
        this.vdrd = vdrd;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getFkxz() {
        return fkxz;
    }

    public void setFkxz(String fkxz) {
        this.fkxz = fkxz;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getBttbankno() {
        return bttbankno;
    }

    public void setBttbankno(String bttbankno) {
        this.bttbankno = bttbankno;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getPzzh() {
        return pzzh;
    }

    public void setPzzh(String pzzh) {
        this.pzzh = pzzh;
    }

    public String getEls() {
        return els;
    }

    public void setEls(String els) {
        this.els = els;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBib() {
        return bib;
    }

    public void setBib(String bib) {
        this.bib = bib;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
        if (!(object instanceof QTCCW005)) {
            return false;
        }
        QTCCW005 other = (QTCCW005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.QTCCW005[ oid=" + oid + " ]";
    }
    
}
