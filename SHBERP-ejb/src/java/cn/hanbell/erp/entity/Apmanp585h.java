/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
@Table(name = "apmanp585h")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmanp585h.findAll", query = "SELECT a FROM Apmanp585h a"),
    @NamedQuery(name = "Apmanp585h.findByFacno", query = "SELECT a FROM Apmanp585h a WHERE a.apmanp585hPK.facno = :facno"),
    @NamedQuery(name = "Apmanp585h.findByAnpno", query = "SELECT a FROM Apmanp585h a WHERE a.apmanp585hPK.anpno = :anpno"),
    @NamedQuery(name = "Apmanp585h.findByTpydat", query = "SELECT a FROM Apmanp585h a WHERE a.tpydat = :tpydat"),
    @NamedQuery(name = "Apmanp585h.findBySrcprogram", query = "SELECT a FROM Apmanp585h a WHERE a.srcprogram = :srcprogram"),
    @NamedQuery(name = "Apmanp585h.findByExtcnt", query = "SELECT a FROM Apmanp585h a WHERE a.extcnt = :extcnt"),
    @NamedQuery(name = "Apmanp585h.findByPayuserid", query = "SELECT a FROM Apmanp585h a WHERE a.payuserid = :payuserid"),
    @NamedQuery(name = "Apmanp585h.findByOaid", query = "SELECT a FROM Apmanp585h a WHERE a.oaid = :oaid")})
public class Apmanp585h implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Apmanp585hPK apmanp585hPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tpydat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tpydat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "srcprogram")
    private String srcprogram;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extcnt")
    private short extcnt;
    @Size(max = 50)
    @Column(name = "payuserid")
    private String payuserid;
    @Size(max = 30)
    @Column(name = "OAID")
    private String oaid;

    public Apmanp585h() {
    }

    public Apmanp585h(Apmanp585hPK apmanp585hPK) {
        this.apmanp585hPK = apmanp585hPK;
    }

    public Apmanp585h(Apmanp585hPK apmanp585hPK, Date tpydat, String srcprogram, short extcnt) {
        this.apmanp585hPK = apmanp585hPK;
        this.tpydat = tpydat;
        this.srcprogram = srcprogram;
        this.extcnt = extcnt;
    }

    public Apmanp585h(String facno, String anpno) {
        this.apmanp585hPK = new Apmanp585hPK(facno, anpno);
    }

    public Apmanp585hPK getApmanp585hPK() {
        return apmanp585hPK;
    }

    public void setApmanp585hPK(Apmanp585hPK apmanp585hPK) {
        this.apmanp585hPK = apmanp585hPK;
    }

    public Date getTpydat() {
        return tpydat;
    }

    public void setTpydat(Date tpydat) {
        this.tpydat = tpydat;
    }

    public String getSrcprogram() {
        return srcprogram;
    }

    public void setSrcprogram(String srcprogram) {
        this.srcprogram = srcprogram;
    }

    public short getExtcnt() {
        return extcnt;
    }

    public void setExtcnt(short extcnt) {
        this.extcnt = extcnt;
    }

    public String getPayuserid() {
        return payuserid;
    }

    public void setPayuserid(String payuserid) {
        this.payuserid = payuserid;
    }

    public String getOaid() {
        return oaid;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmanp585hPK != null ? apmanp585hPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmanp585h)) {
            return false;
        }
        Apmanp585h other = (Apmanp585h) object;
        if ((this.apmanp585hPK == null && other.apmanp585hPK != null) || (this.apmanp585hPK != null && !this.apmanp585hPK.equals(other.apmanp585hPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmanp585h[ apmanp585hPK=" + apmanp585hPK + " ]";
    }
    
}
