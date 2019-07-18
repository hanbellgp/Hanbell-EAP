/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "cdrqhdsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrqhdsc.findAll", query = "SELECT c FROM Cdrqhdsc c")
    , @NamedQuery(name = "Cdrqhdsc.findByFacno", query = "SELECT c FROM Cdrqhdsc c WHERE c.cdrqhdscPK.facno = :facno")
    , @NamedQuery(name = "Cdrqhdsc.findByQuono", query = "SELECT c FROM Cdrqhdsc c WHERE c.cdrqhdscPK.quono = :quono")
    , @NamedQuery(name = "Cdrqhdsc.findByMark1", query = "SELECT c FROM Cdrqhdsc c WHERE c.mark1 = :mark1")
    , @NamedQuery(name = "Cdrqhdsc.findByMark2", query = "SELECT c FROM Cdrqhdsc c WHERE c.mark2 = :mark2")
    , @NamedQuery(name = "Cdrqhdsc.findByMark3", query = "SELECT c FROM Cdrqhdsc c WHERE c.mark3 = :mark3")
    , @NamedQuery(name = "Cdrqhdsc.findByMark4", query = "SELECT c FROM Cdrqhdsc c WHERE c.mark4 = :mark4")})
public class Cdrqhdsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrqhdscPK cdrqhdscPK;
    @Size(max = 60)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 60)
    @Column(name = "mark2")
    private String mark2;
    @Size(max = 60)
    @Column(name = "mark3")
    private String mark3;
    @Size(max = 60)
    @Column(name = "mark4")
    private String mark4;

    public Cdrqhdsc() {
    }

    public Cdrqhdsc(CdrqhdscPK cdrqhdscPK) {
        this.cdrqhdscPK = cdrqhdscPK;
    }

    public Cdrqhdsc(String facno, String quono) {
        this.cdrqhdscPK = new CdrqhdscPK(facno, quono);
    }

    public CdrqhdscPK getCdrqhdscPK() {
        return cdrqhdscPK;
    }

    public void setCdrqhdscPK(CdrqhdscPK cdrqhdscPK) {
        this.cdrqhdscPK = cdrqhdscPK;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public String getMark3() {
        return mark3;
    }

    public void setMark3(String mark3) {
        this.mark3 = mark3;
    }

    public String getMark4() {
        return mark4;
    }

    public void setMark4(String mark4) {
        this.mark4 = mark4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrqhdscPK != null ? cdrqhdscPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrqhdsc)) {
            return false;
        }
        Cdrqhdsc other = (Cdrqhdsc) object;
        if ((this.cdrqhdscPK == null && other.cdrqhdscPK != null) || (this.cdrqhdscPK != null && !this.cdrqhdscPK.equals(other.cdrqhdscPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Cdrqhdsc[ cdrqhdscPK=" + cdrqhdscPK + " ]";
    }
    
}
