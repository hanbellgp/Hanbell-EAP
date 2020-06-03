/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SYSNN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SYSNN.findAll", query = "SELECT s FROM SYSNN s"),
    @NamedQuery(name = "SYSNN.findByCompany", query = "SELECT s FROM SYSNN s WHERE s.company = :company"),
    @NamedQuery(name = "SYSNN.findByCreator", query = "SELECT s FROM SYSNN s WHERE s.creator = :creator"),
    @NamedQuery(name = "SYSNN.findByCreateDate", query = "SELECT s FROM SYSNN s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SYSNN.findByModifier", query = "SELECT s FROM SYSNN s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SYSNN.findByModiDate", query = "SELECT s FROM SYSNN s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SYSNN.findByFlag", query = "SELECT s FROM SYSNN s WHERE s.flag = :flag"),
    @NamedQuery(name = "SYSNN.findByNn001", query = "SELECT s FROM SYSNN s WHERE s.nn001 = :nn001")})
public class SYSNN implements Serializable {

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
    @Column(name = "NN001")
    private String nn001;
    @Size(max = 60)
    @Column(name = "NN002")
    private String nn002;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NN003")
    private BigDecimal nn003;
    @Size(max = 1)
    @Column(name = "NN004")
    private String nn004;
    @Size(max = 1)
    @Column(name = "NN005")
    private String nn005;
    @Size(max = 3)
    @Column(name = "NN006")
    private String nn006;
    @Size(max = 20)
    @Column(name = "NN007")
    private String nn007;
    @Size(max = 255)
    @Column(name = "NN008")
    private String nn008;
    @Size(max = 1)
    @Column(name = "NN009")
    private String nn009;
    @Column(name = "NN010")
    private BigDecimal nn010;
    @Size(max = 10)
    @Column(name = "NN011")
    private String nn011;
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
    @Column(name = "SYSNN01")
    private String sysnn01;
    @Size(max = 255)
    @Column(name = "SYSNN02")
    private String sysnn02;
    @Size(max = 255)
    @Column(name = "SYSNN03")
    private String sysnn03;
    @Size(max = 255)
    @Column(name = "SYSNN04")
    private String sysnn04;
    @Size(max = 255)
    @Column(name = "SYSNN05")
    private String sysnn05;
    @Size(max = 255)
    @Column(name = "SYSNN06")
    private String sysnn06;
    @Size(max = 255)
    @Column(name = "SYSNN07")
    private String sysnn07;
    @Size(max = 255)
    @Column(name = "SYSNN08")
    private String sysnn08;
    @Size(max = 255)
    @Column(name = "SYSNN09")
    private String sysnn09;
    @Size(max = 255)
    @Column(name = "SYSNN10")
    private String sysnn10;
    @Size(max = 255)
    @Column(name = "SYSNN11")
    private String sysnn11;
    @Size(max = 255)
    @Column(name = "SYSNN12")
    private String sysnn12;
    @Size(max = 255)
    @Column(name = "SYSNN13")
    private String sysnn13;
    @Size(max = 255)
    @Column(name = "SYSNN14")
    private String sysnn14;
    @Size(max = 255)
    @Column(name = "SYSNN15")
    private String sysnn15;
    @Size(max = 255)
    @Column(name = "SYSNN16")
    private String sysnn16;
    @Size(max = 255)
    @Column(name = "SYSNN17")
    private String sysnn17;
    @Size(max = 255)
    @Column(name = "SYSNN18")
    private String sysnn18;
    @Size(max = 255)
    @Column(name = "SYSNN19")
    private String sysnn19;
    @Size(max = 255)
    @Column(name = "SYSNN20")
    private String sysnn20;

    public SYSNN() {
    }

    public SYSNN(String nn001) {
        this.nn001 = nn001;
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

    public String getNn001() {
        return nn001;
    }

    public void setNn001(String nn001) {
        this.nn001 = nn001;
    }

    public String getNn002() {
        return nn002;
    }

    public void setNn002(String nn002) {
        this.nn002 = nn002;
    }

    public BigDecimal getNn003() {
        return nn003;
    }

    public void setNn003(BigDecimal nn003) {
        this.nn003 = nn003;
    }

    public String getNn004() {
        return nn004;
    }

    public void setNn004(String nn004) {
        this.nn004 = nn004;
    }

    public String getNn005() {
        return nn005;
    }

    public void setNn005(String nn005) {
        this.nn005 = nn005;
    }

    public String getNn006() {
        return nn006;
    }

    public void setNn006(String nn006) {
        this.nn006 = nn006;
    }

    public String getNn007() {
        return nn007;
    }

    public void setNn007(String nn007) {
        this.nn007 = nn007;
    }

    public String getNn008() {
        return nn008;
    }

    public void setNn008(String nn008) {
        this.nn008 = nn008;
    }

    public String getNn009() {
        return nn009;
    }

    public void setNn009(String nn009) {
        this.nn009 = nn009;
    }

    public BigDecimal getNn010() {
        return nn010;
    }

    public void setNn010(BigDecimal nn010) {
        this.nn010 = nn010;
    }

    public String getNn011() {
        return nn011;
    }

    public void setNn011(String nn011) {
        this.nn011 = nn011;
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

    public String getSysnn01() {
        return sysnn01;
    }

    public void setSysnn01(String sysnn01) {
        this.sysnn01 = sysnn01;
    }

    public String getSysnn02() {
        return sysnn02;
    }

    public void setSysnn02(String sysnn02) {
        this.sysnn02 = sysnn02;
    }

    public String getSysnn03() {
        return sysnn03;
    }

    public void setSysnn03(String sysnn03) {
        this.sysnn03 = sysnn03;
    }

    public String getSysnn04() {
        return sysnn04;
    }

    public void setSysnn04(String sysnn04) {
        this.sysnn04 = sysnn04;
    }

    public String getSysnn05() {
        return sysnn05;
    }

    public void setSysnn05(String sysnn05) {
        this.sysnn05 = sysnn05;
    }

    public String getSysnn06() {
        return sysnn06;
    }

    public void setSysnn06(String sysnn06) {
        this.sysnn06 = sysnn06;
    }

    public String getSysnn07() {
        return sysnn07;
    }

    public void setSysnn07(String sysnn07) {
        this.sysnn07 = sysnn07;
    }

    public String getSysnn08() {
        return sysnn08;
    }

    public void setSysnn08(String sysnn08) {
        this.sysnn08 = sysnn08;
    }

    public String getSysnn09() {
        return sysnn09;
    }

    public void setSysnn09(String sysnn09) {
        this.sysnn09 = sysnn09;
    }

    public String getSysnn10() {
        return sysnn10;
    }

    public void setSysnn10(String sysnn10) {
        this.sysnn10 = sysnn10;
    }

    public String getSysnn11() {
        return sysnn11;
    }

    public void setSysnn11(String sysnn11) {
        this.sysnn11 = sysnn11;
    }

    public String getSysnn12() {
        return sysnn12;
    }

    public void setSysnn12(String sysnn12) {
        this.sysnn12 = sysnn12;
    }

    public String getSysnn13() {
        return sysnn13;
    }

    public void setSysnn13(String sysnn13) {
        this.sysnn13 = sysnn13;
    }

    public String getSysnn14() {
        return sysnn14;
    }

    public void setSysnn14(String sysnn14) {
        this.sysnn14 = sysnn14;
    }

    public String getSysnn15() {
        return sysnn15;
    }

    public void setSysnn15(String sysnn15) {
        this.sysnn15 = sysnn15;
    }

    public String getSysnn16() {
        return sysnn16;
    }

    public void setSysnn16(String sysnn16) {
        this.sysnn16 = sysnn16;
    }

    public String getSysnn17() {
        return sysnn17;
    }

    public void setSysnn17(String sysnn17) {
        this.sysnn17 = sysnn17;
    }

    public String getSysnn18() {
        return sysnn18;
    }

    public void setSysnn18(String sysnn18) {
        this.sysnn18 = sysnn18;
    }

    public String getSysnn19() {
        return sysnn19;
    }

    public void setSysnn19(String sysnn19) {
        this.sysnn19 = sysnn19;
    }

    public String getSysnn20() {
        return sysnn20;
    }

    public void setSysnn20(String sysnn20) {
        this.sysnn20 = sysnn20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nn001 != null ? nn001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SYSNN)) {
            return false;
        }
        SYSNN other = (SYSNN) object;
        if ((this.nn001 == null && other.nn001 != null) || (this.nn001 != null && !this.nn001.equals(other.nn001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.Sysnn[ nn001=" + nn001 + " ]";
    }
    
}
