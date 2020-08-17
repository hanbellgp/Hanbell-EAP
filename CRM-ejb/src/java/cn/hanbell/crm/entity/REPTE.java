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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "REPTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "REPTE.findAll", query = "SELECT r FROM REPTE r"),
    @NamedQuery(name = "REPTE.findByPK", query = "SELECT r FROM REPTE r WHERE r.rEPTEPK.te001 = :te001 AND r.rEPTEPK.te002 = :te002 AND r.rEPTEPK.te004 = :te004"),
    @NamedQuery(name = "REPTE.findByCompany", query = "SELECT r FROM REPTE r WHERE r.company = :company"),
    @NamedQuery(name = "REPTE.findByCreator", query = "SELECT r FROM REPTE r WHERE r.creator = :creator"),
    @NamedQuery(name = "REPTE.findByUsrGroup", query = "SELECT r FROM REPTE r WHERE r.usrGroup = :usrGroup"),
    @NamedQuery(name = "REPTE.findByCreateDate", query = "SELECT r FROM REPTE r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "REPTE.findByModifier", query = "SELECT r FROM REPTE r WHERE r.modifier = :modifier"),
    @NamedQuery(name = "REPTE.findByModiDate", query = "SELECT r FROM REPTE r WHERE r.modiDate = :modiDate"),
    @NamedQuery(name = "REPTE.findByFlag", query = "SELECT r FROM REPTE r WHERE r.flag = :flag"),
    @NamedQuery(name = "REPTE.findByTe001", query = "SELECT r FROM REPTE r WHERE r.rEPTEPK.te001 = :te001"),
    @NamedQuery(name = "REPTE.findByTe002", query = "SELECT r FROM REPTE r WHERE r.rEPTEPK.te002 = :te002"),
    @NamedQuery(name = "REPTE.findByTe003", query = "SELECT r FROM REPTE r WHERE r.te003 = :te003"),
    @NamedQuery(name = "REPTE.findByTe004", query = "SELECT r FROM REPTE r WHERE r.rEPTEPK.te004 = :te004"),
    @NamedQuery(name = "REPTE.findByTe005", query = "SELECT r FROM REPTE r WHERE r.te005 = :te005"),
    @NamedQuery(name = "REPTE.findByTe006", query = "SELECT r FROM REPTE r WHERE r.te006 = :te006"),
    @NamedQuery(name = "REPTE.findByTe007", query = "SELECT r FROM REPTE r WHERE r.te007 = :te007"),
    @NamedQuery(name = "REPTE.findByTe008", query = "SELECT r FROM REPTE r WHERE r.te008 = :te008"),
    @NamedQuery(name = "REPTE.findByTe009", query = "SELECT r FROM REPTE r WHERE r.te009 = :te009"),
    @NamedQuery(name = "REPTE.findByTe010", query = "SELECT r FROM REPTE r WHERE r.te010 = :te010"),
    @NamedQuery(name = "REPTE.findByTe011", query = "SELECT r FROM REPTE r WHERE r.te011 = :te011"),
    @NamedQuery(name = "REPTE.findByTe012", query = "SELECT r FROM REPTE r WHERE r.te012 = :te012"),
    @NamedQuery(name = "REPTE.findByTe013", query = "SELECT r FROM REPTE r WHERE r.te013 = :te013"),
    @NamedQuery(name = "REPTE.findByTe014", query = "SELECT r FROM REPTE r WHERE r.te014 = :te014"),
    @NamedQuery(name = "REPTE.findByTe015", query = "SELECT r FROM REPTE r WHERE r.te015 = :te015"),
    @NamedQuery(name = "REPTE.findByTe016", query = "SELECT r FROM REPTE r WHERE r.te016 = :te016"),
    @NamedQuery(name = "REPTE.findByCustomer", query = "SELECT r FROM REPTE r WHERE r.customer = :customer"),
    @NamedQuery(name = "REPTE.findByProduct", query = "SELECT r FROM REPTE r WHERE r.product = :product"),
    @NamedQuery(name = "REPTE.findByRegion", query = "SELECT r FROM REPTE r WHERE r.region = :region"),
    @NamedQuery(name = "REPTE.findByDealer", query = "SELECT r FROM REPTE r WHERE r.dealer = :dealer"),
    @NamedQuery(name = "REPTE.findByTe017", query = "SELECT r FROM REPTE r WHERE r.te017 = :te017"),
    @NamedQuery(name = "REPTE.findByTe018", query = "SELECT r FROM REPTE r WHERE r.te018 = :te018"),
    @NamedQuery(name = "REPTE.findByTe019", query = "SELECT r FROM REPTE r WHERE r.te019 = :te019"),
    @NamedQuery(name = "REPTE.findByTe020", query = "SELECT r FROM REPTE r WHERE r.te020 = :te020"),
    @NamedQuery(name = "REPTE.findByTe021", query = "SELECT r FROM REPTE r WHERE r.te021 = :te021"),
    @NamedQuery(name = "REPTE.findByTe022", query = "SELECT r FROM REPTE r WHERE r.te022 = :te022"),
    @NamedQuery(name = "REPTE.findByTe023", query = "SELECT r FROM REPTE r WHERE r.te023 = :te023"),
    @NamedQuery(name = "REPTE.findByRepte01", query = "SELECT r FROM REPTE r WHERE r.repte01 = :repte01"),
    @NamedQuery(name = "REPTE.findByRepte02", query = "SELECT r FROM REPTE r WHERE r.repte02 = :repte02"),
    @NamedQuery(name = "REPTE.findByRepte03", query = "SELECT r FROM REPTE r WHERE r.repte03 = :repte03"),
    @NamedQuery(name = "REPTE.findByRepte04", query = "SELECT r FROM REPTE r WHERE r.repte04 = :repte04"),
    @NamedQuery(name = "REPTE.findByRepte05", query = "SELECT r FROM REPTE r WHERE r.repte05 = :repte05"),
    @NamedQuery(name = "REPTE.findByRepte06", query = "SELECT r FROM REPTE r WHERE r.repte06 = :repte06"),
    @NamedQuery(name = "REPTE.findByRepte07", query = "SELECT r FROM REPTE r WHERE r.repte07 = :repte07"),
    @NamedQuery(name = "REPTE.findByRepte08", query = "SELECT r FROM REPTE r WHERE r.repte08 = :repte08"),
    @NamedQuery(name = "REPTE.findByRepte09", query = "SELECT r FROM REPTE r WHERE r.repte09 = :repte09"),
    @NamedQuery(name = "REPTE.findByRepte10", query = "SELECT r FROM REPTE r WHERE r.repte10 = :repte10"),
    @NamedQuery(name = "REPTE.findByRepte11", query = "SELECT r FROM REPTE r WHERE r.repte11 = :repte11"),
    @NamedQuery(name = "REPTE.findByRepte12", query = "SELECT r FROM REPTE r WHERE r.repte12 = :repte12"),
    @NamedQuery(name = "REPTE.findByRepte13", query = "SELECT r FROM REPTE r WHERE r.repte13 = :repte13"),
    @NamedQuery(name = "REPTE.findByRepte14", query = "SELECT r FROM REPTE r WHERE r.repte14 = :repte14"),
    @NamedQuery(name = "REPTE.findByRepte15", query = "SELECT r FROM REPTE r WHERE r.repte15 = :repte15"),
    @NamedQuery(name = "REPTE.findByRepte16", query = "SELECT r FROM REPTE r WHERE r.repte16 = :repte16"),
    @NamedQuery(name = "REPTE.findByRepte17", query = "SELECT r FROM REPTE r WHERE r.repte17 = :repte17"),
    @NamedQuery(name = "REPTE.findByRepte18", query = "SELECT r FROM REPTE r WHERE r.repte18 = :repte18"),
    @NamedQuery(name = "REPTE.findByRepte19", query = "SELECT r FROM REPTE r WHERE r.repte19 = :repte19"),
    @NamedQuery(name = "REPTE.findByRepte20", query = "SELECT r FROM REPTE r WHERE r.repte20 = :repte20"),
    @NamedQuery(name = "REPTE.findByTe500", query = "SELECT r FROM REPTE r WHERE r.te500 = :te500"),
    @NamedQuery(name = "REPTE.findByTe501", query = "SELECT r FROM REPTE r WHERE r.te501 = :te501"),
    @NamedQuery(name = "REPTE.findByTe502", query = "SELECT r FROM REPTE r WHERE r.te502 = :te502"),
    @NamedQuery(name = "REPTE.findByTe503", query = "SELECT r FROM REPTE r WHERE r.te503 = :te503"),
    @NamedQuery(name = "REPTE.findByTe504", query = "SELECT r FROM REPTE r WHERE r.te504 = :te504"),
    @NamedQuery(name = "REPTE.findByTe505", query = "SELECT r FROM REPTE r WHERE r.te505 = :te505"),
    @NamedQuery(name = "REPTE.findByTe024", query = "SELECT r FROM REPTE r WHERE r.te024 = :te024")})
public class REPTE implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected REPTEPK rEPTEPK;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TE003")
    private String te003;
    @Size(max = 4000)
    @Column(name = "TE005")
    private String te005;
    @Size(max = 4000)
    @Column(name = "TE006")
    private String te006;
    @Size(max = 8)
    @Column(name = "TE007")
    private String te007;
    @Size(max = 10)
    @Column(name = "TE008")
    private String te008;
    @Size(max = 1000)
    @Column(name = "TE009")
    private String te009;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TE010")
    private BigDecimal te010;
    @Size(max = 4)
    @Column(name = "TE011")
    private String te011;
    @Column(name = "TE012")
    private BigDecimal te012;
    @Column(name = "TE013")
    private BigDecimal te013;
    @Size(max = 1)
    @Column(name = "TE014")
    private String te014;
    @Size(max = 30)
    @Column(name = "TE015")
    private String te015;
    @Size(max = 60)
    @Column(name = "TE016")
    private String te016;
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
    @Size(max = 4)
    @Column(name = "TE017")
    private String te017;
    @Size(max = 8)
    @Column(name = "TE018")
    private String te018;
    @Size(max = 4)
    @Column(name = "TE019")
    private String te019;
    @Size(max = 255)
    @Column(name = "TE020")
    private String te020;
    @Size(max = 255)
    @Column(name = "TE021")
    private String te021;
    @Size(max = 255)
    @Column(name = "TE022")
    private String te022;
    @Size(max = 255)
    @Column(name = "TE023")
    private String te023;
    @Size(max = 255)
    @Column(name = "REPTE01")
    private String repte01;
    @Size(max = 255)
    @Column(name = "REPTE02")
    private String repte02;
    @Size(max = 255)
    @Column(name = "REPTE03")
    private String repte03;
    @Size(max = 255)
    @Column(name = "REPTE04")
    private String repte04;
    @Size(max = 255)
    @Column(name = "REPTE05")
    private String repte05;
    @Size(max = 255)
    @Column(name = "REPTE06")
    private String repte06;
    @Size(max = 255)
    @Column(name = "REPTE07")
    private String repte07;
    @Size(max = 255)
    @Column(name = "REPTE08")
    private String repte08;
    @Size(max = 255)
    @Column(name = "REPTE09")
    private String repte09;
    @Size(max = 255)
    @Column(name = "REPTE10")
    private String repte10;
    @Size(max = 255)
    @Column(name = "REPTE11")
    private String repte11;
    @Size(max = 255)
    @Column(name = "REPTE12")
    private String repte12;
    @Size(max = 255)
    @Column(name = "REPTE13")
    private String repte13;
    @Size(max = 255)
    @Column(name = "REPTE14")
    private String repte14;
    @Size(max = 255)
    @Column(name = "REPTE15")
    private String repte15;
    @Size(max = 255)
    @Column(name = "REPTE16")
    private String repte16;
    @Size(max = 255)
    @Column(name = "REPTE17")
    private String repte17;
    @Size(max = 255)
    @Column(name = "REPTE18")
    private String repte18;
    @Size(max = 255)
    @Column(name = "REPTE19")
    private String repte19;
    @Size(max = 255)
    @Column(name = "REPTE20")
    private String repte20;
    @Column(name = "TE500")
    private BigDecimal te500;
    @Column(name = "TE501")
    private BigDecimal te501;
    @Size(max = 8)
    @Column(name = "TE502")
    private String te502;
    @Size(max = 8)
    @Column(name = "TE503")
    private String te503;
    @Size(max = 4)
    @Column(name = "TE504")
    private String te504;
    @Size(max = 4)
    @Column(name = "TE505")
    private String te505;
    @Size(max = 4)
    @Column(name = "TE024")
    private String te024;

    @Size(max = 255)
    @Column(name = "TE506")
    private String te506;
    @Size(max = 255)
    @Column(name = "TE507")
    private String te507;
    @Size(max = 255)
    @Column(name = "TE508")
    private String te508;
    @Size(max = 255)
    @Column(name = "TE509")
    private String te509;
    
   

    public REPTE() {
    }

    public REPTE(REPTEPK rEPTEPK) {
        this.rEPTEPK = rEPTEPK;
    }

    public REPTE(REPTEPK rEPTEPK, String te003) {
        this.rEPTEPK = rEPTEPK;
        this.te003 = te003;
    }

    public REPTE(String te001, String te002, String te004) {
        this.rEPTEPK = new REPTEPK(te001, te002, te004);
    }

    public REPTEPK getREPTEPK() {
        return rEPTEPK;
    }

    public void setREPTEPK(REPTEPK rEPTEPK) {
        this.rEPTEPK = rEPTEPK;
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

    public String getTe003() {
        return te003;
    }

    public void setTe003(String te003) {
        this.te003 = te003;
    }

    public String getTe005() {
        return te005;
    }

    public void setTe005(String te005) {
        this.te005 = te005;
    }

    public String getTe006() {
        return te006;
    }

    public void setTe006(String te006) {
        this.te006 = te006;
    }

    public String getTe007() {
        return te007;
    }

    public void setTe007(String te007) {
        this.te007 = te007;
    }

    public String getTe008() {
        return te008;
    }

    public void setTe008(String te008) {
        this.te008 = te008;
    }

    public String getTe009() {
        return te009;
    }

    public void setTe009(String te009) {
        this.te009 = te009;
    }

    public BigDecimal getTe010() {
        return te010;
    }

    public void setTe010(BigDecimal te010) {
        this.te010 = te010;
    }

    public String getTe011() {
        return te011;
    }

    public void setTe011(String te011) {
        this.te011 = te011;
    }

    public BigDecimal getTe012() {
        return te012;
    }

    public void setTe012(BigDecimal te012) {
        this.te012 = te012;
    }

    public BigDecimal getTe013() {
        return te013;
    }

    public void setTe013(BigDecimal te013) {
        this.te013 = te013;
    }

    public String getTe014() {
        return te014;
    }

    public void setTe014(String te014) {
        this.te014 = te014;
    }

    public String getTe015() {
        return te015;
    }

    public void setTe015(String te015) {
        this.te015 = te015;
    }

    public String getTe016() {
        return te016;
    }

    public void setTe016(String te016) {
        this.te016 = te016;
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

    public String getTe017() {
        return te017;
    }

    public void setTe017(String te017) {
        this.te017 = te017;
    }

    public String getTe018() {
        return te018;
    }

    public void setTe018(String te018) {
        this.te018 = te018;
    }

    public String getTe019() {
        return te019;
    }

    public void setTe019(String te019) {
        this.te019 = te019;
    }

    public String getTe020() {
        return te020;
    }

    public void setTe020(String te020) {
        this.te020 = te020;
    }

    public String getTe021() {
        return te021;
    }

    public void setTe021(String te021) {
        this.te021 = te021;
    }

    public String getTe022() {
        return te022;
    }

    public void setTe022(String te022) {
        this.te022 = te022;
    }

    public String getTe023() {
        return te023;
    }

    public void setTe023(String te023) {
        this.te023 = te023;
    }

    public String getRepte01() {
        return repte01;
    }

    public void setRepte01(String repte01) {
        this.repte01 = repte01;
    }

    public String getRepte02() {
        return repte02;
    }

    public void setRepte02(String repte02) {
        this.repte02 = repte02;
    }

    public String getRepte03() {
        return repte03;
    }

    public void setRepte03(String repte03) {
        this.repte03 = repte03;
    }

    public String getRepte04() {
        return repte04;
    }

    public void setRepte04(String repte04) {
        this.repte04 = repte04;
    }

    public String getRepte05() {
        return repte05;
    }

    public void setRepte05(String repte05) {
        this.repte05 = repte05;
    }

    public String getRepte06() {
        return repte06;
    }

    public void setRepte06(String repte06) {
        this.repte06 = repte06;
    }

    public String getRepte07() {
        return repte07;
    }

    public void setRepte07(String repte07) {
        this.repte07 = repte07;
    }

    public String getRepte08() {
        return repte08;
    }

    public void setRepte08(String repte08) {
        this.repte08 = repte08;
    }

    public String getRepte09() {
        return repte09;
    }

    public void setRepte09(String repte09) {
        this.repte09 = repte09;
    }

    public String getRepte10() {
        return repte10;
    }

    public void setRepte10(String repte10) {
        this.repte10 = repte10;
    }

    public String getRepte11() {
        return repte11;
    }

    public void setRepte11(String repte11) {
        this.repte11 = repte11;
    }

    public String getRepte12() {
        return repte12;
    }

    public void setRepte12(String repte12) {
        this.repte12 = repte12;
    }

    public String getRepte13() {
        return repte13;
    }

    public void setRepte13(String repte13) {
        this.repte13 = repte13;
    }

    public String getRepte14() {
        return repte14;
    }

    public void setRepte14(String repte14) {
        this.repte14 = repte14;
    }

    public String getRepte15() {
        return repte15;
    }

    public void setRepte15(String repte15) {
        this.repte15 = repte15;
    }

    public String getRepte16() {
        return repte16;
    }

    public void setRepte16(String repte16) {
        this.repte16 = repte16;
    }

    public String getRepte17() {
        return repte17;
    }

    public void setRepte17(String repte17) {
        this.repte17 = repte17;
    }

    public String getRepte18() {
        return repte18;
    }

    public void setRepte18(String repte18) {
        this.repte18 = repte18;
    }

    public String getRepte19() {
        return repte19;
    }

    public void setRepte19(String repte19) {
        this.repte19 = repte19;
    }

    public String getRepte20() {
        return repte20;
    }

    public void setRepte20(String repte20) {
        this.repte20 = repte20;
    }

    public BigDecimal getTe500() {
        return te500;
    }

    public void setTe500(BigDecimal te500) {
        this.te500 = te500;
    }

    public BigDecimal getTe501() {
        return te501;
    }

    public void setTe501(BigDecimal te501) {
        this.te501 = te501;
    }

    public String getTe502() {
        return te502;
    }

    public void setTe502(String te502) {
        this.te502 = te502;
    }

    public String getTe503() {
        return te503;
    }

    public void setTe503(String te503) {
        this.te503 = te503;
    }

    public String getTe504() {
        return te504;
    }

    public void setTe504(String te504) {
        this.te504 = te504;
    }

    public String getTe505() {
        return te505;
    }

    public void setTe505(String te505) {
        this.te505 = te505;
    }

    public String getTe024() {
        return te024;
    }

    public void setTe024(String te024) {
        this.te024 = te024;
    }

    public String getTe506() {
        return te506;
    }

    public void setTe506(String te506) {
        this.te506 = te506;
    }

    public String getTe507() {
        return te507;
    }

    public void setTe507(String te507) {
        this.te507 = te507;
    }

    public String getTe508() {
        return te508;
    }

    public void setTe508(String te508) {
        this.te508 = te508;
    }

    public String getTe509() {
        return te509;
    }

    public void setTe509(String te509) {
        this.te509 = te509;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rEPTEPK != null ? rEPTEPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof REPTE)) {
            return false;
        }
        REPTE other = (REPTE) object;
        if ((this.rEPTEPK == null && other.rEPTEPK != null) || (this.rEPTEPK != null && !this.rEPTEPK.equals(other.rEPTEPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "REPTE{" + "rEPTEPK=" + rEPTEPK + ", company=" + company + ", creator=" + creator + ", usrGroup=" + usrGroup + ", createDate=" + createDate + ", modifier=" + modifier + ", modiDate=" + modiDate + ", flag=" + flag + ", te003=" + te003 + ", te005=" + te005 + ", te006=" + te006 + ", te007=" + te007 + ", te008=" + te008 + ", te009=" + te009 + ", te010=" + te010 + ", te011=" + te011 + ", te012=" + te012 + ", te013=" + te013 + ", te014=" + te014 + ", te015=" + te015 + ", te016=" + te016 + ", customer=" + customer + ", product=" + product + ", region=" + region + ", dealer=" + dealer + ", te017=" + te017 + ", te018=" + te018 + ", te019=" + te019 + ", te020=" + te020 + ", te021=" + te021 + ", te022=" + te022 + ", te023=" + te023 + ", repte01=" + repte01 + ", repte02=" + repte02 + ", repte03=" + repte03 + ", repte04=" + repte04 + ", repte05=" + repte05 + ", repte06=" + repte06 + ", repte07=" + repte07 + ", repte08=" + repte08 + ", repte09=" + repte09 + ", repte10=" + repte10 + ", repte11=" + repte11 + ", repte12=" + repte12 + ", repte13=" + repte13 + ", repte14=" + repte14 + ", repte15=" + repte15 + ", repte16=" + repte16 + ", repte17=" + repte17 + ", repte18=" + repte18 + ", repte19=" + repte19 + ", repte20=" + repte20 + ", te500=" + te500 + ", te501=" + te501 + ", te502=" + te502 + ", te503=" + te503 + ", te504=" + te504 + ", te505=" + te505 + ", te024=" + te024 + ", te506=" + te506 + ", te507=" + te507 + ", te508=" + te508 + ", te509=" + te509 + '}';
    }

}
