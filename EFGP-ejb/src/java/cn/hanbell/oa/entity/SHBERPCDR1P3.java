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
 * @author Administrator
 */
@Entity
@Table(name = "SHB_ERP_CDR1P3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPCDR1P3.findAll", query = "SELECT s FROM SHBERPCDR1P3 s"),
    @NamedQuery(name = "SHBERPCDR1P3.findByPSN", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SHBERPCDR1P3.findByArea1", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.area1 = :area1"),
    @NamedQuery(name = "SHBERPCDR1P3.findByCusno", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.cusno = :cusno"),
    @NamedQuery(name = "SHBERPCDR1P3.findByOid", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPCDR1P3.findByMancode", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.mancode = :mancode"),
    @NamedQuery(name = "SHBERPCDR1P3.findByCuslevel1", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.cuslevel1 = :cuslevel1"),
    @NamedQuery(name = "SHBERPCDR1P3.findByApplyUser", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.applyUser = :applyUser"),
    @NamedQuery(name = "SHBERPCDR1P3.findByCuslevel2", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.cuslevel2 = :cuslevel2"),
    @NamedQuery(name = "SHBERPCDR1P3.findBySerialNumber", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.serialNumber = :serialNumber"),
    @NamedQuery(name = "SHBERPCDR1P3.findByChangetype", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.changetype = :changetype"),
    @NamedQuery(name = "SHBERPCDR1P3.findByFSN", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SHBERPCDR1P3.findByAppres", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.appres = :appres"),
    @NamedQuery(name = "SHBERPCDR1P3.findByApplyDate", query = "SELECT s FROM SHBERPCDR1P3 s WHERE s.applyDate = :applyDate")})
public class SHBERPCDR1P3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "area")
    private String area;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "area1")
    private String area1;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "mancodesc")
    private String mancodesc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 255)
    @Column(name = "cuslevel1")
    private String cuslevel1;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "cuslevel2")
    private String cuslevel2;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "changetype")
    private String changetype;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "appres")
    private String appres;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;

    public SHBERPCDR1P3() {
    }

    public SHBERPCDR1P3(String oid) {
        this.oid = oid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getMancodesc() {
        return mancodesc;
    }

    public void setMancodesc(String mancodesc) {
        this.mancodesc = mancodesc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getCuslevel1() {
        return cuslevel1;
    }

    public void setCuslevel1(String cuslevel1) {
        this.cuslevel1 = cuslevel1;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getCuslevel2() {
        return cuslevel2;
    }

    public void setCuslevel2(String cuslevel2) {
        this.cuslevel2 = cuslevel2;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getAppres() {
        return appres;
    }

    public void setAppres(String appres) {
        this.appres = appres;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
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
        if (!(object instanceof SHBERPCDR1P3)) {
            return false;
        }
        SHBERPCDR1P3 other = (SHBERPCDR1P3) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPCDR1P3[ oid=" + oid + " ]";
    }

}
