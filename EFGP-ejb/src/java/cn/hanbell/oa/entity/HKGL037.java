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
@Table(name = "HK_GL037")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL037.findAll", query = "SELECT h FROM HKGL037 h"),
    @NamedQuery(name = "HKGL037.findByTotal", query = "SELECT h FROM HKGL037 h WHERE h.total = :total"),
    @NamedQuery(name = "HKGL037.findByOid", query = "SELECT h FROM HKGL037 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL037.findByZgls", query = "SELECT h FROM HKGL037 h WHERE h.zgls = :zgls"),
    @NamedQuery(name = "HKGL037.findByAddress1", query = "SELECT h FROM HKGL037 h WHERE h.address1 = :address1"),
    @NamedQuery(name = "HKGL037.findByAddress2", query = "SELECT h FROM HKGL037 h WHERE h.address2 = :address2"),
    @NamedQuery(name = "HKGL037.findByCfcs", query = "SELECT h FROM HKGL037 h WHERE h.cfcs = :cfcs"),
    @NamedQuery(name = "HKGL037.findByCctime", query = "SELECT h FROM HKGL037 h WHERE h.cctime = :cctime"),
    @NamedQuery(name = "HKGL037.findByContact", query = "SELECT h FROM HKGL037 h WHERE h.contact = :contact"),
    @NamedQuery(name = "HKGL037.findBySerialNumber", query = "SELECT h FROM HKGL037 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL037.findByHdnEmply", query = "SELECT h FROM HKGL037 h WHERE h.hdnEmply = :hdnEmply"),
    @NamedQuery(name = "HKGL037.findByEmply", query = "SELECT h FROM HKGL037 h WHERE h.emply = :emply"),
    @NamedQuery(name = "HKGL037.findByYcrq", query = "SELECT h FROM HKGL037 h WHERE h.ycrq = :ycrq"),
    @NamedQuery(name = "HKGL037.findByHdnScgy", query = "SELECT h FROM HKGL037 h WHERE h.hdnScgy = :hdnScgy"),
    @NamedQuery(name = "HKGL037.findByBm", query = "SELECT h FROM HKGL037 h WHERE h.bm = :bm"),
    @NamedQuery(name = "HKGL037.findByGsmc", query = "SELECT h FROM HKGL037 h WHERE h.gsmc = :gsmc"),
    @NamedQuery(name = "HKGL037.findByCph", query = "SELECT h FROM HKGL037 h WHERE h.cph = :cph"),
    @NamedQuery(name = "HKGL037.findBySqrq", query = "SELECT h FROM HKGL037 h WHERE h.sqrq = :sqrq"),
    @NamedQuery(name = "HKGL037.findByJsylxfs", query = "SELECT h FROM HKGL037 h WHERE h.jsylxfs = :jsylxfs"),
    @NamedQuery(name = "HKGL037.findByDept", query = "SELECT h FROM HKGL037 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKGL037.findByPSN", query = "SELECT h FROM HKGL037 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL037.findBySy", query = "SELECT h FROM HKGL037 h WHERE h.sy = :sy"),
    @NamedQuery(name = "HKGL037.findByHdaddress2", query = "SELECT h FROM HKGL037 h WHERE h.hdaddress2 = :hdaddress2"),
    @NamedQuery(name = "HKGL037.findByYcyy", query = "SELECT h FROM HKGL037 h WHERE h.ycyy = :ycyy"),
    @NamedQuery(name = "HKGL037.findByMdcs", query = "SELECT h FROM HKGL037 h WHERE h.mdcs = :mdcs"),
    @NamedQuery(name = "HKGL037.findByEmplyer", query = "SELECT h FROM HKGL037 h WHERE h.emplyer = :emplyer"),
    @NamedQuery(name = "HKGL037.findByCpno", query = "SELECT h FROM HKGL037 h WHERE h.cpno = :cpno"),
    @NamedQuery(name = "HKGL037.findByDeparture", query = "SELECT h FROM HKGL037 h WHERE h.departure = :departure"),
    @NamedQuery(name = "HKGL037.findByMdsf", query = "SELECT h FROM HKGL037 h WHERE h.mdsf = :mdsf"),
    @NamedQuery(name = "HKGL037.findByKr", query = "SELECT h FROM HKGL037 h WHERE h.kr = :kr"),
    @NamedQuery(name = "HKGL037.findByKrlxfs", query = "SELECT h FROM HKGL037 h WHERE h.krlxfs = :krlxfs"),
    @NamedQuery(name = "HKGL037.findByHdnDept", query = "SELECT h FROM HKGL037 h WHERE h.hdnDept = :hdnDept"),
    @NamedQuery(name = "HKGL037.findByHdnJsy", query = "SELECT h FROM HKGL037 h WHERE h.hdnJsy = :hdnJsy"),
    @NamedQuery(name = "HKGL037.findByClxz", query = "SELECT h FROM HKGL037 h WHERE h.clxz = :clxz"),
    @NamedQuery(name = "HKGL037.findByCfsf", query = "SELECT h FROM HKGL037 h WHERE h.cfsf = :cfsf"),
    @NamedQuery(name = "HKGL037.findByJsy", query = "SELECT h FROM HKGL037 h WHERE h.jsy = :jsy"),
    @NamedQuery(name = "HKGL037.findByAccommodation", query = "SELECT h FROM HKGL037 h WHERE h.accommodation = :accommodation"),
    @NamedQuery(name = "HKGL037.findBySgls", query = "SELECT h FROM HKGL037 h WHERE h.sgls = :sgls"),
    @NamedQuery(name = "HKGL037.findByGh", query = "SELECT h FROM HKGL037 h WHERE h.gh = :gh"),
    @NamedQuery(name = "HKGL037.findByHdycyy", query = "SELECT h FROM HKGL037 h WHERE h.hdycyy = :hdycyy"),
    @NamedQuery(name = "HKGL037.findByHctime", query = "SELECT h FROM HKGL037 h WHERE h.hctime = :hctime"),
    @NamedQuery(name = "HKGL037.findByLxfs", query = "SELECT h FROM HKGL037 h WHERE h.lxfs = :lxfs"),
    @NamedQuery(name = "HKGL037.findByFSN", query = "SELECT h FROM HKGL037 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL037.findByBzsm", query = "SELECT h FROM HKGL037 h WHERE h.bzsm = :bzsm"),
    @NamedQuery(name = "HKGL037.findByIsPrint", query = "SELECT h FROM HKGL037 h WHERE h.isPrint = :isPrint")})
public class HKGL037 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "zgls")
    private Double zgls;
    @Size(max = 255)
    @Column(name = "address1")
    private String address1;
    @Size(max = 255)
    @Column(name = "address2")
    private String address2;
    @Size(max = 255)
    @Column(name = "cfcs")
    private String cfcs;
    @Column(name = "cctime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cctime;
    @Size(max = 255)
    @Column(name = "contact")
    private String contact;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdn_emply")
    private String hdnEmply;
    @Size(max = 255)
    @Column(name = "emply")
    private String emply;
    @Column(name = "ycrq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ycrq;
    @Size(max = 255)
    @Column(name = "hdn_scgy")
    private String hdnScgy;
    @Size(max = 255)
    @Column(name = "bm")
    private String bm;
    @Size(max = 255)
    @Column(name = "gsmc")
    private String gsmc;
    @Size(max = 255)
    @Column(name = "cph")
    private String cph;
    @Column(name = "sqrq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sqrq;
    @Size(max = 255)
    @Column(name = "jsylxfs")
    private String jsylxfs;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "sy")
    private String sy;
    @Size(max = 255)
    @Column(name = "hdaddress2")
    private String hdaddress2;
    @Size(max = 255)
    @Column(name = "ycyy")
    private String ycyy;
    @Size(max = 255)
    @Column(name = "mdcs")
    private String mdcs;
    @Size(max = 255)
    @Column(name = "emplyer")
    private String emplyer;
    @Size(max = 255)
    @Column(name = "cpno")
    private String cpno;
    @Size(max = 255)
    @Column(name = "departure")
    private String departure;
    @Size(max = 255)
    @Column(name = "mdsf")
    private String mdsf;
    @Size(max = 255)
    @Column(name = "kr")
    private String kr;
    @Size(max = 255)
    @Column(name = "krlxfs")
    private String krlxfs;
    @Size(max = 255)
    @Column(name = "hdn_dept")
    private String hdnDept;
    @Size(max = 255)
    @Column(name = "hdn_jsy")
    private String hdnJsy;
    @Size(max = 255)
    @Column(name = "clxz")
    private String clxz;
    @Size(max = 255)
    @Column(name = "cfsf")
    private String cfsf;
    @Size(max = 255)
    @Column(name = "jsy")
    private String jsy;
    @Size(max = 255)
    @Column(name = "accommodation")
    private String accommodation;
    @Column(name = "sgls")
    private Double sgls;
    @Size(max = 255)
    @Column(name = "gh")
    private String gh;
    @Size(max = 255)
    @Column(name = "hdycyy")
    private String hdycyy;
    @Column(name = "hctime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hctime;
    @Size(max = 255)
    @Column(name = "lxfs")
    private String lxfs;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "bzsm")
    private String bzsm;
    @Size(max = 255)
    @Column(name = "isPrint")
    private String isPrint;

    public HKGL037() {
    }

    public HKGL037(String oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getZgls() {
        return zgls;
    }

    public void setZgls(Double zgls) {
        this.zgls = zgls;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCfcs() {
        return cfcs;
    }

    public void setCfcs(String cfcs) {
        this.cfcs = cfcs;
    }

    public Date getCctime() {
        return cctime;
    }

    public void setCctime(Date cctime) {
        this.cctime = cctime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnEmply() {
        return hdnEmply;
    }

    public void setHdnEmply(String hdnEmply) {
        this.hdnEmply = hdnEmply;
    }

    public String getEmply() {
        return emply;
    }

    public void setEmply(String emply) {
        this.emply = emply;
    }

    public Date getYcrq() {
        return ycrq;
    }

    public void setYcrq(Date ycrq) {
        this.ycrq = ycrq;
    }

    public String getHdnScgy() {
        return hdnScgy;
    }

    public void setHdnScgy(String hdnScgy) {
        this.hdnScgy = hdnScgy;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public Date getSqrq() {
        return sqrq;
    }

    public void setSqrq(Date sqrq) {
        this.sqrq = sqrq;
    }

    public String getJsylxfs() {
        return jsylxfs;
    }

    public void setJsylxfs(String jsylxfs) {
        this.jsylxfs = jsylxfs;
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

    public String getSy() {
        return sy;
    }

    public void setSy(String sy) {
        this.sy = sy;
    }

    public String getHdaddress2() {
        return hdaddress2;
    }

    public void setHdaddress2(String hdaddress2) {
        this.hdaddress2 = hdaddress2;
    }

    public String getYcyy() {
        return ycyy;
    }

    public void setYcyy(String ycyy) {
        this.ycyy = ycyy;
    }

    public String getMdcs() {
        return mdcs;
    }

    public void setMdcs(String mdcs) {
        this.mdcs = mdcs;
    }

    public String getEmplyer() {
        return emplyer;
    }

    public void setEmplyer(String emplyer) {
        this.emplyer = emplyer;
    }

    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getMdsf() {
        return mdsf;
    }

    public void setMdsf(String mdsf) {
        this.mdsf = mdsf;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getKrlxfs() {
        return krlxfs;
    }

    public void setKrlxfs(String krlxfs) {
        this.krlxfs = krlxfs;
    }

    public String getHdnDept() {
        return hdnDept;
    }

    public void setHdnDept(String hdnDept) {
        this.hdnDept = hdnDept;
    }

    public String getHdnJsy() {
        return hdnJsy;
    }

    public void setHdnJsy(String hdnJsy) {
        this.hdnJsy = hdnJsy;
    }

    public String getClxz() {
        return clxz;
    }

    public void setClxz(String clxz) {
        this.clxz = clxz;
    }

    public String getCfsf() {
        return cfsf;
    }

    public void setCfsf(String cfsf) {
        this.cfsf = cfsf;
    }

    public String getJsy() {
        return jsy;
    }

    public void setJsy(String jsy) {
        this.jsy = jsy;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public Double getSgls() {
        return sgls;
    }

    public void setSgls(Double sgls) {
        this.sgls = sgls;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getHdycyy() {
        return hdycyy;
    }

    public void setHdycyy(String hdycyy) {
        this.hdycyy = hdycyy;
    }

    public Date getHctime() {
        return hctime;
    }

    public void setHctime(Date hctime) {
        this.hctime = hctime;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getBzsm() {
        return bzsm;
    }

    public void setBzsm(String bzsm) {
        this.bzsm = bzsm;
    }

    public String getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
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
        if (!(object instanceof HKGL037)) {
            return false;
        }
        HKGL037 other = (HKGL037) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.ejb.HKGL037[ oid=" + oid + " ]";
    }
    
}
