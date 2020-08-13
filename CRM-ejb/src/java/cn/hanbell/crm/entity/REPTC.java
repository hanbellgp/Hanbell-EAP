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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "REPTC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPTC.findAll", query = "SELECT r FROM REPTC r"),
    @NamedQuery(name = "REPTC.findByCompany", query = "SELECT r FROM REPTC r WHERE r.company = :company"),
    @NamedQuery(name = "REPTC.findByCreator", query = "SELECT r FROM REPTC r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPTC.findByUsrGroup", query = "SELECT r FROM REPTC r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPTC.findByCreateDate", query = "SELECT r FROM REPTC r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPTC.findByModifier", query = "SELECT r FROM REPTC r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPTC.findByModiDate", query = "SELECT r FROM REPTC r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPTC.findByFlag", query = "SELECT r FROM REPTC r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPTC.findByTc001", query = "SELECT r FROM REPTC r WHERE r.reptcPK.tc001 = :tc001"),
    @NamedQuery(name = "REPTC.findByTc002", query = "SELECT r FROM REPTC r WHERE r.reptcPK.tc002 = :tc002"),
    @NamedQuery(name = "REPTC.findByPK", query = "SELECT r FROM REPTC r WHERE r.reptcPK.tc001 = :tc001 AND r.reptcPK.tc002 = :tc002"),
    @NamedQuery(name = "REPTC.findByTc003", query = "SELECT r FROM REPTC r WHERE r.tc003 = :tc003"),
    @NamedQuery(name = "REPTC.findByTc004", query = "SELECT r FROM REPTC r WHERE r.tc004 = :tc004"),
    @NamedQuery(name = "REPTC.findByTc005", query = "SELECT r FROM REPTC r WHERE r.tc005 = :tc005"),
    @NamedQuery(name = "REPTC.findByTc006", query = "SELECT r FROM REPTC r WHERE r.tc006 = :tc006"),
    @NamedQuery(name = "REPTC.findByTc007", query = "SELECT r FROM REPTC r WHERE r.tc007 = :tc007"),
    @NamedQuery(name = "REPTC.findByTc008", query = "SELECT r FROM REPTC r WHERE r.tc008 = :tc008"),
    @NamedQuery(name = "REPTC.findByTc009", query = "SELECT r FROM REPTC r WHERE r.tc009 = :tc009"),
    @NamedQuery(name = "REPTC.findByTc010", query = "SELECT r FROM REPTC r WHERE r.tc010 = :tc010"),
    @NamedQuery(name = "REPTC.findByTc011", query = "SELECT r FROM REPTC r WHERE r.tc011 = :tc011"),
    @NamedQuery(name = "REPTC.findByTc012", query = "SELECT r FROM REPTC r WHERE r.tc012 = :tc012"),
    @NamedQuery(name = "REPTC.findByTc013", query = "SELECT r FROM REPTC r WHERE r.tc013 = :tc013"),
    @NamedQuery(name = "REPTC.findByTc014", query = "SELECT r FROM REPTC r WHERE r.tc014 = :tc014"),
    @NamedQuery(name = "REPTC.findByTc015", query = "SELECT r FROM REPTC r WHERE r.tc015 = :tc015"),
    @NamedQuery(name = "REPTC.findByTc016", query = "SELECT r FROM REPTC r WHERE r.tc016 = :tc016"),
    @NamedQuery(name = "REPTC.findByTc017", query = "SELECT r FROM REPTC r WHERE r.tc017 = :tc017"),
    @NamedQuery(name = "REPTC.findByTc018", query = "SELECT r FROM REPTC r WHERE r.tc018 = :tc018"),
    @NamedQuery(name = "REPTC.findByTc019", query = "SELECT r FROM REPTC r WHERE r.tc019 = :tc019"),
    @NamedQuery(name = "REPTC.findByTc020", query = "SELECT r FROM REPTC r WHERE r.tc020 = :tc020"),
    @NamedQuery(name = "REPTC.findByTc021", query = "SELECT r FROM REPTC r WHERE r.tc021 = :tc021"),
    @NamedQuery(name = "REPTC.findByTc022", query = "SELECT r FROM REPTC r WHERE r.tc022 = :tc022"),
    @NamedQuery(name = "REPTC.findByTc023", query = "SELECT r FROM REPTC r WHERE r.tc023 = :tc023"),
    @NamedQuery(name = "REPTC.findByTc024", query = "SELECT r FROM REPTC r WHERE r.tc024 = :tc024"),
    @NamedQuery(name = "REPTC.findByTc025", query = "SELECT r FROM REPTC r WHERE r.tc025 = :tc025"),
    @NamedQuery(name = "REPTC.findByTc026", query = "SELECT r FROM REPTC r WHERE r.tc026 = :tc026"),
    @NamedQuery(name = "REPTC.findByTc027", query = "SELECT r FROM REPTC r WHERE r.tc027 = :tc027"),
    @NamedQuery(name = "REPTC.findByTc028", query = "SELECT r FROM REPTC r WHERE r.tc028 = :tc028"),
    @NamedQuery(name = "REPTC.findByTc029", query = "SELECT r FROM REPTC r WHERE r.tc029 = :tc029"),
    @NamedQuery(name = "REPTC.findByTc030", query = "SELECT r FROM REPTC r WHERE r.tc030 = :tc030"),
    @NamedQuery(name = "REPTC.findByTc031", query = "SELECT r FROM REPTC r WHERE r.tc031 = :tc031"),
    @NamedQuery(name = "REPTC.findByTc032", query = "SELECT r FROM REPTC r WHERE r.tc032 = :tc032"),
    @NamedQuery(name = "REPTC.findByTc033", query = "SELECT r FROM REPTC r WHERE r.tc033 = :tc033"),
    @NamedQuery(name = "REPTC.findByTc034", query = "SELECT r FROM REPTC r WHERE r.tc034 = :tc034"),
    @NamedQuery(name = "REPTC.findByTc035", query = "SELECT r FROM REPTC r WHERE r.tc035 = :tc035"),
    @NamedQuery(name = "REPTC.findByTc036", query = "SELECT r FROM REPTC r WHERE r.tc036 = :tc036"),
    @NamedQuery(name = "REPTC.findByTc037", query = "SELECT r FROM REPTC r WHERE r.tc037 = :tc037"),
    @NamedQuery(name = "REPTC.findByTc038", query = "SELECT r FROM REPTC r WHERE r.tc038 = :tc038"),
    @NamedQuery(name = "REPTC.findByTc039", query = "SELECT r FROM REPTC r WHERE r.tc039 = :tc039"),
    @NamedQuery(name = "REPTC.findByTc040", query = "SELECT r FROM REPTC r WHERE r.tc040 = :tc040"),
    @NamedQuery(name = "REPTC.findByTc041", query = "SELECT r FROM REPTC r WHERE r.tc041 = :tc041"),
    @NamedQuery(name = "REPTC.findByTc042", query = "SELECT r FROM REPTC r WHERE r.tc042 = :tc042"),
    @NamedQuery(name = "REPTC.findByTc043", query = "SELECT r FROM REPTC r WHERE r.tc043 = :tc043"),
    @NamedQuery(name = "REPTC.findByTc044", query = "SELECT r FROM REPTC r WHERE r.tc044 = :tc044"),
    @NamedQuery(name = "REPTC.findByTc045", query = "SELECT r FROM REPTC r WHERE r.tc045 = :tc045"),
    @NamedQuery(name = "REPTC.findByTc046", query = "SELECT r FROM REPTC r WHERE r.tc046 = :tc046"),
    @NamedQuery(name = "REPTC.findByTc047", query = "SELECT r FROM REPTC r WHERE r.tc047 = :tc047"),
    @NamedQuery(name = "REPTC.findByTc048", query = "SELECT r FROM REPTC r WHERE r.tc048 = :tc048"),
    @NamedQuery(name = "REPTC.findByTc049", query = "SELECT r FROM REPTC r WHERE r.tc049 = :tc049"),
    @NamedQuery(name = "REPTC.findByTc050", query = "SELECT r FROM REPTC r WHERE r.tc050 = :tc050"),
    @NamedQuery(name = "REPTC.findByTc051", query = "SELECT r FROM REPTC r WHERE r.tc051 = :tc051"),
    @NamedQuery(name = "REPTC.findByTc052", query = "SELECT r FROM REPTC r WHERE r.tc052 = :tc052"),
    @NamedQuery(name = "REPTC.findByTc053", query = "SELECT r FROM REPTC r WHERE r.tc053 = :tc053"),
    @NamedQuery(name = "REPTC.findByTc054", query = "SELECT r FROM REPTC r WHERE r.tc054 = :tc054"),
    @NamedQuery(name = "REPTC.findByTc055", query = "SELECT r FROM REPTC r WHERE r.tc055 = :tc055"),
    @NamedQuery(name = "REPTC.findByTc056", query = "SELECT r FROM REPTC r WHERE r.tc056 = :tc056"),
    @NamedQuery(name = "REPTC.findByTc057", query = "SELECT r FROM REPTC r WHERE r.tc057 = :tc057"),
    @NamedQuery(name = "REPTC.findByTc058", query = "SELECT r FROM REPTC r WHERE r.tc058 = :tc058"),
    @NamedQuery(name = "REPTC.findByTc059", query = "SELECT r FROM REPTC r WHERE r.tc059 = :tc059"),
    @NamedQuery(name = "REPTC.findByTc060", query = "SELECT r FROM REPTC r WHERE r.tc060 = :tc060"),
    @NamedQuery(name = "REPTC.findByTc061", query = "SELECT r FROM REPTC r WHERE r.tc061 = :tc061"),
    @NamedQuery(name = "REPTC.findByTc062", query = "SELECT r FROM REPTC r WHERE r.tc062 = :tc062"),
    @NamedQuery(name = "REPTC.findByTc063", query = "SELECT r FROM REPTC r WHERE r.tc063 = :tc063"),
    @NamedQuery(name = "REPTC.findByTc064", query = "SELECT r FROM REPTC r WHERE r.tc064 = :tc064"),
    @NamedQuery(name = "REPTC.findByTc065", query = "SELECT r FROM REPTC r WHERE r.tc065 = :tc065"),
    @NamedQuery(name = "REPTC.findByTc066", query = "SELECT r FROM REPTC r WHERE r.tc066 = :tc066"),
    @NamedQuery(name = "REPTC.findByTc067", query = "SELECT r FROM REPTC r WHERE r.tc067 = :tc067"),
    @NamedQuery(name = "REPTC.findByTc068", query = "SELECT r FROM REPTC r WHERE r.tc068 = :tc068"),
    @NamedQuery(name = "REPTC.findByTc069", query = "SELECT r FROM REPTC r WHERE r.tc069 = :tc069"),
    @NamedQuery(name = "REPTC.findByTc070", query = "SELECT r FROM REPTC r WHERE r.tc070 = :tc070"),
    @NamedQuery(name = "REPTC.findByTc071", query = "SELECT r FROM REPTC r WHERE r.tc071 = :tc071"),
    @NamedQuery(name = "REPTC.findByTc072", query = "SELECT r FROM REPTC r WHERE r.tc072 = :tc072"),
    @NamedQuery(name = "REPTC.findByTc073", query = "SELECT r FROM REPTC r WHERE r.tc073 = :tc073"),
    @NamedQuery(name = "REPTC.findByTc074", query = "SELECT r FROM REPTC r WHERE r.tc074 = :tc074"),
    @NamedQuery(name = "REPTC.findByTc075", query = "SELECT r FROM REPTC r WHERE r.tc075 = :tc075"),
    @NamedQuery(name = "REPTC.findByTc076", query = "SELECT r FROM REPTC r WHERE r.tc076 = :tc076"),
    @NamedQuery(name = "REPTC.findByTc077", query = "SELECT r FROM REPTC r WHERE r.tc077 = :tc077"),
    @NamedQuery(name = "REPTC.findByTc078", query = "SELECT r FROM REPTC r WHERE r.tc078 = :tc078"),
    @NamedQuery(name = "REPTC.findByTc079", query = "SELECT r FROM REPTC r WHERE r.tc079 = :tc079"),
    @NamedQuery(name = "REPTC.findByTc080", query = "SELECT r FROM REPTC r WHERE r.tc080 = :tc080"),
    @NamedQuery(name = "REPTC.findByTc081", query = "SELECT r FROM REPTC r WHERE r.tc081 = :tc081"),
    @NamedQuery(name = "REPTC.findByTc082", query = "SELECT r FROM REPTC r WHERE r.tc082 = :tc082"),
    @NamedQuery(name = "REPTC.findByTc083", query = "SELECT r FROM REPTC r WHERE r.tc083 = :tc083"),
    @NamedQuery(name = "REPTC.findByTc084", query = "SELECT r FROM REPTC r WHERE r.tc084 = :tc084"),
    @NamedQuery(name = "REPTC.findByTc085", query = "SELECT r FROM REPTC r WHERE r.tc085 = :tc085"),
    @NamedQuery(name = "REPTC.findByTc086", query = "SELECT r FROM REPTC r WHERE r.tc086 = :tc086"),
    @NamedQuery(name = "REPTC.findByTc087", query = "SELECT r FROM REPTC r WHERE r.tc087 = :tc087"),
    @NamedQuery(name = "REPTC.findByTc088", query = "SELECT r FROM REPTC r WHERE r.tc088 = :tc088"),
    @NamedQuery(name = "REPTC.findByTc089", query = "SELECT r FROM REPTC r WHERE r.tc089 = :tc089"),
    @NamedQuery(name = "REPTC.findByCustomer", query = "SELECT r FROM REPTC r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPTC.findByProduct", query = "SELECT r FROM REPTC r WHERE r.product = :product"),
    @NamedQuery(name = "REPTC.findByRegion", query = "SELECT r FROM REPTC r WHERE r.region = :region"),
    @NamedQuery(name = "REPTC.findByDealer", query = "SELECT r FROM REPTC r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPTC.findByTc197", query = "SELECT r FROM REPTC r WHERE r.tc197 = :tc197"),
    @NamedQuery(name = "REPTC.findByTc198", query = "SELECT r FROM REPTC r WHERE r.tc198 = :tc198"),
    @NamedQuery(name = "REPTC.findByTc199", query = "SELECT r FROM REPTC r WHERE r.tc199 = :tc199"),
    @NamedQuery(name = "REPTC.findByREPTC01", query = "SELECT r FROM REPTC r WHERE r.reptc01 = :reptc01"),
    @NamedQuery(name = "REPTC.findByREPTC02", query = "SELECT r FROM REPTC r WHERE r.reptc02 = :reptc02"),
    @NamedQuery(name = "REPTC.findByREPTC03", query = "SELECT r FROM REPTC r WHERE r.reptc03 = :reptc03"),
    @NamedQuery(name = "REPTC.findByREPTC04", query = "SELECT r FROM REPTC r WHERE r.reptc04 = :reptc04"),
    @NamedQuery(name = "REPTC.findByREPTC05", query = "SELECT r FROM REPTC r WHERE r.reptc05 = :reptc05"),
    @NamedQuery(name = "REPTC.findByREPTC06", query = "SELECT r FROM REPTC r WHERE r.reptc06 = :reptc06"),
    @NamedQuery(name = "REPTC.findByREPTC07", query = "SELECT r FROM REPTC r WHERE r.reptc07 = :reptc07"),
    @NamedQuery(name = "REPTC.findByREPTC08", query = "SELECT r FROM REPTC r WHERE r.reptc08 = :reptc08"),
    @NamedQuery(name = "REPTC.findByREPTC09", query = "SELECT r FROM REPTC r WHERE r.reptc09 = :reptc09"),
    @NamedQuery(name = "REPTC.findByREPTC10", query = "SELECT r FROM REPTC r WHERE r.reptc10 = :reptc10"),
    @NamedQuery(name = "REPTC.findByREPTC11", query = "SELECT r FROM REPTC r WHERE r.reptc11 = :reptc11"),
    @NamedQuery(name = "REPTC.findByREPTC12", query = "SELECT r FROM REPTC r WHERE r.reptc12 = :reptc12"),
    @NamedQuery(name = "REPTC.findByREPTC13", query = "SELECT r FROM REPTC r WHERE r.reptc13 = :reptc13"),
    @NamedQuery(name = "REPTC.findByREPTC14", query = "SELECT r FROM REPTC r WHERE r.reptc14 = :reptc14"),
    @NamedQuery(name = "REPTC.findByREPTC15", query = "SELECT r FROM REPTC r WHERE r.reptc15 = :reptc15"),
    @NamedQuery(name = "REPTC.findByREPTC16", query = "SELECT r FROM REPTC r WHERE r.reptc16 = :reptc16"),
    @NamedQuery(name = "REPTC.findByREPTC17", query = "SELECT r FROM REPTC r WHERE r.reptc17 = :reptc17"),
    @NamedQuery(name = "REPTC.findByREPTC18", query = "SELECT r FROM REPTC r WHERE r.reptc18 = :reptc18"),
    @NamedQuery(name = "REPTC.findByREPTC19", query = "SELECT r FROM REPTC r WHERE r.reptc19 = :reptc19"),
    @NamedQuery(name = "REPTC.findByREPTC20", query = "SELECT r FROM REPTC r WHERE r.reptc20 = :reptc20"),
    @NamedQuery(name = "REPTC.findByTc090", query = "SELECT r FROM REPTC r WHERE r.tc090 = :tc090"),
    @NamedQuery(name = "REPTC.findByTc091", query = "SELECT r FROM REPTC r WHERE r.tc091 = :tc091"),
    @NamedQuery(name = "REPTC.findByTc092", query = "SELECT r FROM REPTC r WHERE r.tc092 = :tc092"),
    @NamedQuery(name = "REPTC.findByTc093", query = "SELECT r FROM REPTC r WHERE r.tc093 = :tc093"),
    @NamedQuery(name = "REPTC.findByTc094", query = "SELECT r FROM REPTC r WHERE r.tc094 = :tc094")})
public class REPTC implements Serializable {

    @Size(max = 10)
    @Column(name = "TC500")
    private String tc500;
    @Size(max = 50)
    @Column(name = "TC501")
    private String tc501;
    @Size(max = 50)
    @Column(name = "TC502")
    private String tc502;
    @Size(max = 500)
    @Column(name = "TC503")
    private String tc503;
    @Size(max = 500)
    @Column(name = "TC504")
    private String tc504;
    @Size(max = 500)
    @Column(name = "TC505")
    private String tc505;
    @Size(max = 500)
    @Column(name = "TC506")
    private String tc506;
    @Size(max = 500)
    @Column(name = "TC507")
    private String tc507;
    @Size(max = 500)
    @Column(name = "TC508")
    private String tc508;

    @Column(name = "TC090")
    private BigDecimal tc090;
    @Column(name = "TC091")
    private BigDecimal tc091;
    @Size(max = 1)
    @Column(name = "TC092")
    private String tc092;
    @Size(max = 4)
    @Column(name = "TC093")
    private String tc093;
    @Size(max = 11)
    @Column(name = "TC094")
    private String tc094;
    @Size(max = 4)
    @Column(name = "TC095")
    private String tc095;
    @Size(max = 30)
    @Column(name = "TC096")
    private String tc096;
    @Size(max = 30)
    @Column(name = "TC097")
    private String tc097;
    @Size(max = 4)
    @Column(name = "TC098")
    private String tc098;
    @Size(max = 4)
    @Column(name = "TC099")
    private String tc099;
    // @Size(max = 50)
    // @Column(name = "TC100")
    // private String tc100;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPTCPK reptcPK;
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
    @Column(name = "TC003")
    private String tc003;
    @Size(max = 8)
    @Column(name = "TC004")
    private String tc004;
    @Size(max = 4)
    @Column(name = "TC005")
    private String tc005;
    @Size(max = 11)
    @Column(name = "TC006")
    private String tc006;
    @Size(max = 10)
    @Column(name = "TC007")
    private String tc007;
    @Size(max = 120)
    @Column(name = "TC008")
    private String tc008;
    @Size(max = 120)
    @Column(name = "TC009")
    private String tc009;
    @Size(max = 120)
    @Column(name = "TC010")
    private String tc010;
    @Size(max = 10)
    @Column(name = "TC011")
    private String tc011;
    @Size(max = 10)
    @Column(name = "TC012")
    private String tc012;
    @Size(max = 4000)
    @Column(name = "TC013")
    private String tc013;
    @Size(max = 8)
    @Column(name = "TC014")
    private String tc014;
    @Size(max = 8)
    @Column(name = "TC015")
    private String tc015;
    @Size(max = 10)
    @Column(name = "TC016")
    private String tc016;
    @Size(max = 10)
    @Column(name = "TC017")
    private String tc017;
    @Size(max = 1)
    @Column(name = "TC018")
    private String tc018;
    @Size(max = 10)
    @Column(name = "TC019")
    private String tc019;
    @Size(max = 4)
    @Column(name = "TC020")
    private String tc020;
    @Size(max = 11)
    @Column(name = "TC021")
    private String tc021;
    @Column(name = "TC022")
    private Short tc022;
    @Size(max = 255)
    @Column(name = "TC023")
    private String tc023;
    @Size(max = 10)
    @Column(name = "TC024")
    private String tc024;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "TC025")
    private BigDecimal tc025;
    @Column(name = "TC026")
    private BigDecimal tc026;
    @Size(max = 1)
    @Column(name = "TC027")
    private String tc027;
    @Size(max = 4)
    @Column(name = "TC028")
    private String tc028;
    @Size(max = 20)
    @Column(name = "TC029")
    private String tc029;
    @Size(max = 4)
    @Column(name = "TC030")
    private String tc030;
    @Column(name = "TC031")
    private BigDecimal tc031;
    @Size(max = 1)
    @Column(name = "TC032")
    private String tc032;
    @Size(max = 50)
    @Column(name = "TC033")
    private String tc033;
    @Size(max = 1)
    @Column(name = "TC034")
    private String tc034;
    @Size(max = 10)
    @Column(name = "TC035")
    private String tc035;
    @Size(max = 100)
    @Column(name = "TC036")
    private String tc036;
    @Size(max = 10)
    @Column(name = "TC037")
    private String tc037;
    @Size(max = 20)
    @Column(name = "TC038")
    private String tc038;
    @Size(max = 1)
    @Column(name = "TC039")
    private String tc039;
    @Size(max = 255)
    @Column(name = "TC040")
    private String tc040;
    @Size(max = 255)
    @Column(name = "TC041")
    private String tc041;
    @Size(max = 1)
    @Column(name = "TC042")
    private String tc042;
    @Size(max = 10)
    @Column(name = "TC043")
    private String tc043;
    @Size(max = 8)
    @Column(name = "TC044")
    private String tc044;
    @Size(max = 6)
    @Column(name = "TC045")
    private String tc045;
    @Column(name = "TC046")
    private BigDecimal tc046;
    @Column(name = "TC047")
    private Short tc047;
    @Size(max = 1)
    @Column(name = "TC048")
    private String tc048;
    @Column(name = "TC049")
    private BigDecimal tc049;
    @Column(name = "TC050")
    private BigDecimal tc050;
    @Size(max = 1)
    @Column(name = "TC051")
    private String tc051;
    @Column(name = "TC052")
    private Short tc052;
    @Size(max = 20)
    @Column(name = "TC053")
    private String tc053;
    @Size(max = 15)
    @Column(name = "TC054")
    private String tc054;
    @Size(max = 8)
    @Column(name = "TC055")
    private String tc055;
    @Size(max = 3)
    @Column(name = "TC056")
    private String tc056;
    @Size(max = 6)
    @Column(name = "TC057")
    private String tc057;
    @Size(max = 30)
    @Column(name = "TC058")
    private String tc058;
    @Size(max = 8)
    @Column(name = "TC059")
    private String tc059;
    @Size(max = 8)
    @Column(name = "TC060")
    private String tc060;
    @Size(max = 20)
    @Column(name = "TC061")
    private String tc061;
    @Size(max = 1)
    @Column(name = "TC062")
    private String tc062;
    @Size(max = 1)
    @Column(name = "TC063")
    private String tc063;
    @Size(max = 8)
    @Column(name = "TC064")
    private String tc064;
    @Size(max = 8)
    @Column(name = "TC065")
    private String tc065;
    @Column(name = "TC066")
    private BigDecimal tc066;
    @Size(max = 20)
    @Column(name = "TC067")
    private String tc067;
    @Size(max = 40)
    @Column(name = "TC068")
    private String tc068;
    @Size(max = 6)
    @Column(name = "TC069")
    private String tc069;
    @Column(name = "TC070")
    private BigDecimal tc070;
    @Column(name = "TC071")
    private BigDecimal tc071;
    @Column(name = "TC072")
    private BigDecimal tc072;
    @Column(name = "TC073")
    private BigDecimal tc073;
    @Size(max = 4)
    @Column(name = "TC074")
    private String tc074;
    @Size(max = 120)
    @Column(name = "TC075")
    private String tc075;
    @Size(max = 30)
    @Column(name = "TC076")
    private String tc076;
    @Size(max = 10)
    @Column(name = "TC077")
    private String tc077;
    @Size(max = 1000)
    @Column(name = "TC078")
    private String tc078;
    @Size(max = 1000)
    @Column(name = "TC079")
    private String tc079;
    @Column(name = "TC080")
    private BigDecimal tc080;
    @Column(name = "TC081")
    private BigDecimal tc081;
    @Size(max = 1)
    @Column(name = "TC082")
    private String tc082;
    @Size(max = 30)
    @Column(name = "TC083")
    private String tc083;
    @Size(max = 60)
    @Column(name = "TC084")
    private String tc084;
    @Size(max = 1)
    @Column(name = "TC085")
    private String tc085;
    @Size(max = 1)
    @Column(name = "TC086")
    private String tc086;
    @Column(name = "TC087")
    private BigDecimal tc087;
    @Size(max = 1000)
    @Column(name = "TC088")
    private String tc088;
    @Size(max = 10)
    @Column(name = "TC089")
    private String tc089;
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
    @Column(name = "TC197")
    private String tc197;
    @Size(max = 10)
    @Column(name = "TC198")
    private String tc198;
    @Size(max = 10)
    @Column(name = "TC199")
    private String tc199;
    @Size(max = 255)
    @Column(name = "REPTC01")
    private String reptc01;
    @Size(max = 255)
    @Column(name = "REPTC02")
    private String reptc02;
    @Size(max = 255)
    @Column(name = "REPTC03")
    private String reptc03;
    @Size(max = 255)
    @Column(name = "REPTC04")
    private String reptc04;
    @Size(max = 255)
    @Column(name = "REPTC05")
    private String reptc05;
    @Size(max = 255)
    @Column(name = "REPTC06")
    private String reptc06;
    @Size(max = 255)
    @Column(name = "REPTC07")
    private String reptc07;
    @Size(max = 255)
    @Column(name = "REPTC08")
    private String reptc08;
    @Size(max = 255)
    @Column(name = "REPTC09")
    private String reptc09;
    @Size(max = 255)
    @Column(name = "REPTC10")
    private String reptc10;
    @Size(max = 255)
    @Column(name = "REPTC11")
    private String reptc11;
    @Size(max = 255)
    @Column(name = "REPTC12")
    private String reptc12;
    @Size(max = 255)
    @Column(name = "REPTC13")
    private String reptc13;
    @Size(max = 255)
    @Column(name = "REPTC14")
    private String reptc14;
    @Size(max = 255)
    @Column(name = "REPTC15")
    private String reptc15;
    @Size(max = 255)
    @Column(name = "REPTC16")
    private String reptc16;
    @Size(max = 255)
    @Column(name = "REPTC17")
    private String reptc17;
    @Size(max = 255)
    @Column(name = "REPTC18")
    private String reptc18;
    @Size(max = 255)
    @Column(name = "REPTC19")
    private String reptc19;
    @Size(max = 255)
    @Column(name = "REPTC20")
    private String reptc20;
    
    @JoinColumn(name = "TC007", referencedColumnName = "GG001", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private CRMGG crmgg;
    
 
    public REPTC() {
    }

    public REPTC(REPTCPK reptcPK) {
        this.reptcPK = reptcPK;
    }

    public REPTC(String tc001, String tc002) {
        this.reptcPK = new REPTCPK(tc001, tc002);
    }

    public REPTCPK getREPTCPK() {
        return reptcPK;
    }

    public void setREPTCPK(REPTCPK reptcPK) {
        this.reptcPK = reptcPK;
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

    public String getTc003() {
        return tc003;
    }

    public void setTc003(String tc003) {
        this.tc003 = tc003;
    }

    public String getTc004() {
        return tc004;
    }

    public void setTc004(String tc004) {
        this.tc004 = tc004;
    }

    public String getTc005() {
        return tc005;
    }

    public void setTc005(String tc005) {
        this.tc005 = tc005;
    }

    public String getTc006() {
        return tc006;
    }

    public void setTc006(String tc006) {
        this.tc006 = tc006;
    }

    public String getTc007() {
        return tc007;
    }

    public void setTc007(String tc007) {
        this.tc007 = tc007;
    }

    public String getTc008() {
        return tc008;
    }

    public void setTc008(String tc008) {
        this.tc008 = tc008;
    }

    public String getTc009() {
        return tc009;
    }

    public void setTc009(String tc009) {
        this.tc009 = tc009;
    }

    public String getTc010() {
        return tc010;
    }

    public void setTc010(String tc010) {
        this.tc010 = tc010;
    }

    public String getTc011() {
        return tc011;
    }

    public void setTc011(String tc011) {
        this.tc011 = tc011;
    }

    public String getTc012() {
        return tc012;
    }

    public void setTc012(String tc012) {
        this.tc012 = tc012;
    }

    public String getTc013() {
        return tc013;
    }

    public void setTc013(String tc013) {
        this.tc013 = tc013;
    }

    public String getTc014() {
        return tc014;
    }

    public void setTc014(String tc014) {
        this.tc014 = tc014;
    }

    public String getTc015() {
        return tc015;
    }

    public void setTc015(String tc015) {
        this.tc015 = tc015;
    }

    public String getTc016() {
        return tc016;
    }

    public void setTc016(String tc016) {
        this.tc016 = tc016;
    }

    public String getTc017() {
        return tc017;
    }

    public void setTc017(String tc017) {
        this.tc017 = tc017;
    }

    public String getTc018() {
        return tc018;
    }

    public void setTc018(String tc018) {
        this.tc018 = tc018;
    }

    public String getTc019() {
        return tc019;
    }

    public void setTc019(String tc019) {
        this.tc019 = tc019;
    }

    public String getTc020() {
        return tc020;
    }

    public void setTc020(String tc020) {
        this.tc020 = tc020;
    }

    public String getTc021() {
        return tc021;
    }

    public void setTc021(String tc021) {
        this.tc021 = tc021;
    }

    public Short getTc022() {
        return tc022;
    }

    public void setTc022(Short tc022) {
        this.tc022 = tc022;
    }

    public String getTc023() {
        return tc023;
    }

    public void setTc023(String tc023) {
        this.tc023 = tc023;
    }

    public String getTc024() {
        return tc024;
    }

    public void setTc024(String tc024) {
        this.tc024 = tc024;
    }

    public BigDecimal getTc025() {
        return tc025;
    }

    public void setTc025(BigDecimal tc025) {
        this.tc025 = tc025;
    }

    public BigDecimal getTc026() {
        return tc026;
    }

    public void setTc026(BigDecimal tc026) {
        this.tc026 = tc026;
    }

    public String getTc027() {
        return tc027;
    }

    public void setTc027(String tc027) {
        this.tc027 = tc027;
    }

    public String getTc028() {
        return tc028;
    }

    public void setTc028(String tc028) {
        this.tc028 = tc028;
    }

    public String getTc029() {
        return tc029;
    }

    public void setTc029(String tc029) {
        this.tc029 = tc029;
    }

    public String getTc030() {
        return tc030;
    }

    public void setTc030(String tc030) {
        this.tc030 = tc030;
    }

    public BigDecimal getTc031() {
        return tc031;
    }

    public void setTc031(BigDecimal tc031) {
        this.tc031 = tc031;
    }

    public String getTc032() {
        return tc032;
    }

    public void setTc032(String tc032) {
        this.tc032 = tc032;
    }

    public String getTc033() {
        return tc033;
    }

    public void setTc033(String tc033) {
        this.tc033 = tc033;
    }

    public String getTc034() {
        return tc034;
    }

    public void setTc034(String tc034) {
        this.tc034 = tc034;
    }

    public String getTc035() {
        return tc035;
    }

    public void setTc035(String tc035) {
        this.tc035 = tc035;
    }

    public String getTc036() {
        return tc036;
    }

    public void setTc036(String tc036) {
        this.tc036 = tc036;
    }

    public String getTc037() {
        return tc037;
    }

    public void setTc037(String tc037) {
        this.tc037 = tc037;
    }

    public String getTc038() {
        return tc038;
    }

    public void setTc038(String tc038) {
        this.tc038 = tc038;
    }

    public String getTc039() {
        return tc039;
    }

    public void setTc039(String tc039) {
        this.tc039 = tc039;
    }

    public String getTc040() {
        return tc040;
    }

    public void setTc040(String tc040) {
        this.tc040 = tc040;
    }

    public String getTc041() {
        return tc041;
    }

    public void setTc041(String tc041) {
        this.tc041 = tc041;
    }

    public String getTc042() {
        return tc042;
    }

    public void setTc042(String tc042) {
        this.tc042 = tc042;
    }

    public String getTc043() {
        return tc043;
    }

    public void setTc043(String tc043) {
        this.tc043 = tc043;
    }

    public String getTc044() {
        return tc044;
    }

    public void setTc044(String tc044) {
        this.tc044 = tc044;
    }

    public String getTc045() {
        return tc045;
    }

    public void setTc045(String tc045) {
        this.tc045 = tc045;
    }

    public BigDecimal getTc046() {
        return tc046;
    }

    public void setTc046(BigDecimal tc046) {
        this.tc046 = tc046;
    }

    public Short getTc047() {
        return tc047;
    }

    public void setTc047(Short tc047) {
        this.tc047 = tc047;
    }

    public String getTc048() {
        return tc048;
    }

    public void setTc048(String tc048) {
        this.tc048 = tc048;
    }

    public BigDecimal getTc049() {
        return tc049;
    }

    public void setTc049(BigDecimal tc049) {
        this.tc049 = tc049;
    }

    public BigDecimal getTc050() {
        return tc050;
    }

    public void setTc050(BigDecimal tc050) {
        this.tc050 = tc050;
    }

    public String getTc051() {
        return tc051;
    }

    public void setTc051(String tc051) {
        this.tc051 = tc051;
    }

    public Short getTc052() {
        return tc052;
    }

    public void setTc052(Short tc052) {
        this.tc052 = tc052;
    }

    public String getTc053() {
        return tc053;
    }

    public void setTc053(String tc053) {
        this.tc053 = tc053;
    }

    public String getTc054() {
        return tc054;
    }

    public void setTc054(String tc054) {
        this.tc054 = tc054;
    }

    public String getTc055() {
        return tc055;
    }

    public void setTc055(String tc055) {
        this.tc055 = tc055;
    }

    public String getTc056() {
        return tc056;
    }

    public void setTc056(String tc056) {
        this.tc056 = tc056;
    }

    public String getTc057() {
        return tc057;
    }

    public void setTc057(String tc057) {
        this.tc057 = tc057;
    }

    public String getTc058() {
        return tc058;
    }

    public void setTc058(String tc058) {
        this.tc058 = tc058;
    }

    public String getTc059() {
        return tc059;
    }

    public void setTc059(String tc059) {
        this.tc059 = tc059;
    }

    public String getTc060() {
        return tc060;
    }

    public void setTc060(String tc060) {
        this.tc060 = tc060;
    }

    public String getTc061() {
        return tc061;
    }

    public void setTc061(String tc061) {
        this.tc061 = tc061;
    }

    public String getTc062() {
        return tc062;
    }

    public void setTc062(String tc062) {
        this.tc062 = tc062;
    }

    public String getTc063() {
        return tc063;
    }

    public void setTc063(String tc063) {
        this.tc063 = tc063;
    }

    public String getTc064() {
        return tc064;
    }

    public void setTc064(String tc064) {
        this.tc064 = tc064;
    }

    public String getTc065() {
        return tc065;
    }

    public void setTc065(String tc065) {
        this.tc065 = tc065;
    }

    public BigDecimal getTc066() {
        return tc066;
    }

    public void setTc066(BigDecimal tc066) {
        this.tc066 = tc066;
    }

    public String getTc067() {
        return tc067;
    }

    public void setTc067(String tc067) {
        this.tc067 = tc067;
    }

    public String getTc068() {
        return tc068;
    }

    public void setTc068(String tc068) {
        this.tc068 = tc068;
    }

    public String getTc069() {
        return tc069;
    }

    public void setTc069(String tc069) {
        this.tc069 = tc069;
    }

    public BigDecimal getTc070() {
        return tc070;
    }

    public void setTc070(BigDecimal tc070) {
        this.tc070 = tc070;
    }

    public BigDecimal getTc071() {
        return tc071;
    }

    public void setTc071(BigDecimal tc071) {
        this.tc071 = tc071;
    }

    public BigDecimal getTc072() {
        return tc072;
    }

    public void setTc072(BigDecimal tc072) {
        this.tc072 = tc072;
    }

    public BigDecimal getTc073() {
        return tc073;
    }

    public void setTc073(BigDecimal tc073) {
        this.tc073 = tc073;
    }

    public String getTc074() {
        return tc074;
    }

    public void setTc074(String tc074) {
        this.tc074 = tc074;
    }

    public String getTc075() {
        return tc075;
    }

    public void setTc075(String tc075) {
        this.tc075 = tc075;
    }

    public String getTc076() {
        return tc076;
    }

    public void setTc076(String tc076) {
        this.tc076 = tc076;
    }

    public String getTc077() {
        return tc077;
    }

    public void setTc077(String tc077) {
        this.tc077 = tc077;
    }

    public String getTc078() {
        return tc078;
    }

    public void setTc078(String tc078) {
        this.tc078 = tc078;
    }

    public String getTc079() {
        return tc079;
    }

    public void setTc079(String tc079) {
        this.tc079 = tc079;
    }

    public BigDecimal getTc080() {
        return tc080;
    }

    public void setTc080(BigDecimal tc080) {
        this.tc080 = tc080;
    }

    public BigDecimal getTc081() {
        return tc081;
    }

    public void setTc081(BigDecimal tc081) {
        this.tc081 = tc081;
    }

    public String getTc082() {
        return tc082;
    }

    public void setTc082(String tc082) {
        this.tc082 = tc082;
    }

    public String getTc083() {
        return tc083;
    }

    public void setTc083(String tc083) {
        this.tc083 = tc083;
    }

    public String getTc084() {
        return tc084;
    }

    public void setTc084(String tc084) {
        this.tc084 = tc084;
    }

    public String getTc085() {
        return tc085;
    }

    public void setTc085(String tc085) {
        this.tc085 = tc085;
    }

    public String getTc086() {
        return tc086;
    }

    public void setTc086(String tc086) {
        this.tc086 = tc086;
    }

    public BigDecimal getTc087() {
        return tc087;
    }

    public void setTc087(BigDecimal tc087) {
        this.tc087 = tc087;
    }

    public String getTc088() {
        return tc088;
    }

    public void setTc088(String tc088) {
        this.tc088 = tc088;
    }

    public String getTc089() {
        return tc089;
    }

    public void setTc089(String tc089) {
        this.tc089 = tc089;
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

    public String getTc197() {
        return tc197;
    }

    public void setTc197(String tc197) {
        this.tc197 = tc197;
    }

    public String getTc198() {
        return tc198;
    }

    public void setTc198(String tc198) {
        this.tc198 = tc198;
    }

    public String getTc199() {
        return tc199;
    }

    public void setTc199(String tc199) {
        this.tc199 = tc199;
    }

    public String getREPTC01() {
        return reptc01;
    }

    public void setREPTC01(String reptc01) {
        this.reptc01 = reptc01;
    }

    public String getREPTC02() {
        return reptc02;
    }

    public void setREPTC02(String reptc02) {
        this.reptc02 = reptc02;
    }

    public String getREPTC03() {
        return reptc03;
    }

    public void setREPTC03(String reptc03) {
        this.reptc03 = reptc03;
    }

    public String getREPTC04() {
        return reptc04;
    }

    public void setREPTC04(String reptc04) {
        this.reptc04 = reptc04;
    }

    public String getREPTC05() {
        return reptc05;
    }

    public void setREPTC05(String reptc05) {
        this.reptc05 = reptc05;
    }

    public String getREPTC06() {
        return reptc06;
    }

    public void setREPTC06(String reptc06) {
        this.reptc06 = reptc06;
    }

    public String getREPTC07() {
        return reptc07;
    }

    public void setREPTC07(String reptc07) {
        this.reptc07 = reptc07;
    }

    public String getREPTC08() {
        return reptc08;
    }

    public void setREPTC08(String reptc08) {
        this.reptc08 = reptc08;
    }

    public String getREPTC09() {
        return reptc09;
    }

    public void setREPTC09(String reptc09) {
        this.reptc09 = reptc09;
    }

    public String getREPTC10() {
        return reptc10;
    }

    public void setREPTC10(String reptc10) {
        this.reptc10 = reptc10;
    }

    public String getREPTC11() {
        return reptc11;
    }

    public void setREPTC11(String reptc11) {
        this.reptc11 = reptc11;
    }

    public String getREPTC12() {
        return reptc12;
    }

    public void setREPTC12(String reptc12) {
        this.reptc12 = reptc12;
    }

    public String getREPTC13() {
        return reptc13;
    }

    public void setREPTC13(String reptc13) {
        this.reptc13 = reptc13;
    }

    public String getREPTC14() {
        return reptc14;
    }

    public void setREPTC14(String reptc14) {
        this.reptc14 = reptc14;
    }

    public String getREPTC15() {
        return reptc15;
    }

    public void setREPTC15(String reptc15) {
        this.reptc15 = reptc15;
    }

    public String getREPTC16() {
        return reptc16;
    }

    public void setREPTC16(String reptc16) {
        this.reptc16 = reptc16;
    }

    public String getREPTC17() {
        return reptc17;
    }

    public void setREPTC17(String reptc17) {
        this.reptc17 = reptc17;
    }

    public String getREPTC18() {
        return reptc18;
    }

    public void setREPTC18(String reptc18) {
        this.reptc18 = reptc18;
    }

    public String getREPTC19() {
        return reptc19;
    }

    public void setREPTC19(String reptc19) {
        this.reptc19 = reptc19;
    }

    public String getREPTC20() {
        return reptc20;
    }

    public void setREPTC20(String reptc20) {
        this.reptc20 = reptc20;
    }

    public BigDecimal getTc090() {
        return tc090;
    }

    public void setTc090(BigDecimal tc090) {
        this.tc090 = tc090;
    }

    public BigDecimal getTc091() {
        return tc091;
    }

    public void setTc091(BigDecimal tc091) {
        this.tc091 = tc091;
    }

    public String getTc092() {
        return tc092;
    }

    public void setTc092(String tc092) {
        this.tc092 = tc092;
    }

    public String getTc093() {
        return tc093;
    }

    public void setTc093(String tc093) {
        this.tc093 = tc093;
    }

    public String getTc094() {
        return tc094;
    }

    public void setTc094(String tc094) {
        this.tc094 = tc094;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reptcPK != null ? reptcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTC)) {
            return false;
        }
        REPTC other = (REPTC) object;
        if ((this.reptcPK == null && other.reptcPK != null)
                || (this.reptcPK != null && !this.reptcPK.equals(other.reptcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPTC[ reptcPK=" + reptcPK + " ]";
    }

    // public String getTc100() {
    // return tc100;
    // }
    //
    // public void setTc100(String tc100) {
    // this.tc100 = tc100;
    // }
    public String getTc095() {
        return tc095;
    }

    public void setTc095(String tc095) {
        this.tc095 = tc095;
    }

    public String getTc096() {
        return tc096;
    }

    public void setTc096(String tc096) {
        this.tc096 = tc096;
    }

    public String getTc097() {
        return tc097;
    }

    public void setTc097(String tc097) {
        this.tc097 = tc097;
    }

    public String getTc098() {
        return tc098;
    }

    public void setTc098(String tc098) {
        this.tc098 = tc098;
    }

    public String getTc500() {
        return tc500;
    }

    public void setTc500(String tc500) {
        this.tc500 = tc500;
    }

    public String getTc501() {
        return tc501;
    }

    public void setTc501(String tc501) {
        this.tc501 = tc501;
    }

    public String getTc099() {
        return tc099;
    }

    public void setTc099(String tc099) {
        this.tc099 = tc099;
    }

    public String getTc502() {
        return tc502;
    }

    public void setTc502(String tc502) {
        this.tc502 = tc502;
    }

    public String getTc503() {
        return tc503;
    }

    public void setTc503(String tc503) {
        this.tc503 = tc503;
    }

    public String getTc504() {
        return tc504;
    }

    public void setTc504(String tc504) {
        this.tc504 = tc504;
    }

    public String getTc505() {
        return tc505;
    }

    public void setTc505(String tc505) {
        this.tc505 = tc505;
    }

    public String getTc506() {
        return tc506;
    }

    public void setTc506(String tc506) {
        this.tc506 = tc506;
    }

    public String getTc507() {
        return tc507;
    }

    public void setTc507(String tc507) {
        this.tc507 = tc507;
    }

    public String getTc508() {
        return tc508;
    }

    public void setTc508(String tc508) {
        this.tc508 = tc508;
    }

    public CRMGG getCrmgg() {
        return crmgg;
    }

    public void setCrmgg(CRMGG crmgg) {
        this.crmgg = crmgg;
    }

}
