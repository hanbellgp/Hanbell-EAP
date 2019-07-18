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
@Table(name = "REPMF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPMF.findAll", query = "SELECT r FROM REPMF r"),
    @NamedQuery(name = "REPMF.findByCompany", query = "SELECT r FROM REPMF r WHERE r.company = :company"),
    @NamedQuery(name = "REPMF.findByCreator", query = "SELECT r FROM REPMF r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPMF.findByUsrGroup", query = "SELECT r FROM REPMF r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPMF.findByCreateDate", query = "SELECT r FROM REPMF r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPMF.findByModifier", query = "SELECT r FROM REPMF r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPMF.findByModiDate", query = "SELECT r FROM REPMF r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPMF.findByFlag", query = "SELECT r FROM REPMF r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPMF.findByMf001", query = "SELECT r FROM REPMF r WHERE r.rEPMFPK.mf001 = :mf001"),
    @NamedQuery(name = "REPMF.findByMf002", query = "SELECT r FROM REPMF r WHERE r.rEPMFPK.mf002 = :mf002"),
    @NamedQuery(name = "REPMF.findByMf003", query = "SELECT r FROM REPMF r WHERE r.mf003 = :mf003"),
    @NamedQuery(name = "REPMF.findByMf004", query = "SELECT r FROM REPMF r WHERE r.mf004 = :mf004"),
    @NamedQuery(name = "REPMF.findByMf005", query = "SELECT r FROM REPMF r WHERE r.rEPMFPK.mf005 = :mf005"),
    @NamedQuery(name = "REPMF.findByMf006", query = "SELECT r FROM REPMF r WHERE r.mf006 = :mf006"),
    @NamedQuery(name = "REPMF.findByMf007", query = "SELECT r FROM REPMF r WHERE r.mf007 = :mf007"),
    @NamedQuery(name = "REPMF.findByMf008", query = "SELECT r FROM REPMF r WHERE r.mf008 = :mf008"),
    @NamedQuery(name = "REPMF.findByMf009", query = "SELECT r FROM REPMF r WHERE r.rEPMFPK.mf009 = :mf009"),
    @NamedQuery(name = "REPMF.findByCustomer", query = "SELECT r FROM REPMF r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPMF.findByProduct", query = "SELECT r FROM REPMF r WHERE r.product = :product"),
    @NamedQuery(name = "REPMF.findByRegion", query = "SELECT r FROM REPMF r WHERE r.region = :region"),
    @NamedQuery(name = "REPMF.findByDealer", query = "SELECT r FROM REPMF r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPMF.findByRepmf01", query = "SELECT r FROM REPMF r WHERE r.repmf01 = :repmf01"),
    @NamedQuery(name = "REPMF.findByRepmf02", query = "SELECT r FROM REPMF r WHERE r.repmf02 = :repmf02"),
    @NamedQuery(name = "REPMF.findByRepmf03", query = "SELECT r FROM REPMF r WHERE r.repmf03 = :repmf03"),
    @NamedQuery(name = "REPMF.findByRepmf04", query = "SELECT r FROM REPMF r WHERE r.repmf04 = :repmf04"),
    @NamedQuery(name = "REPMF.findByRepmf05", query = "SELECT r FROM REPMF r WHERE r.repmf05 = :repmf05"),
    @NamedQuery(name = "REPMF.findByRepmf06", query = "SELECT r FROM REPMF r WHERE r.repmf06 = :repmf06"),
    @NamedQuery(name = "REPMF.findByRepmf07", query = "SELECT r FROM REPMF r WHERE r.repmf07 = :repmf07"),
    @NamedQuery(name = "REPMF.findByRepmf08", query = "SELECT r FROM REPMF r WHERE r.repmf08 = :repmf08"),
    @NamedQuery(name = "REPMF.findByRepmf09", query = "SELECT r FROM REPMF r WHERE r.repmf09 = :repmf09"),
    @NamedQuery(name = "REPMF.findByRepmf10", query = "SELECT r FROM REPMF r WHERE r.repmf10 = :repmf10"),
    @NamedQuery(name = "REPMF.findByRepmf11", query = "SELECT r FROM REPMF r WHERE r.repmf11 = :repmf11"),
    @NamedQuery(name = "REPMF.findByRepmf12", query = "SELECT r FROM REPMF r WHERE r.repmf12 = :repmf12"),
    @NamedQuery(name = "REPMF.findByRepmf13", query = "SELECT r FROM REPMF r WHERE r.repmf13 = :repmf13"),
    @NamedQuery(name = "REPMF.findByRepmf14", query = "SELECT r FROM REPMF r WHERE r.repmf14 = :repmf14"),
    @NamedQuery(name = "REPMF.findByRepmf15", query = "SELECT r FROM REPMF r WHERE r.repmf15 = :repmf15"),
    @NamedQuery(name = "REPMF.findByRepmf16", query = "SELECT r FROM REPMF r WHERE r.repmf16 = :repmf16"),
    @NamedQuery(name = "REPMF.findByRepmf17", query = "SELECT r FROM REPMF r WHERE r.repmf17 = :repmf17"),
    @NamedQuery(name = "REPMF.findByRepmf18", query = "SELECT r FROM REPMF r WHERE r.repmf18 = :repmf18"),
    @NamedQuery(name = "REPMF.findByRepmf19", query = "SELECT r FROM REPMF r WHERE r.repmf19 = :repmf19"),
    @NamedQuery(name = "REPMF.findByRepmf20", query = "SELECT r FROM REPMF r WHERE r.repmf20 = :repmf20")})
public class REPMF implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPMFPK rEPMFPK;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MF003")
    private BigDecimal mf003;
    @Size(max = 8)
    @Column(name = "MF004")
    private String mf004;
    @Size(max = 8)
    @Column(name = "MF006")
    private String mf006;
    @Size(max = 255)
    @Column(name = "MF007")
    private String mf007;
    @Size(max = 1)
    @Column(name = "MF008")
    private String mf008;
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
    @Column(name = "REPMF01")
    private String repmf01;
    @Size(max = 255)
    @Column(name = "REPMF02")
    private String repmf02;
    @Size(max = 255)
    @Column(name = "REPMF03")
    private String repmf03;
    @Size(max = 255)
    @Column(name = "REPMF04")
    private String repmf04;
    @Size(max = 255)
    @Column(name = "REPMF05")
    private String repmf05;
    @Size(max = 255)
    @Column(name = "REPMF06")
    private String repmf06;
    @Size(max = 255)
    @Column(name = "REPMF07")
    private String repmf07;
    @Size(max = 255)
    @Column(name = "REPMF08")
    private String repmf08;
    @Size(max = 255)
    @Column(name = "REPMF09")
    private String repmf09;
    @Size(max = 255)
    @Column(name = "REPMF10")
    private String repmf10;
    @Size(max = 255)
    @Column(name = "REPMF11")
    private String repmf11;
    @Size(max = 255)
    @Column(name = "REPMF12")
    private String repmf12;
    @Size(max = 255)
    @Column(name = "REPMF13")
    private String repmf13;
    @Size(max = 255)
    @Column(name = "REPMF14")
    private String repmf14;
    @Size(max = 255)
    @Column(name = "REPMF15")
    private String repmf15;
    @Size(max = 255)
    @Column(name = "REPMF16")
    private String repmf16;
    @Size(max = 255)
    @Column(name = "REPMF17")
    private String repmf17;
    @Size(max = 255)
    @Column(name = "REPMF18")
    private String repmf18;
    @Size(max = 255)
    @Column(name = "REPMF19")
    private String repmf19;
    @Size(max = 255)
    @Column(name = "REPMF20")
    private String repmf20;

    public REPMF() {
    }

    public REPMF(REPMFPK rEPMFPK) {
        this.rEPMFPK = rEPMFPK;
    }

    public REPMF(String mf001, String mf002, String mf005, String mf009) {
        this.rEPMFPK = new REPMFPK(mf001, mf002, mf005, mf009);
    }

    public REPMFPK getREPMFPK() {
        return rEPMFPK;
    }

    public void setREPMFPK(REPMFPK rEPMFPK) {
        this.rEPMFPK = rEPMFPK;
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

    public BigDecimal getMf003() {
        return mf003;
    }

    public void setMf003(BigDecimal mf003) {
        this.mf003 = mf003;
    }

    public String getMf004() {
        return mf004;
    }

    public void setMf004(String mf004) {
        this.mf004 = mf004;
    }

    public String getMf006() {
        return mf006;
    }

    public void setMf006(String mf006) {
        this.mf006 = mf006;
    }

    public String getMf007() {
        return mf007;
    }

    public void setMf007(String mf007) {
        this.mf007 = mf007;
    }

    public String getMf008() {
        return mf008;
    }

    public void setMf008(String mf008) {
        this.mf008 = mf008;
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

    public String getRepmf01() {
        return repmf01;
    }

    public void setRepmf01(String repmf01) {
        this.repmf01 = repmf01;
    }

    public String getRepmf02() {
        return repmf02;
    }

    public void setRepmf02(String repmf02) {
        this.repmf02 = repmf02;
    }

    public String getRepmf03() {
        return repmf03;
    }

    public void setRepmf03(String repmf03) {
        this.repmf03 = repmf03;
    }

    public String getRepmf04() {
        return repmf04;
    }

    public void setRepmf04(String repmf04) {
        this.repmf04 = repmf04;
    }

    public String getRepmf05() {
        return repmf05;
    }

    public void setRepmf05(String repmf05) {
        this.repmf05 = repmf05;
    }

    public String getRepmf06() {
        return repmf06;
    }

    public void setRepmf06(String repmf06) {
        this.repmf06 = repmf06;
    }

    public String getRepmf07() {
        return repmf07;
    }

    public void setRepmf07(String repmf07) {
        this.repmf07 = repmf07;
    }

    public String getRepmf08() {
        return repmf08;
    }

    public void setRepmf08(String repmf08) {
        this.repmf08 = repmf08;
    }

    public String getRepmf09() {
        return repmf09;
    }

    public void setRepmf09(String repmf09) {
        this.repmf09 = repmf09;
    }

    public String getRepmf10() {
        return repmf10;
    }

    public void setRepmf10(String repmf10) {
        this.repmf10 = repmf10;
    }

    public String getRepmf11() {
        return repmf11;
    }

    public void setRepmf11(String repmf11) {
        this.repmf11 = repmf11;
    }

    public String getRepmf12() {
        return repmf12;
    }

    public void setRepmf12(String repmf12) {
        this.repmf12 = repmf12;
    }

    public String getRepmf13() {
        return repmf13;
    }

    public void setRepmf13(String repmf13) {
        this.repmf13 = repmf13;
    }

    public String getRepmf14() {
        return repmf14;
    }

    public void setRepmf14(String repmf14) {
        this.repmf14 = repmf14;
    }

    public String getRepmf15() {
        return repmf15;
    }

    public void setRepmf15(String repmf15) {
        this.repmf15 = repmf15;
    }

    public String getRepmf16() {
        return repmf16;
    }

    public void setRepmf16(String repmf16) {
        this.repmf16 = repmf16;
    }

    public String getRepmf17() {
        return repmf17;
    }

    public void setRepmf17(String repmf17) {
        this.repmf17 = repmf17;
    }

    public String getRepmf18() {
        return repmf18;
    }

    public void setRepmf18(String repmf18) {
        this.repmf18 = repmf18;
    }

    public String getRepmf19() {
        return repmf19;
    }

    public void setRepmf19(String repmf19) {
        this.repmf19 = repmf19;
    }

    public String getRepmf20() {
        return repmf20;
    }

    public void setRepmf20(String repmf20) {
        this.repmf20 = repmf20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPMFPK != null ? rEPMFPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMF)) {
            return false;
        }
        REPMF other = (REPMF) object;
        if ((this.rEPMFPK == null && other.rEPMFPK != null) || (this.rEPMFPK != null && !this.rEPMFPK.equals(other.rEPMFPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMF[ rEPMFPK=" + rEPMFPK + " ]";
    }
    
}
