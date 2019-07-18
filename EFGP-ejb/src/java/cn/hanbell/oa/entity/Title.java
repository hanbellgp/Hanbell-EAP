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
@Table(name = "Title")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t"),
    @NamedQuery(name = "Title.findByOID", query = "SELECT t FROM Title t WHERE t.oid = :oid"),
    @NamedQuery(name = "Title.findByOrganizationUnitOID", query = "SELECT t FROM Title t WHERE t.organizationUnitOID = :organizationUnitOID"),
    @NamedQuery(name = "Title.findByOUOIDAndUserOID", query = "SELECT t FROM Title t WHERE t.organizationUnitOID = :ouoid AND t.occupantOID = :useroid")})
public class Title implements Serializable {

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

    @JoinColumn(name = "definitionOID", referencedColumnName = "OID")
    @ManyToOne(optional = false)
    private TitleDefinition titleDefinition;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "organizationUnitOID")
    private String organizationUnitOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "occupantOID")
    private String occupantOID;

    public Title() {
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

    public TitleDefinition getTitleDefinition() {
        return titleDefinition;
    }

    public void setTitleDefinition(TitleDefinition titleDefinition) {
        this.titleDefinition = titleDefinition;
    }

    public String getOrganizationUnitOID() {
        return organizationUnitOID;
    }

    public void setOrganizationUnitOID(String organizationUnitOID) {
        this.organizationUnitOID = organizationUnitOID;
    }

    public String getOccupantOID() {
        return occupantOID;
    }

    public void setOccupantOID(String occupantOID) {
        this.occupantOID = occupantOID;
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
        if (!(object instanceof Title)) {
            return false;
        }
        Title other = (Title) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.Title[ oid=" + oid + " ]";
    }

}
