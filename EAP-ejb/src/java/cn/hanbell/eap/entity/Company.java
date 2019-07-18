/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.getRowCount", query = "SELECT COUNT(c) FROM Company c")
    ,
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    ,
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    ,
    @NamedQuery(name = "Company.findByCompany", query = "SELECT c FROM Company c WHERE c.company = :company")
    ,
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name")
    ,
    @NamedQuery(name = "Company.findByFullname", query = "SELECT c FROM Company c WHERE c.fullname = :fullname")
    ,
    @NamedQuery(name = "Company.findByHasEAM", query = "SELECT c FROM Company c WHERE c.hasEAM = 1")
    ,
    @NamedQuery(name = "Company.findByHasKPI", query = "SELECT c FROM Company c WHERE c.hasKPI = 1")
    ,
    @NamedQuery(name = "Company.findByStatus", query = "SELECT c FROM Company c WHERE c.status = :status")})
public class Company extends SuperEntity {

    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Size(max = 20)
    @Column(name = "boss")
    private String boss;
    @Size(max = 20)
    @Column(name = "contacter")
    private String contacter;
    @Size(max = 4)
    @Column(name = "assetcode")
    private String assetcode;
    @Column(name = "hasEAP")
    private Boolean hasEAP;
    @Column(name = "hasEAM")
    private Boolean hasEAM;
    @Column(name = "hasKPI")
    private Boolean hasKPI;
    @Column(name = "hasBSC")
    private Boolean hasBSC;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public Company() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    public Boolean getHasEAP() {
        return hasEAP;
    }

    public void setHasEAP(Boolean hasEAP) {
        this.hasEAP = hasEAP;
    }

    public Boolean getHasEAM() {
        return hasEAM;
    }

    public void setHasEAM(Boolean hasEAM) {
        this.hasEAM = hasEAM;
    }

    public Boolean getHasKPI() {
        return hasKPI;
    }

    public void setHasKPI(Boolean hasKPI) {
        this.hasKPI = hasKPI;
    }

    public Boolean getHasBSC() {
        return hasBSC;
    }

    public void setHasBSC(Boolean hasBSC) {
        this.hasBSC = hasBSC;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if (this.id != null && other.id != null) {
            return this.id == other.id;
        }
        return this.company.equals(other.company);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Company[ id=" + id + " ]";
    }

}
