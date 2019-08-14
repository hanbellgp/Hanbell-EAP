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
import javax.persistence.Lob;
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
@Table(name = "CRMGD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRMGD.findAll", query = "SELECT c FROM CRMGD c"),
    @NamedQuery(name = "CRMGD.findByCompany", query = "SELECT c FROM CRMGD c WHERE c.company = :company"),
    @NamedQuery(name = "CRMGD.findByCreator", query = "SELECT c FROM CRMGD c WHERE c.creator = :creator"),
    @NamedQuery(name = "CRMGD.findByUsrGroup", query = "SELECT c FROM CRMGD c WHERE c.usrGroup = :usrGroup"),
    @NamedQuery(name = "CRMGD.findByCreateDate", query = "SELECT c FROM CRMGD c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CRMGD.findByModifier", query = "SELECT c FROM CRMGD c WHERE c.modifier = :modifier"),
    @NamedQuery(name = "CRMGD.findByModiDate", query = "SELECT c FROM CRMGD c WHERE c.modiDate = :modiDate"),
    @NamedQuery(name = "CRMGD.findByFlag", query = "SELECT c FROM CRMGD c WHERE c.flag = :flag"),
    @NamedQuery(name = "CRMGD.findByGd001", query = "SELECT c FROM CRMGD c WHERE c.gd001 = :gd001"),
    @NamedQuery(name = "CRMGD.findByGd002", query = "SELECT c FROM CRMGD c WHERE c.gd002 = :gd002"),
    @NamedQuery(name = "CRMGD.findByGd003", query = "SELECT c FROM CRMGD c WHERE c.gd003 = :gd003"),
    @NamedQuery(name = "CRMGD.findByGd004", query = "SELECT c FROM CRMGD c WHERE c.gd004 = :gd004"),
    @NamedQuery(name = "CRMGD.findByGd005", query = "SELECT c FROM CRMGD c WHERE c.gd005 = :gd005"),
    @NamedQuery(name = "CRMGD.findByGd006", query = "SELECT c FROM CRMGD c WHERE c.gd006 = :gd006"),
    @NamedQuery(name = "CRMGD.findByGd007", query = "SELECT c FROM CRMGD c WHERE c.gd007 = :gd007"),
    @NamedQuery(name = "CRMGD.findByGd008", query = "SELECT c FROM CRMGD c WHERE c.gd008 = :gd008"),
    @NamedQuery(name = "CRMGD.findByGd009", query = "SELECT c FROM CRMGD c WHERE c.gd009 = :gd009"),
    @NamedQuery(name = "CRMGD.findByGd010", query = "SELECT c FROM CRMGD c WHERE c.gd010 = :gd010"),
    @NamedQuery(name = "CRMGD.findByGd011", query = "SELECT c FROM CRMGD c WHERE c.gd011 = :gd011"),
    @NamedQuery(name = "CRMGD.findByGd012", query = "SELECT c FROM CRMGD c WHERE c.gd012 = :gd012"),
    @NamedQuery(name = "CRMGD.findByGd013", query = "SELECT c FROM CRMGD c WHERE c.gd013 = :gd013"),
    @NamedQuery(name = "CRMGD.findByGd014", query = "SELECT c FROM CRMGD c WHERE c.gd014 = :gd014"),
    @NamedQuery(name = "CRMGD.findByGd015", query = "SELECT c FROM CRMGD c WHERE c.gd015 = :gd015"),
    @NamedQuery(name = "CRMGD.findByGd016", query = "SELECT c FROM CRMGD c WHERE c.gd016 = :gd016"),
    @NamedQuery(name = "CRMGD.findByGd017", query = "SELECT c FROM CRMGD c WHERE c.gd017 = :gd017"),
    @NamedQuery(name = "CRMGD.findByGd018", query = "SELECT c FROM CRMGD c WHERE c.gd018 = :gd018"),
    @NamedQuery(name = "CRMGD.findByGd019", query = "SELECT c FROM CRMGD c WHERE c.gd019 = :gd019"),
    @NamedQuery(name = "CRMGD.findByGd020", query = "SELECT c FROM CRMGD c WHERE c.gd020 = :gd020"),
    @NamedQuery(name = "CRMGD.findByGd021", query = "SELECT c FROM CRMGD c WHERE c.gd021 = :gd021"),
    @NamedQuery(name = "CRMGD.findByGd022", query = "SELECT c FROM CRMGD c WHERE c.gd022 = :gd022"),
    @NamedQuery(name = "CRMGD.findByGd023", query = "SELECT c FROM CRMGD c WHERE c.gd023 = :gd023"),
    @NamedQuery(name = "CRMGD.findByGd024", query = "SELECT c FROM CRMGD c WHERE c.gd024 = :gd024"),
    @NamedQuery(name = "CRMGD.findByGd025", query = "SELECT c FROM CRMGD c WHERE c.gd025 = :gd025"),
    @NamedQuery(name = "CRMGD.findByGd026", query = "SELECT c FROM CRMGD c WHERE c.gd026 = :gd026"),
    @NamedQuery(name = "CRMGD.findByGd027", query = "SELECT c FROM CRMGD c WHERE c.gd027 = :gd027"),
    @NamedQuery(name = "CRMGD.findByGd028", query = "SELECT c FROM CRMGD c WHERE c.gd028 = :gd028"),
    @NamedQuery(name = "CRMGD.findByGd029", query = "SELECT c FROM CRMGD c WHERE c.gd029 = :gd029"),
    @NamedQuery(name = "CRMGD.findByGd030", query = "SELECT c FROM CRMGD c WHERE c.gd030 = :gd030"),
    @NamedQuery(name = "CRMGD.findByGd031", query = "SELECT c FROM CRMGD c WHERE c.gd031 = :gd031"),
    @NamedQuery(name = "CRMGD.findByGd032", query = "SELECT c FROM CRMGD c WHERE c.gd032 = :gd032"),
    @NamedQuery(name = "CRMGD.findByGd033", query = "SELECT c FROM CRMGD c WHERE c.gd033 = :gd033"),
    @NamedQuery(name = "CRMGD.findByGd034", query = "SELECT c FROM CRMGD c WHERE c.gd034 = :gd034"),
    @NamedQuery(name = "CRMGD.findByGd035", query = "SELECT c FROM CRMGD c WHERE c.gd035 = :gd035"),
    @NamedQuery(name = "CRMGD.findByGd036", query = "SELECT c FROM CRMGD c WHERE c.gd036 = :gd036"),
    @NamedQuery(name = "CRMGD.findByGd037", query = "SELECT c FROM CRMGD c WHERE c.gd037 = :gd037"),
    @NamedQuery(name = "CRMGD.findByGd038", query = "SELECT c FROM CRMGD c WHERE c.gd038 = :gd038"),
    @NamedQuery(name = "CRMGD.findByGd040", query = "SELECT c FROM CRMGD c WHERE c.gd040 = :gd040"),
    @NamedQuery(name = "CRMGD.findByCustomer", query = "SELECT c FROM CRMGD c WHERE c.customer = :customer"),
    @NamedQuery(name = "CRMGD.findByProduct", query = "SELECT c FROM CRMGD c WHERE c.product = :product"),
    @NamedQuery(name = "CRMGD.findByRegion", query = "SELECT c FROM CRMGD c WHERE c.region = :region"),
    @NamedQuery(name = "CRMGD.findByDealer", query = "SELECT c FROM CRMGD c WHERE c.dealer = :dealer"),
    @NamedQuery(name = "CRMGD.findByGd041", query = "SELECT c FROM CRMGD c WHERE c.gd041 = :gd041"),
    @NamedQuery(name = "CRMGD.findByGd042", query = "SELECT c FROM CRMGD c WHERE c.gd042 = :gd042"),
    @NamedQuery(name = "CRMGD.findByGd197", query = "SELECT c FROM CRMGD c WHERE c.gd197 = :gd197"),
    @NamedQuery(name = "CRMGD.findByGd198", query = "SELECT c FROM CRMGD c WHERE c.gd198 = :gd198"),
    @NamedQuery(name = "CRMGD.findByGd199", query = "SELECT c FROM CRMGD c WHERE c.gd199 = :gd199"),
    @NamedQuery(name = "CRMGD.findByGd043", query = "SELECT c FROM CRMGD c WHERE c.gd043 = :gd043"),
    @NamedQuery(name = "CRMGD.findByCrmgd01", query = "SELECT c FROM CRMGD c WHERE c.crmgd01 = :crmgd01"),
    @NamedQuery(name = "CRMGD.findByCrmgd02", query = "SELECT c FROM CRMGD c WHERE c.crmgd02 = :crmgd02"),
    @NamedQuery(name = "CRMGD.findByCrmgd03", query = "SELECT c FROM CRMGD c WHERE c.crmgd03 = :crmgd03"),
    @NamedQuery(name = "CRMGD.findByCrmgd04", query = "SELECT c FROM CRMGD c WHERE c.crmgd04 = :crmgd04"),
    @NamedQuery(name = "CRMGD.findByCrmgd05", query = "SELECT c FROM CRMGD c WHERE c.crmgd05 = :crmgd05"),
    @NamedQuery(name = "CRMGD.findByCrmgd06", query = "SELECT c FROM CRMGD c WHERE c.crmgd06 = :crmgd06"),
    @NamedQuery(name = "CRMGD.findByCrmgd07", query = "SELECT c FROM CRMGD c WHERE c.crmgd07 = :crmgd07"),
    @NamedQuery(name = "CRMGD.findByCrmgd08", query = "SELECT c FROM CRMGD c WHERE c.crmgd08 = :crmgd08"),
    @NamedQuery(name = "CRMGD.findByCrmgd09", query = "SELECT c FROM CRMGD c WHERE c.crmgd09 = :crmgd09"),
    @NamedQuery(name = "CRMGD.findByCrmgd10", query = "SELECT c FROM CRMGD c WHERE c.crmgd10 = :crmgd10"),
    @NamedQuery(name = "CRMGD.findByCrmgd11", query = "SELECT c FROM CRMGD c WHERE c.crmgd11 = :crmgd11"),
    @NamedQuery(name = "CRMGD.findByCrmgd12", query = "SELECT c FROM CRMGD c WHERE c.crmgd12 = :crmgd12"),
    @NamedQuery(name = "CRMGD.findByCrmgd13", query = "SELECT c FROM CRMGD c WHERE c.crmgd13 = :crmgd13"),
    @NamedQuery(name = "CRMGD.findByCrmgd14", query = "SELECT c FROM CRMGD c WHERE c.crmgd14 = :crmgd14"),
    @NamedQuery(name = "CRMGD.findByCrmgd15", query = "SELECT c FROM CRMGD c WHERE c.crmgd15 = :crmgd15"),
    @NamedQuery(name = "CRMGD.findByCrmgd16", query = "SELECT c FROM CRMGD c WHERE c.crmgd16 = :crmgd16"),
    @NamedQuery(name = "CRMGD.findByCrmgd17", query = "SELECT c FROM CRMGD c WHERE c.crmgd17 = :crmgd17"),
    @NamedQuery(name = "CRMGD.findByCrmgd18", query = "SELECT c FROM CRMGD c WHERE c.crmgd18 = :crmgd18"),
    @NamedQuery(name = "CRMGD.findByCrmgd19", query = "SELECT c FROM CRMGD c WHERE c.crmgd19 = :crmgd19"),
    @NamedQuery(name = "CRMGD.findByCrmgd20", query = "SELECT c FROM CRMGD c WHERE c.crmgd20 = :crmgd20"),
    @NamedQuery(name = "CRMGD.findByGd044", query = "SELECT c FROM CRMGD c WHERE c.gd044 = :gd044"),
    @NamedQuery(name = "CRMGD.findByGd045", query = "SELECT c FROM CRMGD c WHERE c.gd045 = :gd045"),
    @NamedQuery(name = "CRMGD.findByGd046", query = "SELECT c FROM CRMGD c WHERE c.gd046 = :gd046"),
    @NamedQuery(name = "CRMGD.findByGd047", query = "SELECT c FROM CRMGD c WHERE c.gd047 = :gd047"),
    @NamedQuery(name = "CRMGD.findByGd048", query = "SELECT c FROM CRMGD c WHERE c.gd048 = :gd048"),
    @NamedQuery(name = "CRMGD.findByGd049", query = "SELECT c FROM CRMGD c WHERE c.gd049 = :gd049"),
    @NamedQuery(name = "CRMGD.findByGd050", query = "SELECT c FROM CRMGD c WHERE c.gd050 = :gd050"),
    @NamedQuery(name = "CRMGD.findByGd051", query = "SELECT c FROM CRMGD c WHERE c.gd051 = :gd051"),
    @NamedQuery(name = "CRMGD.findByGd052", query = "SELECT c FROM CRMGD c WHERE c.gd052 = :gd052"),
    @NamedQuery(name = "CRMGD.findByGd053", query = "SELECT c FROM CRMGD c WHERE c.gd053 = :gd053")})
public class CRMGD implements Serializable {

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
    @Size(min = 1, max = 20)
    @Column(name = "GD001")
    private String gd001;
    @Size(max = 10)
    @Column(name = "GD002")
    private String gd002;
    @Size(max = 6)
    @Column(name = "GD003")
    private String gd003;
    @Size(max = 100)
    @Column(name = "GD004")
    private String gd004;
    @Size(max = 50)
    @Column(name = "GD005")
    private String gd005;
    @Size(max = 50)
    @Column(name = "GD006")
    private String gd006;
    @Size(max = 20)
    @Column(name = "GD007")
    private String gd007;
    @Size(max = 255)
    @Column(name = "GD008")
    private String gd008;
    @Size(max = 100)
    @Column(name = "GD009")
    private String gd009;
    @Size(max = 10)
    @Column(name = "GD010")
    private String gd010;
    @Size(max = 10)
    @Column(name = "GD011")
    private String gd011;
    @Size(max = 20)
    @Column(name = "GD012")
    private String gd012;
    @Size(max = 10)
    @Column(name = "GD013")
    private String gd013;
    @Size(max = 20)
    @Column(name = "GD014")
    private String gd014;
    @Size(max = 4)
    @Column(name = "GD015")
    private String gd015;
    @Size(max = 1)
    @Column(name = "GD016")
    private String gd016;
    @Size(max = 1)
    @Column(name = "GD017")
    private String gd017;
    @Size(max = 1)
    @Column(name = "GD018")
    private String gd018;
    @Size(max = 4000)
    @Column(name = "GD019")
    private String gd019;
    @Size(max = 10)
    @Column(name = "GD020")
    private String gd020;
    @Size(max = 1)
    @Column(name = "GD021")
    private String gd021;
    @Size(max = 100)
    @Column(name = "GD022")
    private String gd022;
    @Size(max = 6)
    @Column(name = "GD023")
    private String gd023;
    @Size(max = 6)
    @Column(name = "GD024")
    private String gd024;
    @Size(max = 5)
    @Column(name = "GD025")
    private String gd025;
    @Size(max = 10)
    @Column(name = "GD026")
    private String gd026;
    @Size(max = 5)
    @Column(name = "GD027")
    private String gd027;
    @Size(max = 5)
    @Column(name = "GD028")
    private String gd028;
    @Size(max = 255)
    @Column(name = "GD029")
    private String gd029;
    @Size(max = 1)
    @Column(name = "GD030")
    private String gd030;
    @Size(max = 30)
    @Column(name = "GD031")
    private String gd031;
    @Size(max = 10)
    @Column(name = "GD032")
    private String gd032;
    @Size(max = 2147483647)
    @Column(name = "GD033")
    private String gd033;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GD034")
    private BigDecimal gd034;
    @Column(name = "GD035")
    private BigDecimal gd035;
    @Size(max = 1)
    @Column(name = "GD036")
    private String gd036;
    @Size(max = 30)
    @Column(name = "GD037")
    private String gd037;
    @Size(max = 60)
    @Column(name = "GD038")
    private String gd038;
    @Lob
    @Column(name = "GD039")
    private byte[] gd039;
    @Size(max = 10)
    @Column(name = "GD040")
    private String gd040;
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
    @Column(name = "GD041")
    private String gd041;
    @Column(name = "GD042")
    private Long gd042;
    @Size(max = 10)
    @Column(name = "GD197")
    private String gd197;
    @Size(max = 10)
    @Column(name = "GD198")
    private String gd198;
    @Size(max = 10)
    @Column(name = "GD199")
    private String gd199;
    @Size(max = 200)
    @Column(name = "GD043")
    private String gd043;
    @Size(max = 255)
    @Column(name = "CRMGD01")
    private String crmgd01;
    @Size(max = 255)
    @Column(name = "CRMGD02")
    private String crmgd02;
    @Size(max = 255)
    @Column(name = "CRMGD03")
    private String crmgd03;
    @Size(max = 255)
    @Column(name = "CRMGD04")
    private String crmgd04;
    @Size(max = 255)
    @Column(name = "CRMGD05")
    private String crmgd05;
    @Size(max = 255)
    @Column(name = "CRMGD06")
    private String crmgd06;
    @Size(max = 255)
    @Column(name = "CRMGD07")
    private String crmgd07;
    @Size(max = 255)
    @Column(name = "CRMGD08")
    private String crmgd08;
    @Size(max = 255)
    @Column(name = "CRMGD09")
    private String crmgd09;
    @Size(max = 255)
    @Column(name = "CRMGD10")
    private String crmgd10;
    @Size(max = 255)
    @Column(name = "CRMGD11")
    private String crmgd11;
    @Size(max = 255)
    @Column(name = "CRMGD12")
    private String crmgd12;
    @Size(max = 255)
    @Column(name = "CRMGD13")
    private String crmgd13;
    @Size(max = 255)
    @Column(name = "CRMGD14")
    private String crmgd14;
    @Size(max = 255)
    @Column(name = "CRMGD15")
    private String crmgd15;
    @Size(max = 255)
    @Column(name = "CRMGD16")
    private String crmgd16;
    @Size(max = 255)
    @Column(name = "CRMGD17")
    private String crmgd17;
    @Size(max = 255)
    @Column(name = "CRMGD18")
    private String crmgd18;
    @Size(max = 255)
    @Column(name = "CRMGD19")
    private String crmgd19;
    @Size(max = 255)
    @Column(name = "CRMGD20")
    private String crmgd20;
    @Size(max = 40)
    @Column(name = "GD044")
    private String gd044;
    @Size(max = 40)
    @Column(name = "GD045")
    private String gd045;
    @Size(max = 40)
    @Column(name = "GD046")
    private String gd046;
    @Size(max = 1)
    @Column(name = "GD047")
    private String gd047;
    @Size(max = 10)
    @Column(name = "GD048")
    private String gd048;
    @Size(max = 20)
    @Column(name = "GD049")
    private String gd049;
    @Size(max = 20)
    @Column(name = "GD050")
    private String gd050;
    @Size(max = 20)
    @Column(name = "GD051")
    private String gd051;
    @Size(max = 20)
    @Column(name = "GD052")
    private String gd052;
    @Size(max = 20)
    @Column(name = "GD053")
    private String gd053;

    public CRMGD() {
    }

    public CRMGD(String gd001) {
        this.gd001 = gd001;
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

    public String getGd001() {
        return gd001;
    }

    public void setGd001(String gd001) {
        this.gd001 = gd001;
    }

    public String getGd002() {
        return gd002;
    }

    public void setGd002(String gd002) {
        this.gd002 = gd002;
    }

    public String getGd003() {
        return gd003;
    }

    public void setGd003(String gd003) {
        this.gd003 = gd003;
    }

    public String getGd004() {
        return gd004;
    }

    public void setGd004(String gd004) {
        this.gd004 = gd004;
    }

    public String getGd005() {
        return gd005;
    }

    public void setGd005(String gd005) {
        this.gd005 = gd005;
    }

    public String getGd006() {
        return gd006;
    }

    public void setGd006(String gd006) {
        this.gd006 = gd006;
    }

    public String getGd007() {
        return gd007;
    }

    public void setGd007(String gd007) {
        this.gd007 = gd007;
    }

    public String getGd008() {
        return gd008;
    }

    public void setGd008(String gd008) {
        this.gd008 = gd008;
    }

    public String getGd009() {
        return gd009;
    }

    public void setGd009(String gd009) {
        this.gd009 = gd009;
    }

    public String getGd010() {
        return gd010;
    }

    public void setGd010(String gd010) {
        this.gd010 = gd010;
    }

    public String getGd011() {
        return gd011;
    }

    public void setGd011(String gd011) {
        this.gd011 = gd011;
    }

    public String getGd012() {
        return gd012;
    }

    public void setGd012(String gd012) {
        this.gd012 = gd012;
    }

    public String getGd013() {
        return gd013;
    }

    public void setGd013(String gd013) {
        this.gd013 = gd013;
    }

    public String getGd014() {
        return gd014;
    }

    public void setGd014(String gd014) {
        this.gd014 = gd014;
    }

    public String getGd015() {
        return gd015;
    }

    public void setGd015(String gd015) {
        this.gd015 = gd015;
    }

    public String getGd016() {
        return gd016;
    }

    public void setGd016(String gd016) {
        this.gd016 = gd016;
    }

    public String getGd017() {
        return gd017;
    }

    public void setGd017(String gd017) {
        this.gd017 = gd017;
    }

    public String getGd018() {
        return gd018;
    }

    public void setGd018(String gd018) {
        this.gd018 = gd018;
    }

    public String getGd019() {
        return gd019;
    }

    public void setGd019(String gd019) {
        this.gd019 = gd019;
    }

    public String getGd020() {
        return gd020;
    }

    public void setGd020(String gd020) {
        this.gd020 = gd020;
    }

    public String getGd021() {
        return gd021;
    }

    public void setGd021(String gd021) {
        this.gd021 = gd021;
    }

    public String getGd022() {
        return gd022;
    }

    public void setGd022(String gd022) {
        this.gd022 = gd022;
    }

    public String getGd023() {
        return gd023;
    }

    public void setGd023(String gd023) {
        this.gd023 = gd023;
    }

    public String getGd024() {
        return gd024;
    }

    public void setGd024(String gd024) {
        this.gd024 = gd024;
    }

    public String getGd025() {
        return gd025;
    }

    public void setGd025(String gd025) {
        this.gd025 = gd025;
    }

    public String getGd026() {
        return gd026;
    }

    public void setGd026(String gd026) {
        this.gd026 = gd026;
    }

    public String getGd027() {
        return gd027;
    }

    public void setGd027(String gd027) {
        this.gd027 = gd027;
    }

    public String getGd028() {
        return gd028;
    }

    public void setGd028(String gd028) {
        this.gd028 = gd028;
    }

    public String getGd029() {
        return gd029;
    }

    public void setGd029(String gd029) {
        this.gd029 = gd029;
    }

    public String getGd030() {
        return gd030;
    }

    public void setGd030(String gd030) {
        this.gd030 = gd030;
    }

    public String getGd031() {
        return gd031;
    }

    public void setGd031(String gd031) {
        this.gd031 = gd031;
    }

    public String getGd032() {
        return gd032;
    }

    public void setGd032(String gd032) {
        this.gd032 = gd032;
    }

    public String getGd033() {
        return gd033;
    }

    public void setGd033(String gd033) {
        this.gd033 = gd033;
    }

    public BigDecimal getGd034() {
        return gd034;
    }

    public void setGd034(BigDecimal gd034) {
        this.gd034 = gd034;
    }

    public BigDecimal getGd035() {
        return gd035;
    }

    public void setGd035(BigDecimal gd035) {
        this.gd035 = gd035;
    }

    public String getGd036() {
        return gd036;
    }

    public void setGd036(String gd036) {
        this.gd036 = gd036;
    }

    public String getGd037() {
        return gd037;
    }

    public void setGd037(String gd037) {
        this.gd037 = gd037;
    }

    public String getGd038() {
        return gd038;
    }

    public void setGd038(String gd038) {
        this.gd038 = gd038;
    }

    public byte[] getGd039() {
        return gd039;
    }

    public void setGd039(byte[] gd039) {
        this.gd039 = gd039;
    }

    public String getGd040() {
        return gd040;
    }

    public void setGd040(String gd040) {
        this.gd040 = gd040;
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

    public String getGd041() {
        return gd041;
    }

    public void setGd041(String gd041) {
        this.gd041 = gd041;
    }

    public Long getGd042() {
        return gd042;
    }

    public void setGd042(Long gd042) {
        this.gd042 = gd042;
    }

    public String getGd197() {
        return gd197;
    }

    public void setGd197(String gd197) {
        this.gd197 = gd197;
    }

    public String getGd198() {
        return gd198;
    }

    public void setGd198(String gd198) {
        this.gd198 = gd198;
    }

    public String getGd199() {
        return gd199;
    }

    public void setGd199(String gd199) {
        this.gd199 = gd199;
    }

    public String getGd043() {
        return gd043;
    }

    public void setGd043(String gd043) {
        this.gd043 = gd043;
    }

    public String getCrmgd01() {
        return crmgd01;
    }

    public void setCrmgd01(String crmgd01) {
        this.crmgd01 = crmgd01;
    }

    public String getCrmgd02() {
        return crmgd02;
    }

    public void setCrmgd02(String crmgd02) {
        this.crmgd02 = crmgd02;
    }

    public String getCrmgd03() {
        return crmgd03;
    }

    public void setCrmgd03(String crmgd03) {
        this.crmgd03 = crmgd03;
    }

    public String getCrmgd04() {
        return crmgd04;
    }

    public void setCrmgd04(String crmgd04) {
        this.crmgd04 = crmgd04;
    }

    public String getCrmgd05() {
        return crmgd05;
    }

    public void setCrmgd05(String crmgd05) {
        this.crmgd05 = crmgd05;
    }

    public String getCrmgd06() {
        return crmgd06;
    }

    public void setCrmgd06(String crmgd06) {
        this.crmgd06 = crmgd06;
    }

    public String getCrmgd07() {
        return crmgd07;
    }

    public void setCrmgd07(String crmgd07) {
        this.crmgd07 = crmgd07;
    }

    public String getCrmgd08() {
        return crmgd08;
    }

    public void setCrmgd08(String crmgd08) {
        this.crmgd08 = crmgd08;
    }

    public String getCrmgd09() {
        return crmgd09;
    }

    public void setCrmgd09(String crmgd09) {
        this.crmgd09 = crmgd09;
    }

    public String getCrmgd10() {
        return crmgd10;
    }

    public void setCrmgd10(String crmgd10) {
        this.crmgd10 = crmgd10;
    }

    public String getCrmgd11() {
        return crmgd11;
    }

    public void setCrmgd11(String crmgd11) {
        this.crmgd11 = crmgd11;
    }

    public String getCrmgd12() {
        return crmgd12;
    }

    public void setCrmgd12(String crmgd12) {
        this.crmgd12 = crmgd12;
    }

    public String getCrmgd13() {
        return crmgd13;
    }

    public void setCrmgd13(String crmgd13) {
        this.crmgd13 = crmgd13;
    }

    public String getCrmgd14() {
        return crmgd14;
    }

    public void setCrmgd14(String crmgd14) {
        this.crmgd14 = crmgd14;
    }

    public String getCrmgd15() {
        return crmgd15;
    }

    public void setCrmgd15(String crmgd15) {
        this.crmgd15 = crmgd15;
    }

    public String getCrmgd16() {
        return crmgd16;
    }

    public void setCrmgd16(String crmgd16) {
        this.crmgd16 = crmgd16;
    }

    public String getCrmgd17() {
        return crmgd17;
    }

    public void setCrmgd17(String crmgd17) {
        this.crmgd17 = crmgd17;
    }

    public String getCrmgd18() {
        return crmgd18;
    }

    public void setCrmgd18(String crmgd18) {
        this.crmgd18 = crmgd18;
    }

    public String getCrmgd19() {
        return crmgd19;
    }

    public void setCrmgd19(String crmgd19) {
        this.crmgd19 = crmgd19;
    }

    public String getCrmgd20() {
        return crmgd20;
    }

    public void setCrmgd20(String crmgd20) {
        this.crmgd20 = crmgd20;
    }

    public String getGd044() {
        return gd044;
    }

    public void setGd044(String gd044) {
        this.gd044 = gd044;
    }

    public String getGd045() {
        return gd045;
    }

    public void setGd045(String gd045) {
        this.gd045 = gd045;
    }

    public String getGd046() {
        return gd046;
    }

    public void setGd046(String gd046) {
        this.gd046 = gd046;
    }

    public String getGd047() {
        return gd047;
    }

    public void setGd047(String gd047) {
        this.gd047 = gd047;
    }

    public String getGd048() {
        return gd048;
    }

    public void setGd048(String gd048) {
        this.gd048 = gd048;
    }

    public String getGd049() {
        return gd049;
    }

    public void setGd049(String gd049) {
        this.gd049 = gd049;
    }

    public String getGd050() {
        return gd050;
    }

    public void setGd050(String gd050) {
        this.gd050 = gd050;
    }

    public String getGd051() {
        return gd051;
    }

    public void setGd051(String gd051) {
        this.gd051 = gd051;
    }

    public String getGd052() {
        return gd052;
    }

    public void setGd052(String gd052) {
        this.gd052 = gd052;
    }

    public String getGd053() {
        return gd053;
    }

    public void setGd053(String gd053) {
        this.gd053 = gd053;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gd001 != null ? gd001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRMGD)) {
            return false;
        }
        CRMGD other = (CRMGD) object;
        if ((this.gd001 == null && other.gd001 != null) || (this.gd001 != null && !this.gd001.equals(other.gd001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CRMGD[ gd001=" + gd001 + " ]";
    }

}
