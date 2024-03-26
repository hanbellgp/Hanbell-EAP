/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CMSME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CMSME.findAll", query = "SELECT c FROM CMSME c"),
    @NamedQuery(name = "CMSME.findByCompany", query = "SELECT c FROM CMSME c WHERE c.company = :company"),
    @NamedQuery(name = "CMSME.findByMe001", query = "SELECT c FROM CMSME c WHERE c.me001 = :me001"),
    @NamedQuery(name = "CMSME.findByMe002", query = "SELECT c FROM CMSME c WHERE c.me002 = :me002")})
public class CMSME implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 10)
    @Column(name = "CREATOR")
    private String creator;
    @Size(max = 10)
    @Column(name = "USR_GROUP")
    private String usrGroup;
    @Size(max = 8)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 10)
    @Column(name = "MODIFIER")
    private String modifier;
    @Size(max = 8)
    @Column(name = "MODI_DATE")
    private String modiDate;
    @Column(name = "FLAG")
    private Short flag;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ME001")
    private String me001;
    @Size(max = 40)
    @Column(name = "ME002")
    private String me002;
    @Size(max = 255)
    @Column(name = "ME003")
    private String me003;
    @Size(max = 20)
    @Column(name = "ME004")
    private String me004;
    @Size(max = 255)
    @Column(name = "ME005")
    private String me005;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ME006")
    private BigDecimal me006;
    @Column(name = "ME007")
    private BigDecimal me007;
    @Size(max = 1)
    @Column(name = "ME008")
    private String me008;
    @Size(max = 30)
    @Column(name = "ME009")
    private String me009;
    @Size(max = 60)
    @Column(name = "ME010")
    private String me010;

    public CMSME() {
    }

    public CMSME(String me001) {
        this.me001 = me001;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUsrGroup() {
        return usrGroup;
    }

    public void setUsrGroup(String usrGroup) {
        this.usrGroup = usrGroup;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getMe001() {
        return me001;
    }

    public void setMe001(String me001) {
        this.me001 = me001;
    }

    public String getMe002() {
        return me002;
    }

    public void setMe002(String me002) {
        this.me002 = me002;
    }

    public String getMe003() {
        return me003;
    }

    public void setMe003(String me003) {
        this.me003 = me003;
    }

    public String getMe004() {
        return me004;
    }

    public void setMe004(String me004) {
        this.me004 = me004;
    }

    public String getMe005() {
        return me005;
    }

    public void setMe005(String me005) {
        this.me005 = me005;
    }

    public BigDecimal getMe006() {
        return me006;
    }

    public void setMe006(BigDecimal me006) {
        this.me006 = me006;
    }

    public BigDecimal getMe007() {
        return me007;
    }

    public void setMe007(BigDecimal me007) {
        this.me007 = me007;
    }

    public String getMe008() {
        return me008;
    }

    public void setMe008(String me008) {
        this.me008 = me008;
    }

    public String getMe009() {
        return me009;
    }

    public void setMe009(String me009) {
        this.me009 = me009;
    }

    public String getMe010() {
        return me010;
    }

    public void setMe010(String me010) {
        this.me010 = me010;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (me001 != null ? me001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMSME)) {
            return false;
        }
        CMSME other = (CMSME) object;
        if ((this.me001 == null && other.me001 != null) || (this.me001 != null && !this.me001.equals(other.me001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CMSME[ me001=" + me001 + " ]";
    }

}
