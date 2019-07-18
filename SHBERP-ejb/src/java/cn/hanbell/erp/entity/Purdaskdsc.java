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
@Table(name = "purdaskdsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purdaskdsc.findAll", query = "SELECT p FROM Purdaskdsc p"),
    @NamedQuery(name = "Purdaskdsc.findByFacno", query = "SELECT p FROM Purdaskdsc p WHERE p.purdaskdscPK.facno = :facno"),
    @NamedQuery(name = "Purdaskdsc.findByProno", query = "SELECT p FROM Purdaskdsc p WHERE p.purdaskdscPK.prono = :prono"),
    @NamedQuery(name = "Purdaskdsc.findByPrno", query = "SELECT p FROM Purdaskdsc p WHERE p.purdaskdscPK.prno = :prno"),
    @NamedQuery(name = "Purdaskdsc.findByTrseq", query = "SELECT p FROM Purdaskdsc p WHERE p.purdaskdscPK.trseq = :trseq"),
    @NamedQuery(name = "Purdaskdsc.findByMark1", query = "SELECT p FROM Purdaskdsc p WHERE p.mark1 = :mark1"),
    @NamedQuery(name = "Purdaskdsc.findByMark2", query = "SELECT p FROM Purdaskdsc p WHERE p.mark2 = :mark2"),
    @NamedQuery(name = "Purdaskdsc.findByMark3", query = "SELECT p FROM Purdaskdsc p WHERE p.mark3 = :mark3"),
    @NamedQuery(name = "Purdaskdsc.findByMark4", query = "SELECT p FROM Purdaskdsc p WHERE p.mark4 = :mark4"),
    @NamedQuery(name = "Purdaskdsc.findByMark5", query = "SELECT p FROM Purdaskdsc p WHERE p.mark5 = :mark5"),
    @NamedQuery(name = "Purdaskdsc.findByMark6", query = "SELECT p FROM Purdaskdsc p WHERE p.mark6 = :mark6"),
    @NamedQuery(name = "Purdaskdsc.findByMark7", query = "SELECT p FROM Purdaskdsc p WHERE p.mark7 = :mark7"),
    @NamedQuery(name = "Purdaskdsc.findByMark8", query = "SELECT p FROM Purdaskdsc p WHERE p.mark8 = :mark8"),
    @NamedQuery(name = "Purdaskdsc.findByMark9", query = "SELECT p FROM Purdaskdsc p WHERE p.mark9 = :mark9"),
    @NamedQuery(name = "Purdaskdsc.findByMarka", query = "SELECT p FROM Purdaskdsc p WHERE p.marka = :marka")})
public class Purdaskdsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurdaskdscPK purdaskdscPK;
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
    @Size(max = 60)
    @Column(name = "mark5")
    private String mark5;
    @Size(max = 60)
    @Column(name = "mark6")
    private String mark6;
    @Size(max = 60)
    @Column(name = "mark7")
    private String mark7;
    @Size(max = 60)
    @Column(name = "mark8")
    private String mark8;
    @Size(max = 60)
    @Column(name = "mark9")
    private String mark9;
    @Size(max = 60)
    @Column(name = "marka")
    private String marka;

    public Purdaskdsc() {
    }

    public Purdaskdsc(PurdaskdscPK purdaskdscPK) {
        this.purdaskdscPK = purdaskdscPK;
    }

    public Purdaskdsc(String facno, String prono, String prno, short trseq) {
        this.purdaskdscPK = new PurdaskdscPK(facno, prono, prno, trseq);
    }

    public PurdaskdscPK getPurdaskdscPK() {
        return purdaskdscPK;
    }

    public void setPurdaskdscPK(PurdaskdscPK purdaskdscPK) {
        this.purdaskdscPK = purdaskdscPK;
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

    public String getMark5() {
        return mark5;
    }

    public void setMark5(String mark5) {
        this.mark5 = mark5;
    }

    public String getMark6() {
        return mark6;
    }

    public void setMark6(String mark6) {
        this.mark6 = mark6;
    }

    public String getMark7() {
        return mark7;
    }

    public void setMark7(String mark7) {
        this.mark7 = mark7;
    }

    public String getMark8() {
        return mark8;
    }

    public void setMark8(String mark8) {
        this.mark8 = mark8;
    }

    public String getMark9() {
        return mark9;
    }

    public void setMark9(String mark9) {
        this.mark9 = mark9;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purdaskdscPK != null ? purdaskdscPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purdaskdsc)) {
            return false;
        }
        Purdaskdsc other = (Purdaskdsc) object;
        if ((this.purdaskdscPK == null && other.purdaskdscPK != null) || (this.purdaskdscPK != null && !this.purdaskdscPK.equals(other.purdaskdscPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purdaskdsc[ purdaskdscPK=" + purdaskdscPK + " ]";
    }
    
}
