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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "freeserviceamt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FreeServiceAmt.findAll", query = "SELECT f FROM FreeServiceAmt f"),
    @NamedQuery(name = "FreeServiceAmt.findById", query = "SELECT f FROM FreeServiceAmt f WHERE f.id = :id"),
    @NamedQuery(name = "FreeServiceAmt.findByCrdate", query = "SELECT f FROM FreeServiceAmt f WHERE f.crdate = :crdate"),
    @NamedQuery(name = "FreeServiceAmt.findByCasenumber", query = "SELECT f FROM FreeServiceAmt f WHERE f.casenumber = :casenumber"),
    @NamedQuery(name = "FreeServiceAmt.findByUserno", query = "SELECT f FROM FreeServiceAmt f WHERE f.userno = :userno"),
    @NamedQuery(name = "FreeServiceAmt.findByUserna", query = "SELECT f FROM FreeServiceAmt f WHERE f.userna = :userna"),
    @NamedQuery(name = "FreeServiceAmt.findByDeptno", query = "SELECT f FROM FreeServiceAmt f WHERE f.deptno = :deptno"),
    @NamedQuery(name = "FreeServiceAmt.findByDeptna", query = "SELECT f FROM FreeServiceAmt f WHERE f.deptna = :deptna"),
    @NamedQuery(name = "FreeServiceAmt.findByItntypeno", query = "SELECT f FROM FreeServiceAmt f WHERE f.itntypeno = :itntypeno"),
    @NamedQuery(name = "FreeServiceAmt.findByItntypena", query = "SELECT f FROM FreeServiceAmt f WHERE f.itntypena = :itntypena"),
    @NamedQuery(name = "FreeServiceAmt.findByVarnr", query = "SELECT f FROM FreeServiceAmt f WHERE f.varnr = :varnr"),
    @NamedQuery(name = "FreeServiceAmt.findByItnbrcus", query = "SELECT f FROM FreeServiceAmt f WHERE f.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "FreeServiceAmt.findByCusno", query = "SELECT f FROM FreeServiceAmt f WHERE f.cusno = :cusno"),
    @NamedQuery(name = "FreeServiceAmt.findByCusna", query = "SELECT f FROM FreeServiceAmt f WHERE f.cusna = :cusna"),
    @NamedQuery(name = "FreeServiceAmt.findByJudge", query = "SELECT f FROM FreeServiceAmt f WHERE f.judge = :judge"),
    @NamedQuery(name = "FreeServiceAmt.findByCharge", query = "SELECT f FROM FreeServiceAmt f WHERE f.charge = :charge"),
    @NamedQuery(name = "FreeServiceAmt.findByIswarranty", query = "SELECT f FROM FreeServiceAmt f WHERE f.iswarranty = :iswarranty"),
    @NamedQuery(name = "FreeServiceAmt.findByAscriptiondept", query = "SELECT f FROM FreeServiceAmt f WHERE f.ascriptiondept = :ascriptiondept"),
    @NamedQuery(name = "FreeServiceAmt.findByReason", query = "SELECT f FROM FreeServiceAmt f WHERE f.reason = :reason"),
    @NamedQuery(name = "FreeServiceAmt.findByRepairnumber", query = "SELECT f FROM FreeServiceAmt f WHERE f.repairnumber = :repairnumber"),
    @NamedQuery(name = "FreeServiceAmt.findByRepairuserno", query = "SELECT f FROM FreeServiceAmt f WHERE f.repairuserno = :repairuserno"),
    @NamedQuery(name = "FreeServiceAmt.findByRepairuserna", query = "SELECT f FROM FreeServiceAmt f WHERE f.repairuserna = :repairuserna"),
    @NamedQuery(name = "FreeServiceAmt.findByRepairdeptno", query = "SELECT f FROM FreeServiceAmt f WHERE f.repairdeptno = :repairdeptno"),
    @NamedQuery(name = "FreeServiceAmt.findByRepairdeptna", query = "SELECT f FROM FreeServiceAmt f WHERE f.repairdeptna = :repairdeptna"),
    @NamedQuery(name = "FreeServiceAmt.findByGcpamt", query = "SELECT f FROM FreeServiceAmt f WHERE f.gcpamt = :gcpamt"),
    @NamedQuery(name = "FreeServiceAmt.findByGcramt", query = "SELECT f FROM FreeServiceAmt f WHERE f.gcramt = :gcramt"),
    @NamedQuery(name = "FreeServiceAmt.findByDrpamt", query = "SELECT f FROM FreeServiceAmt f WHERE f.drpamt = :drpamt"),
    @NamedQuery(name = "FreeServiceAmt.findByDrramt", query = "SELECT f FROM FreeServiceAmt f WHERE f.drramt = :drramt"),
    @NamedQuery(name = "FreeServiceAmt.findByTravelamt", query = "SELECT f FROM FreeServiceAmt f WHERE f.travelamt = :travelamt"),
    @NamedQuery(name = "FreeServiceAmt.findByTrafficamt", query = "SELECT f FROM FreeServiceAmt f WHERE f.trafficamt = :trafficamt"),
    @NamedQuery(name = "FreeServiceAmt.findByTotalamt", query = "SELECT f FROM FreeServiceAmt f WHERE f.totalamt = :totalamt")})
public class FreeServiceAmt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "casenumber")
    private String casenumber;
    @Size(max = 20)
    @Column(name = "userno")
    private String userno;
    @Size(max = 20)
    @Column(name = "userna")
    private String userna;
    @Size(max = 20)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 20)
    @Column(name = "deptna")
    private String deptna;
    @Size(max = 10)
    @Column(name = "itntypeno")
    private String itntypeno;
    @Size(max = 20)
    @Column(name = "itntypena")
    private String itntypena;
    @Size(max = 20)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 20)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Size(max = 20)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 20)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 20)
    @Column(name = "judge")
    private String judge;
    @Size(max = 10)
    @Column(name = "charge")
    private String charge;
    @Size(max = 10)
    @Column(name = "iswarranty")
    private String iswarranty;
    @Size(max = 20)
    @Column(name = "ascriptiondept")
    private String ascriptiondept;
    @Size(max = 20)
    @Column(name = "reason")
    private String reason;
    @Size(max = 20)
    @Column(name = "repairnumber")
    private String repairnumber;
    @Size(max = 20)
    @Column(name = "repairuserno")
    private String repairuserno;
    @Size(max = 20)
    @Column(name = "repairuserna")
    private String repairuserna;
    @Size(max = 20)
    @Column(name = "repairdeptno")
    private String repairdeptno;
    @Size(max = 20)
    @Column(name = "repairdeptna")
    private String repairdeptna;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gcpamt")
    private BigDecimal gcpamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gcramt")
    private BigDecimal gcramt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "drpamt")
    private BigDecimal drpamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "drramt")
    private BigDecimal drramt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "travelamt")
    private BigDecimal travelamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trafficamt")
    private BigDecimal trafficamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalamt")
    private BigDecimal totalamt;

    public FreeServiceAmt() {
    }

    public FreeServiceAmt(Integer id) {
        this.id = id;
    }

    public FreeServiceAmt(Integer id, Date crdate, String casenumber, BigDecimal gcpamt, BigDecimal gcramt, BigDecimal drpamt, BigDecimal drramt, BigDecimal travelamt, BigDecimal trafficamt, BigDecimal totalamt) {
        this.id = id;
        this.crdate = crdate;
        this.casenumber = casenumber;
        this.gcpamt = gcpamt;
        this.gcramt = gcramt;
        this.drpamt = drpamt;
        this.drramt = drramt;
        this.travelamt = travelamt;
        this.trafficamt = trafficamt;
        this.totalamt = totalamt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCrdate() {
        return crdate;
    }

    public void setCrdate(Date crdate) {
        this.crdate = crdate;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUserna() {
        return userna;
    }

    public void setUserna(String userna) {
        this.userna = userna;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptna() {
        return deptna;
    }

    public void setDeptna(String deptna) {
        this.deptna = deptna;
    }

    public String getItntypeno() {
        return itntypeno;
    }

    public void setItntypeno(String itntypeno) {
        this.itntypeno = itntypeno;
    }

    public String getItntypena() {
        return itntypena;
    }

    public void setItntypena(String itntypena) {
        this.itntypena = itntypena;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
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

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getIswarranty() {
        return iswarranty;
    }

    public void setIswarranty(String iswarranty) {
        this.iswarranty = iswarranty;
    }

    public String getAscriptiondept() {
        return ascriptiondept;
    }

    public void setAscriptiondept(String ascriptiondept) {
        this.ascriptiondept = ascriptiondept;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRepairnumber() {
        return repairnumber;
    }

    public void setRepairnumber(String repairnumber) {
        this.repairnumber = repairnumber;
    }

    public String getRepairuserno() {
        return repairuserno;
    }

    public void setRepairuserno(String repairuserno) {
        this.repairuserno = repairuserno;
    }

    public String getRepairuserna() {
        return repairuserna;
    }

    public void setRepairuserna(String repairuserna) {
        this.repairuserna = repairuserna;
    }

    public String getRepairdeptno() {
        return repairdeptno;
    }

    public void setRepairdeptno(String repairdeptno) {
        this.repairdeptno = repairdeptno;
    }

    public String getRepairdeptna() {
        return repairdeptna;
    }

    public void setRepairdeptna(String repairdeptna) {
        this.repairdeptna = repairdeptna;
    }

    public BigDecimal getGcpamt() {
        return gcpamt;
    }

    public void setGcpamt(BigDecimal gcpamt) {
        this.gcpamt = gcpamt;
    }

    public BigDecimal getGcramt() {
        return gcramt;
    }

    public void setGcramt(BigDecimal gcramt) {
        this.gcramt = gcramt;
    }

    public BigDecimal getDrpamt() {
        return drpamt;
    }

    public void setDrpamt(BigDecimal drpamt) {
        this.drpamt = drpamt;
    }

    public BigDecimal getDrramt() {
        return drramt;
    }

    public void setDrramt(BigDecimal drramt) {
        this.drramt = drramt;
    }

    public BigDecimal getTravelamt() {
        return travelamt;
    }

    public void setTravelamt(BigDecimal travelamt) {
        this.travelamt = travelamt;
    }

    public BigDecimal getTrafficamt() {
        return trafficamt;
    }

    public void setTrafficamt(BigDecimal trafficamt) {
        this.trafficamt = trafficamt;
    }

    public BigDecimal getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(BigDecimal totalamt) {
        this.totalamt = totalamt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FreeServiceAmt)) {
            return false;
        }
        FreeServiceAmt other = (FreeServiceAmt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.FreeServiceAmt[ id=" + id + " ]";
    }
    
}
