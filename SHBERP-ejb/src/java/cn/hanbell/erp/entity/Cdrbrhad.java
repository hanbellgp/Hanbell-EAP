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
@Table(name = "cdrbrhad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrbrhad.findAll", query = "SELECT c FROM Cdrbrhad c"),
    @NamedQuery(name = "Cdrbrhad.findByFacno", query = "SELECT c FROM Cdrbrhad c WHERE c.cdrbrhadPK.facno = :facno"),
    @NamedQuery(name = "Cdrbrhad.findByBrtrno", query = "SELECT c FROM Cdrbrhad c WHERE c.cdrbrhadPK.brtrno = :brtrno"),
    @NamedQuery(name = "Cdrbrhad.findByCdrobtype", query = "SELECT c FROM Cdrbrhad c WHERE c.cdrobtype = :cdrobtype"),
    @NamedQuery(name = "Cdrbrhad.findByPK", query = "SELECT c FROM Cdrbrhad c WHERE c.cdrbrhadPK.facno = :facno AND c.cdrbrhadPK.brtrno = :brtrno ")})
public class Cdrbrhad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrbrhadPK cdrbrhadPK;
    @Size(max = 3)
    @Column(name = "cdrobtype")
    private String cdrobtype;
    @Size(max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Column(name = "brdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date brdate;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Column(name = "status")
    private Character status;
    @Column(name = "prtcnt")
    private Short prtcnt;
    @Size(max = 12)
    @Column(name = "lnwareh")
    private String lnwareh;
    @Column(name = "saleyn")
    private Character saleyn;
    @Size(max = 18)
    @Column(name = "shpno")
    private String shpno;
    @Size(max = 3)
    @Column(name = "prono")
    private String prono;
    @Size(max = 60)
    @Column(name = "hmark01")
    private String hmark01;
    @Size(max = 60)
    @Column(name = "hmark02")
    private String hmark02;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "objtype")
    private String objtype;
    @Size(max = 20)
    @Column(name = "hmark03")
    private String hmark03;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdrbrhad")
    private List<Cdrbrdta> cdrbrdtaList;

    public Cdrbrhad() {
    }

    public Cdrbrhad(CdrbrhadPK cdrbrhadPK) {
        this.cdrbrhadPK = cdrbrhadPK;
    }

    public Cdrbrhad(CdrbrhadPK cdrbrhadPK, String objtype) {
        this.cdrbrhadPK = cdrbrhadPK;
        this.objtype = objtype;
    }

    public Cdrbrhad(String facno, String brtrno) {
        this.cdrbrhadPK = new CdrbrhadPK(facno, brtrno);
    }

    public CdrbrhadPK getCdrbrhadPK() {
        return cdrbrhadPK;
    }

    public void setCdrbrhadPK(CdrbrhadPK cdrbrhadPK) {
        this.cdrbrhadPK = cdrbrhadPK;
    }

    public String getCdrobtype() {
        return cdrobtype;
    }

    public void setCdrobtype(String cdrobtype) {
        this.cdrobtype = cdrobtype;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public Date getBrdate() {
        return brdate;
    }

    public void setBrdate(Date brdate) {
        this.brdate = brdate;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
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

    public Short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(Short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public String getLnwareh() {
        return lnwareh;
    }

    public void setLnwareh(String lnwareh) {
        this.lnwareh = lnwareh;
    }

    public Character getSaleyn() {
        return saleyn;
    }

    public void setSaleyn(Character saleyn) {
        this.saleyn = saleyn;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getHmark01() {
        return hmark01;
    }

    public void setHmark01(String hmark01) {
        this.hmark01 = hmark01;
    }

    public String getHmark02() {
        return hmark02;
    }

    public void setHmark02(String hmark02) {
        this.hmark02 = hmark02;
    }

    public String getObjtype() {
        return objtype;
    }

    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    public String getHmark03() {
        return hmark03;
    }

    public void setHmark03(String hmark03) {
        this.hmark03 = hmark03;
    }

    @XmlTransient
    public List<Cdrbrdta> getCdrbrdtaList() {
        return cdrbrdtaList;
    }

    public void setCdrbrdtaList(List<Cdrbrdta> cdrbrdtaList) {
        this.cdrbrdtaList = cdrbrdtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrbrhadPK != null ? cdrbrhadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrbrhad)) {
            return false;
        }
        Cdrbrhad other = (Cdrbrhad) object;
        if ((this.cdrbrhadPK == null && other.cdrbrhadPK != null) || (this.cdrbrhadPK != null && !this.cdrbrhadPK.equals(other.cdrbrhadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrbrhad[ cdrbrhadPK=" + cdrbrhadPK + " ]";
    }

}
