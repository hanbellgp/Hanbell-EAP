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
@Table(name = "SHB_ERP_MIS226")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPMIS226.findAll", query = "SELECT s FROM SHBERPMIS226 s")
    ,
    @NamedQuery(name = "SHBERPMIS226.findBySerialNumber", query = "SELECT s FROM SHBERPMIS226 s WHERE s.serialNumber = :serialNumber")
    ,
    @NamedQuery(name = "SHBERPMIS226.findByDept", query = "SELECT s FROM SHBERPMIS226 s WHERE s.dept = :dept")
    ,
    @NamedQuery(name = "SHBERPMIS226.findByOID", query = "SELECT s FROM SHBERPMIS226 s WHERE s.oid = :oid")
    ,
    @NamedQuery(name = "SHBERPMIS226.findByFacno", query = "SELECT s FROM SHBERPMIS226 s WHERE s.facno = :facno")
    ,
    @NamedQuery(name = "SHBERPMIS226.findByApplyuser", query = "SELECT s FROM SHBERPMIS226 s WHERE s.applyuser = :applyuser")
    ,
    @NamedQuery(name = "SHBERPMIS226.findByPSN", query = "SELECT s FROM SHBERPMIS226 s WHERE s.processSerialNumber = :psn")
    ,
    @NamedQuery(name = "SHBERPMIS226.findByFSN", query = "SELECT s FROM SHBERPMIS226 s WHERE s.formSerialNumber = :fsn")})
public class SHBERPMIS226 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "hdn_other1")
    private String hdnOther1;
    @Size(max = 255)
    @Column(name = "hdn_other2")
    private String hdnOther2;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "jb8")
    private String jb8;
    @Size(max = 255)
    @Column(name = "jb9")
    private String jb9;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdn_other4")
    private String hdnOther4;
    @Size(max = 255)
    @Column(name = "hdn_jb12")
    private String hdnJb12;
    @Size(max = 255)
    @Column(name = "hdn_other3")
    private String hdnOther3;
    @Size(max = 255)
    @Column(name = "hdn_jb13")
    private String hdnJb13;
    @Size(max = 255)
    @Column(name = "hdn_other6")
    private String hdnOther6;
    @Size(max = 255)
    @Column(name = "hdn_jb10")
    private String hdnJb10;
    @Size(max = 255)
    @Column(name = "hdn_other5")
    private String hdnOther5;
    @Size(max = 255)
    @Column(name = "hdn_jb11")
    private String hdnJb11;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "hdn_other8")
    private String hdnOther8;
    @Size(max = 255)
    @Column(name = "hdn_other7")
    private String hdnOther7;
    @Size(max = 255)
    @Column(name = "hdn_other9")
    private String hdnOther9;
    @Size(max = 255)
    @Column(name = "hdn_jb4")
    private String hdnJb4;
    @Size(max = 255)
    @Column(name = "hdn_jb3")
    private String hdnJb3;
    @Size(max = 255)
    @Column(name = "hdn_jb2")
    private String hdnJb2;
    @Size(max = 255)
    @Column(name = "hdn_jb1")
    private String hdnJb1;
    @Size(max = 255)
    @Column(name = "cx")
    private String cx;
    @Size(max = 255)
    @Column(name = "cxname")
    private String cxname;
    @Size(max = 255)
    @Column(name = "t4")
    private String t4;
    @Size(max = 255)
    @Column(name = "jtcx")
    private String jtcx;
    @Size(max = 255)
    @Column(name = "hdn_jb7")
    private String hdnJb7;
    @Size(max = 255)
    @Column(name = "t5")
    private String t5;
    @Size(max = 255)
    @Column(name = "hdn_jb8")
    private String hdnJb8;
    @Size(max = 255)
    @Column(name = "t6")
    private String t6;
    @Size(max = 255)
    @Column(name = "hdn_jb5")
    private String hdnJb5;
    @Size(max = 255)
    @Column(name = "t7")
    private String t7;
    @Size(max = 255)
    @Column(name = "hdn_jb6")
    private String hdnJb6;
    @Size(max = 255)
    @Column(name = "t8")
    private String t8;
    @Size(max = 255)
    @Column(name = "t9")
    private String t9;
    @Size(max = 255)
    @Column(name = "hdn_jb9")
    private String hdnJb9;
    @Size(max = 255)
    @Column(name = "t3")
    private String t3;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "t2")
    private String t2;
    @Size(max = 255)
    @Column(name = "t1")
    private String t1;
    @Size(max = 255)
    @Column(name = "jb4")
    private String jb4;
    @Size(max = 255)
    @Column(name = "jb5")
    private String jb5;
    @Size(max = 255)
    @Column(name = "jb6")
    private String jb6;
    @Size(max = 255)
    @Column(name = "jb7")
    private String jb7;
    @Size(max = 255)
    @Column(name = "jb1")
    private String jb1;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "jb2")
    private String jb2;
    @Size(max = 255)
    @Column(name = "jb3")
    private String jb3;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "mk")
    private String mk;
    @Size(max = 255)
    @Column(name = "other4")
    private String other4;
    @Size(max = 255)
    @Column(name = "other5")
    private String other5;
    @Size(max = 255)
    @Column(name = "other6")
    private String other6;
    @Size(max = 255)
    @Column(name = "other7")
    private String other7;
    @Size(max = 255)
    @Column(name = "other1")
    private String other1;
    @Size(max = 255)
    @Column(name = "other2")
    private String other2;
    @Size(max = 255)
    @Column(name = "jb10")
    private String jb10;
    @Size(max = 255)
    @Column(name = "other3")
    private String other3;
    @Size(max = 255)
    @Column(name = "jb12")
    private String jb12;
    @Size(max = 255)
    @Column(name = "jb11")
    private String jb11;
    @Size(max = 255)
    @Column(name = "jb13")
    private String jb13;
    @Size(max = 255)
    @Column(name = "other8")
    private String other8;
    @Size(max = 255)
    @Column(name = "other9")
    private String other9;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "jtcxname")
    private String jtcxname;
    @Size(max = 10)
    @Column(name = "gtype")
    private String gtype;

    public SHBERPMIS226() {
    }

    public SHBERPMIS226(String oid) {
        this.oid = oid;
    }

    public String getHdnOther1() {
        return hdnOther1;
    }

    public void setHdnOther1(String hdnOther1) {
        this.hdnOther1 = hdnOther1;
    }

    public String getHdnOther2() {
        return hdnOther2;
    }

    public void setHdnOther2(String hdnOther2) {
        this.hdnOther2 = hdnOther2;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getJb8() {
        return jb8;
    }

    public void setJb8(String jb8) {
        this.jb8 = jb8;
    }

    public String getJb9() {
        return jb9;
    }

    public void setJb9(String jb9) {
        this.jb9 = jb9;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnOther4() {
        return hdnOther4;
    }

    public void setHdnOther4(String hdnOther4) {
        this.hdnOther4 = hdnOther4;
    }

    public String getHdnJb12() {
        return hdnJb12;
    }

    public void setHdnJb12(String hdnJb12) {
        this.hdnJb12 = hdnJb12;
    }

    public String getHdnOther3() {
        return hdnOther3;
    }

    public void setHdnOther3(String hdnOther3) {
        this.hdnOther3 = hdnOther3;
    }

    public String getHdnJb13() {
        return hdnJb13;
    }

    public void setHdnJb13(String hdnJb13) {
        this.hdnJb13 = hdnJb13;
    }

    public String getHdnOther6() {
        return hdnOther6;
    }

    public void setHdnOther6(String hdnOther6) {
        this.hdnOther6 = hdnOther6;
    }

    public String getHdnJb10() {
        return hdnJb10;
    }

    public void setHdnJb10(String hdnJb10) {
        this.hdnJb10 = hdnJb10;
    }

    public String getHdnOther5() {
        return hdnOther5;
    }

    public void setHdnOther5(String hdnOther5) {
        this.hdnOther5 = hdnOther5;
    }

    public String getHdnJb11() {
        return hdnJb11;
    }

    public void setHdnJb11(String hdnJb11) {
        this.hdnJb11 = hdnJb11;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getHdnOther8() {
        return hdnOther8;
    }

    public void setHdnOther8(String hdnOther8) {
        this.hdnOther8 = hdnOther8;
    }

    public String getHdnOther7() {
        return hdnOther7;
    }

    public void setHdnOther7(String hdnOther7) {
        this.hdnOther7 = hdnOther7;
    }

    public String getHdnOther9() {
        return hdnOther9;
    }

    public void setHdnOther9(String hdnOther9) {
        this.hdnOther9 = hdnOther9;
    }

    public String getHdnJb4() {
        return hdnJb4;
    }

    public void setHdnJb4(String hdnJb4) {
        this.hdnJb4 = hdnJb4;
    }

    public String getHdnJb3() {
        return hdnJb3;
    }

    public void setHdnJb3(String hdnJb3) {
        this.hdnJb3 = hdnJb3;
    }

    public String getHdnJb2() {
        return hdnJb2;
    }

    public void setHdnJb2(String hdnJb2) {
        this.hdnJb2 = hdnJb2;
    }

    public String getHdnJb1() {
        return hdnJb1;
    }

    public void setHdnJb1(String hdnJb1) {
        this.hdnJb1 = hdnJb1;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getCxname() {
        return cxname;
    }

    public void setCxname(String cxname) {
        this.cxname = cxname;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String getJtcx() {
        return jtcx;
    }

    public void setJtcx(String jtcx) {
        this.jtcx = jtcx;
    }

    public String getHdnJb7() {
        return hdnJb7;
    }

    public void setHdnJb7(String hdnJb7) {
        this.hdnJb7 = hdnJb7;
    }

    public String getT5() {
        return t5;
    }

    public void setT5(String t5) {
        this.t5 = t5;
    }

    public String getHdnJb8() {
        return hdnJb8;
    }

    public void setHdnJb8(String hdnJb8) {
        this.hdnJb8 = hdnJb8;
    }

    public String getT6() {
        return t6;
    }

    public void setT6(String t6) {
        this.t6 = t6;
    }

    public String getHdnJb5() {
        return hdnJb5;
    }

    public void setHdnJb5(String hdnJb5) {
        this.hdnJb5 = hdnJb5;
    }

    public String getT7() {
        return t7;
    }

    public void setT7(String t7) {
        this.t7 = t7;
    }

    public String getHdnJb6() {
        return hdnJb6;
    }

    public void setHdnJb6(String hdnJb6) {
        this.hdnJb6 = hdnJb6;
    }

    public String getT8() {
        return t8;
    }

    public void setT8(String t8) {
        this.t8 = t8;
    }

    public String getT9() {
        return t9;
    }

    public void setT9(String t9) {
        this.t9 = t9;
    }

    public String getHdnJb9() {
        return hdnJb9;
    }

    public void setHdnJb9(String hdnJb9) {
        this.hdnJb9 = hdnJb9;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getJb4() {
        return jb4;
    }

    public void setJb4(String jb4) {
        this.jb4 = jb4;
    }

    public String getJb5() {
        return jb5;
    }

    public void setJb5(String jb5) {
        this.jb5 = jb5;
    }

    public String getJb6() {
        return jb6;
    }

    public void setJb6(String jb6) {
        this.jb6 = jb6;
    }

    public String getJb7() {
        return jb7;
    }

    public void setJb7(String jb7) {
        this.jb7 = jb7;
    }

    public String getJb1() {
        return jb1;
    }

    public void setJb1(String jb1) {
        this.jb1 = jb1;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getJb2() {
        return jb2;
    }

    public void setJb2(String jb2) {
        this.jb2 = jb2;
    }

    public String getJb3() {
        return jb3;
    }

    public void setJb3(String jb3) {
        this.jb3 = jb3;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    public String getOther7() {
        return other7;
    }

    public void setOther7(String other7) {
        this.other7 = other7;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getJb10() {
        return jb10;
    }

    public void setJb10(String jb10) {
        this.jb10 = jb10;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getJb12() {
        return jb12;
    }

    public void setJb12(String jb12) {
        this.jb12 = jb12;
    }

    public String getJb11() {
        return jb11;
    }

    public void setJb11(String jb11) {
        this.jb11 = jb11;
    }

    public String getJb13() {
        return jb13;
    }

    public void setJb13(String jb13) {
        this.jb13 = jb13;
    }

    public String getOther8() {
        return other8;
    }

    public void setOther8(String other8) {
        this.other8 = other8;
    }

    public String getOther9() {
        return other9;
    }

    public void setOther9(String other9) {
        this.other9 = other9;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getJtcxname() {
        return jtcxname;
    }

    public void setJtcxname(String jtcxname) {
        this.jtcxname = jtcxname;
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
        if (!(object instanceof SHBERPMIS226)) {
            return false;
        }
        SHBERPMIS226 other = (SHBERPMIS226) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPMIS226[ oid=" + oid + " ]";
    }

    /**
     * @return the gtype
     */
    public String getGtype() {
        return gtype;
    }

    /**
     * @param gtype the gtype to set
     */
    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

}
