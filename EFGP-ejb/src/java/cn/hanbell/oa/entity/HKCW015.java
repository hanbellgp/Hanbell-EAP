/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Administrator
 */
@Entity
@Table(name = "HK_CW015")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW015.findAll", query = "SELECT h FROM HKCW015 h"),
    @NamedQuery(name = "HKCW015.findBySummary", query = "SELECT h FROM HKCW015 h WHERE h.summary = :summary"),
    @NamedQuery(name = "HKCW015.findByFacno", query = "SELECT h FROM HKCW015 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW015.findByPSN", query = "SELECT h FROM HKCW015 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW015.findByDrafttamts", query = "SELECT h FROM HKCW015 h WHERE h.drafttamts = :drafttamts"),
    @NamedQuery(name = "HKCW015.findByTtamts", query = "SELECT h FROM HKCW015 h WHERE h.ttamts = :ttamts"),
    @NamedQuery(name = "HKCW015.findByChineseAmount", query = "SELECT h FROM HKCW015 h WHERE h.chineseAmount = :chineseAmount"),
    @NamedQuery(name = "HKCW015.findByOid", query = "SELECT h FROM HKCW015 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW015.findBySrcno", query = "SELECT h FROM HKCW015 h WHERE h.srcno = :srcno"),
    @NamedQuery(name = "HKCW015.findByTotalCount", query = "SELECT h FROM HKCW015 h WHERE h.totalCount = :totalCount"),
    @NamedQuery(name = "HKCW015.findByDraftiamts", query = "SELECT h FROM HKCW015 h WHERE h.draftiamts = :draftiamts"),
    @NamedQuery(name = "HKCW015.findByApplyUser", query = "SELECT h FROM HKCW015 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKCW015.findByOtheramts", query = "SELECT h FROM HKCW015 h WHERE h.otheramts = :otheramts"),
    @NamedQuery(name = "HKCW015.findByTotalAmount", query = "SELECT h FROM HKCW015 h WHERE h.totalAmount = :totalAmount"),
    @NamedQuery(name = "HKCW015.findByPayType", query = "SELECT h FROM HKCW015 h WHERE h.payType = :payType"),
    @NamedQuery(name = "HKCW015.findBySerialNumber", query = "SELECT h FROM HKCW015 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW015.findByNtsamts", query = "SELECT h FROM HKCW015 h WHERE h.ntsamts = :ntsamts"),
    @NamedQuery(name = "HKCW015.findByFSN", query = "SELECT h FROM HKCW015 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW015.findByCoin", query = "SELECT h FROM HKCW015 h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKCW015.findByCreateDate", query = "SELECT h FROM HKCW015 h WHERE h.createDate = :createDate"),
    @NamedQuery(name = "HKCW015.findByPayDate", query = "SELECT h FROM HKCW015 h WHERE h.payDate = :payDate"),
    @NamedQuery(name = "HKCW015.findByAttachment", query = "SELECT h FROM HKCW015 h WHERE h.attachment = :attachment")})
public class HKCW015 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "summary")
    private String summary;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "drafttamts")
    private String drafttamts;
    @Size(max = 255)
    @Column(name = "ttamts")
    private String ttamts;
    @Size(max = 255)
    @Column(name = "chineseAmount")
    private String chineseAmount;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 255)
    @Column(name = "totalCount")
    private String totalCount;
    @Size(max = 255)
    @Column(name = "draftiamts")
    private String draftiamts;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "otheramts")
    private String otheramts;
    @Size(max = 255)
    @Column(name = "totalAmount")
    private String totalAmount;
    @Size(max = 255)
    @Column(name = "payType")
    private String payType;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "ntsamts")
    private String ntsamts;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "payDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;
    @Size(max = 255)
    @Column(name = "Attachment")
    private String attachment;

    public HKCW015() {
    }

    public HKCW015(String oid) {
        this.oid = oid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getDrafttamts() {
        return drafttamts;
    }

    public void setDrafttamts(String drafttamts) {
        this.drafttamts = drafttamts;
    }

    public String getTtamts() {
        return ttamts;
    }

    public void setTtamts(String ttamts) {
        this.ttamts = ttamts;
    }

    public String getChineseAmount() {
        return chineseAmount;
    }

    public void setChineseAmount(String chineseAmount) {
        this.chineseAmount = chineseAmount;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getDraftiamts() {
        return draftiamts;
    }

    public void setDraftiamts(String draftiamts) {
        this.draftiamts = draftiamts;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getOtheramts() {
        return otheramts;
    }

    public void setOtheramts(String otheramts) {
        this.otheramts = otheramts;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNtsamts() {
        return ntsamts;
    }

    public void setNtsamts(String ntsamts) {
        this.ntsamts = ntsamts;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
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
        if (!(object instanceof HKCW015)) {
            return false;
        }
        HKCW015 other = (HKCW015) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW015[ oid=" + oid + " ]";
    }
    
}
