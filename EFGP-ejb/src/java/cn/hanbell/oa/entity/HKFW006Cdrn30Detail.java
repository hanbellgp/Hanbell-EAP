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
@Table(name = "HK_FW006_CDRN30_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW006Cdrn30Detail.findAll", query = "SELECT h FROM HKFW006Cdrn30Detail h"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByOID", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByFixnr", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.fixnr = :fixnr"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByWareh", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.wareh = :wareh"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByPrebkdate", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.prebkdate = :prebkdate"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByVarnr", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.varnr = :varnr"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByRetqy1", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.retqy1 = :retqy1"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByUnmsr1", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByItdsc", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByBrpqy1", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.brpqy1 = :brpqy1"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findBySpdsc", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.spdsc = :spdsc"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByDmark2", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.dmark2 = :dmark2"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByBrowno", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.browno = :browno"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findBySeq", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByItnbr", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByTrseq", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.trseq = :trseq"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByBrqy1", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.brqy1 = :brqy1"),
    @NamedQuery(name = "HKFW006Cdrn30Detail.findByFSN", query = "SELECT h FROM HKFW006Cdrn30Detail h WHERE h.formSerialNumber = :fsn")})
public class HKFW006Cdrn30Detail implements Serializable {

    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "prebkdate_txt")
    private String prebkdate;
    @Size(max = 255)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 255)
    @Column(name = "retqy1")
    private String retqy1;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "brpqy1")
    private String brpqy1;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
     @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "browno")
    private String browno;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;
    @Size(max = 255)
    @Column(name = "brqy1")
    private String brqy1;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKFW006Cdrn30Detail() {
    }

    public HKFW006Cdrn30Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getPrebkdate() {
        return prebkdate;
    }

    public void setPrebkdate(String prebkdate) {
        this.prebkdate = prebkdate;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getRetqy1() {
        return retqy1;
    }

    public void setRetqy1(String retqy1) {
        this.retqy1 = retqy1;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getBrpqy1() {
        return brpqy1;
    }

    public void setBrpqy1(String brpqy1) {
        this.brpqy1 = brpqy1;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getBrowno() {
        return browno;
    }

    public void setBrowno(String browno) {
        this.browno = browno;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public String getBrqy1() {
        return brqy1;
    }

    public void setBrqy1(String brqy1) {
        this.brqy1 = brqy1;
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
        if (!(object instanceof HKFW006Cdrn30Detail)) {
            return false;
        }
        HKFW006Cdrn30Detail other = (HKFW006Cdrn30Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW006Cdrn30Detail[ oid=" + oid + " ]";
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }
    
}
