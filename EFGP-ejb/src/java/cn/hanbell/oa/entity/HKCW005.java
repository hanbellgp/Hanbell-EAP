/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.oa.ejb.WorkFlowBean;
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
@Table(name = "HK_CW005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW005.findAll", query = "SELECT h FROM HKCW005 h"),
    @NamedQuery(name = "HKCW005.findByFacno", query = "SELECT h FROM HKCW005 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW005.findByPSN", query = "SELECT h FROM HKCW005 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW005.findByJine", query = "SELECT h FROM HKCW005 h WHERE h.jine = :jine"),
    @NamedQuery(name = "HKCW005.findByCreatedate", query = "SELECT h FROM HKCW005 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HKCW005.findByBttbankno", query = "SELECT h FROM HKCW005 h WHERE h.bttbankno = :bttbankno"),
    @NamedQuery(name = "HKCW005.findByPzzh", query = "SELECT h FROM HKCW005 h WHERE h.pzzh = :pzzh"),
    @NamedQuery(name = "HKCW005.findByLkr", query = "SELECT h FROM HKCW005 h WHERE h.lkr = :lkr"),
    @NamedQuery(name = "HKCW005.findByDx", query = "SELECT h FROM HKCW005 h WHERE h.dx = :dx"),
    @NamedQuery(name = "HKCW005.findByVdrd", query = "SELECT h FROM HKCW005 h WHERE h.vdrd = :vdrd"),
    @NamedQuery(name = "HKCW005.findByFSN", query = "SELECT h FROM HKCW005 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW005.findByHdnmanager", query = "SELECT h FROM HKCW005 h WHERE h.hdnmanager = :hdnmanager"),
    @NamedQuery(name = "HKCW005.findByCreatetime", query = "SELECT h FROM HKCW005 h WHERE h.createtime = :createtime"),
    @NamedQuery(name = "HKCW005.findByFkxz", query = "SELECT h FROM HKCW005 h WHERE h.fkxz = :fkxz"),
    @NamedQuery(name = "HKCW005.findByDept", query = "SELECT h FROM HKCW005 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKCW005.findByVdrno", query = "SELECT h FROM HKCW005 h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HKCW005.findByOID", query = "SELECT h FROM HKCW005 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW005.findByEls", query = "SELECT h FROM HKCW005 h WHERE h.els = :els"),
    @NamedQuery(name = "HKCW005.findByApplyuser", query = "SELECT h FROM HKCW005 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKCW005.findByDeptno", query = "SELECT h FROM HKCW005 h WHERE h.deptno = :deptno"),
    @NamedQuery(name = "HKCW005.findByFkje", query = "SELECT h FROM HKCW005 h WHERE h.fkje = :fkje"),
    @NamedQuery(name = "HKCW005.findByKemu", query = "SELECT h FROM HKCW005 h WHERE h.kemu = :kemu"),
    @NamedQuery(name = "HKCW005.findBySerialNumber", query = "SELECT h FROM HKCW005 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW005.findByBeizhu", query = "SELECT h FROM HKCW005 h WHERE h.beizhu = :beizhu"),
    @NamedQuery(name = "HKCW005.findByBib", query = "SELECT h FROM HKCW005 h WHERE h.bib = :bib"),
    @NamedQuery(name = "HKCW005.findByFkfs", query = "SELECT h FROM HKCW005 h WHERE h.fkfs = :fkfs"),
    @NamedQuery(name = "HKCW005.findByZy", query = "SELECT h FROM HKCW005 h WHERE h.zy = :zy")})
public class HKCW005 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "jine")
    private Double jine;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "bttbankno")
    private String bttbankno;
    @Size(max = 255)
    @Column(name = "pzzh")
    private String pzzh;
    @Size(max = 255)
    @Column(name = "lkr")
    private String lkr;
    @Size(max = 255)
    @Column(name = "dx")
    private String dx;
    @Size(max = 255)
    @Column(name = "vdrd")
    private String vdrd;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdnmanager")
    private String hdnmanager;
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Size(max = 255)
    @Column(name = "fkxz")
    private String fkxz;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "els")
    private String els;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "deptno")
    private String deptno;
    @Column(name = "fkje")
    private Double fkje;
    @Size(max = 255)
    @Column(name = "kemu")
    private String kemu;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "beizhu")
    private String beizhu;
    @Size(max = 255)
    @Column(name = "bib")
    private String bib;
    @Size(max = 255)
    @Column(name = "fkfs")
    private String fkfs;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    //人名
    @JoinColumn(name = "lkr", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;
    public HKCW005() {
    }

    public HKCW005(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Double getJine() {
        return jine;
    }

    public void setJine(Double jine) {
        this.jine = jine;
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

    public String getPzzh() {
        return pzzh;
    }

    public void setPzzh(String pzzh) {
        this.pzzh = pzzh;
    }

    public String getLkr() {
        return lkr;
    }

    public void setLkr(String lkr) {
        this.lkr = lkr;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getVdrd() {
        return vdrd;
    }

    public void setVdrd(String vdrd) {
        this.vdrd = vdrd;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnmanager() {
        return hdnmanager;
    }

    public void setHdnmanager(String hdnmanager) {
        this.hdnmanager = hdnmanager;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFkxz() {
        return fkxz;
    }

    public void setFkxz(String fkxz) {
        this.fkxz = fkxz;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getEls() {
        return els;
    }

    public void setEls(String els) {
        this.els = els;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public Double getFkje() {
        return fkje;
    }

    public void setFkje(Double fkje) {
        this.fkje = fkje;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getBib() {
        return bib;
    }

    public void setBib(String bib) {
        this.bib = bib;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getCompanyName() {
        WorkFlowBean WorkFlowBean = new WorkFlowBean();
        return WorkFlowBean.getCompanyName(this.facno);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getBibName() {
        switch (this.bib) {
            case "1":
                return "人民币";
            case "2":
                return "美元";
            case "3":
                return "日元";
            case "4":
                return "欧元";
            case "5":
                return "英镑";
            case "6":
                return "卢币";
            case "7":
                return "越南盾";
            case "8":
                return "台币";
            case "9":
                return "港币";
            case "10":
                return this.els;
        }
        return "";
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
        if (!(object instanceof HKCW005)) {
            return false;
        }
        HKCW005 other = (HKCW005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW005[ oid=" + oid + " ]";
    }

}
