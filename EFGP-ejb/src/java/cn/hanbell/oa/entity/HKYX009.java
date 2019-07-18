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
@Table(name = "HK_YX009")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX009.findAll", query = "SELECT h FROM HKYX009 h"),
    @NamedQuery(name = "HKYX009.findByOid", query = "SELECT h FROM HKYX009 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKYX009.findByItnbrcus", query = "SELECT h FROM HKYX009 h WHERE h.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "HKYX009.findByCfmdate", query = "SELECT h FROM HKYX009 h WHERE h.cfmdate = :cfmdate"),
    @NamedQuery(name = "HKYX009.findByFacno", query = "SELECT h FROM HKYX009 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKYX009.findByCusno", query = "SELECT h FROM HKYX009 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKYX009.findByQuono", query = "SELECT h FROM HKYX009 h WHERE h.quono = :quono"),
    @NamedQuery(name = "HKYX009.findByItnbr", query = "SELECT h FROM HKYX009 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKYX009.findByPSN", query = "SELECT h FROM HKYX009 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKYX009.findByDepno", query = "SELECT h FROM HKYX009 h WHERE h.depno = :depno"),
    @NamedQuery(name = "HKYX009.findByFSN", query = "SELECT h FROM HKYX009 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKYX009.findByLastunpri", query = "SELECT h FROM HKYX009 h WHERE h.lastunpri = :lastunpri")})
public class HKYX009 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "isspecial")
    private String isspecial;
    @Size(max = 255)
    @Column(name = "levelp")
    private String levelp;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "quono")
    private String quono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peratio")
    private String peratio;
    @Size(max = 255)
    @Column(name = "pricingtype")
    private String pricingtype;
     @Size(max = 255)
    @Column(name = "pricingtypedsc")
    private String pricingtypedsc;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "quaqy1")
    private Double quaqy1;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "quotype ")
    private String quotype ;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "refmodel")
    private String refmodel;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "apprresno")
    private String apprresno;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Column(name = "unpris")
    private Double unpris;
    @Column(name = "ratio")
    private Double ratio;
    @Column(name = "diffitting")
    private Double diffitting;
    @Size(max = 255)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Size(max = 255)
    @Column(name = "orderqty")
    private String orderqty;
    @Size(max = 255)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 255)
    @Column(name = "mancodesc")
    private String mancodesc;
    @Column(name = "tramts")
    private Double tramts;
    @Column(name = "quodate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date quodate;
    @Column(name = "refratio")
    private String refratio;
    @Column(name = "trseq")
    private Integer trseq;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "lastunpri")
    private Double lastunpri;

    public HKYX009() {
    }

    public HKYX009(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPricingtype() {
        return pricingtype;
    }

    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(String isspecial) {
        this.isspecial = isspecial;
    }

    public String getLevelp() {
        return levelp;
    }

    public void setLevelp(String levelp) {
        this.levelp = levelp;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public String getPeratio() {
        return peratio;
    }

    public void setPeratio(String peratio) {
        this.peratio = peratio;
    }

    public String getPricingtypedsc() {
        return pricingtypedsc;
    }

    public void setPricingtypedsc(String pricingtypedsc) {
        this.pricingtypedsc = pricingtypedsc;
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

    public Double getQuaqy1() {
        return quaqy1;
    }

    public void setQuaqy1(Double quaqy1) {
        this.quaqy1 = quaqy1;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getQuotype () {
        return quotype ;
    }

    public void setQuotype (String quotype ) {
        this.quotype  = quotype ;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getRefmodel() {
        return refmodel;
    }

    public void setRefmodel(String refmodel) {
        this.refmodel = refmodel;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getApprresno() {
        return apprresno;
    }

    public void setApprresno(String apprresno) {
        this.apprresno = apprresno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Double getUnpris() {
        return unpris;
    }

    public void setUnpris(Double unpris) {
        this.unpris = unpris;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Double getDiffitting() {
        return diffitting;
    }

    public void setDiffitting(Double diffitting) {
        this.diffitting = diffitting;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public String getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(String orderqty) {
        this.orderqty = orderqty;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public Double getTramts() {
        return tramts;
    }

    public void setTramts(Double tramts) {
        this.tramts = tramts;
    }

    public Date getQuodate() {
        return quodate;
    }

    public void setQuodate(Date quodate) {
        this.quodate = quodate;
    }

    public String getRefratio() {
        return refratio;
    }

    public void setRefratio(String refratio) {
        this.refratio = refratio;
    }

    public Integer getTrseq() {
        return trseq;
    }

    public void setTrseq(Integer trseq) {
        this.trseq = trseq;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Double getLastunpri() {
        return lastunpri;
    }

    public void setLastunpri(Double lastunpri) {
        this.lastunpri = lastunpri;
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
        if (!(object instanceof HKYX009)) {
            return false;
        }
        HKYX009 other = (HKYX009) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX009[ oid=" + oid + " ]";
    }

    public String getMancodesc() {
        return mancodesc;
    }

    public void setMancodesc(String mancodesc) {
        this.mancodesc = mancodesc;
    }
    
}
