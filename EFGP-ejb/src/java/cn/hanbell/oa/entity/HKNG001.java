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
@Table(name = "HK_NG001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKNG001.findAll", query = "SELECT h FROM HKNG001 h")
    , @NamedQuery(name = "HKNG001.findByCondition", query = "SELECT h FROM HKNG001 h WHERE h.condition = :condition")
    , @NamedQuery(name = "HKNG001.findByOid", query = "SELECT h FROM HKNG001 h WHERE h.oid = :oid")
    , @NamedQuery(name = "HKNG001.findBySupName", query = "SELECT h FROM HKNG001 h WHERE h.supName = :supName")
    , @NamedQuery(name = "HKNG001.findByFacno", query = "SELECT h FROM HKNG001 h WHERE h.facno = :facno")
    , @NamedQuery(name = "HKNG001.findByCreater", query = "SELECT h FROM HKNG001 h WHERE h.creater = :creater")
    , @NamedQuery(name = "HKNG001.findByCreateDate", query = "SELECT h FROM HKNG001 h WHERE h.createDate = :createDate")
    , @NamedQuery(name = "HKNG001.findByEsdid", query = "SELECT h FROM HKNG001 h WHERE h.esdid = :esdid")
    , @NamedQuery(name = "HKNG001.findByTaxrate", query = "SELECT h FROM HKNG001 h WHERE h.taxrate = :taxrate")
    , @NamedQuery(name = "HKNG001.findByTag", query = "SELECT h FROM HKNG001 h WHERE h.tag = :tag")
    , @NamedQuery(name = "HKNG001.findByEName", query = "SELECT h FROM HKNG001 h WHERE h.eName = :eName")
    , @NamedQuery(name = "HKNG001.findByPrePrqy", query = "SELECT h FROM HKNG001 h WHERE h.prePrqy = :prePrqy")
    , @NamedQuery(name = "HKNG001.findByBackUrl", query = "SELECT h FROM HKNG001 h WHERE h.backUrl = :backUrl")
    , @NamedQuery(name = "HKNG001.findByUnmsr", query = "SELECT h FROM HKNG001 h WHERE h.unmsr = :unmsr")
    , @NamedQuery(name = "HKNG001.findByPSN", query = "SELECT h FROM HKNG001 h WHERE h.processSerialNumber = :psn")
    , @NamedQuery(name = "HKNG001.findByBgSeq", query = "SELECT h FROM HKNG001 h WHERE h.bgSeq = :bgSeq")
    , @NamedQuery(name = "HKNG001.findBySupNo", query = "SELECT h FROM HKNG001 h WHERE h.supNo = :supNo")
    , @NamedQuery(name = "HKNG001.findByTotamts", query = "SELECT h FROM HKNG001 h WHERE h.totamts = :totamts")
    , @NamedQuery(name = "HKNG001.findByItnbr", query = "SELECT h FROM HKNG001 h WHERE h.itnbr = :itnbr")
    , @NamedQuery(name = "HKNG001.findByTotprice", query = "SELECT h FROM HKNG001 h WHERE h.totprice = :totprice")
    , @NamedQuery(name = "HKNG001.findByECode", query = "SELECT h FROM HKNG001 h WHERE h.eCode = :eCode")
    , @NamedQuery(name = "HKNG001.findByEid", query = "SELECT h FROM HKNG001 h WHERE h.eid = :eid")
    , @NamedQuery(name = "HKNG001.findByExplain", query = "SELECT h FROM HKNG001 h WHERE h.explain = :explain")
    , @NamedQuery(name = "HKNG001.findByUnprice", query = "SELECT h FROM HKNG001 h WHERE h.unprice = :unprice")
    , @NamedQuery(name = "HKNG001.findByItdsc", query = "SELECT h FROM HKNG001 h WHERE h.itdsc = :itdsc")
    , @NamedQuery(name = "HKNG001.findByFSN", query = "SELECT h FROM HKNG001 h WHERE h.formSerialNumber = :fsn")
    , @NamedQuery(name = "HKNG001.findBySerialNumber", query = "SELECT h FROM HKNG001 h WHERE h.serialNumber = :serialNumber")
    , @NamedQuery(name = "HKNG001.findByCreaterName", query = "SELECT h FROM HKNG001 h WHERE h.createrName = :createrName")})
public class HKNG001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Condition")
    private String condition;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "SupName")
    private String supName;
    @Size(max = 255)
    @Column(name = "Facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "Creater")
    private String creater;
    @Size(max = 255)
    @Column(name = "CreateDate")
    private String createDate;
    @Size(max = 255)
    @Column(name = "ESDID")
    private String esdid;
    @Size(max = 255)
    @Column(name = "Taxrate")
    private String taxrate;
    @Size(max = 255)
    @Column(name = "Tag")
    private String tag;
    @Size(max = 255)
    @Column(name = "EName")
    private String eName;
    @Size(max = 255)
    @Column(name = "PrePrqy")
    private String prePrqy;
    @Size(max = 255)
    @Column(name = "BackUrl")
    private String backUrl;
    @Size(max = 255)
    @Column(name = "Unmsr")
    private String unmsr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "BgSeq")
    private String bgSeq;
    @Size(max = 255)
    @Column(name = "SupNo")
    private String supNo;
    @Size(max = 255)
    @Column(name = "Totamts")
    private String totamts;
    @Size(max = 255)
    @Column(name = "Itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "Totprice")
    private String totprice;
    @Size(max = 255)
    @Column(name = "ECode")
    private String eCode;
    @Size(max = 255)
    @Column(name = "EID")
    private String eid;
    @Size(max = 255)
    @Column(name = "Explain")
    private String explain;
    @Size(max = 255)
    @Column(name = "Unprice")
    private String unprice;
    @Size(max = 255)
    @Column(name = "Itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "CreaterName")
    private String createrName;

    public HKNG001() {
    }

    public HKNG001(String oid) {
        this.oid = oid;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEsdid() {
        return esdid;
    }

    public void setEsdid(String esdid) {
        this.esdid = esdid;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getPrePrqy() {
        return prePrqy;
    }

    public void setPrePrqy(String prePrqy) {
        this.prePrqy = prePrqy;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getUnmsr() {
        return unmsr;
    }

    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getBgSeq() {
        return bgSeq;
    }

    public void setBgSeq(String bgSeq) {
        this.bgSeq = bgSeq;
    }

    public String getSupNo() {
        return supNo;
    }

    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    public String getTotamts() {
        return totamts;
    }

    public void setTotamts(String totamts) {
        this.totamts = totamts;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getTotprice() {
        return totprice;
    }

    public void setTotprice(String totprice) {
        this.totprice = totprice;
    }

    public String getECode() {
        return eCode;
    }

    public void setECode(String eCode) {
        this.eCode = eCode;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getUnprice() {
        return unprice;
    }

    public void setUnprice(String unprice) {
        this.unprice = unprice;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
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
        if (!(object instanceof HKNG001)) {
            return false;
        }
        HKNG001 other = (HKNG001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKNG001[ oid=" + oid + " ]";
    }
    
}
