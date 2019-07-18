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
@Table(name = "systemname")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemName.findAll", query = "SELECT s FROM SystemName s ORDER BY s.sortid"),
    @NamedQuery(name = "SystemName.findById", query = "SELECT s FROM SystemName s WHERE s.id = :id"),
    @NamedQuery(name = "SystemName.findByName", query = "SELECT s FROM SystemName s WHERE s.name = :name"),
    @NamedQuery(name = "SystemName.findByAppidAndToken", query = "SELECT s FROM SystemName s WHERE s.appid = :appid AND s.token =:token"),
    @NamedQuery(name = "SystemName.findByStatus", query = "SELECT s FROM SystemName s WHERE s.status = :status ORDER BY s.sortid")})
public class SystemName extends SuperEntity {

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
    @Size(max = 20)
    @Column(name = "appid")
    private String appid;
    @Size(max = 32)
    @Column(name = "token")
    private String token;
    @Size(max = 32)
    @Column(name = "secret")
    private String secret;

    public SystemName() {
    }

    public SystemName(String name, int sortid, String status) {
        this.name = name;
        this.sortid = sortid;
        this.status = status;
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

    /**
     * @return the appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid the appid to set
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
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
        if (!(object instanceof SystemName)) {
            return false;
        }
        SystemName other = (SystemName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SystemName[ id=" + id + " ]";
    }

}
