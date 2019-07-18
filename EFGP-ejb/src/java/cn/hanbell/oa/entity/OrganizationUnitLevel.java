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
@Table(name = "OrganizationUnitLevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizationUnitLevel.findAll", query = "SELECT o FROM OrganizationUnitLevel o"),
    @NamedQuery(name = "OrganizationUnitLevel.findByOid", query = "SELECT o FROM OrganizationUnitLevel o WHERE o.oid = :oid"),
    @NamedQuery(name = "OrganizationUnitLevel.findByObjectVersion", query = "SELECT o FROM OrganizationUnitLevel o WHERE o.objectVersion = :objectVersion"),
    @NamedQuery(name = "OrganizationUnitLevel.findByLevelValue", query = "SELECT o FROM OrganizationUnitLevel o WHERE o.levelValue = :levelValue"),
    @NamedQuery(name = "OrganizationUnitLevel.findByOrganizationUnitLevelName", query = "SELECT o FROM OrganizationUnitLevel o WHERE o.organizationUnitLevelName = :organizationUnitLevelName"),
    @NamedQuery(name = "OrganizationUnitLevel.findByOrganizationOID", query = "SELECT o FROM OrganizationUnitLevel o WHERE o.organizationOID = :organizationOID")})
public class OrganizationUnitLevel implements Serializable {

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
    @Column(name = "levelValue")
    private int levelValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "organizationUnitLevelName")
    private String organizationUnitLevelName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "organizationOID")
    private String organizationOID;
    @Lob
    @Column(name = "description")
    private String description;

    public OrganizationUnitLevel() {
    }

    public OrganizationUnitLevel(String oid) {
        this.oid = oid;
    }

    public OrganizationUnitLevel(String oid, int objectVersion, int levelValue, String organizationUnitLevelName, String organizationOID) {
        this.oid = oid;
        this.objectVersion = objectVersion;
        this.levelValue = levelValue;
        this.organizationUnitLevelName = organizationUnitLevelName;
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

    public int getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(int levelValue) {
        this.levelValue = levelValue;
    }

    public String getOrganizationUnitLevelName() {
        return organizationUnitLevelName;
    }

    public void setOrganizationUnitLevelName(String organizationUnitLevelName) {
        this.organizationUnitLevelName = organizationUnitLevelName;
    }

    public String getOrganizationOID() {
        return organizationOID;
    }

    public void setOrganizationOID(String organizationOID) {
        this.organizationOID = organizationOID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof OrganizationUnitLevel)) {
            return false;
        }
        OrganizationUnitLevel other = (OrganizationUnitLevel) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hanbell.oa.entity.OrganizationUnitLevel[ oid=" + oid + " ]";
    }
    
}
