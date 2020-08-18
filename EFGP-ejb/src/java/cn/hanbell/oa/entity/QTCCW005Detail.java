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
 * @author C2082
 */
@Entity
@Table(name = "QTC_CW005_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QTCCW005Detail.findAll", query = "SELECT q FROM QTCCW005Detail q"),
    @NamedQuery(name = "QTCCW005Detail.findByOid", query = "SELECT q FROM QTCCW005Detail q WHERE q.oid = :oid"),
    @NamedQuery(name = "QTCCW005Detail.findByDeptTxt", query = "SELECT q FROM QTCCW005Detail q WHERE q.deptTxt = :deptTxt"),
    @NamedQuery(name = "QTCCW005Detail.findByZy", query = "SELECT q FROM QTCCW005Detail q WHERE q.zy = :zy"),
    @NamedQuery(name = "QTCCW005Detail.findByFkje", query = "SELECT q FROM QTCCW005Detail q WHERE q.fkje = :fkje"),
    @NamedQuery(name = "QTCCW005Detail.findByNo", query = "SELECT q FROM QTCCW005Detail q WHERE q.no = :no"),
    @NamedQuery(name = "QTCCW005Detail.findByKemu", query = "SELECT q FROM QTCCW005Detail q WHERE q.kemu = :kemu"),
    @NamedQuery(name = "QTCCW005Detail.findByBeizhu", query = "SELECT q FROM QTCCW005Detail q WHERE q.beizhu = :beizhu"),
    @NamedQuery(name = "QTCCW005Detail.findByFSN", query = "SELECT q FROM QTCCW005Detail q WHERE q.formSerialNumber = :fsn"),
    @NamedQuery(name = "QTCCW005Detail.findBySeq", query = "SELECT q FROM QTCCW005Detail q WHERE q.seq = :seq")})
public class QTCCW005Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "dept_txt")
    private String deptTxt;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    @Size(max = 255)
    @Column(name = "fkje")
    private String fkje;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "kemu")
    private String kemu;
    @Size(max = 255)
    @Column(name = "beizhu")
    private String beizhu;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    public QTCCW005Detail() {
    }

    public QTCCW005Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDeptTxt() {
        return deptTxt;
    }

    public void setDeptTxt(String deptTxt) {
        this.deptTxt = deptTxt;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getFkje() {
        return fkje;
    }

    public void setFkje(String fkje) {
        this.fkje = fkje;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof QTCCW005Detail)) {
            return false;
        }
        QTCCW005Detail other = (QTCCW005Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.QTCCW005Detail[ oid=" + oid + " ]";
    }
    
}
