/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author kevindong
 */
@Entity
@Table(name = "manmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manmas.findAll", query = "SELECT m FROM Manmas m"),
    @NamedQuery(name = "Manmas.findByFacno", query = "SELECT m FROM Manmas m WHERE m.manmasPK.facno = :facno"),
    @NamedQuery(name = "Manmas.findByProno", query = "SELECT m FROM Manmas m WHERE m.manmasPK.prono = :prono"),
    @NamedQuery(name = "Manmas.findByManno", query = "SELECT m FROM Manmas m WHERE m.manmasPK.manno = :manno"),
    @NamedQuery(name = "Manmas.findByItnbrf", query = "SELECT m FROM Manmas m WHERE m.itnbrf = :itnbrf"),
    @NamedQuery(name = "Manmas.findByCusno", query = "SELECT m FROM Manmas m WHERE m.cusno = :cusno"),
    @NamedQuery(name = "Manmas.findByMankind", query = "SELECT m FROM Manmas m WHERE m.mankind = :mankind"),
    @NamedQuery(name = "Manmas.findByManqty", query = "SELECT m FROM Manmas m WHERE m.manqty = :manqty"),
    @NamedQuery(name = "Manmas.findByMandate", query = "SELECT m FROM Manmas m WHERE m.mandate = :mandate"),
    @NamedQuery(name = "Manmas.findByManstatus", query = "SELECT m FROM Manmas m WHERE m.manstatus = :manstatus"),
    @NamedQuery(name = "Manmas.findByTypecode", query = "SELECT m FROM Manmas m WHERE m.typecode = :typecode")})
public class Manmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManmasPK manmasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "linecode")
    private String linecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "mankind")
    private String mankind;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "manqty")
    private BigDecimal manqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mandate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mandate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manstatus")
    private Character manstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "typecode")
    private String typecode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finqty")
    private BigDecimal finqty;
    @Column(name = "findate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date findate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mrpqty")
    private BigDecimal mrpqty;
    @Column(name = "mrpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mrpdate;
    @Size(max = 10)
    @Column(name = "mrpnr")
    private String mrpnr;
    @Size(max = 10)
    @Column(name = "batnr")
    private String batnr;
    @Size(max = 18)
    @Column(name = "manlotno")
    private String manlotno;
    @Size(max = 20)
    @Column(name = "itnbrh")
    private String itnbrh;
    @Size(max = 18)
    @Column(name = "refno")
    private String refno;
    @Column(name = "refseq")
    private Short refseq;
    @Size(max = 8)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 8)
    @Column(name = "remark2")
    private String remark2;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "milcode")
    private Character milcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "keyindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyindate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "issdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issdate;
    @Column(name = "misdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date misdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issqty")
    private BigDecimal issqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preqty")
    private BigDecimal preqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posdate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 20)
    @Column(name = "itnbrgrp")
    private String itnbrgrp;
    @Column(name = "batsiz")
    private BigDecimal batsiz;
    @Column(name = "batqty")
    private BigDecimal batqty;
    @Column(name = "mapqty")
    private BigDecimal mapqty;
    @Column(name = "mrplevel")
    private Short mrplevel;
    @Column(name = "schdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schdate;
    @Size(max = 20)
    @Column(name = "yycode")
    private String yycode;
    @Size(max = 20)
    @Column(name = "kfdh")
    private String kfdh;
    @Size(max = 200)
    @Column(name = "mark1")
    private String mark1;

    public Manmas() {
    }

    public Manmas(ManmasPK manmasPK) {
        this.manmasPK = manmasPK;
    }

    public Manmas(ManmasPK manmasPK, String linecode, String itnbrf, String cusno, String mankind, BigDecimal manqty, Date mandate, Character manstatus, String typecode, BigDecimal finqty, BigDecimal mrpqty, Character milcode, Date keyindate, String userno, BigDecimal issqty, BigDecimal preqty, Date posdate) {
        this.manmasPK = manmasPK;
        this.linecode = linecode;
        this.itnbrf = itnbrf;
        this.cusno = cusno;
        this.mankind = mankind;
        this.manqty = manqty;
        this.mandate = mandate;
        this.manstatus = manstatus;
        this.typecode = typecode;
        this.finqty = finqty;
        this.mrpqty = mrpqty;
        this.milcode = milcode;
        this.keyindate = keyindate;
        this.userno = userno;
        this.issqty = issqty;
        this.preqty = preqty;
        this.posdate = posdate;
    }

    public Manmas(String facno, String prono, String manno) {
        this.manmasPK = new ManmasPK(facno, prono, manno);
    }

    public ManmasPK getManmasPK() {
        return manmasPK;
    }

    public void setManmasPK(ManmasPK manmasPK) {
        this.manmasPK = manmasPK;
    }

    public String getLinecode() {
        return linecode;
    }

    public void setLinecode(String linecode) {
        this.linecode = linecode;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getMankind() {
        return mankind;
    }

    public void setMankind(String mankind) {
        this.mankind = mankind;
    }

    public BigDecimal getManqty() {
        return manqty;
    }

    public void setManqty(BigDecimal manqty) {
        this.manqty = manqty;
    }

    public Date getMandate() {
        return mandate;
    }

    public void setMandate(Date mandate) {
        this.mandate = mandate;
    }

    public Character getManstatus() {
        return manstatus;
    }

    public void setManstatus(Character manstatus) {
        this.manstatus = manstatus;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public BigDecimal getFinqty() {
        return finqty;
    }

    public void setFinqty(BigDecimal finqty) {
        this.finqty = finqty;
    }

    public Date getFindate() {
        return findate;
    }

    public void setFindate(Date findate) {
        this.findate = findate;
    }

    public BigDecimal getMrpqty() {
        return mrpqty;
    }

    public void setMrpqty(BigDecimal mrpqty) {
        this.mrpqty = mrpqty;
    }

    public Date getMrpdate() {
        return mrpdate;
    }

    public void setMrpdate(Date mrpdate) {
        this.mrpdate = mrpdate;
    }

    public String getMrpnr() {
        return mrpnr;
    }

    public void setMrpnr(String mrpnr) {
        this.mrpnr = mrpnr;
    }

    public String getBatnr() {
        return batnr;
    }

    public void setBatnr(String batnr) {
        this.batnr = batnr;
    }

    public String getManlotno() {
        return manlotno;
    }

    public void setManlotno(String manlotno) {
        this.manlotno = manlotno;
    }

    public String getItnbrh() {
        return itnbrh;
    }

    public void setItnbrh(String itnbrh) {
        this.itnbrh = itnbrh;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public Short getRefseq() {
        return refseq;
    }

    public void setRefseq(Short refseq) {
        this.refseq = refseq;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public Character getMilcode() {
        return milcode;
    }

    public void setMilcode(Character milcode) {
        this.milcode = milcode;
    }

    public Date getKeyindate() {
        return keyindate;
    }

    public void setKeyindate(Date keyindate) {
        this.keyindate = keyindate;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIssdate() {
        return issdate;
    }

    public void setIssdate(Date issdate) {
        this.issdate = issdate;
    }

    public Date getMisdate() {
        return misdate;
    }

    public void setMisdate(Date misdate) {
        this.misdate = misdate;
    }

    public BigDecimal getIssqty() {
        return issqty;
    }

    public void setIssqty(BigDecimal issqty) {
        this.issqty = issqty;
    }

    public BigDecimal getPreqty() {
        return preqty;
    }

    public void setPreqty(BigDecimal preqty) {
        this.preqty = preqty;
    }

    public Date getPosdate() {
        return posdate;
    }

    public void setPosdate(Date posdate) {
        this.posdate = posdate;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getItnbrgrp() {
        return itnbrgrp;
    }

    public void setItnbrgrp(String itnbrgrp) {
        this.itnbrgrp = itnbrgrp;
    }

    public BigDecimal getBatsiz() {
        return batsiz;
    }

    public void setBatsiz(BigDecimal batsiz) {
        this.batsiz = batsiz;
    }

    public BigDecimal getBatqty() {
        return batqty;
    }

    public void setBatqty(BigDecimal batqty) {
        this.batqty = batqty;
    }

    public BigDecimal getMapqty() {
        return mapqty;
    }

    public void setMapqty(BigDecimal mapqty) {
        this.mapqty = mapqty;
    }

    public Short getMrplevel() {
        return mrplevel;
    }

    public void setMrplevel(Short mrplevel) {
        this.mrplevel = mrplevel;
    }

    public Date getSchdate() {
        return schdate;
    }

    public void setSchdate(Date schdate) {
        this.schdate = schdate;
    }

    public String getYycode() {
        return yycode;
    }

    public void setYycode(String yycode) {
        this.yycode = yycode;
    }

    public String getKfdh() {
        return kfdh;
    }

    public void setKfdh(String kfdh) {
        this.kfdh = kfdh;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manmasPK != null ? manmasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manmas)) {
            return false;
        }
        Manmas other = (Manmas) object;
        if ((this.manmasPK == null && other.manmasPK != null) || (this.manmasPK != null && !this.manmasPK.equals(other.manmasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Manmas[ manmasPK=" + manmasPK + " ]";
    }

}
