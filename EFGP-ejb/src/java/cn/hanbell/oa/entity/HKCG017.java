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
 * @author C1368
 */
@Entity
@Table(name = "HK_CG017")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG017.findAll", query = "SELECT h FROM HKCG017 h"),
    @NamedQuery(name = "HKCG017.findByAlse", query = "SELECT h FROM HKCG017 h WHERE h.alse = :alse"),
    @NamedQuery(name = "HKCG017.findByOid", query = "SELECT h FROM HKCG017 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCG017.findByTtbankna", query = "SELECT h FROM HKCG017 h WHERE h.ttbankna = :ttbankna"),
    @NamedQuery(name = "HKCG017.findByBfkfs1", query = "SELECT h FROM HKCG017 h WHERE h.bfkfs1 = :bfkfs1"),
    @NamedQuery(name = "HKCG017.findByReason", query = "SELECT h FROM HKCG017 h WHERE h.reason = :reason"),
    @NamedQuery(name = "HKCG017.findByBaddress", query = "SELECT h FROM HKCG017 h WHERE h.baddress = :baddress"),
    @NamedQuery(name = "HKCG017.findByVdrna", query = "SELECT h FROM HKCG017 h WHERE h.vdrna = :vdrna"),
    @NamedQuery(name = "HKCG017.findByContactman", query = "SELECT h FROM HKCG017 h WHERE h.contactman = :contactman"),
    @NamedQuery(name = "HKCG017.findByFktype", query = "SELECT h FROM HKCG017 h WHERE h.fktype = :fktype"),
    @NamedQuery(name = "HKCG017.findByFacno", query = "SELECT h FROM HKCG017 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCG017.findByBfkfs", query = "SELECT h FROM HKCG017 h WHERE h.bfkfs = :bfkfs"),
    @NamedQuery(name = "HKCG017.findByTel1", query = "SELECT h FROM HKCG017 h WHERE h.tel1 = :tel1"),
    @NamedQuery(name = "HKCG017.findByBfax1", query = "SELECT h FROM HKCG017 h WHERE h.bfax1 = :bfax1"),
    @NamedQuery(name = "HKCG017.findBySerialNumber", query = "SELECT h FROM HKCG017 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCG017.findByTtbankno", query = "SELECT h FROM HKCG017 h WHERE h.ttbankno = :ttbankno"),
    @NamedQuery(name = "HKCG017.findByTel2", query = "SELECT h FROM HKCG017 h WHERE h.tel2 = :tel2"),
    @NamedQuery(name = "HKCG017.findByVdrds", query = "SELECT h FROM HKCG017 h WHERE h.vdrds = :vdrds"),
    @NamedQuery(name = "HKCG017.findByBuniform", query = "SELECT h FROM HKCG017 h WHERE h.buniform = :buniform"),
    @NamedQuery(name = "HKCG017.findByBcontactman", query = "SELECT h FROM HKCG017 h WHERE h.bcontactman = :bcontactman"),
    @NamedQuery(name = "HKCG017.findByApplyuser", query = "SELECT h FROM HKCG017 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKCG017.findByFax1", query = "SELECT h FROM HKCG017 h WHERE h.fax1 = :fax1"),
    @NamedQuery(name = "HKCG017.findByDept", query = "SELECT h FROM HKCG017 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKCG017.findByPSN", query = "SELECT h FROM HKCG017 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCG017.findByVdrd", query = "SELECT h FROM HKCG017 h WHERE h.vdrd = :vdrd"),
    @NamedQuery(name = "HKCG017.findByBvdrds1", query = "SELECT h FROM HKCG017 h WHERE h.bvdrds1 = :bvdrds1"),
    @NamedQuery(name = "HKCG017.findByUniform", query = "SELECT h FROM HKCG017 h WHERE h.uniform = :uniform"),
    @NamedQuery(name = "HKCG017.findByBttbankno", query = "SELECT h FROM HKCG017 h WHERE h.bttbankno = :bttbankno"),
    @NamedQuery(name = "HKCG017.findByBvdrds", query = "SELECT h FROM HKCG017 h WHERE h.bvdrds = :bvdrds"),
    @NamedQuery(name = "HKCG017.findByBtel1", query = "SELECT h FROM HKCG017 h WHERE h.btel1 = :btel1"),
    @NamedQuery(name = "HKCG017.findByCheckbox10", query = "SELECT h FROM HKCG017 h WHERE h.checkbox10 = :checkbox10"),
    @NamedQuery(name = "HKCG017.findByBtel2", query = "SELECT h FROM HKCG017 h WHERE h.btel2 = :btel2"),
    @NamedQuery(name = "HKCG017.findByCheckbox11", query = "SELECT h FROM HKCG017 h WHERE h.checkbox11 = :checkbox11"),
    @NamedQuery(name = "HKCG017.findByTtbanknum", query = "SELECT h FROM HKCG017 h WHERE h.ttbanknum = :ttbanknum"),
    @NamedQuery(name = "HKCG017.findByCheckbox14", query = "SELECT h FROM HKCG017 h WHERE h.checkbox14 = :checkbox14"),
    @NamedQuery(name = "HKCG017.findByAddress", query = "SELECT h FROM HKCG017 h WHERE h.address = :address"),
    @NamedQuery(name = "HKCG017.findByCheckbox15", query = "SELECT h FROM HKCG017 h WHERE h.checkbox15 = :checkbox15"),
    @NamedQuery(name = "HKCG017.findByCheckbox12", query = "SELECT h FROM HKCG017 h WHERE h.checkbox12 = :checkbox12"),
    @NamedQuery(name = "HKCG017.findByCheckbox13", query = "SELECT h FROM HKCG017 h WHERE h.checkbox13 = :checkbox13"),
    @NamedQuery(name = "HKCG017.findByFkfs", query = "SELECT h FROM HKCG017 h WHERE h.fkfs = :fkfs"),
    @NamedQuery(name = "HKCG017.findByBttbanknum", query = "SELECT h FROM HKCG017 h WHERE h.bttbanknum = :bttbanknum"),
    @NamedQuery(name = "HKCG017.findByCheckbox18", query = "SELECT h FROM HKCG017 h WHERE h.checkbox18 = :checkbox18"),
    @NamedQuery(name = "HKCG017.findByBelse", query = "SELECT h FROM HKCG017 h WHERE h.belse = :belse"),
    @NamedQuery(name = "HKCG017.findByPurkind", query = "SELECT h FROM HKCG017 h WHERE h.purkind = :purkind"),
    @NamedQuery(name = "HKCG017.findByCheckbox16", query = "SELECT h FROM HKCG017 h WHERE h.checkbox16 = :checkbox16"),
    @NamedQuery(name = "HKCG017.findByCheckbox17", query = "SELECT h FROM HKCG017 h WHERE h.checkbox17 = :checkbox17"),
    @NamedQuery(name = "HKCG017.findByBfktype", query = "SELECT h FROM HKCG017 h WHERE h.bfktype = :bfktype"),
    @NamedQuery(name = "HKCG017.findByVdrno", query = "SELECT h FROM HKCG017 h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HKCG017.findByFSN", query = "SELECT h FROM HKCG017 h WHERE h.formSerialNumber = :fsn")})
public class HKCG017 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "alse")
    private String alse;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ttbankna")
    private String ttbankna;
    @Size(max = 255)
    @Column(name = "bfkfs1")
    private String bfkfs1;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "baddress")
    private String baddress;
    @Size(max = 255)
    @Column(name = "vdrna")
    private String vdrna;
    @Size(max = 255)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 255)
    @Column(name = "fktype")
    private String fktype;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "bfkfs")
    private String bfkfs;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "bfax1")
    private String bfax1;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "ttbankno")
    private String ttbankno;
    @Size(max = 255)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 255)
    @Column(name = "vdrds")
    private String vdrds;
    @Size(max = 255)
    @Column(name = "buniform")
    private String buniform;
    @Size(max = 255)
    @Column(name = "bcontactman")
    private String bcontactman;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "fax1")
    private String fax1;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "vdrd")
    private String vdrd;
    @Size(max = 255)
    @Column(name = "bvdrds1")
    private String bvdrds1;
    @Size(max = 255)
    @Column(name = "uniform")
    private String uniform;
    @Size(max = 255)
    @Column(name = "bttbankno")
    private String bttbankno;
    @Size(max = 255)
    @Column(name = "bvdrds")
    private String bvdrds;
    @Size(max = 255)
    @Column(name = "btel1")
    private String btel1;
    @Size(max = 255)
    @Column(name = "Checkbox10")
    private String checkbox10;
    @Size(max = 255)
    @Column(name = "btel2")
    private String btel2;
    @Size(max = 255)
    @Column(name = "Checkbox11")
    private String checkbox11;
    @Size(max = 255)
    @Column(name = "ttbanknum")
    private String ttbanknum;
    @Size(max = 255)
    @Column(name = "Checkbox14")
    private String checkbox14;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "Checkbox15")
    private String checkbox15;
    @Size(max = 255)
    @Column(name = "Checkbox12")
    private String checkbox12;
    @Size(max = 255)
    @Column(name = "Checkbox13")
    private String checkbox13;
    @Size(max = 255)
    @Column(name = "fkfs")
    private String fkfs;
    @Size(max = 255)
    @Column(name = "bttbanknum")
    private String bttbanknum;
    @Size(max = 255)
    @Column(name = "Checkbox18")
    private String checkbox18;
    @Size(max = 255)
    @Column(name = "Checkbox19")
    private String checkbox19;
    @Size(max = 255)
    @Column(name = "belse")
    private String belse;
    @Size(max = 255)
    @Column(name = "vdrsta")
    private String vdrsta;
    @Size(max = 255)
    @Column(name = "purkind")
    private String purkind;
    @Size(max = 255)
    @Column(name = "Checkbox16")
    private String checkbox16;
    @Size(max = 255)
    @Column(name = "Checkbox17")
    private String checkbox17;
    @Size(max = 255)
    @Column(name = "bfktype")
    private String bfktype;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
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
    @Size(max = 10)
    @Column(name = "chkpaycode")
    private String chkpaycode;
    @Size(max = 10)
    @Column(name = "paycode")
    private String paycode;
    @Size(max = 255)
    @Column(name = "CheckTax")
    private String checktax;
    @Size(max = 10)
    @Column(name = "tax")
    private String tax;
    @Size(max = 255)
    @Column(name = "CheckTaxrate")
    private String checktaxrate;
    @Size(max = 10)
    @Column(name = "taxrate")
    private String taxrate;

    public HKCG017() {
    }

    public HKCG017(String oid) {
        this.oid = oid;
    }

    public String getAlse() {
        return alse;
    }

    public void setAlse(String alse) {
        this.alse = alse;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTtbankna() {
        return ttbankna;
    }

    public void setTtbankna(String ttbankna) {
        this.ttbankna = ttbankna;
    }

    public String getBfkfs1() {
        return bfkfs1;
    }

    public void setBfkfs1(String bfkfs1) {
        this.bfkfs1 = bfkfs1;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getFktype() {
        return fktype;
    }

    public void setFktype(String fktype) {
        this.fktype = fktype;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBfkfs() {
        return bfkfs;
    }

    public void setBfkfs(String bfkfs) {
        this.bfkfs = bfkfs;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getBfax1() {
        return bfax1;
    }

    public void setBfax1(String bfax1) {
        this.bfax1 = bfax1;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTtbankno() {
        return ttbankno;
    }

    public void setTtbankno(String ttbankno) {
        this.ttbankno = ttbankno;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getVdrds() {
        return vdrds;
    }

    public void setVdrds(String vdrds) {
        this.vdrds = vdrds;
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

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
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

    public String getVdrd() {
        return vdrd;
    }

    public void setVdrd(String vdrd) {
        this.vdrd = vdrd;
    }

    public String getBvdrds1() {
        return bvdrds1;
    }

    public void setBvdrds1(String bvdrds1) {
        this.bvdrds1 = bvdrds1;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getBttbankno() {
        return bttbankno;
    }

    public void setBttbankno(String bttbankno) {
        this.bttbankno = bttbankno;
    }

    public String getBvdrds() {
        return bvdrds;
    }

    public void setBvdrds(String bvdrds) {
        this.bvdrds = bvdrds;
    }

    public String getBtel1() {
        return btel1;
    }

    public void setBtel1(String btel1) {
        this.btel1 = btel1;
    }

    public String getCheckbox10() {
        return checkbox10;
    }

    public void setCheckbox10(String checkbox10) {
        this.checkbox10 = checkbox10;
    }

    public String getBtel2() {
        return btel2;
    }

    public void setBtel2(String btel2) {
        this.btel2 = btel2;
    }

    public String getCheckbox11() {
        return checkbox11;
    }

    public void setCheckbox11(String checkbox11) {
        this.checkbox11 = checkbox11;
    }

    public String getTtbanknum() {
        return ttbanknum;
    }

    public void setTtbanknum(String ttbanknum) {
        this.ttbanknum = ttbanknum;
    }

    public String getCheckbox14() {
        return checkbox14;
    }

    public void setCheckbox14(String checkbox14) {
        this.checkbox14 = checkbox14;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckbox15() {
        return checkbox15;
    }

    public void setCheckbox15(String checkbox15) {
        this.checkbox15 = checkbox15;
    }

    public String getCheckbox12() {
        return checkbox12;
    }

    public void setCheckbox12(String checkbox12) {
        this.checkbox12 = checkbox12;
    }

    public String getCheckbox13() {
        return checkbox13;
    }

    public void setCheckbox13(String checkbox13) {
        this.checkbox13 = checkbox13;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    public String getBttbanknum() {
        return bttbanknum;
    }

    public void setBttbanknum(String bttbanknum) {
        this.bttbanknum = bttbanknum;
    }

    public String getCheckbox18() {
        return checkbox18;
    }

    public void setCheckbox18(String checkbox18) {
        this.checkbox18 = checkbox18;
    }

    public String getBelse() {
        return belse;
    }

    public void setBelse(String belse) {
        this.belse = belse;
    }

    public String getPurkind() {
        return purkind;
    }

    public void setPurkind(String purkind) {
        this.purkind = purkind;
    }

    public String getCheckbox16() {
        return checkbox16;
    }

    public void setCheckbox16(String checkbox16) {
        this.checkbox16 = checkbox16;
    }

    public String getCheckbox17() {
        return checkbox17;
    }

    public void setCheckbox17(String checkbox17) {
        this.checkbox17 = checkbox17;
    }

    public String getBfktype() {
        return bfktype;
    }

    public void setBfktype(String bfktype) {
        this.bfktype = bfktype;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
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
        if (!(object instanceof HKCG017)) {
            return false;
        }
        HKCG017 other = (HKCG017) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG017[ oid=" + oid + " ]";
    }

    public String getCbtickdays() {
        return cbtickdays;
    }

    public void setCbtickdays(String cbtickdays) {
        this.cbtickdays = cbtickdays;
    }

    public short getTickdays() {
        return tickdays;
    }

    public void setTickdays(short tickdays) {
        this.tickdays = tickdays;
    }

    public short getBtickdays() {
        return btickdays;
    }

    public void setBtickdays(short btickdays) {
        this.btickdays = btickdays;
    }

    public String getChkpaycode() {
        return chkpaycode;
    }

    public void setChkpaycode(String chkpaycode) {
        this.chkpaycode = chkpaycode;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode;
    }

    public String getCheckbox19() {
        return checkbox19;
    }

    public void setCheckbox19(String checkbox19) {
        this.checkbox19 = checkbox19;
    }

    public String getVdrsta() {
        return vdrsta;
    }

    public void setVdrsta(String vdrsta) {
        this.vdrsta = vdrsta;
    }

    public String getChecktax() {
        return checktax;
    }

    public void setChecktax(String checktax) {
        this.checktax = checktax;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getChecktaxrate() {
        return checktaxrate;
    }

    public void setChecktaxrate(String checktaxrate) {
        this.checktaxrate = checktaxrate;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

}
