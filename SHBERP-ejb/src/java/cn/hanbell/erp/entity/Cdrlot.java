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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "cdrlot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrlot.findAll", query = "SELECT c FROM Cdrlot c"),
    @NamedQuery(name = "Cdrlot.findByFacno", query = "SELECT c FROM Cdrlot c WHERE c.cdrlotPK.facno = :facno"),
    @NamedQuery(name = "Cdrlot.findByShpno", query = "SELECT c FROM Cdrlot c WHERE c.cdrlotPK.shpno = :shpno"),
    @NamedQuery(name = "Cdrlot.findByFacnoAndShpno", query = "SELECT c FROM Cdrlot c WHERE c.cdrlotPK.facno = :facno AND c.cdrlotPK.shpno = :shpno ORDER BY c.cdrlotPK.shpno,c.cdrlotPK.trseq,c.cdrlotPK.seq")})
public class Cdrlot implements Serializable {

    @JoinColumns({
        @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false),
        @JoinColumn(name = "shpno", referencedColumnName = "shpno", insertable = false, updatable = false),
        @JoinColumn(name = "trseq", referencedColumnName = "trseq", insertable = false, updatable = false)
    })
    @ManyToOne()
    private Cdrdta cdrdta;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrlotPK cdrlotPK;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
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
    @Column(name = "shpqy1")
    private BigDecimal shpqy1;
    @Column(name = "shpqy2")
    private BigDecimal shpqy2;
    @Size(max = 12)
    @Column(name = "owareh")
    private String owareh;
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

    public Cdrlot() {
    }

    public Cdrlot(CdrlotPK cdrlotPK) {
        this.cdrlotPK = cdrlotPK;
    }

    public Cdrlot(CdrlotPK cdrlotPK, int asrsSta) {
        this.cdrlotPK = cdrlotPK;
        this.asrsSta = asrsSta;
    }

    public Cdrlot(String facno, String shpno, short trseq, short seq) {
        this.cdrlotPK = new CdrlotPK(facno, shpno, trseq, seq);
    }

    public CdrlotPK getCdrlotPK() {
        return cdrlotPK;
    }

    public void setCdrlotPK(CdrlotPK cdrlotPK) {
        this.cdrlotPK = cdrlotPK;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
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

    public BigDecimal getShpqy1() {
        return shpqy1;
    }

    public void setShpqy1(BigDecimal shpqy1) {
        this.shpqy1 = shpqy1;
    }

    public BigDecimal getShpqy2() {
        return shpqy2;
    }

    public void setShpqy2(BigDecimal shpqy2) {
        this.shpqy2 = shpqy2;
    }

    public String getOwareh() {
        return owareh;
    }

    public void setOwareh(String owareh) {
        this.owareh = owareh;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrlotPK != null ? cdrlotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrlot)) {
            return false;
        }
        Cdrlot other = (Cdrlot) object;
        if ((this.cdrlotPK == null && other.cdrlotPK != null) || (this.cdrlotPK != null && !this.cdrlotPK.equals(other.cdrlotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrlot[ cdrlotPK=" + cdrlotPK + " ]";
    }

    /**
     * @return the cdrdta
     */
    public Cdrdta getCdrdta() {
        return cdrdta;
    }

    /**
     * @param cdrdta the cdrdta to set
     */
    public void setCdrdta(Cdrdta cdrdta) {
        this.cdrdta = cdrdta;
    }

}
