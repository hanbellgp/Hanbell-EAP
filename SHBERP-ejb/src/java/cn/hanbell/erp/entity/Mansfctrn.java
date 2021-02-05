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
 * @author kevindong
 */
@Entity
@Table(name = "mansfctrn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mansfctrn.findAll", query = "SELECT m FROM Mansfctrn m"),
    @NamedQuery(name = "Mansfctrn.findByFacno", query = "SELECT m FROM Mansfctrn m WHERE m.mansfctrnPK.facno = :facno"),
    @NamedQuery(name = "Mansfctrn.findByProno", query = "SELECT m FROM Mansfctrn m WHERE m.mansfctrnPK.prono = :prono"),
    @NamedQuery(name = "Mansfctrn.findByManno", query = "SELECT m FROM Mansfctrn m WHERE m.mansfctrnPK.manno = :manno"),
    @NamedQuery(name = "Mansfctrn.findByTrtype", query = "SELECT m FROM Mansfctrn m WHERE m.mansfctrnPK.trtype = :trtype"),
    @NamedQuery(name = "Mansfctrn.findByTrno", query = "SELECT m FROM Mansfctrn m WHERE m.mansfctrnPK.trno = :trno"),
    @NamedQuery(name = "Mansfctrn.findByTrseq", query = "SELECT m FROM Mansfctrn m WHERE m.mansfctrnPK.trseq = :trseq"),
    @NamedQuery(name = "Mansfctrn.findByTrdate", query = "SELECT m FROM Mansfctrn m WHERE m.trdate = :trdate"),
    @NamedQuery(name = "Mansfctrn.findByItnbr", query = "SELECT m FROM Mansfctrn m WHERE m.itnbr = :itnbr"),
    @NamedQuery(name = "Mansfctrn.findByTrnqy1", query = "SELECT m FROM Mansfctrn m WHERE m.trnqy1 = :trnqy1"),
    @NamedQuery(name = "Mansfctrn.findByIocode", query = "SELECT m FROM Mansfctrn m WHERE m.iocode = :iocode"),
    @NamedQuery(name = "Mansfctrn.findByDepno", query = "SELECT m FROM Mansfctrn m WHERE m.depno = :depno"),
    @NamedQuery(name = "Mansfctrn.findByPctno", query = "SELECT m FROM Mansfctrn m WHERE m.pctno = :pctno"),
    @NamedQuery(name = "Mansfctrn.findByWrcode", query = "SELECT m FROM Mansfctrn m WHERE m.wrcode = :wrcode"),
    @NamedQuery(name = "Mansfctrn.findByProsscode", query = "SELECT m FROM Mansfctrn m WHERE m.prosscode = :prosscode"),
    @NamedQuery(name = "Mansfctrn.findByProseq", query = "SELECT m FROM Mansfctrn m WHERE m.proseq = :proseq"),
    @NamedQuery(name = "Mansfctrn.findByReascode", query = "SELECT m FROM Mansfctrn m WHERE m.reascode = :reascode"),
    @NamedQuery(name = "Mansfctrn.findByKeyindate", query = "SELECT m FROM Mansfctrn m WHERE m.keyindate = :keyindate"),
    @NamedQuery(name = "Mansfctrn.findByUserno", query = "SELECT m FROM Mansfctrn m WHERE m.userno = :userno"),
    @NamedQuery(name = "Mansfctrn.findByVarnr", query = "SELECT m FROM Mansfctrn m WHERE m.varnr = :varnr"),
    @NamedQuery(name = "Mansfctrn.findByFixnr", query = "SELECT m FROM Mansfctrn m WHERE m.fixnr = :fixnr")})
public class Mansfctrn implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MansfctrnPK mansfctrnPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "trnqy1")
    private BigDecimal trnqy1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iocode")
    private Character iocode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "pctno")
    private String pctno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "wrcode")
    private String wrcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "prosscode")
    private String prosscode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proseq")
    private short proseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reascode")
    private Character reascode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "keyindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyindate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Size(max = 18)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 8)
    @Column(name = "fixnr")
    private String fixnr;

    public Mansfctrn() {
    }

    public Mansfctrn(MansfctrnPK mansfctrnPK) {
        this.mansfctrnPK = mansfctrnPK;
    }

    public Mansfctrn(MansfctrnPK mansfctrnPK, Date trdate, String itnbr, BigDecimal trnqy1, Character iocode, String depno, String pctno, String wrcode, String prosscode, short proseq, Character reascode, Date keyindate, String userno) {
        this.mansfctrnPK = mansfctrnPK;
        this.trdate = trdate;
        this.itnbr = itnbr;
        this.trnqy1 = trnqy1;
        this.iocode = iocode;
        this.depno = depno;
        this.pctno = pctno;
        this.wrcode = wrcode;
        this.prosscode = prosscode;
        this.proseq = proseq;
        this.reascode = reascode;
        this.keyindate = keyindate;
        this.userno = userno;
    }

    public Mansfctrn(String facno, String prono, String manno, String trtype, String trno, short trseq) {
        this.mansfctrnPK = new MansfctrnPK(facno, prono, manno, trtype, trno, trseq);
    }

    public MansfctrnPK getMansfctrnPK() {
        return mansfctrnPK;
    }

    public void setMansfctrnPK(MansfctrnPK mansfctrnPK) {
        this.mansfctrnPK = mansfctrnPK;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public BigDecimal getTrnqy1() {
        return trnqy1;
    }

    public void setTrnqy1(BigDecimal trnqy1) {
        this.trnqy1 = trnqy1;
    }

    public Character getIocode() {
        return iocode;
    }

    public void setIocode(Character iocode) {
        this.iocode = iocode;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getPctno() {
        return pctno;
    }

    public void setPctno(String pctno) {
        this.pctno = pctno;
    }

    public String getWrcode() {
        return wrcode;
    }

    public void setWrcode(String wrcode) {
        this.wrcode = wrcode;
    }

    public String getProsscode() {
        return prosscode;
    }

    public void setProsscode(String prosscode) {
        this.prosscode = prosscode;
    }

    public short getProseq() {
        return proseq;
    }

    public void setProseq(short proseq) {
        this.proseq = proseq;
    }

    public Character getReascode() {
        return reascode;
    }

    public void setReascode(Character reascode) {
        this.reascode = reascode;
    }

    public Date getKeyindate() {
        return keyindate;
    }

    public void setKeyindate(Date keyindate) {
        this.keyindate = keyindate;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mansfctrnPK != null ? mansfctrnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mansfctrn)) {
            return false;
        }
        Mansfctrn other = (Mansfctrn) object;
        if ((this.mansfctrnPK == null && other.mansfctrnPK != null) || (this.mansfctrnPK != null && !this.mansfctrnPK.equals(other.mansfctrnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Mansfctrn[ mansfctrnPK=" + mansfctrnPK + " ]";
    }
    
}
