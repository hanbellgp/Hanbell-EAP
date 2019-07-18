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
 * @author C0160
 */
@Entity
@Table(name = "apmrno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmrno.findAll", query = "SELECT a FROM Apmrno a"),
    @NamedQuery(name = "Apmrno.findByPK", query = "SELECT a FROM Apmrno a WHERE a.apmrnoPK.facno = :facno AND a.apmrnoPK.scode = :scode AND a.apmrnoPK.maxnumber Like :maxnumber")})
public class Apmrno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmrnoPK apmrnoPK;

    public Apmrno() {
    }

    public Apmrno(ApmrnoPK apmrnoPK) {
        this.apmrnoPK = apmrnoPK;
    }

    public Apmrno(String facno, String scode, String maxnumber) {
        this.apmrnoPK = new ApmrnoPK(facno, scode, maxnumber);
    }

    public ApmrnoPK getApmrnoPK() {
        return apmrnoPK;
    }

    public void setApmrnoPK(ApmrnoPK apmrnoPK) {
        this.apmrnoPK = apmrnoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmrnoPK != null ? apmrnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmrno)) {
            return false;
        }
        Apmrno other = (Apmrno) object;
        if ((this.apmrnoPK == null && other.apmrnoPK != null) || (this.apmrnoPK != null && !this.apmrnoPK.equals(other.apmrnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmrno[ apmrnoPK=" + apmrnoPK + " ]";
    }

}
