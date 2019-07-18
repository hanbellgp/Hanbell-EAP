/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "OrgUnit_OrgUnitProperty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgUnitOrgUnitProperty.findAll", query = "SELECT o FROM OrgUnitOrgUnitProperty o"),
    @NamedQuery(name = "OrgUnitOrgUnitProperty.findByOrganizationUnitPropertyOID", query = "SELECT o FROM OrgUnitOrgUnitProperty o WHERE o.orgUnitOrgUnitPropertyPK.organizationUnitPropertyOID = :organizationUnitPropertyOID"),
    @NamedQuery(name = "OrgUnitOrgUnitProperty.findByOrganizationUnitOID", query = "SELECT o FROM OrgUnitOrgUnitProperty o WHERE o.orgUnitOrgUnitPropertyPK.organizationUnitOID = :organizationUnitOID")})
public class OrgUnitOrgUnitProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrgUnitOrgUnitPropertyPK orgUnitOrgUnitPropertyPK;

    public OrgUnitOrgUnitProperty() {
    }

    public OrgUnitOrgUnitProperty(OrgUnitOrgUnitPropertyPK orgUnitOrgUnitPropertyPK) {
        this.orgUnitOrgUnitPropertyPK = orgUnitOrgUnitPropertyPK;
    }

    public OrgUnitOrgUnitProperty(String organizationUnitPropertyOID, String organizationUnitOID) {
        this.orgUnitOrgUnitPropertyPK = new OrgUnitOrgUnitPropertyPK(organizationUnitPropertyOID, organizationUnitOID);
    }

    public OrgUnitOrgUnitPropertyPK getOrgUnitOrgUnitPropertyPK() {
        return orgUnitOrgUnitPropertyPK;
    }

    public void setOrgUnitOrgUnitPropertyPK(OrgUnitOrgUnitPropertyPK orgUnitOrgUnitPropertyPK) {
        this.orgUnitOrgUnitPropertyPK = orgUnitOrgUnitPropertyPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgUnitOrgUnitPropertyPK != null ? orgUnitOrgUnitPropertyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgUnitOrgUnitProperty)) {
            return false;
        }
        OrgUnitOrgUnitProperty other = (OrgUnitOrgUnitProperty) object;
        if ((this.orgUnitOrgUnitPropertyPK == null && other.orgUnitOrgUnitPropertyPK != null) || (this.orgUnitOrgUnitPropertyPK != null && !this.orgUnitOrgUnitPropertyPK.equals(other.orgUnitOrgUnitPropertyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hanbell.oa.entity.OrgUnitOrgUnitProperty[ orgUnitOrgUnitPropertyPK=" + orgUnitOrgUnitPropertyPK + " ]";
    }
    
}
