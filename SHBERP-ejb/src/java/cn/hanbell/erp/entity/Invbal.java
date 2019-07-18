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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
@Table(name = "invbal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invbal.findByItnbr", query = "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr = :itnbr"),
    @NamedQuery(name = "Invbal.findByItnbrAndWareh", query = "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr = :itnbr AND i.invbalPK.wareh = :wareh"),
    @NamedQuery(name = "Invbal.findByItcls", query = "SELECT i FROM Invbal i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "Invbal.findByPK", query = "SELECT i FROM Invbal i WHERE i.invbalPK.facno = :facno AND i.invbalPK.prono = :prono AND i.invbalPK.itnbr = :itnbr AND i.invbalPK.wareh = :wareh")})
public class Invbal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvbalPK invbalPK;
    @MapsId("wareh")//映射主键中的属性,转成对象
    @ManyToOne
    @JoinColumn(name = "wareh")
    private Invwh invwh;
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
    @Column(name = "cyclecnt")
    private int cyclecnt;
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Column(name = "lindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lindate;
    @Column(name = "loudate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loudate;
    @Column(name = "lcydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lcydate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preqy1")
    private BigDecimal preqy1;
    @Column(name = "preqy2")
    private BigDecimal preqy2;
    @Column(name = "preqy3")
    private BigDecimal preqy3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onhand1")
    private BigDecimal onhand1;
    @Column(name = "onhand2")
    private BigDecimal onhand2;
    @Column(name = "onhand3")
    private BigDecimal onhand3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mbegqy1")
    private BigDecimal mbegqy1;
    @Column(name = "mbegqy2")
    private BigDecimal mbegqy2;
    @Column(name = "mbegqy3")
    private BigDecimal mbegqy3;

    public Invbal() {
        this.preqy1 = BigDecimal.ZERO;
        this.preqy2 = BigDecimal.ZERO;
        this.preqy3 = BigDecimal.ZERO;
        this.onhand1 = BigDecimal.ZERO;
        this.onhand2 = BigDecimal.ZERO;
        this.onhand3 = BigDecimal.ZERO;
        this.mbegqy1 = BigDecimal.ZERO;
        this.mbegqy2 = BigDecimal.ZERO;
        this.mbegqy3 = BigDecimal.ZERO;
    }

    public Invbal(InvbalPK invbalPK) {
        this.invbalPK = invbalPK;
        this.preqy1 = BigDecimal.ZERO;
        this.preqy2 = BigDecimal.ZERO;
        this.preqy3 = BigDecimal.ZERO;
        this.onhand1 = BigDecimal.ZERO;
        this.onhand2 = BigDecimal.ZERO;
        this.onhand3 = BigDecimal.ZERO;
        this.mbegqy1 = BigDecimal.ZERO;
        this.mbegqy2 = BigDecimal.ZERO;
        this.mbegqy3 = BigDecimal.ZERO;
    }

    public Invbal(String facno, String prono, String itnbr, String wareh) {
        this.invbalPK = new InvbalPK(facno, prono, itnbr, wareh);
        this.preqy1 = BigDecimal.ZERO;
        this.preqy2 = BigDecimal.ZERO;
        this.preqy3 = BigDecimal.ZERO;
        this.onhand1 = BigDecimal.ZERO;
        this.onhand2 = BigDecimal.ZERO;
        this.onhand3 = BigDecimal.ZERO;
        this.mbegqy1 = BigDecimal.ZERO;
        this.mbegqy2 = BigDecimal.ZERO;
        this.mbegqy3 = BigDecimal.ZERO;
    }

    public InvbalPK getInvbalPK() {
        return invbalPK;
    }

    public void setInvbalPK(InvbalPK invbalPK) {
        this.invbalPK = invbalPK;
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

    public int getCyclecnt() {
        return cyclecnt;
    }

    public void setCyclecnt(int cyclecnt) {
        this.cyclecnt = cyclecnt;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public Date getLindate() {
        return lindate;
    }

    public void setLindate(Date lindate) {
        this.lindate = lindate;
    }

    public Date getLoudate() {
        return loudate;
    }

    public void setLoudate(Date loudate) {
        this.loudate = loudate;
    }

    public Date getLcydate() {
        return lcydate;
    }

    public void setLcydate(Date lcydate) {
        this.lcydate = lcydate;
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

    public BigDecimal getPreqy3() {
        return preqy3;
    }

    public void setPreqy3(BigDecimal preqy3) {
        this.preqy3 = preqy3;
    }

    public BigDecimal getOnhand1() {
        return onhand1;
    }

    public void setOnhand1(BigDecimal onhand1) {
        this.onhand1 = onhand1;
    }

    public BigDecimal getOnhand2() {
        return onhand2;
    }

    public void setOnhand2(BigDecimal onhand2) {
        this.onhand2 = onhand2;
    }

    public BigDecimal getOnhand3() {
        return onhand3;
    }

    public void setOnhand3(BigDecimal onhand3) {
        this.onhand3 = onhand3;
    }

    public BigDecimal getMbegqy1() {
        return mbegqy1;
    }

    public void setMbegqy1(BigDecimal mbegqy1) {
        this.mbegqy1 = mbegqy1;
    }

    public BigDecimal getMbegqy2() {
        return mbegqy2;
    }

    public void setMbegqy2(BigDecimal mbegqy2) {
        this.mbegqy2 = mbegqy2;
    }

    public BigDecimal getMbegqy3() {
        return mbegqy3;
    }

    public void setMbegqy3(BigDecimal mbegqy3) {
        this.mbegqy3 = mbegqy3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invbalPK != null ? invbalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invbal)) {
            return false;
        }
        Invbal other = (Invbal) object;
        if ((this.invbalPK == null && other.invbalPK != null) || (this.invbalPK != null && !this.invbalPK.equals(other.invbalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.shb.ejb.Invbal[ invbalPK=" + invbalPK + " ]";
    }

    /**
     * @return the invwh
     */
    public Invwh getInvwh() {
        return invwh;
    }

    /**
     * @param invwh the invwh to set
     */
    public void setInvwh(Invwh invwh) {
        this.invwh = invwh;
    }

}
