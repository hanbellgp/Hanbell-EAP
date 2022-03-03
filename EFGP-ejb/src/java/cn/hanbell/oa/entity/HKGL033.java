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
 * @author C2082
 */
@Entity
@Table(name = "HK_GL033")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL033.findAll", query = "SELECT h FROM HKGL033 h"),
    @NamedQuery(name = "HKGL033.findByOid", query = "SELECT h FROM HKGL033 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL033.findByHdnEmply", query = "SELECT h FROM HKGL033 h WHERE h.hdnEmply = :hdnEmply"),
    @NamedQuery(name = "HKGL033.findByEmply", query = "SELECT h FROM HKGL033 h WHERE h.emply = :emply"),
    @NamedQuery(name = "HKGL033.findByTs", query = "SELECT h FROM HKGL033 h WHERE h.ts = :ts"),
    @NamedQuery(name = "HKGL033.findBySqrq", query = "SELECT h FROM HKGL033 h WHERE h.sqrq = :sqrq"),
    @NamedQuery(name = "HKGL033.findByUserTitle", query = "SELECT h FROM HKGL033 h WHERE h.userTitle = :userTitle"),
    @NamedQuery(name = "HKGL033.findByDept", query = "SELECT h FROM HKGL033 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKGL033.findByPSN", query = "SELECT h FROM HKGL033 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL033.findByType", query = "SELECT h FROM HKGL033 h WHERE h.type = :type"),
    @NamedQuery(name = "HKGL033.findByHdnDept", query = "SELECT h FROM HKGL033 h WHERE h.hdnDept = :hdnDept"),
    @NamedQuery(name = "HKGL033.findByHdnStyle", query = "SELECT h FROM HKGL033 h WHERE h.hdnStyle = :hdnStyle"),
    @NamedQuery(name = "HKGL033.findByFSN", query = "SELECT h FROM HKGL033 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL033.findBySerialNumber", query = "SELECT h FROM HKGL033 h WHERE h.serialNumber = :serialNumber")})
public class HKGL033 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "hdn_emply")
    private String hdnEmply;
    @Size(max = 255)
    @Column(name = "emply")
    private String emply;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ts")
    private Double ts;
    @Column(name = "sqrq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sqrq;
    @Size(max = 255)
    @Column(name = "userTitle")
    private String userTitle;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "hdn_dept")
    private String hdnDept;
    @Size(max = 255)
    @Column(name = "hdn_style")
    private String hdnStyle;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;

    public HKGL033() {
    }

    public HKGL033(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getHdnEmply() {
        return hdnEmply;
    }

    public void setHdnEmply(String hdnEmply) {
        this.hdnEmply = hdnEmply;
    }

    public String getEmply() {
        return emply;
    }

    public void setEmply(String emply) {
        this.emply = emply;
    }

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }

    public Date getSqrq() {
        return sqrq;
    }

    public void setSqrq(Date sqrq) {
        this.sqrq = sqrq;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHdnDept() {
        return hdnDept;
    }

    public void setHdnDept(String hdnDept) {
        this.hdnDept = hdnDept;
    }

    public String getHdnStyle() {
        return hdnStyle;
    }

    public void setHdnStyle(String hdnStyle) {
        this.hdnStyle = hdnStyle;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
        if (!(object instanceof HKGL033)) {
            return false;
        }
        HKGL033 other = (HKGL033) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL033[ oid=" + oid + " ]";
    }
    
}
