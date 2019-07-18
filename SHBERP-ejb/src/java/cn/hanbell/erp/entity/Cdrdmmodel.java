/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "cdrdmmodel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrdmmodel.findAll", query = "SELECT c FROM Cdrdmmodel c"),
    @NamedQuery(name = "Cdrdmmodel.findByFacno", query = "SELECT c FROM Cdrdmmodel c WHERE c.cdrdmmodelPK.facno = :facno"),
    @NamedQuery(name = "Cdrdmmodel.findByItnbr", query = "SELECT c FROM Cdrdmmodel c WHERE c.cdrdmmodelPK.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrdmmodel.findByCmccode", query = "SELECT c FROM Cdrdmmodel c WHERE c.cdrdmmodelPK.cmccode = :cmccode"),
    @NamedQuery(name = "Cdrdmmodel.findByCmcmodel", query = "SELECT c FROM Cdrdmmodel c WHERE c.cmcmodel = :cmcmodel"),
    @NamedQuery(name = "Cdrdmmodel.findByCmcitdsc", query = "SELECT c FROM Cdrdmmodel c WHERE c.cmcitdsc = :cmcitdsc"),
    @NamedQuery(name = "Cdrdmmodel.findByCmcspdsc", query = "SELECT c FROM Cdrdmmodel c WHERE c.cmcspdsc = :cmcspdsc"),
    @NamedQuery(name = "Cdrdmmodel.findByKind", query = "SELECT c FROM Cdrdmmodel c WHERE c.kind = :kind")})
public class Cdrdmmodel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrdmmodelPK cdrdmmodelPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cmcmodel")
    private String cmcmodel;
    @Size(max = 30)
    @Column(name = "cmcitdsc")
    private String cmcitdsc;
    @Size(max = 30)
    @Column(name = "cmcspdsc")
    private String cmcspdsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kind")
    private String kind;

    public Cdrdmmodel() {
    }

    public Cdrdmmodel(CdrdmmodelPK cdrdmmodelPK) {
        this.cdrdmmodelPK = cdrdmmodelPK;
    }

    public Cdrdmmodel(CdrdmmodelPK cdrdmmodelPK, String cmcmodel, String kind) {
        this.cdrdmmodelPK = cdrdmmodelPK;
        this.cmcmodel = cmcmodel;
        this.kind = kind;
    }

    public Cdrdmmodel(String facno, String itnbr, String cmccode) {
        this.cdrdmmodelPK = new CdrdmmodelPK(facno, itnbr, cmccode);
    }

    public CdrdmmodelPK getCdrdmmodelPK() {
        return cdrdmmodelPK;
    }

    public void setCdrdmmodelPK(CdrdmmodelPK cdrdmmodelPK) {
        this.cdrdmmodelPK = cdrdmmodelPK;
    }

    public String getCmcmodel() {
        return cmcmodel;
    }

    public void setCmcmodel(String cmcmodel) {
        this.cmcmodel = cmcmodel;
    }

    public String getCmcitdsc() {
        return cmcitdsc;
    }

    public void setCmcitdsc(String cmcitdsc) {
        this.cmcitdsc = cmcitdsc;
    }

    public String getCmcspdsc() {
        return cmcspdsc;
    }

    public void setCmcspdsc(String cmcspdsc) {
        this.cmcspdsc = cmcspdsc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrdmmodelPK != null ? cdrdmmodelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrdmmodel)) {
            return false;
        }
        Cdrdmmodel other = (Cdrdmmodel) object;
        if ((this.cdrdmmodelPK == null && other.cdrdmmodelPK != null) || (this.cdrdmmodelPK != null && !this.cdrdmmodelPK.equals(other.cdrdmmodelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.shb.erp.Cdrdmmodel[ cdrdmmodelPK=" + cdrdmmodelPK + " ]";
    }
    
}
