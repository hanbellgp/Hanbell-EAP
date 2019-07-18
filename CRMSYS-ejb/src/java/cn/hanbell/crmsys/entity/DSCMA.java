/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crmsys.entity;

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
 * @author C0160
 */
@Entity
@Table(name = "DSCMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DSCMA.findAll", query = "SELECT d FROM DSCMA d"),
    @NamedQuery(name = "DSCMA.findByCompany", query = "SELECT d FROM DSCMA d WHERE d.company = :company"),
    @NamedQuery(name = "DSCMA.findByFlag", query = "SELECT d FROM DSCMA d WHERE d.flag = :flag"),
    @NamedQuery(name = "DSCMA.findByMa001", query = "SELECT d FROM DSCMA d WHERE d.ma001 = :ma001"),
    @NamedQuery(name = "DSCMA.findByMa002", query = "SELECT d FROM DSCMA d WHERE d.ma002 = :ma002"),
    @NamedQuery(name = "DSCMA.findByMa003", query = "SELECT d FROM DSCMA d WHERE d.ma003 = :ma003"),
    @NamedQuery(name = "DSCMA.findByMa004", query = "SELECT d FROM DSCMA d WHERE d.ma004 = :ma004")})
public class DSCMA implements Serializable {

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
    @Column(name = "MA001")
    private String ma001;
    @Size(max = 30)
    @Column(name = "MA002")
    private String ma002;
    @Size(max = 36)
    @Column(name = "MA003")
    private String ma003;
    @Size(max = 255)
    @Column(name = "MA004")
    private String ma004;

    public DSCMA() {
    }

    public DSCMA(String ma001) {
        this.ma001 = ma001;
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

    public String getMa001() {
        return ma001;
    }

    public void setMa001(String ma001) {
        this.ma001 = ma001;
    }

    public String getMa002() {
        return ma002;
    }

    public void setMa002(String ma002) {
        this.ma002 = ma002;
    }

    public String getMa003() {
        return ma003;
    }

    public void setMa003(String ma003) {
        this.ma003 = ma003;
    }

    public String getMa004() {
        return ma004;
    }

    public void setMa004(String ma004) {
        this.ma004 = ma004;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ma001 != null ? ma001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DSCMA)) {
            return false;
        }
        DSCMA other = (DSCMA) object;
        return this.ma001.equals(other.ma001);
    }

    @Override
    public String toString() {
        return "cn.hanbell.crmsys.entity.DSCMA[ ma001=" + ma001 + " ]";
    }

}
