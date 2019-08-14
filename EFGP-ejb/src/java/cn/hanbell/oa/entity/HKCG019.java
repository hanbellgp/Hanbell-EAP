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
@Table(name = "HK_CG019")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG019.findAll", query = "SELECT h FROM HKCG019 h"),
    @NamedQuery(name = "HKCG019.findByEName", query = "SELECT h FROM HKCG019 h WHERE h.eName = :eName"),
    @NamedQuery(name = "HKCG019.findByEsdid", query = "SELECT h FROM HKCG019 h WHERE h.esdid = :esdid"),
    @NamedQuery(name = "HKCG019.findBySupName", query = "SELECT h FROM HKCG019 h WHERE h.supName = :supName"),
    @NamedQuery(name = "HKCG019.findByTramts", query = "SELECT h FROM HKCG019 h WHERE h.tramts = :tramts"),
    @NamedQuery(name = "HKCG019.findByPSN", query = "SELECT h FROM HKCG019 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCG019.findBySupNo", query = "SELECT h FROM HKCG019 h WHERE h.supNo = :supNo"),
    @NamedQuery(name = "HKCG019.findByTax", query = "SELECT h FROM HKCG019 h WHERE h.tax = :tax"),
    @NamedQuery(name = "HKCG019.findByTaxrate", query = "SELECT h FROM HKCG019 h WHERE h.taxrate = :taxrate"),
    @NamedQuery(name = "HKCG019.findByCreateDate", query = "SELECT h FROM HKCG019 h WHERE h.createDate = :createDate"),
    @NamedQuery(name = "HKCG019.findByCoin", query = "SELECT h FROM HKCG019 h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKCG019.findByCreater", query = "SELECT h FROM HKCG019 h WHERE h.creater = :creater"),
    @NamedQuery(name = "HKCG019.findByUnmsr", query = "SELECT h FROM HKCG019 h WHERE h.unmsr = :unmsr"),
    @NamedQuery(name = "HKCG019.findByBGInfoUrl", query = "SELECT h FROM HKCG019 h WHERE h.bGInfoUrl = :bGInfoUrl"),
    @NamedQuery(name = "HKCG019.findByFSN", query = "SELECT h FROM HKCG019 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCG019.findByPreMark", query = "SELECT h FROM HKCG019 h WHERE h.preMark = :preMark"),
    @NamedQuery(name = "HKCG019.findByCondition", query = "SELECT h FROM HKCG019 h WHERE h.condition = :condition"),
    @NamedQuery(name = "HKCG019.findByEid", query = "SELECT h FROM HKCG019 h WHERE h.eid = :eid"),
    @NamedQuery(name = "HKCG019.findByFacno", query = "SELECT h FROM HKCG019 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCG019.findByTotamts", query = "SELECT h FROM HKCG019 h WHERE h.totamts = :totamts"),
    @NamedQuery(name = "HKCG019.findByExplain", query = "SELECT h FROM HKCG019 h WHERE h.explain = :explain"),
    @NamedQuery(name = "HKCG019.findByBgSeq", query = "SELECT h FROM HKCG019 h WHERE h.bgSeq = :bgSeq"),
    @NamedQuery(name = "HKCG019.findByItnbr", query = "SELECT h FROM HKCG019 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKCG019.findByEType", query = "SELECT h FROM HKCG019 h WHERE h.eType = :eType"),
    @NamedQuery(name = "HKCG019.findByOid", query = "SELECT h FROM HKCG019 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCG019.findByTaxamts", query = "SELECT h FROM HKCG019 h WHERE h.taxamts = :taxamts"),
    @NamedQuery(name = "HKCG019.findByBackUrl", query = "SELECT h FROM HKCG019 h WHERE h.backUrl = :backUrl"),
    @NamedQuery(name = "HKCG019.findByItdsc", query = "SELECT h FROM HKCG019 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKCG019.findBySerialNumber", query = "SELECT h FROM HKCG019 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCG019.findByUnprice", query = "SELECT h FROM HKCG019 h WHERE h.unprice = :unprice"),
    @NamedQuery(name = "HKCG019.findByCreaterName", query = "SELECT h FROM HKCG019 h WHERE h.createrName = :createrName"),
    @NamedQuery(name = "HKCG019.findByTag", query = "SELECT h FROM HKCG019 h WHERE h.tag = :tag"),
    @NamedQuery(name = "HKCG019.findByPrePrqy", query = "SELECT h FROM HKCG019 h WHERE h.prePrqy = :prePrqy"),
    @NamedQuery(name = "HKCG019.findByECode", query = "SELECT h FROM HKCG019 h WHERE h.eCode = :eCode"),
    @NamedQuery(name = "HKCG019.findByAttachment", query = "SELECT h FROM HKCG019 h WHERE h.attachment = :attachment")})
public class HKCG019 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "EName")
    private String eName;
    @Size(max = 255)
    @Column(name = "ESDID")
    private String esdid;
    @Size(max = 255)
    @Column(name = "SupName")
    private String supName;
    @Size(max = 255)
    @Column(name = "Tramts")
    private String tramts;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "SupNo")
    private String supNo;
    @Size(max = 255)
    @Column(name = "Tax")
    private String tax;
    @Size(max = 255)
    @Column(name = "Taxrate")
    private String taxrate;
    @Size(max = 255)
    @Column(name = "CreateDate")
    private String createDate;
    @Size(max = 255)
    @Column(name = "Coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "Creater")
    private String creater;
    @Size(max = 255)
    @Column(name = "Unmsr")
    private String unmsr;
    @Size(max = 255)
    @Column(name = "BGInfoUrl")
    private String bGInfoUrl;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "PreMark")
    private String preMark;
    @Size(max = 255)
    @Column(name = "Condition")
    private String condition;
    @Size(max = 255)
    @Column(name = "EID")
    private String eid;
    @Size(max = 255)
    @Column(name = "Facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "Totamts")
    private String totamts;
    @Size(max = 255)
    @Column(name = "Explain")
    private String explain;
    @Size(max = 255)
    @Column(name = "BgSeq")
    private String bgSeq;
    @Size(max = 255)
    @Column(name = "Itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "EType")
    private String eType;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "Taxamts")
    private String taxamts;
    @Size(max = 255)
    @Column(name = "BackUrl")
    private String backUrl;
    @Size(max = 255)
    @Column(name = "Itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "Unprice")
    private String unprice;
    @Size(max = 255)
    @Column(name = "CreaterName")
    private String createrName;
    @Size(max = 255)
    @Column(name = "Tag")
    private String tag;
    @Size(max = 255)
    @Column(name = "PrePrqy")
    private String prePrqy;
    @Size(max = 255)
    @Column(name = "ECode")
    private String eCode;
    @Size(max = 255)
    @Column(name = "Attachment")
    private String attachment;

    public HKCG019() {
    }

    public HKCG019(String oid) {
        this.oid = oid;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getEsdid() {
        return esdid;
    }

    public void setEsdid(String esdid) {
        this.esdid = esdid;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getTramts() {
        return tramts;
    }

    public void setTramts(String tramts) {
        this.tramts = tramts;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getSupNo() {
        return supNo;
    }

    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUnmsr() {
        return unmsr;
    }

    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }

    public String getBGInfoUrl() {
        return bGInfoUrl;
    }

    public void setBGInfoUrl(String bGInfoUrl) {
        this.bGInfoUrl = bGInfoUrl;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPreMark() {
        return preMark;
    }

    public void setPreMark(String preMark) {
        this.preMark = preMark;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getTotamts() {
        return totamts;
    }

    public void setTotamts(String totamts) {
        this.totamts = totamts;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getBgSeq() {
        return bgSeq;
    }

    public void setBgSeq(String bgSeq) {
        this.bgSeq = bgSeq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getEType() {
        return eType;
    }

    public void setEType(String eType) {
        this.eType = eType;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTaxamts() {
        return taxamts;
    }

    public void setTaxamts(String taxamts) {
        this.taxamts = taxamts;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUnprice() {
        return unprice;
    }

    public void setUnprice(String unprice) {
        this.unprice = unprice;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPrePrqy() {
        return prePrqy;
    }

    public void setPrePrqy(String prePrqy) {
        this.prePrqy = prePrqy;
    }

    public String getECode() {
        return eCode;
    }

    public void setECode(String eCode) {
        this.eCode = eCode;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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
        if (!(object instanceof HKCG019)) {
            return false;
        }
        HKCG019 other = (HKCG019) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG019[ oid=" + oid + " ]";
    }

}
