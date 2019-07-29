/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "mis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mis.findAll", query = "SELECT m FROM Mis m"),
    @NamedQuery(name = "Mis.findByCompany", query = "SELECT m FROM Mis m WHERE m.company = :company"),
    @NamedQuery(name = "Mis.findByTaxrate", query = "SELECT m FROM Mis m WHERE m.taxrate = :taxrate"),
    @NamedQuery(name = "Mis.findByTaxrateCom", query = "SELECT m FROM Mis m WHERE m.taxrateCom = :taxrateCom"),
    @NamedQuery(name = "Mis.findByCoinno", query = "SELECT m FROM Mis m WHERE m.coinno = :coinno"),
    @NamedQuery(name = "Mis.findByExpkind", query = "SELECT m FROM Mis m WHERE m.expkind = :expkind"),
    @NamedQuery(name = "Mis.findByTcoinno", query = "SELECT m FROM Mis m WHERE m.tcoinno = :tcoinno"),
    @NamedQuery(name = "Mis.findByTel", query = "SELECT m FROM Mis m WHERE m.tel = :tel"),
    @NamedQuery(name = "Mis.findByFax", query = "SELECT m FROM Mis m WHERE m.fax = :fax"),
    @NamedQuery(name = "Mis.findByAddress", query = "SELECT m FROM Mis m WHERE m.address = :address"),
    @NamedQuery(name = "Mis.findByCity", query = "SELECT m FROM Mis m WHERE m.city = :city"),
    @NamedQuery(name = "Mis.findByCountry", query = "SELECT m FROM Mis m WHERE m.country = :country"),
    @NamedQuery(name = "Mis.findByZipcode", query = "SELECT m FROM Mis m WHERE m.zipcode = :zipcode"),
    @NamedQuery(name = "Mis.findByCompanyE", query = "SELECT m FROM Mis m WHERE m.companyE = :companyE"),
    @NamedQuery(name = "Mis.findByAddressE", query = "SELECT m FROM Mis m WHERE m.addressE = :addressE"),
    @NamedQuery(name = "Mis.findByCoinsumnum", query = "SELECT m FROM Mis m WHERE m.coinsumnum = :coinsumnum"),
    @NamedQuery(name = "Mis.findByCoinsumptn", query = "SELECT m FROM Mis m WHERE m.coinsumptn = :coinsumptn"),
    @NamedQuery(name = "Mis.findByCountryno", query = "SELECT m FROM Mis m WHERE m.countryno = :countryno"),
    @NamedQuery(name = "Mis.findByEmail", query = "SELECT m FROM Mis m WHERE m.email = :email"),
    @NamedQuery(name = "Mis.findBySalestel", query = "SELECT m FROM Mis m WHERE m.salestel = :salestel"),
    @NamedQuery(name = "Mis.findBySalesfax", query = "SELECT m FROM Mis m WHERE m.salesfax = :salesfax")})
public class Mis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "company")
    private String company;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Column(name = "taxrate_com")
    private BigDecimal taxrateCom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coinno")
    private String coinno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "expkind")
    private String expkind;
    @Size(max = 4)
    @Column(name = "tcoinno")
    private String tcoinno;
    @Size(max = 16)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 16)
    @Column(name = "fax")
    private String fax;
    @Size(max = 64)
    @Column(name = "address")
    private String address;
    @Size(max = 30)
    @Column(name = "city")
    private String city;
    @Size(max = 30)
    @Column(name = "country")
    private String country;
    @Size(max = 6)
    @Column(name = "zipcode")
    private String zipcode;
    @Size(max = 60)
    @Column(name = "company_e")
    private String companyE;
    @Size(max = 128)
    @Column(name = "address_e")
    private String addressE;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coinsumnum")
    private short coinsumnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coinsumptn")
    private short coinsumptn;
    @Size(max = 1)
    @Column(name = "countryno")
    private String countryno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "salestel")
    private String salestel;
    @Size(max = 20)
    @Column(name = "salesfax")
    private String salesfax;

    public Mis() {
    }

    public Mis(String company) {
        this.company = company;
    }

    public Mis(String company, BigDecimal taxrate, String coinno, String expkind, short coinsumnum, short coinsumptn) {
        this.company = company;
        this.taxrate = taxrate;
        this.coinno = coinno;
        this.expkind = expkind;
        this.coinsumnum = coinsumnum;
        this.coinsumptn = coinsumptn;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getTaxrateCom() {
        return taxrateCom;
    }

    public void setTaxrateCom(BigDecimal taxrateCom) {
        this.taxrateCom = taxrateCom;
    }

    public String getCoinno() {
        return coinno;
    }

    public void setCoinno(String coinno) {
        this.coinno = coinno;
    }

    public String getExpkind() {
        return expkind;
    }

    public void setExpkind(String expkind) {
        this.expkind = expkind;
    }

    public String getTcoinno() {
        return tcoinno;
    }

    public void setTcoinno(String tcoinno) {
        this.tcoinno = tcoinno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCompanyE() {
        return companyE;
    }

    public void setCompanyE(String companyE) {
        this.companyE = companyE;
    }

    public String getAddressE() {
        return addressE;
    }

    public void setAddressE(String addressE) {
        this.addressE = addressE;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public short getCoinsumnum() {
        return coinsumnum;
    }

    public void setCoinsumnum(short coinsumnum) {
        this.coinsumnum = coinsumnum;
    }

    public short getCoinsumptn() {
        return coinsumptn;
    }

    public void setCoinsumptn(short coinsumptn) {
        this.coinsumptn = coinsumptn;
    }

    public String getCountryno() {
        return countryno;
    }

    public void setCountryno(String countryno) {
        this.countryno = countryno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalestel() {
        return salestel;
    }

    public void setSalestel(String salestel) {
        this.salestel = salestel;
    }

    public String getSalesfax() {
        return salesfax;
    }

    public void setSalesfax(String salesfax) {
        this.salesfax = salesfax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (company != null ? company.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mis)) {
            return false;
        }
        Mis other = (Mis) object;
        if ((this.company == null && other.company != null) || (this.company != null && !this.company.equals(other.company))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Mis[ company=" + company + " ]";
    }

}
