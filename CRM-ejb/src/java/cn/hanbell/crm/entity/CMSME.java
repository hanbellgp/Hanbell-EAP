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
    @Column(name = "CMSME01")
    private String cmsme01;
    @Size(max = 255)
    @Column(name = "CMSME02")
    private String cmsme02;
    @Size(max = 255)
    @Column(name = "CMSME03")
    private String cmsme03;
    @Size(max = 255)
    @Column(name = "CMSME04")
    private String cmsme04;
    @Size(max = 255)
    @Column(name = "CMSME05")
    private String cmsme05;
    @Size(max = 255)
    @Column(name = "CMSME06")
    private String cmsme06;
    @Size(max = 255)
    @Column(name = "CMSME07")
    private String cmsme07;
    @Size(max = 255)
    @Column(name = "CMSME08")
    private String cmsme08;
    @Size(max = 255)
    @Column(name = "CMSME09")
    private String cmsme09;
    @Size(max = 255)
    @Column(name = "CMSME10")
    private String cmsme10;
    @Size(max = 255)
    @Column(name = "CMSME11")
    private String cmsme11;
    @Size(max = 255)
    @Column(name = "CMSME12")
    private String cmsme12;
    @Size(max = 255)
    @Column(name = "CMSME13")
    private String cmsme13;
    @Size(max = 255)
    @Column(name = "CMSME14")
    private String cmsme14;
    @Size(max = 255)
    @Column(name = "CMSME15")
    private String cmsme15;
    @Size(max = 255)
    @Column(name = "CMSME16")
    private String cmsme16;
    @Size(max = 255)
    @Column(name = "CMSME17")
    private String cmsme17;
    @Size(max = 255)
    @Column(name = "CMSME18")
    private String cmsme18;
    @Size(max = 255)
    @Column(name = "CMSME19")
    private String cmsme19;
    @Size(max = 255)
    @Column(name = "CMSME20")
    private String cmsme20;
    @Size(max = 10)
    @Column(name = "CUSTOMER")
    private String customer;
    @Size(max = 10)
    @Column(name = "PRODUCT")
    private String product;
    @Size(max = 10)
    @Column(name = "REGION")
    private String region;
    @Size(max = 10)
    @Column(name = "DEALER")
    private String dealer;
    @Size(max = 10)
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

    public String getCmsme01() {
        return cmsme01;
    }

    public void setCmsme01(String cmsme01) {
        this.cmsme01 = cmsme01;
    }

    public String getCmsme02() {
        return cmsme02;
    }

    public void setCmsme02(String cmsme02) {
        this.cmsme02 = cmsme02;
    }

    public String getCmsme03() {
        return cmsme03;
    }

    public void setCmsme03(String cmsme03) {
        this.cmsme03 = cmsme03;
    }

    public String getCmsme04() {
        return cmsme04;
    }

    public void setCmsme04(String cmsme04) {
        this.cmsme04 = cmsme04;
    }

    public String getCmsme05() {
        return cmsme05;
    }

    public void setCmsme05(String cmsme05) {
        this.cmsme05 = cmsme05;
    }

    public String getCmsme06() {
        return cmsme06;
    }

    public void setCmsme06(String cmsme06) {
        this.cmsme06 = cmsme06;
    }

    public String getCmsme07() {
        return cmsme07;
    }

    public void setCmsme07(String cmsme07) {
        this.cmsme07 = cmsme07;
    }

    public String getCmsme08() {
        return cmsme08;
    }

    public void setCmsme08(String cmsme08) {
        this.cmsme08 = cmsme08;
    }

    public String getCmsme09() {
        return cmsme09;
    }

    public void setCmsme09(String cmsme09) {
        this.cmsme09 = cmsme09;
    }

    public String getCmsme10() {
        return cmsme10;
    }

    public void setCmsme10(String cmsme10) {
        this.cmsme10 = cmsme10;
    }

    public String getCmsme11() {
        return cmsme11;
    }

    public void setCmsme11(String cmsme11) {
        this.cmsme11 = cmsme11;
    }

    public String getCmsme12() {
        return cmsme12;
    }

    public void setCmsme12(String cmsme12) {
        this.cmsme12 = cmsme12;
    }

    public String getCmsme13() {
        return cmsme13;
    }

    public void setCmsme13(String cmsme13) {
        this.cmsme13 = cmsme13;
    }

    public String getCmsme14() {
        return cmsme14;
    }

    public void setCmsme14(String cmsme14) {
        this.cmsme14 = cmsme14;
    }

    public String getCmsme15() {
        return cmsme15;
    }

    public void setCmsme15(String cmsme15) {
        this.cmsme15 = cmsme15;
    }

    public String getCmsme16() {
        return cmsme16;
    }

    public void setCmsme16(String cmsme16) {
        this.cmsme16 = cmsme16;
    }

    public String getCmsme17() {
        return cmsme17;
    }

    public void setCmsme17(String cmsme17) {
        this.cmsme17 = cmsme17;
    }

    public String getCmsme18() {
        return cmsme18;
    }

    public void setCmsme18(String cmsme18) {
        this.cmsme18 = cmsme18;
    }

    public String getCmsme19() {
        return cmsme19;
    }

    public void setCmsme19(String cmsme19) {
        this.cmsme19 = cmsme19;
    }

    public String getCmsme20() {
        return cmsme20;
    }

    public void setCmsme20(String cmsme20) {
        this.cmsme20 = cmsme20;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
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
