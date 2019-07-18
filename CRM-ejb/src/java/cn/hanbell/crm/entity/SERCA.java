/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import cn.hanbell.crm.entity.SERCAPK;
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
 * @author Administrator
 */
@Entity
@Table(name = "SERCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERCA.findAll", query = "SELECT s FROM SERCA s")
    , @NamedQuery(name = "SERCA.findByCompany", query = "SELECT s FROM SERCA s WHERE s.company = :company")
    , @NamedQuery(name = "SERCA.findByCreator", query = "SELECT s FROM SERCA s WHERE s.creator = :creator")
    , @NamedQuery(name = "SERCA.findByUsrGroup", query = "SELECT s FROM SERCA s WHERE s.usrGroup = :usrGroup")
    , @NamedQuery(name = "SERCA.findByCreateDate", query = "SELECT s FROM SERCA s WHERE s.createDate = :createDate")
    , @NamedQuery(name = "SERCA.findByModifier", query = "SELECT s FROM SERCA s WHERE s.modifier = :modifier")
    , @NamedQuery(name = "SERCA.findByModiDate", query = "SELECT s FROM SERCA s WHERE s.modiDate = :modiDate")
    , @NamedQuery(name = "SERCA.findByFlag", query = "SELECT s FROM SERCA s WHERE s.flag = :flag")
    , @NamedQuery(name = "SERCA.findByCa001", query = "SELECT s FROM SERCA s WHERE s.sERCAPK.ca001 = :ca001")
    , @NamedQuery(name = "SERCA.findByCa002", query = "SELECT s FROM SERCA s WHERE s.sERCAPK.ca002 = :ca002")
    , @NamedQuery(name = "SERCA.findByCa003", query = "SELECT s FROM SERCA s WHERE s.ca003 = :ca003")
    , @NamedQuery(name = "SERCA.findByCa004", query = "SELECT s FROM SERCA s WHERE s.ca004 = :ca004")
    , @NamedQuery(name = "SERCA.findByCa005", query = "SELECT s FROM SERCA s WHERE s.ca005 = :ca005")
    , @NamedQuery(name = "SERCA.findByCa006", query = "SELECT s FROM SERCA s WHERE s.ca006 = :ca006")
    , @NamedQuery(name = "SERCA.findByCa007", query = "SELECT s FROM SERCA s WHERE s.ca007 = :ca007")
    , @NamedQuery(name = "SERCA.findByCa008", query = "SELECT s FROM SERCA s WHERE s.ca008 = :ca008")
    , @NamedQuery(name = "SERCA.findByCa009", query = "SELECT s FROM SERCA s WHERE s.ca009 = :ca009")
    , @NamedQuery(name = "SERCA.findByCa001ToCa009", query = "SELECT s FROM SERCA s WHERE s.sERCAPK.ca001 = :ca001")
    , @NamedQuery(name = "SERCA.findByCa010", query = "SELECT s FROM SERCA s WHERE s.ca010 = :ca010")
    , @NamedQuery(name = "SERCA.findByCa011", query = "SELECT s FROM SERCA s WHERE s.ca011 = :ca011")
    , @NamedQuery(name = "SERCA.findByCa012", query = "SELECT s FROM SERCA s WHERE s.ca012 = :ca012")
    , @NamedQuery(name = "SERCA.findByCa013", query = "SELECT s FROM SERCA s WHERE s.ca013 = :ca013")
    , @NamedQuery(name = "SERCA.findByCa014", query = "SELECT s FROM SERCA s WHERE s.ca014 = :ca014")
    , @NamedQuery(name = "SERCA.findByCa015", query = "SELECT s FROM SERCA s WHERE s.ca015 = :ca015")
    , @NamedQuery(name = "SERCA.findByCa016", query = "SELECT s FROM SERCA s WHERE s.ca016 = :ca016")
    , @NamedQuery(name = "SERCA.findByCa017", query = "SELECT s FROM SERCA s WHERE s.ca017 = :ca017")
    , @NamedQuery(name = "SERCA.findByCa018", query = "SELECT s FROM SERCA s WHERE s.ca018 = :ca018")
    , @NamedQuery(name = "SERCA.findByCa019", query = "SELECT s FROM SERCA s WHERE s.ca019 = :ca019")
    , @NamedQuery(name = "SERCA.findByCustomer", query = "SELECT s FROM SERCA s WHERE s.customer = :customer")
    , @NamedQuery(name = "SERCA.findByProduct", query = "SELECT s FROM SERCA s WHERE s.product = :product")
    , @NamedQuery(name = "SERCA.findByRegion", query = "SELECT s FROM SERCA s WHERE s.region = :region")
    , @NamedQuery(name = "SERCA.findByDealer", query = "SELECT s FROM SERCA s WHERE s.dealer = :dealer")
    , @NamedQuery(name = "SERCA.findByCa020", query = "SELECT s FROM SERCA s WHERE s.ca020 = :ca020")
    , @NamedQuery(name = "SERCA.findBySerca01", query = "SELECT s FROM SERCA s WHERE s.serca01 = :serca01")
    , @NamedQuery(name = "SERCA.findBySerca02", query = "SELECT s FROM SERCA s WHERE s.serca02 = :serca02")
    , @NamedQuery(name = "SERCA.findBySerca03", query = "SELECT s FROM SERCA s WHERE s.serca03 = :serca03")
    , @NamedQuery(name = "SERCA.findBySerca04", query = "SELECT s FROM SERCA s WHERE s.serca04 = :serca04")
    , @NamedQuery(name = "SERCA.findBySerca05", query = "SELECT s FROM SERCA s WHERE s.serca05 = :serca05")
    , @NamedQuery(name = "SERCA.findBySerca06", query = "SELECT s FROM SERCA s WHERE s.serca06 = :serca06")
    , @NamedQuery(name = "SERCA.findBySerca07", query = "SELECT s FROM SERCA s WHERE s.serca07 = :serca07")
    , @NamedQuery(name = "SERCA.findBySerca08", query = "SELECT s FROM SERCA s WHERE s.serca08 = :serca08")
    , @NamedQuery(name = "SERCA.findBySerca09", query = "SELECT s FROM SERCA s WHERE s.serca09 = :serca09")
    , @NamedQuery(name = "SERCA.findBySerca10", query = "SELECT s FROM SERCA s WHERE s.serca10 = :serca10")
    , @NamedQuery(name = "SERCA.findBySerca11", query = "SELECT s FROM SERCA s WHERE s.serca11 = :serca11")
    , @NamedQuery(name = "SERCA.findBySerca12", query = "SELECT s FROM SERCA s WHERE s.serca12 = :serca12")
    , @NamedQuery(name = "SERCA.findBySerca13", query = "SELECT s FROM SERCA s WHERE s.serca13 = :serca13")
    , @NamedQuery(name = "SERCA.findBySerca14", query = "SELECT s FROM SERCA s WHERE s.serca14 = :serca14")
    , @NamedQuery(name = "SERCA.findBySerca15", query = "SELECT s FROM SERCA s WHERE s.serca15 = :serca15")
    , @NamedQuery(name = "SERCA.findBySerca16", query = "SELECT s FROM SERCA s WHERE s.serca16 = :serca16")
    , @NamedQuery(name = "SERCA.findBySerca17", query = "SELECT s FROM SERCA s WHERE s.serca17 = :serca17")
    , @NamedQuery(name = "SERCA.findBySerca18", query = "SELECT s FROM SERCA s WHERE s.serca18 = :serca18")
    , @NamedQuery(name = "SERCA.findBySerca19", query = "SELECT s FROM SERCA s WHERE s.serca19 = :serca19")
    , @NamedQuery(name = "SERCA.findBySerca20", query = "SELECT s FROM SERCA s WHERE s.serca20 = :serca20")
    , @NamedQuery(name = "SERCA.findByCa021", query = "SELECT s FROM SERCA s WHERE s.ca021 = :ca021")
    , @NamedQuery(name = "SERCA.findByCa500", query = "SELECT s FROM SERCA s WHERE s.ca500 = :ca500")
    , @NamedQuery(name = "SERCA.findByCa022", query = "SELECT s FROM SERCA s WHERE s.ca022 = :ca022")})
public class SERCA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SERCAPK sERCAPK;
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
    @Size(max = 120)
    @Column(name = "CA003")
    private String ca003;
    @Size(max = 120)
    @Column(name = "CA004")
    private String ca004;
    @Size(max = 120)
    @Column(name = "CA005")
    private String ca005;
    @Size(max = 20)
    @Column(name = "CA006")
    private String ca006;
    @Size(max = 8)
    @Column(name = "CA007")
    private String ca007;
    @Size(max = 8)
    @Column(name = "CA008")
    private String ca008;
    @Size(max = 30)
    @Column(name = "CA009")
    private String ca009;
    @Size(max = 4)
    @Column(name = "CA010")
    private String ca010;
    @Size(max = 11)
    @Column(name = "CA011")
    private String ca011;
    @Size(max = 1)
    @Column(name = "CA012")
    private String ca012;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CA013")
    private BigDecimal ca013;
    @Size(max = 1)
    @Column(name = "CA014")
    private String ca014;
    @Size(max = 180)
    @Column(name = "CA015")
    private String ca015;
    @Size(max = 255)
    @Column(name = "CA016")
    private String ca016;
    @Column(name = "CA017")
    private BigDecimal ca017;
    @Size(max = 8)
    @Column(name = "CA018")
    private String ca018;
    @Size(max = 3)
    @Column(name = "CA019")
    private String ca019;
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
    @Size(max = 8)
    @Column(name = "CA020")
    private String ca020;
    @Size(max = 255)
    @Column(name = "SERCA01")
    private String serca01;
    @Size(max = 255)
    @Column(name = "SERCA02")
    private String serca02;
    @Size(max = 255)
    @Column(name = "SERCA03")
    private String serca03;
    @Size(max = 255)
    @Column(name = "SERCA04")
    private String serca04;
    @Size(max = 255)
    @Column(name = "SERCA05")
    private String serca05;
    @Size(max = 255)
    @Column(name = "SERCA06")
    private String serca06;
    @Size(max = 255)
    @Column(name = "SERCA07")
    private String serca07;
    @Size(max = 255)
    @Column(name = "SERCA08")
    private String serca08;
    @Size(max = 255)
    @Column(name = "SERCA09")
    private String serca09;
    @Size(max = 255)
    @Column(name = "SERCA10")
    private String serca10;
    @Size(max = 255)
    @Column(name = "SERCA11")
    private String serca11;
    @Size(max = 255)
    @Column(name = "SERCA12")
    private String serca12;
    @Size(max = 255)
    @Column(name = "SERCA13")
    private String serca13;
    @Size(max = 255)
    @Column(name = "SERCA14")
    private String serca14;
    @Size(max = 255)
    @Column(name = "SERCA15")
    private String serca15;
    @Size(max = 255)
    @Column(name = "SERCA16")
    private String serca16;
    @Size(max = 255)
    @Column(name = "SERCA17")
    private String serca17;
    @Size(max = 255)
    @Column(name = "SERCA18")
    private String serca18;
    @Size(max = 255)
    @Column(name = "SERCA19")
    private String serca19;
    @Size(max = 255)
    @Column(name = "SERCA20")
    private String serca20;
    @Size(max = 10)
    @Column(name = "CA021")
    private String ca021;
    @Size(max = 50)
    @Column(name = "CA500")
    private String ca500;
    @Size(max = 255)
    @Column(name = "CA022")
    private String ca022;

    public SERCA() {
    }

    public SERCA(SERCAPK sERCAPK) {
        this.sERCAPK = sERCAPK;
    }

    public SERCA(String ca001, String ca002) {
        this.sERCAPK = new SERCAPK(ca001, ca002);
    }

    public SERCAPK getSERCAPK() {
        return sERCAPK;
    }

    public void setSERCAPK(SERCAPK sERCAPK) {
        this.sERCAPK = sERCAPK;
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

    public String getCa003() {
        return ca003;
    }

    public void setCa003(String ca003) {
        this.ca003 = ca003;
    }

    public String getCa004() {
        return ca004;
    }

    public void setCa004(String ca004) {
        this.ca004 = ca004;
    }

    public String getCa005() {
        return ca005;
    }

    public void setCa005(String ca005) {
        this.ca005 = ca005;
    }

    public String getCa006() {
        return ca006;
    }

    public void setCa006(String ca006) {
        this.ca006 = ca006;
    }

    public String getCa007() {
        return ca007;
    }

    public void setCa007(String ca007) {
        this.ca007 = ca007;
    }

    public String getCa008() {
        return ca008;
    }

    public void setCa008(String ca008) {
        this.ca008 = ca008;
    }

    public String getCa009() {
        return ca009;
    }

    public void setCa009(String ca009) {
        this.ca009 = ca009;
    }

    public String getCa010() {
        return ca010;
    }

    public void setCa010(String ca010) {
        this.ca010 = ca010;
    }

    public String getCa011() {
        return ca011;
    }

    public void setCa011(String ca011) {
        this.ca011 = ca011;
    }

    public String getCa012() {
        return ca012;
    }

    public void setCa012(String ca012) {
        this.ca012 = ca012;
    }

    public BigDecimal getCa013() {
        return ca013;
    }

    public void setCa013(BigDecimal ca013) {
        this.ca013 = ca013;
    }

    public String getCa014() {
        return ca014;
    }

    public void setCa014(String ca014) {
        this.ca014 = ca014;
    }

    public String getCa015() {
        return ca015;
    }

    public void setCa015(String ca015) {
        this.ca015 = ca015;
    }

    public String getCa016() {
        return ca016;
    }

    public void setCa016(String ca016) {
        this.ca016 = ca016;
    }

    public BigDecimal getCa017() {
        return ca017;
    }

    public void setCa017(BigDecimal ca017) {
        this.ca017 = ca017;
    }

    public String getCa018() {
        return ca018;
    }

    public void setCa018(String ca018) {
        this.ca018 = ca018;
    }

    public String getCa019() {
        return ca019;
    }

    public void setCa019(String ca019) {
        this.ca019 = ca019;
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

    public String getCa020() {
        return ca020;
    }

    public void setCa020(String ca020) {
        this.ca020 = ca020;
    }

    public String getSerca01() {
        return serca01;
    }

    public void setSerca01(String serca01) {
        this.serca01 = serca01;
    }

    public String getSerca02() {
        return serca02;
    }

    public void setSerca02(String serca02) {
        this.serca02 = serca02;
    }

    public String getSerca03() {
        return serca03;
    }

    public void setSerca03(String serca03) {
        this.serca03 = serca03;
    }

    public String getSerca04() {
        return serca04;
    }

    public void setSerca04(String serca04) {
        this.serca04 = serca04;
    }

    public String getSerca05() {
        return serca05;
    }

    public void setSerca05(String serca05) {
        this.serca05 = serca05;
    }

    public String getSerca06() {
        return serca06;
    }

    public void setSerca06(String serca06) {
        this.serca06 = serca06;
    }

    public String getSerca07() {
        return serca07;
    }

    public void setSerca07(String serca07) {
        this.serca07 = serca07;
    }

    public String getSerca08() {
        return serca08;
    }

    public void setSerca08(String serca08) {
        this.serca08 = serca08;
    }

    public String getSerca09() {
        return serca09;
    }

    public void setSerca09(String serca09) {
        this.serca09 = serca09;
    }

    public String getSerca10() {
        return serca10;
    }

    public void setSerca10(String serca10) {
        this.serca10 = serca10;
    }

    public String getSerca11() {
        return serca11;
    }

    public void setSerca11(String serca11) {
        this.serca11 = serca11;
    }

    public String getSerca12() {
        return serca12;
    }

    public void setSerca12(String serca12) {
        this.serca12 = serca12;
    }

    public String getSerca13() {
        return serca13;
    }

    public void setSerca13(String serca13) {
        this.serca13 = serca13;
    }

    public String getSerca14() {
        return serca14;
    }

    public void setSerca14(String serca14) {
        this.serca14 = serca14;
    }

    public String getSerca15() {
        return serca15;
    }

    public void setSerca15(String serca15) {
        this.serca15 = serca15;
    }

    public String getSerca16() {
        return serca16;
    }

    public void setSerca16(String serca16) {
        this.serca16 = serca16;
    }

    public String getSerca17() {
        return serca17;
    }

    public void setSerca17(String serca17) {
        this.serca17 = serca17;
    }

    public String getSerca18() {
        return serca18;
    }

    public void setSerca18(String serca18) {
        this.serca18 = serca18;
    }

    public String getSerca19() {
        return serca19;
    }

    public void setSerca19(String serca19) {
        this.serca19 = serca19;
    }

    public String getSerca20() {
        return serca20;
    }

    public void setSerca20(String serca20) {
        this.serca20 = serca20;
    }

    public String getCa021() {
        return ca021;
    }

    public void setCa021(String ca021) {
        this.ca021 = ca021;
    }

    public String getCa500() {
        return ca500;
    }

    public void setCa500(String ca500) {
        this.ca500 = ca500;
    }

    public String getCa022() {
        return ca022;
    }

    public void setCa022(String ca022) {
        this.ca022 = ca022;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sERCAPK != null ? sERCAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERCA)) {
            return false;
        }
        SERCA other = (SERCA) object;
        if ((this.sERCAPK == null && other.sERCAPK != null) || (this.sERCAPK != null && !this.sERCAPK.equals(other.sERCAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.ejb.SERCA[ sERCAPK=" + sERCAPK + " ]";
    }
    
}
