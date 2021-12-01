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
@Table(name = "SALFT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SALFT.findAll", query = "SELECT s FROM SALFT s"),
    @NamedQuery(name = "SALFT.findByCompany", query = "SELECT s FROM SALFT s WHERE s.company = :company"),
    @NamedQuery(name = "SALFT.findByCreator", query = "SELECT s FROM SALFT s WHERE s.creator = :creator"),
    @NamedQuery(name = "SALFT.findByUsrGroup", query = "SELECT s FROM SALFT s WHERE s.usrGroup = :usrGroup"),
    @NamedQuery(name = "SALFT.findByCreateDate", query = "SELECT s FROM SALFT s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SALFT.findByModifier", query = "SELECT s FROM SALFT s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SALFT.findByModiDate", query = "SELECT s FROM SALFT s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SALFT.findByFlag", query = "SELECT s FROM SALFT s WHERE s.flag = :flag"),
    @NamedQuery(name = "SALFT.findByFt001", query = "SELECT s FROM SALFT s WHERE s.sALFTPK.ft001 = :ft001"),
    @NamedQuery(name = "SALFT.findByFt002", query = "SELECT s FROM SALFT s WHERE s.sALFTPK.ft002 = :ft002"),
    @NamedQuery(name = "SALFT.findByCustomer", query = "SELECT s FROM SALFT s WHERE s.customer = :customer"),
    @NamedQuery(name = "SALFT.findByProduct", query = "SELECT s FROM SALFT s WHERE s.product = :product"),
    @NamedQuery(name = "SALFT.findByRegion", query = "SELECT s FROM SALFT s WHERE s.region = :region"),
    @NamedQuery(name = "SALFT.findByDealer", query = "SELECT s FROM SALFT s WHERE s.dealer = :dealer"),
    @NamedQuery(name = "SALFT.findBySalft01", query = "SELECT s FROM SALFT s WHERE s.salft01 = :salft01"),
    @NamedQuery(name = "SALFT.findBySalft02", query = "SELECT s FROM SALFT s WHERE s.salft02 = :salft02"),
    @NamedQuery(name = "SALFT.findBySalft03", query = "SELECT s FROM SALFT s WHERE s.salft03 = :salft03")})
public class SALFT implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SALFTPK sALFTPK;
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
    @Size(max = 10)
    @Column(name = "FT003")
    private String ft003;
    @Size(max = 8)
    @Column(name = "FT004")
    private String ft004;
    @Size(max = 100)
    @Column(name = "FT005")
    private String ft005;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FT006")
    private BigDecimal ft006;
    @Size(max = 6)
    @Column(name = "FT007")
    private String ft007;
    @Size(max = 255)
    @Column(name = "FT008")
    private String ft008;
    @Size(max = 50)
    @Column(name = "FT009")
    private String ft009;
    @Size(max = 50)
    @Column(name = "FT010")
    private String ft010;
    @Column(name = "FT011")
    private BigDecimal ft011;
    @Column(name = "FT012")
    private BigDecimal ft012;
    @Column(name = "FT013")
    private BigDecimal ft013;
    @Size(max = 10)
    @Column(name = "FT014")
    private String ft014;
    @Column(name = "FT015")
    private BigDecimal ft015;
    @Column(name = "FT016")
    private BigDecimal ft016;
    @Column(name = "FT017")
    private BigDecimal ft017;
    @Size(max = 1)
    @Column(name = "FT018")
    private String ft018;
    @Size(max = 30)
    @Column(name = "FT019")
    private String ft019;
    @Size(max = 60)
    @Column(name = "FT020")
    private String ft020;
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
    @Column(name = "SALFT01")
    private String salft01;
    @Size(max = 255)
    @Column(name = "SALFT02")
    private String salft02;
    @Size(max = 255)
    @Column(name = "SALFT03")
    private String salft03;
    @Size(max = 255)
    @Column(name = "SALFT04")
    private String salft04;
    @Size(max = 255)
    @Column(name = "SALFT05")
    private String salft05;
    @Size(max = 255)
    @Column(name = "SALFT06")
    private String salft06;
    @Size(max = 255)
    @Column(name = "SALFT07")
    private String salft07;
    @Size(max = 255)
    @Column(name = "SALFT08")
    private String salft08;
    @Size(max = 255)
    @Column(name = "SALFT09")
    private String salft09;
    @Size(max = 255)
    @Column(name = "SALFT10")
    private String salft10;
    @Size(max = 255)
    @Column(name = "SALFT11")
    private String salft11;
    @Size(max = 255)
    @Column(name = "SALFT12")
    private String salft12;
    @Size(max = 255)
    @Column(name = "SALFT13")
    private String salft13;
    @Size(max = 255)
    @Column(name = "SALFT14")
    private String salft14;
    @Size(max = 255)
    @Column(name = "SALFT15")
    private String salft15;
    @Size(max = 255)
    @Column(name = "SALFT16")
    private String salft16;
    @Size(max = 255)
    @Column(name = "SALFT17")
    private String salft17;
    @Size(max = 255)
    @Column(name = "SALFT18")
    private String salft18;
    @Size(max = 255)
    @Column(name = "SALFT19")
    private String salft19;
    @Size(max = 255)
    @Column(name = "SALFT20")
    private String salft20;
    @Size(max = 4)
    @Column(name = "FT021")
    private String ft021;
    @Size(max = 11)
    @Column(name = "FT022")
    private String ft022;
    @Size(max = 4)
    @Column(name = "FT023")
    private String ft023;
    @Size(max = 10)
    @Column(name = "FT024")
    private String ft024;
    @Size(max = 1)
    @Column(name = "FT025")
    private String ft025;
    @Size(max = 1)
    @Column(name = "FT026")
    private String ft026;
    @Column(name = "FT027")
    private BigDecimal ft027;
    @Column(name = "FT028")
    private BigDecimal ft028;
    @Column(name = "FT029")
    private BigDecimal ft029;
    @Column(name = "FT030")
    private BigDecimal ft030;

    public SALFT() {
    }

    public SALFT(SALFTPK sALFTPK) {
        this.sALFTPK = sALFTPK;
    }

    public SALFT(String ft001, String ft002) {
        this.sALFTPK = new SALFTPK(ft001, ft002);
    }

    public SALFTPK getSALFTPK() {
        return sALFTPK;
    }

    public void setSALFTPK(SALFTPK sALFTPK) {
        this.sALFTPK = sALFTPK;
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

    public String getFt003() {
        return ft003;
    }

    public void setFt003(String ft003) {
        this.ft003 = ft003;
    }

    public String getFt004() {
        return ft004;
    }

    public void setFt004(String ft004) {
        this.ft004 = ft004;
    }

    public String getFt005() {
        return ft005;
    }

    public void setFt005(String ft005) {
        this.ft005 = ft005;
    }

    public BigDecimal getFt006() {
        return ft006;
    }

    public void setFt006(BigDecimal ft006) {
        this.ft006 = ft006;
    }

    public String getFt007() {
        return ft007;
    }

    public void setFt007(String ft007) {
        this.ft007 = ft007;
    }

    public String getFt008() {
        return ft008;
    }

    public void setFt008(String ft008) {
        this.ft008 = ft008;
    }

    public String getFt009() {
        return ft009;
    }

    public void setFt009(String ft009) {
        this.ft009 = ft009;
    }

    public String getFt010() {
        return ft010;
    }

    public void setFt010(String ft010) {
        this.ft010 = ft010;
    }

    public BigDecimal getFt011() {
        return ft011;
    }

    public void setFt011(BigDecimal ft011) {
        this.ft011 = ft011;
    }

    public BigDecimal getFt012() {
        return ft012;
    }

    public void setFt012(BigDecimal ft012) {
        this.ft012 = ft012;
    }

    public BigDecimal getFt013() {
        return ft013;
    }

    public void setFt013(BigDecimal ft013) {
        this.ft013 = ft013;
    }

    public String getFt014() {
        return ft014;
    }

    public void setFt014(String ft014) {
        this.ft014 = ft014;
    }

    public BigDecimal getFt015() {
        return ft015;
    }

    public void setFt015(BigDecimal ft015) {
        this.ft015 = ft015;
    }

    public BigDecimal getFt016() {
        return ft016;
    }

    public void setFt016(BigDecimal ft016) {
        this.ft016 = ft016;
    }

    public BigDecimal getFt017() {
        return ft017;
    }

    public void setFt017(BigDecimal ft017) {
        this.ft017 = ft017;
    }

    public String getFt018() {
        return ft018;
    }

    public void setFt018(String ft018) {
        this.ft018 = ft018;
    }

    public String getFt019() {
        return ft019;
    }

    public void setFt019(String ft019) {
        this.ft019 = ft019;
    }

    public String getFt020() {
        return ft020;
    }

    public void setFt020(String ft020) {
        this.ft020 = ft020;
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

    public String getSalft01() {
        return salft01;
    }

    public void setSalft01(String salft01) {
        this.salft01 = salft01;
    }

    public String getSalft02() {
        return salft02;
    }

    public void setSalft02(String salft02) {
        this.salft02 = salft02;
    }

    public String getSalft03() {
        return salft03;
    }

    public void setSalft03(String salft03) {
        this.salft03 = salft03;
    }

    public String getSalft04() {
        return salft04;
    }

    public void setSalft04(String salft04) {
        this.salft04 = salft04;
    }

    public String getSalft05() {
        return salft05;
    }

    public void setSalft05(String salft05) {
        this.salft05 = salft05;
    }

    public String getSalft06() {
        return salft06;
    }

    public void setSalft06(String salft06) {
        this.salft06 = salft06;
    }

    public String getSalft07() {
        return salft07;
    }

    public void setSalft07(String salft07) {
        this.salft07 = salft07;
    }

    public String getSalft08() {
        return salft08;
    }

    public void setSalft08(String salft08) {
        this.salft08 = salft08;
    }

    public String getSalft09() {
        return salft09;
    }

    public void setSalft09(String salft09) {
        this.salft09 = salft09;
    }

    public String getSalft10() {
        return salft10;
    }

    public void setSalft10(String salft10) {
        this.salft10 = salft10;
    }

    public String getSalft11() {
        return salft11;
    }

    public void setSalft11(String salft11) {
        this.salft11 = salft11;
    }

    public String getSalft12() {
        return salft12;
    }

    public void setSalft12(String salft12) {
        this.salft12 = salft12;
    }

    public String getSalft13() {
        return salft13;
    }

    public void setSalft13(String salft13) {
        this.salft13 = salft13;
    }

    public String getSalft14() {
        return salft14;
    }

    public void setSalft14(String salft14) {
        this.salft14 = salft14;
    }

    public String getSalft15() {
        return salft15;
    }

    public void setSalft15(String salft15) {
        this.salft15 = salft15;
    }

    public String getSalft16() {
        return salft16;
    }

    public void setSalft16(String salft16) {
        this.salft16 = salft16;
    }

    public String getSalft17() {
        return salft17;
    }

    public void setSalft17(String salft17) {
        this.salft17 = salft17;
    }

    public String getSalft18() {
        return salft18;
    }

    public void setSalft18(String salft18) {
        this.salft18 = salft18;
    }

    public String getSalft19() {
        return salft19;
    }

    public void setSalft19(String salft19) {
        this.salft19 = salft19;
    }

    public String getSalft20() {
        return salft20;
    }

    public void setSalft20(String salft20) {
        this.salft20 = salft20;
    }

    public String getFt021() {
        return ft021;
    }

    public void setFt021(String ft021) {
        this.ft021 = ft021;
    }

    public String getFt022() {
        return ft022;
    }

    public void setFt022(String ft022) {
        this.ft022 = ft022;
    }

    public String getFt023() {
        return ft023;
    }

    public void setFt023(String ft023) {
        this.ft023 = ft023;
    }

    public String getFt024() {
        return ft024;
    }

    public void setFt024(String ft024) {
        this.ft024 = ft024;
    }

    public String getFt025() {
        return ft025;
    }

    public void setFt025(String ft025) {
        this.ft025 = ft025;
    }

    public String getFt026() {
        return ft026;
    }

    public void setFt026(String ft026) {
        this.ft026 = ft026;
    }

    public BigDecimal getFt027() {
        return ft027;
    }

    public void setFt027(BigDecimal ft027) {
        this.ft027 = ft027;
    }

    public BigDecimal getFt028() {
        return ft028;
    }

    public void setFt028(BigDecimal ft028) {
        this.ft028 = ft028;
    }

    public BigDecimal getFt029() {
        return ft029;
    }

    public void setFt029(BigDecimal ft029) {
        this.ft029 = ft029;
    }

    public BigDecimal getFt030() {
        return ft030;
    }

    public void setFt030(BigDecimal ft030) {
        this.ft030 = ft030;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sALFTPK != null ? sALFTPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SALFT)) {
            return false;
        }
        SALFT other = (SALFT) object;
        if ((this.sALFTPK == null && other.sALFTPK != null) || (this.sALFTPK != null && !this.sALFTPK.equals(other.sALFTPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SALFT[ sALFTPK=" + sALFTPK + " ]";
    }
    
}
