/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.oa.ejb.WorkFlowBean;
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
 * @author C2082
 */
@Entity
@Table(name = "HK_CW004")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW004.findAll", query = "SELECT h FROM HKCW004 h"),
    @NamedQuery(name = "HKCW004.findByFacno", query = "SELECT h FROM HKCW004 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW004.findByPSN", query = "SELECT h FROM HKCW004 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW004.findByJine", query = "SELECT h FROM HKCW004 h WHERE h.jine = :jine"),
    @NamedQuery(name = "HKCW004.findByCreatedate", query = "SELECT h FROM HKCW004 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HKCW004.findByBttbankno", query = "SELECT h FROM HKCW004 h WHERE h.bttbankno = :bttbankno"),
    @NamedQuery(name = "HKCW004.findByPzzh", query = "SELECT h FROM HKCW004 h WHERE h.pzzh = :pzzh"),
    @NamedQuery(name = "HKCW004.findByDx", query = "SELECT h FROM HKCW004 h WHERE h.dx = :dx"),
    @NamedQuery(name = "HKCW004.findByVdrd", query = "SELECT h FROM HKCW004 h WHERE h.vdrd = :vdrd"),
    @NamedQuery(name = "HKCW004.findByBz", query = "SELECT h FROM HKCW004 h WHERE h.bz = :bz"),
    @NamedQuery(name = "HKCW004.findByFSN", query = "SELECT h FROM HKCW004 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW004.findByCusna", query = "SELECT h FROM HKCW004 h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKCW004.findByBfkfs", query = "SELECT h FROM HKCW004 h WHERE h.bfkfs = :bfkfs"),
    @NamedQuery(name = "HKCW004.findByBibi", query = "SELECT h FROM HKCW004 h WHERE h.bibi = :bibi"),
    @NamedQuery(name = "HKCW004.findByHdnmanager", query = "SELECT h FROM HKCW004 h WHERE h.hdnmanager = :hdnmanager"),
    @NamedQuery(name = "HKCW004.findByCusno", query = "SELECT h FROM HKCW004 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKCW004.findByDept", query = "SELECT h FROM HKCW004 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKCW004.findByHdnFacno", query = "SELECT h FROM HKCW004 h WHERE h.hdnFacno = :hdnFacno"),
    @NamedQuery(name = "HKCW004.findByOID", query = "SELECT h FROM HKCW004 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW004.findBySsje", query = "SELECT h FROM HKCW004 h WHERE h.ssje = :ssje"),
    @NamedQuery(name = "HKCW004.findByYsje", query = "SELECT h FROM HKCW004 h WHERE h.ysje = :ysje"),
    @NamedQuery(name = "HKCW004.findByApplyuser", query = "SELECT h FROM HKCW004 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKCW004.findBySkxz", query = "SELECT h FROM HKCW004 h WHERE h.skxz = :skxz"),
    @NamedQuery(name = "HKCW004.findByAcctno", query = "SELECT h FROM HKCW004 h WHERE h.acctno = :acctno"),
    @NamedQuery(name = "HKCW004.findBySerialNumber", query = "SELECT h FROM HKCW004 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW004.findByHdnboss", query = "SELECT h FROM HKCW004 h WHERE h.hdnboss = :hdnboss"),
    @NamedQuery(name = "HKCW004.findByFphm", query = "SELECT h FROM HKCW004 h WHERE h.fphm = :fphm"),
    @NamedQuery(name = "HKCW004.findByZy", query = "SELECT h FROM HKCW004 h WHERE h.zy = :zy")})
public class HKCW004 implements Serializable {

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
    @Column(name = "dx")
    private String dx;
    @Size(max = 255)
    @Column(name = "vdrd")
    private String vdrd;
    @Size(max = 255)
    @Column(name = "bz")
    private String bz;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "bfkfs")
    private String bfkfs;
    @Size(max = 255)
    @Column(name = "bibi")
    private String bibi;
    @Size(max = 255)
    @Column(name = "hdnmanager")
    private String hdnmanager;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "ssje")
    private Double ssje;
    @Column(name = "ysje")
    private Double ysje;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "skxz")
    private String skxz;
    @Size(max = 255)
    @Column(name = "acctno")
    private String acctno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdnboss")
    private String hdnboss;
    @Size(max = 255)
    @Column(name = "fphm")
    private String fphm;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;

    public HKCW004() {
    }

    public HKCW004(String oid) {
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

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getBfkfs() {
        return bfkfs;
    }

    public void setBfkfs(String bfkfs) {
        this.bfkfs = bfkfs;
    }

    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    public String getHdnmanager() {
        return hdnmanager;
    }

    public void setHdnmanager(String hdnmanager) {
        this.hdnmanager = hdnmanager;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getSsje() {
        return ssje;
    }

    public void setSsje(Double ssje) {
        this.ssje = ssje;
    }

    public Double getYsje() {
        return ysje;
    }

    public void setYsje(Double ysje) {
        this.ysje = ysje;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getSkxz() {
        return skxz;
    }

    public void setSkxz(String skxz) {
        this.skxz = skxz;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnboss() {
        return hdnboss;
    }

    public void setHdnboss(String hdnboss) {
        this.hdnboss = hdnboss;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW004)) {
            return false;
        }
        HKCW004 other = (HKCW004) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW004[ oid=" + oid + " ]";
    }
    
}
