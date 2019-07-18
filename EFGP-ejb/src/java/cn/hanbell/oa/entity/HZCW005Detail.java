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
@Table(name = "HZ_CW005_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW005Detail.findAll", query = "SELECT h FROM HZCW005Detail h"),
    @NamedQuery(name = "HZCW005Detail.findByOid", query = "SELECT h FROM HZCW005Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW005Detail.findByZy", query = "SELECT h FROM HZCW005Detail h WHERE h.zy = :zy"),
    @NamedQuery(name = "HZCW005Detail.findByFkje", query = "SELECT h FROM HZCW005Detail h WHERE h.fkje = :fkje"),
    @NamedQuery(name = "HZCW005Detail.findByNo", query = "SELECT h FROM HZCW005Detail h WHERE h.no = :no"),
    @NamedQuery(name = "HZCW005Detail.findByKemu", query = "SELECT h FROM HZCW005Detail h WHERE h.kemu = :kemu"),
    @NamedQuery(name = "HZCW005Detail.findByBeizhu", query = "SELECT h FROM HZCW005Detail h WHERE h.beizhu = :beizhu"),
    @NamedQuery(name = "HZCW005Detail.findByDept", query = "SELECT h FROM HZCW005Detail h WHERE h.dept = :dept"),
    @NamedQuery(name = "HZCW005Detail.findByFSN", query = "SELECT h FROM HZCW005Detail h WHERE h.formSerialNumber = :fsn")})
public class HZCW005Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
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
    @Column(name = "dept_txt")
    private String dept;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HZCW005Detail() {
    }

    public HZCW005Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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
        if (!(object instanceof HZCW005Detail)) {
            return false;
        }
        HZCW005Detail other = (HZCW005Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW005Detail[ oid=" + oid + " ]";
    }
    
}
