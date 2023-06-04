/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "apmaph")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmaph.findAll", query = "SELECT a FROM Apmaph a"),
    @NamedQuery(name = "Apmaph.findByFacno", query = "SELECT a FROM Apmaph a WHERE a.apmaphPK.facno = :facno"),
    @NamedQuery(name = "Apmaph.findByApno", query = "SELECT a FROM Apmaph a WHERE a.apmaphPK.apno = :apno"),
    @NamedQuery(name = "Apmaph.findByAptyp", query = "SELECT a FROM Apmaph a WHERE a.apmaphPK.aptyp = :aptyp"),
    @NamedQuery(name = "Apmaph.findByApsta", query = "SELECT a FROM Apmaph a WHERE a.apsta = :apsta"),
    @NamedQuery(name = "Apmaph.findByDepno", query = "SELECT a FROM Apmaph a WHERE a.depno = :depno"),
    @NamedQuery(name = "Apmaph.findByApusrno", query = "SELECT a FROM Apmaph a WHERE a.apusrno = :apusrno"),
    @NamedQuery(name = "Apmaph.findByApdate", query = "SELECT a FROM Apmaph a WHERE a.apdate = :apdate"),
    @NamedQuery(name = "Apmaph.findByVdrno", query = "SELECT a FROM Apmaph a WHERE a.vdrno = :vdrno"),
    @NamedQuery(name = "Apmaph.findByVdrna", query = "SELECT a FROM Apmaph a WHERE a.vdrna = :vdrna"),
    @NamedQuery(name = "Apmaph.findByPaytn", query = "SELECT a FROM Apmaph a WHERE a.paytn = :paytn"),
    @NamedQuery(name = "Apmaph.findByPayda", query = "SELECT a FROM Apmaph a WHERE a.payda = :payda"),
    @NamedQuery(name = "Apmaph.findByTerda", query = "SELECT a FROM Apmaph a WHERE a.terda = :terda"),
    @NamedQuery(name = "Apmaph.findByIndate", query = "SELECT a FROM Apmaph a WHERE a.indate = :indate"),
    @NamedQuery(name = "Apmaph.findByUserno", query = "SELECT a FROM Apmaph a WHERE a.userno = :userno"),
    @NamedQuery(name = "Apmaph.findByCfmdate", query = "SELECT a FROM Apmaph a WHERE a.cfmdate = :cfmdate"),
    @NamedQuery(name = "Apmaph.findByCfmusrno", query = "SELECT a FROM Apmaph a WHERE a.cfmusrno = :cfmusrno"),
    @NamedQuery(name = "Apmaph.findByPK",
            query = "SELECT a FROM Apmaph a WHERE a.apmaphPK.facno = :facno AND a.apmaphPK.apno = :apno AND a.apmaphPK.aptyp = :aptyp"),
    @NamedQuery(name = "Apmaph.findNeedThrow",
            query = "SELECT a FROM Apmaph a WHERE a.apsta = '20' and a.pzsta = 'Y' and (a.oano is null or a.oano = '') and a.apmaphPK.aptyp = :aptyp ORDER BY a.apmaphPK.facno ,a.apmaphPK.apno,a.apmaphPK.aptyp")})
public class Apmaph implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmaphPK apmaphPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "apsta")
    private String apsta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "apusrno")
    private String apusrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 60)
    @Column(name = "vdrna")
    private String vdrna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "paytn")
    private String paytn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payda;
    @Column(name = "terda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 8)
    @Column(name = "cfmusrno")
    private String cfmusrno;
    @Size(max = 40)
    @Column(name = "hmark")
    private String hmark;
    @Size(max = 22)
    @Column(name = "refno")
    private String refno;
    @Size(max = 1)
    @Column(name = "pyhyn")
    private String pyhyn;
    @Size(max = 20)
    @Column(name = "oano")
    private String oano;
    @Column(name = "pzsta")
    private Character pzsta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apmaph")
    private List<Apmapd> apmapdList;

    public Apmaph() {
    }

    public Apmaph(ApmaphPK apmaphPK) {
        this.apmaphPK = apmaphPK;
    }

    public Apmaph(ApmaphPK apmaphPK, String apsta, String depno, String apusrno, Date apdate, String vdrno, String paytn, Date payda, Date indate, String userno) {
        this.apmaphPK = apmaphPK;
        this.apsta = apsta;
        this.depno = depno;
        this.apusrno = apusrno;
        this.apdate = apdate;
        this.vdrno = vdrno;
        this.paytn = paytn;
        this.payda = payda;
        this.indate = indate;
        this.userno = userno;
    }

    public Apmaph(String facno, String apno, String aptyp) {
        this.apmaphPK = new ApmaphPK(facno, apno, aptyp);
    }

    public ApmaphPK getApmaphPK() {
        return apmaphPK;
    }

    public void setApmaphPK(ApmaphPK apmaphPK) {
        this.apmaphPK = apmaphPK;
    }

    public String getApsta() {
        return apsta;
    }

    public void setApsta(String apsta) {
        this.apsta = apsta;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getApusrno() {
        return apusrno;
    }

    public void setApusrno(String apusrno) {
        this.apusrno = apusrno;
    }

    public Date getApdate() {
        return apdate;
    }

    public void setApdate(Date apdate) {
        this.apdate = apdate;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getPaytn() {
        return paytn;
    }

    public void setPaytn(String paytn) {
        this.paytn = paytn;
    }

    public Date getPayda() {
        return payda;
    }

    public void setPayda(Date payda) {
        this.payda = payda;
    }

    public Date getTerda() {
        return terda;
    }

    public void setTerda(Date terda) {
        this.terda = terda;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
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

    public String getCfmusrno() {
        return cfmusrno;
    }

    public void setCfmusrno(String cfmusrno) {
        this.cfmusrno = cfmusrno;
    }

    public String getHmark() {
        return hmark;
    }

    public void setHmark(String hmark) {
        this.hmark = hmark;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getPyhyn() {
        return pyhyn;
    }

    public void setPyhyn(String pyhyn) {
        this.pyhyn = pyhyn;
    }

    @XmlTransient
    public List<Apmapd> getApmapdList() {
        return apmapdList;
    }

    public void setApmapdList(List<Apmapd> apmapdList) {
        this.apmapdList = apmapdList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmaphPK != null ? apmaphPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmaph)) {
            return false;
        }
        Apmaph other = (Apmaph) object;
        if ((this.apmaphPK == null && other.apmaphPK != null) || (this.apmaphPK != null && !this.apmaphPK.equals(other.apmaphPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.Apmaph[ apmaphPK=" + apmaphPK + " ]";
    }

    public String getOano() {
        return oano;
    }

    public void setOano(String oano) {
        this.oano = oano;
    }

    public Character getPzsta() {
        return pzsta;
    }

    public void setPzsta(Character pzsta) {
        this.pzsta = pzsta;
    }

}
