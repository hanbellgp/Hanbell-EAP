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
 * @author C0160
 */
@Entity
@Table(name = "invwh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invwh.findAll", query = "SELECT i FROM Invwh i"),
    @NamedQuery(name = "Invwh.findByFacno", query = "SELECT i FROM Invwh i WHERE i.facno = :facno"),
    @NamedQuery(name = "Invwh.findByProno", query = "SELECT i FROM Invwh i WHERE i.prono = :prono"),
    @NamedQuery(name = "Invwh.findByWareh", query = "SELECT i FROM Invwh i WHERE i.wareh = :wareh"),
    @NamedQuery(name = "Invwh.findByWhdsc", query = "SELECT i FROM Invwh i WHERE i.whdsc = :whdsc"),
    @NamedQuery(name = "Invwh.findByMrpco", query = "SELECT i FROM Invwh i WHERE i.mrpco = :mrpco"),
    @NamedQuery(name = "Invwh.findByCostyn", query = "SELECT i FROM Invwh i WHERE i.costyn = :costyn"),
    @NamedQuery(name = "Invwh.findByWclerk", query = "SELECT i FROM Invwh i WHERE i.wclerk = :wclerk"),
    @NamedQuery(name = "Invwh.findByUserno", query = "SELECT i FROM Invwh i WHERE i.userno = :userno"),
    @NamedQuery(name = "Invwh.findByIndate", query = "SELECT i FROM Invwh i WHERE i.indate = :indate")})
public class Invwh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "prono")
    private String prono;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "whdsc")
    private String whdsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mrpco")
    private Character mrpco;
    @Column(name = "costyn")
    private Character costyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "wclerk")
    private String wclerk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;

    public Invwh() {
    }

    public Invwh(String wareh) {
        this.wareh = wareh;
    }

    public Invwh(String wareh, String facno, String prono, String whdsc, Character mrpco, String wclerk, String userno, Date indate) {
        this.wareh = wareh;
        this.facno = facno;
        this.prono = prono;
        this.whdsc = whdsc;
        this.mrpco = mrpco;
        this.wclerk = wclerk;
        this.userno = userno;
        this.indate = indate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public Character getMrpco() {
        return mrpco;
    }

    public void setMrpco(Character mrpco) {
        this.mrpco = mrpco;
    }

    public Character getCostyn() {
        return costyn;
    }

    public void setCostyn(Character costyn) {
        this.costyn = costyn;
    }

    public String getWclerk() {
        return wclerk;
    }

    public void setWclerk(String wclerk) {
        this.wclerk = wclerk;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wareh != null ? wareh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invwh)) {
            return false;
        }
        Invwh other = (Invwh) object;
        if ((this.wareh == null && other.wareh != null) || (this.wareh != null && !this.wareh.equals(other.wareh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invwh[ wareh=" + wareh + " ]";
    }
    
}
