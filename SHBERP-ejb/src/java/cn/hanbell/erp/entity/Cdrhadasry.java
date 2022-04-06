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
 * @author C2082
 */
@Entity
@Table(name = "cdrhadasry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrhadasry.findAll", query = "SELECT c FROM Cdrhadasry c"),
    @NamedQuery(name = "Cdrhadasry.findByFacno", query = "SELECT c FROM Cdrhadasry c WHERE c.cdrhadasryPK.facno = :facno"),
    @NamedQuery(name = "Cdrhadasry.findByProno", query = "SELECT c FROM Cdrhadasry c WHERE c.cdrhadasryPK.prono = :prono"),
    @NamedQuery(name = "Cdrhadasry.findByTrno", query = "SELECT c FROM Cdrhadasry c WHERE c.cdrhadasryPK.trno = :trno"),
    @NamedQuery(name = "Cdrhadasry.findByTrtype", query = "SELECT c FROM Cdrhadasry c WHERE c.trtype = :trtype"),
    @NamedQuery(name = "Cdrhadasry.findByIssmode", query = "SELECT c FROM Cdrhadasry c WHERE c.issmode = :issmode"),
    @NamedQuery(name = "Cdrhadasry.findByTrdate", query = "SELECT c FROM Cdrhadasry c WHERE c.trdate = :trdate"),
    @NamedQuery(name = "Cdrhadasry.findByShpdepno", query = "SELECT c FROM Cdrhadasry c WHERE c.shpdepno = :shpdepno"),
    @NamedQuery(name = "Cdrhadasry.findByDepno", query = "SELECT c FROM Cdrhadasry c WHERE c.depno = :depno"),
    @NamedQuery(name = "Cdrhadasry.findByIocode", query = "SELECT c FROM Cdrhadasry c WHERE c.iocode = :iocode"),
    @NamedQuery(name = "Cdrhadasry.findByHmark1", query = "SELECT c FROM Cdrhadasry c WHERE c.hmark1 = :hmark1"),
    @NamedQuery(name = "Cdrhadasry.findByHmark2", query = "SELECT c FROM Cdrhadasry c WHERE c.hmark2 = :hmark2"),
    @NamedQuery(name = "Cdrhadasry.findByResno", query = "SELECT c FROM Cdrhadasry c WHERE c.resno = :resno"),
    @NamedQuery(name = "Cdrhadasry.findBySourceno", query = "SELECT c FROM Cdrhadasry c WHERE c.sourceno = :sourceno"),
    @NamedQuery(name = "Cdrhadasry.findByUserno", query = "SELECT c FROM Cdrhadasry c WHERE c.userno = :userno"),
    @NamedQuery(name = "Cdrhadasry.findByIndate", query = "SELECT c FROM Cdrhadasry c WHERE c.indate = :indate"),
    @NamedQuery(name = "Cdrhadasry.findByCfmuserno", query = "SELECT c FROM Cdrhadasry c WHERE c.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Cdrhadasry.findByCfmdate", query = "SELECT c FROM Cdrhadasry c WHERE c.cfmdate = :cfmdate"),
    @NamedQuery(name = "Cdrhadasry.findByStatus", query = "SELECT c FROM Cdrhadasry c WHERE c.status = :status"),
    @NamedQuery(name = "Cdrhadasry.findByPrtcnt", query = "SELECT c FROM Cdrhadasry c WHERE c.prtcnt = :prtcnt"),
    @NamedQuery(name = "Cdrhadasry.findByAsrsQty", query = "SELECT c FROM Cdrhadasry c WHERE c.asrsQty = :asrsQty"),
    @NamedQuery(name = "Cdrhadasry.findByVdrno", query = "SELECT c FROM Cdrhadasry c WHERE c.vdrno = :vdrno"),
    @NamedQuery(name = "Cdrhadasry.findByAsrsstatus", query = "SELECT c FROM Cdrhadasry c WHERE c.asrsstatus = :asrsstatus")})
public class Cdrhadasry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrhadasryPK cdrhadasryPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issmode")
    private Character issmode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "shpdepno")
    private String shpdepno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iocode")
    private Character iocode;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "resno")
    private String resno;
    @Size(max = 18)
    @Column(name = "sourceno")
    private String sourceno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prtcnt")
    private short prtcnt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "asrs_qty")
    private BigDecimal asrsQty;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 1)
    @Column(name = "asrsstatus")
    private String asrsstatus;

    public Cdrhadasry() {
    }

    public Cdrhadasry(CdrhadasryPK cdrhadasryPK) {
        this.cdrhadasryPK = cdrhadasryPK;
    }

    public Cdrhadasry(CdrhadasryPK cdrhadasryPK, String trtype, Character issmode, Date trdate, String shpdepno, String depno, Character iocode, String resno, String userno, Date indate, Character status, short prtcnt) {
        this.cdrhadasryPK = cdrhadasryPK;
        this.trtype = trtype;
        this.issmode = issmode;
        this.trdate = trdate;
        this.shpdepno = shpdepno;
        this.depno = depno;
        this.iocode = iocode;
        this.resno = resno;
        this.userno = userno;
        this.indate = indate;
        this.status = status;
        this.prtcnt = prtcnt;
    }

    public Cdrhadasry(String facno, String prono, String trno) {
        this.cdrhadasryPK = new CdrhadasryPK(facno, prono, trno);
    }

    public CdrhadasryPK getCdrhadasryPK() {
        return cdrhadasryPK;
    }

    public void setCdrhadasryPK(CdrhadasryPK cdrhadasryPK) {
        this.cdrhadasryPK = cdrhadasryPK;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public Character getIssmode() {
        return issmode;
    }

    public void setIssmode(Character issmode) {
        this.issmode = issmode;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public String getShpdepno() {
        return shpdepno;
    }

    public void setShpdepno(String shpdepno) {
        this.shpdepno = shpdepno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Character getIocode() {
        return iocode;
    }

    public void setIocode(Character iocode) {
        this.iocode = iocode;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public String getResno() {
        return resno;
    }

    public void setResno(String resno) {
        this.resno = resno;
    }

    public String getSourceno() {
        return sourceno;
    }

    public void setSourceno(String sourceno) {
        this.sourceno = sourceno;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public BigDecimal getAsrsQty() {
        return asrsQty;
    }

    public void setAsrsQty(BigDecimal asrsQty) {
        this.asrsQty = asrsQty;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getAsrsstatus() {
        return asrsstatus;
    }

    public void setAsrsstatus(String asrsstatus) {
        this.asrsstatus = asrsstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrhadasryPK != null ? cdrhadasryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrhadasry)) {
            return false;
        }
        Cdrhadasry other = (Cdrhadasry) object;
        if ((this.cdrhadasryPK == null && other.cdrhadasryPK != null) || (this.cdrhadasryPK != null && !this.cdrhadasryPK.equals(other.cdrhadasryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Cdrhadasry[ cdrhadasryPK=" + cdrhadasryPK + " ]";
    }
    
}
