/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "accacr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accacr.findAll", query = "SELECT a FROM Accacr a"),
    @NamedQuery(name = "Accacr.findByFacno", query = "SELECT a FROM Accacr a WHERE a.accacrPK.facno = :facno"),
    @NamedQuery(name = "Accacr.findBySysno", query = "SELECT a FROM Accacr a WHERE a.accacrPK.sysno = :sysno"),
    @NamedQuery(name = "Accacr.findByKind", query = "SELECT a FROM Accacr a WHERE a.accacrPK.kind = :kind"),
    @NamedQuery(name = "Accacr.findByRkd", query = "SELECT a FROM Accacr a WHERE a.accacrPK.rkd = :rkd"),
    @NamedQuery(name = "Accacr.findByAccseq", query = "SELECT a FROM Accacr a WHERE a.accacrPK.accseq = :accseq"),
    @NamedQuery(name = "Accacr.findByAccno", query = "SELECT a FROM Accacr a WHERE a.accno = :accno"),
    @NamedQuery(name = "Accacr.findByDcratr", query = "SELECT a FROM Accacr a WHERE a.dcratr = :dcratr"),
    @NamedQuery(name = "Accacr.findByDetno1", query = "SELECT a FROM Accacr a WHERE a.detno1 = :detno1"),
    @NamedQuery(name = "Accacr.findByDetno2", query = "SELECT a FROM Accacr a WHERE a.detno2 = :detno2"),
    @NamedQuery(name = "Accacr.findByDetno3", query = "SELECT a FROM Accacr a WHERE a.detno3 = :detno3"),
    @NamedQuery(name = "Accacr.findByDetno4", query = "SELECT a FROM Accacr a WHERE a.detno4 = :detno4"),
    @NamedQuery(name = "Accacr.findByDetno5", query = "SELECT a FROM Accacr a WHERE a.detno5 = :detno5"),
    @NamedQuery(name = "Accacr.findByDetno6", query = "SELECT a FROM Accacr a WHERE a.detno6 = :detno6"),
    @NamedQuery(name = "Accacr.findBySumry1", query = "SELECT a FROM Accacr a WHERE a.sumry1 = :sumry1"),
    @NamedQuery(name = "Accacr.findBySumry2", query = "SELECT a FROM Accacr a WHERE a.sumry2 = :sumry2"),
    @NamedQuery(name = "Accacr.findBySumry3", query = "SELECT a FROM Accacr a WHERE a.sumry3 = :sumry3"),
    @NamedQuery(name = "Accacr.findBySumry4", query = "SELECT a FROM Accacr a WHERE a.sumry4 = :sumry4"),
    @NamedQuery(name = "Accacr.findBySumry5", query = "SELECT a FROM Accacr a WHERE a.sumry5 = :sumry5"),
    @NamedQuery(name = "Accacr.findBySumln1", query = "SELECT a FROM Accacr a WHERE a.sumln1 = :sumln1"),
    @NamedQuery(name = "Accacr.findBySumln2", query = "SELECT a FROM Accacr a WHERE a.sumln2 = :sumln2"),
    @NamedQuery(name = "Accacr.findBySumln3", query = "SELECT a FROM Accacr a WHERE a.sumln3 = :sumln3"),
    @NamedQuery(name = "Accacr.findBySumln4", query = "SELECT a FROM Accacr a WHERE a.sumln4 = :sumln4"),
    @NamedQuery(name = "Accacr.findBySumln5", query = "SELECT a FROM Accacr a WHERE a.sumln5 = :sumln5"),
    @NamedQuery(name = "Accacr.findByAmtcol", query = "SELECT a FROM Accacr a WHERE a.amtcol = :amtcol"),
    @NamedQuery(name = "Accacr.findByAmtscol", query = "SELECT a FROM Accacr a WHERE a.amtscol = :amtscol"),
    @NamedQuery(name = "Accacr.findByCoincol", query = "SELECT a FROM Accacr a WHERE a.coincol = :coincol"),
    @NamedQuery(name = "Accacr.findByRatecol", query = "SELECT a FROM Accacr a WHERE a.ratecol = :ratecol"),
    @NamedQuery(name = "Accacr.findByTrntype", query = "SELECT a FROM Accacr a WHERE a.trntype = :trntype"),
    @NamedQuery(name = "Accacr.findByConfig", query = "SELECT a FROM Accacr a WHERE a.config = :config"),
    @NamedQuery(name = "Accacr.findByTrndesc", query = "SELECT a FROM Accacr a WHERE a.trndesc = :trndesc"),
    @NamedQuery(name = "Accacr.findBySysnoAndKindAndRkd", query = "SELECT a FROM Accacr a WHERE a.accacrPK.sysno = :sysno AND a.accacrPK.kind = :kind AND a.accacrPK.rkd = :rkd "),
    @NamedQuery(name = "Accacr.findByPK", query = "SELECT a FROM Accacr a WHERE a.accacrPK.facno = :facno AND a.accacrPK.sysno = :sysno AND a.accacrPK.kind = :kind AND a.accacrPK.rkd = :rkd AND a.accno = :accno AND a.dcratr = :dcratr ")})
public class Accacr implements Serializable {

    @EmbeddedId
    protected AccacrPK accacrPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "accno")
    private String accno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dcratr")
    private Character dcratr;
    @Size(max = 8)
    @Column(name = "detno1")
    private String detno1;
    @Size(max = 8)
    @Column(name = "detno2")
    private String detno2;
    @Size(max = 8)
    @Column(name = "detno3")
    private String detno3;
    @Size(max = 8)
    @Column(name = "detno4")
    private String detno4;
    @Size(max = 8)
    @Column(name = "detno5")
    private String detno5;
    @Size(max = 8)
    @Column(name = "detno6")
    private String detno6;
    @Size(max = 8)
    @Column(name = "sumry1")
    private String sumry1;
    @Size(max = 8)
    @Column(name = "sumry2")
    private String sumry2;
    @Size(max = 8)
    @Column(name = "sumry3")
    private String sumry3;
    @Size(max = 8)
    @Column(name = "sumry4")
    private String sumry4;
    @Size(max = 8)
    @Column(name = "sumry5")
    private String sumry5;
    @Column(name = "sumln1")
    private Short sumln1;
    @Column(name = "sumln2")
    private Short sumln2;
    @Column(name = "sumln3")
    private Short sumln3;
    @Column(name = "sumln4")
    private Short sumln4;
    @Column(name = "sumln5")
    private Short sumln5;
    @Size(max = 8)
    @Column(name = "amtcol")
    private String amtcol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "amtscol")
    private String amtscol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "coincol")
    private String coincol;
    @Size(max = 8)
    @Column(name = "ratecol")
    private String ratecol;
    @Size(max = 2)
    @Column(name = "trntype")
    private String trntype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "config")
    private short config;
    @Size(max = 20)
    @Column(name = "trndesc")
    private String trndesc;

    public Accacr() {
    }

    public Accacr(AccacrPK accacrPK) {
        this.accacrPK = accacrPK;
    }

    public Accacr(AccacrPK accacrPK, String accno, Character dcratr, String amtscol, String coincol, short config) {
        this.accacrPK = accacrPK;
        this.accno = accno;
        this.dcratr = dcratr;
        this.amtscol = amtscol;
        this.coincol = coincol;
        this.config = config;
    }

    public Accacr(String facno, String sysno, String kind, String rkd, short accseq) {
        this.accacrPK = new AccacrPK(facno, sysno, kind, rkd, accseq);
    }

    public AccacrPK getAccacrPK() {
        return accacrPK;
    }

    public void setAccacrPK(AccacrPK accacrPK) {
        this.accacrPK = accacrPK;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public Character getDcratr() {
        return dcratr;
    }

    public void setDcratr(Character dcratr) {
        this.dcratr = dcratr;
    }

    public String getDetno1() {
        return detno1;
    }

    public void setDetno1(String detno1) {
        this.detno1 = detno1;
    }

    public String getDetno2() {
        return detno2;
    }

    public void setDetno2(String detno2) {
        this.detno2 = detno2;
    }

    public String getDetno3() {
        return detno3;
    }

    public void setDetno3(String detno3) {
        this.detno3 = detno3;
    }

    public String getDetno4() {
        return detno4;
    }

    public void setDetno4(String detno4) {
        this.detno4 = detno4;
    }

    public String getDetno5() {
        return detno5;
    }

    public void setDetno5(String detno5) {
        this.detno5 = detno5;
    }

    public String getDetno6() {
        return detno6;
    }

    public void setDetno6(String detno6) {
        this.detno6 = detno6;
    }

    public String getSumry1() {
        return sumry1;
    }

    public void setSumry1(String sumry1) {
        this.sumry1 = sumry1;
    }

    public String getSumry2() {
        return sumry2;
    }

    public void setSumry2(String sumry2) {
        this.sumry2 = sumry2;
    }

    public String getSumry3() {
        return sumry3;
    }

    public void setSumry3(String sumry3) {
        this.sumry3 = sumry3;
    }

    public String getSumry4() {
        return sumry4;
    }

    public void setSumry4(String sumry4) {
        this.sumry4 = sumry4;
    }

    public String getSumry5() {
        return sumry5;
    }

    public void setSumry5(String sumry5) {
        this.sumry5 = sumry5;
    }

    public Short getSumln1() {
        return sumln1;
    }

    public void setSumln1(Short sumln1) {
        this.sumln1 = sumln1;
    }

    public Short getSumln2() {
        return sumln2;
    }

    public void setSumln2(Short sumln2) {
        this.sumln2 = sumln2;
    }

    public Short getSumln3() {
        return sumln3;
    }

    public void setSumln3(Short sumln3) {
        this.sumln3 = sumln3;
    }

    public Short getSumln4() {
        return sumln4;
    }

    public void setSumln4(Short sumln4) {
        this.sumln4 = sumln4;
    }

    public Short getSumln5() {
        return sumln5;
    }

    public void setSumln5(Short sumln5) {
        this.sumln5 = sumln5;
    }

    public String getAmtcol() {
        return amtcol;
    }

    public void setAmtcol(String amtcol) {
        this.amtcol = amtcol;
    }

    public String getAmtscol() {
        return amtscol;
    }

    public void setAmtscol(String amtscol) {
        this.amtscol = amtscol;
    }

    public String getCoincol() {
        return coincol;
    }

    public void setCoincol(String coincol) {
        this.coincol = coincol;
    }

    public String getRatecol() {
        return ratecol;
    }

    public void setRatecol(String ratecol) {
        this.ratecol = ratecol;
    }

    public String getTrntype() {
        return trntype;
    }

    public void setTrntype(String trntype) {
        this.trntype = trntype;
    }

    public short getConfig() {
        return config;
    }

    public void setConfig(short config) {
        this.config = config;
    }

    public String getTrndesc() {
        return trndesc;
    }

    public void setTrndesc(String trndesc) {
        this.trndesc = trndesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accacrPK != null ? accacrPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accacr)) {
            return false;
        }
        Accacr other = (Accacr) object;
        if ((this.accacrPK == null && other.accacrPK != null) || (this.accacrPK != null && !this.accacrPK.equals(other.accacrPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Accacr[ accacrPK=" + accacrPK + " ]";
    }

}
