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
 * @author Administrator
 */
@Entity
@Table(name = "REPMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPMA.findAll", query = "SELECT r FROM REPMA r")
    , @NamedQuery(name = "REPMA.findByCompany", query = "SELECT r FROM REPMA r WHERE r.company = :company")
    , @NamedQuery(name = "REPMA.findByCreator", query = "SELECT r FROM REPMA r WHERE r.creator = :creator")
    , @NamedQuery(name = "REPMA.findByUsrGroup", query = "SELECT r FROM REPMA r WHERE r.usrGroup = :usrGroup")
    , @NamedQuery(name = "REPMA.findByCreateDate", query = "SELECT r FROM REPMA r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "REPMA.findByModifier", query = "SELECT r FROM REPMA r WHERE r.modifier = :modifier")
    , @NamedQuery(name = "REPMA.findByModiDate", query = "SELECT r FROM REPMA r WHERE r.modiDate = :modiDate")
    , @NamedQuery(name = "REPMA.findByFlag", query = "SELECT r FROM REPMA r WHERE r.flag = :flag")
    , @NamedQuery(name = "REPMA.findByMa001", query = "SELECT r FROM REPMA r WHERE r.ma001 = :ma001")
    , @NamedQuery(name = "REPMA.findByMa002", query = "SELECT r FROM REPMA r WHERE r.ma002 = :ma002")
    , @NamedQuery(name = "REPMA.findByMa003", query = "SELECT r FROM REPMA r WHERE r.ma003 = :ma003")
    , @NamedQuery(name = "REPMA.findByCustomer", query = "SELECT r FROM REPMA r WHERE r.customer = :customer")
    , @NamedQuery(name = "REPMA.findByProduct", query = "SELECT r FROM REPMA r WHERE r.product = :product")
    , @NamedQuery(name = "REPMA.findByRegion", query = "SELECT r FROM REPMA r WHERE r.region = :region")
    , @NamedQuery(name = "REPMA.findByDealer", query = "SELECT r FROM REPMA r WHERE r.dealer = :dealer")
    , @NamedQuery(name = "REPMA.findByRepma01", query = "SELECT r FROM REPMA r WHERE r.repma01 = :repma01")
    , @NamedQuery(name = "REPMA.findByRepma02", query = "SELECT r FROM REPMA r WHERE r.repma02 = :repma02")
    , @NamedQuery(name = "REPMA.findByRepma03", query = "SELECT r FROM REPMA r WHERE r.repma03 = :repma03")
    , @NamedQuery(name = "REPMA.findByRepma04", query = "SELECT r FROM REPMA r WHERE r.repma04 = :repma04")})
public class REPMA implements Serializable {

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
    @Column(name = "MA001")
    private String ma001;
    @Size(max = 50)
    @Column(name = "MA002")
    private String ma002;
    @Size(max = 100)
    @Column(name = "MA003")
    private String ma003;
    @Column(name = "MA004")
    private Short ma004;
    @Size(max = 255)
    @Column(name = "MA005")
    private String ma005;
    @Size(max = 255)
    @Column(name = "MA006")
    private String ma006;
    @Size(max = 10)
    @Column(name = "MA007")
    private String ma007;
    @Size(max = 20)
    @Column(name = "MA008")
    private String ma008;
    @Size(max = 20)
    @Column(name = "MA009")
    private String ma009;
    @Size(max = 20)
    @Column(name = "MA010")
    private String ma010;
    @Size(max = 100)
    @Column(name = "MA011")
    private String ma011;
    @Size(max = 3)
    @Column(name = "MA012")
    private String ma012;
    @Size(max = 10)
    @Column(name = "MA013")
    private String ma013;
    @Size(max = 255)
    @Column(name = "MA014")
    private String ma014;
    @Size(max = 20)
    @Column(name = "MA015")
    private String ma015;
    @Size(max = 1)
    @Column(name = "MA016")
    private String ma016;
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
    @Column(name = "REPMA01")
    private String repma01;
    @Size(max = 255)
    @Column(name = "REPMA02")
    private String repma02;
    @Size(max = 255)
    @Column(name = "REPMA03")
    private String repma03;
    @Size(max = 255)
    @Column(name = "REPMA04")
    private String repma04;
    @Size(max = 255)
    @Column(name = "REPMA05")
    private String repma05;
    @Size(max = 255)
    @Column(name = "REPMA06")
    private String repma06;
    @Size(max = 255)
    @Column(name = "REPMA07")
    private String repma07;
    @Size(max = 255)
    @Column(name = "REPMA08")
    private String repma08;
    @Size(max = 255)
    @Column(name = "REPMA09")
    private String repma09;
    @Size(max = 255)
    @Column(name = "REPMA10")
    private String repma10;
    @Size(max = 255)
    @Column(name = "REPMA11")
    private String repma11;
    @Size(max = 255)
    @Column(name = "REPMA12")
    private String repma12;
    @Size(max = 255)
    @Column(name = "REPMA13")
    private String repma13;
    @Size(max = 255)
    @Column(name = "REPMA14")
    private String repma14;
    @Size(max = 255)
    @Column(name = "REPMA15")
    private String repma15;
    @Size(max = 255)
    @Column(name = "REPMA16")
    private String repma16;
    @Size(max = 255)
    @Column(name = "REPMA17")
    private String repma17;
    @Size(max = 255)
    @Column(name = "REPMA18")
    private String repma18;
    @Size(max = 255)
    @Column(name = "REPMA19")
    private String repma19;
    @Size(max = 255)
    @Column(name = "REPMA20")
    private String repma20;

    public REPMA() {
    }

    public REPMA(String ma001) {
        this.ma001 = ma001;
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

    public String getMa001() {
        return ma001;
    }

    public void setMa001(String ma001) {
        this.ma001 = ma001;
    }

    public String getMa002() {
        return ma002;
    }

    public void setMa002(String ma002) {
        this.ma002 = ma002;
    }

    public String getMa003() {
        return ma003;
    }

    public void setMa003(String ma003) {
        this.ma003 = ma003;
    }

    public Short getMa004() {
        return ma004;
    }

    public void setMa004(Short ma004) {
        this.ma004 = ma004;
    }

    public String getMa005() {
        return ma005;
    }

    public void setMa005(String ma005) {
        this.ma005 = ma005;
    }

    public String getMa006() {
        return ma006;
    }

    public void setMa006(String ma006) {
        this.ma006 = ma006;
    }

    public String getMa007() {
        return ma007;
    }

    public void setMa007(String ma007) {
        this.ma007 = ma007;
    }

    public String getMa008() {
        return ma008;
    }

    public void setMa008(String ma008) {
        this.ma008 = ma008;
    }

    public String getMa009() {
        return ma009;
    }

    public void setMa009(String ma009) {
        this.ma009 = ma009;
    }

    public String getMa010() {
        return ma010;
    }

    public void setMa010(String ma010) {
        this.ma010 = ma010;
    }

    public String getMa011() {
        return ma011;
    }

    public void setMa011(String ma011) {
        this.ma011 = ma011;
    }

    public String getMa012() {
        return ma012;
    }

    public void setMa012(String ma012) {
        this.ma012 = ma012;
    }

    public String getMa013() {
        return ma013;
    }

    public void setMa013(String ma013) {
        this.ma013 = ma013;
    }

    public String getMa014() {
        return ma014;
    }

    public void setMa014(String ma014) {
        this.ma014 = ma014;
    }

    public String getMa015() {
        return ma015;
    }

    public void setMa015(String ma015) {
        this.ma015 = ma015;
    }

    public String getMa016() {
        return ma016;
    }

    public void setMa016(String ma016) {
        this.ma016 = ma016;
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

    public String getRepma01() {
        return repma01;
    }

    public void setRepma01(String repma01) {
        this.repma01 = repma01;
    }

    public String getRepma02() {
        return repma02;
    }

    public void setRepma02(String repma02) {
        this.repma02 = repma02;
    }

    public String getRepma03() {
        return repma03;
    }

    public void setRepma03(String repma03) {
        this.repma03 = repma03;
    }

    public String getRepma04() {
        return repma04;
    }

    public void setRepma04(String repma04) {
        this.repma04 = repma04;
    }

    public String getRepma05() {
        return repma05;
    }

    public void setRepma05(String repma05) {
        this.repma05 = repma05;
    }

    public String getRepma06() {
        return repma06;
    }

    public void setRepma06(String repma06) {
        this.repma06 = repma06;
    }

    public String getRepma07() {
        return repma07;
    }

    public void setRepma07(String repma07) {
        this.repma07 = repma07;
    }

    public String getRepma08() {
        return repma08;
    }

    public void setRepma08(String repma08) {
        this.repma08 = repma08;
    }

    public String getRepma09() {
        return repma09;
    }

    public void setRepma09(String repma09) {
        this.repma09 = repma09;
    }

    public String getRepma10() {
        return repma10;
    }

    public void setRepma10(String repma10) {
        this.repma10 = repma10;
    }

    public String getRepma11() {
        return repma11;
    }

    public void setRepma11(String repma11) {
        this.repma11 = repma11;
    }

    public String getRepma12() {
        return repma12;
    }

    public void setRepma12(String repma12) {
        this.repma12 = repma12;
    }

    public String getRepma13() {
        return repma13;
    }

    public void setRepma13(String repma13) {
        this.repma13 = repma13;
    }

    public String getRepma14() {
        return repma14;
    }

    public void setRepma14(String repma14) {
        this.repma14 = repma14;
    }

    public String getRepma15() {
        return repma15;
    }

    public void setRepma15(String repma15) {
        this.repma15 = repma15;
    }

    public String getRepma16() {
        return repma16;
    }

    public void setRepma16(String repma16) {
        this.repma16 = repma16;
    }

    public String getRepma17() {
        return repma17;
    }

    public void setRepma17(String repma17) {
        this.repma17 = repma17;
    }

    public String getRepma18() {
        return repma18;
    }

    public void setRepma18(String repma18) {
        this.repma18 = repma18;
    }

    public String getRepma19() {
        return repma19;
    }

    public void setRepma19(String repma19) {
        this.repma19 = repma19;
    }

    public String getRepma20() {
        return repma20;
    }

    public void setRepma20(String repma20) {
        this.repma20 = repma20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ma001 != null ? ma001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMA)) {
            return false;
        }
        REPMA other = (REPMA) object;
        if ((this.ma001 == null && other.ma001 != null) || (this.ma001 != null && !this.ma001.equals(other.ma001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMA[ ma001=" + ma001 + " ]";
    }
    
}
