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
@Table(name = "FormInstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormInstance.findAll", query = "SELECT f FROM FormInstance f"),
    @NamedQuery(name = "FormInstance.findByOID", query = "SELECT f FROM FormInstance f WHERE f.oid = :oid"),
    @NamedQuery(name = "FormInstance.findByCreatorOID", query = "SELECT f FROM FormInstance f WHERE f.creatorOID = :creatorOID"),
    @NamedQuery(name = "FormInstance.findByDefinitionOID", query = "SELECT f FROM FormInstance f WHERE f.definitionOID = :definitionOID"),
    @NamedQuery(name = "FormInstance.findByObjectVersion", query = "SELECT f FROM FormInstance f WHERE f.objectVersion = :objectVersion"),
    @NamedQuery(name = "FormInstance.findBySerialNumber", query = "SELECT f FROM FormInstance f WHERE f.serialNumber = :serialNumber")})
public class FormInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "creatorOID")
    private String creatorOID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "definitionOID")
    private String definitionOID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "fieldValues")
    private String fieldValues;
    @Lob
    @Column(name = "signedFieldValues")
    private String signedFieldValues;
    @Basic(optional = false)
    @NotNull
    @Column(name = "objectVersion")
    private int objectVersion;
    @Size(max = 50)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Lob
    @Column(name = "maskFieldValues")
    private String maskFieldValues;

    public FormInstance() {
    }

    public FormInstance(String oid) {
        this.oid = oid;
    }

    public FormInstance(String oid, String creatorOID, String definitionOID, String fieldValues, int objectVersion) {
        this.oid = oid;
        this.creatorOID = creatorOID;
        this.definitionOID = definitionOID;
        this.fieldValues = fieldValues;
        this.objectVersion = objectVersion;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCreatorOID() {
        return creatorOID;
    }

    public void setCreatorOID(String creatorOID) {
        this.creatorOID = creatorOID;
    }

    public String getDefinitionOID() {
        return definitionOID;
    }

    public void setDefinitionOID(String definitionOID) {
        this.definitionOID = definitionOID;
    }

    public String getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(String fieldValues) {
        this.fieldValues = fieldValues;
    }

    public String getSignedFieldValues() {
        return signedFieldValues;
    }

    public void setSignedFieldValues(String signedFieldValues) {
        this.signedFieldValues = signedFieldValues;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMaskFieldValues() {
        return maskFieldValues;
    }

    public void setMaskFieldValues(String maskFieldValues) {
        this.maskFieldValues = maskFieldValues;
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
        if (!(object instanceof FormInstance)) {
            return false;
        }
        FormInstance other = (FormInstance) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.FormInstance[ oid=" + oid + " ]";
    }
    
}
