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
@Table(name = "OrganizationUnit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizationUnit.findAll", query = "SELECT o FROM OrganizationUnit o"),
    @NamedQuery(name = "OrganizationUnit.findByOID", query = "SELECT o FROM OrganizationUnit o WHERE o.oid = :oid"),
    @NamedQuery(name = "OrganizationUnit.findById", query = "SELECT o FROM OrganizationUnit o WHERE o.id = :id"),
    @NamedQuery(name = "OrganizationUnit.findByOrganizationUnitName", query = "SELECT o FROM OrganizationUnit o WHERE o.organizationUnitName = :organizationUnitName"),
    @NamedQuery(name = "OrganizationUnit.findBySuperUnitOID", query = "SELECT o FROM OrganizationUnit o WHERE o.superUnitOID = :superUnitOID"),
    @NamedQuery(name = "OrganizationUnit.findByObjectVersion", query = "SELECT o FROM OrganizationUnit o WHERE o.objectVersion = :objectVersion"),
    @NamedQuery(name = "OrganizationUnit.findByOrganizationUnitType", query = "SELECT o FROM OrganizationUnit o WHERE o.organizationUnitType = :organizationUnitType"),
    @NamedQuery(name = "OrganizationUnit.findByLevelOID", query = "SELECT o FROM OrganizationUnit o WHERE o.levelOID = :levelOID"),
    @NamedQuery(name = "OrganizationUnit.findByOrganizationOID", query = "SELECT o FROM OrganizationUnit o WHERE o.organizationOID = :organizationOID"),
    @NamedQuery(name = "OrganizationUnit.findByValidType", query = "SELECT o FROM OrganizationUnit o WHERE o.validType = :validType")})
public class OrganizationUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "organizationUnitName")
    private String organizationUnitName;

    @JoinColumn(name = "managerOID", referencedColumnName = "OID")
    @ManyToOne
    private Users manager;

    @Size(max = 32)
    @Column(name = "superUnitOID")
    private String superUnitOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizationUnitType")
    private int organizationUnitType;
    @Size(max = 32)
    @Column(name = "levelOID")
    private String levelOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "organizationOID")
    private String organizationOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validType")
    private int validType;

    public OrganizationUnit() {
    }

    public OrganizationUnit(String oid) {
        this.oid = oid;
    }

    public OrganizationUnit(String oid, String id, String organizationUnitName, int objectVersion, int organizationUnitType, String organizationOID, int validType) {
        this.oid = oid;
        this.id = id;
        this.organizationUnitName = organizationUnitName;
        this.objectVersion = objectVersion;
        this.organizationUnitType = organizationUnitType;
        this.organizationOID = organizationOID;
        this.validType = validType;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationUnitName() {
        return organizationUnitName;
    }

    public void setOrganizationUnitName(String organizationUnitName) {
        this.organizationUnitName = organizationUnitName;
    }

    public Users getManager() {
        return manager;
    }

    public void setManager(Users manager) {
        this.manager = manager;
    }

    public String getSuperUnitOID() {
        return superUnitOID;
    }

    public void setSuperUnitOID(String superUnitOID) {
        this.superUnitOID = superUnitOID;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public int getOrganizationUnitType() {
        return organizationUnitType;
    }

    public void setOrganizationUnitType(int organizationUnitType) {
        this.organizationUnitType = organizationUnitType;
    }

    public String getLevelOID() {
        return levelOID;
    }

    public void setLevelOID(String levelOID) {
        this.levelOID = levelOID;
    }

    public String getOrganizationOID() {
        return organizationOID;
    }

    public void setOrganizationOID(String organizationOID) {
        this.organizationOID = organizationOID;
    }

    public int getValidType() {
        return validType;
    }

    public void setValidType(int validType) {
        this.validType = validType;
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
        if (!(object instanceof OrganizationUnit)) {
            return false;
        }
        OrganizationUnit other = (OrganizationUnit) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hanbell.oa.entity.OrganizationUnit[ oid=" + oid + " ]";
    }

}
