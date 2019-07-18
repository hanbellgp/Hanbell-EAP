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
@Table(name = "FormType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormType.findAll", query = "SELECT f FROM FormType f"),
    @NamedQuery(name = "FormType.findByOid", query = "SELECT f FROM FormType f WHERE f.oid = :oid"),
    @NamedQuery(name = "FormType.findByObjectVersion", query = "SELECT f FROM FormType f WHERE f.objectVersion = :objectVersion"),
    @NamedQuery(name = "FormType.findByFormDefinitionId", query = "SELECT f FROM FormType f WHERE f.formDefinitionId = :formDefinitionId")})
public class FormType implements Serializable {

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
    @Size(max = 100)
    @Column(name = "formDefinitionId")
    private String formDefinitionId;

    public FormType() {
    }

    public FormType(String oid) {
        this.oid = oid;
    }

    public FormType(String oid, int objectVersion) {
        this.oid = oid;
        this.objectVersion = objectVersion;
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

    public String getFormDefinitionId() {
        return formDefinitionId;
    }

    public void setFormDefinitionId(String formDefinitionId) {
        this.formDefinitionId = formDefinitionId;
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
        if (!(object instanceof FormType)) {
            return false;
        }
        FormType other = (FormType) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.FormType[ oid=" + oid + " ]";
    }
    
}
