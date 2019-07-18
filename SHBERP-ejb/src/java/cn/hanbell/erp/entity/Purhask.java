/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
@Table(name = "purhask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purhask.findAll", query = "SELECT p FROM Purhask p"),
    @NamedQuery(name = "Purhask.findByFacno", query = "SELECT p FROM Purhask p WHERE p.purhaskPK.facno = :facno"),
    @NamedQuery(name = "Purhask.findByProno", query = "SELECT p FROM Purhask p WHERE p.purhaskPK.prono = :prono"),
    @NamedQuery(name = "Purhask.findByPrno", query = "SELECT p FROM Purhask p WHERE p.purhaskPK.prno = :prno"),
    @NamedQuery(name = "Purhask.findByPrkind", query = "SELECT p FROM Purhask p WHERE p.prkind = :prkind"),
    @NamedQuery(name = "Purhask.findByMapcdrtype", query = "SELECT p FROM Purhask p WHERE p.mapcdrtype = :mapcdrtype"),
    @NamedQuery(name = "Purhask.findByPrdate", query = "SELECT p FROM Purhask p WHERE p.prdate = :prdate"),
    @NamedQuery(name = "Purhask.findByDepno", query = "SELECT p FROM Purhask p WHERE p.depno = :depno"),
    @NamedQuery(name = "Purhask.findBySrcno", query = "SELECT p FROM Purhask p WHERE p.srcno = :srcno"),
    @NamedQuery(name = "Purhask.findByBudgetcode", query = "SELECT p FROM Purhask p WHERE p.budgetcode = :budgetcode"),
    @NamedQuery(name = "Purhask.findByHmark1", query = "SELECT p FROM Purhask p WHERE p.hmark1 = :hmark1"),
    @NamedQuery(name = "Purhask.findByHmark2", query = "SELECT p FROM Purhask p WHERE p.hmark2 = :hmark2"),
    @NamedQuery(name = "Purhask.findByHasksta", query = "SELECT p FROM Purhask p WHERE p.hasksta = :hasksta"),
    @NamedQuery(name = "Purhask.findByUserno", query = "SELECT p FROM Purhask p WHERE p.userno = :userno"),
    @NamedQuery(name = "Purhask.findByIndate", query = "SELECT p FROM Purhask p WHERE p.indate = :indate"),
    @NamedQuery(name = "Purhask.findByCfmuserno", query = "SELECT p FROM Purhask p WHERE p.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Purhask.findByCfmdate", query = "SELECT p FROM Purhask p WHERE p.cfmdate = :cfmdate"),
    @NamedQuery(name = "Purhask.findByPrtcnt", query = "SELECT p FROM Purhask p WHERE p.prtcnt = :prtcnt"),
    @NamedQuery(name = "Purhask.findByYea", query = "SELECT p FROM Purhask p WHERE p.yea = :yea"),
    @NamedQuery(name = "Purhask.findByApplyno", query = "SELECT p FROM Purhask p WHERE p.applyno = :applyno")})
public class Purhask implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurhaskPK purhaskPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "prkind")
    private String prkind;
    @Column(name = "mapcdrtype")
    private Character mapcdrtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Size(max = 18)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 8)
    @Column(name = "budgetcode")
    private String budgetcode;
    @Size(max = 10)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 10)
    @Column(name = "hmark2")
    private String hmark2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasksta")
    private Character hasksta;
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
    @Column(name = "prtcnt")
    private short prtcnt;
    @Column(name = "yea")
    private Integer yea;
    @Size(max = 2)
    @Column(name = "applyno")
    private String applyno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purhask")
    private List<Purdask> purdaskList;

    public Purhask() {
    }

    public Purhask(PurhaskPK purhaskPK) {
        this.purhaskPK = purhaskPK;
    }

    public Purhask(PurhaskPK purhaskPK, String prkind, Date prdate, String depno, Character hasksta, String userno, Date indate, short prtcnt) {
        this.purhaskPK = purhaskPK;
        this.prkind = prkind;
        this.prdate = prdate;
        this.depno = depno;
        this.hasksta = hasksta;
        this.userno = userno;
        this.indate = indate;
        this.prtcnt = prtcnt;
    }

    public Purhask(String facno, String prono, String prno) {
        this.purhaskPK = new PurhaskPK(facno, prono, prno);
    }

    public PurhaskPK getPurhaskPK() {
        return purhaskPK;
    }

    public void setPurhaskPK(PurhaskPK purhaskPK) {
        this.purhaskPK = purhaskPK;
    }

    public String getPrkind() {
        return prkind;
    }

    public void setPrkind(String prkind) {
        this.prkind = prkind;
    }

    public Character getMapcdrtype() {
        return mapcdrtype;
    }

    public void setMapcdrtype(Character mapcdrtype) {
        this.mapcdrtype = mapcdrtype;
    }

    public Date getPrdate() {
        return prdate;
    }

    public void setPrdate(Date prdate) {
        this.prdate = prdate;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getBudgetcode() {
        return budgetcode;
    }

    public void setBudgetcode(String budgetcode) {
        this.budgetcode = budgetcode;
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

    public Character getHasksta() {
        return hasksta;
    }

    public void setHasksta(Character hasksta) {
        this.hasksta = hasksta;
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

    public short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public Integer getYea() {
        return yea;
    }

    public void setYea(Integer yea) {
        this.yea = yea;
    }

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    @XmlTransient
    public List<Purdask> getPurdaskList() {
        return purdaskList;
    }

    public void setPurdaskList(List<Purdask> purdaskList) {
        this.purdaskList = purdaskList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purhaskPK != null ? purhaskPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purhask)) {
            return false;
        }
        Purhask other = (Purhask) object;
        if ((this.purhaskPK == null && other.purhaskPK != null) || (this.purhaskPK != null && !this.purhaskPK.equals(other.purhaskPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purhask[ purhaskPK=" + purhaskPK + " ]";
    }
    
}
