/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZFF
 */
@Entity
@Table(name = "secuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secuser.findAll", query = "SELECT s FROM Secuser s"),
    @NamedQuery(name = "Secuser.findByUserno", query = "SELECT s FROM Secuser s WHERE s.userno = :userno"),
    @NamedQuery(name = "Secuser.findByUsername", query = "SELECT s FROM Secuser s WHERE s.username = :username"),
    @NamedQuery(name = "Secuser.findByUtype", query = "SELECT s FROM Secuser s WHERE s.utype = :utype"),
    @NamedQuery(name = "Secuser.findByUclass", query = "SELECT s FROM Secuser s WHERE s.uclass = :uclass"),
    @NamedQuery(name = "Secuser.findByEnabled", query = "SELECT s FROM Secuser s WHERE s.enabled = :enabled"),
    @NamedQuery(name = "Secuser.findByPwd", query = "SELECT s FROM Secuser s WHERE s.pwd = :pwd"),
    @NamedQuery(name = "Secuser.findByEmail", query = "SELECT s FROM Secuser s WHERE s.email = :email"),
    @NamedQuery(name = "Secuser.findByPfacno", query = "SELECT s FROM Secuser s WHERE s.pfacno = :pfacno"),
    @NamedQuery(name = "Secuser.findByPdepno", query = "SELECT s FROM Secuser s WHERE s.pdepno = :pdepno"),
    @NamedQuery(name = "Secuser.findByPprono", query = "SELECT s FROM Secuser s WHERE s.pprono = :pprono"),
    @NamedQuery(name = "Secuser.findByDuedate", query = "SELECT s FROM Secuser s WHERE s.duedate = :duedate"),
    @NamedQuery(name = "Secuser.findByGtype", query = "SELECT s FROM Secuser s WHERE s.gtype = :gtype"),
    @NamedQuery(name = "Secuser.findByStatuspass", query = "SELECT s FROM Secuser s WHERE s.statuspass = :statuspass"),
    @NamedQuery(name = "Secuser.findBySigntext", query = "SELECT s FROM Secuser s WHERE s.signtext = :signtext"),
    @NamedQuery(name = "Secuser.findByPwdrule1", query = "SELECT s FROM Secuser s WHERE s.pwdrule1 = :pwdrule1"),
    @NamedQuery(name = "Secuser.findByPwdrule2", query = "SELECT s FROM Secuser s WHERE s.pwdrule2 = :pwdrule2")})
public class Secuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Size(max = 96)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "utype")
    private Character utype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uclass")
    private short uclass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private Character enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pwd")
    private String pwd;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    @Size(max = 3)
    @Column(name = "pfacno")
    private String pfacno;
    @Size(max = 8)
    @Column(name = "pdepno")
    private String pdepno;
    @Size(max = 3)
    @Column(name = "pprono")
    private String pprono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "gtype")
    private String gtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "statuspass")
    private String statuspass;
    @Size(max = 255)
    @Column(name = "signtext")
    private String signtext;
    @Size(max = 1)
    @Column(name = "pwdrule1")
    private String pwdrule1;
    @Size(max = 2)
    @Column(name = "pwdrule2")
    private String pwdrule2;

    public Secuser() {
    }

    public Secuser(String userno) {
        this.userno = userno;
    }

    public Secuser(String userno, Character utype, short uclass, Character enabled, String pwd, Date duedate, String gtype, String statuspass) {
        this.userno = userno;
        this.utype = utype;
        this.uclass = uclass;
        this.enabled = enabled;
        this.pwd = pwd;
        this.duedate = duedate;
        this.gtype = gtype;
        this.statuspass = statuspass;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Character getUtype() {
        return utype;
    }

    public void setUtype(Character utype) {
        this.utype = utype;
    }

    public short getUclass() {
        return uclass;
    }

    public void setUclass(short uclass) {
        this.uclass = uclass;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPfacno() {
        return pfacno;
    }

    public void setPfacno(String pfacno) {
        this.pfacno = pfacno;
    }

    public String getPdepno() {
        return pdepno;
    }

    public void setPdepno(String pdepno) {
        this.pdepno = pdepno;
    }

    public String getPprono() {
        return pprono;
    }

    public void setPprono(String pprono) {
        this.pprono = pprono;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getStatuspass() {
        return statuspass;
    }

    public void setStatuspass(String statuspass) {
        this.statuspass = statuspass;
    }

    public String getSigntext() {
        return signtext;
    }

    public void setSigntext(String signtext) {
        this.signtext = signtext;
    }

    public String getPwdrule1() {
        return pwdrule1;
    }

    public void setPwdrule1(String pwdrule1) {
        this.pwdrule1 = pwdrule1;
    }

    public String getPwdrule2() {
        return pwdrule2;
    }

    public void setPwdrule2(String pwdrule2) {
        this.pwdrule2 = pwdrule2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userno != null ? userno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secuser)) {
            return false;
        }
        Secuser other = (Secuser) object;
        if ((this.userno == null && other.userno != null) || (this.userno != null && !this.userno.equals(other.userno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.entity.Secuser[ userno=" + userno + " ]";
    }
    
}
