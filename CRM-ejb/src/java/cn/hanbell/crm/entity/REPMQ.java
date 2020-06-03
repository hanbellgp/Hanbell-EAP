/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

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
@Table(name = "REPMQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPMQ.findAll", query = "SELECT r FROM REPMQ r")
    , @NamedQuery(name = "REPMQ.findByCompany", query = "SELECT r FROM REPMQ r WHERE r.company = :company")
    , @NamedQuery(name = "REPMQ.findByCreator", query = "SELECT r FROM REPMQ r WHERE r.creator = :creator")
    , @NamedQuery(name = "REPMQ.findByUsrGroup", query = "SELECT r FROM REPMQ r WHERE r.usrGroup = :usrGroup")
    , @NamedQuery(name = "REPMQ.findByCreateDate", query = "SELECT r FROM REPMQ r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "REPMQ.findByModifier", query = "SELECT r FROM REPMQ r WHERE r.modifier = :modifier")
    , @NamedQuery(name = "REPMQ.findByModiDate", query = "SELECT r FROM REPMQ r WHERE r.modiDate = :modiDate")
    , @NamedQuery(name = "REPMQ.findByFlag", query = "SELECT r FROM REPMQ r WHERE r.flag = :flag")
    , @NamedQuery(name = "REPMQ.findByMq001", query = "SELECT r FROM REPMQ r WHERE r.mq001 = :mq001")
    , @NamedQuery(name = "REPMQ.findByMq002", query = "SELECT r FROM REPMQ r WHERE r.mq002 = :mq002")
    , @NamedQuery(name = "REPMQ.findByMq003", query = "SELECT r FROM REPMQ r WHERE r.mq003 = :mq003")
    , @NamedQuery(name = "REPMQ.findByMq004", query = "SELECT r FROM REPMQ r WHERE r.mq004 = :mq004")
    , @NamedQuery(name = "REPMQ.findByMq005", query = "SELECT r FROM REPMQ r WHERE r.mq005 = :mq005")
    , @NamedQuery(name = "REPMQ.findByMq006", query = "SELECT r FROM REPMQ r WHERE r.mq006 = :mq006")
    , @NamedQuery(name = "REPMQ.findByMq007", query = "SELECT r FROM REPMQ r WHERE r.mq007 = :mq007")
    , @NamedQuery(name = "REPMQ.findByMq008", query = "SELECT r FROM REPMQ r WHERE r.mq008 = :mq008")
    , @NamedQuery(name = "REPMQ.findByMq009", query = "SELECT r FROM REPMQ r WHERE r.mq009 = :mq009")
    , @NamedQuery(name = "REPMQ.findByMq010", query = "SELECT r FROM REPMQ r WHERE r.mq010 = :mq010")
    , @NamedQuery(name = "REPMQ.findByMq011", query = "SELECT r FROM REPMQ r WHERE r.mq011 = :mq011")
    , @NamedQuery(name = "REPMQ.findByMq012", query = "SELECT r FROM REPMQ r WHERE r.mq012 = :mq012")
    , @NamedQuery(name = "REPMQ.findByMq013", query = "SELECT r FROM REPMQ r WHERE r.mq013 = :mq013")
    , @NamedQuery(name = "REPMQ.findByMq014", query = "SELECT r FROM REPMQ r WHERE r.mq014 = :mq014")
    , @NamedQuery(name = "REPMQ.findByMq015", query = "SELECT r FROM REPMQ r WHERE r.mq015 = :mq015")
    , @NamedQuery(name = "REPMQ.findByMq016", query = "SELECT r FROM REPMQ r WHERE r.mq016 = :mq016")
    , @NamedQuery(name = "REPMQ.findByMq017", query = "SELECT r FROM REPMQ r WHERE r.mq017 = :mq017")
    , @NamedQuery(name = "REPMQ.findByMq018", query = "SELECT r FROM REPMQ r WHERE r.mq018 = :mq018")
    , @NamedQuery(name = "REPMQ.findByMq019", query = "SELECT r FROM REPMQ r WHERE r.mq019 = :mq019")
    , @NamedQuery(name = "REPMQ.findByMq020", query = "SELECT r FROM REPMQ r WHERE r.mq020 = :mq020")
    , @NamedQuery(name = "REPMQ.findByMq021", query = "SELECT r FROM REPMQ r WHERE r.mq021 = :mq021")
    , @NamedQuery(name = "REPMQ.findByMq022", query = "SELECT r FROM REPMQ r WHERE r.mq022 = :mq022")
    , @NamedQuery(name = "REPMQ.findByMq023", query = "SELECT r FROM REPMQ r WHERE r.mq023 = :mq023")
    , @NamedQuery(name = "REPMQ.findByMq024", query = "SELECT r FROM REPMQ r WHERE r.mq024 = :mq024")
    , @NamedQuery(name = "REPMQ.findByCustomer", query = "SELECT r FROM REPMQ r WHERE r.customer = :customer")
    , @NamedQuery(name = "REPMQ.findByProduct", query = "SELECT r FROM REPMQ r WHERE r.product = :product")
    , @NamedQuery(name = "REPMQ.findByRegion", query = "SELECT r FROM REPMQ r WHERE r.region = :region")
    , @NamedQuery(name = "REPMQ.findByDealer", query = "SELECT r FROM REPMQ r WHERE r.dealer = :dealer")
    , @NamedQuery(name = "REPMQ.findByMq025", query = "SELECT r FROM REPMQ r WHERE r.mq025 = :mq025")
    , @NamedQuery(name = "REPMQ.findByMq026", query = "SELECT r FROM REPMQ r WHERE r.mq026 = :mq026")
    , @NamedQuery(name = "REPMQ.findByMq027", query = "SELECT r FROM REPMQ r WHERE r.mq027 = :mq027")
    , @NamedQuery(name = "REPMQ.findByMq028", query = "SELECT r FROM REPMQ r WHERE r.mq028 = :mq028")
    , @NamedQuery(name = "REPMQ.findByMq029", query = "SELECT r FROM REPMQ r WHERE r.mq029 = :mq029")
    , @NamedQuery(name = "REPMQ.findByMq030", query = "SELECT r FROM REPMQ r WHERE r.mq030 = :mq030")
    , @NamedQuery(name = "REPMQ.findByMq031", query = "SELECT r FROM REPMQ r WHERE r.mq031 = :mq031")
    , @NamedQuery(name = "REPMQ.findByRepmq01", query = "SELECT r FROM REPMQ r WHERE r.repmq01 = :repmq01")
    , @NamedQuery(name = "REPMQ.findByRepmq02", query = "SELECT r FROM REPMQ r WHERE r.repmq02 = :repmq02")
    , @NamedQuery(name = "REPMQ.findByRepmq03", query = "SELECT r FROM REPMQ r WHERE r.repmq03 = :repmq03")
    , @NamedQuery(name = "REPMQ.findByRepmq04", query = "SELECT r FROM REPMQ r WHERE r.repmq04 = :repmq04")
    , @NamedQuery(name = "REPMQ.findByRepmq05", query = "SELECT r FROM REPMQ r WHERE r.repmq05 = :repmq05")
    , @NamedQuery(name = "REPMQ.findByRepmq06", query = "SELECT r FROM REPMQ r WHERE r.repmq06 = :repmq06")
    , @NamedQuery(name = "REPMQ.findByRepmq07", query = "SELECT r FROM REPMQ r WHERE r.repmq07 = :repmq07")
    , @NamedQuery(name = "REPMQ.findByRepmq08", query = "SELECT r FROM REPMQ r WHERE r.repmq08 = :repmq08")
    , @NamedQuery(name = "REPMQ.findByRepmq09", query = "SELECT r FROM REPMQ r WHERE r.repmq09 = :repmq09")
    , @NamedQuery(name = "REPMQ.findByRepmq10", query = "SELECT r FROM REPMQ r WHERE r.repmq10 = :repmq10")
    , @NamedQuery(name = "REPMQ.findByRepmq11", query = "SELECT r FROM REPMQ r WHERE r.repmq11 = :repmq11")
    , @NamedQuery(name = "REPMQ.findByRepmq12", query = "SELECT r FROM REPMQ r WHERE r.repmq12 = :repmq12")
    , @NamedQuery(name = "REPMQ.findByRepmq13", query = "SELECT r FROM REPMQ r WHERE r.repmq13 = :repmq13")
    , @NamedQuery(name = "REPMQ.findByRepmq14", query = "SELECT r FROM REPMQ r WHERE r.repmq14 = :repmq14")
    , @NamedQuery(name = "REPMQ.findByRepmq15", query = "SELECT r FROM REPMQ r WHERE r.repmq15 = :repmq15")
    , @NamedQuery(name = "REPMQ.findByRepmq16", query = "SELECT r FROM REPMQ r WHERE r.repmq16 = :repmq16")
    , @NamedQuery(name = "REPMQ.findByRepmq17", query = "SELECT r FROM REPMQ r WHERE r.repmq17 = :repmq17")
    , @NamedQuery(name = "REPMQ.findByRepmq18", query = "SELECT r FROM REPMQ r WHERE r.repmq18 = :repmq18")
    , @NamedQuery(name = "REPMQ.findByRepmq19", query = "SELECT r FROM REPMQ r WHERE r.repmq19 = :repmq19")
    , @NamedQuery(name = "REPMQ.findByRepmq20", query = "SELECT r FROM REPMQ r WHERE r.repmq20 = :repmq20")
    , @NamedQuery(name = "REPMQ.findByMq032", query = "SELECT r FROM REPMQ r WHERE r.mq032 = :mq032")
   
})
public class REPMQ implements Serializable {

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
    @Size(min = 1, max = 4)
    @Column(name = "MQ001")
    private String mq001;
    @Size(max = 10)
    @Column(name = "MQ002")
    private String mq002;
    @Size(max = 2)
    @Column(name = "MQ003")
    private String mq003;
    @Size(max = 1)
    @Column(name = "MQ004")
    private String mq004;
    @Column(name = "MQ005")
    private Short mq005;
    @Column(name = "MQ006")
    private Short mq006;
    @Size(max = 1)
    @Column(name = "MQ007")
    private String mq007;
    @Size(max = 1)
    @Column(name = "MQ008")
    private String mq008;
    @Size(max = 1)
    @Column(name = "MQ009")
    private String mq009;
    @Size(max = 1)
    @Column(name = "MQ010")
    private String mq010;
    @Size(max = 4)
    @Column(name = "MQ011")
    private String mq011;
    @Size(max = 255)
    @Column(name = "MQ012")
    private String mq012;
    @Size(max = 1)
    @Column(name = "MQ013")
    private String mq013;
    @Column(name = "MQ014")
    private Short mq014;
    @Size(max = 20)
    @Column(name = "MQ015")
    private String mq015;
    @Size(max = 1)
    @Column(name = "MQ016")
    private String mq016;
    @Size(max = 1)
    @Column(name = "MQ017")
    private String mq017;
    @Size(max = 1)
    @Column(name = "MQ018")
    private String mq018;
    @Size(max = 1)
    @Column(name = "MQ019")
    private String mq019;
    @Size(max = 20)
    @Column(name = "MQ020")
    private String mq020;
    @Size(max = 1)
    @Column(name = "MQ021")
    private String mq021;
    @Size(max = 20)
    @Column(name = "MQ022")
    private String mq022;
    @Size(max = 1)
    @Column(name = "MQ023")
    private String mq023;
    @Size(max = 100)
    @Column(name = "MQ024")
    private String mq024;
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
    @Size(max = 1)
    @Column(name = "MQ025")
    private String mq025;
    @Size(max = 1)
    @Column(name = "MQ026")
    private String mq026;
    @Size(max = 1)
    @Column(name = "MQ027")
    private String mq027;
    @Size(max = 4)
    @Column(name = "MQ028")
    private String mq028;
    @Size(max = 10)
    @Column(name = "MQ029")
    private String mq029;
    @Size(max = 1)
    @Column(name = "MQ030")
    private String mq030;
    @Size(max = 4)
    @Column(name = "MQ031")
    private String mq031;
    @Size(max = 255)
    @Column(name = "REPMQ01")
    private String repmq01;
    @Size(max = 255)
    @Column(name = "REPMQ02")
    private String repmq02;
    @Size(max = 255)
    @Column(name = "REPMQ03")
    private String repmq03;
    @Size(max = 255)
    @Column(name = "REPMQ04")
    private String repmq04;
    @Size(max = 255)
    @Column(name = "REPMQ05")
    private String repmq05;
    @Size(max = 255)
    @Column(name = "REPMQ06")
    private String repmq06;
    @Size(max = 255)
    @Column(name = "REPMQ07")
    private String repmq07;
    @Size(max = 255)
    @Column(name = "REPMQ08")
    private String repmq08;
    @Size(max = 255)
    @Column(name = "REPMQ09")
    private String repmq09;
    @Size(max = 255)
    @Column(name = "REPMQ10")
    private String repmq10;
    @Size(max = 255)
    @Column(name = "REPMQ11")
    private String repmq11;
    @Size(max = 255)
    @Column(name = "REPMQ12")
    private String repmq12;
    @Size(max = 255)
    @Column(name = "REPMQ13")
    private String repmq13;
    @Size(max = 255)
    @Column(name = "REPMQ14")
    private String repmq14;
    @Size(max = 255)
    @Column(name = "REPMQ15")
    private String repmq15;
    @Size(max = 255)
    @Column(name = "REPMQ16")
    private String repmq16;
    @Size(max = 255)
    @Column(name = "REPMQ17")
    private String repmq17;
    @Size(max = 255)
    @Column(name = "REPMQ18")
    private String repmq18;
    @Size(max = 255)
    @Column(name = "REPMQ19")
    private String repmq19;
    @Size(max = 255)
    @Column(name = "REPMQ20")
    private String repmq20;
    @Size(max = 1)
    @Column(name = "MQ032")
    private String mq032;

    public REPMQ() {
    }

    public REPMQ(String mq001) {
        this.mq001 = mq001;
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

    public String getMq001() {
        return mq001;
    }

    public void setMq001(String mq001) {
        this.mq001 = mq001;
    }

    public String getMq002() {
        return mq002;
    }

    public void setMq002(String mq002) {
        this.mq002 = mq002;
    }

    public String getMq003() {
        return mq003;
    }

    public void setMq003(String mq003) {
        this.mq003 = mq003;
    }

    public String getMq004() {
        return mq004;
    }

    public void setMq004(String mq004) {
        this.mq004 = mq004;
    }

    public Short getMq005() {
        return mq005;
    }

    public void setMq005(Short mq005) {
        this.mq005 = mq005;
    }

    public Short getMq006() {
        return mq006;
    }

    public void setMq006(Short mq006) {
        this.mq006 = mq006;
    }

    public String getMq007() {
        return mq007;
    }

    public void setMq007(String mq007) {
        this.mq007 = mq007;
    }

    public String getMq008() {
        return mq008;
    }

    public void setMq008(String mq008) {
        this.mq008 = mq008;
    }

    public String getMq009() {
        return mq009;
    }

    public void setMq009(String mq009) {
        this.mq009 = mq009;
    }

    public String getMq010() {
        return mq010;
    }

    public void setMq010(String mq010) {
        this.mq010 = mq010;
    }

    public String getMq011() {
        return mq011;
    }

    public void setMq011(String mq011) {
        this.mq011 = mq011;
    }

    public String getMq012() {
        return mq012;
    }

    public void setMq012(String mq012) {
        this.mq012 = mq012;
    }

    public String getMq013() {
        return mq013;
    }

    public void setMq013(String mq013) {
        this.mq013 = mq013;
    }

    public Short getMq014() {
        return mq014;
    }

    public void setMq014(Short mq014) {
        this.mq014 = mq014;
    }

    public String getMq015() {
        return mq015;
    }

    public void setMq015(String mq015) {
        this.mq015 = mq015;
    }

    public String getMq016() {
        return mq016;
    }

    public void setMq016(String mq016) {
        this.mq016 = mq016;
    }

    public String getMq017() {
        return mq017;
    }

    public void setMq017(String mq017) {
        this.mq017 = mq017;
    }

    public String getMq018() {
        return mq018;
    }

    public void setMq018(String mq018) {
        this.mq018 = mq018;
    }

    public String getMq019() {
        return mq019;
    }

    public void setMq019(String mq019) {
        this.mq019 = mq019;
    }

    public String getMq020() {
        return mq020;
    }

    public void setMq020(String mq020) {
        this.mq020 = mq020;
    }

    public String getMq021() {
        return mq021;
    }

    public void setMq021(String mq021) {
        this.mq021 = mq021;
    }

    public String getMq022() {
        return mq022;
    }

    public void setMq022(String mq022) {
        this.mq022 = mq022;
    }

    public String getMq023() {
        return mq023;
    }

    public void setMq023(String mq023) {
        this.mq023 = mq023;
    }

    public String getMq024() {
        return mq024;
    }

    public void setMq024(String mq024) {
        this.mq024 = mq024;
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

    public String getMq025() {
        return mq025;
    }

    public void setMq025(String mq025) {
        this.mq025 = mq025;
    }

    public String getMq026() {
        return mq026;
    }

    public void setMq026(String mq026) {
        this.mq026 = mq026;
    }

    public String getMq027() {
        return mq027;
    }

    public void setMq027(String mq027) {
        this.mq027 = mq027;
    }

    public String getMq028() {
        return mq028;
    }

    public void setMq028(String mq028) {
        this.mq028 = mq028;
    }

    public String getMq029() {
        return mq029;
    }

    public void setMq029(String mq029) {
        this.mq029 = mq029;
    }

    public String getMq030() {
        return mq030;
    }

    public void setMq030(String mq030) {
        this.mq030 = mq030;
    }

    public String getMq031() {
        return mq031;
    }

    public void setMq031(String mq031) {
        this.mq031 = mq031;
    }

    public String getRepmq01() {
        return repmq01;
    }

    public void setRepmq01(String repmq01) {
        this.repmq01 = repmq01;
    }

    public String getRepmq02() {
        return repmq02;
    }

    public void setRepmq02(String repmq02) {
        this.repmq02 = repmq02;
    }

    public String getRepmq03() {
        return repmq03;
    }

    public void setRepmq03(String repmq03) {
        this.repmq03 = repmq03;
    }

    public String getRepmq04() {
        return repmq04;
    }

    public void setRepmq04(String repmq04) {
        this.repmq04 = repmq04;
    }

    public String getRepmq05() {
        return repmq05;
    }

    public void setRepmq05(String repmq05) {
        this.repmq05 = repmq05;
    }

    public String getRepmq06() {
        return repmq06;
    }

    public void setRepmq06(String repmq06) {
        this.repmq06 = repmq06;
    }

    public String getRepmq07() {
        return repmq07;
    }

    public void setRepmq07(String repmq07) {
        this.repmq07 = repmq07;
    }

    public String getRepmq08() {
        return repmq08;
    }

    public void setRepmq08(String repmq08) {
        this.repmq08 = repmq08;
    }

    public String getRepmq09() {
        return repmq09;
    }

    public void setRepmq09(String repmq09) {
        this.repmq09 = repmq09;
    }

    public String getRepmq10() {
        return repmq10;
    }

    public void setRepmq10(String repmq10) {
        this.repmq10 = repmq10;
    }

    public String getRepmq11() {
        return repmq11;
    }

    public void setRepmq11(String repmq11) {
        this.repmq11 = repmq11;
    }

    public String getRepmq12() {
        return repmq12;
    }

    public void setRepmq12(String repmq12) {
        this.repmq12 = repmq12;
    }

    public String getRepmq13() {
        return repmq13;
    }

    public void setRepmq13(String repmq13) {
        this.repmq13 = repmq13;
    }

    public String getRepmq14() {
        return repmq14;
    }

    public void setRepmq14(String repmq14) {
        this.repmq14 = repmq14;
    }

    public String getRepmq15() {
        return repmq15;
    }

    public void setRepmq15(String repmq15) {
        this.repmq15 = repmq15;
    }

    public String getRepmq16() {
        return repmq16;
    }

    public void setRepmq16(String repmq16) {
        this.repmq16 = repmq16;
    }

    public String getRepmq17() {
        return repmq17;
    }

    public void setRepmq17(String repmq17) {
        this.repmq17 = repmq17;
    }

    public String getRepmq18() {
        return repmq18;
    }

    public void setRepmq18(String repmq18) {
        this.repmq18 = repmq18;
    }

    public String getRepmq19() {
        return repmq19;
    }

    public void setRepmq19(String repmq19) {
        this.repmq19 = repmq19;
    }

    public String getRepmq20() {
        return repmq20;
    }

    public void setRepmq20(String repmq20) {
        this.repmq20 = repmq20;
    }

    public String getMq032() {
        return mq032;
    }

    public void setMq032(String mq032) {
        this.mq032 = mq032;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mq001 != null ? mq001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMQ)) {
            return false;
        }
        REPMQ other = (REPMQ) object;
        if ((this.mq001 == null && other.mq001 != null) || (this.mq001 != null && !this.mq001.equals(other.mq001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMQ[ mq001=" + mq001 + " ]";
    }
    
}
