/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "cdrdta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrdta.findAll", query = "SELECT c FROM Cdrdta c"),
    @NamedQuery(name = "Cdrdta.findByFacno", query = "SELECT c FROM Cdrdta c WHERE c.cdrdtaPK.facno = :facno"),
    @NamedQuery(name = "Cdrdta.findByShpno", query = "SELECT c FROM Cdrdta c WHERE c.cdrdtaPK.shpno = :shpno"),
    @NamedQuery(name = "Cdrdta.findByCdrno", query = "SELECT c FROM Cdrdta c WHERE c.cdrno = :cdrno"),
    @NamedQuery(name = "Cdrdta.findByItnbr", query = "SELECT c FROM Cdrdta c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrdta.findByItnbrcus", query = "SELECT c FROM Cdrdta c WHERE c.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "Cdrdta.findByWareh", query = "SELECT c FROM Cdrdta c WHERE c.wareh = :wareh"),
    @NamedQuery(name = "Cdrdta.findByTrtype", query = "SELECT c FROM Cdrdta c WHERE c.trtype = :trtype")})
public class Cdrdta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrdtaPK cdrdtaPK;
    @Size(max = 18)
    @Column(name = "cdrno")
    private String cdrno;
    @Column(name = "ctrseq")
    private Short ctrseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 30)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 20)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 12)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 18)
    @Column(name = "varnr")
    private String varnr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpqy1")
    private BigDecimal shpqy1;
    @Column(name = "shpqy2")
    private BigDecimal shpqy2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "armqy")
    private BigDecimal armqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unprisrccode")
    private Character unprisrccode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpamts")
    private BigDecimal shpamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivoamts")
    private BigDecimal ivoamts;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 8)
    @Column(name = "dmark3")
    private String dmark3;
    @Size(max = 8)
    @Column(name = "dmark4")
    private String dmark4;
    @Size(max = 4)
    @Column(name = "unmsr9")
    private String unmsr9;
    @Size(max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Size(max = 60)
    @Column(name = "cusmark")
    private String cusmark;
    @Size(max = 30)
    @Column(name = "cuslable")
    private String cuslable;
    @Column(name = "islableprt")
    private Character islableprt;
    @Size(max = 30)
    @Column(name = "matecode")
    private String matecode;
    @Column(name = "psamts")
    private BigDecimal psamts;
    @Column(name = "msamts")
    private BigDecimal msamts;
    @Column(name = "issevdta")
    private Character issevdta;

    public Cdrdta() {
    }

    public Cdrdta(CdrdtaPK cdrdtaPK) {
        this.cdrdtaPK = cdrdtaPK;
    }

    public Cdrdta(CdrdtaPK cdrdtaPK, String itnbr, String itdsc, String prono, BigDecimal shpqy1, BigDecimal armqy, BigDecimal unpris, Character unprisrccode, BigDecimal shpamts, BigDecimal ivoamts) {
        this.cdrdtaPK = cdrdtaPK;
        this.itnbr = itnbr;
        this.itdsc = itdsc;
        this.prono = prono;
        this.shpqy1 = shpqy1;
        this.armqy = armqy;
        this.unpris = unpris;
        this.unprisrccode = unprisrccode;
        this.shpamts = shpamts;
        this.ivoamts = ivoamts;
    }

    public Cdrdta(String facno, String shpno, short trseq) {
        this.cdrdtaPK = new CdrdtaPK(facno, shpno, trseq);
    }

    public CdrdtaPK getCdrdtaPK() {
        return cdrdtaPK;
    }

    public void setCdrdtaPK(CdrdtaPK cdrdtaPK) {
        this.cdrdtaPK = cdrdtaPK;
    }

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
    }

    public Short getCtrseq() {
        return ctrseq;
    }

    public void setCtrseq(Short ctrseq) {
        this.ctrseq = ctrseq;
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

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
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

    public BigDecimal getShpqy1() {
        return shpqy1;
    }

    public void setShpqy1(BigDecimal shpqy1) {
        this.shpqy1 = shpqy1;
    }

    public BigDecimal getShpqy2() {
        return shpqy2;
    }

    public void setShpqy2(BigDecimal shpqy2) {
        this.shpqy2 = shpqy2;
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

    public Character getUnprisrccode() {
        return unprisrccode;
    }

    public void setUnprisrccode(Character unprisrccode) {
        this.unprisrccode = unprisrccode;
    }

    public BigDecimal getShpamts() {
        return shpamts;
    }

    public void setShpamts(BigDecimal shpamts) {
        this.shpamts = shpamts;
    }

    public BigDecimal getIvoamts() {
        return ivoamts;
    }

    public void setIvoamts(BigDecimal ivoamts) {
        this.ivoamts = ivoamts;
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

    public String getDmark3() {
        return dmark3;
    }

    public void setDmark3(String dmark3) {
        this.dmark3 = dmark3;
    }

    public String getDmark4() {
        return dmark4;
    }

    public void setDmark4(String dmark4) {
        this.dmark4 = dmark4;
    }

    public String getUnmsr9() {
        return unmsr9;
    }

    public void setUnmsr9(String unmsr9) {
        this.unmsr9 = unmsr9;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getCusmark() {
        return cusmark;
    }

    public void setCusmark(String cusmark) {
        this.cusmark = cusmark;
    }

    public String getCuslable() {
        return cuslable;
    }

    public void setCuslable(String cuslable) {
        this.cuslable = cuslable;
    }

    public Character getIslableprt() {
        return islableprt;
    }

    public void setIslableprt(Character islableprt) {
        this.islableprt = islableprt;
    }

    public String getMatecode() {
        return matecode;
    }

    public void setMatecode(String matecode) {
        this.matecode = matecode;
    }

    public BigDecimal getPsamts() {
        return psamts;
    }

    public void setPsamts(BigDecimal psamts) {
        this.psamts = psamts;
    }

    public BigDecimal getMsamts() {
        return msamts;
    }

    public void setMsamts(BigDecimal msamts) {
        this.msamts = msamts;
    }

    public Character getIssevdta() {
        return issevdta;
    }

    public void setIssevdta(Character issevdta) {
        this.issevdta = issevdta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrdtaPK != null ? cdrdtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrdta)) {
            return false;
        }
        Cdrdta other = (Cdrdta) object;
        if ((this.cdrdtaPK == null && other.cdrdtaPK != null) || (this.cdrdtaPK != null && !this.cdrdtaPK.equals(other.cdrdtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shberp.entity.Cdrdta[ cdrdtaPK=" + cdrdtaPK + " ]";
    }

}
