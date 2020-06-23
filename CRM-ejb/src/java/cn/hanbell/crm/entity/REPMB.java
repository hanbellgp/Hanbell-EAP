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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "REPMB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPMB.findAll", query = "SELECT r FROM REPMB r"),
    @NamedQuery(name = "REPMB.findByCompany", query = "SELECT r FROM REPMB r WHERE r.company = :company"),
    @NamedQuery(name = "REPMB.findByCreator", query = "SELECT r FROM REPMB r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPMB.findByUsrGroup", query = "SELECT r FROM REPMB r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPMB.findByCreateDate", query = "SELECT r FROM REPMB r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPMB.findByModifier", query = "SELECT r FROM REPMB r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPMB.findByModiDate", query = "SELECT r FROM REPMB r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPMB.findByFlag", query = "SELECT r FROM REPMB r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPMB.findByMb001", query = "SELECT r FROM REPMB r WHERE r.mb001 = :mb001"),
    @NamedQuery(name = "REPMB.findByMb002", query = "SELECT r FROM REPMB r WHERE r.mb002 = :mb002"),
    @NamedQuery(name = "REPMB.findByMb003", query = "SELECT r FROM REPMB r WHERE r.mb003 = :mb003"),
    @NamedQuery(name = "REPMB.findByMb004", query = "SELECT r FROM REPMB r WHERE r.mb004 = :mb004"),
    @NamedQuery(name = "REPMB.findByMb005", query = "SELECT r FROM REPMB r WHERE r.mb005 = :mb005"),
    @NamedQuery(name = "REPMB.findByMb006", query = "SELECT r FROM REPMB r WHERE r.mb006 = :mb006"),
    @NamedQuery(name = "REPMB.findByMb007", query = "SELECT r FROM REPMB r WHERE r.mb007 = :mb007"),
    @NamedQuery(name = "REPMB.findByMb008", query = "SELECT r FROM REPMB r WHERE r.mb008 = :mb008"),
    @NamedQuery(name = "REPMB.findByMb009", query = "SELECT r FROM REPMB r WHERE r.mb009 = :mb009"),
    @NamedQuery(name = "REPMB.findByMb010", query = "SELECT r FROM REPMB r WHERE r.mb010 = :mb010"),
    @NamedQuery(name = "REPMB.findByCustomer", query = "SELECT r FROM REPMB r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPMB.findByProduct", query = "SELECT r FROM REPMB r WHERE r.product = :product"),
    @NamedQuery(name = "REPMB.findByRegion", query = "SELECT r FROM REPMB r WHERE r.region = :region"),
    @NamedQuery(name = "REPMB.findByDealer", query = "SELECT r FROM REPMB r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPMB.findByRepmb01", query = "SELECT r FROM REPMB r WHERE r.repmb01 = :repmb01"),
    @NamedQuery(name = "REPMB.findByRepmb02", query = "SELECT r FROM REPMB r WHERE r.repmb02 = :repmb02"),
    @NamedQuery(name = "REPMB.findByRepmb03", query = "SELECT r FROM REPMB r WHERE r.repmb03 = :repmb03"),
    @NamedQuery(name = "REPMB.findByRepmb04", query = "SELECT r FROM REPMB r WHERE r.repmb04 = :repmb04"),
    @NamedQuery(name = "REPMB.findByRepmb05", query = "SELECT r FROM REPMB r WHERE r.repmb05 = :repmb05"),
    @NamedQuery(name = "REPMB.findByRepmb06", query = "SELECT r FROM REPMB r WHERE r.repmb06 = :repmb06"),
    @NamedQuery(name = "REPMB.findByRepmb07", query = "SELECT r FROM REPMB r WHERE r.repmb07 = :repmb07"),
    @NamedQuery(name = "REPMB.findByRepmb08", query = "SELECT r FROM REPMB r WHERE r.repmb08 = :repmb08"),
    @NamedQuery(name = "REPMB.findByRepmb09", query = "SELECT r FROM REPMB r WHERE r.repmb09 = :repmb09"),
    @NamedQuery(name = "REPMB.findByRepmb10", query = "SELECT r FROM REPMB r WHERE r.repmb10 = :repmb10"),
    @NamedQuery(name = "REPMB.findByRepmb11", query = "SELECT r FROM REPMB r WHERE r.repmb11 = :repmb11"),
    @NamedQuery(name = "REPMB.findByRepmb12", query = "SELECT r FROM REPMB r WHERE r.repmb12 = :repmb12"),
    @NamedQuery(name = "REPMB.findByRepmb13", query = "SELECT r FROM REPMB r WHERE r.repmb13 = :repmb13"),
    @NamedQuery(name = "REPMB.findByRepmb14", query = "SELECT r FROM REPMB r WHERE r.repmb14 = :repmb14"),
    @NamedQuery(name = "REPMB.findByRepmb15", query = "SELECT r FROM REPMB r WHERE r.repmb15 = :repmb15"),
    @NamedQuery(name = "REPMB.findByRepmb16", query = "SELECT r FROM REPMB r WHERE r.repmb16 = :repmb16"),
    @NamedQuery(name = "REPMB.findByRepmb17", query = "SELECT r FROM REPMB r WHERE r.repmb17 = :repmb17"),
    @NamedQuery(name = "REPMB.findByRepmb18", query = "SELECT r FROM REPMB r WHERE r.repmb18 = :repmb18"),
    @NamedQuery(name = "REPMB.findByRepmb19", query = "SELECT r FROM REPMB r WHERE r.repmb19 = :repmb19"),
    @NamedQuery(name = "REPMB.findByRepmb20", query = "SELECT r FROM REPMB r WHERE r.repmb20 = :repmb20")})
public class REPMB implements Serializable {

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
    @Column(name = "MB001")
    private String mb001;
    @Size(max = 10)
    @Column(name = "MB002")
    private String mb002;
    @Size(max = 10)
    @Column(name = "MB003")
    private String mb003;
    @Size(max = 10)
    @Column(name = "MB004")
    private String mb004;
    @Size(max = 10)
    @Column(name = "MB005")
    private String mb005;
    @Size(max = 10)
    @Column(name = "MB006")
    private String mb006;
    @Size(max = 20)
    @Column(name = "MB007")
    private String mb007;
    @Size(max = 20)
    @Column(name = "MB008")
    private String mb008;
    @Size(max = 100)
    @Column(name = "MB009")
    private String mb009;
    @Size(max = 255)
    @Column(name = "MB010")
    private String mb010;
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
    @Column(name = "REPMB01")
    private String repmb01;
    @Size(max = 255)
    @Column(name = "REPMB02")
    private String repmb02;
    @Size(max = 255)
    @Column(name = "REPMB03")
    private String repmb03;
    @Size(max = 255)
    @Column(name = "REPMB04")
    private String repmb04;
    @Size(max = 255)
    @Column(name = "REPMB05")
    private String repmb05;
    @Size(max = 255)
    @Column(name = "REPMB06")
    private String repmb06;
    @Size(max = 255)
    @Column(name = "REPMB07")
    private String repmb07;
    @Size(max = 255)
    @Column(name = "REPMB08")
    private String repmb08;
    @Size(max = 255)
    @Column(name = "REPMB09")
    private String repmb09;
    @Size(max = 255)
    @Column(name = "REPMB10")
    private String repmb10;
    @Size(max = 255)
    @Column(name = "REPMB11")
    private String repmb11;
    @Size(max = 255)
    @Column(name = "REPMB12")
    private String repmb12;
    @Size(max = 255)
    @Column(name = "REPMB13")
    private String repmb13;
    @Size(max = 255)
    @Column(name = "REPMB14")
    private String repmb14;
    @Size(max = 255)
    @Column(name = "REPMB15")
    private String repmb15;
    @Size(max = 255)
    @Column(name = "REPMB16")
    private String repmb16;
    @Size(max = 255)
    @Column(name = "REPMB17")
    private String repmb17;
    @Size(max = 255)
    @Column(name = "REPMB18")
    private String repmb18;
    @Size(max = 255)
    @Column(name = "REPMB19")
    private String repmb19;
    @Size(max = 255)
    @Column(name = "REPMB20")
    private String repmb20;
    //用户
    @JoinColumn(name = "MB001", referencedColumnName = "MV001", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private CMSMV cmsmv;
    //仓库
    @JoinColumn(name = "MB002", referencedColumnName = "MJ001", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private WARMJ warmj;
    public REPMB() {
    }

    public REPMB(String mb001) {
        this.mb001 = mb001;
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

    public String getMb001() {
        return mb001;
    }

    public void setMb001(String mb001) {
        this.mb001 = mb001;
    }

    public String getMb002() {
        return mb002;
    }

    public void setMb002(String mb002) {
        this.mb002 = mb002;
    }

    public String getMb003() {
        return mb003;
    }

    public void setMb003(String mb003) {
        this.mb003 = mb003;
    }

    public String getMb004() {
        return mb004;
    }

    public void setMb004(String mb004) {
        this.mb004 = mb004;
    }

    public String getMb005() {
        return mb005;
    }

    public void setMb005(String mb005) {
        this.mb005 = mb005;
    }

    public String getMb006() {
        return mb006;
    }

    public void setMb006(String mb006) {
        this.mb006 = mb006;
    }

    public String getMb007() {
        return mb007;
    }

    public void setMb007(String mb007) {
        this.mb007 = mb007;
    }

    public String getMb008() {
        return mb008;
    }

    public void setMb008(String mb008) {
        this.mb008 = mb008;
    }

    public String getMb009() {
        return mb009;
    }

    public void setMb009(String mb009) {
        this.mb009 = mb009;
    }

    public String getMb010() {
        return mb010;
    }

    public void setMb010(String mb010) {
        this.mb010 = mb010;
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

    public String getRepmb01() {
        return repmb01;
    }

    public void setRepmb01(String repmb01) {
        this.repmb01 = repmb01;
    }

    public String getRepmb02() {
        return repmb02;
    }

    public void setRepmb02(String repmb02) {
        this.repmb02 = repmb02;
    }

    public String getRepmb03() {
        return repmb03;
    }

    public void setRepmb03(String repmb03) {
        this.repmb03 = repmb03;
    }

    public String getRepmb04() {
        return repmb04;
    }

    public void setRepmb04(String repmb04) {
        this.repmb04 = repmb04;
    }

    public String getRepmb05() {
        return repmb05;
    }

    public void setRepmb05(String repmb05) {
        this.repmb05 = repmb05;
    }

    public String getRepmb06() {
        return repmb06;
    }

    public void setRepmb06(String repmb06) {
        this.repmb06 = repmb06;
    }

    public String getRepmb07() {
        return repmb07;
    }

    public void setRepmb07(String repmb07) {
        this.repmb07 = repmb07;
    }

    public String getRepmb08() {
        return repmb08;
    }

    public void setRepmb08(String repmb08) {
        this.repmb08 = repmb08;
    }

    public String getRepmb09() {
        return repmb09;
    }

    public void setRepmb09(String repmb09) {
        this.repmb09 = repmb09;
    }

    public String getRepmb10() {
        return repmb10;
    }

    public void setRepmb10(String repmb10) {
        this.repmb10 = repmb10;
    }

    public String getRepmb11() {
        return repmb11;
    }

    public void setRepmb11(String repmb11) {
        this.repmb11 = repmb11;
    }

    public String getRepmb12() {
        return repmb12;
    }

    public void setRepmb12(String repmb12) {
        this.repmb12 = repmb12;
    }

    public String getRepmb13() {
        return repmb13;
    }

    public void setRepmb13(String repmb13) {
        this.repmb13 = repmb13;
    }

    public String getRepmb14() {
        return repmb14;
    }

    public void setRepmb14(String repmb14) {
        this.repmb14 = repmb14;
    }

    public String getRepmb15() {
        return repmb15;
    }

    public void setRepmb15(String repmb15) {
        this.repmb15 = repmb15;
    }

    public String getRepmb16() {
        return repmb16;
    }

    public void setRepmb16(String repmb16) {
        this.repmb16 = repmb16;
    }

    public String getRepmb17() {
        return repmb17;
    }

    public void setRepmb17(String repmb17) {
        this.repmb17 = repmb17;
    }

    public String getRepmb18() {
        return repmb18;
    }

    public void setRepmb18(String repmb18) {
        this.repmb18 = repmb18;
    }

    public String getRepmb19() {
        return repmb19;
    }

    public void setRepmb19(String repmb19) {
        this.repmb19 = repmb19;
    }

    public String getRepmb20() {
        return repmb20;
    }

    public void setRepmb20(String repmb20) {
        this.repmb20 = repmb20;
    }

    public CMSMV getCmsmv() {
        return cmsmv;
    }

    public void setCmsmv(CMSMV cmsmv) {
        this.cmsmv = cmsmv;
    }

    public WARMJ getWarmj() {
        return warmj;
    }

    public void setWarmj(WARMJ warmj) {
        this.warmj = warmj;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mb001 != null ? mb001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMB)) {
            return false;
        }
        REPMB other = (REPMB) object;
        if ((this.mb001 == null && other.mb001 != null) || (this.mb001 != null && !this.mb001.equals(other.mb001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMB[ mb001=" + mb001 + " ]";
    }

}
