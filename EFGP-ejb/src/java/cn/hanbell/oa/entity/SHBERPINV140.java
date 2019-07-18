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
@Table(name = "SHB_ERP_INV140")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV140.findAll", query = "SELECT s FROM SHBERPINV140 s"),
    @NamedQuery(name = "SHBERPINV140.findBySitdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.sitdsc = :sitdsc"),
    @NamedQuery(name = "SHBERPINV140.findByBrate2", query = "SELECT s FROM SHBERPINV140 s WHERE s.brate2 = :brate2"),
    @NamedQuery(name = "SHBERPINV140.findByOid", query = "SELECT s FROM SHBERPINV140 s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPINV140.findByBmorpcode", query = "SELECT s FROM SHBERPINV140 s WHERE s.bmorpcode = :bmorpcode"),
    @NamedQuery(name = "SHBERPINV140.findByBespdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.bespdsc = :bespdsc"),
    @NamedQuery(name = "SHBERPINV140.findByBitdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.bitdsc = :bitdsc"),
    @NamedQuery(name = "SHBERPINV140.findByEspdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.espdsc = :espdsc"),
    @NamedQuery(name = "SHBERPINV140.findByBunmsr11", query = "SELECT s FROM SHBERPINV140 s WHERE s.bunmsr11 = :bunmsr11"),
    @NamedQuery(name = "SHBERPINV140.findByCreatedate", query = "SELECT s FROM SHBERPINV140 s WHERE s.createdate = :createdate"),
    @NamedQuery(name = "SHBERPINV140.findByMorpcode", query = "SELECT s FROM SHBERPINV140 s WHERE s.morpcode = :morpcode"),
    @NamedQuery(name = "SHBERPINV140.findByEitdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.eitdsc = :eitdsc"),
    @NamedQuery(name = "SHBERPINV140.findBySpdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.spdsc = :spdsc"),
    @NamedQuery(name = "SHBERPINV140.findBySerialNumber", query = "SELECT s FROM SHBERPINV140 s WHERE s.serialNumber = :serialNumber"),
    @NamedQuery(name = "SHBERPINV140.findByBitnbr", query = "SELECT s FROM SHBERPINV140 s WHERE s.bitnbr = :bitnbr"),
    @NamedQuery(name = "SHBERPINV140.findByFvco", query = "SELECT s FROM SHBERPINV140 s WHERE s.fvco = :fvco"),
    @NamedQuery(name = "SHBERPINV140.findByBspdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.bspdsc = :bspdsc"),
    @NamedQuery(name = "SHBERPINV140.findByBitcls", query = "SELECT s FROM SHBERPINV140 s WHERE s.bitcls = :bitcls"),
    @NamedQuery(name = "SHBERPINV140.findBySpdsc2", query = "SELECT s FROM SHBERPINV140 s WHERE s.spdsc2 = :spdsc2"),
    @NamedQuery(name = "SHBERPINV140.findByItdsc2", query = "SELECT s FROM SHBERPINV140 s WHERE s.itdsc2 = :itdsc2"),
    @NamedQuery(name = "SHBERPINV140.findByApplyuser", query = "SELECT s FROM SHBERPINV140 s WHERE s.applyuser = :applyuser"),
    @NamedQuery(name = "SHBERPINV140.findByItcls", query = "SELECT s FROM SHBERPINV140 s WHERE s.itcls = :itcls"),
    @NamedQuery(name = "SHBERPINV140.findByBunmsr21", query = "SELECT s FROM SHBERPINV140 s WHERE s.bunmsr21 = :bunmsr21"),
    @NamedQuery(name = "SHBERPINV140.findByItnbr", query = "SELECT s FROM SHBERPINV140 s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "SHBERPINV140.findByHslsx", query = "SELECT s FROM SHBERPINV140 s WHERE s.hslsx = :hslsx"),
    @NamedQuery(name = "SHBERPINV140.findByDept", query = "SELECT s FROM SHBERPINV140 s WHERE s.dept = :dept"),
    @NamedQuery(name = "SHBERPINV140.findByPSN", query = "SELECT s FROM SHBERPINV140 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SHBERPINV140.findByBunmsr1", query = "SELECT s FROM SHBERPINV140 s WHERE s.bunmsr1 = :bunmsr1"),
    @NamedQuery(name = "SHBERPINV140.findByBunmsr2", query = "SELECT s FROM SHBERPINV140 s WHERE s.bunmsr2 = :bunmsr2"),
    @NamedQuery(name = "SHBERPINV140.findByRate2", query = "SELECT s FROM SHBERPINV140 s WHERE s.rate2 = :rate2"),
    @NamedQuery(name = "SHBERPINV140.findByFacno1", query = "SELECT s FROM SHBERPINV140 s WHERE s.facno1 = :facno1"),
    @NamedQuery(name = "SHBERPINV140.findByFacno2", query = "SELECT s FROM SHBERPINV140 s WHERE s.facno2 = :facno2"),
    @NamedQuery(name = "SHBERPINV140.findByBeitdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.beitdsc = :beitdsc"),
    @NamedQuery(name = "SHBERPINV140.findByUnmsr1", query = "SELECT s FROM SHBERPINV140 s WHERE s.unmsr1 = :unmsr1"),
    @NamedQuery(name = "SHBERPINV140.findByItdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "SHBERPINV140.findByUnmsr2", query = "SELECT s FROM SHBERPINV140 s WHERE s.unmsr2 = :unmsr2"),
    @NamedQuery(name = "SHBERPINV140.findByBspdsc2", query = "SELECT s FROM SHBERPINV140 s WHERE s.bspdsc2 = :bspdsc2"),
    @NamedQuery(name = "SHBERPINV140.findByUnmsr11", query = "SELECT s FROM SHBERPINV140 s WHERE s.unmsr11 = :unmsr11"),
    @NamedQuery(name = "SHBERPINV140.findByBsitdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.bsitdsc = :bsitdsc"),
    @NamedQuery(name = "SHBERPINV140.findByBclsdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.bclsdsc = :bclsdsc"),
    @NamedQuery(name = "SHBERPINV140.findByBfvco", query = "SELECT s FROM SHBERPINV140 s WHERE s.bfvco = :bfvco"),
    @NamedQuery(name = "SHBERPINV140.findByBitdsc2", query = "SELECT s FROM SHBERPINV140 s WHERE s.bitdsc2 = :bitdsc2"),
    @NamedQuery(name = "SHBERPINV140.findByUnmsr21", query = "SELECT s FROM SHBERPINV140 s WHERE s.unmsr21 = :unmsr21"),
    @NamedQuery(name = "SHBERPINV140.findByFSN", query = "SELECT s FROM SHBERPINV140 s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPINV140.findByClsdsc", query = "SELECT s FROM SHBERPINV140 s WHERE s.clsdsc = :clsdsc")})
public class SHBERPINV140 implements Serializable {

    @Size(max = 255)
    @Column(name = "printtype")
    private String printtype;
    @Size(max = 255)
    @Column(name = "lotid")
    private String lotid;
    @Size(max = 255)
    @Column(name = "getseq")
    private String getseq;
    @Size(max = 255)
    @Column(name = "producttype")
    private String producttype;
    @Size(max = 255)
    @Column(name = "deydetyn")
    private String deydetyn;
    @Size(max = 255)
    @Column(name = "compid")
    private String compid;
    @Size(max = 255)
    @Column(name = "selfprint")
    private String selfprint;
    @Size(max = 255)
    @Column(name = "wno")
    private String wno;
    @Size(max = 255)
    @Column(name = "lno")
    private String lno;
    @Size(max = 255)
    @Column(name = "level2")
    private String level2;
    @Size(max = 255)
    @Column(name = "level1")
    private String level1;
    @Column(name = "qcdatanum")
    private Integer qcdatanum;
    @Size(max = 255)
    @Column(name = "asrstype")
    private String asrstype;
    @Size(max = 255)
    @Column(name = "qcdata")
    private String qcdata;
    @Size(max = 255)
    @Column(name = "tracetype")
    private String tracetype;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "sitdsc")
    private String sitdsc;
    @Size(max = 255)
    @Column(name = "brate2")
    private String brate2;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
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
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "bunmsr1_1")
    private String bunmsr11;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "morpcode")
    private String morpcode;
    @Size(max = 255)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "bitnbr")
    private String bitnbr;
    @Size(max = 255)
    @Column(name = "fvco")
    private String fvco;
    @Size(max = 255)
    @Column(name = "bspdsc")
    private String bspdsc;
    @Size(max = 255)
    @Column(name = "bitcls")
    private String bitcls;
    @Size(max = 255)
    @Column(name = "spdsc2")
    private String spdsc2;
    @Size(max = 255)
    @Column(name = "itdsc2")
    private String itdsc2;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "bunmsr2_1")
    private String bunmsr21;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "hslsx")
    private String hslsx;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "bunmsr1")
    private String bunmsr1;
    @Size(max = 255)
    @Column(name = "bunmsr2")
    private String bunmsr2;
    @Size(max = 255)
    @Column(name = "rate2")
    private String rate2;
    @Size(max = 255)
    @Column(name = "facno1")
    private String facno1;
    @Size(max = 255)
    @Column(name = "facno2")
    private String facno2;
    @Size(max = 255)
    @Column(name = "beitdsc")
    private String beitdsc;
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
    @Column(name = "bspdsc2")
    private String bspdsc2;
    @Size(max = 255)
    @Column(name = "unmsr1_1")
    private String unmsr11;
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
    @Size(max = 255)
    @Column(name = "unmsr2_1")
    private String unmsr21;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;

    public SHBERPINV140() {
    }

    public SHBERPINV140(String oid) {
        this.oid = oid;
    }

    public String getSitdsc() {
        return sitdsc;
    }

    public void setSitdsc(String sitdsc) {
        this.sitdsc = sitdsc;
    }

    public String getBrate2() {
        return brate2;
    }

    public void setBrate2(String brate2) {
        this.brate2 = brate2;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getBunmsr11() {
        return bunmsr11;
    }

    public void setBunmsr11(String bunmsr11) {
        this.bunmsr11 = bunmsr11;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getMorpcode() {
        return morpcode;
    }

    public void setMorpcode(String morpcode) {
        this.morpcode = morpcode;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBitnbr() {
        return bitnbr;
    }

    public void setBitnbr(String bitnbr) {
        this.bitnbr = bitnbr;
    }

    public String getFvco() {
        return fvco;
    }

    public void setFvco(String fvco) {
        this.fvco = fvco;
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

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getBunmsr21() {
        return bunmsr21;
    }

    public void setBunmsr21(String bunmsr21) {
        this.bunmsr21 = bunmsr21;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getHslsx() {
        return hslsx;
    }

    public void setHslsx(String hslsx) {
        this.hslsx = hslsx;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

    public String getFacno1() {
        return facno1;
    }

    public void setFacno1(String facno1) {
        this.facno1 = facno1;
    }

    public String getFacno2() {
        return facno2;
    }

    public void setFacno2(String facno2) {
        this.facno2 = facno2;
    }

    public String getBeitdsc() {
        return beitdsc;
    }

    public void setBeitdsc(String beitdsc) {
        this.beitdsc = beitdsc;
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

    public String getBspdsc2() {
        return bspdsc2;
    }

    public void setBspdsc2(String bspdsc2) {
        this.bspdsc2 = bspdsc2;
    }

    public String getUnmsr11() {
        return unmsr11;
    }

    public void setUnmsr11(String unmsr11) {
        this.unmsr11 = unmsr11;
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

    public String getUnmsr21() {
        return unmsr21;
    }

    public void setUnmsr21(String unmsr21) {
        this.unmsr21 = unmsr21;
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
        if (!(object instanceof SHBERPINV140)) {
            return false;
        }
        SHBERPINV140 other = (SHBERPINV140) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV140[ oid=" + oid + " ]";
    }

    public String getPrinttype() {
        return printtype;
    }

    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid;
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

    public String getDeydetyn() {
        return deydetyn;
    }

    public void setDeydetyn(String deydetyn) {
        this.deydetyn = deydetyn;
    }

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
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

    public String getLno() {
        return lno;
    }

    public void setLno(String lno) {
        this.lno = lno;
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

    public Integer getQcdatanum() {
        return qcdatanum;
    }

    public void setQcdatanum(Integer qcdatanum) {
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

    public String getTracetype() {
        return tracetype;
    }

    public void setTracetype(String tracetype) {
        this.tracetype = tracetype;
    }
    
}
