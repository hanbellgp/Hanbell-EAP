/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "invunit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invunit.findAll", query = "SELECT i FROM Invunit i"),
    @NamedQuery(name = "Invunit.findByUnitcode", query = "SELECT i FROM Invunit i WHERE i.unitcode = :unitcode"),
    @NamedQuery(name = "Invunit.findByUnitcodsc", query = "SELECT i FROM Invunit i WHERE i.unitcodsc = :unitcodsc"),
    @NamedQuery(name = "Invunit.findByUnitcodsce", query = "SELECT i FROM Invunit i WHERE i.unitcodsce = :unitcodsce")})
public class Invunit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "unitcode")
    private String unitcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "unitcodsc")
    private String unitcodsc;
    @Size(max = 12)
    @Column(name = "unitcodsce")
    private String unitcodsce;

    public Invunit() {
    }

    public Invunit(String unitcode) {
        this.unitcode = unitcode;
    }

    public Invunit(String unitcode, String unitcodsc) {
        this.unitcode = unitcode;
        this.unitcodsc = unitcodsc;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getUnitcodsc() {
        return unitcodsc;
    }

    public void setUnitcodsc(String unitcodsc) {
        this.unitcodsc = unitcodsc;
    }

    public String getUnitcodsce() {
        return unitcodsce;
    }

    public void setUnitcodsce(String unitcodsce) {
        this.unitcodsce = unitcodsce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitcode != null ? unitcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invunit)) {
            return false;
        }
        Invunit other = (Invunit) object;
        if ((this.unitcode == null && other.unitcode != null) || (this.unitcode != null && !this.unitcode.equals(other.unitcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invunit[ unitcode=" + unitcode + " ]";
    }

}
