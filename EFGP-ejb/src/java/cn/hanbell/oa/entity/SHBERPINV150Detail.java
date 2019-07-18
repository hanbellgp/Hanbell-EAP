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
@Table(name = "SHB_ERP_INV150_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPINV150Detail.findAll", query = "SELECT s FROM SHBERPINV150Detail s")
    , @NamedQuery(name = "SHBERPINV150Detail.findByOid", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.oid = :oid")
    , @NamedQuery(name = "SHBERPINV150Detail.findByWclerkLbl", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.wclerkLbl = :wclerkLbl")
    , @NamedQuery(name = "SHBERPINV150Detail.findByWclerkTxt", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.wclerkTxt = :wclerkTxt")
    , @NamedQuery(name = "SHBERPINV150Detail.findByWareh", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.wareh = :wareh")
    , @NamedQuery(name = "SHBERPINV150Detail.findByWhdsc", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.whdsc = :whdsc")
    , @NamedQuery(name = "SHBERPINV150Detail.findBySeq", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.seq = :seq")
    , @NamedQuery(name = "SHBERPINV150Detail.findByFSN", query = "SELECT s FROM SHBERPINV150Detail s WHERE s.formSerialNumber = :fsn")})
public class SHBERPINV150Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "wclerk_lbl")
    private String wclerkLbl;
    @Size(max = 255)
    @Column(name = "wclerk_txt")
    private String wclerkTxt;
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
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "hdn_costyn")
    private String hdnCostyn;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public SHBERPINV150Detail() {
    }

    public SHBERPINV150Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getWclerkLbl() {
        return wclerkLbl;
    }

    public void setWclerkLbl(String wclerkLbl) {
        this.wclerkLbl = wclerkLbl;
    }

    public String getWclerkTxt() {
        return wclerkTxt;
    }

    public void setWclerkTxt(String wclerkTxt) {
        this.wclerkTxt = wclerkTxt;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof SHBERPINV150Detail)) {
            return false;
        }
        SHBERPINV150Detail other = (SHBERPINV150Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPINV150Detail[ oid=" + oid + " ]";
    }

    public String getHdnmrpco() {
        return hdnmrpco;
    }

    public void setHdnmrpco(String hdnmrpco) {
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

    public String getHdnCostyn() {
        return hdnCostyn;
    }

    public void setHdnCostyn(String hdnCostyn) {
        this.hdnCostyn = hdnCostyn;
    }
    
}
