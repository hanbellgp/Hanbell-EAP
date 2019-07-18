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
@Table(name = "Functions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Functions.findAll", query = "SELECT f FROM Functions f"),
    @NamedQuery(name = "Functions.findByOID", query = "SELECT f FROM Functions f WHERE f.oid = :oid"),
    @NamedQuery(name = "Functions.findByObjectVersion", query = "SELECT f FROM Functions f WHERE f.objectVersion = :objectVersion"),
    @NamedQuery(name = "Functions.findByApprovalLevelOID", query = "SELECT f FROM Functions f WHERE f.approvalLevelOID = :approvalLevelOID"),
    @NamedQuery(name = "Functions.findByDefinitionOID", query = "SELECT f FROM Functions f WHERE f.definitionOID = :definitionOID"),
    @NamedQuery(name = "Functions.findByUserOID", query = "SELECT f FROM Functions f WHERE f.occupantOID = :userOID AND f.isMain = true"),
    @NamedQuery(name = "Functions.findByOrganizationUnitOID", query = "SELECT f FROM Functions f WHERE f.organizationUnit.oid = :organizationUnitOID"),
    @NamedQuery(name = "Functions.findBySpecifiedManagerOID", query = "SELECT f FROM Functions f WHERE f.specifiedManagerOID = :specifiedManagerOID"),
    @NamedQuery(name = "Functions.findByIsMain", query = "SELECT f FROM Functions f WHERE f.isMain = :isMain")})
public class Functions implements Serializable {

    @JoinColumn(name = "occupantOID", referencedColumnName = "OID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

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
    @Size(max = 32)
    @Column(name = "approvalLevelOID")
    private String approvalLevelOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "definitionOID")
    private String definitionOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "occupantOID")
    private String occupantOID;

    @JoinColumn(name = "organizationUnitOID", referencedColumnName = "OID")
    @ManyToOne(optional = false)
    private OrganizationUnit organizationUnit;
    @Size(max = 32)
    @Column(name = "specifiedManagerOID")
    private String specifiedManagerOID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isMain")
    private int isMain;

    public Functions() {
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

    public String getApprovalLevelOID() {
        return approvalLevelOID;
    }

    public void setApprovalLevelOID(String approvalLevelOID) {
        this.approvalLevelOID = approvalLevelOID;
    }

    public String getDefinitionOID() {
        return definitionOID;
    }

    public void setDefinitionOID(String definitionOID) {
        this.definitionOID = definitionOID;
    }

    public String getOccupantOID() {
        return occupantOID;
    }

    public void setOccupantOID(String occupantOID) {
        this.occupantOID = occupantOID;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public String getSpecifiedManagerOID() {
        return specifiedManagerOID;
    }

    public void setSpecifiedManagerOID(String specifiedManagerOID) {
        this.specifiedManagerOID = specifiedManagerOID;
    }

    public int getIsMain() {
        return isMain;
    }

    public void setIsMain(int isMain) {
        this.isMain = isMain;
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
        if (!(object instanceof Functions)) {
            return false;
        }
        Functions other = (Functions) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.Functions[ oid=" + oid + " ]";
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

}
