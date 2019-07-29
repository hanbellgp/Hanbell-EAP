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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "cdrqdta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrqdta.findAll", query = "SELECT c FROM Cdrqdta c"),
    @NamedQuery(name = "Cdrqdta.findByFacno", query = "SELECT c FROM Cdrqdta c WHERE c.cdrqdtaPK.facno = :facno"),
    @NamedQuery(name = "Cdrqdta.findByQuono", query = "SELECT c FROM Cdrqdta c WHERE c.cdrqdtaPK.quono = :quono"),
    @NamedQuery(name = "Cdrqdta.findByTrseq", query = "SELECT c FROM Cdrqdta c WHERE c.cdrqdtaPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrqdta.findByItnbr", query = "SELECT c FROM Cdrqdta c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrqdta.findByItnbrcus", query = "SELECT c FROM Cdrqdta c WHERE c.itnbrcus = :itnbrcus"),
    @NamedQuery(name = "Cdrqdta.findByProno", query = "SELECT c FROM Cdrqdta c WHERE c.prono = :prono"),
    @NamedQuery(name = "Cdrqdta.findByShptrseq", query = "SELECT c FROM Cdrqdta c WHERE c.shptrseq = :shptrseq"),
    @NamedQuery(name = "Cdrqdta.findByQuaqy1", query = "SELECT c FROM Cdrqdta c WHERE c.quaqy1 = :quaqy1"),
    @NamedQuery(name = "Cdrqdta.findByArmqy", query = "SELECT c FROM Cdrqdta c WHERE c.armqy = :armqy"),
    @NamedQuery(name = "Cdrqdta.findByUnpris", query = "SELECT c FROM Cdrqdta c WHERE c.unpris = :unpris"),
    @NamedQuery(name = "Cdrqdta.findByUnprisrccode", query = "SELECT c FROM Cdrqdta c WHERE c.unprisrccode = :unprisrccode"),
    @NamedQuery(name = "Cdrqdta.findByTramts", query = "SELECT c FROM Cdrqdta c WHERE c.tramts = :tramts"),
    @NamedQuery(name = "Cdrqdta.findByCdrdate", query = "SELECT c FROM Cdrqdta c WHERE c.cdrdate = :cdrdate"),
    @NamedQuery(name = "Cdrqdta.findByDmark1", query = "SELECT c FROM Cdrqdta c WHERE c.dmark1 = :dmark1"),
    @NamedQuery(name = "Cdrqdta.findByTrnstatus", query = "SELECT c FROM Cdrqdta c WHERE c.trnstatus = :trnstatus"),
    @NamedQuery(name = "Cdrqdta.findByListunpri", query = "SELECT c FROM Cdrqdta c WHERE c.listunpri = :listunpri"),
    @NamedQuery(name = "Cdrqdta.findByNeedThrowDetail", query = "SELECT c FROM Cdrqdta c WHERE c.cdrqdtaPK.facno = :facno AND c.cdrqdtaPK.quono = :quono  ORDER BY  c.cdrqdtaPK.trseq ")})
public class Cdrqdta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrqdtaPK cdrqdtaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 20)
    @Column(name = "itnbrcus")
    private String itnbrcus;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Column(name = "shptrseq")
    private Short shptrseq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quaqy1")
    private BigDecimal quaqy1;
    @Column(name = "quaqy2")
    private BigDecimal quaqy2;
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
    @Column(name = "tramts")
    private BigDecimal tramts;
    @Column(name = "cdrdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdrdate;
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
    @Column(name = "trnstatus")
    private Integer trnstatus;
    @Column(name = "listunpri")
    private BigDecimal listunpri;
    @Column(name = "discnt")
    private Short discnt;
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
    @Column(name = "oldpri")
    private BigDecimal oldpri;
    @Column(name = "morderqy")
    private BigDecimal morderqy;
    @Column(name = "spcode")
    private Character spcode;
    @Column(name = "contunpri")
    private BigDecimal contunpri;
    @Size(max = 8)
    @Column(name = "norm")
    private String norm;
    @Column(name = "islableprt")
    private Character islableprt;
    @Column(name = "hisorders")
    private Long hisorders;
    @Size(max = 3)
    @Column(name = "levelp")
    private String levelp;
    @Column(name = "fare")
    private BigDecimal fare;
    @Size(max = 10)
    @Column(name = "unprislevel")
    private String unprislevel;
    @Column(name = "maxpricing")
    private BigDecimal maxpricing;
    @Column(name = "diffprice")
    private BigDecimal diffprice;
    @Size(max = 18)
    @Column(name = "contractno")
    private String contractno;
    @Column(name = "contrseq")
    private Short contrseq;
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
    @Column(name = "dqxjkind")
    private Character dqxjkind;
    @Size(max = 16)
    @Column(name = "qxb")
    private String qxb;
    @Size(max = 40)
    @Column(name = "stanitnbr")
    private String stanitnbr;
    @Size(max = 16)
    @Column(name = "stanqxb")
    private String stanqxb;
    @Column(name = "deflevprice")
    private BigDecimal deflevprice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cusmark")
    private String cusmark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cuslable")
    private String cuslable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matecode")
    private String matecode;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "quono", referencedColumnName = "quono", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cdrqhad cdrqhad;

    public Cdrqdta() {
    }

    public Cdrqdta(CdrqdtaPK cdrqdtaPK) {
        this.cdrqdtaPK = cdrqdtaPK;
    }

    public Cdrqdta(CdrqdtaPK cdrqdtaPK, String itnbr, BigDecimal quaqy1, BigDecimal armqy, BigDecimal unpris, Character unprisrccode, BigDecimal tramts, String cusmark, String cuslable, String matecode) {
        this.cdrqdtaPK = cdrqdtaPK;
        this.itnbr = itnbr;
        this.quaqy1 = quaqy1;
        this.armqy = armqy;
        this.unpris = unpris;
        this.unprisrccode = unprisrccode;
        this.tramts = tramts;
        this.cusmark = cusmark;
        this.cuslable = cuslable;
        this.matecode = matecode;
    }

    public Cdrqdta(String facno, String quono, short trseq) {
        this.cdrqdtaPK = new CdrqdtaPK(facno, quono, trseq);
    }

    public CdrqdtaPK getCdrqdtaPK() {
        return cdrqdtaPK;
    }

    public void setCdrqdtaPK(CdrqdtaPK cdrqdtaPK) {
        this.cdrqdtaPK = cdrqdtaPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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

    public Short getShptrseq() {
        return shptrseq;
    }

    public void setShptrseq(Short shptrseq) {
        this.shptrseq = shptrseq;
    }

    public BigDecimal getQuaqy1() {
        return quaqy1;
    }

    public void setQuaqy1(BigDecimal quaqy1) {
        this.quaqy1 = quaqy1;
    }

    public BigDecimal getQuaqy2() {
        return quaqy2;
    }

    public void setQuaqy2(BigDecimal quaqy2) {
        this.quaqy2 = quaqy2;
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

    public BigDecimal getTramts() {
        return tramts;
    }

    public void setTramts(BigDecimal tramts) {
        this.tramts = tramts;
    }

    public Date getCdrdate() {
        return cdrdate;
    }

    public void setCdrdate(Date cdrdate) {
        this.cdrdate = cdrdate;
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

    public Integer getTrnstatus() {
        return trnstatus;
    }

    public void setTrnstatus(Integer trnstatus) {
        this.trnstatus = trnstatus;
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

    public BigDecimal getOldpri() {
        return oldpri;
    }

    public void setOldpri(BigDecimal oldpri) {
        this.oldpri = oldpri;
    }

    public BigDecimal getMorderqy() {
        return morderqy;
    }

    public void setMorderqy(BigDecimal morderqy) {
        this.morderqy = morderqy;
    }

    public Character getSpcode() {
        return spcode;
    }

    public void setSpcode(Character spcode) {
        this.spcode = spcode;
    }

    public BigDecimal getContunpri() {
        return contunpri;
    }

    public void setContunpri(BigDecimal contunpri) {
        this.contunpri = contunpri;
    }

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public Character getIslableprt() {
        return islableprt;
    }

    public void setIslableprt(Character islableprt) {
        this.islableprt = islableprt;
    }

    public Long getHisorders() {
        return hisorders;
    }

    public void setHisorders(Long hisorders) {
        this.hisorders = hisorders;
    }

    public String getLevelp() {
        return levelp;
    }

    public void setLevelp(String levelp) {
        this.levelp = levelp;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String getUnprislevel() {
        return unprislevel;
    }

    public void setUnprislevel(String unprislevel) {
        this.unprislevel = unprislevel;
    }

    public BigDecimal getMaxpricing() {
        return maxpricing;
    }

    public void setMaxpricing(BigDecimal maxpricing) {
        this.maxpricing = maxpricing;
    }

    public BigDecimal getDiffprice() {
        return diffprice;
    }

    public void setDiffprice(BigDecimal diffprice) {
        this.diffprice = diffprice;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public Short getContrseq() {
        return contrseq;
    }

    public void setContrseq(Short contrseq) {
        this.contrseq = contrseq;
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

    public Character getDqxjkind() {
        return dqxjkind;
    }

    public void setDqxjkind(Character dqxjkind) {
        this.dqxjkind = dqxjkind;
    }

    public String getQxb() {
        return qxb;
    }

    public void setQxb(String qxb) {
        this.qxb = qxb;
    }

    public String getStanitnbr() {
        return stanitnbr;
    }

    public void setStanitnbr(String stanitnbr) {
        this.stanitnbr = stanitnbr;
    }

    public String getStanqxb() {
        return stanqxb;
    }

    public void setStanqxb(String stanqxb) {
        this.stanqxb = stanqxb;
    }

    public BigDecimal getDeflevprice() {
        return deflevprice;
    }

    public void setDeflevprice(BigDecimal deflevprice) {
        this.deflevprice = deflevprice;
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

    public String getMatecode() {
        return matecode;
    }

    public void setMatecode(String matecode) {
        this.matecode = matecode;
    }

    public Cdrqhad getCdrqhad() {
        return cdrqhad;
    }

    public void setCdrqhad(Cdrqhad cdrqhad) {
        this.cdrqhad = cdrqhad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrqdtaPK != null ? cdrqdtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrqdta)) {
            return false;
        }
        Cdrqdta other = (Cdrqdta) object;
        if ((this.cdrqdtaPK == null && other.cdrqdtaPK != null) || (this.cdrqdtaPK != null && !this.cdrqdtaPK.equals(other.cdrqdtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrqdta[ cdrqdtaPK=" + cdrqdtaPK + " ]";
    }

}
