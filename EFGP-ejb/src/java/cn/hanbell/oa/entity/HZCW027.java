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
 * @author C0160
 */
@Entity
@Table(name = "HZ_CW027")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW027.findAll", query = "SELECT h FROM HZCW027 h"),
    @NamedQuery(name = "HZCW027.findByOid", query = "SELECT h FROM HZCW027 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW027.findByPSN", query = "SELECT h FROM HZCW027 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW027.findByFSN", query = "SELECT h FROM HZCW027 h WHERE h.formSerialNumber = :fsn")})
public class HZCW027 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ysje")
    private String ysje;
    @Size(max = 255)
    @Column(name = "dx")
    private String dx;
    @Size(max = 255)
    @Column(name = "bz")
    private String bz;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "bfkfs")
    private String bfkfs;
    @Size(max = 255)
    @Column(name = "skxz")
    private String skxz;
    @Size(max = 255)
    @Column(name = "fphm")
    private String fphm;
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
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "bib")
    private String bib;
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
    @Column(name = "hdn_bfkfs")
    private String hdnBfkfs;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "bttbankno")
    private String bttbankno;
    @Size(max = 255)
    @Column(name = "acctno")
    private String acctno;
    @Size(max = 255)
    @Column(name = "pzzh")
    private String pzzh;
    @Size(max = 255)
    @Column(name = "hdn_skxz")
    private String hdnSkxz;
    @Size(max = 255)
    @Column(name = "bibi")
    private String bibi;
    @Size(max = 255)
    @Column(name = "hdn_dept")
    private String hdnDept;
    @Size(max = 255)
    @Column(name = "els")
    private String els;
    @Size(max = 255)
    @Column(name = "hdn_bib")
    private String hdnBib;
    @Size(max = 255)
    @Column(name = "ssje")
    private String ssje;
    @Size(max = 255)
    @Column(name = "hdn_applyuser")
    private String hdnApplyuser;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdn_facno")
    private String hdnFacno;

    public HZCW027() {
    }

    public HZCW027(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
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

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBfkfs() {
        return bfkfs;
    }

    public void setBfkfs(String bfkfs) {
        this.bfkfs = bfkfs;
    }

    public String getSkxz() {
        return skxz;
    }

    public void setSkxz(String skxz) {
        this.skxz = skxz;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
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

    public String getHdnBfkfs() {
        return hdnBfkfs;
    }

    public void setHdnBfkfs(String hdnBfkfs) {
        this.hdnBfkfs = hdnBfkfs;
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

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getPzzh() {
        return pzzh;
    }

    public void setPzzh(String pzzh) {
        this.pzzh = pzzh;
    }

    public String getHdnSkxz() {
        return hdnSkxz;
    }

    public void setHdnSkxz(String hdnSkxz) {
        this.hdnSkxz = hdnSkxz;
    }

    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    public String getHdnDept() {
        return hdnDept;
    }

    public void setHdnDept(String hdnDept) {
        this.hdnDept = hdnDept;
    }

    public String getEls() {
        return els;
    }

    public void setEls(String els) {
        this.els = els;
    }

    public String getHdnBib() {
        return hdnBib;
    }

    public void setHdnBib(String hdnBib) {
        this.hdnBib = hdnBib;
    }

    public String getSsje() {
        return ssje;
    }

    public void setSsje(String ssje) {
        this.ssje = ssje;
    }

    public String getHdnApplyuser() {
        return hdnApplyuser;
    }

    public void setHdnApplyuser(String hdnApplyuser) {
        this.hdnApplyuser = hdnApplyuser;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnFacno() {
        return hdnFacno;
    }

    public void setHdnFacno(String hdnFacno) {
        this.hdnFacno = hdnFacno;
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
        if (!(object instanceof HZCW027)) {
            return false;
        }
        HZCW027 other = (HZCW027) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW027[ oid=" + oid + " ]";
    }

}
