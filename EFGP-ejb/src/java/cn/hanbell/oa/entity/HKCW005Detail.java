/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.crm.entity.CRMGG;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HK_CW005_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW005Detail.findAll", query = "SELECT h FROM HKCW005Detail h"),
    @NamedQuery(name = "HKCW005Detail.findByKemu", query = "SELECT h FROM HKCW005Detail h WHERE h.kemu = :kemu"),
    @NamedQuery(name = "HKCW005Detail.findByFSN", query = "SELECT h FROM HKCW005Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW005Detail.findByBeizhu", query = "SELECT h FROM HKCW005Detail h WHERE h.beizhu = :beizhu"),
    @NamedQuery(name = "HKCW005Detail.findByOID", query = "SELECT h FROM HKCW005Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW005Detail.findBySeq", query = "SELECT h FROM HKCW005Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCW005Detail.findByDeptTxt", query = "SELECT h FROM HKCW005Detail h WHERE h.deptTxt = :deptTxt"),
    @NamedQuery(name = "HKCW005Detail.findByFkje", query = "SELECT h FROM HKCW005Detail h WHERE h.fkje = :fkje"),
    @NamedQuery(name = "HKCW005Detail.findByZy", query = "SELECT h FROM HKCW005Detail h WHERE h.zy = :zy")})
public class HKCW005Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "kemu")
    private String kemu;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "beizhu")
    private String beizhu;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "dept_txt")
    private String deptTxt;
    @Size(max = 255)
    @Column(name = "fkje")
    private String fkje;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    //部门名称
    @JoinColumn(name = "dept_txt", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit dept;
    public HKCW005Detail() {
    }

    public HKCW005Detail(String oid) {
        this.oid = oid;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getDeptTxt() {
        return deptTxt;
    }

    public void setDeptTxt(String deptTxt) {
        this.deptTxt = deptTxt;
    }

    public String getFkje() {
        return fkje;
    }

    public void setFkje(String fkje) {
        this.fkje = fkje;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public OrganizationUnit getDept() {
        return dept;
    }

    public void setDept(OrganizationUnit dept) {
        this.dept = dept;
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
        if (!(object instanceof HKCW005Detail)) {
            return false;
        }
        HKCW005Detail other = (HKCW005Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW005Detail[ oid=" + oid + " ]";
    }
    
}
