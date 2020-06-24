/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
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
 * @author C2082
 */
@Entity
@Table(name = "WARMQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARMQ.findAll", query = "SELECT w FROM WARMQ w"),
    @NamedQuery(name = "WARMQ.findByCompany", query = "SELECT w FROM WARMQ w WHERE w.company = :company"),
    @NamedQuery(name = "WARMQ.findByCreator", query = "SELECT w FROM WARMQ w WHERE w.creator = :creator"),
    @NamedQuery(name = "WARMQ.findByUsrGroup", query = "SELECT w FROM WARMQ w WHERE w.usrGroup = :usrGroup"),
    @NamedQuery(name = "WARMQ.findByCreateDate", query = "SELECT w FROM WARMQ w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WARMQ.findByModifier", query = "SELECT w FROM WARMQ w WHERE w.modifier = :modifier"),
    @NamedQuery(name = "WARMQ.findByModiDate", query = "SELECT w FROM WARMQ w WHERE w.modiDate = :modiDate"),
    @NamedQuery(name = "WARMQ.findByFlag", query = "SELECT w FROM WARMQ w WHERE w.flag = :flag"),
    @NamedQuery(name = "WARMQ.findByMq001", query = "SELECT w FROM WARMQ w WHERE w.mq001 = :mq001"),
    @NamedQuery(name = "WARMQ.findByMq002", query = "SELECT w FROM WARMQ w WHERE w.mq002 = :mq002"),
    @NamedQuery(name = "WARMQ.findByMq003", query = "SELECT w FROM WARMQ w WHERE w.mq003 = :mq003"),
    @NamedQuery(name = "WARMQ.findByMq004", query = "SELECT w FROM WARMQ w WHERE w.mq004 = :mq004"),
    @NamedQuery(name = "WARMQ.findByMq005", query = "SELECT w FROM WARMQ w WHERE w.mq005 = :mq005"),
    @NamedQuery(name = "WARMQ.findByMq006", query = "SELECT w FROM WARMQ w WHERE w.mq006 = :mq006"),
    @NamedQuery(name = "WARMQ.findByMq007", query = "SELECT w FROM WARMQ w WHERE w.mq007 = :mq007"),
    @NamedQuery(name = "WARMQ.findByMq008", query = "SELECT w FROM WARMQ w WHERE w.mq008 = :mq008"),
    @NamedQuery(name = "WARMQ.findByMq009", query = "SELECT w FROM WARMQ w WHERE w.mq009 = :mq009"),
    @NamedQuery(name = "WARMQ.findByMq010", query = "SELECT w FROM WARMQ w WHERE w.mq010 = :mq010"),
    @NamedQuery(name = "WARMQ.findByMq011", query = "SELECT w FROM WARMQ w WHERE w.mq011 = :mq011"),
    @NamedQuery(name = "WARMQ.findByMq012", query = "SELECT w FROM WARMQ w WHERE w.mq012 = :mq012"),
    @NamedQuery(name = "WARMQ.findByMq013", query = "SELECT w FROM WARMQ w WHERE w.mq013 = :mq013"),
    @NamedQuery(name = "WARMQ.findByMq014", query = "SELECT w FROM WARMQ w WHERE w.mq014 = :mq014"),
    @NamedQuery(name = "WARMQ.findByMq015", query = "SELECT w FROM WARMQ w WHERE w.mq015 = :mq015"),
    @NamedQuery(name = "WARMQ.findByMq016", query = "SELECT w FROM WARMQ w WHERE w.mq016 = :mq016"),
    @NamedQuery(name = "WARMQ.findByMq017", query = "SELECT w FROM WARMQ w WHERE w.mq017 = :mq017"),
    @NamedQuery(name = "WARMQ.findByMq018", query = "SELECT w FROM WARMQ w WHERE w.mq018 = :mq018"),
    @NamedQuery(name = "WARMQ.findByMq019", query = "SELECT w FROM WARMQ w WHERE w.mq019 = :mq019"),
    @NamedQuery(name = "WARMQ.findByMq020", query = "SELECT w FROM WARMQ w WHERE w.mq020 = :mq020"),
    @NamedQuery(name = "WARMQ.findByMq021", query = "SELECT w FROM WARMQ w WHERE w.mq021 = :mq021"),
    @NamedQuery(name = "WARMQ.findByCustomer", query = "SELECT w FROM WARMQ w WHERE w.customer = :customer"),
    @NamedQuery(name = "WARMQ.findByProduct", query = "SELECT w FROM WARMQ w WHERE w.product = :product"),
    @NamedQuery(name = "WARMQ.findByRegion", query = "SELECT w FROM WARMQ w WHERE w.region = :region"),
    @NamedQuery(name = "WARMQ.findByDealer", query = "SELECT w FROM WARMQ w WHERE w.dealer = :dealer"),
    @NamedQuery(name = "WARMQ.findByMq022", query = "SELECT w FROM WARMQ w WHERE w.mq022 = :mq022"),
    @NamedQuery(name = "WARMQ.findByMq023", query = "SELECT w FROM WARMQ w WHERE w.mq023 = :mq023"),
    @NamedQuery(name = "WARMQ.findByMq024", query = "SELECT w FROM WARMQ w WHERE w.mq024 = :mq024"),
    @NamedQuery(name = "WARMQ.findByMq025", query = "SELECT w FROM WARMQ w WHERE w.mq025 = :mq025"),
    @NamedQuery(name = "WARMQ.findByWarmq01", query = "SELECT w FROM WARMQ w WHERE w.warmq01 = :warmq01"),
    @NamedQuery(name = "WARMQ.findByWarmq02", query = "SELECT w FROM WARMQ w WHERE w.warmq02 = :warmq02"),
    @NamedQuery(name = "WARMQ.findByWarmq03", query = "SELECT w FROM WARMQ w WHERE w.warmq03 = :warmq03"),
    @NamedQuery(name = "WARMQ.findByWarmq04", query = "SELECT w FROM WARMQ w WHERE w.warmq04 = :warmq04"),
    @NamedQuery(name = "WARMQ.findByWarmq05", query = "SELECT w FROM WARMQ w WHERE w.warmq05 = :warmq05"),
    @NamedQuery(name = "WARMQ.findByWarmq06", query = "SELECT w FROM WARMQ w WHERE w.warmq06 = :warmq06"),
    @NamedQuery(name = "WARMQ.findByWarmq07", query = "SELECT w FROM WARMQ w WHERE w.warmq07 = :warmq07"),
    @NamedQuery(name = "WARMQ.findByWarmq08", query = "SELECT w FROM WARMQ w WHERE w.warmq08 = :warmq08"),
    @NamedQuery(name = "WARMQ.findByWarmq09", query = "SELECT w FROM WARMQ w WHERE w.warmq09 = :warmq09"),
    @NamedQuery(name = "WARMQ.findByWarmq10", query = "SELECT w FROM WARMQ w WHERE w.warmq10 = :warmq10"),
    @NamedQuery(name = "WARMQ.findByWarmq11", query = "SELECT w FROM WARMQ w WHERE w.warmq11 = :warmq11"),
    @NamedQuery(name = "WARMQ.findByWarmq12", query = "SELECT w FROM WARMQ w WHERE w.warmq12 = :warmq12"),
    @NamedQuery(name = "WARMQ.findByWarmq13", query = "SELECT w FROM WARMQ w WHERE w.warmq13 = :warmq13"),
    @NamedQuery(name = "WARMQ.findByWarmq14", query = "SELECT w FROM WARMQ w WHERE w.warmq14 = :warmq14"),
    @NamedQuery(name = "WARMQ.findByWarmq15", query = "SELECT w FROM WARMQ w WHERE w.warmq15 = :warmq15"),
    @NamedQuery(name = "WARMQ.findByWarmq16", query = "SELECT w FROM WARMQ w WHERE w.warmq16 = :warmq16"),
    @NamedQuery(name = "WARMQ.findByWarmq17", query = "SELECT w FROM WARMQ w WHERE w.warmq17 = :warmq17"),
    @NamedQuery(name = "WARMQ.findByWarmq18", query = "SELECT w FROM WARMQ w WHERE w.warmq18 = :warmq18"),
    @NamedQuery(name = "WARMQ.findByWarmq19", query = "SELECT w FROM WARMQ w WHERE w.warmq19 = :warmq19"),
    @NamedQuery(name = "WARMQ.findByWarmq20", query = "SELECT w FROM WARMQ w WHERE w.warmq20 = :warmq20")})
public class WARMQ implements Serializable {

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
    @Size(min = 1, max = 4)
    @Column(name = "MQ001")
    private String mq001;
    @Size(max = 10)
    @Column(name = "MQ002")
    private String mq002;
    @Size(max = 2)
    @Column(name = "MQ003")
    private String mq003;
    @Size(max = 1)
    @Column(name = "MQ004")
    private String mq004;
    @Column(name = "MQ005")
    private Short mq005;
    @Column(name = "MQ006")
    private Short mq006;
    @Size(max = 1)
    @Column(name = "MQ007")
    private String mq007;
    @Size(max = 1)
    @Column(name = "MQ008")
    private String mq008;
    @Column(name = "MQ009")
    private Short mq009;
    @Size(max = 1)
    @Column(name = "MQ010")
    private String mq010;
    @Size(max = 1)
    @Column(name = "MQ011")
    private String mq011;
    @Size(max = 1)
    @Column(name = "MQ012")
    private String mq012;
    @Size(max = 1)
    @Column(name = "MQ013")
    private String mq013;
    @Size(max = 1)
    @Column(name = "MQ014")
    private String mq014;
    @Size(max = 255)
    @Column(name = "MQ015")
    private String mq015;
    @Size(max = 20)
    @Column(name = "MQ016")
    private String mq016;
    @Size(max = 1)
    @Column(name = "MQ017")
    private String mq017;
    @Size(max = 20)
    @Column(name = "MQ018")
    private String mq018;
    @Size(max = 1)
    @Column(name = "MQ019")
    private String mq019;
    @Size(max = 20)
    @Column(name = "MQ020")
    private String mq020;
    @Size(max = 10)
    @Column(name = "MQ021")
    private String mq021;
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
    @Size(max = 5)
    @Column(name = "MQ022")
    private String mq022;
    @Size(max = 10)
    @Column(name = "MQ023")
    private String mq023;
    @Size(max = 20)
    @Column(name = "MQ024")
    private String mq024;
    @Size(max = 60)
    @Column(name = "MQ025")
    private String mq025;
    @Size(max = 255)
    @Column(name = "WARMQ01")
    private String warmq01;
    @Size(max = 255)
    @Column(name = "WARMQ02")
    private String warmq02;
    @Size(max = 255)
    @Column(name = "WARMQ03")
    private String warmq03;
    @Size(max = 255)
    @Column(name = "WARMQ04")
    private String warmq04;
    @Size(max = 255)
    @Column(name = "WARMQ05")
    private String warmq05;
    @Size(max = 255)
    @Column(name = "WARMQ06")
    private String warmq06;
    @Size(max = 255)
    @Column(name = "WARMQ07")
    private String warmq07;
    @Size(max = 255)
    @Column(name = "WARMQ08")
    private String warmq08;
    @Size(max = 255)
    @Column(name = "WARMQ09")
    private String warmq09;
    @Size(max = 255)
    @Column(name = "WARMQ10")
    private String warmq10;
    @Size(max = 255)
    @Column(name = "WARMQ11")
    private String warmq11;
    @Size(max = 255)
    @Column(name = "WARMQ12")
    private String warmq12;
    @Size(max = 255)
    @Column(name = "WARMQ13")
    private String warmq13;
    @Size(max = 255)
    @Column(name = "WARMQ14")
    private String warmq14;
    @Size(max = 255)
    @Column(name = "WARMQ15")
    private String warmq15;
    @Size(max = 255)
    @Column(name = "WARMQ16")
    private String warmq16;
    @Size(max = 255)
    @Column(name = "WARMQ17")
    private String warmq17;
    @Size(max = 255)
    @Column(name = "WARMQ18")
    private String warmq18;
    @Size(max = 255)
    @Column(name = "WARMQ19")
    private String warmq19;
    @Size(max = 255)
    @Column(name = "WARMQ20")
    private String warmq20;

    public WARMQ() {
    }

    public WARMQ(String mq001) {
        this.mq001 = mq001;
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

    public String getMq001() {
        return mq001;
    }

    public void setMq001(String mq001) {
        this.mq001 = mq001;
    }

    public String getMq002() {
        return mq002;
    }

    public void setMq002(String mq002) {
        this.mq002 = mq002;
    }

    public String getMq003() {
        return mq003;
    }

    public void setMq003(String mq003) {
        this.mq003 = mq003;
    }

    public String getMq004() {
        return mq004;
    }

    public void setMq004(String mq004) {
        this.mq004 = mq004;
    }

    public Short getMq005() {
        return mq005;
    }

    public void setMq005(Short mq005) {
        this.mq005 = mq005;
    }

    public Short getMq006() {
        return mq006;
    }

    public void setMq006(Short mq006) {
        this.mq006 = mq006;
    }

    public String getMq007() {
        return mq007;
    }

    public void setMq007(String mq007) {
        this.mq007 = mq007;
    }

    public String getMq008() {
        return mq008;
    }

    public void setMq008(String mq008) {
        this.mq008 = mq008;
    }

    public Short getMq009() {
        return mq009;
    }

    public void setMq009(Short mq009) {
        this.mq009 = mq009;
    }

    public String getMq010() {
        return mq010;
    }

    public void setMq010(String mq010) {
        this.mq010 = mq010;
    }

    public String getMq011() {
        return mq011;
    }

    public void setMq011(String mq011) {
        this.mq011 = mq011;
    }

    public String getMq012() {
        return mq012;
    }

    public void setMq012(String mq012) {
        this.mq012 = mq012;
    }

    public String getMq013() {
        return mq013;
    }

    public void setMq013(String mq013) {
        this.mq013 = mq013;
    }

    public String getMq014() {
        return mq014;
    }

    public void setMq014(String mq014) {
        this.mq014 = mq014;
    }

    public String getMq015() {
        return mq015;
    }

    public void setMq015(String mq015) {
        this.mq015 = mq015;
    }

    public String getMq016() {
        return mq016;
    }

    public void setMq016(String mq016) {
        this.mq016 = mq016;
    }

    public String getMq017() {
        return mq017;
    }

    public void setMq017(String mq017) {
        this.mq017 = mq017;
    }

    public String getMq018() {
        return mq018;
    }

    public void setMq018(String mq018) {
        this.mq018 = mq018;
    }

    public String getMq019() {
        return mq019;
    }

    public void setMq019(String mq019) {
        this.mq019 = mq019;
    }

    public String getMq020() {
        return mq020;
    }

    public void setMq020(String mq020) {
        this.mq020 = mq020;
    }

    public String getMq021() {
        return mq021;
    }

    public void setMq021(String mq021) {
        this.mq021 = mq021;
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

    public String getMq022() {
        return mq022;
    }

    public void setMq022(String mq022) {
        this.mq022 = mq022;
    }

    public String getMq023() {
        return mq023;
    }

    public void setMq023(String mq023) {
        this.mq023 = mq023;
    }

    public String getMq024() {
        return mq024;
    }

    public void setMq024(String mq024) {
        this.mq024 = mq024;
    }

    public String getMq025() {
        return mq025;
    }

    public void setMq025(String mq025) {
        this.mq025 = mq025;
    }

    public String getWarmq01() {
        return warmq01;
    }

    public void setWarmq01(String warmq01) {
        this.warmq01 = warmq01;
    }

    public String getWarmq02() {
        return warmq02;
    }

    public void setWarmq02(String warmq02) {
        this.warmq02 = warmq02;
    }

    public String getWarmq03() {
        return warmq03;
    }

    public void setWarmq03(String warmq03) {
        this.warmq03 = warmq03;
    }

    public String getWarmq04() {
        return warmq04;
    }

    public void setWarmq04(String warmq04) {
        this.warmq04 = warmq04;
    }

    public String getWarmq05() {
        return warmq05;
    }

    public void setWarmq05(String warmq05) {
        this.warmq05 = warmq05;
    }

    public String getWarmq06() {
        return warmq06;
    }

    public void setWarmq06(String warmq06) {
        this.warmq06 = warmq06;
    }

    public String getWarmq07() {
        return warmq07;
    }

    public void setWarmq07(String warmq07) {
        this.warmq07 = warmq07;
    }

    public String getWarmq08() {
        return warmq08;
    }

    public void setWarmq08(String warmq08) {
        this.warmq08 = warmq08;
    }

    public String getWarmq09() {
        return warmq09;
    }

    public void setWarmq09(String warmq09) {
        this.warmq09 = warmq09;
    }

    public String getWarmq10() {
        return warmq10;
    }

    public void setWarmq10(String warmq10) {
        this.warmq10 = warmq10;
    }

    public String getWarmq11() {
        return warmq11;
    }

    public void setWarmq11(String warmq11) {
        this.warmq11 = warmq11;
    }

    public String getWarmq12() {
        return warmq12;
    }

    public void setWarmq12(String warmq12) {
        this.warmq12 = warmq12;
    }

    public String getWarmq13() {
        return warmq13;
    }

    public void setWarmq13(String warmq13) {
        this.warmq13 = warmq13;
    }

    public String getWarmq14() {
        return warmq14;
    }

    public void setWarmq14(String warmq14) {
        this.warmq14 = warmq14;
    }

    public String getWarmq15() {
        return warmq15;
    }

    public void setWarmq15(String warmq15) {
        this.warmq15 = warmq15;
    }

    public String getWarmq16() {
        return warmq16;
    }

    public void setWarmq16(String warmq16) {
        this.warmq16 = warmq16;
    }

    public String getWarmq17() {
        return warmq17;
    }

    public void setWarmq17(String warmq17) {
        this.warmq17 = warmq17;
    }

    public String getWarmq18() {
        return warmq18;
    }

    public void setWarmq18(String warmq18) {
        this.warmq18 = warmq18;
    }

    public String getWarmq19() {
        return warmq19;
    }

    public void setWarmq19(String warmq19) {
        this.warmq19 = warmq19;
    }

    public String getWarmq20() {
        return warmq20;
    }

    public void setWarmq20(String warmq20) {
        this.warmq20 = warmq20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mq001 != null ? mq001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARMQ)) {
            return false;
        }
        WARMQ other = (WARMQ) object;
        if ((this.mq001 == null && other.mq001 != null) || (this.mq001 != null && !this.mq001.equals(other.mq001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARMQ[ mq001=" + mq001 + " ]";
    }
    
}
