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
@Table(name = "HK_GC002")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGC002.findAll", query = "SELECT h FROM HKGC002 h"),
    @NamedQuery(name = "HKGC002.findByOID", query = "SELECT h FROM HKGC002 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGC002.findByPSN", query = "SELECT h FROM HKGC002 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGC002.findByFSN", query = "SELECT h FROM HKGC002 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGC002.findBySrcno", query = "SELECT h FROM HKGC002 h WHERE h.srcno = :srcno")})
public class HKGC002 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "mandate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mandate;
    @Size(max = 255)
    @Column(name = "pono")
    private String pono;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Column(name = "outdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outdate;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "itnbrname")
    private String itnbrname;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "askdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdate;
    @Size(max = 255)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Size(max = 255)
    @Column(name = "supportUser")
    private String supportUser;
    @Size(max = 255)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "applyneed")
    private String applyneed;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Column(name = "assdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assdate;
    @Column(name = "needdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date needdate;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Column(name = "findate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date findate;
    @Size(max = 255)
    @Column(name = "itnbrfname")
    private String itnbrfname;
    @Column(name = "stockdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stockdate;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKGC002() {
    }

    public HKGC002(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getMandate() {
        return mandate;
    }

    public void setMandate(Date mandate) {
        this.mandate = mandate;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getItnbrname() {
        return itnbrname;
    }

    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getAskdate() {
        return askdate;
    }

    public void setAskdate(Date askdate) {
        this.askdate = askdate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(String supportUser) {
        this.supportUser = supportUser;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getApplyneed() {
        return applyneed;
    }

    public void setApplyneed(String applyneed) {
        this.applyneed = applyneed;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getAssdate() {
        return assdate;
    }

    public void setAssdate(Date assdate) {
        this.assdate = assdate;
    }

    public Date getNeeddate() {
        return needdate;
    }

    public void setNeeddate(Date needdate) {
        this.needdate = needdate;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Date getFindate() {
        return findate;
    }

    public void setFindate(Date findate) {
        this.findate = findate;
    }

    public String getItnbrfname() {
        return itnbrfname;
    }

    public void setItnbrfname(String itnbrfname) {
        this.itnbrfname = itnbrfname;
    }

    public Date getStockdate() {
        return stockdate;
    }

    public void setStockdate(Date stockdate) {
        this.stockdate = stockdate;
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
        if (!(object instanceof HKGC002)) {
            return false;
        }
        HKGC002 other = (HKGC002) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGC002[ oid=" + oid + " ]";
    }

}
