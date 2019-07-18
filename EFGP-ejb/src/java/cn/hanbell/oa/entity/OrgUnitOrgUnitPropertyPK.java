/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C0160
 */
@Embeddable
public class OrgUnitOrgUnitPropertyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OrganizationUnitPropertyOID")
    private String organizationUnitPropertyOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OrganizationUnitOID")
    private String organizationUnitOID;

    public OrgUnitOrgUnitPropertyPK() {
    }

    public OrgUnitOrgUnitPropertyPK(String organizationUnitPropertyOID, String organizationUnitOID) {
        this.organizationUnitPropertyOID = organizationUnitPropertyOID;
        this.organizationUnitOID = organizationUnitOID;
    }

    public String getOrganizationUnitPropertyOID() {
        return organizationUnitPropertyOID;
    }

    public void setOrganizationUnitPropertyOID(String organizationUnitPropertyOID) {
        this.organizationUnitPropertyOID = organizationUnitPropertyOID;
    }

    public String getOrganizationUnitOID() {
        return organizationUnitOID;
    }

    public void setOrganizationUnitOID(String organizationUnitOID) {
        this.organizationUnitOID = organizationUnitOID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizationUnitPropertyOID != null ? organizationUnitPropertyOID.hashCode() : 0);
        hash += (organizationUnitOID != null ? organizationUnitOID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgUnitOrgUnitPropertyPK)) {
            return false;
        }
        OrgUnitOrgUnitPropertyPK other = (OrgUnitOrgUnitPropertyPK) object;
        if ((this.organizationUnitPropertyOID == null && other.organizationUnitPropertyOID != null) || (this.organizationUnitPropertyOID != null && !this.organizationUnitPropertyOID.equals(other.organizationUnitPropertyOID))) {
            return false;
        }
        if ((this.organizationUnitOID == null && other.organizationUnitOID != null) || (this.organizationUnitOID != null && !this.organizationUnitOID.equals(other.organizationUnitOID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hanbell.oa.entity.OrgUnitOrgUnitPropertyPK[ organizationUnitPropertyOID=" + organizationUnitPropertyOID + ", organizationUnitOID=" + organizationUnitOID + " ]";
    }
    
}
