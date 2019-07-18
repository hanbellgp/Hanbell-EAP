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
 * @author C1587
 */
@Entity
@Table(name = "SERBR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERBR.findAll", query = "SELECT s FROM SERBR s"),
    @NamedQuery(name = "SERBR.findByCompany", query = "SELECT s FROM SERBR s WHERE s.company = :company"),
    @NamedQuery(name = "SERBR.findByCreator", query = "SELECT s FROM SERBR s WHERE s.creator = :creator"),
    @NamedQuery(name = "SERBR.findByUsrGroup", query = "SELECT s FROM SERBR s WHERE s.usrGroup = :usrGroup"),
    @NamedQuery(name = "SERBR.findByCreateDate", query = "SELECT s FROM SERBR s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SERBR.findByModifier", query = "SELECT s FROM SERBR s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SERBR.findByModiDate", query = "SELECT s FROM SERBR s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SERBR.findByFlag", query = "SELECT s FROM SERBR s WHERE s.flag = :flag"),
    @NamedQuery(name = "SERBR.findByPK", query = "SELECT s FROM SERBR s WHERE s.sERBRPK.br001 = :br001 and s.sERBRPK.br002 = :br002"),
    @NamedQuery(name = "SERBR.findByBr001", query = "SELECT s FROM SERBR s WHERE s.sERBRPK.br001 = :br001"),
    @NamedQuery(name = "SERBR.findByBr002", query = "SELECT s FROM SERBR s WHERE s.sERBRPK.br002 = :br002"),
    @NamedQuery(name = "SERBR.findByBr003", query = "SELECT s FROM SERBR s WHERE s.br003 = :br003"),
    @NamedQuery(name = "SERBR.findByBr004", query = "SELECT s FROM SERBR s WHERE s.br004 = :br004"),
    @NamedQuery(name = "SERBR.findByBr005", query = "SELECT s FROM SERBR s WHERE s.br005 = :br005"),
    @NamedQuery(name = "SERBR.findByBr006", query = "SELECT s FROM SERBR s WHERE s.br006 = :br006"),
    @NamedQuery(name = "SERBR.findByBr007", query = "SELECT s FROM SERBR s WHERE s.br007 = :br007"),
    @NamedQuery(name = "SERBR.findByBr008", query = "SELECT s FROM SERBR s WHERE s.br008 = :br008"),
    @NamedQuery(name = "SERBR.findByBr009", query = "SELECT s FROM SERBR s WHERE s.br009 = :br009"),
    @NamedQuery(name = "SERBR.findByBr010", query = "SELECT s FROM SERBR s WHERE s.br010 = :br010"),
    @NamedQuery(name = "SERBR.findByBr011", query = "SELECT s FROM SERBR s WHERE s.br011 = :br011"),
    @NamedQuery(name = "SERBR.findByBr012", query = "SELECT s FROM SERBR s WHERE s.br012 = :br012"),
    @NamedQuery(name = "SERBR.findByBr013", query = "SELECT s FROM SERBR s WHERE s.br013 = :br013"),
    @NamedQuery(name = "SERBR.findByBr014", query = "SELECT s FROM SERBR s WHERE s.br014 = :br014"),
    @NamedQuery(name = "SERBR.findByBr015", query = "SELECT s FROM SERBR s WHERE s.br015 = :br015"),
    @NamedQuery(name = "SERBR.findByBr016", query = "SELECT s FROM SERBR s WHERE s.br016 = :br016"),
    @NamedQuery(name = "SERBR.findByBr017", query = "SELECT s FROM SERBR s WHERE s.br017 = :br017"),
    @NamedQuery(name = "SERBR.findByBr018", query = "SELECT s FROM SERBR s WHERE s.br018 = :br018"),
    @NamedQuery(name = "SERBR.findByBr019", query = "SELECT s FROM SERBR s WHERE s.br019 = :br019"),
    @NamedQuery(name = "SERBR.findByBr020", query = "SELECT s FROM SERBR s WHERE s.br020 = :br020"),
    @NamedQuery(name = "SERBR.findByBr021", query = "SELECT s FROM SERBR s WHERE s.br021 = :br021"),
    @NamedQuery(name = "SERBR.findByBr022", query = "SELECT s FROM SERBR s WHERE s.br022 = :br022"),
    @NamedQuery(name = "SERBR.findByBr023", query = "SELECT s FROM SERBR s WHERE s.br023 = :br023"),
    @NamedQuery(name = "SERBR.findByBr024", query = "SELECT s FROM SERBR s WHERE s.br024 = :br024"),
    @NamedQuery(name = "SERBR.findByBr025", query = "SELECT s FROM SERBR s WHERE s.br025 = :br025"),
    @NamedQuery(name = "SERBR.findByBr026", query = "SELECT s FROM SERBR s WHERE s.br026 = :br026"),
    @NamedQuery(name = "SERBR.findByBr027", query = "SELECT s FROM SERBR s WHERE s.br027 = :br027"),
    @NamedQuery(name = "SERBR.findByBr028", query = "SELECT s FROM SERBR s WHERE s.br028 = :br028"),
    @NamedQuery(name = "SERBR.findByBr029", query = "SELECT s FROM SERBR s WHERE s.br029 = :br029"),
    @NamedQuery(name = "SERBR.findByBr030", query = "SELECT s FROM SERBR s WHERE s.br030 = :br030"),
    @NamedQuery(name = "SERBR.findByBr031", query = "SELECT s FROM SERBR s WHERE s.br031 = :br031"),
    @NamedQuery(name = "SERBR.findByBr032", query = "SELECT s FROM SERBR s WHERE s.br032 = :br032"),
    @NamedQuery(name = "SERBR.findByBr033", query = "SELECT s FROM SERBR s WHERE s.br033 = :br033"),
    @NamedQuery(name = "SERBR.findByBr034", query = "SELECT s FROM SERBR s WHERE s.br034 = :br034"),
    @NamedQuery(name = "SERBR.findByBr035", query = "SELECT s FROM SERBR s WHERE s.br035 = :br035"),
    @NamedQuery(name = "SERBR.findByCustomer", query = "SELECT s FROM SERBR s WHERE s.customer = :customer"),
    @NamedQuery(name = "SERBR.findByProduct", query = "SELECT s FROM SERBR s WHERE s.product = :product"),
    @NamedQuery(name = "SERBR.findByRegion", query = "SELECT s FROM SERBR s WHERE s.region = :region"),
    @NamedQuery(name = "SERBR.findByDealer", query = "SELECT s FROM SERBR s WHERE s.dealer = :dealer"),
    @NamedQuery(name = "SERBR.findByBr197", query = "SELECT s FROM SERBR s WHERE s.br197 = :br197"),
    @NamedQuery(name = "SERBR.findByBr198", query = "SELECT s FROM SERBR s WHERE s.br198 = :br198"),
    @NamedQuery(name = "SERBR.findByBr199", query = "SELECT s FROM SERBR s WHERE s.br199 = :br199"),
    @NamedQuery(name = "SERBR.findBySerbr01", query = "SELECT s FROM SERBR s WHERE s.serbr01 = :serbr01"),
    @NamedQuery(name = "SERBR.findBySerbr02", query = "SELECT s FROM SERBR s WHERE s.serbr02 = :serbr02"),
    @NamedQuery(name = "SERBR.findBySerbr03", query = "SELECT s FROM SERBR s WHERE s.serbr03 = :serbr03"),
    @NamedQuery(name = "SERBR.findBySerbr04", query = "SELECT s FROM SERBR s WHERE s.serbr04 = :serbr04"),
    @NamedQuery(name = "SERBR.findBySerbr05", query = "SELECT s FROM SERBR s WHERE s.serbr05 = :serbr05"),
    @NamedQuery(name = "SERBR.findBySerbr06", query = "SELECT s FROM SERBR s WHERE s.serbr06 = :serbr06"),
    @NamedQuery(name = "SERBR.findBySerbr07", query = "SELECT s FROM SERBR s WHERE s.serbr07 = :serbr07"),
    @NamedQuery(name = "SERBR.findBySerbr08", query = "SELECT s FROM SERBR s WHERE s.serbr08 = :serbr08"),
    @NamedQuery(name = "SERBR.findBySerbr09", query = "SELECT s FROM SERBR s WHERE s.serbr09 = :serbr09"),
    @NamedQuery(name = "SERBR.findBySerbr10", query = "SELECT s FROM SERBR s WHERE s.serbr10 = :serbr10"),
    @NamedQuery(name = "SERBR.findBySerbr11", query = "SELECT s FROM SERBR s WHERE s.serbr11 = :serbr11"),
    @NamedQuery(name = "SERBR.findBySerbr12", query = "SELECT s FROM SERBR s WHERE s.serbr12 = :serbr12"),
    @NamedQuery(name = "SERBR.findBySerbr13", query = "SELECT s FROM SERBR s WHERE s.serbr13 = :serbr13"),
    @NamedQuery(name = "SERBR.findBySerbr14", query = "SELECT s FROM SERBR s WHERE s.serbr14 = :serbr14"),
    @NamedQuery(name = "SERBR.findBySerbr15", query = "SELECT s FROM SERBR s WHERE s.serbr15 = :serbr15"),
    @NamedQuery(name = "SERBR.findBySerbr16", query = "SELECT s FROM SERBR s WHERE s.serbr16 = :serbr16"),
    @NamedQuery(name = "SERBR.findBySerbr17", query = "SELECT s FROM SERBR s WHERE s.serbr17 = :serbr17"),
    @NamedQuery(name = "SERBR.findBySerbr18", query = "SELECT s FROM SERBR s WHERE s.serbr18 = :serbr18"),
    @NamedQuery(name = "SERBR.findBySerbr19", query = "SELECT s FROM SERBR s WHERE s.serbr19 = :serbr19"),
    @NamedQuery(name = "SERBR.findBySerbr20", query = "SELECT s FROM SERBR s WHERE s.serbr20 = :serbr20"),
    @NamedQuery(name = "SERBR.findByBr036", query = "SELECT s FROM SERBR s WHERE s.br036 = :br036")})
public class SERBR implements Serializable {

    @Size(max = 1)
    @Column(name = "BR037")
    private String br037;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SERBRPK sERBRPK;
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
    @Size(max = 8)
    @Column(name = "BR003")
    private String br003;
    @Size(max = 1)
    @Column(name = "BR004")
    private String br004;
    @Size(max = 4000)
    @Column(name = "BR005")
    private String br005;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BR006")
    private BigDecimal br006;
    @Size(max = 1)
    @Column(name = "BR007")
    private String br007;
    @Size(max = 6)
    @Column(name = "BR008")
    private String br008;
    @Size(max = 8)
    @Column(name = "BR009")
    private String br009;
    @Size(max = 4)
    @Column(name = "BR010")
    private String br010;
    @Size(max = 10)
    @Column(name = "BR011")
    private String br011;
    @Size(max = 10)
    @Column(name = "BR012")
    private String br012;
    @Size(max = 10)
    @Column(name = "BR013")
    private String br013;
    @Size(max = 10)
    @Column(name = "BR014")
    private String br014;
    @Size(max = 1)
    @Column(name = "BR015")
    private String br015;
    @Size(max = 8)
    @Column(name = "BR016")
    private String br016;
    @Size(max = 10)
    @Column(name = "BR017")
    private String br017;
    @Size(max = 4)
    @Column(name = "BR018")
    private String br018;
    @Size(max = 1)
    @Column(name = "BR019")
    private String br019;
    @Size(max = 4)
    @Column(name = "BR020")
    private String br020;
    @Size(max = 11)
    @Column(name = "BR021")
    private String br021;
    @Column(name = "BR022")
    private BigDecimal br022;
    @Size(max = 1)
    @Column(name = "BR023")
    private String br023;
    @Size(max = 1)
    @Column(name = "BR024")
    private String br024;
    @Size(max = 1073741823)
    @Column(name = "BR025")
    private String br025;
    @Size(max = 1)
    @Column(name = "BR026")
    private String br026;
    @Size(max = 1)
    @Column(name = "BR027")
    private String br027;
    @Size(max = 1)
    @Column(name = "BR028")
    private String br028;
    @Size(max = 6)
    @Column(name = "BR029")
    private String br029;
    @Size(max = 10)
    @Column(name = "BR030")
    private String br030;
    @Size(max = 10)
    @Column(name = "BR031")
    private String br031;
    @Size(max = 10)
    @Column(name = "BR032")
    private String br032;
    @Size(max = 10)
    @Column(name = "BR033")
    private String br033;
    @Size(max = 1)
    @Column(name = "BR034")
    private String br034;
    @Size(max = 1073741823)
    @Column(name = "BR035")
    private String br035;
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
    @Column(name = "BR197")
    private String br197;
    @Size(max = 10)
    @Column(name = "BR198")
    private String br198;
    @Size(max = 10)
    @Column(name = "BR199")
    private String br199;
    @Size(max = 255)
    @Column(name = "SERBR01")
    private String serbr01;
    @Size(max = 255)
    @Column(name = "SERBR02")
    private String serbr02;
    @Size(max = 255)
    @Column(name = "SERBR03")
    private String serbr03;
    @Size(max = 255)
    @Column(name = "SERBR04")
    private String serbr04;
    @Size(max = 255)
    @Column(name = "SERBR05")
    private String serbr05;
    @Size(max = 255)
    @Column(name = "SERBR06")
    private String serbr06;
    @Size(max = 255)
    @Column(name = "SERBR07")
    private String serbr07;
    @Size(max = 255)
    @Column(name = "SERBR08")
    private String serbr08;
    @Size(max = 255)
    @Column(name = "SERBR09")
    private String serbr09;
    @Size(max = 255)
    @Column(name = "SERBR10")
    private String serbr10;
    @Size(max = 255)
    @Column(name = "SERBR11")
    private String serbr11;
    @Size(max = 255)
    @Column(name = "SERBR12")
    private String serbr12;
    @Size(max = 255)
    @Column(name = "SERBR13")
    private String serbr13;
    @Size(max = 255)
    @Column(name = "SERBR14")
    private String serbr14;
    @Size(max = 255)
    @Column(name = "SERBR15")
    private String serbr15;
    @Size(max = 255)
    @Column(name = "SERBR16")
    private String serbr16;
    @Size(max = 255)
    @Column(name = "SERBR17")
    private String serbr17;
    @Size(max = 255)
    @Column(name = "SERBR18")
    private String serbr18;
    @Size(max = 255)
    @Column(name = "SERBR19")
    private String serbr19;
    @Size(max = 255)
    @Column(name = "SERBR20")
    private String serbr20;
    @Size(max = 4)
    @Column(name = "BR036")
    private String br036;

    public SERBR() {
    }

    public SERBR(SERBRPK sERBRPK) {
        this.sERBRPK = sERBRPK;
    }

    public SERBR(String br001, String br002) {
        this.sERBRPK = new SERBRPK(br001, br002);
    }

    public SERBRPK getSERBRPK() {
        return sERBRPK;
    }

    public void setSERBRPK(SERBRPK sERBRPK) {
        this.sERBRPK = sERBRPK;
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

    public String getBr003() {
        return br003;
    }

    public void setBr003(String br003) {
        this.br003 = br003;
    }

    public String getBr004() {
        return br004;
    }

    public void setBr004(String br004) {
        this.br004 = br004;
    }

    public String getBr005() {
        return br005;
    }

    public void setBr005(String br005) {
        this.br005 = br005;
    }

    public BigDecimal getBr006() {
        return br006;
    }

    public void setBr006(BigDecimal br006) {
        this.br006 = br006;
    }

    public String getBr007() {
        return br007;
    }

    public void setBr007(String br007) {
        this.br007 = br007;
    }

    public String getBr008() {
        return br008;
    }

    public void setBr008(String br008) {
        this.br008 = br008;
    }

    public String getBr009() {
        return br009;
    }

    public void setBr009(String br009) {
        this.br009 = br009;
    }

    public String getBr010() {
        return br010;
    }

    public void setBr010(String br010) {
        this.br010 = br010;
    }

    public String getBr011() {
        return br011;
    }

    public void setBr011(String br011) {
        this.br011 = br011;
    }

    public String getBr012() {
        return br012;
    }

    public void setBr012(String br012) {
        this.br012 = br012;
    }

    public String getBr013() {
        return br013;
    }

    public void setBr013(String br013) {
        this.br013 = br013;
    }

    public String getBr014() {
        return br014;
    }

    public void setBr014(String br014) {
        this.br014 = br014;
    }

    public String getBr015() {
        return br015;
    }

    public void setBr015(String br015) {
        this.br015 = br015;
    }

    public String getBr016() {
        return br016;
    }

    public void setBr016(String br016) {
        this.br016 = br016;
    }

    public String getBr017() {
        return br017;
    }

    public void setBr017(String br017) {
        this.br017 = br017;
    }

    public String getBr018() {
        return br018;
    }

    public void setBr018(String br018) {
        this.br018 = br018;
    }

    public String getBr019() {
        return br019;
    }

    public void setBr019(String br019) {
        this.br019 = br019;
    }

    public String getBr020() {
        return br020;
    }

    public void setBr020(String br020) {
        this.br020 = br020;
    }

    public String getBr021() {
        return br021;
    }

    public void setBr021(String br021) {
        this.br021 = br021;
    }

    public BigDecimal getBr022() {
        return br022;
    }

    public void setBr022(BigDecimal br022) {
        this.br022 = br022;
    }

    public String getBr023() {
        return br023;
    }

    public void setBr023(String br023) {
        this.br023 = br023;
    }

    public String getBr024() {
        return br024;
    }

    public void setBr024(String br024) {
        this.br024 = br024;
    }

    public String getBr025() {
        return br025;
    }

    public void setBr025(String br025) {
        this.br025 = br025;
    }

    public String getBr026() {
        return br026;
    }

    public void setBr026(String br026) {
        this.br026 = br026;
    }

    public String getBr027() {
        return br027;
    }

    public void setBr027(String br027) {
        this.br027 = br027;
    }

    public String getBr028() {
        return br028;
    }

    public void setBr028(String br028) {
        this.br028 = br028;
    }

    public String getBr029() {
        return br029;
    }

    public void setBr029(String br029) {
        this.br029 = br029;
    }

    public String getBr030() {
        return br030;
    }

    public void setBr030(String br030) {
        this.br030 = br030;
    }

    public String getBr031() {
        return br031;
    }

    public void setBr031(String br031) {
        this.br031 = br031;
    }

    public String getBr032() {
        return br032;
    }

    public void setBr032(String br032) {
        this.br032 = br032;
    }

    public String getBr033() {
        return br033;
    }

    public void setBr033(String br033) {
        this.br033 = br033;
    }

    public String getBr034() {
        return br034;
    }

    public void setBr034(String br034) {
        this.br034 = br034;
    }

    public String getBr035() {
        return br035;
    }

    public void setBr035(String br035) {
        this.br035 = br035;
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

    public String getBr197() {
        return br197;
    }

    public void setBr197(String br197) {
        this.br197 = br197;
    }

    public String getBr198() {
        return br198;
    }

    public void setBr198(String br198) {
        this.br198 = br198;
    }

    public String getBr199() {
        return br199;
    }

    public void setBr199(String br199) {
        this.br199 = br199;
    }

    public String getSerbr01() {
        return serbr01;
    }

    public void setSerbr01(String serbr01) {
        this.serbr01 = serbr01;
    }

    public String getSerbr02() {
        return serbr02;
    }

    public void setSerbr02(String serbr02) {
        this.serbr02 = serbr02;
    }

    public String getSerbr03() {
        return serbr03;
    }

    public void setSerbr03(String serbr03) {
        this.serbr03 = serbr03;
    }

    public String getSerbr04() {
        return serbr04;
    }

    public void setSerbr04(String serbr04) {
        this.serbr04 = serbr04;
    }

    public String getSerbr05() {
        return serbr05;
    }

    public void setSerbr05(String serbr05) {
        this.serbr05 = serbr05;
    }

    public String getSerbr06() {
        return serbr06;
    }

    public void setSerbr06(String serbr06) {
        this.serbr06 = serbr06;
    }

    public String getSerbr07() {
        return serbr07;
    }

    public void setSerbr07(String serbr07) {
        this.serbr07 = serbr07;
    }

    public String getSerbr08() {
        return serbr08;
    }

    public void setSerbr08(String serbr08) {
        this.serbr08 = serbr08;
    }

    public String getSerbr09() {
        return serbr09;
    }

    public void setSerbr09(String serbr09) {
        this.serbr09 = serbr09;
    }

    public String getSerbr10() {
        return serbr10;
    }

    public void setSerbr10(String serbr10) {
        this.serbr10 = serbr10;
    }

    public String getSerbr11() {
        return serbr11;
    }

    public void setSerbr11(String serbr11) {
        this.serbr11 = serbr11;
    }

    public String getSerbr12() {
        return serbr12;
    }

    public void setSerbr12(String serbr12) {
        this.serbr12 = serbr12;
    }

    public String getSerbr13() {
        return serbr13;
    }

    public void setSerbr13(String serbr13) {
        this.serbr13 = serbr13;
    }

    public String getSerbr14() {
        return serbr14;
    }

    public void setSerbr14(String serbr14) {
        this.serbr14 = serbr14;
    }

    public String getSerbr15() {
        return serbr15;
    }

    public void setSerbr15(String serbr15) {
        this.serbr15 = serbr15;
    }

    public String getSerbr16() {
        return serbr16;
    }

    public void setSerbr16(String serbr16) {
        this.serbr16 = serbr16;
    }

    public String getSerbr17() {
        return serbr17;
    }

    public void setSerbr17(String serbr17) {
        this.serbr17 = serbr17;
    }

    public String getSerbr18() {
        return serbr18;
    }

    public void setSerbr18(String serbr18) {
        this.serbr18 = serbr18;
    }

    public String getSerbr19() {
        return serbr19;
    }

    public void setSerbr19(String serbr19) {
        this.serbr19 = serbr19;
    }

    public String getSerbr20() {
        return serbr20;
    }

    public void setSerbr20(String serbr20) {
        this.serbr20 = serbr20;
    }

    public String getBr036() {
        return br036;
    }

    public void setBr036(String br036) {
        this.br036 = br036;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sERBRPK != null ? sERBRPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERBR)) {
            return false;
        }
        SERBR other = (SERBR) object;
        if ((this.sERBRPK == null && other.sERBRPK != null) || (this.sERBRPK != null && !this.sERBRPK.equals(other.sERBRPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SERBR[ sERBRPK=" + sERBRPK + " ]";
    }

    public String getBr037() {
        return br037;
    }

    public void setBr037(String br037) {
        this.br037 = br037;
    }
    
}
