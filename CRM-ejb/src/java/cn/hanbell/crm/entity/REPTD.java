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
@Table(name = "REPTD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPTD.findAll", query = "SELECT r FROM REPTD r"),
    @NamedQuery(name = "REPTD.findByCompany", query = "SELECT r FROM REPTD r WHERE r.company = :company"),
    @NamedQuery(name = "REPTD.findByCreator", query = "SELECT r FROM REPTD r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPTD.findByUsrGroup", query = "SELECT r FROM REPTD r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPTD.findByCreateDate", query = "SELECT r FROM REPTD r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPTD.findByModifier", query = "SELECT r FROM REPTD r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPTD.findByModiDate", query = "SELECT r FROM REPTD r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPTD.findByFlag", query = "SELECT r FROM REPTD r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPTD.findByTd001", query = "SELECT r FROM REPTD r WHERE r.reptdPK.td001 = :td001"),
    @NamedQuery(name = "REPTD.findByTd002", query = "SELECT r FROM REPTD r WHERE r.reptdPK.td002 = :td002"),
    @NamedQuery(name = "REPTD.findByTd003", query = "SELECT r FROM REPTD r WHERE r.reptdPK.td003 = :td003"), 
    @NamedQuery(name = "REPTD.findByPK", query = "SELECT r FROM REPTD r WHERE r.reptdPK.td001 = :td001 AND r.reptdPK.td002 = :td002 AND r.reptdPK.td003 = :td003"), 
    @NamedQuery(name = "REPTD.findByCustomer", query = "SELECT r FROM REPTD r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPTD.findByProduct", query = "SELECT r FROM REPTD r WHERE r.product = :product"),
    @NamedQuery(name = "REPTD.findByRegion", query = "SELECT r FROM REPTD r WHERE r.region = :region"),
    @NamedQuery(name = "REPTD.findByDealer", query = "SELECT r FROM REPTD r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPTD.findByTd053", query = "SELECT r FROM REPTD r WHERE r.td053 = :td053")})
public class REPTD implements Serializable {

    @Column(name = "TD500")
    private BigDecimal td500;
    @Size(max = 255)
    @Column(name = "TD501")
    private String td501;
    @Size(max = 255)
    @Column(name = "TD502")
    private String td502;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPTDPK reptdPK;
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
    @Column(name = "TD004")
    private String td004;
    @Size(max = 120)
    @Column(name = "TD005")
    private String td005;
    @Size(max = 120)
    @Column(name = "TD006")
    private String td006;
    @Size(max = 6)
    @Column(name = "TD007")
    private String td007;
    @Size(max = 10)
    @Column(name = "TD008")
    private String td008;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TD009")
    private BigDecimal td009;
    @Column(name = "TD010")
    private BigDecimal td010;
    @Column(name = "TD011")
    private BigDecimal td011;
    @Size(max = 255)
    @Column(name = "TD012")
    private String td012;
    @Size(max = 1)
    @Column(name = "TD013")
    private String td013;
    @Size(max = 20)
    @Column(name = "TD014")
    private String td014;
    @Column(name = "TD015")
    private BigDecimal td015;
    @Size(max = 6)
    @Column(name = "TD016")
    private String td016;
    @Column(name = "TD017")
    private BigDecimal td017;
    @Column(name = "TD018")
    private BigDecimal td018;
    @Size(max = 1)
    @Column(name = "TD019")
    private String td019;
    @Column(name = "TD020")
    private BigDecimal td020;
    @Size(max = 1)
    @Column(name = "TD021")
    private String td021;
    @Size(max = 30)
    @Column(name = "TD022")
    private String td022;
    @Size(max = 1)
    @Column(name = "TD023")
    private String td023;
    @Size(max = 8)
    @Column(name = "TD024")
    private String td024;
    @Size(max = 8)
    @Column(name = "TD025")
    private String td025;
    @Size(max = 10)
    @Column(name = "TD026")
    private String td026;
    @Size(max = 1)
    @Column(name = "TD027")
    private String td027;
    @Size(max = 4)
    @Column(name = "TD028")
    private String td028;
    @Size(max = 1)
    @Column(name = "TD029")
    private String td029;
    @Size(max = 4)
    @Column(name = "TD030")
    private String td030;
    @Size(max = 1)
    @Column(name = "TD031")
    private String td031;
    @Column(name = "TD032")
    private BigDecimal td032;
    @Size(max = 1)
    @Column(name = "TD033")
    private String td033;
    @Size(max = 8)
    @Column(name = "TD034")
    private String td034;
    @Size(max = 8)
    @Column(name = "TD035")
    private String td035;
    @Size(max = 10)
    @Column(name = "TD036")
    private String td036;
    @Size(max = 10)
    @Column(name = "TD037")
    private String td037;
    @Column(name = "TD038")
    private BigDecimal td038;
    @Column(name = "TD039")
    private BigDecimal td039;
    @Column(name = "TD040")
    private BigDecimal td040;
    @Column(name = "TD041")
    private BigDecimal td041;
    @Column(name = "TD042")
    private BigDecimal td042;
    @Size(max = 1)
    @Column(name = "TD043")
    private String td043;
    @Size(max = 30)
    @Column(name = "TD044")
    private String td044;
    @Size(max = 60)
    @Column(name = "TD045")
    private String td045;
    @Size(max = 1)
    @Column(name = "TD046")
    private String td046;
    @Size(max = 1)
    @Column(name = "TD047")
    private String td047;
    @Size(max = 1)
    @Column(name = "TD048")
    private String td048;
    @Size(max = 10)
    @Column(name = "TD049")
    private String td049;
    @Size(max = 20)
    @Column(name = "TD050")
    private String td050;
    @Size(max = 20)
    @Column(name = "TD051")
    private String td051;
    @Size(max = 20)
    @Column(name = "TD052")
    private String td052;
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
    @Size(max = 255)
    @Column(name = "REPTD01")
    private String reptd01;
    @Size(max = 255)
    @Column(name = "REPTD02")
    private String reptd02;
    @Size(max = 255)
    @Column(name = "REPTD03")
    private String reptd03;
    @Size(max = 255)
    @Column(name = "REPTD04")
    private String reptd04;
    @Size(max = 255)
    @Column(name = "REPTD05")
    private String reptd05;
    @Size(max = 255)
    @Column(name = "REPTD06")
    private String reptd06;
    @Size(max = 255)
    @Column(name = "REPTD07")
    private String reptd07;
    @Size(max = 255)
    @Column(name = "REPTD08")
    private String reptd08;
    @Size(max = 255)
    @Column(name = "REPTD09")
    private String reptd09;
    @Size(max = 255)
    @Column(name = "REPTD10")
    private String reptd10;
    @Size(max = 255)
    @Column(name = "REPTD11")
    private String reptd11;
    @Size(max = 255)
    @Column(name = "REPTD12")
    private String reptd12;
    @Size(max = 255)
    @Column(name = "REPTD13")
    private String reptd13;
    @Size(max = 255)
    @Column(name = "REPTD14")
    private String reptd14;
    @Size(max = 255)
    @Column(name = "REPTD15")
    private String reptd15;
    @Size(max = 255)
    @Column(name = "REPTD16")
    private String reptd16;
    @Size(max = 255)
    @Column(name = "REPTD17")
    private String reptd17;
    @Size(max = 255)
    @Column(name = "REPTD18")
    private String reptd18;
    @Size(max = 255)
    @Column(name = "REPTD19")
    private String reptd19;
    @Size(max = 255)
    @Column(name = "REPTD20")
    private String reptd20;
    @Column(name = "TD053")
    private BigDecimal td053;

    public REPTD() {
    }

    public REPTD(REPTDPK reptdPK) {
        this.reptdPK = reptdPK;
    }

    public REPTD(String td001, String td002, String td003) {
        this.reptdPK = new REPTDPK(td001, td002, td003);
    }

    public REPTDPK getREPTDPK() {
        return reptdPK;
    }

    public void setREPTDPK(REPTDPK reptdPK) {
        this.reptdPK = reptdPK;
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

    public String getTd004() {
        return td004;
    }

    public void setTd004(String td004) {
        this.td004 = td004;
    }

    public String getTd005() {
        return td005;
    }

    public void setTd005(String td005) {
        this.td005 = td005;
    }

    public String getTd006() {
        return td006;
    }

    public void setTd006(String td006) {
        this.td006 = td006;
    }

    public String getTd007() {
        return td007;
    }

    public void setTd007(String td007) {
        this.td007 = td007;
    }

    public String getTd008() {
        return td008;
    }

    public void setTd008(String td008) {
        this.td008 = td008;
    }

    public BigDecimal getTd009() {
        return td009;
    }

    public void setTd009(BigDecimal td009) {
        this.td009 = td009;
    }

    public BigDecimal getTd010() {
        return td010;
    }

    public void setTd010(BigDecimal td010) {
        this.td010 = td010;
    }

    public BigDecimal getTd011() {
        return td011;
    }

    public void setTd011(BigDecimal td011) {
        this.td011 = td011;
    }

    public String getTd012() {
        return td012;
    }

    public void setTd012(String td012) {
        this.td012 = td012;
    }

    public String getTd013() {
        return td013;
    }

    public void setTd013(String td013) {
        this.td013 = td013;
    }

    public String getTd014() {
        return td014;
    }

    public void setTd014(String td014) {
        this.td014 = td014;
    }

    public BigDecimal getTd015() {
        return td015;
    }

    public void setTd015(BigDecimal td015) {
        this.td015 = td015;
    }

    public String getTd016() {
        return td016;
    }

    public void setTd016(String td016) {
        this.td016 = td016;
    }

    public BigDecimal getTd017() {
        return td017;
    }

    public void setTd017(BigDecimal td017) {
        this.td017 = td017;
    }

    public BigDecimal getTd018() {
        return td018;
    }

    public void setTd018(BigDecimal td018) {
        this.td018 = td018;
    }

    public String getTd019() {
        return td019;
    }

    public void setTd019(String td019) {
        this.td019 = td019;
    }

    public BigDecimal getTd020() {
        return td020;
    }

    public void setTd020(BigDecimal td020) {
        this.td020 = td020;
    }

    public String getTd021() {
        return td021;
    }

    public void setTd021(String td021) {
        this.td021 = td021;
    }

    public String getTd022() {
        return td022;
    }

    public void setTd022(String td022) {
        this.td022 = td022;
    }

    public String getTd023() {
        return td023;
    }

    public void setTd023(String td023) {
        this.td023 = td023;
    }

    public String getTd024() {
        return td024;
    }

    public void setTd024(String td024) {
        this.td024 = td024;
    }

    public String getTd025() {
        return td025;
    }

    public void setTd025(String td025) {
        this.td025 = td025;
    }

    public String getTd026() {
        return td026;
    }

    public void setTd026(String td026) {
        this.td026 = td026;
    }

    public String getTd027() {
        return td027;
    }

    public void setTd027(String td027) {
        this.td027 = td027;
    }

    public String getTd028() {
        return td028;
    }

    public void setTd028(String td028) {
        this.td028 = td028;
    }

    public String getTd029() {
        return td029;
    }

    public void setTd029(String td029) {
        this.td029 = td029;
    }

    public String getTd030() {
        return td030;
    }

    public void setTd030(String td030) {
        this.td030 = td030;
    }

    public String getTd031() {
        return td031;
    }

    public void setTd031(String td031) {
        this.td031 = td031;
    }

    public BigDecimal getTd032() {
        return td032;
    }

    public void setTd032(BigDecimal td032) {
        this.td032 = td032;
    }

    public String getTd033() {
        return td033;
    }

    public void setTd033(String td033) {
        this.td033 = td033;
    }

    public String getTd034() {
        return td034;
    }

    public void setTd034(String td034) {
        this.td034 = td034;
    }

    public String getTd035() {
        return td035;
    }

    public void setTd035(String td035) {
        this.td035 = td035;
    }

    public String getTd036() {
        return td036;
    }

    public void setTd036(String td036) {
        this.td036 = td036;
    }

    public String getTd037() {
        return td037;
    }

    public void setTd037(String td037) {
        this.td037 = td037;
    }

    public BigDecimal getTd038() {
        return td038;
    }

    public void setTd038(BigDecimal td038) {
        this.td038 = td038;
    }

    public BigDecimal getTd039() {
        return td039;
    }

    public void setTd039(BigDecimal td039) {
        this.td039 = td039;
    }

    public BigDecimal getTd040() {
        return td040;
    }

    public void setTd040(BigDecimal td040) {
        this.td040 = td040;
    }

    public BigDecimal getTd041() {
        return td041;
    }

    public void setTd041(BigDecimal td041) {
        this.td041 = td041;
    }

    public BigDecimal getTd042() {
        return td042;
    }

    public void setTd042(BigDecimal td042) {
        this.td042 = td042;
    }

    public String getTd043() {
        return td043;
    }

    public void setTd043(String td043) {
        this.td043 = td043;
    }

    public String getTd044() {
        return td044;
    }

    public void setTd044(String td044) {
        this.td044 = td044;
    }

    public String getTd045() {
        return td045;
    }

    public void setTd045(String td045) {
        this.td045 = td045;
    }

    public String getTd046() {
        return td046;
    }

    public void setTd046(String td046) {
        this.td046 = td046;
    }

    public String getTd047() {
        return td047;
    }

    public void setTd047(String td047) {
        this.td047 = td047;
    }

    public String getTd048() {
        return td048;
    }

    public void setTd048(String td048) {
        this.td048 = td048;
    }

    public String getTd049() {
        return td049;
    }

    public void setTd049(String td049) {
        this.td049 = td049;
    }

    public String getTd050() {
        return td050;
    }

    public void setTd050(String td050) {
        this.td050 = td050;
    }

    public String getTd051() {
        return td051;
    }

    public void setTd051(String td051) {
        this.td051 = td051;
    }

    public String getTd052() {
        return td052;
    }

    public void setTd052(String td052) {
        this.td052 = td052;
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

    public String getREPTD01() {
        return reptd01;
    }

    public void setREPTD01(String reptd01) {
        this.reptd01 = reptd01;
    }

    public String getREPTD02() {
        return reptd02;
    }

    public void setREPTD02(String reptd02) {
        this.reptd02 = reptd02;
    }

    public String getREPTD03() {
        return reptd03;
    }

    public void setREPTD03(String reptd03) {
        this.reptd03 = reptd03;
    }

    public String getREPTD04() {
        return reptd04;
    }

    public void setREPTD04(String reptd04) {
        this.reptd04 = reptd04;
    }

    public String getREPTD05() {
        return reptd05;
    }

    public void setREPTD05(String reptd05) {
        this.reptd05 = reptd05;
    }

    public String getREPTD06() {
        return reptd06;
    }

    public void setREPTD06(String reptd06) {
        this.reptd06 = reptd06;
    }

    public String getREPTD07() {
        return reptd07;
    }

    public void setREPTD07(String reptd07) {
        this.reptd07 = reptd07;
    }

    public String getREPTD08() {
        return reptd08;
    }

    public void setREPTD08(String reptd08) {
        this.reptd08 = reptd08;
    }

    public String getREPTD09() {
        return reptd09;
    }

    public void setREPTD09(String reptd09) {
        this.reptd09 = reptd09;
    }

    public String getREPTD10() {
        return reptd10;
    }

    public void setREPTD10(String reptd10) {
        this.reptd10 = reptd10;
    }

    public String getREPTD11() {
        return reptd11;
    }

    public void setREPTD11(String reptd11) {
        this.reptd11 = reptd11;
    }

    public String getREPTD12() {
        return reptd12;
    }

    public void setREPTD12(String reptd12) {
        this.reptd12 = reptd12;
    }

    public String getREPTD13() {
        return reptd13;
    }

    public void setREPTD13(String reptd13) {
        this.reptd13 = reptd13;
    }

    public String getREPTD14() {
        return reptd14;
    }

    public void setREPTD14(String reptd14) {
        this.reptd14 = reptd14;
    }

    public String getREPTD15() {
        return reptd15;
    }

    public void setREPTD15(String reptd15) {
        this.reptd15 = reptd15;
    }

    public String getREPTD16() {
        return reptd16;
    }

    public void setREPTD16(String reptd16) {
        this.reptd16 = reptd16;
    }

    public String getREPTD17() {
        return reptd17;
    }

    public void setREPTD17(String reptd17) {
        this.reptd17 = reptd17;
    }

    public String getREPTD18() {
        return reptd18;
    }

    public void setREPTD18(String reptd18) {
        this.reptd18 = reptd18;
    }

    public String getREPTD19() {
        return reptd19;
    }

    public void setREPTD19(String reptd19) {
        this.reptd19 = reptd19;
    }

    public String getREPTD20() {
        return reptd20;
    }

    public void setREPTD20(String reptd20) {
        this.reptd20 = reptd20;
    }

    public BigDecimal getTd053() {
        return td053;
    }

    public void setTd053(BigDecimal td053) {
        this.td053 = td053;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reptdPK != null ? reptdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTD)) {
            return false;
        }
        REPTD other = (REPTD) object;
        if ((this.reptdPK == null && other.reptdPK != null) || (this.reptdPK != null && !this.reptdPK.equals(other.reptdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.comm.REPTD[ reptdPK=" + reptdPK + " ]";
    }

    public BigDecimal getTd500() {
        return td500;
    }

    public void setTd500(BigDecimal td500) {
        this.td500 = td500;
    }

    public String getTd501() {
        return td501;
    }

    public void setTd501(String td501) {
        this.td501 = td501;
    }

    public String getTd502() {
        return td502;
    }

    public void setTd502(String td502) {
        this.td502 = td502;
    }
    
}
