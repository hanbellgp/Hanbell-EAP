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
@Table(name = "REPTM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPTM.findAll", query = "SELECT r FROM REPTM r"),
    @NamedQuery(name = "REPTM.findByCompany", query = "SELECT r FROM REPTM r WHERE r.company = :company"),
    @NamedQuery(name = "REPTM.findByCreator", query = "SELECT r FROM REPTM r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPTM.findByUsrGroup", query = "SELECT r FROM REPTM r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPTM.findByCreateDate", query = "SELECT r FROM REPTM r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPTM.findByModifier", query = "SELECT r FROM REPTM r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPTM.findByModiDate", query = "SELECT r FROM REPTM r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPTM.findByFlag", query = "SELECT r FROM REPTM r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPTM.findByTm001", query = "SELECT r FROM REPTM r WHERE r.rEPTMPK.tm001 = :tm001"),
    @NamedQuery(name = "REPTM.findByTm002", query = "SELECT r FROM REPTM r WHERE r.rEPTMPK.tm002 = :tm002")})
public class REPTM implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPTMPK rEPTMPK;
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
    @Column(name = "TM003")
    private String tm003;
    @Size(max = 10)
    @Column(name = "TM004")
    private String tm004;
    @Size(max = 10)
    @Column(name = "TM005")
    private String tm005;
    @Size(max = 1)
    @Column(name = "TM006")
    private String tm006;
    @Size(max = 50)
    @Column(name = "TM007")
    private String tm007;
    @Size(max = 100)
    @Column(name = "TM008")
    private String tm008;
    @Size(max = 255)
    @Column(name = "TM009")
    private String tm009;
    @Size(max = 255)
    @Column(name = "TM010")
    private String tm010;
    @Size(max = 10)
    @Column(name = "TM011")
    private String tm011;
    @Size(max = 20)
    @Column(name = "TM012")
    private String tm012;
    @Size(max = 1)
    @Column(name = "TM013")
    private String tm013;
    @Size(max = 20)
    @Column(name = "TM014")
    private String tm014;
    @Size(max = 20)
    @Column(name = "TM015")
    private String tm015;
    @Size(max = 255)
    @Column(name = "TM016")
    private String tm016;
    @Size(max = 255)
    @Column(name = "TM017")
    private String tm017;
    @Size(max = 10)
    @Column(name = "TM018")
    private String tm018;
    @Size(max = 1)
    @Column(name = "TM019")
    private String tm019;
    @Size(max = 8)
    @Column(name = "TM020")
    private String tm020;
    @Size(max = 10)
    @Column(name = "TM021")
    private String tm021;
    @Size(max = 1)
    @Column(name = "TM022")
    private String tm022;
    @Column(name = "TM023")
    private Short tm023;
    @Column(name = "TM024")
    private Short tm024;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TM025")
    private BigDecimal tm025;
    @Column(name = "TM026")
    private Short tm026;
    @Column(name = "TM027")
    private Short tm027;
    @Column(name = "TM028")
    private BigDecimal tm028;
    @Size(max = 255)
    @Column(name = "TM029")
    private String tm029;
    @Size(max = 1)
    @Column(name = "TM030")
    private String tm030;
    @Column(name = "TM031")
    private BigDecimal tm031;
    @Column(name = "TM032")
    private BigDecimal tm032;
    @Size(max = 20)
    @Column(name = "TM033")
    private String tm033;
    @Size(max = 20)
    @Column(name = "TM034")
    private String tm034;
    @Size(max = 40)
    @Column(name = "TM035")
    private String tm035;
    @Size(max = 10)
    @Column(name = "TM036")
    private String tm036;
    @Column(name = "TM037")
    private BigDecimal tm037;
    @Column(name = "TM038")
    private BigDecimal tm038;
    @Column(name = "TM039")
    private BigDecimal tm039;
    @Column(name = "TM040")
    private BigDecimal tm040;
    @Column(name = "TM041")
    private BigDecimal tm041;
    @Size(max = 10)
    @Column(name = "TM042")
    private String tm042;
    @Size(max = 1000)
    @Column(name = "TM043")
    private String tm043;
    @Size(max = 1000)
    @Column(name = "TM044")
    private String tm044;
    @Column(name = "TM045")
    private BigDecimal tm045;
    @Column(name = "TM046")
    private BigDecimal tm046;
    @Size(max = 1)
    @Column(name = "TM047")
    private String tm047;
    @Size(max = 30)
    @Column(name = "TM048")
    private String tm048;
    @Size(max = 60)
    @Column(name = "TM049")
    private String tm049;
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
    @Column(name = "TM197")
    private String tm197;
    @Size(max = 10)
    @Column(name = "TM198")
    private String tm198;
    @Size(max = 10)
    @Column(name = "TM199")
    private String tm199;
    @Size(max = 255)
    @Column(name = "REPTM01")
    private String reptm01;
    @Size(max = 255)
    @Column(name = "REPTM02")
    private String reptm02;
    @Size(max = 255)
    @Column(name = "REPTM03")
    private String reptm03;
    @Size(max = 255)
    @Column(name = "REPTM04")
    private String reptm04;
    @Size(max = 255)
    @Column(name = "REPTM05")
    private String reptm05;
    @Size(max = 255)
    @Column(name = "REPTM06")
    private String reptm06;
    @Size(max = 255)
    @Column(name = "REPTM07")
    private String reptm07;
    @Size(max = 255)
    @Column(name = "REPTM08")
    private String reptm08;
    @Size(max = 255)
    @Column(name = "REPTM09")
    private String reptm09;
    @Size(max = 255)
    @Column(name = "REPTM10")
    private String reptm10;
    @Size(max = 255)
    @Column(name = "REPTM11")
    private String reptm11;
    @Size(max = 255)
    @Column(name = "REPTM12")
    private String reptm12;
    @Size(max = 255)
    @Column(name = "REPTM13")
    private String reptm13;
    @Size(max = 255)
    @Column(name = "REPTM14")
    private String reptm14;
    @Size(max = 255)
    @Column(name = "REPTM15")
    private String reptm15;
    @Size(max = 255)
    @Column(name = "REPTM16")
    private String reptm16;
    @Size(max = 255)
    @Column(name = "REPTM17")
    private String reptm17;
    @Size(max = 255)
    @Column(name = "REPTM18")
    private String reptm18;
    @Size(max = 255)
    @Column(name = "REPTM19")
    private String reptm19;
    @Size(max = 255)
    @Column(name = "REPTM20")
    private String reptm20;
    @Size(max = 30)
    @Column(name = "TM500")
    private String tm500;
    @Size(max = 30)
    @Column(name = "TM501")
    private String tm501;
    @Size(max = 30)
    @Column(name = "TM502")
    private String tm502;
    @Size(max = 30)
    @Column(name = "TM503")
    private String tm503;
    @Size(max = 60)
    @Column(name = "TM504")
    private String tm504;
    @Size(max = 60)
    @Column(name = "TM505")
    private String tm505;
    @Size(max = 60)
    @Column(name = "TM506")
    private String tm506;
    @Size(max = 60)
    @Column(name = "TM507")
    private String tm507;
    @Size(max = 1)
    @Column(name = "TM508")
    private String tm508;

    public REPTM() {
    }

    public REPTM(REPTMPK rEPTMPK) {
        this.rEPTMPK = rEPTMPK;
    }

    public REPTM(String tm001, String tm002) {
        this.rEPTMPK = new REPTMPK(tm001, tm002);
    }

    public REPTMPK getREPTMPK() {
        return rEPTMPK;
    }

    public void setREPTMPK(REPTMPK rEPTMPK) {
        this.rEPTMPK = rEPTMPK;
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

    public String getTm003() {
        return tm003;
    }

    public void setTm003(String tm003) {
        this.tm003 = tm003;
    }

    public String getTm004() {
        return tm004;
    }

    public void setTm004(String tm004) {
        this.tm004 = tm004;
    }

    public String getTm005() {
        return tm005;
    }

    public void setTm005(String tm005) {
        this.tm005 = tm005;
    }

    public String getTm006() {
        return tm006;
    }

    public void setTm006(String tm006) {
        this.tm006 = tm006;
    }

    public String getTm007() {
        return tm007;
    }

    public void setTm007(String tm007) {
        this.tm007 = tm007;
    }

    public String getTm008() {
        return tm008;
    }

    public void setTm008(String tm008) {
        this.tm008 = tm008;
    }

    public String getTm009() {
        return tm009;
    }

    public void setTm009(String tm009) {
        this.tm009 = tm009;
    }

    public String getTm010() {
        return tm010;
    }

    public void setTm010(String tm010) {
        this.tm010 = tm010;
    }

    public String getTm011() {
        return tm011;
    }

    public void setTm011(String tm011) {
        this.tm011 = tm011;
    }

    public String getTm012() {
        return tm012;
    }

    public void setTm012(String tm012) {
        this.tm012 = tm012;
    }

    public String getTm013() {
        return tm013;
    }

    public void setTm013(String tm013) {
        this.tm013 = tm013;
    }

    public String getTm014() {
        return tm014;
    }

    public void setTm014(String tm014) {
        this.tm014 = tm014;
    }

    public String getTm015() {
        return tm015;
    }

    public void setTm015(String tm015) {
        this.tm015 = tm015;
    }

    public String getTm016() {
        return tm016;
    }

    public void setTm016(String tm016) {
        this.tm016 = tm016;
    }

    public String getTm017() {
        return tm017;
    }

    public void setTm017(String tm017) {
        this.tm017 = tm017;
    }

    public String getTm018() {
        return tm018;
    }

    public void setTm018(String tm018) {
        this.tm018 = tm018;
    }

    public String getTm019() {
        return tm019;
    }

    public void setTm019(String tm019) {
        this.tm019 = tm019;
    }

    public String getTm020() {
        return tm020;
    }

    public void setTm020(String tm020) {
        this.tm020 = tm020;
    }

    public String getTm021() {
        return tm021;
    }

    public void setTm021(String tm021) {
        this.tm021 = tm021;
    }

    public String getTm022() {
        return tm022;
    }

    public void setTm022(String tm022) {
        this.tm022 = tm022;
    }

    public Short getTm023() {
        return tm023;
    }

    public void setTm023(Short tm023) {
        this.tm023 = tm023;
    }

    public Short getTm024() {
        return tm024;
    }

    public void setTm024(Short tm024) {
        this.tm024 = tm024;
    }

    public BigDecimal getTm025() {
        return tm025;
    }

    public void setTm025(BigDecimal tm025) {
        this.tm025 = tm025;
    }

    public Short getTm026() {
        return tm026;
    }

    public void setTm026(Short tm026) {
        this.tm026 = tm026;
    }

    public Short getTm027() {
        return tm027;
    }

    public void setTm027(Short tm027) {
        this.tm027 = tm027;
    }

    public BigDecimal getTm028() {
        return tm028;
    }

    public void setTm028(BigDecimal tm028) {
        this.tm028 = tm028;
    }

    public String getTm029() {
        return tm029;
    }

    public void setTm029(String tm029) {
        this.tm029 = tm029;
    }

    public String getTm030() {
        return tm030;
    }

    public void setTm030(String tm030) {
        this.tm030 = tm030;
    }

    public BigDecimal getTm031() {
        return tm031;
    }

    public void setTm031(BigDecimal tm031) {
        this.tm031 = tm031;
    }

    public BigDecimal getTm032() {
        return tm032;
    }

    public void setTm032(BigDecimal tm032) {
        this.tm032 = tm032;
    }

    public String getTm033() {
        return tm033;
    }

    public void setTm033(String tm033) {
        this.tm033 = tm033;
    }

    public String getTm034() {
        return tm034;
    }

    public void setTm034(String tm034) {
        this.tm034 = tm034;
    }

    public String getTm035() {
        return tm035;
    }

    public void setTm035(String tm035) {
        this.tm035 = tm035;
    }

    public String getTm036() {
        return tm036;
    }

    public void setTm036(String tm036) {
        this.tm036 = tm036;
    }

    public BigDecimal getTm037() {
        return tm037;
    }

    public void setTm037(BigDecimal tm037) {
        this.tm037 = tm037;
    }

    public BigDecimal getTm038() {
        return tm038;
    }

    public void setTm038(BigDecimal tm038) {
        this.tm038 = tm038;
    }

    public BigDecimal getTm039() {
        return tm039;
    }

    public void setTm039(BigDecimal tm039) {
        this.tm039 = tm039;
    }

    public BigDecimal getTm040() {
        return tm040;
    }

    public void setTm040(BigDecimal tm040) {
        this.tm040 = tm040;
    }

    public BigDecimal getTm041() {
        return tm041;
    }

    public void setTm041(BigDecimal tm041) {
        this.tm041 = tm041;
    }

    public String getTm042() {
        return tm042;
    }

    public void setTm042(String tm042) {
        this.tm042 = tm042;
    }

    public String getTm043() {
        return tm043;
    }

    public void setTm043(String tm043) {
        this.tm043 = tm043;
    }

    public String getTm044() {
        return tm044;
    }

    public void setTm044(String tm044) {
        this.tm044 = tm044;
    }

    public BigDecimal getTm045() {
        return tm045;
    }

    public void setTm045(BigDecimal tm045) {
        this.tm045 = tm045;
    }

    public BigDecimal getTm046() {
        return tm046;
    }

    public void setTm046(BigDecimal tm046) {
        this.tm046 = tm046;
    }

    public String getTm047() {
        return tm047;
    }

    public void setTm047(String tm047) {
        this.tm047 = tm047;
    }

    public String getTm048() {
        return tm048;
    }

    public void setTm048(String tm048) {
        this.tm048 = tm048;
    }

    public String getTm049() {
        return tm049;
    }

    public void setTm049(String tm049) {
        this.tm049 = tm049;
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

    public String getTm197() {
        return tm197;
    }

    public void setTm197(String tm197) {
        this.tm197 = tm197;
    }

    public String getTm198() {
        return tm198;
    }

    public void setTm198(String tm198) {
        this.tm198 = tm198;
    }

    public String getTm199() {
        return tm199;
    }

    public void setTm199(String tm199) {
        this.tm199 = tm199;
    }

    public String getReptm01() {
        return reptm01;
    }

    public void setReptm01(String reptm01) {
        this.reptm01 = reptm01;
    }

    public String getReptm02() {
        return reptm02;
    }

    public void setReptm02(String reptm02) {
        this.reptm02 = reptm02;
    }

    public String getReptm03() {
        return reptm03;
    }

    public void setReptm03(String reptm03) {
        this.reptm03 = reptm03;
    }

    public String getReptm04() {
        return reptm04;
    }

    public void setReptm04(String reptm04) {
        this.reptm04 = reptm04;
    }

    public String getReptm05() {
        return reptm05;
    }

    public void setReptm05(String reptm05) {
        this.reptm05 = reptm05;
    }

    public String getReptm06() {
        return reptm06;
    }

    public void setReptm06(String reptm06) {
        this.reptm06 = reptm06;
    }

    public String getReptm07() {
        return reptm07;
    }

    public void setReptm07(String reptm07) {
        this.reptm07 = reptm07;
    }

    public String getReptm08() {
        return reptm08;
    }

    public void setReptm08(String reptm08) {
        this.reptm08 = reptm08;
    }

    public String getReptm09() {
        return reptm09;
    }

    public void setReptm09(String reptm09) {
        this.reptm09 = reptm09;
    }

    public String getReptm10() {
        return reptm10;
    }

    public void setReptm10(String reptm10) {
        this.reptm10 = reptm10;
    }

    public String getReptm11() {
        return reptm11;
    }

    public void setReptm11(String reptm11) {
        this.reptm11 = reptm11;
    }

    public String getReptm12() {
        return reptm12;
    }

    public void setReptm12(String reptm12) {
        this.reptm12 = reptm12;
    }

    public String getReptm13() {
        return reptm13;
    }

    public void setReptm13(String reptm13) {
        this.reptm13 = reptm13;
    }

    public String getReptm14() {
        return reptm14;
    }

    public void setReptm14(String reptm14) {
        this.reptm14 = reptm14;
    }

    public String getReptm15() {
        return reptm15;
    }

    public void setReptm15(String reptm15) {
        this.reptm15 = reptm15;
    }

    public String getReptm16() {
        return reptm16;
    }

    public void setReptm16(String reptm16) {
        this.reptm16 = reptm16;
    }

    public String getReptm17() {
        return reptm17;
    }

    public void setReptm17(String reptm17) {
        this.reptm17 = reptm17;
    }

    public String getReptm18() {
        return reptm18;
    }

    public void setReptm18(String reptm18) {
        this.reptm18 = reptm18;
    }

    public String getReptm19() {
        return reptm19;
    }

    public void setReptm19(String reptm19) {
        this.reptm19 = reptm19;
    }

    public String getReptm20() {
        return reptm20;
    }

    public void setReptm20(String reptm20) {
        this.reptm20 = reptm20;
    }

    public String getTm500() {
        return tm500;
    }

    public void setTm500(String tm500) {
        this.tm500 = tm500;
    }

    public String getTm501() {
        return tm501;
    }

    public void setTm501(String tm501) {
        this.tm501 = tm501;
    }

    public String getTm502() {
        return tm502;
    }

    public void setTm502(String tm502) {
        this.tm502 = tm502;
    }

    public String getTm503() {
        return tm503;
    }

    public void setTm503(String tm503) {
        this.tm503 = tm503;
    }

    public String getTm504() {
        return tm504;
    }

    public void setTm504(String tm504) {
        this.tm504 = tm504;
    }

    public String getTm505() {
        return tm505;
    }

    public void setTm505(String tm505) {
        this.tm505 = tm505;
    }

    public String getTm506() {
        return tm506;
    }

    public void setTm506(String tm506) {
        this.tm506 = tm506;
    }

    public String getTm507() {
        return tm507;
    }

    public void setTm507(String tm507) {
        this.tm507 = tm507;
    }

    public String getTm508() {
        return tm508;
    }

    public void setTm508(String tm508) {
        this.tm508 = tm508;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPTMPK != null ? rEPTMPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTM)) {
            return false;
        }
        REPTM other = (REPTM) object;
        if ((this.rEPTMPK == null && other.rEPTMPK != null) || (this.rEPTMPK != null && !this.rEPTMPK.equals(other.rEPTMPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPTM[ rEPTMPK=" + rEPTMPK + " ]";
    }
    
}
