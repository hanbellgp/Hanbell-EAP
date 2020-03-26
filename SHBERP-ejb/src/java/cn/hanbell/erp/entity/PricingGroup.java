/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "pricinggroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PricingGroup.findAll", query = "SELECT p FROM PricingGroup p"),
    @NamedQuery(name = "PricingGroup.findByGroupid", query = "SELECT p FROM PricingGroup p WHERE p.pricingGroupPK.groupid = :groupid"),
    @NamedQuery(name = "PricingGroup.findByGroupname", query = "SELECT p FROM PricingGroup p WHERE p.groupname = :groupname"),
    @NamedQuery(name = "PricingGroup.findByPricingtype", query = "SELECT p FROM PricingGroup p WHERE p.pricingGroupPK.pricingtype = :pricingtype")})
public class PricingGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PricingGroupPK pricingGroupPK;
    @Size(max = 20)
    @Column(name = "groupname")
    private String groupname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price09")
    private boolean price09;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price08")
    private boolean price08;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price07")
    private boolean price07;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price06")
    private boolean price06;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price05")
    private boolean price05;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price04")
    private boolean price04;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price03")
    private boolean price03;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price02")
    private boolean price02;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price01")
    private boolean price01;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Size(max = 10)
    @Column(name = "creator")
    private String creator;
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Size(max = 10)
    @Column(name = "optuser")
    private String optuser;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;
    @Size(max = 10)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Column(name = "isdatum")
    private Character isdatum;

    public PricingGroup() {
    }

    public PricingGroup(PricingGroupPK pricingGroupPK) {
        this.pricingGroupPK = pricingGroupPK;
    }

    public PricingGroup(String groupid, String groupname, boolean price09, boolean price08, boolean price07, boolean price06, boolean price05, boolean price04, boolean price03, boolean price02, boolean price01, String pricingtype) {
        this.pricingGroupPK = new PricingGroupPK(groupid, pricingtype);
        this.groupname = groupname;
        this.price09 = price09;
        this.price08 = price08;
        this.price07 = price07;
        this.price06 = price06;
        this.price05 = price05;
        this.price04 = price04;
        this.price03 = price03;
        this.price02 = price02;
        this.price01 = price01;
    }

    public PricingGroupPK getPricingGroupPK() {
        return pricingGroupPK;
    }

    public void setPricingGroupPK(PricingGroupPK pricingGroupPK) {
        this.pricingGroupPK = pricingGroupPK;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public boolean getPrice09() {
        return price09;
    }

    public void setPrice09(boolean price09) {
        this.price09 = price09;
    }

    public boolean getPrice08() {
        return price08;
    }

    public void setPrice08(boolean price08) {
        this.price08 = price08;
    }

    public boolean getPrice07() {
        return price07;
    }

    public void setPrice07(boolean price07) {
        this.price07 = price07;
    }

    public boolean getPrice06() {
        return price06;
    }

    public void setPrice06(boolean price06) {
        this.price06 = price06;
    }

    public boolean getPrice05() {
        return price05;
    }

    public void setPrice05(boolean price05) {
        this.price05 = price05;
    }

    public boolean getPrice04() {
        return price04;
    }

    public void setPrice04(boolean price04) {
        this.price04 = price04;
    }

    public boolean getPrice03() {
        return price03;
    }

    public void setPrice03(boolean price03) {
        this.price03 = price03;
    }

    public boolean getPrice02() {
        return price02;
    }

    public void setPrice02(boolean price02) {
        this.price02 = price02;
    }

    public boolean getPrice01() {
        return price01;
    }

    public void setPrice01(boolean price01) {
        this.price01 = price01;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
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

    public Character getIsdatum() {
        return isdatum;
    }

    public void setIsdatum(Character isdatum) {
        this.isdatum = isdatum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingGroupPK != null ? pricingGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingGroup)) {
            return false;
        }
        PricingGroup other = (PricingGroup) object;
        if ((this.pricingGroupPK == null && other.pricingGroupPK != null) || (this.pricingGroupPK != null && !this.pricingGroupPK.equals(other.pricingGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.PricingGroup[ pricingGroupPK=" + pricingGroupPK + " ]";
    }

}
