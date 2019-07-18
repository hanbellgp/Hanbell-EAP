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
 * @author Administrator
 */
@Entity
@Table(name = "cdrlnhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrlnhad.findAll", query = "SELECT c FROM Cdrlnhad c"),
    @NamedQuery(name = "Cdrlnhad.findByFacno", query = "SELECT c FROM Cdrlnhad c WHERE c.cdrlnhadPK.facno = :facno"),
    @NamedQuery(name = "Cdrlnhad.findByTrno", query = "SELECT c FROM Cdrlnhad c WHERE c.cdrlnhadPK.trno = :trno"),
    @NamedQuery(name = "Cdrlnhad.findByCdrobtype", query = "SELECT c FROM Cdrlnhad c WHERE c.cdrobtype = :cdrobtype"),
    @NamedQuery(name = "Cdrlnhad.findByKfno", query = "SELECT c FROM Cdrlnhad c WHERE c.kfno = :kfno"),
    @NamedQuery(name = "Cdrlnhad.findByFwno", query = "SELECT c FROM Cdrlnhad c WHERE c.fwno = :fwno"),
    @NamedQuery(name = "Cdrlnhad.findByBugdsc", query = "SELECT c FROM Cdrlnhad c WHERE c.bugdsc = :bugdsc"),
    @NamedQuery(name = "Cdrlnhad.findByAsrsstatus", query = "SELECT c FROM Cdrlnhad c WHERE c.asrsstatus = :asrsstatus"),
    @NamedQuery(name = "Cdrlnhad.findByPK", query = "SELECT c FROM Cdrlnhad c WHERE c.cdrlnhadPK.facno = :facno AND c.cdrlnhadPK.trno = :trno"),
    @NamedQuery(name = "Cdrlnhad.findByYuy", query = "SELECT c FROM Cdrlnhad c WHERE c.yuy = :yuy")})
public class Cdrlnhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrlnhadPK cdrlnhadPK;
    @Size(max = 3)
    @Column(name = "cdrobtype")
    private String cdrobtype;
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Size(max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 8)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 8)
    @Column(name = "resno")
    private String resno;
    @Size(max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Column(name = "status")
    private Character status;
    @Column(name = "prtcnt")
    private Short prtcnt;
    @Size(max = 12)
    @Column(name = "lnwareh")
    private String lnwareh;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 60)
    @Column(name = "hmark01")
    private String hmark01;
    @Size(max = 60)
    @Column(name = "hmark02")
    private String hmark02;
    @Column(name = "shptrseq")
    private Short shptrseq;
    @Column(name = "tax")
    private Character tax;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 4)
    @Column(name = "coin")
    private String coin;
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Column(name = "shpamts")
    private BigDecimal shpamts;
    @Column(name = "taxamts")
    private BigDecimal taxamts;
    @Column(name = "totamts")
    private BigDecimal totamts;
    @Size(max = 10)
    @Column(name = "headperson")
    private String headperson;
    @Size(max = 2)
    @Column(name = "objtype")
    private String objtype;
    @Size(max = 60)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 60)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 100)
    @Column(name = "bugdsc")
    private String bugdsc;
    @Size(max = 1)
    @Column(name = "asrsstatus")
    private String asrsstatus;
    @Size(max = 8)
    @Column(name = "yuy")
    private String yuy;

    public Cdrlnhad() {
    }

    public Cdrlnhad(CdrlnhadPK cdrlnhadPK) {
        this.cdrlnhadPK = cdrlnhadPK;
    }

    public Cdrlnhad(String facno, String trno) {
        this.cdrlnhadPK = new CdrlnhadPK(facno, trno);
    }

    public CdrlnhadPK getCdrlnhadPK() {
        return cdrlnhadPK;
    }

    public void setCdrlnhadPK(CdrlnhadPK cdrlnhadPK) {
        this.cdrlnhadPK = cdrlnhadPK;
    }

    public String getCdrobtype() {
        return cdrobtype;
    }

    public void setCdrobtype(String cdrobtype) {
        this.cdrobtype = cdrobtype;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public String getResno() {
        return resno;
    }

    public void setResno(String resno) {
        this.resno = resno;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(Short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public String getLnwareh() {
        return lnwareh;
    }

    public void setLnwareh(String lnwareh) {
        this.lnwareh = lnwareh;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getHmark01() {
        return hmark01;
    }

    public void setHmark01(String hmark01) {
        this.hmark01 = hmark01;
    }

    public String getHmark02() {
        return hmark02;
    }

    public void setHmark02(String hmark02) {
        this.hmark02 = hmark02;
    }

    public Short getShptrseq() {
        return shptrseq;
    }

    public void setShptrseq(Short shptrseq) {
        this.shptrseq = shptrseq;
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

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public BigDecimal getShpamts() {
        return shpamts;
    }

    public void setShpamts(BigDecimal shpamts) {
        this.shpamts = shpamts;
    }

    public BigDecimal getTaxamts() {
        return taxamts;
    }

    public void setTaxamts(BigDecimal taxamts) {
        this.taxamts = taxamts;
    }

    public BigDecimal getTotamts() {
        return totamts;
    }

    public void setTotamts(BigDecimal totamts) {
        this.totamts = totamts;
    }

    public String getHeadperson() {
        return headperson;
    }

    public void setHeadperson(String headperson) {
        this.headperson = headperson;
    }

    public String getObjtype() {
        return objtype;
    }

    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getBugdsc() {
        return bugdsc;
    }

    public void setBugdsc(String bugdsc) {
        this.bugdsc = bugdsc;
    }

    public String getAsrsstatus() {
        return asrsstatus;
    }

    public void setAsrsstatus(String asrsstatus) {
        this.asrsstatus = asrsstatus;
    }

    public String getYuy() {
        return yuy;
    }

    public void setYuy(String yuy) {
        this.yuy = yuy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrlnhadPK != null ? cdrlnhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrlnhad)) {
            return false;
        }
        Cdrlnhad other = (Cdrlnhad) object;
        if ((this.cdrlnhadPK == null && other.cdrlnhadPK != null) || (this.cdrlnhadPK != null && !this.cdrlnhadPK.equals(other.cdrlnhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrlnhad[ cdrlnhadPK=" + cdrlnhadPK + " ]";
    }

}
