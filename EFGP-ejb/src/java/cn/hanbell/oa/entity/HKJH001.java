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
 * @author C1587
 */
@Entity
@Table(name = "HK_JH001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH001.findAll", query = "SELECT h FROM HKJH001 h"),
    @NamedQuery(name = "HKJH001.findByFfpmail", query = "SELECT h FROM HKJH001 h WHERE h.ffpmail = :ffpmail"),
    @NamedQuery(name = "HKJH001.findByContractno", query = "SELECT h FROM HKJH001 h WHERE h.contractno = :contractno"),
    @NamedQuery(name = "HKJH001.findByContractaddress", query = "SELECT h FROM HKJH001 h WHERE h.contractaddress = :contractaddress"),
    @NamedQuery(name = "HKJH001.findByFfp", query = "SELECT h FROM HKJH001 h WHERE h.ffp = :ffp"),
    @NamedQuery(name = "HKJH001.findByFfpperson", query = "SELECT h FROM HKJH001 h WHERE h.ffpperson = :ffpperson"),
    @NamedQuery(name = "HKJH001.findByTp", query = "SELECT h FROM HKJH001 h WHERE h.tp = :tp"),
    @NamedQuery(name = "HKJH001.findByCapital", query = "SELECT h FROM HKJH001 h WHERE h.capital = :capital"),
    @NamedQuery(name = "HKJH001.findByTpaddress", query = "SELECT h FROM HKJH001 h WHERE h.tpaddress = :tpaddress"),
    @NamedQuery(name = "HKJH001.findByProjectaddress", query = "SELECT h FROM HKJH001 h WHERE h.projectaddress = :projectaddress"),
    @NamedQuery(name = "HKJH001.findBySpperson", query = "SELECT h FROM HKJH001 h WHERE h.spperson = :spperson"),
    @NamedQuery(name = "HKJH001.findByFfpbankno", query = "SELECT h FROM HKJH001 h WHERE h.ffpbankno = :ffpbankno"),
    @NamedQuery(name = "HKJH001.findByDept", query = "SELECT h FROM HKJH001 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKJH001.findByTpmail", query = "SELECT h FROM HKJH001 h WHERE h.tpmail = :tpmail"),
    @NamedQuery(name = "HKJH001.findByAppdate", query = "SELECT h FROM HKJH001 h WHERE h.appdate = :appdate"),
    @NamedQuery(name = "HKJH001.findByFp", query = "SELECT h FROM HKJH001 h WHERE h.fp = :fp"),
    @NamedQuery(name = "HKJH001.findBySpbank", query = "SELECT h FROM HKJH001 h WHERE h.spbank = :spbank"),
    @NamedQuery(name = "HKJH001.findByPerson3", query = "SELECT h FROM HKJH001 h WHERE h.person3 = :person3"),
    @NamedQuery(name = "HKJH001.findByPerson4", query = "SELECT h FROM HKJH001 h WHERE h.person4 = :person4"),
    @NamedQuery(name = "HKJH001.findByPerson1", query = "SELECT h FROM HKJH001 h WHERE h.person1 = :person1"),
    @NamedQuery(name = "HKJH001.findByPerson2", query = "SELECT h FROM HKJH001 h WHERE h.person2 = :person2"),
    @NamedQuery(name = "HKJH001.findBySp", query = "SELECT h FROM HKJH001 h WHERE h.sp = :sp"),
    @NamedQuery(name = "HKJH001.findByFpaddress", query = "SELECT h FROM HKJH001 h WHERE h.fpaddress = :fpaddress"),
    @NamedQuery(name = "HKJH001.findByProjectname", query = "SELECT h FROM HKJH001 h WHERE h.projectname = :projectname"),
    @NamedQuery(name = "HKJH001.findByFpphone", query = "SELECT h FROM HKJH001 h WHERE h.fpphone = :fpphone"),
    @NamedQuery(name = "HKJH001.findByContent", query = "SELECT h FROM HKJH001 h WHERE h.content = :content"),
    @NamedQuery(name = "HKJH001.findByHdnfacno", query = "SELECT h FROM HKJH001 h WHERE h.hdnfacno = :hdnfacno"),
    @NamedQuery(name = "HKJH001.findByCode2", query = "SELECT h FROM HKJH001 h WHERE h.code2 = :code2"),
    @NamedQuery(name = "HKJH001.findByTpbankno", query = "SELECT h FROM HKJH001 h WHERE h.tpbankno = :tpbankno"),
    @NamedQuery(name = "HKJH001.findByContractmoney", query = "SELECT h FROM HKJH001 h WHERE h.contractmoney = :contractmoney"),
    @NamedQuery(name = "HKJH001.findByCode1", query = "SELECT h FROM HKJH001 h WHERE h.code1 = :code1"),
    @NamedQuery(name = "HKJH001.findByCode4", query = "SELECT h FROM HKJH001 h WHERE h.code4 = :code4"),
    @NamedQuery(name = "HKJH001.findByCode3", query = "SELECT h FROM HKJH001 h WHERE h.code3 = :code3"),
    @NamedQuery(name = "HKJH001.findByEnddate", query = "SELECT h FROM HKJH001 h WHERE h.enddate = :enddate"),
    @NamedQuery(name = "HKJH001.findByBegindate", query = "SELECT h FROM HKJH001 h WHERE h.begindate = :begindate"),
    @NamedQuery(name = "HKJH001.findByFpbank", query = "SELECT h FROM HKJH001 h WHERE h.fpbank = :fpbank"),
    @NamedQuery(name = "HKJH001.findByOID", query = "SELECT h FROM HKJH001 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH001.findByIfpay", query = "SELECT h FROM HKJH001 h WHERE h.ifpay = :ifpay"),
    @NamedQuery(name = "HKJH001.findByTpphone", query = "SELECT h FROM HKJH001 h WHERE h.tpphone = :tpphone"),
    @NamedQuery(name = "HKJH001.findByFfpaddress", query = "SELECT h FROM HKJH001 h WHERE h.ffpaddress = :ffpaddress"),
    @NamedQuery(name = "HKJH001.findByTpbank", query = "SELECT h FROM HKJH001 h WHERE h.tpbank = :tpbank"),
    @NamedQuery(name = "HKJH001.findByAppuser", query = "SELECT h FROM HKJH001 h WHERE h.appuser = :appuser"),
    @NamedQuery(name = "HKJH001.findByFacno", query = "SELECT h FROM HKJH001 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKJH001.findByHiddenTextField6", query = "SELECT h FROM HKJH001 h WHERE h.hiddenTextField6 = :hiddenTextField6"),
    @NamedQuery(name = "HKJH001.findByFfpbank", query = "SELECT h FROM HKJH001 h WHERE h.ffpbank = :ffpbank"),
    @NamedQuery(name = "HKJH001.findByPaykind", query = "SELECT h FROM HKJH001 h WHERE h.paykind = :paykind"),
    @NamedQuery(name = "HKJH001.findByFpmail", query = "SELECT h FROM HKJH001 h WHERE h.fpmail = :fpmail"),
    @NamedQuery(name = "HKJH001.findByPSN", query = "SELECT h FROM HKJH001 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJH001.findByContractdate", query = "SELECT h FROM HKJH001 h WHERE h.contractdate = :contractdate"),
    @NamedQuery(name = "HKJH001.findBySpaddress", query = "SELECT h FROM HKJH001 h WHERE h.spaddress = :spaddress"),
    @NamedQuery(name = "HKJH001.findByFpbankno", query = "SELECT h FROM HKJH001 h WHERE h.fpbankno = :fpbankno"),
    @NamedQuery(name = "HKJH001.findByKind3", query = "SELECT h FROM HKJH001 h WHERE h.kind3 = :kind3"),
    @NamedQuery(name = "HKJH001.findBySpbankno", query = "SELECT h FROM HKJH001 h WHERE h.spbankno = :spbankno"),
    @NamedQuery(name = "HKJH001.findByHdnappuser", query = "SELECT h FROM HKJH001 h WHERE h.hdnappuser = :hdnappuser"),
    @NamedQuery(name = "HKJH001.findByCoin", query = "SELECT h FROM HKJH001 h WHERE h.coin = :coin"),
    @NamedQuery(name = "HKJH001.findBySpphone", query = "SELECT h FROM HKJH001 h WHERE h.spphone = :spphone"),
    @NamedQuery(name = "HKJH001.findByFfpphone", query = "SELECT h FROM HKJH001 h WHERE h.ffpphone = :ffpphone"),
    @NamedQuery(name = "HKJH001.findByContractday", query = "SELECT h FROM HKJH001 h WHERE h.contractday = :contractday"),
    @NamedQuery(name = "HKJH001.findBySpmail", query = "SELECT h FROM HKJH001 h WHERE h.spmail = :spmail"),
    @NamedQuery(name = "HKJH001.findByWarrantyyear", query = "SELECT h FROM HKJH001 h WHERE h.warrantyyear = :warrantyyear"),
    @NamedQuery(name = "HKJH001.findByAnyone", query = "SELECT h FROM HKJH001 h WHERE h.anyone = :anyone"),
    @NamedQuery(name = "HKJH001.findByTpperson", query = "SELECT h FROM HKJH001 h WHERE h.tpperson = :tpperson"),
    @NamedQuery(name = "HKJH001.findByWarrantydate", query = "SELECT h FROM HKJH001 h WHERE h.warrantydate = :warrantydate"),
    @NamedQuery(name = "HKJH001.findBySealfacno", query = "SELECT h FROM HKJH001 h WHERE h.sealfacno = :sealfacno"),
    @NamedQuery(name = "HKJH001.findByFSN", query = "SELECT h FROM HKJH001 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKJH001.findByFpperson", query = "SELECT h FROM HKJH001 h WHERE h.fpperson = :fpperson")})
public class HKJH001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "ffpmail")
    private String ffpmail;
    @Size(max = 255)
    @Column(name = "contractno")
    private String contractno;
    @Size(max = 255)
    @Column(name = "contractaddress")
    private String contractaddress;
    @Size(max = 255)
    @Column(name = "ffp")
    private String ffp;
    @Size(max = 255)
    @Column(name = "ffpperson")
    private String ffpperson;
    @Size(max = 255)
    @Column(name = "tp")
    private String tp;
    @Size(max = 255)
    @Column(name = "capital")
    private String capital;
    @Size(max = 255)
    @Column(name = "tpaddress")
    private String tpaddress;
    @Size(max = 255)
    @Column(name = "projectaddress")
    private String projectaddress;
    @Size(max = 255)
    @Column(name = "spperson")
    private String spperson;
    @Size(max = 255)
    @Column(name = "ffpbankno")
    private String ffpbankno;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "tpmail")
    private String tpmail;
    @Column(name = "appdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appdate;
    @Size(max = 255)
    @Column(name = "fp")
    private String fp;
    @Size(max = 255)
    @Column(name = "spbank")
    private String spbank;
    @Size(max = 255)
    @Column(name = "person3")
    private String person3;
    @Size(max = 255)
    @Column(name = "person4")
    private String person4;
    @Size(max = 255)
    @Column(name = "person1")
    private String person1;
    @Size(max = 255)
    @Column(name = "person2")
    private String person2;
    @Size(max = 255)
    @Column(name = "sp")
    private String sp;
    @Size(max = 255)
    @Column(name = "fpaddress")
    private String fpaddress;
    @Size(max = 255)
    @Column(name = "projectname")
    private String projectname;
    @Size(max = 255)
    @Column(name = "fpphone")
    private String fpphone;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "hdnfacno")
    private String hdnfacno;
    @Size(max = 255)
    @Column(name = "code2")
    private String code2;
    @Size(max = 255)
    @Column(name = "tpbankno")
    private String tpbankno;
    @Size(max = 255)
    @Column(name = "contractmoney")
    private String contractmoney;
    @Size(max = 255)
    @Column(name = "code1")
    private String code1;
    @Size(max = 255)
    @Column(name = "code4")
    private String code4;
    @Size(max = 255)
    @Column(name = "code3")
    private String code3;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "begindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date begindate;
    @Size(max = 255)
    @Column(name = "fpbank")
    private String fpbank;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ifpay")
    private String ifpay;
    @Size(max = 255)
    @Column(name = "tpphone")
    private String tpphone;
    @Size(max = 255)
    @Column(name = "ffpaddress")
    private String ffpaddress;
    @Size(max = 255)
    @Column(name = "tpbank")
    private String tpbank;
    @Size(max = 255)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "HiddenTextField6")
    private String hiddenTextField6;
    @Size(max = 255)
    @Column(name = "ffpbank")
    private String ffpbank;
    @Size(max = 255)
    @Column(name = "paykind")
    private String paykind;
    @Size(max = 255)
    @Column(name = "fpmail")
    private String fpmail;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "contractdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractdate;
    @Size(max = 255)
    @Column(name = "spaddress")
    private String spaddress;
    @Size(max = 255)
    @Column(name = "fpbankno")
    private String fpbankno;
    @Size(max = 255)
    @Column(name = "kind3")
    private String kind3;
    @Size(max = 255)
    @Column(name = "spbankno")
    private String spbankno;
    @Size(max = 255)
    @Column(name = "hdnappuser")
    private String hdnappuser;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "spphone")
    private String spphone;
    @Size(max = 255)
    @Column(name = "ffpphone")
    private String ffpphone;
    @Size(max = 255)
    @Column(name = "contractday")
    private String contractday;
    @Size(max = 255)
    @Column(name = "spmail")
    private String spmail;
    @Size(max = 255)
    @Column(name = "warrantyyear")
    private String warrantyyear;
    @Size(max = 255)
    @Column(name = "anyone")
    private String anyone;
    @Size(max = 255)
    @Column(name = "tpperson")
    private String tpperson;
    @Size(max = 255)
    @Column(name = "warrantydate")
    private String warrantydate;
    @Size(max = 255)
    @Column(name = "sealfacno")
    private String sealfacno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "fpperson")
    private String fpperson;

    public HKJH001() {
    }

    public HKJH001(String oid) {
        this.oid = oid;
    }

    public String getFfpmail() {
        return ffpmail;
    }

    public void setFfpmail(String ffpmail) {
        this.ffpmail = ffpmail;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getContractaddress() {
        return contractaddress;
    }

    public void setContractaddress(String contractaddress) {
        this.contractaddress = contractaddress;
    }

    public String getFfp() {
        return ffp;
    }

    public void setFfp(String ffp) {
        this.ffp = ffp;
    }

    public String getFfpperson() {
        return ffpperson;
    }

    public void setFfpperson(String ffpperson) {
        this.ffpperson = ffpperson;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getTpaddress() {
        return tpaddress;
    }

    public void setTpaddress(String tpaddress) {
        this.tpaddress = tpaddress;
    }

    public String getProjectaddress() {
        return projectaddress;
    }

    public void setProjectaddress(String projectaddress) {
        this.projectaddress = projectaddress;
    }

    public String getSpperson() {
        return spperson;
    }

    public void setSpperson(String spperson) {
        this.spperson = spperson;
    }

    public String getFfpbankno() {
        return ffpbankno;
    }

    public void setFfpbankno(String ffpbankno) {
        this.ffpbankno = ffpbankno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTpmail() {
        return tpmail;
    }

    public void setTpmail(String tpmail) {
        this.tpmail = tpmail;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }

    public String getSpbank() {
        return spbank;
    }

    public void setSpbank(String spbank) {
        this.spbank = spbank;
    }

    public String getPerson3() {
        return person3;
    }

    public void setPerson3(String person3) {
        this.person3 = person3;
    }

    public String getPerson4() {
        return person4;
    }

    public void setPerson4(String person4) {
        this.person4 = person4;
    }

    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1 = person1;
    }

    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2 = person2;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getFpaddress() {
        return fpaddress;
    }

    public void setFpaddress(String fpaddress) {
        this.fpaddress = fpaddress;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFpphone() {
        return fpphone;
    }

    public void setFpphone(String fpphone) {
        this.fpphone = fpphone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHdnfacno() {
        return hdnfacno;
    }

    public void setHdnfacno(String hdnfacno) {
        this.hdnfacno = hdnfacno;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getTpbankno() {
        return tpbankno;
    }

    public void setTpbankno(String tpbankno) {
        this.tpbankno = tpbankno;
    }

    public String getContractmoney() {
        return contractmoney;
    }

    public void setContractmoney(String contractmoney) {
        this.contractmoney = contractmoney;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode4() {
        return code4;
    }

    public void setCode4(String code4) {
        this.code4 = code4;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public String getFpbank() {
        return fpbank;
    }

    public void setFpbank(String fpbank) {
        this.fpbank = fpbank;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getIfpay() {
        return ifpay;
    }

    public void setIfpay(String ifpay) {
        this.ifpay = ifpay;
    }

    public String getTpphone() {
        return tpphone;
    }

    public void setTpphone(String tpphone) {
        this.tpphone = tpphone;
    }

    public String getFfpaddress() {
        return ffpaddress;
    }

    public void setFfpaddress(String ffpaddress) {
        this.ffpaddress = ffpaddress;
    }

    public String getTpbank() {
        return tpbank;
    }

    public void setTpbank(String tpbank) {
        this.tpbank = tpbank;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHiddenTextField6() {
        return hiddenTextField6;
    }

    public void setHiddenTextField6(String hiddenTextField6) {
        this.hiddenTextField6 = hiddenTextField6;
    }

    public String getFfpbank() {
        return ffpbank;
    }

    public void setFfpbank(String ffpbank) {
        this.ffpbank = ffpbank;
    }

    public String getPaykind() {
        return paykind;
    }

    public void setPaykind(String paykind) {
        this.paykind = paykind;
    }

    public String getFpmail() {
        return fpmail;
    }

    public void setFpmail(String fpmail) {
        this.fpmail = fpmail;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    public String getSpaddress() {
        return spaddress;
    }

    public void setSpaddress(String spaddress) {
        this.spaddress = spaddress;
    }

    public String getFpbankno() {
        return fpbankno;
    }

    public void setFpbankno(String fpbankno) {
        this.fpbankno = fpbankno;
    }

    public String getKind3() {
        return kind3;
    }

    public void setKind3(String kind3) {
        this.kind3 = kind3;
    }

    public String getSpbankno() {
        return spbankno;
    }

    public void setSpbankno(String spbankno) {
        this.spbankno = spbankno;
    }

    public String getHdnappuser() {
        return hdnappuser;
    }

    public void setHdnappuser(String hdnappuser) {
        this.hdnappuser = hdnappuser;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getSpphone() {
        return spphone;
    }

    public void setSpphone(String spphone) {
        this.spphone = spphone;
    }

    public String getFfpphone() {
        return ffpphone;
    }

    public void setFfpphone(String ffpphone) {
        this.ffpphone = ffpphone;
    }

    public String getContractday() {
        return contractday;
    }

    public void setContractday(String contractday) {
        this.contractday = contractday;
    }

    public String getSpmail() {
        return spmail;
    }

    public void setSpmail(String spmail) {
        this.spmail = spmail;
    }

    public String getWarrantyyear() {
        return warrantyyear;
    }

    public void setWarrantyyear(String warrantyyear) {
        this.warrantyyear = warrantyyear;
    }

    public String getAnyone() {
        return anyone;
    }

    public void setAnyone(String anyone) {
        this.anyone = anyone;
    }

    public String getTpperson() {
        return tpperson;
    }

    public void setTpperson(String tpperson) {
        this.tpperson = tpperson;
    }

    public String getWarrantydate() {
        return warrantydate;
    }

    public void setWarrantydate(String warrantydate) {
        this.warrantydate = warrantydate;
    }

    public String getSealfacno() {
        return sealfacno;
    }

    public void setSealfacno(String sealfacno) {
        this.sealfacno = sealfacno;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getFpperson() {
        return fpperson;
    }

    public void setFpperson(String fpperson) {
        this.fpperson = fpperson;
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
        if (!(object instanceof HKJH001)) {
            return false;
        }
        HKJH001 other = (HKJH001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH001[ oid=" + oid + " ]";
    }
    
}
