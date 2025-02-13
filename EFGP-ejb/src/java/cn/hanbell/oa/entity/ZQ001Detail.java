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
@Table(name = "ZQ001_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZQ001Detail.findAll", query = "SELECT z FROM ZQ001Detail z"),
    @NamedQuery(name = "ZQ001Detail.findByInstitution", query = "SELECT z FROM ZQ001Detail z WHERE z.institution = :institution"),
    @NamedQuery(name = "ZQ001Detail.findByReceptionStaff", query = "SELECT z FROM ZQ001Detail z WHERE z.receptionStaff = :receptionStaff"),
    @NamedQuery(name = "ZQ001Detail.findByOtherMethod", query = "SELECT z FROM ZQ001Detail z WHERE z.otherMethod = :otherMethod"),
    @NamedQuery(name = "ZQ001Detail.findByFileno", query = "SELECT z FROM ZQ001Detail z WHERE z.fileno = :fileno"),
    @NamedQuery(name = "ZQ001Detail.findByResearchTime", query = "SELECT z FROM ZQ001Detail z WHERE z.researchTime = :researchTime"),
    @NamedQuery(name = "ZQ001Detail.findByAddress1", query = "SELECT z FROM ZQ001Detail z WHERE z.address1 = :address1"),
    @NamedQuery(name = "ZQ001Detail.findByFSN", query = "SELECT z FROM ZQ001Detail z WHERE z.formSerialNumber = :fsn"),
    @NamedQuery(name = "ZQ001Detail.findByOid", query = "SELECT z FROM ZQ001Detail z WHERE z.oid = :oid"),
    @NamedQuery(name = "ZQ001Detail.findByResearchMethod", query = "SELECT z FROM ZQ001Detail z WHERE z.researchMethod = :researchMethod"),
    @NamedQuery(name = "ZQ001Detail.findBySerialNo", query = "SELECT z FROM ZQ001Detail z WHERE z.serialNo = :serialNo"),
    @NamedQuery(name = "ZQ001Detail.findByRemark", query = "SELECT z FROM ZQ001Detail z WHERE z.remark = :remark")})
public class ZQ001Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4000)
    @Column(name = "institution")
    private String institution;
    @Size(max = 4000)
    @Column(name = "receptionStaff")
    private String receptionStaff;
    @Size(max = 255)
    @Column(name = "otherMethod")
    private String otherMethod;
    @Size(max = 255)
    @Column(name = "fileno")
    private String fileno;
    @Size(max = 255)
    @Column(name = "researchTime")
    private String researchTime;
    @Size(max = 255)
    @Column(name = "address1")
    private String address1;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "researchMethod")
    private String researchMethod;
    @Size(max = 255)
    @Column(name = "serialNo")
    private String serialNo;
    @Size(max = 4000)
    @Column(name = "remark")
    private String remark;

    public ZQ001Detail() {
    }

    public ZQ001Detail(String oid) {
        this.oid = oid;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getReceptionStaff() {
        return receptionStaff;
    }

    public void setReceptionStaff(String receptionStaff) {
        this.receptionStaff = receptionStaff;
    }

    public String getOtherMethod() {
        return otherMethod;
    }

    public void setOtherMethod(String otherMethod) {
        this.otherMethod = otherMethod;
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getResearchTime() {
        return researchTime;
    }

    public void setResearchTime(String researchTime) {
        this.researchTime = researchTime;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getResearchMethod() {
        return researchMethod;
    }

    public void setResearchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof ZQ001Detail)) {
            return false;
        }
        ZQ001Detail other = (ZQ001Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.ZQ001Detail[ oid=" + oid + " ]";
    }
    
}
