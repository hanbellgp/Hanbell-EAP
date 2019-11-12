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
@Table(name = "PORBG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PORBG.findAll", query = "SELECT p FROM PORBG p"),
    @NamedQuery(name = "PORBG.findByCompany", query = "SELECT p FROM PORBG p WHERE p.company = :company"),
    @NamedQuery(name = "PORBG.findByCreator", query = "SELECT p FROM PORBG p WHERE p.creator = :creator"),
    @NamedQuery(name = "PORBG.findByUsrGroup", query = "SELECT p FROM PORBG p WHERE p.usrGroup = :usrGroup"),
    @NamedQuery(name = "PORBG.findByCustomer", query = "SELECT p FROM PORBG p WHERE p.customer = :customer"),
    @NamedQuery(name = "PORBG.findByProduct", query = "SELECT p FROM PORBG p WHERE p.product = :product"),
    @NamedQuery(name = "PORBG.findByRegion", query = "SELECT p FROM PORBG p WHERE p.region = :region"),
    @NamedQuery(name = "PORBG.findByDealer", query = "SELECT p FROM PORBG p WHERE p.dealer = :dealer"),
    @NamedQuery(name = "PORBG.findByBg001", query = "SELECT p FROM PORBG p WHERE p.bg001 = :bg001"),
    @NamedQuery(name = "PORBG.findByBg002", query = "SELECT p FROM PORBG p WHERE p.bg002 = :bg002"),
    @NamedQuery(name = "PORBG.findByBg003", query = "SELECT p FROM PORBG p WHERE p.bg003 = :bg003"),
    @NamedQuery(name = "PORBG.findByPorbg01", query = "SELECT p FROM PORBG p WHERE p.porbg01 = :porbg01"),
    @NamedQuery(name = "PORBG.findByPorbg02", query = "SELECT p FROM PORBG p WHERE p.porbg02 = :porbg02"),
    @NamedQuery(name = "PORBG.findByPorbg03", query = "SELECT p FROM PORBG p WHERE p.porbg03 = :porbg03")})
public class PORBG implements Serializable {

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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "BG001")
    private String bg001;
    @Size(max = 10)
    @Column(name = "BG002")
    private String bg002;
    @Size(max = 50)
    @Column(name = "BG003")
    private String bg003;
    @Size(max = 255)
    @Column(name = "BG004")
    private String bg004;
    @Size(max = 255)
    @Column(name = "PORBG01")
    private String porbg01;
    @Size(max = 255)
    @Column(name = "PORBG02")
    private String porbg02;
    @Size(max = 255)
    @Column(name = "PORBG03")
    private String porbg03;
    @Size(max = 255)
    @Column(name = "PORBG04")
    private String porbg04;
    @Size(max = 255)
    @Column(name = "PORBG05")
    private String porbg05;
    @Size(max = 255)
    @Column(name = "PORBG06")
    private String porbg06;
    @Size(max = 255)
    @Column(name = "PORBG07")
    private String porbg07;
    @Size(max = 255)
    @Column(name = "PORBG08")
    private String porbg08;
    @Size(max = 255)
    @Column(name = "PORBG09")
    private String porbg09;
    @Size(max = 255)
    @Column(name = "PORBG10")
    private String porbg10;
    @Size(max = 255)
    @Column(name = "PORBG11")
    private String porbg11;
    @Size(max = 255)
    @Column(name = "PORBG12")
    private String porbg12;
    @Size(max = 255)
    @Column(name = "PORBG13")
    private String porbg13;
    @Size(max = 255)
    @Column(name = "PORBG14")
    private String porbg14;
    @Size(max = 255)
    @Column(name = "PORBG15")
    private String porbg15;
    @Size(max = 255)
    @Column(name = "PORBG16")
    private String porbg16;
    @Size(max = 255)
    @Column(name = "PORBG17")
    private String porbg17;
    @Size(max = 255)
    @Column(name = "PORBG18")
    private String porbg18;
    @Size(max = 255)
    @Column(name = "PORBG19")
    private String porbg19;
    @Size(max = 255)
    @Column(name = "PORBG20")
    private String porbg20;

    public PORBG() {
    }

    public PORBG(String bg001) {
        this.bg001 = bg001;
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

    public String getBg001() {
        return bg001;
    }

    public void setBg001(String bg001) {
        this.bg001 = bg001;
    }

    public String getBg002() {
        return bg002;
    }

    public void setBg002(String bg002) {
        this.bg002 = bg002;
    }

    public String getBg003() {
        return bg003;
    }

    public void setBg003(String bg003) {
        this.bg003 = bg003;
    }

    public String getBg004() {
        return bg004;
    }

    public void setBg004(String bg004) {
        this.bg004 = bg004;
    }

    public String getPorbg01() {
        return porbg01;
    }

    public void setPorbg01(String porbg01) {
        this.porbg01 = porbg01;
    }

    public String getPorbg02() {
        return porbg02;
    }

    public void setPorbg02(String porbg02) {
        this.porbg02 = porbg02;
    }

    public String getPorbg03() {
        return porbg03;
    }

    public void setPorbg03(String porbg03) {
        this.porbg03 = porbg03;
    }

    public String getPorbg04() {
        return porbg04;
    }

    public void setPorbg04(String porbg04) {
        this.porbg04 = porbg04;
    }

    public String getPorbg05() {
        return porbg05;
    }

    public void setPorbg05(String porbg05) {
        this.porbg05 = porbg05;
    }

    public String getPorbg06() {
        return porbg06;
    }

    public void setPorbg06(String porbg06) {
        this.porbg06 = porbg06;
    }

    public String getPorbg07() {
        return porbg07;
    }

    public void setPorbg07(String porbg07) {
        this.porbg07 = porbg07;
    }

    public String getPorbg08() {
        return porbg08;
    }

    public void setPorbg08(String porbg08) {
        this.porbg08 = porbg08;
    }

    public String getPorbg09() {
        return porbg09;
    }

    public void setPorbg09(String porbg09) {
        this.porbg09 = porbg09;
    }

    public String getPorbg10() {
        return porbg10;
    }

    public void setPorbg10(String porbg10) {
        this.porbg10 = porbg10;
    }

    public String getPorbg11() {
        return porbg11;
    }

    public void setPorbg11(String porbg11) {
        this.porbg11 = porbg11;
    }

    public String getPorbg12() {
        return porbg12;
    }

    public void setPorbg12(String porbg12) {
        this.porbg12 = porbg12;
    }

    public String getPorbg13() {
        return porbg13;
    }

    public void setPorbg13(String porbg13) {
        this.porbg13 = porbg13;
    }

    public String getPorbg14() {
        return porbg14;
    }

    public void setPorbg14(String porbg14) {
        this.porbg14 = porbg14;
    }

    public String getPorbg15() {
        return porbg15;
    }

    public void setPorbg15(String porbg15) {
        this.porbg15 = porbg15;
    }

    public String getPorbg16() {
        return porbg16;
    }

    public void setPorbg16(String porbg16) {
        this.porbg16 = porbg16;
    }

    public String getPorbg17() {
        return porbg17;
    }

    public void setPorbg17(String porbg17) {
        this.porbg17 = porbg17;
    }

    public String getPorbg18() {
        return porbg18;
    }

    public void setPorbg18(String porbg18) {
        this.porbg18 = porbg18;
    }

    public String getPorbg19() {
        return porbg19;
    }

    public void setPorbg19(String porbg19) {
        this.porbg19 = porbg19;
    }

    public String getPorbg20() {
        return porbg20;
    }

    public void setPorbg20(String porbg20) {
        this.porbg20 = porbg20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bg001 != null ? bg001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PORBG)) {
            return false;
        }
        PORBG other = (PORBG) object;
        if ((this.bg001 == null && other.bg001 != null) || (this.bg001 != null && !this.bg001.equals(other.bg001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.PORBG[ bg001=" + bg001 + " ]";
    }
    
}
