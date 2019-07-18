/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "scminvmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scminvmas.findAll", query = "SELECT s FROM Scminvmas s"),
    @NamedQuery(name = "Scminvmas.findByItnbr", query = "SELECT s FROM Scminvmas s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "Scminvmas.findByItdsc", query = "SELECT s FROM Scminvmas s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "Scminvmas.findByProducttype", query = "SELECT s FROM Scminvmas s WHERE s.producttype = :producttype"),
    @NamedQuery(name = "Scminvmas.findByLevel1", query = "SELECT s FROM Scminvmas s WHERE s.level1 = :level1"),
    @NamedQuery(name = "Scminvmas.findByLevel2", query = "SELECT s FROM Scminvmas s WHERE s.level2 = :level2"),
    @NamedQuery(name = "Scminvmas.findByTracetype", query = "SELECT s FROM Scminvmas s WHERE s.tracetype = :tracetype"),
    @NamedQuery(name = "Scminvmas.findByLotid", query = "SELECT s FROM Scminvmas s WHERE s.lotid = :lotid"),
    @NamedQuery(name = "Scminvmas.findByCompid", query = "SELECT s FROM Scminvmas s WHERE s.compid = :compid"),
    @NamedQuery(name = "Scminvmas.findByLno", query = "SELECT s FROM Scminvmas s WHERE s.lno = :lno"),
    @NamedQuery(name = "Scminvmas.findByWno", query = "SELECT s FROM Scminvmas s WHERE s.wno = :wno"),
    @NamedQuery(name = "Scminvmas.findByGetseq", query = "SELECT s FROM Scminvmas s WHERE s.getseq = :getseq"),
    @NamedQuery(name = "Scminvmas.findByPrinttype", query = "SELECT s FROM Scminvmas s WHERE s.printtype = :printtype"),
    @NamedQuery(name = "Scminvmas.findByQcdata", query = "SELECT s FROM Scminvmas s WHERE s.qcdata = :qcdata"),
    @NamedQuery(name = "Scminvmas.findByQcdatanum", query = "SELECT s FROM Scminvmas s WHERE s.qcdatanum = :qcdatanum"),
    @NamedQuery(name = "Scminvmas.findByAsrstype", query = "SELECT s FROM Scminvmas s WHERE s.asrstype = :asrstype"),
    @NamedQuery(name = "Scminvmas.findBySelfprint", query = "SELECT s FROM Scminvmas s WHERE s.selfprint = :selfprint"),
    @NamedQuery(name = "Scminvmas.findByModifytime", query = "SELECT s FROM Scminvmas s WHERE s.modifytime = :modifytime"),
    @NamedQuery(name = "Scminvmas.findByTransflag", query = "SELECT s FROM Scminvmas s WHERE s.transflag = :transflag"),
    @NamedQuery(name = "Scminvmas.findByTranstime", query = "SELECT s FROM Scminvmas s WHERE s.transtime = :transtime"),
    @NamedQuery(name = "Scminvmas.findByDeydetyn", query = "SELECT s FROM Scminvmas s WHERE s.deydetyn = :deydetyn")})
public class Scminvmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 50)
    @Column(name = "producttype")
    private String producttype;
    @Size(max = 30)
    @Column(name = "level1")
    private String level1;
    @Size(max = 30)
    @Column(name = "level2")
    private String level2;
    @Size(max = 1)
    @Column(name = "tracetype")
    private String tracetype;
    @Size(max = 1)
    @Column(name = "lotid")
    private String lotid;
    @Size(max = 1)
    @Column(name = "compid")
    private String compid;
    @Size(max = 1)
    @Column(name = "lno")
    private String lno;
    @Size(max = 1)
    @Column(name = "wno")
    private String wno;
    @Size(max = 1)
    @Column(name = "getseq")
    private String getseq;
    @Size(max = 1)
    @Column(name = "printtype")
    private String printtype;
    @Size(max = 5)
    @Column(name = "qcdata")
    private String qcdata;
    @Size(max = 2)
    @Column(name = "qcdatanum")
    private String qcdatanum;
    @Size(max = 1)
    @Column(name = "asrstype")
    private String asrstype;
    @Size(max = 1)
    @Column(name = "selfprint")
    private String selfprint;
    @Size(max = 20)
    @Column(name = "modifytime")
    private String modifytime;
    @Size(max = 1)
    @Column(name = "transflag")
    private String transflag;
    @Size(max = 20)
    @Column(name = "transtime")
    private String transtime;
    @Size(max = 4)
    @Column(name = "deydetyn")
    private String deydetyn;

    public Scminvmas() {
    }

    public Scminvmas(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getTracetype() {
        return tracetype;
    }

    public void setTracetype(String tracetype) {
        this.tracetype = tracetype;
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid;
    }

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public String getLno() {
        return lno;
    }

    public void setLno(String lno) {
        this.lno = lno;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getGetseq() {
        return getseq;
    }

    public void setGetseq(String getseq) {
        this.getseq = getseq;
    }

    public String getPrinttype() {
        return printtype;
    }

    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    public String getQcdata() {
        return qcdata;
    }

    public void setQcdata(String qcdata) {
        this.qcdata = qcdata;
    }

    public String getQcdatanum() {
        return qcdatanum;
    }

    public void setQcdatanum(String qcdatanum) {
        this.qcdatanum = qcdatanum;
    }

    public String getAsrstype() {
        return asrstype;
    }

    public void setAsrstype(String asrstype) {
        this.asrstype = asrstype;
    }

    public String getSelfprint() {
        return selfprint;
    }

    public void setSelfprint(String selfprint) {
        this.selfprint = selfprint;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getTransflag() {
        return transflag;
    }

    public void setTransflag(String transflag) {
        this.transflag = transflag;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = transtime;
    }

    public String getDeydetyn() {
        return deydetyn;
    }

    public void setDeydetyn(String deydetyn) {
        this.deydetyn = deydetyn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scminvmas)) {
            return false;
        }
        Scminvmas other = (Scminvmas) object;
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Scminvmas[ itnbr=" + itnbr + " ]";
    }
    
}
