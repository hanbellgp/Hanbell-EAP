/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "systemgrantmodule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemGrantModule.getRowCount", query = "SELECT COUNT(s) FROM SystemGrantModule s"),
    @NamedQuery(name = "SystemGrantModule.getRowCountByUserId", query = "SELECT COUNT(s) FROM SystemGrantModule s WHERE s.systemUser.id = :userid "),
    @NamedQuery(name = "SystemGrantModule.findAll", query = "SELECT s FROM SystemGrantModule s"),
    @NamedQuery(name = "SystemGrantModule.findById", query = "SELECT s FROM SystemGrantModule s WHERE s.id = :id"),
    @NamedQuery(name = "SystemGrantModule.findByKind", query = "SELECT s FROM SystemGrantModule s WHERE s.kind = :kind"),
    @NamedQuery(name = "SystemGrantModule.findByUserId", query = "SELECT s FROM SystemGrantModule s WHERE s.systemUser.id = :userid ORDER BY s.systemModule.sortid "),
    @NamedQuery(name = "SystemGrantModule.findByRoleId", query = "SELECT s FROM SystemGrantModule s WHERE s.systemRole.id = :roleid ORDER BY s.systemModule.sortid "),
    @NamedQuery(name = "SystemGrantModule.findByModuleId", query = "SELECT s FROM SystemGrantModule s WHERE s.systemModule.id = :moduleid"),
    @NamedQuery(name = "SystemGrantModule.findBySystemNameAndUserId", query = "SELECT s FROM SystemGrantModule s WHERE s.systemModule.sysname=:sysname AND s.systemUser.id = :userid ORDER BY s.systemModule.sortid "),
    @NamedQuery(name = "SystemGrantModule.findBySystemNameAndRoleId", query = "SELECT s FROM SystemGrantModule s WHERE s.systemModule.sysname=:sysname AND s.systemRole.id = :roleid ORDER BY s.systemModule.sortid "),
    @NamedQuery(name = "SystemGrantModule.findByStatus", query = "SELECT s FROM SystemGrantModule s WHERE s.status = :status")})
public class SystemGrantModule extends SuperEntity {

    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private SystemUser systemUser;
    @JoinColumn(name = "roleid", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private SystemRole systemRole;
    @JoinColumn(name = "moduleid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemModule systemModule;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "kind")
    private String kind;

    public SystemGrantModule() {
        kind = "U";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
        if (!(object instanceof SystemGrantModule)) {
            return false;
        }
        SystemGrantModule other = (SystemGrantModule) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        if ((!this.kind.equals(other.kind)) || !Objects.equals(this.systemRole, other.systemRole) || !Objects.equals(this.systemUser, other.systemUser)) {
            return false;
        }
        if ((this.kind.equals(other.kind)) && ((Objects.equals(this.systemRole, other.systemRole)) || (Objects.equals(this.systemUser, other.systemUser))) && (Objects.equals(this.systemModule, other.systemModule))) {
            return true;
        }
        if ((this.kind.equals(other.kind)) && ((Objects.equals(this.systemRole, other.systemRole)) || (Objects.equals(this.systemUser, other.systemUser))) && (!Objects.equals(this.systemModule, other.systemModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SystemGrantModule[ id=" + id + " ]";
    }

    /**
     * @return the systemUser
     */
    public SystemUser getSystemUser() {
        return systemUser;
    }

    /**
     * @param systemUser the systemUser to set
     */
    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    /**
     * @return the systemRole
     */
    public SystemRole getSystemRole() {
        return systemRole;
    }

    /**
     * @param systemRole the systemRole to set
     */
    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }

    /**
     * @return the systemModule
     */
    public SystemModule getSystemModule() {
        return systemModule;
    }

    /**
     * @param systemModule the systemModule to set
     */
    public void setSystemModule(SystemModule systemModule) {
        this.systemModule = systemModule;
    }

}
