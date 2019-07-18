/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Administrator
 */
@Entity
@Table(name = "HZ_CW005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW005.findAll", query = "SELECT h FROM HZCW005 h"),
    @NamedQuery(name = "HZCW005.findByLkr", query = "SELECT h FROM HZCW005 h WHERE h.lkr = :lkr"),
    @NamedQuery(name = "HZCW005.findByOID", query = "SELECT h FROM HZCW005 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW005.findByFkje", query = "SELECT h FROM HZCW005 h WHERE h.fkje = :fkje"),
    @NamedQuery(name = "HZCW005.findByJine", query = "SELECT h FROM HZCW005 h WHERE h.jine = :jine"),
    @NamedQuery(name = "HZCW005.findByVdrd", query = "SELECT h FROM HZCW005 h WHERE h.vdrd = :vdrd"),
    @NamedQuery(name = "HZCW005.findByDx", query = "SELECT h FROM HZCW005 h WHERE h.dx = :dx"),
    @NamedQuery(name = "HZCW005.findByFkxz", query = "SELECT h FROM HZCW005 h WHERE h.fkxz = :fkxz"),
    @NamedQuery(name = "HZCW005.findByKemu", query = "SELECT h FROM HZCW005 h WHERE h.kemu = :kemu"),
    @NamedQuery(name = "HZCW005.findByCreatedate", query = "SELECT h FROM HZCW005 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HZCW005.findByBttbankno", query = "SELECT h FROM HZCW005 h WHERE h.bttbankno = :bttbankno"),
    @NamedQuery(name = "HZCW005.findByBeizhu", query = "SELECT h FROM HZCW005 h WHERE h.beizhu = :beizhu"),
    @NamedQuery(name = "HZCW005.findByPzzh", query = "SELECT h FROM HZCW005 h WHERE h.pzzh = :pzzh"),
    @NamedQuery(name = "HZCW005.findByEls", query = "SELECT h FROM HZCW005 h WHERE h.els = :els"),
    @NamedQuery(name = "HZCW005.findByCreatetime", query = "SELECT h FROM HZCW005 h WHERE h.createtime = :createtime"),
    @NamedQuery(name = "HZCW005.findBySerialNumber", query = "SELECT h FROM HZCW005 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HZCW005.findByZy", query = "SELECT h FROM HZCW005 h WHERE h.zy = :zy"),
    @NamedQuery(name = "HZCW005.findByApplyuser", query = "SELECT h FROM HZCW005 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HZCW005.findByFkfs", query = "SELECT h FROM HZCW005 h WHERE h.fkfs = :fkfs"),
    @NamedQuery(name = "HZCW005.findByDeptno", query = "SELECT h FROM HZCW005 h WHERE h.deptno = :deptno"),
    @NamedQuery(name = "HZCW005.findByDept", query = "SELECT h FROM HZCW005 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HZCW005.findByBib", query = "SELECT h FROM HZCW005 h WHERE h.bib = :bib"),
    @NamedQuery(name = "HZCW005.findByPSN", query = "SELECT h FROM HZCW005 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW005.findByVdrno", query = "SELECT h FROM HZCW005 h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HZCW005.findByFSN", query = "SELECT h FROM HZCW005 h WHERE h.formSerialNumber = :fsn")})
public class HZCW005 implements Serializable {

    @Size(max = 255)
    @Column(name = "hdn_deptno")
    private String hdnDeptno;
    @Size(max = 255)
    @Column(name = "hdn_fkfs")
    private String hdnFkfs;
    @Size(max = 255)
    @Column(name = "hdn_lkr")
    private String hdnLkr;
    @Size(max = 255)
    @Column(name = "hdn_bib")
    private String hdnBib;
    @Size(max = 255)
    @Column(name = "hdn_fkxz")
    private String hdnFkxz;
    @Size(max = 255)
    @Column(name = "hdn_applyuser")
    private String hdnApplyuser;

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

    public HZCW005() {
    }

    public HZCW005(String oid) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZCW005)) {
            return false;
        }
        HZCW005 other = (HZCW005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW005[ oid=" + oid + " ]";
    }

    public String getHdnDeptno() {
        return hdnDeptno;
    }

    public void setHdnDeptno(String hdnDeptno) {
        this.hdnDeptno = hdnDeptno;
    }

    public String getHdnFkfs() {
        return hdnFkfs;
    }

    public void setHdnFkfs(String hdnFkfs) {
        this.hdnFkfs = hdnFkfs;
    }

    public String getHdnLkr() {
        return hdnLkr;
    }

    public void setHdnLkr(String hdnLkr) {
        this.hdnLkr = hdnLkr;
    }

    public String getHdnBib() {
        return hdnBib;
    }

    public void setHdnBib(String hdnBib) {
        this.hdnBib = hdnBib;
    }

    public String getHdnFkxz() {
        return hdnFkxz;
    }

    public void setHdnFkxz(String hdnFkxz) {
        this.hdnFkxz = hdnFkxz;
    }

    public String getHdnApplyuser() {
        return hdnApplyuser;
    }

    public void setHdnApplyuser(String hdnApplyuser) {
        this.hdnApplyuser = hdnApplyuser;
    }
    
}
