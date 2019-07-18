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
@Table(name = "TitleDefinition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TitleDefinition.findAll", query = "SELECT t FROM TitleDefinition t"),
    @NamedQuery(name = "TitleDefinition.findByOid", query = "SELECT t FROM TitleDefinition t WHERE t.oid = :oid"),
    @NamedQuery(name = "TitleDefinition.findByObjectVersion", query = "SELECT t FROM TitleDefinition t WHERE t.objectVersion = :objectVersion"),
    @NamedQuery(name = "TitleDefinition.findByTitleDefinitionName", query = "SELECT t FROM TitleDefinition t WHERE t.titleDefinitionName = :titleDefinitionName"),
    @NamedQuery(name = "TitleDefinition.findByShortName", query = "SELECT t FROM TitleDefinition t WHERE t.shortName = :shortName"),
    @NamedQuery(name = "TitleDefinition.findByOrganizationOID", query = "SELECT t FROM TitleDefinition t WHERE t.organizationOID = :organizationOID")})
public class TitleDefinition implements Serializable {

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
    @Column(name = "titleDefinitionName")
    private String titleDefinitionName;
    @Size(max = 50)
    @Column(name = "shortName")
    private String shortName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "organizationOID")
    private String organizationOID;
    @Lob
    @Column(name = "description")
    private String description;

    public TitleDefinition() {
    }

    public TitleDefinition(String oid) {
        this.oid = oid;
    }

    public TitleDefinition(String oid, int objectVersion, String titleDefinitionName, String organizationOID) {
        this.oid = oid;
        this.objectVersion = objectVersion;
        this.titleDefinitionName = titleDefinitionName;
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

    public String getTitleDefinitionName() {
        return titleDefinitionName;
    }

    public void setTitleDefinitionName(String titleDefinitionName) {
        this.titleDefinitionName = titleDefinitionName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
        if (!(object instanceof TitleDefinition)) {
            return false;
        }
        TitleDefinition other = (TitleDefinition) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.TitleDefinition[ oid=" + oid + " ]";
    }
    
}
