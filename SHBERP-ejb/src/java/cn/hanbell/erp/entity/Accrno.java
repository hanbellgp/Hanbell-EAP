/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "accrno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accrno.findAll", query = "SELECT a FROM Accrno a"),
    @NamedQuery(name = "Accrno.findByFacno", query = "SELECT a FROM Accrno a WHERE a.accrnoPK.facno = :facno"),
    @NamedQuery(name = "Accrno.findByFinvdate", query = "SELECT a FROM Accrno a WHERE a.accrnoPK.finvdate = :finvdate"),
    @NamedQuery(name = "Accrno.findByPK", query = "SELECT a FROM Accrno a WHERE a.accrnoPK.facno = :facno AND a.accrnoPK.finvdate = :finvdate")})
public class Accrno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccrnoPK accrnoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finvno")
    private short finvno;

    public Accrno() {
    }

    public Accrno(AccrnoPK accrnoPK) {
        this.accrnoPK = accrnoPK;
    }

    public Accrno(AccrnoPK accrnoPK, short finvno) {
        this.accrnoPK = accrnoPK;
        this.finvno = finvno;
    }

    public Accrno(String facno, Date finvdate) {
        this.accrnoPK = new AccrnoPK(facno, finvdate);
    }

    public AccrnoPK getAccrnoPK() {
        return accrnoPK;
    }

    public void setAccrnoPK(AccrnoPK accrnoPK) {
        this.accrnoPK = accrnoPK;
    }

    public short getFinvno() {
        return finvno;
    }

    public void setFinvno(short finvno) {
        this.finvno = finvno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accrnoPK != null ? accrnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accrno)) {
            return false;
        }
        Accrno other = (Accrno) object;
        if ((this.accrnoPK == null && other.accrnoPK != null) || (this.accrnoPK != null && !this.accrnoPK.equals(other.accrnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Accrno[ accrnoPK=" + accrnoPK + " ]";
    }
    
}
