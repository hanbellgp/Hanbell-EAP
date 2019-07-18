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
 * @author C0160
 */
@Entity
@Table(name = "HK_YX007")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX007.findAll", query = "SELECT h FROM HKYX007 h")
    ,
    @NamedQuery(name = "HKYX007.findByOID", query = "SELECT h FROM HKYX007 h WHERE h.oid = :oid")
    ,
    @NamedQuery(name = "HKYX007.findByPSN", query = "SELECT h FROM HKYX007 h WHERE h.processSerialNumber = :psn")
    ,
    @NamedQuery(name = "HKYX007.findByFSN", query = "SELECT h FROM HKYX007 h WHERE h.formSerialNumber = :fsn")})
public class HKYX007 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "cuskind")
    private String cuskind;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;

    @Size(max = 255)
    @Column(name = "chkcusds")
    private String chkcusds;
    @Size(max = 255)
    @Column(name = "chkskfs")
    private String chkskfs;
    @Size(max = 255)
    @Column(name = "chkaddress")
    private String chkaddress;
    @Size(max = 255)
    @Column(name = "chkcusbakna")
    private String chkcusbakna;
    @Size(max = 255)
    @Column(name = "chkcusacctno")
    private String chkcusacctno;
    @Size(max = 255)
    @Column(name = "chkuniform")
    private String chkuniform;
    @Size(max = 255)
    @Column(name = "chkcontactman")
    private String chkcontactman;
    @Size(max = 255)
    @Column(name = "chktel1")
    private String chktel1;
    @Size(max = 255)
    @Column(name = "chkfax")
    private String chkfax;
    @Size(max = 255)
    @Column(name = "chkman")
    private String chkman;
    @Size(max = 255)
    @Column(name = "chkqt")
    private String chkqt;

    @Size(max = 255)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 255)
    @Column(name = "skfs")
    private String skfs;
    @Size(max = 255)
    @Column(name = "qtskfs")
    private String qtskfs;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "cusbakna")
    private String cusbakna;
    @Size(max = 255)
    @Column(name = "cusacctno")
    private String cusacctno;
    @Size(max = 255)
    @Column(name = "uniform")
    private String uniform;
    @Size(max = 255)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "fax")
    private String fax;
    @Size(max = 255)
    @Column(name = "man")
    private String man;
    @Size(max = 255)
    @Column(name = "qt")
    private String qt;

    @Size(max = 255)
    @Column(name = "bcusds")
    private String bcusds;
    @Size(max = 255)
    @Column(name = "bskfs")
    private String bskfs;
    @Size(max = 255)
    @Column(name = "baddress")
    private String baddress;
    @Size(max = 255)
    @Column(name = "bcusbakna")
    private String bcusbakna;
    @Size(max = 255)
    @Column(name = "bcusacctno")
    private String bcusacctno;
    @Size(max = 255)
    @Column(name = "buniform")
    private String buniform;
    @Size(max = 255)
    @Column(name = "bcontactman")
    private String bcontactman;
    @Size(max = 255)
    @Column(name = "btel1")
    private String btel1;
    @Size(max = 255)
    @Column(name = "bfax")
    private String bfax;
    @Size(max = 255)
    @Column(name = "bman")
    private String bman;
    @Size(max = 255)
    @Column(name = "bqt")
    private String bqt;
    @Size(max = 255)
    @Column(name = "explain")
    private String explain;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "cbtickdays")
    private String cbtickdays;
    @Size(max = 255)
    @Column(name = "btickdays")
    private short btickdays;
    @Size(max = 255)
    @Column(name = "tickdays")
    private short tickdays;

    public HKYX007() {
    }

    public HKYX007(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public String getBcusds() {
        return bcusds;
    }

    public void setBcusds(String bcusds) {
        this.bcusds = bcusds;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBqt() {
        return bqt;
    }

    public void setBqt(String bqt) {
        this.bqt = bqt;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getSkfs() {
        return skfs;
    }

    public void setSkfs(String skfs) {
        this.skfs = skfs;
    }

    public String getBuniform() {
        return buniform;
    }

    public void setBuniform(String buniform) {
        this.buniform = buniform;
    }

    public String getBcontactman() {
        return bcontactman;
    }

    public void setBcontactman(String bcontactman) {
        this.bcontactman = bcontactman;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getCusbakna() {
        return cusbakna;
    }

    public void setCusbakna(String cusbakna) {
        this.cusbakna = cusbakna;
    }

    public String getBcusacctno() {
        return bcusacctno;
    }

    public void setBcusacctno(String bcusacctno) {
        this.bcusacctno = bcusacctno;
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

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getBskfs() {
        return bskfs;
    }

    public void setBskfs(String bskfs) {
        this.bskfs = bskfs;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getCuskind() {
        return cuskind;
    }

    public void setCuskind(String cuskind) {
        this.cuskind = cuskind;
    }

    public String getBfax() {
        return bfax;
    }

    public void setBfax(String bfax) {
        this.bfax = bfax;
    }

    public String getBcusbakna() {
        return bcusbakna;
    }

    public void setBcusbakna(String bcusbakna) {
        this.bcusbakna = bcusbakna;
    }

    public String getQtskfs() {
        return qtskfs;
    }

    public void setQtskfs(String qtskfs) {
        this.qtskfs = qtskfs;
    }

    public String getBtel1() {
        return btel1;
    }

    public void setBtel1(String btel1) {
        this.btel1 = btel1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCusacctno() {
        return cusacctno;
    }

    public void setCusacctno(String cusacctno) {
        this.cusacctno = cusacctno;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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
        if (!(object instanceof HKYX007)) {
            return false;
        }
        HKYX007 other = (HKYX007) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX007[ oid=" + oid + " ]";
    }

    public String getBman() {
        return bman;
    }

    public void setBman(String bman) {
        this.bman = bman;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getChkman() {
        return chkman;
    }

    public void setChkman(String chkman) {
        this.chkman = chkman;
    }

    public String getChkqt() {
        return chkqt;
    }

    public void setChkqt(String chkqt) {
        this.chkqt = chkqt;
    }

    public String getChkcontactman() {
        return chkcontactman;
    }

    public void setChkcontactman(String chkcontactman) {
        this.chkcontactman = chkcontactman;
    }

    public String getChkfax() {
        return chkfax;
    }

    public void setChkfax(String chkfax) {
        this.chkfax = chkfax;
    }

    public String getChktel1() {
        return chktel1;
    }

    public void setChktel1(String chktel1) {
        this.chktel1 = chktel1;
    }

    public String getChkcusds() {
        return chkcusds;
    }

    public void setChkcusds(String chkcusds) {
        this.chkcusds = chkcusds;
    }

    public String getChkskfs() {
        return chkskfs;
    }

    public void setChkskfs(String chkskfs) {
        this.chkskfs = chkskfs;
    }

    public String getChkuniform() {
        return chkuniform;
    }

    public void setChkuniform(String chkuniform) {
        this.chkuniform = chkuniform;
    }

    public String getChkcusacctno() {
        return chkcusacctno;
    }

    public void setChkcusacctno(String chkcusacctno) {
        this.chkcusacctno = chkcusacctno;
    }

    public String getChkaddress() {
        return chkaddress;
    }

    public void setChkaddress(String chkaddress) {
        this.chkaddress = chkaddress;
    }

    public String getChkcusbakna() {
        return chkcusbakna;
    }

    public void setChkcusbakna(String chkcusbakna) {
        this.chkcusbakna = chkcusbakna;
    }

    public String getCbtickdays() {
        return cbtickdays;
    }

    public void setCbtickdays(String cbtickdays) {
        this.cbtickdays = cbtickdays;
    }

    public short getBtickdays() {
        return btickdays;
    }

    public void setBtickdays(short btickdays) {
        this.btickdays = btickdays;
    }

    public short getTickdays() {
        return tickdays;
    }

    public void setTickdays(short tickdays) {
        this.tickdays = tickdays;
    }

}
