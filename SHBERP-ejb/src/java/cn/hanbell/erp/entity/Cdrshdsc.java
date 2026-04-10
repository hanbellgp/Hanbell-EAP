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
 * @author ZFF
 */
@Entity
@Table(name = "cdrshdsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrshdsc.findAll", query = "SELECT c FROM Cdrshdsc c"),
    @NamedQuery(name = "Cdrshdsc.findByFacno", query = "SELECT c FROM Cdrshdsc c WHERE c.cdrshdscPK.facno = :facno"),
    @NamedQuery(name = "Cdrshdsc.findByShpno", query = "SELECT c FROM Cdrshdsc c WHERE c.cdrshdscPK.shpno = :shpno"),
    @NamedQuery(name = "Cdrshdsc.findByMark1", query = "SELECT c FROM Cdrshdsc c WHERE c.mark1 = :mark1"),
    @NamedQuery(name = "Cdrshdsc.findByMark2", query = "SELECT c FROM Cdrshdsc c WHERE c.mark2 = :mark2"),
    @NamedQuery(name = "Cdrshdsc.findByMark3", query = "SELECT c FROM Cdrshdsc c WHERE c.mark3 = :mark3"),
    @NamedQuery(name = "Cdrshdsc.findByMark4", query = "SELECT c FROM Cdrshdsc c WHERE c.mark4 = :mark4"),
    @NamedQuery(name = "Cdrshdsc.findByBrantrno", query = "SELECT c FROM Cdrshdsc c WHERE c.brantrno = :brantrno")})
public class Cdrshdsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrshdscPK cdrshdscPK;
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
    @Size(max = 18)
    @Column(name = "brantrno")
    private String brantrno;

    public Cdrshdsc() {
    }

    public Cdrshdsc(CdrshdscPK cdrshdscPK) {
        this.cdrshdscPK = cdrshdscPK;
    }

    public Cdrshdsc(String facno, String shpno) {
        this.cdrshdscPK = new CdrshdscPK(facno, shpno);
    }

    public CdrshdscPK getCdrshdscPK() {
        return cdrshdscPK;
    }

    public void setCdrshdscPK(CdrshdscPK cdrshdscPK) {
        this.cdrshdscPK = cdrshdscPK;
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

    public String getBrantrno() {
        return brantrno;
    }

    public void setBrantrno(String brantrno) {
        this.brantrno = brantrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrshdscPK != null ? cdrshdscPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrshdsc)) {
            return false;
        }
        Cdrshdsc other = (Cdrshdsc) object;
        if ((this.cdrshdscPK == null && other.cdrshdscPK != null) || (this.cdrshdscPK != null && !this.cdrshdscPK.equals(other.cdrshdscPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Cdrshdsc[ cdrshdscPK=" + cdrshdscPK + " ]";
    }
    
}
