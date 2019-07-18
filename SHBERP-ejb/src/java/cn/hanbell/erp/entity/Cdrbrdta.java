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
@Table(name = "cdrbrdta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrbrdta.findAll", query = "SELECT c FROM Cdrbrdta c"),
    @NamedQuery(name = "Cdrbrdta.findByFacno", query = "SELECT c FROM Cdrbrdta c WHERE c.cdrbrdtaPK.facno = :facno"),
    @NamedQuery(name = "Cdrbrdta.findByBrtrno", query = "SELECT c FROM Cdrbrdta c WHERE c.cdrbrdtaPK.brtrno = :brtrno"),
    @NamedQuery(name = "Cdrbrdta.findByTrseq", query = "SELECT c FROM Cdrbrdta c WHERE c.cdrbrdtaPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrbrdta.findByLntrno", query = "SELECT c FROM Cdrbrdta c WHERE c.lntrno = :lntrno"),
    @NamedQuery(name = "Cdrbrdta.findByLntrseq", query = "SELECT c FROM Cdrbrdta c WHERE c.lntrseq = :lntrseq"),
    @NamedQuery(name = "Cdrbrdta.findByItnbr", query = "SELECT c FROM Cdrbrdta c WHERE c.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrbrdta.findByWareh", query = "SELECT c FROM Cdrbrdta c WHERE c.wareh = :wareh"),
    @NamedQuery(name = "Cdrbrdta.findByFixnr", query = "SELECT c FROM Cdrbrdta c WHERE c.fixnr = :fixnr"),
    @NamedQuery(name = "Cdrbrdta.findByVarnr", query = "SELECT c FROM Cdrbrdta c WHERE c.varnr = :varnr"),
    @NamedQuery(name = "Cdrbrdta.findByBrpqy1", query = "SELECT c FROM Cdrbrdta c WHERE c.brpqy1 = :brpqy1"),
    @NamedQuery(name = "Cdrbrdta.findByBrpqy2", query = "SELECT c FROM Cdrbrdta c WHERE c.brpqy2 = :brpqy2"),
    @NamedQuery(name = "Cdrbrdta.findByBrdate", query = "SELECT c FROM Cdrbrdta c WHERE c.brdate = :brdate"),
    @NamedQuery(name = "Cdrbrdta.findByPyhbrdate", query = "SELECT c FROM Cdrbrdta c WHERE c.pyhbrdate = :pyhbrdate"),
    @NamedQuery(name = "Cdrbrdta.findByDmark1", query = "SELECT c FROM Cdrbrdta c WHERE c.dmark1 = :dmark1"),
    @NamedQuery(name = "Cdrbrdta.findByDmark2", query = "SELECT c FROM Cdrbrdta c WHERE c.dmark2 = :dmark2"),
    @NamedQuery(name = "Cdrbrdta.findByProno", query = "SELECT c FROM Cdrbrdta c WHERE c.prono = :prono"),
    @NamedQuery(name = "Cdrbrdta.findByShpno", query = "SELECT c FROM Cdrbrdta c WHERE c.shpno = :shpno"),
    @NamedQuery(name = "Cdrbrdta.findByStatus", query = "SELECT c FROM Cdrbrdta c WHERE c.status = :status"),
    @NamedQuery(name = "Cdrbrdta.findByMark1", query = "SELECT c FROM Cdrbrdta c WHERE c.mark1 = :mark1"),
    @NamedQuery(name = "Cdrbrdta.findByMark2", query = "SELECT c FROM Cdrbrdta c WHERE c.mark2 = :mark2"),
    @NamedQuery(name = "Cdrbrdta.findByAsrsQty", query = "SELECT c FROM Cdrbrdta c WHERE c.asrsQty = :asrsQty"),
    @NamedQuery(name = "Cdrbrdta.findByAsrsUser", query = "SELECT c FROM Cdrbrdta c WHERE c.asrsUser = :asrsUser"),
    @NamedQuery(name = "Cdrbrdta.findByAsrsDmark", query = "SELECT c FROM Cdrbrdta c WHERE c.asrsDmark = :asrsDmark"),
    @NamedQuery(name = "Cdrbrdta.findByAsrsSta", query = "SELECT c FROM Cdrbrdta c WHERE c.asrsSta = :asrsSta"),
    @NamedQuery(name = "Cdrbrdta.findByPohzfwd", query = "SELECT c FROM Cdrbrdta c WHERE c.pohzfwd = :pohzfwd"),
    @NamedQuery(name = "Cdrbrdta.findByMarkdesc", query = "SELECT c FROM Cdrbrdta c WHERE c.markdesc = :markdesc")})
public class Cdrbrdta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrbrdtaPK cdrbrdtaPK;
    @Size(max = 18)
    @Column(name = "lntrno")
    private String lntrno;
    @Column(name = "lntrseq")
    private Short lntrseq;
    @Size(max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 12)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 18)
    @Column(name = "varnr")
    private String varnr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "brpqy1")
    private BigDecimal brpqy1;
    @Column(name = "brpqy2")
    private BigDecimal brpqy2;
    @Column(name = "brdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date brdate;
    @Column(name = "pyhbrdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pyhbrdate;
    @Size(max = 20)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 20)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 18)
    @Column(name = "shpno")
    private String shpno;
    @Column(name = "status")
    private Character status;
    @Size(max = 50)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 50)
    @Column(name = "mark2")
    private String mark2;
    @Column(name = "asrs_qty")
    private BigDecimal asrsQty;
    @Size(max = 20)
    @Column(name = "asrs_user")
    private String asrsUser;
    @Size(max = 60)
    @Column(name = "asrs_dmark")
    private String asrsDmark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asrs_sta")
    private int asrsSta;
    @Size(max = 2)
    @Column(name = "pohzfwd")
    private String pohzfwd;
    @Size(max = 60)
    @Column(name = "markdesc")
    private String markdesc;
    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "brtrno", referencedColumnName = "brtrno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cdrbrhad cdrbrhad;

    public Cdrbrdta() {
    }

    public Cdrbrdta(CdrbrdtaPK cdrbrdtaPK) {
        this.cdrbrdtaPK = cdrbrdtaPK;
    }

    public Cdrbrdta(CdrbrdtaPK cdrbrdtaPK, int asrsSta) {
        this.cdrbrdtaPK = cdrbrdtaPK;
        this.asrsSta = asrsSta;
    }

    public Cdrbrdta(String facno, String brtrno, short trseq) {
        this.cdrbrdtaPK = new CdrbrdtaPK(facno, brtrno, trseq);
    }

    public CdrbrdtaPK getCdrbrdtaPK() {
        return cdrbrdtaPK;
    }

    public void setCdrbrdtaPK(CdrbrdtaPK cdrbrdtaPK) {
        this.cdrbrdtaPK = cdrbrdtaPK;
    }

    public String getLntrno() {
        return lntrno;
    }

    public void setLntrno(String lntrno) {
        this.lntrno = lntrno;
    }

    public Short getLntrseq() {
        return lntrseq;
    }

    public void setLntrseq(Short lntrseq) {
        this.lntrseq = lntrseq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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

    public BigDecimal getBrpqy1() {
        return brpqy1;
    }

    public void setBrpqy1(BigDecimal brpqy1) {
        this.brpqy1 = brpqy1;
    }

    public BigDecimal getBrpqy2() {
        return brpqy2;
    }

    public void setBrpqy2(BigDecimal brpqy2) {
        this.brpqy2 = brpqy2;
    }

    public Date getBrdate() {
        return brdate;
    }

    public void setBrdate(Date brdate) {
        this.brdate = brdate;
    }

    public Date getPyhbrdate() {
        return pyhbrdate;
    }

    public void setPyhbrdate(Date pyhbrdate) {
        this.pyhbrdate = pyhbrdate;
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

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
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

    public int getAsrsSta() {
        return asrsSta;
    }

    public void setAsrsSta(int asrsSta) {
        this.asrsSta = asrsSta;
    }

    public String getPohzfwd() {
        return pohzfwd;
    }

    public void setPohzfwd(String pohzfwd) {
        this.pohzfwd = pohzfwd;
    }

    public String getMarkdesc() {
        return markdesc;
    }

    public void setMarkdesc(String markdesc) {
        this.markdesc = markdesc;
    }

    public Cdrbrhad getCdrbrhad() {
        return cdrbrhad;
    }

    public void setCdrbrhad(Cdrbrhad cdrbrhad) {
        this.cdrbrhad = cdrbrhad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrbrdtaPK != null ? cdrbrdtaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrbrdta)) {
            return false;
        }
        Cdrbrdta other = (Cdrbrdta) object;
        if ((this.cdrbrdtaPK == null && other.cdrbrdtaPK != null) || (this.cdrbrdtaPK != null && !this.cdrbrdtaPK.equals(other.cdrbrdtaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrbrdta[ cdrbrdtaPK=" + cdrbrdtaPK + " ]";
    }
    
}
