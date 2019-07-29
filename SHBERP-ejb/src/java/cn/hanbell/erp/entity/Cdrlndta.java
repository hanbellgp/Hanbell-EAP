/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "cdrlndta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrlndta.findAll", query = "SELECT c FROM Cdrlndta c"),
    @NamedQuery(name = "Cdrlndta.findByFacno", query = "SELECT c FROM Cdrlndta c WHERE c.cdrlndtaPK.facno = :facno"),
    @NamedQuery(name = "Cdrlndta.findByTrno", query = "SELECT c FROM Cdrlndta c WHERE c.cdrlndtaPK.trno = :trno"),
    @NamedQuery(name = "Cdrlndta.findByTrseq", query = "SELECT c FROM Cdrlndta c WHERE c.cdrlndtaPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrlndta.findByPK", query = "SELECT c FROM Cdrlndta c WHERE c.cdrlndtaPK.facno = :facno AND c.cdrlndtaPK.trno = :trno AND c.cdrlndtaPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrlndta.findByItnbr", query = "SELECT c FROM Cdrlndta c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrlndta.findByTrnqy1", query = "SELECT c FROM Cdrlndta c WHERE c.trnqy1 = :trnqy1"),
    @NamedQuery(name = "Cdrlndta.findByTrnqy2", query = "SELECT c FROM Cdrlndta c WHERE c.trnqy2 = :trnqy2"),
    @NamedQuery(name = "Cdrlndta.findByWareh", query = "SELECT c FROM Cdrlndta c WHERE c.wareh = :wareh"),
    @NamedQuery(name = "Cdrlndta.findByFixnr", query = "SELECT c FROM Cdrlndta c WHERE c.fixnr = :fixnr"),
    @NamedQuery(name = "Cdrlndta.findByVarnr", query = "SELECT c FROM Cdrlndta c WHERE c.varnr = :varnr"),
    @NamedQuery(name = "Cdrlndta.findByTrdate", query = "SELECT c FROM Cdrlndta c WHERE c.trdate = :trdate"),
    @NamedQuery(name = "Cdrlndta.findByPrebkdate", query = "SELECT c FROM Cdrlndta c WHERE c.prebkdate = :prebkdate"),
    @NamedQuery(name = "Cdrlndta.findByRetqy1", query = "SELECT c FROM Cdrlndta c WHERE c.retqy1 = :retqy1"),
    @NamedQuery(name = "Cdrlndta.findByRetqy2", query = "SELECT c FROM Cdrlndta c WHERE c.retqy2 = :retqy2"),
    @NamedQuery(name = "Cdrlndta.findBySaleqy1", query = "SELECT c FROM Cdrlndta c WHERE c.saleqy1 = :saleqy1"),
    @NamedQuery(name = "Cdrlndta.findBySaleqy2", query = "SELECT c FROM Cdrlndta c WHERE c.saleqy2 = :saleqy2"),
    @NamedQuery(name = "Cdrlndta.findByStatus", query = "SELECT c FROM Cdrlndta c WHERE c.status = :status"),
    @NamedQuery(name = "Cdrlndta.findByDmark1", query = "SELECT c FROM Cdrlndta c WHERE c.dmark1 = :dmark1"),
    @NamedQuery(name = "Cdrlndta.findByDmark2", query = "SELECT c FROM Cdrlndta c WHERE c.dmark2 = :dmark2"),
    @NamedQuery(name = "Cdrlndta.findByProno", query = "SELECT c FROM Cdrlndta c WHERE c.prono = :prono"),
    @NamedQuery(name = "Cdrlndta.findByArmqy", query = "SELECT c FROM Cdrlndta c WHERE c.armqy = :armqy"),
    @NamedQuery(name = "Cdrlndta.findByUnpris", query = "SELECT c FROM Cdrlndta c WHERE c.unpris = :unpris"),
    @NamedQuery(name = "Cdrlndta.findByShpamts", query = "SELECT c FROM Cdrlndta c WHERE c.shpamts = :shpamts"),
    @NamedQuery(name = "Cdrlndta.findByBvarnr", query = "SELECT c FROM Cdrlndta c WHERE c.bvarnr = :bvarnr"),
    @NamedQuery(name = "Cdrlndta.findByBfixnr", query = "SELECT c FROM Cdrlndta c WHERE c.bfixnr = :bfixnr"),
    @NamedQuery(name = "Cdrlndta.findByAsrsQty", query = "SELECT c FROM Cdrlndta c WHERE c.asrsQty = :asrsQty"),
    @NamedQuery(name = "Cdrlndta.findByAsrsUser", query = "SELECT c FROM Cdrlndta c WHERE c.asrsUser = :asrsUser"),
    @NamedQuery(name = "Cdrlndta.findByAsrsDmark", query = "SELECT c FROM Cdrlndta c WHERE c.asrsDmark = :asrsDmark"),
    @NamedQuery(name = "Cdrlndta.findByAsrsSta", query = "SELECT c FROM Cdrlndta c WHERE c.asrsSta = :asrsSta")})
public class Cdrlndta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrlndtaPK cdrlndtaPK;
    @Size(max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "trnqy1")
    private BigDecimal trnqy1;
    @Column(name = "trnqy2")
    private BigDecimal trnqy2;
    @Size(max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 20)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 20)
    @Column(name = "varnr")
    private String varnr;
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Column(name = "prebkdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prebkdate;
    @Column(name = "retqy1")
    private BigDecimal retqy1;
    @Column(name = "retqy2")
    private BigDecimal retqy2;
    @Column(name = "saleqy1")
    private BigDecimal saleqy1;
    @Column(name = "saleqy2")
    private BigDecimal saleqy2;
    @Column(name = "status")
    private Character status;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Column(name = "armqy")
    private BigDecimal armqy;
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Column(name = "shpamts")
    private BigDecimal shpamts;
    @Size(max = 20)
    @Column(name = "bvarnr")
    private String bvarnr;
    @Size(max = 20)
    @Column(name = "bfixnr")
    private String bfixnr;
    @Column(name = "asrs_qty")
    private BigDecimal asrsQty;
    @Size(max = 20)
    @Column(name = "asrs_user")
    private String asrsUser;
    @Size(max = 60)
    @Column(name = "asrs_dmark")
    private String asrsDmark;
    @Column(name = "asrs_sta")
    private Integer asrsSta;

    public Cdrlndta() {
    }

    public Cdrlndta(CdrlndtaPK cdrlndtaPK) {
        this.cdrlndtaPK = cdrlndtaPK;
    }

    public Cdrlndta(String facno, String trno, short trseq) {
        this.cdrlndtaPK = new CdrlndtaPK(facno, trno, trseq);
    }

    public CdrlndtaPK getCdrlndtaPK() {
        return cdrlndtaPK;
    }

    public void setCdrlndtaPK(CdrlndtaPK cdrlndtaPK) {
        this.cdrlndtaPK = cdrlndtaPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public BigDecimal getTrnqy1() {
        return trnqy1;
    }

    public void setTrnqy1(BigDecimal trnqy1) {
        this.trnqy1 = trnqy1;
    }

    public BigDecimal getTrnqy2() {
        return trnqy2;
    }

    public void setTrnqy2(BigDecimal trnqy2) {
        this.trnqy2 = trnqy2;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public Date getPrebkdate() {
        return prebkdate;
    }

    public void setPrebkdate(Date prebkdate) {
        this.prebkdate = prebkdate;
    }

    public BigDecimal getRetqy1() {
        return retqy1;
    }

    public void setRetqy1(BigDecimal retqy1) {
        this.retqy1 = retqy1;
    }

    public BigDecimal getRetqy2() {
        return retqy2;
    }

    public void setRetqy2(BigDecimal retqy2) {
        this.retqy2 = retqy2;
    }

    public BigDecimal getSaleqy1() {
        return saleqy1;
    }

    public void setSaleqy1(BigDecimal saleqy1) {
        this.saleqy1 = saleqy1;
    }

    public BigDecimal getSaleqy2() {
        return saleqy2;
    }

    public void setSaleqy2(BigDecimal saleqy2) {
        this.saleqy2 = saleqy2;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
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

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public BigDecimal getArmqy() {
        return armqy;
    }

    public void setArmqy(BigDecimal armqy) {
        this.armqy = armqy;
    }

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
    }

    public BigDecimal getShpamts() {
        return shpamts;
    }

    public void setShpamts(BigDecimal shpamts) {
        this.shpamts = shpamts;
    }

    public String getBvarnr() {
        return bvarnr;
    }

    public void setBvarnr(String bvarnr) {
        this.bvarnr = bvarnr;
    }

    public String getBfixnr() {
        return bfixnr;
    }

    public void setBfixnr(String bfixnr) {
        this.bfixnr = bfixnr;
    }

    public BigDecimal getAsrsQty() {
        return asrsQty;
    }

    public void setAsrsQty(BigDecimal asrsQty) {
        this.asrsQty = asrsQty;
    }

    public String getAsrsUser() {
        return asrsUser;
    }

    public void setAsrsUser(String asrsUser) {
        this.asrsUser = asrsUser;
    }

    public String getAsrsDmark() {
        return asrsDmark;
    }

    public void setAsrsDmark(String asrsDmark) {
        this.asrsDmark = asrsDmark;
    }

    public Integer getAsrsSta() {
        return asrsSta;
    }

    public void setAsrsSta(Integer asrsSta) {
        this.asrsSta = asrsSta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrlndtaPK != null ? cdrlndtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrlndta)) {
            return false;
        }
        Cdrlndta other = (Cdrlndta) object;
        if ((this.cdrlndtaPK == null && other.cdrlndtaPK != null) || (this.cdrlndtaPK != null && !this.cdrlndtaPK.equals(other.cdrlndtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrlndta[ cdrlndtaPK=" + cdrlndtaPK + " ]";
    }

}
