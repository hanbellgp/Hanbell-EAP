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
@Table(name = "PORMZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pormz.findAll", query = "SELECT p FROM Pormz p"),
    @NamedQuery(name = "Pormz.findByCompany", query = "SELECT p FROM Pormz p WHERE p.company = :company"),
    @NamedQuery(name = "Pormz.findByCreator", query = "SELECT p FROM Pormz p WHERE p.creator = :creator"),
    @NamedQuery(name = "Pormz.findByUsrGroup", query = "SELECT p FROM Pormz p WHERE p.usrGroup = :usrGroup"),
    @NamedQuery(name = "Pormz.findByCreateDate", query = "SELECT p FROM Pormz p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Pormz.findByModifier", query = "SELECT p FROM Pormz p WHERE p.modifier = :modifier"),
    @NamedQuery(name = "Pormz.findByModiDate", query = "SELECT p FROM Pormz p WHERE p.modiDate = :modiDate"),
    @NamedQuery(name = "Pormz.findByFlag", query = "SELECT p FROM Pormz p WHERE p.flag = :flag"),
    @NamedQuery(name = "Pormz.findByPormz01", query = "SELECT p FROM Pormz p WHERE p.pormz01 = :pormz01"),
    @NamedQuery(name = "Pormz.findByPormz02", query = "SELECT p FROM Pormz p WHERE p.pormz02 = :pormz02"),
    @NamedQuery(name = "Pormz.findByPormz03", query = "SELECT p FROM Pormz p WHERE p.pormz03 = :pormz03"),
    @NamedQuery(name = "Pormz.findByPormz04", query = "SELECT p FROM Pormz p WHERE p.pormz04 = :pormz04"),
    @NamedQuery(name = "Pormz.findByPormz05", query = "SELECT p FROM Pormz p WHERE p.pormz05 = :pormz05"),
    @NamedQuery(name = "Pormz.findByPormz06", query = "SELECT p FROM Pormz p WHERE p.pormz06 = :pormz06"),
    @NamedQuery(name = "Pormz.findByPormz07", query = "SELECT p FROM Pormz p WHERE p.pormz07 = :pormz07"),
    @NamedQuery(name = "Pormz.findByPormz08", query = "SELECT p FROM Pormz p WHERE p.pormz08 = :pormz08"),
    @NamedQuery(name = "Pormz.findByPormz09", query = "SELECT p FROM Pormz p WHERE p.pormz09 = :pormz09"),
    @NamedQuery(name = "Pormz.findByPormz10", query = "SELECT p FROM Pormz p WHERE p.pormz10 = :pormz10"),
    @NamedQuery(name = "Pormz.findByPormz11", query = "SELECT p FROM Pormz p WHERE p.pormz11 = :pormz11"),
    @NamedQuery(name = "Pormz.findByPormz12", query = "SELECT p FROM Pormz p WHERE p.pormz12 = :pormz12"),
    @NamedQuery(name = "Pormz.findByPormz13", query = "SELECT p FROM Pormz p WHERE p.pormz13 = :pormz13"),
    @NamedQuery(name = "Pormz.findByPormz14", query = "SELECT p FROM Pormz p WHERE p.pormz14 = :pormz14"),
    @NamedQuery(name = "Pormz.findByPormz15", query = "SELECT p FROM Pormz p WHERE p.pormz15 = :pormz15"),
    @NamedQuery(name = "Pormz.findByPormz16", query = "SELECT p FROM Pormz p WHERE p.pormz16 = :pormz16"),
    @NamedQuery(name = "Pormz.findByPormz17", query = "SELECT p FROM Pormz p WHERE p.pormz17 = :pormz17"),
    @NamedQuery(name = "Pormz.findByPormz18", query = "SELECT p FROM Pormz p WHERE p.pormz18 = :pormz18"),
    @NamedQuery(name = "Pormz.findByPormz19", query = "SELECT p FROM Pormz p WHERE p.pormz19 = :pormz19"),
    @NamedQuery(name = "Pormz.findByPormz20", query = "SELECT p FROM Pormz p WHERE p.pormz20 = :pormz20"),
    @NamedQuery(name = "Pormz.findByCustomer", query = "SELECT p FROM Pormz p WHERE p.customer = :customer"),
    @NamedQuery(name = "Pormz.findByProduct", query = "SELECT p FROM Pormz p WHERE p.product = :product"),
    @NamedQuery(name = "Pormz.findByRegion", query = "SELECT p FROM Pormz p WHERE p.region = :region"),
    @NamedQuery(name = "Pormz.findByDealer", query = "SELECT p FROM Pormz p WHERE p.dealer = :dealer"),
    @NamedQuery(name = "Pormz.findByMz001", query = "SELECT p FROM Pormz p WHERE p.pormzPK.mz001 = :mz001"),
    @NamedQuery(name = "Pormz.findByMz002", query = "SELECT p FROM Pormz p WHERE p.pormzPK.mz002 = :mz002"),
    @NamedQuery(name = "Pormz.findByMz003", query = "SELECT p FROM Pormz p WHERE p.pormzPK.mz003 = :mz003"),
    @NamedQuery(name = "Pormz.findByMz004", query = "SELECT p FROM Pormz p WHERE p.mz004 = :mz004"),
    @NamedQuery(name = "Pormz.findByMz005", query = "SELECT p FROM Pormz p WHERE p.mz005 = :mz005"),
    @NamedQuery(name = "Pormz.findByMz006", query = "SELECT p FROM Pormz p WHERE p.mz006 = :mz006"),
    @NamedQuery(name = "Pormz.findByMz007", query = "SELECT p FROM Pormz p WHERE p.mz007 = :mz007"),
    @NamedQuery(name = "Pormz.findByMz008", query = "SELECT p FROM Pormz p WHERE p.mz008 = :mz008"),
    @NamedQuery(name = "Pormz.findByMz009", query = "SELECT p FROM Pormz p WHERE p.mz009 = :mz009"),
    @NamedQuery(name = "Pormz.findByMz010", query = "SELECT p FROM Pormz p WHERE p.mz010 = :mz010"),
    @NamedQuery(name = "Pormz.findByMz011", query = "SELECT p FROM Pormz p WHERE p.mz011 = :mz011"),
    @NamedQuery(name = "Pormz.findByMz012", query = "SELECT p FROM Pormz p WHERE p.mz012 = :mz012"),
    @NamedQuery(name = "Pormz.findByMz013", query = "SELECT p FROM Pormz p WHERE p.mz013 = :mz013"),
    @NamedQuery(name = "Pormz.findByMz014", query = "SELECT p FROM Pormz p WHERE p.mz014 = :mz014"),
    @NamedQuery(name = "Pormz.findByMz015", query = "SELECT p FROM Pormz p WHERE p.mz015 = :mz015"),
    @NamedQuery(name = "Pormz.findByMz016", query = "SELECT p FROM Pormz p WHERE p.mz016 = :mz016"),
    @NamedQuery(name = "Pormz.findByMz017", query = "SELECT p FROM Pormz p WHERE p.mz017 = :mz017"),
    @NamedQuery(name = "Pormz.findByMz018", query = "SELECT p FROM Pormz p WHERE p.mz018 = :mz018"),
    @NamedQuery(name = "Pormz.findByMz019", query = "SELECT p FROM Pormz p WHERE p.mz019 = :mz019"),
    @NamedQuery(name = "Pormz.findByMz020", query = "SELECT p FROM Pormz p WHERE p.mz020 = :mz020"),
    @NamedQuery(name = "Pormz.findByMz021", query = "SELECT p FROM Pormz p WHERE p.mz021 = :mz021"),
    @NamedQuery(name = "Pormz.findByMz022", query = "SELECT p FROM Pormz p WHERE p.mz022 = :mz022"),
    @NamedQuery(name = "Pormz.findByMz023", query = "SELECT p FROM Pormz p WHERE p.mz023 = :mz023"),
    @NamedQuery(name = "Pormz.findByMz024", query = "SELECT p FROM Pormz p WHERE p.mz024 = :mz024"),
    @NamedQuery(name = "Pormz.findByMz025", query = "SELECT p FROM Pormz p WHERE p.mz025 = :mz025"),
    @NamedQuery(name = "Pormz.findByMz026", query = "SELECT p FROM Pormz p WHERE p.mz026 = :mz026"),
    @NamedQuery(name = "Pormz.findByMz027", query = "SELECT p FROM Pormz p WHERE p.mz027 = :mz027"),
    @NamedQuery(name = "Pormz.findByMz028", query = "SELECT p FROM Pormz p WHERE p.mz028 = :mz028"),
    @NamedQuery(name = "Pormz.findByMz029", query = "SELECT p FROM Pormz p WHERE p.mz029 = :mz029"),
    @NamedQuery(name = "Pormz.findByMz030", query = "SELECT p FROM Pormz p WHERE p.mz030 = :mz030"),
    @NamedQuery(name = "Pormz.findByMz031", query = "SELECT p FROM Pormz p WHERE p.mz031 = :mz031"),
    @NamedQuery(name = "Pormz.findByMz032", query = "SELECT p FROM Pormz p WHERE p.mz032 = :mz032"),
    @NamedQuery(name = "Pormz.findByMz033", query = "SELECT p FROM Pormz p WHERE p.mz033 = :mz033"),
    @NamedQuery(name = "Pormz.findByMz034", query = "SELECT p FROM Pormz p WHERE p.mz034 = :mz034"),
    @NamedQuery(name = "Pormz.findByMz035", query = "SELECT p FROM Pormz p WHERE p.mz035 = :mz035"),
    @NamedQuery(name = "Pormz.findByMz036", query = "SELECT p FROM Pormz p WHERE p.mz036 = :mz036"),
    @NamedQuery(name = "Pormz.findByMz037", query = "SELECT p FROM Pormz p WHERE p.mz037 = :mz037")})
public class Pormz implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PormzPK pormzPK;
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
    @Size(max = 255)
    @Column(name = "PORMZ01")
    private String pormz01;
    @Size(max = 255)
    @Column(name = "PORMZ02")
    private String pormz02;
    @Size(max = 255)
    @Column(name = "PORMZ03")
    private String pormz03;
    @Size(max = 255)
    @Column(name = "PORMZ04")
    private String pormz04;
    @Size(max = 255)
    @Column(name = "PORMZ05")
    private String pormz05;
    @Size(max = 255)
    @Column(name = "PORMZ06")
    private String pormz06;
    @Size(max = 255)
    @Column(name = "PORMZ07")
    private String pormz07;
    @Size(max = 255)
    @Column(name = "PORMZ08")
    private String pormz08;
    @Size(max = 255)
    @Column(name = "PORMZ09")
    private String pormz09;
    @Size(max = 255)
    @Column(name = "PORMZ10")
    private String pormz10;
    @Size(max = 255)
    @Column(name = "PORMZ11")
    private String pormz11;
    @Size(max = 255)
    @Column(name = "PORMZ12")
    private String pormz12;
    @Size(max = 255)
    @Column(name = "PORMZ13")
    private String pormz13;
    @Size(max = 255)
    @Column(name = "PORMZ14")
    private String pormz14;
    @Size(max = 255)
    @Column(name = "PORMZ15")
    private String pormz15;
    @Size(max = 255)
    @Column(name = "PORMZ16")
    private String pormz16;
    @Size(max = 255)
    @Column(name = "PORMZ17")
    private String pormz17;
    @Size(max = 255)
    @Column(name = "PORMZ18")
    private String pormz18;
    @Size(max = 255)
    @Column(name = "PORMZ19")
    private String pormz19;
    @Size(max = 255)
    @Column(name = "PORMZ20")
    private String pormz20;
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
    @Column(name = "MZ004")
    private String mz004;
    @Size(max = 4)
    @Column(name = "MZ005")
    private String mz005;
    @Size(max = 15)
    @Column(name = "MZ006")
    private String mz006;
    @Size(max = 10)
    @Column(name = "MZ007")
    private String mz007;
    @Size(max = 8)
    @Column(name = "MZ008")
    private String mz008;
    @Size(max = 6)
    @Column(name = "MZ009")
    private String mz009;
    @Size(max = 6)
    @Column(name = "MZ010")
    private String mz010;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MZ011")
    private BigDecimal mz011;
    @Size(max = 4)
    @Column(name = "MZ012")
    private String mz012;
    @Size(max = 1)
    @Column(name = "MZ013")
    private String mz013;
    @Size(max = 1)
    @Column(name = "MZ014")
    private String mz014;
    @Column(name = "MZ015")
    private BigDecimal mz015;
    @Column(name = "MZ016")
    private BigDecimal mz016;
    @Column(name = "MZ017")
    private BigDecimal mz017;
    @Column(name = "MZ018")
    private BigDecimal mz018;
    @Column(name = "MZ019")
    private BigDecimal mz019;
    @Size(max = 255)
    @Column(name = "MZ020")
    private String mz020;
    @Size(max = 20)
    @Column(name = "MZ021")
    private String mz021;
    @Size(max = 1)
    @Column(name = "MZ022")
    private String mz022;
    @Size(max = 1)
    @Column(name = "MZ023")
    private String mz023;
    @Size(max = 1)
    @Column(name = "MZ024")
    private String mz024;
    @Size(max = 10)
    @Column(name = "MZ025")
    private String mz025;
    @Size(max = 30)
    @Column(name = "MZ026")
    private String mz026;
    @Size(max = 30)
    @Column(name = "MZ027")
    private String mz027;
    @Size(max = 50)
    @Column(name = "MZ028")
    private String mz028;
    @Size(max = 50)
    @Column(name = "MZ029")
    private String mz029;
    @Size(max = 255)
    @Column(name = "MZ030")
    private String mz030;
    @Size(max = 255)
    @Column(name = "MZ031")
    private String mz031;
    @Size(max = 255)
    @Column(name = "MZ032")
    private String mz032;
    @Column(name = "MZ033")
    private BigDecimal mz033;
    @Column(name = "MZ034")
    private BigDecimal mz034;
    @Size(max = 4)
    @Column(name = "MZ035")
    private String mz035;
    @Size(max = 11)
    @Column(name = "MZ036")
    private String mz036;
    @Size(max = 2)
    @Column(name = "MZ037")
    private String mz037;

    public Pormz() {
    }

    public Pormz(PormzPK pormzPK) {
        this.pormzPK = pormzPK;
    }

    public Pormz(String mz001, String mz002, String mz003) {
        this.pormzPK = new PormzPK(mz001, mz002, mz003);
    }

    public PormzPK getPormzPK() {
        return pormzPK;
    }

    public void setPormzPK(PormzPK pormzPK) {
        this.pormzPK = pormzPK;
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

    public String getPormz01() {
        return pormz01;
    }

    public void setPormz01(String pormz01) {
        this.pormz01 = pormz01;
    }

    public String getPormz02() {
        return pormz02;
    }

    public void setPormz02(String pormz02) {
        this.pormz02 = pormz02;
    }

    public String getPormz03() {
        return pormz03;
    }

    public void setPormz03(String pormz03) {
        this.pormz03 = pormz03;
    }

    public String getPormz04() {
        return pormz04;
    }

    public void setPormz04(String pormz04) {
        this.pormz04 = pormz04;
    }

    public String getPormz05() {
        return pormz05;
    }

    public void setPormz05(String pormz05) {
        this.pormz05 = pormz05;
    }

    public String getPormz06() {
        return pormz06;
    }

    public void setPormz06(String pormz06) {
        this.pormz06 = pormz06;
    }

    public String getPormz07() {
        return pormz07;
    }

    public void setPormz07(String pormz07) {
        this.pormz07 = pormz07;
    }

    public String getPormz08() {
        return pormz08;
    }

    public void setPormz08(String pormz08) {
        this.pormz08 = pormz08;
    }

    public String getPormz09() {
        return pormz09;
    }

    public void setPormz09(String pormz09) {
        this.pormz09 = pormz09;
    }

    public String getPormz10() {
        return pormz10;
    }

    public void setPormz10(String pormz10) {
        this.pormz10 = pormz10;
    }

    public String getPormz11() {
        return pormz11;
    }

    public void setPormz11(String pormz11) {
        this.pormz11 = pormz11;
    }

    public String getPormz12() {
        return pormz12;
    }

    public void setPormz12(String pormz12) {
        this.pormz12 = pormz12;
    }

    public String getPormz13() {
        return pormz13;
    }

    public void setPormz13(String pormz13) {
        this.pormz13 = pormz13;
    }

    public String getPormz14() {
        return pormz14;
    }

    public void setPormz14(String pormz14) {
        this.pormz14 = pormz14;
    }

    public String getPormz15() {
        return pormz15;
    }

    public void setPormz15(String pormz15) {
        this.pormz15 = pormz15;
    }

    public String getPormz16() {
        return pormz16;
    }

    public void setPormz16(String pormz16) {
        this.pormz16 = pormz16;
    }

    public String getPormz17() {
        return pormz17;
    }

    public void setPormz17(String pormz17) {
        this.pormz17 = pormz17;
    }

    public String getPormz18() {
        return pormz18;
    }

    public void setPormz18(String pormz18) {
        this.pormz18 = pormz18;
    }

    public String getPormz19() {
        return pormz19;
    }

    public void setPormz19(String pormz19) {
        this.pormz19 = pormz19;
    }

    public String getPormz20() {
        return pormz20;
    }

    public void setPormz20(String pormz20) {
        this.pormz20 = pormz20;
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

    public String getMz004() {
        return mz004;
    }

    public void setMz004(String mz004) {
        this.mz004 = mz004;
    }

    public String getMz005() {
        return mz005;
    }

    public void setMz005(String mz005) {
        this.mz005 = mz005;
    }

    public String getMz006() {
        return mz006;
    }

    public void setMz006(String mz006) {
        this.mz006 = mz006;
    }

    public String getMz007() {
        return mz007;
    }

    public void setMz007(String mz007) {
        this.mz007 = mz007;
    }

    public String getMz008() {
        return mz008;
    }

    public void setMz008(String mz008) {
        this.mz008 = mz008;
    }

    public String getMz009() {
        return mz009;
    }

    public void setMz009(String mz009) {
        this.mz009 = mz009;
    }

    public String getMz010() {
        return mz010;
    }

    public void setMz010(String mz010) {
        this.mz010 = mz010;
    }

    public BigDecimal getMz011() {
        return mz011;
    }

    public void setMz011(BigDecimal mz011) {
        this.mz011 = mz011;
    }

    public String getMz012() {
        return mz012;
    }

    public void setMz012(String mz012) {
        this.mz012 = mz012;
    }

    public String getMz013() {
        return mz013;
    }

    public void setMz013(String mz013) {
        this.mz013 = mz013;
    }

    public String getMz014() {
        return mz014;
    }

    public void setMz014(String mz014) {
        this.mz014 = mz014;
    }

    public BigDecimal getMz015() {
        return mz015;
    }

    public void setMz015(BigDecimal mz015) {
        this.mz015 = mz015;
    }

    public BigDecimal getMz016() {
        return mz016;
    }

    public void setMz016(BigDecimal mz016) {
        this.mz016 = mz016;
    }

    public BigDecimal getMz017() {
        return mz017;
    }

    public void setMz017(BigDecimal mz017) {
        this.mz017 = mz017;
    }

    public BigDecimal getMz018() {
        return mz018;
    }

    public void setMz018(BigDecimal mz018) {
        this.mz018 = mz018;
    }

    public BigDecimal getMz019() {
        return mz019;
    }

    public void setMz019(BigDecimal mz019) {
        this.mz019 = mz019;
    }

    public String getMz020() {
        return mz020;
    }

    public void setMz020(String mz020) {
        this.mz020 = mz020;
    }

    public String getMz021() {
        return mz021;
    }

    public void setMz021(String mz021) {
        this.mz021 = mz021;
    }

    public String getMz022() {
        return mz022;
    }

    public void setMz022(String mz022) {
        this.mz022 = mz022;
    }

    public String getMz023() {
        return mz023;
    }

    public void setMz023(String mz023) {
        this.mz023 = mz023;
    }

    public String getMz024() {
        return mz024;
    }

    public void setMz024(String mz024) {
        this.mz024 = mz024;
    }

    public String getMz025() {
        return mz025;
    }

    public void setMz025(String mz025) {
        this.mz025 = mz025;
    }

    public String getMz026() {
        return mz026;
    }

    public void setMz026(String mz026) {
        this.mz026 = mz026;
    }

    public String getMz027() {
        return mz027;
    }

    public void setMz027(String mz027) {
        this.mz027 = mz027;
    }

    public String getMz028() {
        return mz028;
    }

    public void setMz028(String mz028) {
        this.mz028 = mz028;
    }

    public String getMz029() {
        return mz029;
    }

    public void setMz029(String mz029) {
        this.mz029 = mz029;
    }

    public String getMz030() {
        return mz030;
    }

    public void setMz030(String mz030) {
        this.mz030 = mz030;
    }

    public String getMz031() {
        return mz031;
    }

    public void setMz031(String mz031) {
        this.mz031 = mz031;
    }

    public String getMz032() {
        return mz032;
    }

    public void setMz032(String mz032) {
        this.mz032 = mz032;
    }

    public BigDecimal getMz033() {
        return mz033;
    }

    public void setMz033(BigDecimal mz033) {
        this.mz033 = mz033;
    }

    public BigDecimal getMz034() {
        return mz034;
    }

    public void setMz034(BigDecimal mz034) {
        this.mz034 = mz034;
    }

    public String getMz035() {
        return mz035;
    }

    public void setMz035(String mz035) {
        this.mz035 = mz035;
    }

    public String getMz036() {
        return mz036;
    }

    public void setMz036(String mz036) {
        this.mz036 = mz036;
    }

    public String getMz037() {
        return mz037;
    }

    public void setMz037(String mz037) {
        this.mz037 = mz037;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pormzPK != null ? pormzPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pormz)) {
            return false;
        }
        Pormz other = (Pormz) object;
        if ((this.pormzPK == null && other.pormzPK != null) || (this.pormzPK != null && !this.pormzPK.equals(other.pormzPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.Pormz[ pormzPK=" + pormzPK + " ]";
    }
    
}
