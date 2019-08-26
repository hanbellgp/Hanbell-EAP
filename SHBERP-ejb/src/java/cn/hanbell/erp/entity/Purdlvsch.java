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
@Table(name = "purdlvsch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purdlvsch.findAll", query = "SELECT p FROM Purdlvsch p"),
    @NamedQuery(name = "Purdlvsch.findByFacno", query = "SELECT p FROM Purdlvsch p WHERE p.purdlvschPK.facno = :facno"),
    @NamedQuery(name = "Purdlvsch.findByProno", query = "SELECT p FROM Purdlvsch p WHERE p.purdlvschPK.prono = :prono"),
    @NamedQuery(name = "Purdlvsch.findByPono", query = "SELECT p FROM Purdlvsch p WHERE p.purdlvschPK.pono = :pono"),
    @NamedQuery(name = "Purdlvsch.findByPK", query = "SELECT p FROM Purdlvsch p WHERE p.purdlvschPK.facno = :facno AND p.purdlvschPK.prono = :prono AND p.purdlvschPK.pono = :pono AND  p.purdlvschPK.trseq = :trseq AND p.purdlvschPK.schseq = :schseq"),
    @NamedQuery(name = "Purdlvsch.findNeedThrowByStatus", query = "SELECT p FROM Purdlvsch p WHERE p.syncsta='N' AND p.schsta='20' AND p.indate>= :indate ORDER BY p.purdlvschPK.pono"),
    @NamedQuery(name = "Purdlvsch.findNeedCancelByStatus", query = "SELECT p FROM Purdlvsch p WHERE p.syncsta='Y' AND p.schsta>'95' AND p.indate>= :indate ORDER BY p.purdlvschPK.pono")})
public class Purdlvsch implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurdlvschPK purdlvschPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Size(max = 10)
    @Column(name = "batnr")
    private String batnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acceptdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acceptdateo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptdateo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "askdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "askdateo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askdateo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "schsta")
    private String schsta;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Column(name = "lrecivedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lrecivedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chgnum")
    private short chgnum;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "poqy1")
    private BigDecimal poqy1;
    @Column(name = "poqy2")
    private BigDecimal poqy2;
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
    @Column(name = "defqy1")
    private BigDecimal defqy1;
    @Column(name = "defqy2")
    private BigDecimal defqy2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "srccode")
    private Character srccode;
    @Column(name = "sdqy1")
    private BigDecimal sdqy1;
    @Size(max = 18)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 18)
    @Column(name = "srcvdrno")
    private String srcvdrno;
    @Size(max = 18)
    @Column(name = "srcvdrna")
    private String srcvdrna;
    @Size(max = 18)
    @Column(name = "refno")
    private String refno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "syncsta")
    private String syncsta;

    public Purdlvsch() {
    }

    public Purdlvsch(PurdlvschPK purdlvschPK) {
        this.purdlvschPK = purdlvschPK;
    }

    public Purdlvsch(PurdlvschPK purdlvschPK, String itnbr, Date indate, String userno, Date acceptdate, Date acceptdateo,
            Date askdate, Date askdateo, String schsta, short chgnum, BigDecimal poqy1, Character srccode, String syncsta) {
        this.purdlvschPK = purdlvschPK;
        this.itnbr = itnbr;
        this.indate = indate;
        this.userno = userno;
        this.acceptdate = acceptdate;
        this.acceptdateo = acceptdateo;
        this.askdate = askdate;
        this.askdateo = askdateo;
        this.schsta = schsta;
        this.chgnum = chgnum;
        this.poqy1 = poqy1;
        this.srccode = srccode;
        this.syncsta = syncsta;
    }

    public Purdlvsch(String facno, String prono, String pono, short trseq, short schseq) {
        this.purdlvschPK = new PurdlvschPK(facno, prono, pono, trseq, schseq);
    }

    public PurdlvschPK getPurdlvschPK() {
        return purdlvschPK;
    }

    public void setPurdlvschPK(PurdlvschPK purdlvschPK) {
        this.purdlvschPK = purdlvschPK;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getBatnr() {
        return batnr;
    }

    public void setBatnr(String batnr) {
        this.batnr = batnr;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    public Date getAcceptdateo() {
        return acceptdateo;
    }

    public void setAcceptdateo(Date acceptdateo) {
        this.acceptdateo = acceptdateo;
    }

    public Date getAskdate() {
        return askdate;
    }

    public void setAskdate(Date askdate) {
        this.askdate = askdate;
    }

    public Date getAskdateo() {
        return askdateo;
    }

    public void setAskdateo(Date askdateo) {
        this.askdateo = askdateo;
    }

    public String getSchsta() {
        return schsta;
    }

    public void setSchsta(String schsta) {
        this.schsta = schsta;
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

    public Date getLrecivedate() {
        return lrecivedate;
    }

    public void setLrecivedate(Date lrecivedate) {
        this.lrecivedate = lrecivedate;
    }

    public short getChgnum() {
        return chgnum;
    }

    public void setChgnum(short chgnum) {
        this.chgnum = chgnum;
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

    public Character getSrccode() {
        return srccode;
    }

    public void setSrccode(Character srccode) {
        this.srccode = srccode;
    }

    public BigDecimal getSdqy1() {
        return sdqy1;
    }

    public void setSdqy1(BigDecimal sdqy1) {
        this.sdqy1 = sdqy1;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getSrcvdrno() {
        return srcvdrno;
    }

    public void setSrcvdrno(String srcvdrno) {
        this.srcvdrno = srcvdrno;
    }

    public String getSrcvdrna() {
        return srcvdrna;
    }

    public void setSrcvdrna(String srcvdrna) {
        this.srcvdrna = srcvdrna;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getSyncsta() {
        return syncsta;
    }

    public void setSyncsta(String syncsta) {
        this.syncsta = syncsta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purdlvschPK != null ? purdlvschPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purdlvsch)) {
            return false;
        }
        Purdlvsch other = (Purdlvsch) object;
        if ((this.purdlvschPK == null && other.purdlvschPK != null)
                || (this.purdlvschPK != null && !this.purdlvschPK.equals(other.purdlvschPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purdlvsch[ purdlvschPK=" + purdlvschPK + " ]";
    }

}
