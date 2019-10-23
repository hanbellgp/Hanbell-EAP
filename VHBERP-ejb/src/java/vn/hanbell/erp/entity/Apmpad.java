/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

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
@Table(name = "apmpad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmpad.findAll", query = "SELECT a FROM Apmpad a")
    , @NamedQuery(name = "Apmpad.findByFacno", query = "SELECT a FROM Apmpad a WHERE a.apmpadPK.facno = :facno")
    , @NamedQuery(name = "Apmpad.findByPaycode", query = "SELECT a FROM Apmpad a WHERE a.apmpadPK.paycode = :paycode")
    , @NamedQuery(name = "Apmpad.findByPayno", query = "SELECT a FROM Apmpad a WHERE a.apmpadPK.payno = :payno")
    , @NamedQuery(name = "Apmpad.findByTrse", query = "SELECT a FROM Apmpad a WHERE a.apmpadPK.trse = :trse")
    , @NamedQuery(name = "Apmpad.findByAccno", query = "SELECT a FROM Apmpad a WHERE a.accno = :accno")
    , @NamedQuery(name = "Apmpad.findByConfig", query = "SELECT a FROM Apmpad a WHERE a.config = :config")
    , @NamedQuery(name = "Apmpad.findByDramt", query = "SELECT a FROM Apmpad a WHERE a.dramt = :dramt")
    , @NamedQuery(name = "Apmpad.findByCramt", query = "SELECT a FROM Apmpad a WHERE a.cramt = :cramt")
    , @NamedQuery(name = "Apmpad.findByDramtfs", query = "SELECT a FROM Apmpad a WHERE a.dramtfs = :dramtfs")
    , @NamedQuery(name = "Apmpad.findByCramtfs", query = "SELECT a FROM Apmpad a WHERE a.cramtfs = :cramtfs")
    , @NamedQuery(name = "Apmpad.findByCoin", query = "SELECT a FROM Apmpad a WHERE a.coin = :coin")
    , @NamedQuery(name = "Apmpad.findByRatio", query = "SELECT a FROM Apmpad a WHERE a.ratio = :ratio")
    , @NamedQuery(name = "Apmpad.findByCuskind", query = "SELECT a FROM Apmpad a WHERE a.cuskind = :cuskind")
    , @NamedQuery(name = "Apmpad.findByVdrno", query = "SELECT a FROM Apmpad a WHERE a.vdrno = :vdrno")
    , @NamedQuery(name = "Apmpad.findByVdrna", query = "SELECT a FROM Apmpad a WHERE a.vdrna = :vdrna")
    , @NamedQuery(name = "Apmpad.findByTnfamt", query = "SELECT a FROM Apmpad a WHERE a.tnfamt = :tnfamt")
    , @NamedQuery(name = "Apmpad.findByTnfamtfs", query = "SELECT a FROM Apmpad a WHERE a.tnfamtfs = :tnfamtfs")
    , @NamedQuery(name = "Apmpad.findByRefno", query = "SELECT a FROM Apmpad a WHERE a.refno = :refno")
    , @NamedQuery(name = "Apmpad.findByRefamt", query = "SELECT a FROM Apmpad a WHERE a.refamt = :refamt")
    , @NamedQuery(name = "Apmpad.findByRefamtfs", query = "SELECT a FROM Apmpad a WHERE a.refamtfs = :refamtfs")
    , @NamedQuery(name = "Apmpad.findByVouseq", query = "SELECT a FROM Apmpad a WHERE a.vouseq = :vouseq")
    , @NamedQuery(name = "Apmpad.findByTrntype", query = "SELECT a FROM Apmpad a WHERE a.trntype = :trntype")})
public class Apmpad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmpadPK apmpadPK;
    @Size(max = 8)
    @Column(name = "accno")
    private String accno;
    @Column(name = "config")
    private Short config;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dramt")
    private BigDecimal dramt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cramt")
    private BigDecimal cramt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dramtfs")
    private BigDecimal dramtfs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cramtfs")
    private BigDecimal cramtfs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Size(max = 2)
    @Column(name = "cuskind")
    private String cuskind;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 60)
    @Column(name = "vdrna")
    private String vdrna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tnfamt")
    private BigDecimal tnfamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tnfamtfs")
    private BigDecimal tnfamtfs;
    @Size(max = 22)
    @Column(name = "refno")
    private String refno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refamt")
    private BigDecimal refamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refamtfs")
    private BigDecimal refamtfs;
    @Column(name = "vouseq")
    private Short vouseq;
    @Size(max = 2)
    @Column(name = "trntype")
    private String trntype;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false)
        , @JoinColumn(name = "paycode", referencedColumnName = "paycode", insertable = false, updatable = false)
        , @JoinColumn(name = "payno", referencedColumnName = "payno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Apmpay apmpay;

    public Apmpad() {
    }

    public Apmpad(ApmpadPK apmpadPK) {
        this.apmpadPK = apmpadPK;
    }

    public Apmpad(ApmpadPK apmpadPK, BigDecimal dramt, BigDecimal cramt, BigDecimal dramtfs, BigDecimal cramtfs, String coin, BigDecimal ratio, BigDecimal tnfamt, BigDecimal tnfamtfs, BigDecimal refamt, BigDecimal refamtfs) {
        this.apmpadPK = apmpadPK;
        this.dramt = dramt;
        this.cramt = cramt;
        this.dramtfs = dramtfs;
        this.cramtfs = cramtfs;
        this.coin = coin;
        this.ratio = ratio;
        this.tnfamt = tnfamt;
        this.tnfamtfs = tnfamtfs;
        this.refamt = refamt;
        this.refamtfs = refamtfs;
    }

    public Apmpad(String facno, Character paycode, String payno, short trse) {
        this.apmpadPK = new ApmpadPK(facno, paycode, payno, trse);
    }

    public ApmpadPK getApmpadPK() {
        return apmpadPK;
    }

    public void setApmpadPK(ApmpadPK apmpadPK) {
        this.apmpadPK = apmpadPK;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public Short getConfig() {
        return config;
    }

    public void setConfig(Short config) {
        this.config = config;
    }

    public BigDecimal getDramt() {
        return dramt;
    }

    public void setDramt(BigDecimal dramt) {
        this.dramt = dramt;
    }

    public BigDecimal getCramt() {
        return cramt;
    }

    public void setCramt(BigDecimal cramt) {
        this.cramt = cramt;
    }

    public BigDecimal getDramtfs() {
        return dramtfs;
    }

    public void setDramtfs(BigDecimal dramtfs) {
        this.dramtfs = dramtfs;
    }

    public BigDecimal getCramtfs() {
        return cramtfs;
    }

    public void setCramtfs(BigDecimal cramtfs) {
        this.cramtfs = cramtfs;
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

    public String getCuskind() {
        return cuskind;
    }

    public void setCuskind(String cuskind) {
        this.cuskind = cuskind;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public BigDecimal getTnfamt() {
        return tnfamt;
    }

    public void setTnfamt(BigDecimal tnfamt) {
        this.tnfamt = tnfamt;
    }

    public BigDecimal getTnfamtfs() {
        return tnfamtfs;
    }

    public void setTnfamtfs(BigDecimal tnfamtfs) {
        this.tnfamtfs = tnfamtfs;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public BigDecimal getRefamt() {
        return refamt;
    }

    public void setRefamt(BigDecimal refamt) {
        this.refamt = refamt;
    }

    public BigDecimal getRefamtfs() {
        return refamtfs;
    }

    public void setRefamtfs(BigDecimal refamtfs) {
        this.refamtfs = refamtfs;
    }

    public Short getVouseq() {
        return vouseq;
    }

    public void setVouseq(Short vouseq) {
        this.vouseq = vouseq;
    }

    public String getTrntype() {
        return trntype;
    }

    public void setTrntype(String trntype) {
        this.trntype = trntype;
    }

    public Apmpay getApmpay() {
        return apmpay;
    }

    public void setApmpay(Apmpay apmpay) {
        this.apmpay = apmpay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmpadPK != null ? apmpadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmpad)) {
            return false;
        }
        Apmpad other = (Apmpad) object;
        if ((this.apmpadPK == null && other.apmpadPK != null) || (this.apmpadPK != null && !this.apmpadPK.equals(other.apmpadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.Apmpad[ apmpadPK=" + apmpadPK + " ]";
    }
    
}
