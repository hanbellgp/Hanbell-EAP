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
@Table(name = "HK_GL038_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL038Detail.findAll", query = "SELECT h FROM HKGL038Detail h"),
    @NamedQuery(name = "HKGL038Detail.findByTotal", query = "SELECT h FROM HKGL038Detail h WHERE h.total = :total"),
    @NamedQuery(name = "HKGL038Detail.findByClxz", query = "SELECT h FROM HKGL038Detail h WHERE h.clxz = :clxz"),
    @NamedQuery(name = "HKGL038Detail.findByOid", query = "SELECT h FROM HKGL038Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL038Detail.findBySrcno", query = "SELECT h FROM HKGL038Detail h WHERE h.srcno = :srcno"),
    @NamedQuery(name = "HKGL038Detail.findByZgls", query = "SELECT h FROM HKGL038Detail h WHERE h.zgls = :zgls"),
    @NamedQuery(name = "HKGL038Detail.findByJsy", query = "SELECT h FROM HKGL038Detail h WHERE h.jsy = :jsy"),
    @NamedQuery(name = "HKGL038Detail.findBySgls", query = "SELECT h FROM HKGL038Detail h WHERE h.sgls = :sgls"),
    @NamedQuery(name = "HKGL038Detail.findBySeq", query = "SELECT h FROM HKGL038Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL038Detail.findByCph", query = "SELECT h FROM HKGL038Detail h WHERE h.cph = :cph"),
    @NamedQuery(name = "HKGL038Detail.findByTxry", query = "SELECT h FROM HKGL038Detail h WHERE h.txry = :txry"),
    @NamedQuery(name = "HKGL038Detail.findByCctime", query = "SELECT h FROM HKGL038Detail h WHERE h.cctime = :cctime"),
    @NamedQuery(name = "HKGL038Detail.findByFSN", query = "SELECT h FROM HKGL038Detail h WHERE h.formSerialNumber = :fsn")})
public class HKGL038Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "total")
    private String total;
    @Size(max = 255)
    @Column(name = "clxz")
    private String clxz;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 255)
    @Column(name = "zgls")
    private String zgls;
    @Size(max = 255)
    @Column(name = "jsy")
    private String jsy;
    @Size(max = 255)
    @Column(name = "sgls")
    private String sgls;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "cph")
    private String cph;
    @Size(max = 255)
    @Column(name = "txry")
    private String txry;
    @Size(max = 255)
    @Column(name = "cctime")
    private String cctime;
    @Size(max = 255)
    @Column(name = "hctime")
    private String hctime;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "ycyy")
    private String ycyy;
    @Column(name = "unprice")
    private Double unprice;
    @Column(name = "cost ")
    private Double cost;
    public HKGL038Detail() {
    }

    public HKGL038Detail(String oid) {
        this.oid = oid;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getClxz() {
        return clxz;
    }

    public void setClxz(String clxz) {
        this.clxz = clxz;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getZgls() {
        return zgls;
    }

    public void setZgls(String zgls) {
        this.zgls = zgls;
    }

    public String getJsy() {
        return jsy;
    }

    public void setJsy(String jsy) {
        this.jsy = jsy;
    }

    public String getSgls() {
        return sgls;
    }

    public void setSgls(String sgls) {
        this.sgls = sgls;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getTxry() {
        return txry;
    }

    public void setTxry(String txry) {
        this.txry = txry;
    }

    public String getCctime() {
        return cctime;
    }

    public void setCctime(String cctime) {
        this.cctime = cctime;
    }

    
    public String getHctime() {
        return hctime;
    }

    public void setHctime(String hctime) {
        this.hctime = hctime;
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
        if (!(object instanceof HKGL038Detail)) {
            return false;
        }
        HKGL038Detail other = (HKGL038Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.comm.HKGL038Detail[ oid=" + oid + " ]";
    }

    public String getYcyy() {
        return ycyy;
    }

    public void setYcyy(String ycyy) {
        this.ycyy = ycyy;
    }

    public Double getUnprice() {
        return unprice;
    }

    public void setUnprice(Double unprice) {
        this.unprice = unprice;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
