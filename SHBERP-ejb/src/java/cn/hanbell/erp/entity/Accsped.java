/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "accsped")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accsped.findAll", query = "SELECT a FROM Accsped a"),
    @NamedQuery(name = "Accsped.findByConfig", query = "SELECT a FROM Accsped a WHERE a.accspedPK.config = :config"),
    @NamedQuery(name = "Accsped.findByAccno", query = "SELECT a FROM Accsped a WHERE a.accspedPK.accno = :accno")})
public class Accsped implements Serializable {

    @EmbeddedId
    protected AccspedPK accspedPK;

    public Accsped() {
    }

    public Accsped(AccspedPK accspedPK) {
        this.accspedPK = accspedPK;
    }

    public Accsped(short config, String accno) {
        this.accspedPK = new AccspedPK(config, accno);
    }

    public AccspedPK getAccspedPK() {
        return accspedPK;
    }

    public void setAccspedPK(AccspedPK accspedPK) {
        this.accspedPK = accspedPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accspedPK != null ? accspedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accsped)) {
            return false;
        }
        Accsped other = (Accsped) object;
        if ((this.accspedPK == null && other.accspedPK != null) || (this.accspedPK != null && !this.accspedPK.equals(other.accspedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Accsped[ accspedPK=" + accspedPK + " ]";
    }

}
