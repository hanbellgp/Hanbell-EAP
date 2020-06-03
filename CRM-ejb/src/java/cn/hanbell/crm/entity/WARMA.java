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
 * @author C2082
 */
@Entity
@Table(name = "WARMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARMA.findAll", query = "SELECT w FROM WARMA w"),
    @NamedQuery(name = "WARMA.findByCompany", query = "SELECT w FROM WARMA w WHERE w.company = :company"),
    @NamedQuery(name = "WARMA.findByCreator", query = "SELECT w FROM WARMA w WHERE w.creator = :creator"),
    @NamedQuery(name = "WARMA.findByUsrGroup", query = "SELECT w FROM WARMA w WHERE w.usrGroup = :usrGroup"),
    @NamedQuery(name = "WARMA.findByCreateDate", query = "SELECT w FROM WARMA w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WARMA.findByModifier", query = "SELECT w FROM WARMA w WHERE w.modifier = :modifier"),
    @NamedQuery(name = "WARMA.findByModiDate", query = "SELECT w FROM WARMA w WHERE w.modiDate = :modiDate"),
    @NamedQuery(name = "WARMA.findByFlag", query = "SELECT w FROM WARMA w WHERE w.flag = :flag"),
    @NamedQuery(name = "WARMA.findByMa001", query = "SELECT w FROM WARMA w WHERE w.WARMAPK.ma001 = :ma001"),
    @NamedQuery(name = "WARMA.findByMa002", query = "SELECT w FROM WARMA w WHERE w.WARMAPK.ma002 = :ma002"),
    @NamedQuery(name = "WARMA.findByMa003", query = "SELECT w FROM WARMA w WHERE w.ma003 = :ma003"),
    @NamedQuery(name = "WARMA.findByMa004", query = "SELECT w FROM WARMA w WHERE w.ma004 = :ma004"),
    @NamedQuery(name = "WARMA.findByMa005", query = "SELECT w FROM WARMA w WHERE w.ma005 = :ma005"),
    @NamedQuery(name = "WARMA.findByMa006", query = "SELECT w FROM WARMA w WHERE w.ma006 = :ma006"),
    @NamedQuery(name = "WARMA.findByMa007", query = "SELECT w FROM WARMA w WHERE w.ma007 = :ma007"),
    @NamedQuery(name = "WARMA.findByMa008", query = "SELECT w FROM WARMA w WHERE w.ma008 = :ma008"),
    @NamedQuery(name = "WARMA.findByCustomer", query = "SELECT w FROM WARMA w WHERE w.customer = :customer"),
    @NamedQuery(name = "WARMA.findByProduct", query = "SELECT w FROM WARMA w WHERE w.product = :product"),
    @NamedQuery(name = "WARMA.findByRegion", query = "SELECT w FROM WARMA w WHERE w.region = :region"),
    @NamedQuery(name = "WARMA.findByDealer", query = "SELECT w FROM WARMA w WHERE w.dealer = :dealer"),
    @NamedQuery(name = "WARMA.findByWarma01", query = "SELECT w FROM WARMA w WHERE w.warma01 = :warma01"),
    @NamedQuery(name = "WARMA.findByWarma02", query = "SELECT w FROM WARMA w WHERE w.warma02 = :warma02"),
    @NamedQuery(name = "WARMA.findByWarma03", query = "SELECT w FROM WARMA w WHERE w.warma03 = :warma03"),
    @NamedQuery(name = "WARMA.findByWarma04", query = "SELECT w FROM WARMA w WHERE w.warma04 = :warma04"),
    @NamedQuery(name = "WARMA.findByWarma05", query = "SELECT w FROM WARMA w WHERE w.warma05 = :warma05"),
    @NamedQuery(name = "WARMA.findByWarma06", query = "SELECT w FROM WARMA w WHERE w.warma06 = :warma06"),
    @NamedQuery(name = "WARMA.findByWarma07", query = "SELECT w FROM WARMA w WHERE w.warma07 = :warma07"),
    @NamedQuery(name = "WARMA.findByWarma08", query = "SELECT w FROM WARMA w WHERE w.warma08 = :warma08"),
    @NamedQuery(name = "WARMA.findByWarma09", query = "SELECT w FROM WARMA w WHERE w.warma09 = :warma09"),
    @NamedQuery(name = "WARMA.findByWarma10", query = "SELECT w FROM WARMA w WHERE w.warma10 = :warma10"),
    @NamedQuery(name = "WARMA.findByWarma11", query = "SELECT w FROM WARMA w WHERE w.warma11 = :warma11"),
    @NamedQuery(name = "WARMA.findByWarma12", query = "SELECT w FROM WARMA w WHERE w.warma12 = :warma12"),
    @NamedQuery(name = "WARMA.findByWarma13", query = "SELECT w FROM WARMA w WHERE w.warma13 = :warma13"),
    @NamedQuery(name = "WARMA.findByWarma14", query = "SELECT w FROM WARMA w WHERE w.warma14 = :warma14"),
    @NamedQuery(name = "WARMA.findByWarma15", query = "SELECT w FROM WARMA w WHERE w.warma15 = :warma15"),
    @NamedQuery(name = "WARMA.findByWarma16", query = "SELECT w FROM WARMA w WHERE w.warma16 = :warma16"),
    @NamedQuery(name = "WARMA.findByWarma17", query = "SELECT w FROM WARMA w WHERE w.warma17 = :warma17"),
    @NamedQuery(name = "WARMA.findByWarma18", query = "SELECT w FROM WARMA w WHERE w.warma18 = :warma18"),
    @NamedQuery(name = "WARMA.findByWarma19", query = "SELECT w FROM WARMA w WHERE w.warma19 = :warma19"),
    @NamedQuery(name = "WARMA.findByWarma20", query = "SELECT w FROM WARMA w WHERE w.warma20 = :warma20")})
public class WARMA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WARMAPK WARMAPK;
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
    @Size(max = 40)
    @Column(name = "MA003")
    private String ma003;
    @Size(max = 20)
    @Column(name = "MA004")
    private String ma004;
    @Size(max = 1)
    @Column(name = "MA005")
    private String ma005;
    @Size(max = 1)
    @Column(name = "MA006")
    private String ma006;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MA007")
    private BigDecimal ma007;
    @Column(name = "MA008")
    private Short ma008;
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
    @Column(name = "WARMA01")
    private String warma01;
    @Size(max = 255)
    @Column(name = "WARMA02")
    private String warma02;
    @Size(max = 255)
    @Column(name = "WARMA03")
    private String warma03;
    @Size(max = 255)
    @Column(name = "WARMA04")
    private String warma04;
    @Size(max = 255)
    @Column(name = "WARMA05")
    private String warma05;
    @Size(max = 255)
    @Column(name = "WARMA06")
    private String warma06;
    @Size(max = 255)
    @Column(name = "WARMA07")
    private String warma07;
    @Size(max = 255)
    @Column(name = "WARMA08")
    private String warma08;
    @Size(max = 255)
    @Column(name = "WARMA09")
    private String warma09;
    @Size(max = 255)
    @Column(name = "WARMA10")
    private String warma10;
    @Size(max = 255)
    @Column(name = "WARMA11")
    private String warma11;
    @Size(max = 255)
    @Column(name = "WARMA12")
    private String warma12;
    @Size(max = 255)
    @Column(name = "WARMA13")
    private String warma13;
    @Size(max = 255)
    @Column(name = "WARMA14")
    private String warma14;
    @Size(max = 255)
    @Column(name = "WARMA15")
    private String warma15;
    @Size(max = 255)
    @Column(name = "WARMA16")
    private String warma16;
    @Size(max = 255)
    @Column(name = "WARMA17")
    private String warma17;
    @Size(max = 255)
    @Column(name = "WARMA18")
    private String warma18;
    @Size(max = 255)
    @Column(name = "WARMA19")
    private String warma19;
    @Size(max = 255)
    @Column(name = "WARMA20")
    private String warma20;

    public WARMA() {
    }

    public WARMA(WARMAPK warmaPK) {
        this.WARMAPK = warmaPK;
    }

    public WARMA(String ma001, String ma002) {
        this.WARMAPK = new WARMAPK(ma001, ma002);
    }

    public WARMAPK getWarmaPK() {
        return WARMAPK;
    }

    public void setWarmaPK(WARMAPK warmaPK) {
        this.WARMAPK = warmaPK;
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

    public String getMa003() {
        return ma003;
    }

    public void setMa003(String ma003) {
        this.ma003 = ma003;
    }

    public String getMa004() {
        return ma004;
    }

    public void setMa004(String ma004) {
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

    public BigDecimal getMa007() {
        return ma007;
    }

    public void setMa007(BigDecimal ma007) {
        this.ma007 = ma007;
    }

    public Short getMa008() {
        return ma008;
    }

    public void setMa008(Short ma008) {
        this.ma008 = ma008;
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

    public String getWarma01() {
        return warma01;
    }

    public void setWarma01(String warma01) {
        this.warma01 = warma01;
    }

    public String getWarma02() {
        return warma02;
    }

    public void setWarma02(String warma02) {
        this.warma02 = warma02;
    }

    public String getWarma03() {
        return warma03;
    }

    public void setWarma03(String warma03) {
        this.warma03 = warma03;
    }

    public String getWarma04() {
        return warma04;
    }

    public void setWarma04(String warma04) {
        this.warma04 = warma04;
    }

    public String getWarma05() {
        return warma05;
    }

    public void setWarma05(String warma05) {
        this.warma05 = warma05;
    }

    public String getWarma06() {
        return warma06;
    }

    public void setWarma06(String warma06) {
        this.warma06 = warma06;
    }

    public String getWarma07() {
        return warma07;
    }

    public void setWarma07(String warma07) {
        this.warma07 = warma07;
    }

    public String getWarma08() {
        return warma08;
    }

    public void setWarma08(String warma08) {
        this.warma08 = warma08;
    }

    public String getWarma09() {
        return warma09;
    }

    public void setWarma09(String warma09) {
        this.warma09 = warma09;
    }

    public String getWarma10() {
        return warma10;
    }

    public void setWarma10(String warma10) {
        this.warma10 = warma10;
    }

    public String getWarma11() {
        return warma11;
    }

    public void setWarma11(String warma11) {
        this.warma11 = warma11;
    }

    public String getWarma12() {
        return warma12;
    }

    public void setWarma12(String warma12) {
        this.warma12 = warma12;
    }

    public String getWarma13() {
        return warma13;
    }

    public void setWarma13(String warma13) {
        this.warma13 = warma13;
    }

    public String getWarma14() {
        return warma14;
    }

    public void setWarma14(String warma14) {
        this.warma14 = warma14;
    }

    public String getWarma15() {
        return warma15;
    }

    public void setWarma15(String warma15) {
        this.warma15 = warma15;
    }

    public String getWarma16() {
        return warma16;
    }

    public void setWarma16(String warma16) {
        this.warma16 = warma16;
    }

    public String getWarma17() {
        return warma17;
    }

    public void setWarma17(String warma17) {
        this.warma17 = warma17;
    }

    public String getWarma18() {
        return warma18;
    }

    public void setWarma18(String warma18) {
        this.warma18 = warma18;
    }

    public String getWarma19() {
        return warma19;
    }

    public void setWarma19(String warma19) {
        this.warma19 = warma19;
    }

    public String getWarma20() {
        return warma20;
    }

    public void setWarma20(String warma20) {
        this.warma20 = warma20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (WARMAPK != null ? WARMAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARMA)) {
            return false;
        }
        WARMA other = (WARMA) object;
        if ((this.WARMAPK == null && other.WARMAPK != null) || (this.WARMAPK != null && !this.WARMAPK.equals(other.WARMAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.Warma[ warmaPK=" + WARMAPK + " ]";
    }
    
}
