/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "CMSMG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CMSMG.findAll", query = "SELECT c FROM CMSMG c"),
    @NamedQuery(name = "CMSMG.findByCompany", query = "SELECT c FROM CMSMG c WHERE c.company = :company"),
    @NamedQuery(name = "CMSMG.findByCreator", query = "SELECT c FROM CMSMG c WHERE c.creator = :creator"),
    @NamedQuery(name = "CMSMG.findByUsrGroup", query = "SELECT c FROM CMSMG c WHERE c.usrGroup = :usrGroup"),
    @NamedQuery(name = "CMSMG.findByCreateDate", query = "SELECT c FROM CMSMG c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CMSMG.findByModifier", query = "SELECT c FROM CMSMG c WHERE c.modifier = :modifier"),
    @NamedQuery(name = "CMSMG.findByModiDate", query = "SELECT c FROM CMSMG c WHERE c.modiDate = :modiDate"),
    @NamedQuery(name = "CMSMG.findByFlag", query = "SELECT c FROM CMSMG c WHERE c.flag = :flag"),
    @NamedQuery(name = "CMSMG.findByMg001", query = "SELECT c FROM CMSMG c WHERE c.cMSMGPK.mg001 = :mg001"),
    @NamedQuery(name = "CMSMG.findByMg002", query = "SELECT c FROM CMSMG c WHERE c.cMSMGPK.mg002 = :mg002"),
    @NamedQuery(name = "CMSMG.findByMg003", query = "SELECT c FROM CMSMG c WHERE c.mg003 = :mg003"),
    @NamedQuery(name = "CMSMG.findByMg004", query = "SELECT c FROM CMSMG c WHERE c.mg004 = :mg004"),
    @NamedQuery(name = "CMSMG.findByMg005", query = "SELECT c FROM CMSMG c WHERE c.mg005 = :mg005"),
    @NamedQuery(name = "CMSMG.findByMg006", query = "SELECT c FROM CMSMG c WHERE c.mg006 = :mg006"),
    @NamedQuery(name = "CMSMG.findByCmsmg01", query = "SELECT c FROM CMSMG c WHERE c.cmsmg01 = :cmsmg01"),
    @NamedQuery(name = "CMSMG.findByCmsmg02", query = "SELECT c FROM CMSMG c WHERE c.cmsmg02 = :cmsmg02"),
    @NamedQuery(name = "CMSMG.findByCmsmg03", query = "SELECT c FROM CMSMG c WHERE c.cmsmg03 = :cmsmg03"),
    @NamedQuery(name = "CMSMG.findByCmsmg04", query = "SELECT c FROM CMSMG c WHERE c.cmsmg04 = :cmsmg04"),
    @NamedQuery(name = "CMSMG.findByCmsmg05", query = "SELECT c FROM CMSMG c WHERE c.cmsmg05 = :cmsmg05"),
    @NamedQuery(name = "CMSMG.findByCmsmg06", query = "SELECT c FROM CMSMG c WHERE c.cmsmg06 = :cmsmg06"),
    @NamedQuery(name = "CMSMG.findByCmsmg07", query = "SELECT c FROM CMSMG c WHERE c.cmsmg07 = :cmsmg07"),
    @NamedQuery(name = "CMSMG.findByCmsmg08", query = "SELECT c FROM CMSMG c WHERE c.cmsmg08 = :cmsmg08"),
    @NamedQuery(name = "CMSMG.findByCmsmg09", query = "SELECT c FROM CMSMG c WHERE c.cmsmg09 = :cmsmg09"),
    @NamedQuery(name = "CMSMG.findByCmsmg10", query = "SELECT c FROM CMSMG c WHERE c.cmsmg10 = :cmsmg10"),
    @NamedQuery(name = "CMSMG.findByCmsmg11", query = "SELECT c FROM CMSMG c WHERE c.cmsmg11 = :cmsmg11"),
    @NamedQuery(name = "CMSMG.findByCmsmg12", query = "SELECT c FROM CMSMG c WHERE c.cmsmg12 = :cmsmg12"),
    @NamedQuery(name = "CMSMG.findByCmsmg13", query = "SELECT c FROM CMSMG c WHERE c.cmsmg13 = :cmsmg13"),
    @NamedQuery(name = "CMSMG.findByCmsmg14", query = "SELECT c FROM CMSMG c WHERE c.cmsmg14 = :cmsmg14"),
    @NamedQuery(name = "CMSMG.findByCmsmg15", query = "SELECT c FROM CMSMG c WHERE c.cmsmg15 = :cmsmg15"),
    @NamedQuery(name = "CMSMG.findByCmsmg16", query = "SELECT c FROM CMSMG c WHERE c.cmsmg16 = :cmsmg16"),
    @NamedQuery(name = "CMSMG.findByCmsmg17", query = "SELECT c FROM CMSMG c WHERE c.cmsmg17 = :cmsmg17"),
    @NamedQuery(name = "CMSMG.findByCmsmg18", query = "SELECT c FROM CMSMG c WHERE c.cmsmg18 = :cmsmg18"),
    @NamedQuery(name = "CMSMG.findByCmsmg19", query = "SELECT c FROM CMSMG c WHERE c.cmsmg19 = :cmsmg19"),
    @NamedQuery(name = "CMSMG.findByCmsmg20", query = "SELECT c FROM CMSMG c WHERE c.cmsmg20 = :cmsmg20"),
    @NamedQuery(name = "CMSMG.findByCustomer", query = "SELECT c FROM CMSMG c WHERE c.customer = :customer"),
    @NamedQuery(name = "CMSMG.findByProduct", query = "SELECT c FROM CMSMG c WHERE c.product = :product"),
    @NamedQuery(name = "CMSMG.findByRegion", query = "SELECT c FROM CMSMG c WHERE c.region = :region"),
    @NamedQuery(name = "CMSMG.findByDealer", query = "SELECT c FROM CMSMG c WHERE c.dealer = :dealer"),
    @NamedQuery(name = "CMSMG.findByMg007", query = "SELECT c FROM CMSMG c WHERE c.mg007 = :mg007"),
    @NamedQuery(name = "CMSMG.findByMg008", query = "SELECT c FROM CMSMG c WHERE c.mg008 = :mg008"),
    @NamedQuery(name = "CMSMG.findByMg009", query = "SELECT c FROM CMSMG c WHERE c.mg009 = :mg009"),
    @NamedQuery(name = "CMSMG.findByMg010", query = "SELECT c FROM CMSMG c WHERE c.mg010 = :mg010"),
    @NamedQuery(name = "CMSMG.findByMg011", query = "SELECT c FROM CMSMG c WHERE c.mg011 = :mg011")})
public class CMSMG implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CMSMGPK cMSMGPK;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MG003")
    private BigDecimal mg003;
    @Column(name = "MG004")
    private BigDecimal mg004;
    @Column(name = "MG005")
    private BigDecimal mg005;
    @Column(name = "MG006")
    private BigDecimal mg006;
    @Size(max = 255)
    @Column(name = "CMSMG01")
    private String cmsmg01;
    @Size(max = 255)
    @Column(name = "CMSMG02")
    private String cmsmg02;
    @Size(max = 255)
    @Column(name = "CMSMG03")
    private String cmsmg03;
    @Size(max = 255)
    @Column(name = "CMSMG04")
    private String cmsmg04;
    @Size(max = 255)
    @Column(name = "CMSMG05")
    private String cmsmg05;
    @Size(max = 255)
    @Column(name = "CMSMG06")
    private String cmsmg06;
    @Size(max = 255)
    @Column(name = "CMSMG07")
    private String cmsmg07;
    @Size(max = 255)
    @Column(name = "CMSMG08")
    private String cmsmg08;
    @Size(max = 255)
    @Column(name = "CMSMG09")
    private String cmsmg09;
    @Size(max = 255)
    @Column(name = "CMSMG10")
    private String cmsmg10;
    @Size(max = 255)
    @Column(name = "CMSMG11")
    private String cmsmg11;
    @Size(max = 255)
    @Column(name = "CMSMG12")
    private String cmsmg12;
    @Size(max = 255)
    @Column(name = "CMSMG13")
    private String cmsmg13;
    @Size(max = 255)
    @Column(name = "CMSMG14")
    private String cmsmg14;
    @Size(max = 255)
    @Column(name = "CMSMG15")
    private String cmsmg15;
    @Size(max = 255)
    @Column(name = "CMSMG16")
    private String cmsmg16;
    @Size(max = 255)
    @Column(name = "CMSMG17")
    private String cmsmg17;
    @Size(max = 255)
    @Column(name = "CMSMG18")
    private String cmsmg18;
    @Size(max = 255)
    @Column(name = "CMSMG19")
    private String cmsmg19;
    @Size(max = 255)
    @Column(name = "CMSMG20")
    private String cmsmg20;
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
    @Column(name = "MG007")
    private BigDecimal mg007;
    @Column(name = "MG008")
    private BigDecimal mg008;
    @Size(max = 1)
    @Column(name = "MG009")
    private String mg009;
    @Size(max = 30)
    @Column(name = "MG010")
    private String mg010;
    @Size(max = 60)
    @Column(name = "MG011")
    private String mg011;

    public CMSMG() {
    }

    public CMSMG(CMSMGPK cMSMGPK) {
        this.cMSMGPK = cMSMGPK;
    }

    public CMSMG(String mg001, String mg002) {
        this.cMSMGPK = new CMSMGPK(mg001, mg002);
    }

    public CMSMGPK getCMSMGPK() {
        return cMSMGPK;
    }

    public void setCMSMGPK(CMSMGPK cMSMGPK) {
        this.cMSMGPK = cMSMGPK;
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

    public BigDecimal getMg003() {
        return mg003;
    }

    public void setMg003(BigDecimal mg003) {
        this.mg003 = mg003;
    }

    public BigDecimal getMg004() {
        return mg004;
    }

    public void setMg004(BigDecimal mg004) {
        this.mg004 = mg004;
    }

    public BigDecimal getMg005() {
        return mg005;
    }

    public void setMg005(BigDecimal mg005) {
        this.mg005 = mg005;
    }

    public BigDecimal getMg006() {
        return mg006;
    }

    public void setMg006(BigDecimal mg006) {
        this.mg006 = mg006;
    }

    public String getCmsmg01() {
        return cmsmg01;
    }

    public void setCmsmg01(String cmsmg01) {
        this.cmsmg01 = cmsmg01;
    }

    public String getCmsmg02() {
        return cmsmg02;
    }

    public void setCmsmg02(String cmsmg02) {
        this.cmsmg02 = cmsmg02;
    }

    public String getCmsmg03() {
        return cmsmg03;
    }

    public void setCmsmg03(String cmsmg03) {
        this.cmsmg03 = cmsmg03;
    }

    public String getCmsmg04() {
        return cmsmg04;
    }

    public void setCmsmg04(String cmsmg04) {
        this.cmsmg04 = cmsmg04;
    }

    public String getCmsmg05() {
        return cmsmg05;
    }

    public void setCmsmg05(String cmsmg05) {
        this.cmsmg05 = cmsmg05;
    }

    public String getCmsmg06() {
        return cmsmg06;
    }

    public void setCmsmg06(String cmsmg06) {
        this.cmsmg06 = cmsmg06;
    }

    public String getCmsmg07() {
        return cmsmg07;
    }

    public void setCmsmg07(String cmsmg07) {
        this.cmsmg07 = cmsmg07;
    }

    public String getCmsmg08() {
        return cmsmg08;
    }

    public void setCmsmg08(String cmsmg08) {
        this.cmsmg08 = cmsmg08;
    }

    public String getCmsmg09() {
        return cmsmg09;
    }

    public void setCmsmg09(String cmsmg09) {
        this.cmsmg09 = cmsmg09;
    }

    public String getCmsmg10() {
        return cmsmg10;
    }

    public void setCmsmg10(String cmsmg10) {
        this.cmsmg10 = cmsmg10;
    }

    public String getCmsmg11() {
        return cmsmg11;
    }

    public void setCmsmg11(String cmsmg11) {
        this.cmsmg11 = cmsmg11;
    }

    public String getCmsmg12() {
        return cmsmg12;
    }

    public void setCmsmg12(String cmsmg12) {
        this.cmsmg12 = cmsmg12;
    }

    public String getCmsmg13() {
        return cmsmg13;
    }

    public void setCmsmg13(String cmsmg13) {
        this.cmsmg13 = cmsmg13;
    }

    public String getCmsmg14() {
        return cmsmg14;
    }

    public void setCmsmg14(String cmsmg14) {
        this.cmsmg14 = cmsmg14;
    }

    public String getCmsmg15() {
        return cmsmg15;
    }

    public void setCmsmg15(String cmsmg15) {
        this.cmsmg15 = cmsmg15;
    }

    public String getCmsmg16() {
        return cmsmg16;
    }

    public void setCmsmg16(String cmsmg16) {
        this.cmsmg16 = cmsmg16;
    }

    public String getCmsmg17() {
        return cmsmg17;
    }

    public void setCmsmg17(String cmsmg17) {
        this.cmsmg17 = cmsmg17;
    }

    public String getCmsmg18() {
        return cmsmg18;
    }

    public void setCmsmg18(String cmsmg18) {
        this.cmsmg18 = cmsmg18;
    }

    public String getCmsmg19() {
        return cmsmg19;
    }

    public void setCmsmg19(String cmsmg19) {
        this.cmsmg19 = cmsmg19;
    }

    public String getCmsmg20() {
        return cmsmg20;
    }

    public void setCmsmg20(String cmsmg20) {
        this.cmsmg20 = cmsmg20;
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

    public BigDecimal getMg007() {
        return mg007;
    }

    public void setMg007(BigDecimal mg007) {
        this.mg007 = mg007;
    }

    public BigDecimal getMg008() {
        return mg008;
    }

    public void setMg008(BigDecimal mg008) {
        this.mg008 = mg008;
    }

    public String getMg009() {
        return mg009;
    }

    public void setMg009(String mg009) {
        this.mg009 = mg009;
    }

    public String getMg010() {
        return mg010;
    }

    public void setMg010(String mg010) {
        this.mg010 = mg010;
    }

    public String getMg011() {
        return mg011;
    }

    public void setMg011(String mg011) {
        this.mg011 = mg011;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cMSMGPK != null ? cMSMGPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMSMG)) {
            return false;
        }
        CMSMG other = (CMSMG) object;
        if ((this.cMSMGPK == null && other.cMSMGPK != null) || (this.cMSMGPK != null && !this.cMSMGPK.equals(other.cMSMGPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CMSMG[ cMSMGPK=" + cMSMGPK + " ]";
    }
    
}
