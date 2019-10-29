/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
 * @author C0160
 */
@Entity
@Table(name = "cdrcusrel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrcusrel.findAll", query = "SELECT c FROM Cdrcusrel c"),
    @NamedQuery(name = "Cdrcusrel.findByCusno", query = "SELECT c FROM Cdrcusrel c WHERE c.cdrcusrelPK.cusno = :cusno")})
public class Cdrcusrel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrcusrelPK cdrcusrelPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 20)
    @Column(name = "duty")
    private String duty;
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Size(max = 5)
    @Column(name = "ext")
    private String ext;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "zonecode")
    private String zonecode;
    @Size(max = 20)
    @Column(name = "handtel")
    private String handtel;
    @Size(max = 200)
    @Column(name = "address")
    private String address;

    public Cdrcusrel() {
    }

    public Cdrcusrel(CdrcusrelPK cdrcusrelPK) {
        this.cdrcusrelPK = cdrcusrelPK;
    }

    public Cdrcusrel(CdrcusrelPK cdrcusrelPK, String contactman) {
        this.cdrcusrelPK = cdrcusrelPK;
        this.contactman = contactman;
    }

    public Cdrcusrel(String cusno, short trseq) {
        this.cdrcusrelPK = new CdrcusrelPK(cusno, trseq);
    }

    public CdrcusrelPK getCdrcusrelPK() {
        return cdrcusrelPK;
    }

    public void setCdrcusrelPK(CdrcusrelPK cdrcusrelPK) {
        this.cdrcusrelPK = cdrcusrelPK;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    public String getHandtel() {
        return handtel;
    }

    public void setHandtel(String handtel) {
        this.handtel = handtel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrcusrelPK != null ? cdrcusrelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrcusrel)) {
            return false;
        }
        Cdrcusrel other = (Cdrcusrel) object;
        if ((this.cdrcusrelPK == null && other.cdrcusrelPK != null) || (this.cdrcusrelPK != null && !this.cdrcusrelPK.equals(other.cdrcusrelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrcusrel[ cdrcusrelPK=" + cdrcusrelPK + " ]";
    }

}
