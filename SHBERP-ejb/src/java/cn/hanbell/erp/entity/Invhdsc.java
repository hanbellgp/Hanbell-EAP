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
@Table(name = "invhdsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invhdsc.findAll", query = "SELECT i FROM Invhdsc i"),
    @NamedQuery(name = "Invhdsc.findByFacno", query = "SELECT i FROM Invhdsc i WHERE i.invhdscPK.facno = :facno"),
    @NamedQuery(name = "Invhdsc.findByProno", query = "SELECT i FROM Invhdsc i WHERE i.invhdscPK.prono = :prono"),
    @NamedQuery(name = "Invhdsc.findByTrno", query = "SELECT i FROM Invhdsc i WHERE i.invhdscPK.trno = :trno"),
    @NamedQuery(name = "Invhdsc.findByMark1", query = "SELECT i FROM Invhdsc i WHERE i.mark1 = :mark1"),
    @NamedQuery(name = "Invhdsc.findByMark2", query = "SELECT i FROM Invhdsc i WHERE i.mark2 = :mark2"),
    @NamedQuery(name = "Invhdsc.findByMark3", query = "SELECT i FROM Invhdsc i WHERE i.mark3 = :mark3"),
    @NamedQuery(name = "Invhdsc.findByMark4", query = "SELECT i FROM Invhdsc i WHERE i.mark4 = :mark4"),
    @NamedQuery(name = "Invhdsc.findByFacnoAndPronoAndTrno", query = "SELECT i FROM Invhdsc i WHERE i.invhdscPK.facno = :facno AND i.invhdscPK.prono = :prono AND i.invhdscPK.trno = :trno")
})
public class Invhdsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvhdscPK invhdscPK;
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

    public Invhdsc() {
    }

    public Invhdsc(InvhdscPK invhdscPK) {
        this.invhdscPK = invhdscPK;
    }

    public Invhdsc(String facno, String prono, String trno) {
        this.invhdscPK = new InvhdscPK(facno, prono, trno);
    }

    public InvhdscPK getInvhdscPK() {
        return invhdscPK;
    }

    public void setInvhdscPK(InvhdscPK invhdscPK) {
        this.invhdscPK = invhdscPK;
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
        hash += (invhdscPK != null ? invhdscPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invhdsc)) {
            return false;
        }
        Invhdsc other = (Invhdsc) object;
        if ((this.invhdscPK == null && other.invhdscPK != null) || (this.invhdscPK != null && !this.invhdscPK.equals(other.invhdscPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Invhdsc[ invhdscPK=" + invhdscPK + " ]";
    }
    
}
