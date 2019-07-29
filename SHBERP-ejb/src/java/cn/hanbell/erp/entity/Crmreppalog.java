/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "crmreppalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crmreppalog.findAll", query = "SELECT c FROM Crmreppalog c"),
    @NamedQuery(name = "Crmreppalog.findByPa001", query = "SELECT c FROM Crmreppalog c WHERE c.pa001 = :pa001"),
    @NamedQuery(name = "Crmreppalog.findByPa002", query = "SELECT c FROM Crmreppalog c WHERE c.pa002 = :pa002"),
    @NamedQuery(name = "Crmreppalog.findByIndate", query = "SELECT c FROM Crmreppalog c WHERE c.indate = :indate"),
    @NamedQuery(name = "Crmreppalog.findByCreator", query = "SELECT c FROM Crmreppalog c WHERE c.creator = :creator"),
    @NamedQuery(name = "Crmreppalog.findByMancode", query = "SELECT c FROM Crmreppalog c WHERE c.mancode = :mancode"),
    @NamedQuery(name = "Crmreppalog.findByPzcnt", query = "SELECT c FROM Crmreppalog c WHERE c.pzcnt = :pzcnt"),
    @NamedQuery(name = "Crmreppalog.findByErrdescription", query = "SELECT c FROM Crmreppalog c WHERE c.errdescription = :errdescription"),
    @NamedQuery(name = "Crmreppalog.findByQuono", query = "SELECT c FROM Crmreppalog c WHERE c.quono = :quono"),
    @NamedQuery(name = "Crmreppalog.findById", query = "SELECT c FROM Crmreppalog c WHERE c.id = :id")})
public class Crmreppalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pa001")
    private String pa001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pa002")
    private String pa002;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 30)
    @Column(name = "creator")
    private String creator;
    @Size(max = 30)
    @Column(name = "mancode")
    private String mancode;
    @Column(name = "pzcnt")
    private Integer pzcnt;
    @Size(max = 255)
    @Column(name = "errdescription")
    private String errdescription;
    @Size(max = 30)
    @Column(name = "quono")
    private String quono;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    public Crmreppalog() {
    }

    public Crmreppalog(Long id) {
        this.id = id;
    }

    public Crmreppalog(Long id, String pa001, String pa002, Date indate) {
        this.id = id;
        this.pa001 = pa001;
        this.pa002 = pa002;
        this.indate = indate;
    }

    public String getPa001() {
        return pa001;
    }

    public void setPa001(String pa001) {
        this.pa001 = pa001;
    }

    public String getPa002() {
        return pa002;
    }

    public void setPa002(String pa002) {
        this.pa002 = pa002;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public Integer getPzcnt() {
        return pzcnt;
    }

    public void setPzcnt(Integer pzcnt) {
        this.pzcnt = pzcnt;
    }

    public String getErrdescription() {
        return errdescription;
    }

    public void setErrdescription(String errdescription) {
        this.errdescription = errdescription;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Crmreppalog)) {
            return false;
        }
        Crmreppalog other = (Crmreppalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Crmreppalog[ id=" + id + " ]";
    }

}
