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
@Table(name = "manpih")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manpih.findAll", query = "SELECT m FROM Manpih m"),
    @NamedQuery(name = "Manpih.findByFacno", query = "SELECT m FROM Manpih m WHERE m.manpihPK.facno = :facno"),
    @NamedQuery(name = "Manpih.findByProno", query = "SELECT m FROM Manpih m WHERE m.manpihPK.prono = :prono"),
    @NamedQuery(name = "Manpih.findByPisno", query = "SELECT m FROM Manpih m WHERE m.manpihPK.pisno = :pisno"),
    @NamedQuery(name = "Manpih.findByTrtype", query = "SELECT m FROM Manpih m WHERE m.trtype = :trtype"),
    @NamedQuery(name = "Manpih.findByAppno", query = "SELECT m FROM Manpih m WHERE m.appno = :appno"),
    @NamedQuery(name = "Manpih.findByManno", query = "SELECT m FROM Manpih m WHERE m.manno = :manno"),
    @NamedQuery(name = "Manpih.findByProsscode", query = "SELECT m FROM Manpih m WHERE m.prosscode = :prosscode"),
    @NamedQuery(name = "Manpih.findByProseq", query = "SELECT m FROM Manpih m WHERE m.proseq = :proseq"),
    @NamedQuery(name = "Manpih.findByIssqty", query = "SELECT m FROM Manpih m WHERE m.issqty = :issqty"),
    @NamedQuery(name = "Manpih.findByReascode", query = "SELECT m FROM Manpih m WHERE m.reascode = :reascode"),
    @NamedQuery(name = "Manpih.findByIssdepno", query = "SELECT m FROM Manpih m WHERE m.issdepno = :issdepno"),
    @NamedQuery(name = "Manpih.findByWrcode", query = "SELECT m FROM Manpih m WHERE m.wrcode = :wrcode"),
    @NamedQuery(name = "Manpih.findByPctno", query = "SELECT m FROM Manpih m WHERE m.pctno = :pctno"),
    @NamedQuery(name = "Manpih.findByIssdate", query = "SELECT m FROM Manpih m WHERE m.issdate = :issdate"),
    @NamedQuery(name = "Manpih.findByAppuser", query = "SELECT m FROM Manpih m WHERE m.appuser = :appuser"),
    @NamedQuery(name = "Manpih.findByIocode", query = "SELECT m FROM Manpih m WHERE m.iocode = :iocode"),
    @NamedQuery(name = "Manpih.findByIssstatus", query = "SELECT m FROM Manpih m WHERE m.issstatus = :issstatus"),
    @NamedQuery(name = "Manpih.findByItnbrf", query = "SELECT m FROM Manpih m WHERE m.itnbrf = :itnbrf"),
    @NamedQuery(name = "Manpih.findByWareh", query = "SELECT m FROM Manpih m WHERE m.wareh = :wareh"),
    @NamedQuery(name = "Manpih.findByWclerk", query = "SELECT m FROM Manpih m WHERE m.wclerk = :wclerk"),
    @NamedQuery(name = "Manpih.findByHremark1", query = "SELECT m FROM Manpih m WHERE m.hremark1 = :hremark1"),
    @NamedQuery(name = "Manpih.findByHremark2", query = "SELECT m FROM Manpih m WHERE m.hremark2 = :hremark2"),
    @NamedQuery(name = "Manpih.findByPrtseq", query = "SELECT m FROM Manpih m WHERE m.prtseq = :prtseq"),
    @NamedQuery(name = "Manpih.findByIssmode", query = "SELECT m FROM Manpih m WHERE m.issmode = :issmode"),
    @NamedQuery(name = "Manpih.findByKeyindate", query = "SELECT m FROM Manpih m WHERE m.keyindate = :keyindate"),
    @NamedQuery(name = "Manpih.findByUserno", query = "SELECT m FROM Manpih m WHERE m.userno = :userno"),
    @NamedQuery(name = "Manpih.findByCfmdate", query = "SELECT m FROM Manpih m WHERE m.cfmdate = :cfmdate"),
    @NamedQuery(name = "Manpih.findByCfmuserno", query = "SELECT m FROM Manpih m WHERE m.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Manpih.findByWktype", query = "SELECT m FROM Manpih m WHERE m.wktype = :wktype"),
    @NamedQuery(name = "Manpih.findBySrcno", query = "SELECT m FROM Manpih m WHERE m.srcno = :srcno"),
    @NamedQuery(name = "Manpih.findByAsrsQty", query = "SELECT m FROM Manpih m WHERE m.asrsQty = :asrsQty"),
    @NamedQuery(name = "Manpih.findByVdrno", query = "SELECT m FROM Manpih m WHERE m.vdrno = :vdrno"),
    @NamedQuery(name = "Manpih.findByAsrsstatus", query = "SELECT m FROM Manpih m WHERE m.asrsstatus = :asrsstatus"),
    @NamedQuery(name = "Manpih.findBySrcseq", query = "SELECT m FROM Manpih m WHERE m.srcseq = :srcseq")})
public class Manpih implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManpihPK manpihPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "appno")
    private String appno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "manno")
    private String manno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "prosscode")
    private String prosscode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proseq")
    private short proseq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "issqty")
    private BigDecimal issqty;
    @Size(max = 8)
    @Column(name = "reascode")
    private String reascode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "issdepno")
    private String issdepno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "wrcode")
    private String wrcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "pctno")
    private String pctno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "appuser")
    private String appuser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iocode")
    private Character iocode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issstatus")
    private Character issstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "wclerk")
    private String wclerk;
    @Size(max = 8)
    @Column(name = "hremark1")
    private String hremark1;
    @Size(max = 8)
    @Column(name = "hremark2")
    private String hremark2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prtseq")
    private short prtseq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issmode")
    private Character issmode;
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
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wktype")
    private Character wktype;
    @Size(max = 18)
    @Column(name = "srcno")
    private String srcno;
    @Column(name = "asrs_qty")
    private BigDecimal asrsQty;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Column(name = "asrsstatus")
    private Character asrsstatus;
    @Column(name = "srcseq")
    private Short srcseq;

    public Manpih() {
    }

    public Manpih(ManpihPK manpihPK) {
        this.manpihPK = manpihPK;
    }

    public Manpih(ManpihPK manpihPK, String trtype, String appno, String manno, String prosscode, short proseq, BigDecimal issqty, String issdepno, String wrcode, String pctno, Date issdate, String appuser, Character iocode, Character issstatus, String itnbrf, String wareh, String wclerk, short prtseq, Character issmode, Date keyindate, String userno, Character wktype) {
        this.manpihPK = manpihPK;
        this.trtype = trtype;
        this.appno = appno;
        this.manno = manno;
        this.prosscode = prosscode;
        this.proseq = proseq;
        this.issqty = issqty;
        this.issdepno = issdepno;
        this.wrcode = wrcode;
        this.pctno = pctno;
        this.issdate = issdate;
        this.appuser = appuser;
        this.iocode = iocode;
        this.issstatus = issstatus;
        this.itnbrf = itnbrf;
        this.wareh = wareh;
        this.wclerk = wclerk;
        this.prtseq = prtseq;
        this.issmode = issmode;
        this.keyindate = keyindate;
        this.userno = userno;
        this.wktype = wktype;
    }

    public Manpih(String facno, String prono, String pisno) {
        this.manpihPK = new ManpihPK(facno, prono, pisno);
    }

    public ManpihPK getManpihPK() {
        return manpihPK;
    }

    public void setManpihPK(ManpihPK manpihPK) {
        this.manpihPK = manpihPK;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getManno() {
        return manno;
    }

    public void setManno(String manno) {
        this.manno = manno;
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

    public BigDecimal getIssqty() {
        return issqty;
    }

    public void setIssqty(BigDecimal issqty) {
        this.issqty = issqty;
    }

    public String getReascode() {
        return reascode;
    }

    public void setReascode(String reascode) {
        this.reascode = reascode;
    }

    public String getIssdepno() {
        return issdepno;
    }

    public void setIssdepno(String issdepno) {
        this.issdepno = issdepno;
    }

    public String getWrcode() {
        return wrcode;
    }

    public void setWrcode(String wrcode) {
        this.wrcode = wrcode;
    }

    public String getPctno() {
        return pctno;
    }

    public void setPctno(String pctno) {
        this.pctno = pctno;
    }

    public Date getIssdate() {
        return issdate;
    }

    public void setIssdate(Date issdate) {
        this.issdate = issdate;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Character getIocode() {
        return iocode;
    }

    public void setIocode(Character iocode) {
        this.iocode = iocode;
    }

    public Character getIssstatus() {
        return issstatus;
    }

    public void setIssstatus(Character issstatus) {
        this.issstatus = issstatus;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getWclerk() {
        return wclerk;
    }

    public void setWclerk(String wclerk) {
        this.wclerk = wclerk;
    }

    public String getHremark1() {
        return hremark1;
    }

    public void setHremark1(String hremark1) {
        this.hremark1 = hremark1;
    }

    public String getHremark2() {
        return hremark2;
    }

    public void setHremark2(String hremark2) {
        this.hremark2 = hremark2;
    }

    public short getPrtseq() {
        return prtseq;
    }

    public void setPrtseq(short prtseq) {
        this.prtseq = prtseq;
    }

    public Character getIssmode() {
        return issmode;
    }

    public void setIssmode(Character issmode) {
        this.issmode = issmode;
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

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public Character getWktype() {
        return wktype;
    }

    public void setWktype(Character wktype) {
        this.wktype = wktype;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
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

    public Character getAsrsstatus() {
        return asrsstatus;
    }

    public void setAsrsstatus(Character asrsstatus) {
        this.asrsstatus = asrsstatus;
    }

    public Short getSrcseq() {
        return srcseq;
    }

    public void setSrcseq(Short srcseq) {
        this.srcseq = srcseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manpihPK != null ? manpihPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manpih)) {
            return false;
        }
        Manpih other = (Manpih) object;
        if ((this.manpihPK == null && other.manpihPK != null) || (this.manpihPK != null && !this.manpihPK.equals(other.manpihPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Manpih[ manpihPK=" + manpihPK + " ]";
    }
    
}
