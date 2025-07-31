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
@Table(name = "VH_TV006")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHTV006.findAll", query = "SELECT h FROM VHTV006 h"),
    @NamedQuery(name = "VHTV006.findByOid", query = "SELECT h FROM VHTV006 h WHERE h.oid = :oid"),
    @NamedQuery(name = "VHTV006.findByFacno", query = "SELECT h FROM VHTV006 h WHERE h.facno = :facno"),
    @NamedQuery(name = "VHTV006.findByCusno", query = "SELECT h FROM VHTV006 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "VHTV006.findByQuono", query = "SELECT h FROM VHTV006 h WHERE h.quono = :quono"),
    @NamedQuery(name = "VHTV006.findByPSN", query = "SELECT h FROM VHTV006 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "VHTV006.findByFSN", query = "SELECT h FROM VHTV006 h WHERE h.formSerialNumber = :fsn")})
public class VHTV006 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "isspecial")
    private String isspecial;
    @Size(max = 255)
    @Column(name = "levelp")
    private String levelp;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "quono")
    private String quono;
    @Size(max = 255)
    @Column(name = "pricingtype")
    private String pricingtype;
    @Size(max = 255)
    @Column(name = "pricingtypedsc")
    private String pricingtypedsc;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "quotype ")
    private String quotype;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "apprresno")
    private String apprresno;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Column(name = "ratio")
    private Double ratio;
    @Size(max = 255)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Size(max = 255)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 255)
    @Column(name = "mancodesc")
    private String mancodesc;
    @Column(name = "quodate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date quodate;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;


    public VHTV006() {
    }

    public VHTV006(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPricingtype() {
        return pricingtype;
    }

    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(String isspecial) {
        this.isspecial = isspecial;
    }

    public String getLevelp() {
        return levelp;
    }

    public void setLevelp(String levelp) {
        this.levelp = levelp;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }


    public String getPricingtypedsc() {
        return pricingtypedsc;
    }

    public void setPricingtypedsc(String pricingtypedsc) {
        this.pricingtypedsc = pricingtypedsc;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getQuotype() {
        return quotype;
    }

    public void setQuotype(String quotype) {
        this.quotype = quotype;
    }

    public String getCusna() {
        return cusna;
    }

    public String getApprresno() {
        return apprresno;
    }

    public void setApprresno(String apprresno) {
        this.apprresno = apprresno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public Date getQuodate() {
        return quodate;
    }

    public void setQuodate(Date quodate) {
        this.quodate = quodate;
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
        if (!(object instanceof VHTV006)) {
            return false;
        }
        VHTV006 other = (VHTV006) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHTV006[ oid=" + oid + " ]";
    }

    public String getMancodesc() {
        return mancodesc;
    }

    public void setMancodesc(String mancodesc) {
        this.mancodesc = mancodesc;
    }

}
