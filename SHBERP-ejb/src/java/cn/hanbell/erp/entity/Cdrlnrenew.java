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
@Table(name = "cdrlnrenew")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrlnrenew.findAll", query = "SELECT c FROM Cdrlnrenew c"),
    @NamedQuery(name = "Cdrlnrenew.findById", query = "SELECT c FROM Cdrlnrenew c WHERE c.id = :id"),
    @NamedQuery(name = "Cdrlnrenew.findByFacno", query = "SELECT c FROM Cdrlnrenew c WHERE c.facno = :facno"),
    @NamedQuery(name = "Cdrlnrenew.findByTrno", query = "SELECT c FROM Cdrlnrenew c WHERE c.trno = :trno"),
    @NamedQuery(name = "Cdrlnrenew.findByTrseq", query = "SELECT c FROM Cdrlnrenew c WHERE c.trseq = :trseq"),
    @NamedQuery(name = "Cdrlnrenew.findBySheetno", query = "SELECT c FROM Cdrlnrenew c WHERE c.sheetno = :sheetno"),
    @NamedQuery(name = "Cdrlnrenew.findByBkdate", query = "SELECT c FROM Cdrlnrenew c WHERE c.bkdate = :bkdate"),
    @NamedQuery(name = "Cdrlnrenew.findByCreatedate", query = "SELECT c FROM Cdrlnrenew c WHERE c.createdate = :createdate"),
    @NamedQuery(name = "Cdrlnrenew.findByCreator", query = "SELECT c FROM Cdrlnrenew c WHERE c.creator = :creator")})
public class Cdrlnrenew implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "trno")
    private String trno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sheetno")
    private String sheetno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bkdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bkdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "creator")
    private String creator;

    public Cdrlnrenew() {
    }

    public Cdrlnrenew(Integer id) {
        this.id = id;
    }

    public Cdrlnrenew(Integer id, String facno, String trno, short trseq, String sheetno, Date bkdate, Date createdate, String creator) {
        this.id = id;
        this.facno = facno;
        this.trno = trno;
        this.trseq = trseq;
        this.sheetno = sheetno;
        this.bkdate = bkdate;
        this.createdate = createdate;
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getTrno() {
        return trno;
    }

    public void setTrno(String trno) {
        this.trno = trno;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    public String getSheetno() {
        return sheetno;
    }

    public void setSheetno(String sheetno) {
        this.sheetno = sheetno;
    }

    public Date getBkdate() {
        return bkdate;
    }

    public void setBkdate(Date bkdate) {
        this.bkdate = bkdate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        if (!(object instanceof Cdrlnrenew)) {
            return false;
        }
        Cdrlnrenew other = (Cdrlnrenew) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrlnrenew[ id=" + id + " ]";
    }

}
