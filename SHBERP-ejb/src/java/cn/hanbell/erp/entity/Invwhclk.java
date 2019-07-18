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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "invwhclk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invwhclk.findAll", query = "SELECT i FROM Invwhclk i"),
    @NamedQuery(name = "Invwhclk.findByFacno", query = "SELECT i FROM Invwhclk i WHERE i.invwhclkPK.facno = :facno"),
    @NamedQuery(name = "Invwhclk.findByProno", query = "SELECT i FROM Invwhclk i WHERE i.invwhclkPK.prono = :prono"),
    @NamedQuery(name = "Invwhclk.findByWareh", query = "SELECT i FROM Invwhclk i WHERE i.invwhclkPK.wareh = :wareh"),
    @NamedQuery(name = "Invwhclk.findByWclerk", query = "SELECT i FROM Invwhclk i WHERE i.invwhclkPK.wclerk = :wclerk"),
    @NamedQuery(name = "Invwhclk.findByMainyn", query = "SELECT i FROM Invwhclk i WHERE i.mainyn = :mainyn"),
    @NamedQuery(name = "Invwhclk.findByPK", query = "SELECT i FROM Invwhclk i WHERE i.invwhclkPK.facno = :facno AND i.invwhclkPK.prono = :prono AND i.invwhclkPK.wareh = :wareh AND i.invwhclkPK.wclerk = :wclerk")})
public class Invwhclk implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvwhclkPK invwhclkPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mainyn")
    private Character mainyn;
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

    public Invwhclk() {
    }

    public Invwhclk(InvwhclkPK invwhclkPK) {
        this.invwhclkPK = invwhclkPK;
    }

    public Invwhclk(String facno, String prono, String wareh, String wclerk) {
        this.invwhclkPK = new InvwhclkPK(facno, prono, wareh, wclerk);
    }

    public InvwhclkPK getInvwhclkPK() {
        return invwhclkPK;
    }

    public void setInvwhclkPK(InvwhclkPK invwhclkPK) {
        this.invwhclkPK = invwhclkPK;
    }

    public Character getMainyn() {
        return mainyn;
    }

    public void setMainyn(Character mainyn) {
        this.mainyn = mainyn;
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
        hash += (invwhclkPK != null ? invwhclkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invwhclk)) {
            return false;
        }
        Invwhclk other = (Invwhclk) object;
        if ((this.invwhclkPK == null && other.invwhclkPK != null) || (this.invwhclkPK != null && !this.invwhclkPK.equals(other.invwhclkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invwhclk[ invwhclkPK=" + invwhclkPK + " ]";
    }

}
