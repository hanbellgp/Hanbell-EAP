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
@Table(name = "CRMGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRMGA.findAll", query = "SELECT c FROM CRMGA c"),
    @NamedQuery(name = "CRMGA.findByCompany", query = "SELECT c FROM CRMGA c WHERE c.company = :company"),
    @NamedQuery(name = "CRMGA.findByCreator", query = "SELECT c FROM CRMGA c WHERE c.creator = :creator"),
    @NamedQuery(name = "CRMGA.findByUsrGroup", query = "SELECT c FROM CRMGA c WHERE c.usrGroup = :usrGroup"),
    @NamedQuery(name = "CRMGA.findByCreateDate", query = "SELECT c FROM CRMGA c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CRMGA.findByModifier", query = "SELECT c FROM CRMGA c WHERE c.modifier = :modifier"),
    @NamedQuery(name = "CRMGA.findByModiDate", query = "SELECT c FROM CRMGA c WHERE c.modiDate = :modiDate"),
    @NamedQuery(name = "CRMGA.findByFlag", query = "SELECT c FROM CRMGA c WHERE c.flag = :flag"),
    @NamedQuery(name = "CRMGA.findByGa001", query = "SELECT c FROM CRMGA c WHERE c.cRMGAPK.ga001 = :ga001"),
    @NamedQuery(name = "CRMGA.findByGa002", query = "SELECT c FROM CRMGA c WHERE c.cRMGAPK.ga002 = :ga002"),
    @NamedQuery(name = "CRMGA.findByGa003", query = "SELECT c FROM CRMGA c WHERE c.ga003 = :ga003"),
    @NamedQuery(name = "CRMGA.findByGa004", query = "SELECT c FROM CRMGA c WHERE c.ga004 = :ga004"),
    @NamedQuery(name = "CRMGA.findByGa005", query = "SELECT c FROM CRMGA c WHERE c.ga005 = :ga005"),
    @NamedQuery(name = "CRMGA.findByCustomer", query = "SELECT c FROM CRMGA c WHERE c.customer = :customer"),
    @NamedQuery(name = "CRMGA.findByProduct", query = "SELECT c FROM CRMGA c WHERE c.product = :product"),
    @NamedQuery(name = "CRMGA.findByRegion", query = "SELECT c FROM CRMGA c WHERE c.region = :region"),
    @NamedQuery(name = "CRMGA.findByDealer", query = "SELECT c FROM CRMGA c WHERE c.dealer = :dealer"),
    @NamedQuery(name = "CRMGA.findByGa006", query = "SELECT c FROM CRMGA c WHERE c.ga006 = :ga006"),
    @NamedQuery(name = "CRMGA.findByGa007", query = "SELECT c FROM CRMGA c WHERE c.ga007 = :ga007"),
    @NamedQuery(name = "CRMGA.findByCrmga01", query = "SELECT c FROM CRMGA c WHERE c.crmga01 = :crmga01"),
    @NamedQuery(name = "CRMGA.findByCrmga02", query = "SELECT c FROM CRMGA c WHERE c.crmga02 = :crmga02"),
    @NamedQuery(name = "CRMGA.findByCrmga03", query = "SELECT c FROM CRMGA c WHERE c.crmga03 = :crmga03"),
    @NamedQuery(name = "CRMGA.findByCrmga04", query = "SELECT c FROM CRMGA c WHERE c.crmga04 = :crmga04"),
    @NamedQuery(name = "CRMGA.findByCrmga05", query = "SELECT c FROM CRMGA c WHERE c.crmga05 = :crmga05"),
    @NamedQuery(name = "CRMGA.findByCrmga06", query = "SELECT c FROM CRMGA c WHERE c.crmga06 = :crmga06"),
    @NamedQuery(name = "CRMGA.findByCrmga07", query = "SELECT c FROM CRMGA c WHERE c.crmga07 = :crmga07"),
    @NamedQuery(name = "CRMGA.findByCrmga08", query = "SELECT c FROM CRMGA c WHERE c.crmga08 = :crmga08"),
    @NamedQuery(name = "CRMGA.findByCrmga09", query = "SELECT c FROM CRMGA c WHERE c.crmga09 = :crmga09"),
    @NamedQuery(name = "CRMGA.findByCrmga10", query = "SELECT c FROM CRMGA c WHERE c.crmga10 = :crmga10"),
    @NamedQuery(name = "CRMGA.findByCrmga11", query = "SELECT c FROM CRMGA c WHERE c.crmga11 = :crmga11"),
    @NamedQuery(name = "CRMGA.findByCrmga12", query = "SELECT c FROM CRMGA c WHERE c.crmga12 = :crmga12"),
    @NamedQuery(name = "CRMGA.findByCrmga13", query = "SELECT c FROM CRMGA c WHERE c.crmga13 = :crmga13"),
    @NamedQuery(name = "CRMGA.findByCrmga14", query = "SELECT c FROM CRMGA c WHERE c.crmga14 = :crmga14"),
    @NamedQuery(name = "CRMGA.findByCrmga15", query = "SELECT c FROM CRMGA c WHERE c.crmga15 = :crmga15"),
    @NamedQuery(name = "CRMGA.findByCrmga16", query = "SELECT c FROM CRMGA c WHERE c.crmga16 = :crmga16"),
    @NamedQuery(name = "CRMGA.findByCrmga17", query = "SELECT c FROM CRMGA c WHERE c.crmga17 = :crmga17"),
    @NamedQuery(name = "CRMGA.findByCrmga18", query = "SELECT c FROM CRMGA c WHERE c.crmga18 = :crmga18"),
    @NamedQuery(name = "CRMGA.findByCrmga19", query = "SELECT c FROM CRMGA c WHERE c.crmga19 = :crmga19"),
    @NamedQuery(name = "CRMGA.findByCrmga20", query = "SELECT c FROM CRMGA c WHERE c.crmga20 = :crmga20"),
    @NamedQuery(name = "CRMGA.findByGa008", query = "SELECT c FROM CRMGA c WHERE c.ga008 = :ga008"),
    @NamedQuery(name = "CRMGA.findByGa009", query = "SELECT c FROM CRMGA c WHERE c.ga009 = :ga009"),
    @NamedQuery(name = "CRMGA.findByGa010", query = "SELECT c FROM CRMGA c WHERE c.ga010 = :ga010"),
    @NamedQuery(name = "CRMGA.findByGa011", query = "SELECT c FROM CRMGA c WHERE c.ga011 = :ga011")})
public class CRMGA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CRMGAPK cRMGAPK;
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
    @Size(max = 40)
    @Column(name = "GA003")
    private String ga003;
    @Size(max = 255)
    @Column(name = "GA004")
    private String ga004;
    @Size(max = 1)
    @Column(name = "GA005")
    private String ga005;
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
    @Size(max = 1)
    @Column(name = "GA006")
    private String ga006;
    @Size(max = 10)
    @Column(name = "GA007")
    private String ga007;
    @Size(max = 255)
    @Column(name = "CRMGA01")
    private String crmga01;
    @Size(max = 255)
    @Column(name = "CRMGA02")
    private String crmga02;
    @Size(max = 255)
    @Column(name = "CRMGA03")
    private String crmga03;
    @Size(max = 255)
    @Column(name = "CRMGA04")
    private String crmga04;
    @Size(max = 255)
    @Column(name = "CRMGA05")
    private String crmga05;
    @Size(max = 255)
    @Column(name = "CRMGA06")
    private String crmga06;
    @Size(max = 255)
    @Column(name = "CRMGA07")
    private String crmga07;
    @Size(max = 255)
    @Column(name = "CRMGA08")
    private String crmga08;
    @Size(max = 255)
    @Column(name = "CRMGA09")
    private String crmga09;
    @Size(max = 255)
    @Column(name = "CRMGA10")
    private String crmga10;
    @Size(max = 255)
    @Column(name = "CRMGA11")
    private String crmga11;
    @Size(max = 255)
    @Column(name = "CRMGA12")
    private String crmga12;
    @Size(max = 255)
    @Column(name = "CRMGA13")
    private String crmga13;
    @Size(max = 255)
    @Column(name = "CRMGA14")
    private String crmga14;
    @Size(max = 255)
    @Column(name = "CRMGA15")
    private String crmga15;
    @Size(max = 255)
    @Column(name = "CRMGA16")
    private String crmga16;
    @Size(max = 255)
    @Column(name = "CRMGA17")
    private String crmga17;
    @Size(max = 255)
    @Column(name = "CRMGA18")
    private String crmga18;
    @Size(max = 255)
    @Column(name = "CRMGA19")
    private String crmga19;
    @Size(max = 255)
    @Column(name = "CRMGA20")
    private String crmga20;
    @Size(max = 1)
    @Column(name = "GA008")
    private String ga008;
    @Size(max = 1)
    @Column(name = "GA009")
    private String ga009;
    @Size(max = 1)
    @Column(name = "GA010")
    private String ga010;
    @Column(name = "GA011")
    private Short ga011;

    public CRMGA() {
    }

    public CRMGA(CRMGAPK cRMGAPK) {
        this.cRMGAPK = cRMGAPK;
    }

    public CRMGA(String ga001, String ga002) {
        this.cRMGAPK = new CRMGAPK(ga001, ga002);
    }

    public CRMGAPK getCRMGAPK() {
        return cRMGAPK;
    }

    public void setCRMGAPK(CRMGAPK cRMGAPK) {
        this.cRMGAPK = cRMGAPK;
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

    public String getGa003() {
        return ga003;
    }

    public void setGa003(String ga003) {
        this.ga003 = ga003;
    }

    public String getGa004() {
        return ga004;
    }

    public void setGa004(String ga004) {
        this.ga004 = ga004;
    }

    public String getGa005() {
        return ga005;
    }

    public void setGa005(String ga005) {
        this.ga005 = ga005;
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

    public String getGa006() {
        return ga006;
    }

    public void setGa006(String ga006) {
        this.ga006 = ga006;
    }

    public String getGa007() {
        return ga007;
    }

    public void setGa007(String ga007) {
        this.ga007 = ga007;
    }

    public String getCrmga01() {
        return crmga01;
    }

    public void setCrmga01(String crmga01) {
        this.crmga01 = crmga01;
    }

    public String getCrmga02() {
        return crmga02;
    }

    public void setCrmga02(String crmga02) {
        this.crmga02 = crmga02;
    }

    public String getCrmga03() {
        return crmga03;
    }

    public void setCrmga03(String crmga03) {
        this.crmga03 = crmga03;
    }

    public String getCrmga04() {
        return crmga04;
    }

    public void setCrmga04(String crmga04) {
        this.crmga04 = crmga04;
    }

    public String getCrmga05() {
        return crmga05;
    }

    public void setCrmga05(String crmga05) {
        this.crmga05 = crmga05;
    }

    public String getCrmga06() {
        return crmga06;
    }

    public void setCrmga06(String crmga06) {
        this.crmga06 = crmga06;
    }

    public String getCrmga07() {
        return crmga07;
    }

    public void setCrmga07(String crmga07) {
        this.crmga07 = crmga07;
    }

    public String getCrmga08() {
        return crmga08;
    }

    public void setCrmga08(String crmga08) {
        this.crmga08 = crmga08;
    }

    public String getCrmga09() {
        return crmga09;
    }

    public void setCrmga09(String crmga09) {
        this.crmga09 = crmga09;
    }

    public String getCrmga10() {
        return crmga10;
    }

    public void setCrmga10(String crmga10) {
        this.crmga10 = crmga10;
    }

    public String getCrmga11() {
        return crmga11;
    }

    public void setCrmga11(String crmga11) {
        this.crmga11 = crmga11;
    }

    public String getCrmga12() {
        return crmga12;
    }

    public void setCrmga12(String crmga12) {
        this.crmga12 = crmga12;
    }

    public String getCrmga13() {
        return crmga13;
    }

    public void setCrmga13(String crmga13) {
        this.crmga13 = crmga13;
    }

    public String getCrmga14() {
        return crmga14;
    }

    public void setCrmga14(String crmga14) {
        this.crmga14 = crmga14;
    }

    public String getCrmga15() {
        return crmga15;
    }

    public void setCrmga15(String crmga15) {
        this.crmga15 = crmga15;
    }

    public String getCrmga16() {
        return crmga16;
    }

    public void setCrmga16(String crmga16) {
        this.crmga16 = crmga16;
    }

    public String getCrmga17() {
        return crmga17;
    }

    public void setCrmga17(String crmga17) {
        this.crmga17 = crmga17;
    }

    public String getCrmga18() {
        return crmga18;
    }

    public void setCrmga18(String crmga18) {
        this.crmga18 = crmga18;
    }

    public String getCrmga19() {
        return crmga19;
    }

    public void setCrmga19(String crmga19) {
        this.crmga19 = crmga19;
    }

    public String getCrmga20() {
        return crmga20;
    }

    public void setCrmga20(String crmga20) {
        this.crmga20 = crmga20;
    }

    public String getGa008() {
        return ga008;
    }

    public void setGa008(String ga008) {
        this.ga008 = ga008;
    }

    public String getGa009() {
        return ga009;
    }

    public void setGa009(String ga009) {
        this.ga009 = ga009;
    }

    public String getGa010() {
        return ga010;
    }

    public void setGa010(String ga010) {
        this.ga010 = ga010;
    }

    public Short getGa011() {
        return ga011;
    }

    public void setGa011(Short ga011) {
        this.ga011 = ga011;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRMGAPK != null ? cRMGAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRMGA)) {
            return false;
        }
        CRMGA other = (CRMGA) object;
        if ((this.cRMGAPK == null && other.cRMGAPK != null) || (this.cRMGAPK != null && !this.cRMGAPK.equals(other.cRMGAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.CRMGA[ cRMGAPK=" + cRMGAPK + " ]";
    }
    
}
