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
@Table(name = "invtrn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invtrn.findAll", query = "SELECT i FROM Invtrn i"),
    @NamedQuery(name = "Invtrn.findByFacno", query = "SELECT i FROM Invtrn i WHERE i.invtrnPK.facno = :facno"),
    @NamedQuery(name = "Invtrn.findByProno", query = "SELECT i FROM Invtrn i WHERE i.invtrnPK.prono = :prono"),
    @NamedQuery(name = "Invtrn.findByTrtype", query = "SELECT i FROM Invtrn i WHERE i.invtrnPK.trtype = :trtype"),
    @NamedQuery(name = "Invtrn.findByTrno", query = "SELECT i FROM Invtrn i WHERE i.invtrnPK.trno = :trno"),
    @NamedQuery(name = "Invtrn.findByTrseq", query = "SELECT i FROM Invtrn i WHERE i.invtrnPK.trseq = :trseq"),
    @NamedQuery(name = "Invtrn.findByItnbr", query = "SELECT i FROM Invtrn i WHERE i.itnbr = :itnbr"),
    @NamedQuery(name = "Invtrn.findByTrdate", query = "SELECT i FROM Invtrn i WHERE i.trdate = :trdate"),
    @NamedQuery(name = "Invtrn.findByDepno", query = "SELECT i FROM Invtrn i WHERE i.depno = :depno"),
    @NamedQuery(name = "Invtrn.findByHmark1", query = "SELECT i FROM Invtrn i WHERE i.hmark1 = :hmark1"),
    @NamedQuery(name = "Invtrn.findByHmark2", query = "SELECT i FROM Invtrn i WHERE i.hmark2 = :hmark2"),
    @NamedQuery(name = "Invtrn.findByWareh", query = "SELECT i FROM Invtrn i WHERE i.wareh = :wareh"),
    @NamedQuery(name = "Invtrn.findByFixnr", query = "SELECT i FROM Invtrn i WHERE i.fixnr = :fixnr"),
    @NamedQuery(name = "Invtrn.findByVarnr", query = "SELECT i FROM Invtrn i WHERE i.varnr = :varnr"),
    @NamedQuery(name = "Invtrn.findByTrnqy1", query = "SELECT i FROM Invtrn i WHERE i.trnqy1 = :trnqy1"),
    @NamedQuery(name = "Invtrn.findByTrnqy2", query = "SELECT i FROM Invtrn i WHERE i.trnqy2 = :trnqy2"),
    @NamedQuery(name = "Invtrn.findByTrnqy3", query = "SELECT i FROM Invtrn i WHERE i.trnqy3 = :trnqy3"),
    @NamedQuery(name = "Invtrn.findByUnmsr1", query = "SELECT i FROM Invtrn i WHERE i.unmsr1 = :unmsr1"),
    @NamedQuery(name = "Invtrn.findByUnmsr2", query = "SELECT i FROM Invtrn i WHERE i.unmsr2 = :unmsr2"),
    @NamedQuery(name = "Invtrn.findByUnmsr3", query = "SELECT i FROM Invtrn i WHERE i.unmsr3 = :unmsr3"),
    @NamedQuery(name = "Invtrn.findByIocode", query = "SELECT i FROM Invtrn i WHERE i.iocode = :iocode"),
    @NamedQuery(name = "Invtrn.findByDmark1", query = "SELECT i FROM Invtrn i WHERE i.dmark1 = :dmark1"),
    @NamedQuery(name = "Invtrn.findByDmark2", query = "SELECT i FROM Invtrn i WHERE i.dmark2 = :dmark2"),
    @NamedQuery(name = "Invtrn.findByUserno", query = "SELECT i FROM Invtrn i WHERE i.userno = :userno"),
    @NamedQuery(name = "Invtrn.findByCfmuserno", query = "SELECT i FROM Invtrn i WHERE i.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Invtrn.findByRescode", query = "SELECT i FROM Invtrn i WHERE i.rescode = :rescode"),
    @NamedQuery(name = "Invtrn.findBySyscode", query = "SELECT i FROM Invtrn i WHERE i.syscode = :syscode"),
    @NamedQuery(name = "Invtrn.findBySourceno", query = "SELECT i FROM Invtrn i WHERE i.sourceno = :sourceno"),
    @NamedQuery(name = "Invtrn.findByItcls", query = "SELECT i FROM Invtrn i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "Invtrn.findByItclscode", query = "SELECT i FROM Invtrn i WHERE i.itclscode = :itclscode"),
    @NamedQuery(name = "Invtrn.findByIndate", query = "SELECT i FROM Invtrn i WHERE i.indate = :indate"),
    @NamedQuery(name = "Invtrn.findByCfmdate", query = "SELECT i FROM Invtrn i WHERE i.cfmdate = :cfmdate"),
    @NamedQuery(name = "Invtrn.findByTramt", query = "SELECT i FROM Invtrn i WHERE i.tramt = :tramt"),
    @NamedQuery(name = "Invtrn.findByPriyn", query = "SELECT i FROM Invtrn i WHERE i.priyn = :priyn"),
    @NamedQuery(name = "Invtrn.findBySourceno1", query = "SELECT i FROM Invtrn i WHERE i.sourceno1 = :sourceno1"),
    @NamedQuery(name = "Invtrn.findByTtmanm", query = "SELECT i FROM Invtrn i WHERE i.ttmanm = :ttmanm"),
    @NamedQuery(name = "Invtrn.findByTtmatm", query = "SELECT i FROM Invtrn i WHERE i.ttmatm = :ttmatm"),
    @NamedQuery(name = "Invtrn.findByTtexpm", query = "SELECT i FROM Invtrn i WHERE i.ttexpm = :ttexpm"),
    @NamedQuery(name = "Invtrn.findByTtassm", query = "SELECT i FROM Invtrn i WHERE i.ttassm = :ttassm"),
    @NamedQuery(name = "Invtrn.findByMorpcode", query = "SELECT i FROM Invtrn i WHERE i.morpcode = :morpcode")})
public class Invtrn implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvtrnPK invtrnPK;
    @Size(max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
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
    @Column(name = "trnqy1")
    private BigDecimal trnqy1;
    @Column(name = "trnqy2")
    private BigDecimal trnqy2;
    @Column(name = "trnqy3")
    private BigDecimal trnqy3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 4)
    @Column(name = "unmsr2")
    private String unmsr2;
    @Size(max = 4)
    @Column(name = "unmsr3")
    private String unmsr3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iocode")
    private Character iocode;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Size(max = 8)
    @Column(name = "rescode")
    private String rescode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "syscode")
    private String syscode;
    @Size(max = 18)
    @Column(name = "sourceno")
    private String sourceno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itclscode")
    private Character itclscode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Column(name = "tramt")
    private BigDecimal tramt;
    @Column(name = "priyn")
    private Character priyn;
    @Size(max = 22)
    @Column(name = "sourceno1")
    private String sourceno1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ttmanm")
    private BigDecimal ttmanm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ttmatm")
    private BigDecimal ttmatm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ttexpm")
    private BigDecimal ttexpm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ttassm")
    private BigDecimal ttassm;
    @Column(name = "morpcode")
    private Character morpcode;

    public Invtrn() {
        this.tramt = BigDecimal.ZERO;
        this.ttmatm = BigDecimal.ZERO;
        this.ttmanm = BigDecimal.ZERO;
        this.ttexpm = BigDecimal.ZERO;
        this.ttassm = BigDecimal.ZERO;
    }

    public Invtrn(InvtrnPK invtrnPK) {
        this.invtrnPK = invtrnPK;
        this.tramt = BigDecimal.ZERO;
        this.ttmatm = BigDecimal.ZERO;
        this.ttmanm = BigDecimal.ZERO;
        this.ttexpm = BigDecimal.ZERO;
        this.ttassm = BigDecimal.ZERO;
    }

    public Invtrn(String facno, String prono, String trtype, String trno, int trseq) {
        this.invtrnPK = new InvtrnPK(facno, prono, trtype, trno, trseq);
        this.tramt = BigDecimal.ZERO;
        this.ttmatm = BigDecimal.ZERO;
        this.ttmanm = BigDecimal.ZERO;
        this.ttexpm = BigDecimal.ZERO;
        this.ttassm = BigDecimal.ZERO;
    }

    public InvtrnPK getInvtrnPK() {
        return invtrnPK;
    }

    public void setInvtrnPK(InvtrnPK invtrnPK) {
        this.invtrnPK = invtrnPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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

    public BigDecimal getTrnqy3() {
        return trnqy3;
    }

    public void setTrnqy3(BigDecimal trnqy3) {
        this.trnqy3 = trnqy3;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getUnmsr2() {
        return unmsr2;
    }

    public void setUnmsr2(String unmsr2) {
        this.unmsr2 = unmsr2;
    }

    public String getUnmsr3() {
        return unmsr3;
    }

    public void setUnmsr3(String unmsr3) {
        this.unmsr3 = unmsr3;
    }

    public Character getIocode() {
        return iocode;
    }

    public void setIocode(Character iocode) {
        this.iocode = iocode;
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

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public String getRescode() {
        return rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode;
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    public String getSourceno() {
        return sourceno;
    }

    public void setSourceno(String sourceno) {
        this.sourceno = sourceno;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public Character getItclscode() {
        return itclscode;
    }

    public void setItclscode(Character itclscode) {
        this.itclscode = itclscode;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public BigDecimal getTramt() {
        return tramt;
    }

    public void setTramt(BigDecimal tramt) {
        this.tramt = tramt;
    }

    public Character getPriyn() {
        return priyn;
    }

    public void setPriyn(Character priyn) {
        this.priyn = priyn;
    }

    public String getSourceno1() {
        return sourceno1;
    }

    public void setSourceno1(String sourceno1) {
        this.sourceno1 = sourceno1;
    }

    public BigDecimal getTtmanm() {
        return ttmanm;
    }

    public void setTtmanm(BigDecimal ttmanm) {
        this.ttmanm = ttmanm;
    }

    public BigDecimal getTtmatm() {
        return ttmatm;
    }

    public void setTtmatm(BigDecimal ttmatm) {
        this.ttmatm = ttmatm;
    }

    public BigDecimal getTtexpm() {
        return ttexpm;
    }

    public void setTtexpm(BigDecimal ttexpm) {
        this.ttexpm = ttexpm;
    }

    public BigDecimal getTtassm() {
        return ttassm;
    }

    public void setTtassm(BigDecimal ttassm) {
        this.ttassm = ttassm;
    }

    public Character getMorpcode() {
        return morpcode;
    }

    public void setMorpcode(Character morpcode) {
        this.morpcode = morpcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invtrnPK != null ? invtrnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invtrn)) {
            return false;
        }
        Invtrn other = (Invtrn) object;
        if ((this.invtrnPK == null && other.invtrnPK != null) || (this.invtrnPK != null && !this.invtrnPK.equals(other.invtrnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invtrn[ invtrnPK=" + invtrnPK + " ]";
    }

}
