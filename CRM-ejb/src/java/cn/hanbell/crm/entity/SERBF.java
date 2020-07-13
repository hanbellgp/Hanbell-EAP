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
 * @author C2082
 */
@Entity
@Table(name = "SERBF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERBF.findAll", query = "SELECT s FROM SERBF s"),
    @NamedQuery(name = "SERBF.findByCompany", query = "SELECT s FROM SERBF s WHERE s.company = :company"),
    @NamedQuery(name = "SERBF.findByCreator", query = "SELECT s FROM SERBF s WHERE s.creator = :creator"),
    @NamedQuery(name = "SERBF.findByUsrGroup", query = "SELECT s FROM SERBF s WHERE s.usrGroup = :usrGroup"),
    @NamedQuery(name = "SERBF.findByCreateDate", query = "SELECT s FROM SERBF s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SERBF.findByModifier", query = "SELECT s FROM SERBF s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SERBF.findByModiDate", query = "SELECT s FROM SERBF s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SERBF.findByFlag", query = "SELECT s FROM SERBF s WHERE s.flag = :flag"),
    @NamedQuery(name = "SERBF.findByBf001", query = "SELECT s FROM SERBF s WHERE s.sERBFPK.bf001 = :bf001"),
    @NamedQuery(name = "SERBF.findByBf002", query = "SELECT s FROM SERBF s WHERE s.sERBFPK.bf002 = :bf002"),
    @NamedQuery(name = "SERBF.findByBf003", query = "SELECT s FROM SERBF s WHERE s.bf003 = :bf003"),
    @NamedQuery(name = "SERBF.findByBf004", query = "SELECT s FROM SERBF s WHERE s.bf004 = :bf004"),
    @NamedQuery(name = "SERBF.findByBf005", query = "SELECT s FROM SERBF s WHERE s.bf005 = :bf005"),
    @NamedQuery(name = "SERBF.findByBf006", query = "SELECT s FROM SERBF s WHERE s.bf006 = :bf006"),
    @NamedQuery(name = "SERBF.findByBf007", query = "SELECT s FROM SERBF s WHERE s.bf007 = :bf007"),
    @NamedQuery(name = "SERBF.findByBf008", query = "SELECT s FROM SERBF s WHERE s.bf008 = :bf008"),
    @NamedQuery(name = "SERBF.findByBf009", query = "SELECT s FROM SERBF s WHERE s.bf009 = :bf009"),
    @NamedQuery(name = "SERBF.findByBf010", query = "SELECT s FROM SERBF s WHERE s.bf010 = :bf010"),
    @NamedQuery(name = "SERBF.findByBf011", query = "SELECT s FROM SERBF s WHERE s.bf011 = :bf011"),
    @NamedQuery(name = "SERBF.findByBf012", query = "SELECT s FROM SERBF s WHERE s.bf012 = :bf012"),
    @NamedQuery(name = "SERBF.findByBf013", query = "SELECT s FROM SERBF s WHERE s.bf013 = :bf013"),
    @NamedQuery(name = "SERBF.findByBf014", query = "SELECT s FROM SERBF s WHERE s.bf014 = :bf014"),
    @NamedQuery(name = "SERBF.findByCustomer", query = "SELECT s FROM SERBF s WHERE s.customer = :customer"),
    @NamedQuery(name = "SERBF.findByProduct", query = "SELECT s FROM SERBF s WHERE s.product = :product"),
    @NamedQuery(name = "SERBF.findByRegion", query = "SELECT s FROM SERBF s WHERE s.region = :region"),
    @NamedQuery(name = "SERBF.findByDealer", query = "SELECT s FROM SERBF s WHERE s.dealer = :dealer"),
    @NamedQuery(name = "SERBF.findBySerbf01", query = "SELECT s FROM SERBF s WHERE s.serbf01 = :serbf01"),
    @NamedQuery(name = "SERBF.findBySerbf02", query = "SELECT s FROM SERBF s WHERE s.serbf02 = :serbf02"),
    @NamedQuery(name = "SERBF.findBySerbf03", query = "SELECT s FROM SERBF s WHERE s.serbf03 = :serbf03"),
    @NamedQuery(name = "SERBF.findBySerbf04", query = "SELECT s FROM SERBF s WHERE s.serbf04 = :serbf04"),
    @NamedQuery(name = "SERBF.findBySerbf05", query = "SELECT s FROM SERBF s WHERE s.serbf05 = :serbf05"),
    @NamedQuery(name = "SERBF.findBySerbf06", query = "SELECT s FROM SERBF s WHERE s.serbf06 = :serbf06"),
    @NamedQuery(name = "SERBF.findBySerbf07", query = "SELECT s FROM SERBF s WHERE s.serbf07 = :serbf07"),
    @NamedQuery(name = "SERBF.findBySerbf08", query = "SELECT s FROM SERBF s WHERE s.serbf08 = :serbf08"),
    @NamedQuery(name = "SERBF.findBySerbf09", query = "SELECT s FROM SERBF s WHERE s.serbf09 = :serbf09"),
    @NamedQuery(name = "SERBF.findBySerbf10", query = "SELECT s FROM SERBF s WHERE s.serbf10 = :serbf10"),
    @NamedQuery(name = "SERBF.findBySerbf11", query = "SELECT s FROM SERBF s WHERE s.serbf11 = :serbf11"),
    @NamedQuery(name = "SERBF.findBySerbf12", query = "SELECT s FROM SERBF s WHERE s.serbf12 = :serbf12"),
    @NamedQuery(name = "SERBF.findBySerbf13", query = "SELECT s FROM SERBF s WHERE s.serbf13 = :serbf13"),
    @NamedQuery(name = "SERBF.findBySerbf14", query = "SELECT s FROM SERBF s WHERE s.serbf14 = :serbf14"),
    @NamedQuery(name = "SERBF.findBySerbf15", query = "SELECT s FROM SERBF s WHERE s.serbf15 = :serbf15"),
    @NamedQuery(name = "SERBF.findBySerbf16", query = "SELECT s FROM SERBF s WHERE s.serbf16 = :serbf16"),
    @NamedQuery(name = "SERBF.findBySerbf17", query = "SELECT s FROM SERBF s WHERE s.serbf17 = :serbf17"),
    @NamedQuery(name = "SERBF.findBySerbf18", query = "SELECT s FROM SERBF s WHERE s.serbf18 = :serbf18"),
    @NamedQuery(name = "SERBF.findBySerbf19", query = "SELECT s FROM SERBF s WHERE s.serbf19 = :serbf19"),
    @NamedQuery(name = "SERBF.findBySerbf20", query = "SELECT s FROM SERBF s WHERE s.serbf20 = :serbf20")})
public class SERBF implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SERBFPK sERBFPK;
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
    @Size(max = 1)
    @Column(name = "BF003")
    private String bf003;
    @Size(max = 6)
    @Column(name = "BF004")
    private String bf004;
    @Size(max = 10)
    @Column(name = "BF005")
    private String bf005;
    @Size(max = 10)
    @Column(name = "BF006")
    private String bf006;
    @Size(max = 36)
    @Column(name = "BF007")
    private String bf007;
    @Size(max = 36)
    @Column(name = "BF008")
    private String bf008;
    @Size(max = 20)
    @Column(name = "BF009")
    private String bf009;
    @Size(max = 20)
    @Column(name = "BF010")
    private String bf010;
    @Size(max = 20)
    @Column(name = "BF011")
    private String bf011;
    @Size(max = 20)
    @Column(name = "BF012")
    private String bf012;
    @Size(max = 1)
    @Column(name = "BF013")
    private String bf013;
    @Size(max = 255)
    @Column(name = "BF014")
    private String bf014;
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
    @Column(name = "SERBF01")
    private String serbf01;
    @Size(max = 255)
    @Column(name = "SERBF02")
    private String serbf02;
    @Size(max = 255)
    @Column(name = "SERBF03")
    private String serbf03;
    @Size(max = 255)
    @Column(name = "SERBF04")
    private String serbf04;
    @Size(max = 255)
    @Column(name = "SERBF05")
    private String serbf05;
    @Size(max = 255)
    @Column(name = "SERBF06")
    private String serbf06;
    @Size(max = 255)
    @Column(name = "SERBF07")
    private String serbf07;
    @Size(max = 255)
    @Column(name = "SERBF08")
    private String serbf08;
    @Size(max = 255)
    @Column(name = "SERBF09")
    private String serbf09;
    @Size(max = 255)
    @Column(name = "SERBF10")
    private String serbf10;
    @Size(max = 255)
    @Column(name = "SERBF11")
    private String serbf11;
    @Size(max = 255)
    @Column(name = "SERBF12")
    private String serbf12;
    @Size(max = 255)
    @Column(name = "SERBF13")
    private String serbf13;
    @Size(max = 255)
    @Column(name = "SERBF14")
    private String serbf14;
    @Size(max = 255)
    @Column(name = "SERBF15")
    private String serbf15;
    @Size(max = 255)
    @Column(name = "SERBF16")
    private String serbf16;
    @Size(max = 255)
    @Column(name = "SERBF17")
    private String serbf17;
    @Size(max = 255)
    @Column(name = "SERBF18")
    private String serbf18;
    @Size(max = 255)
    @Column(name = "SERBF19")
    private String serbf19;
    @Size(max = 255)
    @Column(name = "SERBF20")
    private String serbf20;

    public SERBF() {
    }

    public SERBF(SERBFPK sERBFPK) {
        this.sERBFPK = sERBFPK;
    }

    public SERBF(String bf001, String bf002) {
        this.sERBFPK = new SERBFPK(bf001, bf002);
    }

    public SERBFPK getSERBFPK() {
        return sERBFPK;
    }

    public void setSERBFPK(SERBFPK sERBFPK) {
        this.sERBFPK = sERBFPK;
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

    public String getBf003() {
        return bf003;
    }

    public void setBf003(String bf003) {
        this.bf003 = bf003;
    }

    public String getBf004() {
        return bf004;
    }

    public void setBf004(String bf004) {
        this.bf004 = bf004;
    }

    public String getBf005() {
        return bf005;
    }

    public void setBf005(String bf005) {
        this.bf005 = bf005;
    }

    public String getBf006() {
        return bf006;
    }

    public void setBf006(String bf006) {
        this.bf006 = bf006;
    }

    public String getBf007() {
        return bf007;
    }

    public void setBf007(String bf007) {
        this.bf007 = bf007;
    }

    public String getBf008() {
        return bf008;
    }

    public void setBf008(String bf008) {
        this.bf008 = bf008;
    }

    public String getBf009() {
        return bf009;
    }

    public void setBf009(String bf009) {
        this.bf009 = bf009;
    }

    public String getBf010() {
        return bf010;
    }

    public void setBf010(String bf010) {
        this.bf010 = bf010;
    }

    public String getBf011() {
        return bf011;
    }

    public void setBf011(String bf011) {
        this.bf011 = bf011;
    }

    public String getBf012() {
        return bf012;
    }

    public void setBf012(String bf012) {
        this.bf012 = bf012;
    }

    public String getBf013() {
        return bf013;
    }

    public void setBf013(String bf013) {
        this.bf013 = bf013;
    }

    public String getBf014() {
        return bf014;
    }

    public void setBf014(String bf014) {
        this.bf014 = bf014;
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

    public String getSerbf01() {
        return serbf01;
    }

    public void setSerbf01(String serbf01) {
        this.serbf01 = serbf01;
    }

    public String getSerbf02() {
        return serbf02;
    }

    public void setSerbf02(String serbf02) {
        this.serbf02 = serbf02;
    }

    public String getSerbf03() {
        return serbf03;
    }

    public void setSerbf03(String serbf03) {
        this.serbf03 = serbf03;
    }

    public String getSerbf04() {
        return serbf04;
    }

    public void setSerbf04(String serbf04) {
        this.serbf04 = serbf04;
    }

    public String getSerbf05() {
        return serbf05;
    }

    public void setSerbf05(String serbf05) {
        this.serbf05 = serbf05;
    }

    public String getSerbf06() {
        return serbf06;
    }

    public void setSerbf06(String serbf06) {
        this.serbf06 = serbf06;
    }

    public String getSerbf07() {
        return serbf07;
    }

    public void setSerbf07(String serbf07) {
        this.serbf07 = serbf07;
    }

    public String getSerbf08() {
        return serbf08;
    }

    public void setSerbf08(String serbf08) {
        this.serbf08 = serbf08;
    }

    public String getSerbf09() {
        return serbf09;
    }

    public void setSerbf09(String serbf09) {
        this.serbf09 = serbf09;
    }

    public String getSerbf10() {
        return serbf10;
    }

    public void setSerbf10(String serbf10) {
        this.serbf10 = serbf10;
    }

    public String getSerbf11() {
        return serbf11;
    }

    public void setSerbf11(String serbf11) {
        this.serbf11 = serbf11;
    }

    public String getSerbf12() {
        return serbf12;
    }

    public void setSerbf12(String serbf12) {
        this.serbf12 = serbf12;
    }

    public String getSerbf13() {
        return serbf13;
    }

    public void setSerbf13(String serbf13) {
        this.serbf13 = serbf13;
    }

    public String getSerbf14() {
        return serbf14;
    }

    public void setSerbf14(String serbf14) {
        this.serbf14 = serbf14;
    }

    public String getSerbf15() {
        return serbf15;
    }

    public void setSerbf15(String serbf15) {
        this.serbf15 = serbf15;
    }

    public String getSerbf16() {
        return serbf16;
    }

    public void setSerbf16(String serbf16) {
        this.serbf16 = serbf16;
    }

    public String getSerbf17() {
        return serbf17;
    }

    public void setSerbf17(String serbf17) {
        this.serbf17 = serbf17;
    }

    public String getSerbf18() {
        return serbf18;
    }

    public void setSerbf18(String serbf18) {
        this.serbf18 = serbf18;
    }

    public String getSerbf19() {
        return serbf19;
    }

    public void setSerbf19(String serbf19) {
        this.serbf19 = serbf19;
    }

    public String getSerbf20() {
        return serbf20;
    }

    public void setSerbf20(String serbf20) {
        this.serbf20 = serbf20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sERBFPK != null ? sERBFPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERBF)) {
            return false;
        }
        SERBF other = (SERBF) object;
        if ((this.sERBFPK == null && other.sERBFPK != null) || (this.sERBFPK != null && !this.sERBFPK.equals(other.sERBFPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SERBF[ sERBFPK=" + sERBFPK + " ]";
    }
    
}
