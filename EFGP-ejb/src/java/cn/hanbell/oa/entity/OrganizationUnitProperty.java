/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "OrganizationUnitProperty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizationUnitProperty.findAll", query = "SELECT o FROM OrganizationUnitProperty o"),
    @NamedQuery(name = "OrganizationUnitProperty.findByOid", query = "SELECT o FROM OrganizationUnitProperty o WHERE o.oid = :oid"),
    @NamedQuery(name = "OrganizationUnitProperty.findByObjectVersion", query = "SELECT o FROM OrganizationUnitProperty o WHERE o.objectVersion = :objectVersion"),
    @NamedQuery(name = "OrganizationUnitProperty.findByOrganizationUnitPropertyName", query = "SELECT o FROM OrganizationUnitProperty o WHERE o.organizationUnitPropertyName = :organizationUnitPropertyName"),
    @NamedQuery(name = "OrganizationUnitProperty.findByOrganizationOID", query = "SELECT o FROM OrganizationUnitProperty o WHERE o.organizationOID = :organizationOID")})
public class OrganizationUnitProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "organizationUnitPropertyName")
    private String organizationUnitPropertyName;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "organizationOID")
    private String organizationOID;

    public OrganizationUnitProperty() {
    }

    public OrganizationUnitProperty(String oid) {
        this.oid = oid;
    }

    public OrganizationUnitProperty(String oid, int objectVersion, String organizationUnitPropertyName, String organizationOID) {
        this.oid = oid;
        this.objectVersion = objectVersion;
        this.organizationUnitPropertyName = organizationUnitPropertyName;
        this.organizationOID = organizationOID;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getOrganizationUnitPropertyName() {
        return organizationUnitPropertyName;
    }

    public void setOrganizationUnitPropertyName(String organizationUnitPropertyName) {
        this.organizationUnitPropertyName = organizationUnitPropertyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizationOID() {
        return organizationOID;
    }

    public void setOrganizationOID(String organizationOID) {
        this.organizationOID = organizationOID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrganizationUnitProperty)) {
            return false;
        }
        OrganizationUnitProperty other = (OrganizationUnitProperty) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hanbell.oa.entity.OrganizationUnitProperty[ oid=" + oid + " ]";
    }
    
}
