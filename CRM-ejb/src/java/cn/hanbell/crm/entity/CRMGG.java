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
@Table(name = "CRMGG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRMGG.findAll", query = "SELECT c FROM CRMGG c"),
    @NamedQuery(name = "CRMGG.findById", query = "SELECT c FROM CRMGG c WHERE c.gg001 = :id"),
    @NamedQuery(name = "CRMGG.findByCustomer", query = "SELECT c FROM CRMGG c WHERE c.customer = :customer"),
    @NamedQuery(name = "CRMGG.findByProduct", query = "SELECT c FROM CRMGG c WHERE c.product = :product"),
    @NamedQuery(name = "CRMGG.findByRegion", query = "SELECT c FROM CRMGG c WHERE c.region = :region"),
    @NamedQuery(name = "CRMGG.findByERPCusno", query = "SELECT c FROM CRMGG c WHERE c.gg043 = :cusno")})
public class CRMGG implements Serializable {

    @Size(max = 1)
    @Column(name = "GG044")
    private String gg044;
    @Size(max = 1)
    @Column(name = "GG045")
    private String gg045;
    @Size(max = 1)
    @Column(name = "GG046")
    private String gg046;
    @Size(max = 1)
    @Column(name = "GG052")
    private String gg052;
    @Size(max = 1)
    @Column(name = "GG061")
    private String gg061;
    @Size(max = 1)
    @Column(name = "GG063")
    private String gg063;
    @Size(max = 1)
    @Column(name = "GG080")
    private String gg080;
    @Size(max = 1)
    @Column(name = "GG081")
    private String gg081;
    @Size(max = 1)
    @Column(name = "GG089")
    private String gg089;
    @Size(max = 1)
    @Column(name = "GG090")
    private String gg090;
    @Size(max = 1)
    @Column(name = "GG098")
    private String gg098;
    @Size(max = 1)
    @Column(name = "GG103")
    private String gg103;
    @Size(max = 1)
    @Column(name = "GG107")
    private String gg107;
    @Size(max = 1)
    @Column(name = "GG111")
    private String gg111;
    @Size(max = 10)
    @Column(name = "GG112")
    private String gg112;
    @Size(max = 1)
    @Column(name = "GG113")
    private String gg113;
    @Size(max = 1)
    @Column(name = "GG119")
    private String gg119;
    @Size(max = 1)
    @Column(name = "GG124")
    private String gg124;
    @Size(max = 1)
    @Column(name = "GG132")
    private String gg132;
    @Size(max = 40)
    @Column(name = "GG153")
    private String gg153;
    @Size(max = 40)
    @Column(name = "GG154")
    private String gg154;
    @Size(max = 40)
    @Column(name = "GG155")
    private String gg155;
    @Size(max = 40)
    @Column(name = "GG156")
    private String gg156;
    @Size(max = 40)
    @Column(name = "GG157")
    private String gg157;
    @Size(max = 40)
    @Column(name = "GG158")
    private String gg158;
    @Size(max = 40)
    @Column(name = "GG159")
    private String gg159;
    @Size(max = 40)
    @Column(name = "GG160")
    private String gg160;
    @Size(max = 40)
    @Column(name = "GG161")
    private String gg161;
    @Size(max = 40)
    @Column(name = "GG162")
    private String gg162;
    @Size(max = 1)
    @Column(name = "GG163")
    private String gg163;
    @Size(max = 1)
    @Column(name = "GG164")
    private String gg164;
    @Size(max = 10)
    @Column(name = "GG165")
    private String gg165;
    @Size(max = 20)
    @Column(name = "GG166")
    private String gg166;
    @Size(max = 20)
    @Column(name = "GG167")
    private String gg167;
    @Size(max = 20)
    @Column(name = "GG168")
    private String gg168;
    @Size(max = 20)
    @Column(name = "GG169")
    private String gg169;
    @Size(max = 20)
    @Column(name = "GG170")
    private String gg170;
    @Size(max = 20)
    @Column(name = "GG171")
    private String gg171;
    @Size(max = 20)
    @Column(name = "GG172")
    private String gg172;

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
    @Column(name = "GG001")
    private String gg001;
    @Size(max = 1)
    @Column(name = "GG002")
    private String gg002;
    @Size(max = 50)
    @Column(name = "GG003")
    private String gg003;
    @Size(max = 100)
    @Column(name = "GG004")
    private String gg004;
    @Size(max = 6)
    @Column(name = "GG005")
    private String gg005;
    @Size(max = 6)
    @Column(name = "GG006")
    private String gg006;
    @Size(max = 6)
    @Column(name = "GG007")
    private String gg007;
    @Size(max = 10)
    @Column(name = "GG008")
    private String gg008;
    @Size(max = 10)
    @Column(name = "GG009")
    private String gg009;
    @Size(max = 10)
    @Column(name = "GG010")
    private String gg010;
    @Size(max = 6)
    @Column(name = "GG011")
    private String gg011;
    @Size(max = 6)
    @Column(name = "GG012")
    private String gg012;
    @Size(max = 6)
    @Column(name = "GG013")
    private String gg013;
    @Size(max = 6)
    @Column(name = "GG014")
    private String gg014;
    @Size(max = 100)
    @Column(name = "GG015")
    private String gg015;
    @Size(max = 8)
    @Column(name = "GG016")
    private String gg016;
    @Size(max = 8)
    @Column(name = "GG017")
    private String gg017;
    @Size(max = 50)
    @Column(name = "GG018")
    private String gg018;
    @Size(max = 50)
    @Column(name = "GG019")
    private String gg019;
    @Size(max = 5)
    @Column(name = "GG020")
    private String gg020;
    @Size(max = 10)
    @Column(name = "GG021")
    private String gg021;
    @Size(max = 20)
    @Column(name = "GG022")
    private String gg022;
    @Size(max = 8)
    @Column(name = "GG023")
    private String gg023;
    @Size(max = 20)
    @Column(name = "GG024")
    private String gg024;
    @Size(max = 8)
    @Column(name = "GG025")
    private String gg025;
    @Size(max = 10)
    @Column(name = "GG026")
    private String gg026;
    @Size(max = 20)
    @Column(name = "GG027")
    private String gg027;
    @Size(max = 100)
    @Column(name = "GG028")
    private String gg028;
    @Size(max = 5)
    @Column(name = "GG029")
    private String gg029;
    @Size(max = 100)
    @Column(name = "GG030")
    private String gg030;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GG031")
    private BigDecimal gg031;
    @Column(name = "GG032")
    private Long gg032;
    @Column(name = "GG033")
    private BigDecimal gg033;
    @Column(name = "GG034")
    private BigDecimal gg034;
    @Column(name = "GG035")
    private Integer gg035;
    @Size(max = 255)
    @Column(name = "GG036")
    private String gg036;
    @Size(max = 10)
    @Column(name = "GG037")
    private String gg037;
    @Size(max = 255)
    @Column(name = "GG038")
    private String gg038;
    @Size(max = 10)
    @Column(name = "GG039")
    private String gg039;
    @Size(max = 4000)
    @Column(name = "GG040")
    private String gg040;
    @Size(max = 1)
    @Column(name = "GG041")
    private String gg041;
    @Size(max = 10)
    @Column(name = "GG042")
    private String gg042;
    @Size(max = 10)
    @Column(name = "GG043")
    private String gg043;
    @Size(max = 6)
    @Column(name = "GG047")
    private String gg047;
    @Size(max = 20)
    @Column(name = "GG048")
    private String gg048;
    @Size(max = 4000)
    @Column(name = "GG049")
    private String gg049;
    @Size(max = 10)
    @Column(name = "GG050")
    private String gg050;
    @Size(max = 4000)
    @Column(name = "GG051")
    private String gg051;
    @Size(max = 8)
    @Column(name = "GG053")
    private String gg053;
    @Size(max = 20)
    @Column(name = "GG054")
    private String gg054;
    @Size(max = 6)
    @Column(name = "GG055")
    private String gg055;
    @Size(max = 6)
    @Column(name = "GG056")
    private String gg056;
    @Column(name = "GG057")
    private Long gg057;
    @Column(name = "GG058")
    private Long gg058;
    @Size(max = 50)
    @Column(name = "GG059")
    private String gg059;
    @Size(max = 50)
    @Column(name = "GG060")
    private String gg060;
    @Size(max = 40)
    @Column(name = "GG062")
    private String gg062;
    @Size(max = 5)
    @Column(name = "GG064")
    private String gg064;
    @Size(max = 20)
    @Column(name = "GG065")
    private String gg065;
    @Size(max = 20)
    @Column(name = "GG066")
    private String gg066;
    @Size(max = 255)
    @Column(name = "GG067")
    private String gg067;
    @Size(max = 10)
    @Column(name = "GG068")
    private String gg068;
    @Size(max = 6)
    @Column(name = "GG069")
    private String gg069;
    @Size(max = 6)
    @Column(name = "GG070")
    private String gg070;
    @Size(max = 100)
    @Column(name = "GG071")
    private String gg071;
    @Size(max = 100)
    @Column(name = "GG072")
    private String gg072;
    @Size(max = 100)
    @Column(name = "GG073")
    private String gg073;
    @Size(max = 100)
    @Column(name = "GG074")
    private String gg074;
    @Size(max = 100)
    @Column(name = "GG075")
    private String gg075;
    @Size(max = 1)
    @Column(name = "GG076")
    private String gg076;
    @Size(max = 6)
    @Column(name = "GG077")
    private String gg077;
    @Size(max = 10)
    @Column(name = "GG078")
    private String gg078;
    @Size(max = 30)
    @Column(name = "GG079")
    private String gg079;
    @Size(max = 255)
    @Column(name = "GG082")
    private String gg082;
    @Size(max = 255)
    @Column(name = "GG083")
    private String gg083;
    @Size(max = 6)
    @Column(name = "GG084")
    private String gg084;
    @Size(max = 6)
    @Column(name = "GG085")
    private String gg085;
    @Size(max = 18)
    @Column(name = "GG086")
    private String gg086;
    @Size(max = 18)
    @Column(name = "GG087")
    private String gg087;
    @Size(max = 18)
    @Column(name = "GG088")
    private String gg088;
    @Size(max = 10)
    @Column(name = "GG091")
    private String gg091;
    @Size(max = 2)
    @Column(name = "GG092")
    private String gg092;
    @Size(max = 40)
    @Column(name = "GG093")
    private String gg093;
    @Size(max = 255)
    @Column(name = "GG094")
    private String gg094;
    @Size(max = 255)
    @Column(name = "GG095")
    private String gg095;
    @Size(max = 255)
    @Column(name = "GG096")
    private String gg096;
    @Size(max = 255)
    @Column(name = "GG097")
    private String gg097;
    @Column(name = "GG099")
    private Short gg099;
    @Column(name = "GG100")
    private Short gg100;
    @Size(max = 10)
    @Column(name = "GG101")
    private String gg101;
    @Size(max = 10)
    @Column(name = "GG102")
    private String gg102;
    @Size(max = 100)
    @Column(name = "GG104")
    private String gg104;
    @Size(max = 200)
    @Column(name = "GG105")
    private String gg105;
    @Size(max = 10)
    @Column(name = "GG106")
    private String gg106;
    @Size(max = 500)
    @Column(name = "GG108")
    private String gg108;
    @Size(max = 4)
    @Column(name = "GG109")
    private String gg109;
    @Size(max = 10)
    @Column(name = "GG110")
    private String gg110;
    @Size(max = 4)
    @Column(name = "GG114")
    private String gg114;
    @Size(max = 20)
    @Column(name = "GG115")
    private String gg115;
    @Size(max = 6)
    @Column(name = "GG116")
    private String gg116;
    @Column(name = "GG117")
    private BigDecimal gg117;
    @Column(name = "GG118")
    private BigDecimal gg118;
    @Size(max = 30)
    @Column(name = "GG120")
    private String gg120;
    @Size(max = 60)
    @Column(name = "GG121")
    private String gg121;
    @Size(max = 15)
    @Column(name = "GG122")
    private String gg122;
    @Column(name = "GG123")
    private BigDecimal gg123;
    @Column(name = "GG125")
    private Short gg125;
    @Size(max = 6)
    @Column(name = "GG126")
    private String gg126;
    @Column(name = "GG127")
    private BigDecimal gg127;
    @Column(name = "GG128")
    private BigDecimal gg128;
    @Column(name = "GG129")
    private BigDecimal gg129;
    @Column(name = "GG130")
    private BigDecimal gg130;
    @Column(name = "GG131")
    private BigDecimal gg131;
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
    @Column(name = "GG133")
    private BigDecimal gg133;
    @Size(max = 10)
    @Column(name = "GG134")
    private String gg134;
    @Size(max = 10)
    @Column(name = "GG135")
    private String gg135;
    @Size(max = 1)
    @Column(name = "GG136")
    private String gg136;
    @Column(name = "GG137")
    private Long gg137;
    @Size(max = 5)
    @Column(name = "GG138")
    private String gg138;
    @Size(max = 6)
    @Column(name = "GG139")
    private String gg139;
    @Size(max = 1)
    @Column(name = "GG140")
    private String gg140;
    @Column(name = "GG141")
    private BigDecimal gg141;
    @Size(max = 10)
    @Column(name = "GG142")
    private String gg142;
    @Size(max = 10)
    @Column(name = "GG143")
    private String gg143;
    @Column(name = "GG144")
    private Long gg144;
    @Column(name = "GG145")
    private BigDecimal gg145;
    @Size(max = 10)
    @Column(name = "GG146")
    private String gg146;
    @Size(max = 10)
    @Column(name = "GG147")
    private String gg147;
    @Column(name = "GG148")
    private Long gg148;
    @Size(max = 10)
    @Column(name = "GG149")
    private String gg149;
    @Size(max = 10)
    @Column(name = "GG150")
    private String gg150;
    @Size(max = 255)
    @Column(name = "CRMGG01")
    private String crmgg01;
    @Size(max = 255)
    @Column(name = "CRMGG02")
    private String crmgg02;
    @Size(max = 255)
    @Column(name = "CRMGG03")
    private String crmgg03;
    @Size(max = 255)
    @Column(name = "CRMGG04")
    private String crmgg04;
    @Size(max = 255)
    @Column(name = "CRMGG05")
    private String crmgg05;
    @Size(max = 255)
    @Column(name = "CRMGG06")
    private String crmgg06;
    @Size(max = 255)
    @Column(name = "CRMGG07")
    private String crmgg07;
    @Size(max = 255)
    @Column(name = "CRMGG08")
    private String crmgg08;
    @Size(max = 255)
    @Column(name = "CRMGG09")
    private String crmgg09;
    @Size(max = 255)
    @Column(name = "CRMGG10")
    private String crmgg10;
    @Size(max = 255)
    @Column(name = "CRMGG11")
    private String crmgg11;
    @Size(max = 255)
    @Column(name = "CRMGG12")
    private String crmgg12;
    @Size(max = 255)
    @Column(name = "CRMGG13")
    private String crmgg13;
    @Size(max = 255)
    @Column(name = "CRMGG14")
    private String crmgg14;
    @Size(max = 255)
    @Column(name = "CRMGG15")
    private String crmgg15;
    @Size(max = 255)
    @Column(name = "CRMGG16")
    private String crmgg16;
    @Size(max = 255)
    @Column(name = "CRMGG17")
    private String crmgg17;
    @Size(max = 255)
    @Column(name = "CRMGG18")
    private String crmgg18;
    @Size(max = 255)
    @Column(name = "CRMGG19")
    private String crmgg19;
    @Size(max = 255)
    @Column(name = "CRMGG20")
    private String crmgg20;
    @Size(max = 10)
    @Column(name = "GG151")
    private String gg151;
    @Size(max = 10)
    @Column(name = "GG152")
    private String gg152;

    public CRMGG() {
    }

    public CRMGG(String gg001) {
        this.gg001 = gg001;
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

    public String getGg001() {
        return gg001;
    }

    public void setGg001(String gg001) {
        this.gg001 = gg001;
    }

    public String getGg002() {
        return gg002;
    }

    public void setGg002(String gg002) {
        this.gg002 = gg002;
    }

    public String getGg003() {
        return gg003;
    }

    public void setGg003(String gg003) {
        this.gg003 = gg003;
    }

    public String getGg004() {
        return gg004;
    }

    public void setGg004(String gg004) {
        this.gg004 = gg004;
    }

    public String getGg005() {
        return gg005;
    }

    public void setGg005(String gg005) {
        this.gg005 = gg005;
    }

    public String getGg006() {
        return gg006;
    }

    public void setGg006(String gg006) {
        this.gg006 = gg006;
    }

    public String getGg007() {
        return gg007;
    }

    public void setGg007(String gg007) {
        this.gg007 = gg007;
    }

    public String getGg008() {
        return gg008;
    }

    public void setGg008(String gg008) {
        this.gg008 = gg008;
    }

    public String getGg009() {
        return gg009;
    }

    public void setGg009(String gg009) {
        this.gg009 = gg009;
    }

    public String getGg010() {
        return gg010;
    }

    public void setGg010(String gg010) {
        this.gg010 = gg010;
    }

    public String getGg011() {
        return gg011;
    }

    public void setGg011(String gg011) {
        this.gg011 = gg011;
    }

    public String getGg012() {
        return gg012;
    }

    public void setGg012(String gg012) {
        this.gg012 = gg012;
    }

    public String getGg013() {
        return gg013;
    }

    public void setGg013(String gg013) {
        this.gg013 = gg013;
    }

    public String getGg014() {
        return gg014;
    }

    public void setGg014(String gg014) {
        this.gg014 = gg014;
    }

    public String getGg015() {
        return gg015;
    }

    public void setGg015(String gg015) {
        this.gg015 = gg015;
    }

    public String getGg016() {
        return gg016;
    }

    public void setGg016(String gg016) {
        this.gg016 = gg016;
    }

    public String getGg017() {
        return gg017;
    }

    public void setGg017(String gg017) {
        this.gg017 = gg017;
    }

    public String getGg018() {
        return gg018;
    }

    public void setGg018(String gg018) {
        this.gg018 = gg018;
    }

    public String getGg019() {
        return gg019;
    }

    public void setGg019(String gg019) {
        this.gg019 = gg019;
    }

    public String getGg020() {
        return gg020;
    }

    public void setGg020(String gg020) {
        this.gg020 = gg020;
    }

    public String getGg021() {
        return gg021;
    }

    public void setGg021(String gg021) {
        this.gg021 = gg021;
    }

    public String getGg022() {
        return gg022;
    }

    public void setGg022(String gg022) {
        this.gg022 = gg022;
    }

    public String getGg023() {
        return gg023;
    }

    public void setGg023(String gg023) {
        this.gg023 = gg023;
    }

    public String getGg024() {
        return gg024;
    }

    public void setGg024(String gg024) {
        this.gg024 = gg024;
    }

    public String getGg025() {
        return gg025;
    }

    public void setGg025(String gg025) {
        this.gg025 = gg025;
    }

    public String getGg026() {
        return gg026;
    }

    public void setGg026(String gg026) {
        this.gg026 = gg026;
    }

    public String getGg027() {
        return gg027;
    }

    public void setGg027(String gg027) {
        this.gg027 = gg027;
    }

    public String getGg028() {
        return gg028;
    }

    public void setGg028(String gg028) {
        this.gg028 = gg028;
    }

    public String getGg029() {
        return gg029;
    }

    public void setGg029(String gg029) {
        this.gg029 = gg029;
    }

    public String getGg030() {
        return gg030;
    }

    public void setGg030(String gg030) {
        this.gg030 = gg030;
    }

    public BigDecimal getGg031() {
        return gg031;
    }

    public void setGg031(BigDecimal gg031) {
        this.gg031 = gg031;
    }

    public Long getGg032() {
        return gg032;
    }

    public void setGg032(Long gg032) {
        this.gg032 = gg032;
    }

    public BigDecimal getGg033() {
        return gg033;
    }

    public void setGg033(BigDecimal gg033) {
        this.gg033 = gg033;
    }

    public BigDecimal getGg034() {
        return gg034;
    }

    public void setGg034(BigDecimal gg034) {
        this.gg034 = gg034;
    }

    public Integer getGg035() {
        return gg035;
    }

    public void setGg035(Integer gg035) {
        this.gg035 = gg035;
    }

    public String getGg036() {
        return gg036;
    }

    public void setGg036(String gg036) {
        this.gg036 = gg036;
    }

    public String getGg037() {
        return gg037;
    }

    public void setGg037(String gg037) {
        this.gg037 = gg037;
    }

    public String getGg038() {
        return gg038;
    }

    public void setGg038(String gg038) {
        this.gg038 = gg038;
    }

    public String getGg039() {
        return gg039;
    }

    public void setGg039(String gg039) {
        this.gg039 = gg039;
    }

    public String getGg040() {
        return gg040;
    }

    public void setGg040(String gg040) {
        this.gg040 = gg040;
    }

    public String getGg041() {
        return gg041;
    }

    public void setGg041(String gg041) {
        this.gg041 = gg041;
    }

    public String getGg042() {
        return gg042;
    }

    public void setGg042(String gg042) {
        this.gg042 = gg042;
    }

    public String getGg043() {
        return gg043;
    }

    public void setGg043(String gg043) {
        this.gg043 = gg043;
    }

    public String getGg047() {
        return gg047;
    }

    public void setGg047(String gg047) {
        this.gg047 = gg047;
    }

    public String getGg048() {
        return gg048;
    }

    public void setGg048(String gg048) {
        this.gg048 = gg048;
    }

    public String getGg049() {
        return gg049;
    }

    public void setGg049(String gg049) {
        this.gg049 = gg049;
    }

    public String getGg050() {
        return gg050;
    }

    public void setGg050(String gg050) {
        this.gg050 = gg050;
    }

    public String getGg051() {
        return gg051;
    }

    public void setGg051(String gg051) {
        this.gg051 = gg051;
    }

    public String getGg053() {
        return gg053;
    }

    public void setGg053(String gg053) {
        this.gg053 = gg053;
    }

    public String getGg054() {
        return gg054;
    }

    public void setGg054(String gg054) {
        this.gg054 = gg054;
    }

    public String getGg055() {
        return gg055;
    }

    public void setGg055(String gg055) {
        this.gg055 = gg055;
    }

    public String getGg056() {
        return gg056;
    }

    public void setGg056(String gg056) {
        this.gg056 = gg056;
    }

    public Long getGg057() {
        return gg057;
    }

    public void setGg057(Long gg057) {
        this.gg057 = gg057;
    }

    public Long getGg058() {
        return gg058;
    }

    public void setGg058(Long gg058) {
        this.gg058 = gg058;
    }

    public String getGg059() {
        return gg059;
    }

    public void setGg059(String gg059) {
        this.gg059 = gg059;
    }

    public String getGg060() {
        return gg060;
    }

    public void setGg060(String gg060) {
        this.gg060 = gg060;
    }

    public String getGg062() {
        return gg062;
    }

    public void setGg062(String gg062) {
        this.gg062 = gg062;
    }

    public String getGg064() {
        return gg064;
    }

    public void setGg064(String gg064) {
        this.gg064 = gg064;
    }

    public String getGg065() {
        return gg065;
    }

    public void setGg065(String gg065) {
        this.gg065 = gg065;
    }

    public String getGg066() {
        return gg066;
    }

    public void setGg066(String gg066) {
        this.gg066 = gg066;
    }

    public String getGg067() {
        return gg067;
    }

    public void setGg067(String gg067) {
        this.gg067 = gg067;
    }

    public String getGg068() {
        return gg068;
    }

    public void setGg068(String gg068) {
        this.gg068 = gg068;
    }

    public String getGg069() {
        return gg069;
    }

    public void setGg069(String gg069) {
        this.gg069 = gg069;
    }

    public String getGg070() {
        return gg070;
    }

    public void setGg070(String gg070) {
        this.gg070 = gg070;
    }

    public String getGg071() {
        return gg071;
    }

    public void setGg071(String gg071) {
        this.gg071 = gg071;
    }

    public String getGg072() {
        return gg072;
    }

    public void setGg072(String gg072) {
        this.gg072 = gg072;
    }

    public String getGg073() {
        return gg073;
    }

    public void setGg073(String gg073) {
        this.gg073 = gg073;
    }

    public String getGg074() {
        return gg074;
    }

    public void setGg074(String gg074) {
        this.gg074 = gg074;
    }

    public String getGg075() {
        return gg075;
    }

    public void setGg075(String gg075) {
        this.gg075 = gg075;
    }

    public String getGg076() {
        return gg076;
    }

    public void setGg076(String gg076) {
        this.gg076 = gg076;
    }

    public String getGg077() {
        return gg077;
    }

    public void setGg077(String gg077) {
        this.gg077 = gg077;
    }

    public String getGg078() {
        return gg078;
    }

    public void setGg078(String gg078) {
        this.gg078 = gg078;
    }

    public String getGg079() {
        return gg079;
    }

    public void setGg079(String gg079) {
        this.gg079 = gg079;
    }

    public String getGg082() {
        return gg082;
    }

    public void setGg082(String gg082) {
        this.gg082 = gg082;
    }

    public String getGg083() {
        return gg083;
    }

    public void setGg083(String gg083) {
        this.gg083 = gg083;
    }

    public String getGg084() {
        return gg084;
    }

    public void setGg084(String gg084) {
        this.gg084 = gg084;
    }

    public String getGg085() {
        return gg085;
    }

    public void setGg085(String gg085) {
        this.gg085 = gg085;
    }

    public String getGg086() {
        return gg086;
    }

    public void setGg086(String gg086) {
        this.gg086 = gg086;
    }

    public String getGg087() {
        return gg087;
    }

    public void setGg087(String gg087) {
        this.gg087 = gg087;
    }

    public String getGg088() {
        return gg088;
    }

    public void setGg088(String gg088) {
        this.gg088 = gg088;
    }

    public String getGg091() {
        return gg091;
    }

    public void setGg091(String gg091) {
        this.gg091 = gg091;
    }

    public String getGg092() {
        return gg092;
    }

    public void setGg092(String gg092) {
        this.gg092 = gg092;
    }

    public String getGg093() {
        return gg093;
    }

    public void setGg093(String gg093) {
        this.gg093 = gg093;
    }

    public String getGg094() {
        return gg094;
    }

    public void setGg094(String gg094) {
        this.gg094 = gg094;
    }

    public String getGg095() {
        return gg095;
    }

    public void setGg095(String gg095) {
        this.gg095 = gg095;
    }

    public String getGg096() {
        return gg096;
    }

    public void setGg096(String gg096) {
        this.gg096 = gg096;
    }

    public String getGg097() {
        return gg097;
    }

    public void setGg097(String gg097) {
        this.gg097 = gg097;
    }

    public Short getGg099() {
        return gg099;
    }

    public void setGg099(Short gg099) {
        this.gg099 = gg099;
    }

    public Short getGg100() {
        return gg100;
    }

    public void setGg100(Short gg100) {
        this.gg100 = gg100;
    }

    public String getGg101() {
        return gg101;
    }

    public void setGg101(String gg101) {
        this.gg101 = gg101;
    }

    public String getGg102() {
        return gg102;
    }

    public void setGg102(String gg102) {
        this.gg102 = gg102;
    }

    public String getGg104() {
        return gg104;
    }

    public void setGg104(String gg104) {
        this.gg104 = gg104;
    }

    public String getGg105() {
        return gg105;
    }

    public void setGg105(String gg105) {
        this.gg105 = gg105;
    }

    public String getGg106() {
        return gg106;
    }

    public void setGg106(String gg106) {
        this.gg106 = gg106;
    }

    public String getGg108() {
        return gg108;
    }

    public void setGg108(String gg108) {
        this.gg108 = gg108;
    }

    public String getGg109() {
        return gg109;
    }

    public void setGg109(String gg109) {
        this.gg109 = gg109;
    }

    public String getGg110() {
        return gg110;
    }

    public void setGg110(String gg110) {
        this.gg110 = gg110;
    }

    public String getGg114() {
        return gg114;
    }

    public void setGg114(String gg114) {
        this.gg114 = gg114;
    }

    public String getGg115() {
        return gg115;
    }

    public void setGg115(String gg115) {
        this.gg115 = gg115;
    }

    public String getGg116() {
        return gg116;
    }

    public void setGg116(String gg116) {
        this.gg116 = gg116;
    }

    public BigDecimal getGg117() {
        return gg117;
    }

    public void setGg117(BigDecimal gg117) {
        this.gg117 = gg117;
    }

    public BigDecimal getGg118() {
        return gg118;
    }

    public void setGg118(BigDecimal gg118) {
        this.gg118 = gg118;
    }

    public String getGg120() {
        return gg120;
    }

    public void setGg120(String gg120) {
        this.gg120 = gg120;
    }

    public String getGg121() {
        return gg121;
    }

    public void setGg121(String gg121) {
        this.gg121 = gg121;
    }

    public String getGg122() {
        return gg122;
    }

    public void setGg122(String gg122) {
        this.gg122 = gg122;
    }

    public BigDecimal getGg123() {
        return gg123;
    }

    public void setGg123(BigDecimal gg123) {
        this.gg123 = gg123;
    }

    public Short getGg125() {
        return gg125;
    }

    public void setGg125(Short gg125) {
        this.gg125 = gg125;
    }

    public String getGg126() {
        return gg126;
    }

    public void setGg126(String gg126) {
        this.gg126 = gg126;
    }

    public BigDecimal getGg127() {
        return gg127;
    }

    public void setGg127(BigDecimal gg127) {
        this.gg127 = gg127;
    }

    public BigDecimal getGg128() {
        return gg128;
    }

    public void setGg128(BigDecimal gg128) {
        this.gg128 = gg128;
    }

    public BigDecimal getGg129() {
        return gg129;
    }

    public void setGg129(BigDecimal gg129) {
        this.gg129 = gg129;
    }

    public BigDecimal getGg130() {
        return gg130;
    }

    public void setGg130(BigDecimal gg130) {
        this.gg130 = gg130;
    }

    public BigDecimal getGg131() {
        return gg131;
    }

    public void setGg131(BigDecimal gg131) {
        this.gg131 = gg131;
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

    public BigDecimal getGg133() {
        return gg133;
    }

    public void setGg133(BigDecimal gg133) {
        this.gg133 = gg133;
    }

    public String getGg134() {
        return gg134;
    }

    public void setGg134(String gg134) {
        this.gg134 = gg134;
    }

    public String getGg135() {
        return gg135;
    }

    public void setGg135(String gg135) {
        this.gg135 = gg135;
    }

    public String getGg136() {
        return gg136;
    }

    public void setGg136(String gg136) {
        this.gg136 = gg136;
    }

    public Long getGg137() {
        return gg137;
    }

    public void setGg137(Long gg137) {
        this.gg137 = gg137;
    }

    public String getGg138() {
        return gg138;
    }

    public void setGg138(String gg138) {
        this.gg138 = gg138;
    }

    public String getGg139() {
        return gg139;
    }

    public void setGg139(String gg139) {
        this.gg139 = gg139;
    }

    public String getGg140() {
        return gg140;
    }

    public void setGg140(String gg140) {
        this.gg140 = gg140;
    }

    public BigDecimal getGg141() {
        return gg141;
    }

    public void setGg141(BigDecimal gg141) {
        this.gg141 = gg141;
    }

    public String getGg142() {
        return gg142;
    }

    public void setGg142(String gg142) {
        this.gg142 = gg142;
    }

    public String getGg143() {
        return gg143;
    }

    public void setGg143(String gg143) {
        this.gg143 = gg143;
    }

    public Long getGg144() {
        return gg144;
    }

    public void setGg144(Long gg144) {
        this.gg144 = gg144;
    }

    public BigDecimal getGg145() {
        return gg145;
    }

    public void setGg145(BigDecimal gg145) {
        this.gg145 = gg145;
    }

    public String getGg146() {
        return gg146;
    }

    public void setGg146(String gg146) {
        this.gg146 = gg146;
    }

    public String getGg147() {
        return gg147;
    }

    public void setGg147(String gg147) {
        this.gg147 = gg147;
    }

    public Long getGg148() {
        return gg148;
    }

    public void setGg148(Long gg148) {
        this.gg148 = gg148;
    }

    public String getGg149() {
        return gg149;
    }

    public void setGg149(String gg149) {
        this.gg149 = gg149;
    }

    public String getGg150() {
        return gg150;
    }

    public void setGg150(String gg150) {
        this.gg150 = gg150;
    }

    public String getCrmgg01() {
        return crmgg01;
    }

    public void setCrmgg01(String crmgg01) {
        this.crmgg01 = crmgg01;
    }

    public String getCrmgg02() {
        return crmgg02;
    }

    public void setCrmgg02(String crmgg02) {
        this.crmgg02 = crmgg02;
    }

    public String getCrmgg03() {
        return crmgg03;
    }

    public void setCrmgg03(String crmgg03) {
        this.crmgg03 = crmgg03;
    }

    public String getCrmgg04() {
        return crmgg04;
    }

    public void setCrmgg04(String crmgg04) {
        this.crmgg04 = crmgg04;
    }

    public String getCrmgg05() {
        return crmgg05;
    }

    public void setCrmgg05(String crmgg05) {
        this.crmgg05 = crmgg05;
    }

    public String getCrmgg06() {
        return crmgg06;
    }

    public void setCrmgg06(String crmgg06) {
        this.crmgg06 = crmgg06;
    }

    public String getCrmgg07() {
        return crmgg07;
    }

    public void setCrmgg07(String crmgg07) {
        this.crmgg07 = crmgg07;
    }

    public String getCrmgg08() {
        return crmgg08;
    }

    public void setCrmgg08(String crmgg08) {
        this.crmgg08 = crmgg08;
    }

    public String getCrmgg09() {
        return crmgg09;
    }

    public void setCrmgg09(String crmgg09) {
        this.crmgg09 = crmgg09;
    }

    public String getCrmgg10() {
        return crmgg10;
    }

    public void setCrmgg10(String crmgg10) {
        this.crmgg10 = crmgg10;
    }

    public String getCrmgg11() {
        return crmgg11;
    }

    public void setCrmgg11(String crmgg11) {
        this.crmgg11 = crmgg11;
    }

    public String getCrmgg12() {
        return crmgg12;
    }

    public void setCrmgg12(String crmgg12) {
        this.crmgg12 = crmgg12;
    }

    public String getCrmgg13() {
        return crmgg13;
    }

    public void setCrmgg13(String crmgg13) {
        this.crmgg13 = crmgg13;
    }

    public String getCrmgg14() {
        return crmgg14;
    }

    public void setCrmgg14(String crmgg14) {
        this.crmgg14 = crmgg14;
    }

    public String getCrmgg15() {
        return crmgg15;
    }

    public void setCrmgg15(String crmgg15) {
        this.crmgg15 = crmgg15;
    }

    public String getCrmgg16() {
        return crmgg16;
    }

    public void setCrmgg16(String crmgg16) {
        this.crmgg16 = crmgg16;
    }

    public String getCrmgg17() {
        return crmgg17;
    }

    public void setCrmgg17(String crmgg17) {
        this.crmgg17 = crmgg17;
    }

    public String getCrmgg18() {
        return crmgg18;
    }

    public void setCrmgg18(String crmgg18) {
        this.crmgg18 = crmgg18;
    }

    public String getCrmgg19() {
        return crmgg19;
    }

    public void setCrmgg19(String crmgg19) {
        this.crmgg19 = crmgg19;
    }

    public String getCrmgg20() {
        return crmgg20;
    }

    public void setCrmgg20(String crmgg20) {
        this.crmgg20 = crmgg20;
    }

    public String getGg151() {
        return gg151;
    }

    public void setGg151(String gg151) {
        this.gg151 = gg151;
    }

    public String getGg152() {
        return gg152;
    }

    public void setGg152(String gg152) {
        this.gg152 = gg152;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gg001 != null ? gg001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRMGG)) {
            return false;
        }
        CRMGG other = (CRMGG) object;
        if ((this.gg001 == null && other.gg001 != null) || (this.gg001 != null && !this.gg001.equals(other.gg001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CRMGG[ gg001=" + gg001 + " ]";
    }

    public String getGg044() {
        return gg044;
    }

    public void setGg044(String gg044) {
        this.gg044 = gg044;
    }

    public String getGg045() {
        return gg045;
    }

    public void setGg045(String gg045) {
        this.gg045 = gg045;
    }

    public String getGg046() {
        return gg046;
    }

    public void setGg046(String gg046) {
        this.gg046 = gg046;
    }

    public String getGg052() {
        return gg052;
    }

    public void setGg052(String gg052) {
        this.gg052 = gg052;
    }

    public String getGg061() {
        return gg061;
    }

    public void setGg061(String gg061) {
        this.gg061 = gg061;
    }

    public String getGg063() {
        return gg063;
    }

    public void setGg063(String gg063) {
        this.gg063 = gg063;
    }

    public String getGg080() {
        return gg080;
    }

    public void setGg080(String gg080) {
        this.gg080 = gg080;
    }

    public String getGg081() {
        return gg081;
    }

    public void setGg081(String gg081) {
        this.gg081 = gg081;
    }

    public String getGg089() {
        return gg089;
    }

    public void setGg089(String gg089) {
        this.gg089 = gg089;
    }

    public String getGg090() {
        return gg090;
    }

    public void setGg090(String gg090) {
        this.gg090 = gg090;
    }

    public String getGg098() {
        return gg098;
    }

    public void setGg098(String gg098) {
        this.gg098 = gg098;
    }

    public String getGg103() {
        return gg103;
    }

    public void setGg103(String gg103) {
        this.gg103 = gg103;
    }

    public String getGg107() {
        return gg107;
    }

    public void setGg107(String gg107) {
        this.gg107 = gg107;
    }

    public String getGg111() {
        return gg111;
    }

    public void setGg111(String gg111) {
        this.gg111 = gg111;
    }

    public String getGg112() {
        return gg112;
    }

    public void setGg112(String gg112) {
        this.gg112 = gg112;
    }

    public String getGg113() {
        return gg113;
    }

    public void setGg113(String gg113) {
        this.gg113 = gg113;
    }

    public String getGg119() {
        return gg119;
    }

    public void setGg119(String gg119) {
        this.gg119 = gg119;
    }

    public String getGg124() {
        return gg124;
    }

    public void setGg124(String gg124) {
        this.gg124 = gg124;
    }

    public String getGg132() {
        return gg132;
    }

    public void setGg132(String gg132) {
        this.gg132 = gg132;
    }

    public String getGg153() {
        return gg153;
    }

    public void setGg153(String gg153) {
        this.gg153 = gg153;
    }

    public String getGg154() {
        return gg154;
    }

    public void setGg154(String gg154) {
        this.gg154 = gg154;
    }

    public String getGg155() {
        return gg155;
    }

    public void setGg155(String gg155) {
        this.gg155 = gg155;
    }

    public String getGg156() {
        return gg156;
    }

    public void setGg156(String gg156) {
        this.gg156 = gg156;
    }

    public String getGg157() {
        return gg157;
    }

    public void setGg157(String gg157) {
        this.gg157 = gg157;
    }

    public String getGg158() {
        return gg158;
    }

    public void setGg158(String gg158) {
        this.gg158 = gg158;
    }

    public String getGg159() {
        return gg159;
    }

    public void setGg159(String gg159) {
        this.gg159 = gg159;
    }

    public String getGg160() {
        return gg160;
    }

    public void setGg160(String gg160) {
        this.gg160 = gg160;
    }

    public String getGg161() {
        return gg161;
    }

    public void setGg161(String gg161) {
        this.gg161 = gg161;
    }

    public String getGg162() {
        return gg162;
    }

    public void setGg162(String gg162) {
        this.gg162 = gg162;
    }

    public String getGg163() {
        return gg163;
    }

    public void setGg163(String gg163) {
        this.gg163 = gg163;
    }

    public String getGg164() {
        return gg164;
    }

    public void setGg164(String gg164) {
        this.gg164 = gg164;
    }

    public String getGg165() {
        return gg165;
    }

    public void setGg165(String gg165) {
        this.gg165 = gg165;
    }

    public String getGg166() {
        return gg166;
    }

    public void setGg166(String gg166) {
        this.gg166 = gg166;
    }

    public String getGg167() {
        return gg167;
    }

    public void setGg167(String gg167) {
        this.gg167 = gg167;
    }

    public String getGg168() {
        return gg168;
    }

    public void setGg168(String gg168) {
        this.gg168 = gg168;
    }

    public String getGg169() {
        return gg169;
    }

    public void setGg169(String gg169) {
        this.gg169 = gg169;
    }

    public String getGg170() {
        return gg170;
    }

    public void setGg170(String gg170) {
        this.gg170 = gg170;
    }

    public String getGg171() {
        return gg171;
    }

    public void setGg171(String gg171) {
        this.gg171 = gg171;
    }

    public String getGg172() {
        return gg172;
    }

    public void setGg172(String gg172) {
        this.gg172 = gg172;
    }

}
