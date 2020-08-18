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
 * @author C2082
 */
@Entity
@Table(name = "QTC_CW027")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QTCCW027.findAll", query = "SELECT q FROM QTCCW027 q"),
    @NamedQuery(name = "QTCCW027.findByOid", query = "SELECT q FROM QTCCW027 q WHERE q.oid = :oid"),
    @NamedQuery(name = "QTCCW027.findByDx", query = "SELECT q FROM QTCCW027 q WHERE q.dx = :dx"),
    @NamedQuery(name = "QTCCW027.findByYsje", query = "SELECT q FROM QTCCW027 q WHERE q.ysje = :ysje"),
    @NamedQuery(name = "QTCCW027.findByBz", query = "SELECT q FROM QTCCW027 q WHERE q.bz = :bz"),
    @NamedQuery(name = "QTCCW027.findByCreatedate", query = "SELECT q FROM QTCCW027 q WHERE q.createdate = :createdate"),
    @NamedQuery(name = "QTCCW027.findByBfkfs", query = "SELECT q FROM QTCCW027 q WHERE q.bfkfs = :bfkfs"),
    @NamedQuery(name = "QTCCW027.findByFacno", query = "SELECT q FROM QTCCW027 q WHERE q.facno = :facno"),
    @NamedQuery(name = "QTCCW027.findBySkxz", query = "SELECT q FROM QTCCW027 q WHERE q.skxz = :skxz"),
    @NamedQuery(name = "QTCCW027.findBySerialNumber", query = "SELECT q FROM QTCCW027 q WHERE q.serialNumber = :serialNumber"),
    @NamedQuery(name = "QTCCW027.findByFphm", query = "SELECT q FROM QTCCW027 q WHERE q.fphm = :fphm"),
    @NamedQuery(name = "QTCCW027.findByZy", query = "SELECT q FROM QTCCW027 q WHERE q.zy = :zy"),
    @NamedQuery(name = "QTCCW027.findByApplyuser", query = "SELECT q FROM QTCCW027 q WHERE q.applyuser = :applyuser"),
    @NamedQuery(name = "QTCCW027.findByCusno", query = "SELECT q FROM QTCCW027 q WHERE q.cusno = :cusno"),
    @NamedQuery(name = "QTCCW027.findByBib", query = "SELECT q FROM QTCCW027 q WHERE q.bib = :bib"),
    @NamedQuery(name = "QTCCW027.findByDept", query = "SELECT q FROM QTCCW027 q WHERE q.dept = :dept"),
    @NamedQuery(name = "QTCCW027.findByPSN", query = "SELECT q FROM QTCCW027 q WHERE q.processSerialNumber = :psn"),
    @NamedQuery(name = "QTCCW027.findByJine", query = "SELECT q FROM QTCCW027 q WHERE q.jine = :jine"),
    @NamedQuery(name = "QTCCW027.findByVdrd", query = "SELECT q FROM QTCCW027 q WHERE q.vdrd = :vdrd"),
    @NamedQuery(name = "QTCCW027.findByCusna", query = "SELECT q FROM QTCCW027 q WHERE q.cusna = :cusna"),
    @NamedQuery(name = "QTCCW027.findByBttbankno", query = "SELECT q FROM QTCCW027 q WHERE q.bttbankno = :bttbankno"),
    @NamedQuery(name = "QTCCW027.findByPzzh", query = "SELECT q FROM QTCCW027 q WHERE q.pzzh = :pzzh"),
    @NamedQuery(name = "QTCCW027.findByBibi", query = "SELECT q FROM QTCCW027 q WHERE q.bibi = :bibi"),
    @NamedQuery(name = "QTCCW027.findByEls", query = "SELECT q FROM QTCCW027 q WHERE q.els = :els"),
    @NamedQuery(name = "QTCCW027.findBySsje", query = "SELECT q FROM QTCCW027 q WHERE q.ssje = :ssje"),
    @NamedQuery(name = "QTCCW027.findByFSN", query = "SELECT q FROM QTCCW027 q WHERE q.formSerialNumber = :fsn")})
public class QTCCW027 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "dx")
    private String dx;
    @Size(max = 255)
    @Column(name = "ysje")
    private String ysje;
    @Size(max = 255)
    @Column(name = "bz")
    private String bz;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "bfkfs")
    private String bfkfs;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "skxz")
    private String skxz;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "fphm")
    private String fphm;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "bib")
    private String bib;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "jine")
    private Double jine;
    @Size(max = 255)
    @Column(name = "vdrd")
    private String vdrd;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "bttbankno")
    private String bttbankno;
    @Size(max = 255)
    @Column(name = "pzzh")
    private String pzzh;
    @Size(max = 255)
    @Column(name = "bibi")
    private String bibi;
    @Size(max = 255)
    @Column(name = "els")
    private String els;
    @Size(max = 255)
    @Column(name = "ssje")
    private String ssje;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public QTCCW027() {
    }

    public QTCCW027(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getBfkfs() {
        return bfkfs;
    }

    public void setBfkfs(String bfkfs) {
        this.bfkfs = bfkfs;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSkxz() {
        return skxz;
    }

    public void setSkxz(String skxz) {
        this.skxz = skxz;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getBib() {
        return bib;
    }

    public void setBib(String bib) {
        this.bib = bib;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getVdrd() {
        return vdrd;
    }

    public void setVdrd(String vdrd) {
        this.vdrd = vdrd;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
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

    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    public String getEls() {
        return els;
    }

    public void setEls(String els) {
        this.els = els;
    }

    public String getSsje() {
        return ssje;
    }

    public void setSsje(String ssje) {
        this.ssje = ssje;
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
        if (!(object instanceof QTCCW027)) {
            return false;
        }
        QTCCW027 other = (QTCCW027) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.QTCCW027[ oid=" + oid + " ]";
    }
    
}
