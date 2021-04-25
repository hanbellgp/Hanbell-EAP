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
 * @author C0160
 */
@Entity
@Table(name = "HSY_PB004")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HSYPB004.findAll", query = "SELECT h FROM HSYPB004 h"),
    @NamedQuery(name = "HSYPB004.findByFacno", query = "SELECT h FROM HSYPB004 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HSYPB004.findByPSN", query = "SELECT h FROM HSYPB004 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HSYPB004.findByFSN", query = "SELECT h FROM HSYPB004 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HSYPB004.findByApplyUser", query = "SELECT h FROM HSYPB004 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HSYPB004.findByApplyDept", query = "SELECT h FROM HSYPB004 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HSYPB004.findByOID", query = "SELECT h FROM HSYPB004 h WHERE h.oid = :oid")})
public class HSYPB004 implements Serializable {

    @Size(max = 255)
    @Column(name = "hdn_applyUser")
    private String hdnApplyUser;
    @Size(max = 255)
    @Column(name = "hdn_applyDept")
    private String hdnApplyDept;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "old_content")
    private String oldContent;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "new_itnbr")
    private String newItnbr;
    @Size(max = 255)
    @Column(name = "new_content")
    private String newContent;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "copies")
    private String copies;
    @Size(max = 255)
    @Column(name = "old_no")
    private String oldNo;
    @Size(max = 255)
    @Column(name = "new_itdsc")
    private String newItdsc;
    @Size(max = 255)
    @Column(name = "attachedPages")
    private String attachedPages;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "new_drawing")
    private String newDrawing;
    @Size(max = 255)
    @Column(name = "new_name")
    private String newName;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "old_itdsc")
    private String oldItdsc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "receptionDept")
    private String receptionDept;
    @Size(max = 255)
    @Column(name = "old_itnbr")
    private String oldItnbr;
    @Size(max = 255)
    @Column(name = "old_drawing")
    private String oldDrawing;
    @Size(max = 255)
    @Column(name = "ECN")
    private String ecn;
    @Size(max = 255)
    @Column(name = "applyRemark")
    private String applyRemark;
    @Size(max = 255)
    @Column(name = "old_name")
    private String oldName;
    @Size(max = 255)
    @Column(name = "attachedCopies")
    private String attachedCopies;
    @Size(max = 255)
    @Column(name = "new_no")
    private String newNo;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Size(max = 255)
    @Column(name = "RecordNumber")
    private String recordNumber;
    @Column(name = "effectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;

    public HSYPB004() {
    }

    public HSYPB004(String oid) {
        this.oid = oid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getNewItnbr() {
        return newItnbr;
    }

    public void setNewItnbr(String newItnbr) {
        this.newItnbr = newItnbr;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        this.copies = copies;
    }

    public String getOldNo() {
        return oldNo;
    }

    public void setOldNo(String oldNo) {
        this.oldNo = oldNo;
    }

    public String getNewItdsc() {
        return newItdsc;
    }

    public void setNewItdsc(String newItdsc) {
        this.newItdsc = newItdsc;
    }

    public String getAttachedPages() {
        return attachedPages;
    }

    public void setAttachedPages(String attachedPages) {
        this.attachedPages = attachedPages;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getNewDrawing() {
        return newDrawing;
    }

    public void setNewDrawing(String newDrawing) {
        this.newDrawing = newDrawing;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOldItdsc() {
        return oldItdsc;
    }

    public void setOldItdsc(String oldItdsc) {
        this.oldItdsc = oldItdsc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getReceptionDept() {
        return receptionDept;
    }

    public void setReceptionDept(String receptionDept) {
        this.receptionDept = receptionDept;
    }

    public String getOldItnbr() {
        return oldItnbr;
    }

    public void setOldItnbr(String oldItnbr) {
        this.oldItnbr = oldItnbr;
    }

    public String getOldDrawing() {
        return oldDrawing;
    }

    public void setOldDrawing(String oldDrawing) {
        this.oldDrawing = oldDrawing;
    }

    public String getEcn() {
        return ecn;
    }

    public void setEcn(String ecn) {
        this.ecn = ecn;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getAttachedCopies() {
        return attachedCopies;
    }

    public void setAttachedCopies(String attachedCopies) {
        this.attachedCopies = attachedCopies;
    }

    public String getNewNo() {
        return newNo;
    }

    public void setNewNo(String newNo) {
        this.newNo = newNo;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof HSYPB004)) {
            return false;
        }
        HSYPB004 other = (HSYPB004) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HSYPB004[ oid=" + oid + " ]";
    }

    public String getHdnApplyUser() {
        return hdnApplyUser;
    }

    public void setHdnApplyUser(String hdnApplyUser) {
        this.hdnApplyUser = hdnApplyUser;
    }

    public String getHdnApplyDept() {
        return hdnApplyDept;
    }

    public void setHdnApplyDept(String hdnApplyDept) {
        this.hdnApplyDept = hdnApplyDept;
    }

}
