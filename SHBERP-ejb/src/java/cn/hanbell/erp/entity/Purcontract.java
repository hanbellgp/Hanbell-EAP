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
 * @author Administrator
 */
@Entity
@Table(name = "purcontract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purcontract.findAll", query = "SELECT p FROM Purcontract p"),
    @NamedQuery(name = "Purcontract.findByProno", query = "SELECT p FROM Purcontract p WHERE p.purcontractPK.prono = :prono"),
    @NamedQuery(name = "Purcontract.findByContractno", query = "SELECT p FROM Purcontract p WHERE p.purcontractPK.contractno = :contractno"),
    @NamedQuery(name = "Purcontract.findBySeq", query = "SELECT p FROM Purcontract p WHERE p.purcontractPK.seq = :seq"),
    @NamedQuery(name = "Purcontract.findBySourceno", query = "SELECT p FROM Purcontract p WHERE p.sourceno = :sourceno"),
    @NamedQuery(name = "Purcontract.findByCoinqcode", query = "SELECT p FROM Purcontract p WHERE p.coinqcode = :coinqcode"),
    @NamedQuery(name = "Purcontract.findByVdrno", query = "SELECT p FROM Purcontract p WHERE p.vdrno = :vdrno"),
    @NamedQuery(name = "Purcontract.findByPcdate", query = "SELECT p FROM Purcontract p WHERE p.pcdate = :pcdate"),
    @NamedQuery(name = "Purcontract.findByFromdate", query = "SELECT p FROM Purcontract p WHERE p.fromdate = :fromdate"),
    @NamedQuery(name = "Purcontract.findByEnddate", query = "SELECT p FROM Purcontract p WHERE p.enddate = :enddate"),
    @NamedQuery(name = "Purcontract.findByUserno", query = "SELECT p FROM Purcontract p WHERE p.userno = :userno"),
    @NamedQuery(name = "Purcontract.findByTermedby", query = "SELECT p FROM Purcontract p WHERE p.termedby = :termedby"),
    @NamedQuery(name = "Purcontract.findByItnbrAndVdr", query = "SELECT p FROM Purcontract p WHERE p.purcontractPK.facno = :facno And p.purcontractPK.prono = :prono"
            + " AND p.itnbr= :itnbr AND p.vdrno= :vdrno AND (p.fromdate <= :fromdate AND p.enddate >= :enddate)")})
public class Purcontract implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurcontractPK purcontractPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sourceno")
    private Character sourceno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coinqcode")
    private Character coinqcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Column(name = "pcdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pcdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fromdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "mainvdryn")
    private Character mainvdryn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private Character tax;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 8)
    @Column(name = "buyer")
    private String buyer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "termcode")
    private String termcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sndcode")
    private String sndcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paycode")
    private Character paycode;
    @Column(name = "tickdays")
    private Short tickdays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 20)
    @Column(name = "itnbrvdr")
    private String itnbrvdr;
    @Size(max = 20)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "selpricode")
    private Character selpricode;
    @Column(name = "listunpri")
    private BigDecimal listunpri;
    @Column(name = "discnt")
    private Short discnt;
    @Column(name = "unpri")
    private BigDecimal unpri;
    @Column(name = "dispri0")
    private BigDecimal dispri0;
    @Column(name = "disqy1")
    private BigDecimal disqy1;
    @Column(name = "dispri1")
    private BigDecimal dispri1;
    @Column(name = "disqy2")
    private BigDecimal disqy2;
    @Column(name = "dispri2")
    private BigDecimal dispri2;
    @Column(name = "disqy3")
    private BigDecimal disqy3;
    @Column(name = "dispri3")
    private BigDecimal dispri3;
    @Column(name = "disqy4")
    private BigDecimal disqy4;
    @Column(name = "dispri4")
    private BigDecimal dispri4;
    @Column(name = "disqy5")
    private BigDecimal disqy5;
    @Column(name = "dispri5")
    private BigDecimal dispri5;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Size(max = 18)
    @Column(name = "termedby")
    private String termedby;

    public Purcontract() {
    }

    public Purcontract(PurcontractPK purcontractPK) {
        this.purcontractPK = purcontractPK;
    }

    public Purcontract(PurcontractPK purcontractPK, Character sourceno, Character coinqcode, String vdrno, Date fromdate, Date enddate, String coin, Character tax, BigDecimal taxrate, String termcode, String sndcode, Character paycode, String itnbr, Character selpricode, String userno) {
        this.purcontractPK = purcontractPK;
        this.sourceno = sourceno;
        this.coinqcode = coinqcode;
        this.vdrno = vdrno;
        this.fromdate = fromdate;
        this.enddate = enddate;
        this.coin = coin;
        this.tax = tax;
        this.taxrate = taxrate;
        this.termcode = termcode;
        this.sndcode = sndcode;
        this.paycode = paycode;
        this.itnbr = itnbr;
        this.selpricode = selpricode;
        this.userno = userno;
    }

    public Purcontract(String facno, String prono, String contractno, short seq) {
        this.purcontractPK = new PurcontractPK(facno, prono, contractno, seq);
    }

    public PurcontractPK getPurcontractPK() {
        return purcontractPK;
    }

    public void setPurcontractPK(PurcontractPK purcontractPK) {
        this.purcontractPK = purcontractPK;
    }

    public Character getSourceno() {
        return sourceno;
    }

    public void setSourceno(Character sourceno) {
        this.sourceno = sourceno;
    }

    public Character getCoinqcode() {
        return coinqcode;
    }

    public void setCoinqcode(Character coinqcode) {
        this.coinqcode = coinqcode;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public Date getPcdate() {
        return pcdate;
    }

    public void setPcdate(Date pcdate) {
        this.pcdate = pcdate;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Character getMainvdryn() {
        return mainvdryn;
    }

    public void setMainvdryn(Character mainvdryn) {
        this.mainvdryn = mainvdryn;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Character getTax() {
        return tax;
    }

    public void setTax(Character tax) {
        this.tax = tax;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public Character getPaycode() {
        return paycode;
    }

    public void setPaycode(Character paycode) {
        this.paycode = paycode;
    }

    public Short getTickdays() {
        return tickdays;
    }

    public void setTickdays(Short tickdays) {
        this.tickdays = tickdays;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItnbrvdr() {
        return itnbrvdr;
    }

    public void setItnbrvdr(String itnbrvdr) {
        this.itnbrvdr = itnbrvdr;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public Character getSelpricode() {
        return selpricode;
    }

    public void setSelpricode(Character selpricode) {
        this.selpricode = selpricode;
    }

    public BigDecimal getListunpri() {
        return listunpri;
    }

    public void setListunpri(BigDecimal listunpri) {
        this.listunpri = listunpri;
    }

    public Short getDiscnt() {
        return discnt;
    }

    public void setDiscnt(Short discnt) {
        this.discnt = discnt;
    }

    public BigDecimal getUnpri() {
        return unpri;
    }

    public void setUnpri(BigDecimal unpri) {
        this.unpri = unpri;
    }

    public BigDecimal getDispri0() {
        return dispri0;
    }

    public void setDispri0(BigDecimal dispri0) {
        this.dispri0 = dispri0;
    }

    public BigDecimal getDisqy1() {
        return disqy1;
    }

    public void setDisqy1(BigDecimal disqy1) {
        this.disqy1 = disqy1;
    }

    public BigDecimal getDispri1() {
        return dispri1;
    }

    public void setDispri1(BigDecimal dispri1) {
        this.dispri1 = dispri1;
    }

    public BigDecimal getDisqy2() {
        return disqy2;
    }

    public void setDisqy2(BigDecimal disqy2) {
        this.disqy2 = disqy2;
    }

    public BigDecimal getDispri2() {
        return dispri2;
    }

    public void setDispri2(BigDecimal dispri2) {
        this.dispri2 = dispri2;
    }

    public BigDecimal getDisqy3() {
        return disqy3;
    }

    public void setDisqy3(BigDecimal disqy3) {
        this.disqy3 = disqy3;
    }

    public BigDecimal getDispri3() {
        return dispri3;
    }

    public void setDispri3(BigDecimal dispri3) {
        this.dispri3 = dispri3;
    }

    public BigDecimal getDisqy4() {
        return disqy4;
    }

    public void setDisqy4(BigDecimal disqy4) {
        this.disqy4 = disqy4;
    }

    public BigDecimal getDispri4() {
        return dispri4;
    }

    public void setDispri4(BigDecimal dispri4) {
        this.dispri4 = dispri4;
    }

    public BigDecimal getDisqy5() {
        return disqy5;
    }

    public void setDisqy5(BigDecimal disqy5) {
        this.disqy5 = disqy5;
    }

    public BigDecimal getDispri5() {
        return dispri5;
    }

    public void setDispri5(BigDecimal dispri5) {
        this.dispri5 = dispri5;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getTermedby() {
        return termedby;
    }

    public void setTermedby(String termedby) {
        this.termedby = termedby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purcontractPK != null ? purcontractPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purcontract)) {
            return false;
        }
        Purcontract other = (Purcontract) object;
        if ((this.purcontractPK == null && other.purcontractPK != null) || (this.purcontractPK != null && !this.purcontractPK.equals(other.purcontractPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purcontract[ purcontractPK=" + purcontractPK + " ]";
    }

}
