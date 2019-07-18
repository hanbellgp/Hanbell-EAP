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
 * @author C1368
 */
@Entity
@Table(name = "HK_CW002_P_purDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW002PpurDetail.findAll", query = "SELECT h FROM HKCW002PpurDetail h"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySubyearbal", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.subyearbal = :subyearbal"),
    @NamedQuery(name = "HKCW002PpurDetail.findByOid", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW002PpurDetail.findByMidclasscodeTxt", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.midclasscodeTxt = :midclasscodeTxt"),
    @NamedQuery(name = "HKCW002PpurDetail.findByBudgetaccname", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.budgetaccname = :budgetaccname"),
    @NamedQuery(name = "HKCW002PpurDetail.findByAddcode", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.addcode = :addcode"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySmallclasscodeTxt", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.smallclasscodeTxt = :smallclasscodeTxt"),
    @NamedQuery(name = "HKCW002PpurDetail.findByBigclasscodeTxt", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.bigclasscodeTxt = :bigclasscodeTxt"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySubperbal", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.subperbal = :subperbal"),
    @NamedQuery(name = "HKCW002PpurDetail.findByBudgetacc", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.budgetacc = :budgetacc"),
    @NamedQuery(name = "HKCW002PpurDetail.findByDmark1", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.dmark1 = :dmark1"),
    @NamedQuery(name = "HKCW002PpurDetail.findByDmark2", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.dmark2 = :dmark2"),
    @NamedQuery(name = "HKCW002PpurDetail.findByQgnum", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.qgnum = :qgnum"),
    @NamedQuery(name = "HKCW002PpurDetail.findByMidclasscode", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.midclasscode = :midclasscode"),
    @NamedQuery(name = "HKCW002PpurDetail.findByDmark1name", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.dmark1name = :dmark1name"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySpdse", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.spdse = :spdse"),
    @NamedQuery(name = "HKCW002PpurDetail.findByApamts", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.apamts = :apamts"),
    @NamedQuery(name = "HKCW002PpurDetail.findByAdscodeTxt", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.adscodeTxt = :adscodeTxt"),
    @NamedQuery(name = "HKCW002PpurDetail.findByApplyunit", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.applyunit = :applyunit"),
    @NamedQuery(name = "HKCW002PpurDetail.findByAdscode", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.adscode = :adscode"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySmallclasscode", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.smallclasscode = :smallclasscode"),
    @NamedQuery(name = "HKCW002PpurDetail.findByPremoney", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.premoney = :premoney"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySfjj", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.sfjj = :sfjj"),
    @NamedQuery(name = "HKCW002PpurDetail.findBySeq", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCW002PpurDetail.findByDmark2name", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.dmark2name = :dmark2name"),
    @NamedQuery(name = "HKCW002PpurDetail.findByLynum", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.lynum = :lynum"),
    @NamedQuery(name = "HKCW002PpurDetail.findByPncode", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.pncode = :pncode"),
    @NamedQuery(name = "HKCW002PpurDetail.findByBigclasscode", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.bigclasscode = :bigclasscode"),
    @NamedQuery(name = "HKCW002PpurDetail.findByFSN", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW002PpurDetail.findByDatetime1Txt", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.datetime1Txt = :datetime1Txt"),
    @NamedQuery(name = "HKCW002PpurDetail.findByApplynum", query = "SELECT h FROM HKCW002PpurDetail h WHERE h.applynum = :applynum")})
public class HKCW002PpurDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "subyearbal")
    private String subyearbal;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "midclasscode_txt")
    private String midclasscodeTxt;
    @Size(max = 255)
    @Column(name = "budgetaccname")
    private String budgetaccname;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "smallclasscode_txt")
    private String smallclasscodeTxt;
    @Size(max = 255)
    @Column(name = "bigclasscode_txt")
    private String bigclasscodeTxt;
    @Size(max = 255)
    @Column(name = "subperbal")
    private String subperbal;
    @Size(max = 255)
    @Column(name = "budgetacc")
    private String budgetacc;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "qgnum")
    private String qgnum;
    @Size(max = 255)
    @Column(name = "midclasscode")
    private String midclasscode;
    @Size(max = 255)
    @Column(name = "dmark1name")
    private String dmark1name;
    @Size(max = 255)
    @Column(name = "spdse")
    private String spdse;
    @Size(max = 255)
    @Column(name = "apamts")
    private String apamts;
    @Size(max = 255)
    @Column(name = "adscode_txt")
    private String adscodeTxt;
    @Size(max = 255)
    @Column(name = "applyunit")
    private String applyunit;
    @Size(max = 255)
    @Column(name = "adscode")
    private String adscode;
    @Size(max = 255)
    @Column(name = "smallclasscode")
    private String smallclasscode;
    @Size(max = 255)
    @Column(name = "premoney")
    private String premoney;
    @Size(max = 255)
    @Column(name = "sfjj")
    private String sfjj;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "dmark2name")
    private String dmark2name;
    @Size(max = 255)
    @Column(name = "lynum")
    private String lynum;
    @Size(max = 255)
    @Column(name = "pncode")
    private String pncode;
    @Size(max = 255)
    @Column(name = "bigclasscode")
    private String bigclasscode;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "datetime1_txt")
    private String datetime1Txt;
    @Size(max = 255)
    @Column(name = "applynum")
    private String applynum;
    @Size(max = 255)
    @Column(name = "pnname")
    private String pnname;
    

    public HKCW002PpurDetail() {
    }

    public HKCW002PpurDetail(String oid) {
        this.oid = oid;
    }

    public String getSubyearbal() {
        return subyearbal;
    }

    public void setSubyearbal(String subyearbal) {
        this.subyearbal = subyearbal;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMidclasscodeTxt() {
        return midclasscodeTxt;
    }

    public void setMidclasscodeTxt(String midclasscodeTxt) {
        this.midclasscodeTxt = midclasscodeTxt;
    }

    public String getBudgetaccname() {
        return budgetaccname;
    }

    public void setBudgetaccname(String budgetaccname) {
        this.budgetaccname = budgetaccname;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public String getSmallclasscodeTxt() {
        return smallclasscodeTxt;
    }

    public void setSmallclasscodeTxt(String smallclasscodeTxt) {
        this.smallclasscodeTxt = smallclasscodeTxt;
    }

    public String getBigclasscodeTxt() {
        return bigclasscodeTxt;
    }

    public void setBigclasscodeTxt(String bigclasscodeTxt) {
        this.bigclasscodeTxt = bigclasscodeTxt;
    }

    public String getSubperbal() {
        return subperbal;
    }

    public void setSubperbal(String subperbal) {
        this.subperbal = subperbal;
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
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

    public String getQgnum() {
        return qgnum;
    }

    public void setQgnum(String qgnum) {
        this.qgnum = qgnum;
    }

    public String getMidclasscode() {
        return midclasscode;
    }

    public void setMidclasscode(String midclasscode) {
        this.midclasscode = midclasscode;
    }

    public String getDmark1name() {
        return dmark1name;
    }

    public void setDmark1name(String dmark1name) {
        this.dmark1name = dmark1name;
    }

    public String getSpdse() {
        return spdse;
    }

    public void setSpdse(String spdse) {
        this.spdse = spdse;
    }

    public String getApamts() {
        return apamts;
    }

    public void setApamts(String apamts) {
        this.apamts = apamts;
    }

    public String getAdscodeTxt() {
        return adscodeTxt;
    }

    public void setAdscodeTxt(String adscodeTxt) {
        this.adscodeTxt = adscodeTxt;
    }

    public String getApplyunit() {
        return applyunit;
    }

    public void setApplyunit(String applyunit) {
        this.applyunit = applyunit;
    }

    public String getAdscode() {
        return adscode;
    }

    public void setAdscode(String adscode) {
        this.adscode = adscode;
    }

    public String getSmallclasscode() {
        return smallclasscode;
    }

    public void setSmallclasscode(String smallclasscode) {
        this.smallclasscode = smallclasscode;
    }

    public String getPremoney() {
        return premoney;
    }

    public void setPremoney(String premoney) {
        this.premoney = premoney;
    }

    public String getSfjj() {
        return sfjj;
    }

    public void setSfjj(String sfjj) {
        this.sfjj = sfjj;
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

    public String getLynum() {
        return lynum;
    }

    public void setLynum(String lynum) {
        this.lynum = lynum;
    }

    public String getPncode() {
        return pncode;
    }

    public void setPncode(String pncode) {
        this.pncode = pncode;
    }

    public String getBigclasscode() {
        return bigclasscode;
    }

    public void setBigclasscode(String bigclasscode) {
        this.bigclasscode = bigclasscode;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getDatetime1Txt() {
        return datetime1Txt;
    }

    public void setDatetime1Txt(String datetime1Txt) {
        this.datetime1Txt = datetime1Txt;
    }

    public String getApplynum() {
        return applynum;
    }

    public void setApplynum(String applynum) {
        this.applynum = applynum;
    }

    public String getPnname() {
        return pnname;
    }

    public void setPnname(String pnname) {
        this.pnname = pnname;
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
        if (!(object instanceof HKCW002PpurDetail)) {
            return false;
        }
        HKCW002PpurDetail other = (HKCW002PpurDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW002PpurDetail[ oid=" + oid + " ]";
    }
    
}
