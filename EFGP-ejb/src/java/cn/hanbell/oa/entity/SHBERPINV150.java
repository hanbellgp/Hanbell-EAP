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
@Table(name = "SHB_ERP_INV150")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV150.findAll", query = "SELECT s FROM SHBERPINV150 s"),
    @NamedQuery(name = "SHBERPINV150.findByOid", query = "SELECT s FROM SHBERPINV150 s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPINV150.findByWareh", query = "SELECT s FROM SHBERPINV150 s WHERE s.wareh = :wareh"),
    @NamedQuery(name = "SHBERPINV150.findByWhdsc", query = "SELECT s FROM SHBERPINV150 s WHERE s.whdsc = :whdsc"),
    @NamedQuery(name = "SHBERPINV150.findByApplyreason", query = "SELECT s FROM SHBERPINV150 s WHERE s.applyreason = :applyreason"),
    @NamedQuery(name = "SHBERPINV150.findByFacno", query = "SELECT s FROM SHBERPINV150 s WHERE s.facno = :facno"),
    @NamedQuery(name = "SHBERPINV150.findByWclerk", query = "SELECT s FROM SHBERPINV150 s WHERE s.wclerk = :wclerk"),
    @NamedQuery(name = "SHBERPINV150.findByApplyDate", query = "SELECT s FROM SHBERPINV150 s WHERE s.applyDate = :applyDate"),
    @NamedQuery(name = "SHBERPINV150.findByApplyUser", query = "SELECT s FROM SHBERPINV150 s WHERE s.applyUser = :applyUser"),
    @NamedQuery(name = "SHBERPINV150.findByApplyDept", query = "SELECT s FROM SHBERPINV150 s WHERE s.applyDept = :applyDept"),
    @NamedQuery(name = "SHBERPINV150.findByProductplace", query = "SELECT s FROM SHBERPINV150 s WHERE s.productplace = :productplace"),
    @NamedQuery(name = "SHBERPINV150.findByPSN", query = "SELECT s FROM SHBERPINV150 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SHBERPINV150.findByFSN", query = "SELECT s FROM SHBERPINV150 s WHERE s.formSerialNumber = :fsn")})
public class SHBERPINV150 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "costyn")
    private String costyn;
    @Size(max = 255)
    @Column(name = "hdn_mrpco")
    private String hdnmrpco;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "applyreason")
    private String applyreason;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "wclerk")
    private String wclerk;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "productplace")
    private String productplace;
    @Size(max = 255)
    @Column(name = "hdn_costyn")
    private String hdnCostyn;
    @Size(max = 255)
    @Column(name = "mrpco")
    private String mrpco;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public SHBERPINV150() {
    }

    public SHBERPINV150(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCostyn() {
        return costyn;
    }

    public void setCostyn(String costyn) {
        this.costyn = costyn;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getWclerk() {
        return wclerk;
    }

    public void setWclerk(String wclerk) {
        this.wclerk = wclerk;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getProductplace() {
        return productplace;
    }

    public void setProductplace(String productplace) {
        this.productplace = productplace;
    }

    public String getHdncostyn() {
        return hdnCostyn;
    }

    public void setHdnCostyn(String hdnCostyn) {
        this.hdnCostyn = hdnCostyn;
    }

    public String getMrpco() {
        return mrpco;
    }

    public void setMrpco(String mrpco) {
        this.mrpco = mrpco;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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
        if (!(object instanceof SHBERPINV150)) {
            return false;
        }
        SHBERPINV150 other = (SHBERPINV150) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV150[ oid=" + oid + " ]";
    }

    public String getHdnmrpco() {
        return hdnmrpco;
    }

    public void setHdn_mrpco(String hdnmrpco) {
        this.hdnmrpco = hdnmrpco;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

}
