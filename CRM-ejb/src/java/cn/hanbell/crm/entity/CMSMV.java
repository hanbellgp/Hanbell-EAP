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
@Table(name = "CMSMV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CMSMV.findAll", query = "SELECT c FROM CMSMV c"),
    @NamedQuery(name = "CMSMV.findByCompany", query = "SELECT c FROM CMSMV c WHERE c.company = :company"),
    @NamedQuery(name = "CMSMV.findByMv001", query = "SELECT c FROM CMSMV c WHERE c.mv001 = :mv001"),
    @NamedQuery(name = "CMSMV.findByMv002", query = "SELECT c FROM CMSMV c WHERE c.mv002 = :mv002"),
    @NamedQuery(name = "CMSMV.findByMv003", query = "SELECT c FROM CMSMV c WHERE c.mv003 = :mv003"),
    @NamedQuery(name = "CMSMV.findByMv004", query = "SELECT c FROM CMSMV c WHERE c.mv004 = :mv004"),
    @NamedQuery(name = "CMSMV.findByMv005", query = "SELECT c FROM CMSMV c WHERE c.mv005 = :mv005"),
    @NamedQuery(name = "CMSMV.findByMv006", query = "SELECT c FROM CMSMV c WHERE c.mv006 = :mv006"),
    @NamedQuery(name = "CMSMV.findByMv007", query = "SELECT c FROM CMSMV c WHERE c.mv007 = :mv007"),
    @NamedQuery(name = "CMSMV.findByMv008", query = "SELECT c FROM CMSMV c WHERE c.mv008 = :mv008"),
    @NamedQuery(name = "CMSMV.findByMv009", query = "SELECT c FROM CMSMV c WHERE c.mv009 = :mv009"),
    @NamedQuery(name = "CMSMV.findByMv010", query = "SELECT c FROM CMSMV c WHERE c.mv010 = :mv010"),
    @NamedQuery(name = "CMSMV.findByMv011", query = "SELECT c FROM CMSMV c WHERE c.mv011 = :mv011"),
    @NamedQuery(name = "CMSMV.findByMv012", query = "SELECT c FROM CMSMV c WHERE c.mv012 = :mv012"),
    @NamedQuery(name = "CMSMV.findByMv013", query = "SELECT c FROM CMSMV c WHERE c.mv013 = :mv013"),
    @NamedQuery(name = "CMSMV.findByMv014", query = "SELECT c FROM CMSMV c WHERE c.mv014 = :mv014"),
    @NamedQuery(name = "CMSMV.findByMv015", query = "SELECT c FROM CMSMV c WHERE c.mv015 = :mv015"),
    @NamedQuery(name = "CMSMV.findByMv016", query = "SELECT c FROM CMSMV c WHERE c.mv016 = :mv016"),
    @NamedQuery(name = "CMSMV.findByMv017", query = "SELECT c FROM CMSMV c WHERE c.mv017 = :mv017"),
    @NamedQuery(name = "CMSMV.findByMv018", query = "SELECT c FROM CMSMV c WHERE c.mv018 = :mv018"),
    @NamedQuery(name = "CMSMV.findByMv019", query = "SELECT c FROM CMSMV c WHERE c.mv019 = :mv019"),
    @NamedQuery(name = "CMSMV.findByMv020", query = "SELECT c FROM CMSMV c WHERE c.mv020 = :mv020"),
    @NamedQuery(name = "CMSMV.findByMv021", query = "SELECT c FROM CMSMV c WHERE c.mv021 = :mv021"),
    @NamedQuery(name = "CMSMV.findByMv022", query = "SELECT c FROM CMSMV c WHERE c.mv022 = :mv022"),
    @NamedQuery(name = "CMSMV.findByMv023", query = "SELECT c FROM CMSMV c WHERE c.mv023 = :mv023"),
    @NamedQuery(name = "CMSMV.findByMv024", query = "SELECT c FROM CMSMV c WHERE c.mv024 = :mv024"),
    @NamedQuery(name = "CMSMV.findByMv025", query = "SELECT c FROM CMSMV c WHERE c.mv025 = :mv025"),
    @NamedQuery(name = "CMSMV.findByMv026", query = "SELECT c FROM CMSMV c WHERE c.mv026 = :mv026"),
    @NamedQuery(name = "CMSMV.findByMv027", query = "SELECT c FROM CMSMV c WHERE c.mv027 = :mv027"),
    @NamedQuery(name = "CMSMV.findByMv028", query = "SELECT c FROM CMSMV c WHERE c.mv028 = :mv028"),
    @NamedQuery(name = "CMSMV.findByMv029", query = "SELECT c FROM CMSMV c WHERE c.mv029 = :mv029"),
    @NamedQuery(name = "CMSMV.findByMv030", query = "SELECT c FROM CMSMV c WHERE c.mv030 = :mv030"),
    @NamedQuery(name = "CMSMV.findByMv031", query = "SELECT c FROM CMSMV c WHERE c.mv031 = :mv031"),
    @NamedQuery(name = "CMSMV.findByMv032", query = "SELECT c FROM CMSMV c WHERE c.mv032 = :mv032"),
    @NamedQuery(name = "CMSMV.findByMv033", query = "SELECT c FROM CMSMV c WHERE c.mv033 = :mv033"),
    @NamedQuery(name = "CMSMV.findByMv034", query = "SELECT c FROM CMSMV c WHERE c.mv034 = :mv034"),
    @NamedQuery(name = "CMSMV.findByMv035", query = "SELECT c FROM CMSMV c WHERE c.mv035 = :mv035"),
    @NamedQuery(name = "CMSMV.findByMv036", query = "SELECT c FROM CMSMV c WHERE c.mv036 = :mv036"),
    @NamedQuery(name = "CMSMV.findByMv037", query = "SELECT c FROM CMSMV c WHERE c.mv037 = :mv037"),
    @NamedQuery(name = "CMSMV.findByMv038", query = "SELECT c FROM CMSMV c WHERE c.mv038 = :mv038"),
    @NamedQuery(name = "CMSMV.findByMv039", query = "SELECT c FROM CMSMV c WHERE c.mv039 = :mv039"),
    @NamedQuery(name = "CMSMV.findByMv040", query = "SELECT c FROM CMSMV c WHERE c.mv040 = :mv040"),
    @NamedQuery(name = "CMSMV.findByMv041", query = "SELECT c FROM CMSMV c WHERE c.mv041 = :mv041"),
    @NamedQuery(name = "CMSMV.findByMv042", query = "SELECT c FROM CMSMV c WHERE c.mv042 = :mv042"),
    @NamedQuery(name = "CMSMV.findByMv043", query = "SELECT c FROM CMSMV c WHERE c.mv043 = :mv043"),
    @NamedQuery(name = "CMSMV.findByMv044", query = "SELECT c FROM CMSMV c WHERE c.mv044 = :mv044"),
    @NamedQuery(name = "CMSMV.findByMv045", query = "SELECT c FROM CMSMV c WHERE c.mv045 = :mv045"),
    @NamedQuery(name = "CMSMV.findByMv046", query = "SELECT c FROM CMSMV c WHERE c.mv046 = :mv046"),
    @NamedQuery(name = "CMSMV.findByMv047", query = "SELECT c FROM CMSMV c WHERE c.mv047 = :mv047"),
    @NamedQuery(name = "CMSMV.findByMv048", query = "SELECT c FROM CMSMV c WHERE c.mv048 = :mv048"),
    @NamedQuery(name = "CMSMV.findByMv049", query = "SELECT c FROM CMSMV c WHERE c.mv049 = :mv049"),
    @NamedQuery(name = "CMSMV.findByMv050", query = "SELECT c FROM CMSMV c WHERE c.mv050 = :mv050"),
    @NamedQuery(name = "CMSMV.findByMv051", query = "SELECT c FROM CMSMV c WHERE c.mv051 = :mv051"),
    @NamedQuery(name = "CMSMV.findByMv052", query = "SELECT c FROM CMSMV c WHERE c.mv052 = :mv052"),
    @NamedQuery(name = "CMSMV.findByMv053", query = "SELECT c FROM CMSMV c WHERE c.mv053 = :mv053"),
    @NamedQuery(name = "CMSMV.findByMv054", query = "SELECT c FROM CMSMV c WHERE c.mv054 = :mv054"),
    @NamedQuery(name = "CMSMV.findByMv055", query = "SELECT c FROM CMSMV c WHERE c.mv055 = :mv055"),
    @NamedQuery(name = "CMSMV.findByMv056", query = "SELECT c FROM CMSMV c WHERE c.mv056 = :mv056"),
    @NamedQuery(name = "CMSMV.findByMv057", query = "SELECT c FROM CMSMV c WHERE c.mv057 = :mv057"),
    @NamedQuery(name = "CMSMV.findByMv058", query = "SELECT c FROM CMSMV c WHERE c.mv058 = :mv058"),
    @NamedQuery(name = "CMSMV.findByMv059", query = "SELECT c FROM CMSMV c WHERE c.mv059 = :mv059"),
    @NamedQuery(name = "CMSMV.findByMv060", query = "SELECT c FROM CMSMV c WHERE c.mv060 = :mv060"),
    @NamedQuery(name = "CMSMV.findByMv061", query = "SELECT c FROM CMSMV c WHERE c.mv061 = :mv061"),
    @NamedQuery(name = "CMSMV.findByMv062", query = "SELECT c FROM CMSMV c WHERE c.mv062 = :mv062"),
    @NamedQuery(name = "CMSMV.findByMv063", query = "SELECT c FROM CMSMV c WHERE c.mv063 = :mv063")})
public class CMSMV implements Serializable {

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
    @Column(name = "MV001")
    private String mv001;
    @Size(max = 30)
    @Column(name = "MV002")
    private String mv002;
    @Size(max = 10)
    @Column(name = "MV003")
    private String mv003;
    @Size(max = 10)
    @Column(name = "MV004")
    private String mv004;
    @Size(max = 10)
    @Column(name = "MV005")
    private String mv005;
    @Size(max = 10)
    @Column(name = "MV006")
    private String mv006;
    @Size(max = 1)
    @Column(name = "MV007")
    private String mv007;
    @Size(max = 8)
    @Column(name = "MV008")
    private String mv008;
    @Size(max = 50)
    @Column(name = "MV009")
    private String mv009;
    @Size(max = 1)
    @Column(name = "MV010")
    private String mv010;
    @Size(max = 1)
    @Column(name = "MV011")
    private String mv011;
    @Size(max = 8)
    @Column(name = "MV012")
    private String mv012;
    @Size(max = 80)
    @Column(name = "MV013")
    private String mv013;
    @Size(max = 1)
    @Column(name = "MV014")
    private String mv014;
    @Size(max = 20)
    @Column(name = "MV015")
    private String mv015;
    @Size(max = 20)
    @Column(name = "MV016")
    private String mv016;
    @Size(max = 255)
    @Column(name = "MV017")
    private String mv017;
    @Size(max = 6)
    @Column(name = "MV018")
    private String mv018;
    @Size(max = 255)
    @Column(name = "MV019")
    private String mv019;
    @Size(max = 60)
    @Column(name = "MV020")
    private String mv020;
    @Size(max = 8)
    @Column(name = "MV021")
    private String mv021;
    @Size(max = 8)
    @Column(name = "MV022")
    private String mv022;
    @Size(max = 8)
    @Column(name = "MV023")
    private String mv023;
    @Size(max = 1)
    @Column(name = "MV024")
    private String mv024;
    @Size(max = 10)
    @Column(name = "MV025")
    private String mv025;
    @Size(max = 1)
    @Column(name = "MV026")
    private String mv026;
    @Size(max = 3)
    @Column(name = "MV027")
    private String mv027;
    @Size(max = 10)
    @Column(name = "MV028")
    private String mv028;
    @Size(max = 10)
    @Column(name = "MV029")
    private String mv029;
    @Size(max = 10)
    @Column(name = "MV030")
    private String mv030;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MV031")
    private BigDecimal mv031;
    @Size(max = 1)
    @Column(name = "MV032")
    private String mv032;
    @Column(name = "MV033")
    private BigDecimal mv033;
    @Size(max = 1)
    @Column(name = "MV034")
    private String mv034;
    @Size(max = 10)
    @Column(name = "MV035")
    private String mv035;
    @Size(max = 30)
    @Column(name = "MV036")
    private String mv036;
    @Column(name = "MV037")
    private Short mv037;
    @Size(max = 1)
    @Column(name = "MV038")
    private String mv038;
    @Column(name = "MV039")
    private BigDecimal mv039;
    @Column(name = "MV040")
    private BigDecimal mv040;
    @Size(max = 1)
    @Column(name = "MV041")
    private String mv041;
    @Size(max = 1)
    @Column(name = "MV042")
    private String mv042;
    @Column(name = "MV043")
    private BigDecimal mv043;
    @Size(max = 1)
    @Column(name = "MV044")
    private String mv044;
    @Column(name = "MV045")
    private BigDecimal mv045;
    @Size(max = 255)
    @Column(name = "MV046")
    private String mv046;
    @Size(max = 80)
    @Column(name = "MV047")
    private String mv047;
    @Size(max = 8)
    @Column(name = "MV048")
    private String mv048;
    @Size(max = 8)
    @Column(name = "MV049")
    private String mv049;
    @Size(max = 8)
    @Column(name = "MV050")
    private String mv050;
    @Size(max = 20)
    @Column(name = "MV051")
    private String mv051;
    @Size(max = 8)
    @Column(name = "MV052")
    private String mv052;
    @Size(max = 8)
    @Column(name = "MV053")
    private String mv053;
    @Size(max = 2)
    @Column(name = "MV054")
    private String mv054;
    @Column(name = "MV055")
    private BigDecimal mv055;
    @Column(name = "MV056")
    private BigDecimal mv056;
    @Size(max = 12)
    @Column(name = "MV057")
    private String mv057;
    @Size(max = 10)
    @Column(name = "MV058")
    private String mv058;
    @Size(max = 8)
    @Column(name = "MV059")
    private String mv059;
    @Size(max = 8)
    @Column(name = "MV060")
    private String mv060;
    @Size(max = 1)
    @Column(name = "MV061")
    private String mv061;
    @Size(max = 20)
    @Column(name = "MV062")
    private String mv062;
    @Size(max = 20)
    @Column(name = "MV063")
    private String mv063;
    @Size(max = 255)
    @Column(name = "CMSMV01")
    private String cmsmv01;
    @Size(max = 255)
    @Column(name = "CMSMV02")
    private String cmsmv02;
    @Size(max = 255)
    @Column(name = "CMSMV03")
    private String cmsmv03;
    @Size(max = 255)
    @Column(name = "CMSMV04")
    private String cmsmv04;
    @Size(max = 255)
    @Column(name = "CMSMV05")
    private String cmsmv05;
    @Size(max = 255)
    @Column(name = "CMSMV06")
    private String cmsmv06;
    @Size(max = 255)
    @Column(name = "CMSMV07")
    private String cmsmv07;
    @Size(max = 255)
    @Column(name = "CMSMV08")
    private String cmsmv08;
    @Size(max = 255)
    @Column(name = "CMSMV09")
    private String cmsmv09;
    @Size(max = 255)
    @Column(name = "CMSMV10")
    private String cmsmv10;
    @Size(max = 255)
    @Column(name = "CMSMV11")
    private String cmsmv11;
    @Size(max = 255)
    @Column(name = "CMSMV12")
    private String cmsmv12;
    @Size(max = 255)
    @Column(name = "CMSMV13")
    private String cmsmv13;
    @Size(max = 255)
    @Column(name = "CMSMV14")
    private String cmsmv14;
    @Size(max = 255)
    @Column(name = "CMSMV15")
    private String cmsmv15;
    @Size(max = 255)
    @Column(name = "CMSMV16")
    private String cmsmv16;
    @Size(max = 255)
    @Column(name = "CMSMV17")
    private String cmsmv17;
    @Size(max = 255)
    @Column(name = "CMSMV18")
    private String cmsmv18;
    @Size(max = 255)
    @Column(name = "CMSMV19")
    private String cmsmv19;
    @Size(max = 255)
    @Column(name = "CMSMV20")
    private String cmsmv20;
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
    @Size(max = 6)
    @Column(name = "MV064")
    private String mv064;
    @Size(max = 10)
    @Column(name = "MV065")
    private String mv065;
    @Size(max = 6)
    @Column(name = "MV066")
    private String mv066;
    @Size(max = 6)
    @Column(name = "MV067")
    private String mv067;
    @Size(max = 10)
    @Column(name = "MV068")
    private String mv068;
    @Size(max = 80)
    @Column(name = "MV069")
    private String mv069;
    @Size(max = 1)
    @Column(name = "MV070")
    private String mv070;
    @Column(name = "MV071")
    private BigDecimal mv071;
    @Size(max = 1)
    @Column(name = "MV072")
    private String mv072;
    @Size(max = 1)
    @Column(name = "MV073")
    private String mv073;
    @Size(max = 1)
    @Column(name = "MV074")
    private String mv074;
    @Size(max = 1)
    @Column(name = "MV075")
    private String mv075;
    @Column(name = "MV076")
    private BigDecimal mv076;
    @Size(max = 8)
    @Column(name = "MV077")
    private String mv077;
    @Column(name = "MV078")
    private BigDecimal mv078;
    @Column(name = "MV079")
    private BigDecimal mv079;
    @Column(name = "MV080")
    private Short mv080;
    @Size(max = 10)
    @Column(name = "MV081")
    private String mv081;
    @Column(name = "MV082")
    private BigDecimal mv082;
    @Column(name = "MV083")
    private BigDecimal mv083;
    @Size(max = 1)
    @Column(name = "MV084")
    private String mv084;
    @Size(max = 30)
    @Column(name = "MV085")
    private String mv085;
    @Size(max = 60)
    @Column(name = "MV086")
    private String mv086;
    @Size(max = 8)
    @Column(name = "MV087")
    private String mv087;
    @Size(max = 12)
    @Column(name = "MV088")
    private String mv088;
    @Size(max = 255)
    @Column(name = "MV089")
    private String mv089;
    @Size(max = 1)
    @Column(name = "MV090")
    private String mv090;
    @Size(max = 12)
    @Column(name = "MV091")
    private String mv091;
    @Size(max = 1)
    @Column(name = "MV092")
    private String mv092;
    @Size(max = 10)
    @Column(name = "MV093")
    private String mv093;
    @Size(max = 10)
    @Column(name = "MV094")
    private String mv094;
    @Size(max = 10)
    @Column(name = "MV095")
    private String mv095;
    @Size(max = 10)
    @Column(name = "MV096")
    private String mv096;
    @Size(max = 1)
    @Column(name = "MV097")
    private String mv097;
    @Size(max = 8)
    @Column(name = "MV098")
    private String mv098;
    @Size(max = 40)
    @Column(name = "MV099")
    private String mv099;
    @Size(max = 4)
    @Column(name = "MV100")
    private String mv100;
    @Size(max = 20)
    @Column(name = "MV101")
    private String mv101;
    @Size(max = 4)
    @Column(name = "MV102")
    private String mv102;
    @Size(max = 1)
    @Column(name = "MV103")
    private String mv103;
    @Column(name = "MV104")
    private BigDecimal mv104;
    @Size(max = 1)
    @Column(name = "MV105")
    private String mv105;
    @Size(max = 1)
    @Column(name = "MV106")
    private String mv106;
    @Size(max = 1)
    @Column(name = "MV107")
    private String mv107;
    @Size(max = 1)
    @Column(name = "MV108")
    private String mv108;
    @Size(max = 1)
    @Column(name = "MV109")
    private String mv109;
    @Size(max = 8)
    @Column(name = "MV110")
    private String mv110;
    @Size(max = 1)
    @Column(name = "MV111")
    private String mv111;
    @Size(max = 1)
    @Column(name = "MV112")
    private String mv112;
    @Size(max = 1)
    @Column(name = "MV113")
    private String mv113;
    @Size(max = 1)
    @Column(name = "MV114")
    private String mv114;
    @Size(max = 1)
    @Column(name = "MV115")
    private String mv115;
    @Size(max = 1)
    @Column(name = "MV116")
    private String mv116;
    @Size(max = 1)
    @Column(name = "MV117")
    private String mv117;
    @Size(max = 1)
    @Column(name = "MV118")
    private String mv118;
    @Size(max = 1)
    @Column(name = "MV119")
    private String mv119;
    @Size(max = 1)
    @Column(name = "MV120")
    private String mv120;

    public CMSMV() {
    }

    public CMSMV(String mv001) {
        this.mv001 = mv001;
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

    public String getMv001() {
        return mv001;
    }

    public void setMv001(String mv001) {
        this.mv001 = mv001;
    }

    public String getMv002() {
        return mv002;
    }

    public void setMv002(String mv002) {
        this.mv002 = mv002;
    }

    public String getMv003() {
        return mv003;
    }

    public void setMv003(String mv003) {
        this.mv003 = mv003;
    }

    public String getMv004() {
        return mv004;
    }

    public void setMv004(String mv004) {
        this.mv004 = mv004;
    }

    public String getMv005() {
        return mv005;
    }

    public void setMv005(String mv005) {
        this.mv005 = mv005;
    }

    public String getMv006() {
        return mv006;
    }

    public void setMv006(String mv006) {
        this.mv006 = mv006;
    }

    public String getMv007() {
        return mv007;
    }

    public void setMv007(String mv007) {
        this.mv007 = mv007;
    }

    public String getMv008() {
        return mv008;
    }

    public void setMv008(String mv008) {
        this.mv008 = mv008;
    }

    public String getMv009() {
        return mv009;
    }

    public void setMv009(String mv009) {
        this.mv009 = mv009;
    }

    public String getMv010() {
        return mv010;
    }

    public void setMv010(String mv010) {
        this.mv010 = mv010;
    }

    public String getMv011() {
        return mv011;
    }

    public void setMv011(String mv011) {
        this.mv011 = mv011;
    }

    public String getMv012() {
        return mv012;
    }

    public void setMv012(String mv012) {
        this.mv012 = mv012;
    }

    public String getMv013() {
        return mv013;
    }

    public void setMv013(String mv013) {
        this.mv013 = mv013;
    }

    public String getMv014() {
        return mv014;
    }

    public void setMv014(String mv014) {
        this.mv014 = mv014;
    }

    public String getMv015() {
        return mv015;
    }

    public void setMv015(String mv015) {
        this.mv015 = mv015;
    }

    public String getMv016() {
        return mv016;
    }

    public void setMv016(String mv016) {
        this.mv016 = mv016;
    }

    public String getMv017() {
        return mv017;
    }

    public void setMv017(String mv017) {
        this.mv017 = mv017;
    }

    public String getMv018() {
        return mv018;
    }

    public void setMv018(String mv018) {
        this.mv018 = mv018;
    }

    public String getMv019() {
        return mv019;
    }

    public void setMv019(String mv019) {
        this.mv019 = mv019;
    }

    public String getMv020() {
        return mv020;
    }

    public void setMv020(String mv020) {
        this.mv020 = mv020;
    }

    public String getMv021() {
        return mv021;
    }

    public void setMv021(String mv021) {
        this.mv021 = mv021;
    }

    public String getMv022() {
        return mv022;
    }

    public void setMv022(String mv022) {
        this.mv022 = mv022;
    }

    public String getMv023() {
        return mv023;
    }

    public void setMv023(String mv023) {
        this.mv023 = mv023;
    }

    public String getMv024() {
        return mv024;
    }

    public void setMv024(String mv024) {
        this.mv024 = mv024;
    }

    public String getMv025() {
        return mv025;
    }

    public void setMv025(String mv025) {
        this.mv025 = mv025;
    }

    public String getMv026() {
        return mv026;
    }

    public void setMv026(String mv026) {
        this.mv026 = mv026;
    }

    public String getMv027() {
        return mv027;
    }

    public void setMv027(String mv027) {
        this.mv027 = mv027;
    }

    public String getMv028() {
        return mv028;
    }

    public void setMv028(String mv028) {
        this.mv028 = mv028;
    }

    public String getMv029() {
        return mv029;
    }

    public void setMv029(String mv029) {
        this.mv029 = mv029;
    }

    public String getMv030() {
        return mv030;
    }

    public void setMv030(String mv030) {
        this.mv030 = mv030;
    }

    public BigDecimal getMv031() {
        return mv031;
    }

    public void setMv031(BigDecimal mv031) {
        this.mv031 = mv031;
    }

    public String getMv032() {
        return mv032;
    }

    public void setMv032(String mv032) {
        this.mv032 = mv032;
    }

    public BigDecimal getMv033() {
        return mv033;
    }

    public void setMv033(BigDecimal mv033) {
        this.mv033 = mv033;
    }

    public String getMv034() {
        return mv034;
    }

    public void setMv034(String mv034) {
        this.mv034 = mv034;
    }

    public String getMv035() {
        return mv035;
    }

    public void setMv035(String mv035) {
        this.mv035 = mv035;
    }

    public String getMv036() {
        return mv036;
    }

    public void setMv036(String mv036) {
        this.mv036 = mv036;
    }

    public Short getMv037() {
        return mv037;
    }

    public void setMv037(Short mv037) {
        this.mv037 = mv037;
    }

    public String getMv038() {
        return mv038;
    }

    public void setMv038(String mv038) {
        this.mv038 = mv038;
    }

    public BigDecimal getMv039() {
        return mv039;
    }

    public void setMv039(BigDecimal mv039) {
        this.mv039 = mv039;
    }

    public BigDecimal getMv040() {
        return mv040;
    }

    public void setMv040(BigDecimal mv040) {
        this.mv040 = mv040;
    }

    public String getMv041() {
        return mv041;
    }

    public void setMv041(String mv041) {
        this.mv041 = mv041;
    }

    public String getMv042() {
        return mv042;
    }

    public void setMv042(String mv042) {
        this.mv042 = mv042;
    }

    public BigDecimal getMv043() {
        return mv043;
    }

    public void setMv043(BigDecimal mv043) {
        this.mv043 = mv043;
    }

    public String getMv044() {
        return mv044;
    }

    public void setMv044(String mv044) {
        this.mv044 = mv044;
    }

    public BigDecimal getMv045() {
        return mv045;
    }

    public void setMv045(BigDecimal mv045) {
        this.mv045 = mv045;
    }

    public String getMv046() {
        return mv046;
    }

    public void setMv046(String mv046) {
        this.mv046 = mv046;
    }

    public String getMv047() {
        return mv047;
    }

    public void setMv047(String mv047) {
        this.mv047 = mv047;
    }

    public String getMv048() {
        return mv048;
    }

    public void setMv048(String mv048) {
        this.mv048 = mv048;
    }

    public String getMv049() {
        return mv049;
    }

    public void setMv049(String mv049) {
        this.mv049 = mv049;
    }

    public String getMv050() {
        return mv050;
    }

    public void setMv050(String mv050) {
        this.mv050 = mv050;
    }

    public String getMv051() {
        return mv051;
    }

    public void setMv051(String mv051) {
        this.mv051 = mv051;
    }

    public String getMv052() {
        return mv052;
    }

    public void setMv052(String mv052) {
        this.mv052 = mv052;
    }

    public String getMv053() {
        return mv053;
    }

    public void setMv053(String mv053) {
        this.mv053 = mv053;
    }

    public String getMv054() {
        return mv054;
    }

    public void setMv054(String mv054) {
        this.mv054 = mv054;
    }

    public BigDecimal getMv055() {
        return mv055;
    }

    public void setMv055(BigDecimal mv055) {
        this.mv055 = mv055;
    }

    public BigDecimal getMv056() {
        return mv056;
    }

    public void setMv056(BigDecimal mv056) {
        this.mv056 = mv056;
    }

    public String getMv057() {
        return mv057;
    }

    public void setMv057(String mv057) {
        this.mv057 = mv057;
    }

    public String getMv058() {
        return mv058;
    }

    public void setMv058(String mv058) {
        this.mv058 = mv058;
    }

    public String getMv059() {
        return mv059;
    }

    public void setMv059(String mv059) {
        this.mv059 = mv059;
    }

    public String getMv060() {
        return mv060;
    }

    public void setMv060(String mv060) {
        this.mv060 = mv060;
    }

    public String getMv061() {
        return mv061;
    }

    public void setMv061(String mv061) {
        this.mv061 = mv061;
    }

    public String getMv062() {
        return mv062;
    }

    public void setMv062(String mv062) {
        this.mv062 = mv062;
    }

    public String getMv063() {
        return mv063;
    }

    public void setMv063(String mv063) {
        this.mv063 = mv063;
    }

    public String getCmsmv01() {
        return cmsmv01;
    }

    public void setCmsmv01(String cmsmv01) {
        this.cmsmv01 = cmsmv01;
    }

    public String getCmsmv02() {
        return cmsmv02;
    }

    public void setCmsmv02(String cmsmv02) {
        this.cmsmv02 = cmsmv02;
    }

    public String getCmsmv03() {
        return cmsmv03;
    }

    public void setCmsmv03(String cmsmv03) {
        this.cmsmv03 = cmsmv03;
    }

    public String getCmsmv04() {
        return cmsmv04;
    }

    public void setCmsmv04(String cmsmv04) {
        this.cmsmv04 = cmsmv04;
    }

    public String getCmsmv05() {
        return cmsmv05;
    }

    public void setCmsmv05(String cmsmv05) {
        this.cmsmv05 = cmsmv05;
    }

    public String getCmsmv06() {
        return cmsmv06;
    }

    public void setCmsmv06(String cmsmv06) {
        this.cmsmv06 = cmsmv06;
    }

    public String getCmsmv07() {
        return cmsmv07;
    }

    public void setCmsmv07(String cmsmv07) {
        this.cmsmv07 = cmsmv07;
    }

    public String getCmsmv08() {
        return cmsmv08;
    }

    public void setCmsmv08(String cmsmv08) {
        this.cmsmv08 = cmsmv08;
    }

    public String getCmsmv09() {
        return cmsmv09;
    }

    public void setCmsmv09(String cmsmv09) {
        this.cmsmv09 = cmsmv09;
    }

    public String getCmsmv10() {
        return cmsmv10;
    }

    public void setCmsmv10(String cmsmv10) {
        this.cmsmv10 = cmsmv10;
    }

    public String getCmsmv11() {
        return cmsmv11;
    }

    public void setCmsmv11(String cmsmv11) {
        this.cmsmv11 = cmsmv11;
    }

    public String getCmsmv12() {
        return cmsmv12;
    }

    public void setCmsmv12(String cmsmv12) {
        this.cmsmv12 = cmsmv12;
    }

    public String getCmsmv13() {
        return cmsmv13;
    }

    public void setCmsmv13(String cmsmv13) {
        this.cmsmv13 = cmsmv13;
    }

    public String getCmsmv14() {
        return cmsmv14;
    }

    public void setCmsmv14(String cmsmv14) {
        this.cmsmv14 = cmsmv14;
    }

    public String getCmsmv15() {
        return cmsmv15;
    }

    public void setCmsmv15(String cmsmv15) {
        this.cmsmv15 = cmsmv15;
    }

    public String getCmsmv16() {
        return cmsmv16;
    }

    public void setCmsmv16(String cmsmv16) {
        this.cmsmv16 = cmsmv16;
    }

    public String getCmsmv17() {
        return cmsmv17;
    }

    public void setCmsmv17(String cmsmv17) {
        this.cmsmv17 = cmsmv17;
    }

    public String getCmsmv18() {
        return cmsmv18;
    }

    public void setCmsmv18(String cmsmv18) {
        this.cmsmv18 = cmsmv18;
    }

    public String getCmsmv19() {
        return cmsmv19;
    }

    public void setCmsmv19(String cmsmv19) {
        this.cmsmv19 = cmsmv19;
    }

    public String getCmsmv20() {
        return cmsmv20;
    }

    public void setCmsmv20(String cmsmv20) {
        this.cmsmv20 = cmsmv20;
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

    public String getMv064() {
        return mv064;
    }

    public void setMv064(String mv064) {
        this.mv064 = mv064;
    }

    public String getMv065() {
        return mv065;
    }

    public void setMv065(String mv065) {
        this.mv065 = mv065;
    }

    public String getMv066() {
        return mv066;
    }

    public void setMv066(String mv066) {
        this.mv066 = mv066;
    }

    public String getMv067() {
        return mv067;
    }

    public void setMv067(String mv067) {
        this.mv067 = mv067;
    }

    public String getMv068() {
        return mv068;
    }

    public void setMv068(String mv068) {
        this.mv068 = mv068;
    }

    public String getMv069() {
        return mv069;
    }

    public void setMv069(String mv069) {
        this.mv069 = mv069;
    }

    public String getMv070() {
        return mv070;
    }

    public void setMv070(String mv070) {
        this.mv070 = mv070;
    }

    public BigDecimal getMv071() {
        return mv071;
    }

    public void setMv071(BigDecimal mv071) {
        this.mv071 = mv071;
    }

    public String getMv072() {
        return mv072;
    }

    public void setMv072(String mv072) {
        this.mv072 = mv072;
    }

    public String getMv073() {
        return mv073;
    }

    public void setMv073(String mv073) {
        this.mv073 = mv073;
    }

    public String getMv074() {
        return mv074;
    }

    public void setMv074(String mv074) {
        this.mv074 = mv074;
    }

    public String getMv075() {
        return mv075;
    }

    public void setMv075(String mv075) {
        this.mv075 = mv075;
    }

    public BigDecimal getMv076() {
        return mv076;
    }

    public void setMv076(BigDecimal mv076) {
        this.mv076 = mv076;
    }

    public String getMv077() {
        return mv077;
    }

    public void setMv077(String mv077) {
        this.mv077 = mv077;
    }

    public BigDecimal getMv078() {
        return mv078;
    }

    public void setMv078(BigDecimal mv078) {
        this.mv078 = mv078;
    }

    public BigDecimal getMv079() {
        return mv079;
    }

    public void setMv079(BigDecimal mv079) {
        this.mv079 = mv079;
    }

    public Short getMv080() {
        return mv080;
    }

    public void setMv080(Short mv080) {
        this.mv080 = mv080;
    }

    public String getMv081() {
        return mv081;
    }

    public void setMv081(String mv081) {
        this.mv081 = mv081;
    }

    public BigDecimal getMv082() {
        return mv082;
    }

    public void setMv082(BigDecimal mv082) {
        this.mv082 = mv082;
    }

    public BigDecimal getMv083() {
        return mv083;
    }

    public void setMv083(BigDecimal mv083) {
        this.mv083 = mv083;
    }

    public String getMv084() {
        return mv084;
    }

    public void setMv084(String mv084) {
        this.mv084 = mv084;
    }

    public String getMv085() {
        return mv085;
    }

    public void setMv085(String mv085) {
        this.mv085 = mv085;
    }

    public String getMv086() {
        return mv086;
    }

    public void setMv086(String mv086) {
        this.mv086 = mv086;
    }

    public String getMv087() {
        return mv087;
    }

    public void setMv087(String mv087) {
        this.mv087 = mv087;
    }

    public String getMv088() {
        return mv088;
    }

    public void setMv088(String mv088) {
        this.mv088 = mv088;
    }

    public String getMv089() {
        return mv089;
    }

    public void setMv089(String mv089) {
        this.mv089 = mv089;
    }

    public String getMv090() {
        return mv090;
    }

    public void setMv090(String mv090) {
        this.mv090 = mv090;
    }

    public String getMv091() {
        return mv091;
    }

    public void setMv091(String mv091) {
        this.mv091 = mv091;
    }

    public String getMv092() {
        return mv092;
    }

    public void setMv092(String mv092) {
        this.mv092 = mv092;
    }

    public String getMv093() {
        return mv093;
    }

    public void setMv093(String mv093) {
        this.mv093 = mv093;
    }

    public String getMv094() {
        return mv094;
    }

    public void setMv094(String mv094) {
        this.mv094 = mv094;
    }

    public String getMv095() {
        return mv095;
    }

    public void setMv095(String mv095) {
        this.mv095 = mv095;
    }

    public String getMv096() {
        return mv096;
    }

    public void setMv096(String mv096) {
        this.mv096 = mv096;
    }

    public String getMv097() {
        return mv097;
    }

    public void setMv097(String mv097) {
        this.mv097 = mv097;
    }

    public String getMv098() {
        return mv098;
    }

    public void setMv098(String mv098) {
        this.mv098 = mv098;
    }

    public String getMv099() {
        return mv099;
    }

    public void setMv099(String mv099) {
        this.mv099 = mv099;
    }

    public String getMv100() {
        return mv100;
    }

    public void setMv100(String mv100) {
        this.mv100 = mv100;
    }

    public String getMv101() {
        return mv101;
    }

    public void setMv101(String mv101) {
        this.mv101 = mv101;
    }

    public String getMv102() {
        return mv102;
    }

    public void setMv102(String mv102) {
        this.mv102 = mv102;
    }

    public String getMv103() {
        return mv103;
    }

    public void setMv103(String mv103) {
        this.mv103 = mv103;
    }

    public BigDecimal getMv104() {
        return mv104;
    }

    public void setMv104(BigDecimal mv104) {
        this.mv104 = mv104;
    }

    public String getMv105() {
        return mv105;
    }

    public void setMv105(String mv105) {
        this.mv105 = mv105;
    }

    public String getMv106() {
        return mv106;
    }

    public void setMv106(String mv106) {
        this.mv106 = mv106;
    }

    public String getMv107() {
        return mv107;
    }

    public void setMv107(String mv107) {
        this.mv107 = mv107;
    }

    public String getMv108() {
        return mv108;
    }

    public void setMv108(String mv108) {
        this.mv108 = mv108;
    }

    public String getMv109() {
        return mv109;
    }

    public void setMv109(String mv109) {
        this.mv109 = mv109;
    }

    public String getMv110() {
        return mv110;
    }

    public void setMv110(String mv110) {
        this.mv110 = mv110;
    }

    public String getMv111() {
        return mv111;
    }

    public void setMv111(String mv111) {
        this.mv111 = mv111;
    }

    public String getMv112() {
        return mv112;
    }

    public void setMv112(String mv112) {
        this.mv112 = mv112;
    }

    public String getMv113() {
        return mv113;
    }

    public void setMv113(String mv113) {
        this.mv113 = mv113;
    }

    public String getMv114() {
        return mv114;
    }

    public void setMv114(String mv114) {
        this.mv114 = mv114;
    }

    public String getMv115() {
        return mv115;
    }

    public void setMv115(String mv115) {
        this.mv115 = mv115;
    }

    public String getMv116() {
        return mv116;
    }

    public void setMv116(String mv116) {
        this.mv116 = mv116;
    }

    public String getMv117() {
        return mv117;
    }

    public void setMv117(String mv117) {
        this.mv117 = mv117;
    }

    public String getMv118() {
        return mv118;
    }

    public void setMv118(String mv118) {
        this.mv118 = mv118;
    }

    public String getMv119() {
        return mv119;
    }

    public void setMv119(String mv119) {
        this.mv119 = mv119;
    }

    public String getMv120() {
        return mv120;
    }

    public void setMv120(String mv120) {
        this.mv120 = mv120;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mv001 != null ? mv001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMSMV)) {
            return false;
        }
        CMSMV other = (CMSMV) object;
        if ((this.mv001 == null && other.mv001 != null) || (this.mv001 != null && !this.mv001.equals(other.mv001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CMSMV[ mv001=" + mv001 + " ]";
    }

}
