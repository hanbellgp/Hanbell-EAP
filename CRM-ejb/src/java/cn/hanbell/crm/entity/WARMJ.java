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
 * @author C2082
 */
@Entity
@Table(name = "WARMJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARMJ.findAll", query = "SELECT w FROM WARMJ w"),
    @NamedQuery(name = "WARMJ.findByCompany", query = "SELECT w FROM WARMJ w WHERE w.company = :company"),
    @NamedQuery(name = "WARMJ.findByCreator", query = "SELECT w FROM WARMJ w WHERE w.creator = :creator"),
    @NamedQuery(name = "WARMJ.findByUsrGroup", query = "SELECT w FROM WARMJ w WHERE w.usrGroup = :usrGroup"),
    @NamedQuery(name = "WARMJ.findByCreateDate", query = "SELECT w FROM WARMJ w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WARMJ.findByModifier", query = "SELECT w FROM WARMJ w WHERE w.modifier = :modifier"),
    @NamedQuery(name = "WARMJ.findByModiDate", query = "SELECT w FROM WARMJ w WHERE w.modiDate = :modiDate"),
    @NamedQuery(name = "WARMJ.findByFlag", query = "SELECT w FROM WARMJ w WHERE w.flag = :flag"),
    @NamedQuery(name = "WARMJ.findByMj001", query = "SELECT w FROM WARMJ w WHERE w.mj001 = :mj001"),
    @NamedQuery(name = "WARMJ.findByMj002", query = "SELECT w FROM WARMJ w WHERE w.mj002 = :mj002"),
    @NamedQuery(name = "WARMJ.findByMj003", query = "SELECT w FROM WARMJ w WHERE w.mj003 = :mj003"),
    @NamedQuery(name = "WARMJ.findByMj004", query = "SELECT w FROM WARMJ w WHERE w.mj004 = :mj004"),
    @NamedQuery(name = "WARMJ.findByMj005", query = "SELECT w FROM WARMJ w WHERE w.mj005 = :mj005"),
    @NamedQuery(name = "WARMJ.findByCustomer", query = "SELECT w FROM WARMJ w WHERE w.customer = :customer"),
    @NamedQuery(name = "WARMJ.findByProduct", query = "SELECT w FROM WARMJ w WHERE w.product = :product"),
    @NamedQuery(name = "WARMJ.findByRegion", query = "SELECT w FROM WARMJ w WHERE w.region = :region"),
    @NamedQuery(name = "WARMJ.findByDealer", query = "SELECT w FROM WARMJ w WHERE w.dealer = :dealer"),
    @NamedQuery(name = "WARMJ.findByWarmj01", query = "SELECT w FROM WARMJ w WHERE w.warmj01 = :warmj01"),
    @NamedQuery(name = "WARMJ.findByWarmj02", query = "SELECT w FROM WARMJ w WHERE w.warmj02 = :warmj02"),
    @NamedQuery(name = "WARMJ.findByWarmj03", query = "SELECT w FROM WARMJ w WHERE w.warmj03 = :warmj03"),
    @NamedQuery(name = "WARMJ.findByWarmj04", query = "SELECT w FROM WARMJ w WHERE w.warmj04 = :warmj04"),
    @NamedQuery(name = "WARMJ.findByWarmj05", query = "SELECT w FROM WARMJ w WHERE w.warmj05 = :warmj05"),
    @NamedQuery(name = "WARMJ.findByWarmj06", query = "SELECT w FROM WARMJ w WHERE w.warmj06 = :warmj06"),
    @NamedQuery(name = "WARMJ.findByWarmj07", query = "SELECT w FROM WARMJ w WHERE w.warmj07 = :warmj07"),
    @NamedQuery(name = "WARMJ.findByWarmj08", query = "SELECT w FROM WARMJ w WHERE w.warmj08 = :warmj08"),
    @NamedQuery(name = "WARMJ.findByWarmj09", query = "SELECT w FROM WARMJ w WHERE w.warmj09 = :warmj09"),
    @NamedQuery(name = "WARMJ.findByWarmj10", query = "SELECT w FROM WARMJ w WHERE w.warmj10 = :warmj10"),
    @NamedQuery(name = "WARMJ.findByWarmj11", query = "SELECT w FROM WARMJ w WHERE w.warmj11 = :warmj11"),
    @NamedQuery(name = "WARMJ.findByWarmj12", query = "SELECT w FROM WARMJ w WHERE w.warmj12 = :warmj12"),
    @NamedQuery(name = "WARMJ.findByWarmj13", query = "SELECT w FROM WARMJ w WHERE w.warmj13 = :warmj13"),
    @NamedQuery(name = "WARMJ.findByWarmj14", query = "SELECT w FROM WARMJ w WHERE w.warmj14 = :warmj14"),
    @NamedQuery(name = "WARMJ.findByWarmj15", query = "SELECT w FROM WARMJ w WHERE w.warmj15 = :warmj15"),
    @NamedQuery(name = "WARMJ.findByWarmj16", query = "SELECT w FROM WARMJ w WHERE w.warmj16 = :warmj16"),
    @NamedQuery(name = "WARMJ.findByWarmj17", query = "SELECT w FROM WARMJ w WHERE w.warmj17 = :warmj17"),
    @NamedQuery(name = "WARMJ.findByWarmj18", query = "SELECT w FROM WARMJ w WHERE w.warmj18 = :warmj18"),
    @NamedQuery(name = "WARMJ.findByWarmj19", query = "SELECT w FROM WARMJ w WHERE w.warmj19 = :warmj19"),
    @NamedQuery(name = "WARMJ.findByWarmj20", query = "SELECT w FROM WARMJ w WHERE w.warmj20 = :warmj20"),
    @NamedQuery(name = "WARMJ.findByMj006", query = "SELECT w FROM WARMJ w WHERE w.mj006 = :mj006")})
public class WARMJ implements Serializable {

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
    @Column(name = "MJ001")
    private String mj001;
    @Size(max = 40)
    @Column(name = "MJ002")
    private String mj002;
    @Size(max = 1)
    @Column(name = "MJ003")
    private String mj003;
    @Size(max = 1)
    @Column(name = "MJ004")
    private String mj004;
    @Size(max = 255)
    @Column(name = "MJ005")
    private String mj005;
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
    @Column(name = "WARMJ01")
    private String warmj01;
    @Size(max = 255)
    @Column(name = "WARMJ02")
    private String warmj02;
    @Size(max = 255)
    @Column(name = "WARMJ03")
    private String warmj03;
    @Size(max = 255)
    @Column(name = "WARMJ04")
    private String warmj04;
    @Size(max = 255)
    @Column(name = "WARMJ05")
    private String warmj05;
    @Size(max = 255)
    @Column(name = "WARMJ06")
    private String warmj06;
    @Size(max = 255)
    @Column(name = "WARMJ07")
    private String warmj07;
    @Size(max = 255)
    @Column(name = "WARMJ08")
    private String warmj08;
    @Size(max = 255)
    @Column(name = "WARMJ09")
    private String warmj09;
    @Size(max = 255)
    @Column(name = "WARMJ10")
    private String warmj10;
    @Size(max = 255)
    @Column(name = "WARMJ11")
    private String warmj11;
    @Size(max = 255)
    @Column(name = "WARMJ12")
    private String warmj12;
    @Size(max = 255)
    @Column(name = "WARMJ13")
    private String warmj13;
    @Size(max = 255)
    @Column(name = "WARMJ14")
    private String warmj14;
    @Size(max = 255)
    @Column(name = "WARMJ15")
    private String warmj15;
    @Size(max = 255)
    @Column(name = "WARMJ16")
    private String warmj16;
    @Size(max = 255)
    @Column(name = "WARMJ17")
    private String warmj17;
    @Size(max = 255)
    @Column(name = "WARMJ18")
    private String warmj18;
    @Size(max = 255)
    @Column(name = "WARMJ19")
    private String warmj19;
    @Size(max = 255)
    @Column(name = "WARMJ20")
    private String warmj20;
    @Size(max = 1)
    @Column(name = "MJ006")
    private String mj006;

    public WARMJ() {
    }

    public WARMJ(String mj001) {
        this.mj001 = mj001;
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

    public String getMj001() {
        return mj001;
    }

    public void setMj001(String mj001) {
        this.mj001 = mj001;
    }

    public String getMj002() {
        return mj002;
    }

    public void setMj002(String mj002) {
        this.mj002 = mj002;
    }

    public String getMj003() {
        return mj003;
    }

    public void setMj003(String mj003) {
        this.mj003 = mj003;
    }

    public String getMj004() {
        return mj004;
    }

    public void setMj004(String mj004) {
        this.mj004 = mj004;
    }

    public String getMj005() {
        return mj005;
    }

    public void setMj005(String mj005) {
        this.mj005 = mj005;
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

    public String getWarmj01() {
        return warmj01;
    }

    public void setWarmj01(String warmj01) {
        this.warmj01 = warmj01;
    }

    public String getWarmj02() {
        return warmj02;
    }

    public void setWarmj02(String warmj02) {
        this.warmj02 = warmj02;
    }

    public String getWarmj03() {
        return warmj03;
    }

    public void setWarmj03(String warmj03) {
        this.warmj03 = warmj03;
    }

    public String getWarmj04() {
        return warmj04;
    }

    public void setWarmj04(String warmj04) {
        this.warmj04 = warmj04;
    }

    public String getWarmj05() {
        return warmj05;
    }

    public void setWarmj05(String warmj05) {
        this.warmj05 = warmj05;
    }

    public String getWarmj06() {
        return warmj06;
    }

    public void setWarmj06(String warmj06) {
        this.warmj06 = warmj06;
    }

    public String getWarmj07() {
        return warmj07;
    }

    public void setWarmj07(String warmj07) {
        this.warmj07 = warmj07;
    }

    public String getWarmj08() {
        return warmj08;
    }

    public void setWarmj08(String warmj08) {
        this.warmj08 = warmj08;
    }

    public String getWarmj09() {
        return warmj09;
    }

    public void setWarmj09(String warmj09) {
        this.warmj09 = warmj09;
    }

    public String getWarmj10() {
        return warmj10;
    }

    public void setWarmj10(String warmj10) {
        this.warmj10 = warmj10;
    }

    public String getWarmj11() {
        return warmj11;
    }

    public void setWarmj11(String warmj11) {
        this.warmj11 = warmj11;
    }

    public String getWarmj12() {
        return warmj12;
    }

    public void setWarmj12(String warmj12) {
        this.warmj12 = warmj12;
    }

    public String getWarmj13() {
        return warmj13;
    }

    public void setWarmj13(String warmj13) {
        this.warmj13 = warmj13;
    }

    public String getWarmj14() {
        return warmj14;
    }

    public void setWarmj14(String warmj14) {
        this.warmj14 = warmj14;
    }

    public String getWarmj15() {
        return warmj15;
    }

    public void setWarmj15(String warmj15) {
        this.warmj15 = warmj15;
    }

    public String getWarmj16() {
        return warmj16;
    }

    public void setWarmj16(String warmj16) {
        this.warmj16 = warmj16;
    }

    public String getWarmj17() {
        return warmj17;
    }

    public void setWarmj17(String warmj17) {
        this.warmj17 = warmj17;
    }

    public String getWarmj18() {
        return warmj18;
    }

    public void setWarmj18(String warmj18) {
        this.warmj18 = warmj18;
    }

    public String getWarmj19() {
        return warmj19;
    }

    public void setWarmj19(String warmj19) {
        this.warmj19 = warmj19;
    }

    public String getWarmj20() {
        return warmj20;
    }

    public void setWarmj20(String warmj20) {
        this.warmj20 = warmj20;
    }

    public String getMj006() {
        return mj006;
    }

    public void setMj006(String mj006) {
        this.mj006 = mj006;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mj001 != null ? mj001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WARMJ)) {
            return false;
        }
        WARMJ other = (WARMJ) object;
        if ((this.mj001 == null && other.mj001 != null) || (this.mj001 != null && !this.mj001.equals(other.mj001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.WARMJ[ mj001=" + mj001 + " ]";
    }
    
}
