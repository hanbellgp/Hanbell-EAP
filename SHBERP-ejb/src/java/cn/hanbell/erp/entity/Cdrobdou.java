/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "cdrobdou")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrobdou.findAll", query = "SELECT c FROM Cdrobdou c"),
    @NamedQuery(name = "Cdrobdou.findByCdrobtype", query = "SELECT c FROM Cdrobdou c WHERE c.cdrobtype = :cdrobtype"),
    @NamedQuery(name = "Cdrobdou.findByTrtypedsc", query = "SELECT c FROM Cdrobdou c WHERE c.trtypedsc = :trtypedsc"),
    @NamedQuery(name = "Cdrobdou.findByTrtype", query = "SELECT c FROM Cdrobdou c WHERE c.trtype = :trtype"),
    @NamedQuery(name = "Cdrobdou.findByZautoyn", query = "SELECT c FROM Cdrobdou c WHERE c.zautoyn = :zautoyn"),
    @NamedQuery(name = "Cdrobdou.findByZautochar", query = "SELECT c FROM Cdrobdou c WHERE c.zautochar = :zautochar"),
    @NamedQuery(name = "Cdrobdou.findByZnofmt", query = "SELECT c FROM Cdrobdou c WHERE c.znofmt = :znofmt")})
public class Cdrobdou implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cdrobtype")
    private String cdrobtype;
    @Size(max = 20)
    @Column(name = "trtypedsc")
    private String trtypedsc;
    @Size(max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Column(name = "zautoyn")
    private Character zautoyn;
    @Column(name = "zautochar")
    private Character zautochar;
    @Size(max = 6)
    @Column(name = "znofmt")
    private String znofmt;

    public Cdrobdou() {
    }

    public Cdrobdou(String cdrobtype) {
        this.cdrobtype = cdrobtype;
    }

    public String getCdrobtype() {
        return cdrobtype;
    }

    public void setCdrobtype(String cdrobtype) {
        this.cdrobtype = cdrobtype;
    }

    public String getTrtypedsc() {
        return trtypedsc;
    }

    public void setTrtypedsc(String trtypedsc) {
        this.trtypedsc = trtypedsc;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public Character getZautoyn() {
        return zautoyn;
    }

    public void setZautoyn(Character zautoyn) {
        this.zautoyn = zautoyn;
    }

    public Character getZautochar() {
        return zautochar;
    }

    public void setZautochar(Character zautochar) {
        this.zautochar = zautochar;
    }

    public String getZnofmt() {
        return znofmt;
    }

    public void setZnofmt(String znofmt) {
        this.znofmt = znofmt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrobtype != null ? cdrobtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrobdou)) {
            return false;
        }
        Cdrobdou other = (Cdrobdou) object;
        if ((this.cdrobtype == null && other.cdrobtype != null) || (this.cdrobtype != null && !this.cdrobtype.equals(other.cdrobtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrobdou[ cdrobtype=" + cdrobtype + " ]";
    }
    
}
