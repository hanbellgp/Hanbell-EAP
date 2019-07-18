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
@Table(name = "PORMY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pormy.findAll", query = "SELECT p FROM Pormy p"),
    @NamedQuery(name = "Pormy.findByCustomer", query = "SELECT p FROM Pormy p WHERE p.customer = :customer"),
    @NamedQuery(name = "Pormy.findByProduct", query = "SELECT p FROM Pormy p WHERE p.product = :product"),
    @NamedQuery(name = "Pormy.findByRegion", query = "SELECT p FROM Pormy p WHERE p.region = :region"),
    @NamedQuery(name = "Pormy.findByDealer", query = "SELECT p FROM Pormy p WHERE p.dealer = :dealer"),
    @NamedQuery(name = "Pormy.findByMy001", query = "SELECT p FROM Pormy p WHERE p.pormyPK.my001 = :my001"),
    @NamedQuery(name = "Pormy.findByMy002", query = "SELECT p FROM Pormy p WHERE p.pormyPK.my002 = :my002"),    
    @NamedQuery(name = "Pormy.findByPK", query = "SELECT p FROM Pormy p WHERE p.pormyPK = :pormyPK"),
    @NamedQuery(name = "Pormy.findByMy032", query = "SELECT p FROM Pormy p WHERE p.my032 = :my032"),
    @NamedQuery(name = "Pormy.findByMy033", query = "SELECT p FROM Pormy p WHERE p.my033 = :my033")})
public class Pormy implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PormyPK pormyPK;
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
    @Column(name = "PORMY01")
    private String pormy01;
    @Size(max = 255)
    @Column(name = "PORMY02")
    private String pormy02;
    @Size(max = 255)
    @Column(name = "PORMY03")
    private String pormy03;
    @Size(max = 255)
    @Column(name = "PORMY04")
    private String pormy04;
    @Size(max = 255)
    @Column(name = "PORMY05")
    private String pormy05;
    @Size(max = 255)
    @Column(name = "PORMY06")
    private String pormy06;
    @Size(max = 255)
    @Column(name = "PORMY07")
    private String pormy07;
    @Size(max = 255)
    @Column(name = "PORMY08")
    private String pormy08;
    @Size(max = 255)
    @Column(name = "PORMY09")
    private String pormy09;
    @Size(max = 255)
    @Column(name = "PORMY10")
    private String pormy10;
    @Size(max = 255)
    @Column(name = "PORMY11")
    private String pormy11;
    @Size(max = 255)
    @Column(name = "PORMY12")
    private String pormy12;
    @Size(max = 255)
    @Column(name = "PORMY13")
    private String pormy13;
    @Size(max = 255)
    @Column(name = "PORMY14")
    private String pormy14;
    @Size(max = 255)
    @Column(name = "PORMY15")
    private String pormy15;
    @Size(max = 255)
    @Column(name = "PORMY16")
    private String pormy16;
    @Size(max = 255)
    @Column(name = "PORMY17")
    private String pormy17;
    @Size(max = 255)
    @Column(name = "PORMY18")
    private String pormy18;
    @Size(max = 255)
    @Column(name = "PORMY19")
    private String pormy19;
    @Size(max = 255)
    @Column(name = "PORMY20")
    private String pormy20;
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
    @Size(max = 8)
    @Column(name = "MY003")
    private String my003;
    @Size(max = 10)
    @Column(name = "MY004")
    private String my004;
    @Size(max = 10)
    @Column(name = "MY005")
    private String my005;
    @Size(max = 6)
    @Column(name = "MY006")
    private String my006;
    @Size(max = 1)
    @Column(name = "MY007")
    private String my007;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MY008")
    private BigDecimal my008;
    @Size(max = 1)
    @Column(name = "MY009")
    private String my009;
    @Size(max = 10)
    @Column(name = "MY010")
    private String my010;
    @Size(max = 8)
    @Column(name = "MY011")
    private String my011;
    @Size(max = 1)
    @Column(name = "MY012")
    private String my012;
    @Size(max = 4)
    @Column(name = "MY013")
    private String my013;
    @Size(max = 11)
    @Column(name = "MY014")
    private String my014;
    @Size(max = 1)
    @Column(name = "MY015")
    private String my015;
    @Size(max = 255)
    @Column(name = "MY016")
    private String my016;
    @Size(max = 1000)
    @Column(name = "MY017")
    private String my017;
    @Size(max = 1000)
    @Column(name = "MY018")
    private String my018;
    @Size(max = 20)
    @Column(name = "MY019")
    private String my019;
    @Size(max = 40)
    @Column(name = "MY020")
    private String my020;
    @Size(max = 1)
    @Column(name = "MY021")
    private String my021;
    @Size(max = 1)
    @Column(name = "MY022")
    private String my022;
    @Size(max = 1)
    @Column(name = "MY023")
    private String my023;
    @Size(max = 10)
    @Column(name = "MY024")
    private String my024;
    @Size(max = 30)
    @Column(name = "MY025")
    private String my025;
    @Size(max = 30)
    @Column(name = "MY026")
    private String my026;
    @Size(max = 50)
    @Column(name = "MY027")
    private String my027;
    @Size(max = 50)
    @Column(name = "MY028")
    private String my028;
    @Size(max = 255)
    @Column(name = "MY029")
    private String my029;
    @Size(max = 255)
    @Column(name = "MY030")
    private String my030;
    @Size(max = 255)
    @Column(name = "MY031")
    private String my031;
    @Column(name = "MY032")
    private BigDecimal my032;
    @Column(name = "MY033")
    private BigDecimal my033;

    public Pormy() {
    }

    public Pormy(PormyPK pormyPK) {
        this.pormyPK = pormyPK;
    }

    public Pormy(String my001, String my002) {
        this.pormyPK = new PormyPK(my001, my002);
    }

    public PormyPK getPormyPK() {
        return pormyPK;
    }

    public void setPormyPK(PormyPK pormyPK) {
        this.pormyPK = pormyPK;
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

    public String getPormy01() {
        return pormy01;
    }

    public void setPormy01(String pormy01) {
        this.pormy01 = pormy01;
    }

    public String getPormy02() {
        return pormy02;
    }

    public void setPormy02(String pormy02) {
        this.pormy02 = pormy02;
    }

    public String getPormy03() {
        return pormy03;
    }

    public void setPormy03(String pormy03) {
        this.pormy03 = pormy03;
    }

    public String getPormy04() {
        return pormy04;
    }

    public void setPormy04(String pormy04) {
        this.pormy04 = pormy04;
    }

    public String getPormy05() {
        return pormy05;
    }

    public void setPormy05(String pormy05) {
        this.pormy05 = pormy05;
    }

    public String getPormy06() {
        return pormy06;
    }

    public void setPormy06(String pormy06) {
        this.pormy06 = pormy06;
    }

    public String getPormy07() {
        return pormy07;
    }

    public void setPormy07(String pormy07) {
        this.pormy07 = pormy07;
    }

    public String getPormy08() {
        return pormy08;
    }

    public void setPormy08(String pormy08) {
        this.pormy08 = pormy08;
    }

    public String getPormy09() {
        return pormy09;
    }

    public void setPormy09(String pormy09) {
        this.pormy09 = pormy09;
    }

    public String getPormy10() {
        return pormy10;
    }

    public void setPormy10(String pormy10) {
        this.pormy10 = pormy10;
    }

    public String getPormy11() {
        return pormy11;
    }

    public void setPormy11(String pormy11) {
        this.pormy11 = pormy11;
    }

    public String getPormy12() {
        return pormy12;
    }

    public void setPormy12(String pormy12) {
        this.pormy12 = pormy12;
    }

    public String getPormy13() {
        return pormy13;
    }

    public void setPormy13(String pormy13) {
        this.pormy13 = pormy13;
    }

    public String getPormy14() {
        return pormy14;
    }

    public void setPormy14(String pormy14) {
        this.pormy14 = pormy14;
    }

    public String getPormy15() {
        return pormy15;
    }

    public void setPormy15(String pormy15) {
        this.pormy15 = pormy15;
    }

    public String getPormy16() {
        return pormy16;
    }

    public void setPormy16(String pormy16) {
        this.pormy16 = pormy16;
    }

    public String getPormy17() {
        return pormy17;
    }

    public void setPormy17(String pormy17) {
        this.pormy17 = pormy17;
    }

    public String getPormy18() {
        return pormy18;
    }

    public void setPormy18(String pormy18) {
        this.pormy18 = pormy18;
    }

    public String getPormy19() {
        return pormy19;
    }

    public void setPormy19(String pormy19) {
        this.pormy19 = pormy19;
    }

    public String getPormy20() {
        return pormy20;
    }

    public void setPormy20(String pormy20) {
        this.pormy20 = pormy20;
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

    public String getMy003() {
        return my003;
    }

    public void setMy003(String my003) {
        this.my003 = my003;
    }

    public String getMy004() {
        return my004;
    }

    public void setMy004(String my004) {
        this.my004 = my004;
    }

    public String getMy005() {
        return my005;
    }

    public void setMy005(String my005) {
        this.my005 = my005;
    }

    public String getMy006() {
        return my006;
    }

    public void setMy006(String my006) {
        this.my006 = my006;
    }

    public String getMy007() {
        return my007;
    }

    public void setMy007(String my007) {
        this.my007 = my007;
    }

    public BigDecimal getMy008() {
        return my008;
    }

    public void setMy008(BigDecimal my008) {
        this.my008 = my008;
    }

    public String getMy009() {
        return my009;
    }

    public void setMy009(String my009) {
        this.my009 = my009;
    }

    public String getMy010() {
        return my010;
    }

    public void setMy010(String my010) {
        this.my010 = my010;
    }

    public String getMy011() {
        return my011;
    }

    public void setMy011(String my011) {
        this.my011 = my011;
    }

    public String getMy012() {
        return my012;
    }

    public void setMy012(String my012) {
        this.my012 = my012;
    }

    public String getMy013() {
        return my013;
    }

    public void setMy013(String my013) {
        this.my013 = my013;
    }

    public String getMy014() {
        return my014;
    }

    public void setMy014(String my014) {
        this.my014 = my014;
    }

    public String getMy015() {
        return my015;
    }

    public void setMy015(String my015) {
        this.my015 = my015;
    }

    public String getMy016() {
        return my016;
    }

    public void setMy016(String my016) {
        this.my016 = my016;
    }

    public String getMy017() {
        return my017;
    }

    public void setMy017(String my017) {
        this.my017 = my017;
    }

    public String getMy018() {
        return my018;
    }

    public void setMy018(String my018) {
        this.my018 = my018;
    }

    public String getMy019() {
        return my019;
    }

    public void setMy019(String my019) {
        this.my019 = my019;
    }

    public String getMy020() {
        return my020;
    }

    public void setMy020(String my020) {
        this.my020 = my020;
    }

    public String getMy021() {
        return my021;
    }

    public void setMy021(String my021) {
        this.my021 = my021;
    }

    public String getMy022() {
        return my022;
    }

    public void setMy022(String my022) {
        this.my022 = my022;
    }

    public String getMy023() {
        return my023;
    }

    public void setMy023(String my023) {
        this.my023 = my023;
    }

    public String getMy024() {
        return my024;
    }

    public void setMy024(String my024) {
        this.my024 = my024;
    }

    public String getMy025() {
        return my025;
    }

    public void setMy025(String my025) {
        this.my025 = my025;
    }

    public String getMy026() {
        return my026;
    }

    public void setMy026(String my026) {
        this.my026 = my026;
    }

    public String getMy027() {
        return my027;
    }

    public void setMy027(String my027) {
        this.my027 = my027;
    }

    public String getMy028() {
        return my028;
    }

    public void setMy028(String my028) {
        this.my028 = my028;
    }

    public String getMy029() {
        return my029;
    }

    public void setMy029(String my029) {
        this.my029 = my029;
    }

    public String getMy030() {
        return my030;
    }

    public void setMy030(String my030) {
        this.my030 = my030;
    }

    public String getMy031() {
        return my031;
    }

    public void setMy031(String my031) {
        this.my031 = my031;
    }

    public BigDecimal getMy032() {
        return my032;
    }

    public void setMy032(BigDecimal my032) {
        this.my032 = my032;
    }

    public BigDecimal getMy033() {
        return my033;
    }

    public void setMy033(BigDecimal my033) {
        this.my033 = my033;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pormyPK != null ? pormyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pormy)) {
            return false;
        }
        Pormy other = (Pormy) object;
        if ((this.pormyPK == null && other.pormyPK != null) || (this.pormyPK != null && !this.pormyPK.equals(other.pormyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.Pormy[ pormyPK=" + pormyPK + " ]";
    }
    
}
