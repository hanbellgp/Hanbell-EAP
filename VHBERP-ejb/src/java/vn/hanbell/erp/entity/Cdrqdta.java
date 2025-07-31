/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

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
 * @author ZFF
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
    @Size(max = 16)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 16)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 16)
    @Column(name = "dmark3")
    private String dmark3;
    @Size(max = 16)
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
    @Size(max = 16)
    @Column(name = "qxb")
    private String qxb;
    @Column(name = "diffprice")
    private BigDecimal diffprice;

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

    public Cdrqdta(CdrqdtaPK cdrqdtaPK, String itnbr, BigDecimal quaqy1, BigDecimal armqy, BigDecimal unpris, Character unprisrccode, BigDecimal tramts) {
        this.cdrqdtaPK = cdrqdtaPK;
        this.itnbr = itnbr;
        this.quaqy1 = quaqy1;
        this.armqy = armqy;
        this.unpris = unpris;
        this.unprisrccode = unprisrccode;
        this.tramts = tramts;
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
        return "vn.hanbell.erp.entity.Cdrqdta[ cdrqdtaPK=" + cdrqdtaPK + " ]";
    }

    public String getQxb() {
        return qxb;
    }

    public void setQxb(String qxb) {
        this.qxb = qxb;
    }

    public BigDecimal getDiffprice() {
        return diffprice;
    }

    public void setDiffprice(BigDecimal diffprice) {
        this.diffprice = diffprice;
    }

}
