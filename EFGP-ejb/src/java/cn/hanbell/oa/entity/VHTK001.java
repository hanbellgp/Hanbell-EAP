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
@Table(name = "VH_TK001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTK001.findAll", query = "SELECT v FROM VHTK001 v"),
    @NamedQuery(name = "VHTK001.findByEitdsc", query = "SELECT v FROM VHTK001 v WHERE v.eitdsc = :eitdsc"),
    @NamedQuery(name = "VHTK001.findBySpdsc", query = "SELECT v FROM VHTK001 v WHERE v.spdsc = :spdsc"),
    @NamedQuery(name = "VHTK001.findBySerialNumber", query = "SELECT v FROM VHTK001 v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "VHTK001.findByItcls", query = "SELECT v FROM VHTK001 v WHERE v.itcls = :itcls"),
    @NamedQuery(name = "VHTK001.findByDept", query = "SELECT v FROM VHTK001 v WHERE v.dept = :dept"),
    @NamedQuery(name = "VHTK001.findByUnmsr1e", query = "SELECT v FROM VHTK001 v WHERE v.unmsr1e = :unmsr1e"),
    @NamedQuery(name = "VHTK001.findByBarcode", query = "SELECT v FROM VHTK001 v WHERE v.barcode = :barcode"),
    @NamedQuery(name = "VHTK001.findByClsdsc", query = "SELECT v FROM VHTK001 v WHERE v.clsdsc = :clsdsc"),
    @NamedQuery(name = "VHTK001.findByEspdsc", query = "SELECT v FROM VHTK001 v WHERE v.espdsc = :espdsc"),
    @NamedQuery(name = "VHTK001.findByMorpcode", query = "SELECT v FROM VHTK001 v WHERE v.morpcode = :morpcode"),
    @NamedQuery(name = "VHTK001.findByFacno", query = "SELECT v FROM VHTK001 v WHERE v.facno = :facno"),
    @NamedQuery(name = "VHTK001.findByIndate", query = "SELECT v FROM VHTK001 v WHERE v.indate = :indate"),
    @NamedQuery(name = "VHTK001.findByItnbr", query = "SELECT v FROM VHTK001 v WHERE v.itnbr = :itnbr"),
    @NamedQuery(name = "VHTK001.findByGroup4", query = "SELECT v FROM VHTK001 v WHERE v.group4 = :group4"),
    @NamedQuery(name = "VHTK001.findByPSN", query = "SELECT v FROM VHTK001 v WHERE v.processSerialNumber = :psn"),
    @NamedQuery(name = "VHTK001.findByEmpl", query = "SELECT v FROM VHTK001 v WHERE v.empl = :empl"),
    @NamedQuery(name = "VHTK001.findByItdsc", query = "SELECT v FROM VHTK001 v WHERE v.itdsc = :itdsc"),
    @NamedQuery(name = "VHTK001.findByFSN", query = "SELECT v FROM VHTK001 v WHERE v.formSerialNumber = :fsn")})
public class VHTK001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "lblGroup1")
    private String lblGroup1;
    @Size(max = 255)
    @Column(name = "lblGroup2")
    private String lblGroup2;
    @Size(max = 255)
    @Column(name = "hdnchkteshu")
    private String hdnchkteshu;
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
    @Column(name = "remark")
    private String remark;
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
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "hdgenre1")
    private String hdgenre1;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "lblGroup9")
    private String lblGroup9;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "unmsr1e")
    private String unmsr1e;
    @Size(max = 255)
    @Column(name = "isDUnit")
    private String isDUnit;
    @Size(max = 255)
    @Column(name = "genre1")
    private String genre1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate2")
    private Double rate2;
    @Size(max = 255)
    @Column(name = "gx")
    private String gx;
    @Size(max = 255)
    @Column(name = "hdngenre1")
    private String hdngenre1;
    @Size(max = 255)
    @Column(name = "barcode")
    private String barcode;
    @Size(max = 255)
    @Column(name = "itclscode")
    private String itclscode;
    @Size(max = 255)
    @Column(name = "hdnappDept")
    private String hdnappDept;
    @Size(max = 255)
    @Column(name = "chkteshu")
    private String chkteshu;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "hdnappUser")
    private String hdnappUser;
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
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "kind")
    private String kind;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 4000)
    @Column(name = "TextArea1")
    private String textArea1;
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
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "group4")
    private String group4;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
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
    @Column(name = "empl")
    private String empl;
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
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr2")
    private String unmsr2;
    @Size(max = 255)
    @Column(name = "txtItnbrcode")
    private String txtItnbrcode;
    @Size(max = 255)
    @Column(name = "yt")
    private String yt;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public VHTK001() {
    }

    public VHTK001(String oid) {
        this.oid = oid;
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

    public String getHdnchkteshu() {
        return hdnchkteshu;
    }

    public void setHdnchkteshu(String hdnchkteshu) {
        this.hdnchkteshu = hdnchkteshu;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getHdgenre1() {
        return hdgenre1;
    }

    public void setHdgenre1(String hdgenre1) {
        this.hdgenre1 = hdgenre1;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getLblGroup9() {
        return lblGroup9;
    }

    public void setLblGroup9(String lblGroup9) {
        this.lblGroup9 = lblGroup9;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getUnmsr1e() {
        return unmsr1e;
    }

    public void setUnmsr1e(String unmsr1e) {
        this.unmsr1e = unmsr1e;
    }

    public String getIsDUnit() {
        return isDUnit;
    }

    public void setIsDUnit(String isDUnit) {
        this.isDUnit = isDUnit;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public Double getRate2() {
        return rate2;
    }

    public void setRate2(Double rate2) {
        this.rate2 = rate2;
    }

    public String getGx() {
        return gx;
    }

    public void setGx(String gx) {
        this.gx = gx;
    }

    public String getHdngenre1() {
        return hdngenre1;
    }

    public void setHdngenre1(String hdngenre1) {
        this.hdngenre1 = hdngenre1;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getItclscode() {
        return itclscode;
    }

    public void setItclscode(String itclscode) {
        this.itclscode = itclscode;
    }

    public String getHdnappDept() {
        return hdnappDept;
    }

    public void setHdnappDept(String hdnappDept) {
        this.hdnappDept = hdnappDept;
    }

    public String getChkteshu() {
        return chkteshu;
    }

    public void setChkteshu(String chkteshu) {
        this.chkteshu = chkteshu;
    }

    public String getClsdsc() {
        return clsdsc;
    }

    public void setClsdsc(String clsdsc) {
        this.clsdsc = clsdsc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getHdnappUser() {
        return hdnappUser;
    }

    public void setHdnappUser(String hdnappUser) {
        this.hdnappUser = hdnappUser;
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

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(String textArea1) {
        this.textArea1 = textArea1;
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

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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

    public String getEmpl() {
        return empl;
    }

    public void setEmpl(String empl) {
        this.empl = empl;
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

    public String getTxtItnbrcode() {
        return txtItnbrcode;
    }

    public void setTxtItnbrcode(String txtItnbrcode) {
        this.txtItnbrcode = txtItnbrcode;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
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
        if (!(object instanceof VHTK001)) {
            return false;
        }
        VHTK001 other = (VHTK001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTK001[ oid=" + oid + " ]";
    }
    
}
