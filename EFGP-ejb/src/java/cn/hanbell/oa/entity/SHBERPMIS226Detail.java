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
 * @author C1587
 */
@Entity
@Table(name = "SHB_ERP_MIS226_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPMIS226Detail.findAll", query = "SELECT s FROM SHBERPMIS226Detail s"),
    @NamedQuery(name = "SHBERPMIS226Detail.findByOID", query = "SELECT s FROM SHBERPMIS226Detail s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPMIS226Detail.findByFSN", query = "SELECT s FROM SHBERPMIS226Detail s WHERE s.formSerialNumber = :fsn")})
public class SHBERPMIS226Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "hdn_other1")
    private String hdnOther1;
    @Size(max = 255)
    @Column(name = "hdn_other2")
    private String hdnOther2;
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
    @Column(name = "mk")
    private String mk;
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
    @Column(name = "jtcx")
    private String jtcx;
    @Size(max = 255)
    @Column(name = "hdn_jb7")
    private String hdnJb7;
    @Size(max = 255)
    @Column(name = "hdn_jb8")
    private String hdnJb8;
    @Size(max = 255)
    @Column(name = "hdn_jb5")
    private String hdnJb5;
    @Size(max = 255)
    @Column(name = "hdn_jb6")
    private String hdnJb6;
    @Size(max = 255)
    @Column(name = "hdn_jb9")
    private String hdnJb9;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "jtcxname")
    private String jtcxname;

    public SHBERPMIS226Detail() {
    }

    public SHBERPMIS226Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
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

    public String getHdnJb8() {
        return hdnJb8;
    }

    public void setHdnJb8(String hdnJb8) {
        this.hdnJb8 = hdnJb8;
    }

    public String getHdnJb5() {
        return hdnJb5;
    }

    public void setHdnJb5(String hdnJb5) {
        this.hdnJb5 = hdnJb5;
    }

    public String getHdnJb6() {
        return hdnJb6;
    }

    public void setHdnJb6(String hdnJb6) {
        this.hdnJb6 = hdnJb6;
    }

    public String getHdnJb9() {
        return hdnJb9;
    }

    public void setHdnJb9(String hdnJb9) {
        this.hdnJb9 = hdnJb9;
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
        if (!(object instanceof SHBERPMIS226Detail)) {
            return false;
        }
        SHBERPMIS226Detail other = (SHBERPMIS226Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPMIS226Detail[ oid=" + oid + " ]";
    }

}
