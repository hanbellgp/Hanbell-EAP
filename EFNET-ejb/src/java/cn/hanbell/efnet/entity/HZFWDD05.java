/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.entity;

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
 * @author C0160
 */
@Entity
@Table(name = "hzfwd_d05")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZFWDD05.findAll", query = "SELECT h FROM HZFWDD05 h"),
    @NamedQuery(name = "HZFWDD05.findByPId", query = "SELECT h FROM HZFWDD05 h WHERE h.hZFWDD05PK.hzfwdD05002 = :pid"),
    @NamedQuery(name = "HZFWDD05.findByPK", query = "SELECT h FROM HZFWDD05 h WHERE h.hZFWDD05PK.hzfwdD05002 = :id AND h.hZFWDD05PK.hzfwdD05003 = :seq")})
public class HZFWDD05 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HZFWDD05PK hZFWDD05PK;
    @Size(max = 50)
    @Column(name = "hzfwd_d05004")
    private String hzfwdD05004;
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
    @Size(max = 20)
    @Column(name = "hzfwd_d05005")
    private String hzfwdD05005;
    @Size(max = 20)
    @Column(name = "hzfwd_d05006")
    private String hzfwdD05006;
    @Size(max = 20)
    @Column(name = "hzfwd_d05007")
    private String hzfwdD05007;
    @Size(max = 20)
    @Column(name = "hzfwd_d05008")
    private String hzfwdD05008;
    @Size(max = 20)
    @Column(name = "hzfwd_d05009")
    private String hzfwdD05009;
    @Size(max = 20)
    @Column(name = "hzfwd_d05010")
    private String hzfwdD05010;

    public HZFWDD05() {
    }

    public HZFWDD05(HZFWDD05PK hZFWDD05PK) {
        this.hZFWDD05PK = hZFWDD05PK;
    }

    public HZFWDD05(String hzfwdD05001, String hzfwdD05002, String hzfwdD05003) {
        this.hZFWDD05PK = new HZFWDD05PK(hzfwdD05001, hzfwdD05002, hzfwdD05003);
    }

    public HZFWDD05PK getHZFWDD05PK() {
        return hZFWDD05PK;
    }

    public void setHZFWDD05PK(HZFWDD05PK hZFWDD05PK) {
        this.hZFWDD05PK = hZFWDD05PK;
    }

    public String getHzfwdD05004() {
        return hzfwdD05004;
    }

    public void setHzfwdD05004(String hzfwdD05004) {
        this.hzfwdD05004 = hzfwdD05004;
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

    public String getHzfwdD05005() {
        return hzfwdD05005;
    }

    public void setHzfwdD05005(String hzfwdD05005) {
        this.hzfwdD05005 = hzfwdD05005;
    }

    public String getHzfwdD05006() {
        return hzfwdD05006;
    }

    public void setHzfwdD05006(String hzfwdD05006) {
        this.hzfwdD05006 = hzfwdD05006;
    }

    public String getHzfwdD05007() {
        return hzfwdD05007;
    }

    public void setHzfwdD05007(String hzfwdD05007) {
        this.hzfwdD05007 = hzfwdD05007;
    }

    public String getHzfwdD05008() {
        return hzfwdD05008;
    }

    public void setHzfwdD05008(String hzfwdD05008) {
        this.hzfwdD05008 = hzfwdD05008;
    }

    public String getHzfwdD05009() {
        return hzfwdD05009;
    }

    public void setHzfwdD05009(String hzfwdD05009) {
        this.hzfwdD05009 = hzfwdD05009;
    }

    public String getHzfwdD05010() {
        return hzfwdD05010;
    }

    public void setHzfwdD05010(String hzfwdD05010) {
        this.hzfwdD05010 = hzfwdD05010;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hZFWDD05PK != null ? hZFWDD05PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZFWDD05)) {
            return false;
        }
        HZFWDD05 other = (HZFWDD05) object;
        if ((this.hZFWDD05PK == null && other.hZFWDD05PK != null) || (this.hZFWDD05PK != null && !this.hZFWDD05PK.equals(other.hZFWDD05PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.efnet.entity.HZFWDD05[ hZFWDD05PK=" + hZFWDD05PK + " ]";
    }
    
}
