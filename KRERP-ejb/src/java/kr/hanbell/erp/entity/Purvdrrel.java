/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZFF
 */
@Entity
@Table(name = "purvdrrel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purvdrrel.findAll", query = "SELECT p FROM Purvdrrel p"),
    @NamedQuery(name = "Purvdrrel.findByVdrno", query = "SELECT p FROM Purvdrrel p WHERE p.purvdrrelPK.vdrno = :vdrno")})
public class Purvdrrel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurvdrrelPK purvdrrelPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 40)
    @Column(name = "duty")
    private String duty;
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    @Size(max = 5)
    @Column(name = "ext")
    private String ext;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "zonecode")
    private String zonecode;
    @Size(max = 20)
    @Column(name = "handtel")
    private String handtel;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "vdrno", referencedColumnName = "vdrno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Purvdr purvdr;

    public Purvdrrel() {
    }

    public Purvdrrel(PurvdrrelPK purvdrrelPK) {
        this.purvdrrelPK = purvdrrelPK;
    }

    public Purvdrrel(PurvdrrelPK purvdrrelPK, String contactman) {
        this.purvdrrelPK = purvdrrelPK;
        this.contactman = contactman;
    }

    public Purvdrrel(String vdrno, short trseq) {
        this.purvdrrelPK = new PurvdrrelPK(vdrno, trseq);
    }

    public PurvdrrelPK getPurvdrrelPK() {
        return purvdrrelPK;
    }

    public void setPurvdrrelPK(PurvdrrelPK purvdrrelPK) {
        this.purvdrrelPK = purvdrrelPK;
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
        hash += (purvdrrelPK != null ? purvdrrelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purvdrrel)) {
            return false;
        }
        Purvdrrel other = (Purvdrrel) object;
        if ((this.purvdrrelPK == null && other.purvdrrelPK != null) || (this.purvdrrelPK != null && !this.purvdrrelPK.equals(other.purvdrrelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.Purvdrrel[ purvdrrelPK=" + purvdrrelPK + " ]";
    }

    public Purvdr getPurvdr() {
        return purvdr;
    }

    public void setPurvdr(Purvdr purvdr) {
        this.purvdr = purvdr;
    }

}
