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
 * @author Administrator
 */
@Entity
@Table(name = "bomsub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bomsub.findAll", query = "SELECT b FROM Bomsub b")
    , @NamedQuery(name = "Bomsub.findByItnbrf", query = "SELECT b FROM Bomsub b WHERE b.bomsubPK.itnbrf = :itnbrf")
    , @NamedQuery(name = "Bomsub.findByOptkind", query = "SELECT b FROM Bomsub b WHERE b.bomsubPK.optkind = :optkind")
    , @NamedQuery(name = "Bomsub.findByOptvalue", query = "SELECT b FROM Bomsub b WHERE b.bomsubPK.optvalue = :optvalue")
    , @NamedQuery(name = "Bomsub.findByItnbr", query = "SELECT b FROM Bomsub b WHERE b.bomsubPK.itnbr = :itnbr")
    , @NamedQuery(name = "Bomsub.findByItnbrs", query = "SELECT b FROM Bomsub b WHERE b.bomsubPK.itnbrs = :itnbrs")
    , @NamedQuery(name = "Bomsub.findByPKItnbrs", query = "SELECT b FROM Bomsub b WHERE b.bomsubPK.itnbrf = :itnbrf AND b.bomsubPK.itnbr = :itnbr AND b.bomsubPK.itnbrs = :itnbrs")
    , @NamedQuery(name = "Bomsub.findByItem", query = "SELECT b FROM Bomsub b WHERE b.item = :item")
    , @NamedQuery(name = "Bomsub.findBySeqnr", query = "SELECT b FROM Bomsub b WHERE b.seqnr = :seqnr")
    , @NamedQuery(name = "Bomsub.findByStdqty", query = "SELECT b FROM Bomsub b WHERE b.stdqty = :stdqty")
    , @NamedQuery(name = "Bomsub.findByStdpar", query = "SELECT b FROM Bomsub b WHERE b.stdpar = :stdpar")
    , @NamedQuery(name = "Bomsub.findByBadrat", query = "SELECT b FROM Bomsub b WHERE b.badrat = :badrat")
    , @NamedQuery(name = "Bomsub.findBySparecode", query = "SELECT b FROM Bomsub b WHERE b.sparecode = :sparecode")
    , @NamedQuery(name = "Bomsub.findByValiddate", query = "SELECT b FROM Bomsub b WHERE b.validdate = :validdate")
    , @NamedQuery(name = "Bomsub.findByInvaldate", query = "SELECT b FROM Bomsub b WHERE b.invaldate = :invaldate")
    , @NamedQuery(name = "Bomsub.findByRemark1", query = "SELECT b FROM Bomsub b WHERE b.remark1 = :remark1")
    , @NamedQuery(name = "Bomsub.findBySaftycode", query = "SELECT b FROM Bomsub b WHERE b.saftycode = :saftycode")
    , @NamedQuery(name = "Bomsub.findByOldcode", query = "SELECT b FROM Bomsub b WHERE b.oldcode = :oldcode")
    , @NamedQuery(name = "Bomsub.findBySitdsc", query = "SELECT b FROM Bomsub b WHERE b.sitdsc = :sitdsc")})
public class Bomsub implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BomsubPK bomsubPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqnr")
    private short seqnr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "stdqty")
    private BigDecimal stdqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stdpar")
    private short stdpar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "badrat")
    private BigDecimal badrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sparecode")
    private Character sparecode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invaldate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invaldate;
    @Size(max = 10)
    @Column(name = "remark1")
    private String remark1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saftycode")
    private Character saftycode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oldcode")
    private Character oldcode;
    @Size(max = 20)
    @Column(name = "sitdsc")
    private String sitdsc;

    public Bomsub() {
    }

    public Bomsub(BomsubPK bomsubPK) {
        this.bomsubPK = bomsubPK;
    }

    public Bomsub(BomsubPK bomsubPK, String item, short seqnr, BigDecimal stdqty, short stdpar, BigDecimal badrat, Character sparecode, Date validdate, Date invaldate, Character saftycode, Character oldcode) {
        this.bomsubPK = bomsubPK;
        this.item = item;
        this.seqnr = seqnr;
        this.stdqty = stdqty;
        this.stdpar = stdpar;
        this.badrat = badrat;
        this.sparecode = sparecode;
        this.validdate = validdate;
        this.invaldate = invaldate;
        this.saftycode = saftycode;
        this.oldcode = oldcode;
    }

    public Bomsub(String itnbrf, String optkind, String optvalue, String itnbr, String itnbrs) {
        this.bomsubPK = new BomsubPK(itnbrf, optkind, optvalue, itnbr, itnbrs);
    }

    public BomsubPK getBomsubPK() {
        return bomsubPK;
    }

    public void setBomsubPK(BomsubPK bomsubPK) {
        this.bomsubPK = bomsubPK;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public short getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(short seqnr) {
        this.seqnr = seqnr;
    }

    public BigDecimal getStdqty() {
        return stdqty;
    }

    public void setStdqty(BigDecimal stdqty) {
        this.stdqty = stdqty;
    }

    public short getStdpar() {
        return stdpar;
    }

    public void setStdpar(short stdpar) {
        this.stdpar = stdpar;
    }

    public BigDecimal getBadrat() {
        return badrat;
    }

    public void setBadrat(BigDecimal badrat) {
        this.badrat = badrat;
    }

    public Character getSparecode() {
        return sparecode;
    }

    public void setSparecode(Character sparecode) {
        this.sparecode = sparecode;
    }

    public Date getValiddate() {
        return validdate;
    }

    public void setValiddate(Date validdate) {
        this.validdate = validdate;
    }

    public Date getInvaldate() {
        return invaldate;
    }

    public void setInvaldate(Date invaldate) {
        this.invaldate = invaldate;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public Character getSaftycode() {
        return saftycode;
    }

    public void setSaftycode(Character saftycode) {
        this.saftycode = saftycode;
    }

    public Character getOldcode() {
        return oldcode;
    }

    public void setOldcode(Character oldcode) {
        this.oldcode = oldcode;
    }

    public String getSitdsc() {
        return sitdsc;
    }

    public void setSitdsc(String sitdsc) {
        this.sitdsc = sitdsc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bomsubPK != null ? bomsubPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bomsub)) {
            return false;
        }
        Bomsub other = (Bomsub) object;
        if ((this.bomsubPK == null && other.bomsubPK != null) || (this.bomsubPK != null && !this.bomsubPK.equals(other.bomsubPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Bomsub[ bomsubPK=" + bomsubPK + " ]";
    }

}
