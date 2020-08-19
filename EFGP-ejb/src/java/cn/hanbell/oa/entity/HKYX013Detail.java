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
@Table(name = "HK_YX013_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX013Detail.findAll", query = "SELECT h FROM HKYX013Detail h"),
    @NamedQuery(name = "HKYX013Detail.findByFacno", query = "SELECT h FROM HKYX013Detail h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKYX013Detail.findByNewDeptName", query = "SELECT h FROM HKYX013Detail h WHERE h.newDeptName = :newDeptName"),
    @NamedQuery(name = "HKYX013Detail.findByNewMancodeName", query = "SELECT h FROM HKYX013Detail h WHERE h.newMancodeName = :newMancodeName"),
    @NamedQuery(name = "HKYX013Detail.findByNewMancodeNo", query = "SELECT h FROM HKYX013Detail h WHERE h.newMancodeNo = :newMancodeNo"),
    @NamedQuery(name = "HKYX013Detail.findByOldDeptno", query = "SELECT h FROM HKYX013Detail h WHERE h.oldDeptno = :oldDeptno"),
    @NamedQuery(name = "HKYX013Detail.findByOid", query = "SELECT h FROM HKYX013Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKYX013Detail.findByItnbr", query = "SELECT h FROM HKYX013Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKYX013Detail.findByOldMancode", query = "SELECT h FROM HKYX013Detail h WHERE h.oldMancode = :oldMancode"),
    @NamedQuery(name = "HKYX013Detail.findByNcodeDA", query = "SELECT h FROM HKYX013Detail h WHERE h.ncodeDA = :ncodeDA"),
    @NamedQuery(name = "HKYX013Detail.findByOldMancodeName", query = "SELECT h FROM HKYX013Detail h WHERE h.oldMancodeName = :oldMancodeName"),
    @NamedQuery(name = "HKYX013Detail.findByNcodeDC", query = "SELECT h FROM HKYX013Detail h WHERE h.ncodeDC = :ncodeDC"),
    @NamedQuery(name = "HKYX013Detail.findBySingleNumber", query = "SELECT h FROM HKYX013Detail h WHERE h.singleNumber = :singleNumber"),
    @NamedQuery(name = "HKYX013Detail.findByNcodeDD", query = "SELECT h FROM HKYX013Detail h WHERE h.ncodeDD = :ncodeDD"),
    @NamedQuery(name = "HKYX013Detail.findByNcodeCD", query = "SELECT h FROM HKYX013Detail h WHERE h.ncodeCD = :ncodeCD"),
    @NamedQuery(name = "HKYX013Detail.findByNewDeptNo", query = "SELECT h FROM HKYX013Detail h WHERE h.newDeptNo = :newDeptNo"),
    @NamedQuery(name = "HKYX013Detail.findByInvoiceType", query = "SELECT h FROM HKYX013Detail h WHERE h.invoiceType = :invoiceType"),
    @NamedQuery(name = "HKYX013Detail.findByFSN", query = "SELECT h FROM HKYX013Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKYX013Detail.findByOldDeptName", query = "SELECT h FROM HKYX013Detail h WHERE h.oldDeptName = :oldDeptName"),
    @NamedQuery(name = "HKYX013Detail.findByIssevdta", query = "SELECT h FROM HKYX013Detail h WHERE h.issevdta = :issevdta"),
    @NamedQuery(name = "HKYX013Detail.findBySeq", query = "SELECT h FROM HKYX013Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKYX013Detail.findByDifferenceAmount", query = "SELECT h FROM HKYX013Detail h WHERE h.differenceAmount = :differenceAmount"),
    @NamedQuery(name = "HKYX013Detail.findByTrseq", query = "SELECT h FROM HKYX013Detail h WHERE h.trseq = :trseq")})
public class HKYX013Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "newDeptName")
    private String newDeptName;
    @Size(max = 255)
    @Column(name = "newMancodeName")
    private String newMancodeName;
    @Size(max = 255)
    @Column(name = "newMancodeNo")
    private String newMancodeNo;
    @Size(max = 255)
    @Column(name = "oldDeptno")
    private String oldDeptno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "oldMancode")
    private String oldMancode;
    @Size(max = 255)
    @Column(name = "ncodeDA")
    private String ncodeDA;
    @Size(max = 255)
    @Column(name = "oldMancodeName")
    private String oldMancodeName;
    @Size(max = 255)
    @Column(name = "ncodeDC")
    private String ncodeDC;
    @Size(max = 255)
    @Column(name = "singleNumber")
    private String singleNumber;
    @Size(max = 255)
    @Column(name = "ncodeDD")
    private String ncodeDD;
    @Size(max = 255)
    @Column(name = "ncodeCD")
    private String ncodeCD;
    @Size(max = 255)
    @Column(name = "newDeptNo")
    private String newDeptNo;
    @Size(max = 255)
    @Column(name = "invoiceType")
    private String invoiceType;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "oldDeptName")
    private String oldDeptName;
    @Size(max = 255)
    @Column(name = "issevdta")
    private String issevdta;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "differenceAmount")
    private String differenceAmount;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;

    public HKYX013Detail() {
    }

    public HKYX013Detail(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getNewDeptName() {
        return newDeptName;
    }

    public void setNewDeptName(String newDeptName) {
        this.newDeptName = newDeptName;
    }

    public String getNewMancodeName() {
        return newMancodeName;
    }

    public void setNewMancodeName(String newMancodeName) {
        this.newMancodeName = newMancodeName;
    }

    public String getNewMancodeNo() {
        return newMancodeNo;
    }

    public void setNewMancodeNo(String newMancodeNo) {
        this.newMancodeNo = newMancodeNo;
    }

    public String getOldDeptno() {
        return oldDeptno;
    }

    public void setOldDeptno(String oldDeptno) {
        this.oldDeptno = oldDeptno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getOldMancode() {
        return oldMancode;
    }

    public void setOldMancode(String oldMancode) {
        this.oldMancode = oldMancode;
    }

    public String getNcodeDA() {
        return ncodeDA;
    }

    public void setNcodeDA(String ncodeDA) {
        this.ncodeDA = ncodeDA;
    }

    public String getOldMancodeName() {
        return oldMancodeName;
    }

    public void setOldMancodeName(String oldMancodeName) {
        this.oldMancodeName = oldMancodeName;
    }

    public String getNcodeDC() {
        return ncodeDC;
    }

    public void setNcodeDC(String ncodeDC) {
        this.ncodeDC = ncodeDC;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public String getNcodeDD() {
        return ncodeDD;
    }

    public void setNcodeDD(String ncodeDD) {
        this.ncodeDD = ncodeDD;
    }

    public String getNcodeCD() {
        return ncodeCD;
    }

    public void setNcodeCD(String ncodeCD) {
        this.ncodeCD = ncodeCD;
    }

    public String getNewDeptNo() {
        return newDeptNo;
    }

    public void setNewDeptNo(String newDeptNo) {
        this.newDeptNo = newDeptNo;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOldDeptName() {
        return oldDeptName;
    }

    public void setOldDeptName(String oldDeptName) {
        this.oldDeptName = oldDeptName;
    }

    public String getIssevdta() {
        return issevdta;
    }

    public void setIssevdta(String issevdta) {
        this.issevdta = issevdta;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getDifferenceAmount() {
        return differenceAmount;
    }

    public void setDifferenceAmount(String differenceAmount) {
        this.differenceAmount = differenceAmount;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
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
        if (!(object instanceof HKYX013Detail)) {
            return false;
        }
        HKYX013Detail other = (HKYX013Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX013Detail[ oid=" + oid + " ]";
    }
    
}
