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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "REPMU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPMU.findAll", query = "SELECT r FROM REPMU r"),
    @NamedQuery(name = "REPMU.findByCompany", query = "SELECT r FROM REPMU r WHERE r.company = :company"),
    @NamedQuery(name = "REPMU.findByCreator", query = "SELECT r FROM REPMU r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPMU.findByUsrGroup", query = "SELECT r FROM REPMU r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPMU.findByCreateDate", query = "SELECT r FROM REPMU r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPMU.findByModifier", query = "SELECT r FROM REPMU r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPMU.findByModiDate", query = "SELECT r FROM REPMU r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPMU.findByFlag", query = "SELECT r FROM REPMU r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPMU.findByMu001", query = "SELECT r FROM REPMU r WHERE r.rEPMUPK.mu001 = :mu001"),
    @NamedQuery(name = "REPMU.findByMu002", query = "SELECT r FROM REPMU r WHERE r.mu002 = :mu002"),
    @NamedQuery(name = "REPMU.findByMu003", query = "SELECT r FROM REPMU r WHERE r.rEPMUPK.mu003 = :mu003"),
    @NamedQuery(name = "REPMU.findByCustomer", query = "SELECT r FROM REPMU r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPMU.findByProduct", query = "SELECT r FROM REPMU r WHERE r.product = :product"),
    @NamedQuery(name = "REPMU.findByRegion", query = "SELECT r FROM REPMU r WHERE r.region = :region"),
    @NamedQuery(name = "REPMU.findByDealer", query = "SELECT r FROM REPMU r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPMU.findByRepmu01", query = "SELECT r FROM REPMU r WHERE r.repmu01 = :repmu01"),
    @NamedQuery(name = "REPMU.findByRepmu02", query = "SELECT r FROM REPMU r WHERE r.repmu02 = :repmu02"),
    @NamedQuery(name = "REPMU.findByRepmu03", query = "SELECT r FROM REPMU r WHERE r.repmu03 = :repmu03"),
    @NamedQuery(name = "REPMU.findByRepmu04", query = "SELECT r FROM REPMU r WHERE r.repmu04 = :repmu04"),
    @NamedQuery(name = "REPMU.findByRepmu05", query = "SELECT r FROM REPMU r WHERE r.repmu05 = :repmu05"),
    @NamedQuery(name = "REPMU.findByRepmu06", query = "SELECT r FROM REPMU r WHERE r.repmu06 = :repmu06"),
    @NamedQuery(name = "REPMU.findByRepmu07", query = "SELECT r FROM REPMU r WHERE r.repmu07 = :repmu07"),
    @NamedQuery(name = "REPMU.findByRepmu08", query = "SELECT r FROM REPMU r WHERE r.repmu08 = :repmu08"),
    @NamedQuery(name = "REPMU.findByRepmu09", query = "SELECT r FROM REPMU r WHERE r.repmu09 = :repmu09"),
    @NamedQuery(name = "REPMU.findByRepmu10", query = "SELECT r FROM REPMU r WHERE r.repmu10 = :repmu10"),
    @NamedQuery(name = "REPMU.findByRepmu11", query = "SELECT r FROM REPMU r WHERE r.repmu11 = :repmu11"),
    @NamedQuery(name = "REPMU.findByRepmu12", query = "SELECT r FROM REPMU r WHERE r.repmu12 = :repmu12"),
    @NamedQuery(name = "REPMU.findByRepmu13", query = "SELECT r FROM REPMU r WHERE r.repmu13 = :repmu13"),
    @NamedQuery(name = "REPMU.findByRepmu14", query = "SELECT r FROM REPMU r WHERE r.repmu14 = :repmu14"),
    @NamedQuery(name = "REPMU.findByRepmu15", query = "SELECT r FROM REPMU r WHERE r.repmu15 = :repmu15"),
    @NamedQuery(name = "REPMU.findByRepmu16", query = "SELECT r FROM REPMU r WHERE r.repmu16 = :repmu16"),
    @NamedQuery(name = "REPMU.findByRepmu17", query = "SELECT r FROM REPMU r WHERE r.repmu17 = :repmu17"),
    @NamedQuery(name = "REPMU.findByRepmu18", query = "SELECT r FROM REPMU r WHERE r.repmu18 = :repmu18"),
    @NamedQuery(name = "REPMU.findByRepmu19", query = "SELECT r FROM REPMU r WHERE r.repmu19 = :repmu19"),
    @NamedQuery(name = "REPMU.findByRepmu20", query = "SELECT r FROM REPMU r WHERE r.repmu20 = :repmu20")})
public class REPMU implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPMUPK rEPMUPK;
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
    @Size(max = 2)
    @Column(name = "MU002")
    private String mu002;
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
    @Column(name = "REPMU01")
    private String repmu01;
    @Size(max = 255)
    @Column(name = "REPMU02")
    private String repmu02;
    @Size(max = 255)
    @Column(name = "REPMU03")
    private String repmu03;
    @Size(max = 255)
    @Column(name = "REPMU04")
    private String repmu04;
    @Size(max = 255)
    @Column(name = "REPMU05")
    private String repmu05;
    @Size(max = 255)
    @Column(name = "REPMU06")
    private String repmu06;
    @Size(max = 255)
    @Column(name = "REPMU07")
    private String repmu07;
    @Size(max = 255)
    @Column(name = "REPMU08")
    private String repmu08;
    @Size(max = 255)
    @Column(name = "REPMU09")
    private String repmu09;
    @Size(max = 255)
    @Column(name = "REPMU10")
    private String repmu10;
    @Size(max = 255)
    @Column(name = "REPMU11")
    private String repmu11;
    @Size(max = 255)
    @Column(name = "REPMU12")
    private String repmu12;
    @Size(max = 255)
    @Column(name = "REPMU13")
    private String repmu13;
    @Size(max = 255)
    @Column(name = "REPMU14")
    private String repmu14;
    @Size(max = 255)
    @Column(name = "REPMU15")
    private String repmu15;
    @Size(max = 255)
    @Column(name = "REPMU16")
    private String repmu16;
    @Size(max = 255)
    @Column(name = "REPMU17")
    private String repmu17;
    @Size(max = 255)
    @Column(name = "REPMU18")
    private String repmu18;
    @Size(max = 255)
    @Column(name = "REPMU19")
    private String repmu19;
    @Size(max = 255)
    @Column(name = "REPMU20")
    private String repmu20;
    @JoinColumn(name = "MU001", referencedColumnName = "MQ001", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private REPMQ Repmq;
    
    public REPMU() {
    }

    public REPMU(REPMUPK rEPMUPK) {
        this.rEPMUPK = rEPMUPK;
    }

    public REPMU(String mu001, String mu003) {
        this.rEPMUPK = new REPMUPK(mu001, mu003);
    }

    public REPMUPK getREPMUPK() {
        return rEPMUPK;
    }

    public void setREPMUPK(REPMUPK rEPMUPK) {
        this.rEPMUPK = rEPMUPK;
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

    public String getMu002() {
        return mu002;
    }

    public void setMu002(String mu002) {
        this.mu002 = mu002;
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

    public String getRepmu01() {
        return repmu01;
    }

    public void setRepmu01(String repmu01) {
        this.repmu01 = repmu01;
    }

    public String getRepmu02() {
        return repmu02;
    }

    public void setRepmu02(String repmu02) {
        this.repmu02 = repmu02;
    }

    public String getRepmu03() {
        return repmu03;
    }

    public void setRepmu03(String repmu03) {
        this.repmu03 = repmu03;
    }

    public String getRepmu04() {
        return repmu04;
    }

    public void setRepmu04(String repmu04) {
        this.repmu04 = repmu04;
    }

    public String getRepmu05() {
        return repmu05;
    }

    public void setRepmu05(String repmu05) {
        this.repmu05 = repmu05;
    }

    public String getRepmu06() {
        return repmu06;
    }

    public void setRepmu06(String repmu06) {
        this.repmu06 = repmu06;
    }

    public String getRepmu07() {
        return repmu07;
    }

    public void setRepmu07(String repmu07) {
        this.repmu07 = repmu07;
    }

    public String getRepmu08() {
        return repmu08;
    }

    public void setRepmu08(String repmu08) {
        this.repmu08 = repmu08;
    }

    public String getRepmu09() {
        return repmu09;
    }

    public void setRepmu09(String repmu09) {
        this.repmu09 = repmu09;
    }

    public String getRepmu10() {
        return repmu10;
    }

    public void setRepmu10(String repmu10) {
        this.repmu10 = repmu10;
    }

    public String getRepmu11() {
        return repmu11;
    }

    public void setRepmu11(String repmu11) {
        this.repmu11 = repmu11;
    }

    public String getRepmu12() {
        return repmu12;
    }

    public void setRepmu12(String repmu12) {
        this.repmu12 = repmu12;
    }

    public String getRepmu13() {
        return repmu13;
    }

    public void setRepmu13(String repmu13) {
        this.repmu13 = repmu13;
    }

    public String getRepmu14() {
        return repmu14;
    }

    public void setRepmu14(String repmu14) {
        this.repmu14 = repmu14;
    }

    public String getRepmu15() {
        return repmu15;
    }

    public void setRepmu15(String repmu15) {
        this.repmu15 = repmu15;
    }

    public String getRepmu16() {
        return repmu16;
    }

    public void setRepmu16(String repmu16) {
        this.repmu16 = repmu16;
    }

    public String getRepmu17() {
        return repmu17;
    }

    public void setRepmu17(String repmu17) {
        this.repmu17 = repmu17;
    }

    public String getRepmu18() {
        return repmu18;
    }

    public void setRepmu18(String repmu18) {
        this.repmu18 = repmu18;
    }

    public String getRepmu19() {
        return repmu19;
    }

    public void setRepmu19(String repmu19) {
        this.repmu19 = repmu19;
    }

    public String getRepmu20() {
        return repmu20;
    }

    public void setRepmu20(String repmu20) {
        this.repmu20 = repmu20;
    }

    public REPMUPK getrEPMUPK() {
        return rEPMUPK;
    }

    public void setrEPMUPK(REPMUPK rEPMUPK) {
        this.rEPMUPK = rEPMUPK;
    }

    public REPMQ getRepmq() {
        return Repmq;
    }

    public void setRepmq(REPMQ Repmq) {
        this.Repmq = Repmq;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPMUPK != null ? rEPMUPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPMU)) {
            return false;
        }
        REPMU other = (REPMU) object;
        if ((this.rEPMUPK == null && other.rEPMUPK != null) || (this.rEPMUPK != null && !this.rEPMUPK.equals(other.rEPMUPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPMU[ rEPMUPK=" + rEPMUPK + " ]";
    }
    
}
