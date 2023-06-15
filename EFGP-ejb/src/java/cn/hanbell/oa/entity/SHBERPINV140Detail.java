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
@Table(name = "SHB_ERP_INV140_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV140Detail.findAll", query = "SELECT s FROM SHBERPINV140Detail s"),
    @NamedQuery(name = "SHBERPINV140Detail.findBySitdsc", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.sitdsc = :sitdsc"),
    @NamedQuery(name = "SHBERPINV140Detail.findByOid", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPINV140Detail.findByRate2", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.rate2 = :rate2"),
    @NamedQuery(name = "SHBERPINV140Detail.findByNo", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.no = :no"),
    @NamedQuery(name = "SHBERPINV140Detail.findByEspdsc", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.espdsc = :espdsc"),
    @NamedQuery(name = "SHBERPINV140Detail.findByMorpcode", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.morpcode = :morpcode"),
    @NamedQuery(name = "SHBERPINV140Detail.findByUnmsr1", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.unmsr1 = :unmsr1"),
    @NamedQuery(name = "SHBERPINV140Detail.findByItdsc", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "SHBERPINV140Detail.findByUnmsr2", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.unmsr2 = :unmsr2"),
    @NamedQuery(name = "SHBERPINV140Detail.findByEitdsc", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.eitdsc = :eitdsc"),
    @NamedQuery(name = "SHBERPINV140Detail.findBySpdsc", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.spdsc = :spdsc"),
    @NamedQuery(name = "SHBERPINV140Detail.findByFvco", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.fvco = :fvco"),
    @NamedQuery(name = "SHBERPINV140Detail.findBySpdsc2", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.spdsc2 = :spdsc2"),
    @NamedQuery(name = "SHBERPINV140Detail.findByItdsc2", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.itdsc2 = :itdsc2"),
    @NamedQuery(name = "SHBERPINV140Detail.findByItcls", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.itcls = :itcls"),
    @NamedQuery(name = "SHBERPINV140Detail.findByItnbr", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPINV140Detail.findByFSN", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPINV140Detail.findByClsdsc", query = "SELECT s FROM SHBERPINV140Detail s WHERE s.clsdsc = :clsdsc")})
public class SHBERPINV140Detail implements Serializable {

    @Size(max = 255)
    @Column(name = "printtype")
    private String printtype;
    @Size(max = 255)
    @Column(name = "lno")
    private String lno;
    @Size(max = 255)
    @Column(name = "lotid")
    private String lotid;
    @Size(max = 255)
    @Column(name = "level2")
    private String level2;
    @Size(max = 255)
    @Column(name = "level1")
    private String level1;
    @Size(max = 255)
    @Column(name = "getseq")
    private String getseq;
    @Size(max = 255)
    @Column(name = "producttype")
    private String producttype;
    @Size(max = 255)
    @Column(name = "qcdatanum")
    private String qcdatanum;
    @Size(max = 255)
    @Column(name = "asrstype")
    private String asrstype;
    @Size(max = 255)
    @Column(name = "qcdata")
    private String qcdata;
    @Size(max = 255)
    @Column(name = "compid")
    private String compid;
    @Size(max = 255)
    @Column(name = "tracetype")
    private String tracetype;
    @Size(max = 255)
    @Column(name = "selfprint")
    private String selfprint;
    @Size(max = 255)
    @Column(name = "wno")
    private String wno;

    @Size(max = 255)
    @Column(name = "brate2")
    private String brate2;
    @Size(max = 255)
    @Column(name = "bmorpcode")
    private String bmorpcode;
    @Size(max = 255)
    @Column(name = "bespdsc")
    private String bespdsc;
    @Size(max = 255)
    @Column(name = "bitdsc")
    private String bitdsc;
    @Size(max = 255)
    @Column(name = "bitnbr")
    private String bitnbr;
    @Size(max = 255)
    @Column(name = "bspdsc")
    private String bspdsc;
    @Size(max = 255)
    @Column(name = "bitcls")
    private String bitcls;
    @Size(max = 255)
    @Column(name = "bunmsr1")
    private String bunmsr1;
    @Size(max = 255)
    @Column(name = "bunmsr2")
    private String bunmsr2;
    @Size(max = 255)
    @Column(name = "beitdsc")
    private String beitdsc;
    @Size(max = 255)
    @Column(name = "bspdsc2")
    private String bspdsc2;
    @Size(max = 255)
    @Column(name = "bsitdsc")
    private String bsitdsc;
    @Size(max = 255)
    @Column(name = "bclsdsc")
    private String bclsdsc;
    @Size(max = 255)
    @Column(name = "bfvco")
    private String bfvco;
    @Size(max = 255)
    @Column(name = "bitdsc2")
    private String bitdsc2;

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
    @Column(name = "rate2")
    private String rate2;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "morpcode")
    private String morpcode;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr2")
    private String unmsr2;
    @Size(max = 255)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "fvco")
    private String fvco;
    @Size(max = 255)
    @Column(name = "spdsc2")
    private String spdsc2;
    @Size(max = 255)
    @Column(name = "itdsc2")
    private String itdsc2;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;
    @Size(max = 255)
    @Column(name = "genre1")
    private String genre1;
    @Size(max = 255)
    @Column(name = "genre2")
    private String genre2;
    @Size(max = 255)
    @Column(name = "genre3")
    private String genre3;
    @Size(max = 255)
    @Column(name = "ModelDsc1")
    private String ModelDsc1;
    @Size(max = 255)
    @Column(name = "ModelDsc2")
    private String ModelDsc2;

    public SHBERPINV140Detail() {
    }

    public SHBERPINV140Detail(String oid) {
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

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getMorpcode() {
        return morpcode;
    }

    public void setMorpcode(String morpcode) {
        this.morpcode = morpcode;
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

    public String getUnmsr2() {
        return unmsr2;
    }

    public void setUnmsr2(String unmsr2) {
        this.unmsr2 = unmsr2;
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

    public String getFvco() {
        return fvco;
    }

    public void setFvco(String fvco) {
        this.fvco = fvco;
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
        if (!(object instanceof SHBERPINV140Detail)) {
            return false;
        }
        SHBERPINV140Detail other = (SHBERPINV140Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV140Detail[ oid=" + oid + " ]";
    }

    public String getBrate2() {
        return brate2;
    }

    public void setBrate2(String brate2) {
        this.brate2 = brate2;
    }

    public String getBmorpcode() {
        return bmorpcode;
    }

    public void setBmorpcode(String bmorpcode) {
        this.bmorpcode = bmorpcode;
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

    public String getBitnbr() {
        return bitnbr;
    }

    public void setBitnbr(String bitnbr) {
        this.bitnbr = bitnbr;
    }

    public String getBspdsc() {
        return bspdsc;
    }

    public void setBspdsc(String bspdsc) {
        this.bspdsc = bspdsc;
    }

    public String getBitcls() {
        return bitcls;
    }

    public void setBitcls(String bitcls) {
        this.bitcls = bitcls;
    }

    public String getBunmsr1() {
        return bunmsr1;
    }

    public void setBunmsr1(String bunmsr1) {
        this.bunmsr1 = bunmsr1;
    }

    public String getBunmsr2() {
        return bunmsr2;
    }

    public void setBunmsr2(String bunmsr2) {
        this.bunmsr2 = bunmsr2;
    }

    public String getBeitdsc() {
        return beitdsc;
    }

    public void setBeitdsc(String beitdsc) {
        this.beitdsc = beitdsc;
    }

    public String getBspdsc2() {
        return bspdsc2;
    }

    public void setBspdsc2(String bspdsc2) {
        this.bspdsc2 = bspdsc2;
    }

    public String getBsitdsc() {
        return bsitdsc;
    }

    public void setBsitdsc(String bsitdsc) {
        this.bsitdsc = bsitdsc;
    }

    public String getBclsdsc() {
        return bclsdsc;
    }

    public void setBclsdsc(String bclsdsc) {
        this.bclsdsc = bclsdsc;
    }

    public String getBfvco() {
        return bfvco;
    }

    public void setBfvco(String bfvco) {
        this.bfvco = bfvco;
    }

    public String getBitdsc2() {
        return bitdsc2;
    }

    public void setBitdsc2(String bitdsc2) {
        this.bitdsc2 = bitdsc2;
    }

    public String getPrinttype() {
        return printtype;
    }

    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    public String getLno() {
        return lno;
    }

    public void setLno(String lno) {
        this.lno = lno;
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getGetseq() {
        return getseq;
    }

    public void setGetseq(String getseq) {
        this.getseq = getseq;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getQcdatanum() {
        return qcdatanum;
    }

    public void setQcdatanum(String qcdatanum) {
        this.qcdatanum = qcdatanum;
    }

    public String getAsrstype() {
        return asrstype;
    }

    public void setAsrstype(String asrstype) {
        this.asrstype = asrstype;
    }

    public String getQcdata() {
        return qcdata;
    }

    public void setQcdata(String qcdata) {
        this.qcdata = qcdata;
    }

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public String getTracetype() {
        return tracetype;
    }

    public void setTracetype(String tracetype) {
        this.tracetype = tracetype;
    }

    public String getSelfprint() {
        return selfprint;
    }

    public void setSelfprint(String selfprint) {
        this.selfprint = selfprint;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getModelDsc1() {
        return ModelDsc1;
    }

    public void setModelDsc1(String ModelDsc1) {
        this.ModelDsc1 = ModelDsc1;
    }

    public String getModelDsc2() {
        return ModelDsc2;
    }

    public void setModelDsc2(String ModelDsc2) {
        this.ModelDsc2 = ModelDsc2;
    }

}
