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
@Table(name = "HK_CW018_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW018Detail.findAll", query = "SELECT h FROM HKCW018Detail h"),
    @NamedQuery(name = "HKCW018Detail.findByAppno", query = "SELECT h FROM HKCW018Detail h WHERE h.appno = :appno"),
    @NamedQuery(name = "HKCW018Detail.findByOid", query = "SELECT h FROM HKCW018Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW018Detail.findByInvoiceNumber", query = "SELECT h FROM HKCW018Detail h WHERE h.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "HKCW018Detail.findByFSN", query = "SELECT h FROM HKCW018Detail h WHERE h.formSerialNumber = :fsn")})
public class HKCW018Detail implements Serializable {

    @Size(max = 255)
    @Column(name = "payDate2_txt")
    private String payDate2txt;
    @Size(max = 255)
    @Column(name = "payInterest")
    private String payInterest;
    @Size(max = 255)
    @Column(name = "appno")
    private String appno;
    @Size(max = 255)
    @Column(name = "payDate1_txt")
    private String payDate1txt;
    @Size(max = 255)
    @Column(name = "payDate3_txt")
    private String payDate3txt;
    @Size(max = 255)
    @Column(name = "payAmount2")
    private String payAmount2;
    @Size(max = 255)
    @Column(name = "payAmount3")
    private String payAmount3;
    @Size(max = 255)
    @Column(name = "payAmount1")
    private String payAmount1;
    @Size(max = 255)
    @Column(name = "invoiceNumber")
    private String invoiceNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "hpayamtfs")
    private String hpayamtfs;
    @Size(max = 255)
    @Column(name = "payamtfs")
    private String payamtfs;
    @Size(max = 255)
    @Column(name = "payDate")
    private String payDate;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;
    @Size(max = 255)
    @Column(name = "payda")
    private String payda;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;

    public HKCW018Detail() {
    }

    public HKCW018Detail(String oid) {
        this.oid = oid;
    }

    public String getPayDate2txt() {
        return payDate2txt;
    }

    public void setPayDate2txt(String payDate2txt) {
        this.payDate2txt = payDate2txt;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPayDate1txt() {
        return payDate1txt;
    }

    public void setPayDate1txt(String payDate1txt) {
        this.payDate1txt = payDate1txt;
    }

    public String getPayDate3txt() {
        return payDate3txt;
    }

    public void setPayDate3txt(String payDate3txt) {
        this.payDate3txt = payDate3txt;
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
        if (!(object instanceof HKCW018Detail)) {
            return false;
        }
        HKCW018Detail other = (HKCW018Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW018Detail[ oid=" + oid + " ]";
    }

    public String getPayInterest() {
        return payInterest;
    }

    public void setPayInterest(String payInterest) {
        this.payInterest = payInterest;
    }

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getPayAmount2() {
        return payAmount2;
    }

    public void setPayAmount2(String payAmount2) {
        this.payAmount2 = payAmount2;
    }

    public String getPayAmount3() {
        return payAmount3;
    }

    public void setPayAmount3(String payAmount3) {
        this.payAmount3 = payAmount3;
    }

    public String getPayAmount1() {
        return payAmount1;
    }

    public void setPayAmount1(String payAmount1) {
        this.payAmount1 = payAmount1;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getHpayamtfs() {
        return hpayamtfs;
    }

    public void setHpayamtfs(String hpayamtfs) {
        this.hpayamtfs = hpayamtfs;
    }

    public String getPayamtfs() {
        return payamtfs;
    }

    public void setPayamtfs(String payamtfs) {
        this.payamtfs = payamtfs;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public String getPayda() {
        return payda;
    }

    public void setPayda(String payda) {
        this.payda = payda;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

}
