/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "secgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secgroup.findAll", query = "SELECT s FROM Secgroup s"),
    @NamedQuery(name = "Secgroup.findByGroupno", query = "SELECT s FROM Secgroup s WHERE s.secgroupPK.groupno = :groupno"),
    @NamedQuery(name = "Secgroup.findByGtype", query = "SELECT s FROM Secgroup s WHERE s.secgroupPK.gtype = :gtype"),
    @NamedQuery(name = "Secgroup.findByGroupname", query = "SELECT s FROM Secgroup s WHERE s.groupname = :groupname")})
public class Secgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecgroupPK secgroupPK;
    @Size(max = 48)
    @Column(name = "groupname")
    private String groupname;
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "secgroup", fetch = FetchType.LAZY)
    private List<Secguser> secguserList;

    public Secgroup() {
    }

    public Secgroup(SecgroupPK secgroupPK) {
        this.secgroupPK = secgroupPK;
    }

    public Secgroup(String groupno, String gtype) {
        this.secgroupPK = new SecgroupPK(groupno, gtype);
    }

    public SecgroupPK getSecgroupPK() {
        return secgroupPK;
    }

    public void setSecgroupPK(SecgroupPK secgroupPK) {
        this.secgroupPK = secgroupPK;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @XmlTransient
    public List<Secguser> getSecguserList() {
        return secguserList;
    }

    public void setSecguserList(List<Secguser> secguserList) {
        this.secguserList = secguserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secgroupPK != null ? secgroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secgroup)) {
            return false;
        }
        Secgroup other = (Secgroup) object;
        if ((this.secgroupPK == null && other.secgroupPK != null) || (this.secgroupPK != null && !this.secgroupPK.equals(other.secgroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secgroup[ secgroupPK=" + secgroupPK + " ]";
    }

}
