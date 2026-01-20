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
 * @author C2082
 */
@Entity
@Table(name = "HK_GL082")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL082.findAll", query = "SELECT h FROM HKGL082 h"),
    @NamedQuery(name = "HKGL082.findByExplain", query = "SELECT h FROM HKGL082 h WHERE h.explain = :explain"),
    @NamedQuery(name = "HKGL082.findByFacno", query = "SELECT h FROM HKGL082 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKGL082.findByProcessSerialNumber", query = "SELECT h FROM HKGL082 h WHERE h.processSerialNumber = :processSerialNumber"),
    @NamedQuery(name = "HKGL082.findByApplyReason", query = "SELECT h FROM HKGL082 h WHERE h.applyReason = :applyReason"),
    @NamedQuery(name = "HKGL082.findByOid", query = "SELECT h FROM HKGL082 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL082.findByTitle", query = "SELECT h FROM HKGL082 h WHERE h.title = :title"),
    @NamedQuery(name = "HKGL082.findByLoanAmount", query = "SELECT h FROM HKGL082 h WHERE h.loanAmount = :loanAmount"),
    @NamedQuery(name = "HKGL082.findByApplyUser", query = "SELECT h FROM HKGL082 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKGL082.findByApplyDept", query = "SELECT h FROM HKGL082 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKGL082.findBySerialNumber", query = "SELECT h FROM HKGL082 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL082.findByWorkbeginDate", query = "SELECT h FROM HKGL082 h WHERE h.workbeginDate = :workbeginDate"),
    @NamedQuery(name = "HKGL082.findByFormSerialNumber", query = "SELECT h FROM HKGL082 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKGL082.findByPosition", query = "SELECT h FROM HKGL082 h WHERE h.position = :position"),
    @NamedQuery(name = "HKGL082.findByApplyDate", query = "SELECT h FROM HKGL082 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HKGL082.findByProofType", query = "SELECT h FROM HKGL082 h WHERE h.proofType = :proofType")})
public class HKGL082 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "explain")
    private String explain;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "applyReason")
    private String applyReason;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "loanAmount")
    private String loanAmount;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "workbeginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workbeginDate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "position")
    private String position;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "proofType")
    private String proofType;

    public HKGL082() {
    }

    public HKGL082(String oid) {
        this.oid = oid;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getWorkbeginDate() {
        return workbeginDate;
    }

    public void setWorkbeginDate(Date workbeginDate) {
        this.workbeginDate = workbeginDate;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
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
        if (!(object instanceof HKGL082)) {
            return false;
        }
        HKGL082 other = (HKGL082) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL082[ oid=" + oid + " ]";
    }
    
}
