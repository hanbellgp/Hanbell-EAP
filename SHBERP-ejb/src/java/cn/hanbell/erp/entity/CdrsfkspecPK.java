/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class CdrsfkspecPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "parts")
    private String parts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "sorts")
    private String sorts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "specifit")
    private String specifit;

    public CdrsfkspecPK() {
    }

    public CdrsfkspecPK(String facno, String parts, String sorts, String specifit) {
        this.facno = facno;
        this.parts = parts;
        this.sorts = sorts;
        this.specifit = specifit;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public String getSpecifit() {
        return specifit;
    }

    public void setSpecifit(String specifit) {
        this.specifit = specifit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (parts != null ? parts.hashCode() : 0);
        hash += (sorts != null ? sorts.hashCode() : 0);
        hash += (specifit != null ? specifit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrsfkspecPK)) {
            return false;
        }
        CdrsfkspecPK other = (CdrsfkspecPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.parts == null && other.parts != null) || (this.parts != null && !this.parts.equals(other.parts))) {
            return false;
        }
        if ((this.sorts == null && other.sorts != null) || (this.sorts != null && !this.sorts.equals(other.sorts))) {
            return false;
        }
        if ((this.specifit == null && other.specifit != null) || (this.specifit != null && !this.specifit.equals(other.specifit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrsfkspecPK[ facno=" + facno + ", parts=" + parts + ", sorts=" + sorts + ", specifit=" + specifit + " ]";
    }
    
}
