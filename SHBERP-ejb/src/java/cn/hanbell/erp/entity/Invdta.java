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
@Table(name = "invdta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invdta.findAll", query = "SELECT i FROM Invdta i"),
    @NamedQuery(name = "Invdta.findByItnbr", query = "SELECT i FROM Invdta i WHERE i.invdtaPK.itnbr = :itnbr"),
    @NamedQuery(name = "Invdta.findByFacno", query = "SELECT i FROM Invdta i WHERE i.invdtaPK.facno = :facno"),
    @NamedQuery(name = "Invdta.findByProno", query = "SELECT i FROM Invdta i WHERE i.invdtaPK.prono = :prono"),
    @NamedQuery(name = "Invdta.findByTrno", query = "SELECT i FROM Invdta i WHERE i.invdtaPK.trno = :trno"),
    @NamedQuery(name = "Invdta.findByTrseq", query = "SELECT i FROM Invdta i WHERE i.invdtaPK.trseq = :trseq"),
    @NamedQuery(name = "Invdta.findByTrtype", query = "SELECT i FROM Invdta i WHERE i.trtype = :trtype"),
    @NamedQuery(name = "Invdta.findByItcls", query = "SELECT i FROM Invdta i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "Invdta.findByItclscode", query = "SELECT i FROM Invdta i WHERE i.itclscode = :itclscode"),
    @NamedQuery(name = "Invdta.findByTrnqy1", query = "SELECT i FROM Invdta i WHERE i.trnqy1 = :trnqy1"),
    @NamedQuery(name = "Invdta.findByTrnqy2", query = "SELECT i FROM Invdta i WHERE i.trnqy2 = :trnqy2"),
    @NamedQuery(name = "Invdta.findByTrnqy3", query = "SELECT i FROM Invdta i WHERE i.trnqy3 = :trnqy3"),
    @NamedQuery(name = "Invdta.findByUnmsr1", query = "SELECT i FROM Invdta i WHERE i.unmsr1 = :unmsr1"),
    @NamedQuery(name = "Invdta.findByUnmsr2", query = "SELECT i FROM Invdta i WHERE i.unmsr2 = :unmsr2"),
    @NamedQuery(name = "Invdta.findByUnmsr3", query = "SELECT i FROM Invdta i WHERE i.unmsr3 = :unmsr3"),
    @NamedQuery(name = "Invdta.findByWareh", query = "SELECT i FROM Invdta i WHERE i.wareh = :wareh"),
    @NamedQuery(name = "Invdta.findByFixnr", query = "SELECT i FROM Invdta i WHERE i.fixnr = :fixnr"),
    @NamedQuery(name = "Invdta.findByVarnr", query = "SELECT i FROM Invdta i WHERE i.varnr = :varnr"),
    @NamedQuery(name = "Invdta.findByIocode", query = "SELECT i FROM Invdta i WHERE i.iocode = :iocode"),
    @NamedQuery(name = "Invdta.findByDmark1", query = "SELECT i FROM Invdta i WHERE i.dmark1 = :dmark1"),
    @NamedQuery(name = "Invdta.findByDmark2", query = "SELECT i FROM Invdta i WHERE i.dmark2 = :dmark2"),
    @NamedQuery(name = "Invdta.findByAsrsQty", query = "SELECT i FROM Invdta i WHERE i.asrsQty = :asrsQty"),
    @NamedQuery(name = "Invdta.findByAsrsUser", query = "SELECT i FROM Invdta i WHERE i.asrsUser = :asrsUser"),
    @NamedQuery(name = "Invdta.findByAsrsDmark", query = "SELECT i FROM Invdta i WHERE i.asrsDmark = :asrsDmark"),
    @NamedQuery(name = "Invdta.findByAsrsSta", query = "SELECT i FROM Invdta i WHERE i.asrsSta = :asrsSta")})
public class Invdta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvdtaPK invdtaPK;
    @Size(max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itclscode")
    private Character itclscode;
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
    @Size(min = 1, max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 12)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 18)
    @Column(name = "varnr")
    private String varnr;
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
    @Column(name = "asrs_qty")
    private BigDecimal asrsQty;
    @Size(max = 20)
    @Column(name = "asrs_user")
    private String asrsUser;
    @Size(max = 60)
    @Column(name = "asrs_dmark")
    private String asrsDmark;
    @Column(name = "asrs_sta")
    private Integer asrsSta;

    public Invdta() {
        this.asrsQty = BigDecimal.ZERO;
        this.asrsSta = 0;
    }

    public Invdta(InvdtaPK invdtaPK) {
        this.invdtaPK = invdtaPK;
        this.asrsQty = BigDecimal.ZERO;
        this.asrsSta = 0;
    }

    public Invdta(String itnbr, String facno, String prono, String trno, int trseq) {
        this.invdtaPK = new InvdtaPK(itnbr, facno, prono, trno, trseq);
        this.asrsQty = BigDecimal.ZERO;
        this.asrsSta = 0;
    }

    public InvdtaPK getInvdtaPK() {
        return invdtaPK;
    }

    public void setInvdtaPK(InvdtaPK invdtaPK) {
        this.invdtaPK = invdtaPK;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
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

    public BigDecimal getAsrsQty() {
        return asrsQty;
    }

    public void setAsrsQty(BigDecimal asrsQty) {
        this.asrsQty = asrsQty;
    }

    public String getAsrsUser() {
        return asrsUser;
    }

    public void setAsrsUser(String asrsUser) {
        this.asrsUser = asrsUser;
    }

    public String getAsrsDmark() {
        return asrsDmark;
    }

    public void setAsrsDmark(String asrsDmark) {
        this.asrsDmark = asrsDmark;
    }

    public Integer getAsrsSta() {
        return asrsSta;
    }

    public void setAsrsSta(Integer asrsSta) {
        this.asrsSta = asrsSta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invdtaPK != null ? invdtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invdta)) {
            return false;
        }
        Invdta other = (Invdta) object;
        if ((this.invdtaPK == null && other.invdtaPK != null) || (this.invdtaPK != null && !this.invdtaPK.equals(other.invdtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invdta[ invdtaPK=" + invdtaPK + " ]";
    }

    public void setDefaultValue() {
        if (this.fixnr == null) {
            this.fixnr = "";
        }
        if (this.varnr == null) {
            this.varnr = "";
        }
    }

}
