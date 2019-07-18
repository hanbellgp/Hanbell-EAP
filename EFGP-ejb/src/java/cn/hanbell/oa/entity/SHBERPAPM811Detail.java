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
@Table(name = "SHB_ERP_APM811_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPAPM811Detail.findAll", query = "SELECT s FROM SHBERPAPM811Detail s"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByOid", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByCoin", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.coin = :coin"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByAcpno", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.acpno = :acpno"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByLosamtfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.losamtfs = :losamtfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByTemamtfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.temamtfs = :temamtfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByIvomsfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.ivomsfs = :ivomsfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByPric", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.pric = :pric"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByComApamtfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.comApamtfs = :comApamtfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByItdsc", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByOgdkid", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.ogdkid = :ogdkid"),
    @NamedQuery(name = "SHBERPAPM811Detail.findBySponr", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.sponr = :sponr"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByPreamtfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.preamtfs = :preamtfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByIvopsfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.ivopsfs = :ivopsfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByRatio", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.ratio = :ratio"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByDmark", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.dmark = :dmark"),
    @NamedQuery(name = "SHBERPAPM811Detail.findBySeq", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.seq = :seq"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByBilno", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.bilno = :bilno"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByTrapyh", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.trapyh = :trapyh"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByItnbr", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByAcpamtfs", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.acpamtfs = :acpamtfs"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByFSN", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPAPM811Detail.findByPayqty", query = "SELECT s FROM SHBERPAPM811Detail s WHERE s.payqty = :payqty")})
public class SHBERPAPM811Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "acpno")
    private String acpno;
    @Size(max = 255)
    @Column(name = "losamtfs")
    private String losamtfs;
    @Size(max = 255)
    @Column(name = "temamtfs")
    private String temamtfs;
    @Size(max = 255)
    @Column(name = "ivomsfs")
    private String ivomsfs;
    @Size(max = 255)
    @Column(name = "pric")
    private String pric;
    @Size(max = 255)
    @Column(name = "com_apamtfs")
    private String comApamtfs;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "ogdkid")
    private String ogdkid;
    @Size(max = 255)
    @Column(name = "sponr")
    private String sponr;
    @Size(max = 255)
    @Column(name = "preamtfs")
    private String preamtfs;
    @Size(max = 255)
    @Column(name = "ivopsfs")
    private String ivopsfs;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;
    @Size(max = 255)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 255)
    @Column(name = "apdsc")
    private String apdsc;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "bilno")
    private String bilno;
    @Size(max = 255)
    @Column(name = "trapyh")
    private String trapyh;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "acpamtfs")
    private String acpamtfs;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "payqty")
    private String payqty;

    public SHBERPAPM811Detail() {
    }

    public SHBERPAPM811Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAcpno() {
        return acpno;
    }

    public void setAcpno(String acpno) {
        this.acpno = acpno;
    }

    public String getLosamtfs() {
        return losamtfs;
    }

    public void setLosamtfs(String losamtfs) {
        this.losamtfs = losamtfs;
    }

    public String getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(String temamtfs) {
        this.temamtfs = temamtfs;
    }

    public String getIvomsfs() {
        return ivomsfs;
    }

    public void setIvomsfs(String ivomsfs) {
        this.ivomsfs = ivomsfs;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }

    public String getComApamtfs() {
        return comApamtfs;
    }

    public void setComApamtfs(String comApamtfs) {
        this.comApamtfs = comApamtfs;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
    }

    public String getSponr() {
        return sponr;
    }

    public void setSponr(String sponr) {
        this.sponr = sponr;
    }

    public String getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(String preamtfs) {
        this.preamtfs = preamtfs;
    }

    public String getIvopsfs() {
        return ivopsfs;
    }

    public void setIvopsfs(String ivopsfs) {
        this.ivopsfs = ivopsfs;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getTrapyh() {
        return trapyh;
    }

    public void setTrapyh(String trapyh) {
        this.trapyh = trapyh;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(String acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPayqty() {
        return payqty;
    }

    public void setPayqty(String payqty) {
        this.payqty = payqty;
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
        if (!(object instanceof SHBERPAPM811Detail)) {
            return false;
        }
        SHBERPAPM811Detail other = (SHBERPAPM811Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.app.SHBERPAPM811Detail[ oid=" + oid + " ]";
    }

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

}
