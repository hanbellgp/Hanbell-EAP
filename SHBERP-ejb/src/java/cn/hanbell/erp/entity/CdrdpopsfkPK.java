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
public class CdrdpopsfkPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "sfktrno")
    private String sfktrno;
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

    public CdrdpopsfkPK() {
    }

    public CdrdpopsfkPK(String facno, String sfktrno, String parts, String sorts) {
        this.facno = facno;
        this.sfktrno = sfktrno;
        this.parts = parts;
        this.sorts = sorts;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSfktrno() {
        return sfktrno;
    }

    public void setSfktrno(String sfktrno) {
        this.sfktrno = sfktrno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (sfktrno != null ? sfktrno.hashCode() : 0);
        hash += (parts != null ? parts.hashCode() : 0);
        hash += (sorts != null ? sorts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrdpopsfkPK)) {
            return false;
        }
        CdrdpopsfkPK other = (CdrdpopsfkPK) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.sfktrno == null && other.sfktrno != null) || (this.sfktrno != null && !this.sfktrno.equals(other.sfktrno))) {
            return false;
        }
        if ((this.parts == null && other.parts != null) || (this.parts != null && !this.parts.equals(other.parts))) {
            return false;
        }
        if ((this.sorts == null && other.sorts != null) || (this.sorts != null && !this.sorts.equals(other.sorts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrdpopsfkPK[ facno=" + facno + ", sfktrno=" + sfktrno + ", parts=" + parts + ", sorts=" + sorts + " ]";
    }

}
