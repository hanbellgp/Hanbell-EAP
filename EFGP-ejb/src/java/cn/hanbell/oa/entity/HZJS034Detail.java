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
@Table(name = "HZ_JS034_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZJS034Detail.findAll", query = "SELECT h FROM HZJS034Detail h"),
    @NamedQuery(name = "HZJS034Detail.findByOid", query = "SELECT h FROM HZJS034Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZJS034Detail.findByPrinttype", query = "SELECT h FROM HZJS034Detail h WHERE h.printtype = :printtype"),
    @NamedQuery(name = "HZJS034Detail.findByLno", query = "SELECT h FROM HZJS034Detail h WHERE h.lno = :lno"),
    @NamedQuery(name = "HZJS034Detail.findByRemark", query = "SELECT h FROM HZJS034Detail h WHERE h.remark = :remark"),
    @NamedQuery(name = "HZJS034Detail.findByEspdsc", query = "SELECT h FROM HZJS034Detail h WHERE h.espdsc = :espdsc"),
    @NamedQuery(name = "HZJS034Detail.findByLotid", query = "SELECT h FROM HZJS034Detail h WHERE h.lotid = :lotid"),
    @NamedQuery(name = "HZJS034Detail.findByMorpcode", query = "SELECT h FROM HZJS034Detail h WHERE h.morpcode = :morpcode"),
    @NamedQuery(name = "HZJS034Detail.findByEitdsc", query = "SELECT h FROM HZJS034Detail h WHERE h.eitdsc = :eitdsc"),
    @NamedQuery(name = "HZJS034Detail.findByKind", query = "SELECT h FROM HZJS034Detail h WHERE h.kind = :kind"),
    @NamedQuery(name = "HZJS034Detail.findBySpdsc", query = "SELECT h FROM HZJS034Detail h WHERE h.spdsc = :spdsc"),
    @NamedQuery(name = "HZJS034Detail.findByLevel2", query = "SELECT h FROM HZJS034Detail h WHERE h.level2 = :level2"),
    @NamedQuery(name = "HZJS034Detail.findByLevel1", query = "SELECT h FROM HZJS034Detail h WHERE h.level1 = :level1"),
    @NamedQuery(name = "HZJS034Detail.findByItcls", query = "SELECT h FROM HZJS034Detail h WHERE h.itcls = :itcls"),
    @NamedQuery(name = "HZJS034Detail.findByItnbr", query = "SELECT h FROM HZJS034Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HZJS034Detail.findByGetseq", query = "SELECT h FROM HZJS034Detail h WHERE h.getseq = :getseq"),
    @NamedQuery(name = "HZJS034Detail.findByProducttype", query = "SELECT h FROM HZJS034Detail h WHERE h.producttype = :producttype"),
    @NamedQuery(name = "HZJS034Detail.findByQcdatanum", query = "SELECT h FROM HZJS034Detail h WHERE h.qcdatanum = :qcdatanum"),
    @NamedQuery(name = "HZJS034Detail.findByAsrstype", query = "SELECT h FROM HZJS034Detail h WHERE h.asrstype = :asrstype"),
    @NamedQuery(name = "HZJS034Detail.findByDeydetyn", query = "SELECT h FROM HZJS034Detail h WHERE h.deydetyn = :deydetyn"),
    @NamedQuery(name = "HZJS034Detail.findByQcdata", query = "SELECT h FROM HZJS034Detail h WHERE h.qcdata = :qcdata"),
    @NamedQuery(name = "HZJS034Detail.findByCompid", query = "SELECT h FROM HZJS034Detail h WHERE h.compid = :compid"),
    @NamedQuery(name = "HZJS034Detail.findByUnmsr1", query = "SELECT h FROM HZJS034Detail h WHERE h.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HZJS034Detail.findByItdsc", query = "SELECT h FROM HZJS034Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HZJS034Detail.findByTracetype", query = "SELECT h FROM HZJS034Detail h WHERE h.tracetype = :tracetype"),
    @NamedQuery(name = "HZJS034Detail.findByYt", query = "SELECT h FROM HZJS034Detail h WHERE h.yt = :yt"),
    @NamedQuery(name = "HZJS034Detail.findBySelfprint", query = "SELECT h FROM HZJS034Detail h WHERE h.selfprint = :selfprint"),
    @NamedQuery(name = "HZJS034Detail.findByWno", query = "SELECT h FROM HZJS034Detail h WHERE h.wno = :wno"),
    @NamedQuery(name = "HZJS034Detail.findByFSN", query = "SELECT h FROM HZJS034Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZJS034Detail.findByClsdsc", query = "SELECT h FROM HZJS034Detail h WHERE h.clsdsc = :clsdsc")})
public class HZJS034Detail implements Serializable {

    @Size(max = 255)
    @Column(name = "rate2")
    private String rate2;
    @Size(max = 255)
    @Column(name = "gx")
    private String gx;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    @Size(max = 255)
    @Column(name = "isDUnit")
    private String isDUnit;
    @Size(max = 255)
    @Column(name = "group9")
    private String group9;
    @Size(max = 255)
    @Column(name = "group7")
    private String group7;
    @Size(max = 255)
    @Column(name = "group8")
    private String group8;
    @Size(max = 255)
    @Column(name = "group5")
    private String group5;
    @Size(max = 255)
    @Column(name = "group6")
    private String group6;
    @Size(max = 255)
    @Column(name = "group3")
    private String group3;
    @Size(max = 255)
    @Column(name = "group4")
    private String group4;
    @Size(max = 255)
    @Column(name = "unmsr1e")
    private String unmsr1e;
    @Size(max = 255)
    @Column(name = "group12")
    private String group12;
    @Size(max = 255)
    @Column(name = "group1")
    private String group1;
    @Size(max = 255)
    @Column(name = "group2")
    private String group2;
    @Size(max = 255)
    @Column(name = "group11")
    private String group11;
    @Size(max = 255)
    @Column(name = "group10")
    private String group10;
    @Size(max = 255)
    @Column(name = "purtrtype")
    private String purtrtype;
    @Size(max = 255)
    @Column(name = "hdgenre1")
    private String hdgenre1;
    @Size(max = 255)
    @Column(name = "itclscode")
    private String itclscode;
    @Size(max = 255)
    @Column(name = "jityn")
    private String jityn;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "printtype")
    private String printtype;
    @Size(max = 255)
    @Column(name = "lno")
    private String lno;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "lotid")
    private String lotid;
    @Size(max = 255)
    @Column(name = "morpcode")
    private String morpcode;
    @Size(max = 255)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 255)
    @Column(name = "kind")
    private String kind;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "level2")
    private String level2;
    @Size(max = 255)
    @Column(name = "level1")
    private String level1;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
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
    @Column(name = "deydetyn")
    private String deydetyn;
    @Size(max = 255)
    @Column(name = "qcdata")
    private String qcdata;
    @Size(max = 255)
    @Column(name = "compid")
    private String compid;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "unmsr2")
    private String unmsr2;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "tracetype")
    private String tracetype;
    @Size(max = 255)
    @Column(name = "yt")
    private String yt;
    @Size(max = 255)
    @Column(name = "selfprint")
    private String selfprint;
    @Size(max = 255)
    @Column(name = "wno")
    private String wno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;

    public HZJS034Detail() {
    }

    public HZJS034Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
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

    public String getDeydetyn() {
        return deydetyn;
    }

    public void setDeydetyn(String deydetyn) {
        this.deydetyn = deydetyn;
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

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getUnmsr2() {
        return unmsr2;
    }

    public void setUnmsr2(String unmsr2) {
        this.unmsr2 = unmsr2;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getTracetype() {
        return tracetype;
    }

    public void setTracetype(String tracetype) {
        this.tracetype = tracetype;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
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
        if (!(object instanceof HZJS034Detail)) {
            return false;
        }
        HZJS034Detail other = (HZJS034Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZJS034Detail[ oid=" + oid + " ]";
    }

    public String getIsDUnit() {
        return isDUnit;
    }

    public void setIsDUnit(String isDUnit) {
        this.isDUnit = isDUnit;
    }

    public String getGroup9() {
        return group9;
    }

    public void setGroup9(String group9) {
        this.group9 = group9;
    }

    public String getGroup7() {
        return group7;
    }

    public void setGroup7(String group7) {
        this.group7 = group7;
    }

    public String getGroup8() {
        return group8;
    }

    public void setGroup8(String group8) {
        this.group8 = group8;
    }

    public String getGroup5() {
        return group5;
    }

    public void setGroup5(String group5) {
        this.group5 = group5;
    }

    public String getGroup6() {
        return group6;
    }

    public void setGroup6(String group6) {
        this.group6 = group6;
    }

    public String getGroup3() {
        return group3;
    }

    public void setGroup3(String group3) {
        this.group3 = group3;
    }

    public String getGroup4() {
        return group4;
    }

    public void setGroup4(String group4) {
        this.group4 = group4;
    }

    public String getUnmsr1e() {
        return unmsr1e;
    }

    public void setUnmsr1e(String unmsr1e) {
        this.unmsr1e = unmsr1e;
    }

    public String getGroup12() {
        return group12;
    }

    public void setGroup12(String group12) {
        this.group12 = group12;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }

    public String getGroup2() {
        return group2;
    }

    public void setGroup2(String group2) {
        this.group2 = group2;
    }

    public String getGroup11() {
        return group11;
    }

    public void setGroup11(String group11) {
        this.group11 = group11;
    }

    public String getGroup10() {
        return group10;
    }

    public void setGroup10(String group10) {
        this.group10 = group10;
    }

    public String getPurtrtype() {
        return purtrtype;
    }

    public void setPurtrtype(String purtrtype) {
        this.purtrtype = purtrtype;
    }

    public String getHdgenre1() {
        return hdgenre1;
    }

    public void setHdgenre1(String hdgenre1) {
        this.hdgenre1 = hdgenre1;
    }

    public String getItclscode() {
        return itclscode;
    }

    public void setItclscode(String itclscode) {
        this.itclscode = itclscode;
    }

    public String getJityn() {
        return jityn;
    }

    public void setJityn(String jityn) {
        this.jityn = jityn;
    }

    public String getGx() {
        return gx;
    }

    public void setGx(String gx) {
        this.gx = gx;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

}
