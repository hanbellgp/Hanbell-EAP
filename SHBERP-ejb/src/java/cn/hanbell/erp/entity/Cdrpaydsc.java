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
 * @author Administrator
 */
@Entity
@Table(name = "cdrpaydsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrpaydsc.findAll", query = "SELECT c FROM Cdrpaydsc c")
    , @NamedQuery(name = "Cdrpaydsc.findByDifcode", query = "SELECT c FROM Cdrpaydsc c WHERE c.cdrpaydscPK.difcode = :difcode")
    , @NamedQuery(name = "Cdrpaydsc.findByAllcode", query = "SELECT c FROM Cdrpaydsc c WHERE c.cdrpaydscPK.allcode = :allcode")
    , @NamedQuery(name = "Cdrpaydsc.findByPK", query = "SELECT c FROM Cdrpaydsc c WHERE c.cdrpaydscPK.difcode = :difcode AND c.cdrpaydscPK.allcode = :allcode")    
    , @NamedQuery(name = "Cdrpaydsc.findByAllcodedsc", query = "SELECT c FROM Cdrpaydsc c WHERE c.allcodedsc = :allcodedsc")})
public class Cdrpaydsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrpaydscPK cdrpaydscPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "allcodedsc")
    private String allcodedsc;

    public Cdrpaydsc() {
    }

    public Cdrpaydsc(CdrpaydscPK cdrpaydscPK) {
        this.cdrpaydscPK = cdrpaydscPK;
    }

    public Cdrpaydsc(CdrpaydscPK cdrpaydscPK, String allcodedsc) {
        this.cdrpaydscPK = cdrpaydscPK;
        this.allcodedsc = allcodedsc;
    }

    public Cdrpaydsc(Character difcode, String allcode) {
        this.cdrpaydscPK = new CdrpaydscPK(difcode, allcode);
    }

    public CdrpaydscPK getCdrpaydscPK() {
        return cdrpaydscPK;
    }

    public void setCdrpaydscPK(CdrpaydscPK cdrpaydscPK) {
        this.cdrpaydscPK = cdrpaydscPK;
    }

    public String getAllcodedsc() {
        return allcodedsc;
    }

    public void setAllcodedsc(String allcodedsc) {
        this.allcodedsc = allcodedsc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrpaydscPK != null ? cdrpaydscPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrpaydsc)) {
            return false;
        }
        Cdrpaydsc other = (Cdrpaydsc) object;
        if ((this.cdrpaydscPK == null && other.cdrpaydscPK != null) || (this.cdrpaydscPK != null && !this.cdrpaydscPK.equals(other.cdrpaydscPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrpaydsc[ cdrpaydscPK=" + cdrpaydscPK + " ]";
    }
    
}
