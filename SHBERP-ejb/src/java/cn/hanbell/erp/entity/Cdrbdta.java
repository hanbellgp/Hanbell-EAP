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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "cdrbdta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrbdta.findAll", query = "SELECT c FROM Cdrbdta c"),
    @NamedQuery(name = "Cdrbdta.findByFacno", query = "SELECT c FROM Cdrbdta c WHERE c.cdrbdtaPK.facno = :facno"),
    @NamedQuery(name = "Cdrbdta.findByBakno", query = "SELECT c FROM Cdrbdta c WHERE c.cdrbdtaPK.bakno = :bakno"),
    @NamedQuery(name = "Cdrbdta.findByTrseq", query = "SELECT c FROM Cdrbdta c WHERE c.cdrbdtaPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrbdta.findByShpno", query = "SELECT c FROM Cdrbdta c WHERE c.shpno = :shpno"),
    @NamedQuery(name = "Cdrbdta.findByStrseq", query = "SELECT c FROM Cdrbdta c WHERE c.strseq = :strseq"),
    @NamedQuery(name = "Cdrbdta.findByCdrno", query = "SELECT c FROM Cdrbdta c WHERE c.cdrno = :cdrno"),
    @NamedQuery(name = "Cdrbdta.findByCtrseq", query = "SELECT c FROM Cdrbdta c WHERE c.ctrseq = :ctrseq"),
    @NamedQuery(name = "Cdrbdta.findByInvoiceno", query = "SELECT c FROM Cdrbdta c WHERE c.invoiceno = :invoiceno"),
    @NamedQuery(name = "Cdrbdta.findByItnbr", query = "SELECT c FROM Cdrbdta c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrbdta.findByItdsc", query = "SELECT c FROM Cdrbdta c WHERE c.itdsc = :itdsc"),
    @NamedQuery(name = "Cdrbdta.findBySpdsc", query = "SELECT c FROM Cdrbdta c WHERE c.spdsc = :spdsc"),
    @NamedQuery(name = "Cdrbdta.findByItnbrcus", query = "SELECT c FROM Cdrbdta c WHERE c.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "Cdrbdta.findByProno", query = "SELECT c FROM Cdrbdta c WHERE c.prono = :prono"),
    @NamedQuery(name = "Cdrbdta.findByWareh", query = "SELECT c FROM Cdrbdta c WHERE c.wareh = :wareh"),
    @NamedQuery(name = "Cdrbdta.findByFixnr", query = "SELECT c FROM Cdrbdta c WHERE c.fixnr = :fixnr"),
    @NamedQuery(name = "Cdrbdta.findByVarnr", query = "SELECT c FROM Cdrbdta c WHERE c.varnr = :varnr"),
    @NamedQuery(name = "Cdrbdta.findByBshpqy1", query = "SELECT c FROM Cdrbdta c WHERE c.bshpqy1 = :bshpqy1"),
    @NamedQuery(name = "Cdrbdta.findByBshpqy2", query = "SELECT c FROM Cdrbdta c WHERE c.bshpqy2 = :bshpqy2"),
    @NamedQuery(name = "Cdrbdta.findByBarmqy", query = "SELECT c FROM Cdrbdta c WHERE c.barmqy = :barmqy"),
    @NamedQuery(name = "Cdrbdta.findByUnpris", query = "SELECT c FROM Cdrbdta c WHERE c.unpris = :unpris"),
    @NamedQuery(name = "Cdrbdta.findByBakamts", query = "SELECT c FROM Cdrbdta c WHERE c.bakamts = :bakamts"),
    @NamedQuery(name = "Cdrbdta.findByAddamts", query = "SELECT c FROM Cdrbdta c WHERE c.addamts = :addamts"),
    @NamedQuery(name = "Cdrbdta.findBySubamts", query = "SELECT c FROM Cdrbdta c WHERE c.subamts = :subamts"),
    @NamedQuery(name = "Cdrbdta.findByMapamts", query = "SELECT c FROM Cdrbdta c WHERE c.mapamts = :mapamts"),
    @NamedQuery(name = "Cdrbdta.findByCmpno", query = "SELECT c FROM Cdrbdta c WHERE c.cmpno = :cmpno"),
    @NamedQuery(name = "Cdrbdta.findByCmpseq", query = "SELECT c FROM Cdrbdta c WHERE c.cmpseq = :cmpseq"),
    @NamedQuery(name = "Cdrbdta.findByCmpyn", query = "SELECT c FROM Cdrbdta c WHERE c.cmpyn = :cmpyn"),
    @NamedQuery(name = "Cdrbdta.findByDmark1", query = "SELECT c FROM Cdrbdta c WHERE c.dmark1 = :dmark1"),
    @NamedQuery(name = "Cdrbdta.findByDmark2", query = "SELECT c FROM Cdrbdta c WHERE c.dmark2 = :dmark2"),
    @NamedQuery(name = "Cdrbdta.findByUnmsr9", query = "SELECT c FROM Cdrbdta c WHERE c.unmsr9 = :unmsr9"),
    @NamedQuery(name = "Cdrbdta.findByReplenish", query = "SELECT c FROM Cdrbdta c WHERE c.replenish = :replenish"),
    @NamedQuery(name = "Cdrbdta.findByPreqy1", query = "SELECT c FROM Cdrbdta c WHERE c.preqy1 = :preqy1"),
    @NamedQuery(name = "Cdrbdta.findByPreqy2", query = "SELECT c FROM Cdrbdta c WHERE c.preqy2 = :preqy2"),
    @NamedQuery(name = "Cdrbdta.findByShpqy1", query = "SELECT c FROM Cdrbdta c WHERE c.shpqy1 = :shpqy1"),
    @NamedQuery(name = "Cdrbdta.findByShpqy2", query = "SELECT c FROM Cdrbdta c WHERE c.shpqy2 = :shpqy2"),
    @NamedQuery(name = "Cdrbdta.findByIssevdta", query = "SELECT c FROM Cdrbdta c WHERE c.issevdta = :issevdta"),
    @NamedQuery(name = "Cdrbdta.findByNcodeDA", query = "SELECT c FROM Cdrbdta c WHERE c.ncodeDA = :ncodeDA"),
    @NamedQuery(name = "Cdrbdta.findByNcodeCD", query = "SELECT c FROM Cdrbdta c WHERE c.ncodeCD = :ncodeCD"),
    @NamedQuery(name = "Cdrbdta.findByNcodeDC", query = "SELECT c FROM Cdrbdta c WHERE c.ncodeDC = :ncodeDC"),
    @NamedQuery(name = "Cdrbdta.findByNcodeDD", query = "SELECT c FROM Cdrbdta c WHERE c.ncodeDD = :ncodeDD"),
    @NamedQuery(name = "Cdrbdta.findByBaknoAndItnbr", query = "SELECT c FROM Cdrbdta c WHERE c.cdrbdtaPK.bakno = :bakno AND c.itnbr = :itnbr")})
public class Cdrbdta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrbdtaPK cdrbdtaPK;
    @Size(max = 18)
    @Column(name = "shpno")
    private String shpno;
    @Column(name = "strseq")
    private Short strseq;
    @Size(max = 18)
    @Column(name = "cdrno")
    private String cdrno;
    @Column(name = "ctrseq")
    private Short ctrseq;
    @Size(max = 20)
    @Column(name = "invoiceno")
    private String invoiceno;
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
    @Size(max = 20)
    @Column(name = "prono")
    private String prono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
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
    @Column(name = "bshpqy1")
    private BigDecimal bshpqy1;
    @Column(name = "bshpqy2")
    private BigDecimal bshpqy2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "barmqy")
    private BigDecimal barmqy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bakamts")
    private BigDecimal bakamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addamts")
    private BigDecimal addamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subamts")
    private BigDecimal subamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mapamts")
    private BigDecimal mapamts;
    @Size(max = 18)
    @Column(name = "cmpno")
    private String cmpno;
    @Column(name = "cmpseq")
    private Short cmpseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cmpyn")
    private Character cmpyn;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 4)
    @Column(name = "unmsr9")
    private String unmsr9;
    @Column(name = "replenish")
    private Character replenish;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preqy1")
    private BigDecimal preqy1;
    @Column(name = "preqy2")
    private BigDecimal preqy2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpqy1")
    private BigDecimal shpqy1;
    @Column(name = "shpqy2")
    private BigDecimal shpqy2;
    @Column(name = "issevdta")
    private Character issevdta;
    @Size(max = 8)
    @Column(name = "n_code_DA")
    private String ncodeDA;
    @Size(max = 8)
    @Column(name = "n_code_CD")
    private String ncodeCD;
    @Size(max = 8)
    @Column(name = "n_code_DC")
    private String ncodeDC;
    @Size(max = 8)
    @Column(name = "n_code_DD")
    private String ncodeDD;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "bakno", referencedColumnName = "bakno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cdrbhad cdrbhad;

    public Cdrbdta() {
    }

    public Cdrbdta(CdrbdtaPK cdrbdtaPK) {
        this.cdrbdtaPK = cdrbdtaPK;
    }

    public Cdrbdta(CdrbdtaPK cdrbdtaPK, String itnbr, String itdsc, String wareh, BigDecimal bshpqy1, BigDecimal barmqy, BigDecimal unpris, BigDecimal bakamts, BigDecimal addamts, BigDecimal subamts, BigDecimal mapamts, Character cmpyn, BigDecimal preqy1, BigDecimal shpqy1) {
        this.cdrbdtaPK = cdrbdtaPK;
        this.itnbr = itnbr;
        this.itdsc = itdsc;
        this.wareh = wareh;
        this.bshpqy1 = bshpqy1;
        this.barmqy = barmqy;
        this.unpris = unpris;
        this.bakamts = bakamts;
        this.addamts = addamts;
        this.subamts = subamts;
        this.mapamts = mapamts;
        this.cmpyn = cmpyn;
        this.preqy1 = preqy1;
        this.shpqy1 = shpqy1;
    }

    public Cdrbdta(String facno, String bakno, short trseq) {
        this.cdrbdtaPK = new CdrbdtaPK(facno, bakno, trseq);
    }

    public CdrbdtaPK getCdrbdtaPK() {
        return cdrbdtaPK;
    }

    public void setCdrbdtaPK(CdrbdtaPK cdrbdtaPK) {
        this.cdrbdtaPK = cdrbdtaPK;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public Short getStrseq() {
        return strseq;
    }

    public void setStrseq(Short strseq) {
        this.strseq = strseq;
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

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
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

    public BigDecimal getBshpqy1() {
        return bshpqy1;
    }

    public void setBshpqy1(BigDecimal bshpqy1) {
        this.bshpqy1 = bshpqy1;
    }

    public BigDecimal getBshpqy2() {
        return bshpqy2;
    }

    public void setBshpqy2(BigDecimal bshpqy2) {
        this.bshpqy2 = bshpqy2;
    }

    public BigDecimal getBarmqy() {
        return barmqy;
    }

    public void setBarmqy(BigDecimal barmqy) {
        this.barmqy = barmqy;
    }

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
    }

    public BigDecimal getBakamts() {
        return bakamts;
    }

    public void setBakamts(BigDecimal bakamts) {
        this.bakamts = bakamts;
    }

    public BigDecimal getAddamts() {
        return addamts;
    }

    public void setAddamts(BigDecimal addamts) {
        this.addamts = addamts;
    }

    public BigDecimal getSubamts() {
        return subamts;
    }

    public void setSubamts(BigDecimal subamts) {
        this.subamts = subamts;
    }

    public BigDecimal getMapamts() {
        return mapamts;
    }

    public void setMapamts(BigDecimal mapamts) {
        this.mapamts = mapamts;
    }

    public String getCmpno() {
        return cmpno;
    }

    public void setCmpno(String cmpno) {
        this.cmpno = cmpno;
    }

    public Short getCmpseq() {
        return cmpseq;
    }

    public void setCmpseq(Short cmpseq) {
        this.cmpseq = cmpseq;
    }

    public Character getCmpyn() {
        return cmpyn;
    }

    public void setCmpyn(Character cmpyn) {
        this.cmpyn = cmpyn;
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

    public String getUnmsr9() {
        return unmsr9;
    }

    public void setUnmsr9(String unmsr9) {
        this.unmsr9 = unmsr9;
    }

    public Character getReplenish() {
        return replenish;
    }

    public void setReplenish(Character replenish) {
        this.replenish = replenish;
    }

    public BigDecimal getPreqy1() {
        return preqy1;
    }

    public void setPreqy1(BigDecimal preqy1) {
        this.preqy1 = preqy1;
    }

    public BigDecimal getPreqy2() {
        return preqy2;
    }

    public void setPreqy2(BigDecimal preqy2) {
        this.preqy2 = preqy2;
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

    public Character getIssevdta() {
        return issevdta;
    }

    public void setIssevdta(Character issevdta) {
        this.issevdta = issevdta;
    }

    public String getNcodeDA() {
        return ncodeDA;
    }

    public void setNcodeDA(String ncodeDA) {
        this.ncodeDA = ncodeDA;
    }

    public String getNcodeCD() {
        return ncodeCD;
    }

    public void setNcodeCD(String ncodeCD) {
        this.ncodeCD = ncodeCD;
    }

    public String getNcodeDC() {
        return ncodeDC;
    }

    public void setNcodeDC(String ncodeDC) {
        this.ncodeDC = ncodeDC;
    }

    public String getNcodeDD() {
        return ncodeDD;
    }

    public void setNcodeDD(String ncodeDD) {
        this.ncodeDD = ncodeDD;
    }

    public Cdrbhad getCdrbhad() {
        return cdrbhad;
    }

    public void setCdrbhad(Cdrbhad cdrbhad) {
        this.cdrbhad = cdrbhad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrbdtaPK != null ? cdrbdtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrbdta)) {
            return false;
        }
        Cdrbdta other = (Cdrbdta) object;
        if ((this.cdrbdtaPK == null && other.cdrbdtaPK != null) || (this.cdrbdtaPK != null && !this.cdrbdtaPK.equals(other.cdrbdtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrbdta[ cdrbdtaPK=" + cdrbdtaPK + " ]";
    }
    
}
