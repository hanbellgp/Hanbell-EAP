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
@Table(name = "WARTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARTB.findAll", query = "SELECT w FROM WARTB w"),
    @NamedQuery(name = "WARTB.findByCompany", query = "SELECT w FROM WARTB w WHERE w.company = :company"),
    @NamedQuery(name = "WARTB.findByCreator", query = "SELECT w FROM WARTB w WHERE w.creator = :creator"),
    @NamedQuery(name = "WARTB.findByUsrGroup", query = "SELECT w FROM WARTB w WHERE w.usrGroup = :usrGroup"),
    @NamedQuery(name = "WARTB.findByCreateDate", query = "SELECT w FROM WARTB w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WARTB.findByModifier", query = "SELECT w FROM WARTB w WHERE w.modifier = :modifier"),
    @NamedQuery(name = "WARTB.findByModiDate", query = "SELECT w FROM WARTB w WHERE w.modiDate = :modiDate"),
    @NamedQuery(name = "WARTB.findByFlag", query = "SELECT w FROM WARTB w WHERE w.flag = :flag"),
    @NamedQuery(name = "WARTB.findByPK", query = "SELECT w FROM WARTB w WHERE w.wARTBPK.tb001 = :tb001 and w.wARTBPK.tb002 = :tb002 and w.wARTBPK.tb003 = :tb003"),
    @NamedQuery(name = "WARTB.findByTb002", query = "SELECT w FROM WARTB w WHERE w.wARTBPK.tb002 = :tb002"),
    @NamedQuery(name = "WARTB.findByTb003", query = "SELECT w FROM WARTB w WHERE w.wARTBPK.tb003 = :tb003"),
    @NamedQuery(name = "WARTB.findByTb004", query = "SELECT w FROM WARTB w WHERE w.tb004 = :tb004"),
    @NamedQuery(name = "WARTB.findByTb005", query = "SELECT w FROM WARTB w WHERE w.tb005 = :tb005"),
    @NamedQuery(name = "WARTB.findByTb006", query = "SELECT w FROM WARTB w WHERE w.tb006 = :tb006"),
    @NamedQuery(name = "WARTB.findByTb007", query = "SELECT w FROM WARTB w WHERE w.tb007 = :tb007"),
    @NamedQuery(name = "WARTB.findByTb008", query = "SELECT w FROM WARTB w WHERE w.tb008 = :tb008"),
    @NamedQuery(name = "WARTB.findByTb009", query = "SELECT w FROM WARTB w WHERE w.tb009 = :tb009"),
    @NamedQuery(name = "WARTB.findByTb010", query = "SELECT w FROM WARTB w WHERE w.tb010 = :tb010"),
    @NamedQuery(name = "WARTB.findByTb011", query = "SELECT w FROM WARTB w WHERE w.tb011 = :tb011"),
    @NamedQuery(name = "WARTB.findByTb012", query = "SELECT w FROM WARTB w WHERE w.tb012 = :tb012"),
    @NamedQuery(name = "WARTB.findByTb013", query = "SELECT w FROM WARTB w WHERE w.tb013 = :tb013"),
    @NamedQuery(name = "WARTB.findByTb014", query = "SELECT w FROM WARTB w WHERE w.tb014 = :tb014"),
    @NamedQuery(name = "WARTB.findByTb015", query = "SELECT w FROM WARTB w WHERE w.tb015 = :tb015"),
    @NamedQuery(name = "WARTB.findByTb016", query = "SELECT w FROM WARTB w WHERE w.tb016 = :tb016"),
    @NamedQuery(name = "WARTB.findByTb017", query = "SELECT w FROM WARTB w WHERE w.tb017 = :tb017"),
    @NamedQuery(name = "WARTB.findByTb018", query = "SELECT w FROM WARTB w WHERE w.tb018 = :tb018"),
    @NamedQuery(name = "WARTB.findByTb019", query = "SELECT w FROM WARTB w WHERE w.tb019 = :tb019"),
    @NamedQuery(name = "WARTB.findByTb020", query = "SELECT w FROM WARTB w WHERE w.tb020 = :tb020"),
    @NamedQuery(name = "WARTB.findByTb021", query = "SELECT w FROM WARTB w WHERE w.tb021 = :tb021"),
    @NamedQuery(name = "WARTB.findByTb022", query = "SELECT w FROM WARTB w WHERE w.tb022 = :tb022"),
    @NamedQuery(name = "WARTB.findByTb023", query = "SELECT w FROM WARTB w WHERE w.tb023 = :tb023"),
    @NamedQuery(name = "WARTB.findByTb024", query = "SELECT w FROM WARTB w WHERE w.tb024 = :tb024"),
    @NamedQuery(name = "WARTB.findByTb025", query = "SELECT w FROM WARTB w WHERE w.tb025 = :tb025"),
    @NamedQuery(name = "WARTB.findByTb026", query = "SELECT w FROM WARTB w WHERE w.tb026 = :tb026"),
    @NamedQuery(name = "WARTB.findByTb027", query = "SELECT w FROM WARTB w WHERE w.tb027 = :tb027"),
    @NamedQuery(name = "WARTB.findByTb028", query = "SELECT w FROM WARTB w WHERE w.tb028 = :tb028"),
    @NamedQuery(name = "WARTB.findByTb029", query = "SELECT w FROM WARTB w WHERE w.tb029 = :tb029"),
    @NamedQuery(name = "WARTB.findByTb030", query = "SELECT w FROM WARTB w WHERE w.tb030 = :tb030"),
    @NamedQuery(name = "WARTB.findByTb031", query = "SELECT w FROM WARTB w WHERE w.tb031 = :tb031"),
    @NamedQuery(name = "WARTB.findByTb032", query = "SELECT w FROM WARTB w WHERE w.tb032 = :tb032"),
    @NamedQuery(name = "WARTB.findByTb033", query = "SELECT w FROM WARTB w WHERE w.tb033 = :tb033"),
    @NamedQuery(name = "WARTB.findByTb034", query = "SELECT w FROM WARTB w WHERE w.tb034 = :tb034"),
    @NamedQuery(name = "WARTB.findByTb035", query = "SELECT w FROM WARTB w WHERE w.tb035 = :tb035"),
    @NamedQuery(name = "WARTB.findByTb036", query = "SELECT w FROM WARTB w WHERE w.tb036 = :tb036"),
    @NamedQuery(name = "WARTB.findByTb037", query = "SELECT w FROM WARTB w WHERE w.tb037 = :tb037"),
    @NamedQuery(name = "WARTB.findByTb038", query = "SELECT w FROM WARTB w WHERE w.tb038 = :tb038"),
    @NamedQuery(name = "WARTB.findByTb039", query = "SELECT w FROM WARTB w WHERE w.tb039 = :tb039"),
    @NamedQuery(name = "WARTB.findByTb040", query = "SELECT w FROM WARTB w WHERE w.tb040 = :tb040"),
    @NamedQuery(name = "WARTB.findByTb041", query = "SELECT w FROM WARTB w WHERE w.tb041 = :tb041"),
    @NamedQuery(name = "WARTB.findByCustomer", query = "SELECT w FROM WARTB w WHERE w.customer = :customer"),
    @NamedQuery(name = "WARTB.findByProduct", query = "SELECT w FROM WARTB w WHERE w.product = :product"),
    @NamedQuery(name = "WARTB.findByRegion", query = "SELECT w FROM WARTB w WHERE w.region = :region"),
    @NamedQuery(name = "WARTB.findByDealer", query = "SELECT w FROM WARTB w WHERE w.dealer = :dealer"),
    @NamedQuery(name = "WARTB.findByTa042", query = "SELECT w FROM WARTB w WHERE w.ta042 = :ta042"),
    @NamedQuery(name = "WARTB.findByTa043", query = "SELECT w FROM WARTB w WHERE w.ta043 = :ta043"),
    @NamedQuery(name = "WARTB.findByTb042", query = "SELECT w FROM WARTB w WHERE w.tb042 = :tb042"),
    @NamedQuery(name = "WARTB.findByTb043", query = "SELECT w FROM WARTB w WHERE w.tb043 = :tb043"),
    @NamedQuery(name = "WARTB.findByWartb01", query = "SELECT w FROM WARTB w WHERE w.wartb01 = :wartb01"),
    @NamedQuery(name = "WARTB.findByWartb02", query = "SELECT w FROM WARTB w WHERE w.wartb02 = :wartb02"),
    @NamedQuery(name = "WARTB.findByWartb03", query = "SELECT w FROM WARTB w WHERE w.wartb03 = :wartb03"),
    @NamedQuery(name = "WARTB.findByWartb04", query = "SELECT w FROM WARTB w WHERE w.wartb04 = :wartb04"),
    @NamedQuery(name = "WARTB.findByWartb05", query = "SELECT w FROM WARTB w WHERE w.wartb05 = :wartb05"),
    @NamedQuery(name = "WARTB.findByWartb06", query = "SELECT w FROM WARTB w WHERE w.wartb06 = :wartb06"),
    @NamedQuery(name = "WARTB.findByWartb07", query = "SELECT w FROM WARTB w WHERE w.wartb07 = :wartb07"),
    @NamedQuery(name = "WARTB.findByWartb08", query = "SELECT w FROM WARTB w WHERE w.wartb08 = :wartb08"),
    @NamedQuery(name = "WARTB.findByWartb09", query = "SELECT w FROM WARTB w WHERE w.wartb09 = :wartb09"),
    @NamedQuery(name = "WARTB.findByWartb10", query = "SELECT w FROM WARTB w WHERE w.wartb10 = :wartb10"),
    @NamedQuery(name = "WARTB.findByWartb11", query = "SELECT w FROM WARTB w WHERE w.wartb11 = :wartb11"),
    @NamedQuery(name = "WARTB.findByWartb12", query = "SELECT w FROM WARTB w WHERE w.wartb12 = :wartb12"),
    @NamedQuery(name = "WARTB.findByWartb13", query = "SELECT w FROM WARTB w WHERE w.wartb13 = :wartb13"),
    @NamedQuery(name = "WARTB.findByWartb14", query = "SELECT w FROM WARTB w WHERE w.wartb14 = :wartb14"),
    @NamedQuery(name = "WARTB.findByWartb15", query = "SELECT w FROM WARTB w WHERE w.wartb15 = :wartb15"),
    @NamedQuery(name = "WARTB.findByWartb16", query = "SELECT w FROM WARTB w WHERE w.wartb16 = :wartb16"),
    @NamedQuery(name = "WARTB.findByWartb17", query = "SELECT w FROM WARTB w WHERE w.wartb17 = :wartb17"),
    @NamedQuery(name = "WARTB.findByWartb18", query = "SELECT w FROM WARTB w WHERE w.wartb18 = :wartb18"),
    @NamedQuery(name = "WARTB.findByWartb19", query = "SELECT w FROM WARTB w WHERE w.wartb19 = :wartb19"),
    @NamedQuery(name = "WARTB.findByWartb20", query = "SELECT w FROM WARTB w WHERE w.wartb20 = :wartb20")})
public class WARTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WARTBPK wARTBPK;
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
    @Column(name = "TB004")
    private String tb004;
    @Size(max = 120)
    @Column(name = "TB005")
    private String tb005;
    @Size(max = 120)
    @Column(name = "TB006")
    private String tb006;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TB007")
    private BigDecimal tb007;
    @Size(max = 6)
    @Column(name = "TB008")
    private String tb008;
    @Column(name = "TB009")
    private BigDecimal tb009;
    @Size(max = 10)
    @Column(name = "TB010")
    private String tb010;
    @Size(max = 20)
    @Column(name = "TB011")
    private String tb011;
    @Size(max = 255)
    @Column(name = "TB012")
    private String tb012;
    @Size(max = 1)
    @Column(name = "TB013")
    private String tb013;
    @Size(max = 8)
    @Column(name = "TB014")
    private String tb014;
    @Size(max = 4)
    @Column(name = "TB015")
    private String tb015;
    @Size(max = 11)
    @Column(name = "TB016")
    private String tb016;
    @Size(max = 4)
    @Column(name = "TB017")
    private String tb017;
    @Column(name = "TB018")
    private BigDecimal tb018;
    @Size(max = 30)
    @Column(name = "TB019")
    private String tb019;
    @Size(max = 1)
    @Column(name = "TB020")
    private String tb020;
    @Size(max = 8)
    @Column(name = "TB021")
    private String tb021;
    @Size(max = 8)
    @Column(name = "TB022")
    private String tb022;
    @Size(max = 4)
    @Column(name = "TB023")
    private String tb023;
    @Size(max = 11)
    @Column(name = "TB024")
    private String tb024;
    @Size(max = 4)
    @Column(name = "TB025")
    private String tb025;
    @Size(max = 1)
    @Column(name = "TB026")
    private String tb026;
    @Size(max = 1)
    @Column(name = "TB027")
    private String tb027;
    @Size(max = 6)
    @Column(name = "TB028")
    private String tb028;
    @Column(name = "TB029")
    private BigDecimal tb029;
    @Size(max = 6)
    @Column(name = "TB030")
    private String tb030;
    @Column(name = "TB031")
    private BigDecimal tb031;
    @Column(name = "TB032")
    private BigDecimal tb032;
    @Column(name = "TB033")
    private BigDecimal tb033;
    @Size(max = 1)
    @Column(name = "TB034")
    private String tb034;
    @Size(max = 30)
    @Column(name = "TB035")
    private String tb035;
    @Size(max = 60)
    @Column(name = "TB036")
    private String tb036;
    @Size(max = 120)
    @Column(name = "TB037")
    private String tb037;
    @Size(max = 120)
    @Column(name = "TB038")
    private String tb038;
    @Size(max = 120)
    @Column(name = "TB039")
    private String tb039;
    @Size(max = 10)
    @Column(name = "TB040")
    private String tb040;
    @Size(max = 80)
    @Column(name = "TB041")
    private String tb041;
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
    @Column(name = "TA042")
    private String ta042;
    @Size(max = 20)
    @Column(name = "TA043")
    private String ta043;
    @Size(max = 1)
    @Column(name = "TB042")
    private String tb042;
    @Size(max = 20)
    @Column(name = "TB043")
    private String tb043;
    @Size(max = 255)
    @Column(name = "WARTB01")
    private String wartb01;
    @Size(max = 255)
    @Column(name = "WARTB02")
    private String wartb02;
    @Size(max = 255)
    @Column(name = "WARTB03")
    private String wartb03;
    @Size(max = 255)
    @Column(name = "WARTB04")
    private String wartb04;
    @Size(max = 255)
    @Column(name = "WARTB05")
    private String wartb05;
    @Size(max = 255)
    @Column(name = "WARTB06")
    private String wartb06;
    @Size(max = 255)
    @Column(name = "WARTB07")
    private String wartb07;
    @Size(max = 255)
    @Column(name = "WARTB08")
    private String wartb08;
    @Size(max = 255)
    @Column(name = "WARTB09")
    private String wartb09;
    @Size(max = 255)
    @Column(name = "WARTB10")
    private String wartb10;
    @Size(max = 255)
    @Column(name = "WARTB11")
    private String wartb11;
    @Size(max = 255)
    @Column(name = "WARTB12")
    private String wartb12;
    @Size(max = 255)
    @Column(name = "WARTB13")
    private String wartb13;
    @Size(max = 255)
    @Column(name = "WARTB14")
    private String wartb14;
    @Size(max = 255)
    @Column(name = "WARTB15")
    private String wartb15;
    @Size(max = 255)
    @Column(name = "WARTB16")
    private String wartb16;
    @Size(max = 255)
    @Column(name = "WARTB17")
    private String wartb17;
    @Size(max = 255)
    @Column(name = "WARTB18")
    private String wartb18;
    @Size(max = 255)
    @Column(name = "WARTB19")
    private String wartb19;
    @Size(max = 255)
    @Column(name = "WARTB20")
    private String wartb20;

    public WARTB() {
    }

    public WARTB(WARTBPK wARTBPK) {
        this.wARTBPK = wARTBPK;
    }

    public WARTB(String tb001, String tb002, String tb003) {
        this.wARTBPK = new WARTBPK(tb001, tb002, tb003);
    }

    public WARTBPK getWARTBPK() {
        return wARTBPK;
    }

    public void setWARTBPK(WARTBPK wARTBPK) {
        this.wARTBPK = wARTBPK;
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

    public String getTb004() {
        return tb004;
    }

    public void setTb004(String tb004) {
        this.tb004 = tb004;
    }

    public String getTb005() {
        return tb005;
    }

    public void setTb005(String tb005) {
        this.tb005 = tb005;
    }

    public String getTb006() {
        return tb006;
    }

    public void setTb006(String tb006) {
        this.tb006 = tb006;
    }

    public BigDecimal getTb007() {
        return tb007;
    }

    public void setTb007(BigDecimal tb007) {
        this.tb007 = tb007;
    }

    public String getTb008() {
        return tb008;
    }

    public void setTb008(String tb008) {
        this.tb008 = tb008;
    }

    public BigDecimal getTb009() {
        return tb009;
    }

    public void setTb009(BigDecimal tb009) {
        this.tb009 = tb009;
    }

    public String getTb010() {
        return tb010;
    }

    public void setTb010(String tb010) {
        this.tb010 = tb010;
    }

    public String getTb011() {
        return tb011;
    }

    public void setTb011(String tb011) {
        this.tb011 = tb011;
    }

    public String getTb012() {
        return tb012;
    }

    public void setTb012(String tb012) {
        this.tb012 = tb012;
    }

    public String getTb013() {
        return tb013;
    }

    public void setTb013(String tb013) {
        this.tb013 = tb013;
    }

    public String getTb014() {
        return tb014;
    }

    public void setTb014(String tb014) {
        this.tb014 = tb014;
    }

    public String getTb015() {
        return tb015;
    }

    public void setTb015(String tb015) {
        this.tb015 = tb015;
    }

    public String getTb016() {
        return tb016;
    }

    public void setTb016(String tb016) {
        this.tb016 = tb016;
    }

    public String getTb017() {
        return tb017;
    }

    public void setTb017(String tb017) {
        this.tb017 = tb017;
    }

    public BigDecimal getTb018() {
        return tb018;
    }

    public void setTb018(BigDecimal tb018) {
        this.tb018 = tb018;
    }

    public String getTb019() {
        return tb019;
    }

    public void setTb019(String tb019) {
        this.tb019 = tb019;
    }

    public String getTb020() {
        return tb020;
    }

    public void setTb020(String tb020) {
        this.tb020 = tb020;
    }

    public String getTb021() {
        return tb021;
    }

    public void setTb021(String tb021) {
        this.tb021 = tb021;
    }

    public String getTb022() {
        return tb022;
    }

    public void setTb022(String tb022) {
        this.tb022 = tb022;
    }

    public String getTb023() {
        return tb023;
    }

    public void setTb023(String tb023) {
        this.tb023 = tb023;
    }

    public String getTb024() {
        return tb024;
    }

    public void setTb024(String tb024) {
        this.tb024 = tb024;
    }

    public String getTb025() {
        return tb025;
    }

    public void setTb025(String tb025) {
        this.tb025 = tb025;
    }

    public String getTb026() {
        return tb026;
    }

    public void setTb026(String tb026) {
        this.tb026 = tb026;
    }

    public String getTb027() {
        return tb027;
    }

    public void setTb027(String tb027) {
        this.tb027 = tb027;
    }

    public String getTb028() {
        return tb028;
    }

    public void setTb028(String tb028) {
        this.tb028 = tb028;
    }

    public BigDecimal getTb029() {
        return tb029;
    }

    public void setTb029(BigDecimal tb029) {
        this.tb029 = tb029;
    }

    public String getTb030() {
        return tb030;
    }

    public void setTb030(String tb030) {
        this.tb030 = tb030;
    }

    public BigDecimal getTb031() {
        return tb031;
    }

    public void setTb031(BigDecimal tb031) {
        this.tb031 = tb031;
    }

    public BigDecimal getTb032() {
        return tb032;
    }

    public void setTb032(BigDecimal tb032) {
        this.tb032 = tb032;
    }

    public BigDecimal getTb033() {
        return tb033;
    }

    public void setTb033(BigDecimal tb033) {
        this.tb033 = tb033;
    }

    public String getTb034() {
        return tb034;
    }

    public void setTb034(String tb034) {
        this.tb034 = tb034;
    }

    public String getTb035() {
        return tb035;
    }

    public void setTb035(String tb035) {
        this.tb035 = tb035;
    }

    public String getTb036() {
        return tb036;
    }

    public void setTb036(String tb036) {
        this.tb036 = tb036;
    }

    public String getTb037() {
        return tb037;
    }

    public void setTb037(String tb037) {
        this.tb037 = tb037;
    }

    public String getTb038() {
        return tb038;
    }

    public void setTb038(String tb038) {
        this.tb038 = tb038;
    }

    public String getTb039() {
        return tb039;
    }

    public void setTb039(String tb039) {
        this.tb039 = tb039;
    }

    public String getTb040() {
        return tb040;
    }

    public void setTb040(String tb040) {
        this.tb040 = tb040;
    }

    public String getTb041() {
        return tb041;
    }

    public void setTb041(String tb041) {
        this.tb041 = tb041;
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

    public String getTa042() {
        return ta042;
    }

    public void setTa042(String ta042) {
        this.ta042 = ta042;
    }

    public String getTa043() {
        return ta043;
    }

    public void setTa043(String ta043) {
        this.ta043 = ta043;
    }

    public String getTb042() {
        return tb042;
    }

    public void setTb042(String tb042) {
        this.tb042 = tb042;
    }

    public String getTb043() {
        return tb043;
    }

    public void setTb043(String tb043) {
        this.tb043 = tb043;
    }

    public String getWartb01() {
        return wartb01;
    }

    public void setWartb01(String wartb01) {
        this.wartb01 = wartb01;
    }

    public String getWartb02() {
        return wartb02;
    }

    public void setWartb02(String wartb02) {
        this.wartb02 = wartb02;
    }

    public String getWartb03() {
        return wartb03;
    }

    public void setWartb03(String wartb03) {
        this.wartb03 = wartb03;
    }

    public String getWartb04() {
        return wartb04;
    }

    public void setWartb04(String wartb04) {
        this.wartb04 = wartb04;
    }

    public String getWartb05() {
        return wartb05;
    }

    public void setWartb05(String wartb05) {
        this.wartb05 = wartb05;
    }

    public String getWartb06() {
        return wartb06;
    }

    public void setWartb06(String wartb06) {
        this.wartb06 = wartb06;
    }

    public String getWartb07() {
        return wartb07;
    }

    public void setWartb07(String wartb07) {
        this.wartb07 = wartb07;
    }

    public String getWartb08() {
        return wartb08;
    }

    public void setWartb08(String wartb08) {
        this.wartb08 = wartb08;
    }

    public String getWartb09() {
        return wartb09;
    }

    public void setWartb09(String wartb09) {
        this.wartb09 = wartb09;
    }

    public String getWartb10() {
        return wartb10;
    }

    public void setWartb10(String wartb10) {
        this.wartb10 = wartb10;
    }

    public String getWartb11() {
        return wartb11;
    }

    public void setWartb11(String wartb11) {
        this.wartb11 = wartb11;
    }

    public String getWartb12() {
        return wartb12;
    }

    public void setWartb12(String wartb12) {
        this.wartb12 = wartb12;
    }

    public String getWartb13() {
        return wartb13;
    }

    public void setWartb13(String wartb13) {
        this.wartb13 = wartb13;
    }

    public String getWartb14() {
        return wartb14;
    }

    public void setWartb14(String wartb14) {
        this.wartb14 = wartb14;
    }

    public String getWartb15() {
        return wartb15;
    }

    public void setWartb15(String wartb15) {
        this.wartb15 = wartb15;
    }

    public String getWartb16() {
        return wartb16;
    }

    public void setWartb16(String wartb16) {
        this.wartb16 = wartb16;
    }

    public String getWartb17() {
        return wartb17;
    }

    public void setWartb17(String wartb17) {
        this.wartb17 = wartb17;
    }

    public String getWartb18() {
        return wartb18;
    }

    public void setWartb18(String wartb18) {
        this.wartb18 = wartb18;
    }

    public String getWartb19() {
        return wartb19;
    }

    public void setWartb19(String wartb19) {
        this.wartb19 = wartb19;
    }

    public String getWartb20() {
        return wartb20;
    }

    public void setWartb20(String wartb20) {
        this.wartb20 = wartb20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wARTBPK != null ? wARTBPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARTB)) {
            return false;
        }
        WARTB other = (WARTB) object;
        if ((this.wARTBPK == null && other.wARTBPK != null) || (this.wARTBPK != null && !this.wARTBPK.equals(other.wARTBPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARTB[ wARTBPK=" + wARTBPK + " ]";
    }
    
}
