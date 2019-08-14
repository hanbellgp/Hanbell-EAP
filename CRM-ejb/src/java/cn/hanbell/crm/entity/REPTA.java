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
@Table(name = "REPTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPTA.findAll", query = "SELECT r FROM REPTA r"),
    @NamedQuery(name = "REPTA.findByCompany", query = "SELECT r FROM REPTA r WHERE r.company = :company"),
    @NamedQuery(name = "REPTA.findByCreator", query = "SELECT r FROM REPTA r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPTA.findByUsrGroup", query = "SELECT r FROM REPTA r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPTA.findByCreateDate", query = "SELECT r FROM REPTA r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPTA.findByModifier", query = "SELECT r FROM REPTA r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPTA.findByModiDate", query = "SELECT r FROM REPTA r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPTA.findByFlag", query = "SELECT r FROM REPTA r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPTA.findByTa001", query = "SELECT r FROM REPTA r WHERE r.rEPTAPK.ta001 = :ta001"),
    @NamedQuery(name = "REPTA.findByTa002", query = "SELECT r FROM REPTA r WHERE r.rEPTAPK.ta002 = :ta002"),
    @NamedQuery(name = "REPTA.findByTa003", query = "SELECT r FROM REPTA r WHERE r.ta003 = :ta003"),
    @NamedQuery(name = "REPTA.findByTa004", query = "SELECT r FROM REPTA r WHERE r.ta004 = :ta004"),
    @NamedQuery(name = "REPTA.findByTa005", query = "SELECT r FROM REPTA r WHERE r.ta005 = :ta005"),
    @NamedQuery(name = "REPTA.findByTa006", query = "SELECT r FROM REPTA r WHERE r.ta006 = :ta006"),
    @NamedQuery(name = "REPTA.findByTa007", query = "SELECT r FROM REPTA r WHERE r.ta007 = :ta007"),
    @NamedQuery(name = "REPTA.findByTa008", query = "SELECT r FROM REPTA r WHERE r.ta008 = :ta008"),
    @NamedQuery(name = "REPTA.findByTa009", query = "SELECT r FROM REPTA r WHERE r.ta009 = :ta009"),
    @NamedQuery(name = "REPTA.findByTa010", query = "SELECT r FROM REPTA r WHERE r.ta010 = :ta010"),
    @NamedQuery(name = "REPTA.findByTa011", query = "SELECT r FROM REPTA r WHERE r.ta011 = :ta011"),
    @NamedQuery(name = "REPTA.findByTa012", query = "SELECT r FROM REPTA r WHERE r.ta012 = :ta012"),
    @NamedQuery(name = "REPTA.findByTa013", query = "SELECT r FROM REPTA r WHERE r.ta013 = :ta013"),
    @NamedQuery(name = "REPTA.findByTa014", query = "SELECT r FROM REPTA r WHERE r.ta014 = :ta014"),
    @NamedQuery(name = "REPTA.findByTa015", query = "SELECT r FROM REPTA r WHERE r.ta015 = :ta015"),
    @NamedQuery(name = "REPTA.findByTa016", query = "SELECT r FROM REPTA r WHERE r.ta016 = :ta016"),
    @NamedQuery(name = "REPTA.findByTa017", query = "SELECT r FROM REPTA r WHERE r.ta017 = :ta017"),
    @NamedQuery(name = "REPTA.findByTa018", query = "SELECT r FROM REPTA r WHERE r.ta018 = :ta018"),
    @NamedQuery(name = "REPTA.findByTa019", query = "SELECT r FROM REPTA r WHERE r.ta019 = :ta019"),
    @NamedQuery(name = "REPTA.findByTa020", query = "SELECT r FROM REPTA r WHERE r.ta020 = :ta020"),
    @NamedQuery(name = "REPTA.findByTa021", query = "SELECT r FROM REPTA r WHERE r.ta021 = :ta021"),
    @NamedQuery(name = "REPTA.findByTa022", query = "SELECT r FROM REPTA r WHERE r.ta022 = :ta022"),
    @NamedQuery(name = "REPTA.findByTa023", query = "SELECT r FROM REPTA r WHERE r.ta023 = :ta023"),
    @NamedQuery(name = "REPTA.findByTa024", query = "SELECT r FROM REPTA r WHERE r.ta024 = :ta024"),
    @NamedQuery(name = "REPTA.findByTa025", query = "SELECT r FROM REPTA r WHERE r.ta025 = :ta025"),
    @NamedQuery(name = "REPTA.findByTa026", query = "SELECT r FROM REPTA r WHERE r.ta026 = :ta026"),
    @NamedQuery(name = "REPTA.findByTa027", query = "SELECT r FROM REPTA r WHERE r.ta027 = :ta027"),
    @NamedQuery(name = "REPTA.findByTa028", query = "SELECT r FROM REPTA r WHERE r.ta028 = :ta028"),
    @NamedQuery(name = "REPTA.findByTa029", query = "SELECT r FROM REPTA r WHERE r.ta029 = :ta029"),
    @NamedQuery(name = "REPTA.findByTa030", query = "SELECT r FROM REPTA r WHERE r.ta030 = :ta030"),
    @NamedQuery(name = "REPTA.findByTa031", query = "SELECT r FROM REPTA r WHERE r.ta031 = :ta031"),
    @NamedQuery(name = "REPTA.findByTa032", query = "SELECT r FROM REPTA r WHERE r.ta032 = :ta032"),
    @NamedQuery(name = "REPTA.findByTa033", query = "SELECT r FROM REPTA r WHERE r.ta033 = :ta033"),
    @NamedQuery(name = "REPTA.findByTa034", query = "SELECT r FROM REPTA r WHERE r.ta034 = :ta034"),
    @NamedQuery(name = "REPTA.findByTa035", query = "SELECT r FROM REPTA r WHERE r.ta035 = :ta035"),
    @NamedQuery(name = "REPTA.findByTa036", query = "SELECT r FROM REPTA r WHERE r.ta036 = :ta036"),
    @NamedQuery(name = "REPTA.findByTa037", query = "SELECT r FROM REPTA r WHERE r.ta037 = :ta037"),
    @NamedQuery(name = "REPTA.findByTa038", query = "SELECT r FROM REPTA r WHERE r.ta038 = :ta038"),
    @NamedQuery(name = "REPTA.findByTa039", query = "SELECT r FROM REPTA r WHERE r.ta039 = :ta039"),
    @NamedQuery(name = "REPTA.findByTa040", query = "SELECT r FROM REPTA r WHERE r.ta040 = :ta040"),
    @NamedQuery(name = "REPTA.findByTa041", query = "SELECT r FROM REPTA r WHERE r.ta041 = :ta041"),
    @NamedQuery(name = "REPTA.findByTa042", query = "SELECT r FROM REPTA r WHERE r.ta042 = :ta042"),
    @NamedQuery(name = "REPTA.findByTa043", query = "SELECT r FROM REPTA r WHERE r.ta043 = :ta043"),
    @NamedQuery(name = "REPTA.findByTa044", query = "SELECT r FROM REPTA r WHERE r.ta044 = :ta044"),
    @NamedQuery(name = "REPTA.findByTa045", query = "SELECT r FROM REPTA r WHERE r.ta045 = :ta045"),
    @NamedQuery(name = "REPTA.findByTa046", query = "SELECT r FROM REPTA r WHERE r.ta046 = :ta046"),
    @NamedQuery(name = "REPTA.findByTa047", query = "SELECT r FROM REPTA r WHERE r.ta047 = :ta047"),
    @NamedQuery(name = "REPTA.findByTa048", query = "SELECT r FROM REPTA r WHERE r.ta048 = :ta048"),
    @NamedQuery(name = "REPTA.findByTa049", query = "SELECT r FROM REPTA r WHERE r.ta049 = :ta049"),
    @NamedQuery(name = "REPTA.findByTa050", query = "SELECT r FROM REPTA r WHERE r.ta050 = :ta050"),
    @NamedQuery(name = "REPTA.findByTa051", query = "SELECT r FROM REPTA r WHERE r.ta051 = :ta051"),
    @NamedQuery(name = "REPTA.findByTa052", query = "SELECT r FROM REPTA r WHERE r.ta052 = :ta052"),
    @NamedQuery(name = "REPTA.findByTa053", query = "SELECT r FROM REPTA r WHERE r.ta053 = :ta053"),
    @NamedQuery(name = "REPTA.findByTa054", query = "SELECT r FROM REPTA r WHERE r.ta054 = :ta054"),
    @NamedQuery(name = "REPTA.findByTa055", query = "SELECT r FROM REPTA r WHERE r.ta055 = :ta055"),
    @NamedQuery(name = "REPTA.findByTa056", query = "SELECT r FROM REPTA r WHERE r.ta056 = :ta056"),
    @NamedQuery(name = "REPTA.findByTa057", query = "SELECT r FROM REPTA r WHERE r.ta057 = :ta057"),
    @NamedQuery(name = "REPTA.findByTa058", query = "SELECT r FROM REPTA r WHERE r.ta058 = :ta058"),
    @NamedQuery(name = "REPTA.findByTa059", query = "SELECT r FROM REPTA r WHERE r.ta059 = :ta059"),
    @NamedQuery(name = "REPTA.findByTa060", query = "SELECT r FROM REPTA r WHERE r.ta060 = :ta060"),
    @NamedQuery(name = "REPTA.findByTa061", query = "SELECT r FROM REPTA r WHERE r.ta061 = :ta061"),
    @NamedQuery(name = "REPTA.findByTa062", query = "SELECT r FROM REPTA r WHERE r.ta062 = :ta062"),
    @NamedQuery(name = "REPTA.findByTa063", query = "SELECT r FROM REPTA r WHERE r.ta063 = :ta063"),
    @NamedQuery(name = "REPTA.findByTa064", query = "SELECT r FROM REPTA r WHERE r.ta064 = :ta064"),
    @NamedQuery(name = "REPTA.findByTa065", query = "SELECT r FROM REPTA r WHERE r.ta065 = :ta065"),
    @NamedQuery(name = "REPTA.findByTa066", query = "SELECT r FROM REPTA r WHERE r.ta066 = :ta066"),
    @NamedQuery(name = "REPTA.findByTa067", query = "SELECT r FROM REPTA r WHERE r.ta067 = :ta067"),
    @NamedQuery(name = "REPTA.findByTa068", query = "SELECT r FROM REPTA r WHERE r.ta068 = :ta068"),
    @NamedQuery(name = "REPTA.findByTa069", query = "SELECT r FROM REPTA r WHERE r.ta069 = :ta069"),
    @NamedQuery(name = "REPTA.findByTa070", query = "SELECT r FROM REPTA r WHERE r.ta070 = :ta070"),
    @NamedQuery(name = "REPTA.findByTa071", query = "SELECT r FROM REPTA r WHERE r.ta071 = :ta071"),
    @NamedQuery(name = "REPTA.findByTa072", query = "SELECT r FROM REPTA r WHERE r.ta072 = :ta072"),
    @NamedQuery(name = "REPTA.findByTa073", query = "SELECT r FROM REPTA r WHERE r.ta073 = :ta073"),
    @NamedQuery(name = "REPTA.findByTa074", query = "SELECT r FROM REPTA r WHERE r.ta074 = :ta074"),
    @NamedQuery(name = "REPTA.findByTa075", query = "SELECT r FROM REPTA r WHERE r.ta075 = :ta075"),
    @NamedQuery(name = "REPTA.findByTa076", query = "SELECT r FROM REPTA r WHERE r.ta076 = :ta076"),
    @NamedQuery(name = "REPTA.findByTa077", query = "SELECT r FROM REPTA r WHERE r.ta077 = :ta077"),
    @NamedQuery(name = "REPTA.findByTa078", query = "SELECT r FROM REPTA r WHERE r.ta078 = :ta078"),
    @NamedQuery(name = "REPTA.findByTa079", query = "SELECT r FROM REPTA r WHERE r.ta079 = :ta079"),
    @NamedQuery(name = "REPTA.findByCustomer", query = "SELECT r FROM REPTA r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPTA.findByProduct", query = "SELECT r FROM REPTA r WHERE r.product = :product"),
    @NamedQuery(name = "REPTA.findByRegion", query = "SELECT r FROM REPTA r WHERE r.region = :region"),
    @NamedQuery(name = "REPTA.findByDealer", query = "SELECT r FROM REPTA r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPTA.findByTa080", query = "SELECT r FROM REPTA r WHERE r.ta080 = :ta080"),
    @NamedQuery(name = "REPTA.findByTa081", query = "SELECT r FROM REPTA r WHERE r.ta081 = :ta081"),
    @NamedQuery(name = "REPTA.findByTa197", query = "SELECT r FROM REPTA r WHERE r.ta197 = :ta197"),
    @NamedQuery(name = "REPTA.findByTa198", query = "SELECT r FROM REPTA r WHERE r.ta198 = :ta198"),
    @NamedQuery(name = "REPTA.findByTa199", query = "SELECT r FROM REPTA r WHERE r.ta199 = :ta199"),
    @NamedQuery(name = "REPTA.findByTa082", query = "SELECT r FROM REPTA r WHERE r.ta082 = :ta082"),
    @NamedQuery(name = "REPTA.findByTa083", query = "SELECT r FROM REPTA r WHERE r.ta083 = :ta083"),
    @NamedQuery(name = "REPTA.findByTa084", query = "SELECT r FROM REPTA r WHERE r.ta084 = :ta084"),
    @NamedQuery(name = "REPTA.findByTa085", query = "SELECT r FROM REPTA r WHERE r.ta085 = :ta085"),
    @NamedQuery(name = "REPTA.findByTa086", query = "SELECT r FROM REPTA r WHERE r.ta086 = :ta086"),
    @NamedQuery(name = "REPTA.findByTa087", query = "SELECT r FROM REPTA r WHERE r.ta087 = :ta087"),
    @NamedQuery(name = "REPTA.findByTa088", query = "SELECT r FROM REPTA r WHERE r.ta088 = :ta088"),
    @NamedQuery(name = "REPTA.findByTa089", query = "SELECT r FROM REPTA r WHERE r.ta089 = :ta089"),
    @NamedQuery(name = "REPTA.findByTa090", query = "SELECT r FROM REPTA r WHERE r.ta090 = :ta090"),
    @NamedQuery(name = "REPTA.findByRepta01", query = "SELECT r FROM REPTA r WHERE r.repta01 = :repta01"),
    @NamedQuery(name = "REPTA.findByRepta02", query = "SELECT r FROM REPTA r WHERE r.repta02 = :repta02"),
    @NamedQuery(name = "REPTA.findByRepta03", query = "SELECT r FROM REPTA r WHERE r.repta03 = :repta03"),
    @NamedQuery(name = "REPTA.findByRepta04", query = "SELECT r FROM REPTA r WHERE r.repta04 = :repta04"),
    @NamedQuery(name = "REPTA.findByRepta05", query = "SELECT r FROM REPTA r WHERE r.repta05 = :repta05"),
    @NamedQuery(name = "REPTA.findByRepta06", query = "SELECT r FROM REPTA r WHERE r.repta06 = :repta06"),
    @NamedQuery(name = "REPTA.findByRepta07", query = "SELECT r FROM REPTA r WHERE r.repta07 = :repta07"),
    @NamedQuery(name = "REPTA.findByRepta08", query = "SELECT r FROM REPTA r WHERE r.repta08 = :repta08"),
    @NamedQuery(name = "REPTA.findByRepta09", query = "SELECT r FROM REPTA r WHERE r.repta09 = :repta09"),
    @NamedQuery(name = "REPTA.findByRepta10", query = "SELECT r FROM REPTA r WHERE r.repta10 = :repta10"),
    @NamedQuery(name = "REPTA.findByRepta11", query = "SELECT r FROM REPTA r WHERE r.repta11 = :repta11"),
    @NamedQuery(name = "REPTA.findByRepta12", query = "SELECT r FROM REPTA r WHERE r.repta12 = :repta12"),
    @NamedQuery(name = "REPTA.findByRepta13", query = "SELECT r FROM REPTA r WHERE r.repta13 = :repta13"),
    @NamedQuery(name = "REPTA.findByRepta14", query = "SELECT r FROM REPTA r WHERE r.repta14 = :repta14"),
    @NamedQuery(name = "REPTA.findByRepta15", query = "SELECT r FROM REPTA r WHERE r.repta15 = :repta15"),
    @NamedQuery(name = "REPTA.findByRepta16", query = "SELECT r FROM REPTA r WHERE r.repta16 = :repta16"),
    @NamedQuery(name = "REPTA.findByRepta17", query = "SELECT r FROM REPTA r WHERE r.repta17 = :repta17"),
    @NamedQuery(name = "REPTA.findByRepta18", query = "SELECT r FROM REPTA r WHERE r.repta18 = :repta18"),
    @NamedQuery(name = "REPTA.findByRepta19", query = "SELECT r FROM REPTA r WHERE r.repta19 = :repta19"),
    @NamedQuery(name = "REPTA.findByRepta20", query = "SELECT r FROM REPTA r WHERE r.repta20 = :repta20"),
    @NamedQuery(name = "REPTA.findByTa091", query = "SELECT r FROM REPTA r WHERE r.ta091 = :ta091"),
    @NamedQuery(name = "REPTA.findByTa092", query = "SELECT r FROM REPTA r WHERE r.ta092 = :ta092"),
    @NamedQuery(name = "REPTA.findByTa093", query = "SELECT r FROM REPTA r WHERE r.ta093 = :ta093"),
    @NamedQuery(name = "REPTA.findByTa094", query = "SELECT r FROM REPTA r WHERE r.ta094 = :ta094"),
    @NamedQuery(name = "REPTA.findByTa500", query = "SELECT r FROM REPTA r WHERE r.ta500 = :ta500"),
    @NamedQuery(name = "REPTA.findByTa095", query = "SELECT r FROM REPTA r WHERE r.ta095 = :ta095"),
    @NamedQuery(name = "REPTA.findByTa096", query = "SELECT r FROM REPTA r WHERE r.ta096 = :ta096"),
    @NamedQuery(name = "REPTA.findByTa097", query = "SELECT r FROM REPTA r WHERE r.ta097 = :ta097"),
    @NamedQuery(name = "REPTA.findByTa098", query = "SELECT r FROM REPTA r WHERE r.ta098 = :ta098"),
    @NamedQuery(name = "REPTA.findByTa099", query = "SELECT r FROM REPTA r WHERE r.ta099 = :ta099"),
    @NamedQuery(name = "REPTA.findByTa100", query = "SELECT r FROM REPTA r WHERE r.ta100 = :ta100"),
    @NamedQuery(name = "REPTA.findByTa101", query = "SELECT r FROM REPTA r WHERE r.ta101 = :ta101")})
public class REPTA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPTAPK rEPTAPK;
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
    @Size(max = 120)
    @Column(name = "TA005")
    private String ta005;
    @Size(max = 120)
    @Column(name = "TA006")
    private String ta006;
    @Size(max = 120)
    @Column(name = "TA007")
    private String ta007;
    @Size(max = 20)
    @Column(name = "TA008")
    private String ta008;
    @Size(max = 10)
    @Column(name = "TA009")
    private String ta009;
    @Size(max = 4000)
    @Column(name = "TA010")
    private String ta010;
    @Size(max = 8)
    @Column(name = "TA011")
    private String ta011;
    @Size(max = 8)
    @Column(name = "TA012")
    private String ta012;
    @Size(max = 30)
    @Column(name = "TA013")
    private String ta013;
    @Size(max = 1)
    @Column(name = "TA014")
    private String ta014;
    @Size(max = 8)
    @Column(name = "TA015")
    private String ta015;
    @Size(max = 10)
    @Column(name = "TA016")
    private String ta016;
    @Size(max = 255)
    @Column(name = "TA017")
    private String ta017;
    @Column(name = "TA018")
    private Short ta018;
    @Column(name = "TA019")
    private Short ta019;
    @Size(max = 50)
    @Column(name = "TA020")
    private String ta020;
    @Size(max = 100)
    @Column(name = "TA021")
    private String ta021;
    @Size(max = 255)
    @Column(name = "TA022")
    private String ta022;
    @Size(max = 255)
    @Column(name = "TA023")
    private String ta023;
    @Size(max = 10)
    @Column(name = "TA024")
    private String ta024;
    @Size(max = 20)
    @Column(name = "TA025")
    private String ta025;
    @Size(max = 255)
    @Column(name = "TA026")
    private String ta026;
    @Size(max = 255)
    @Column(name = "TA027")
    private String ta027;
    @Size(max = 10)
    @Column(name = "TA028")
    private String ta028;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TA029")
    private BigDecimal ta029;
    @Size(max = 1)
    @Column(name = "TA030")
    private String ta030;
    @Size(max = 1)
    @Column(name = "TA031")
    private String ta031;
    @Size(max = 10)
    @Column(name = "TA032")
    private String ta032;
    @Size(max = 50)
    @Column(name = "TA033")
    private String ta033;
    @Size(max = 20)
    @Column(name = "TA034")
    private String ta034;
    @Size(max = 1)
    @Column(name = "TA035")
    private String ta035;
    @Size(max = 20)
    @Column(name = "TA036")
    private String ta036;
    @Size(max = 1)
    @Column(name = "TA037")
    private String ta037;
    @Size(max = 1)
    @Column(name = "TA038")
    private String ta038;
    @Column(name = "TA039")
    private Short ta039;
    @Column(name = "TA040")
    private Short ta040;
    @Size(max = 4)
    @Column(name = "TA041")
    private String ta041;
    @Size(max = 11)
    @Column(name = "TA042")
    private String ta042;
    @Column(name = "TA043")
    private BigDecimal ta043;
    @Size(max = 1)
    @Column(name = "TA044")
    private String ta044;
    @Column(name = "TA045")
    private BigDecimal ta045;
    @Column(name = "TA046")
    private BigDecimal ta046;
    @Column(name = "TA047")
    private BigDecimal ta047;
    @Size(max = 8)
    @Column(name = "TA048")
    private String ta048;
    @Size(max = 15)
    @Column(name = "TA049")
    private String ta049;
    @Size(max = 10)
    @Column(name = "TA050")
    private String ta050;
    @Size(max = 3)
    @Column(name = "TA051")
    private String ta051;
    @Size(max = 20)
    @Column(name = "TA052")
    private String ta052;
    @Size(max = 255)
    @Column(name = "TA053")
    private String ta053;
    @Size(max = 1)
    @Column(name = "TA054")
    private String ta054;
    @Size(max = 1)
    @Column(name = "TA055")
    private String ta055;
    @Size(max = 8)
    @Column(name = "TA056")
    private String ta056;
    @Size(max = 8)
    @Column(name = "TA057")
    private String ta057;
    @Size(max = 1)
    @Column(name = "TA058")
    private String ta058;
    @Column(name = "TA059")
    private BigDecimal ta059;
    @Size(max = 20)
    @Column(name = "TA060")
    private String ta060;
    @Size(max = 40)
    @Column(name = "TA061")
    private String ta061;
    @Size(max = 10)
    @Column(name = "TA062")
    private String ta062;
    @Column(name = "TA063")
    private BigDecimal ta063;
    @Column(name = "TA064")
    private BigDecimal ta064;
    @Column(name = "TA065")
    private BigDecimal ta065;
    @Column(name = "TA066")
    private BigDecimal ta066;
    @Column(name = "TA067")
    private BigDecimal ta067;
    @Size(max = 10)
    @Column(name = "TA068")
    private String ta068;
    @Size(max = 120)
    @Column(name = "TA069")
    private String ta069;
    @Size(max = 30)
    @Column(name = "TA070")
    private String ta070;
    @Size(max = 10)
    @Column(name = "TA071")
    private String ta071;
    @Size(max = 8)
    @Column(name = "TA072")
    private String ta072;
    @Size(max = 1000)
    @Column(name = "TA073")
    private String ta073;
    @Size(max = 1000)
    @Column(name = "TA074")
    private String ta074;
    @Column(name = "TA075")
    private BigDecimal ta075;
    @Column(name = "TA076")
    private BigDecimal ta076;
    @Size(max = 1)
    @Column(name = "TA077")
    private String ta077;
    @Size(max = 30)
    @Column(name = "TA078")
    private String ta078;
    @Size(max = 60)
    @Column(name = "TA079")
    private String ta079;
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
    @Column(name = "TA080")
    private String ta080;
    @Size(max = 8)
    @Column(name = "TA081")
    private String ta081;
    @Size(max = 10)
    @Column(name = "TA197")
    private String ta197;
    @Size(max = 10)
    @Column(name = "TA198")
    private String ta198;
    @Size(max = 10)
    @Column(name = "TA199")
    private String ta199;
    @Size(max = 1)
    @Column(name = "TA082")
    private String ta082;
    @Size(max = 1000)
    @Column(name = "TA083")
    private String ta083;
    @Size(max = 1)
    @Column(name = "TA084")
    private String ta084;
    @Size(max = 8)
    @Column(name = "TA085")
    private String ta085;
    @Size(max = 10)
    @Column(name = "TA086")
    private String ta086;
    @Size(max = 20)
    @Column(name = "TA087")
    private String ta087;
    @Size(max = 1)
    @Column(name = "TA088")
    private String ta088;
    @Size(max = 10)
    @Column(name = "TA089")
    private String ta089;
    @Column(name = "TA090")
    private Short ta090;
    @Size(max = 255)
    @Column(name = "REPTA01")
    private String repta01;
    @Size(max = 255)
    @Column(name = "REPTA02")
    private String repta02;
    @Size(max = 255)
    @Column(name = "REPTA03")
    private String repta03;
    @Size(max = 255)
    @Column(name = "REPTA04")
    private String repta04;
    @Size(max = 255)
    @Column(name = "REPTA05")
    private String repta05;
    @Size(max = 255)
    @Column(name = "REPTA06")
    private String repta06;
    @Size(max = 255)
    @Column(name = "REPTA07")
    private String repta07;
    @Size(max = 255)
    @Column(name = "REPTA08")
    private String repta08;
    @Size(max = 255)
    @Column(name = "REPTA09")
    private String repta09;
    @Size(max = 255)
    @Column(name = "REPTA10")
    private String repta10;
    @Size(max = 255)
    @Column(name = "REPTA11")
    private String repta11;
    @Size(max = 255)
    @Column(name = "REPTA12")
    private String repta12;
    @Size(max = 255)
    @Column(name = "REPTA13")
    private String repta13;
    @Size(max = 255)
    @Column(name = "REPTA14")
    private String repta14;
    @Size(max = 255)
    @Column(name = "REPTA15")
    private String repta15;
    @Size(max = 255)
    @Column(name = "REPTA16")
    private String repta16;
    @Size(max = 255)
    @Column(name = "REPTA17")
    private String repta17;
    @Size(max = 255)
    @Column(name = "REPTA18")
    private String repta18;
    @Size(max = 255)
    @Column(name = "REPTA19")
    private String repta19;
    @Size(max = 255)
    @Column(name = "REPTA20")
    private String repta20;
    @Size(max = 1)
    @Column(name = "TA091")
    private String ta091;
    @Size(max = 1)
    @Column(name = "TA092")
    private String ta092;
    @Size(max = 4)
    @Column(name = "TA093")
    private String ta093;
    @Size(max = 11)
    @Column(name = "TA094")
    private String ta094;
    @Size(max = 50)
    @Column(name = "TA500")
    private String ta500;
    @Size(max = 16)
    @Column(name = "TA095")
    private String ta095;
    @Size(max = 30)
    @Column(name = "TA096")
    private String ta096;
    @Size(max = 30)
    @Column(name = "TA097")
    private String ta097;
    @Size(max = 8)
    @Column(name = "TA098")
    private String ta098;
    @Size(max = 4)
    @Column(name = "TA099")
    private String ta099;
    @Size(max = 4)
    @Column(name = "TA100")
    private String ta100;
    @Size(max = 4)
    @Column(name = "TA101")
    private String ta101;

    public REPTA() {
    }

    public REPTA(REPTAPK rEPTAPK) {
        this.rEPTAPK = rEPTAPK;
    }

    public REPTA(String ta001, String ta002) {
        this.rEPTAPK = new REPTAPK(ta001, ta002);
    }

    public REPTAPK getREPTAPK() {
        return rEPTAPK;
    }

    public void setREPTAPK(REPTAPK rEPTAPK) {
        this.rEPTAPK = rEPTAPK;
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

    public String getTa008() {
        return ta008;
    }

    public void setTa008(String ta008) {
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

    public Short getTa018() {
        return ta018;
    }

    public void setTa018(Short ta018) {
        this.ta018 = ta018;
    }

    public Short getTa019() {
        return ta019;
    }

    public void setTa019(Short ta019) {
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

    public String getTa023() {
        return ta023;
    }

    public void setTa023(String ta023) {
        this.ta023 = ta023;
    }

    public String getTa024() {
        return ta024;
    }

    public void setTa024(String ta024) {
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

    public String getTa028() {
        return ta028;
    }

    public void setTa028(String ta028) {
        this.ta028 = ta028;
    }

    public BigDecimal getTa029() {
        return ta029;
    }

    public void setTa029(BigDecimal ta029) {
        this.ta029 = ta029;
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

    public Short getTa039() {
        return ta039;
    }

    public void setTa039(Short ta039) {
        this.ta039 = ta039;
    }

    public Short getTa040() {
        return ta040;
    }

    public void setTa040(Short ta040) {
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

    public BigDecimal getTa043() {
        return ta043;
    }

    public void setTa043(BigDecimal ta043) {
        this.ta043 = ta043;
    }

    public String getTa044() {
        return ta044;
    }

    public void setTa044(String ta044) {
        this.ta044 = ta044;
    }

    public BigDecimal getTa045() {
        return ta045;
    }

    public void setTa045(BigDecimal ta045) {
        this.ta045 = ta045;
    }

    public BigDecimal getTa046() {
        return ta046;
    }

    public void setTa046(BigDecimal ta046) {
        this.ta046 = ta046;
    }

    public BigDecimal getTa047() {
        return ta047;
    }

    public void setTa047(BigDecimal ta047) {
        this.ta047 = ta047;
    }

    public String getTa048() {
        return ta048;
    }

    public void setTa048(String ta048) {
        this.ta048 = ta048;
    }

    public String getTa049() {
        return ta049;
    }

    public void setTa049(String ta049) {
        this.ta049 = ta049;
    }

    public String getTa050() {
        return ta050;
    }

    public void setTa050(String ta050) {
        this.ta050 = ta050;
    }

    public String getTa051() {
        return ta051;
    }

    public void setTa051(String ta051) {
        this.ta051 = ta051;
    }

    public String getTa052() {
        return ta052;
    }

    public void setTa052(String ta052) {
        this.ta052 = ta052;
    }

    public String getTa053() {
        return ta053;
    }

    public void setTa053(String ta053) {
        this.ta053 = ta053;
    }

    public String getTa054() {
        return ta054;
    }

    public void setTa054(String ta054) {
        this.ta054 = ta054;
    }

    public String getTa055() {
        return ta055;
    }

    public void setTa055(String ta055) {
        this.ta055 = ta055;
    }

    public String getTa056() {
        return ta056;
    }

    public void setTa056(String ta056) {
        this.ta056 = ta056;
    }

    public String getTa057() {
        return ta057;
    }

    public void setTa057(String ta057) {
        this.ta057 = ta057;
    }

    public String getTa058() {
        return ta058;
    }

    public void setTa058(String ta058) {
        this.ta058 = ta058;
    }

    public BigDecimal getTa059() {
        return ta059;
    }

    public void setTa059(BigDecimal ta059) {
        this.ta059 = ta059;
    }

    public String getTa060() {
        return ta060;
    }

    public void setTa060(String ta060) {
        this.ta060 = ta060;
    }

    public String getTa061() {
        return ta061;
    }

    public void setTa061(String ta061) {
        this.ta061 = ta061;
    }

    public String getTa062() {
        return ta062;
    }

    public void setTa062(String ta062) {
        this.ta062 = ta062;
    }

    public BigDecimal getTa063() {
        return ta063;
    }

    public void setTa063(BigDecimal ta063) {
        this.ta063 = ta063;
    }

    public BigDecimal getTa064() {
        return ta064;
    }

    public void setTa064(BigDecimal ta064) {
        this.ta064 = ta064;
    }

    public BigDecimal getTa065() {
        return ta065;
    }

    public void setTa065(BigDecimal ta065) {
        this.ta065 = ta065;
    }

    public BigDecimal getTa066() {
        return ta066;
    }

    public void setTa066(BigDecimal ta066) {
        this.ta066 = ta066;
    }

    public BigDecimal getTa067() {
        return ta067;
    }

    public void setTa067(BigDecimal ta067) {
        this.ta067 = ta067;
    }

    public String getTa068() {
        return ta068;
    }

    public void setTa068(String ta068) {
        this.ta068 = ta068;
    }

    public String getTa069() {
        return ta069;
    }

    public void setTa069(String ta069) {
        this.ta069 = ta069;
    }

    public String getTa070() {
        return ta070;
    }

    public void setTa070(String ta070) {
        this.ta070 = ta070;
    }

    public String getTa071() {
        return ta071;
    }

    public void setTa071(String ta071) {
        this.ta071 = ta071;
    }

    public String getTa072() {
        return ta072;
    }

    public void setTa072(String ta072) {
        this.ta072 = ta072;
    }

    public String getTa073() {
        return ta073;
    }

    public void setTa073(String ta073) {
        this.ta073 = ta073;
    }

    public String getTa074() {
        return ta074;
    }

    public void setTa074(String ta074) {
        this.ta074 = ta074;
    }

    public BigDecimal getTa075() {
        return ta075;
    }

    public void setTa075(BigDecimal ta075) {
        this.ta075 = ta075;
    }

    public BigDecimal getTa076() {
        return ta076;
    }

    public void setTa076(BigDecimal ta076) {
        this.ta076 = ta076;
    }

    public String getTa077() {
        return ta077;
    }

    public void setTa077(String ta077) {
        this.ta077 = ta077;
    }

    public String getTa078() {
        return ta078;
    }

    public void setTa078(String ta078) {
        this.ta078 = ta078;
    }

    public String getTa079() {
        return ta079;
    }

    public void setTa079(String ta079) {
        this.ta079 = ta079;
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

    public String getTa080() {
        return ta080;
    }

    public void setTa080(String ta080) {
        this.ta080 = ta080;
    }

    public String getTa081() {
        return ta081;
    }

    public void setTa081(String ta081) {
        this.ta081 = ta081;
    }

    public String getTa197() {
        return ta197;
    }

    public void setTa197(String ta197) {
        this.ta197 = ta197;
    }

    public String getTa198() {
        return ta198;
    }

    public void setTa198(String ta198) {
        this.ta198 = ta198;
    }

    public String getTa199() {
        return ta199;
    }

    public void setTa199(String ta199) {
        this.ta199 = ta199;
    }

    public String getTa082() {
        return ta082;
    }

    public void setTa082(String ta082) {
        this.ta082 = ta082;
    }

    public String getTa083() {
        return ta083;
    }

    public void setTa083(String ta083) {
        this.ta083 = ta083;
    }

    public String getTa084() {
        return ta084;
    }

    public void setTa084(String ta084) {
        this.ta084 = ta084;
    }

    public String getTa085() {
        return ta085;
    }

    public void setTa085(String ta085) {
        this.ta085 = ta085;
    }

    public String getTa086() {
        return ta086;
    }

    public void setTa086(String ta086) {
        this.ta086 = ta086;
    }

    public String getTa087() {
        return ta087;
    }

    public void setTa087(String ta087) {
        this.ta087 = ta087;
    }

    public String getTa088() {
        return ta088;
    }

    public void setTa088(String ta088) {
        this.ta088 = ta088;
    }

    public String getTa089() {
        return ta089;
    }

    public void setTa089(String ta089) {
        this.ta089 = ta089;
    }

    public Short getTa090() {
        return ta090;
    }

    public void setTa090(Short ta090) {
        this.ta090 = ta090;
    }

    public String getRepta01() {
        return repta01;
    }

    public void setRepta01(String repta01) {
        this.repta01 = repta01;
    }

    public String getRepta02() {
        return repta02;
    }

    public void setRepta02(String repta02) {
        this.repta02 = repta02;
    }

    public String getRepta03() {
        return repta03;
    }

    public void setRepta03(String repta03) {
        this.repta03 = repta03;
    }

    public String getRepta04() {
        return repta04;
    }

    public void setRepta04(String repta04) {
        this.repta04 = repta04;
    }

    public String getRepta05() {
        return repta05;
    }

    public void setRepta05(String repta05) {
        this.repta05 = repta05;
    }

    public String getRepta06() {
        return repta06;
    }

    public void setRepta06(String repta06) {
        this.repta06 = repta06;
    }

    public String getRepta07() {
        return repta07;
    }

    public void setRepta07(String repta07) {
        this.repta07 = repta07;
    }

    public String getRepta08() {
        return repta08;
    }

    public void setRepta08(String repta08) {
        this.repta08 = repta08;
    }

    public String getRepta09() {
        return repta09;
    }

    public void setRepta09(String repta09) {
        this.repta09 = repta09;
    }

    public String getRepta10() {
        return repta10;
    }

    public void setRepta10(String repta10) {
        this.repta10 = repta10;
    }

    public String getRepta11() {
        return repta11;
    }

    public void setRepta11(String repta11) {
        this.repta11 = repta11;
    }

    public String getRepta12() {
        return repta12;
    }

    public void setRepta12(String repta12) {
        this.repta12 = repta12;
    }

    public String getRepta13() {
        return repta13;
    }

    public void setRepta13(String repta13) {
        this.repta13 = repta13;
    }

    public String getRepta14() {
        return repta14;
    }

    public void setRepta14(String repta14) {
        this.repta14 = repta14;
    }

    public String getRepta15() {
        return repta15;
    }

    public void setRepta15(String repta15) {
        this.repta15 = repta15;
    }

    public String getRepta16() {
        return repta16;
    }

    public void setRepta16(String repta16) {
        this.repta16 = repta16;
    }

    public String getRepta17() {
        return repta17;
    }

    public void setRepta17(String repta17) {
        this.repta17 = repta17;
    }

    public String getRepta18() {
        return repta18;
    }

    public void setRepta18(String repta18) {
        this.repta18 = repta18;
    }

    public String getRepta19() {
        return repta19;
    }

    public void setRepta19(String repta19) {
        this.repta19 = repta19;
    }

    public String getRepta20() {
        return repta20;
    }

    public void setRepta20(String repta20) {
        this.repta20 = repta20;
    }

    public String getTa091() {
        return ta091;
    }

    public void setTa091(String ta091) {
        this.ta091 = ta091;
    }

    public String getTa092() {
        return ta092;
    }

    public void setTa092(String ta092) {
        this.ta092 = ta092;
    }

    public String getTa093() {
        return ta093;
    }

    public void setTa093(String ta093) {
        this.ta093 = ta093;
    }

    public String getTa094() {
        return ta094;
    }

    public void setTa094(String ta094) {
        this.ta094 = ta094;
    }

    public String getTa500() {
        return ta500;
    }

    public void setTa500(String ta500) {
        this.ta500 = ta500;
    }

    public String getTa095() {
        return ta095;
    }

    public void setTa095(String ta095) {
        this.ta095 = ta095;
    }

    public String getTa096() {
        return ta096;
    }

    public void setTa096(String ta096) {
        this.ta096 = ta096;
    }

    public String getTa097() {
        return ta097;
    }

    public void setTa097(String ta097) {
        this.ta097 = ta097;
    }

    public String getTa098() {
        return ta098;
    }

    public void setTa098(String ta098) {
        this.ta098 = ta098;
    }

    public String getTa099() {
        return ta099;
    }

    public void setTa099(String ta099) {
        this.ta099 = ta099;
    }

    public String getTa100() {
        return ta100;
    }

    public void setTa100(String ta100) {
        this.ta100 = ta100;
    }

    public String getTa101() {
        return ta101;
    }

    public void setTa101(String ta101) {
        this.ta101 = ta101;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPTAPK != null ? rEPTAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTA)) {
            return false;
        }
        REPTA other = (REPTA) object;
        if ((this.rEPTAPK == null && other.rEPTAPK != null) || (this.rEPTAPK != null && !this.rEPTAPK.equals(other.rEPTAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPTA[ rEPTAPK=" + rEPTAPK + " ]";
    }

}
