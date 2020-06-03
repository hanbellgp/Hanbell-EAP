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
@Table(name = "SERAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERAC.findAll", query = "SELECT s FROM SERAC s"),
    @NamedQuery(name = "SERAC.findByCompany", query = "SELECT s FROM SERAC s WHERE s.company = :company"),
    @NamedQuery(name = "SERAC.findByCreator", query = "SELECT s FROM SERAC s WHERE s.creator = :creator"),
    @NamedQuery(name = "SERAC.findByUsrGroup", query = "SELECT s FROM SERAC s WHERE s.usrGroup = :usrGroup"),
    @NamedQuery(name = "SERAC.findByCreateDate", query = "SELECT s FROM SERAC s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SERAC.findByModifier", query = "SELECT s FROM SERAC s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SERAC.findByModiDate", query = "SELECT s FROM SERAC s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SERAC.findByFlag", query = "SELECT s FROM SERAC s WHERE s.flag = :flag"),
    @NamedQuery(name = "SERAC.findByAc001", query = "SELECT s FROM SERAC s WHERE s.ac001 = :ac001"),
    @NamedQuery(name = "SERAC.findByAc002", query = "SELECT s FROM SERAC s WHERE s.ac002 = :ac002"),
    @NamedQuery(name = "SERAC.findByAc003", query = "SELECT s FROM SERAC s WHERE s.ac003 = :ac003"),
    @NamedQuery(name = "SERAC.findByAc004", query = "SELECT s FROM SERAC s WHERE s.ac004 = :ac004"),
    @NamedQuery(name = "SERAC.findByAc005", query = "SELECT s FROM SERAC s WHERE s.ac005 = :ac005"),
    @NamedQuery(name = "SERAC.findByAc006", query = "SELECT s FROM SERAC s WHERE s.ac006 = :ac006"),
    @NamedQuery(name = "SERAC.findByCustomer", query = "SELECT s FROM SERAC s WHERE s.customer = :customer"),
    @NamedQuery(name = "SERAC.findByProduct", query = "SELECT s FROM SERAC s WHERE s.product = :product"),
    @NamedQuery(name = "SERAC.findByRegion", query = "SELECT s FROM SERAC s WHERE s.region = :region"),
    @NamedQuery(name = "SERAC.findByDealer", query = "SELECT s FROM SERAC s WHERE s.dealer = :dealer"),
    @NamedQuery(name = "SERAC.findBySerac01", query = "SELECT s FROM SERAC s WHERE s.serac01 = :serac01"),
    @NamedQuery(name = "SERAC.findBySerac02", query = "SELECT s FROM SERAC s WHERE s.serac02 = :serac02"),
    @NamedQuery(name = "SERAC.findBySerac03", query = "SELECT s FROM SERAC s WHERE s.serac03 = :serac03"),
    @NamedQuery(name = "SERAC.findBySerac04", query = "SELECT s FROM SERAC s WHERE s.serac04 = :serac04"),
    @NamedQuery(name = "SERAC.findBySerac05", query = "SELECT s FROM SERAC s WHERE s.serac05 = :serac05"),
    @NamedQuery(name = "SERAC.findBySerac06", query = "SELECT s FROM SERAC s WHERE s.serac06 = :serac06"),
    @NamedQuery(name = "SERAC.findBySerac07", query = "SELECT s FROM SERAC s WHERE s.serac07 = :serac07"),
    @NamedQuery(name = "SERAC.findBySerac08", query = "SELECT s FROM SERAC s WHERE s.serac08 = :serac08"),
    @NamedQuery(name = "SERAC.findBySerac09", query = "SELECT s FROM SERAC s WHERE s.serac09 = :serac09"),
    @NamedQuery(name = "SERAC.findBySerac10", query = "SELECT s FROM SERAC s WHERE s.serac10 = :serac10"),
    @NamedQuery(name = "SERAC.findBySerac11", query = "SELECT s FROM SERAC s WHERE s.serac11 = :serac11"),
    @NamedQuery(name = "SERAC.findBySerac12", query = "SELECT s FROM SERAC s WHERE s.serac12 = :serac12"),
    @NamedQuery(name = "SERAC.findBySerac13", query = "SELECT s FROM SERAC s WHERE s.serac13 = :serac13"),
    @NamedQuery(name = "SERAC.findBySerac14", query = "SELECT s FROM SERAC s WHERE s.serac14 = :serac14"),
    @NamedQuery(name = "SERAC.findBySerac15", query = "SELECT s FROM SERAC s WHERE s.serac15 = :serac15"),
    @NamedQuery(name = "SERAC.findBySerac16", query = "SELECT s FROM SERAC s WHERE s.serac16 = :serac16"),
    @NamedQuery(name = "SERAC.findBySerac17", query = "SELECT s FROM SERAC s WHERE s.serac17 = :serac17"),
    @NamedQuery(name = "SERAC.findBySerac18", query = "SELECT s FROM SERAC s WHERE s.serac18 = :serac18"),
    @NamedQuery(name = "SERAC.findBySerac19", query = "SELECT s FROM SERAC s WHERE s.serac19 = :serac19"),
    @NamedQuery(name = "SERAC.findBySerac20", query = "SELECT s FROM SERAC s WHERE s.serac20 = :serac20")
})
public class SERAC implements Serializable {

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
    @Size(min = 1, max = 3)
    @Column(name = "AC001")
    private String ac001;
    @Size(max = 20)
    @Column(name = "AC002")
    private String ac002;
    @Size(max = 1)
    @Column(name = "AC003")
    private String ac003;
    @Size(max = 1)
    @Column(name = "AC004")
    private String ac004;
    @Size(max = 1)
    @Column(name = "AC005")
    private String ac005;
    @Size(max = 255)
    @Column(name = "AC006")
    private String ac006;
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
    @Column(name = "SERAC01")
    private String serac01;
    @Size(max = 255)
    @Column(name = "SERAC02")
    private String serac02;
    @Size(max = 255)
    @Column(name = "SERAC03")
    private String serac03;
    @Size(max = 255)
    @Column(name = "SERAC04")
    private String serac04;
    @Size(max = 255)
    @Column(name = "SERAC05")
    private String serac05;
    @Size(max = 255)
    @Column(name = "SERAC06")
    private String serac06;
    @Size(max = 255)
    @Column(name = "SERAC07")
    private String serac07;
    @Size(max = 255)
    @Column(name = "SERAC08")
    private String serac08;
    @Size(max = 255)
    @Column(name = "SERAC09")
    private String serac09;
    @Size(max = 255)
    @Column(name = "SERAC10")
    private String serac10;
    @Size(max = 255)
    @Column(name = "SERAC11")
    private String serac11;
    @Size(max = 255)
    @Column(name = "SERAC12")
    private String serac12;
    @Size(max = 255)
    @Column(name = "SERAC13")
    private String serac13;
    @Size(max = 255)
    @Column(name = "SERAC14")
    private String serac14;
    @Size(max = 255)
    @Column(name = "SERAC15")
    private String serac15;
    @Size(max = 255)
    @Column(name = "SERAC16")
    private String serac16;
    @Size(max = 255)
    @Column(name = "SERAC17")
    private String serac17;
    @Size(max = 255)
    @Column(name = "SERAC18")
    private String serac18;
    @Size(max = 255)
    @Column(name = "SERAC19")
    private String serac19;
    @Size(max = 255)
    @Column(name = "SERAC20")
    private String serac20;

    public SERAC() {
    }

    public SERAC(String ac001) {
        this.ac001 = ac001;
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

    public String getAc001() {
        return ac001;
    }

    public void setAc001(String ac001) {
        this.ac001 = ac001;
    }

    public String getAc002() {
        return ac002;
    }

    public void setAc002(String ac002) {
        this.ac002 = ac002;
    }

    public String getAc003() {
        return ac003;
    }

    public void setAc003(String ac003) {
        this.ac003 = ac003;
    }

    public String getAc004() {
        return ac004;
    }

    public void setAc004(String ac004) {
        this.ac004 = ac004;
    }

    public String getAc005() {
        return ac005;
    }

    public void setAc005(String ac005) {
        this.ac005 = ac005;
    }

    public String getAc006() {
        return ac006;
    }

    public void setAc006(String ac006) {
        this.ac006 = ac006;
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

    public String getSerac01() {
        return serac01;
    }

    public void setSerac01(String serac01) {
        this.serac01 = serac01;
    }

    public String getSerac02() {
        return serac02;
    }

    public void setSerac02(String serac02) {
        this.serac02 = serac02;
    }

    public String getSerac03() {
        return serac03;
    }

    public void setSerac03(String serac03) {
        this.serac03 = serac03;
    }

    public String getSerac04() {
        return serac04;
    }

    public void setSerac04(String serac04) {
        this.serac04 = serac04;
    }

    public String getSerac05() {
        return serac05;
    }

    public void setSerac05(String serac05) {
        this.serac05 = serac05;
    }

    public String getSerac06() {
        return serac06;
    }

    public void setSerac06(String serac06) {
        this.serac06 = serac06;
    }

    public String getSerac07() {
        return serac07;
    }

    public void setSerac07(String serac07) {
        this.serac07 = serac07;
    }

    public String getSerac08() {
        return serac08;
    }

    public void setSerac08(String serac08) {
        this.serac08 = serac08;
    }

    public String getSerac09() {
        return serac09;
    }

    public void setSerac09(String serac09) {
        this.serac09 = serac09;
    }

    public String getSerac10() {
        return serac10;
    }

    public void setSerac10(String serac10) {
        this.serac10 = serac10;
    }

    public String getSerac11() {
        return serac11;
    }

    public void setSerac11(String serac11) {
        this.serac11 = serac11;
    }

    public String getSerac12() {
        return serac12;
    }

    public void setSerac12(String serac12) {
        this.serac12 = serac12;
    }

    public String getSerac13() {
        return serac13;
    }

    public void setSerac13(String serac13) {
        this.serac13 = serac13;
    }

    public String getSerac14() {
        return serac14;
    }

    public void setSerac14(String serac14) {
        this.serac14 = serac14;
    }

    public String getSerac15() {
        return serac15;
    }

    public void setSerac15(String serac15) {
        this.serac15 = serac15;
    }

    public String getSerac16() {
        return serac16;
    }

    public void setSerac16(String serac16) {
        this.serac16 = serac16;
    }

    public String getSerac17() {
        return serac17;
    }

    public void setSerac17(String serac17) {
        this.serac17 = serac17;
    }

    public String getSerac18() {
        return serac18;
    }

    public void setSerac18(String serac18) {
        this.serac18 = serac18;
    }

    public String getSerac19() {
        return serac19;
    }

    public void setSerac19(String serac19) {
        this.serac19 = serac19;
    }

    public String getSerac20() {
        return serac20;
    }

    public void setSerac20(String serac20) {
        this.serac20 = serac20;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ac001 != null ? ac001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERAC)) {
            return false;
        }
        SERAC other = (SERAC) object;
        if ((this.ac001 == null && other.ac001 != null) || (this.ac001 != null && !this.ac001.equals(other.ac001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.Serac[ ac001=" + ac001 + " ]";
    }
    
}
