/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
@Table(name = "VH_TM001_purDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTM001purDetail.findAll", query = "SELECT v FROM VHTM001purDetail v"),
    @NamedQuery(name = "VHTM001purDetail.findByOid", query = "SELECT v FROM VHTM001purDetail v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHTM001purDetail.findByFSN", query = "SELECT v FROM VHTM001purDetail v WHERE v.formSerialNumber = :fsn")})
public class VHTM001purDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "rqtdate_txt")
    private String rqtdateTxt;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "ctaxamts")
    private String ctaxamts;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "appunit")
    private String appunit;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "taxrate")
    private String taxrate;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "accPeriod")
    private String accPeriod;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "accYear")
    private String accYear;
    @Size(max = 255)
    @Column(name = "emgyn")
    private String emgyn;
    @Size(max = 255)
    @Column(name = "dmark1name")
    private String dmark1name;
    @Size(max = 255)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 255)
    @Column(name = "askdate_txt")
    private String askdateTxt;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "apamts")
    private String apamts;
    @Size(max = 255)
    @Column(name = "buyername")
    private String buyername;
    @Size(max = 255)
    @Column(name = "ctramts")
    private String ctramts;
    @Size(max = 255)
    @Column(name = "ctotamts")
    private String ctotamts;
    @Size(max = 255)
    @Column(name = "posrccode")
    private String posrccode;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "prqy1")
    private String prqy1;
    @Size(max = 255)
    @Column(name = "tax")
    private String tax;
    @Size(max = 255)
    @Column(name = "unpris")
    private String unpris;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "dmark2name")
    private String dmark2name;
    @Size(max = 255)
    @Column(name = "purdaskdescs")
    private String purdaskdescs;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 255)
    @Column(name = "qtotamts")
    private String qtotamts;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public VHTM001purDetail() {
    }

    public VHTM001purDetail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRqtdateTxt() {
        return rqtdateTxt;
    }

    public void setRqtdateTxt(String rqtdateTxt) {
        this.rqtdateTxt = rqtdateTxt;
    }

    public String getBudgetaccname() {
        return budgetaccname;
    }

    public void setBudgetaccname(String budgetaccname) {
        this.budgetaccname = budgetaccname;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getCtaxamts() {
        return ctaxamts;
    }

    public void setCtaxamts(String ctaxamts) {
        this.ctaxamts = ctaxamts;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public String getAppunit() {
        return appunit;
    }

    public void setAppunit(String appunit) {
        this.appunit = appunit;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(String accPeriod) {
        this.accPeriod = accPeriod;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getAccYear() {
        return accYear;
    }

    public void setAccYear(String accYear) {
        this.accYear = accYear;
    }

    public String getEmgyn() {
        return emgyn;
    }

    public void setEmgyn(String emgyn) {
        this.emgyn = emgyn;
    }

    public String getDmark1name() {
        return dmark1name;
    }

    public void setDmark1name(String dmark1name) {
        this.dmark1name = dmark1name;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAskdateTxt() {
        return askdateTxt;
    }

    public void setAskdateTxt(String askdateTxt) {
        this.askdateTxt = askdateTxt;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getApamts() {
        return apamts;
    }

    public void setApamts(String apamts) {
        this.apamts = apamts;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getCtramts() {
        return ctramts;
    }

    public void setCtramts(String ctramts) {
        this.ctramts = ctramts;
    }

    public String getCtotamts() {
        return ctotamts;
    }

    public void setCtotamts(String ctotamts) {
        this.ctotamts = ctotamts;
    }

    public String getPosrccode() {
        return posrccode;
    }

    public void setPosrccode(String posrccode) {
        this.posrccode = posrccode;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getPrqy1() {
        return prqy1;
    }

    public void setPrqy1(String prqy1) {
        this.prqy1 = prqy1;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getUnpris() {
        return unpris;
    }

    public void setUnpris(String unpris) {
        this.unpris = unpris;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getDmark2name() {
        return dmark2name;
    }

    public void setDmark2name(String dmark2name) {
        this.dmark2name = dmark2name;
    }

    public String getPurdaskdescs() {
        return purdaskdescs;
    }

    public void setPurdaskdescs(String purdaskdescs) {
        this.purdaskdescs = purdaskdescs;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getQtotamts() {
        return qtotamts;
    }

    public void setQtotamts(String qtotamts) {
        this.qtotamts = qtotamts;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VHTM001purDetail)) {
            return false;
        }
        VHTM001purDetail other = (VHTM001purDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTM001purDetail[ oid=" + oid + " ]";
    }

}
