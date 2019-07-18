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
@Table(name = "HZ_JS034")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZJS034.findAll", query = "SELECT h FROM HZJS034 h"),
    @NamedQuery(name = "HZJS034.findByOid", query = "SELECT h FROM HZJS034 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZJS034.findByPrinttype", query = "SELECT h FROM HZJS034 h WHERE h.printtype = :printtype"),
    @NamedQuery(name = "HZJS034.findByLno", query = "SELECT h FROM HZJS034 h WHERE h.lno = :lno"),
    @NamedQuery(name = "HZJS034.findByRemark", query = "SELECT h FROM HZJS034 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HZJS034.findByEspdsc", query = "SELECT h FROM HZJS034 h WHERE h.espdsc = :espdsc"),
    @NamedQuery(name = "HZJS034.findByLotid", query = "SELECT h FROM HZJS034 h WHERE h.lotid = :lotid"),
    @NamedQuery(name = "HZJS034.findByMorpcode", query = "SELECT h FROM HZJS034 h WHERE h.morpcode = :morpcode"),
    @NamedQuery(name = "HZJS034.findByFacno", query = "SELECT h FROM HZJS034 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HZJS034.findByEitdsc", query = "SELECT h FROM HZJS034 h WHERE h.eitdsc = :eitdsc"),
    @NamedQuery(name = "HZJS034.findByKind", query = "SELECT h FROM HZJS034 h WHERE h.kind = :kind"),
    @NamedQuery(name = "HZJS034.findBySpdsc", query = "SELECT h FROM HZJS034 h WHERE h.spdsc = :spdsc"),
    @NamedQuery(name = "HZJS034.findByLevel2", query = "SELECT h FROM HZJS034 h WHERE h.level2 = :level2"),
    @NamedQuery(name = "HZJS034.findByIndate", query = "SELECT h FROM HZJS034 h WHERE h.indate = :indate"),
    @NamedQuery(name = "HZJS034.findByLevel1", query = "SELECT h FROM HZJS034 h WHERE h.level1 = :level1"),
    @NamedQuery(name = "HZJS034.findByItcls", query = "SELECT h FROM HZJS034 h WHERE h.itcls = :itcls"),
    @NamedQuery(name = "HZJS034.findByItnbr", query = "SELECT h FROM HZJS034 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HZJS034.findByGetseq", query = "SELECT h FROM HZJS034 h WHERE h.getseq = :getseq"),
    @NamedQuery(name = "HZJS034.findByDept", query = "SELECT h FROM HZJS034 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HZJS034.findByPSN", query = "SELECT h FROM HZJS034 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZJS034.findByProducttype", query = "SELECT h FROM HZJS034 h WHERE h.producttype = :producttype"),
    @NamedQuery(name = "HZJS034.findByIsDUnit", query = "SELECT h FROM HZJS034 h WHERE h.isDUnit = :isDUnit"),
    @NamedQuery(name = "HZJS034.findByEmpl", query = "SELECT h FROM HZJS034 h WHERE h.empl = :empl"),
    @NamedQuery(name = "HZJS034.findByQcdatanum", query = "SELECT h FROM HZJS034 h WHERE h.qcdatanum = :qcdatanum"),
    @NamedQuery(name = "HZJS034.findByAsrstype", query = "SELECT h FROM HZJS034 h WHERE h.asrstype = :asrstype"),
    @NamedQuery(name = "HZJS034.findByDeydetyn", query = "SELECT h FROM HZJS034 h WHERE h.deydetyn = :deydetyn"),
    @NamedQuery(name = "HZJS034.findByQcdata", query = "SELECT h FROM HZJS034 h WHERE h.qcdata = :qcdata"),
    @NamedQuery(name = "HZJS034.findByCompid", query = "SELECT h FROM HZJS034 h WHERE h.compid = :compid"),
    @NamedQuery(name = "HZJS034.findByUnmsr1", query = "SELECT h FROM HZJS034 h WHERE h.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HZJS034.findByItdsc", query = "SELECT h FROM HZJS034 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HZJS034.findByUnmsr2", query = "SELECT h FROM HZJS034 h WHERE h.unmsr2 = :unmsr2"),
    @NamedQuery(name = "HZJS034.findByTracetype", query = "SELECT h FROM HZJS034 h WHERE h.tracetype = :tracetype"),
    @NamedQuery(name = "HZJS034.findByYt", query = "SELECT h FROM HZJS034 h WHERE h.yt = :yt"),
    @NamedQuery(name = "HZJS034.findBySelfprint", query = "SELECT h FROM HZJS034 h WHERE h.selfprint = :selfprint"),
    @NamedQuery(name = "HZJS034.findByWno", query = "SELECT h FROM HZJS034 h WHERE h.wno = :wno"),
    @NamedQuery(name = "HZJS034.findByChkteshu", query = "SELECT h FROM HZJS034 h WHERE h.chkteshu = :chkteshu"),
    @NamedQuery(name = "HZJS034.findByFormSerialNumber", query = "SELECT h FROM HZJS034 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZJS034.findByClsdsc", query = "SELECT h FROM HZJS034 h WHERE h.clsdsc = :clsdsc")})
public class HZJS034 implements Serializable {

    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "gx")
    private String gx;

    @Size(max = 255)
    @Column(name = "lblGroup1")
    private String lblGroup1;
    @Size(max = 255)
    @Column(name = "lblGroup2")
    private String lblGroup2;
    @Size(max = 255)
    @Column(name = "lblGroup3")
    private String lblGroup3;
    @Size(max = 255)
    @Column(name = "lblGroup4")
    private String lblGroup4;
    @Size(max = 255)
    @Column(name = "lblGroup5")
    private String lblGroup5;
    @Size(max = 255)
    @Column(name = "lblGroup6")
    private String lblGroup6;
    @Size(max = 255)
    @Column(name = "lblGroup7")
    private String lblGroup7;
    @Size(max = 255)
    @Column(name = "lblGroup8")
    private String lblGroup8;
    @Size(max = 255)
    @Column(name = "lblGroup9")
    private String lblGroup9;
    @Size(max = 255)
    @Column(name = "unmsr1e")
    private String unmsr1e;
    @Size(max = 255)
    @Column(name = "genre1")
    private String genre1;
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
    @Column(name = "lblGroup12")
    private String lblGroup12;
    @Size(max = 255)
    @Column(name = "group6")
    private String group6;
    @Size(max = 255)
    @Column(name = "lblGroup11")
    private String lblGroup11;
    @Size(max = 255)
    @Column(name = "group3")
    private String group3;
    @Size(max = 255)
    @Column(name = "lblGroup10")
    private String lblGroup10;
    @Size(max = 255)
    @Column(name = "group4")
    private String group4;
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
    @Column(name = "txtItnbrcode")
    private String txtItnbrcode;
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
    @Column(name = "facno")
    private String facno;
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
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
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
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "producttype")
    private String producttype;
    @Size(max = 255)
    @Column(name = "isDUnit")
    private String isDUnit;
    @Size(max = 255)
    @Column(name = "empl")
    private String empl;
    @Column(name = "qcdatanum")
    private Integer qcdatanum;
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
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr2")
    private String unmsr2;
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
    @Column(name = "chkteshu")
    private String chkteshu;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;

    public HZJS034() {
    }

    public HZJS034(String oid) {
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

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
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

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
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

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getIsDUnit() {
        return isDUnit;
    }

    public void setIsDUnit(String isDUnit) {
        this.isDUnit = isDUnit;
    }

    public String getEmpl() {
        return empl;
    }

    public void setEmpl(String empl) {
        this.empl = empl;
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

    public String getChkteshu() {
        return chkteshu;
    }

    public void setChkteshu(String chkteshu) {
        this.chkteshu = chkteshu;
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
        if (!(object instanceof HZJS034)) {
            return false;
        }
        HZJS034 other = (HZJS034) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZJS034[ oid=" + oid + " ]";
    }

    public String getLblGroup1() {
        return lblGroup1;
    }

    public void setLblGroup1(String lblGroup1) {
        this.lblGroup1 = lblGroup1;
    }

    public String getLblGroup2() {
        return lblGroup2;
    }

    public void setLblGroup2(String lblGroup2) {
        this.lblGroup2 = lblGroup2;
    }

    public String getLblGroup3() {
        return lblGroup3;
    }

    public void setLblGroup3(String lblGroup3) {
        this.lblGroup3 = lblGroup3;
    }

    public String getLblGroup4() {
        return lblGroup4;
    }

    public void setLblGroup4(String lblGroup4) {
        this.lblGroup4 = lblGroup4;
    }

    public String getLblGroup5() {
        return lblGroup5;
    }

    public void setLblGroup5(String lblGroup5) {
        this.lblGroup5 = lblGroup5;
    }

    public String getLblGroup6() {
        return lblGroup6;
    }

    public void setLblGroup6(String lblGroup6) {
        this.lblGroup6 = lblGroup6;
    }

    public String getLblGroup7() {
        return lblGroup7;
    }

    public void setLblGroup7(String lblGroup7) {
        this.lblGroup7 = lblGroup7;
    }

    public String getLblGroup8() {
        return lblGroup8;
    }

    public void setLblGroup8(String lblGroup8) {
        this.lblGroup8 = lblGroup8;
    }

    public String getLblGroup9() {
        return lblGroup9;
    }

    public void setLblGroup9(String lblGroup9) {
        this.lblGroup9 = lblGroup9;
    }

    public String getUnmsr1e() {
        return unmsr1e;
    }

    public void setUnmsr1e(String unmsr1e) {
        this.unmsr1e = unmsr1e;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
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

    public String getLblGroup12() {
        return lblGroup12;
    }

    public void setLblGroup12(String lblGroup12) {
        this.lblGroup12 = lblGroup12;
    }

    public String getGroup6() {
        return group6;
    }

    public void setGroup6(String group6) {
        this.group6 = group6;
    }

    public String getLblGroup11() {
        return lblGroup11;
    }

    public void setLblGroup11(String lblGroup11) {
        this.lblGroup11 = lblGroup11;
    }

    public String getGroup3() {
        return group3;
    }

    public void setGroup3(String group3) {
        this.group3 = group3;
    }

    public String getLblGroup10() {
        return lblGroup10;
    }

    public void setLblGroup10(String lblGroup10) {
        this.lblGroup10 = lblGroup10;
    }

    public String getGroup4() {
        return group4;
    }

    public void setGroup4(String group4) {
        this.group4 = group4;
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

    public String getTxtItnbrcode() {
        return txtItnbrcode;
    }

    public void setTxtItnbrcode(String txtItnbrcode) {
        this.txtItnbrcode = txtItnbrcode;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getGx() {
        return gx;
    }

    public void setGx(String gx) {
        this.gx = gx;
    }
    
}
