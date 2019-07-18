/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "systemmodule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemModule.getRowCount", query = "SELECT COUNT(s) FROM SystemModule s"),
    @NamedQuery(name = "SystemModule.findAll", query = "SELECT s FROM SystemModule s ORDER BY s.sortid"),
    @NamedQuery(name = "SystemModule.findById", query = "SELECT s FROM SystemModule s WHERE s.id = :id"),
    @NamedQuery(name = "SystemModule.findByName", query = "SELECT s FROM SystemModule s WHERE s.name = :name"),
    @NamedQuery(name = "SystemModule.findBySysname", query = "SELECT s FROM SystemModule s WHERE s.sysname = :sysname ORDER BY s.sortid"),
    @NamedQuery(name = "SystemModule.findByStatus", query = "SELECT s FROM SystemModule s WHERE s.status = :status")})
public class SystemModule extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sortid")
    private int sortid;
    @Size(max = 50)
    @Column(name = "descript")
    private String descript;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sysname")
    private String sysname;

    public SystemModule() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
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
        if (!(object instanceof SystemModule)) {
            return false;
        }
        SystemModule other = (SystemModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SystemModule[ id=" + id + " ]";
    }

}
