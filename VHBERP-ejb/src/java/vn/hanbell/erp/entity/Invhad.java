
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

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
@Table(name = "invhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invhad.findAll", query = "SELECT i FROM Invhad i"),
    @NamedQuery(name = "Invhad.findByFacno", query = "SELECT i FROM Invhad i WHERE i.invhadPK.facno = :facno"),
    @NamedQuery(name = "Invhad.findByProno", query = "SELECT i FROM Invhad i WHERE i.invhadPK.prono = :prono"),
    @NamedQuery(name = "Invhad.findByTrno", query = "SELECT i FROM Invhad i WHERE i.invhadPK.trno = :trno"),
    @NamedQuery(name = "Invhad.findByTrdate", query = "SELECT i FROM Invhad i WHERE i.trdate = :trdate"),
    @NamedQuery(name = "Invhad.findByDepno", query = "SELECT i FROM Invhad i WHERE i.depno = :depno"),
    @NamedQuery(name = "Invhad.findByIocode", query = "SELECT i FROM Invhad i WHERE i.iocode = :iocode"),
    @NamedQuery(name = "Invhad.findByHmark1", query = "SELECT i FROM Invhad i WHERE i.hmark1 = :hmark1"),
    @NamedQuery(name = "Invhad.findByHmark2", query = "SELECT i FROM Invhad i WHERE i.hmark2 = :hmark2"),
    @NamedQuery(name = "Invhad.findByResno", query = "SELECT i FROM Invhad i WHERE i.resno = :resno"),
    @NamedQuery(name = "Invhad.findBySourceno", query = "SELECT i FROM Invhad i WHERE i.sourceno = :sourceno"),
    @NamedQuery(name = "Invhad.findByUserno", query = "SELECT i FROM Invhad i WHERE i.userno = :userno"),
    @NamedQuery(name = "Invhad.findByIndate", query = "SELECT i FROM Invhad i WHERE i.indate = :indate"),
    @NamedQuery(name = "Invhad.findByCfmuserno", query = "SELECT i FROM Invhad i WHERE i.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Invhad.findByCfmdate", query = "SELECT i FROM Invhad i WHERE i.cfmdate = :cfmdate"),
    @NamedQuery(name = "Invhad.findByStatus", query = "SELECT i FROM Invhad i WHERE i.status = :status"),
    @NamedQuery(name = "Invhad.findByPrtcnt", query = "SELECT i FROM Invhad i WHERE i.prtcnt = :prtcnt"),
    @NamedQuery(name = "Invhad.findByVdrno", query = "SELECT i FROM Invhad i WHERE i.vdrno = :vdrno")})
public class Invhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvhadPK invhadPK;
    @Size(max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;
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
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 60)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 60)
    @Column(name = "fwno")
    private String fwno;

    public Invhad() {
    }

    public Invhad(InvhadPK invhadPK) {
        this.invhadPK = invhadPK;
    }

    public Invhad(InvhadPK invhadPK, Date trdate, String depno, Character iocode, String resno, String userno, Date indate, Character status, short prtcnt) {
        this.invhadPK = invhadPK;
        this.trdate = trdate;
        this.depno = depno;
        this.iocode = iocode;
        this.resno = resno;
        this.userno = userno;
        this.indate = indate;
        this.status = status;
        this.prtcnt = prtcnt;
    }

    public Invhad(String facno, String prono, String trno) {
        this.invhadPK = new InvhadPK(facno, prono, trno);
    }

    public InvhadPK getInvhadPK() {
        return invhadPK;
    }

    public void setInvhadPK(InvhadPK invhadPK) {
        this.invhadPK = invhadPK;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
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

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invhadPK != null ? invhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invhad)) {
            return false;
        }
        Invhad other = (Invhad) object;
        if ((this.invhadPK == null && other.invhadPK != null) || (this.invhadPK != null && !this.invhadPK.equals(other.invhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invhad[ invhadPK=" + invhadPK + " ]";
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

}
