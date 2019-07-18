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
@Table(name = "WARTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARTA.findAll", query = "SELECT w FROM WARTA w"),
    @NamedQuery(name = "WARTA.findByCompany", query = "SELECT w FROM WARTA w WHERE w.company = :company"),
    @NamedQuery(name = "WARTA.findByCreator", query = "SELECT w FROM WARTA w WHERE w.creator = :creator"),
    @NamedQuery(name = "WARTA.findByUsrGroup", query = "SELECT w FROM WARTA w WHERE w.usrGroup = :usrGroup"),
    @NamedQuery(name = "WARTA.findByCreateDate", query = "SELECT w FROM WARTA w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WARTA.findByModifier", query = "SELECT w FROM WARTA w WHERE w.modifier = :modifier"),
    @NamedQuery(name = "WARTA.findByModiDate", query = "SELECT w FROM WARTA w WHERE w.modiDate = :modiDate"),
    @NamedQuery(name = "WARTA.findByFlag", query = "SELECT w FROM WARTA w WHERE w.flag = :flag"),
    @NamedQuery(name = "WARTA.findByPK", query = "SELECT w FROM WARTA w WHERE w.wARTAPK.ta001 = :ta001 and w.wARTAPK.ta002 = :ta002"),
    @NamedQuery(name = "WARTA.findByTa001", query = "SELECT w FROM WARTA w WHERE w.wARTAPK.ta001 = :ta001"),
    @NamedQuery(name = "WARTA.findByTa002", query = "SELECT w FROM WARTA w WHERE w.wARTAPK.ta002 = :ta002"),
    @NamedQuery(name = "WARTA.findByTa003", query = "SELECT w FROM WARTA w WHERE w.ta003 = :ta003"),
    @NamedQuery(name = "WARTA.findByTa004", query = "SELECT w FROM WARTA w WHERE w.ta004 = :ta004"),
    @NamedQuery(name = "WARTA.findByTa005", query = "SELECT w FROM WARTA w WHERE w.ta005 = :ta005"),
    @NamedQuery(name = "WARTA.findByTa006", query = "SELECT w FROM WARTA w WHERE w.ta006 = :ta006"),
    @NamedQuery(name = "WARTA.findByTa007", query = "SELECT w FROM WARTA w WHERE w.ta007 = :ta007"),
    @NamedQuery(name = "WARTA.findByTa008", query = "SELECT w FROM WARTA w WHERE w.ta008 = :ta008"),
    @NamedQuery(name = "WARTA.findByTa009", query = "SELECT w FROM WARTA w WHERE w.ta009 = :ta009"),
    @NamedQuery(name = "WARTA.findByTa010", query = "SELECT w FROM WARTA w WHERE w.ta010 = :ta010"),
    @NamedQuery(name = "WARTA.findByTa011", query = "SELECT w FROM WARTA w WHERE w.ta011 = :ta011"),
    @NamedQuery(name = "WARTA.findByTa012", query = "SELECT w FROM WARTA w WHERE w.ta012 = :ta012"),
    @NamedQuery(name = "WARTA.findByTa013", query = "SELECT w FROM WARTA w WHERE w.ta013 = :ta013"),
    @NamedQuery(name = "WARTA.findByTa014", query = "SELECT w FROM WARTA w WHERE w.ta014 = :ta014"),
    @NamedQuery(name = "WARTA.findByTa015", query = "SELECT w FROM WARTA w WHERE w.ta015 = :ta015"),
    @NamedQuery(name = "WARTA.findByTa016", query = "SELECT w FROM WARTA w WHERE w.ta016 = :ta016"),
    @NamedQuery(name = "WARTA.findByTa017", query = "SELECT w FROM WARTA w WHERE w.ta017 = :ta017"),
    @NamedQuery(name = "WARTA.findByTa018", query = "SELECT w FROM WARTA w WHERE w.ta018 = :ta018"),
    @NamedQuery(name = "WARTA.findByTa019", query = "SELECT w FROM WARTA w WHERE w.ta019 = :ta019"),
    @NamedQuery(name = "WARTA.findByTa020", query = "SELECT w FROM WARTA w WHERE w.ta020 = :ta020"),
    @NamedQuery(name = "WARTA.findByTa021", query = "SELECT w FROM WARTA w WHERE w.ta021 = :ta021"),
    @NamedQuery(name = "WARTA.findByTa022", query = "SELECT w FROM WARTA w WHERE w.ta022 = :ta022"),
    @NamedQuery(name = "WARTA.findByTa023", query = "SELECT w FROM WARTA w WHERE w.ta023 = :ta023"),
    @NamedQuery(name = "WARTA.findByTa024", query = "SELECT w FROM WARTA w WHERE w.ta024 = :ta024"),
    @NamedQuery(name = "WARTA.findByTa025", query = "SELECT w FROM WARTA w WHERE w.ta025 = :ta025"),
    @NamedQuery(name = "WARTA.findByTa026", query = "SELECT w FROM WARTA w WHERE w.ta026 = :ta026"),
    @NamedQuery(name = "WARTA.findByTa027", query = "SELECT w FROM WARTA w WHERE w.ta027 = :ta027"),
    @NamedQuery(name = "WARTA.findByCustomer", query = "SELECT w FROM WARTA w WHERE w.customer = :customer"),
    @NamedQuery(name = "WARTA.findByProduct", query = "SELECT w FROM WARTA w WHERE w.product = :product"),
    @NamedQuery(name = "WARTA.findByRegion", query = "SELECT w FROM WARTA w WHERE w.region = :region"),
    @NamedQuery(name = "WARTA.findByDealer", query = "SELECT w FROM WARTA w WHERE w.dealer = :dealer"),
    @NamedQuery(name = "WARTA.findByTa028", query = "SELECT w FROM WARTA w WHERE w.ta028 = :ta028"),
    @NamedQuery(name = "WARTA.findByTa029", query = "SELECT w FROM WARTA w WHERE w.ta029 = :ta029"),
    @NamedQuery(name = "WARTA.findByWarta01", query = "SELECT w FROM WARTA w WHERE w.warta01 = :warta01"),
    @NamedQuery(name = "WARTA.findByWarta02", query = "SELECT w FROM WARTA w WHERE w.warta02 = :warta02"),
    @NamedQuery(name = "WARTA.findByWarta03", query = "SELECT w FROM WARTA w WHERE w.warta03 = :warta03"),
    @NamedQuery(name = "WARTA.findByWarta04", query = "SELECT w FROM WARTA w WHERE w.warta04 = :warta04"),
    @NamedQuery(name = "WARTA.findByWarta05", query = "SELECT w FROM WARTA w WHERE w.warta05 = :warta05"),
    @NamedQuery(name = "WARTA.findByWarta06", query = "SELECT w FROM WARTA w WHERE w.warta06 = :warta06"),
    @NamedQuery(name = "WARTA.findByWarta07", query = "SELECT w FROM WARTA w WHERE w.warta07 = :warta07"),
    @NamedQuery(name = "WARTA.findByWarta08", query = "SELECT w FROM WARTA w WHERE w.warta08 = :warta08"),
    @NamedQuery(name = "WARTA.findByWarta09", query = "SELECT w FROM WARTA w WHERE w.warta09 = :warta09"),
    @NamedQuery(name = "WARTA.findByWarta10", query = "SELECT w FROM WARTA w WHERE w.warta10 = :warta10"),
    @NamedQuery(name = "WARTA.findByWarta11", query = "SELECT w FROM WARTA w WHERE w.warta11 = :warta11"),
    @NamedQuery(name = "WARTA.findByWarta12", query = "SELECT w FROM WARTA w WHERE w.warta12 = :warta12"),
    @NamedQuery(name = "WARTA.findByWarta13", query = "SELECT w FROM WARTA w WHERE w.warta13 = :warta13"),
    @NamedQuery(name = "WARTA.findByWarta14", query = "SELECT w FROM WARTA w WHERE w.warta14 = :warta14"),
    @NamedQuery(name = "WARTA.findByWarta15", query = "SELECT w FROM WARTA w WHERE w.warta15 = :warta15"),
    @NamedQuery(name = "WARTA.findByWarta16", query = "SELECT w FROM WARTA w WHERE w.warta16 = :warta16"),
    @NamedQuery(name = "WARTA.findByWarta17", query = "SELECT w FROM WARTA w WHERE w.warta17 = :warta17"),
    @NamedQuery(name = "WARTA.findByWarta18", query = "SELECT w FROM WARTA w WHERE w.warta18 = :warta18"),
    @NamedQuery(name = "WARTA.findByWarta19", query = "SELECT w FROM WARTA w WHERE w.warta19 = :warta19"),
    @NamedQuery(name = "WARTA.findByWarta20", query = "SELECT w FROM WARTA w WHERE w.warta20 = :warta20"),
    @NamedQuery(name = "WARTA.findByTa030", query = "SELECT w FROM WARTA w WHERE w.ta030 = :ta030"),
    @NamedQuery(name = "WARTA.findByTa031", query = "SELECT w FROM WARTA w WHERE w.ta031 = :ta031"),
    @NamedQuery(name = "WARTA.findByTa032", query = "SELECT w FROM WARTA w WHERE w.ta032 = :ta032"),
    @NamedQuery(name = "WARTA.findByTa033", query = "SELECT w FROM WARTA w WHERE w.ta033 = :ta033"),
    @NamedQuery(name = "WARTA.findByTa034", query = "SELECT w FROM WARTA w WHERE w.ta034 = :ta034"),
    @NamedQuery(name = "WARTA.findByTa035", query = "SELECT w FROM WARTA w WHERE w.ta035 = :ta035"),
    @NamedQuery(name = "WARTA.findByTa036", query = "SELECT w FROM WARTA w WHERE w.ta036 = :ta036"),
    @NamedQuery(name = "WARTA.findByTa037", query = "SELECT w FROM WARTA w WHERE w.ta037 = :ta037"),
    @NamedQuery(name = "WARTA.findByTa038", query = "SELECT w FROM WARTA w WHERE w.ta038 = :ta038"),
    @NamedQuery(name = "WARTA.findByTa039", query = "SELECT w FROM WARTA w WHERE w.ta039 = :ta039"),
    @NamedQuery(name = "WARTA.findByTa040", query = "SELECT w FROM WARTA w WHERE w.ta040 = :ta040"),
    @NamedQuery(name = "WARTA.findByTa041", query = "SELECT w FROM WARTA w WHERE w.ta041 = :ta041"),
    @NamedQuery(name = "WARTA.findByTa042", query = "SELECT w FROM WARTA w WHERE w.ta042 = :ta042"),
    @NamedQuery(name = "WARTA.findByTa200", query = "SELECT w FROM WARTA w WHERE w.ta200 = :ta200"),
    @NamedQuery(name = "WARTA.findByTa201", query = "SELECT w FROM WARTA w WHERE w.ta201 = :ta201"),
    @NamedQuery(name = "WARTA.findByTa202", query = "SELECT w FROM WARTA w WHERE w.ta202 = :ta202"),
    @NamedQuery(name = "WARTA.findByTa043", query = "SELECT w FROM WARTA w WHERE w.ta043 = :ta043")})
public class WARTA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WARTAPK wARTAPK;
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
    @Column(name = "TA003")
    private String ta003;
    @Size(max = 10)
    @Column(name = "TA004")
    private String ta004;
    @Size(max = 255)
    @Column(name = "TA005")
    private String ta005;
    @Size(max = 1)
    @Column(name = "TA006")
    private String ta006;
    @Size(max = 2)
    @Column(name = "TA007")
    private String ta007;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TA008")
    private BigDecimal ta008;
    @Size(max = 8)
    @Column(name = "TA009")
    private String ta009;
    @Size(max = 10)
    @Column(name = "TA010")
    private String ta010;
    @Size(max = 8)
    @Column(name = "TA011")
    private String ta011;
    @Size(max = 10)
    @Column(name = "TA012")
    private String ta012;
    @Size(max = 20)
    @Column(name = "TA013")
    private String ta013;
    @Size(max = 6)
    @Column(name = "TA014")
    private String ta014;
    @Size(max = 4)
    @Column(name = "TA015")
    private String ta015;
    @Size(max = 11)
    @Column(name = "TA016")
    private String ta016;

    @Size(max = 1)
    @Column(name = "TA017")
    private String ta017;

    @Size(max = 1000)
    @Column(name = "TA018")
    private String ta018;
    @Size(max = 1000)
    @Column(name = "TA019")
    private String ta019;

    @Size(max = 1)
    @Column(name = "TA020")
    private String ta020;

    @Size(max = 10)
    @Column(name = "TA021")
    private String ta021;
    @Size(max = 10)
    @Column(name = "TA022")
    private String ta022;
    @Column(name = "TA023")
    private BigDecimal ta023;
    @Column(name = "TA024")
    private BigDecimal ta024;
    @Size(max = 30)
    @Column(name = "TA025")
    private String ta025;
    @Size(max = 30)
    @Column(name = "TA026")
    private String ta026;
    @Size(max = 60)
    @Column(name = "TA027")
    private String ta027;
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
    @Size(max = 60)
    @Column(name = "TA028")
    private String ta028;
    @Size(max = 60)
    @Column(name = "TA029")
    private String ta029;
    @Size(max = 255)
    @Column(name = "WARTA01")
    private String warta01;
    @Size(max = 255)
    @Column(name = "WARTA02")
    private String warta02;
    @Size(max = 255)
    @Column(name = "WARTA03")
    private String warta03;
    @Size(max = 255)
    @Column(name = "WARTA04")
    private String warta04;
    @Size(max = 255)
    @Column(name = "WARTA05")
    private String warta05;
    @Size(max = 255)
    @Column(name = "WARTA06")
    private String warta06;
    @Size(max = 255)
    @Column(name = "WARTA07")
    private String warta07;
    @Size(max = 255)
    @Column(name = "WARTA08")
    private String warta08;
    @Size(max = 255)
    @Column(name = "WARTA09")
    private String warta09;
    @Size(max = 255)
    @Column(name = "WARTA10")
    private String warta10;
    @Size(max = 255)
    @Column(name = "WARTA11")
    private String warta11;
    @Size(max = 255)
    @Column(name = "WARTA12")
    private String warta12;
    @Size(max = 255)
    @Column(name = "WARTA13")
    private String warta13;
    @Size(max = 255)
    @Column(name = "WARTA14")
    private String warta14;
    @Size(max = 255)
    @Column(name = "WARTA15")
    private String warta15;
    @Size(max = 255)
    @Column(name = "WARTA16")
    private String warta16;
    @Size(max = 255)
    @Column(name = "WARTA17")
    private String warta17;
    @Size(max = 255)
    @Column(name = "WARTA18")
    private String warta18;
    @Size(max = 255)
    @Column(name = "WARTA19")
    private String warta19;
    @Size(max = 255)
    @Column(name = "WARTA20")
    private String warta20;
    @Size(max = 10)
    @Column(name = "TA030")
    private String ta030;
    @Size(max = 10)
    @Column(name = "TA031")
    private String ta031;
    @Size(max = 10)
    @Column(name = "TA032")
    private String ta032;
    @Size(max = 120)
    @Column(name = "TA033")
    private String ta033;
    @Size(max = 120)
    @Column(name = "TA034")
    private String ta034;
    @Size(max = 120)
    @Column(name = "TA035")
    private String ta035;
    @Size(max = 30)
    @Column(name = "TA036")
    private String ta036;
    @Size(max = 4000)
    @Column(name = "TA037")
    private String ta037;
    @Size(max = 60)
    @Column(name = "TA038")
    private String ta038;
    @Size(max = 15)
    @Column(name = "TA039")
    private String ta039;
    @Size(max = 4)
    @Column(name = "TA040")
    private String ta040;
    @Size(max = 11)
    @Column(name = "TA041")
    private String ta041;
    @Size(max = 30)
    @Column(name = "TA042")
    private String ta042;

    @Size(max = 1)
    @Column(name = "TA200")
    private String ta200;

    @Size(max = 20)
    @Column(name = "TA201")
    private String ta201;
    @Size(max = 40)
    @Column(name = "TA202")
    private String ta202;
    @Size(max = 30)
    @Column(name = "TA043")
    private String ta043;

    public WARTA() {
    }

    public WARTA(WARTAPK wARTAPK) {
        this.wARTAPK = wARTAPK;
    }

    public WARTA(String ta001, String ta002) {
        this.wARTAPK = new WARTAPK(ta001, ta002);
    }

    public WARTAPK getWARTAPK() {
        return wARTAPK;
    }

    public void setWARTAPK(WARTAPK wARTAPK) {
        this.wARTAPK = wARTAPK;
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

    public String getTa003() {
        return ta003;
    }

    public void setTa003(String ta003) {
        this.ta003 = ta003;
    }

    public String getTa004() {
        return ta004;
    }

    public void setTa004(String ta004) {
        this.ta004 = ta004;
    }

    public String getTa005() {
        return ta005;
    }

    public void setTa005(String ta005) {
        this.ta005 = ta005;
    }

    public String getTa006() {
        return ta006;
    }

    public void setTa006(String ta006) {
        this.ta006 = ta006;
    }

    public String getTa007() {
        return ta007;
    }

    public void setTa007(String ta007) {
        this.ta007 = ta007;
    }

    public BigDecimal getTa008() {
        return ta008;
    }

    public void setTa008(BigDecimal ta008) {
        this.ta008 = ta008;
    }

    public String getTa009() {
        return ta009;
    }

    public void setTa009(String ta009) {
        this.ta009 = ta009;
    }

    public String getTa010() {
        return ta010;
    }

    public void setTa010(String ta010) {
        this.ta010 = ta010;
    }

    public String getTa011() {
        return ta011;
    }

    public void setTa011(String ta011) {
        this.ta011 = ta011;
    }

    public String getTa012() {
        return ta012;
    }

    public void setTa012(String ta012) {
        this.ta012 = ta012;
    }

    public String getTa013() {
        return ta013;
    }

    public void setTa013(String ta013) {
        this.ta013 = ta013;
    }

    public String getTa014() {
        return ta014;
    }

    public void setTa014(String ta014) {
        this.ta014 = ta014;
    }

    public String getTa015() {
        return ta015;
    }

    public void setTa015(String ta015) {
        this.ta015 = ta015;
    }

    public String getTa016() {
        return ta016;
    }

    public void setTa016(String ta016) {
        this.ta016 = ta016;
    }

    public String getTa017() {
        return ta017;
    }

    public void setTa017(String ta017) {
        this.ta017 = ta017;
    }

    public String getTa018() {
        return ta018;
    }

    public void setTa018(String ta018) {
        this.ta018 = ta018;
    }

    public String getTa019() {
        return ta019;
    }

    public void setTa019(String ta019) {
        this.ta019 = ta019;
    }

    public String getTa020() {
        return ta020;
    }

    public void setTa020(String ta020) {
        this.ta020 = ta020;
    }

    public String getTa021() {
        return ta021;
    }

    public void setTa021(String ta021) {
        this.ta021 = ta021;
    }

    public String getTa022() {
        return ta022;
    }

    public void setTa022(String ta022) {
        this.ta022 = ta022;
    }

    public BigDecimal getTa023() {
        return ta023;
    }

    public void setTa023(BigDecimal ta023) {
        this.ta023 = ta023;
    }

    public BigDecimal getTa024() {
        return ta024;
    }

    public void setTa024(BigDecimal ta024) {
        this.ta024 = ta024;
    }

    public String getTa025() {
        return ta025;
    }

    public void setTa025(String ta025) {
        this.ta025 = ta025;
    }

    public String getTa026() {
        return ta026;
    }

    public void setTa026(String ta026) {
        this.ta026 = ta026;
    }

    public String getTa027() {
        return ta027;
    }

    public void setTa027(String ta027) {
        this.ta027 = ta027;
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

    public String getTa028() {
        return ta028;
    }

    public void setTa028(String ta028) {
        this.ta028 = ta028;
    }

    public String getTa029() {
        return ta029;
    }

    public void setTa029(String ta029) {
        this.ta029 = ta029;
    }

    public String getWarta01() {
        return warta01;
    }

    public void setWarta01(String warta01) {
        this.warta01 = warta01;
    }

    public String getWarta02() {
        return warta02;
    }

    public void setWarta02(String warta02) {
        this.warta02 = warta02;
    }

    public String getWarta03() {
        return warta03;
    }

    public void setWarta03(String warta03) {
        this.warta03 = warta03;
    }

    public String getWarta04() {
        return warta04;
    }

    public void setWarta04(String warta04) {
        this.warta04 = warta04;
    }

    public String getWarta05() {
        return warta05;
    }

    public void setWarta05(String warta05) {
        this.warta05 = warta05;
    }

    public String getWarta06() {
        return warta06;
    }

    public void setWarta06(String warta06) {
        this.warta06 = warta06;
    }

    public String getWarta07() {
        return warta07;
    }

    public void setWarta07(String warta07) {
        this.warta07 = warta07;
    }

    public String getWarta08() {
        return warta08;
    }

    public void setWarta08(String warta08) {
        this.warta08 = warta08;
    }

    public String getWarta09() {
        return warta09;
    }

    public void setWarta09(String warta09) {
        this.warta09 = warta09;
    }

    public String getWarta10() {
        return warta10;
    }

    public void setWarta10(String warta10) {
        this.warta10 = warta10;
    }

    public String getWarta11() {
        return warta11;
    }

    public void setWarta11(String warta11) {
        this.warta11 = warta11;
    }

    public String getWarta12() {
        return warta12;
    }

    public void setWarta12(String warta12) {
        this.warta12 = warta12;
    }

    public String getWarta13() {
        return warta13;
    }

    public void setWarta13(String warta13) {
        this.warta13 = warta13;
    }

    public String getWarta14() {
        return warta14;
    }

    public void setWarta14(String warta14) {
        this.warta14 = warta14;
    }

    public String getWarta15() {
        return warta15;
    }

    public void setWarta15(String warta15) {
        this.warta15 = warta15;
    }

    public String getWarta16() {
        return warta16;
    }

    public void setWarta16(String warta16) {
        this.warta16 = warta16;
    }

    public String getWarta17() {
        return warta17;
    }

    public void setWarta17(String warta17) {
        this.warta17 = warta17;
    }

    public String getWarta18() {
        return warta18;
    }

    public void setWarta18(String warta18) {
        this.warta18 = warta18;
    }

    public String getWarta19() {
        return warta19;
    }

    public void setWarta19(String warta19) {
        this.warta19 = warta19;
    }

    public String getWarta20() {
        return warta20;
    }

    public void setWarta20(String warta20) {
        this.warta20 = warta20;
    }

    public String getTa030() {
        return ta030;
    }

    public void setTa030(String ta030) {
        this.ta030 = ta030;
    }

    public String getTa031() {
        return ta031;
    }

    public void setTa031(String ta031) {
        this.ta031 = ta031;
    }

    public String getTa032() {
        return ta032;
    }

    public void setTa032(String ta032) {
        this.ta032 = ta032;
    }

    public String getTa033() {
        return ta033;
    }

    public void setTa033(String ta033) {
        this.ta033 = ta033;
    }

    public String getTa034() {
        return ta034;
    }

    public void setTa034(String ta034) {
        this.ta034 = ta034;
    }

    public String getTa035() {
        return ta035;
    }

    public void setTa035(String ta035) {
        this.ta035 = ta035;
    }

    public String getTa036() {
        return ta036;
    }

    public void setTa036(String ta036) {
        this.ta036 = ta036;
    }

    public String getTa037() {
        return ta037;
    }

    public void setTa037(String ta037) {
        this.ta037 = ta037;
    }

    public String getTa038() {
        return ta038;
    }

    public void setTa038(String ta038) {
        this.ta038 = ta038;
    }

    public String getTa039() {
        return ta039;
    }

    public void setTa039(String ta039) {
        this.ta039 = ta039;
    }

    public String getTa040() {
        return ta040;
    }

    public void setTa040(String ta040) {
        this.ta040 = ta040;
    }

    public String getTa041() {
        return ta041;
    }

    public void setTa041(String ta041) {
        this.ta041 = ta041;
    }

    public String getTa042() {
        return ta042;
    }

    public void setTa042(String ta042) {
        this.ta042 = ta042;
    }

    public String getTa200() {
        return ta200;
    }

    public void setTa200(String ta200) {
        this.ta200 = ta200;
    }

    public String getTa201() {
        return ta201;
    }

    public void setTa201(String ta201) {
        this.ta201 = ta201;
    }

    public String getTa202() {
        return ta202;
    }

    public void setTa202(String ta202) {
        this.ta202 = ta202;
    }

    public String getTa043() {
        return ta043;
    }

    public void setTa043(String ta043) {
        this.ta043 = ta043;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wARTAPK != null ? wARTAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARTA)) {
            return false;
        }
        WARTA other = (WARTA) object;
        if ((this.wARTAPK == null && other.wARTAPK != null) || (this.wARTAPK != null && !this.wARTAPK.equals(other.wARTAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARTA[ wARTAPK=" + wARTAPK + " ]";
    }

}
