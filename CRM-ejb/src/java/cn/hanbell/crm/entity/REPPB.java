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
@Table(name = "REPPB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPPB.findAll", query = "SELECT r FROM REPPB r")
    , @NamedQuery(name = "REPPB.findByCompany", query = "SELECT r FROM REPPB r WHERE r.company = :company")
    , @NamedQuery(name = "REPPB.findByCreator", query = "SELECT r FROM REPPB r WHERE r.creator = :creator")
    , @NamedQuery(name = "REPPB.findByUsrGroup", query = "SELECT r FROM REPPB r WHERE r.usrGroup = :usrGroup")
    , @NamedQuery(name = "REPPB.findByCreateDate", query = "SELECT r FROM REPPB r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "REPPB.findByModifier", query = "SELECT r FROM REPPB r WHERE r.modifier = :modifier")
    , @NamedQuery(name = "REPPB.findByModiDate", query = "SELECT r FROM REPPB r WHERE r.modiDate = :modiDate")
    , @NamedQuery(name = "REPPB.findByFlag", query = "SELECT r FROM REPPB r WHERE r.flag = :flag")
    , @NamedQuery(name = "REPPB.findByPb001", query = "SELECT r FROM REPPB r WHERE r.reppbPK.pb001 = :pb001")
    , @NamedQuery(name = "REPPB.findByPb002", query = "SELECT r FROM REPPB r WHERE r.reppbPK.pb002 = :pb002")
    , @NamedQuery(name = "REPPB.findByPb003", query = "SELECT r FROM REPPB r WHERE r.reppbPK.pb003 = :pb003")
    , @NamedQuery(name = "REPPB.findByREPPAPK", query = "SELECT r FROM REPPB r WHERE r.reppbPK.pb001 = :pb001 AND r.reppbPK.pb002 = :pb002")
})
public class REPPB implements Serializable {

    @Size(max = 30)
    @Column(name = "PB502")
    private String pb502;
    @Size(max = 30)
    @Column(name = "PB503")
    private String pb503;
    @Size(max = 50)
    @Column(name = "PB513")
    private String pb513;
    @Size(max = 50)
    @Column(name = "PB514")
    private String pb514;
    @Size(max = 60)
    @Column(name = "PB515")
    private String pb515;
    @Size(max = 30)
    @Column(name = "PB516")
    private String pb516;
    @Size(max = 30)
    @Column(name = "PB517")
    private String pb517;
    @Size(max = 30)
    @Column(name = "PB518")
    private String pb518;
    @Size(max = 30)
    @Column(name = "PB519")
    private String pb519;

    @Size(max = 30)
    @Column(name = "PB510")
    private String pb510;
    @Column(name = "PB500")
    private BigDecimal pb500;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPPBPK reppbPK;
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
    @Column(name = "PB004")
    private String pb004;
    @Size(max = 120)
    @Column(name = "PB005")
    private String pb005;
    @Size(max = 255)
    @Column(name = "PB006")
    private String pb006;
    @Size(max = 30)
    @Column(name = "PB007")
    private String pb007;
    @Size(max = 6)
    @Column(name = "PB008")
    private String pb008;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PB009")
    private BigDecimal pb009;
    @Column(name = "PB010")
    private BigDecimal pb010;
    @Column(name = "PB011")
    private BigDecimal pb011;
    @Column(name = "PB012")
    private BigDecimal pb012;
    @Column(name = "PB013")
    private BigDecimal pb013;
    @Column(name = "PB014")
    private BigDecimal pb014;
    @Column(name = "PB015")
    private BigDecimal pb015;
    @Size(max = 255)
    @Column(name = "PB016")
    private String pb016;
    @Column(name = "PB017")
    private BigDecimal pb017;
    @Column(name = "PB018")
    private BigDecimal pb018;
    @Size(max = 1)
    @Column(name = "PB019")
    private String pb019;
    @Size(max = 30)
    @Column(name = "PB020")
    private String pb020;
    @Size(max = 60)
    @Column(name = "PB021")
    private String pb021;
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
    @Column(name = "REPPB01")
    private String reppb01;
    @Size(max = 255)
    @Column(name = "REPPB02")
    private String reppb02;
    @Size(max = 255)
    @Column(name = "REPPB03")
    private String reppb03;
    @Size(max = 255)
    @Column(name = "REPPB04")
    private String reppb04;
    @Size(max = 255)
    @Column(name = "REPPB05")
    private String reppb05;
    @Size(max = 255)
    @Column(name = "REPPB06")
    private String reppb06;
    @Size(max = 255)
    @Column(name = "REPPB07")
    private String reppb07;
    @Size(max = 255)
    @Column(name = "REPPB08")
    private String reppb08;
    @Size(max = 255)
    @Column(name = "REPPB09")
    private String reppb09;
    @Size(max = 255)
    @Column(name = "REPPB10")
    private String reppb10;
    @Size(max = 255)
    @Column(name = "REPPB11")
    private String reppb11;
    @Size(max = 255)
    @Column(name = "REPPB12")
    private String reppb12;
    @Size(max = 255)
    @Column(name = "REPPB13")
    private String reppb13;
    @Size(max = 255)
    @Column(name = "REPPB14")
    private String reppb14;
    @Size(max = 255)
    @Column(name = "REPPB15")
    private String reppb15;
    @Size(max = 255)
    @Column(name = "REPPB16")
    private String reppb16;
    @Size(max = 255)
    @Column(name = "REPPB17")
    private String reppb17;
    @Size(max = 255)
    @Column(name = "REPPB18")
    private String reppb18;
    @Size(max = 255)
    @Column(name = "REPPB19")
    private String reppb19;
    @Size(max = 255)
    @Column(name = "REPPB20")
    private String reppb20;
    @Column(name = "PB022")
    private BigDecimal pb022;
    @Column(name = "PB023")
    private BigDecimal pb023;
    @Column(name = "PB024")
    private BigDecimal pb024;
    @Column(name = "PB025")
    private BigDecimal pb025;
    @Column(name = "PB501")
    private BigDecimal pb501;
    @Size(max = 60)
    @Column(name = "PB504")
    private String pb504;
    @Size(max = 10)
    @Column(name = "PB505")
    private String pb505;
    @Size(max = 255)
    @Column(name = "PB506")
    private String pb506;
    @Size(max = 255)
    @Column(name = "PB507")
    private String pb507;
    @Size(max = 1)
    @Column(name = "PB508")
    private String pb508;
    @Size(max = 60)
    @Column(name = "PB509")
    private String pb509;
    @Column(name = "PB511")
    private BigDecimal pb511;
    @Column(name = "PB512")
    private BigDecimal pb512;

    public REPPB() {
    }

    public REPPB(REPPBPK reppbPK) {
        this.reppbPK = reppbPK;
    }

    public REPPB(String pb001, String pb002, String pb003) {
        this.reppbPK = new REPPBPK(pb001, pb002, pb003);
    }

    public REPPBPK getREPPBPK() {
        return reppbPK;
    }

    public void setREPPBPK(REPPBPK reppbPK) {
        this.reppbPK = reppbPK;
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

    public String getPb004() {
        return pb004;
    }

    public void setPb004(String pb004) {
        this.pb004 = pb004;
    }

    public String getPb005() {
        return pb005;
    }

    public void setPb005(String pb005) {
        this.pb005 = pb005;
    }

    public String getPb006() {
        return pb006;
    }

    public void setPb006(String pb006) {
        this.pb006 = pb006;
    }

    public String getPb007() {
        return pb007;
    }

    public void setPb007(String pb007) {
        this.pb007 = pb007;
    }

    public String getPb008() {
        return pb008;
    }

    public void setPb008(String pb008) {
        this.pb008 = pb008;
    }

    public BigDecimal getPb009() {
        return pb009;
    }

    public void setPb009(BigDecimal pb009) {
        this.pb009 = pb009;
    }

    public BigDecimal getPb010() {
        return pb010;
    }

    public void setPb010(BigDecimal pb010) {
        this.pb010 = pb010;
    }

    public BigDecimal getPb011() {
        return pb011;
    }

    public void setPb011(BigDecimal pb011) {
        this.pb011 = pb011;
    }

    public BigDecimal getPb012() {
        return pb012;
    }

    public void setPb012(BigDecimal pb012) {
        this.pb012 = pb012;
    }

    public BigDecimal getPb013() {
        return pb013;
    }

    public void setPb013(BigDecimal pb013) {
        this.pb013 = pb013;
    }

    public BigDecimal getPb014() {
        return pb014;
    }

    public void setPb014(BigDecimal pb014) {
        this.pb014 = pb014;
    }

    public BigDecimal getPb015() {
        return pb015;
    }

    public void setPb015(BigDecimal pb015) {
        this.pb015 = pb015;
    }

    public String getPb016() {
        return pb016;
    }

    public void setPb016(String pb016) {
        this.pb016 = pb016;
    }

    public BigDecimal getPb017() {
        return pb017;
    }

    public void setPb017(BigDecimal pb017) {
        this.pb017 = pb017;
    }

    public BigDecimal getPb018() {
        return pb018;
    }

    public void setPb018(BigDecimal pb018) {
        this.pb018 = pb018;
    }

    public String getPb019() {
        return pb019;
    }

    public void setPb019(String pb019) {
        this.pb019 = pb019;
    }

    public String getPb020() {
        return pb020;
    }

    public void setPb020(String pb020) {
        this.pb020 = pb020;
    }

    public String getPb021() {
        return pb021;
    }

    public void setPb021(String pb021) {
        this.pb021 = pb021;
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

    public String getReppb01() {
        return reppb01;
    }

    public void setReppb01(String reppb01) {
        this.reppb01 = reppb01;
    }

    public String getReppb02() {
        return reppb02;
    }

    public void setReppb02(String reppb02) {
        this.reppb02 = reppb02;
    }

    public String getReppb03() {
        return reppb03;
    }

    public void setReppb03(String reppb03) {
        this.reppb03 = reppb03;
    }

    public String getReppb04() {
        return reppb04;
    }

    public void setReppb04(String reppb04) {
        this.reppb04 = reppb04;
    }

    public String getReppb05() {
        return reppb05;
    }

    public void setReppb05(String reppb05) {
        this.reppb05 = reppb05;
    }

    public String getReppb06() {
        return reppb06;
    }

    public void setReppb06(String reppb06) {
        this.reppb06 = reppb06;
    }

    public String getReppb07() {
        return reppb07;
    }

    public void setReppb07(String reppb07) {
        this.reppb07 = reppb07;
    }

    public String getReppb08() {
        return reppb08;
    }

    public void setReppb08(String reppb08) {
        this.reppb08 = reppb08;
    }

    public String getReppb09() {
        return reppb09;
    }

    public void setReppb09(String reppb09) {
        this.reppb09 = reppb09;
    }

    public String getReppb10() {
        return reppb10;
    }

    public void setReppb10(String reppb10) {
        this.reppb10 = reppb10;
    }

    public String getReppb11() {
        return reppb11;
    }

    public void setReppb11(String reppb11) {
        this.reppb11 = reppb11;
    }

    public String getReppb12() {
        return reppb12;
    }

    public void setReppb12(String reppb12) {
        this.reppb12 = reppb12;
    }

    public String getReppb13() {
        return reppb13;
    }

    public void setReppb13(String reppb13) {
        this.reppb13 = reppb13;
    }

    public String getReppb14() {
        return reppb14;
    }

    public void setReppb14(String reppb14) {
        this.reppb14 = reppb14;
    }

    public String getReppb15() {
        return reppb15;
    }

    public void setReppb15(String reppb15) {
        this.reppb15 = reppb15;
    }

    public String getReppb16() {
        return reppb16;
    }

    public void setReppb16(String reppb16) {
        this.reppb16 = reppb16;
    }

    public String getReppb17() {
        return reppb17;
    }

    public void setReppb17(String reppb17) {
        this.reppb17 = reppb17;
    }

    public String getReppb18() {
        return reppb18;
    }

    public void setReppb18(String reppb18) {
        this.reppb18 = reppb18;
    }

    public String getReppb19() {
        return reppb19;
    }

    public void setReppb19(String reppb19) {
        this.reppb19 = reppb19;
    }

    public String getReppb20() {
        return reppb20;
    }

    public void setReppb20(String reppb20) {
        this.reppb20 = reppb20;
    }

    public BigDecimal getPb022() {
        return pb022;
    }

    public void setPb022(BigDecimal pb022) {
        this.pb022 = pb022;
    }

    public BigDecimal getPb023() {
        return pb023;
    }

    public void setPb023(BigDecimal pb023) {
        this.pb023 = pb023;
    }

    public BigDecimal getPb024() {
        return pb024;
    }

    public void setPb024(BigDecimal pb024) {
        this.pb024 = pb024;
    }

    public BigDecimal getPb025() {
        return pb025;
    }

    public void setPb025(BigDecimal pb025) {
        this.pb025 = pb025;
    }

    public BigDecimal getPb501() {
        return pb501;
    }

    public void setPb501(BigDecimal pb501) {
        this.pb501 = pb501;
    }


    public String getPb504() {
        return pb504;
    }

    public void setPb504(String pb504) {
        this.pb504 = pb504;
    }

    public String getPb505() {
        return pb505;
    }

    public void setPb505(String pb505) {
        this.pb505 = pb505;
    }

    public String getPb506() {
        return pb506;
    }

    public void setPb506(String pb506) {
        this.pb506 = pb506;
    }

    public String getPb507() {
        return pb507;
    }

    public void setPb507(String pb507) {
        this.pb507 = pb507;
    }

    public String getPb508() {
        return pb508;
    }

    public void setPb508(String pb508) {
        this.pb508 = pb508;
    }

    public String getPb509() {
        return pb509;
    }

    public void setPb509(String pb509) {
        this.pb509 = pb509;
    }

    public BigDecimal getPb511() {
        return pb511;
    }

    public void setPb511(BigDecimal pb511) {
        this.pb511 = pb511;
    }

    public BigDecimal getPb512() {
        return pb512;
    }

    public void setPb512(BigDecimal pb512) {
        this.pb512 = pb512;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reppbPK != null ? reppbPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPPB)) {
            return false;
        }
        REPPB other = (REPPB) object;
        if ((this.reppbPK == null && other.reppbPK != null) || (this.reppbPK != null && !this.reppbPK.equals(other.reppbPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPPB[ reppbPK=" + reppbPK + " ]";
    }

    public String getPb510() {
        return pb510;
    }

    public void setPb510(String pb510) {
        this.pb510 = pb510;
    }

    public BigDecimal getPb500() {
        return pb500;
    }

    public void setPb500(BigDecimal pb500) {
        this.pb500 = pb500;
    }

    public String getPb502() {
        return pb502;
    }

    public void setPb502(String pb502) {
        this.pb502 = pb502;
    }

    public String getPb503() {
        return pb503;
    }

    public void setPb503(String pb503) {
        this.pb503 = pb503;
    }

    public String getPb513() {
        return pb513;
    }

    public void setPb513(String pb513) {
        this.pb513 = pb513;
    }

    public String getPb514() {
        return pb514;
    }

    public void setPb514(String pb514) {
        this.pb514 = pb514;
    }

    public String getPb515() {
        return pb515;
    }

    public void setPb515(String pb515) {
        this.pb515 = pb515;
    }

    public String getPb516() {
        return pb516;
    }

    public void setPb516(String pb516) {
        this.pb516 = pb516;
    }

    public String getPb517() {
        return pb517;
    }

    public void setPb517(String pb517) {
        this.pb517 = pb517;
    }

    public String getPb518() {
        return pb518;
    }

    public void setPb518(String pb518) {
        this.pb518 = pb518;
    }

    public String getPb519() {
        return pb519;
    }

    public void setPb519(String pb519) {
        this.pb519 = pb519;
    }

}
