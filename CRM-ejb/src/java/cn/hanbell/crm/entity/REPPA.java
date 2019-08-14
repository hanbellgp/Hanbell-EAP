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
import org.atmosphere.config.service.AsyncSupportService;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "REPPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPPA.findAll", query = "SELECT r FROM REPPA r"),
    @NamedQuery(name = "REPPA.findByCompany", query = "SELECT r FROM REPPA r WHERE r.company = :company"),
    @NamedQuery(name = "REPPA.findByCreator", query = "SELECT r FROM REPPA r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPPA.findByUsrGroup", query = "SELECT r FROM REPPA r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPPA.findByCreateDate", query = "SELECT r FROM REPPA r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPPA.findByModifier", query = "SELECT r FROM REPPA r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPPA.findByModiDate", query = "SELECT r FROM REPPA r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPPA.findByFlag", query = "SELECT r FROM REPPA r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPPA.findByPa001", query = "SELECT r FROM REPPA r WHERE r.rEPPAPK.pa001 = :pa001"),
    @NamedQuery(name = "REPPA.findByPa002", query = "SELECT r FROM REPPA r WHERE r.rEPPAPK.pa002 = :pa002"),
    @NamedQuery(name = "REPPA.findByPK", query = "SELECT r FROM REPPA r WHERE r.rEPPAPK.pa001 = :pa001 AND r.rEPPAPK.pa002 = :pa002"),
    @NamedQuery(name = "REPPA.findByPA519", query = "SELECT r FROM REPPA r WHERE r.pa519 = :pa519"),
    @NamedQuery(name = "REPPA.findNeedThrow", query = "SELECT r FROM REPPA r WHERE r.pa026 = 'Y' AND r.pa027 = 'N' AND (CAST(r.pa518 AS int) < 4  OR r.pa518 IS null )")
})
public class REPPA implements Serializable {

    @Size(max = 50)
    @Column(name = "PA519")
    private String pa519;
    @Size(max = 30)
    @Column(name = "PA520")
    private String pa520;
    @Size(max = 30)
    @Column(name = "PA521")
    private String pa521;
    @Size(max = 30)
    @Column(name = "PA522")
    private String pa522;

    @Size(max = 4)
    @Column(name = "PA518")
    private String pa518;

    @Size(max = 30)
    @Column(name = "PA510")
    private String pa510;
    @Size(max = 10)
    @Column(name = "PA513")
    private String pa513;
    @Size(max = 10)
    @Column(name = "PA514")
    private String pa514;
    @Size(max = 1)
    @Column(name = "PA515")
    private String pa515;
    @Size(max = 10)
    @Column(name = "PA516")
    private String pa516;
    @Size(max = 4)
    @Column(name = "PA517")
    private String pa517;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPPAPK rEPPAPK;
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
    @Size(max = 10)
    @Column(name = "PA003")
    private String pa003;
    @Size(max = 10)
    @Column(name = "PA004")
    private String pa004;
    @Size(max = 10)
    @Column(name = "PA005")
    private String pa005;
    @Size(max = 120)
    @Column(name = "PA006")
    private String pa006;
    @Size(max = 120)
    @Column(name = "PA007")
    private String pa007;
    @Size(max = 120)
    @Column(name = "PA008")
    private String pa008;
    @Size(max = 30)
    @Column(name = "PA009")
    private String pa009;
    @Size(max = 10)
    @Column(name = "PA010")
    private String pa010;
    @Size(max = 40)
    @Column(name = "PA011")
    private String pa011;
    @Size(max = 16)
    @Column(name = "PA012")
    private String pa012;
    @Size(max = 255)
    @Column(name = "PA013")
    private String pa013;
    @Size(max = 20)
    @Column(name = "PA014")
    private String pa014;
    @Size(max = 20)
    @Column(name = "PA015")
    private String pa015;
    @Size(max = 100)
    @Column(name = "PA016")
    private String pa016;
    @Size(max = 255)
    @Column(name = "PA017")
    private String pa017;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PA018")
    private BigDecimal pa018;
    @Column(name = "PA019")
    private BigDecimal pa019;
    @Column(name = "PA020")
    private BigDecimal pa020;
    @Column(name = "PA021")
    private BigDecimal pa021;
    @Size(max = 4)
    @Column(name = "PA022")
    private String pa022;
    @Size(max = 10)
    @Column(name = "PA023")
    private String pa023;
    @Size(max = 8)
    @Column(name = "PA024")
    private String pa024;
    @Size(max = 10)
    @Column(name = "PA025")
    private String pa025;
    @Size(max = 1)
    @Column(name = "PA026")
    private String pa026;
    @Size(max = 1)
    @Column(name = "PA027")
    private String pa027;
    @Column(name = "PA028")
    private BigDecimal pa028;
    @Size(max = 8)
    @Column(name = "PA029")
    private String pa029;
    @Size(max = 10)
    @Column(name = "PA030")
    private String pa030;
    @Size(max = 1)
    @Column(name = "PA031")
    private String pa031;
    @Size(max = 4)
    @Column(name = "PA032")
    private String pa032;
    @Size(max = 11)
    @Column(name = "PA033")
    private String pa033;
    @Size(max = 20)
    @Column(name = "PA034")
    private String pa034;
    @Size(max = 2)
    @Column(name = "PA035")
    private String pa035;
    @Size(max = 2)
    @Column(name = "PA036")
    private String pa036;
    @Size(max = 255)
    @Column(name = "PA037")
    private String pa037;
    @Size(max = 255)
    @Column(name = "PA038")
    private String pa038;
    @Size(max = 1000)
    @Column(name = "PA039")
    private String pa039;
    @Size(max = 1000)
    @Column(name = "PA040")
    private String pa040;
    @Size(max = 1)
    @Column(name = "PA041")
    private String pa041;
    @Size(max = 20)
    @Column(name = "PA042")
    private String pa042;
    @Size(max = 40)
    @Column(name = "PA043")
    private String pa043;
    @Column(name = "PA044")
    private BigDecimal pa044;
    @Column(name = "PA045")
    private BigDecimal pa045;
    @Size(max = 1)
    @Column(name = "PA046")
    private String pa046;
    @Size(max = 30)
    @Column(name = "PA047")
    private String pa047;
    @Size(max = 60)
    @Column(name = "PA048")
    private String pa048;
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
    @Column(name = "PA197")
    private String pa197;
    @Size(max = 10)
    @Column(name = "PA198")
    private String pa198;
    @Size(max = 10)
    @Column(name = "PA199")
    private String pa199;
    @Size(max = 255)
    @Column(name = "REPPA01")
    private String reppa01;
    @Size(max = 255)
    @Column(name = "REPPA02")
    private String reppa02;
    @Size(max = 255)
    @Column(name = "REPPA03")
    private String reppa03;
    @Size(max = 255)
    @Column(name = "REPPA04")
    private String reppa04;
    @Size(max = 255)
    @Column(name = "REPPA05")
    private String reppa05;
    @Size(max = 255)
    @Column(name = "REPPA06")
    private String reppa06;
    @Size(max = 255)
    @Column(name = "REPPA07")
    private String reppa07;
    @Size(max = 255)
    @Column(name = "REPPA08")
    private String reppa08;
    @Size(max = 255)
    @Column(name = "REPPA09")
    private String reppa09;
    @Size(max = 255)
    @Column(name = "REPPA10")
    private String reppa10;
    @Size(max = 255)
    @Column(name = "REPPA11")
    private String reppa11;
    @Size(max = 255)
    @Column(name = "REPPA12")
    private String reppa12;
    @Size(max = 255)
    @Column(name = "REPPA13")
    private String reppa13;
    @Size(max = 255)
    @Column(name = "REPPA14")
    private String reppa14;
    @Size(max = 255)
    @Column(name = "REPPA15")
    private String reppa15;
    @Size(max = 255)
    @Column(name = "REPPA16")
    private String reppa16;
    @Size(max = 255)
    @Column(name = "REPPA17")
    private String reppa17;
    @Size(max = 255)
    @Column(name = "REPPA18")
    private String reppa18;
    @Size(max = 255)
    @Column(name = "REPPA19")
    private String reppa19;
    @Size(max = 255)
    @Column(name = "REPPA20")
    private String reppa20;
    @Size(max = 1)
    @Column(name = "PA049")
    private String pa049;
    @Size(max = 1)
    @Column(name = "PA050")
    private String pa050;
    @Column(name = "PA051")
    private BigDecimal pa051;
    @Column(name = "PA052")
    private BigDecimal pa052;
    @Column(name = "PA053")
    private BigDecimal pa053;
    @Size(max = 90)
    @Column(name = "PA500")
    private String pa500;
    @Size(max = 90)
    @Column(name = "PA501")
    private String pa501;
    @Size(max = 50)
    @Column(name = "PA502")
    private String pa502;
    @Size(max = 10)
    @Column(name = "PA503")
    private String pa503;
    @Size(max = 1)
    @Column(name = "PA504")
    private String pa504;
    @Size(max = 1)
    @Column(name = "PA505")
    private String pa505;
    @Size(max = 1)
    @Column(name = "PA506")
    private String pa506;
    @Size(max = 10)
    @Column(name = "PA507")
    private String pa507;
    @Size(max = 1)
    @Column(name = "PA508")
    private String pa508;
    @Size(max = 60)
    @Column(name = "PA509")
    private String pa509;
    @Column(name = "PA511")
    private BigDecimal pa511;
    @Column(name = "PA512")
    private BigDecimal pa512;

    public REPPA() {
    }

    public REPPA(REPPAPK rEPPAPK) {
        this.rEPPAPK = rEPPAPK;
    }

    public REPPA(String pa001, String pa002) {
        this.rEPPAPK = new REPPAPK(pa001, pa002);
    }

    public REPPAPK getREPPAPK() {
        return rEPPAPK;
    }

    public void setREPPAPK(REPPAPK rEPPAPK) {
        this.rEPPAPK = rEPPAPK;
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

    public String getPa003() {
        return pa003;
    }

    public void setPa003(String pa003) {
        this.pa003 = pa003;
    }

    public String getPa004() {
        return pa004;
    }

    public void setPa004(String pa004) {
        this.pa004 = pa004;
    }

    public String getPa005() {
        return pa005;
    }

    public void setPa005(String pa005) {
        this.pa005 = pa005;
    }

    public String getPa006() {
        return pa006;
    }

    public void setPa006(String pa006) {
        this.pa006 = pa006;
    }

    public String getPa007() {
        return pa007;
    }

    public void setPa007(String pa007) {
        this.pa007 = pa007;
    }

    public String getPa008() {
        return pa008;
    }

    public void setPa008(String pa008) {
        this.pa008 = pa008;
    }

    public String getPa009() {
        return pa009;
    }

    public void setPa009(String pa009) {
        this.pa009 = pa009;
    }

    public String getPa010() {
        return pa010;
    }

    public void setPa010(String pa010) {
        this.pa010 = pa010;
    }

    public String getPa011() {
        return pa011;
    }

    public void setPa011(String pa011) {
        this.pa011 = pa011;
    }

    public String getPa012() {
        return pa012;
    }

    public void setPa012(String pa012) {
        this.pa012 = pa012;
    }

    public String getPa013() {
        return pa013;
    }

    public void setPa013(String pa013) {
        this.pa013 = pa013;
    }

    public String getPa014() {
        return pa014;
    }

    public void setPa014(String pa014) {
        this.pa014 = pa014;
    }

    public String getPa015() {
        return pa015;
    }

    public void setPa015(String pa015) {
        this.pa015 = pa015;
    }

    public String getPa016() {
        return pa016;
    }

    public void setPa016(String pa016) {
        this.pa016 = pa016;
    }

    public String getPa017() {
        return pa017;
    }

    public void setPa017(String pa017) {
        this.pa017 = pa017;
    }

    public BigDecimal getPa018() {
        return pa018;
    }

    public void setPa018(BigDecimal pa018) {
        this.pa018 = pa018;
    }

    public BigDecimal getPa019() {
        return pa019;
    }

    public void setPa019(BigDecimal pa019) {
        this.pa019 = pa019;
    }

    public BigDecimal getPa020() {
        return pa020;
    }

    public void setPa020(BigDecimal pa020) {
        this.pa020 = pa020;
    }

    public BigDecimal getPa021() {
        return pa021;
    }

    public void setPa021(BigDecimal pa021) {
        this.pa021 = pa021;
    }

    public String getPa022() {
        return pa022;
    }

    public void setPa022(String pa022) {
        this.pa022 = pa022;
    }

    public String getPa023() {
        return pa023;
    }

    public void setPa023(String pa023) {
        this.pa023 = pa023;
    }

    public String getPa024() {
        return pa024;
    }

    public void setPa024(String pa024) {
        this.pa024 = pa024;
    }

    public String getPa025() {
        return pa025;
    }

    public void setPa025(String pa025) {
        this.pa025 = pa025;
    }

    public String getPa026() {
        return pa026;
    }

    public void setPa026(String pa026) {
        this.pa026 = pa026;
    }

    public String getPa027() {
        return pa027;
    }

    public void setPa027(String pa027) {
        this.pa027 = pa027;
    }

    public BigDecimal getPa028() {
        return pa028;
    }

    public void setPa028(BigDecimal pa028) {
        this.pa028 = pa028;
    }

    public String getPa029() {
        return pa029;
    }

    public void setPa029(String pa029) {
        this.pa029 = pa029;
    }

    public String getPa030() {
        return pa030;
    }

    public void setPa030(String pa030) {
        this.pa030 = pa030;
    }

    public String getPa031() {
        return pa031;
    }

    public void setPa031(String pa031) {
        this.pa031 = pa031;
    }

    public String getPa032() {
        return pa032;
    }

    public void setPa032(String pa032) {
        this.pa032 = pa032;
    }

    public String getPa033() {
        return pa033;
    }

    public void setPa033(String pa033) {
        this.pa033 = pa033;
    }

    public String getPa034() {
        return pa034;
    }

    public void setPa034(String pa034) {
        this.pa034 = pa034;
    }

    public String getPa035() {
        return pa035;
    }

    public void setPa035(String pa035) {
        this.pa035 = pa035;
    }

    public String getPa036() {
        return pa036;
    }

    public void setPa036(String pa036) {
        this.pa036 = pa036;
    }

    public String getPa037() {
        return pa037;
    }

    public void setPa037(String pa037) {
        this.pa037 = pa037;
    }

    public String getPa038() {
        return pa038;
    }

    public void setPa038(String pa038) {
        this.pa038 = pa038;
    }

    public String getPa039() {
        return pa039;
    }

    public void setPa039(String pa039) {
        this.pa039 = pa039;
    }

    public String getPa040() {
        return pa040;
    }

    public void setPa040(String pa040) {
        this.pa040 = pa040;
    }

    public String getPa041() {
        return pa041;
    }

    public void setPa041(String pa041) {
        this.pa041 = pa041;
    }

    public String getPa042() {
        return pa042;
    }

    public void setPa042(String pa042) {
        this.pa042 = pa042;
    }

    public String getPa043() {
        return pa043;
    }

    public void setPa043(String pa043) {
        this.pa043 = pa043;
    }

    public BigDecimal getPa044() {
        return pa044;
    }

    public void setPa044(BigDecimal pa044) {
        this.pa044 = pa044;
    }

    public BigDecimal getPa045() {
        return pa045;
    }

    public void setPa045(BigDecimal pa045) {
        this.pa045 = pa045;
    }

    public String getPa046() {
        return pa046;
    }

    public void setPa046(String pa046) {
        this.pa046 = pa046;
    }

    public String getPa047() {
        return pa047;
    }

    public void setPa047(String pa047) {
        this.pa047 = pa047;
    }

    public String getPa048() {
        return pa048;
    }

    public void setPa048(String pa048) {
        this.pa048 = pa048;
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

    public String getPa197() {
        return pa197;
    }

    public void setPa197(String pa197) {
        this.pa197 = pa197;
    }

    public String getPa198() {
        return pa198;
    }

    public void setPa198(String pa198) {
        this.pa198 = pa198;
    }

    public String getPa199() {
        return pa199;
    }

    public void setPa199(String pa199) {
        this.pa199 = pa199;
    }

    public String getReppa01() {
        return reppa01;
    }

    public void setReppa01(String reppa01) {
        this.reppa01 = reppa01;
    }

    public String getReppa02() {
        return reppa02;
    }

    public void setReppa02(String reppa02) {
        this.reppa02 = reppa02;
    }

    public String getReppa03() {
        return reppa03;
    }

    public void setReppa03(String reppa03) {
        this.reppa03 = reppa03;
    }

    public String getReppa04() {
        return reppa04;
    }

    public void setReppa04(String reppa04) {
        this.reppa04 = reppa04;
    }

    public String getReppa05() {
        return reppa05;
    }

    public void setReppa05(String reppa05) {
        this.reppa05 = reppa05;
    }

    public String getReppa06() {
        return reppa06;
    }

    public void setReppa06(String reppa06) {
        this.reppa06 = reppa06;
    }

    public String getReppa07() {
        return reppa07;
    }

    public void setReppa07(String reppa07) {
        this.reppa07 = reppa07;
    }

    public String getReppa08() {
        return reppa08;
    }

    public void setReppa08(String reppa08) {
        this.reppa08 = reppa08;
    }

    public String getReppa09() {
        return reppa09;
    }

    public void setReppa09(String reppa09) {
        this.reppa09 = reppa09;
    }

    public String getReppa10() {
        return reppa10;
    }

    public void setReppa10(String reppa10) {
        this.reppa10 = reppa10;
    }

    public String getReppa11() {
        return reppa11;
    }

    public void setReppa11(String reppa11) {
        this.reppa11 = reppa11;
    }

    public String getReppa12() {
        return reppa12;
    }

    public void setReppa12(String reppa12) {
        this.reppa12 = reppa12;
    }

    public String getReppa13() {
        return reppa13;
    }

    public void setReppa13(String reppa13) {
        this.reppa13 = reppa13;
    }

    public String getReppa14() {
        return reppa14;
    }

    public void setReppa14(String reppa14) {
        this.reppa14 = reppa14;
    }

    public String getReppa15() {
        return reppa15;
    }

    public void setReppa15(String reppa15) {
        this.reppa15 = reppa15;
    }

    public String getReppa16() {
        return reppa16;
    }

    public void setReppa16(String reppa16) {
        this.reppa16 = reppa16;
    }

    public String getReppa17() {
        return reppa17;
    }

    public void setReppa17(String reppa17) {
        this.reppa17 = reppa17;
    }

    public String getReppa18() {
        return reppa18;
    }

    public void setReppa18(String reppa18) {
        this.reppa18 = reppa18;
    }

    public String getReppa19() {
        return reppa19;
    }

    public void setReppa19(String reppa19) {
        this.reppa19 = reppa19;
    }

    public String getReppa20() {
        return reppa20;
    }

    public void setReppa20(String reppa20) {
        this.reppa20 = reppa20;
    }

    public String getPa049() {
        return pa049;
    }

    public void setPa049(String pa049) {
        this.pa049 = pa049;
    }

    public String getPa050() {
        return pa050;
    }

    public void setPa050(String pa050) {
        this.pa050 = pa050;
    }

    public BigDecimal getPa051() {
        return pa051;
    }

    public void setPa051(BigDecimal pa051) {
        this.pa051 = pa051;
    }

    public BigDecimal getPa052() {
        return pa052;
    }

    public void setPa052(BigDecimal pa052) {
        this.pa052 = pa052;
    }

    public BigDecimal getPa053() {
        return pa053;
    }

    public void setPa053(BigDecimal pa053) {
        this.pa053 = pa053;
    }

    public String getPa500() {
        return pa500;
    }

    public void setPa500(String pa500) {
        this.pa500 = pa500;
    }

    public String getPa501() {
        return pa501;
    }

    public void setPa501(String pa501) {
        this.pa501 = pa501;
    }

    public String getPa502() {
        return pa502;
    }

    public void setPa502(String pa502) {
        this.pa502 = pa502;
    }

    public String getPa503() {
        return pa503;
    }

    public void setPa503(String pa503) {
        this.pa503 = pa503;
    }

    public String getPa504() {
        return pa504;
    }

    public void setPa504(String pa504) {
        this.pa504 = pa504;
    }

    public String getPa505() {
        return pa505;
    }

    public void setPa505(String pa505) {
        this.pa505 = pa505;
    }

    public String getPa506() {
        return pa506;
    }

    public void setPa506(String pa506) {
        this.pa506 = pa506;
    }

    public String getPa507() {
        return pa507;
    }

    public void setPa507(String pa507) {
        this.pa507 = pa507;
    }

    public String getPa508() {
        return pa508;
    }

    public void setPa508(String pa508) {
        this.pa508 = pa508;
    }

    public String getPa509() {
        return pa509;
    }

    public void setPa509(String pa509) {
        this.pa509 = pa509;
    }

    public BigDecimal getPa511() {
        return pa511;
    }

    public void setPa511(BigDecimal pa511) {
        this.pa511 = pa511;
    }

    public BigDecimal getPa512() {
        return pa512;
    }

    public void setPa512(BigDecimal pa512) {
        this.pa512 = pa512;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPPAPK != null ? rEPPAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPPA)) {
            return false;
        }
        REPPA other = (REPPA) object;
        if ((this.rEPPAPK == null && other.rEPPAPK != null) || (this.rEPPAPK != null && !this.rEPPAPK.equals(other.rEPPAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPPA[ rEPPAPK=" + rEPPAPK + " ]";
    }

    public String getPa510() {
        return pa510;
    }

    public void setPa510(String pa510) {
        this.pa510 = pa510;
    }

    public String getPa513() {
        return pa513;
    }

    public void setPa513(String pa513) {
        this.pa513 = pa513;
    }

    public String getPa514() {
        return pa514;
    }

    public void setPa514(String pa514) {
        this.pa514 = pa514;
    }

    public String getPa515() {
        return pa515;
    }

    public void setPa515(String pa515) {
        this.pa515 = pa515;
    }

    public String getPa516() {
        return pa516;
    }

    public void setPa516(String pa516) {
        this.pa516 = pa516;
    }

    public String getPa517() {
        return pa517;
    }

    public void setPa517(String pa517) {
        this.pa517 = pa517;
    }

    public String getPa518() {
        return pa518;
    }

    public void setPa518(String pa518) {
        this.pa518 = pa518;
    }

    public String getPa519() {
        return pa519;
    }

    public void setPa519(String pa519) {
        this.pa519 = pa519;
    }

    public String getPa520() {
        return pa520;
    }

    public void setPa520(String pa520) {
        this.pa520 = pa520;
    }

    public String getPa521() {
        return pa521;
    }

    public void setPa521(String pa521) {
        this.pa521 = pa521;
    }

    public String getPa522() {
        return pa522;
    }

    public void setPa522(String pa522) {
        this.pa522 = pa522;
    }

}
