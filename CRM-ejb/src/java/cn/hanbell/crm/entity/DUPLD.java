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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "DUPLD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DUPLD.findAll", query = "SELECT d FROM DUPLD d"),
    @NamedQuery(name = "DUPLD.findByCompany", query = "SELECT d FROM DUPLD d WHERE d.company = :company"),
    @NamedQuery(name = "DUPLD.findByCreator", query = "SELECT d FROM DUPLD d WHERE d.creator = :creator"),
    @NamedQuery(name = "DUPLD.findByUsrGroup", query = "SELECT d FROM DUPLD d WHERE d.usrGroup = :usrGroup"),
    @NamedQuery(name = "DUPLD.findByCreateDate", query = "SELECT d FROM DUPLD d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DUPLD.findByModifier", query = "SELECT d FROM DUPLD d WHERE d.modifier = :modifier"),
    @NamedQuery(name = "DUPLD.findByModiDate", query = "SELECT d FROM DUPLD d WHERE d.modiDate = :modiDate"),
    @NamedQuery(name = "DUPLD.findByFlag", query = "SELECT d FROM DUPLD d WHERE d.flag = :flag"),
    @NamedQuery(name = "DUPLD.findByLd001", query = "SELECT d FROM DUPLD d WHERE d.ld001 = :ld001"),
    @NamedQuery(name = "DUPLD.findByLd002", query = "SELECT d FROM DUPLD d WHERE d.ld002 = :ld002"),
    @NamedQuery(name = "DUPLD.findByLd003", query = "SELECT d FROM DUPLD d WHERE d.ld003 = :ld003"),
    @NamedQuery(name = "DUPLD.findByLd004", query = "SELECT d FROM DUPLD d WHERE d.ld004 = :ld004"),
    @NamedQuery(name = "DUPLD.findByLd005", query = "SELECT d FROM DUPLD d WHERE d.ld005 = :ld005"),
    @NamedQuery(name = "DUPLD.findByLd006", query = "SELECT d FROM DUPLD d WHERE d.ld006 = :ld006"),
    @NamedQuery(name = "DUPLD.findByDs007", query = "SELECT d FROM DUPLD d WHERE d.ds007 = :ds007"),
    @NamedQuery(name = "DUPLD.findByDs008", query = "SELECT d FROM DUPLD d WHERE d.ds008 = :ds008")})
public class DUPLD implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LD001")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal ld001;
    @Size(max = 4)
    @Column(name = "LD002")
    private String ld002;
    @Size(max = 11)
    @Column(name = "LD003")
    private String ld003;
    @Size(max = 10)
    @Column(name = "LD004")
    private String ld004;
    @Size(max = 8)
    @Column(name = "LD005")
    private String ld005;
    @Size(max = 200)
    @Column(name = "LD006")
    private String ld006;
    @Size(max = 500)
    @Column(name = "DS007")
    private String ds007;
    @Size(max = 500)
    @Column(name = "DS008")
    private String ds008;

    public DUPLD() {
    }

    public DUPLD(BigDecimal ld001) {
        this.ld001 = ld001;
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

    public BigDecimal getLd001() {
        return ld001;
    }

    public void setLd001(BigDecimal ld001) {
        this.ld001 = ld001;
    }

    public String getLd002() {
        return ld002;
    }

    public void setLd002(String ld002) {
        this.ld002 = ld002;
    }

    public String getLd003() {
        return ld003;
    }

    public void setLd003(String ld003) {
        this.ld003 = ld003;
    }

    public String getLd004() {
        return ld004;
    }

    public void setLd004(String ld004) {
        this.ld004 = ld004;
    }

    public String getLd005() {
        return ld005;
    }

    public void setLd005(String ld005) {
        this.ld005 = ld005;
    }

    public String getLd006() {
        return ld006;
    }

    public void setLd006(String ld006) {
        this.ld006 = ld006;
    }

    public String getDs007() {
        return ds007;
    }

    public void setDs007(String ds007) {
        this.ds007 = ds007;
    }

    public String getDs008() {
        return ds008;
    }

    public void setDs008(String ds008) {
        this.ds008 = ds008;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ld001 != null ? ld001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DUPLD)) {
            return false;
        }
        DUPLD other = (DUPLD) object;
        if ((this.ld001 == null && other.ld001 != null) || (this.ld001 != null && !this.ld001.equals(other.ld001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.DUPLD[ ld001=" + ld001 + " ]";
    }
    
}
