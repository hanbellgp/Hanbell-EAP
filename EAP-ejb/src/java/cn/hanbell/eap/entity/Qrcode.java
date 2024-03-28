/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
import com.lightshell.comm.SuperEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author C2082
 */
@Entity
@Table(name = "qrcode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qrcode.findAll", query = "SELECT q FROM Qrcode q"),
    @NamedQuery(name = "Qrcode.findById", query = "SELECT q FROM Qrcode q WHERE q.id = :id"),
    @NamedQuery(name = "Qrcode.findByCompany", query = "SELECT q FROM Qrcode q WHERE q.company = :company"),
    @NamedQuery(name = "Qrcode.findByFormid", query = "SELECT q FROM Qrcode q WHERE q.formid = :formid"),
    @NamedQuery(name = "Qrcode.findByFormdate", query = "SELECT q FROM Qrcode q WHERE q.formdate = :formdate"),
    @NamedQuery(name = "Qrcode.findByDeptno", query = "SELECT q FROM Qrcode q WHERE q.deptno = :deptno"),
    @NamedQuery(name = "Qrcode.findByDeptname", query = "SELECT q FROM Qrcode q WHERE q.deptname = :deptname"),
    @NamedQuery(name = "Qrcode.findByUserno", query = "SELECT q FROM Qrcode q WHERE q.userno = :userno"),
    @NamedQuery(name = "Qrcode.findByUsername", query = "SELECT q FROM Qrcode q WHERE q.username = :username"),
    @NamedQuery(name = "Qrcode.findByType", query = "SELECT q FROM Qrcode q WHERE q.type = :type"),
    @NamedQuery(name = "Qrcode.findByTypename", query = "SELECT q FROM Qrcode q WHERE q.typename = :typename"),
    @NamedQuery(name = "Qrcode.findByStatus", query = "SELECT q FROM Qrcode q WHERE q.status = :status"),
    @NamedQuery(name = "Qrcode.findByCreator", query = "SELECT q FROM Qrcode q WHERE q.creator = :creator"),
    @NamedQuery(name = "Qrcode.findByCredate", query = "SELECT q FROM Qrcode q WHERE q.credate = :credate"),
    @NamedQuery(name = "Qrcode.findByOptuser", query = "SELECT q FROM Qrcode q WHERE q.optuser = :optuser"),
    @NamedQuery(name = "Qrcode.findByOptdate", query = "SELECT q FROM Qrcode q WHERE q.optdate = :optdate"),
    @NamedQuery(name = "Qrcode.findByCfmuser", query = "SELECT q FROM Qrcode q WHERE q.cfmuser = :cfmuser"),
    @NamedQuery(name = "Qrcode.findByCfmdate", query = "SELECT q FROM Qrcode q WHERE q.cfmdate = :cfmdate")})
public class Qrcode  extends FormEntity  {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "company")
    private String company;
    @Size(max = 20)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 45)
    @Column(name = "deptname")
    private String deptname;
    @Size(max = 20)
    @Column(name = "userno")
    private String userno;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "typename")
    private String typename;

    public Qrcode() {
    }

    public Qrcode(Integer id) {
        this.id = id;
    }

    public Qrcode(Integer id, String company, String formid, Date formdate, String status) {
        this.id = id;
        this.company = company;
        this.formid = formid;
        this.formdate = formdate;
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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
        if (!(object instanceof Qrcode)) {
            return false;
        }
        Qrcode other = (Qrcode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Qrcode[ id=" + id + " ]";
    }
    
}
