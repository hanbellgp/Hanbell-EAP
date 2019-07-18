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
 * @author C0160
 */
@Entity
@Table(name = "Hk_JS001_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJS001Detail.findAll", query = "SELECT h FROM HKJS001Detail h"),
    @NamedQuery(name = "HKJS001Detail.findByOID", query = "SELECT h FROM HKJS001Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJS001Detail.findByFSN", query = "SELECT h FROM HKJS001Detail h WHERE h.formSerialNumber = :fsn")})
public class HKJS001Detail implements Serializable {

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
    @Column(name = "czfs")
    private String czfs;
    @Size(max = 255)
    @Column(name = "bth")
    private String bth;
    @Size(max = 255)
    @Column(name = "apm")
    private String apm;
    @Size(max = 255)
    @Column(name = "bjh")
    private String bjh;
    @Size(max = 255)
    @Column(name = "ajh")
    private String ajh;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "bpm")
    private String bpm;
    @Size(max = 255)
    @Column(name = "ath")
    private String ath;

    public HKJS001Detail() {
    }

    public HKJS001Detail(String oid) {
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

    public String getCzfs() {
        return czfs;
    }

    public void setCzfs(String czfs) {
        this.czfs = czfs;
    }

    public String getBth() {
        return bth;
    }

    public void setBth(String bth) {
        this.bth = bth;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getBjh() {
        return bjh;
    }

    public void setBjh(String bjh) {
        this.bjh = bjh;
    }

    public String getAjh() {
        return ajh;
    }

    public void setAjh(String ajh) {
        this.ajh = ajh;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public String getAth() {
        return ath;
    }

    public void setAth(String ath) {
        this.ath = ath;
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
        if (!(object instanceof HKJS001Detail)) {
            return false;
        }
        HKJS001Detail other = (HKJS001Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJS001Detail[ oid=" + oid + " ]";
    }

}
