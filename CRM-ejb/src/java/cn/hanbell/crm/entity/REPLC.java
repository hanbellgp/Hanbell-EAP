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
 * @author Administrator
 */
@Entity
@Table(name = "REPLC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPLC.findAll", query = "SELECT r FROM REPLC r"),
    @NamedQuery(name = "REPLC.findByCompany", query = "SELECT r FROM REPLC r WHERE r.company = :company"),
    @NamedQuery(name = "REPLC.findByCreator", query = "SELECT r FROM REPLC r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPLC.findByUsrGroup", query = "SELECT r FROM REPLC r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPLC.findByCreateDate", query = "SELECT r FROM REPLC r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPLC.findByModifier", query = "SELECT r FROM REPLC r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPLC.findByModiDate", query = "SELECT r FROM REPLC r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPLC.findByFlag", query = "SELECT r FROM REPLC r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPLC.findByLc001", query = "SELECT r FROM REPLC r WHERE r.rEPLCPK.lc001 = :lc001"),
    @NamedQuery(name = "REPLC.findByLc002", query = "SELECT r FROM REPLC r WHERE r.rEPLCPK.lc002 = :lc002"),
    @NamedQuery(name = "REPLC.findByLC001ANDLC002", query = "SELECT r FROM REPLC r WHERE r.rEPLCPK.lc001 = :lc001 AND r.rEPLCPK.lc002 = :lc002"),
    @NamedQuery(name = "REPLC.findByLc003", query = "SELECT r FROM REPLC r WHERE r.rEPLCPK.lc003 = :lc003"),
    @NamedQuery(name = "REPLC.findByCustomer", query = "SELECT r FROM REPLC r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPLC.findByProduct", query = "SELECT r FROM REPLC r WHERE r.product = :product"),
    @NamedQuery(name = "REPLC.findByRegion", query = "SELECT r FROM REPLC r WHERE r.region = :region"),
    @NamedQuery(name = "REPLC.findByDealer", query = "SELECT r FROM REPLC r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPLC.findByReplc01", query = "SELECT r FROM REPLC r WHERE r.replc01 = :replc01"),
    @NamedQuery(name = "REPLC.findByReplc02", query = "SELECT r FROM REPLC r WHERE r.replc02 = :replc02")})
public class REPLC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPLCPK rEPLCPK;
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
    @Size(max = 6)
    @Column(name = "LC004")
    private String lc004;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LC005")
    private BigDecimal lc005;
    @Column(name = "LC006")
    private BigDecimal lc006;
    @Column(name = "LC007")
    private BigDecimal lc007;
    @Column(name = "LC008")
    private BigDecimal lc008;
    @Column(name = "LC009")
    private BigDecimal lc009;
    @Column(name = "LC010")
    private BigDecimal lc010;
    @Column(name = "LC011")
    private BigDecimal lc011;
    @Column(name = "LC012")
    private BigDecimal lc012;
    @Size(max = 1)
    @Column(name = "LC013")
    private String lc013;
    @Size(max = 4)
    @Column(name = "LC014")
    private String lc014;
    @Size(max = 11)
    @Column(name = "LC015")
    private String lc015;
    @Column(name = "LC016")
    private BigDecimal lc016;
    @Column(name = "LC017")
    private BigDecimal lc017;
    @Size(max = 1)
    @Column(name = "LC018")
    private String lc018;
    @Size(max = 30)
    @Column(name = "LC019")
    private String lc019;
    @Size(max = 60)
    @Column(name = "LC020")
    private String lc020;
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
    @Size(max = 255)
    @Column(name = "REPLC01")
    private String replc01;
    @Size(max = 255)
    @Column(name = "REPLC02")
    private String replc02;
    @Size(max = 255)
    @Column(name = "REPLC03")
    private String replc03;
    @Size(max = 255)
    @Column(name = "REPLC04")
    private String replc04;
    @Size(max = 255)
    @Column(name = "REPLC05")
    private String replc05;
    @Size(max = 255)
    @Column(name = "REPLC06")
    private String replc06;
    @Size(max = 255)
    @Column(name = "REPLC07")
    private String replc07;
    @Size(max = 255)
    @Column(name = "REPLC08")
    private String replc08;
    @Size(max = 255)
    @Column(name = "REPLC09")
    private String replc09;
    @Size(max = 255)
    @Column(name = "REPLC10")
    private String replc10;
    @Size(max = 255)
    @Column(name = "REPLC11")
    private String replc11;
    @Size(max = 255)
    @Column(name = "REPLC12")
    private String replc12;
    @Size(max = 255)
    @Column(name = "REPLC13")
    private String replc13;
    @Size(max = 255)
    @Column(name = "REPLC14")
    private String replc14;
    @Size(max = 255)
    @Column(name = "REPLC15")
    private String replc15;
    @Size(max = 255)
    @Column(name = "REPLC16")
    private String replc16;
    @Size(max = 255)
    @Column(name = "REPLC17")
    private String replc17;
    @Size(max = 255)
    @Column(name = "REPLC18")
    private String replc18;
    @Size(max = 255)
    @Column(name = "REPLC19")
    private String replc19;
    @Size(max = 255)
    @Column(name = "REPLC20")
    private String replc20;
    @Size(max = 4)
    @Column(name = "LC021")
    private String lc021;
    @Size(max = 11)
    @Column(name = "LC022")
    private String lc022;
    @Size(max = 4)
    @Column(name = "LC023")
    private String lc023;
    @Size(max = 255)
    @Column(name = "LC024")
    private String lc024;
    @Size(max = 8)
    @Column(name = "LC025")
    private String lc025;
    @Size(max = 10)
    @Column(name = "LC026")
    private String lc026;
    @Size(max = 1)
    @Column(name = "LC027")
    private String lc027;
    @Size(max = 1)
    @Column(name = "LC028")
    private String lc028;
    @Column(name = "LC029")
    private BigDecimal lc029;
    @Size(max = 10)
    @Column(name = "LC030")
    private String lc030;
    @Column(name = "LC031")
    private BigDecimal lc031;
    @Size(max = 10)
    @Column(name = "LC032")
    private String lc032;

    public REPLC() {
    }

    public REPLC(REPLCPK rEPLCPK) {
        this.rEPLCPK = rEPLCPK;
    }

    public REPLC(String lc001, String lc002, String lc003) {
        this.rEPLCPK = new REPLCPK(lc001, lc002, lc003);
    }

    public REPLCPK getREPLCPK() {
        return rEPLCPK;
    }

    public void setREPLCPK(REPLCPK rEPLCPK) {
        this.rEPLCPK = rEPLCPK;
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

    public String getLc004() {
        return lc004;
    }

    public void setLc004(String lc004) {
        this.lc004 = lc004;
    }

    public BigDecimal getLc005() {
        return lc005;
    }

    public void setLc005(BigDecimal lc005) {
        this.lc005 = lc005;
    }

    public BigDecimal getLc006() {
        return lc006;
    }

    public void setLc006(BigDecimal lc006) {
        this.lc006 = lc006;
    }

    public BigDecimal getLc007() {
        return lc007;
    }

    public void setLc007(BigDecimal lc007) {
        this.lc007 = lc007;
    }

    public BigDecimal getLc008() {
        return lc008;
    }

    public void setLc008(BigDecimal lc008) {
        this.lc008 = lc008;
    }

    public BigDecimal getLc009() {
        return lc009;
    }

    public void setLc009(BigDecimal lc009) {
        this.lc009 = lc009;
    }

    public BigDecimal getLc010() {
        return lc010;
    }

    public void setLc010(BigDecimal lc010) {
        this.lc010 = lc010;
    }

    public BigDecimal getLc011() {
        return lc011;
    }

    public void setLc011(BigDecimal lc011) {
        this.lc011 = lc011;
    }

    public BigDecimal getLc012() {
        return lc012;
    }

    public void setLc012(BigDecimal lc012) {
        this.lc012 = lc012;
    }

    public String getLc013() {
        return lc013;
    }

    public void setLc013(String lc013) {
        this.lc013 = lc013;
    }

    public String getLc014() {
        return lc014;
    }

    public void setLc014(String lc014) {
        this.lc014 = lc014;
    }

    public String getLc015() {
        return lc015;
    }

    public void setLc015(String lc015) {
        this.lc015 = lc015;
    }

    public BigDecimal getLc016() {
        return lc016;
    }

    public void setLc016(BigDecimal lc016) {
        this.lc016 = lc016;
    }

    public BigDecimal getLc017() {
        return lc017;
    }

    public void setLc017(BigDecimal lc017) {
        this.lc017 = lc017;
    }

    public String getLc018() {
        return lc018;
    }

    public void setLc018(String lc018) {
        this.lc018 = lc018;
    }

    public String getLc019() {
        return lc019;
    }

    public void setLc019(String lc019) {
        this.lc019 = lc019;
    }

    public String getLc020() {
        return lc020;
    }

    public void setLc020(String lc020) {
        this.lc020 = lc020;
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

    public String getReplc01() {
        return replc01;
    }

    public void setReplc01(String replc01) {
        this.replc01 = replc01;
    }

    public String getReplc02() {
        return replc02;
    }

    public void setReplc02(String replc02) {
        this.replc02 = replc02;
    }

    public String getReplc03() {
        return replc03;
    }

    public void setReplc03(String replc03) {
        this.replc03 = replc03;
    }

    public String getReplc04() {
        return replc04;
    }

    public void setReplc04(String replc04) {
        this.replc04 = replc04;
    }

    public String getReplc05() {
        return replc05;
    }

    public void setReplc05(String replc05) {
        this.replc05 = replc05;
    }

    public String getReplc06() {
        return replc06;
    }

    public void setReplc06(String replc06) {
        this.replc06 = replc06;
    }

    public String getReplc07() {
        return replc07;
    }

    public void setReplc07(String replc07) {
        this.replc07 = replc07;
    }

    public String getReplc08() {
        return replc08;
    }

    public void setReplc08(String replc08) {
        this.replc08 = replc08;
    }

    public String getReplc09() {
        return replc09;
    }

    public void setReplc09(String replc09) {
        this.replc09 = replc09;
    }

    public String getReplc10() {
        return replc10;
    }

    public void setReplc10(String replc10) {
        this.replc10 = replc10;
    }

    public String getReplc11() {
        return replc11;
    }

    public void setReplc11(String replc11) {
        this.replc11 = replc11;
    }

    public String getReplc12() {
        return replc12;
    }

    public void setReplc12(String replc12) {
        this.replc12 = replc12;
    }

    public String getReplc13() {
        return replc13;
    }

    public void setReplc13(String replc13) {
        this.replc13 = replc13;
    }

    public String getReplc14() {
        return replc14;
    }

    public void setReplc14(String replc14) {
        this.replc14 = replc14;
    }

    public String getReplc15() {
        return replc15;
    }

    public void setReplc15(String replc15) {
        this.replc15 = replc15;
    }

    public String getReplc16() {
        return replc16;
    }

    public void setReplc16(String replc16) {
        this.replc16 = replc16;
    }

    public String getReplc17() {
        return replc17;
    }

    public void setReplc17(String replc17) {
        this.replc17 = replc17;
    }

    public String getReplc18() {
        return replc18;
    }

    public void setReplc18(String replc18) {
        this.replc18 = replc18;
    }

    public String getReplc19() {
        return replc19;
    }

    public void setReplc19(String replc19) {
        this.replc19 = replc19;
    }

    public String getReplc20() {
        return replc20;
    }

    public void setReplc20(String replc20) {
        this.replc20 = replc20;
    }

    public String getLc021() {
        return lc021;
    }

    public void setLc021(String lc021) {
        this.lc021 = lc021;
    }

    public String getLc022() {
        return lc022;
    }

    public void setLc022(String lc022) {
        this.lc022 = lc022;
    }

    public String getLc023() {
        return lc023;
    }

    public void setLc023(String lc023) {
        this.lc023 = lc023;
    }

    public String getLc024() {
        return lc024;
    }

    public void setLc024(String lc024) {
        this.lc024 = lc024;
    }

    public String getLc025() {
        return lc025;
    }

    public void setLc025(String lc025) {
        this.lc025 = lc025;
    }

    public String getLc026() {
        return lc026;
    }

    public void setLc026(String lc026) {
        this.lc026 = lc026;
    }

    public String getLc027() {
        return lc027;
    }

    public void setLc027(String lc027) {
        this.lc027 = lc027;
    }

    public String getLc028() {
        return lc028;
    }

    public void setLc028(String lc028) {
        this.lc028 = lc028;
    }

    public BigDecimal getLc029() {
        return lc029;
    }

    public void setLc029(BigDecimal lc029) {
        this.lc029 = lc029;
    }

    public String getLc030() {
        return lc030;
    }

    public void setLc030(String lc030) {
        this.lc030 = lc030;
    }

    public BigDecimal getLc031() {
        return lc031;
    }

    public void setLc031(BigDecimal lc031) {
        this.lc031 = lc031;
    }

    public String getLc032() {
        return lc032;
    }

    public void setLc032(String lc032) {
        this.lc032 = lc032;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPLCPK != null ? rEPLCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPLC)) {
            return false;
        }
        REPLC other = (REPLC) object;
        if ((this.rEPLCPK == null && other.rEPLCPK != null) || (this.rEPLCPK != null && !this.rEPLCPK.equals(other.rEPLCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPLC[ rEPLCPK=" + rEPLCPK + " ]";
    }

}
