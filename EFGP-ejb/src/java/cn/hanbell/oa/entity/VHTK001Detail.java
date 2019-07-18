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
@Table(name = "VH_TK001_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTK001Detail.findAll", query = "SELECT v FROM VHTK001Detail v"),
    @NamedQuery(name = "VHTK001Detail.findByOid", query = "SELECT v FROM VHTK001Detail v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHTK001Detail.findByJityn", query = "SELECT v FROM VHTK001Detail v WHERE v.jityn = :jityn"),
    @NamedQuery(name = "VHTK001Detail.findByEspdsc", query = "SELECT v FROM VHTK001Detail v WHERE v.espdsc = :espdsc"),
    @NamedQuery(name = "VHTK001Detail.findByMorpcode", query = "SELECT v FROM VHTK001Detail v WHERE v.morpcode = :morpcode"),
    @NamedQuery(name = "VHTK001Detail.findByEitdsc", query = "SELECT v FROM VHTK001Detail v WHERE v.eitdsc = :eitdsc"),
    @NamedQuery(name = "VHTK001Detail.findByKind", query = "SELECT v FROM VHTK001Detail v WHERE v.kind = :kind"),
    @NamedQuery(name = "VHTK001Detail.findBySpdsc", query = "SELECT v FROM VHTK001Detail v WHERE v.spdsc = :spdsc"),
    @NamedQuery(name = "VHTK001Detail.findByItcls", query = "SELECT v FROM VHTK001Detail v WHERE v.itcls = :itcls"),
    @NamedQuery(name = "VHTK001Detail.findByBarcode", query = "SELECT v FROM VHTK001Detail v WHERE v.barcode = :barcode"),
    @NamedQuery(name = "VHTK001Detail.findByUnmsr1", query = "SELECT v FROM VHTK001Detail v WHERE v.unmsr1 = :unmsr1"),
    @NamedQuery(name = "VHTK001Detail.findByItdsc", query = "SELECT v FROM VHTK001Detail v WHERE v.itdsc = :itdsc"),
    @NamedQuery(name = "VHTK001Detail.findByItclscode", query = "SELECT v FROM VHTK001Detail v WHERE v.itclscode = :itclscode"),
    @NamedQuery(name = "VHTK001Detail.findByFSN", query = "SELECT v FROM VHTK001Detail v WHERE v.formSerialNumber = :fsn"),
    @NamedQuery(name = "VHTK001Detail.findByClsdsc", query = "SELECT v FROM VHTK001Detail v WHERE v.clsdsc = :clsdsc")})
public class VHTK001Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "jityn")
    private String jityn;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
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
    @Column(name = "hdgenre1")
    private String hdgenre1;
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
    @Column(name = "itcls")
    private String itcls;
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
    @Column(name = "itnbr")
    private String itnbr;
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
    @Column(name = "isDUnit")
    private String isDUnit;
    @Size(max = 255)
    @Column(name = "group11")
    private String group11;
    @Size(max = 255)
    @Column(name = "group10")
    private String group10;
    @Size(max = 255)
    @Column(name = "rate2")
    private String rate2;
    @Size(max = 255)
    @Column(name = "gx")
    private String gx;
    @Size(max = 255)
    @Column(name = "purtrtype")
    private String purtrtype;
    @Size(max = 255)
    @Column(name = "barcode")
    private String barcode;
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
    @Column(name = "yt")
    private String yt;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itclscode")
    private String itclscode;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;

    public VHTK001Detail() {
    }

    public VHTK001Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getJityn() {
        return jityn;
    }

    public void setJityn(String jityn) {
        this.jityn = jityn;
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

    public String getHdgenre1() {
        return hdgenre1;
    }

    public void setHdgenre1(String hdgenre1) {
        this.hdgenre1 = hdgenre1;
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

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
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

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
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

    public String getIsDUnit() {
        return isDUnit;
    }

    public void setIsDUnit(String isDUnit) {
        this.isDUnit = isDUnit;
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

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

    public String getGx() {
        return gx;
    }

    public void setGx(String gx) {
        this.gx = gx;
    }

    public String getPurtrtype() {
        return purtrtype;
    }

    public void setPurtrtype(String purtrtype) {
        this.purtrtype = purtrtype;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItclscode() {
        return itclscode;
    }

    public void setItclscode(String itclscode) {
        this.itclscode = itclscode;
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
        if (!(object instanceof VHTK001Detail)) {
            return false;
        }
        VHTK001Detail other = (VHTK001Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTK001Detail[ oid=" + oid + " ]";
    }
    
}
