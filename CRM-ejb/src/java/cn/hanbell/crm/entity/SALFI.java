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
@Table(name = "SALFI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SALFI.findAll", query = "SELECT s FROM SALFI s"),
    @NamedQuery(name = "SALFI.findByCompany", query = "SELECT s FROM SALFI s WHERE s.company = :company"),
    @NamedQuery(name = "SALFI.findByCreator", query = "SELECT s FROM SALFI s WHERE s.creator = :creator"),
    @NamedQuery(name = "SALFI.findByUsrGroup", query = "SELECT s FROM SALFI s WHERE s.usrGroup = :usrGroup"),
    @NamedQuery(name = "SALFI.findByCreateDate", query = "SELECT s FROM SALFI s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SALFI.findByModifier", query = "SELECT s FROM SALFI s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SALFI.findByModiDate", query = "SELECT s FROM SALFI s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SALFI.findByFlag", query = "SELECT s FROM SALFI s WHERE s.flag = :flag"),
    @NamedQuery(name = "SALFI.findByFi001ANDFi002", query = "SELECT s FROM SALFI s WHERE s.fi001 = :fi001 AND s.fi002 = :fi002"),
    @NamedQuery(name = "SALFI.findByFi001", query = "SELECT s FROM SALFI s WHERE s.fi001 = :fi001"),
    @NamedQuery(name = "SALFI.findByFi002", query = "SELECT s FROM SALFI s WHERE s.fi002 = :fi002"),
    @NamedQuery(name = "SALFI.findByFi003", query = "SELECT s FROM SALFI s WHERE s.fi003 = :fi003"),
    @NamedQuery(name = "SALFI.findByCustomer", query = "SELECT s FROM SALFI s WHERE s.customer = :customer"),
    @NamedQuery(name = "SALFI.findByProduct", query = "SELECT s FROM SALFI s WHERE s.product = :product"),
    @NamedQuery(name = "SALFI.findByRegion", query = "SELECT s FROM SALFI s WHERE s.region = :region"),
    @NamedQuery(name = "SALFI.findByDealer", query = "SELECT s FROM SALFI s WHERE s.dealer = :dealer"),
    @NamedQuery(name = "SALFI.findBySalfi01", query = "SELECT s FROM SALFI s WHERE s.salfi01 = :salfi01"),
    @NamedQuery(name = "SALFI.findBySalfi02", query = "SELECT s FROM SALFI s WHERE s.salfi02 = :salfi02"),
    @NamedQuery(name = "SALFI.findBySalfi03", query = "SELECT s FROM SALFI s WHERE s.salfi03 = :salfi03")})
public class SALFI implements Serializable {

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
    @Column(name = "FI001")
    private String fi001;
    @Size(max = 1000)
    @Column(name = "FI002")
    private String fi002;
    @Size(max = 10)
    @Column(name = "FI003")
    private String fi003;
    @Size(max = 10)
    @Column(name = "FI004")
    private String fi004;
    @Size(max = 8)
    @Column(name = "FI005")
    private String fi005;
    @Size(max = 8)
    @Column(name = "FI006")
    private String fi006;
    @Size(max = 8)
    @Column(name = "FI007")
    private String fi007;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FI008")
    private BigDecimal fi008;
    @Size(max = 2147483647)
    @Column(name = "FI009")
    private String fi009;
    @Size(max = 2)
    @Column(name = "FI010")
    private String fi010;
    @Size(max = 10)
    @Column(name = "FI011")
    private String fi011;
    @Size(max = 6)
    @Column(name = "FI012")
    private String fi012;
    @Size(max = 255)
    @Column(name = "FI013")
    private String fi013;
    @Size(max = 1)
    @Column(name = "FI014")
    private String fi014;
    @Size(max = 10)
    @Column(name = "FI015")
    private String fi015;
    @Size(max = 2)
    @Column(name = "FI016")
    private String fi016;
    @Size(max = 6)
    @Column(name = "FI017")
    private String fi017;
    @Size(max = 1)
    @Column(name = "FI018")
    private String fi018;
    @Size(max = 8)
    @Column(name = "FI019")
    private String fi019;
    @Size(max = 10)
    @Column(name = "FI020")
    private String fi020;
    @Size(max = 10)
    @Column(name = "FI021")
    private String fi021;
    @Size(max = 6)
    @Column(name = "FI022")
    private String fi022;
    @Size(max = 2)
    @Column(name = "FI023")
    private String fi023;
    @Size(max = 15)
    @Column(name = "FI024")
    private String fi024;
    @Size(max = 10)
    @Column(name = "FI025")
    private String fi025;
    @Size(max = 10)
    @Column(name = "FI026")
    private String fi026;
    @Size(max = 255)
    @Column(name = "FI027")
    private String fi027;
    @Size(max = 255)
    @Column(name = "FI028")
    private String fi028;
    @Size(max = 8)
    @Column(name = "FI029")
    private String fi029;
    @Size(max = 8)
    @Column(name = "FI030")
    private String fi030;
    @Size(max = 255)
    @Column(name = "FI031")
    private String fi031;
    @Size(max = 255)
    @Column(name = "FI032")
    private String fi032;
    @Size(max = 10)
    @Column(name = "FI033")
    private String fi033;
    @Size(max = 10)
    @Column(name = "FI034")
    private String fi034;
    @Size(max = 255)
    @Column(name = "FI035")
    private String fi035;
    @Size(max = 255)
    @Column(name = "FI036")
    private String fi036;
    @Size(max = 1)
    @Column(name = "FI037")
    private String fi037;
    @Size(max = 1)
    @Column(name = "FI038")
    private String fi038;
    @Size(max = 6)
    @Column(name = "FI039")
    private String fi039;
    @Size(max = 8)
    @Column(name = "FI040")
    private String fi040;
    @Size(max = 8)
    @Column(name = "FI041")
    private String fi041;
    @Size(max = 8)
    @Column(name = "FI042")
    private String fi042;
    @Size(max = 50)
    @Column(name = "FI043")
    private String fi043;
    @Size(max = 255)
    @Column(name = "FI044")
    private String fi044;
    @Size(max = 10)
    @Column(name = "FI045")
    private String fi045;
    @Size(max = 10)
    @Column(name = "FI046")
    private String fi046;
    @Size(max = 8)
    @Column(name = "FI047")
    private String fi047;
    @Size(max = 20)
    @Column(name = "FI048")
    private String fi048;
    @Size(max = 50)
    @Column(name = "FI049")
    private String fi049;
    @Size(max = 10)
    @Column(name = "FI050")
    private String fi050;
    @Size(max = 1)
    @Column(name = "FI051")
    private String fi051;
    @Size(max = 50)
    @Column(name = "FI052")
    private String fi052;
    @Size(max = 50)
    @Column(name = "FI053")
    private String fi053;
    @Column(name = "FI054")
    private BigDecimal fi054;
    @Column(name = "FI055")
    private BigDecimal fi055;
    @Column(name = "FI056")
    private BigDecimal fi056;
    @Column(name = "FI057")
    private BigDecimal fi057;
    @Size(max = 100)
    @Column(name = "FI058")
    private String fi058;
    @Size(max = 1)
    @Column(name = "FI059")
    private String fi059;
    @Size(max = 20)
    @Column(name = "FI060")
    private String fi060;
    @Size(max = 40)
    @Column(name = "FI061")
    private String fi061;
    @Column(name = "FI062")
    private BigDecimal fi062;
    @Column(name = "FI063")
    private BigDecimal fi063;
    @Column(name = "FI064")
    private BigDecimal fi064;
    @Column(name = "FI065")
    private BigDecimal fi065;
    @Size(max = 6)
    @Column(name = "FI066")
    private String fi066;
    @Size(max = 1)
    @Column(name = "FI067")
    private String fi067;
    @Size(max = 1)
    @Column(name = "FI068")
    private String fi068;
    @Size(max = 14)
    @Column(name = "FI069")
    private String fi069;
    @Size(max = 120)
    @Column(name = "FI070")
    private String fi070;
    @Size(max = 10)
    @Column(name = "FI071")
    private String fi071;
    @Size(max = 1)
    @Column(name = "FI072")
    private String fi072;
    @Column(name = "FI073")
    private BigDecimal fi073;
    @Column(name = "FI074")
    private BigDecimal fi074;
    @Size(max = 8)
    @Column(name = "FI075")
    private String fi075;
    @Size(max = 1000)
    @Column(name = "FI076")
    private String fi076;
    @Size(max = 1000)
    @Column(name = "FI077")
    private String fi077;
    @Column(name = "FI078")
    private BigDecimal fi078;
    @Column(name = "FI079")
    private BigDecimal fi079;
    @Size(max = 1)
    @Column(name = "FI080")
    private String fi080;
    @Size(max = 30)
    @Column(name = "FI081")
    private String fi081;
    @Size(max = 60)
    @Column(name = "FI082")
    private String fi082;
    @Size(max = 4)
    @Column(name = "FI083")
    private String fi083;
    @Size(max = 1)
    @Column(name = "FI084")
    private String fi084;
    @Column(name = "FI085")
    private BigDecimal fi085;
    @Column(name = "FI086")
    private BigDecimal fi086;
    @Column(name = "FI087")
    private BigDecimal fi087;
    @Column(name = "FI088")
    private BigDecimal fi088;
    @Column(name = "FI089")
    private BigDecimal fi089;
    @Column(name = "FI090")
    private BigDecimal fi090;
    @Size(max = 4)
    @Column(name = "FI091")
    private String fi091;
    @Size(max = 10)
    @Column(name = "FI092")
    private String fi092;
    @Column(name = "FI093")
    private BigDecimal fi093;
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
    @Column(name = "FI094")
    private String fi094;
    @Column(name = "FI095")
    private Long fi095;
    @Size(max = 4)
    @Column(name = "FI096")
    private String fi096;
    @Size(max = 11)
    @Column(name = "FI097")
    private String fi097;
    @Size(max = 8)
    @Column(name = "FI098")
    private String fi098;
    @Size(max = 8)
    @Column(name = "FI099")
    private String fi099;
    @Size(max = 20)
    @Column(name = "FI100")
    private String fi100;
    @Size(max = 30)
    @Column(name = "FI101")
    private String fi101;
    @Column(name = "FI102")
    private Long fi102;
    @Size(max = 10)
    @Column(name = "FI197")
    private String fi197;
    @Size(max = 10)
    @Column(name = "FI198")
    private String fi198;
    @Size(max = 10)
    @Column(name = "FI199")
    private String fi199;
    @Column(name = "FI103")
    private BigDecimal fi103;
    @Size(max = 10)
    @Column(name = "FI104")
    private String fi104;
    @Size(max = 10)
    @Column(name = "FI105")
    private String fi105;
    @Column(name = "FI106")
    private Long fi106;
    @Column(name = "FI107")
    private BigDecimal fi107;
    @Size(max = 10)
    @Column(name = "FI108")
    private String fi108;
    @Size(max = 10)
    @Column(name = "FI109")
    private String fi109;
    @Column(name = "FI110")
    private Long fi110;
    @Size(max = 10)
    @Column(name = "FI111")
    private String fi111;
    @Size(max = 1)
    @Column(name = "FI112")
    private String fi112;
    @Size(max = 255)
    @Column(name = "SALFI01")
    private String salfi01;
    @Size(max = 255)
    @Column(name = "SALFI02")
    private String salfi02;
    @Size(max = 255)
    @Column(name = "SALFI03")
    private String salfi03;
    @Size(max = 255)
    @Column(name = "SALFI04")
    private String salfi04;
    @Size(max = 255)
    @Column(name = "SALFI05")
    private String salfi05;
    @Size(max = 255)
    @Column(name = "SALFI06")
    private String salfi06;
    @Size(max = 255)
    @Column(name = "SALFI07")
    private String salfi07;
    @Size(max = 255)
    @Column(name = "SALFI08")
    private String salfi08;
    @Size(max = 255)
    @Column(name = "SALFI09")
    private String salfi09;
    @Size(max = 255)
    @Column(name = "SALFI10")
    private String salfi10;
    @Size(max = 255)
    @Column(name = "SALFI11")
    private String salfi11;
    @Size(max = 255)
    @Column(name = "SALFI12")
    private String salfi12;
    @Size(max = 255)
    @Column(name = "SALFI13")
    private String salfi13;
    @Size(max = 255)
    @Column(name = "SALFI14")
    private String salfi14;
    @Size(max = 255)
    @Column(name = "SALFI15")
    private String salfi15;
    @Size(max = 255)
    @Column(name = "SALFI16")
    private String salfi16;
    @Size(max = 255)
    @Column(name = "SALFI17")
    private String salfi17;
    @Size(max = 255)
    @Column(name = "SALFI18")
    private String salfi18;
    @Size(max = 255)
    @Column(name = "SALFI19")
    private String salfi19;
    @Size(max = 255)
    @Column(name = "SALFI20")
    private String salfi20;
    @Size(max = 255)
    @Column(name = "FI113")
    private String fi113;
    @Size(max = 30)
    @Column(name = "FI114")
    private String fi114;
    @Size(max = 10)
    @Column(name = "FI115")
    private String fi115;
    @Size(max = 1)
    @Column(name = "FI116")
    private String fi116;
    @Size(max = 6)
    @Column(name = "FI117")
    private String fi117;

    public SALFI() {
    }

    public SALFI(String fi001) {
        this.fi001 = fi001;
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

    public String getFi001() {
        return fi001;
    }

    public void setFi001(String fi001) {
        this.fi001 = fi001;
    }

    public String getFi002() {
        return fi002;
    }

    public void setFi002(String fi002) {
        this.fi002 = fi002;
    }

    public String getFi003() {
        return fi003;
    }

    public void setFi003(String fi003) {
        this.fi003 = fi003;
    }

    public String getFi004() {
        return fi004;
    }

    public void setFi004(String fi004) {
        this.fi004 = fi004;
    }

    public String getFi005() {
        return fi005;
    }

    public void setFi005(String fi005) {
        this.fi005 = fi005;
    }

    public String getFi006() {
        return fi006;
    }

    public void setFi006(String fi006) {
        this.fi006 = fi006;
    }

    public String getFi007() {
        return fi007;
    }

    public void setFi007(String fi007) {
        this.fi007 = fi007;
    }

    public BigDecimal getFi008() {
        return fi008;
    }

    public void setFi008(BigDecimal fi008) {
        this.fi008 = fi008;
    }

    public String getFi009() {
        return fi009;
    }

    public void setFi009(String fi009) {
        this.fi009 = fi009;
    }

    public String getFi010() {
        return fi010;
    }

    public void setFi010(String fi010) {
        this.fi010 = fi010;
    }

    public String getFi011() {
        return fi011;
    }

    public void setFi011(String fi011) {
        this.fi011 = fi011;
    }

    public String getFi012() {
        return fi012;
    }

    public void setFi012(String fi012) {
        this.fi012 = fi012;
    }

    public String getFi013() {
        return fi013;
    }

    public void setFi013(String fi013) {
        this.fi013 = fi013;
    }

    public String getFi014() {
        return fi014;
    }

    public void setFi014(String fi014) {
        this.fi014 = fi014;
    }

    public String getFi015() {
        return fi015;
    }

    public void setFi015(String fi015) {
        this.fi015 = fi015;
    }

    public String getFi016() {
        return fi016;
    }

    public void setFi016(String fi016) {
        this.fi016 = fi016;
    }

    public String getFi017() {
        return fi017;
    }

    public void setFi017(String fi017) {
        this.fi017 = fi017;
    }

    public String getFi018() {
        return fi018;
    }

    public void setFi018(String fi018) {
        this.fi018 = fi018;
    }

    public String getFi019() {
        return fi019;
    }

    public void setFi019(String fi019) {
        this.fi019 = fi019;
    }

    public String getFi020() {
        return fi020;
    }

    public void setFi020(String fi020) {
        this.fi020 = fi020;
    }

    public String getFi021() {
        return fi021;
    }

    public void setFi021(String fi021) {
        this.fi021 = fi021;
    }

    public String getFi022() {
        return fi022;
    }

    public void setFi022(String fi022) {
        this.fi022 = fi022;
    }

    public String getFi023() {
        return fi023;
    }

    public void setFi023(String fi023) {
        this.fi023 = fi023;
    }

    public String getFi024() {
        return fi024;
    }

    public void setFi024(String fi024) {
        this.fi024 = fi024;
    }

    public String getFi025() {
        return fi025;
    }

    public void setFi025(String fi025) {
        this.fi025 = fi025;
    }

    public String getFi026() {
        return fi026;
    }

    public void setFi026(String fi026) {
        this.fi026 = fi026;
    }

    public String getFi027() {
        return fi027;
    }

    public void setFi027(String fi027) {
        this.fi027 = fi027;
    }

    public String getFi028() {
        return fi028;
    }

    public void setFi028(String fi028) {
        this.fi028 = fi028;
    }

    public String getFi029() {
        return fi029;
    }

    public void setFi029(String fi029) {
        this.fi029 = fi029;
    }

    public String getFi030() {
        return fi030;
    }

    public void setFi030(String fi030) {
        this.fi030 = fi030;
    }

    public String getFi031() {
        return fi031;
    }

    public void setFi031(String fi031) {
        this.fi031 = fi031;
    }

    public String getFi032() {
        return fi032;
    }

    public void setFi032(String fi032) {
        this.fi032 = fi032;
    }

    public String getFi033() {
        return fi033;
    }

    public void setFi033(String fi033) {
        this.fi033 = fi033;
    }

    public String getFi034() {
        return fi034;
    }

    public void setFi034(String fi034) {
        this.fi034 = fi034;
    }

    public String getFi035() {
        return fi035;
    }

    public void setFi035(String fi035) {
        this.fi035 = fi035;
    }

    public String getFi036() {
        return fi036;
    }

    public void setFi036(String fi036) {
        this.fi036 = fi036;
    }

    public String getFi037() {
        return fi037;
    }

    public void setFi037(String fi037) {
        this.fi037 = fi037;
    }

    public String getFi038() {
        return fi038;
    }

    public void setFi038(String fi038) {
        this.fi038 = fi038;
    }

    public String getFi039() {
        return fi039;
    }

    public void setFi039(String fi039) {
        this.fi039 = fi039;
    }

    public String getFi040() {
        return fi040;
    }

    public void setFi040(String fi040) {
        this.fi040 = fi040;
    }

    public String getFi041() {
        return fi041;
    }

    public void setFi041(String fi041) {
        this.fi041 = fi041;
    }

    public String getFi042() {
        return fi042;
    }

    public void setFi042(String fi042) {
        this.fi042 = fi042;
    }

    public String getFi043() {
        return fi043;
    }

    public void setFi043(String fi043) {
        this.fi043 = fi043;
    }

    public String getFi044() {
        return fi044;
    }

    public void setFi044(String fi044) {
        this.fi044 = fi044;
    }

    public String getFi045() {
        return fi045;
    }

    public void setFi045(String fi045) {
        this.fi045 = fi045;
    }

    public String getFi046() {
        return fi046;
    }

    public void setFi046(String fi046) {
        this.fi046 = fi046;
    }

    public String getFi047() {
        return fi047;
    }

    public void setFi047(String fi047) {
        this.fi047 = fi047;
    }

    public String getFi048() {
        return fi048;
    }

    public void setFi048(String fi048) {
        this.fi048 = fi048;
    }

    public String getFi049() {
        return fi049;
    }

    public void setFi049(String fi049) {
        this.fi049 = fi049;
    }

    public String getFi050() {
        return fi050;
    }

    public void setFi050(String fi050) {
        this.fi050 = fi050;
    }

    public String getFi051() {
        return fi051;
    }

    public void setFi051(String fi051) {
        this.fi051 = fi051;
    }

    public String getFi052() {
        return fi052;
    }

    public void setFi052(String fi052) {
        this.fi052 = fi052;
    }

    public String getFi053() {
        return fi053;
    }

    public void setFi053(String fi053) {
        this.fi053 = fi053;
    }

    public BigDecimal getFi054() {
        return fi054;
    }

    public void setFi054(BigDecimal fi054) {
        this.fi054 = fi054;
    }

    public BigDecimal getFi055() {
        return fi055;
    }

    public void setFi055(BigDecimal fi055) {
        this.fi055 = fi055;
    }

    public BigDecimal getFi056() {
        return fi056;
    }

    public void setFi056(BigDecimal fi056) {
        this.fi056 = fi056;
    }

    public BigDecimal getFi057() {
        return fi057;
    }

    public void setFi057(BigDecimal fi057) {
        this.fi057 = fi057;
    }

    public String getFi058() {
        return fi058;
    }

    public void setFi058(String fi058) {
        this.fi058 = fi058;
    }

    public String getFi059() {
        return fi059;
    }

    public void setFi059(String fi059) {
        this.fi059 = fi059;
    }

    public String getFi060() {
        return fi060;
    }

    public void setFi060(String fi060) {
        this.fi060 = fi060;
    }

    public String getFi061() {
        return fi061;
    }

    public void setFi061(String fi061) {
        this.fi061 = fi061;
    }

    public BigDecimal getFi062() {
        return fi062;
    }

    public void setFi062(BigDecimal fi062) {
        this.fi062 = fi062;
    }

    public BigDecimal getFi063() {
        return fi063;
    }

    public void setFi063(BigDecimal fi063) {
        this.fi063 = fi063;
    }

    public BigDecimal getFi064() {
        return fi064;
    }

    public void setFi064(BigDecimal fi064) {
        this.fi064 = fi064;
    }

    public BigDecimal getFi065() {
        return fi065;
    }

    public void setFi065(BigDecimal fi065) {
        this.fi065 = fi065;
    }

    public String getFi066() {
        return fi066;
    }

    public void setFi066(String fi066) {
        this.fi066 = fi066;
    }

    public String getFi067() {
        return fi067;
    }

    public void setFi067(String fi067) {
        this.fi067 = fi067;
    }

    public String getFi068() {
        return fi068;
    }

    public void setFi068(String fi068) {
        this.fi068 = fi068;
    }

    public String getFi069() {
        return fi069;
    }

    public void setFi069(String fi069) {
        this.fi069 = fi069;
    }

    public String getFi070() {
        return fi070;
    }

    public void setFi070(String fi070) {
        this.fi070 = fi070;
    }

    public String getFi071() {
        return fi071;
    }

    public void setFi071(String fi071) {
        this.fi071 = fi071;
    }

    public String getFi072() {
        return fi072;
    }

    public void setFi072(String fi072) {
        this.fi072 = fi072;
    }

    public BigDecimal getFi073() {
        return fi073;
    }

    public void setFi073(BigDecimal fi073) {
        this.fi073 = fi073;
    }

    public BigDecimal getFi074() {
        return fi074;
    }

    public void setFi074(BigDecimal fi074) {
        this.fi074 = fi074;
    }

    public String getFi075() {
        return fi075;
    }

    public void setFi075(String fi075) {
        this.fi075 = fi075;
    }

    public String getFi076() {
        return fi076;
    }

    public void setFi076(String fi076) {
        this.fi076 = fi076;
    }

    public String getFi077() {
        return fi077;
    }

    public void setFi077(String fi077) {
        this.fi077 = fi077;
    }

    public BigDecimal getFi078() {
        return fi078;
    }

    public void setFi078(BigDecimal fi078) {
        this.fi078 = fi078;
    }

    public BigDecimal getFi079() {
        return fi079;
    }

    public void setFi079(BigDecimal fi079) {
        this.fi079 = fi079;
    }

    public String getFi080() {
        return fi080;
    }

    public void setFi080(String fi080) {
        this.fi080 = fi080;
    }

    public String getFi081() {
        return fi081;
    }

    public void setFi081(String fi081) {
        this.fi081 = fi081;
    }

    public String getFi082() {
        return fi082;
    }

    public void setFi082(String fi082) {
        this.fi082 = fi082;
    }

    public String getFi083() {
        return fi083;
    }

    public void setFi083(String fi083) {
        this.fi083 = fi083;
    }

    public String getFi084() {
        return fi084;
    }

    public void setFi084(String fi084) {
        this.fi084 = fi084;
    }

    public BigDecimal getFi085() {
        return fi085;
    }

    public void setFi085(BigDecimal fi085) {
        this.fi085 = fi085;
    }

    public BigDecimal getFi086() {
        return fi086;
    }

    public void setFi086(BigDecimal fi086) {
        this.fi086 = fi086;
    }

    public BigDecimal getFi087() {
        return fi087;
    }

    public void setFi087(BigDecimal fi087) {
        this.fi087 = fi087;
    }

    public BigDecimal getFi088() {
        return fi088;
    }

    public void setFi088(BigDecimal fi088) {
        this.fi088 = fi088;
    }

    public BigDecimal getFi089() {
        return fi089;
    }

    public void setFi089(BigDecimal fi089) {
        this.fi089 = fi089;
    }

    public BigDecimal getFi090() {
        return fi090;
    }

    public void setFi090(BigDecimal fi090) {
        this.fi090 = fi090;
    }

    public String getFi091() {
        return fi091;
    }

    public void setFi091(String fi091) {
        this.fi091 = fi091;
    }

    public String getFi092() {
        return fi092;
    }

    public void setFi092(String fi092) {
        this.fi092 = fi092;
    }

    public BigDecimal getFi093() {
        return fi093;
    }

    public void setFi093(BigDecimal fi093) {
        this.fi093 = fi093;
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

    public String getFi094() {
        return fi094;
    }

    public void setFi094(String fi094) {
        this.fi094 = fi094;
    }

    public Long getFi095() {
        return fi095;
    }

    public void setFi095(Long fi095) {
        this.fi095 = fi095;
    }

    public String getFi096() {
        return fi096;
    }

    public void setFi096(String fi096) {
        this.fi096 = fi096;
    }

    public String getFi097() {
        return fi097;
    }

    public void setFi097(String fi097) {
        this.fi097 = fi097;
    }

    public String getFi098() {
        return fi098;
    }

    public void setFi098(String fi098) {
        this.fi098 = fi098;
    }

    public String getFi099() {
        return fi099;
    }

    public void setFi099(String fi099) {
        this.fi099 = fi099;
    }

    public String getFi100() {
        return fi100;
    }

    public void setFi100(String fi100) {
        this.fi100 = fi100;
    }

    public String getFi101() {
        return fi101;
    }

    public void setFi101(String fi101) {
        this.fi101 = fi101;
    }

    public Long getFi102() {
        return fi102;
    }

    public void setFi102(Long fi102) {
        this.fi102 = fi102;
    }

    public String getFi197() {
        return fi197;
    }

    public void setFi197(String fi197) {
        this.fi197 = fi197;
    }

    public String getFi198() {
        return fi198;
    }

    public void setFi198(String fi198) {
        this.fi198 = fi198;
    }

    public String getFi199() {
        return fi199;
    }

    public void setFi199(String fi199) {
        this.fi199 = fi199;
    }

    public BigDecimal getFi103() {
        return fi103;
    }

    public void setFi103(BigDecimal fi103) {
        this.fi103 = fi103;
    }

    public String getFi104() {
        return fi104;
    }

    public void setFi104(String fi104) {
        this.fi104 = fi104;
    }

    public String getFi105() {
        return fi105;
    }

    public void setFi105(String fi105) {
        this.fi105 = fi105;
    }

    public Long getFi106() {
        return fi106;
    }

    public void setFi106(Long fi106) {
        this.fi106 = fi106;
    }

    public BigDecimal getFi107() {
        return fi107;
    }

    public void setFi107(BigDecimal fi107) {
        this.fi107 = fi107;
    }

    public String getFi108() {
        return fi108;
    }

    public void setFi108(String fi108) {
        this.fi108 = fi108;
    }

    public String getFi109() {
        return fi109;
    }

    public void setFi109(String fi109) {
        this.fi109 = fi109;
    }

    public Long getFi110() {
        return fi110;
    }

    public void setFi110(Long fi110) {
        this.fi110 = fi110;
    }

    public String getFi111() {
        return fi111;
    }

    public void setFi111(String fi111) {
        this.fi111 = fi111;
    }

    public String getFi112() {
        return fi112;
    }

    public void setFi112(String fi112) {
        this.fi112 = fi112;
    }

    public String getSalfi01() {
        return salfi01;
    }

    public void setSalfi01(String salfi01) {
        this.salfi01 = salfi01;
    }

    public String getSalfi02() {
        return salfi02;
    }

    public void setSalfi02(String salfi02) {
        this.salfi02 = salfi02;
    }

    public String getSalfi03() {
        return salfi03;
    }

    public void setSalfi03(String salfi03) {
        this.salfi03 = salfi03;
    }

    public String getSalfi04() {
        return salfi04;
    }

    public void setSalfi04(String salfi04) {
        this.salfi04 = salfi04;
    }

    public String getSalfi05() {
        return salfi05;
    }

    public void setSalfi05(String salfi05) {
        this.salfi05 = salfi05;
    }

    public String getSalfi06() {
        return salfi06;
    }

    public void setSalfi06(String salfi06) {
        this.salfi06 = salfi06;
    }

    public String getSalfi07() {
        return salfi07;
    }

    public void setSalfi07(String salfi07) {
        this.salfi07 = salfi07;
    }

    public String getSalfi08() {
        return salfi08;
    }

    public void setSalfi08(String salfi08) {
        this.salfi08 = salfi08;
    }

    public String getSalfi09() {
        return salfi09;
    }

    public void setSalfi09(String salfi09) {
        this.salfi09 = salfi09;
    }

    public String getSalfi10() {
        return salfi10;
    }

    public void setSalfi10(String salfi10) {
        this.salfi10 = salfi10;
    }

    public String getSalfi11() {
        return salfi11;
    }

    public void setSalfi11(String salfi11) {
        this.salfi11 = salfi11;
    }

    public String getSalfi12() {
        return salfi12;
    }

    public void setSalfi12(String salfi12) {
        this.salfi12 = salfi12;
    }

    public String getSalfi13() {
        return salfi13;
    }

    public void setSalfi13(String salfi13) {
        this.salfi13 = salfi13;
    }

    public String getSalfi14() {
        return salfi14;
    }

    public void setSalfi14(String salfi14) {
        this.salfi14 = salfi14;
    }

    public String getSalfi15() {
        return salfi15;
    }

    public void setSalfi15(String salfi15) {
        this.salfi15 = salfi15;
    }

    public String getSalfi16() {
        return salfi16;
    }

    public void setSalfi16(String salfi16) {
        this.salfi16 = salfi16;
    }

    public String getSalfi17() {
        return salfi17;
    }

    public void setSalfi17(String salfi17) {
        this.salfi17 = salfi17;
    }

    public String getSalfi18() {
        return salfi18;
    }

    public void setSalfi18(String salfi18) {
        this.salfi18 = salfi18;
    }

    public String getSalfi19() {
        return salfi19;
    }

    public void setSalfi19(String salfi19) {
        this.salfi19 = salfi19;
    }

    public String getSalfi20() {
        return salfi20;
    }

    public void setSalfi20(String salfi20) {
        this.salfi20 = salfi20;
    }

    public String getFi113() {
        return fi113;
    }

    public void setFi113(String fi113) {
        this.fi113 = fi113;
    }

    public String getFi114() {
        return fi114;
    }

    public void setFi114(String fi114) {
        this.fi114 = fi114;
    }

    public String getFi115() {
        return fi115;
    }

    public void setFi115(String fi115) {
        this.fi115 = fi115;
    }

    public String getFi116() {
        return fi116;
    }

    public void setFi116(String fi116) {
        this.fi116 = fi116;
    }

    public String getFi117() {
        return fi117;
    }

    public void setFi117(String fi117) {
        this.fi117 = fi117;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fi001 != null ? fi001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SALFI)) {
            return false;
        }
        SALFI other = (SALFI) object;
        if ((this.fi001 == null && other.fi001 != null) || (this.fi001 != null && !this.fi001.equals(other.fi001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SALFI[ fi001=" + fi001 + " ]";
    }
    
}
