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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class AccrnoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finvdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finvdate;

    public AccrnoPK() {
    }

    public AccrnoPK(String facno, Date finvdate) {
        this.facno = facno;
        this.finvdate = finvdate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Date getFinvdate() {
        return finvdate;
    }

    public void setFinvdate(Date finvdate) {
        this.finvdate = finvdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (finvdate != null ? finvdate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccrnoPK)) {
            return false;
        }
        AccrnoPK other = (AccrnoPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.finvdate == null && other.finvdate != null) || (this.finvdate != null && !this.finvdate.equals(other.finvdate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.AccrnoPK[ facno=" + facno + ", finvdate=" + finvdate + " ]";
    }
    
}
