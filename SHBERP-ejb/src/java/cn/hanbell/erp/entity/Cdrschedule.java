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
 * @author C0160
 */
@Entity
@Table(name = "cdrschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrschedule.findAll", query = "SELECT c FROM Cdrschedule c"),
    @NamedQuery(name = "Cdrschedule.findByCdrno", query = "SELECT c FROM Cdrschedule c WHERE c.cdrschedulePK.cdrno = :cdrno"),
    @NamedQuery(name = "Cdrschedule.findByKindcode", query = "SELECT c FROM Cdrschedule c WHERE c.kindcode = :kindcode"),
    @NamedQuery(name = "Cdrschedule.findByItnbrcus", query = "SELECT c FROM Cdrschedule c WHERE c.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "Cdrschedule.findByItnbr", query = "SELECT c FROM Cdrschedule c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrschedule.findByAreacode", query = "SELECT c FROM Cdrschedule c WHERE c.areacode = :areacode"),
    @NamedQuery(name = "Cdrschedule.findByCusnoDefault", query = "SELECT c FROM Cdrschedule c WHERE c.cusno = :cusno AND c.status != 'Y' ORDER BY c.shipday1 "),
    @NamedQuery(name = "Cdrschedule.findByCusnoClosed", query = "SELECT c FROM Cdrschedule c WHERE c.cusno = :cusno AND c.status = 'Y' "),
    @NamedQuery(name = "Cdrschedule.findByCusnoAll", query = "SELECT c FROM Cdrschedule c WHERE c.cusno = :cusno "),
    @NamedQuery(name = "Cdrschedule.findByStatus", query = "SELECT c FROM Cdrschedule c WHERE c.status = :status")})
public class Cdrschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrschedulePK cdrschedulePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kindcode")
    private String kindcode;
    @Size(max = 30)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 60)
    @Column(name = "itdsc")
    private String itdsc;
    @Column(name = "recdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recdate;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "areacode")
    private String areacode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cusna")
    private String cusna;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigDecimal qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inqty")
    private BigDecimal inqty;
    @Column(name = "shipday1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipday1;
    @Column(name = "shipday2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipday2;
    @Size(max = 60)
    @Column(name = "shipid")
    private String shipid;
    @Column(name = "ppday1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppday1;
    @Column(name = "ppday2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppday2;
    @Size(max = 60)
    @Column(name = "manno")
    private String manno;
    @Column(name = "manday1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date manday1;
    @Column(name = "finday1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finday1;
    @Size(max = 2)
    @Column(name = "manstatus")
    private String manstatus;
    @Size(max = 500)
    @Column(name = "sn")
    private String sn;
    @Size(max = 200)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 200)
    @Column(name = "remark2")
    private String remark2;
    @Size(max = 20)
    @Column(name = "remark3")
    private String remark3;
    @Size(max = 10)
    @Column(name = "optuser")
    private String optuser;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    @Size(max = 20)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 20)
    @Column(name = "dmark2")
    private String dmark2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipqty")
    private BigDecimal shipqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manqty")
    private BigDecimal manqty;
    @Size(max = 10)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 40)
    @Column(name = "cuspono")
    private String cuspono;

    public Cdrschedule() {
    }

    public Cdrschedule(CdrschedulePK cdrschedulePK) {
        this.cdrschedulePK = cdrschedulePK;
    }

    public Cdrschedule(CdrschedulePK cdrschedulePK, String kindcode, String itnbr, String areacode, String cusno, String cusna, BigDecimal qty, BigDecimal inqty, String status, BigDecimal shipqty, BigDecimal manqty) {
        this.cdrschedulePK = cdrschedulePK;
        this.kindcode = kindcode;
        this.itnbr = itnbr;
        this.areacode = areacode;
        this.cusno = cusno;
        this.cusna = cusna;
        this.qty = qty;
        this.inqty = inqty;
        this.status = status;
        this.shipqty = shipqty;
        this.manqty = manqty;
    }

    public Cdrschedule(String facno, String cdrno) {
        this.cdrschedulePK = new CdrschedulePK(facno, cdrno);
    }

    public CdrschedulePK getCdrschedulePK() {
        return cdrschedulePK;
    }

    public void setCdrschedulePK(CdrschedulePK cdrschedulePK) {
        this.cdrschedulePK = cdrschedulePK;
    }

    public String getKindcode() {
        return kindcode;
    }

    public void setKindcode(String kindcode) {
        this.kindcode = kindcode;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public Date getRecdate() {
        return recdate;
    }

    public void setRecdate(Date recdate) {
        this.recdate = recdate;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getInqty() {
        return inqty;
    }

    public void setInqty(BigDecimal inqty) {
        this.inqty = inqty;
    }

    public Date getShipday1() {
        return shipday1;
    }

    public void setShipday1(Date shipday1) {
        this.shipday1 = shipday1;
    }

    public Date getShipday2() {
        return shipday2;
    }

    public void setShipday2(Date shipday2) {
        this.shipday2 = shipday2;
    }

    public String getShipid() {
        return shipid;
    }

    public void setShipid(String shipid) {
        this.shipid = shipid;
    }

    public Date getPpday1() {
        return ppday1;
    }

    public void setPpday1(Date ppday1) {
        this.ppday1 = ppday1;
    }

    public Date getPpday2() {
        return ppday2;
    }

    public void setPpday2(Date ppday2) {
        this.ppday2 = ppday2;
    }

    public String getManno() {
        return manno;
    }

    public void setManno(String manno) {
        this.manno = manno;
    }

    public Date getManday1() {
        return manday1;
    }

    public void setManday1(Date manday1) {
        this.manday1 = manday1;
    }

    public Date getFinday1() {
        return finday1;
    }

    public void setFinday1(Date finday1) {
        this.finday1 = finday1;
    }

    public String getManstatus() {
        return manstatus;
    }

    public void setManstatus(String manstatus) {
        this.manstatus = manstatus;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public BigDecimal getShipqty() {
        return shipqty;
    }

    public void setShipqty(BigDecimal shipqty) {
        this.shipqty = shipqty;
    }

    public BigDecimal getManqty() {
        return manqty;
    }

    public void setManqty(BigDecimal manqty) {
        this.manqty = manqty;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getCuspono() {
        return cuspono;
    }

    public void setCuspono(String cuspono) {
        this.cuspono = cuspono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrschedulePK != null ? cdrschedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrschedule)) {
            return false;
        }
        Cdrschedule other = (Cdrschedule) object;
        if ((this.cdrschedulePK == null && other.cdrschedulePK != null) || (this.cdrschedulePK != null && !this.cdrschedulePK.equals(other.cdrschedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.Cdrschedule[ cdrschedulePK=" + cdrschedulePK + " ]";
    }

}
