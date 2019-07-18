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
@Table(name = "SHB_ERP_INV146_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV146Detail.findAll", query = "SELECT s FROM SHBERPINV146Detail s"),
    @NamedQuery(name = "SHBERPINV146Detail.findBySitdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.sitdsc = :sitdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByOid", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBespdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.bespdsc = :bespdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBitdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.bitdsc = :bitdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByEspdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.espdsc = :espdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBeitdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.beitdsc = :beitdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByItdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByEitdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.eitdsc = :eitdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findBySpdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.spdsc = :spdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBspdsc2", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.bspdsc2 = :bspdsc2"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBspdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.bspdsc = :bspdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBsitdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.bsitdsc = :bsitdsc"),
    @NamedQuery(name = "SHBERPINV146Detail.findBySpdsc2", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.spdsc2 = :spdsc2"),
    @NamedQuery(name = "SHBERPINV146Detail.findByItdsc2", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.itdsc2 = :itdsc2"),
    @NamedQuery(name = "SHBERPINV146Detail.findBySeq", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.seq = :seq"),
    @NamedQuery(name = "SHBERPINV146Detail.findByItcls", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.itcls = :itcls"),
    @NamedQuery(name = "SHBERPINV146Detail.findByItnbr", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPINV146Detail.findByBitdsc2", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.bitdsc2 = :bitdsc2"),
    @NamedQuery(name = "SHBERPINV146Detail.findByFSN", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPINV146Detail.findByClsdsc", query = "SELECT s FROM SHBERPINV146Detail s WHERE s.clsdsc = :clsdsc")})
public class SHBERPINV146Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "sitdsc")
    private String sitdsc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "bespdsc")
    private String bespdsc;
    @Size(max = 255)
    @Column(name = "bitdsc")
    private String bitdsc;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "beitdsc")
    private String beitdsc;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "bspdsc2")
    private String bspdsc2;
    @Size(max = 255)
    @Column(name = "bspdsc")
    private String bspdsc;
    @Size(max = 255)
    @Column(name = "bsitdsc")
    private String bsitdsc;
    @Size(max = 255)
    @Column(name = "spdsc2")
    private String spdsc2;
    @Size(max = 255)
    @Column(name = "itdsc2")
    private String itdsc2;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "bitdsc2")
    private String bitdsc2;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;

    public SHBERPINV146Detail() {
    }

    public SHBERPINV146Detail(String oid) {
        this.oid = oid;
    }

    public String getSitdsc() {
        return sitdsc;
    }

    public void setSitdsc(String sitdsc) {
        this.sitdsc = sitdsc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBespdsc() {
        return bespdsc;
    }

    public void setBespdsc(String bespdsc) {
        this.bespdsc = bespdsc;
    }

    public String getBitdsc() {
        return bitdsc;
    }

    public void setBitdsc(String bitdsc) {
        this.bitdsc = bitdsc;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getBeitdsc() {
        return beitdsc;
    }

    public void setBeitdsc(String beitdsc) {
        this.beitdsc = beitdsc;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getEitdsc() {
        return eitdsc;
    }

    public void setEitdsc(String eitdsc) {
        this.eitdsc = eitdsc;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getBspdsc2() {
        return bspdsc2;
    }

    public void setBspdsc2(String bspdsc2) {
        this.bspdsc2 = bspdsc2;
    }

    public String getBspdsc() {
        return bspdsc;
    }

    public void setBspdsc(String bspdsc) {
        this.bspdsc = bspdsc;
    }

    public String getBsitdsc() {
        return bsitdsc;
    }

    public void setBsitdsc(String bsitdsc) {
        this.bsitdsc = bsitdsc;
    }

    public String getSpdsc2() {
        return spdsc2;
    }

    public void setSpdsc2(String spdsc2) {
        this.spdsc2 = spdsc2;
    }

    public String getItdsc2() {
        return itdsc2;
    }

    public void setItdsc2(String itdsc2) {
        this.itdsc2 = itdsc2;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getBitdsc2() {
        return bitdsc2;
    }

    public void setBitdsc2(String bitdsc2) {
        this.bitdsc2 = bitdsc2;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getClsdsc() {
        return clsdsc;
    }

    public void setClsdsc(String clsdsc) {
        this.clsdsc = clsdsc;
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
        if (!(object instanceof SHBERPINV146Detail)) {
            return false;
        }
        SHBERPINV146Detail other = (SHBERPINV146Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV146Detail[ oid=" + oid + " ]";
    }
    
}
