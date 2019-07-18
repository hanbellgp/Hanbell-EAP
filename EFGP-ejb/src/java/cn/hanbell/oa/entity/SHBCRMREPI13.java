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
@Table(name = "SHB_CRM_REPI13")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBCRMREPI13.findAll", query = "SELECT s FROM SHBCRMREPI13 s")
    , @NamedQuery(name = "SHBCRMREPI13.findBySerialNumber", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.serialNumber = :serialNumber")
    , @NamedQuery(name = "SHBCRMREPI13.findByOid", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.oid = :oid")
    , @NamedQuery(name = "SHBCRMREPI13.findByTc087", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.tc087 = :tc087")
    , @NamedQuery(name = "SHBCRMREPI13.findByTc088", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.tc088 = :tc088")
    , @NamedQuery(name = "SHBCRMREPI13.findByTc001", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.tc001 = :tc001")
    , @NamedQuery(name = "SHBCRMREPI13.findByTc002", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.tc002 = :tc002")
    , @NamedQuery(name = "SHBCRMREPI13.findByTc082", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.tc082 = :tc082")
    , @NamedQuery(name = "SHBCRMREPI13.findByPSN", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.processSerialNumber = :psn")
    , @NamedQuery(name = "SHBCRMREPI13.findByTc086", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.tc086 = :tc086")
    , @NamedQuery(name = "SHBCRMREPI13.findByFSN", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.formSerialNumber = :fsn")
    , @NamedQuery(name = "SHBCRMREPI13.findByHdncp", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.hdncp = :hdncp")
    , @NamedQuery(name = "SHBCRMREPI13.findByHdnfw", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.hdnfw = :hdnfw")
    , @NamedQuery(name = "SHBCRMREPI13.findByHdnapplydept", query = "SELECT s FROM SHBCRMREPI13 s WHERE s.hdnapplydept = :hdnapplydept")})
public class SHBCRMREPI13 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TC087")
    private Double tc087;
    @Size(max = 255)
    @Column(name = "TC088")
    private String tc088;
    @Size(max = 255)
    @Column(name = "TC001")
    private String tc001;
    @Size(max = 255)
    @Column(name = "TC002")
    private String tc002;
    @Size(max = 255)
    @Column(name = "TC082")
    private String tc082;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "TC086")
    private String tc086;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdncp")
    private String hdncp;
    @Size(max = 255)
    @Column(name = "hdnfw")
    private String hdnfw;
    @Size(max = 255)
    @Column(name = "hdnapplydept")
    private String hdnapplydept;

    public SHBCRMREPI13() {
    }

    public SHBCRMREPI13(String oid) {
        this.oid = oid;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getTc087() {
        return tc087;
    }

    public void setTc087(Double tc087) {
        this.tc087 = tc087;
    }

    public String getTc088() {
        return tc088;
    }

    public void setTc088(String tc088) {
        this.tc088 = tc088;
    }

    public String getTc001() {
        return tc001;
    }

    public void setTc001(String tc001) {
        this.tc001 = tc001;
    }

    public String getTc002() {
        return tc002;
    }

    public void setTc002(String tc002) {
        this.tc002 = tc002;
    }

    public String getTc082() {
        return tc082;
    }

    public void setTc082(String tc082) {
        this.tc082 = tc082;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getTc086() {
        return tc086;
    }

    public void setTc086(String tc086) {
        this.tc086 = tc086;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdncp() {
        return hdncp;
    }

    public void setHdncp(String hdncp) {
        this.hdncp = hdncp;
    }

    public String getHdnfw() {
        return hdnfw;
    }

    public void setHdnfw(String hdnfw) {
        this.hdnfw = hdnfw;
    }

    public String getHdnapplydept() {
        return hdnapplydept;
    }

    public void setHdnapplydept(String hdnapplydept) {
        this.hdnapplydept = hdnapplydept;
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
        if (!(object instanceof SHBCRMREPI13)) {
            return false;
        }
        SHBCRMREPI13 other = (SHBCRMREPI13) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBCRMREPI13[ oid=" + oid + " ]";
    }
    
}
