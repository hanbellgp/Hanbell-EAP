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
 * @author Administrator
 */
@Entity
@Table(name = "REPPW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPPW.findAll", query = "SELECT r FROM REPPW r"),
    @NamedQuery(name = "REPPW.findByCompany", query = "SELECT r FROM REPPW r WHERE r.company = :company"),
    @NamedQuery(name = "REPPW.findByCreator", query = "SELECT r FROM REPPW r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPPW.findByUsrGroup", query = "SELECT r FROM REPPW r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPPW.findByCreateDate", query = "SELECT r FROM REPPW r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPPW.findByModifier", query = "SELECT r FROM REPPW r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPPW.findByModiDate", query = "SELECT r FROM REPPW r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPPW.findByFlag", query = "SELECT r FROM REPPW r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPPW.findByReppw01", query = "SELECT r FROM REPPW r WHERE r.reppw01 = :reppw01"),
    @NamedQuery(name = "REPPW.findByReppw02", query = "SELECT r FROM REPPW r WHERE r.reppw02 = :reppw02"),
    @NamedQuery(name = "REPPW.findByReppw03", query = "SELECT r FROM REPPW r WHERE r.reppw03 = :reppw03"),
    @NamedQuery(name = "REPPW.findByReppw04", query = "SELECT r FROM REPPW r WHERE r.reppw04 = :reppw04"),
    @NamedQuery(name = "REPPW.findByReppw05", query = "SELECT r FROM REPPW r WHERE r.reppw05 = :reppw05"),
    @NamedQuery(name = "REPPW.findByReppw06", query = "SELECT r FROM REPPW r WHERE r.reppw06 = :reppw06"),
    @NamedQuery(name = "REPPW.findByReppw07", query = "SELECT r FROM REPPW r WHERE r.reppw07 = :reppw07"),
    @NamedQuery(name = "REPPW.findByReppw08", query = "SELECT r FROM REPPW r WHERE r.reppw08 = :reppw08"),
    @NamedQuery(name = "REPPW.findByReppw09", query = "SELECT r FROM REPPW r WHERE r.reppw09 = :reppw09"),
    @NamedQuery(name = "REPPW.findByReppw10", query = "SELECT r FROM REPPW r WHERE r.reppw10 = :reppw10"),
    @NamedQuery(name = "REPPW.findByReppw11", query = "SELECT r FROM REPPW r WHERE r.reppw11 = :reppw11"),
    @NamedQuery(name = "REPPW.findByReppw12", query = "SELECT r FROM REPPW r WHERE r.reppw12 = :reppw12"),
    @NamedQuery(name = "REPPW.findByReppw13", query = "SELECT r FROM REPPW r WHERE r.reppw13 = :reppw13"),
    @NamedQuery(name = "REPPW.findByReppw14", query = "SELECT r FROM REPPW r WHERE r.reppw14 = :reppw14"),
    @NamedQuery(name = "REPPW.findByReppw15", query = "SELECT r FROM REPPW r WHERE r.reppw15 = :reppw15"),
    @NamedQuery(name = "REPPW.findByReppw16", query = "SELECT r FROM REPPW r WHERE r.reppw16 = :reppw16"),
    @NamedQuery(name = "REPPW.findByReppw17", query = "SELECT r FROM REPPW r WHERE r.reppw17 = :reppw17"),
    @NamedQuery(name = "REPPW.findByReppw18", query = "SELECT r FROM REPPW r WHERE r.reppw18 = :reppw18"),
    @NamedQuery(name = "REPPW.findByReppw19", query = "SELECT r FROM REPPW r WHERE r.reppw19 = :reppw19"),
    @NamedQuery(name = "REPPW.findByReppw20", query = "SELECT r FROM REPPW r WHERE r.reppw20 = :reppw20"),
    @NamedQuery(name = "REPPW.findByCustomer", query = "SELECT r FROM REPPW r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPPW.findByProduct", query = "SELECT r FROM REPPW r WHERE r.product = :product"),
    @NamedQuery(name = "REPPW.findByRegion", query = "SELECT r FROM REPPW r WHERE r.region = :region"),
    @NamedQuery(name = "REPPW.findByDealer", query = "SELECT r FROM REPPW r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPPW.findByPw001", query = "SELECT r FROM REPPW r WHERE r.rEPPWPK.pw001 = :pw001"),
    @NamedQuery(name = "REPPW.findByPw002", query = "SELECT r FROM REPPW r WHERE r.rEPPWPK.pw002 = :pw002"),
    @NamedQuery(name = "REPPW.findByPw003", query = "SELECT r FROM REPPW r WHERE r.rEPPWPK.pw003 = :pw003"),
    @NamedQuery(name = "REPPW.findByPw004", query = "SELECT r FROM REPPW r WHERE r.pw004 = :pw004"),
    @NamedQuery(name = "REPPW.findByPw005", query = "SELECT r FROM REPPW r WHERE r.pw005 = :pw005"),
    @NamedQuery(name = "REPPW.findByPw006", query = "SELECT r FROM REPPW r WHERE r.pw006 = :pw006"),
    @NamedQuery(name = "REPPW.findByPw007", query = "SELECT r FROM REPPW r WHERE r.pw007 = :pw007"),
    @NamedQuery(name = "REPPW.findByPw008", query = "SELECT r FROM REPPW r WHERE r.pw008 = :pw008"),
    @NamedQuery(name = "REPPW.findByPw009", query = "SELECT r FROM REPPW r WHERE r.pw009 = :pw009"),
    @NamedQuery(name = "REPPW.findByPw010", query = "SELECT r FROM REPPW r WHERE r.pw010 = :pw010"),
    @NamedQuery(name = "REPPW.findByPw011", query = "SELECT r FROM REPPW r WHERE r.pw011 = :pw011"),
    @NamedQuery(name = "REPPW.findByPw012", query = "SELECT r FROM REPPW r WHERE r.pw012 = :pw012"),
    @NamedQuery(name = "REPPW.findByPw013", query = "SELECT r FROM REPPW r WHERE r.pw013 = :pw013"),
    @NamedQuery(name = "REPPW.findByPw014", query = "SELECT r FROM REPPW r WHERE r.pw014 = :pw014"),
    @NamedQuery(name = "REPPW.findByPw015", query = "SELECT r FROM REPPW r WHERE r.pw015 = :pw015"),
    @NamedQuery(name = "REPPW.findByPw016", query = "SELECT r FROM REPPW r WHERE r.pw016 = :pw016"),
    @NamedQuery(name = "REPPW.findByPw017", query = "SELECT r FROM REPPW r WHERE r.pw017 = :pw017"),
    @NamedQuery(name = "REPPW.findByPw018", query = "SELECT r FROM REPPW r WHERE r.pw018 = :pw018"),
    @NamedQuery(name = "REPPW.findByPw019", query = "SELECT r FROM REPPW r WHERE r.pw019 = :pw019"),
    @NamedQuery(name = "REPPW.findByPw020", query = "SELECT r FROM REPPW r WHERE r.pw020 = :pw020"),
    @NamedQuery(name = "REPPW.findByPw021", query = "SELECT r FROM REPPW r WHERE r.pw021 = :pw021"),
    @NamedQuery(name = "REPPW.findByPw022", query = "SELECT r FROM REPPW r WHERE r.pw022 = :pw022"),
    @NamedQuery(name = "REPPW.findByPw023", query = "SELECT r FROM REPPW r WHERE r.pw023 = :pw023"),
    @NamedQuery(name = "REPPW.findByPw024", query = "SELECT r FROM REPPW r WHERE r.pw024 = :pw024"),
    @NamedQuery(name = "REPPW.findByPw025", query = "SELECT r FROM REPPW r WHERE r.pw025 = :pw025"),
    @NamedQuery(name = "REPPW.findByPw026", query = "SELECT r FROM REPPW r WHERE r.pw026 = :pw026"),
    @NamedQuery(name = "REPPW.findByPw001AndPw002", query = "SELECT r FROM REPPW r WHERE r.rEPPWPK.pw001 = :pw001 AND r.rEPPWPK.pw002 = :pw002"),
    @NamedQuery(name = "REPPW.findByPw001AndPw002AndPw010AndPw019", query = "SELECT r FROM REPPW r WHERE r.rEPPWPK.pw001 = :pw001 AND r.rEPPWPK.pw002 = :pw002 AND r.pw010 = :pw010 AND r.pw019 = :pw019"),
     @NamedQuery(name = "REPPW.findByPw001AndPw002AndPw019", query = "SELECT r FROM REPPW r WHERE r.rEPPWPK.pw001 = :pw001 AND r.rEPPWPK.pw002 = :pw002 AND r.pw019 = :pw019")
})
public class REPPW implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPPWPK rEPPWPK;
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
    @Size(max = 255)
    @Column(name = "REPPW01")
    private String reppw01;
    @Size(max = 255)
    @Column(name = "REPPW02")
    private String reppw02;
    @Size(max = 255)
    @Column(name = "REPPW03")
    private String reppw03;
    @Size(max = 255)
    @Column(name = "REPPW04")
    private String reppw04;
    @Size(max = 255)
    @Column(name = "REPPW05")
    private String reppw05;
    @Size(max = 255)
    @Column(name = "REPPW06")
    private String reppw06;
    @Size(max = 255)
    @Column(name = "REPPW07")
    private String reppw07;
    @Size(max = 255)
    @Column(name = "REPPW08")
    private String reppw08;
    @Size(max = 255)
    @Column(name = "REPPW09")
    private String reppw09;
    @Size(max = 255)
    @Column(name = "REPPW10")
    private String reppw10;
    @Size(max = 255)
    @Column(name = "REPPW11")
    private String reppw11;
    @Size(max = 255)
    @Column(name = "REPPW12")
    private String reppw12;
    @Size(max = 255)
    @Column(name = "REPPW13")
    private String reppw13;
    @Size(max = 255)
    @Column(name = "REPPW14")
    private String reppw14;
    @Size(max = 255)
    @Column(name = "REPPW15")
    private String reppw15;
    @Size(max = 255)
    @Column(name = "REPPW16")
    private String reppw16;
    @Size(max = 255)
    @Column(name = "REPPW17")
    private String reppw17;
    @Size(max = 255)
    @Column(name = "REPPW18")
    private String reppw18;
    @Size(max = 255)
    @Column(name = "REPPW19")
    private String reppw19;
    @Size(max = 255)
    @Column(name = "REPPW20")
    private String reppw20;
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
    @Size(max = 10)
    @Column(name = "PW004")
    private String pw004;
    @Size(max = 10)
    @Column(name = "PW005")
    private String pw005;
    @Size(max = 8)
    @Column(name = "PW006")
    private String pw006;
    @Size(max = 8)
    @Column(name = "PW007")
    private String pw007;
    @Size(max = 4)
    @Column(name = "PW008")
    private String pw008;
    @Size(max = 11)
    @Column(name = "PW009")
    private String pw009;
    @Size(max = 2)
    @Column(name = "PW010")
    private String pw010;
    @Size(max = 8)
    @Column(name = "PW011")
    private String pw011;
    @Size(max = 10)
    @Column(name = "PW012")
    private String pw012;
    @Column(name = "PW013")
    private Short pw013;
    @Size(max = 10)
    @Column(name = "PW014")
    private String pw014;
    @Size(max = 16)
    @Column(name = "PW015")
    private String pw015;
    @Size(max = 4)
    @Column(name = "PW016")
    private String pw016;
    @Size(max = 11)
    @Column(name = "PW017")
    private String pw017;
    @Size(max = 8)
    @Column(name = "PW018")
    private String pw018;
    @Size(max = 1)
    @Column(name = "PW019")
    private String pw019;
    @Size(max = 1)
    @Column(name = "PW020")
    private String pw020;
    @Size(max = 4)
    @Column(name = "PW021")
    private String pw021;
    @Size(max = 4)
    @Column(name = "PW022")
    private String pw022;
    @Size(max = 4)
    @Column(name = "PW023")
    private String pw023;
    @Size(max = 1)
    @Column(name = "PW024")
    private String pw024;
    @Size(max = 255)
    @Column(name = "PW025")
    private String pw025;
    @Size(max = 20)
    @Column(name = "PW026")
    private String pw026;
    @JoinColumn(name = "PW004", referencedColumnName = "MV001", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private CMSMV cmsmv;
    public REPPW() {
    }

    public REPPW(REPPWPK rEPPWPK) {
        this.rEPPWPK = rEPPWPK;
    }

    public REPPW(String pw001, String pw002, String pw003) {
        this.rEPPWPK = new REPPWPK(pw001, pw002, pw003);
    }

    public REPPWPK getREPPWPK() {
        return rEPPWPK;
    }

    public void setREPPWPK(REPPWPK rEPPWPK) {
        this.rEPPWPK = rEPPWPK;
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

    public String getReppw01() {
        return reppw01;
    }

    public void setReppw01(String reppw01) {
        this.reppw01 = reppw01;
    }

    public String getReppw02() {
        return reppw02;
    }

    public void setReppw02(String reppw02) {
        this.reppw02 = reppw02;
    }

    public String getReppw03() {
        return reppw03;
    }

    public void setReppw03(String reppw03) {
        this.reppw03 = reppw03;
    }

    public String getReppw04() {
        return reppw04;
    }

    public void setReppw04(String reppw04) {
        this.reppw04 = reppw04;
    }

    public String getReppw05() {
        return reppw05;
    }

    public void setReppw05(String reppw05) {
        this.reppw05 = reppw05;
    }

    public String getReppw06() {
        return reppw06;
    }

    public void setReppw06(String reppw06) {
        this.reppw06 = reppw06;
    }

    public String getReppw07() {
        return reppw07;
    }

    public void setReppw07(String reppw07) {
        this.reppw07 = reppw07;
    }

    public String getReppw08() {
        return reppw08;
    }

    public void setReppw08(String reppw08) {
        this.reppw08 = reppw08;
    }

    public String getReppw09() {
        return reppw09;
    }

    public void setReppw09(String reppw09) {
        this.reppw09 = reppw09;
    }

    public String getReppw10() {
        return reppw10;
    }

    public void setReppw10(String reppw10) {
        this.reppw10 = reppw10;
    }

    public String getReppw11() {
        return reppw11;
    }

    public void setReppw11(String reppw11) {
        this.reppw11 = reppw11;
    }

    public String getReppw12() {
        return reppw12;
    }

    public void setReppw12(String reppw12) {
        this.reppw12 = reppw12;
    }

    public String getReppw13() {
        return reppw13;
    }

    public void setReppw13(String reppw13) {
        this.reppw13 = reppw13;
    }

    public String getReppw14() {
        return reppw14;
    }

    public void setReppw14(String reppw14) {
        this.reppw14 = reppw14;
    }

    public String getReppw15() {
        return reppw15;
    }

    public void setReppw15(String reppw15) {
        this.reppw15 = reppw15;
    }

    public String getReppw16() {
        return reppw16;
    }

    public void setReppw16(String reppw16) {
        this.reppw16 = reppw16;
    }

    public String getReppw17() {
        return reppw17;
    }

    public void setReppw17(String reppw17) {
        this.reppw17 = reppw17;
    }

    public String getReppw18() {
        return reppw18;
    }

    public void setReppw18(String reppw18) {
        this.reppw18 = reppw18;
    }

    public String getReppw19() {
        return reppw19;
    }

    public void setReppw19(String reppw19) {
        this.reppw19 = reppw19;
    }

    public String getReppw20() {
        return reppw20;
    }

    public void setReppw20(String reppw20) {
        this.reppw20 = reppw20;
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

    public String getPw004() {
        return pw004;
    }

    public void setPw004(String pw004) {
        this.pw004 = pw004;
    }

    public String getPw005() {
        return pw005;
    }

    public void setPw005(String pw005) {
        this.pw005 = pw005;
    }

    public String getPw006() {
        return pw006;
    }

    public void setPw006(String pw006) {
        this.pw006 = pw006;
    }

    public String getPw007() {
        return pw007;
    }

    public void setPw007(String pw007) {
        this.pw007 = pw007;
    }

    public String getPw008() {
        return pw008;
    }

    public void setPw008(String pw008) {
        this.pw008 = pw008;
    }

    public String getPw009() {
        return pw009;
    }

    public void setPw009(String pw009) {
        this.pw009 = pw009;
    }

    public String getPw010() {
        return pw010;
    }

    public void setPw010(String pw010) {
        this.pw010 = pw010;
    }

    public String getPw011() {
        return pw011;
    }

    public void setPw011(String pw011) {
        this.pw011 = pw011;
    }

    public String getPw012() {
        return pw012;
    }

    public void setPw012(String pw012) {
        this.pw012 = pw012;
    }

    public Short getPw013() {
        return pw013;
    }

    public void setPw013(Short pw013) {
        this.pw013 = pw013;
    }

    public String getPw014() {
        return pw014;
    }

    public void setPw014(String pw014) {
        this.pw014 = pw014;
    }

    public String getPw015() {
        return pw015;
    }

    public void setPw015(String pw015) {
        this.pw015 = pw015;
    }

    public String getPw016() {
        return pw016;
    }

    public void setPw016(String pw016) {
        this.pw016 = pw016;
    }

    public String getPw017() {
        return pw017;
    }

    public void setPw017(String pw017) {
        this.pw017 = pw017;
    }

    public String getPw018() {
        return pw018;
    }

    public void setPw018(String pw018) {
        this.pw018 = pw018;
    }

    public String getPw019() {
        return pw019;
    }

    public void setPw019(String pw019) {
        this.pw019 = pw019;
    }

    public String getPw020() {
        return pw020;
    }

    public void setPw020(String pw020) {
        this.pw020 = pw020;
    }

    public String getPw021() {
        return pw021;
    }

    public void setPw021(String pw021) {
        this.pw021 = pw021;
    }

    public String getPw022() {
        return pw022;
    }

    public void setPw022(String pw022) {
        this.pw022 = pw022;
    }

    public String getPw023() {
        return pw023;
    }

    public void setPw023(String pw023) {
        this.pw023 = pw023;
    }

    public String getPw024() {
        return pw024;
    }

    public void setPw024(String pw024) {
        this.pw024 = pw024;
    }

    public String getPw025() {
        return pw025;
    }

    public void setPw025(String pw025) {
        this.pw025 = pw025;
    }

    public String getPw026() {
        return pw026;
    }

    public void setPw026(String pw026) {
        this.pw026 = pw026;
    }

    public CMSMV getCmsmv() {
        return cmsmv;
    }

    public void setCmsmv(CMSMV cmsmv) {
        this.cmsmv = cmsmv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPPWPK != null ? rEPPWPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPPW)) {
            return false;
        }
        REPPW other = (REPPW) object;
        if ((this.rEPPWPK == null && other.rEPPWPK != null) || (this.rEPPWPK != null && !this.rEPPWPK.equals(other.rEPPWPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.REPPW[ rEPPWPK=" + rEPPWPK + " ]";
    }

}
