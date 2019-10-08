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
@Table(name = "purdta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purdta.findAll", query = "SELECT p FROM Purdta p"),
    @NamedQuery(name = "Purdta.findByPK", query = "SELECT p FROM Purdta p WHERE p.purdtaPK.facno = :facno AND p.purdtaPK.prono = :prono AND p.purdtaPK.pono = :pono AND p.purdtaPK.trseq = :trseq"),
    @NamedQuery(name = "Purdta.findByPono", query = "SELECT p FROM Purdta p WHERE p.purdtaPK.pono = :pono ORDER BY p.purdtaPK.facno,p.purdtaPK.pono,p.purdtaPK.trseq")})
public class Purdta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurdtaPK purdtaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Column(name = "fixyn")
    private Character fixyn;
    @Size(max = 20)
    @Column(name = "itnbrvdr")
    private String itnbrvdr;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "poqy1")
    private BigDecimal poqy1;
    @Column(name = "poqy2")
    private BigDecimal poqy2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apmqy")
    private BigDecimal apmqy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "judco")
    private String judco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tramts")
    private BigDecimal tramts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "askdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "dposta")
    private String dposta;
    @Column(name = "accqy1")
    private BigDecimal accqy1;
    @Column(name = "accqy2")
    private BigDecimal accqy2;
    @Column(name = "okqy1")
    private BigDecimal okqy1;
    @Column(name = "okqy2")
    private BigDecimal okqy2;
    @Column(name = "badqy1")
    private BigDecimal badqy1;
    @Column(name = "badqy2")
    private BigDecimal badqy2;
    @Column(name = "stqy1")
    private BigDecimal stqy1;
    @Column(name = "stqy2")
    private BigDecimal stqy2;
    @Size(max = 10)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 10)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 18)
    @Column(name = "relatedno")
    private String relatedno;
    @Size(max = 3)
    @Column(name = "purkind")
    private String purkind;
    @Size(max = 18)
    @Column(name = "lcpno")
    private String lcpno;
    @Column(name = "lcpamts")
    private BigDecimal lcpamts;
    @Size(max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jitstatus")
    private Character jitstatus;
    @Column(name = "calldate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calldate;
    @Column(name = "askdateo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdateo;
    @Column(name = "defqy1")
    private BigDecimal defqy1;
    @Column(name = "defqy2")
    private BigDecimal defqy2;
    @Column(name = "triunpris")
    private BigDecimal triunpris;
    @Column(name = "tritramts")
    private BigDecimal tritramts;
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Column(name = "callqy1")
    private BigDecimal callqy1;
    @Column(name = "callqy2")
    private BigDecimal callqy2;
    @Column(name = "lrecivdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lrecivdate;
    @Column(name = "sdqy1")
    private BigDecimal sdqy1;
    @Size(max = 1)
    @Column(name = "predict")
    private String predict;

    public Purdta() {
    }

    public Purdta(PurdtaPK purdtaPK) {
        this.purdtaPK = purdtaPK;
    }

    public Purdta(PurdtaPK purdtaPK, String itnbr, BigDecimal poqy1, BigDecimal apmqy, String judco, BigDecimal unpris, BigDecimal tramts, Date askdate, String dposta, Character jitstatus) {
        this.purdtaPK = purdtaPK;
        this.itnbr = itnbr;
        this.poqy1 = poqy1;
        this.apmqy = apmqy;
        this.judco = judco;
        this.unpris = unpris;
        this.tramts = tramts;
        this.askdate = askdate;
        this.dposta = dposta;
        this.jitstatus = jitstatus;
    }

    public Purdta(String facno, String prono, String pono, short trseq) {
        this.purdtaPK = new PurdtaPK(facno, prono, pono, trseq);
    }

    public PurdtaPK getPurdtaPK() {
        return purdtaPK;
    }

    public void setPurdtaPK(PurdtaPK purdtaPK) {
        this.purdtaPK = purdtaPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public Character getFixyn() {
        return fixyn;
    }

    public void setFixyn(Character fixyn) {
        this.fixyn = fixyn;
    }

    public String getItnbrvdr() {
        return itnbrvdr;
    }

    public void setItnbrvdr(String itnbrvdr) {
        this.itnbrvdr = itnbrvdr;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public BigDecimal getPoqy1() {
        return poqy1;
    }

    public void setPoqy1(BigDecimal poqy1) {
        this.poqy1 = poqy1;
    }

    public BigDecimal getPoqy2() {
        return poqy2;
    }

    public void setPoqy2(BigDecimal poqy2) {
        this.poqy2 = poqy2;
    }

    public BigDecimal getApmqy() {
        return apmqy;
    }

    public void setApmqy(BigDecimal apmqy) {
        this.apmqy = apmqy;
    }

    public String getJudco() {
        return judco;
    }

    public void setJudco(String judco) {
        this.judco = judco;
    }

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
    }

    public BigDecimal getTramts() {
        return tramts;
    }

    public void setTramts(BigDecimal tramts) {
        this.tramts = tramts;
    }

    public Date getAskdate() {
        return askdate;
    }

    public void setAskdate(Date askdate) {
        this.askdate = askdate;
    }

    public String getDposta() {
        return dposta;
    }

    public void setDposta(String dposta) {
        this.dposta = dposta;
    }

    public BigDecimal getAccqy1() {
        return accqy1;
    }

    public void setAccqy1(BigDecimal accqy1) {
        this.accqy1 = accqy1;
    }

    public BigDecimal getAccqy2() {
        return accqy2;
    }

    public void setAccqy2(BigDecimal accqy2) {
        this.accqy2 = accqy2;
    }

    public BigDecimal getOkqy1() {
        return okqy1;
    }

    public void setOkqy1(BigDecimal okqy1) {
        this.okqy1 = okqy1;
    }

    public BigDecimal getOkqy2() {
        return okqy2;
    }

    public void setOkqy2(BigDecimal okqy2) {
        this.okqy2 = okqy2;
    }

    public BigDecimal getBadqy1() {
        return badqy1;
    }

    public void setBadqy1(BigDecimal badqy1) {
        this.badqy1 = badqy1;
    }

    public BigDecimal getBadqy2() {
        return badqy2;
    }

    public void setBadqy2(BigDecimal badqy2) {
        this.badqy2 = badqy2;
    }

    public BigDecimal getStqy1() {
        return stqy1;
    }

    public void setStqy1(BigDecimal stqy1) {
        this.stqy1 = stqy1;
    }

    public BigDecimal getStqy2() {
        return stqy2;
    }

    public void setStqy2(BigDecimal stqy2) {
        this.stqy2 = stqy2;
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

    public String getRelatedno() {
        return relatedno;
    }

    public void setRelatedno(String relatedno) {
        this.relatedno = relatedno;
    }

    public String getPurkind() {
        return purkind;
    }

    public void setPurkind(String purkind) {
        this.purkind = purkind;
    }

    public String getLcpno() {
        return lcpno;
    }

    public void setLcpno(String lcpno) {
        this.lcpno = lcpno;
    }

    public BigDecimal getLcpamts() {
        return lcpamts;
    }

    public void setLcpamts(BigDecimal lcpamts) {
        this.lcpamts = lcpamts;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public Character getJitstatus() {
        return jitstatus;
    }

    public void setJitstatus(Character jitstatus) {
        this.jitstatus = jitstatus;
    }

    public Date getCalldate() {
        return calldate;
    }

    public void setCalldate(Date calldate) {
        this.calldate = calldate;
    }

    public Date getAskdateo() {
        return askdateo;
    }

    public void setAskdateo(Date askdateo) {
        this.askdateo = askdateo;
    }

    public BigDecimal getDefqy1() {
        return defqy1;
    }

    public void setDefqy1(BigDecimal defqy1) {
        this.defqy1 = defqy1;
    }

    public BigDecimal getDefqy2() {
        return defqy2;
    }

    public void setDefqy2(BigDecimal defqy2) {
        this.defqy2 = defqy2;
    }

    public BigDecimal getTriunpris() {
        return triunpris;
    }

    public void setTriunpris(BigDecimal triunpris) {
        this.triunpris = triunpris;
    }

    public BigDecimal getTritramts() {
        return tritramts;
    }

    public void setTritramts(BigDecimal tritramts) {
        this.tritramts = tritramts;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public BigDecimal getCallqy1() {
        return callqy1;
    }

    public void setCallqy1(BigDecimal callqy1) {
        this.callqy1 = callqy1;
    }

    public BigDecimal getCallqy2() {
        return callqy2;
    }

    public void setCallqy2(BigDecimal callqy2) {
        this.callqy2 = callqy2;
    }

    public Date getLrecivdate() {
        return lrecivdate;
    }

    public void setLrecivdate(Date lrecivdate) {
        this.lrecivdate = lrecivdate;
    }

    public BigDecimal getSdqy1() {
        return sdqy1;
    }

    public void setSdqy1(BigDecimal sdqy1) {
        this.sdqy1 = sdqy1;
    }

    public String getPredict() {
        return predict;
    }

    public void setPredict(String predict) {
        this.predict = predict;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purdtaPK != null ? purdtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purdta)) {
            return false;
        }
        Purdta other = (Purdta) object;
        if ((this.purdtaPK == null && other.purdtaPK != null) || (this.purdtaPK != null && !this.purdtaPK.equals(other.purdtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purdta[ purdtaPK=" + purdtaPK + " ]";
    }

}
