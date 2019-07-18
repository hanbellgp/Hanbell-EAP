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
 * @author Administrator
 */
@Entity
@Table(name = "WARMB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARMB.findAll", query = "SELECT w FROM WARMB w"),
    @NamedQuery(name = "WARMB.findByCompany", query = "SELECT w FROM WARMB w WHERE w.company = :company"),
    @NamedQuery(name = "WARMB.findByCreator", query = "SELECT w FROM WARMB w WHERE w.creator = :creator"),
    @NamedQuery(name = "WARMB.findByUsrGroup", query = "SELECT w FROM WARMB w WHERE w.usrGroup = :usrGroup"),
    @NamedQuery(name = "WARMB.findByCreateDate", query = "SELECT w FROM WARMB w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WARMB.findByModifier", query = "SELECT w FROM WARMB w WHERE w.modifier = :modifier"),
    @NamedQuery(name = "WARMB.findByModiDate", query = "SELECT w FROM WARMB w WHERE w.modiDate = :modiDate"),
    @NamedQuery(name = "WARMB.findByFlag", query = "SELECT w FROM WARMB w WHERE w.flag = :flag"),
    @NamedQuery(name = "WARMB.findByMb001", query = "SELECT w FROM WARMB w WHERE w.mb001 = :mb001"),
    @NamedQuery(name = "WARMB.findByMb002", query = "SELECT w FROM WARMB w WHERE w.mb002 = :mb002"),
    @NamedQuery(name = "WARMB.findByMb003", query = "SELECT w FROM WARMB w WHERE w.mb003 = :mb003"),
    @NamedQuery(name = "WARMB.findByMb004", query = "SELECT w FROM WARMB w WHERE w.mb004 = :mb004")})
public class WARMB implements Serializable {

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
    @Size(min = 1, max = 120)
    @Column(name = "MB001")
    private String mb001;
    @Size(max = 120)
    @Column(name = "MB002")
    private String mb002;
    @Size(max = 120)
    @Column(name = "MB003")
    private String mb003;
    @Size(max = 6)
    @Column(name = "MB004")
    private String mb004;
    @Size(max = 200)
    @Column(name = "MB005")
    private String mb005;
    @Size(max = 1)
    @Column(name = "MB006")
    private String mb006;
    @Size(max = 1)
    @Column(name = "MB007")
    private String mb007;
    @Size(max = 10)
    @Column(name = "MB008")
    private String mb008;
    @Size(max = 10)
    @Column(name = "MB009")
    private String mb009;
    @Size(max = 1)
    @Column(name = "MB010")
    private String mb010;
    @Size(max = 10)
    @Column(name = "MB011")
    private String mb011;
    @Size(max = 4)
    @Column(name = "MB012")
    private String mb012;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MB013")
    private BigDecimal mb013;
    @Column(name = "MB014")
    private BigDecimal mb014;
    @Column(name = "MB015")
    private Short mb015;
    @Size(max = 10)
    @Column(name = "MB016")
    private String mb016;
    @Size(max = 1)
    @Column(name = "MB017")
    private String mb017;
    @Column(name = "MB018")
    private BigDecimal mb018;
    @Column(name = "MB019")
    private BigDecimal mb019;
    @Column(name = "MB020")
    private BigDecimal mb020;
    @Column(name = "MB021")
    private BigDecimal mb021;
    @Column(name = "MB022")
    private BigDecimal mb022;
    @Column(name = "MB023")
    private BigDecimal mb023;
    @Column(name = "MB024")
    private BigDecimal mb024;
    @Column(name = "MB025")
    private BigDecimal mb025;
    @Size(max = 20)
    @Column(name = "MB026")
    private String mb026;
    @Size(max = 255)
    @Column(name = "MB027")
    private String mb027;
    @Size(max = 1)
    @Column(name = "MB028")
    private String mb028;
    @Size(max = 255)
    @Column(name = "MB029")
    private String mb029;
    @Size(max = 255)
    @Column(name = "MB030")
    private String mb030;
    @Size(max = 1)
    @Column(name = "MB031")
    private String mb031;
    @Size(max = 30)
    @Column(name = "MB032")
    private String mb032;
    @Size(max = 120)
    @Column(name = "MB033")
    private String mb033;
    @Column(name = "MB034")
    private Short mb034;
    @Column(name = "MB035")
    private BigDecimal mb035;
    @Size(max = 1)
    @Column(name = "MB036")
    private String mb036;
    @Size(max = 6)
    @Column(name = "MB037")
    private String mb037;
    @Size(max = 6)
    @Column(name = "MB038")
    private String mb038;
    @Column(name = "MB039")
    private BigDecimal mb039;
    @Column(name = "MB040")
    private BigDecimal mb040;
    @Column(name = "MB041")
    private BigDecimal mb041;
    @Column(name = "MB042")
    private BigDecimal mb042;
    @Size(max = 6)
    @Column(name = "MB043")
    private String mb043;
    @Size(max = 6)
    @Column(name = "MB044")
    private String mb044;
    @Size(max = 1)
    @Column(name = "MB045")
    private String mb045;
    @Size(max = 1)
    @Column(name = "MB046")
    private String mb046;
    @Column(name = "MB047")
    private BigDecimal mb047;
    @Size(max = 6)
    @Column(name = "MB048")
    private String mb048;
    @Size(max = 80)
    @Column(name = "MB049")
    private String mb049;
    @Size(max = 1)
    @Column(name = "MB050")
    private String mb050;
    @Column(name = "MB051")
    private BigDecimal mb051;
    @Column(name = "MB052")
    private BigDecimal mb052;
    @Size(max = 1)
    @Column(name = "MB053")
    private String mb053;
    @Column(name = "MB054")
    private BigDecimal mb054;
    @Column(name = "MB055")
    private BigDecimal mb055;
    @Column(name = "MB056")
    private Short mb056;
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
    @Column(name = "MB057")
    private String mb057;
    @Size(max = 8)
    @Column(name = "MB058")
    private String mb058;
    @Column(name = "MB059")
    private Long mb059;
    @Size(max = 255)
    @Column(name = "WARMB01")
    private String warmb01;
    @Size(max = 255)
    @Column(name = "WARMB02")
    private String warmb02;
    @Size(max = 255)
    @Column(name = "WARMB03")
    private String warmb03;
    @Size(max = 255)
    @Column(name = "WARMB04")
    private String warmb04;
    @Size(max = 255)
    @Column(name = "WARMB05")
    private String warmb05;
    @Size(max = 255)
    @Column(name = "WARMB06")
    private String warmb06;
    @Size(max = 255)
    @Column(name = "WARMB07")
    private String warmb07;
    @Size(max = 255)
    @Column(name = "WARMB08")
    private String warmb08;
    @Size(max = 255)
    @Column(name = "WARMB09")
    private String warmb09;
    @Size(max = 255)
    @Column(name = "WARMB10")
    private String warmb10;
    @Size(max = 255)
    @Column(name = "WARMB11")
    private String warmb11;
    @Size(max = 255)
    @Column(name = "WARMB12")
    private String warmb12;
    @Size(max = 255)
    @Column(name = "WARMB13")
    private String warmb13;
    @Size(max = 255)
    @Column(name = "WARMB14")
    private String warmb14;
    @Size(max = 255)
    @Column(name = "WARMB15")
    private String warmb15;
    @Size(max = 255)
    @Column(name = "WARMB16")
    private String warmb16;
    @Size(max = 255)
    @Column(name = "WARMB17")
    private String warmb17;
    @Size(max = 255)
    @Column(name = "WARMB18")
    private String warmb18;
    @Size(max = 255)
    @Column(name = "WARMB19")
    private String warmb19;
    @Size(max = 255)
    @Column(name = "WARMB20")
    private String warmb20;
    @Size(max = 1)
    @Column(name = "MB060")
    private String mb060;
    @Size(max = 1)
    @Column(name = "MB061")
    private String mb061;
    @Size(max = 1)
    @Column(name = "MB062")
    private String mb062;
    @Size(max = 1)
    @Column(name = "MB063")
    private String mb063;
    @Size(max = 1)
    @Column(name = "MB064")
    private String mb064;
    @Size(max = 1)
    @Column(name = "MB065")
    private String mb065;
    @Size(max = 1)
    @Column(name = "MB066")
    private String mb066;
    @Size(max = 1)
    @Column(name = "MB067")
    private String mb067;
    @Size(max = 1)
    @Column(name = "MB068")
    private String mb068;
    @Size(max = 1)
    @Column(name = "MB069")
    private String mb069;
    @Size(max = 40)
    @Column(name = "MB070")
    private String mb070;
    @Size(max = 40)
    @Column(name = "MB071")
    private String mb071;

    public WARMB() {
    }

    public WARMB(String mb001) {
        this.mb001 = mb001;
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

    public String getMb001() {
        return mb001;
    }

    public void setMb001(String mb001) {
        this.mb001 = mb001;
    }

    public String getMb002() {
        return mb002;
    }

    public void setMb002(String mb002) {
        this.mb002 = mb002;
    }

    public String getMb003() {
        return mb003;
    }

    public void setMb003(String mb003) {
        this.mb003 = mb003;
    }

    public String getMb004() {
        return mb004;
    }

    public void setMb004(String mb004) {
        this.mb004 = mb004;
    }

    public String getMb005() {
        return mb005;
    }

    public void setMb005(String mb005) {
        this.mb005 = mb005;
    }

    public String getMb006() {
        return mb006;
    }

    public void setMb006(String mb006) {
        this.mb006 = mb006;
    }

    public String getMb007() {
        return mb007;
    }

    public void setMb007(String mb007) {
        this.mb007 = mb007;
    }

    public String getMb008() {
        return mb008;
    }

    public void setMb008(String mb008) {
        this.mb008 = mb008;
    }

    public String getMb009() {
        return mb009;
    }

    public void setMb009(String mb009) {
        this.mb009 = mb009;
    }

    public String getMb010() {
        return mb010;
    }

    public void setMb010(String mb010) {
        this.mb010 = mb010;
    }

    public String getMb011() {
        return mb011;
    }

    public void setMb011(String mb011) {
        this.mb011 = mb011;
    }

    public String getMb012() {
        return mb012;
    }

    public void setMb012(String mb012) {
        this.mb012 = mb012;
    }

    public BigDecimal getMb013() {
        return mb013;
    }

    public void setMb013(BigDecimal mb013) {
        this.mb013 = mb013;
    }

    public BigDecimal getMb014() {
        return mb014;
    }

    public void setMb014(BigDecimal mb014) {
        this.mb014 = mb014;
    }

    public Short getMb015() {
        return mb015;
    }

    public void setMb015(Short mb015) {
        this.mb015 = mb015;
    }

    public String getMb016() {
        return mb016;
    }

    public void setMb016(String mb016) {
        this.mb016 = mb016;
    }

    public String getMb017() {
        return mb017;
    }

    public void setMb017(String mb017) {
        this.mb017 = mb017;
    }

    public BigDecimal getMb018() {
        return mb018;
    }

    public void setMb018(BigDecimal mb018) {
        this.mb018 = mb018;
    }

    public BigDecimal getMb019() {
        return mb019;
    }

    public void setMb019(BigDecimal mb019) {
        this.mb019 = mb019;
    }

    public BigDecimal getMb020() {
        return mb020;
    }

    public void setMb020(BigDecimal mb020) {
        this.mb020 = mb020;
    }

    public BigDecimal getMb021() {
        return mb021;
    }

    public void setMb021(BigDecimal mb021) {
        this.mb021 = mb021;
    }

    public BigDecimal getMb022() {
        return mb022;
    }

    public void setMb022(BigDecimal mb022) {
        this.mb022 = mb022;
    }

    public BigDecimal getMb023() {
        return mb023;
    }

    public void setMb023(BigDecimal mb023) {
        this.mb023 = mb023;
    }

    public BigDecimal getMb024() {
        return mb024;
    }

    public void setMb024(BigDecimal mb024) {
        this.mb024 = mb024;
    }

    public BigDecimal getMb025() {
        return mb025;
    }

    public void setMb025(BigDecimal mb025) {
        this.mb025 = mb025;
    }

    public String getMb026() {
        return mb026;
    }

    public void setMb026(String mb026) {
        this.mb026 = mb026;
    }

    public String getMb027() {
        return mb027;
    }

    public void setMb027(String mb027) {
        this.mb027 = mb027;
    }

    public String getMb028() {
        return mb028;
    }

    public void setMb028(String mb028) {
        this.mb028 = mb028;
    }

    public String getMb029() {
        return mb029;
    }

    public void setMb029(String mb029) {
        this.mb029 = mb029;
    }

    public String getMb030() {
        return mb030;
    }

    public void setMb030(String mb030) {
        this.mb030 = mb030;
    }

    public String getMb031() {
        return mb031;
    }

    public void setMb031(String mb031) {
        this.mb031 = mb031;
    }

    public String getMb032() {
        return mb032;
    }

    public void setMb032(String mb032) {
        this.mb032 = mb032;
    }

    public String getMb033() {
        return mb033;
    }

    public void setMb033(String mb033) {
        this.mb033 = mb033;
    }

    public Short getMb034() {
        return mb034;
    }

    public void setMb034(Short mb034) {
        this.mb034 = mb034;
    }

    public BigDecimal getMb035() {
        return mb035;
    }

    public void setMb035(BigDecimal mb035) {
        this.mb035 = mb035;
    }

    public String getMb036() {
        return mb036;
    }

    public void setMb036(String mb036) {
        this.mb036 = mb036;
    }

    public String getMb037() {
        return mb037;
    }

    public void setMb037(String mb037) {
        this.mb037 = mb037;
    }

    public String getMb038() {
        return mb038;
    }

    public void setMb038(String mb038) {
        this.mb038 = mb038;
    }

    public BigDecimal getMb039() {
        return mb039;
    }

    public void setMb039(BigDecimal mb039) {
        this.mb039 = mb039;
    }

    public BigDecimal getMb040() {
        return mb040;
    }

    public void setMb040(BigDecimal mb040) {
        this.mb040 = mb040;
    }

    public BigDecimal getMb041() {
        return mb041;
    }

    public void setMb041(BigDecimal mb041) {
        this.mb041 = mb041;
    }

    public BigDecimal getMb042() {
        return mb042;
    }

    public void setMb042(BigDecimal mb042) {
        this.mb042 = mb042;
    }

    public String getMb043() {
        return mb043;
    }

    public void setMb043(String mb043) {
        this.mb043 = mb043;
    }

    public String getMb044() {
        return mb044;
    }

    public void setMb044(String mb044) {
        this.mb044 = mb044;
    }

    public String getMb045() {
        return mb045;
    }

    public void setMb045(String mb045) {
        this.mb045 = mb045;
    }

    public String getMb046() {
        return mb046;
    }

    public void setMb046(String mb046) {
        this.mb046 = mb046;
    }

    public BigDecimal getMb047() {
        return mb047;
    }

    public void setMb047(BigDecimal mb047) {
        this.mb047 = mb047;
    }

    public String getMb048() {
        return mb048;
    }

    public void setMb048(String mb048) {
        this.mb048 = mb048;
    }

    public String getMb049() {
        return mb049;
    }

    public void setMb049(String mb049) {
        this.mb049 = mb049;
    }

    public String getMb050() {
        return mb050;
    }

    public void setMb050(String mb050) {
        this.mb050 = mb050;
    }

    public BigDecimal getMb051() {
        return mb051;
    }

    public void setMb051(BigDecimal mb051) {
        this.mb051 = mb051;
    }

    public BigDecimal getMb052() {
        return mb052;
    }

    public void setMb052(BigDecimal mb052) {
        this.mb052 = mb052;
    }

    public String getMb053() {
        return mb053;
    }

    public void setMb053(String mb053) {
        this.mb053 = mb053;
    }

    public BigDecimal getMb054() {
        return mb054;
    }

    public void setMb054(BigDecimal mb054) {
        this.mb054 = mb054;
    }

    public BigDecimal getMb055() {
        return mb055;
    }

    public void setMb055(BigDecimal mb055) {
        this.mb055 = mb055;
    }

    public Short getMb056() {
        return mb056;
    }

    public void setMb056(Short mb056) {
        this.mb056 = mb056;
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

    public String getMb057() {
        return mb057;
    }

    public void setMb057(String mb057) {
        this.mb057 = mb057;
    }

    public String getMb058() {
        return mb058;
    }

    public void setMb058(String mb058) {
        this.mb058 = mb058;
    }

    public Long getMb059() {
        return mb059;
    }

    public void setMb059(Long mb059) {
        this.mb059 = mb059;
    }

    public String getWARMB01() {
        return warmb01;
    }

    public void setWARMB01(String warmb01) {
        this.warmb01 = warmb01;
    }

    public String getWARMB02() {
        return warmb02;
    }

    public void setWARMB02(String warmb02) {
        this.warmb02 = warmb02;
    }

    public String getWARMB03() {
        return warmb03;
    }

    public void setWARMB03(String warmb03) {
        this.warmb03 = warmb03;
    }

    public String getWARMB04() {
        return warmb04;
    }

    public void setWARMB04(String warmb04) {
        this.warmb04 = warmb04;
    }

    public String getWARMB05() {
        return warmb05;
    }

    public void setWARMB05(String warmb05) {
        this.warmb05 = warmb05;
    }

    public String getWARMB06() {
        return warmb06;
    }

    public void setWARMB06(String warmb06) {
        this.warmb06 = warmb06;
    }

    public String getWARMB07() {
        return warmb07;
    }

    public void setWARMB07(String warmb07) {
        this.warmb07 = warmb07;
    }

    public String getWARMB08() {
        return warmb08;
    }

    public void setWARMB08(String warmb08) {
        this.warmb08 = warmb08;
    }

    public String getWARMB09() {
        return warmb09;
    }

    public void setWARMB09(String warmb09) {
        this.warmb09 = warmb09;
    }

    public String getWARMB10() {
        return warmb10;
    }

    public void setWARMB10(String warmb10) {
        this.warmb10 = warmb10;
    }

    public String getWARMB11() {
        return warmb11;
    }

    public void setWARMB11(String warmb11) {
        this.warmb11 = warmb11;
    }

    public String getWARMB12() {
        return warmb12;
    }

    public void setWARMB12(String warmb12) {
        this.warmb12 = warmb12;
    }

    public String getWARMB13() {
        return warmb13;
    }

    public void setWARMB13(String warmb13) {
        this.warmb13 = warmb13;
    }

    public String getWARMB14() {
        return warmb14;
    }

    public void setWARMB14(String warmb14) {
        this.warmb14 = warmb14;
    }

    public String getWARMB15() {
        return warmb15;
    }

    public void setWARMB15(String warmb15) {
        this.warmb15 = warmb15;
    }

    public String getWARMB16() {
        return warmb16;
    }

    public void setWARMB16(String warmb16) {
        this.warmb16 = warmb16;
    }

    public String getWARMB17() {
        return warmb17;
    }

    public void setWARMB17(String warmb17) {
        this.warmb17 = warmb17;
    }

    public String getWARMB18() {
        return warmb18;
    }

    public void setWARMB18(String warmb18) {
        this.warmb18 = warmb18;
    }

    public String getWARMB19() {
        return warmb19;
    }

    public void setWARMB19(String warmb19) {
        this.warmb19 = warmb19;
    }

    public String getWARMB20() {
        return warmb20;
    }

    public void setWARMB20(String warmb20) {
        this.warmb20 = warmb20;
    }

    public String getMb060() {
        return mb060;
    }

    public void setMb060(String mb060) {
        this.mb060 = mb060;
    }

    public String getMb061() {
        return mb061;
    }

    public void setMb061(String mb061) {
        this.mb061 = mb061;
    }

    public String getMb062() {
        return mb062;
    }

    public void setMb062(String mb062) {
        this.mb062 = mb062;
    }

    public String getMb063() {
        return mb063;
    }

    public void setMb063(String mb063) {
        this.mb063 = mb063;
    }

    public String getMb064() {
        return mb064;
    }

    public void setMb064(String mb064) {
        this.mb064 = mb064;
    }

    public String getMb065() {
        return mb065;
    }

    public void setMb065(String mb065) {
        this.mb065 = mb065;
    }

    public String getMb066() {
        return mb066;
    }

    public void setMb066(String mb066) {
        this.mb066 = mb066;
    }

    public String getMb067() {
        return mb067;
    }

    public void setMb067(String mb067) {
        this.mb067 = mb067;
    }

    public String getMb068() {
        return mb068;
    }

    public void setMb068(String mb068) {
        this.mb068 = mb068;
    }

    public String getMb069() {
        return mb069;
    }

    public void setMb069(String mb069) {
        this.mb069 = mb069;
    }

    public String getMb070() {
        return mb070;
    }

    public void setMb070(String mb070) {
        this.mb070 = mb070;
    }

    public String getMb071() {
        return mb071;
    }

    public void setMb071(String mb071) {
        this.mb071 = mb071;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mb001 != null ? mb001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARMB)) {
            return false;
        }
        WARMB other = (WARMB) object;
        if ((this.mb001 == null && other.mb001 != null) || (this.mb001 != null && !this.mb001.equals(other.mb001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARMB[ mb001=" + mb001 + " ]";
    }
    
}
