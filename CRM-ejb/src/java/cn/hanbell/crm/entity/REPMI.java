/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
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
@Table(name = "REPMI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPMI.findAll", query = "SELECT r FROM REPMI r"),
    @NamedQuery(name = "REPMI.findByCompany", query = "SELECT r FROM REPMI r WHERE r.company = :company"),
    @NamedQuery(name = "REPMI.findByCreator", query = "SELECT r FROM REPMI r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPMI.findByUsrGroup", query = "SELECT r FROM REPMI r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPMI.findByCreateDate", query = "SELECT r FROM REPMI r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPMI.findByModifier", query = "SELECT r FROM REPMI r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPMI.findByModiDate", query = "SELECT r FROM REPMI r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPMI.findByFlag", query = "SELECT r FROM REPMI r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPMI.findByMi001", query = "SELECT r FROM REPMI r WHERE r.repmiPK.mi001 = :mi001"),
    @NamedQuery(name = "REPMI.findByMi002", query = "SELECT r FROM REPMI r WHERE r.repmiPK.mi002 = :mi002"),
    @NamedQuery(name = "REPMI.findByPK", query = "SELECT r FROM REPMI r WHERE r.repmiPK.mi001 = :mi001 AND r.repmiPK.mi002 = :mi002"),
    @NamedQuery(name = "REPMI.findByMi003", query = "SELECT r FROM REPMI r WHERE r.mi003 = :mi003"),
    @NamedQuery(name = "REPMI.findByMi013", query = "SELECT r FROM REPMI r WHERE r.mi013 = :mi013"),
    @NamedQuery(name = "REPMI.findByCustomer", query = "SELECT r FROM REPMI r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPMI.findByProduct", query = "SELECT r FROM REPMI r WHERE r.product = :product"),
    @NamedQuery(name = "REPMI.findByRegion", query = "SELECT r FROM REPMI r WHERE r.region = :region"),
    @NamedQuery(name = "REPMI.findByDealer", query = "SELECT r FROM REPMI r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPMI.findByRepmi01", query = "SELECT r FROM REPMI r WHERE r.repmi01 = :repmi01"),
    @NamedQuery(name = "REPMI.findByRepmi02", query = "SELECT r FROM REPMI r WHERE r.repmi02 = :repmi02")})
public class REPMI implements Serializable  {

    @Size(max = 1)
    @Column(name = "MI503")
    private String mi503;
    @Size(max = 8)
    @Column(name = "MI504")
    private String mi504;
    @Size(max = 8)
    @Column(name = "MI505")
    private String mi505;
    @Size(max = 50)
    @Column(name = "MI506")
    private String mi506;
    @Size(max = 120)
    @Column(name = "MI507")
    private String mi507;

    @EmbeddedId
    protected REPMIPK repmiPK;
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
    @Column(name = "MI003")
    private String mi003;
    @Size(max = 1)
    @Column(name = "MI004")
    private String mi004;
    @Size(max = 1)
    @Column(name = "MI005")
    private String mi005;
    @Size(max = 8)
    @Column(name = "MI006")
    private String mi006;
    @Size(max = 8)
    @Column(name = "MI007")
    private String mi007;
    @Size(max = 8)
    @Column(name = "MI008")
    private String mi008;
    @Size(max = 8)
    @Column(name = "MI009")
    private String mi009;
    @Size(max = 30)
    @Column(name = "MI010")
    private String mi010;
    @Size(max = 1)
    @Column(name = "MI011")
    private String mi011;
    @Size(max = 120)
    @Column(name = "MI012")
    private String mi012;
    @Size(max = 1)
    @Column(name = "MI013")
    private String mi013;
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
    @Column(name = "REPMI01")
    private String repmi01;
    @Size(max = 255)
    @Column(name = "REPMI02")
    private String repmi02;
    @Size(max = 255)
    @Column(name = "REPMI03")
    private String repmi03;
    @Size(max = 255)
    @Column(name = "REPMI04")
    private String repmi04;
    @Size(max = 255)
    @Column(name = "REPMI05")
    private String repmi05;
    @Size(max = 255)
    @Column(name = "REPMI06")
    private String repmi06;
    @Size(max = 255)
    @Column(name = "REPMI07")
    private String repmi07;
    @Size(max = 255)
    @Column(name = "REPMI08")
    private String repmi08;
    @Size(max = 255)
    @Column(name = "REPMI09")
    private String repmi09;
    @Size(max = 255)
    @Column(name = "REPMI10")
    private String repmi10;
    @Size(max = 255)
    @Column(name = "REPMI11")
    private String repmi11;
    @Size(max = 255)
    @Column(name = "REPMI12")
    private String repmi12;
    @Size(max = 255)
    @Column(name = "REPMI13")
    private String repmi13;
    @Size(max = 255)
    @Column(name = "REPMI14")
    private String repmi14;
    @Size(max = 255)
    @Column(name = "REPMI15")
    private String repmi15;
    @Size(max = 255)
    @Column(name = "REPMI16")
    private String repmi16;
    @Size(max = 255)
    @Column(name = "REPMI17")
    private String repmi17;
    @Size(max = 255)
    @Column(name = "REPMI18")
    private String repmi18;
    @Size(max = 255)
    @Column(name = "REPMI19")
    private String repmi19;
    @Size(max = 255)
    @Column(name = "REPMI20")
    private String repmi20;
    @Size(max = 50)
    @Column(name = "MI500")
    private String mi500;
    @Size(max = 120)
    @Column(name = "MI501")
    private String mi501;
    @Size(max = 50)
    @Column(name = "MI502")
    private String mi502;

    public REPMI() {
    }

    public REPMI(REPMIPK repmiPK) {
        this.repmiPK = repmiPK;
    }

    public REPMI(String mi001, String mi002) {
        this.repmiPK = new REPMIPK(mi001, mi002);
    }

    public REPMIPK getREPMIPK() {
        return repmiPK;
    }

    public void setREPMIPK(REPMIPK repmiPK) {
        this.repmiPK = repmiPK;
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

    public String getMi003() {
        return mi003;
    }

    public void setMi003(String mi003) {
        this.mi003 = mi003;
    }

    public String getMi004() {
        return mi004;
    }

    public void setMi004(String mi004) {
        this.mi004 = mi004;
    }

    public String getMi005() {
        return mi005;
    }

    public void setMi005(String mi005) {
        this.mi005 = mi005;
    }

    public String getMi006() {
        return mi006;
    }

    public void setMi006(String mi006) {
        this.mi006 = mi006;
    }

    public String getMi007() {
        return mi007;
    }

    public void setMi007(String mi007) {
        this.mi007 = mi007;
    }

    public String getMi008() {
        return mi008;
    }

    public void setMi008(String mi008) {
        this.mi008 = mi008;
    }

    public String getMi009() {
        return mi009;
    }

    public void setMi009(String mi009) {
        this.mi009 = mi009;
    }

    public String getMi010() {
        return mi010;
    }

    public void setMi010(String mi010) {
        this.mi010 = mi010;
    }

    public String getMi011() {
        return mi011;
    }

    public void setMi011(String mi011) {
        this.mi011 = mi011;
    }

    public String getMi012() {
        return mi012;
    }

    public void setMi012(String mi012) {
        this.mi012 = mi012;
    }

    public String getMi013() {
        return mi013;
    }

    public void setMi013(String mi013) {
        this.mi013 = mi013;
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

    public String getRepmi01() {
        return repmi01;
    }

    public void setRepmi01(String repmi01) {
        this.repmi01 = repmi01;
    }

    public String getRepmi02() {
        return repmi02;
    }

    public void setRepmi02(String repmi02) {
        this.repmi02 = repmi02;
    }

    public String getRepmi03() {
        return repmi03;
    }

    public void setRepmi03(String repmi03) {
        this.repmi03 = repmi03;
    }

    public String getRepmi04() {
        return repmi04;
    }

    public void setRepmi04(String repmi04) {
        this.repmi04 = repmi04;
    }

    public String getRepmi05() {
        return repmi05;
    }

    public void setRepmi05(String repmi05) {
        this.repmi05 = repmi05;
    }

    public String getRepmi06() {
        return repmi06;
    }

    public void setRepmi06(String repmi06) {
        this.repmi06 = repmi06;
    }

    public String getRepmi07() {
        return repmi07;
    }

    public void setRepmi07(String repmi07) {
        this.repmi07 = repmi07;
    }

    public String getRepmi08() {
        return repmi08;
    }

    public void setRepmi08(String repmi08) {
        this.repmi08 = repmi08;
    }

    public String getRepmi09() {
        return repmi09;
    }

    public void setRepmi09(String repmi09) {
        this.repmi09 = repmi09;
    }

    public String getRepmi10() {
        return repmi10;
    }

    public void setRepmi10(String repmi10) {
        this.repmi10 = repmi10;
    }

    public String getRepmi11() {
        return repmi11;
    }

    public void setRepmi11(String repmi11) {
        this.repmi11 = repmi11;
    }

    public String getRepmi12() {
        return repmi12;
    }

    public void setRepmi12(String repmi12) {
        this.repmi12 = repmi12;
    }

    public String getRepmi13() {
        return repmi13;
    }

    public void setRepmi13(String repmi13) {
        this.repmi13 = repmi13;
    }

    public String getRepmi14() {
        return repmi14;
    }

    public void setRepmi14(String repmi14) {
        this.repmi14 = repmi14;
    }

    public String getRepmi15() {
        return repmi15;
    }

    public void setRepmi15(String repmi15) {
        this.repmi15 = repmi15;
    }

    public String getRepmi16() {
        return repmi16;
    }

    public void setRepmi16(String repmi16) {
        this.repmi16 = repmi16;
    }

    public String getRepmi17() {
        return repmi17;
    }

    public void setRepmi17(String repmi17) {
        this.repmi17 = repmi17;
    }

    public String getRepmi18() {
        return repmi18;
    }

    public void setRepmi18(String repmi18) {
        this.repmi18 = repmi18;
    }

    public String getRepmi19() {
        return repmi19;
    }

    public void setRepmi19(String repmi19) {
        this.repmi19 = repmi19;
    }

    public String getRepmi20() {
        return repmi20;
    }

    public void setRepmi20(String repmi20) {
        this.repmi20 = repmi20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repmiPK != null ? repmiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMI)) {
            return false;
        }
        REPMI other = (REPMI) object;
        if ((this.repmiPK == null && other.repmiPK != null) || (this.repmiPK != null && !this.repmiPK.equals(other.repmiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMI[ repmiPK=" + repmiPK + " ]";
    }

    public String getMi500() {
        return mi500;
    }

    public void setMi500(String mi500) {
        this.mi500 = mi500;
    }

    public String getMi501() {
        return mi501;
    }

    public void setMi501(String mi501) {
        this.mi501 = mi501;
    }

    public String getMi502() {
        return mi502;
    }

    public void setMi502(String mi502) {
        this.mi502 = mi502;
    }

    public String getMi503() {
        return mi503;
    }

    public void setMi503(String mi503) {
        this.mi503 = mi503;
    }

    public String getMi504() {
        return mi504;
    }

    public void setMi504(String mi504) {
        this.mi504 = mi504;
    }

    public String getMi505() {
        return mi505;
    }

    public void setMi505(String mi505) {
        this.mi505 = mi505;
    }

    public String getMi506() {
        return mi506;
    }

    public void setMi506(String mi506) {
        this.mi506 = mi506;
    }

    public String getMi507() {
        return mi507;
    }

    public void setMi507(String mi507) {
        this.mi507 = mi507;
    }
    
}
