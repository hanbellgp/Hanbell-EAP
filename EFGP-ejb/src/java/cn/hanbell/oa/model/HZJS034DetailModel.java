/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class HZJS034DetailModel implements Serializable {

    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "kind")
    private String kind;
    @Size(max = 255)
    @Column(name = "morpcode")
    private String morpcode;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "unmsr1e")
    private String unmsr1e;
    @Size(max = 255)
    @Column(name = "unmsr2")
    private String unmsr2;
    @Size(max = 255)
    @Column(name = "isDUnit")
    private String isDUnit;

    @Size(max = 255)
    @Column(name = "yt")
    private String yt;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;

    @Size(max = 255)
    @Column(name = "producttype")
    private String producttype;
    @Size(max = 255)
    @Column(name = "level1")
    private String level1;
    @Size(max = 255)
    @Column(name = "level2")
    private String level2;
    @Size(max = 255)
    @Column(name = "tracetype")
    private String tracetype;
    @Size(max = 255)
    @Column(name = "lotid")
    private String lotid;
    @Size(max = 255)
    @Column(name = "compid")
    private String compid;
    @Size(max = 255)
    @Column(name = "lno")
    private String lno;
    @Size(max = 255)
    @Column(name = "wno")
    private String wno;
    @Size(max = 255)
    @Column(name = "getseq")
    private String getseq;
    @Size(max = 255)
    @Column(name = "deydetyn")
    private String deydetyn;
    @Size(max = 255)
    @Column(name = "printtype")
    private String printtype;
    @Size(max = 255)
    @Column(name = "asrstype")
    private String asrstype;
    @Size(max = 255)
    @Column(name = "selfprint")
    private String selfprint;
    @Size(max = 255)
    @Column(name = "qcdatanum")
    private String qcdatanum;
    @Size(max = 255)
    @Column(name = "qcdata")
    private String qcdata;

    @Size(max = 255)
    @Column(name = "group1")
    private String group1;
    @Size(max = 255)
    @Column(name = "group2")
    private String group2;
    @Size(max = 255)
    @Column(name = "group3")
    private String group3;
    @Size(max = 255)
    @Column(name = "group4")
    private String group4;
    @Size(max = 255)
    @Column(name = "group5")
    private String group5;
    @Size(max = 255)
    @Column(name = "group6")
    private String group6;
    @Size(max = 255)
    @Column(name = "group7")
    private String group7;
    @Size(max = 255)
    @Column(name = "group8")
    private String group8;
    @Size(max = 255)
    @Column(name = "group9")
    private String group9;
    @Size(max = 255)
    @Column(name = "group10")
    private String group10;
    @Size(max = 255)
    @Column(name = "group11")
    private String group11;
    @Size(max = 255)
    @Column(name = "group12")
    private String group12;
    @Size(max = 255)
    @Column(name = "purtrtype")
    private String purtrtype;
    @Size(max = 255)
    @Column(name = "hdgenre1")
    private String hdgenre1;
    @Size(max = 255)
    @Column(name = "jityn")
    private String jityn;
    @Size(max = 255)
    @Column(name = "itclscode")
    private String itclscode;
    @Size(max = 255)
    @Column(name = "gx")
    private String gx;
    @Size(max = 255)
    @Column(name = "rate2")
    private String rate2;

    public HZJS034DetailModel() {

        this.unmsr2 = "";
        this.producttype = "";
        this.level1 = "";
        this.level2 = "";
        this.tracetype = "";
        this.lotid = "";
        this.compid = "";
        this.lno = "";
        this.wno = "";
        this.getseq = "";
        this.deydetyn = "";
        this.printtype = "";
        this.asrstype = "";
        this.selfprint = "";
        this.qcdatanum = "";
        this.qcdata = "";
        this.group1 = "";
        this.group2 = "";
        this.group3 = "";
        this.group4 = "";
        this.group5 = "";
        this.group6 = "";
        this.group7 = "";
        this.group8 = "";
        this.group9 = "";
        this.group10 = "";
        this.group11 = "";
        this.group12 = "";
        this.gx = "N";
        this.rate2 = "";
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

    public String getClsdsc() {
        return clsdsc;
    }

    public void setClsdsc(String clsdsc) {
        this.clsdsc = clsdsc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZJS034DetailModel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZJS034DetailModel";
    }

    public String getUnmsr1e() {
        return unmsr1e;
    }

    public void setUnmsr1e(String unmsr1e) {
        this.unmsr1e = unmsr1e;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * @return the unmsr2
     */
    public String getUnmsr2() {
        return unmsr2;
    }

    /**
     * @param unmsr2 the unmsr2 to set
     */
    public void setUnmsr2(String unmsr2) {
        this.unmsr2 = unmsr2;
    }

    /**
     * @return the morpcode
     */
    public String getMorpcode() {
        return morpcode;
    }

    /**
     * @param morpcode the morpcode to set
     */
    public void setMorpcode(String morpcode) {
        this.morpcode = morpcode;
    }

    /**
     * @return the isDUnit
     */
    public String getIsDUnit() {
        return isDUnit;
    }

    /**
     * @param isDUnit the isDUnit to set
     */
    public void setIsDUnit(String isDUnit) {
        this.isDUnit = isDUnit;
    }

    /**
     * @return the yt
     */
    public String getYt() {
        return yt;
    }

    /**
     * @param yt the yt to set
     */
    public void setYt(String yt) {
        this.yt = yt;
    }

    /**
     * @return the producttype
     */
    public String getProducttype() {
        return producttype;
    }

    /**
     * @param producttype the producttype to set
     */
    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    /**
     * @return the level1
     */
    public String getLevel1() {
        return level1;
    }

    /**
     * @param level1 the level1 to set
     */
    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    /**
     * @return the level2
     */
    public String getLevel2() {
        return level2;
    }

    /**
     * @param level2 the level2 to set
     */
    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    /**
     * @return the tracetype
     */
    public String getTracetype() {
        return tracetype;
    }

    /**
     * @param tracetype the tracetype to set
     */
    public void setTracetype(String tracetype) {
        this.tracetype = tracetype;
    }

    /**
     * @return the lotid
     */
    public String getLotid() {
        return lotid;
    }

    /**
     * @param lotid the lotid to set
     */
    public void setLotid(String lotid) {
        this.lotid = lotid;
    }

    /**
     * @return the compid
     */
    public String getCompid() {
        return compid;
    }

    /**
     * @param compid the compid to set
     */
    public void setCompid(String compid) {
        this.compid = compid;
    }

    /**
     * @return the lno
     */
    public String getLno() {
        return lno;
    }

    /**
     * @param lno the lno to set
     */
    public void setLno(String lno) {
        this.lno = lno;
    }

    /**
     * @return the wno
     */
    public String getWno() {
        return wno;
    }

    /**
     * @param wno the wno to set
     */
    public void setWno(String wno) {
        this.wno = wno;
    }

    /**
     * @return the getseq
     */
    public String getGetseq() {
        return getseq;
    }

    /**
     * @param getseq the getseq to set
     */
    public void setGetseq(String getseq) {
        this.getseq = getseq;
    }

    /**
     * @return the deydetyn
     */
    public String getDeydetyn() {
        return deydetyn;
    }

    /**
     * @param deydetyn the deydetyn to set
     */
    public void setDeydetyn(String deydetyn) {
        this.deydetyn = deydetyn;
    }

    /**
     * @return the printtype
     */
    public String getPrinttype() {
        return printtype;
    }

    /**
     * @param printtype the printtype to set
     */
    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    /**
     * @return the asrstype
     */
    public String getAsrstype() {
        return asrstype;
    }

    /**
     * @param asrstype the asrstype to set
     */
    public void setAsrstype(String asrstype) {
        this.asrstype = asrstype;
    }

    /**
     * @return the selfprint
     */
    public String getSelfprint() {
        return selfprint;
    }

    /**
     * @param selfprint the selfprint to set
     */
    public void setSelfprint(String selfprint) {
        this.selfprint = selfprint;
    }

    /**
     * @return the qcdatanum
     */
    public String getQcdatanum() {
        return qcdatanum;
    }

    /**
     * @param qcdatanum the qcdatanum to set
     */
    public void setQcdatanum(String qcdatanum) {
        this.qcdatanum = qcdatanum;
    }

    /**
     * @return the qcdata
     */
    public String getQcdata() {
        return qcdata;
    }

    /**
     * @param qcdata the qcdata to set
     */
    public void setQcdata(String qcdata) {
        this.qcdata = qcdata;
    }

    /**
     * @return the group1
     */
    public String getGroup1() {
        return group1;
    }

    /**
     * @param group1 the group1 to set
     */
    public void setGroup1(String group1) {
        this.group1 = group1;
    }

    /**
     * @return the group2
     */
    public String getGroup2() {
        return group2;
    }

    /**
     * @param group2 the group2 to set
     */
    public void setGroup2(String group2) {
        this.group2 = group2;
    }

    /**
     * @return the group3
     */
    public String getGroup3() {
        return group3;
    }

    /**
     * @param group3 the group3 to set
     */
    public void setGroup3(String group3) {
        this.group3 = group3;
    }

    /**
     * @return the group4
     */
    public String getGroup4() {
        return group4;
    }

    /**
     * @param group4 the group4 to set
     */
    public void setGroup4(String group4) {
        this.group4 = group4;
    }

    /**
     * @return the group5
     */
    public String getGroup5() {
        return group5;
    }

    /**
     * @param group5 the group5 to set
     */
    public void setGroup5(String group5) {
        this.group5 = group5;
    }

    /**
     * @return the group6
     */
    public String getGroup6() {
        return group6;
    }

    /**
     * @param group6 the group6 to set
     */
    public void setGroup6(String group6) {
        this.group6 = group6;
    }

    /**
     * @return the group7
     */
    public String getGroup7() {
        return group7;
    }

    /**
     * @param group7 the group7 to set
     */
    public void setGroup7(String group7) {
        this.group7 = group7;
    }

    /**
     * @return the group8
     */
    public String getGroup8() {
        return group8;
    }

    /**
     * @param group8 the group8 to set
     */
    public void setGroup8(String group8) {
        this.group8 = group8;
    }

    /**
     * @return the group9
     */
    public String getGroup9() {
        return group9;
    }

    /**
     * @param group9 the group9 to set
     */
    public void setGroup9(String group9) {
        this.group9 = group9;
    }

    /**
     * @return the group10
     */
    public String getGroup10() {
        return group10;
    }

    /**
     * @param group10 the group10 to set
     */
    public void setGroup10(String group10) {
        this.group10 = group10;
    }

    /**
     * @return the group11
     */
    public String getGroup11() {
        return group11;
    }

    /**
     * @param group11 the group11 to set
     */
    public void setGroup11(String group11) {
        this.group11 = group11;
    }

    /**
     * @return the group12
     */
    public String getGroup12() {
        return group12;
    }

    /**
     * @param group12 the group12 to set
     */
    public void setGroup12(String group12) {
        this.group12 = group12;
    }

    /**
     * @return the purtrtype
     */
    public String getPurtrtype() {
        return purtrtype;
    }

    /**
     * @param purtrtype the purtrtype to set
     */
    public void setPurtrtype(String purtrtype) {
        this.purtrtype = purtrtype;
    }

    /**
     * @return the hdgenre1
     */
    public String getHdgenre1() {
        return hdgenre1;
    }

    /**
     * @param hdgenre1 the hdgenre1 to set
     */
    public void setHdgenre1(String hdgenre1) {
        this.hdgenre1 = hdgenre1;
    }

    /**
     * @return the jityn
     */
    public String getJityn() {
        return jityn;
    }

    /**
     * @param jityn the jityn to set
     */
    public void setJityn(String jityn) {
        this.jityn = jityn;
    }

    /**
     * @return the itclscode
     */
    public String getItclscode() {
        return itclscode;
    }

    /**
     * @param itclscode the itclscode to set
     */
    public void setItclscode(String itclscode) {
        this.itclscode = itclscode;
    }

    /**
     * @return the gx
     */
    public String getGx() {
        return gx;
    }

    /**
     * @param gx the gx to set
     */
    public void setGx(String gx) {
        this.gx = gx;
    }

    /**
     * @return the rate2
     */
    public String getRate2() {
        return rate2;
    }

    /**
     * @param rate2 the rate2 to set
     */
    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

}
